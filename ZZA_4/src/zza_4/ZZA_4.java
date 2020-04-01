
package zza_4;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Properties;
public class ZZA_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String FileName = new File(".").getAbsoluteFile().getParentFile().getAbsolutePath()
                    + System.getProperty("file.separator") + "newXMLDocument.xml";
            Properties p = new Properties();
            File f = new File(FileName);
            if (f.exists() == false) {
                f.createNewFile();
            } else {
                p.loadFromXML(new FileInputStream(FileName));
            }
            final int r = 4;
            final int c = 5;
            int m[][] = new int[r][c];
            int k;

            int Num0 = 0;

            System.out.println("Matrix:");
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    k = (int) Math.round(Math.random() * 9);
                    m[i][j] = k;
                    System.out.print(k + " ");
                }
                System.out.println("");
            }
            System.out.println("");
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    k = m[i][j];

                    if (k == 0) {
                        Num0++;
                    }
                    if (m[i][j] % 2 != 0) {

                        m[i][j] = Num0;
                    } else {

                    }
                }
            }
            System.out.println(Num0);
            System.out.println("");
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    k = m[i][j];
                    System.out.print(k + " ");
                }
                System.out.println("");
            }

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    p.put("m" + i + j, String.valueOf(m[i][j]));
                }
            }
            p.storeToXML(new FileOutputStream(FileName), new Date().toString());

        } catch (Exception e) {
            System.err.println("нет файла XML");
        }
    }
    }
    

