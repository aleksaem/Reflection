package com.luxoft.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Person person = new Person("Sasha", 19, "March 3rd");

        System.out.println("Call methods without arguments: ");
        List result = Reflection.callMethodsWithoutParameters(person);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

        System.out.println("\nPrint all parental classes and interfaces");
        Reflection.printAllInterfacesAndParents(Person.class);

        System.out.println("\nChange all private arguments to their default values");
        Reflection.changePrivateArguments(person);
        System.out.println(person);

    }
}
