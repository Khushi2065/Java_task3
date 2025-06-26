public class LibraryManagementSystem {
    public static void main(String[] args) {
        // 1. Create a Library instance
        Library myLibrary = new Library();

        // 2. Add some books to the library with Indian authors
        System.out.println("--- Adding Books by Indian Authors ---");
        Book book1 = new Book("B001", "The Room on the Roof", "Ruskin Bond");
        Book book2 = new Book("B002", "Malgudi Days", "R.K. Narayan");
        Book book3 = new Book("B003", "The God of Small Things", "Arundhati Roy");
        Book book4 = new Book("B004", "Five Point Someone", "Chetan Bhagat");
        Book book5 = new Book("B005", "The Blue Umbrella", "Ruskin Bond");
        Book book6 = new Book("B006", "The Guide", "R.K. Narayan");


        myLibrary.addBook(book1);
        myLibrary.addBook(book2);
        myLibrary.addBook(book3);
        myLibrary.addBook(book4);
        myLibrary.addBook(book5);
        myLibrary.addBook(book6);
        myLibrary.addBook(new Book("B001", "Duplicate Book Attempt", "Some Author")); 

        // 3. Register some users
        System.out.println("\n--- Registering Users ---");
        User user1 = new User("U001", "Priya Sharma");
        User user2 = new User("U002", "Rahul Gupta");
        User user3 = new User("U003", "Ananya Singh");

        myLibrary.registerUser(user1);
        myLibrary.registerUser(user2);
        myLibrary.registerUser(user3);
        myLibrary.registerUser(new User("U001", "Duplicate User Attempt")); 

        // 4. Display initial state
        myLibrary.displayAllBooks();
        myLibrary.displayAllUsers();
        user1.displayBorrowedBooks();

        // 5. Issue some books
        System.out.println("\n--- Issuing Books ---");
        myLibrary.issueBook("B001", "U001"); 
        myLibrary.issueBook("B002", "U001"); 
        myLibrary.issueBook("B003", "U002"); 
        myLibrary.issueBook("B001", "U003"); 
        myLibrary.issueBook("B007", "U001"); 
        myLibrary.issueBook("B001", "U004"); 

        // Display state after issuing
        myLibrary.displayAllBooks();
        user1.displayBorrowedBooks();
        user2.displayBorrowedBooks();
        user3.displayBorrowedBooks();

        // 6. Return some books
        System.out.println("\n--- Returning Books ---");
        myLibrary.returnBook("B001", "U001");
        myLibrary.returnBook("B002", "U002"); 
        myLibrary.returnBook("B004", "U001"); 
        myLibrary.returnBook("B003", "U002"); 

        // Display final state
        myLibrary.displayAllBooks();
        user1.displayBorrowedBooks();
        user2.displayBorrowedBooks();
    }
}
