package com.vaja.java_test.levedb;

import org.fusesource.leveldbjni.JniDBFactory;
import org.iq80.leveldb.DB;
import org.iq80.leveldb.DBIterator;
import org.iq80.leveldb.Options;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class LeveDBTest {
    public static void main(String[] args) throws IOException {
        // 创建数据库
        Options options = new Options();
        options.createIfMissing(true);
        File path = new File("test/leveldb/data");
        if (!path.exists()) {
            path.mkdirs();
        }
        DB db = JniDBFactory.factory.open(path, options);

        // 写入数据
        db.put("key1".getBytes(), "value1".getBytes());
        db.put("key2".getBytes(), "value2".getBytes());
        db.put("key3".getBytes(), "value1".getBytes());
        db.put("key4".getBytes(), "value2".getBytes());
        db.put("key5".getBytes(), "value1".getBytes());
        db.put("key6".getBytes(), "value2".getBytes());


        // 读取数据
        byte[] valueBytes = db.get("key1".getBytes());
        if (valueBytes != null) {
            System.out.println("Value for key1: " + new String(valueBytes));
        }

        // 迭代数据
        try (DBIterator iterator = db.iterator()) {
            for (iterator.seekToFirst(); iterator.hasNext(); iterator.next()) {
                Map.Entry<byte[], byte[]> entry = iterator.peekNext();
                String key = new String(entry.getKey());
                String value = new String(entry.getValue());
                System.out.println("Key: " + key + ", Value: " + value);
            }

        }

        // 关闭数据库
        db.close();
    }
}
