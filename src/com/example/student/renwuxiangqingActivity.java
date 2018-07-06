package com.example.student;

import java.util.List;

import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import webservice.Bystudentrenwubody;
import webservice.Bystudentrenwuhead;
import webservice.Byxueyoudetial;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class renwuxiangqingActivity extends Activity{
	private TextView tv_renwuxiangqing1,tv_renwuxiangqing2;
	String organization = ApkEntity.getorganization();
   protected void onCreate(Bundle savedInstanceState) {
		    
        super.onCreate(savedInstanceState);
        setContentView(R.layout.renwuxiangqing); 
        
        String renwu_theme= ApkEntity.getrenwu_theme();
     	String strParams1 = "account:" + organization+ "|title:" + renwu_theme;
     	String strParams2 = "title:" + renwu_theme;
     	List<Bystudentrenwuhead> lgroup1=Bystudentrenwuhead.listGroup(strParams1);
     	List<Bystudentrenwubody> lgroup2=Bystudentrenwubody.listGroup(strParams2);
     	for (int i = 0; i < lgroup1.size(); i++) { 			
 			tv_renwuxiangqing1=(TextView) findViewById(R.id.tv_renwuxiangqing1);
 			 tv_renwuxiangqing2=(TextView) findViewById(R.id.tv_renwuxiangqing2);
 			
 			tv_renwuxiangqing1.setText(lgroup1.get(i).renwucourse);
 			if(lgroup1.get(i).renwustate.equals("1")){
 				tv_renwuxiangqing2.setText("已完成");
 			}else if(lgroup1.get(i).renwustate.equals("0")){
 				tv_renwuxiangqing2.setText("进行中");
 			}				  		
 		}
     	for (int i = 0; i < lgroup2.size(); i++) { 			
     		TextView tv_renwuxiangqing4=(TextView) findViewById(R.id.tv_renwuxiangqing4);
     		TextView tv_renwuxiangqing6=(TextView) findViewById(R.id.tv_renwuxiangqing6);
     		TextView tv_renwuxiangqing8=(TextView) findViewById(R.id.tv_renwuxiangqing8);
     		TextView ltv_renwuxianging=(TextView) findViewById(R.id.ltv_renwuxianging);
     		TextView tv_renwuxiangqing11=(TextView) findViewById(R.id.tv_renwuxiangqing11);
     		TextView tv_renwuxiangqing13=(TextView) findViewById(R.id.tv_renwuxiangqing13);
     		
 			tv_renwuxiangqing4.setText(lgroup2.get(i).renwutime);
 			tv_renwuxiangqing6.setText(lgroup2.get(i).renwudeadline);
 			tv_renwuxiangqing8.setText(lgroup2.get(i).renwutype);
 			ltv_renwuxianging.setText(lgroup2.get(i).renwudetail);
 			tv_renwuxiangqing11.setText(lgroup2.get(i).renwuteacher);
 			tv_renwuxiangqing13.setText(lgroup2.get(i).renwutime);
 						  		
 		}
        
        Button renwuxiangqing_backw = (Button)findViewById(R.id.renwuxiangqing_backw);
        renwuxiangqing_backw.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();  
                intent.setClass(renwuxiangqingActivity.this, renwu_lvActivity.class);
                startActivity(intent);
			}
		});   
        Button btn_renwuxiangqing = (Button)findViewById(R.id.btn_renwuxiangqing);
        btn_renwuxiangqing.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();  
                intent.setClass(renwuxiangqingActivity.this, submitrenwu.class);
                startActivity(intent);
			}
		});    
    }
}
