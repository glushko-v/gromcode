package lesson19.HomeWork;

import java.util.Objects;

public class File {
    private long id;
    private String name;
    private String format;
    private long size;

    public File(long id, String name, String format, long size) throws Exception {
        this.id = id;
        this.name = name;
        this.format = format;
        this.size = size;

        char[] syms = name.toCharArray();

        if (syms.length > 9) throw new Exception("Invalid file name. Can not create file " + name);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    public long getSize() {
        return size;
    }

    @Override
    public String toString() {
        return
                "id=" + id;
//                        " name='" + name + '\'' +
//                        " format='" + format + '\'' +
//                        " size=" + size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return id == file.id &&
                Objects.equals(name, file.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }
}
