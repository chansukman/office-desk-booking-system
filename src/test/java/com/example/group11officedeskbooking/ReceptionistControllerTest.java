package com.example.group11officedeskbooking;
import static org.assertj.core.api.Assertions.*;
import com.example.group11officedeskbooking.controller.ReceptionistController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReceptionistControllerTest {
    @Autowired
    private ReceptionistController receptionistController;

    @Test
    public void contentRoute() throws Exception{
        assertThat(receptionistController).isNotNull();

    }
}
