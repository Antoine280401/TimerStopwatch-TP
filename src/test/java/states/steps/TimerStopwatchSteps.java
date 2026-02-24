package states.steps;

import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.*;

import states.Context;
import states.stopwatch.*;
import states.timer.*;

public class TimerStopwatchSteps {

    private Context c;

    @Given("the chronometer is initialized")
    public void the_chronometer_is_initialized() {
        c = new Context();
        AbstractTimer.resetInitialValues();
        AbstractStopwatch.resetInitialValues();
    }

    @When("the user presses {string}")
    public void the_user_presses(String button) {
        switch (button.toLowerCase()) {
            case "left": c.left(); break;
            case "right": c.right(); break;
            case "up": c.up(); break;
            default: throw new IllegalArgumentException("Unknown button: " + button);
        }
    }

    @When("a tick occurs")
    public void a_tick_occurs() {
        c.tick();
    }

    @Then("the current state should be {string}")
    public void the_current_state_should_be(String expectedStateName) {
        Object expectedState = switch (expectedStateName) {
            case "IdleTimer" -> IdleTimer.Instance();
            case "SetTimer" -> SetTimer.Instance();
            case "PausedTimer" -> PausedTimer.Instance();
            case "RunningTimer" -> RunningTimer.Instance();
            case "RingingTimer" -> RingingTimer.Instance();
            case "ResetStopwatch" -> ResetStopwatch.Instance();
            case "RunningStopwatch" -> RunningStopwatch.Instance();
            case "LaptimeStopwatch" -> LaptimeStopwatch.Instance();
            default -> throw new IllegalArgumentException("Unknown state: " + expectedStateName);
        };
        assertEquals(expectedState, c.currentState);
    }

    @Then("memTimer should be {int}")
    public void memtimer_should_be(int expected) {
        assertEquals(expected, AbstractTimer.getMemTimer());
    }

    @Then("timer should be {int}")
    public void timer_should_be(int expected) {
        assertEquals(expected, AbstractTimer.getTimer());
    }

    @Then("totalTime should be {int}")
    public void totaltime_should_be(int expected) {
        assertEquals(expected, AbstractStopwatch.getTotalTime());
    }

    @Then("lapTime should be {int}")
    public void laptime_should_be(int expected) {
        assertEquals(expected, AbstractStopwatch.getLapTime());
    }
}