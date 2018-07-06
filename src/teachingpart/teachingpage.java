package teachingpart;

import java.util.ArrayList;
import java.util.List;

import com.example.videopaly.video;
import com.example.videopaly.video1;
import com.imooc.systemwork.ApkEntity;
import com.imooc.systemwork.ReFlashListView;
import com.imooc.systemwork.class_management;
import com.imooc.systemwork.course_management;
import com.imooc.systemwork.department_management;
import com.imooc.systemwork.student_management;
import com.imooc.systemwork.teacher_management;
import com.imooc.systemwork.ReFlashListView.ILoadListener;
import com.imooc.systemwork.ReFlashListView.IReflashListener;
import com.zhy.tree_view.Node;
import com.zhy.tree_view.R;
import com.zhy.tree_view.TreeListViewAdapter;
import com.zhy.tree_view.TreeListViewAdapter.OnTreeNodeClickListener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import teacherpart.SlidingMenu;
import webservice.Byadminnicheng;
import webservice.Byalllivepath;
import webservice.Byallpoint;
import webservice.Bychangeicon1;
import webservice.Byteachernicheng;



public class teachingpage extends Activity implements IReflashListener,ILoadListener{
	ArrayList<ApkEntity> apk_list;
	private SlidingMenu mMenu;
	private List<FileBean> mDatas = new ArrayList<FileBean>();
	private ListView mTree;
	@SuppressWarnings("rawtypes")
	private TreeListViewAdapter mAdapter;
	private long mLastPressBackTime = 0;
    private static final int INTERVAL_OF_TWO_CLICK_TO_QUIT = 1000; // 1 seconde
    String account = ApkEntity.getaccount();
	String organization = ApkEntity.getorganization();

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.teaching_homepage);
		mMenu = (SlidingMenu) findViewById(R.id.teaching_menu);
		
		
		Button teaching_xx = (Button) findViewById(R.id.homepage_communion);
		Button teaching_bj = (Button) findViewById(R.id.homepage_bianji);
		TextView homepage_xinxi = (TextView) findViewById(R.id.homepage_xinxi);
		homepage_xinxi.setText(organization);
		String strParams1 = "account:" + account; 
		String retString1=Byadminnicheng.studentRegisterSelect(strParams1);
		((ApkEntity) getApplication()).setaccount_name(retString1);
		TextView homepage_name = (TextView) findViewById(R.id.homepage_name);
		homepage_name.setText(retString1);
		teaching_xx.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(teachingpage.this, teaching_information.class);
				startActivity(intent);
			}
		});
		teaching_bj.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(teachingpage.this, teaching_setup.class);
				startActivity(intent);
		}
		});	
	
		
		initDatas();
		mTree = (ListView) findViewById(R.id.id_tree);
		try
		{
			mAdapter = new SimpleTreeAdapter<FileBean>(mTree, this, mDatas, 10);
			
			mAdapter.setOnTreeNodeClickListener(new OnTreeNodeClickListener()
			{
				@Override
				public void onClick(Node node, int position)
				{
					if (node.isLeaf())
					{
						
						if(node.getId() == 9)
						{
							Intent intent = new Intent();
							intent.setClass(teachingpage.this, department_management.class);
							startActivity(intent);
						}
						if(node.getId() == 10)
						{
							Intent intent = new Intent();
							intent.setClass(teachingpage.this, class_management.class);
							startActivity(intent);
						}
						if(node.getId() == 11)
						{
							Intent intent = new Intent();
							intent.setClass(teachingpage.this, teacher_management.class);
							startActivity(intent);
						}
						if(node.getId() == 12)
						{
							Intent intent = new Intent();
							intent.setClass(teachingpage.this, student_management.class);
							startActivity(intent);
						}
						if(node.getId() == 13)
						{
							Intent intent = new Intent();
							intent.setClass(teachingpage.this, course_management.class);
							startActivity(intent);
						}
						if(node.getId() == 3)
						{
							Intent intent = new Intent();
							intent.setClass(teachingpage.this, real_time_data_statistics.class);
							startActivity(intent);
						}
						if(node.getId() == 14)
						{
							Intent intent = new Intent();
							intent.setClass(teachingpage.this, teaching_carousel_diagram_management.class);
							startActivity(intent);
						}
						if(node.getId() == 24)
						{
							Intent intent = new Intent();
							intent.setClass(teachingpage.this, teaching_words_set.class);
							startActivity(intent);
						}
						if(node.getId() == 25)
						{
							Intent intent = new Intent();
							intent.setClass(teachingpage.this, teaching_comment_supervision.class);
							startActivity(intent);
						}
						if(node.getId() == 18)
						{
							Intent intent = new Intent();
							intent.setClass(teachingpage.this, review_training_plan.class);
							startActivity(intent);
						}
						if(node.getId() == 20)
						{
							Intent intent = new Intent();
							intent.setClass(teachingpage.this, student_mark.class);
							startActivity(intent);
						}
						if(node.getId() == 8)
						{
							Intent intent = new Intent();
							intent.setClass(teachingpage.this, teaching_Supervision.class);
							startActivity(intent);
						}
						if(node.getId() == 19)
						{
							Intent intent = new Intent();
							intent.setClass(teachingpage.this, finished_course.class);
							startActivity(intent);
						}
						if(node.getId() == 23)
						{
							Intent intent = new Intent();
							intent.setClass(teachingpage.this, teaching_dangan.class);
							startActivity(intent);
						}
						if(node.getId() == 21)
						{
							Intent intent = new Intent();
							intent.setClass(teachingpage.this, student_participation.class);
							startActivity(intent);
						}
						if(node.getId() == 22)
						{
							Intent intent = new Intent();
							intent.setClass(teachingpage.this, course_effect.class);
							startActivity(intent);
						}
					}
				}

			});
			
			mTree.setAdapter(mAdapter);
		} catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}

		
		setData();
		showList(apk_list);
		
		listview.setOnItemClickListener(new OnItemClickListener(){  
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				//获取当前item的数据
				String strParams = "organization:" + organization;
				List<Byalllivepath> lgroup=Byalllivepath.listGroup(strParams);
			    String vodiourl = lgroup.get(position).teacheraccount;
			    String teachername = lgroup.get(position).teachername;
			    ((ApkEntity) getApplication()).setliveurl(vodiourl);
			    ((ApkEntity) getApplication()).setteachername(teachername);
				Intent intent = new Intent(); 
				intent.setClass(teachingpage.this, video1.class);
	            startActivity(intent);  
			}                                 
	    });

	}
	
	 @Override
	    public void onBackPressed() {
	        if (System.currentTimeMillis() - mLastPressBackTime < INTERVAL_OF_TWO_CLICK_TO_QUIT) {
//	            Intent intent = new Intent();
//	            intent.putExtra("has_logout", false);
//	            setResult(RESULT_OK, intent);
	            finish();
	        } else {
	            Toast.makeText(this, "再次按下返回键将退出应用！", Toast.LENGTH_SHORT).show();
	            mLastPressBackTime = System.currentTimeMillis();
	        }
	    }

	private void initDatas()
	{

		// id , pid , label , 其他属性
		mDatas.add(new FileBean(1, 0, "功能菜单"));
		mDatas.add(new FileBean(2, 1, "系统管理"));
		mDatas.add(new FileBean(3, 1, "实时数据统计"));
		mDatas.add(new FileBean(4, 1, "门户管理"));
		mDatas.add(new FileBean(5, 1, "实训动态"));
		mDatas.add(new FileBean(6, 1, "数据分析"));
		mDatas.add(new FileBean(7, 1, "交流监管"));
		mDatas.add(new FileBean(8, 1, "教学监管"));
		mDatas.add(new FileBean(9, 2,"院系管理"));
		mDatas.add(new FileBean(10, 2, "班级管理"));
		mDatas.add(new FileBean(11, 2, "教师管理"));
		mDatas.add(new FileBean(12, 2, "学生管理"));
		mDatas.add(new FileBean(13, 2, "课程管理"));
		mDatas.add(new FileBean(14, 4, "轮播图管理"));
		mDatas.add(new FileBean(15, 4, "通知公告管理"));
		mDatas.add(new FileBean(16, 4, "校园资讯管理"));
		mDatas.add(new FileBean(17, 4, "学友圈管理"));
		mDatas.add(new FileBean(18, 5, "发布实训计划"));
		mDatas.add(new FileBean(19, 5, "实训效果统计"));
		mDatas.add(new FileBean(20, 6, "学生成绩统计"));
		mDatas.add(new FileBean(21, 6, "参与度分析"));
		mDatas.add(new FileBean(22, 6, "实训效果分析"));
		mDatas.add(new FileBean(23, 6, "学生能力档案"));
		mDatas.add(new FileBean(24, 7, "敏感词设置"));
		mDatas.add(new FileBean(25, 7, "话题（回复）监管"));
		
		

	}

	public void toggleMenu(View view)
	{
		mMenu.toggle();
	}

	/*@Override
	public void onLoad() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onReflash() {
		// TODO Auto-generated method stub
		
	}*/
	
	teachingpageAdapter adapter;
	ReFlashListView listview;
	private void showList(ArrayList<ApkEntity> apk_list) {
		if (adapter == null) {
			listview = (ReFlashListView) findViewById(R.id.homepagelv);
			listview.setInterface(this);
			listview.setInterfoot(this);
			adapter = new teachingpageAdapter(this, apk_list);
			listview.setAdapter(adapter);
		} else {
			adapter.onDateChange(apk_list);
		}
	}

	private void setData() {
		String strParams = "organization:" + organization;
		List<Byalllivepath> lgroup=Byalllivepath.listGroup(strParams);
		apk_list = new ArrayList<ApkEntity>();
		for (int i = 0; i < lgroup.size(); i++) {
			ApkEntity entity = new ApkEntity();
			entity.sethomepagelv_name(lgroup.get(i).teachername+"正在直播");
			apk_list.add(entity);
		}
	}

	private void setReflashData() {
		
	}
	private void getLoadData() {
		
	}
	@Override
	public void onReflash() {
		// TODO Auto-generated method stub\
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//锟斤拷取锟斤拷锟斤拷锟斤拷锟斤拷
				setReflashData();
				//通知锟斤拷锟斤拷锟斤拷示
				showList(apk_list);
				//通知listview 刷锟斤拷锟斤拷锟斤拷锟斤拷希锟�
				listview.reflashComplete();
			}
		}, 2000);
		
	}
	public void onLoad() {
		// TODO Auto-generated method stub
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				getLoadData();
				showList(apk_list);
				listview.loadComplete();
			}
		}, 2000);
	}

}
