package model;

public class Class {
    private int id;
    private String nameClass;

    public Class() {
    }

    public Class(int id, String nameClass) {
        this.id = id;
        this.nameClass = nameClass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", nameClass='" + nameClass + '\'' +
                '}';
    }
}
