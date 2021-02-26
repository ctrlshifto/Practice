package com.vavr;

import io.vavr.collection.CharSeq;
import io.vavr.collection.Seq;
import io.vavr.control.Validation;

/**
 * @author WhomHim
 * @date Create in 2021/2/26 16:03
 */
public class ValidationTest {
    private static final String VALID_NAME_CHARS = "[a-zA-Z ]";
    private static final int MIN_AGE = 0;

    public Validation<Seq<String>, Person> validatePerson(String name, int age) {
        return Validation.combine(validateName(name), validateAge(age)).ap(Person::new);
    }

    private Validation<String, String> validateName(String name) {
        return CharSeq.of(name).replaceAll(VALID_NAME_CHARS, "").transform(seq -> seq.isEmpty()
                ? Validation.valid(name)
                : Validation.invalid("Name contains invalid characters: '"
                + seq.distinct().sorted() + "'"));
    }

    private Validation<String, Integer> validateAge(int age) {
        return age < MIN_AGE
                ? Validation.invalid("Age must be at least " + MIN_AGE)
                : Validation.valid(age);
    }

    class Person {

        public final String name;
        public final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person(" + name + ", " + age + ")";
        }

    }

    public static void main(String[] args) {
        ValidationTest personValidator = new ValidationTest();

        // Valid(Person(John Doe, 30))
        Validation<Seq<String>, Person> valid = personValidator.validatePerson("John Doe", 30);
        System.out.println(valid.isValid());

        // Invalid(List(Name contains invalid characters: '!4?', Age must be greater than 0))
        Validation<Seq<String>, Person> invalid = personValidator.validatePerson("John? Doe!4", -1);
        System.out.println(invalid.isValid());

    }
}
