import java.util.ArrayList;
import java.util.List;

public class LaunchLibrary {
// A library holds book objects
  // A library has list of available books, and checked out books
  private List<Book> availableBooks = new ArrayList<>();
  private List<Book> checkedoutBooks = new ArrayList<>();

  public void addBook(Book book) {
    this.availableBooks.add(book);
  }

  public void checkoutBook(int bookIndex) {
    // remove the selected book from available books
    // add the book to checked out books
    Book selectedBook = availableBooks.get(bookIndex);
    this.availableBooks.remove(bookIndex);
    this.checkedoutBooks.add(selectedBook);
  }

  public void returnBook(int bookIndex) {
    Book bookToReturn = checkedoutBooks.get(bookIndex);
    this.checkedoutBooks.remove(bookIndex);
    this.availableBooks.add(bookToReturn);
  }

  public List<Book> getAvailableBooks() {
    return this.availableBooks;
  }

  public List<Book> getCheckedoutBooks() {
    return this.checkedoutBooks;
  }
}
