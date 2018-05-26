package integration;

import br.com.munieri.sistema.contas.boot.SistemaContasApplication;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static io.restassured.RestAssured.get;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SistemaContasApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestEndPoitTestIT {

    @LocalServerPort
    private Integer port;

    @Test
    public void should_return_ok() {
        get("http://127.0.0.1:" + port + "/sistema-contas/api/test")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }
}
