import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String name;
    private List<Book> borrowedBooks;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        if (book != null && !borrowedBooks.contains(book)) {
            borrowedBooks.add(book);
            System.out.println(name + " has borrowed '" + book.getTitle() + "'.");
        } else if (borrowedBooks.contains(book)) {
            System.out.println(name + " already has '" + book.getTitle() + "'.");
        }
    }

    public void returnBook(Book book) {
        if (book != null && borrowedBooks.remove(book)) {
            System.out.println(name + " has returned '" + book.getTitle() + "'.");
        } else if (book != null) {
            System.out.println(name + " did not borrow '" + book.getTitle() + "'.");
        }
    }

    public void displayBorrowedBooks() {
        System.out.println("Books borrowed by " + name + " (ID: " + userId + "):");
        if (borrowedBooks.isEmpty()) {
            System.out.println("  No books currently borrowed.");
        } else {
            for (Book book : borrowedBooks) {
                System.out.println("  - " + book.getTitle() + " by " + book.getAuthor() + " (ID: " + book.getBookId() + ")");
            }
        }
        System.out.println("--------------------");
    }
    
    public void displayUserDetails() {
        System.out.println("User ID: " + userId);
        System.out.println("Name: " + name);
        System.out.println("Number of borrowed books: " + borrowedBooks.size());
        System.out.println("--------------------");
    }
}