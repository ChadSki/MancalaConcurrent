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
            Game.g.battlefield.add(this);

            if (Game.g.visualize) {
                System.out.println("Activate Charbelcher...");
            }

            for (int i = 0; i < Game.g.library.size(); i++) {
                if (Game.g.library.get(i).isLand) {
                    if (Game.g.visualize) {
                        System.out.println(i + " flips");
                        System.out.println("Deals " + (i * 2) + " damage");
                    }
                    Game.g.belcherDamage = i * 2;
                    break;
                } else if (i == (Game.g.library.size() - 1)) {
                    if (Game.g.visualize) {
                        System.out.println(i + " flips");
                        System.out.println("Deals " + (i * 2) + " damage");
                    }
                    Game.g.belcherDamage = i * 2;

                }
            }

            return true;
        } else {
            return false;
        }
    }
}
