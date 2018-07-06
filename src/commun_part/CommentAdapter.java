package commun_part;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

/**
 * Created by Admin on 2016/5/27.
 */
public class CommentAdapter extends BaseAdapter {
    private int resourceId;
    private Context context;
    private Handler handler;
    private List<CommentBean> list;
    private LayoutInflater inflater;
    private ViewHolder mholder = null;
    private Map<Integer, Boolean> isVisible;

    private android.view.animation.Animation animation;//鍔ㄧ敾鏁堟灉鐨�

    public CommentAdapter(Context context, List<CommentBean> list
            , int resourceId, Handler handler) {
        this.list = list;
        this.context = context;
        this.handler = handler;
        this.resourceId = resourceId;
        inflater = LayoutInflater.from(context);
        setPaise();
    }

    public void addMap(int id) {
        isVisible.put(id, false);
    }

    private void setPaise() {
        isVisible = new HashMap<Integer, Boolean>();
        for (int i = 0; i < list.size(); i++) {

            addMap(list.get(i).getId());
        }
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        CommentBean bean = list.get(position);
//		ViewHolder mholder = null;
        if (convertView == null) {
            mholder = new ViewHolder();
            convertView = inflater.inflate(resourceId, null);
            mholder.commentNickname = (TextView)
                    convertView.findViewById(R.id.comment_name);
            mholder.commentItemTime = (TextView)
                    convertView.findViewById(R.id.comment_time);
            mholder.commentItemContent = (TextView)
                    convertView.findViewById(R.id.comment_content);
            mholder.replyList = (NoScrollListView)
                    convertView.findViewById(R.id.no_scroll_list_reply);
            mholder.mPraiseText = (TextView)
                    convertView.findViewById(R.id.img_zan_num);
            mholder.replyBut = (Button)
                    convertView.findViewById(R.id.but_comment_reply);
            mholder.mDelect = (Button)
                    convertView.findViewById(R.id.but_comment_delect);

            convertView.setTag(mholder);
        } else {
            mholder = (ViewHolder) convertView.getTag();
        }

        mholder.commentNickname.setText(bean.getCommentNickname());
        mholder.commentItemTime.setText(bean.getCommentTime());
        mholder.commentItemContent.setText(bean.getCommentContent());
        if (isVisible.get(list.get(position).getId())) {
            mholder.mPraiseText.setTextColor(Color.rgb(255, 0, 0));
        } else {
            mholder.mPraiseText.setTextColor(Color.rgb(0, 0, 0));
        }
        String account = ApkEntity.getaccount();
        if(list.get(position).getCommnetAccount().equals(account)){
            mholder.mDelect.setVisibility(View.VISIBLE);
            mholder.replyBut.setVisibility(View.VISIBLE);
        }else {
            mholder.mDelect.setVisibility(View.GONE);
            mholder.replyBut.setVisibility(View.VISIBLE);
        }


        final ReplyAdapter adapter = new ReplyAdapter(context, bean.getReplyList(), R.layout.reply_item);
        mholder.replyList.setAdapter(adapter);
        TextviewClickListener tcl = new TextviewClickListener(position);
        mholder.replyBut.setOnClickListener(tcl);
        mholder.mPraiseText.setOnClickListener(tcl);
        mholder.mDelect.setOnClickListener(tcl);
        return convertView;
    }

    private final class ViewHolder {
        public TextView commentNickname;            //璇勮浜烘樀绉�
        public TextView commentItemTime;            //璇勮鏃堕棿
        public TextView commentItemContent;         //璇勮鍐呭
        public NoScrollListView replyList;          //璇勮鍥炲鍒楄〃
        public TextView mPraiseText;                //鐐硅禐
        public Button replyBut;                     //鍥炲
        public Button mDelect;                      //鍒犻櫎璇勮

    }

    /**
     * 鑾峰彇鍥炲璇勮
     */
    public void getReplyComment(ReplyBean bean, int position) {
        List<ReplyBean> rList = list.get(position).getReplyList();
        rList.add(rList.size(), bean);
    }

    /**
     * 回复名称点击事件
     */
    private final class TextviewClickListener implements View.OnClickListener {
        private int position;

        public TextviewClickListener(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.but_comment_reply:
                    handler.sendMessage(handler.obtainMessage(10, position));
                    break;
                case R.id.lyt_comment_zan:
                    if (isVisible.get(list.get(position).getId())){
                        isVisible.put(list.get(position).getId(), false);
                    }else {
                        isVisible.put(list.get(position).getId(), true);
                    }
                    notifyDataSetChanged();
                    break;
                case R.id.but_comment_delect:
                    handler.sendMessage(handler.obtainMessage(11, position));
                    break;
            }
        }
    }

}