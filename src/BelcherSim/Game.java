package BelcherSim;

import java.util.ArrayList;
import java.util.Collections;

public class Game {
    // Create card zones
    ArrayList<Card> library = new ArrayList<Card>();
    ArrayList<Card> graveyard = new ArrayList<Card>();
    ArrayList<Card> battlefield = new ArrayList<Card>();
    ArrayList<Card> hand = new ArrayList<Card>();
    ArrayList<Card> exile = new ArrayList<Card>();
    ArrayList<Card> sideboard = new ArrayList<Card>();

    // Temporary card zones
    ArrayList<Card> tempLibrary = new ArrayList<Card>();
    ArrayList<Card> tempGraveyard = new ArrayList<Card>();
    ArrayList<Card> tempBattlefield = new ArrayList<Card>();
    ArrayList<Card> tempHand = new ArrayList<Card>();
    ArrayList<Card> tempExile = new ArrayList<Card>();
    ArrayList<Card> tempSideboard = new ArrayList<Card>();

    ArrayList<Card> tempLibrary2 = new ArrayList<Card>();
    ArrayList<Card> tempGraveyard2 = new ArrayList<Card>();
    ArrayList<Card> tempBattlefield2 = new ArrayList<Card>();
    ArrayList<Card> tempHand2 = new ArrayList<Card>();
    ArrayList<Card> tempExile2 = new ArrayList<Card>();
    ArrayList<Card> tempSideboard2 = new ArrayList<Card>();

    ArrayList<Card> tempLibrary3 = new ArrayList<Card>();
    ArrayList<Card> tempGraveyard3 = new ArrayList<Card>();
    ArrayList<Card> tempBattlefield3 = new ArrayList<Card>();
    ArrayList<Card> tempHand3 = new ArrayList<Card>();
    ArrayList<Card> tempExile3 = new ArrayList<Card>();
    ArrayList<Card> tempSideboard3 = new ArrayList<Card>();

    ArrayList<Card> tempLibrary4 = new ArrayList<Card>();
    ArrayList<Card> tempGraveyard4 = new ArrayList<Card>();
    ArrayList<Card> tempBattlefield4 = new ArrayList<Card>();
    ArrayList<Card> tempHand4 = new ArrayList<Card>();
    ArrayList<Card> tempExile4 = new ArrayList<Card>();
    ArrayList<Card> tempSideboard4 = new ArrayList<Card>();

    GameData gameData = new GameData();
    GameData tempGameData = new GameData();
    GameData tempGameData2 = new GameData();
    GameData tempGameData3 = new GameData();
    GameData tempGameData4 = new GameData();

    int belcherDamage = 0;
    boolean visualize = false;
    boolean debug = false;
    int openingHandSize = 7;

    // Say number of cards in the decklist
    int cardsInDeck = 60;

    int petalNum = 4; //Core
    int belcherNum = 4; //Core
    int wishNum = 4; // Core
    int etwNum = 3; // Core
    int ledNum = 4; // Core

    int cottNum = 0;
    int serumNum = 4;
    int pritNum = 2;
    int moxNum = 4;
    int esgNum = 4; // Important
    int ssgNum = 4;
    int tinderNum = 4;
    int dritNum = 4;
    int songNum = 4;
    int lgrantNum = 4;
    int rofNum = 4;
    int manamNum = 0;
    int taigaNum = 3;

    int probeNum = 0;
    int swNum = 0;

    public static Game staticReferenceToGame;

