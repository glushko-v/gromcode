package lesson29;

import java.util.Objects;

public class File implements Comparable<File> {
    private String filename;
    private long sizeInBytes;

    public File(String filename, long sizeInBytes) {
        this.filename = filename;
        this.sizeInBytes = sizeInBytes;
    }

    public String getFilename() {
        return filename;
    }

    public long getSizeInBytes() {
        return sizeInBytes;
    }

    @Override
    public String toString() {
        return
                filename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return Objects.equals(filename, file.filename);
    }

    @Override
    public int hashCode() {

        return Objects.hash(filename);
    }

    @Override
    public int compareTo(File file) {

        int res = 0;

        if (file.getSizeInBytes() > this.getSizeInBytes()) res = 1;
        else if (file.getSizeInBytes() < this.getSizeInBytes()) res = -1;

        return res;
    }
}
