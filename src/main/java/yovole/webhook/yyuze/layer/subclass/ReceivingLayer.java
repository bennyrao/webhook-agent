package yovole.webhook.yyuze.layer.subclass;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import yovole.webhook.yyuze.layer.Layer;
import yovole.webhook.yyuze.template.MarkdownTemplate;

@Component
public class ReceivingLayer extends Layer {

    private String convert2Markdown() {
        JSONObject obj = new JSONObject(this.getContent());
        JSONObject issue = obj.getJSONObject("issue");
        JSONObject fields = issue.getJSONObject("fields");

        String key = (String) issue.get("key");
        String summary = (String) fields.get("summary");
        String link = "http://jira.yovole.tech/browse/" + key;
        String statusIcon = (String) fields.getJSONObject("status").get("name");
        String status = (String) fields.getJSONObject("status").get("name");
        String assignee = "";

        if (fields.get("assignee").toString().equals("null")) {
            assignee += (String) fields.getJSONObject("creator").get("key");
        }
        else {
            assignee += (String) fields.getJSONObject("assignee").get("displayName");
        }
        String priority = (String) fields.getJSONObject("priority").get("name");

        MarkdownTemplate template = new MarkdownTemplate();
        template.setKey(key);
        template.setSummary(summary);
        template.setLink(link);
        template.setStatusIcon(statusIcon);
        template.setStatus(status);
        template.setCreator(assignee);
        template.setPriority(priority);

        return template.generateTemplate();
    }

    public String getReceivedContent() {
        return this.convert2Markdown();
    }
}