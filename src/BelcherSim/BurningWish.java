package BelcherSim;

class BurningWish extends Card {
    public BurningWish() {
        name = "Burning Wish";
        ccRed = 1;
        ccColorless = 1;
        isWinCon = true;
        isRed = true;
    }

    public boolean tryCast(GameData g) {
        if (super.tryCast(g)) {
            Game.staticReferenceToGame.graveyard.add(this);
            return true;
        } else {
            return false;
        }
    }
}
