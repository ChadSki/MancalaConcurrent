package BelcherSim;

class ChancellorOfTheTangle extends Card {
    public ChancellorOfTheTangle() {
        name = "Chancellor Of The Tangle";
        ccGreen = 4;
        ccColorless = 100;
        isGreen = true;
    }

    public boolean tryCast(GameData g) {
        if (super.tryCast(g)) {
            return true;
        } else {
            return false;
        }
    }
}
