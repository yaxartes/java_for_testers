package ru.stqa.mantis.model;

public record User(String name, String email, String password) {
    public User() {
        this("", "", "");
    }

    public User withName(String name) {
        return new User(name, this.email, this.password);
    }

    public User withEmail(String email) {
        return new User(this.name, email, this.password);
    }

    public User withPassword(String password) {
        return new User(this.name, this.email, password);
    }
}
