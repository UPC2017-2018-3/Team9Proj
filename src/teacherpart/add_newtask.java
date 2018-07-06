package teacherpart;

import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import webservice.Byupcourse;
import webservice.Byuprenwu;
import android.widget.Toast;

public class add_newtask extends Activity{
	
	private String a;
	private EditText add_newtask_bt,add_newtask_tjkc,add_newtask_tjbj,add_newtask_gy,add_newtask_tjrq1,add_newtask_tjrq2;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_newtask);
        add_newtask_tjkc = (EditText)findViewById(R.id.add_newtask_tjkc);
        add_newtask_bt = (EditText)findViewById(R.id.add_newtask_bt);
        add_newtask_tjbj = (EditText)findViewById(R.id.add_newtask_tjbj);
        add_newtask_gy = (EditText)findViewById(R.id.add_newtask_gy);
        add_newtask_tjrq1 = (EditText)findViewById(R.id.add_newtask_tjrq1);
        Button fanhuibt = (Button) findViewById(R.id.add_newtask_setupfh);
        Button tjbt = (Button) findViewById(R.id.teacher_add_newtaskb1);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {  
            
            @Override  
            public void onCheckedChanged(RadioGroup group, int checkedId) {  
                // TODO Auto-generated method stub  
            	 switch (checkedId) {
     	        case R.id.newtask_rb1:
     	        	((ApkEntity) getApplication()).settaskType("作品");
     	            break;
     	        case R.id.newtask_rb2:
     	        	((ApkEntity) getApplication()).settaskType("笔记");
     	            break;
     	        case R.id.newtask_rb3:
     	        	((ApkEntity) getApplication()).settaskType("论文");
     	            break;
     	        default:
     	        	((ApkEntity) getApplication()).settaskType("其他");
     	            break;
     	        }
     	    } 
                  
        });  
        
        fanhuibt.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(add_newtask.this, teacher_task_management.class);
				startActivity(intent);
			}
		});
        tjbt.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String course=add_newtask_tjkc.getText().toString();
				String cla=add_newtask_tjbj.getText().toString();
				String text=add_newtask_gy.getText().toString();
				String deadline=add_newtask_tjrq1.getText().toString();
				String title=add_newtask_bt.getText().toString();
				String type=ApkEntity.gettaskType();
				String account = ApkEntity.getaccount();
				String strParams="teacher:"+account+"|course:"+course+"|deadline:"+deadline+"|type:"+type
			             +"|title:"+title+"|text:"+text+"|cla:"+cla;
	             String retString=Byuprenwu.LogSelect(strParams);
	             if (retString.equals("1")) {
		        		
						
						Toast.makeText(getApplicationContext(), "任务发布成功", Toast.LENGTH_LONG).show();
						
					}		     
		        	else {
		        		Toast.makeText(getApplicationContext(), "任务发布失败", Toast.LENGTH_SHORT).show();
		        	}
				
			}
		});
	}
	

}
