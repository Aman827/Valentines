package datastorage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataStorage {

    String email = "a.mason";
    String path;

    public static void main(String[] args) throws IOException {
        DataStorage bob = new DataStorage();
        bob.Save("h7", "j");
        //bob.Reader();
    }

    private void Save(String message, String WhereMet) throws IOException {
        File mainDir = new File("ValentineList");
        String userEmail = "h.bilg7hl";  // temporary user spot; will be removed in final version, replaced with
        mainDir.mkdir();    // Creates a Main directory named ValentineList

        File studentsValentines = new File(mainDir, email);
        studentsValentines.mkdir();     // creates sub(?) directory inside of the ValentineList Directory, named with the Valentine Recipients' email
        // out.println(studentsValentines.getPath());
        File individVal = new File(studentsValentines, userEmail);
        individVal.mkdir();     // Creates a third folder, inside of the recipient directory, named with the users email
        String userEmailTxt = userEmail + ".txt";     // sets the user's email into text doc. ready form
        File individValText = new File(individVal, userEmailTxt);

        individValText.createNewFile();     //creates a text file with the user's email as the name, inside of the directory named with the recipient's email
        FileWriter fileWriter = new FileWriter(individValText.getPath(), true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);
        printWriter.println(message);       // writes to the Text File
        bufferedWriter.close();     //closes the bufferedWriter
        printWriter.close();        //closes the printWriter
        String usEmImg =  userEmail + ".jpg";
        File imageDir = new File("Images");
        imageDir.mkdir();
        
        File imageEmail = new File(imageDir, usEmImg);
         out.println(imageEmail.getPath());
         
       
        File a = new File(imageEmail.getPath());
        out.println("a     " + a.getPath());
        a.renameTo(new File(individVal.getPath() + "\\" + a.getName()));
        out.println(a.getPath() + "        new a path");
        out.println(individVal.getPath());

        out.println(a.getName() + "      a Name");
        out.println(a.getPath());

    }

    private void Reader() throws IOException {
        String filename = "ValentineList\\" + email;
        File fileRetriever = new File(filename);
        String[] filelist = fileRetriever.list();
        for (int x = 0; x < filelist.length; x++) {
            out.println(filelist[x]);
            File textfileRet = new File(filename + "\\" + filelist[x]);

            String[] inFileList = textfileRet.list();
            out.println(inFileList[x]);
            File file = new File(textfileRet.getPath(), inFileList[x]);
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                //process the line
                System.out.println(line);
            }
            br.close();
        }
    }

}
