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
            if (!Game.staticReferenceToGame.battlefield.isEmpty()) {
                for (int j = 0; j < Game.staticReferenceToGame.battlefield.size(); j++) {
                    if (Game.staticReferenceToGame.battlefield.get(j).isLand) {
                        landCheck = false;
                        break;
                    }
                }
            }
            // If landcheck is true, make the mana. Otherwise, return.
            if (landCheck) {
                for (int i = 0; i < Game.staticReferenceToGame.library.size(); i++) {
                    if (Game.staticReferenceToGame.library.get(i).getName() == "Taiga") {
                        Game.staticReferenceToGame.battlefield.add(Game.staticReferenceToGame.library.get(i));
                        Game.staticReferenceToGame.library.remove(i);

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

            Game.staticReferenceToGame.graveyard.add(this);
            return true;
        } else {
            return false;
        }
    }
}
