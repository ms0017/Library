//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Book Library: Project 3
// Files:
// Course: CS 300, Spring '19
//
// Author: Sheriff Issaka
// Email: issaka@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Don Catarello
// Partner Email: catarello@wisc.edu
// Partner Lecturer's Name: Mouna
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X__ Write-up states that pair programming is allowed for this assignment.
// __X_ We have both read and understand the course Pair Programming Policy.
// _X__ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////


import java.util.ArrayList;
import java.util.Scanner;

public class Library {
  // instance fields
  private String address; // Street address of this library
  private Librarian librarian; // this library's librarian. This library must have only ONE
                               // librarian
  private ArrayList<Book> books; // list of the books in this library
  private ArrayList<Subscriber> subscribers; // list of this library's subscribers

  /*
   * @param: address, librarian user name, librarian login implements the library method
   */
  public Library(String address, String librarianUsername, String librarianLogin) {
    // sets address
    this.address = address;
    // new instance of a librarian
    Librarian librarian = new Librarian(librarianUsername, librarianLogin);
    // setting librarian
    this.librarian = librarian;
    // new instance of a book
    books = new ArrayList<Book>();
    // new instance of a subscriber
    subscribers = new ArrayList<Subscriber>();
  }

  /*
   * @param: N/A returns librarian
   */
  public Librarian getLibrarian() {
    // returns librarian
    return librarian;
  }

  /*
   * @param: N/A returns address
   */
  public String getAddress() {
    // returns address
    return address;
  }

  /*
   * @param: book id finds a book and return it
   */
  public Book findBook(int bookId) {
    // looping through all the books for a match
    for (int i = 0; i < books.size(); i++) {
      if (books.get(i).getID() == bookId) {
        // return the matched book
        return books.get(i);
      }
    }
    // if no match, print this message and return null
    System.out.println("Error: this book identifier didn't match any of our books identifiers.");
    return null;
  }

  /*
   * @param: title compiles all matched books
   */
  public ArrayList<Book> findBookByTitle(String title) {
    // checking for matches
    ArrayList<Book> matches = new ArrayList<Book>();
    for (int i = 0; i < books.size(); i++) {
      if (books.get(i).getTitle().equalsIgnoreCase(title)) {
        // adding matches to array list
        matches.add(books.get(i));
      }
    }
    // returns the matches
    return matches;
  }

  /*
   * @param: author finds book given author
   */
  public ArrayList<Book> findBookByAuthor(String author) {
    // checking for matches
    ArrayList<Book> matches = new ArrayList<Book>();
    for (int i = 0; i < books.size(); i++) {
      if (books.get(i).getAuthor().equalsIgnoreCase(author)) {
        // adding matches to array list
        matches.add(books.get(i));
      }
    }
    // returns the matching book
    return matches;
  }

  /*
   * @param: title, author adds a book given its name and author
   */
  public void addBook(String title, String author) {
    // new instance of a book
    Book B1 = new Book(title, author);
    // adding to the list of books
    books.add(B1);
    // message
    System.out.println("Book with Title " + title + " is successfully added to the library.");
  }

  /*
   * @param: book id finds and removes a book
   */
  public Book removeBook(int bookId) {
    // finds book
    Book book = findBook(bookId);
    if (book != null) {
      // removes its occurrence
      books.remove(book);
      return book;
    }
    return null;
  }

  /*
   * @param: name, pin, address, phone number adds a new subscriber
   */
  public void addSubscriber(String name, int pin, String address, String phoneNumber) {
    // creates a new instance of subscriber
    Subscriber subscriber = new Subscriber(name, pin, address, phoneNumber);
    // adds the new instance to the list of subscribers
    subscribers.add(subscriber);
    // message to subscriber
    System.out.println("Library card with bar code " + subscriber.getCARD_BAR_CODE()
        + " is successfully issued to the new subscriber " + name + ".");
  }

  /*
   * @param: card bar code finds a subscriber gives it's code
   */
  public Subscriber findSubscriber(int cardBarCode) {
    // checking for a match
    for (int i = 0; i < subscribers.size(); i++) {
      if (subscribers.get(i).getCARD_BAR_CODE() == cardBarCode) {
        // returns the subscriber if found
        return subscribers.get(i);
      }
    }
    // if there is no match, return this message and return null
    System.out.println("Error: this card bar code didn't match any of our records.");
    return null;
  }


