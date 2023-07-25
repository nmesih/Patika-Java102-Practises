package bookSorter;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Kitapları isme göre sıralamak için TreeSet kullanalım.
        TreeSet<Book> booksByName = new TreeSet<>();
        booksByName.add(new Book("Kaplumbağalar", 300, "Fakir Baykurt", "1965-01-01"));
        booksByName.add(new Book("Kuyucaklı Yusuf", 250, "Sabahattin Ali", "1940-05-15"));
        booksByName.add(new Book("Suç ve Ceza", 400, "Dostoyevski", "1878-03-10"));
        booksByName.add(new Book("Beyaz Diş", 180, "Jack London", "1910-11-30"));
        booksByName.add(new Book("Sefiller", 350, "Victor Hugo", "1840-02-20"));

        System.out.println("Kitaplar isme göre sıralanmış:");
        for (Book book : booksByName) {
            System.out.println(book);
        }

        // Kitapları sayfa sayısına göre sıralamak için TreeSet yerine başka bir yapımız olsun (örn. ArrayList).
        List<Book> books = new ArrayList<>();
        books.add(new Book("Kaplumbağalar", 300, "Fakir Baykurt", "1965-01-01"));
        books.add(new Book("Kuyucaklı Yusuf", 250, "Sabahattin Ali", "1940-05-15"));
        books.add(new Book("Suç ve Ceza", 400, "Dostoyevski", "1878-03-10"));
        books.add(new Book("Beyaz Diş", 180, "Jack London", "1910-11-30"));
        books.add(new Book("Sefiller", 350, "Victor Hugo", "1840-02-20"));

        // Kitapları sayfa sayısına göre sıralamak için Collections.sort() metodunu kullanalım.
        Collections.sort(books, Comparator.comparingInt(Book::getPageCount));

        System.out.println("\nKitaplar sayfa sayısına göre sıralanmış:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

}
