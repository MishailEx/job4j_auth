package ru.job4j.model;

import java.util.*;


public class EmployeeShow {
    private int id;
    private String name;
    private String surname;
    private int inn;
    private Date date;
    private List<PersonShow> list = new ArrayList<>();

    public List<PersonShow> getList() {
        return list;
    }

    public void setList(List<PersonShow> list) {
        this.list = list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String secondName) {
        this.surname = secondName;
    }

    public int getInn() {
        return inn;
    }

    public void setInn(int inn) {
        this.inn = inn;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EmployeeShow that = (EmployeeShow) o;
        return id == that.id && inn == that.inn && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(date, that.date) && Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, inn, date, list);
    }
}
