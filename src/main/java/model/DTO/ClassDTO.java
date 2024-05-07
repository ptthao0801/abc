package model.DTO;

public class ClassDTO {
    private String name;
    private int number;

    public ClassDTO() {
    }

    public ClassDTO(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ClassDTO{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