    public boolean play(boolean play) {
        // Put EtW in sideboard
        Card z = new EmptyTheWarrens();
        sideboard.add(z);

        // Not the best way to do this. Needs cleaning.
        for (int i = 1; i <= moxNum; i++) {
            Card a = new ChromeMox();
            library.add(a);
            continue;
        }

        for (int i = 1; i <= petalNum; i++) {
            Card b = new LotusPetal();
            library.add(b);
            continue;
        }

        for (int i = 1; i <= belcherNum; i++) {
            Card c = new GoblinCharbelcher();
            library.add(c);
            continue;
        }

        for (int i = 1; i <= dritNum; i++) {
            Card d = new DesperateRitual();
            library.add(d);
            continue;
        }

        for (int i = 1; i <= pritNum; i++) {
            Card e = new PyreticRitual();
            library.add(e);
            continue;
        }

        for (int i = 1; i <= esgNum; i++) {
            Card f = new ElvishSpiritGuide();
            library.add(f);
            continue;
        }

        for (int i = 1; i <= ssgNum; i++) {
            Card g = new SimianSpiritGuide();
            library.add(g);
            continue;
        }

        for (int i = 1; i <= etwNum; i++) {
            Card h = new EmptyTheWarrens();
            library.add(h);
            continue;
        }

        for (int i = 1; i <= ledNum; i++) {
            Card j = new LED();
            library.add(j);
            continue;
        }

        for (int i = 1; i <= lgrantNum; i++) {
            Card k = new LandGrant();
            library.add(k);
            continue;
        }

        for (int i = 1; i <= manamNum; i++) {
            Card l = new Manamorphose();
            library.add(l);
            continue;
        }

        for (int i = 1; i <= rofNum; i++) {
            Card m = new RiteOfFlame();
            library.add(m);
            continue;
        }

        for (int i = 1; i <= songNum; i++) {
            Card n = new SeethingSong();
            library.add(n);
            continue;
        }

        for (int i = 1; i <= taigaNum; i++) {
            Card o = new Taiga();
            library.add(o);
            continue;
        }

        for (int i = 1; i <= tinderNum; i++) {
            Card p = new TinderWall();
            library.add(p);
            continue;
        }

        for (int i = 1; i <= wishNum; i++) {
            Card q = new BurningWish();
            library.add(q);
            continue;
        }

        for (int i = 1; i <= probeNum; i++) {
            Card r = new GitaxianProbe();
            library.add(r);
            continue;
        }

        for (int i = 1; i <= swNum; i++) {
            Card r = new StreetWraith();
            library.add(r);
            continue;
        }

        for (int i = 1; i <= cottNum; i++) {
            Card s = new ChancellorOfTheTangle();
            library.add(s);
            continue;
        }

        for (int i = 1; i <= serumNum; i++) {
            Card t = new SerumPowder();
            library.add(t);
            continue;
        }

        if (library.size() != cardsInDeck) {
            System.out.println("Number of cards doesn't match cards in deck  " + library.size());
            return false;
        }

        if (play) {
            return gameSetup("play");
        } else {
            return gameSetup("draw");
        }
    }

    public void draw(int j) {
        for (int i = 1; i <= j; i++) {
            Card c = library.get(0);
            library.remove(0);
            hand.add(c);
        }
    }

    // Cast cards, bring along color if needed.
    public boolean castCard(int i, String color) {
        Card d = hand.get(i);
        boolean test = d.tryCast(gameData, color);
        if (test) {
            hand.remove(i);
            if (visualize) {
                System.out.println(d.getName() + " - Red:" + gameData.getRed() + " - Green:" + gameData.getGreen() + " - Colorless:" + gameData.getColorless());
            }
        }
        return test;
    }

    public boolean castCard(int i) {
        Card d = hand.get(i);
        boolean test = d.tryCast(gameData);
        if (test) {
            hand.remove(i);
            if (visualize) {
                System.out.println(d.getName() + " - Red:" + gameData.getRed() + " - Green:" + gameData.getGreen() + " - Colorless:" + gameData.getColorless());
            }
        }
        return test;
    }

    // Set up game
    public boolean gameSetup(String playOrDraw) {

        Collections.shuffle(library);
        draw(openingHandSize);

        // Print out hand
        if (visualize) {
            System.out.println("Hand contains:");
        }
        for (int i = 0; i < hand.size(); i++) {
            if (visualize) {
                System.out.println(hand.get(i).getName());
            }
        }

        int j = 0;

        //See if hand is keepable.
        for (j = 0; j < hand.size(); j++) {
            if (hand.get(j).isWinCon) {
                if (visualize) {
                    System.out.println("Keep it!");
                }
                break;
            }
            if (j == (hand.size() - 1)) {
                if (visualize) {
                    System.out.println("Ship it!");
                }

                // If a hand doesn't have a wincon but has Serum Powder, exile it and try again with a new seven
                for (j = 0; j < hand.size(); j++) {
                    if (hand.get(j).getName() == "Serum Powder") {
                        if (visualize) {
                            System.out.println("Serum Powder Mulligan");
                        }

                        for (int i = 0; i < openingHandSize; i++) {
                            exile.add(hand.get(0));
                            if (visualize) {
                                System.out.println("Exiling " + hand.get(0).getName());
                            }
                            hand.remove(0);
                        }
                        return gameSetup(playOrDraw);
                    }
                }

                return false;
            }
        }

        // If Serum Powder is in your hand, try to win. If you can't, remove your hand and try again.
        for (j = 0; j < hand.size(); j++) {
            if (hand.get(j).getName() == "Serum Powder") {
                if (visualize) {
                    System.out.println("Serum Powder in opener");
                }
                // Set a ref point and try to win.
                makeTempZones(1);
                if (runAI(playOrDraw, true, 2)) {
                    return true;
                    // If you don't, remove your hand from the game and try again.
                } else {
                    if (visualize) {
                        System.out.println("Serum Powder Mulligan");
                        System.out.println(" ");
                    }
                    resetTempZones(1);
                    for (int i = 0; i < openingHandSize; i++) {
                        exile.add(hand.get(0));
                        if (visualize) {
                            System.out.println("Exiling " + hand.get(0).getName());
                        }
                        hand.remove(0);
                    }
                    return gameSetup(playOrDraw);
                }
            }
        }
        return runAI(playOrDraw, true, 1);
    }

