package pao.tickets.services;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class FileManager
{
    private static Map<String, FileHandler> instances = new HashMap<String, FileHandler>();

    public static <T>FileHandler instance(Class<T> t) throws IOException {
        FileHandler instance;
        String className = t.getSimpleName();
        if (instances.containsKey(className)) {
            instance = instances.get(className);
        } else {
            instance = new FileHandler(t);
            instances.put(className, instance);
        }

        return instance;
    }

    public static void closeFiles() throws IOException {
        for (FileHandler file : instances.values()) {
            file.closeWriter();
        }
    }

    private FileManager() {

    }


}
