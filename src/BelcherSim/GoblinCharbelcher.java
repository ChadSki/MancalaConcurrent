package BelcherSim;

class GoblinCharbelcher extends Card {
    public GoblinCharbelcher() {
        name = "Goblin Charbelcher";
        ccColorless = 7;
        isWinCon = true;
        isArtifact = true;
    }

    public boolean tryCast(GameData g) {
        if (super.tryCast(g)) {
            Game.staticReferenceToGame.battlefield.add(this);

            if (Game.staticReferenceToGame.visualize) {
                System.out.println("Activate Charbelcher...");
            }

            for (int i = 0; i < Game.staticReferenceToGame.library.size(); i++) {
                if (Game.staticReferenceToGame.library.get(i).isLand) {
                    if (Game.staticReferenceToGame.visualize) {
                        System.out.println(i + " flips");
                        System.out.println("Deals " + (i * 2) + " damage");
                    }
                    Game.staticReferenceToGame.belcherDamage = i * 2;
                    break;
                } else if (i == (Game.staticReferenceToGame.library.size() - 1)) {
                    if (Game.staticReferenceToGame.visualize) {
                        System.out.println(i + " flips");
                        System.out.println("Deals " + (i * 2) + " damage");
                    }
                    Game.staticReferenceToGame.belcherDamage = i * 2;

                }
            }

            return true;
        } else {
            return false;
        }
    }
}