    public boolean runAI(String playOrDraw, boolean initialSetup, int loopNumber) {
        int twCount = 0;
        int j = 0;
        if (debug) {
            System.out.println("Loop number: " + loopNumber);
        }

        if (initialSetup) {
            // Add G if you have any Chancellors in your hand
            for (j = 0; j < hand.size(); j++) {
                if (hand.get(j).getName() == "Chancellor Of The Tangle") {
                    gameData.setGreen(gameData.getGreen() + 1);
                }
            }

            // Draw a card if you're on the draw.
            if (playOrDraw == "draw") {
                draw(1);
                if (visualize) {
                    System.out.println("Drew " + hand.get(hand.size() - 1).getName());
                }
            }


            if (visualize) {
                System.out.println(" ");
                System.out.println("Casting...");
            }

            //Cast free cantrips
            for (j = 0; j < hand.size(); j++) {
                if (hand.get(j).isFreeCantrip) {
                    castCard(j);
                    j--;

                    if (j == (hand.size() - 1)) {
                        break;
                    }
                }
            }
        }

        //See if Chrome mox is in hand
        for (j = 0; j < hand.size(); j++) {
            if (hand.get(j).getName() == "Chrome Mox") {
                // Copy zones and game data as a reference point.
                makeTempZones(loopNumber);

                // Try casting chrome mox without imprinting first.
                castCard(j, "no color");
                if (runAI(playOrDraw, false, (loopNumber + 1))) {
                    return true;
                } else {
                    // If it fails, reset.
                    resetTempZones(loopNumber);
                }

                // Search your hand for colored cards (ie, non-land, non artifact.)
                for (int i = 0; i < hand.size(); i++) {
                    if (hand.get(i).isRed || hand.get(i).isGreen || hand.get(i).isMulticolored) {
                        if (visualize) {
                            System.out.println(" ");
                            System.out.println("Chrome Mox loop " + i);
                        }

                        //If the card is multicolored (manamorphose,) try red and green.
                        if (hand.get(i).isMulticolored) {
                            for (int k = 0; k < 2; k++) {
                                hand.get(j).imprint(i);
                                if (k == 0) {
                                    castCard(j, "red");
                                } else {
                                    castCard(j, "green");
                                }

                                if (i < j) {
                                    Game.staticReferenceToGame.hand.remove(i);
                                } else {
                                    Game.staticReferenceToGame.hand.remove(i - 1);
                                }

                                // Try running the rest of the game.
                                if (runAI(playOrDraw, false, (loopNumber + 1))) {
                                    return true;
                                } else {
                                    // If it fails, reset..
                                    resetTempZones(loopNumber);
                                }
                            }
                            // If it isn't multicolored, get the color and try it out.
                        } else {
                            // Imprint and cast mox
                            hand.get(j).imprint(i);
                            if (hand.get(i).isRed) {
                                castCard(j, "red");
                            } else {
                                castCard(j, "green");
                            }

                            if (i < j) {
                                Game.staticReferenceToGame.hand.remove(i);
                            } else {
                                Game.staticReferenceToGame.hand.remove(i - 1);
                            }

                            // Try running the rest of the game.
                            if (runAI(playOrDraw, false, (loopNumber + 1))) {
                                return true;
                            } else {
                                // If it fails, reset..
                                resetTempZones(loopNumber);
                            }
                        }
                    }

                    if (i >= (hand.size() - 1)) {
                        return false;
                    }
                }
            }
            if (j >= (hand.size() - 1)) {
                break;
            }
        }

        if (debug) {
            System.out.println("Use constrained IMS's");
        }
        //Use constrained IMS's
        if (!hand.isEmpty()) {
            for (j = 0; j < hand.size(); j++) {
                if (hand.get(j).isConstrainedIMS || hand.get(j).getName() == "Lion's Eye Diamond") {
                    ;
                    castCard(j);
                    j--;

                    if (j == (hand.size() - 1)) {
                        break;
                    }
                }
            }
        }

        if (debug) {
            System.out.println("Get twCount");
        }
        //Check for green cards (currently only Tinder Wall)
        if (!hand.isEmpty()) {
            for (j = 0; j < hand.size(); j++) {
                if (hand.get(j).getName() == "Tinder Wall") {
                    twCount++;
                }
            }
        }

        if (debug) {
            System.out.println("Use other IMS's based on green cards in hand");
        }
        if (!hand.isEmpty()) {
            //Use other IMS's based on any green cards in hand.
            j = 0;
            // If twCount is greater than green mana in pool, cast IMS's and try to make enough green.
            if (twCount > gameData.getGreen()) {
                int tempTWC = (twCount - gameData.getGreen());
                for (j = 0; j < hand.size(); j++) {
                    if (hand.get(j).getCardCost() == 0) {
                        if (tempTWC > 0) {
                            if (castCard(j, "green")) {
                                tempTWC--;
                                j--;
                            }
                        }
                        // If tempTWC becomes zero, just cast IMS's as red
                        else {
                            if (castCard(j, "red")) {
                                j--;
                            }
                        }

                        if (j == (hand.size() - 1)) {
                            break;
                        }
                    }
                }
            }
            //Else, you don't need any more green mana, so just make red.
            else {
                for (j = 0; j < hand.size(); j++) {
                    if (hand.get(j).getCardCost() == 0) {
                        if (castCard(j, "red")) {
                            j--;
                        }

                        if (j == (hand.size() - 1)) {
                            break;
                        }
                    }
                }
            }
        }

        if (debug) {
            System.out.println("FIRST TIME - cast any tinder walls");
        }
        // FIRST TIME - Try to cast any tinder walls in your hand
        if (!hand.isEmpty()) {
            for (j = 0; j < hand.size(); j++) {
                if (hand.get(j).getName() == "Tinder Wall") {
                    if (castCard(j)) {
                        j--;
                        twCount--;
                    }

                    if (j == (hand.size() - 1)) {
                        break;
                    }
                }
            }
        }

        if (debug) {
            System.out.println("Try to cast any manamorphoses");
        }
        // Try to cast any Manamorphose in your hand
        if (!hand.isEmpty()) {
            for (j = 0; j < hand.size(); j++) {
                if (hand.get(j).getName() == "Manamorphose") {
                    if (twCount > 0) {
                        castCard(j, "green");
                    } else {
                        castCard(j, "red");
                    }

                    if (j == (hand.size() - 1)) {
                        break;
                    }
                }
            }
        }

        if (debug) {
            System.out.println("SECOND TIME - try to cast any tinder walls");
        }
        // SECOND TIME - Try to cast any tinder walls in your hand (that you may have drawn)
        if (!hand.isEmpty()) {
            for (j = 0; j < hand.size(); j++) {
                if (hand.get(j).getName() == "Tinder Wall") {
                    if (castCard(j)) {
                        j--;
                        twCount--;
                    }

                    if (j == (hand.size() - 1)) {
                        break;
                    }
                }
            }
        }

        if (debug) {
            System.out.println("Use any drawn constrained IMS's");
        }
        //If you drew an unconstrained IMS, cast it
        if (!hand.isEmpty()) {
            for (j = 0; j < hand.size(); j++) {
                if (hand.get(j).getCardCost() == 0 && hand.get(j).isUnconstrainedIMS) {
                    castCard(j, "red");

                    if (j == (hand.size() - 1)) {
                        break;
                    }
                }
            }
        }

        if (debug) {
            System.out.println("Begin casting other acceleration from your hand");
        }
        // Begin casting other acceleration in your hand, from smallest to largest
        boolean test = false;
        j = 0;
        if (!hand.isEmpty()) {
            while (!test) {
                if (!hand.get(j).isWinCon) {
                    if (castCard(j)) {
                        j = 0;
                    } else {
                        j++;
                    }
                } else {
                    j++;
                }

                if (j == (hand.size())) {
                    test = true;
                }
            }
        }


        if (debug) {
            System.out.println("Belcher wincon check");
        }
        // Cast any wincons in your hand. Belcher > Bw(etw) > etw
        // Belcher first.
        test = false;
        j = 0;
        if (!hand.isEmpty()) {
            while (!test) {
                ;
                if (hand.get(j).getName() == "Goblin Charbelcher") {
                    if (gameData.getManaPool() >= 4) {
                        for (int k = 0; k < battlefield.size(); k++) {
                            if (battlefield.get(k).getName() == "Lion's Eye Diamond") {
                                battlefield.get(k).ability1(gameData);
                                battlefield.remove(k);
                                if (visualize) {
                                    System.out.println("Crack LED.");
                                }
                                break;
                            }
                        }

                        //If you can cast Belcher, do it and check the belcher damage.
                        if (castCard(j)) {
                            if (belcherDamage >= 20) {
                                if (debug) {
                                    System.out.println("Belcher win");
                                }
                                return true;
                            } else {
                                if (debug) {
                                    System.out.println("Belcher loss");
                                }
                                return false;
                            }
                        } else {
                            break;
                        }
                    }
                }

                j++;

                if (j == (hand.size())) {
                    test = true;
                }
            }
        }

        if (debug) {
            System.out.println("Wish wincon check");
        }
        // Burning Wish next.
        test = false;
        j = 0;
        if (!hand.isEmpty()) {
            while (!test) {
                ;
                if (hand.get(j).getName() == "Burning Wish") {
                    // Get LED count
                    int ledCount = 0;
                    for (int k = 0; k < battlefield.size(); k++) {
                        if (battlefield.get(k).getName() == "Lion's Eye Diamond") {
                            ledCount++;
                        }
                    }
                    // Check for either 1R and two LEDs or 2R and one LED
                    if ((gameData.getManaPool() >= 2 && gameData.getRed() >= 1 && ledCount >= 2) || (gameData.getManaPool() >= 3 && gameData.getRed() >= 1 && ledCount >= 1) || (gameData.getManaPool() >= 6 && gameData.getRed() >= 2)) {
                        for (int k = 0; k < battlefield.size(); k++) {
                            if (battlefield.get(k).getName() == "Lion's Eye Diamond") {
                                battlefield.get(k).ability1(gameData);
                                battlefield.remove(k);
                                k--;
                                if (visualize) {
                                    System.out.println("Crack LED.");
                                }
                            }

                            if (battlefield.isEmpty()) {
                                break;
                            }
                        }

                        // Cast wish
                        if (castCard(j)) {
                            // Move EtW to hand from exile and cast it
                            hand.add(sideboard.get(0));
                            if (hand.size() == 1) {
                                castCard(0);
                            } else {
                                castCard(hand.size() - 1);
                            }

                            if (debug) {
                                System.out.println("Wish -> Empty the Warrrens win");
                            }

                            // Call it a loss if storm count is too low.
                            if (gameData.getStormCount() > 4) {
                                return true;
                            } else {
                                return false;
                            }
                        }
                    }
                }

                j++;

                if (j == (hand.size())) {
                    test = true;
                }
            }
        }

        if (debug) {
            System.out.println("ETW wincon check");
        }
        // Empty the Warrens last.
        test = false;
        j = 0;
        if (!hand.isEmpty()) {
            while (!test) {
                ;
                if (hand.get(j).getName() == "Empty the Warrens") {
                    if (gameData.getManaPool() >= 4 || gameData.getRed() >= 1) {
                        if (castCard(j)) {
                            if (debug) {
                                System.out.println("Empty the Warrens win");
                            }
                            // Call it a loss if storm count is too low.
                            if (gameData.getStormCount() > 4) {
                                return true;
                            } else {
                                return false;
                            }
                        }
                    }
                }

                j++;

                if (j == (hand.size())) {
                    test = true;
                }
            }
        }

        // You couldn't win.
        if (debug) {
            System.out.println("Default loss");
        }
        return false;
    }

