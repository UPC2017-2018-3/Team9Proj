package com.example.student;


import com.zhy.tree_view.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class renwutijiaoActivity extends Activity{
	 protected void onCreate(Bundle savedInstanceState) {
		    
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.renwutijiao); 
	        
	        
	        Button renwutijiao_backw = (Button)findViewById(R.id.renwutijiao_backw);
	        renwutijiao_backw.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent();  
	                intent.setClass(renwutijiaoActivity.this, renwuxiangqingActivity.class);
	                startActivity(intent);
				}
			});   
	        Button btn_renwutijiao = (Button)findViewById(R.id.btn_renwutijiao);
	        btn_renwutijiao.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
				}
			});    
	    }

}
