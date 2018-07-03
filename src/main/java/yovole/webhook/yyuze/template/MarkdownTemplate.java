package yovole.webhook.yyuze.template;

public class MarkdownTemplate {
    private String template = "{ \"msgtype\": \"markdown\", \"markdown\": {\"title\":\"{$key}\",\"text\": \"" + "#### {$key} / [{$summary}]({$link})\n#### 状态:{$status}\n#### 经办人:{$creator}\n#### 优先级:{$priority}\n" + "\"}}";
    private String key;
    private String summary;
    private String link;
    private String statusIcon;
    private String status;
    private String creator;
    private String priority;

    public void setKey(String key) {
        this.key = key;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setStatusIcon(String statusIcon) {
        this.statusIcon = statusIcon;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String generateTemplate() {
        this.template = this.template.replace("{$key}", this.key);
        this.template = this.template.replace("{$summary}", this.summary);
        this.template = this.template.replace("{$link}", this.link);
        this.template = this.template.replace("{$statusIcon}", this.statusIcon);
        this.template = this.template.replace("{$status}", this.status);
        this.template = this.template.replace("{$creator}", this.creator);
        this.template = this.template.replace("{$priority}", this.priority);
        return this.template;
    }
}
