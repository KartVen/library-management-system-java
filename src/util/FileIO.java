package util;

import model.Library;

public interface FileIO {
    Library read();
    void save(Library library);

    enum FileType{
        SERIAL
    }
}
