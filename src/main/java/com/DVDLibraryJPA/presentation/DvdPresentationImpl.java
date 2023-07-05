package com.DVDLibraryJPA.presentation;

import com.DVDLibraryJPA.dto.entity.Dvd;
import com.DVDLibraryJPA.service.DvdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.EmptyStackException;
import java.util.List;
import java.util.Scanner;

@Component
public class DvdPresentationImpl implements DvdPresentation {

    @Autowired
    private DvdService dvdService;

    @Override
    public void showMenu() {
        System.out.println("1. Add New DVD");
        System.out.println("2. List All DVDs");
        System.out.println("3. Search DVD By Title");
        System.out.println("4. Delete DVD By Title");
        System.out.println("5. Update User Rating");
        System.out.println("6. Exit");
    }

    @Override
    public void performMenu(int choice) {
        Scanner scanner=new Scanner(System.in);
        switch (choice) {
            case 1:
                Dvd dvd = new Dvd();

                System.out.println("Enter DVD ID: ");
                dvd.setDvdId(scanner.nextInt());
                System.out.println("Enter DVD Title: ");
                dvd.setTitle(scanner.next());
                System.out.println("Enter Director Name: ");
                dvd.setDirectorName(scanner.next());
                System.out.println("Enter Studio: ");
                dvd.setStudio(scanner.next());
                System.out.println("Enter User Rating: ");
                dvd.setUserRating(scanner.nextDouble());

                if(dvdService.insertDvd(dvd)!=null)
                    System.out.println("DVD Added");
                else
                    System.out.println("DVD Not Added");
                break;

            case 2:
                List<Dvd> dvds = dvdService.getAllDvds();
                for(Dvd dvd1 : dvds) {
                    System.out.println(dvd1);
                }
                break;
            case 3:
                System.out.println("Enter DVD Title: ");
                String title = scanner.next();
                Dvd searchedDvd = dvdService.searchDvdByTitle(title);
                if(searchedDvd != null)
                    System.out.println(searchedDvd);
                else
                    System.out.println("DVD with title " + title + " does not exist");
                break;
            case 4:
                System.out.println("Enter DVD Title: ");
                String dvdTitle = scanner.next();
                if(dvdService.deleteDvdByTitle(dvdTitle) != null)
                    System.out.println("DVD Deleted With Title " + dvdTitle);
                else
                    System.out.println("DVD with title " + dvdTitle + " does not exist");
                break;
            case 5:
                System.out.println("Enter DVD Title: ");
                String dTitle = scanner.next();
                System.out.println("Enter New User Rating:");
                double newRating = scanner.nextDouble();
                Dvd updatedDvd = dvdService.updateUserRating(dTitle, newRating);
                if(updatedDvd != null) {
                    System.out.print("After Update DVD Details: ");
                    System.out.println(updatedDvd);
                }
                else
                    System.out.println("DVD with title " + dTitle + " does not exist for rating update");
                break;
            case 6:
                System.out.println("Thanks for using DVD Library");
                System.exit(0);
            default:
                System.out.println("Invalid Choice");
        }
    }
}
