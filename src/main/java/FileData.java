import java.util.Comparator;

public class FileData {
    private String name;
    private int size;
    private String pathToFile;

    public FileData(String name, int size, String pathToFile) {
        this.name = name;
        this.size = size;
        this.pathToFile = pathToFile;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    @Override
    public String toString() {
        return "FileData{" +
               "name='" + name + '\'' +
               ", size=" + size +" bytes"+
               ", pathToFile='" + pathToFile + '\'' +
               '}';
    }
}
