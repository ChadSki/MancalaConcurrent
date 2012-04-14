package BelcherSim;

class LandGrant extends Card {
    int manaAdded = 1;
    boolean isSorcery = true;

    public LandGrant() {
        name = "Land Grant";
        isUnconstrainedIMS = true;
        isGreen = true;
    }

    public boolean tryCast(GameData g, String color) {
        boolean landCheck = true;
        if (super.tryCast(g)) {
            // Check for any other lands played this turn
            if (!Game.g.battlefield.isEmpty()) {
                for (int j = 0; j < Game.g.battlefield.size(); j++) {
                    if (Game.g.battlefield.get(j).isLand) {
                        landCheck = false;
                        break;
                    }
                }
            }
            // If landcheck is true, make the mana. Otherwise, return.
            if (landCheck) {
                for (int i = 0; i < Game.g.library.size(); i++) {
                    if (Game.g.library.get(i).getName() == "Taiga") {
                        Game.g.battlefield.add(Game.g.library.get(i));
                        Game.g.library.remove(i);

                        if (color == "red") {
                            g.setRed(g.getRed() + 1);
                        }
                        if (color == "green") {
                            g.setGreen(g.getGreen() + 1);
                        }

                        break;
                    }
                }
            }

            Game.g.graveyard.add(this);
            return true;
        } else {
            return false;
        }
    }
}
