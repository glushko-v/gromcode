package lesson19.HomeWork;

import java.util.Arrays;

public class Storage {
    long id;
    File[] files;
    String[] formatsSupported;
    String storageCountry;
    long storageSize;

    public Storage(long id, File[] files, String[] formatsSupported, String storageCountry, long storageSize) {
        this.id = id;
        this.files = files;
        this.formatsSupported = formatsSupported;
        this.storageCountry = storageCountry;
        this.storageSize = storageSize;
    }

    public long getId() {
        return id;
    }

    public File[] getFiles() {
        return files;
    }

    public String[] getFormatsSupported() {
        return formatsSupported;
    }

    public String getStorageCountry() {
        return storageCountry;
    }

    public long getStorageSize() {
        return storageSize;
    }


    @Override
    public String toString() {
        return
                "id=" + id +
                ", files=" + Arrays.toString(files);
    }


}
