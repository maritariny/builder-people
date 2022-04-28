
import java.util.OptionalInt;

public class PersonBuilder {

    protected String name;
    protected String surname;
    protected OptionalInt age = OptionalInt.empty();
    protected String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {

        if (age.isPresent() && age.getAsInt() < 0) {
            throw new IllegalArgumentException("Возраст не может быть меньше 0!");
        }

        if (surname == null || surname.equals("")) {
            throw new IllegalStateException("Поле surname не может быть пустым!");
        }
        if (name == null || name.equals("")) {
            throw new IllegalStateException("Поле name не может быть пустым!");
        }

        if (age.isPresent()) {
            Person person = new Person(this.name, this.surname, this.age.getAsInt());
            person.setAddress(this.address);
            return  person;
        } else {
            Person person = new Person(this.name, this.surname);
            person.setAddress(this.address);
            return  person;
        }
    }
}
