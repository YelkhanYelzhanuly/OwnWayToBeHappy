package stazhirovka;

import java.util.Objects;

public class User {

    private int id;
    private String name;
    private String programmingLanguage;
    private String stack;

    public User() {}

    public User(int id, String name, String programmingLanguage, String stack) {
        this.id = id;
        this.name = name;
        this.programmingLanguage = programmingLanguage;
        this.stack = stack;
    }

    public User(String name, String programmingLanguage, String stack) {
        this.name = name;
        this.programmingLanguage = programmingLanguage;
        this.stack = stack;
    }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setProgrammingLanguage(String programmingLanguage) { this.programmingLanguage = programmingLanguage; }
    public void setStack(String stack) { this.stack = stack; }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getProgrammingLanguage() { return programmingLanguage; }
    public String getStack() { return stack; }

    @Override
    public String toString() {
        return id + " | " + name + " (" + programmingLanguage + ", " + stack + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