    public void makeTempZones(int k) {
        if (k == 1) {
            tempLibrary.clear();
            tempGraveyard.clear();
            tempBattlefield.clear();
            tempHand.clear();
            tempExile.clear();
            tempSideboard.clear();

            int i = 0;
            for (i = 0; i < library.size(); i++) {
                tempLibrary.add(library.get(i));
            }
            for (i = 0; i < graveyard.size(); i++) {
                tempGraveyard.add(graveyard.get(i));
            }
            for (i = 0; i < battlefield.size(); i++) {
                tempBattlefield.add(battlefield.get(i));
            }
            for (i = 0; i < hand.size(); i++) {
                tempHand.add(hand.get(i));
            }
            for (i = 0; i < exile.size(); i++) {
                tempExile.add(exile.get(i));
            }
            for (i = 0; i < sideboard.size(); i++) {
                tempSideboard.add(sideboard.get(i));
            }

            tempGameData.setColorless(gameData.getColorless());
            tempGameData.setRed(gameData.getRed());
            tempGameData.setGreen(gameData.getGreen());

            tempGameData.setStormCount(gameData.getStormCount());
        } else if (k == 2) {
            tempLibrary2.clear();
            tempGraveyard2.clear();
            tempBattlefield2.clear();
            tempHand2.clear();
            tempExile2.clear();
            tempSideboard2.clear();

            int i = 0;
            for (i = 0; i < library.size(); i++) {
                tempLibrary2.add(library.get(i));
            }
            for (i = 0; i < graveyard.size(); i++) {
                tempGraveyard2.add(graveyard.get(i));
            }
            for (i = 0; i < battlefield.size(); i++) {
                tempBattlefield2.add(battlefield.get(i));
            }
            for (i = 0; i < hand.size(); i++) {
                tempHand2.add(hand.get(i));
            }
            for (i = 0; i < exile.size(); i++) {
                tempExile2.add(exile.get(i));
            }
            for (i = 0; i < sideboard.size(); i++) {
                tempSideboard2.add(sideboard.get(i));
            }

            tempGameData2.setColorless(gameData.getColorless());
            tempGameData2.setRed(gameData.getRed());
            tempGameData2.setGreen(gameData.getGreen());

            tempGameData2.setStormCount(gameData.getStormCount());
        } else if (k == 3) {
            tempLibrary3.clear();
            tempGraveyard3.clear();
            tempBattlefield3.clear();
            tempHand3.clear();
            tempExile3.clear();
            tempSideboard3.clear();

            int i = 0;
            for (i = 0; i < library.size(); i++) {
                tempLibrary3.add(library.get(i));
            }
            for (i = 0; i < graveyard.size(); i++) {
                tempGraveyard3.add(graveyard.get(i));
            }
            for (i = 0; i < battlefield.size(); i++) {
                tempBattlefield3.add(battlefield.get(i));
            }
            for (i = 0; i < hand.size(); i++) {
                tempHand3.add(hand.get(i));
            }
            for (i = 0; i < exile.size(); i++) {
                tempExile3.add(exile.get(i));
            }
            for (i = 0; i < sideboard.size(); i++) {
                tempSideboard3.add(sideboard.get(i));
            }

            tempGameData3.setColorless(gameData.getColorless());
            tempGameData3.setRed(gameData.getRed());
            tempGameData3.setGreen(gameData.getGreen());

            tempGameData3.setStormCount(gameData.getStormCount());
        } else if (k == 4) {
            tempLibrary4.clear();
            tempGraveyard4.clear();
            tempBattlefield4.clear();
            tempHand4.clear();
            tempExile4.clear();
            tempSideboard4.clear();

            int i = 0;
            for (i = 0; i < library.size(); i++) {
                tempLibrary4.add(library.get(i));
            }
            for (i = 0; i < graveyard.size(); i++) {
                tempGraveyard4.add(graveyard.get(i));
            }
            for (i = 0; i < battlefield.size(); i++) {
                tempBattlefield4.add(battlefield.get(i));
            }
            for (i = 0; i < hand.size(); i++) {
                tempHand4.add(hand.get(i));
            }
            for (i = 0; i < exile.size(); i++) {
                tempExile4.add(exile.get(i));
            }
            for (i = 0; i < sideboard.size(); i++) {
                tempSideboard4.add(sideboard.get(i));
            }

            tempGameData4.setColorless(gameData.getColorless());
            tempGameData4.setRed(gameData.getRed());
            tempGameData4.setGreen(gameData.getGreen());

            tempGameData4.setStormCount(gameData.getStormCount());
        }
    }

