package org.launchcode.techjobs.oo;
import java.util.Objects;
public class JobField {
    private int id;
    private static int nextId = 1;
    private String value;
    public JobField() {
        id=nextId;
        nextId++;
    }
    public JobField(String value) {
        this();
        this.value = value;
    }
    //Getter and setterssss


    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    @Override
    public boolean equals(Object o) {
        if (this ==o) return true;
        if(!(o instanceof JobField)) return false;
        JobField jobField = (JobField) o;
        return Objects.equals(value,jobField.value);

    }
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
