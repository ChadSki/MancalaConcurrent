package BelcherSim;

class ElvishSpiritGuide extends Card {
    int manaAdded = 1;
    boolean isCreature = true;

    public ElvishSpiritGuide() {
        name = "Elvish Spirit Guide";
        isConstrainedIMS = true;
        isGreen = true;
    }

    public boolean tryCast(GameData g) {
        if (super.tryCast(g)) {
            g.setGreen(g.getGreen() + 1);
            Game.staticReferenceToGame.exile.add(this);
            return true;
        } else {
            return false;
        }
    }
}
