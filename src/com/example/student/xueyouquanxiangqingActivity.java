package com.example.student;

import java.io.IOException;
import java.util.List;

import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import webservice.Byxueyoudetial;
import webservice.Byzixuncontent;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class xueyouquanxiangqingActivity extends Activity{
	protected void onCreate(Bundle savedInstanceState) {
		
	    
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xueyouquanxiangqing); 
        
        String xueyouquan_theme= ApkEntity.getxueyouquan_theme();
     	String strParams = "organization:" + "中国能源大学"+ "|title:" + xueyouquan_theme;
     	List<Byxueyoudetial> lgroup=Byxueyoudetial.listGroup(strParams);
     	for (int i = 0; i < lgroup.size(); i++) { 			
 			TextView tv1_xueyouxiangqing=(TextView) findViewById(R.id.tv1_xueyouxiangqing);
 			TextView tv2_xueyouxiangqing=(TextView) findViewById(R.id.tv2_xueyouxiangqing);
 			TextView tv3_xueyouxiangqing=(TextView) findViewById(R.id.tv3_xueyouxiangqing);
 			TextView tv4_xueyouxiangqing=(TextView) findViewById(R.id.tv4_xueyouxiangqing);
 	       
 			tv1_xueyouxiangqing.setText(lgroup.get(i).xueyoutitle);
 			tv2_xueyouxiangqing.setText(lgroup.get(i).xueyoutime);
 			tv3_xueyouxiangqing.setText(lgroup.get(i).xueyouwriter);
 			tv4_xueyouxiangqing.setText(lgroup.get(i).xueyoucontent);
 	  		
 		}
        Button xueyouxiangqing_backw = (Button)findViewById(R.id.xueyouxiangqing_backw);
        xueyouxiangqing_backw.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();  
                intent.setClass(xueyouquanxiangqingActivity.this, xueyouquan_lvActivity.class);
                startActivity(intent);
			}
		});   
        
        
    }

}
