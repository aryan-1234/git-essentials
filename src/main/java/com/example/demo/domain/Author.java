package com.example.demo.domain;

import javax.persistence.*;
import java.util.Set;
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String firstname;
    private String lastname;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;

    public Author() {
    }

    public Author(String firstname, String lastname, Set<Book> books) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.books = books;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "Id=" + Id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", books=" + books +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return Id == author.Id;
    }

    @Override
    public int hashCode() {
        return (int) (Id ^ (Id >>> 32));
    }
}
