package gui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import states.Context;

import static org.junit.jupiter.api.Assertions.*;

class SwingGUITest {

    @Test
    @DisplayName("SwingGUI constructor delegates to super and creates instance")
    void constructorCreatesInstance() {
        // Context implements EventListener in this project (it is used in other GUI tests)
        Context c = new Context();

        SwingGUI gui = new SwingGUI(c);

        assertNotNull(gui);
    }
}