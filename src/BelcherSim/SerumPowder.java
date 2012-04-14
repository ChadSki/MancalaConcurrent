package BelcherSim;

class SerumPowder extends Card {
    public SerumPowder() {
        name = "Serum Powder";
        ccColorless = 100;
        isArtifact = true;
    }

    public boolean tryCast(GameData g) {
        if (super.tryCast(g)) {
            return true;
        } else {
            return false;
        }
    }
}