    public void resetTempZones(int k) {
        int i = 0;

        library.clear();
        graveyard.clear();
        battlefield.clear();
        hand.clear();
        exile.clear();
        sideboard.clear();

        if (k == 1) {

            for (i = 0; i < tempLibrary.size(); i++) {
                library.add(tempLibrary.get(i));
            }
            for (i = 0; i < tempGraveyard.size(); i++) {
                graveyard.add(tempGraveyard.get(i));
            }
            for (i = 0; i < tempBattlefield.size(); i++) {
                battlefield.add(tempBattlefield.get(i));
            }
            for (i = 0; i < tempHand.size(); i++) {
                hand.add(tempHand.get(i));
            }
            for (i = 0; i < tempExile.size(); i++) {
                exile.add(tempExile.get(i));
            }
            for (i = 0; i < tempSideboard.size(); i++) {
                sideboard.add(tempSideboard.get(i));
            }

            gameData.setColorless(tempGameData.getColorless());
            gameData.setRed(tempGameData.getRed());
            gameData.setGreen(tempGameData.getGreen());

            gameData.setStormCount(tempGameData.getStormCount());
        } else if (k == 2) {

            for (i = 0; i < tempLibrary2.size(); i++) {
                library.add(tempLibrary2.get(i));
            }
            for (i = 0; i < tempGraveyard2.size(); i++) {
                graveyard.add(tempGraveyard2.get(i));
            }
            for (i = 0; i < tempBattlefield2.size(); i++) {
                battlefield.add(tempBattlefield2.get(i));
            }
            for (i = 0; i < tempHand2.size(); i++) {
                hand.add(tempHand2.get(i));
            }
            for (i = 0; i < tempExile2.size(); i++) {
                exile.add(tempExile2.get(i));
            }
            for (i = 0; i < tempSideboard2.size(); i++) {
                sideboard.add(tempSideboard2.get(i));
            }

            gameData.setColorless(tempGameData2.getColorless());
            gameData.setRed(tempGameData2.getRed());
            gameData.setGreen(tempGameData2.getGreen());

            gameData.setStormCount(tempGameData2.getStormCount());
        } else if (k == 3) {

            for (i = 0; i < tempLibrary3.size(); i++) {
                library.add(tempLibrary3.get(i));
            }
            for (i = 0; i < tempGraveyard3.size(); i++) {
                graveyard.add(tempGraveyard3.get(i));
            }
            for (i = 0; i < tempBattlefield3.size(); i++) {
                battlefield.add(tempBattlefield3.get(i));
            }
            for (i = 0; i < tempHand3.size(); i++) {
                hand.add(tempHand3.get(i));
            }
            for (i = 0; i < tempExile3.size(); i++) {
                exile.add(tempExile3.get(i));
            }
            for (i = 0; i < tempSideboard3.size(); i++) {
                sideboard.add(tempSideboard3.get(i));
            }

            gameData.setColorless(tempGameData3.getColorless());
            gameData.setRed(tempGameData3.getRed());
            gameData.setGreen(tempGameData3.getGreen());

            gameData.setStormCount(tempGameData3.getStormCount());
        } else if (k == 4) {

            for (i = 0; i < tempLibrary4.size(); i++) {
                library.add(tempLibrary4.get(i));
            }
            for (i = 0; i < tempGraveyard4.size(); i++) {
                graveyard.add(tempGraveyard4.get(i));
            }
            for (i = 0; i < tempBattlefield4.size(); i++) {
                battlefield.add(tempBattlefield4.get(i));
            }
            for (i = 0; i < tempHand4.size(); i++) {
                hand.add(tempHand4.get(i));
            }
            for (i = 0; i < tempExile4.size(); i++) {
                exile.add(tempExile4.get(i));
            }
            for (i = 0; i < tempSideboard4.size(); i++) {
                sideboard.add(tempSideboard4.get(i));
            }

            gameData.setColorless(tempGameData4.getColorless());
            gameData.setRed(tempGameData4.getRed());
            gameData.setGreen(tempGameData4.getGreen());

            gameData.setStormCount(tempGameData4.getStormCount());
        }
    }
}
		
