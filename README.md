# CSI_DDU
Library Management System (CMD)
A simple command-line application to manage a library's books.
This project allows you to add, update, search, issue, and return books - all through a menu-driven interface.

Features
Add Book : Enter book details like title, author, and unique ID.
Update Book : Change the title or author of an existing book.
Search Book : Search by title, author, or ID (case-insensitive).
Issue Book : Mark a book as issued if it's available.
Return Book : Mark a book as available again.
Display All Books : View the complete list of books in the library.
Fixed Array Storage : Uses a simple array to store books.

How It Works
The system stores books in a fixed-size array and keeps track of how many are currently added using a count variable.
It uses case-insensitive comparisons for book IDs and search keywords to make the user experience smoother.

Why Java?
I could have implemented this in C++, but I chose Java because:
Security : Java runs inside the JVM, which provides an extra layer of safety compared to C++ native execution.
Automatic Memory Management → No need to manually allocate or free memory - less chance of memory leaks.
Cross-Platform : Write once, run anywhere with a JVM.
Built-in Libraries : Makes handling strings, input, and other operations simpler.

Example Output
--- Library Menu ---
1. Add Book
2. Update Book
3. Search Book
4. Issue Book
5. Return Book
6. Display All Books
7. Exit
Enter choice: 1
Enter title: Java 2
Enter author: Herbert Schildt
Enter book ID: B101
Book added successfully.

Future Improvements
Allow multiple copies of the same book.
Save data to a file for persistence.
