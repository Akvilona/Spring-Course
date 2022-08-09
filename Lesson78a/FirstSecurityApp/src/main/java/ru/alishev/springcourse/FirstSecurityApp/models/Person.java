/**
 * Создал Андрей Антонов 08.08.2022 17:12
 **/
package ru.alishev.springcourse.FirstSecurityApp.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="Person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 100, message = "Имя должно быть от 2 до 100 символов длинной")
    @Column(name = "username")
    private String username;

    @Min(value = 1900, message = "Год рождения должен быть больше, чем 1900")
    @Column(name = "year_of_birth")
    private int yearOfBirth;

    @Column(name = "password")
    private String password;

    /** пустой конструктор, который нужен для Spring */
    public Person () {
    }

    /** Конструктор по значимым полям */
    public Person(String username, int yearOfBirth) {
        this.username = username;
        this.yearOfBirth = yearOfBirth;
    }

    /** геттеры и сеттеры */
    public int getId() {
        return id;
    }

    /** геттеры и сеттеры */
    public void setId(int id) {
        this.id = id;
    }

    /** геттеры и сеттеры */
    public String getUsername() {
        return username;
    }

    /** геттеры и сеттеры */
    public void setUsername(String username) {
        this.username = username;
    }

    /** геттеры и сеттеры */
    public int getYearOfBirth() {
        return yearOfBirth;
    }

    /** геттеры и сеттеры */
    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    /** геттеры и сеттеры */
    public String getPassword() {
        return password;
    }

    /** геттеры и сеттеры */
    public void setPassword(String password) {
        this.password = password;
    }

    /** для отображения в консоли */
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", password='" + password + '\'' +
                '}';
    }
}
