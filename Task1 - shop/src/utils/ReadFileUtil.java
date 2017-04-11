package utils;

import java.io.*;

/**
 * Created by W510 on 09.04.2017.
 */
public class ReadFileUtil {

    public static String readFileAsString(final File file) throws IOException {
        StringBuilder result = new StringBuilder();

            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(file));
                char[] buf = new char[1024];
                int r = 0;
                while ((r = reader.read(buf)) != -1) {
                    result.append(buf, 0, r);
                }
            }   finally {
                if(reader!=null){
                    reader.close();
                }
            }
        return result.toString();
    }


}
