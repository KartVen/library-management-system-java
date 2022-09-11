package util;

import exception.ExportDataException;
import exception.ImportDataException;
import model.Library;

import java.io.*;

public class SerializableFileIO implements FileIO {
    private static final String LIBRARY_FILE_NAME = "Library.obj";

    @Override
    public Library read() {
        try (
                FileInputStream fileInputStream = new FileInputStream(LIBRARY_FILE_NAME);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            return (Library) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            throw new ImportDataException("There is no file to read");
        } catch (IOException e) {
            throw new ImportDataException("Error reading from file");
        } catch (ClassNotFoundException e) {
            throw new ImportDataException("Incompatible data type");
        }
    }

    @Override
    public void save(Library library) {
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(LIBRARY_FILE_NAME);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        ) {
            objectOutputStream.writeObject(library);
        } catch (FileNotFoundException e) {
            throw new ExportDataException("File not found");
        } catch (IOException e) {
            throw new ExportDataException("Error writing to file");
        }
    }
}
