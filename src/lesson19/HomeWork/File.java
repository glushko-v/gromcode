package lesson19.HomeWork;

public class File {
    private long id;
    String name;
    String format;
    long size;

    public File(long id, String name, String format, long size) {
        this.id = id;
        this.name = name;
        this.format = format;
        this.size = size;
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
                "id=" + id +
                        " name='" + name + '\'' +
                        " format='" + format + '\'' +
                        " size=" + size;
    }
}
