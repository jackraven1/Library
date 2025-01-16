package se.lexicon.library.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true, length = 50)
    private String userName;
    @Column(nullable = false, length = 50)
    private String password;
    @Column
    private LocalDate regDate;

    @OneToOne
    @JoinColumn(name = "idda")
    private Details userDetails;

    protected AppUser() {
    }
    public AppUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.regDate = LocalDate.parse(regDate.toString());
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public Details getUserDetails() {
        return userDetails;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public void setUserDetails(Details userDetails) {
        this.userDetails = userDetails;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", regDate=" + regDate +
                ", userDetails=" + userDetails +
                '}';
    }

}
