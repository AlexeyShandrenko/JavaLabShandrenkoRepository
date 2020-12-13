package ru.kpfu.itis;

public class User {
    private String firstName;
    private String lastName;
    private boolean isWorker;
    private Long id;

    public User() {
    }

    public User(String firstName, String lastName, boolean isWorker, Long id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isWorker = isWorker;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isWorker() {
        return isWorker;
    }

    public void setWorker(boolean worker) {
        isWorker = worker;
    }
}

