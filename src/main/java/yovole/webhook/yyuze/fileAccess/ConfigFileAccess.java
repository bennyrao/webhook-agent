package yovole.webhook.yyuze.fileAccess;

import org.springframework.util.ClassUtils;

import java.io.*;
import java.util.ArrayList;

public class ConfigFileAccess {

    private static String getTokenConfigFilePath() {
        String classPath = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        //String tokenConfigPath = classPath.substring(classPath.indexOf("/", 0), classPath.lastIndexOf("/webhook")) + "/token.conf";//linux测试用
        String tokenConfigPath = classPath.substring(classPath.indexOf("/", 0), classPath.lastIndexOf("/classes")) + "/token.conf";//windows测试用
        return tokenConfigPath;
    }

    public static String[][] loadConfigFile() {
        ArrayList<String> buf = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(ConfigFileAccess.getTokenConfigFilePath())), "UTF-8"));
            String row = reader.readLine();
            while (row != null) {
                buf.add(row);
                row = reader.readLine();
            }
            reader.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[][] result = new String[buf.size()][5];
        int index = 0;
        for (String i : buf) {
            result[index] = i.split(",");
            index++;
        }
        return result;
    }
}
