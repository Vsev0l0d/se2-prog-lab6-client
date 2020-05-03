package BasicClasses;

import javax.validation.constraints.*;
import java.io.Serializable;

public class Person implements Serializable {
    @NotNull
    @Size(min = 1)
    private String name; //Строка не может быть пустой, Поле не может быть null
    @Min(0)
    private int height; //Значение поля должно быть больше 0
    @NotNull
    private Color eyeColor; //Поле не может быть null
    @NotNull
    private Color hairColor; //Поле не может быть null
    private Country nationality; //Поле может быть null

    public Person(String name, int height, Color eyeColor, Color hairColor, Country nationality) {
        this.name = name;
        this.height = height;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public Color getEyeColor() {
        return eyeColor;
    }

    public Color getHairColor() {
        return hairColor;
    }

    public Country getNationality() {
        return nationality;
    }

    public int compareValue() {
        return this.name.length() + height;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Person)) {
            return false;
        }

        Person person = (Person) obj;
        return name.equals(person.getName()) &&
                height == person.getHeight() &&
                eyeColor.equals(person.getEyeColor()) &&
                hairColor.equals(person.getHairColor()) &&
                nationality.equals(person.getNationality());
    }
}
