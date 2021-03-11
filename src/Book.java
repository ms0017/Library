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

public class Book {

  // class/static fields
  private static int nextId = 1; // class variable that represents the identifier of the next
                                 // book
  // Instance fields
  private final int ID; // unique identifier of this book
  private String author; // name of the author of this book
  private String title; // title of this book
  private Integer borrowerCardBarCode; // card bar code of the borrower of this book
                                       // When borrowerCardBarCode == null, the book is available
                                       // (no one has the book)
  /*
   * @param: title: takes the name of the author
   * 
   * @param: author: takes the title of the book
   * 
   * this constructor sets the names and other items for every new instance of a book created
   */

  public Book(String title, String author) {
    // sets the authors name
    this.author = author;
    // sets the books title
    this.title = title;
    // sets the status of the borrow to null
    borrowerCardBarCode = null;
    // Increments the id
    ID = nextId++;
  }

  /*
   * @param: N/A Method returns the authors name
   */
  public String getAuthor() {
    // returns the authors name
    return author;
  }

  /*
   * @param: N/A method returns the title of a book
   */
  public String getTitle() {
    // returns the title of a book
    return title;
  }

  /*
   * @param: N/A method returns the borrower status
   */
  public Integer getBorrowerCardBarCode() {
    // returns the borrower status
    return borrowerCardBarCode;
  }

  /*
   * @param: N/A method returns the id of a book
   */
  public int getID() {
    // returns the id of a book
    return ID;
  }

  /*
   * @param: ard bar code of the borrower of a specific book method changes the status of the
   * borrowerCardBarCode
   */
  public void borrowBook(Integer borrowerCardBarCode) {
    // changes the status of the borrowerCardBarCode
    this.borrowerCardBarCode = borrowerCardBarCode;
  }

  /*
   * @param: N/A sets borrowerCardBarCode to null
   */
  public void returnBook() {
    // sets borrowerCardBarCode to null when the book is available
    borrowerCardBarCode = null;
  }

  /*
   * @param: N/A method checks the availability of a book
   */
  public boolean isAvailable() {
    // checking the availability of a book
    if (borrowerCardBarCode == null) {
      // returns true if the book is available
      return true;

    } else {
      // returns false if book isn't available
      return false;
    }
  }
}
