package pao.tickets.services;

import pao.tickets.interfaces.FileHandlerInterface;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

public class FileHandler implements FileHandlerInterface {
    private Class object;
    private FileWriter fileWriter;
    private FileReader fileReader;
    private String fileName;

    @Override
    public void write(Object object) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException {
        Method method = object.getClass().getDeclaredMethod("outputForCSV");
        String data = (String) method.invoke(object);
        fileWriter.append(data);
    }

    public void closeWriter() throws IOException {
        fileWriter.close();
    }

    public void reinitializeWriter() throws IOException {
        this.fileWriter.flush();

//        this.closeWriter();
//        this.fileWriter = new FileWriter(this.fileName, true);
    }

    @Override
    public List<Object> read() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException {
        this.reinitializeWriter();
        List<Object> objects = new java.util.ArrayList<>(Collections.emptyList());
        BufferedReader br = null;
        String line = "";
        String splitter = ",";
        Method method = object.getDeclaredMethod("createNewObject", String.class);

        try {
            br = new BufferedReader(this.fileReader);
            while ((line = br.readLine()) != null) {
//                String[] object_data = line.split(splitter);
                objects.add((Object) method.invoke(object, line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return objects;
    }

    public <T> FileHandler(Class<T> object) throws IOException {
        this.object = object;
        this.fileName = object.getSimpleName() + ".csv";
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        this.fileWriter = new FileWriter(fileName, true);
        this.fileReader = new FileReader(fileName);
    }
}
