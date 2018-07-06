package commun_part;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2016/5/27.
 */
public class CommentBean {
    private int id;					//璇勮璁板綍ID
    private String commnetAccount;	//璇勮浜鸿处鍙�
    private String commentNickname;	//璇勮浜烘樀绉�
    private String commentTime;		//璇勮鏃堕棿
    private String commentContent;	//璇勮鍐呭
    private String paisenum;

    public String getPaisenum() {
        return paisenum;
    }

    public void setPaisenum(String paisenum) {
        this.paisenum = paisenum;
    }

    private List<ReplyBean> replyList = new ArrayList<ReplyBean>();
    //鍥炲鍐呭鍒楄〃
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCommnetAccount() {
        return commnetAccount;
    }
    public void setCommnetAccount(String commnetAccount) {
        this.commnetAccount = commnetAccount;
    }
    public String getCommentNickname() {
        return commentNickname;
    }
    public void setCommentNickname(String commentNickname) {
        this.commentNickname = commentNickname;
    }
    public String getCommentTime() {
        return commentTime;
    }
    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }
    public String getCommentContent() {
        return commentContent;
    }
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
    public List<ReplyBean> getReplyList() {
        return replyList;
    }
    public void setReplyList(List<ReplyBean> replyList) {
        this.replyList = replyList;
    }

}
