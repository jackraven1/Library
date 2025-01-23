package se.lexicon.library.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class BookLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate loanDate;
    private LocalDate dueDate;
    private Boolean returned;

    @ManyToOne
    @JoinColumn(name = "borrower_id")
    private AppUser borrower;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    protected BookLoan() {
    }

    public BookLoan(LocalDate loanDate, LocalDate dueDate, Boolean returned, AppUser borrower, Book book) {
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.returned = returned;
        this.borrower = borrower;
        this.book = book;
    }

    public BookLoan(LocalDate loanDate, LocalDate dueDate, Boolean returned) {
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.returned = returned;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public AppUser getBorrower() {
        return borrower;
    }

    public void setBorrower(AppUser borrower) {
        this.borrower = borrower;
    }

    public Boolean getReturned() {
        return returned;
    }

    public void setReturned(Boolean returned) {
        this.returned = returned;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public int getId() {
        return id;
    }
}
