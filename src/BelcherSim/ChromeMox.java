package BelcherSim;

class ChromeMox extends Card {
    int manaAdded = 1;

    public ChromeMox() {
        name = "Chrome Mox";
        isArtifact = true;
        isImprinted = false;
    }

    public void imprint(int i) {
        if (Game.g.visualize) {
            System.out.println("Chrome Mox Imprinting " + Game.g.hand.get(i).getName());
        }
        isImprinted = true;
        Card c = Game.g.hand.get(i);
        Game.g.exile.add(c);

        isImprinted = true;
    }

    public boolean tryCast(GameData g, String color) {
        if (super.tryCast(g)) {
            if (isImprinted) {
                if (color == "red") {
                    g.setRed(g.getRed() + 1);
                }
                if (color == "green") {
                    g.setGreen(g.getGreen() + 1);
                }
            }
            Game.g.battlefield.add(this);
            return true;
        } else {
            return false;
        }

    }
}
