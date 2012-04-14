package BelcherSim;

class GitaxianProbe extends Card {
    boolean isSorcery = true;

    public GitaxianProbe() {
        name = "Gitaxian Probe";
        isFreeCantrip = true;
    }

    public boolean tryCast(GameData g) {
        if (super.tryCast(g)) {
            Game.g.draw(1);
            Game.g.graveyard.add(this);
            return true;
        } else {
            return false;
        }
    }
}
