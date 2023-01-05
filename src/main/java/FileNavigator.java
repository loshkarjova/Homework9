import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileNavigator {
    static HashMap<String, List<FileData>> listOfFiles = new HashMap<>();

    public static void main(String[] args) {
        FileData file1 = new FileData("file1.txt", 125, "/path/to/file/1");
        FileData file2 = new FileData("file2.txt", 68, "/path/to/file/1");
        FileData file3 = new FileData("file3.txt", 15, "/path/to/file/2");

        System.out.println("Test \"add\"");
        add("/path/to/file/1", file1);
        add("/path/to/file/1", file2);
        add("/path/to/file/2", file3);
        System.out.println(listOfFiles);

        System.out.println("\nTest \"find\"");
        System.out.println(find("/path/to/file/1"));

        System.out.println("\nTest \"filterBySize\"");
        System.out.println(filterBySize(100));

        // System.out.println("\nTest \"remove\"");
        // remove("/path/to/file/1");

        System.out.println("\nTest \"sortBySize\"");
        System.out.println(sortBySize(listOfFiles));


    }

    public static void add(String path, FileData file) {
        if (!path.equals(file.getPathToFile())) {
            throw new RuntimeException("Wrong path: " + path + " to file." + file.getPathToFile() + " is waited path.");
        }
        if (listOfFiles.containsKey(file.getPathToFile())) {
            List<FileData> fileData = new LinkedList<>(listOfFiles.get(file.getPathToFile()));
            fileData.add(file);
            listOfFiles.put(file.getPathToFile(), fileData);
        } else {
            listOfFiles.put(path, List.of(file));

        }

    }

    public static List<FileData> find(String path) {
        return listOfFiles.get(path);
    }

    public static List<FileData> filterBySize(int size) {
        List<FileData> sizes = new ArrayList<>();
        for (Map.Entry<String, List<FileData>> entry : listOfFiles.entrySet()) {
            List<FileData> collect = entry.getValue()
                    .stream()
                    .filter(fileDataSize -> fileDataSize.getSize() < size)
                    .collect(Collectors.toList());
            sizes.addAll(collect);
        }
        return sizes;
    }

    public static void remove(String path) {
        listOfFiles.remove(path);
        System.out.println(listOfFiles);

    }

    public static HashMap<String, List<FileData>> sortBySize(HashMap<String, List<FileData>> listOfFiles) {
        for (Map.Entry<String, List<FileData>> entry : listOfFiles.entrySet()) {
            LinkedList<FileData> fileData = new LinkedList<>(entry.getValue());
            fileData.sort(new FileDataComparator());
            listOfFiles.put(entry.getKey(), fileData);
        }
        return listOfFiles;
    }
}
