package BelcherSim;

class SimianSpiritGuide extends Card {
    boolean isCreature = true;

    public SimianSpiritGuide() {
        name = "Simian Spirit Guide";
        isConstrainedIMS = true;
        isRed = true;
    }

    public boolean tryCast(GameData g) {
        if (super.tryCast(g)) {
            g.setRed(g.getRed() + 1);
            Game.g.exile.add(this);
            return true;
        } else {
            return false;
        }
    }
}
