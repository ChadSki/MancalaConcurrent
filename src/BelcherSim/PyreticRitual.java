package BelcherSim;

class PyreticRitual extends Card {
    int manaAdded = 3;
    boolean isSorcery = true;

    public PyreticRitual() {
        name = "Pyretic Ritual";
        ccRed = 1;
        ccColorless = 1;
        isRed = true;
    }

    public boolean tryCast(GameData g) {
        if (super.tryCast(g)) {
            g.setRed(g.getRed() + 3);
            Game.staticReferenceToGame.graveyard.add(this);
            return true;
        } else {
            return false;
        }
    }
}
