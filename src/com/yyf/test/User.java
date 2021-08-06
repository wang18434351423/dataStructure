package com.yyf.test;

import java.util.Objects;

public class User {

    public User(int id, int sex) {
        this.id = id;
        this.sex = sex;
    }

    private int id;
    private int sex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && sex == user.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sex);
    }
}
