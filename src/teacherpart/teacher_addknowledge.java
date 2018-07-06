package teacherpart;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import video.FllScreenVideoView;
import webservice.Bychangecourseicon;
import webservice.Byuppoint;

public class teacher_addknowledge extends Activity{
	
	public  final static int VEDIO_KU = 101;
    private String path;//文件路径
    FllScreenVideoView mVideoView;//原始控件
    private EditText teacher_addknowledgeet1;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.teacher_addknowledge);
		teacher_addknowledgeet1 = (EditText)findViewById(R.id.teacher_addknowledgeet1);
		Button fanhuibt = (Button) findViewById(R.id.teacher_addknowledgerb);
		TextView teacher_addknowledgeet1sc = (TextView) findViewById(R.id.teacher_addknowledgeet1sc);
		TextView teacher_addknowledge2 = (TextView) findViewById(R.id.teacher_addknowledge2);
		fanhuibt.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(teacher_addknowledge.this, teacher_knowledge.class);
				startActivity(intent);
			}
		});
		teacher_addknowledgeet1sc.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				seleteVedio();
			}
		});
		teacher_addknowledge2.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				String coursename = ApkEntity.getcoursename();
				String account = ApkEntity.getaccount();
				String content=teacher_addknowledgeet1.getText().toString();
				String strParams = "account:" + account+"|name:" + coursename+"|content:" +content;
				String retString=Byuppoint.LogSelect(strParams);
                if (retString.equals("1")) {
		    		
					
					Toast.makeText(getApplicationContext(), "知识点添加成功", Toast.LENGTH_LONG).show();
					
				}
		    	else {
		    		Toast.makeText(getApplicationContext(), "知识点添加失败", Toast.LENGTH_SHORT).show();
		    	}
			}
		});
		
		mVideoView = (FllScreenVideoView) findViewById(R.id.videoView);
        mVideoView.setMediaController(new MediaController(this));
//        mVideoView.setVideoURI(uri);
        mVideoView.requestFocus();
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(), "视频播放结束了", 1).show();
            }
        });
	}
	
	 public void seleteVedio() {
	        // TODO 启动相册
	        Intent intent = new Intent();
	        intent.setType("video/*");
	        intent.setAction(Intent.ACTION_GET_CONTENT);
	        intent.addCategory(Intent.CATEGORY_OPENABLE);
	        startActivityForResult(intent,teacher_addknowledge.VEDIO_KU);
	    }
	    private void submitVedio() {
	            final Handler handler = new Handler(this.getMainLooper());
	            final Runnable callBack = new Runnable() {
	                public void run() {
	                    try {
	                        //上传成功处理
	                    } catch (Exception ex) {
	                    }
	                }
	            };
	            final Thread thread = new Thread() {
	                @Override
	                public void run() {
	                    try {
	                        File file = new File(path);
	                        FileInputStream is = null;
	                        // 获取文件大小
	                        long length = file.length();
	                        // 创建一个数据来保存文件数据
	                        byte[] fileData = null;
	                        try {
	                            is = new FileInputStream(file);
	                        } catch (FileNotFoundException e) {
	                            e.printStackTrace();
	                        }
	                        // 读取数据到byte数组中
	                        List<ByteArrayInputStream> temp = new ArrayList<>();
	                        int len = 0;
	                        fileData = new byte[1000 * 1000 * 2];
	                        //断点续传
	                        while ((len = is.read(fileData)) != -1) {
	                            temp = new ArrayList<>();
	                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(fileData);
	                            temp.add(byteArrayInputStream);
	                            //这里是提交数组流到后台
	                            /*RegisterControlService.submitVedioSon(
	                                    SubVedioViewActivity.this, temp, fInfos, subIdx);*/
	                            temp.clear();
	                            byteArrayInputStream.close();
	                        }
	                        if (is != null)
	                            is.close();
	                    } catch (Exception ex) {
	                        System.out.print(ex.toString() + "dujq");
	                        String a = ex + "";
	                    }
	                    handler.post(callBack);
	                }
	            };
	            thread.start();
	    }
	    /**
	     * 选择回调
	     */
	    @Override
	    public void onActivityResult(int requestCode, int resultCode, Intent data) {
	        switch (requestCode) {
	            // TODO 视频
	            case teacher_addknowledge.VEDIO_KU:
	                if (resultCode == Activity.RESULT_OK) {
	                    try {
	                        Uri uri = data.getData();
	                        uri = geturi(this, data);
	                        File file = null;
	                        if (uri.toString().indexOf("file") == 0) {
	                            file = new File(new URI(uri.toString()));
	                            path = file.getPath();
	                        } else {
	                            path = getPath(uri);
	                            file = new File(path);
	                        }
	                        if (!file.exists()) {
	                            break;
	                        }
	                        if (file.length() > 100 * 1024 * 1024) {
//	                            "文件大于100M";
	                            break;
	                        }
	                        //视频播放
	                        mVideoView.setVideoURI(uri);
	                        mVideoView.start();
	                        //开始上传视频，
//	                        submitVedio();
	                    } catch (Exception e) {
	                        String  a=e+"";
	                    } catch (OutOfMemoryError e) {
	                        String  a=e+"";
	                    }
	                }
	                break;
	        }

	    }
	    public static Uri geturi(Context context, android.content.Intent intent) {
	        Uri uri = intent.getData();
	        String type = intent.getType();
	        if (uri.getScheme().equals("file") && (type.contains("image/"))) {
	            String path = uri.getEncodedPath();
	            if (path != null) {
	                path = Uri.decode(path);
	                ContentResolver cr = context.getContentResolver();
	                StringBuffer buff = new StringBuffer();
	                buff.append("(").append(MediaStore.Images.ImageColumns.DATA).append("=")
	                        .append("'" + path + "'").append(")");
	                Cursor cur = cr.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
	                        new String[] { MediaStore.Images.ImageColumns._ID },
	                        buff.toString(), null, null);
	                int index = 0;
	                for (cur.moveToFirst(); !cur.isAfterLast(); cur.moveToNext()) {
	                    index = cur.getColumnIndex(MediaStore.Images.ImageColumns._ID);
	                    // set _id value
	                    index = cur.getInt(index);
	                }
	                if (index == 0) {
	                    // do nothing
	                } else {
	                    Uri uri_temp = Uri
	                            .parse("content://media/external/images/media/"
	                                    + index);
	                    if (uri_temp != null) {
	                        uri = uri_temp;
	                        Log.i("urishi", uri.toString());
	                    }
	                }
	            }
	        }
	        return uri;
	    }
	    private String getPath(Uri uri) {
	        String[] projection = {MediaStore.Video.Media.DATA};
	        Cursor cursor = managedQuery(uri, projection, null, null, null);
	        int column_index = cursor
	                .getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
	        cursor.moveToFirst();
	        return cursor.getString(column_index);
	    }

}

