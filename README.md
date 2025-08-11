# CSI_DDU
Library Management System (CMD)<br>
A simple command-line application to manage a library's books.<br>
This project allows you to add, update, search, issue, and return books - all through a menu-driven interface.<br>

Features<br>
Add Book : Enter book details like title, author, and unique ID.
<br>
Update Book : Change the title or author of an existing book.<br>
Search Book : Search by title, author, or ID (case-insensitive).<br>
Issue Book : Mark a book as issued if it's available.<br>
Return Book : Mark a book as available again.<br>
Display All Books : View the complete list of books in the library.<br>
Fixed Array Storage : Uses a simple array to store books.<br>

How It Works<br>
The system stores books in a fixed-size array and keeps track of how many are currently added using a count variable.<br>
It uses case-insensitive comparisons for book IDs and search keywords to make the user experience smoother.<br>

Why Java?<br>
I could have implemented this in C++, but I chose Java because:<br>
Security : Java runs inside the JVM, which provides an extra layer of safety compared to C++ native execution.<br>
Automatic Memory Management → No need to manually allocate or free memory - less chance of memory leaks.<br>
Cross-Platform : Write once, run anywhere with a JVM.<br>
Built-in Libraries : Makes handling strings, input, and other operations simpler.<br>

Example Output<br>
--- Library Menu ---<br>
1. Add Book<br>
2. Update Book<br>
3. Search Book<br>
4. Issue Book<br>
5. Return Book<br>
6. Display All Books<br>
7. Exit<br>
Enter choice: 1<br>
Enter title: Java 2<br>
Enter author: Herbert Schildt<br>
Enter book ID: B101<br>
Book added successfully.<br>

Future Improvements<br>
Allow multiple copies of the same book.<br>
Save data to a file for persistence.<br>
