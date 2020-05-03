package BasicClasses;

import java.io.Serializable;
import javax.validation.constraints.*;

public class Coordinates implements Serializable {
    @NotNull
    @Max(531)
    private Integer x; //Поле не может быть null, Максимальное значение поля: 531
    @Min(-653)
    private float y; //Значение поля должно быть больше -653

    public Coordinates(Integer x, float y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
}
