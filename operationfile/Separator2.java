import java.io.*;

public class Separator2 {
    public static void main(String[] args) {
        String folders = "data/save";
        System.out.println("creating folder" + folders);
        File dir = new File(folders);
        System.out.println(dir.getAbsolutePath());
    }
}