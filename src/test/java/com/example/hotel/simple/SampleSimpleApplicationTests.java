package com.example.hotel.simple;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for {@link SampleSimpleApplication}.
 * 
 * author Dave Syer
 * author Phillip Webb
 */
@ExtendWith(OutputCaptureExtension.class)
public class SampleSimpleApplicationTests {

    private String profiles;

    @BeforeEach
    public void init() {
        this.profiles = System.getProperty("spring.profiles.active");
    }

    @AfterEach
    public void after() {
        if (this.profiles != null) {
            System.setProperty("spring.profiles.active", this.profiles);
        } else {
            System.clearProperty("spring.profiles.active");
        }
    }

    @Test
    public void testDefaultSettings(CapturedOutput output) throws Exception {
        SampleSimpleApplication.main(new String[0]);
        String capturedOutput = output.toString();
        assertTrue(capturedOutput.contains("Hello Phil"), "Wrong output: " + capturedOutput);
    }

    @Test
    public void testCommandLineOverrides(CapturedOutput output) throws Exception {
        SampleSimpleApplication.main(new String[] { "--name=Gordon" });
        String capturedOutput = output.toString();
        assertTrue(capturedOutput.contains("Hello Gordon"), "Wrong output: " + capturedOutput);
    }
}
