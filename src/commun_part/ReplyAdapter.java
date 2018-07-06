package commun_part;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

import com.zhy.tree_view.R;

/**
 * Created by Admin on 2016/5/27.
 */
public class ReplyAdapter extends BaseAdapter {
    private int resourceId;
    private List<ReplyBean> list;
    private LayoutInflater inflater;
    private TextView replyContent;
    private SpannableString ss;
    private Context context;
    public ReplyAdapter(Context context,List<ReplyBean> list
            ,int resourceId){
        this.list = list;
        this.context = context;
        this.resourceId = resourceId;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ReplyBean bean = list.get(position);
        convertView = inflater.inflate(resourceId, null);
        replyContent = (TextView)
                convertView.findViewById(R.id.replyContent);

        final String replyNickName = bean.getReplyNickname();
        final String commentNickName = bean.getCommentNickname();
        String replyContentStr = bean.getReplyContent();
       
        ss = new SpannableString(replyNickName+"回复   "+commentNickName
                +"："+replyContentStr);
        ss.setSpan(new ForegroundColorSpan(Color.BLUE),0,
                replyNickName.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new ForegroundColorSpan(Color.BLUE),replyNickName.length()+3,
                replyNickName.length()+commentNickName.length()+3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //涓哄洖澶嶇殑浜烘樀绉版坊鍔犵偣鍑讳簨浠�
        ss.setSpan(new TextSpanClick(true), 0,
                replyNickName.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //涓鸿瘎璁虹殑浜虹殑娣诲姞鐐瑰嚮浜嬩欢
        ss.setSpan(new TextSpanClick(false),replyNickName.length()+3,
                replyNickName.length()+commentNickName.length()+3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        replyContent.setText(ss);
        //娣诲姞鐐瑰嚮浜嬩欢鏃讹紝蹇呴』璁剧疆
        replyContent.setMovementMethod(LinkMovementMethod.getInstance());
        return convertView;
    }

    private final class TextSpanClick extends ClickableSpan {
        private boolean status;
        public TextSpanClick(boolean status){
            this.status = status;
        }
        @Override
        public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            ds.setUnderlineText(false);//鍙栨秷涓嬪垝绾�
        }
        @Override
        public void onClick(View v) {
            String msgStr = "";
            if(status){
                msgStr = "鎴戞槸鍥炲鐨勪汉";
            }else{
                msgStr = "鎴戞槸璇勮鐨勪汉";
            }
            Toast.makeText(context, msgStr, Toast.LENGTH_SHORT).show();
        }
    }

    private final class ListItemClick implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        }
    }
}
