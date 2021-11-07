import java.util.ArrayList;
import java.io.*;

/**
 * Store Catalog class
 *
 * <p>Purdue University -- CS18000 -- Summer 2021</p>
 *
 * @author Purdue CS
 * @version June 14, 2021
 */
public class StoreCatalog {
    private ArrayList books = new ArrayList();
    private String fileName = "";

    public StoreCatalog(String fileName) throws FileNotFoundException, BookParseException {
        this.fileName = fileName;
        File f = new File(fileName);
        FileReader fr = new FileReader(f);
        BufferedReader bfr = new BufferedReader(fr);
        try {
            String line = bfr.readLine();
            while (line != null) {

                Book b = parseBook(line);
                this.books.add(b);
                line = bfr.readLine();
            }
            bfr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList getBookList() {
        return books;
    }

    private static Book parseBook(String line) throws BookParseException {
        String[] info = line.split(" ");
        String[] bnamearr = info[0].split("_");
        String[] anamearr = info[1].split("_");
        String bname = "";
        String aname = "";
        for (int i = 0; i < bnamearr.length; i++) {
            bname = bname + bnamearr[i] + " ";
        }
        for (int i = 0; i < anamearr.length; i++) {
            aname = aname + anamearr[i] + " ";
        }
        Book b = new Book(bname.substring(0, bname.length() - 1), aname.substring(0, aname.length() - 1),
                Float.parseFloat(info[2]), Integer.parseInt(info[3]), Integer.parseInt(info[4]));
        return b;
    }

    public ArrayList<Book> searchByName(String bookName) throws BookNotFoundException {
        ArrayList result = new ArrayList();
        for (int i = 0; i < books.size(); i++) {
            Book b = (Book) books.get(i);
            String name = b.getBookName();
            if (name.contains(bookName)) {
                result.add(b);
            }
        }
        return result;
    }

    public java.util.ArrayList<Book> searchByAuthor(java.lang.String authorName) throws BookNotFoundException {
        ArrayList result = new ArrayList();
        for (int i = 0; i < books.size(); i++) {
            Book b = (Book) books.get(i);
            String name = b.getAuthorName();
            if (name.contains(authorName)) {
                result.add(b);
            }
        }
        return result;
    }

    public void purchaseBook(java.lang.String bookName) throws BookNotFoundException {
        for (int i = 0; i < books.size(); i++) {
            if (((Book) books.get(i)).getBookName().equalsIgnoreCase(bookName)) {
                ((Book) books.get(i)).setQuantity(((Book) books.get(i)).getQuantity() - 1);
                if (((Book) books.get(i)).getQuantity() == 0) {
                    books.remove(i);
                }
            }
        }
    }

    public void writeChangesToFile() throws java.io.FileNotFoundException {
        File f = new File(fileName);
        FileOutputStream fos = new FileOutputStream(f, false);
        PrintWriter pr = new PrintWriter(fos);
        for (int i = 0; i < books.size(); i++) {
            String s = "";
            String bname = ((Book) books.get(i)).getBookName().replace(" ", "_");
            String aname = ((Book) books.get(i)).getAuthorName().replace(" ", "_");
            s = s + bname + " " + aname + " " + ((Book) books.get(i)).getPrice() + " "
                    + ((Book) books.get(i)).getQuantity() + " " + ((Book) books.get(i)).getYear();
            pr.println(s);
        }
    }
}
