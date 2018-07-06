package commun_part;
/**
 * Created by Admin on 2016/5/27.
 */
public class ReplyBean {
    private int id;					//鍐呭ID
    private String replyAccount;	//鍥炲浜鸿处鍙�
    private String replyNickname;	//鍥炲浜烘樀绉�
    private String commentAccount;	//琚洖澶嶄汉璐﹀彿
    private String commentNickname;	//琚洖澶嶄汉鏄电О
    private String replyContent;	//鍥炲鐨勫唴瀹�
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getReplyAccount() {
        return replyAccount;
    }
    public void setReplyAccount(String replyAccount) {
        this.replyAccount = replyAccount;
    }
    public String getReplyNickname() {
        return replyNickname;
    }
    public void setReplyNickname(String replyNickname) {
        this.replyNickname = replyNickname;
    }
    public String getCommentAccount() {
        return commentAccount;
    }
    public void setCommentAccount(String commentAccount) {
        this.commentAccount = commentAccount;
    }
    public String getCommentNickname() {
        return commentNickname;
    }
    public void setCommentNickname(String commentNickname) {
        this.commentNickname = commentNickname;
    }
    public String getReplyContent() {
        return replyContent;
    }
    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }
}
