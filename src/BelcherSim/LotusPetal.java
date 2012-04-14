package BelcherSim;

class LotusPetal extends Card {
    int manaAdded = 1;
    boolean isArtifact = true;

    public LotusPetal() {
        name = "Lotus Petal";
        isUnconstrainedIMS = true;
        isArtifact = true;
        isLand = false;
    }

    public boolean tryCast(GameData g, String color) {
        if (super.tryCast(g)) {
            if (color == "red") {
                g.setRed(g.getRed() + 1);
            }
            if (color == "green") {
                g.setGreen(g.getGreen() + 1);
            }

            Game.g.graveyard.add(this);
            return true;
        } else {
            return false;
        }
    }
}
