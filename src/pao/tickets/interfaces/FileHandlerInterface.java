package pao.tickets.interfaces;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface FileHandlerInterface<Class> {
    public <T>void write(T object) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException;
    public <T>List<T> read() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException;
}
