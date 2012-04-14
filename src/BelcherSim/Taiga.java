package BelcherSim;

class Taiga extends Card {
    int manaAdded = 1;

    public Taiga() {
        name = "Taiga";
        isLand = true;
        isUnconstrainedIMS = true;
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
                if (color == "red") {
                    g.setRed(g.getRed() + 1);
                }
                if (color == "green") {
                    g.setGreen(g.getGreen() + 1);
                }

                Game.g.battlefield.add(this);
            } else {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }
}
