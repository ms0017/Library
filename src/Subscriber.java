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

public class Subscriber {
  // static fields
  private final static int MAX_BOOKS_CHECKED_OUT = 10; // maximum number of books to be checked out
                                                       // one subscriber
  private static int nextCardBarCode = 2019000001; // class variable that represents the card bar
                                                   // code of the next subscriber to be created
  // Instance fields
  private int pin; // 4-digits Personal Identification Number to verify the identity of this
                   // subscriber
  private final Integer CARD_BAR_CODE; // card bar code of this subscriber

  private String name; // name of this subscriber
  private String address; // address of this subscriber
  private String phoneNumber; // phone number of this subscriber

  private ArrayList<Book> booksCheckedOut; // list of books checked out by this subscriber and not
                                           // yet
                                           // returned. A subscriber can have at most 10 checked out
                                           // books
  private ArrayList<Book> booksReturned; // list of the books returned by this subscriber

  /**
   * Checks if this subscriber booksCheckedOut list contains a given book
   * 
   * @param book book to check if it is within this subscriber booksCheckedOut list
   * @return true if booksCheckedOut contains book, false otherwise
   */
  public boolean isBookInBooksCheckedOut(Book book) {
    return booksCheckedOut.contains(book);
  }

  /**
   * Displays the list of the books checked out and not yet returned
   */
  public void displayBooksCheckedOut() {
    if (booksCheckedOut.isEmpty()) // empty list
      System.out.println("No books checked out by this subscriber");
    else
      // Traverse the list of books checked out by this subscriber and display its content
      for (int i = 0; i < booksCheckedOut.size(); i++) {
        System.out.print("Book ID: " + booksCheckedOut.get(i).getID() + " ");
        System.out.print("Title: " + booksCheckedOut.get(i).getTitle() + " ");
        System.out.println("Author: " + booksCheckedOut.get(i).getAuthor());
      }
  }

  /**
   * Displays the history of the returned books by this subscriber
   */
  public void displayHistoryBooksReturned() {
    if (booksReturned.isEmpty()) // empty list
      System.out.println("No books returned by this subscriber");
    else
      // Traverse the list of borrowed books already returned by this subscriber and display its
      // content
      for (int i = 0; i < booksReturned.size(); i++) {
        System.out.print("Book ID: " + booksReturned.get(i).getID() + " ");
        System.out.print("Title: " + booksReturned.get(i).getTitle() + " ");
        System.out.println("Author: " + booksReturned.get(i).getAuthor());
      }
  }

  /**
   * Displays this subscriber's personal information
   */
  public void displayPersonalInfo() {
    System.out.println("Personal information of the subscriber: " + CARD_BAR_CODE);
    System.out.println("  Name: " + name);
    System.out.println("  Address: " + address);
    System.out.println("  Phone number: " + phoneNumber);
  }

  /*
   * @param: N/A returns a subscribers address
   */
  public String getAddress() {
    // returns a subscribers address
    return address;
  }

  /*
   * @param: N/A sets a subscribers address
   */
  public void setAddress(String address) {
    // sets a subscribers address
    this.address = address;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  /*
   * @param: N/A sets subscribers phone number
   */
  public void setPhoneNumber(String phoneNumber) {
    // sets subscribers phone number
    this.phoneNumber = phoneNumber;
  }

  /*
   * @param: N/A returns a subscribers pin
   */
  public int getPin() {
    // returns a subscribers pin
    return pin;
  }

  /*
   * @param: N/A returns cards bar code
   */
  public Integer getCARD_BAR_CODE() {
    // returns cards bar code
    return CARD_BAR_CODE;
  }

  /*
   * @param: N/A returns subscribers name
   */
  public String getName() {
    // returns subscribers name
    return name;
  }

  /*
   * @param: book enables or denies a subscriber to check out a book
   */
  public void checkoutBook(Book book) {
    // checking if the max number of check outs have been reached
    if (booksCheckedOut.size() == MAX_BOOKS_CHECKED_OUT) {
      System.out.println(
          // error message
          "Checkout Failed: You cannot check out more than " + MAX_BOOKS_CHECKED_OUT + " book.");
    } else if (booksCheckedOut.contains(book)) {
      // checking if the same user has already checked out the same book
      System.out.println("You have already checked out " + book.getTitle() + " book.");
    } else if (!book.isAvailable()) {
      // checking if the book has already been checked out by another subscriber
      System.out.println("Sorry, " + book.getTitle() + " is not available.");
    } else {
      // if the book is available, take the users card code and allow check out
      book.borrowBook(CARD_BAR_CODE);
      booksCheckedOut.add(book);
    }
  }

  /*
   * @param: book makes changes to other methods if a book is returned
   */
  public void returnBook(Book book) {
    // returning book
    book.returnBook();
    // removes the book from the list of checked out books
    booksCheckedOut.remove(book);
    // adds book to the list of returned books
    booksReturned.add(book);

  }

  /*
   * @param: book checks if book is in returned book list
   */
  public boolean isBookInBooksReturned(Book book) {
    // checks if book is in returned book list
    // true if it is, else false
    return booksReturned.contains(book);
  }

  /*
   * @param: name, pin, address, phoneNumber
   */
  public Subscriber(String name, int pin, String address, String phoneNumber) {
    // increments the subscribers code every time code is run
    CARD_BAR_CODE = nextCardBarCode++;
    // sets name
    this.name = name;
    // sets pin
    this.pin = pin;
    // sets phone number
    this.phoneNumber = phoneNumber;
    // sets address
    this.address = address;
    // assigns books checked out to an array list of book
    booksCheckedOut = new ArrayList<Book>();
    // assigns books return out to an array list of book
    booksReturned = new ArrayList<Book>();
  }
}
