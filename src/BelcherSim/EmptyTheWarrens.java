package BelcherSim;

class EmptyTheWarrens extends Card {
    public EmptyTheWarrens() {
        name = "Empty the Warrens";
        ccRed = 1;
        ccColorless = 3;
        isWinCon = true;
        isRed = true;
    }

    public boolean tryCast(GameData g) {
        if (super.tryCast(g)) {
            Game.g.graveyard.add(this);
            return true;
        } else {
            return false;
        }
    }
}
