package br.com.literacode;

import br.com.literacode.main.MainMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LiteracodeApplication implements CommandLineRunner {

	@Autowired
	private MainMenu main;

	public static void main(String[] args) {
		SpringApplication.run(LiteracodeApplication.class, args);
	}

	@Override
	public void run(String... args) {
		main.showMenu();
	}
}