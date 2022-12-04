import java.io.*;

public class FileMerge {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter("file3.txt");

        BufferedReader br1 = new BufferedReader(new FileReader("file1.txt"));
        BufferedReader br2 = new BufferedReader(new FileReader("file2.txt"));

        String file1Line = br1.readLine();
        String file2Line = br2.readLine();

        while (file1Line != null || file2Line != null) {
            try {
                pw.println(file1Line);
                file1Line = br1.readLine();

                pw.println(file2Line);
                file2Line = br2.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        pw.flush();

        br1.close();
        br2.close();
        pw.close();

        System.out.println("Merged file1.txt and file2.txt into file3.txt");
    }
}
