package kr.hs.e_mirim.bomi0324.dongwhapiece;

/**
 * Created by YookyungJung on 2017-11-21.
 */

public class BookItem {
    private int profile;
    private String BookName;
    private String writer;
    private String publisher;
    public int getProfile() {
        return profile;
    }
    public String getBookName() {
        return BookName;
    }
    public String getWriter() { return writer; }
    public String getPublisher() {
        return publisher;
    }
    public BookItem(int profile, String BookName, String writer, String publisher) {
        this.profile=profile;
        this.BookName=BookName;
        this.writer=writer;
        this.publisher=publisher;
    }
}
