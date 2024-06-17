package co.simplon.stoparnaques;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StopArnaquesApplication {

    public static void main(String[] args) {
	SpringApplication.run(StopArnaquesApplication.class,
		args);
	System.out.println("ca fonctionne :)");
    }

}
