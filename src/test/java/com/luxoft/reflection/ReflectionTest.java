package com.luxoft.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReflectionTest {

    @Test
    public void testCreatingNewObject() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Person person = new Person("Sasha", 19, "March 3rd");

        Person newPerson = (Person) Reflection.generateNewObject(Person.class, "Sasha", 19, "March 3rd");
        assertEquals(person.toString(), newPerson.toString());
    }

    @Test
    public void testPrintMethodsSignaturesWithFinal() {
        Person person = new Person("Sasha", 19, "March 3rd");


        assertEquals("eat", Reflection.printMethodsSignaturesWithFinal(person));
    }

    @Test
    public void testPrintAllPrivateMethods() {
        assertEquals("getBirthday", Reflection.printAllPrivateMethods(Person.class));
    }
}
