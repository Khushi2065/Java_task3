import java.util.ArrayList;
import java.util.List;
import java.util.Optional; 

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addBook(Book book) {
        Optional<Book> existingBook = books.stream()
                                          .filter(b -> b.getBookId().equals(book.getBookId()))
                                          .findFirst();
        if (existingBook.isPresent()) {
            System.out.println("Error: Book with ID '" + book.getBookId() + "' already exists in the library.");
        } else {
            books.add(book);
            System.out.println("Book '" + book.getTitle() + "' by " + book.getAuthor() + " added to the library.");
        }
    }

    public void registerUser(User user) {
        Optional<User> existingUser = users.stream()
                                          .filter(u -> u.getUserId().equals(user.getUserId()))
                                          .findFirst();
        if (existingUser.isPresent()) {
            System.out.println("Error: User with ID '" + user.getUserId() + "' already registered.");
        } else {
            users.add(user);
            System.out.println("User '" + user.getName() + "' registered successfully.");
        }
    }

    private Optional<Book> findBookById(String bookId) {
        return books.stream()
                    .filter(book -> book.getBookId().equals(bookId))
                    .findFirst();
    }

    private Optional<User> findUserById(String userId) {
        return users.stream()
                    .filter(user -> user.getUserId().equals(userId))
                    .findFirst();
    }

    public void issueBook(String bookId, String userId) {
        Optional<Book> bookOpt = findBookById(bookId);
        Optional<User> userOpt = findUserById(userId);

        if (!bookOpt.isPresent()) {
            System.out.println("Error: Book with ID '" + bookId + "' not found.");
            return;
        }
        if (!userOpt.isPresent()) {
            System.out.println("Error: User with ID '" + userId + "' not found.");
            return;
        }

        Book book = bookOpt.get();
        User user = userOpt.get();

        if (book.isIssued()) {
            System.out.println("Error: Book '" + book.getTitle() + "' is already issued.");
        } else {
            book.setIssued(true);
            user.borrowBook(book); 
            System.out.println("Successfully issued '" + book.getTitle() + "' to " + user.getName() + ".");
        }
    }

    public void returnBook(String bookId, String userId) {
        Optional<Book> bookOpt = findBookById(bookId);
        Optional<User> userOpt = findUserById(userId);

        if (!bookOpt.isPresent()) {
            System.out.println("Error: Book with ID '" + bookId + "' not found.");
            return;
        }
        if (!userOpt.isPresent()) {
            System.out.println("Error: User with ID '" + userId + "' not found.");
            return;
        }

        Book book = bookOpt.get();
        User user = userOpt.get();

        if (!book.isIssued()) {
            System.out.println("Error: Book '" + book.getTitle() + "' is not currently issued.");
        } else if (!user.getBorrowedBooks().contains(book)) {
            System.out.println("Error: Book '" + book.getTitle() + "' was not borrowed by " + user.getName() + ".");
        }
        else {
            book.setIssued(false);
            user.returnBook(book); 
            System.out.println("Successfully returned '" + book.getTitle() + "' from " + user.getName() + ".");
        }
    }

    public void displayAllBooks() {
        System.out.println("\n--- All Books in Library ---");
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        for (Book book : books) {
            book.displayBookDetails();
        }
    }

    public void displayAllUsers() {
        System.out.println("\n--- All Registered Users ---");
        if (users.isEmpty()) {
            System.out.println("No users registered.");
            return;
        }
        for (User user : users) {
            user.displayUserDetails();
        }
    }
}
