package bookSorter;

public class Book implements Comparable<Book>{
    private String bookTitle;
    private int pageCount;
    private String authorName;
    private String publicationDate;

    public Book(String bookTitle, int pageCount, String authorName, String publicationDate) {
        this.bookTitle = bookTitle;
        this.pageCount = pageCount;
        this.authorName = authorName;
        this.publicationDate = publicationDate;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Override
    public int compareTo(Book otherBook) {
        return this.bookTitle.compareTo(otherBook.bookTitle);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookTitle='" + bookTitle + '\'' +
                ", pageCount=" + pageCount +
                ", authorName='" + authorName + '\'' +
                ", publicationDate='" + publicationDate + '\'' +
                '}';
    }
}
