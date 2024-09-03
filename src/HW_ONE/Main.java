package HW_ONE;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library myLibrary = new Library(new ArrayList<>());

        while (true) {
            String user_title;
            String user_author;
            String user_date_of_publication;
            LibraryResource foundResource;
            printUserMenu();

            Scanner scan = new Scanner(System.in);
            int user_choice = scan.nextInt();
            scan.nextLine();

            switch (user_choice) {
                case 1:
                    System.out.println("To add a new book, I would need a little bit of info from you!");
                    System.out.println("Can you enter the title of the book? ");
                    user_title = scan.nextLine();

                    System.out.println("Next, can you enter the author of the book? ");
                    user_author = scan.nextLine();

                    Book book_to_add = new Book(user_title, user_author);
                    myLibrary.addResource(book_to_add);

                    System.out.println("Your book has been successfully added!");
                    break;

                case 2:
                    System.out.println("To add a new magazine, I would need a little bit of info from you!");
                    System.out.println("Can you enter the title of the magazine? ");
                    user_title = scan.nextLine();

                    System.out.println("Next, can you enter the author of the magazine? ");
                    user_author = scan.nextLine();

                    System.out.println("Next, can you enter the date of publication of the magazine? ");
                    user_date_of_publication = scan.nextLine();

                    Magazine magazine_to_add = new Magazine(user_title, user_author, user_date_of_publication);
                    myLibrary.addResource(magazine_to_add);

                    System.out.println("Your magazine has been successfully added!");
                    break;

                case 3:
                    System.out.println("To find your desired item, I would need a little bit of info from you!");
                    System.out.println("Can your enter the title of the item?");
                    user_title = scan.nextLine();

                    foundResource = myLibrary.findResource(user_title);

                    if (foundResource == null){
                        System.out.println("404 Error. HW_ONE.Book not found!");
                        break;
                    }

                    System.out.println();
                    if (foundResource.isAssigned()){
                        System.out.println("HW_ONE.Book is not available to be borrowed");
                    } else {
                        System.out.println("HW_ONE.Book is available to be borrowed");
                    }

                    foundResource.displayLibraryResource();
                    break;

                case 4:
                    String user_name;
                    String user_phone;

                    System.out.println("To check out a book or magazine, I would need a little bit of info from you!");
                    System.out.println("Can your kindly enter your name?");
                    user_name = scan.nextLine();

                    //add check for numbers
                    System.out.println("Can your kindly enter your phone. Ex 3334445555?");
                    user_phone = scan.nextLine();

                    System.out.println("Can your enter the title of the item?");
                    user_title = scan.nextLine();

                    foundResource = myLibrary.findResource(user_title);

                    if (foundResource == null){
                        System.out.println("404 Error. HW_ONE.Book not found!");
                        break;
                    }


                    try {
                        int parsed_phone = Integer.parseInt(user_phone);
                        Person borrower = new Person(user_name, parsed_phone);
                        foundResource.checkOut(borrower);
                        System.out.println("Checkout Successful");
                    } catch (NumberFormatException e) {
                        System.out.println("Could not parse your phone number");
                        System.out.println(e.getMessage());
                    }

                    break;

                case 5:
                    System.out.println("To check in a book or magazine, I would need a little bit of info from you!");
                    System.out.println("Can your enter the title of the item?");
                    user_title = scan.nextLine();

                    foundResource = myLibrary.findResource(user_title);

                    if (foundResource == null){
                        System.out.println("404 Error. HW_ONE.Book not found!");
                        break;
                    }

                    foundResource.checkIn();
                    break;

                case 6:
                    myLibrary.printResourcesInStock();
                    break;

                case 7:
                    myLibrary.printResourcesOnLoan();
                    break;

                case 8:
                    myLibrary.printResourcesOnLoanWithBorrowerPhoneNumber();
                    break;

                case 9:
                    myLibrary.populateLibraryWithDefaults();
                    break;

                case 10:
                    System.out.println("Thanks for chatting with us today!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Wrong input and not found!");
                    break;
            }
        }

    }

    public static void printUserMenu() {
        System.out.println();
        System.out.println("Howdy User! Press a number and let's begin this journey!");
        System.out.println("1 - Enter a new book into the system");
        System.out.println("2 - Enter a magazine into the system");
        System.out.println("3 - Search and see the status of a book or magazine by title");
        System.out.println("4 - Check-out a book or magazine and assign it to a person");
        System.out.println("5 - Check-in a book or magazine");
        System.out.println("6 - Print the number, and all the books & magazines currently in stock");
        System.out.println("7 - Print the number, and all the books & magazines currently on loan.");
        System.out.println("8 - Print out all the phone numbers of people who have books and magazines out.");
        System.out.println("9 - An option to fill the library with at least 5 default books and 3 magazines.");
        System.out.println("10 - Exit");
        System.out.println();
    }
}









