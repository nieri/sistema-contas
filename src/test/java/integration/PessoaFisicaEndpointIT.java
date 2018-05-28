package integration;

import br.com.munieri.sistema.contas.boot.SistemaContasApplication;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SistemaContasApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PessoaFisicaEndpointIT {

    @LocalServerPort
    private Integer port;

    @Test
    public void deve_retornar_uma_pessoa_fiica() {

        given()
                .when()
                .get("http://127.0.0.1:" + port + "/sistema-contas/api/pf/pessoas/1")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("nome", equalTo("Murilo Nieri"));
    }

    @Test
    public void deve_retornar_BAD_REQUEST_pessoa_fisica_nao_for_encontrada() {
        get("http://127.0.0.1:" + port + "/sistema-contas/api/pf/pessoas/9999")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }
}
