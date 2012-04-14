package BelcherSim;

class ChromeMox extends Card {
    int manaAdded = 1;

    public ChromeMox() {
        name = "Chrome Mox";
        isArtifact = true;
        isImprinted = false;
    }

    public void imprint(int i) {
        if (Game.staticReferenceToGame.visualize) {
            System.out.println("Chrome Mox Imprinting " + Game.staticReferenceToGame.hand.get(i).getName());
        }
        isImprinted = true;
        Card c = Game.staticReferenceToGame.hand.get(i);
        Game.staticReferenceToGame.exile.add(c);

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
            Game.staticReferenceToGame.battlefield.add(this);
            return true;
        } else {
            return false;
        }

    }
}
