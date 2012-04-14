package BelcherSim;

public class Launcher {
    // To do list:
    // Make Serum Powder work
    // Make optimization systematic.

    public static void main(String[] args) {
        boolean testMode = false;
        boolean showStatsInRealTime = true;

        int winPercentage = 0;
        int runNumber = 1000000; // 10000 is decent, but more is preferred.

        int belcherAvg = 0;
        int belcherFizzle = 0;
        int fizzleCounter = 0;
        int playCounter = 0;
        int drawCounter = 0;

        int totalStormCount = 0;
        int stormCounter = 0;

        // Test mode
        if (testMode) {
            runNumber = 1;
        }

        // Run the program runNumber times and get the statistics.
        for (int i = 1; i <= runNumber; i++) {
            Game.g = new Game();

            if (testMode) {
                Game.g.visualize = true;
            }

            if (showStatsInRealTime) {
                if ((i % 1000) == 0) {
                    System.out.println("Win Percentage " + (((double) (winPercentage) * 100) / i) + "%");
                }
            }

            if ((i % 2) == 0) {
                if (Game.g.play(false)) {
                    winPercentage++;
                    drawCounter++;

                    if (Game.g.belcherDamage == 0) {
                        stormCounter++;
                        totalStormCount = totalStormCount + Game.g.gameData.getStormCount();
                    }
                }
            } else {
                if (Game.g.play(true)) {
                    winPercentage++;
                    playCounter++;

                    if (Game.g.belcherDamage == 0) {
                        stormCounter++;
                        totalStormCount = totalStormCount + Game.g.gameData.getStormCount();
                    }
                }
            }

            if (Game.g.belcherDamage > 0) {
                fizzleCounter++;
                belcherAvg = belcherAvg + Game.g.belcherDamage;
                if (Game.g.belcherDamage > 20) {
                    belcherFizzle++;
                }
            }
            Game.g = null;
        }

        System.out.println(" ");
        System.out.println("Final Win Percentage " + (((double) (winPercentage) * 100) / runNumber) + "%");
        System.out.println("Play Win Percentage " + (((double) (playCounter) * 100) / (runNumber / 2)) + "%");
        System.out.println("Draw Win Percentage " + (((double) (drawCounter) * 100) / (runNumber / 2)) + "%");
        System.out.println(" ");
        System.out.println("Average Belcher Damage " + (((double) (belcherAvg)) / (double) fizzleCounter));
        System.out.println("Belcher Success Percentage " + (((double) (belcherFizzle) * 100) / (double) fizzleCounter) + "%");
        System.out.println("Average Storm Count " + (((double) (totalStormCount)) / (double) stormCounter));
    }
}
