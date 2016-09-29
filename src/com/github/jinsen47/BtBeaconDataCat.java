package com.github.jinsen47;

import java.io.*;
import java.util.*;

/**
 * Created by Jinsen on 16/9/27.
 */
public class BtBeaconDataCat {
    public static void main(String[] args) {
        File dir = new File("/Users/Jinsen/Desktop/北京局资产管理基础数据/csv");
        List<String> infa = new LinkedList<>();
        List<String> commu = new LinkedList<>();
        List<String> comp = new LinkedList<>();
        Map<String, Integer> cat = new HashMap<>();
        List<String> all = new LinkedList<>();
        String title = null;
        try {
            for (File f : dir.listFiles()) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
                String temp = null;
                title = reader.readLine();
                while ((temp = reader.readLine()) != null) {
                    all.add(temp);
                }
            }
            File categoryInput = new File(dir.getParentFile(), "category.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(categoryInput)));
            String temp = null;
            while ((temp = reader.readLine()) != null) {
                String name = temp;
                int value = Integer.valueOf(reader.readLine());
                cat.put(name, value);
            }
            for (Map.Entry<String, Integer> s : cat.entrySet()) {
                switch (s.getValue()) {
                    case 0:
                        copyTo(all, infa, s.getKey());
                        break;
                    case 1:
                        copyTo(all, commu, s.getKey());
                        break;
                    case 2:
                        copyTo(all, comp, s.getKey());
                }
            }
            File infaFile = new File(dir, "infa.csv");
            File commuFile = new File(dir, "communication.csv");
            File compFile = new File(dir, "computer.csv");

            create(infaFile);
            create(commuFile);
            create(compFile);

            serialize(infa, title, infaFile);
            serialize(commu, title, commuFile);
            serialize(comp, title, compFile);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void create(File f) throws IOException {
        if (f.exists()) {
            f.delete();
        }
        f.createNewFile();
    }

    public static void copyTo(List<String> source, List<String> target, String name) {
        for (String s: source) {
            if (s.split(",")[2].equals(name)) {
                target.add(s);
            }
        }
    }

    public static void serialize(List<String> source, String title, File dest) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(dest, true));
            writer.append(title);
            for (String s : source) {
                writer.newLine();
                writer.append(s);
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
