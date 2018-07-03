package yovole.webhook.yyuze.robot;


import yovole.webhook.yyuze.fileAccess.ConfigFileAccess;

public class Robot {

    private String website;
    private String url;
    private String token;
    private String content;

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getURL() {
        return url;
    }

    public void setURL(String url) {
        this.url = url;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static Robot createRobot(String website, String url, String token, String content) {
        Robot r = new Robot();
        r.setWebsite(website);
        r.setURL(url);
        r.setToken(token);
        r.setContent(content);
        return r;
    }

    public void convert2TransmitRobot(String transmitContent) {
        this.website = "https://oapi.dingtalk.com";
        this.content = transmitContent;
        String[][] rows = ConfigFileAccess.loadConfigFile();
        for (int i = 0; i < rows.length; i++) {
            if (this.token.equals(rows[i][1])) {
                this.url = rows[i][2];
                this.token = rows[i][3];
                break;
            }
        }
    }


}
