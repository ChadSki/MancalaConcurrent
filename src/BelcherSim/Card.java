package BelcherSim;

abstract class Card {
    String name;

    // Mana costs
    boolean isConstrainedIMS;
    boolean isUnconstrainedIMS;

    boolean isRed;
    boolean isGreen;
    boolean isMulticolored;

    int cardCost;
    int ccRed;
    int ccGreen;
    int ccColorless;

    boolean isLand;
    boolean isArtifact;

    boolean isWinCon;

    boolean isCantrip;
    boolean isFreeCantrip;

    boolean isImprinted;

    public String getName() {
        return name;
    }

    public int getCardCost() {
        cardCost = ccRed + ccGreen + ccColorless;
        return (cardCost);
    }

    public boolean tryCast(GameData g, String color) {
        return true;
    }

    // Attempt to cast any card. If you can't pay for it, resets mana to previous point.
    public boolean tryCast(GameData g) {
        // Initialize temp variables
        int backUpColorless = g.getColorless();
        int backUpRed = g.getRed();
        int backUpGreen = g.getGreen();

        int tempccColorless = this.ccColorless;
        int tempccRed = this.ccRed;
        int tempccGreen = this.ccGreen;


        // Do mana costs only if it costs mana
        if (this.getCardCost() > 0) {
            // If the card has a colorless cost...
            if (tempccColorless > 0) {
                //... and if there is colorless mana in the pool...
                if (g.getColorless() > 0) {
                    //... use the limiting resource.
                    if (g.getColorless() >= tempccColorless) {
                        g.setColorless(g.getColorless() - tempccColorless);
                        tempccColorless = 0;
                    } else {
                        tempccColorless = tempccColorless - g.getColorless();
                        g.setColorless(0);
                    }
                }
            }

            // Next, repeat, but using green mana to fill the colorless
            if (tempccColorless > 0) {
                //... and if there is green mana in the pool...
                if (g.getGreen() > 0) {
                    //... use the limiting resource.
                    if (g.getGreen() >= tempccColorless) {
                        g.setGreen(g.getGreen() - tempccColorless);
                        tempccColorless = 0;
                    } else {
                        tempccColorless = tempccColorless - g.getGreen();
                        g.setGreen(0);
                    }
                }
            }

            // Repeat, but using red mana to fill the colorless
            if (tempccColorless > 0) {
                //... and if there is red mana in the pool...
                if (g.getRed() > 0) {
                    //... use the limiting resource.
                    if (g.getRed() >= tempccColorless) {
                        g.setRed(g.getRed() - tempccColorless);
                        tempccColorless = 0;
                    } else {
                        tempccColorless = tempccColorless - g.getRed();
                        g.setRed(0);
                    }
                }
            }

            // Use green to fill green
            if (tempccGreen > 0) {
                //... and if there is green mana in the pool...
                if (g.getGreen() > 0) {
                    //... use the limiting resource.
                    if (g.getGreen() >= tempccGreen) {
                        g.setGreen(g.getGreen() - tempccGreen);
                        tempccGreen = 0;
                    } else {
                        tempccGreen = tempccGreen - g.getGreen();
                        g.setGreen(0);
                    }
                }
            }

            // Use red to fill red
            if (tempccRed > 0) {
                //... and if there is red mana in the pool...
                if (g.getRed() > 0) {
                    //... use the limiting resource.
                    if (g.getRed() >= tempccRed) {
                        g.setRed(g.getRed() - tempccRed);
                        tempccRed = 0;
                    } else {
                        tempccRed = tempccRed - g.getRed();
                        g.setRed(0);
                    }
                }
            }
        }

        // If you have any cost unpaid, then return things the way they were and exit the method.
        if (tempccRed > 0 || tempccGreen > 0 || tempccColorless > 0) {
            g.setColorless(backUpColorless);
            g.setGreen(backUpGreen);
            g.setRed(backUpRed);
            return false;
            //Otherwise, proceed.
        } else if (!(isLand) && (!isConstrainedIMS)) {
            int storm = g.getStormCount();
            storm++;
            g.setStormCount(storm);
        }
        return true;
    }

    public boolean canCast(GameData g) {
        int manaPool = g.getManaPool();
        if (cardCost > manaPool) {
            return false;
        } else {
            return true;
        }
    }

    public void ability1(GameData g) {
    }

    public void imprint(int i) {
    }
}
