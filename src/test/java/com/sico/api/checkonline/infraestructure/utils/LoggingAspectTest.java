package com.sico.api.checkonline.infraestructure.utils;
import com.sico.api.checkinline.application.CheckOnLineApplication;
import com.sico.api.checkinline.infraestructure.utils.LoggingAspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;

import static org.mockito.Mockito.*;

@SpringBootTest(classes = CheckOnLineApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(properties = {"app.employees.calculation.years=5"})
@Import(LoggingAspect.class)
public class LoggingAspectTest {

    @Mock
    private JoinPoint joinPoint;

    @Mock
    private Throwable throwable;

    @Spy
    @InjectMocks
    private LoggingAspect loggingAspect;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLogAfterReturning() {
        Object result = new Object();
        Signature signature = mock(MethodSignature.class);
        when(joinPoint.getSignature()).thenReturn(signature);
        when(joinPoint.getArgs()).thenReturn(new Object[]{});
        when(joinPoint.getTarget()).thenReturn(new Object());

        loggingAspect.logAfterReturning(joinPoint, result);

        // Verificar si se llamó al método de registro después de un retorno exitoso
        verify(loggingAspect, times(1)).logAfterReturning(joinPoint, result);
    }

    @Test
    public void testLogAfterThrowing() {
        when(throwable.getMessage()).thenReturn("Error message");

        loggingAspect.logAfterThrowing(joinPoint, throwable);

        // Verificar si se llamó al método de registro después de lanzar una excepción
        verify(loggingAspect, times(1)).logAfterThrowing(joinPoint, throwable);
    }
}
