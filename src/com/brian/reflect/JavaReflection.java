package com.brian.reflect;

import java.lang.reflect.*;

public class JavaReflection {
    public static class MockClass {
        private String firstName;
        private String secondName;

        public String getFirstName() {
            return this.firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        @Override
        public String toString() {
            return "MockClass [firstName=" + firstName + ", secondName=" + secondName + "]";
        }
    }

    public static void main(String[] args) throws
            ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            NoSuchMethodException,
            SecurityException,
            IllegalArgumentException,
            InvocationTargetException
    {
        Class c1 = MockClass.class;
        Class c2 = Class.forName("com.brian.reflect.JavaReflection");
        Class c3 = new MockClass().getClass();
        //check that 3 methods obtain same class instance
        System.out.println("Whether T.class is same with Class.forName():"
                + String.valueOf(c1 == c2) + "\n"
                + "Whether Class.forName is same with object.getClass():"
                + String.valueOf(c2 == c3) + "\n"
                + "Whether T.class equals to object.getClass(): "
                + String.valueOf(c1 == c3));
        //using nullary constructor
        MockClass mockClass1 = (MockClass)c1.newInstance();
        //another method, first get Constructor
        Constructor<MockClass> constructor = c1.getConstructor(new Class[]{});
        MockClass mockClass2 = (MockClass)constructor.newInstance(new Object[]{});
        //get Method
        Method[] methods = c1.getDeclaredMethods();
        for(Method method : methods) {
            System.out.println(method.getName());
        }
        //get Field
        Field[] fields = c1.getDeclaredFields();
        for(Field field : fields) {
            System.out.println(field.getName());
        }
        fields[0].setAccessible(true);
        fields[0].set(mockClass2, "Hello");
        fields[1].setAccessible(true);
        fields[1].set(mockClass2, "World!");
        System.out.println(mockClass2.toString());
        //invoke method
        System.out.println(methods[1].invoke(mockClass2, new Object[]{}));
        System.out.println(methods[1].invoke(mockClass1, new Object[]{}));
    }
}
