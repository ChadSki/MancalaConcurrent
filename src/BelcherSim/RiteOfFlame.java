package BelcherSim;

class RiteOfFlame extends Card {
    int manaAdded = 2;
    boolean isSorcery = true;

    public RiteOfFlame() {
        name = "Rite of Flame";
        ccRed = 1;
        isRed = true;
    }

    public boolean tryCast(GameData g) {
        if (super.tryCast(g)) {
            g.setRed(g.getRed() + 2);

            for (int i = 0; i < Game.g.graveyard.size(); i++) {
                if (Game.g.graveyard.get(i).getName() == "Rite of Flame") {
                    g.setRed(g.getRed() + 1);
                }
            }

            Game.g.graveyard.add(this);
            return true;
        } else {
            return false;
        }
    }
}