  /**
   * Displays a list of books
   * 
   * @param books ArrayList of books
   */
  public static void displayBooks(ArrayList<Book> books) {
    // Traverse the list of books and display book id, title, author, and availability of each book
    for (int i = 0; i < books.size(); i++) {
      System.out.print("<Book ID>: " + books.get(i).getID() + " ");
      System.out.print("<Title>: " + books.get(i).getTitle() + " ");
      System.out.print("<Author>: " + books.get(i).getAuthor() + " ");
      System.out.println("<Is Available>: " + books.get(i).isAvailable());
    }
  }

  /**
   * Reads and processes the user commands with respect to the menu of this application
   * 
   * @param scanner Scanner object used to read the user command lines
   */
  public void readProcessUserCommand(Scanner scanner) {
    final String promptCommandLine = "ENTER COMMAND: ";
    displayMainMenu(); // display the library management system main menu
    System.out.print(promptCommandLine);
    String command = scanner.nextLine(); // read user command line
    String[] commands = command.trim().split(" "); // split user command
    while (commands[0].trim().charAt(0) != '3') { // '3': Exit the application
      switch (commands[0].trim().charAt(0)) {
        case '1': // login as librarian commands[1]: password
          if (this.librarian.checkPassword(commands[1])) {
            // read and process librarian commands
            readProcessLibrarianCommand(scanner);
          } else { // error password
            System.out.println("Error: Password incorrect!");
          }
          break;
        case '2': // login as subscriber commands[1]: card bar code
          Subscriber subscriber = this.findSubscriber(Integer.parseInt(commands[1]));
          if (subscriber != null) {
            if (subscriber.getPin() == Integer.parseInt(commands[2])) // correct PIN
              // read and process subscriber commands
              readProcessSubscriberCommand(subscriber, scanner);
            else
              System.out.println("Error: Incorrect PIN.");
          }
          break;
      }
      // read and split next user command line
      displayMainMenu(); // display the library management system main menu
      System.out.print(promptCommandLine);
      command = scanner.nextLine(); // read user command line
      commands = command.trim().split(" "); // split user command line
    }
  }

  /**
   * Displays the main menu for this book library application
   */
  private static void displayMainMenu() {
    System.out.println("\n--------------------------------------------------------");
    System.out.println("     Welcome to our Book Library Management System");
    System.out.println("--------------------------------------------------------");
    System.out.println("Enter one of the following options:");
    System.out.println("[1 <password>] Login as a librarian");
    System.out.println("[2 <card bar code> <4-digits pin>] Login as a Subscriber");
    System.out.println("[3] Exit"); // Exit the application
    System.out.println("--------------------------------------------------------");
  }

  /**
   * Displays the menu for a Subscriber
   */
  private static void displaySubscriberMenu() {
    System.out.println("\n--------------------------------------------------------");
    System.out.println("    Welcome to Subscriber's Space");
    System.out.println("--------------------------------------------------------");
    System.out.println("Enter one of the following options:");
    System.out.println("[1 <book ID>] Check out a book");
    System.out.println("[2 <book ID>] Return a book");
    System.out.println("[3 <title>] Search a Book by title");
    System.out.println("[4 <author>] Search a Book by author");
    System.out.println("[5] Print list of books checked out");
    System.out.println("[6] Print history of returned books");
    System.out.println("[7 <address>] Update address");
    System.out.println("[8 <phone number>] Update phone number");
    System.out.println("[9] Logout");
    System.out.println("--------------------------------------------------------");
  }

  /**
   * Displays the menu for the Librarian
   */
  private static void displayLibrarianMenu() {
    System.out.println("\n--------------------------------------------------------");
    System.out.println("    Welcome to Librarian's Space");
    System.out.println("--------------------------------------------------------");
    System.out.println("Enter one of the following options:");
    System.out.println("[1 <title> <author>] Add new Book");
    System.out.println("[2 <name> <pin> <address> <phone number>] Add new subscriber");
    System.out.println("[3 <card bar code> <book ID>] Check out a Book");
    System.out.println("[4 <card bar code> <book ID>] Return a Book for a subscriber");
    System.out.println("[5 <card bar code>] Display Personal Info of a Subscriber");
    System.out.println("[6 <card bar code>] Display Books Checked out by a Subscriber");
    System.out.println("[7] Display All Books");
    System.out.println("[8 <book ID>] Remove a Book");
    System.out.println("[9] Logout");
    System.out.println("--------------------------------------------------------");
  }

