package com.luxoft.reflection;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

public class Reflection {

    /**
     * Method creates new object of given class
     *
     * @param clazz Given class
     * @return Object of this class
     */
    public static Object generateNewObject(Class clazz, Object... arguments) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class[] typesOfArguments = {String.class, int.class, String.class};

        Constructor constructor = clazz.getConstructor(typesOfArguments);
        Object newObject = constructor.newInstance(arguments);

        return newObject;
    }

    /**
     * Method takes an object and calls all his methods without parameters
     *
     * @param value Object
     */
    public static List callMethodsWithoutParameters(Object value) throws InvocationTargetException, IllegalAccessException {
        Class clazz = value.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        List result = new ArrayList();
        for (Method method : methods) {
            if(method.getParameterCount() == 0){
                method.setAccessible(true);
                result.add(method.invoke(value).toString());
            }
        }
        return result;
    }

    public static String printMethodsSignaturesWithFinal(Object value){
        Class clazz = value.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if(Modifier.isFinal(method.getModifiers())){
                return method.getName();
            }
        }
        return null;
    }

    public static String printAllPrivateMethods(Class clazz){
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if(Modifier.isPrivate(method.getModifiers())){
                return method.getName();
            }
        }
        return null;
    }

    public static void printAllInterfacesAndParents(Class clazz){
        Class[] interfaces = clazz.getInterfaces();
        Class parentalClass = clazz.getSuperclass();

        System.out.println("Interfaces: ");
        for (Class anInterface : interfaces) {
            System.out.print(anInterface + " ");
        }
        System.out.println("Parental class: " + parentalClass);
    }

    public static void changePrivateArguments(Object value) throws IllegalAccessException {
        Class clazz = value.getClass();
        Field[] fields = clazz.getFields();

        for (Field field : fields) {
            if(Modifier.isPrivate(field.getModifiers())){
                field.setAccessible(true);
                if(field.getType() == String.class){
                    field.set(value, null);
                }
                else if(field.getType() == int.class){
                    field.setInt(value, 0);
                }
                else if(field.getType() == double.class){
                    field.setDouble(value, 0.0);
                }
                else if(field.getType() == float.class){
                    field.setFloat(value, 0.0F);
                }
                else if(field.getType() == long.class){
                    field.setLong(value, 0L);
                }
                else if(field.getType() == short.class){
                    field.setShort(value, (short) 0);
                }
                else if(field.getType() == boolean.class){
                    field.setBoolean(value, false);
                }
                else if(field.getType() == char.class){
                    field.setChar(value, '\u0000');
                }
                else if(field.getType() == byte.class){
                    field.setByte(value, (byte) 0);
                }
            }
        }
    }
}
