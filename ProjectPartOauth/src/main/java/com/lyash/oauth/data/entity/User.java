package com.lyash.oauth.data.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import java.util.Objects;

@Entity
@Table(name = "localusers")
public class User {

    @Id
    private String id;
    private String name;
    private String userpic;
    private String email;
    private String gender;
    private String locale;
    private Role role;

    public User(String id, String name, String userpic, String email,
                String gender, String locale, Role role) {
        this.id = id;
        this.name = name;
        this.userpic = userpic;
        this.email = email;
        this.gender = gender;
        this.locale = locale;
        this.role = role;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserpic() {
        return userpic;
    }

    public void setUserpic(String userpic) {
        this.userpic = userpic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(userpic, user.userpic) &&
                Objects.equals(email, user.email) &&
                Objects.equals(gender, user.gender) &&
                Objects.equals(locale, user.locale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, userpic, email, gender, locale);
    }
}
