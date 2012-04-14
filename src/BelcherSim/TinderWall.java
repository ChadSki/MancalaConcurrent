package BelcherSim;

class TinderWall extends Card {
    int manaAdded = 2;
    boolean isCreature = true;

    public TinderWall() {
        name = "Tinder Wall";
        ccGreen = 1;
        isGreen = true;
    }

    public boolean tryCast(GameData g) {
        if (super.tryCast(g)) {
            g.setRed(g.getRed() + 2);
            Game.g.graveyard.add(this);
            return true;
        } else {
            return false;
        }
    }
}
