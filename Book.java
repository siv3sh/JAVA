import java.util.Scanner;

public class Book {
    private int bookId;
    private String title;
    private String author;

 public Book(int bookId, String title, String author) {
    this.bookId = bookId;
    this.title = title;
    this.author = author;
 }

public void display() {
    System.out.println("Book ID: " + bookId);
    System.out.println("Title: " + title);
    System.out.println("Author: " + author);
    }

static class ReferenceBook extends Book {
        private int edition;

public ReferenceBook(int bookId, String title, String author, int edition) {
    super(bookId, title, author);
    this.edition = edition;
        }

       
    public void display() {
         super.display();

        System.out.println("Edition: " + edition);
        }}

    static class FictionBook extends Book {
    private String genre;

    public FictionBook(int bookId, String title, String author, String genre) {
        super(bookId, title, author);
        this.genre = genre;
        }

      
    public void display() {
         super.display();
        System.out.println("Genre: " + genre);
        } }

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

        
    System.out.println("Enter details for Reference Book:");
    System.out.print("Enter Book ID: ");
    int refBookId = scanner.nextInt();
    scanner.nextLine(); 

    System.out.print("Enter Title: ");
    String refTitle = scanner.nextLine();

    System.out.print("Enter Author: ");
    String refAuthor = scanner.nextLine();

    int refEdition;
        while (true) {
        System.out.print("Enter Edition: ");
        if (scanner.hasNextInt()) 
        {
           refEdition = scanner.nextInt();
           scanner.nextLine(); 
                break;
            } 
            else {

             System.out.println("Invalid input! Please enter a valid integer for Edition.");
            scanner.nextLine(); 
            } }

        ReferenceBook refBook = new ReferenceBook(refBookId, refTitle, refAuthor, refEdition);
        System.out.println("\nReference Book Details:");
        refBook.display();

        System.out.println("\n");

        
        System.out.println("Enter details for Fiction Book:");
        System.out.print("Enter Book ID: ");
        int ficBookId = scanner.nextInt();
        scanner.nextLine(); 

    System.out.print("Enter Title: ");
    String ficTitle = scanner.nextLine();

    System.out.print("Enter Author: ");
    String ficAuthor = scanner.nextLine();

    System.out.print("Enter Genre: ");
    String ficGenre = scanner.nextLine();

    FictionBook ficBook = new FictionBook(ficBookId, ficTitle, ficAuthor, ficGenre);
    System.out.println("\nFiction Book Details:");
    ficBook.display();

    scanner.close();
    } }
