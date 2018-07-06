package teacherpart;




import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import livepart.StreamingActivity;
import livepart.livepage;
import webservice.Bychangeicon1;
import webservice.Bychangeteachericon;
import webservice.Bystudentnicheng;
import webservice.Byteachernicheng;

public class teacherpage extends Activity{
	private SlidingMenu mMenu;
	private static final String TAG = "SettingActivity";

    // TODO:: update your rtmp here url
    // private String mStreamKey =
    // "rtmp://push.bcelive.com/live/xxxxxxxxxxxxxxxx";
	String account = ApkEntity.getaccount();
	String organization = ApkEntity.getorganization();
    private String mStreamKey = "rtmp://39.106.182.248:94/live/"+account;

    private LinearLayout mLoadingAnimation = null;


    private Button mStartButton = null;

    private SharedPreferences mSharedPreferences = null;

    private boolean isOritationSwitcherChecked = false;

    // Bitrate related params
    private int mSupportedBitrateValues[] = new int[] { 2000, 1200, 800, 600 };

    // Resolution related params
    private int mSupportedResolutionValues[] = new int[] { 1920, 1080, 1280, 720, 640, 480, 480, 360 };
    private int mSelectedResolutionIndex = 1;

    // Frame rate ralated params
    private int mSupportedFramerateValues[] = new int[] { 18, 15, 15, 15 };

    private Handler mUIEventHandler = null;
    private static final int UI_EVNET_HIDE_LOADING_ANIMATION = 0;
    private static final int UI_EVENT_SHOW_STREAMING_ACTIVITY = 1;
    private static final int UI_EVENT_HINT_NO_STREAMING_URL = 2;

