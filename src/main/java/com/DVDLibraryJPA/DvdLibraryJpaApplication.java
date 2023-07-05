package com.DVDLibraryJPA;

import com.DVDLibraryJPA.presentation.DvdPresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Scanner;

@SpringBootApplication(scanBasePackages = "com.DVDLibraryJPA")
@EntityScan(basePackages = "com.DVDLibraryJPA.dto.entity")
@EnableJpaRepositories(basePackages = "com.DVDLibraryJPA.persistence")
public class DvdLibraryJpaApplication implements CommandLineRunner {

	@Autowired
	private DvdPresentation dvdPresentation;

	public static void main(String[] args) {
		SpringApplication.run(DvdLibraryJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			dvdPresentation.showMenu();
			System.out.println("Enter choice: ");
			int choice = scanner.nextInt();
			dvdPresentation.performMenu(choice);
		}
	}
}
