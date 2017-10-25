package com.micredis.hibernatemvc.pojo;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull

    @Size(min = 1, max = 100)
    @Column(columnDefinition = "varchar(100)")
    private String title;
    @NotNull
    @Size(min = 1, max = 255)
    @Column(columnDefinition = "varchar(255)")
    private String description;
    @NotNull
    @Size(min = 1, max = 100)
    @Column(columnDefinition = "varchar(100)")
    private String author;
    @NotNull
    @Size(min = 1, max = 20)
    @Column(columnDefinition = "varchar(20)")
    private String isbn;
    @NotNull
    @Max(2017l)
    @Column
    private Integer printYear;
    @Column
    private Boolean readAlready = Boolean.FALSE;

    //for hibernate
    public Book() {
    }

    //for hibernate retrieval operations
    public Book(Long id) {
        this.id = id;
    }

    //for hibernate whole object creation
    public Book(Long id, String title, String description, String author, String isbn, Integer printYear, Boolean readAlready) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.isbn = isbn;
        this.printYear = printYear;
        this.readAlready = readAlready;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getPrintYear() {
        return printYear;
    }

    public void setPrintYear(Integer printYear) {
        this.printYear = printYear;
    }

    public Boolean getReadAlready() {
        return readAlready;
    }

    public void setReadAlready(Boolean readAlready) {
        this.readAlready = readAlready;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(getId(), book.getId()) &&
                Objects.equals(getTitle(), book.getTitle()) &&
                Objects.equals(getDescription(), book.getDescription()) &&
                Objects.equals(getAuthor(), book.getAuthor()) &&
                Objects.equals(getIsbn(), book.getIsbn()) &&
                Objects.equals(getPrintYear(), book.getPrintYear());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getDescription(), getAuthor(), getIsbn(), getPrintYear());
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", printYear=" + printYear +
                ", readAlready=" + readAlready +
                '}';
    }
}
