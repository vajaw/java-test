package com.vaja.java_test.serializable;



import static com.vaja.java_test.serializable.SerializationUtil.deserialize;
import static com.vaja.java_test.serializable.SerializationUtil.serialize;

public class SerializationExample {

    public static void main(String[] args) {
        User user = new User();
        user.setName("John Doe");
        user.setAge(30);

        String fileName = "test/serializedUser/user.ser";
        serialize(user, fileName);

        User deserializedUser = deserialize(fileName);
        System.out.println("Name: " + deserializedUser.getName());
        // Age won't be printed because it's marked as transient
    }
}
