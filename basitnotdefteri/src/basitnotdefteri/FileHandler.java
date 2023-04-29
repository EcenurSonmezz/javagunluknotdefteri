import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    private String fileName;

    public FileHandler(String fileName) {
        this.fileName = fileName;
    }

    public void createFile() throws IOException {
        File file = new File(fileName);

        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public void writeFile(String line) throws IOException {
        FileWriter writer = new FileWriter(fileName, true);
        writer.write(line + "\n");
        writer.close();
    }

    public ArrayList<String> readFile() throws IOException {
        ArrayList<String> lines = new ArrayList<>();

        FileReader reader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }

        reader.close();
        bufferedReader.close();

        return lines;
    }
}
