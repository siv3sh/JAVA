 import java.util.Scanner;
public class Book {
    int bookid;       
    String title;    
    String author;  

    
 Book(int bookId, String title, String author) {
    this.bookid = bookid;
    this.title = title;
     this.author = author;
 }
    void display() {
        System.out.println("bookid " + bookid);
        System.out.println("title " + title);
        System.out.println("author " + author);
    } } 
class Referencebook extends Book {
    int edition;  
Referencebook(int bookId, String title, String author, int edition) {
        super(bookId, title, author);
        this.edition = edition;
    }
    void display() {
        super.display(); 
        System.out.println("edition" + edition);
    } }

class Fictionbook extends Book {
    String genre;

    Fictionbook(int bookId, String title, String author, String genre) {
        super(bookId, title, author); 
        this.genre = genre;
    }

    void display() {
        super.display(); 
        System.out.println("Genre" + genre);
    } }

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("bookid");
        int rbookId = scanner.nextInt();
        scanner.nextLine();

     System.out.print("title");
        String rtitle = scanner.nextLine();

     System.out.print("author: ");
        String rauthor = scanner.nextLine();

     System.out.print("edition: ");
        int redition = scanner.nextInt();
        scanner.nextLine();

     System.out.print("Genre: ");
        String rgenre = scanner.nextLine();

        Referencebook refBook = new Referencebook(rbookId, rtitle, rauthor, redition);
        System.out.println("\nReference Book Information:");

        refBook.display();

        System.out.println("\n");
         System.out.println("Fiction");
        System.out.print("bookid ");
        int fbookId = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("title");
        String ftitle = scanner.nextLine();

        System.out.print("author");
        String fauthor = scanner.nextLine();

        System.out.print("Genre");
        String fgenre = scanner.nextLine();

        Fictionbook ficBook = new Fictionbook(fbookId, ftitle, fauthor, fgenre);

  ficBook.display();

    scanner.close();
    }}
