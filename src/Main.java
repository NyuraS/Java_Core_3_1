import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        List<File> foldersList = Arrays.asList(
                new File("E:/Games/temp"),
                new File("E:/Games/src"),
                new File("E:/Games/res"),
                new File("E:/Games/savegames"),
                new File("E:/Games/src/main"),
                new File("E:/Games/src/test"),
                new File("E:/Games/res/drawables"),
                new File("E:/Games/res/vectors"),
                new File("E:/Games/res/icons")
        );

        List<File> filesList = Arrays.asList(
                new File("E:/Games/src/main/Main.java"),
                new File("E:/Games/src/main/Utils.java"),
                new File("E:/Games/temp/temp.txt")
        );

        foldersList.stream().forEach(folders -> {
            if (folders.mkdir()) stringBuilder.append("Каталог " + folders + " создан\n");
            else stringBuilder.append("Каталог " + folders + " не создан\n");
        });

        filesList.stream().forEach(files -> {
            try {
                if (files.createNewFile()) stringBuilder.append("Файл " + files + " создан\n");
                else stringBuilder.append("Файл " + files + " не создан\n");
            } catch (IOException ex) {
                stringBuilder.append(ex.getMessage() + '\n');
            }
        });

        try (FileWriter log = new FileWriter("E:/Games/temp/temp.txt", false)) {
            log.write(stringBuilder.toString());
            log.flush();
        } catch (IOException ex) {
            stringBuilder.append(ex.getMessage() + '\n');
        }

        try (BufferedReader br = new BufferedReader(new FileReader("E:/Games/temp/temp.txt"))) {
            String s;
            while ((s = br.readLine()) != null) System.out.println(s);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}