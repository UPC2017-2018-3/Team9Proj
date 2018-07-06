package teacherpart;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import commun_part.CommentAdapter;
import commun_part.CommentBean;
import commun_part.NoTouchLinearLayout;
import commun_part.ReplyBean;
import webservice.Bychangeicon1;
import webservice.Bycomment;
import webservice.Bydeletetcomment;
import webservice.Byreply;
import webservice.Byreturnshixunplan;
import webservice.Bysearchexercise;
import webservice.Byseecomment;
import webservice.Byseereply;

public class teacher_commun_area extends Activity {

    private ListView mListData;
    private LinearLayout mLytCommentVG;
    private NoTouchLinearLayout mLytEdittextVG;
    private EditText mCommentEdittext;
    private Button mSendBut;
    private List<CommentBean> list;
    private CommentAdapter adapter;
    private int count;                    
    private String comment = "";        
    private int position;               
    private boolean isReply;     
    String account_name = ApkEntity.getaccount_name();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_commun_area);
        Button fanhuibt = (Button) findViewById(R.id.commun_arearb);
        sharp.CircleImageView teacher_commun_pic = (sharp.CircleImageView) findViewById(R.id.teacher_commun_pic);
        TextView teacher_commun_name = (TextView) findViewById(R.id.teacher_commun_name);
        TextView teacher_commun_plan = (TextView) findViewById(R.id.teacher_commun_plan);
        
        String account = ApkEntity.getaccount();
    	String coursename = ApkEntity.getcoursename();
    	String strParams = "account:" + account+"|course:" + coursename;
    	List<Byreturnshixunplan> lgroup=Byreturnshixunplan.listGroup(strParams);
    	teacher_commun_name.setText(coursename);
    	for (int i = 0; i < lgroup.size(); i++) {
    	teacher_commun_plan.setText(lgroup.get(i).shixuncontent);
    	String strURL = lgroup.get(i).teacherpicture;
    	
    	try {
			Bitmap bitmap = getBitmap(strURL);
			teacher_commun_pic.setImageBitmap(bitmap);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
    	
		
    	
        fanhuibt.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(teacher_commun_area.this, teacher_course.class);
				startActivity(intent);
			}
		});
        initViews();
        adapter = new CommentAdapter(this, getCommentData(), R.layout.comment_item_list, handler);
        mListData.setAdapter(adapter);
    }

   
    private void initViews() {
        mListData = (ListView) findViewById(R.id.list_data);
        mLytCommentVG = (LinearLayout) findViewById(R.id.comment_vg_lyt);
        mLytEdittextVG = (NoTouchLinearLayout) findViewById(R.id.edit_vg_lyt);
        mCommentEdittext = (EditText) findViewById(R.id.edit_comment);
        mSendBut = (Button) findViewById(R.id.but_comment_send);

        ClickListener cl = new ClickListener();
        mSendBut.setOnClickListener(cl);
        mLytCommentVG.setOnClickListener(cl);

    }

    /**
     * 静态数据
     */

	String coursename = ApkEntity.getcoursename();
	String strParams = "course:" + coursename;
	List<Byseecomment> lgroup=Byseecomment.listGroup(strParams);
    private List<CommentBean> getCommentData() {
        list = new ArrayList<>();
        count = 4;
        for (int i = 0; i < lgroup.size(); i++) {
            CommentBean bean = new CommentBean();
            bean.setId(i);
            bean.setCommentNickname(lgroup.get(i).writername);
            bean.setCommentTime(lgroup.get(i).jiaoliutime);
            bean.setCommnetAccount(lgroup.get(i).jiaoliuwriter);
            bean.setCommentContent(lgroup.get(i).jiaoliutext); 
            
            String strParams = "course:" + coursename;
        	List<Byseereply> lgroup1=Byseereply.listGroup(strParams);
	
            /**
             * 数据库数据添加回复
             */
            List<ReplyBean> replyList = new ArrayList<>();
            for (int j = 0; j < lgroup1.size(); j++) {
            	if(lgroup.get(i).jiaoliutime.equals(lgroup1.get(j).oldtime))
            	{
            	ReplyBean bn = new ReplyBean();
            	bn.setId(j);
            	bn.setCommentNickname(lgroup.get(i).writername);
            	bn.setCommentAccount(lgroup1.get(j).replyrecieve);
            	bn.setReplyNickname(lgroup1.get(j).writername);
            	bn.setReplyContent(lgroup1.get(j).replywriter);
                replyList.add(bn);
            }
            }
            
            
            bean.setReplyList(replyList);
            list.add(bean);
        }
        return list;
    }

    
  
    
    private void onFocusChange(boolean hasFocus) {
        final boolean isFocus = hasFocus;
        (new Handler()).postDelayed(new Runnable() {
            public void run() {
                InputMethodManager imm = (InputMethodManager)
                        mCommentEdittext.getContext().getSystemService(INPUT_METHOD_SERVICE);
                if (isFocus) {
                   
                    mCommentEdittext.requestFocus();
                    imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
                } else {

                    imm.hideSoftInputFromWindow(mCommentEdittext.getWindowToken(), 0);
                    mLytCommentVG.setVisibility(View.VISIBLE);
                    mLytEdittextVG.setVisibility(View.GONE);
                }
            }
        }, 100);
    }

    
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {
                onFocusChange(false);

            }
            return super.dispatchTouchEvent(ev);
        }
        // 蹇呬笉鍙皯锛屽惁鍒欐墍鏈夌殑缁勪欢閮戒笉浼氭湁TouchEvent浜�
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return onTouchEvent(ev);
    }

    /**
     * 闅愯棌鎴栬�呮樉绀鸿緭鍏ユ
     */
    public boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};
            //鑾峰彇杈撳叆妗嗗綋鍓嶇殑location浣嶇疆
            /**
             *杩欏爢鏁板�兼槸绠楁垜鐨勪笅杈硅緭鍏ュ尯鍩熺殑甯冨眬鐨勶紝
             * 瑙勯伩鐐瑰嚮杈撳叆鍖哄煙涔熶細闅愯棌杈撳叆鍖哄煙
             */

            v.getLocationInWindow(leftTop);
            int left = leftTop[0] - 50;
            int top = leftTop[1] - 50;
            int bottom = top + v.getHeight() + 300;
            int right = left + v.getWidth() + 120;
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 鐐瑰嚮鐨勬槸杈撳叆妗嗗尯鍩燂紝淇濈暀鐐瑰嚮EditText鐨勪簨浠�
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 鍒ゆ柇瀵硅瘽妗嗕腑鏄惁杈撳叆鍐呭
     */
    private boolean isEditEmply() {
        comment = mCommentEdittext.getText().toString().trim();
        if (comment.equals("")) {
            Toast.makeText(getApplicationContext(), "您输入的内容为空！", Toast.LENGTH_SHORT).show();
            return false;
        }
       
        mCommentEdittext.setText("");
       
        return true;
    }

    /**
     * 添加评论
     */
    private void publishComment() {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年M月d日 HH/mm/ss ");
        Date curDate = new Date(System.currentTimeMillis());//鑾峰彇褰撳墠鏃堕棿
        String str = formatter.format(curDate);
        
        
        String account = ApkEntity.getaccount();
    	String coursename = ApkEntity.getcoursename();
        String strParams = "account:" + account+"|name:" + account_name+"|coursename:" + coursename+"|content:" + comment+"|time:" + str;
		String retString=Bycomment.LogSelect(strParams);
		if (retString.equals("1")) {
    		
			
			Toast.makeText(getApplicationContext(), "评论发布成功", Toast.LENGTH_LONG).show();
			
		}
    	else {
    		Toast.makeText(getApplicationContext(), "评论发布失败了", Toast.LENGTH_SHORT).show();
    	}

        CommentBean bean = new CommentBean();
        bean.setId(count);
        bean.setCommentNickname(account_name);
        bean.setCommentTime(str);
        bean.setCommnetAccount(account);
        bean.setCommentContent(comment);
        list.add(0, bean);//鍔犺浇鍒發ist鐨勬渶鍓嶉潰
        adapter.addMap(count);
        count++;
        adapter.notifyDataSetChanged();
    }

    private void DelectComment(int postion) {
        
        String account3 =list.get(position).getCommnetAccount();
        String time1 = list.get(position).getCommentTime();
        String strParams = "time:" + time1+"|account:" + account3;
        String retString=Bydeletetcomment.LogSelect(strParams);
		if (retString.equals("1")) {
    		
			
			Toast.makeText(getApplicationContext(), "您的评论已删除", Toast.LENGTH_LONG).show();
			
		}
    	else {
    		Toast.makeText(getApplicationContext(), "请重新删除", Toast.LENGTH_SHORT).show();
    	}
		list.remove(postion);
        adapter.notifyDataSetChanged();
    }


    /**
     * 添加回复
     */
    private void replyComment() {
    	
    	String account2 =list.get(position).getCommnetAccount();
    	String time = list.get(position).getCommentTime();
    	Toast.makeText(getApplicationContext(), time, Toast.LENGTH_LONG).show();
    	String account = ApkEntity.getaccount();
    	String coursename = ApkEntity.getcoursename();
        String strParams = "account1:" + account+"|name:" + account_name+"|account2:" + account2+"|coursename:" + coursename+"|content:" + comment+"|time2:" + time;
		String retString=Byreply.LogSelect(strParams);
		if (retString.equals("1")) {
    		
			
			Toast.makeText(getApplicationContext(), "回复添加成功", Toast.LENGTH_LONG).show();
			
		}
    	else {
    		Toast.makeText(getApplicationContext(), "回复添加失败", Toast.LENGTH_SHORT).show();
    	}
    	
    	
        ReplyBean bean = new ReplyBean();
        bean.setId(count + 10);
        bean.setCommentNickname(list.get(position).getCommentNickname());
        bean.setReplyNickname("回复者");
        bean.setReplyContent(comment);
        adapter.getReplyComment(bean, position);
        adapter.notifyDataSetChanged();
    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case 10:
                    isReply = true;
                    position = (Integer) msg.obj;
                    mLytCommentVG.setVisibility(View.GONE);
                    mLytEdittextVG.setVisibility(View.VISIBLE);
                    onFocusChange(true);
                    break;
                case 11:
                    isReply = false;
                    position = (Integer)msg.obj;
                    DelectComment(position);
                    break;

            }

        }
    };

    /**
     * 浜嬩欢鐐瑰嚮鐩戝惉鍣�
     */
    private final class ClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.but_comment_send:        //鍙戣〃璇勮鎸夐挳
                    if (isEditEmply()) {        //鍒ゆ柇鐢ㄦ埛鏄惁杈撳叆鍐呭
                        if (isReply) {
                            replyComment();
                        } else {
                            publishComment();
                           
                        }
                        mLytCommentVG.setVisibility(View.VISIBLE);
                        mLytEdittextVG.setVisibility(View.GONE);
                        onFocusChange(false);
                    }
                    break;
                case R.id.comment_vg_lyt:        //搴曢儴璇勮鎸夐挳
                    isReply = false;
                    mLytEdittextVG.setVisibility(View.VISIBLE);
                    mLytCommentVG.setVisibility(View.GONE);
                    onFocusChange(true);
                    break;
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //鍒ゆ柇鎺т欢鏄惁鏄剧ず
        if (mLytEdittextVG.getVisibility() == View.VISIBLE) {
            mLytEdittextVG.setVisibility(View.GONE);
            mLytCommentVG.setVisibility(View.VISIBLE);
        }
    }
    
    public Bitmap getBitmap(String path) throws IOException {
		try {
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setRequestMethod("GET");
			if (conn.getResponseCode() == 200) {
				InputStream inputStream = conn.getInputStream();
				Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
				return bitmap;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}

