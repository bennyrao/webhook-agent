package yovole.webhook.yyuze.layer.subclass;

import org.springframework.stereotype.Component;
import yovole.webhook.yyuze.fileAccess.ConfigFileAccess;
import yovole.webhook.yyuze.layer.Layer;


@Component
public class VerifyingLayer extends Layer {

    public boolean getTokenState() {
        String[][] rows = ConfigFileAccess.loadConfigFile();
        String[] tokenPoor = new String[rows.length];
        for (int i = 0; i < rows.length; i++) {
            tokenPoor[i] = rows[i][1];
        }

        String token = this.getToken();
        boolean flag = false;
        if (token != null) {
            for (String i : tokenPoor) {
                if (i.equals(token)) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
}
