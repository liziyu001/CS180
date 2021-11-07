
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseCatalog {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("What is the name of the file you want to read from?");
        String[] courses;
        try {
            courses = readFile(s.nextLine());

            String[] processed = new String[courses.length];
            for (int i = 0; i < courses.length; i++) {
                String[] detail = courses[i].split(";");
                String output = "The course " + detail[0] + " is taught by " + detail[1]
                        + " which runs from " + detail[2]
                        + " until " + detail[3] + " in building " + detail[4];
                processed[i] = output;
            }
            System.out.println("The given filename was processed!");
            System.out.println("What is the name of the file you want to read from?");
            String target = s.nextLine();
            try {
                writeFile(processed, target);
                System.out.println("Writing to the file was successful!");
            } catch (IOException e) {
                System.out.println("There was an error when writing to the file!");
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println("The given filename does not exist!");
        }  catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The given filename was not in the right format!");
        } catch (Exception e) {
            System.out.println("There was an undocumented error when reading from the file!");
        }


    }

    public static String[] readFile(String filename) throws Exception {
        ArrayList info = new ArrayList();
        File f = new File(filename);
        FileReader fr = new FileReader(f);
        BufferedReader bfr = new BufferedReader(fr);
        String line = bfr.readLine();
        while (line != null) {
            info.add(line);
            line = bfr.readLine();
        }
        bfr.close();
        String[] courses = new String[info.size()];
        for (int i = 0; i < courses.length; i++) {
            courses[i] = (String) info.get(i);
        }
        return courses;
    }

    public static void writeFile(String[] courses, String filename) throws Exception {
        File f = new File(filename);
        FileOutputStream fos = new FileOutputStream(f, false);
        PrintWriter pr = new PrintWriter(fos);
        for (int i = 0; i < courses.length; i++) {
            pr.println(courses[i]);
        }
        pr.close();
    }
}
