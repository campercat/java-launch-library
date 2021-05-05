import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LaunchLibraryRunner {
    public static final String ADD_BOOK_TEXT = "Contribute a book";
    public static final String CHECKOUT_TEXT = "Check out a book";
    public static final String RETURN_BOOK_TEXT = "Return a book";
    public static final String QUIT_TEXT = "Quit";

  public static void main(String[] args) {
  //your code here
    List<String> options = new ArrayList<>();
    options.add(ADD_BOOK_TEXT);
    options.add(CHECKOUT_TEXT);
    options.add(RETURN_BOOK_TEXT);
    options.add(QUIT_TEXT);

    Scanner inputScanner = new Scanner(System.in);
    String menuChoice = "";
    LaunchLibrary library = new LaunchLibrary();

    while(!menuChoice.equals(QUIT_TEXT)) {
      int menuIndex = 1;
      for(String option : options) {
        System.out.println(menuIndex + ". " + option);
        menuIndex++;
      }

      System.out.println("\nWhat would you like to do? Select a number.");
      try {
        int selectedOption = inputScanner.nextInt();
        menuChoice = options.get(selectedOption - 1);

        if(menuChoice.equals(ADD_BOOK_TEXT)) {
          // add logic to contribute a book
          inputScanner.nextLine();
          System.out.println("Please enter the title of the book:");
          String bookTitle = inputScanner.nextLine();
          if(!bookTitle.isBlank()) {
            Book newBook = new Book(bookTitle);
            library.addBook(newBook);
            System.out.println(library.getAvailableBooks().toString());
          }
        }
        else if(menuChoice.equals(CHECKOUT_TEXT)) {
          // add logic to check out a book
          inputScanner.nextLine();
          List<Book> availableBooks = library.getAvailableBooks();
          int bookIndex = 1;
          System.out.println("Currently available books:");
          for (Book book : availableBooks) {
            System.out.println(bookIndex + ". " + book.getTitle());
            bookIndex++;
          }
          System.out.println("Which book would you like to check out? Select a number. ");
          String selection = inputScanner.nextLine();

          if (!selection.isBlank()) {
            int selectedIndex = Integer.parseInt(selection.trim()) - 1;
            library.checkoutBook(selectedIndex);
            List<Book> checkedoutBooks = library.getCheckedoutBooks();
            System.out.println(checkedoutBooks);
          }
        }
        else if(menuChoice.equals(RETURN_BOOK_TEXT)) {
          // add logic to return a book
          inputScanner.nextLine();
          List<Book> checkedoutBooks = library.getCheckedoutBooks();
          int bookIndex = 1;
          if(checkedoutBooks.size() == 0) {
            System.out.println("You don't have any checked out books!");
          } else {
            for (Book book : checkedoutBooks) {
              System.out.println(bookIndex + ". " + book.getTitle());
              bookIndex++;
            }
            System.out.println("Which book would you like to return? Select a number.");
            String selection = inputScanner.nextLine();
            if (!selection.isBlank()) {
              int selectedIndex = Integer.parseInt(selection.trim()) - 1;
              library.returnBook(selectedIndex);
              List<Book> availableBooks = library.getAvailableBooks();
              System.out.println(availableBooks);
            }
          }
        }
      } catch(IndexOutOfBoundsException err) {
        System.out.println("Please make a valid selection!");
      }
    }
  }
}
