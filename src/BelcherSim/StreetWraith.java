package BelcherSim;

class StreetWraith extends Card {
    boolean isSorcery = true;

    public StreetWraith() {
        name = "Street Wraith";
        isFreeCantrip = true;
    }

    public boolean tryCast(GameData g) {
        if (super.tryCast(g)) {
            Game.staticReferenceToGame.draw(1);
            Game.staticReferenceToGame.graveyard.add(this);
            g.setStormCount(g.getStormCount() - 1);
            return true;
        } else {
            return false;
        }
    }
}
