package BelcherSim;

public class GameData {
    int stormCount = 0;

    // Colored mana pools
    int redPool = 0;
    int greenPool = 0;
    int blackPool = 0;
    int bluePool = 0;
    int whitePool = 0;
    int colorlessPool = 0;

    // Gets total number of mana in pool
    public int getManaPool() {
        return (redPool + greenPool + blackPool + bluePool + whitePool + colorlessPool);
    }

    public int getRed() {
        return redPool;
    }

    public int getGreen() {
        return greenPool;
    }

    public int getColorless() {
        return colorlessPool;
    }

    // Add colored mana to pool
    public void setRed(int a) {
        redPool = a;
    }

    public void setGreen(int a) {
        greenPool = a;
    }

    public void setBlue(int a) {
        bluePool = a;
    }

    public void setBlack(int a) {
        blackPool = a;
    }

    public void setWhite(int a) {
        whitePool = a;
    }

    public void setColorless(int a) {
        colorlessPool = a;
    }

    // Get/Set storm count.
    public int getStormCount() {
        return stormCount;
    }

    public void setStormCount(int b) {
        stormCount = b;
    }
}
