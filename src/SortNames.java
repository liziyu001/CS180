import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
/**
 * A program that reads names from a text file, sorts them, then writes them to another text file.
 *
 * <p>Purdue University -- CS18000 -- Summer 2021</p>
 *
 * @author Purdue CS 
 * @version June 14, 2021
 */
public class SortNames {

    public static ArrayList<String> readFile(String filename)
            throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<String>();
        File f = new File(filename);
        FileReader fr = new FileReader(f);
        BufferedReader bfr = new BufferedReader(fr);
        try{
            String line = bfr.readLine();
            while (line != null) {
                list.add(line);
                line = bfr.readLine();
            }
            bfr.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        return list;
    }

    public static void writeFile(String filename, ArrayList<String> names)
            throws FileNotFoundException {
        File f = new File(filename);
        FileOutputStream fos = new FileOutputStream(f, true);
        PrintWriter pw = new PrintWriter(fos);
        for (int i = 0; i < names.size(); i++){
            pw.println(names.get(i));
        }

        pw.close();
    }

    public static void main(String[] args) {
        ArrayList<String> names;
        System.out.println("Enter filename with unsorted names");
        Scanner sc = new Scanner(System.in);
        String filename = sc.nextLine();
        try {
            names = readFile(filename);
            Collections.sort(names);
            writeFile("sorted_names.txt", names);
        } catch (FileNotFoundException e){
            System.out.println("File not found!");
            return;
        }
        System.out.println("Sorted names written to sorted_names.txt");
    }
}