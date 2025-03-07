package com.vaja.java_test.serializable;

import static com.vaja.java_test.serializable.SerializationUtil.deserialize;

public class SerialVersionUIDTest {
    public static void main(String[] args) {
        String fileName = "test/serializedUser/user.ser";

        User deserializedUser = deserialize(fileName);
        System.out.println("Name: " + deserializedUser.getName());
    }
}
