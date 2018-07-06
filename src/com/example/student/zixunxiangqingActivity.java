package com.example.student;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import webservice.Byzixuncontent;
import webservice.Byzixunlist;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class zixunxiangqingActivity extends Activity{
	String strURL;
	ArrayList<ApkEntity> apk_list;
	ApkEntity entity = new ApkEntity();
	String organization = ApkEntity.getorganization();
	protected void onCreate(Bundle savedInstanceState) {
		
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zixunxiangqing); 
        
//        showData();
//        showList(apk_list);
        String theme = ApkEntity.gettheme();
    	String strParams = "organization:" + organization+ "|title:" + theme;
    	List<Byzixuncontent> lgroup=Byzixuncontent.listGroup(strParams);
    	for (int i = 0; i < lgroup.size(); i++) {
			
			TextView tv1_zixunxiangqing=(TextView) findViewById(R.id.tv1_zixunxiangqing);
	        ImageView img_zixunxiangqing=(ImageView) findViewById(R.id.img_zixunxiangqing);
	        TextView tv3_zixunxiangqing=(TextView) findViewById(R.id.tv3_zixunxiangqing);
	        TextView tv4_zixunxiangqing=(TextView) findViewById(R.id.tv4_zixunxiangqing);
			tv1_zixunxiangqing.setText(lgroup.get(i).zixuntitle);
	  		tv3_zixunxiangqing.setText(lgroup.get(i).zixunorganization);
	  		tv4_zixunxiangqing.setText(lgroup.get(i).zixuntext); 	  		
	  		strURL=lgroup.get(i).zixunpicture;
	  		
	  		try {
				Bitmap bitmap = getBitmap(strURL);
				img_zixunxiangqing.setImageBitmap(bitmap);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  		
		}
    
    	
     		
        Button zixunxiangqing_backw = (Button)findViewById(R.id.zixunxiangqing_backw);        
        zixunxiangqing_backw.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub				
				Intent intent = new Intent();  
                intent.setClass(zixunxiangqingActivity.this, zixun_student_lvActivity.class);
                startActivity(intent);
			}
		});  
        
    }
	private Bitmap getBitmap(String strURL) throws IOException {
		
		try {
			URL url = new URL(strURL);
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
