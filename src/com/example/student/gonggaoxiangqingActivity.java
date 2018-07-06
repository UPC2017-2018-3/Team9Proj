package com.example.student;

import java.util.List;

import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import webservice.Bygonggaodetial;
import webservice.Byxueyoudetial;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class gonggaoxiangqingActivity extends Activity{
	private TextView tv1_gonggaoxiangqing,tv2_gonggaoxiangqing,tv3_gonggaoxiangqing,tv4_gonggaoxiangqing;
	protected void onCreate(Bundle savedInstanceState) {
		
    	    
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gonggaoxiangqing);
        
        tv1_gonggaoxiangqing=(TextView) findViewById(R.id.tv1_gonggaoxiangqing);
		tv2_gonggaoxiangqing=(TextView) findViewById(R.id.tv2_gonggaoxiangqing);
		tv3_gonggaoxiangqing=(TextView) findViewById(R.id.tv3_gonggaoxiangqing);
		tv4_gonggaoxiangqing=(TextView) findViewById(R.id.tv4_gonggaoxiangqing);
        
        String tongzhi_theme= ApkEntity.gettongzhi_theme();
     	String strParams = "organization:" + "中国能源大学"+ "|title:" + tongzhi_theme;
     	List<Bygonggaodetial> lgroup=Bygonggaodetial.listGroup(strParams);
     	for (int i = 0; i < lgroup.size(); i++) { 			
 			       
 			tv1_gonggaoxiangqing.setText(lgroup.get(i).gonggaotitle);
 			tv2_gonggaoxiangqing.setText(lgroup.get(i).gonggaotime);
 			tv3_gonggaoxiangqing.setText(lgroup.get(i).gonggaowriter);
 			tv4_gonggaoxiangqing.setText(lgroup.get(i).gonggaotext);
 	  		
 		}
        
        Button gonggaoxiangqing_backw = (Button)findViewById(R.id.gonggaoxiangqing_backw);
        gonggaoxiangqing_backw.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();  
                intent.setClass(gonggaoxiangqingActivity.this, tongzhi_lvActivity.class);
                startActivity(intent);
			}
		});        
    }

}
