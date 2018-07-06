package teachingpart;

import java.util.List;

import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.print.PrintAttributes;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import webservice.Byallsensitivewords;
import webservice.Bystajiaowu;

public class real_time_data_statistics extends Activity{
	
	private   String tn,sn,cn;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.real_time_data_statistics);
		Button fanhuibt = (Button) findViewById(R.id.teacher_studentstudyrb);
		
		String organization = ApkEntity.getorganization();
		String strParams = "organization:" + organization;
		List<Bystajiaowu> lgroup=Bystajiaowu.listGroup(strParams);
		for (int i = 0; i < lgroup.size(); i++) {
			TextView real_time_data_statistics_t3 = (TextView) findViewById(R.id.real_time_data_statistics_t3);
			TextView real_time_data_statistics_t4 = (TextView) findViewById(R.id.real_time_data_statistics_t4);
			TextView real_time_data_statistics_t5 = (TextView) findViewById(R.id.real_time_data_statistics_t5);	
			tn =lgroup.get(i).tn;
			sn =lgroup.get(i).sn;
			cn =lgroup.get(i).cn;
			real_time_data_statistics_t3.setText(tn);
			real_time_data_statistics_t4.setText(sn);
			real_time_data_statistics_t5.setText(cn);	
		}
	
		
		
		fanhuibt.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(real_time_data_statistics.this, teachingpage.class);
				startActivity(intent);
			}
		});
		
		
		
	}

}
