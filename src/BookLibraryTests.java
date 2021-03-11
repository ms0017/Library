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

public class BookLibraryTests {
  /*
   * @param:
   */
  public static boolean testBookConstructorGetters() {
    // assigning boolean values to be changed by responses of methods
    boolean a = false;
    boolean b = false;
    // creating a new instance of a book
    Book b1 = new Book("CompSci", "Sheriff");
    // borrowing a book
    b1.borrowBook(7475);
    // checking if all credentials match
    if (b1.getAuthor().equals("Sheriff") && b1.getTitle().equals("CompSci")
        && b1.getBorrowerCardBarCode() == 7475 && b1.getID() == 1) {
      // return true if the all pass
      a = true;
    }
    // new instance of a book
    Book b2 = new Book("CompSci", "Sheriff");
    // borrowing a book
    b2.borrowBook(7475);
    // checking if all credentials match
    if (b2.getAuthor().equals("Sheriff") && b2.getTitle().equals("CompSci")
        && b2.getBorrowerCardBarCode() == 7475 && b2.getID() == 2) {
      // return true if the all pass
      b = true;
    }
    // checking if all the tests for this method passed
    if (a == true && b == true) {
      return a;
    }
    return false;
  }

  public static boolean testBookReturnBook() {
    Book b1 = new Book("CompSci", "Sheriff");
    b1.returnBook();
    if (b1.isAvailable() == true) {
      return true;
    } else {
      return false;
    }

  }

  public static boolean testSubscriberCheckoutBook() {
    /*
     * Book b1 = new Book("Me", "You"); if(b1.getBorrowerCardBarCode() != null) { return true; }else
     * { return false; }
     */
    // new instance of a subscriber
    Subscriber s1 = new Subscriber("", 1234, "", "");
    Book b2;
    for (int i = 0; i < 12; i++) {
      b2 = new Book("" + i, "" + i);
      s1.checkoutBook(b2);
      // checking if credentials match
      if (i < 10 && !s1.isBookInBooksCheckedOut(b2)) {
        return false;
        // checking if credentials match
      } else if (i >= 10 && s1.isBookInBooksCheckedOut(b2)) {
        System.out.println(s1.isBookInBooksCheckedOut(b2));
        // return if fail
        return false;
      }
    }

    return true;


  }

  // finds a book
  public static boolean testLibraryFindBookByAuthor() {
    // instance of a book
    Book b1 = new Book("Me", "You");
    if (b1.getAuthor() == "You") {
      // return true or false if test pass or fail respectively
      return true;
    } else {
      return false;
    }

  }

  public static boolean testLibraryFindBookByTitle() {
    // instance of a subscriber
    Book b1 = new Book("Me", "You");
    if (b1.getTitle() == "Me") {
      // return true or false if test pass or fail respectively
      return true;
    } else {
      return false;
    }

  }

  /*
   * @param main method controls tests
   */
  public static void main(String[] args) {
    // evaluating testBookConstructorGetter
    if (testBookConstructorGetters() == true) {
      System.out.println("testBookConstructorGetters passed");
    } else {
      System.out.println("testBookConstructorGetters failed");
    }
    // evaluating testBookReturnBook
    if (testBookReturnBook() == true) {
      System.out.println("testBookReturnBook passed");
    } else {
      System.out.println("testBookReturnBook failed");
    }
    // evaluating testLibraryFindBookByAuthor
    if (testLibraryFindBookByAuthor() == true) {
      System.out.println("testLibraryFindBookByAuthor passed");
    } else {
      System.out.println("testLibraryFindBookByAuthor failed");
    }

    if (testLibraryFindBookByTitle() == true) {
      System.out.println("testLibraryFindBookByTitle passed");
    } else {
      System.out.println("testLibraryFindBookByTitle failed");
    }
    if (testSubscriberCheckoutBook() == true) {
      System.out.println("testSubscriberCheckoutBook passed");
    } else {
      System.out.println("testSubscriberCheckoutBook failed");
    }



  }
}
