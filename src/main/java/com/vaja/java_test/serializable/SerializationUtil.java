package com.vaja.java_test.serializable;

import java.io.*;

public class SerializationUtil {
    public static void serialize(User user, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static User deserialize(String fileName) {
        User user = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            user = (User) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }

}
