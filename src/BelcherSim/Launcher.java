package BelcherSim;

public class Launcher implements Runnable {
    // To do list:
    // Make Serum Powder work
    // Make optimization systematic.

    public void run() {
        boolean testMode = false;
        boolean showStatsInRealTime = false;

        int winCount = 0;
        int runNumber = 10000; // 10000 is decent, but more is preferred.

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
            Game.staticReferenceToGame = new Game();

            if (testMode) {
                Game.staticReferenceToGame.visualize = true;
            }

            if (showStatsInRealTime) {
                if ((i % 1000) == 0) {
                    System.out.println("Win Percentage " + (((double) (winCount) * 100) / i) + "%");
                }
            }

            if ((i % 2) == 0) {
                if (Game.staticReferenceToGame.play(false)) {
                    winCount++;
                    drawCounter++;

                    if (Game.staticReferenceToGame.belcherDamage == 0) {
                        stormCounter++;
                        totalStormCount = totalStormCount + Game.staticReferenceToGame.gameData.getStormCount();
                    }
                }
            } else {
                if (Game.staticReferenceToGame.play(true)) {
                    winCount++;
                    playCounter++;

                    if (Game.staticReferenceToGame.belcherDamage == 0) {
                        stormCounter++;
                        totalStormCount = totalStormCount + Game.staticReferenceToGame.gameData.getStormCount();
                    }
                }
            }

            if (Game.staticReferenceToGame.belcherDamage > 0) {
                fizzleCounter++;
                belcherAvg = belcherAvg + Game.staticReferenceToGame.belcherDamage;
                if (Game.staticReferenceToGame.belcherDamage > 20) {
                    belcherFizzle++;
                }
            }
            Game.staticReferenceToGame = null;
        }

        String winPercentage = "Win: " + (((double) (winCount) * 100) / runNumber) + "%";
        System.out.println(winPercentage);

        //System.out.println("Play Win Percentage " + (((double) (playCounter) * 100) / (runNumber / 2)) + "%");
        //System.out.println("Draw Win Percentage " + (((double) (drawCounter) * 100) / (runNumber / 2)) + "%");
        //System.out.println("Average Belcher Damage " + (((double) (belcherAvg)) / (double) fizzleCounter));
        //System.out.println("Belcher Success Percentage " + (((double) (belcherFizzle) * 100) / (double) fizzleCounter) + "%");
        //System.out.println("Average Storm Count " + (((double) (totalStormCount)) / (double) stormCounter));
    }
}
