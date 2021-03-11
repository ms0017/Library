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

public class Librarian {


  // instance fields
  private String username; // librarian's username
  private String password; // librarian password to have access to this application

  /*
   * @param: N/A returns user name
   */
  public String getUsername() {
    // returns user name
    return username;
  }

  /*
   * @param: password checks if password is correct
   */
  boolean checkPassword(String password) {
    // checks if password is correct
    return this.password.equals(password) ? true : false;
  }

  /*
   * @param: username, password sets user name and password
   */
  public Librarian(String username, String password) {
    // sets user name
    this.username = username;
    // sets password
    this.password = password;
  }

}
