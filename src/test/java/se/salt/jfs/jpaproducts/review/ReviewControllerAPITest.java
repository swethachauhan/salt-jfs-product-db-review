package se.salt.jfs.jpaproducts.review;

import org.junit.jupiter.api.*;
import org.springframework.http.ResponseEntity;
import se.salt.jfs.jpaproducts.JfsLabJpaPostgresqlApplicationTests;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ReviewControllerAPITest extends JfsLabJpaPostgresqlApplicationTests {



  @BeforeAll
  static void setUp() {
    // create a known state   in the test databases here
  }

  @AfterAll
  static void tearDown() {
    // clean up after the tests so state is not leaked to other tests
  }

  @Test
  void shouldListReviews() {
    ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:%s/api/reviews".formatted(port), List.class);
    List reviews = response.getBody();
    assertThat(response.getStatusCode().value()).isEqualTo(200);
    assertThat(reviews).hasSize(1);

  }


}