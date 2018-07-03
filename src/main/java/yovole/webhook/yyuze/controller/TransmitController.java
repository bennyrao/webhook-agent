package yovole.webhook.yyuze.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yovole.webhook.yyuze.layer.subclass.ReceivingLayer;
import yovole.webhook.yyuze.layer.subclass.TransmitLayer;
import yovole.webhook.yyuze.layer.subclass.VerifyingLayer;
import yovole.webhook.yyuze.robot.Robot;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/jira")
public class TransmitController {

    @Autowired
    private ReceivingLayer receivingLayer;
    @Autowired
    private VerifyingLayer verifyingLayer;
    @Autowired
    private TransmitLayer transmitLayer;

    @RequestMapping("/send")
    public void getData(HttpServletRequest request, @RequestBody String body) {
//    public void transmitJira(HttpServletRequest request) {
//        String body = "{\"timestamp\":1529912106847,\"webhookEvent\":\"jira:issue_updated\",\"user\":{\"self\":\"http://jira.yovole.tech/rest/api/2/user?username=liguo\",\"name\":\"liguo\",\"key\":\"liguo\",\"emailAddress\":\"liguo@yovole.com\",\"avatarUrls\":{\"48x48\":\"http://jira.yovole.tech/secure/useravatar?ownerId=liguo&avatarId=11402\",\"24x24\":\"http://jira.yovole.tech/secure/useravatar?size=small&ownerId=liguo&avatarId=11402\",\"16x16\":\"http://jira.yovole.tech/secure/useravatar?size=xsmall&ownerId=liguo&avatarId=11402\",\"32x32\":\"http://jira.yovole.tech/secure/useravatar?size=medium&ownerId=liguo&avatarId=11402\"},\"displayName\":\"李果\",\"active\":true,\"timeZone\":\"Asia/Shanghai\"},\"issue\":{\"id\":\"24761\",\"self\":\"http://jira.yovole.tech/rest/api/2/issue/24761\",\"key\":\"BF-1704\",\"fields\":{\"customfield_12130\":null,\"fixVersions\":[],\"customfield_10110\":null,\"resolution\":null,\"customfield_10114\":null,\"customfield_12137\":null,\"customfield_12129\":null,\"customfield_10107\":null,\"lastViewed\":\"2018-06-25T15:35:06.809+0800\",\"customfield_12121\":null,\"customfield_12120\":null,\"customfield_12002\":null,\"priority\":{\"self\":\"http://jira.yovole.tech/rest/api/2/priority/1\",\"iconUrl\":\"http://jira.yovole.tech/images/icons/priorities/major.svg\",\"name\":\"P2:High\",\"id\":\"1\"},\"customfield_10100\":null,\"customfield_12004\":null,\"customfield_12125\":null,\"customfield_12127\":null,\"labels\":[],\"customfield_12126\":null,\"customfield_12118\":null,\"customfield_12117\":null,\"customfield_10216\":null,\"customfield_12119\":null,\"timeestimate\":null,\"aggregatetimeoriginalestimate\":null,\"versions\":[],\"issuelinks\":[],\"assignee\":{\"self\":\"http://jira.yovole.tech/rest/api/2/user?username=mayan\",\"name\":\"mayan\",\"key\":\"mayan\",\"emailAddress\":\"mayan@yovole.com\",\"avatarUrls\":{\"48x48\":\"http://jira.yovole.tech/secure/useravatar?avatarId=10338\",\"24x24\":\"http://jira.yovole.tech/secure/useravatar?size=small&avatarId=10338\",\"16x16\":\"http://jira.yovole.tech/secure/useravatar?size=xsmall&avatarId=10338\",\"32x32\":\"http://jira.yovole.tech/secure/useravatar?size=medium&avatarId=10338\"},\"displayName\":\"马琰\",\"active\":true,\"timeZone\":\"Asia/Shanghai\"},\"status\":{\"self\":\"http://jira.yovole.tech/rest/api/2/status/10100\",\"description\":\"\",\"iconUrl\":\"http://jira.yovole.tech/images/icons/statuses/generic.png\",\"name\":\"Engineer Fixed\",\"id\":\"10100\",\"statusCategory\":{\"self\":\"http://jira.yovole.tech/rest/api/2/statuscategory/4\",\"id\":4,\"key\":\"indeterminate\",\"colorName\":\"yellow\",\"name\":\"进行中\"}},\"components\":[],\"customfield_12110\":null,\"customfield_12114\":null,\"customfield_10211\":null,\"customfield_12116\":null,\"customfield_12115\":null,\"customfield_12107\":null,\"customfield_10205\":null,\"customfield_12109\":null,\"customfield_10206\":null,\"customfield_10207\":null,\"aggregatetimeestimate\":null,\"customfield_10208\":null,\"creator\":{\"self\":\"http://jira.yovole.tech/rest/api/2/user?username=mayan\",\"name\":\"mayan\",\"key\":\"mayan\",\"emailAddress\":\"mayan@yovole.com\",\"avatarUrls\":{\"48x48\":\"http://jira.yovole.tech/secure/useravatar?avatarId=10338\",\"24x24\":\"http://jira.yovole.tech/secure/useravatar?size=small&avatarId=10338\",\"16x16\":\"http://jira.yovole.tech/secure/useravatar?size=xsmall&avatarId=10338\",\"32x32\":\"http://jira.yovole.tech/secure/useravatar?size=medium&avatarId=10338\"},\"displayName\":\"马琰\",\"active\":true,\"timeZone\":\"Asia/Shanghai\"},\"subtasks\":[],\"reporter\":{\"self\":\"http://jira.yovole.tech/rest/api/2/user?username=mayan\",\"name\":\"mayan\",\"key\":\"mayan\",\"emailAddress\":\"mayan@yovole.com\",\"avatarUrls\":{\"48x48\":\"http://jira.yovole.tech/secure/useravatar?avatarId=10338\",\"24x24\":\"http://jira.yovole.tech/secure/useravatar?size=small&avatarId=10338\",\"16x16\":\"http://jira.yovole.tech/secure/useravatar?size=xsmall&avatarId=10338\",\"32x32\":\"http://jira.yovole.tech/secure/useravatar?size=medium&avatarId=10338\"},\"displayName\":\"马琰\",\"active\":true,\"timeZone\":\"Asia/Shanghai\"},\"aggregateprogress\":{\"progress\":0,\"total\":0},\"customfield_12103\":null,\"customfield_12102\":null,\"customfield_12105\":null,\"customfield_12501\":null,\"customfield_10202\":0.0,\"customfield_12104\":null,\"customfield_12500\":[],\"progress\":{\"progress\":0,\"total\":0},\"votes\":{\"self\":\"http://jira.yovole.tech/rest/api/2/issue/BF-1704/votes\",\"votes\":0,\"hasVoted\":false},\"worklog\":{\"startAt\":0,\"maxResults\":20,\"total\":0,\"worklogs\":[]},\"issuetype\":{\"self\":\"http://jira.yovole.tech/rest/api/2/issuetype/10104\",\"id\":\"10104\",\"description\":\"测试过程，维护过程发现影响系统运行的缺陷\",\"iconUrl\":\"http://jira.yovole.tech/secure/viewavatar?size=xsmall&avatarId=10303&avatarType=issuetype\",\"name\":\"Defect\",\"subtask\":false,\"avatarId\":10303},\"customfield_12170\":null,\"customfield_12171\":null,\"timespent\":null,\"project\":{\"self\":\"http://jira.yovole.tech/rest/api/2/project/11003\",\"id\":\"11003\",\"key\":\"BF\",\"name\":\"BF: YCloud Bug Fix\",\"avatarUrls\":{\"48x48\":\"http://jira.yovole.tech/secure/projectavatar?pid=11003&avatarId=10201\",\"24x24\":\"http://jira.yovole.tech/secure/projectavatar?size=small&pid=11003&avatarId=10201\",\"16x16\":\"http://jira.yovole.tech/secure/projectavatar?size=xsmall&pid=11003&avatarId=10201\",\"32x32\":\"http://jira.yovole.tech/secure/projectavatar?size=medium&pid=11003&avatarId=10201\"}},\"aggregatetimespent\":null,\"resolutiondate\":null,\"workratio\":-1,\"watches\":{\"self\":\"http://jira.yovole.tech/rest/api/2/issue/BF-1704/watchers\",\"watchCount\":1,\"isWatching\":false},\"customfield_12161\":null,\"customfield_12160\":null,\"customfield_12163\":null,\"created\":\"2018-06-25T11:34:40.000+0800\",\"customfield_12162\":null,\"customfield_12165\":null,\"customfield_12164\":null,\"customfield_12167\":null,\"customfield_12166\":null,\"customfield_12169\":null,\"customfield_12168\":null,\"customfield_11502\":null,\"customfield_11503\":null,\"updated\":\"2018-06-25T15:35:06.842+0800\",\"customfield_12150\":null,\"customfield_12152\":null,\"customfield_12151\":null,\"timeoriginalestimate\":null,\"customfield_12154\":null,\"description\":\"复现步骤：\\r\\n1. YVS， UBP的某一线路的EIP总量为200.\\r\\n2. 备用IP池里对该线路划入10个EIP到生产。\\r\\n3. 检查YVS和UBP里该线路的EIP库存总量。\\r\\n\\r\\n实际结果：\\r\\nYVS更新为210，但UBP里仍为200.\",\"customfield_12153\":null,\"customfield_12156\":null,\"customfield_12155\":null,\"customfield_12157\":null,\"timetracking\":{},\"customfield_12159\":null,\"customfield_10005\":null,\"customfield_12305\":null,\"customfield_12304\":null,\"customfield_12307\":null,\"customfield_12306\":null,\"attachment\":[],\"customfield_10803\":null,\"summary\":\"【OP】备用EIP划入生产池后，UBP EIP库存没有同步YVS库存\",\"customfield_12143\":null,\"customfield_12142\":{\"self\":\"http://jira.yovole.tech/rest/api/2/customFieldOption/10803\",\"value\":\"内测环境\",\"id\":\"10803\"},\"customfield_12145\":{\"self\":\"http://jira.yovole.tech/rest/api/2/customFieldOption/10875\",\"value\":\"P2:High\",\"id\":\"10875\",\"child\":{\"self\":\"http://jira.yovole.tech/rest/api/2/customFieldOption/10883\",\"value\":\"S2:Major\",\"id\":\"10883\"}},\"customfield_10000\":\"0|i02cd3:\",\"customfield_10121\":null,\"customfield_12144\":{\"self\":\"http://jira.yovole.tech/rest/api/2/customFieldOption/10834\",\"value\":\"系统测试\",\"id\":\"10834\",\"child\":{\"self\":\"http://jira.yovole.tech/rest/api/2/customFieldOption/10849\",\"value\":\"功能测试\",\"id\":\"10849\"}},\"customfield_10001\":null,\"customfield_10123\":null,\"customfield_12146\":null,\"customfield_10124\":null,\"customfield_12149\":null,\"customfield_12148\":null,\"customfield_12302\":null,\"customfield_12139\":null,\"environment\":null,\"customfield_11603\":null,\"customfield_11602\":null,\"customfield_10119\":null,\"customfield_11605\":null,\"customfield_11604\":null,\"duedate\":null,\"customfield_11606\":null,\"comment\":{\"startAt\":0,\"maxResults\":0,\"total\":0,\"comments\":[]}}},\"changelog\":{\"id\":\"108329\",\"items\":[{\"field\":\"status\",\"fieldtype\":\"jira\",\"from\":\"10009\",\"fromString\":\"In Progress\",\"to\":\"10100\",\"toString\":\"Engineer Fixed\"},{\"field\":\"assignee\",\"fieldtype\":\"jira\",\"from\":\"liguo\",\"fromString\":\"李果\",\"to\":\"mayan\",\"toString\":\"马琰\"}]}}";

        String website = "http://webhook.yovole.tech";
        String url = "/jira/send";
        String token = request.getParameter("access_token");
        //构造工作机器人
        Robot robot = Robot.createRobot(website, url, token, body);
        //token校验层
        verifyingLayer.hireRobot(robot);
        boolean isPassed = verifyingLayer.getTokenState();
        verifyingLayer.fireRobot();
        if (isPassed) {
            //数据接收层
            receivingLayer.hireRobot(robot);
            String transmitData = receivingLayer.getReceivedContent();
            receivingLayer.fireRobot();
            //转发层
            robot.convert2TransmitRobot(transmitData);
            transmitLayer.hireRobot(robot);
            transmitLayer.transmitContent();
            transmitLayer.fireRobot();
        }
        else {
            System.out.println("token error");
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
