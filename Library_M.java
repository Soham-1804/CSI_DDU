package CSI_DDU;

import java.util.*;

class Book
{
    String title;
    String author;
    // here i can take ID as a INT but i will take it as a String
    // because it is more flexible , suppose i want to add a book
    // with ID as "A123" or "B456"
    String id;
    String status;

    Book(String title, String author, String id)
    {
        this.title = title;
        this.author = author;
        this.id = id;
        //here i am setting the status of the book to available
        //when it is created, so that it can be borrowed later
        this.status = "Available";
    }
}

public class Library_M
{
    //here i am giving fixed size of 100 for the array
    static Book[] books = new Book[100];
    static int count = 0;
    static Scanner obj = new Scanner(System.in);
    public static void main(String[] args)
    {
         while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Display All Books");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            String choice = obj.nextLine();

            switch (choice) {
                case "1":
                    addBook();
                    break;
                case "2":
                    updateBook();
                    break;
                case "3":
                    searchBook();
                    break;
                case "4":
                    issueBook();
                    break;
                case "5":
                    returnBook();
                    break;
                case "6":
                    displayBooks();
                    break;
                case "7":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
     public static Book findBook(String id) {
        for (int i = 0; i < count; i++) {
            // Using equalsIgnoreCase to make the search case-insensitive
            // This allows users to search for books without worrying about case sensitivity
            if (books[i].id.equalsIgnoreCase(id)) {
                return books[i];
            }
        }
        return null;
    }
    public static void addBook() {
        if (count >= books.length) {
            System.out.println("Library is full.");
            return;
        }
        System.out.print("Enter title: ");
        String title = obj.nextLine();
        System.out.print("Enter author: ");
        String author = obj.nextLine();
        System.out.print("Enter book ID: ");
        String id = obj.nextLine();
        //this is the edge case where we check if the book ID already exists
        //if it exists then i will not add the book
        if (findBook(id) != null) {
            System.out.println("Book ID already exists.");
            return;
        }

        books[count] = new Book(title, author, id);
        count++;
        System.out.println("Book added successfully.");
    }
     public static void updateBook() {
        System.out.print("Enter book ID to update: ");
        String id = obj.nextLine();
        //making obj of book class and check if the book exists or not
        //if it exists then i will update the book
        Book book = findBook(id);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        //this is also the edge case where i give feature to update the book
        //title and author, if the user wants to keep the current title or author
        System.out.print("Enter new title (leave empty to keep current): ");
        String newTitle = obj.nextLine();
        System.out.print("Enter new author (leave empty to keep current): ");
        String newAuthor = obj.nextLine();
        //here i am adding the .trim() method to remove any spaces ( i mean any extra spaces )
        if (!newTitle.trim().isEmpty()) {
            book.title = newTitle;
        }
        if (!newAuthor.trim().isEmpty()) {
            book.author = newAuthor;
        }
        //here i am not updating the ID because it is unique and should not be changed
        //if user leave empty block either title or author so it's not going to update , i mean no new title or author 
        System.out.println("Book updated.");
    }
     public static void searchBook() {
        System.out.print("Enter search keyword: ");
        //here i am taking the input from the user and converting it to lower case
        //so that it can be case-insensitive , so it search more accurately
        String keyword = obj.nextLine().toLowerCase();
        boolean found = false;

        for (int i = 0; i < count; i++) {
            Book book = books[i];
            if (book.title.toLowerCase().contains(keyword) ||
                book.author.toLowerCase().contains(keyword) ||
                book.id.toLowerCase().contains(keyword)) {
                System.out.println(book.id + " | " + book.title + " | " + book.author + " | " + book.status);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found.");
        }
    }
     public static void issueBook() {
        System.out.print("Enter book ID to issue: ");
        String id = obj.nextLine();
        Book book = findBook(id);
        //here i am checking if the book exists or not
        //if it exists then i will check if the book is already issued or not

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        if (book.status.equalsIgnoreCase("Issued")) {
            System.out.println("Book is already issued.");
            return;
        }

        book.status = "Issued";
        System.out.println("Book issued.");
    }
     public static void returnBook() {
        System.out.print("Enter book ID to return: ");
        String id = obj.nextLine();
        Book book = findBook(id);
        //here i am trying to implement that if library has more tham one copy of the book , like Book of java ,
        // the library has more than one copy of the book let say 30, so i will try to implement that

        //here i am supposed that the library has only one copy of the book
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        if (book.status.equalsIgnoreCase("Available")) {
            System.out.println("Book was not issued.");
            return;
        }

        book.status = "Available";
        System.out.println("Book returned.");
    }
     public static void displayBooks() {
        if (count == 0) {
            System.out.println("No books in library.");
            return;
        }
        for (int i = 0; i < count; i++) {
            Book b = books[i];
            System.out.println(b.id + " | " + b.title + " | " + b.author + " | " + b.status);
        }
    }
}