  /**
   * Display the Application GoodBye and logout message.
   */
  private static void displayGoodByeLogoutMessage() {
    System.out.println("\n--------------------------------------------------------");
    System.out.println("       Thanks for Using our Book Library App!!!!");
    System.out.println("--------------------------------------------------------");
  }

  /**
   * Reads and processes the librarian commands according to the librarian menu
   * 
   * @param scanner Scanner object used to read the librarian command lines
   */
  private void readProcessLibrarianCommand(Scanner scanner) {
    // a declaration of a subscriber to be used later
    Subscriber subscriber;
    // an int declaration of a barcode to be used later
    int barcode;
    int a;
    // a do while to ensure the sustainability of the code
    do {
      // displaying menu
      displayLibrarianMenu();
      // prompting user for input
      System.out.print("ENTER COMMAND: ");
      // getting the first scanner value to chose a case
      a = scanner.nextInt();
      switch (a) {
        // this case adds a book
        case 1:
          addBook(scanner.next(), scanner.next());
          break;

        // this case adds a subscriber
        case 2:
          addSubscriber(scanner.next(), scanner.nextInt(), scanner.next(), scanner.next());
          break;
        // this case checks out a book
        case 3:
          barcode = scanner.nextInt();
          if (findSubscriber(barcode) != null) {
            // making sure the subscriber is eligible
            subscriber = findSubscriber(barcode);
            int BID = scanner.nextInt();
            if (findBook(BID) != null) {
              // enables check out
              subscriber.checkoutBook(findBook(BID));
            }
          }
          break;
        // this case enables a book to be returned
        case 4:
          barcode = scanner.nextInt();
          subscriber = findSubscriber(barcode);
          subscriber.returnBook(findBook(scanner.nextInt()));
          break;

        // this case displays the subscribers info
        case 5:
          barcode = scanner.nextInt();
          subscriber = findSubscriber(barcode);
          subscriber.displayPersonalInfo();
          break;
        // this case displays books checked out
        case 6:
          barcode = scanner.nextInt();
          subscriber = findSubscriber(barcode);
          subscriber.displayBooksCheckedOut();
          break;
        // this method displays all books
        case 7:
          displayBooks(books);
          break;
        // this method removes a book
        case 8:
          removeBook(scanner.nextInt());
          break;
      }
      // making sure input isn't a quit number
    } while (a != 9);

    scanner.nextLine();
  }

  /**
   * Reads and processes the subscriber commands according to the subscriber menu
   * 
   * @param subscriber Current logged in subscriber
   * @param scanner    Scanner object used to read the librarian command lines
   */
  private void readProcessSubscriberCommand(Subscriber subscriber, Scanner scanner) {
    // ints to be used later by the cases
    int b;
    int fromScan;
    do {
      // a do while loops to continue the code before the quit number
      // displays menu
      displaySubscriberMenu();
      // displays command
      System.out.print("ENTER COMMAND: ");
      // receiving scanner value
      b = scanner.nextInt();
      switch (b) {

        // this case enables check out
        case 1:
          fromScan = scanner.nextInt();
          if (findBook(fromScan) != null) {
            subscriber.checkoutBook(findBook(fromScan));
          }
          break;
        // this case allows the return of a book
        case 2:
          fromScan = scanner.nextInt();
          if (findBook(fromScan) != null) {
            subscriber.returnBook(findBook(fromScan));
          }
          break;
        // this case displays books by title
        case 3:
          displayBooks(findBookByTitle(scanner.next()));
          break;
        // this case displays books by author
        case 4:
          displayBooks(findBookByAuthor(scanner.next()));
          break;
        // this case displays books checked out
        case 5:
          subscriber.displayBooksCheckedOut();
          break;
        // this method displays a books history
        case 6:
          subscriber.displayHistoryBooksReturned();
          break;
        // this case updates an address
        case 7:
          subscriber.setAddress(scanner.next());
          break;
        case 8:
          //// this case updates an phone number
          subscriber.setPhoneNumber(scanner.next());
      }
    } while (b != 9);
    scanner.nextLine();
  }


  /**
   * Main method that represents the driver for this application
   * 
   * @param args
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in); // create a scanner object to read user inputs
    // create a new library object
    Library madisonLibrary = new Library("Madison, WI", "april", "abc");
    // read and process user command lines
    madisonLibrary.readProcessUserCommand(scanner);
    displayGoodByeLogoutMessage(); // display good bye message
    scanner.close();// close this scanner
  }
}
