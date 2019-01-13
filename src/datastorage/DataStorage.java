package datastorage;

import java.io.File;
import java.io.IOException;
import static java.lang.System.out;
import java.nio.file.Path;

public class DataStorage {

    public static void main(String[] args) throws IOException {
        String email = "a.mason";
        File mainDir = new File("ValentineList");

        mainDir.mkdir();
        String mainDirPath = mainDir.getPath();
        out.println(mainDirPath);
        File file = new File(mainDir, email);
        file.mkdir();
        

    }

}
