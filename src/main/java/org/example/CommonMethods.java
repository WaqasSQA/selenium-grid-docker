package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommonMethods {

    public static void runTerminalCommand(String command, String logtext) {
        try {
            String path = System.getProperty("user.dir");
            System.out.println("Current directory: " + path); // Log current directory
            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "cd \"" + path + "\" && " + command);
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            boolean foundLogText = false;
            long startTime = System.currentTimeMillis(); // Record start time
            long timeout = 60000; // Timeout in milliseconds (adjust as needed)
            System.out.println("Command output:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Log each line of command output
                if (line.contains(logtext)) {
                    foundLogText = true;
                    break;
                }
                // Check timeout
                if (System.currentTimeMillis() - startTime > timeout) {
                    throw new RuntimeException("Timeout: Log text '" + logtext + "' not found in command output");
                }
            }
            if (!foundLogText) {
                throw new RuntimeException("Log text '" + logtext + "' not found in command output");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error running terminal command", e);
        }
    }


}
