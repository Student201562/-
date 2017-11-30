import java.io.*;
import static java.lang.System.*;
/* полезные ссылки https://metanit.com/java/tutorial/6.11.php
                   http://devcolibri.com/1141
*/
public class WorkFile {
    public static void main(String[] args) {
        String pathFile = "C:\\Users\\Kiril\\IdeaProjects\\Example.txt";
        File f = new File(pathFile);

        printFiles(pathFile, f);
        readFile(pathFile);
    }
    public static void printFiles(String pathFile, File f) {
        // Без try нужно будет сделать public static void main(String[] args) throw IOException
        try {
            PrintWriter pw = new PrintWriter(f);

            for (int i = 0; i < 50; i++) {
                pw.println(i);
            }

            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readFile(String pathFile) {
        try {
            FileReader fr = new FileReader(pathFile);
            BufferedReader br = new BufferedReader(fr);

            String dataFromFile;
            while ((dataFromFile = br.readLine()) != null) {
                out.println(dataFromFile);
            }
            br.close();
        } catch (IOException e) {
            out.println("Error!");
        }
    }
}
