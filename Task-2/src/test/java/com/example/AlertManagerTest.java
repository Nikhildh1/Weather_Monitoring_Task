package com.example; // Ensure this matches the package of AlertManager

import org.junit.Test;
import static org.junit.Assert.*;

public class AlertManagerTest {

    @Test
    public void testAlertTriggering() {
        AlertManager alertManager = new AlertManager(35.0);

        alertManager.checkForAlerts(30.0);
        alertManager.checkForAlerts(36.0);
        alertManager.checkForAlerts(36.0);
    }
}
