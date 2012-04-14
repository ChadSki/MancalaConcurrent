package BelcherSim;

class DesperateRitual extends Card {
    int manaAdded = 3;
    boolean isSorcery = true;

    public DesperateRitual() {
        name = "Desperate Ritual";
        ccRed = 1;
        ccColorless = 1;
        isRed = true;
    }

    public boolean tryCast(GameData g) {
        if (super.tryCast(g)) {
            g.setRed(g.getRed() + 3);
            Game.g.graveyard.add(this);
            return true;
        } else {
            return false;
        }
    }
}
