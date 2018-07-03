package yovole.webhook.yyuze.layer;

import yovole.webhook.yyuze.robot.Robot;

import java.util.HashMap;

public class Layer {

    protected Robot robot;

    public void hireRobot(Robot robot) {
        this.robot = robot;
    }

    public void fireRobot(){
        this.robot = null;
    }

    public String getWebsite(){
        return this.robot.getWebsite();
    }

    public String getURL(){
        return this.robot.getURL();
    }

    public String getContent(){
        return this.robot.getContent();
    }

    public String getToken(){
        return this.robot.getToken();
    }
}
