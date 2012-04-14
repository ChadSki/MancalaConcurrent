package BelcherSim;

class SeethingSong extends Card {
    int manaAdded = 5;
    boolean isSorcery = true;

    public SeethingSong() {
        name = "Seething Song";
        ccRed = 1;
        ccColorless = 2;
        isRed = true;
    }

    public boolean tryCast(GameData g) {
        if (super.tryCast(g)) {
            g.setRed(g.getRed() + 5);
            Game.g.graveyard.add(this);
            return true;
        } else {
            return false;
        }
    }
}
