package states.timer;

import states.ClockState;

import java.util.logging.Logger;

public final class RingingTimer extends ActiveTimer {
    protected static boolean ring = false;

    // use Singleton design pattern
    private RingingTimer() {}; // make constructor invisible to clients
    private static RingingTimer instance = null;
    public static RingingTimer Instance() {
        if(instance == null) instance = new RingingTimer();
        return instance;
    }

    @Override
    public ClockState doIt() {
        java.awt.Toolkit.getDefaultToolkit().beep();
        return this;
    }

    @Override
    public void entry() {
        ring = true;
        super.entry();};
    @Override
    public void exit() {
        ring = false;
        super.exit();};

    public String getDisplayString() {
        // display decreasing values starting from memTimer counting down to 0
        return "Time's up !";
    }

    public static boolean getRing(){
        return ring;
    }
}