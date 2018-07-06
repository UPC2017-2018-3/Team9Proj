package teacherpart;

import java.util.ArrayList;

import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import table.PPColumn;
import table.PieChart;
import webservice.Bychangeteachericon;
import webservice.Byjsavgmark;
import webservice.Byjsrenwufinish;
import webservice.Byjsstudentnum;
import webservice.Byjsyoulianglv;

public class teacher_data_analysis extends Activity {

    private PieChart mPieChart;
    private PieChart mPieChart1;
    private PieChart mPieChart12;
    private PieChart mPieChart2;
    private PieChart mPieChart3;
    private PPColumn column_one;
    private PPColumn column_two;
    private PPColumn column_three;
    String ret3;
    String ret4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_data_analysis);
        Button fhbt = (Button) findViewById(R.id.teacher_datarb);
        mPieChart = (PieChart) findViewById(R.id.pie_chart);
        mPieChart1 = (PieChart) findViewById(R.id.pie_chart1);
        mPieChart12 = (PieChart) findViewById(R.id.pie_chart12);
        mPieChart2 = (PieChart) findViewById(R.id.pie_chart2);
        
        
        fhbt.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(teacher_data_analysis.this, course_data_analysis.class);
				startActivity(intent);
				/*Toast.makeText(getApplicationContext(),"接单成功！",
						Toast.LENGTH_LONG).show();	*/
			}
		});
        
        
        String account = ApkEntity.getaccount();
    	String coursename = ApkEntity.getdata_coursename();
    	String strParams = "account:" + account+"|course:" + coursename;
    	String ret1=Byjsstudentnum.LogSelect(strParams);
    	String ret2=Byjsavgmark.LogSelect(strParams);    	
    	ret3=Byjsyoulianglv.LogSelect(strParams);
    	ret4=Byjsrenwufinish.LogSelect(strParams);
    	int a = Integer.parseInt(ret1);
    	int b = Integer.parseInt(ret2);
    	int c = Integer.parseInt(ret3);
    	int d = Integer.parseInt(ret4);
    	
        CompanyInfo companyInfo = new CompanyInfo(a, 0, 0, 0, 0, 0);
        ArrayList tmp = createPieChart(companyInfo);
        mPieChart.setData(tmp, "总共有");

        CompanyInfo companyInfo1 = new CompanyInfo(0, b, 0, 0, 0, 0);
        ArrayList tmp1 = createPieChart(companyInfo1);
        mPieChart1.setData(tmp1, "总共有");

        CompanyInfo companyInfo12 = new CompanyInfo(0, 0, c, 100-c, 0, 0);
        ArrayList tmp12 = createPieChart(companyInfo12);
        mPieChart12.setData(tmp12, "满分");

        CompanyInfo companyInfo2 = new CompanyInfo(0, 0, 0, 0, 100-d, d);
        ArrayList tmp2 = createPieChart(companyInfo2);
        mPieChart2.setData(tmp2, "满分");

       
        
    }

    private ArrayList createPieChart(CompanyInfo companyInfo) {
        ArrayList tmp = new ArrayList();
        int count = 0;
        if(companyInfo.trademarks_count > 0) {
            count += companyInfo.trademarks_count;
            tmp.add(new PieChart.Entry("选课人数",companyInfo.trademarks_count));//trademark
        }
        if(companyInfo.domains_count > 0) {
            count += companyInfo.domains_count;
            tmp.add(new PieChart.Entry("平均成绩",companyInfo.domains_count));//trademark
        }
        if(companyInfo.patents_count > 0) {
            count += companyInfo.patents_count;
            tmp.add(new PieChart.Entry(ret3+"%",companyInfo.patents_count));//trademark
        }
        if(companyInfo.soft_count > 0) {
            count += companyInfo.soft_count;
            tmp.add(new PieChart.Entry("不及格",companyInfo.soft_count));//trademark
        }
        if(companyInfo.original_count > 0) {
            count += companyInfo.original_count;
            tmp.add(new PieChart.Entry("未完成",companyInfo.original_count));//trademark
        }
        if(companyInfo.certificate_count > 0) {
            count += companyInfo.certificate_count;
            tmp.add(new PieChart.Entry("完成比"+ret4+"%",companyInfo.certificate_count));//trademark
        }
        return tmp;
    }

    class CompanyInfo {
        public int trademarks_count;
        public int domains_count;
        public int patents_count;
        public int soft_count;
        public int original_count;
        public int certificate_count;

        public CompanyInfo(int trademarks_count, int domains_count, int patents_count, int soft_count, int original_count, int certificate_count) {
            this.trademarks_count = trademarks_count;
            this.domains_count = domains_count;
            this.patents_count = patents_count;
            this.soft_count = soft_count;
            this.original_count = original_count;
            this.certificate_count = certificate_count;
        }
    }
   
}
