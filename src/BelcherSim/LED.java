package BelcherSim;

class LED extends Card {

    public LED() {
        name = "Lion's Eye Diamond";
        isArtifact = true;

    }

    public boolean tryCast(GameData g) {
        if (super.tryCast(g)) {
            Game.g.battlefield.add(this);
            return true;
        } else {
            return false;
        }
    }

    public void ability1(GameData g) {
        g.setRed(g.getRed() + 3);
        Game.g.graveyard.add(this);
    }
}
