package com.sico.api.checkonline.infraestructure.utils;

import com.sico.api.checkinline.application.CheckOnLineApplication;
import com.sico.api.checkinline.infraestructure.utils.CheckDigitImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = CheckOnLineApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(properties = {"app.employees.calculation.years=5"})
class CheckDigitImplTest {
    @Test
    public void testCalculateDigit() {
        CheckDigitImpl checkDigit = new CheckDigitImpl();
        String result = checkDigit.calculateDigit("123456789");
        assertEquals("6", result);
    }
}
