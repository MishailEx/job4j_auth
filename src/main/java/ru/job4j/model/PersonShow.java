package ru.job4j.model;

import ru.job4j.domain.Person;

import java.util.Objects;

public class PersonShow {

    private int id;
    private String login;
    private String password;

    public static PersonShow toPersonShow(Person person) {
        PersonShow personShow = new PersonShow();
        personShow.setId(person.getId());
        personShow.setLogin(person.getLogin());
        personShow.setPassword(person.getPassword());
        return personShow;
    }

    public PersonShow() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PersonShow that = (PersonShow) o;
        return id == that.id && Objects.equals(login, that.login) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password);
    }
}