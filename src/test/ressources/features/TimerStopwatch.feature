Feature: Timer and Stopwatch State Machine
  As a user
  I want to switch between timer and stopwatch modes and trigger actions
  So that I can verify the states, history, and time values are correctly maintained

  Scenario: Complete Timer-Stopwatch scenario with mode switching and history states
    Given the chronometer is initialized
    Then the current state should be "IdleTimer"
    And memTimer should be 0

    When the user presses "right"
    And a tick occurs
    Then the current state should be "SetTimer"
    And memTimer should be 1
    And timer should be 0

    When a tick occurs
    Then memTimer should be 2
    And timer should be 0

    When the user presses "right"
    And a tick occurs
    Then memTimer should be 2
    And timer should be 0

    When the user presses "up"
    Then timer should be 2
    When a tick occurs
    Then memTimer should be 2
    And timer should be 1

    When the user presses "up"
    And a tick occurs
    Then the current state should be "PausedTimer"
    And memTimer should be 2
    And timer should be 1

    When the user presses "left"
    And a tick occurs
    Then the current state should be "ResetStopwatch"
    And totalTime should be 0
    And lapTime should be 0

    When the user presses "up"
    And a tick occurs
    Then the current state should be "RunningStopwatch"
    And totalTime should be 1
    And lapTime should be 0

    When the user presses "up"
    And a tick occurs
    Then the current state should be "LaptimeStopwatch"
    And totalTime should be 2
    And lapTime should be 1

    When the user presses "left"
    And a tick occurs
    Then the current state should be "PausedTimer"
    And memTimer should be 2
    And timer should be 1

    When the user presses "up"
    Then the current state should be "RunningTimer"
    When a tick occurs
    Then the current state should be "RingingTimer"
    And memTimer should be 2
    And timer should be 0

    When the user presses "right"
    And a tick occurs
    Then the current state should be "IdleTimer"
    And memTimer should be 2
    And timer should be 0