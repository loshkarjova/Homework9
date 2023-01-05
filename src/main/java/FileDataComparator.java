import java.util.Comparator;

public class FileDataComparator implements Comparator<FileData> {
    @Override
    public int compare(FileData o1, FileData o2) {
        return Integer.compare(o1.getSize(),o2.getSize());
    }
}
