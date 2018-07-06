package com.example.student;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import commun_part.CommentAdapter;
import commun_part.CommentBean;
import commun_part.NoTouchLinearLayout;
import commun_part.ReplyBean;
import webservice.Bycomment;
import webservice.Bydeletetcomment;
import webservice.Byreply;
import webservice.Byseecomment;
import webservice.Byseereply;

public class kechengping_Fragment3 extends Fragment{
	
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
    public void onAttach(Activity activity) {
    	
    	Log.i("liujun", "kechengping_Fragment3--onAttach");
    	
        super.onAttach(activity);
     
    }


	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		Log.i("liujun", "kechengping_Fragment3--onCreate");
		
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		Log.i("liujun", "kechengping_Fragment3--onCreateView");
		
		//����Ƭ�ζ�Ӧ�Ĳ����ļ�
		View parentView = inflater.inflate(R.layout.kechengxiangqing_ping, container, false);

		mListData = (ListView) parentView.findViewById(R.id.list_data);
        mLytCommentVG = (LinearLayout) parentView.findViewById(R.id.comment_vg_lyt);
        mLytEdittextVG = (NoTouchLinearLayout) parentView.findViewById(R.id.edit_vg_lyt);
        mCommentEdittext = (EditText) parentView.findViewById(R.id.edit_comment);
        mSendBut = (Button) parentView.findViewById(R.id.but_comment_send);

        ClickListener cl = new ClickListener();
        mSendBut.setOnClickListener(cl);
        mLytCommentVG.setOnClickListener(cl);
        
        kecheng_MainActivity.MyTouchListener myTouchListener = new kecheng_MainActivity.MyTouchListener() {  
            @Override  
            public void onTouchEvent(MotionEvent event) {  
            // 处理手势事件  
            }  
        };  
              
        // 将myTouchListener注册到分发列表  
       ((kecheng_MainActivity)this.getActivity()).registerMyTouchListener(myTouchListener);
       
       adapter = new CommentAdapter(getActivity().getApplicationContext(), getCommentData(), R.layout.comment_item_list, handler);
       mListData.setAdapter(adapter);
		return parentView;
		// return super.onCreateView(, container, savedInstanceState);
	}
	
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
                        mCommentEdittext.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
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

    


    /**
     * 闅愯棌鎴栬�呮樉绀鸿緭鍏ユ
     */
    public boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};

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
            Toast.makeText(getActivity().getApplicationContext(), "您输入的内容为空！", Toast.LENGTH_SHORT).show();
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
    		
			
			Toast.makeText(getActivity().getApplicationContext(), "评论发布成功", Toast.LENGTH_LONG).show();
			
		}
    	else {
    		Toast.makeText(getActivity().getApplicationContext(), "评论发布失败了", Toast.LENGTH_SHORT).show();
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
    		
			
			Toast.makeText(getActivity().getApplicationContext(), "您的评论已删除", Toast.LENGTH_LONG).show();
			
		}
    	else {
    		Toast.makeText(getActivity().getApplicationContext(), "请重新删除", Toast.LENGTH_SHORT).show();
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
    	Toast.makeText(getActivity().getApplicationContext(), time, Toast.LENGTH_LONG).show();
    	String account = ApkEntity.getaccount();
    	String coursename = ApkEntity.getcoursename();
        String strParams = "account1:" + account+"|name:" + account_name+"|account2:" + account2+"|coursename:" + coursename+"|content:" + comment+"|time2:" + time;
		String retString=Byreply.LogSelect(strParams);
		if (retString.equals("1")) {
    		
			
			Toast.makeText(getActivity().getApplicationContext(), "回复添加成功", Toast.LENGTH_LONG).show();
			
		}
    	else {
    		Toast.makeText(getActivity().getApplicationContext(), "回复添加失败", Toast.LENGTH_SHORT).show();
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

    public void onBackPressed() {
        getActivity().onBackPressed();

        if (mLytEdittextVG.getVisibility() == View.VISIBLE) {
            mLytEdittextVG.setVisibility(View.GONE);
            mLytCommentVG.setVisibility(View.VISIBLE);
        }
    }
	

        




	@Override
	public void onDestroy() {
		
		Log.i("liujun", "kechengping_Fragment3--onDestroy");
		
		super.onDestroy();
		
	}


	@Override
	public void onDestroyView() {
		Log.i("liujun", "kechengping_Fragment3--onDestroyView");
		super.onDestroyView();
	}


	@Override
	public void onDetach() {
		Log.i("liujun", "kechengping_Fragment3--onDetach");
		super.onDetach();
	}


	@Override
	public void onStop() {
		Log.i("liujun", "kechengping_Fragment3--onStop");
		
		super.onStop();
	}

}
