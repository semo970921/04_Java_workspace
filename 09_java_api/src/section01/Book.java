package section01;

import java.util.Objects;

public class Book {

    private long bookNumber; // 책 번호
    private String title; // 제목
    private String author; // 저자
    private int price; // 가격

    public Book(long bookNumber, String title, String author, int price) {
        this.bookNumber = bookNumber;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public long getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(long bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book [" +
                "bookNumber=" + bookNumber +
                ", title='" + title  +
                ", author='" + author +
                ", price=" + price +
                ']';
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)  return true;

        if(obj == null) return false;

        if(this.getClass() != obj.getClass()) return false;

        Book other = (Book) obj;
        if(this.bookNumber != other.bookNumber) return false;
        if(!this.title.equals(other.title)) return false;
        if(!this.author.equals(other.author)) return false;
        if(this.price != other.price) return false;
        return true;
    }

    // =======================================

    @Override
    public int hashCode() {
        return Objects.hash(bookNumber, title, author, price);
    }
}
