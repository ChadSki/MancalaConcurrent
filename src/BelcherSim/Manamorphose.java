package BelcherSim;

class Manamorphose extends Card {
    int manaAdded = 2;
    boolean isSorcery = true;

    public Manamorphose() {
        name = "Manamorphose";
        isCantrip = true;
        isMulticolored = true;
        isRed = true;
        isGreen = true;

        // Cost is effectively 2 colorless
        ccColorless = 2;
    }

    public boolean tryCast(GameData g, String color) {
        if (super.tryCast(g)) {
            // Usually want to make RG, but in the case that you have a tinder wall in hand and no green, we should make GG.
            if (color == "red") {
                g.setRed(g.getRed() + 1);
                g.setGreen(g.getGreen() + 1);
                if (Game.g.visualize) {
                    System.out.println("Add RG");
                }
            } else if (color == "green") {
                g.setGreen(g.getGreen() + 2);
                if (Game.g.visualize) {
                    System.out.println("Add GG");
                }
            }
            Game.g.draw(1);
            if (Game.g.visualize) {
                System.out.println("Draw: " + Game.g.hand.get(Game.g.hand.size() - 1).getName());
            }
            Game.g.graveyard.add(this);
            return true;
        } else {
            return false;
        }
    }
}