    private long mLastPressBackTime = 0;
    private static final int INTERVAL_OF_TWO_CLICK_TO_QUIT = 1000; // 1 seconde

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		Log.i(TAG, "Calling onCreate()");
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.teacher_homepage);
		mMenu = (SlidingMenu) findViewById(R.id.id_menu1);
		
		sharp.CircleImageView head2 = (sharp.CircleImageView) 
				findViewById(R.id.mine_picture);
		 String account = ApkEntity.getaccount();
		String strParams = "account:" + account;
		String retString=Bychangeicon1.LogSelect(strParams);
		String strURL = retString;
		try {
			Bitmap bitmap = getBitmap(strURL);
			head2.setImageBitmap(bitmap);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TextView teacher_dz = (TextView) findViewById(R.id.t1);
		TextView teacher_zhsx = (TextView) findViewById(R.id.t2);
		TextView teacher_rwgl = (TextView) findViewById(R.id.t3);
		TextView teacher_xinxi = (TextView) findViewById(R.id.teacher_xinxi);
		teacher_xinxi.setText(organization);
		TextView teacher_dang = (TextView) findViewById(R.id.t4);
		
		TextView teacher_sjfx = (TextView) findViewById(R.id.t5);
		Button teacher_xx = (Button) findViewById(R.id.teacher_communion);
		Button teacher_bj = (Button) findViewById(R.id.teacher_bianji);
		
		teacher_dz.setOnClickListener(new Button.OnClickListener() {			
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent();
					intent.setClass(teacherpage.this, teacher_coursemanagement.class);
					startActivity(intent);
					
				}
			});
		String strParams1 = "account:" + account; 
		String retString1=Byteachernicheng.studentRegisterSelect(strParams1);
		((ApkEntity) getApplication()).setaccount_name(retString1);
		TextView mine_name = (TextView) findViewById(R.id.mine_name);
		mine_name.setText(retString1);
		teacher_rwgl.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(teacherpage.this, teacher_task_management.class);
				startActivity(intent);
				
			}
		});
		teacher_dang.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(teacherpage.this, teacher_file_course.class);
				startActivity(intent);
				
			}
		});
		teacher_sjfx.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(teacherpage.this, course_data_analysis.class);
				startActivity(intent);
				
			}
		});
		teacher_zhsx.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(teacherpage.this, comprehensive_training_course.class);
				startActivity(intent);
			
			}
		});
		teacher_xx.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(teacherpage.this, teacher_information.class);
				startActivity(intent);
			}
		});
		teacher_bj.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(teacherpage.this, teacher_setup.class);
				startActivity(intent);
		}
		});	
		
		mSharedPreferences = getApplication().getSharedPreferences("BCELive", Context.MODE_PRIVATE);
       
        initUIHandler();
        initUIElements();
	


	}

	

	public void toggleMenu(View view)
	{
		mMenu.toggle();
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
	
	 @Override
	    public void onBackPressed() {
	        if (System.currentTimeMillis() - mLastPressBackTime < INTERVAL_OF_TWO_CLICK_TO_QUIT) {
	            saveStreamParams();
//	            Intent intent = new Intent();
//	            intent.putExtra("has_logout", false);
//	            setResult(RESULT_OK, intent);
	            finish();
	        } else {
	            Toast.makeText(this, "再次按下返回键将退出应用！", Toast.LENGTH_SHORT).show();
	            mLastPressBackTime = System.currentTimeMillis();
	        }
	    }

	    @Override
	    public void onStart() {
	        Log.i(TAG, "Calling onStart()");
	        super.onStart();
	    }
	    
	    @Override
	    protected void onResume() {
	        Log.i(TAG, "Calling onResume()");
	        super.onResume();
	    }

	    @Override
	    protected void onPause() {
	        Log.i(TAG, "Calling onPause()");
	        super.onPause();
	    }

	    @Override
	    public void onStop() {
	        Log.i(TAG, "Calling onStop()");
	        saveStreamParams();
	        super.onStop();
	    }

	    @Override
	    public void onDestroy() {
	        Log.i(TAG, "Calling onDestroy()");
	        mUIEventHandler.removeCallbacksAndMessages(null);
	        super.onDestroy();
	    }

	    private void initUIElements() {
	        mLoadingAnimation = (LinearLayout) findViewById(R.id.loading_anim);

	        fetchStreamParams();



	        RadioGroup orientationRadioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
	        final RadioButton radioLandscape = (RadioButton) findViewById(R.id.radioLandscape);
	        final RadioButton radioPortrait = (RadioButton) findViewById(R.id.radioPortrait);
	        orientationRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

	            @Override
	            public void onCheckedChanged(RadioGroup group, int checkedId) {
	                if (checkedId == R.id.radioLandscape) {
	                    isOritationSwitcherChecked = true;
	                    radioLandscape.setTextColor(Color.WHITE);
	                    radioPortrait.setTextColor(0xff666666);
	                } else {
	                    isOritationSwitcherChecked = false;
	                    radioLandscape.setTextColor(0xff666666);
	                    radioPortrait.setTextColor(Color.WHITE);
	                }
	            }
	        });
	        if (isOritationSwitcherChecked) {
	            radioLandscape.setChecked(true);
	            radioLandscape.setTextColor(Color.WHITE);
	        } else {
	            radioPortrait.setChecked(true);
	            radioPortrait.setTextColor(Color.WHITE);
	        }

	        RadioGroup resolutionRadioGroup = (RadioGroup) findViewById(R.id.radioGroup0);
	        final RadioButton radio1080P = (RadioButton) findViewById(R.id.radio1080p);
	        final RadioButton radio720P = (RadioButton) findViewById(R.id.radio720p);
	        final RadioButton radio480P = (RadioButton) findViewById(R.id.radio480p);
	        final RadioButton radio360P = (RadioButton) findViewById(R.id.radio360p);
	        resolutionRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

	            @Override
	            public void onCheckedChanged(RadioGroup group, int checkedId) {
	                radio1080P.setTextColor(0xff666666);
	                radio720P.setTextColor(0xff666666);
	                radio480P.setTextColor(0xff666666);
	                radio360P.setTextColor(0xff666666);
	                switch (checkedId) {
	                case R.id.radio1080p:
	                    mSelectedResolutionIndex = 0;
	                    radio1080P.setTextColor(Color.WHITE);
	                    break;
	                case R.id.radio720p:
	                    mSelectedResolutionIndex = 1;
	                    radio720P.setTextColor(Color.WHITE);
	                    break;
	                case R.id.radio480p:
	                    mSelectedResolutionIndex = 2;
	                    radio480P.setTextColor(Color.WHITE);
	                    break;
	                case R.id.radio360p:
	                    mSelectedResolutionIndex = 3;
	                    radio360P.setTextColor(Color.WHITE);
	                    break;
	                }
	            }
	        });

	        switch (mSelectedResolutionIndex) {
	        case 0:
	            radio1080P.setChecked(true);
	            radio1080P.setTextColor(Color.WHITE);
	            break;
	        case 1:
	            radio720P.setChecked(true);
	            radio720P.setTextColor(Color.WHITE);
	            break;
	        case 2:
	            radio480P.setChecked(true);
	            radio480P.setTextColor(Color.WHITE);
	            break;
	        case 3:
	            radio360P.setChecked(true);
	            radio360P.setTextColor(Color.WHITE);
	            break;
	        }

	        mStartButton = (Button) findViewById(R.id.btn_start);
	    }

	    private void initUIHandler() {
	        mUIEventHandler = new Handler() {

	            @Override
	            public void handleMessage(Message msg) {
	                switch (msg.what) {
	                case UI_EVNET_HIDE_LOADING_ANIMATION:
	                    mLoadingAnimation.setVisibility(View.GONE);
	                    mStartButton.setEnabled(true);
	                    break;
	                case UI_EVENT_SHOW_STREAMING_ACTIVITY:
	                	
	                    Intent intent = new Intent(teacherpage.this, StreamingActivity.class);
	                    saveStreamParams();
	                    intent.putExtra("push_url", mStreamKey.trim());
	                    intent.putExtra("res_w", mSupportedResolutionValues[mSelectedResolutionIndex * 2]);
	                    intent.putExtra("res_h", mSupportedResolutionValues[mSelectedResolutionIndex * 2 + 1]);
	                    intent.putExtra("frame_rate", mSupportedFramerateValues[mSelectedResolutionIndex]);
	                    intent.putExtra("bitrate", mSupportedBitrateValues[mSelectedResolutionIndex]);
	                    intent.putExtra("oritation_landscape", isOritationSwitcherChecked);
	                    startActivity(intent);
	                    break;
				       
	                case UI_EVENT_HINT_NO_STREAMING_URL:
	                    mStreamKey = mSharedPreferences.getString("user_avatar", "");
	                    Toast.makeText(teacherpage.this, "未获取到有效的推流地址，已使用上次推流的地址！", Toast.LENGTH_SHORT).show();
	                    mUIEventHandler.sendEmptyMessage(UI_EVENT_SHOW_STREAMING_ACTIVITY);
	                    break;
	                default:
	                    break;
	                }
	                super.handleMessage(msg);
	            }

	        };

	    }

	    public void onClickQuit(View v) {
	        saveStreamParams();
	    }

	    private void fetchStreamParams() {
	        mSelectedResolutionIndex = mSharedPreferences.getInt("resolution", 1);
	        isOritationSwitcherChecked = mSharedPreferences.getBoolean("oritation_landscape", false);
	    }

	    private void saveStreamParams() {
	        Editor editor = mSharedPreferences.edit();
	        editor.putInt("resolution", mSelectedResolutionIndex);
	        editor.putBoolean("oritation_landscape", isOritationSwitcherChecked);
	        editor.commit();
	    }

	    public void onClickStart(View v) {

	        if (!TextUtils.isEmpty(mStreamKey)) {
	            mUIEventHandler.sendEmptyMessage(UI_EVENT_SHOW_STREAMING_ACTIVITY);
	        } else {
	            Toast.makeText(this, "注意：推流地址不能为空！！", Toast.LENGTH_SHORT).show();
	        }
	    }

}