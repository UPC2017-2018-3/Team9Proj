package teacherpart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.imooc.systemwork.ApkEntity;
import com.imooc.systemwork.ReFlashListView;
import com.imooc.systemwork.ReFlashListView.ILoadListener;
import com.imooc.systemwork.ReFlashListView.IReflashListener;
import com.zhy.tree_view.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import popwindoe.DropDownMenu;
import popwindoe.MenuListAdapter;
import webservice.Byallcourse;
import webservice.Byallrenwu;
import webservice.Byclasslist;
import webservice.Byteacherreturncourse;


public class teacher_task_management extends Activity implements IReflashListener,ILoadListener{


    //菜单标题
    private String headers[] = {"状态", "课程", "班级"};
    private ListView listView1;
    private ListView listView2;
    private ListView listView3;
    private MenuListAdapter mMenuAdapter1;
    private MenuListAdapter mMenuAdapter2;
    private MenuListAdapter mMenuAdapter3;

    private DropDownMenu mDropDownMenu;

    private String status[] = { "进行中", "已完成"};

    private String allcourse[] = new String[200];

    private String cla[] = new String[200];
    
    private String zhuangtai = null ;
    private String kecheng = null ;
    private String banji = null ;
    

    private List<View> popupViews = new ArrayList<>();
    ArrayList<ApkEntity> apk_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_task_management);
        Button fanhuibt = (Button) findViewById(R.id.task_management_returnbt);
		Button tjbt = (Button) findViewById(R.id.task_management_communion);
		setData();
		showList(apk_list);
		fanhuibt.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(teacher_task_management.this, teacherpage.class);
				startActivity(intent);
			}
		});
		tjbt.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(teacher_task_management.this, add_newtask.class);
				startActivity(intent);
			}
		});
		
		String organization = ApkEntity.getorganization();
		String strParams = "organization:" + organization;
		List<Byallcourse> lgroup=Byallcourse.listGroup(strParams);

        for (int i = 0; i < lgroup.size(); i++) {
			
        	allcourse[i] = lgroup.get(i).coursename;
		
		}
        
    	String strParam = "organization:" + organization;
    	List<Byclasslist> lgroup1=Byclasslist.listGroup(strParam);

    	 for (int i = 0; i < lgroup1.size(); i++) {
 			
    		 cla[i] = lgroup1.get(i).cla;
 		
 		}
    	 

        initView();
    }

    private void initView() {


        mDropDownMenu = (DropDownMenu) findViewById(R.id.dropDownMenu);


        //init menu listview

        //这里是每个下拉菜单之后的布局,目前只是简单的listview作为展示
        listView1 = new ListView(teacher_task_management.this);
        listView2 = new ListView(teacher_task_management.this);
        listView3 = new ListView(teacher_task_management.this);

        listView1.setDividerHeight(0);
        listView2.setDividerHeight(0);
        listView3.setDividerHeight(0);

        mMenuAdapter1 = new MenuListAdapter(teacher_task_management.this, Arrays.asList(status));
        mMenuAdapter2 = new MenuListAdapter(teacher_task_management.this, Arrays.asList(allcourse));
        mMenuAdapter3 = new MenuListAdapter(teacher_task_management.this, Arrays.asList(cla));

        listView1.setAdapter(mMenuAdapter1);
        listView2.setAdapter(mMenuAdapter2);
        listView3.setAdapter(mMenuAdapter3);

        popupViews.add(listView1);
        popupViews.add(listView2);
        popupViews.add(listView3);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                mDropDownMenu.setTabText(status[position]);
                mDropDownMenu.closeMenu();
                zhuangtai = status[position];
                setData();
				showList(apk_list);
				adapter.notifyDataSetChanged();
                
            }
        });

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                mDropDownMenu.setTabText(allcourse[position]);
                mDropDownMenu.closeMenu();
                kecheng = allcourse[position];
                setData();
				showList(apk_list);
				adapter.notifyDataSetChanged();
            }
        });

        listView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                mDropDownMenu.setTabText(cla[position]);
                mDropDownMenu.closeMenu();
                banji = cla[position];
                setData();
				showList(apk_list);
				adapter.notifyDataSetChanged();
            }
        });
        listview.setOnItemClickListener(new OnItemClickListener(){  
 			@Override
 			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
 				// TODO Auto-generated method stub
 				//获取当前item的数据
 				String strParams = "account:" + account;
 				List<Byallrenwu> lgroup=Byallrenwu.listGroup(strParams);
 
 				String renwucourse =lgroup.get(position-1).renwucourse;
 				
 				((ApkEntity) getApplication()).setrenwucourse(renwucourse);
 				String renwutext =lgroup.get(position-1).renwutext;
 				((ApkEntity) getApplication()).setrenwutitle(renwutext);
 				Intent intent = new Intent();
				intent.setClass(teacher_task_management.this,teacher_renwuxiangqing.class);
				startActivity(intent);
 			}                                 
 	    });


        //这里添加 内容显示区域,可以是任何布局
        TextView contentView = new TextView(this);
        contentView.setText("根据需要可选择查询");
        contentView.setTextSize(15);
        contentView.setGravity(Gravity.CENTER);


        mDropDownMenu.setDropDownMenu(Arrays.asList(headers), popupViews,contentView );

    }

    teacher_task_managementAdapter adapter;
	ReFlashListView listview;
	private void showList(ArrayList<ApkEntity> apk_list) {
		if (adapter == null) {
			listview = (ReFlashListView) findViewById(R.id.task_managementlv);
			listview.setInterface(this);
			listview.setInterfoot(this);
			adapter = new teacher_task_managementAdapter(this, apk_list);
			listview.setAdapter(adapter);
		} else {
			adapter.onDateChange(apk_list);
		}
	}
	String account = ApkEntity.getaccount();
	
	private void setData() {
		
		String strParams = "account:" + account;
		List<Byallrenwu> lgroup=Byallrenwu.listGroup(strParams);
		
		apk_list = new ArrayList<ApkEntity>();
		for (int i = 0; i < lgroup.size(); i++) {
			
			boolean iszhuangtai = false;
			boolean iskecheng = false;
			boolean isbanji = false;
			ApkEntity entity = new ApkEntity();
			entity.setteacher_task_managementlv_t1("任务类型:"+lgroup.get(i).renwutype);
			entity.setteacher_task_managementlv_t2(lgroup.get(i).renwucourse);
			entity.setteacher_task_managementlv_t3(lgroup.get(i).renwutime+"-"+lgroup.get(i).renwudeadline);
			// 课程等级
						if(kecheng != null){
							if(kecheng.equals(lgroup.get(i).renwucourse)){
								iskecheng = true;
							}
						}else{
							iskecheng = true;
						}
			// 课程等级
						if(banji != null){
							if(banji.equals(lgroup.get(i).renwuclass)){
								isbanji = true;
							}
						}else{
							isbanji = true;
						}
						if(isbanji && iskecheng){
							apk_list.add(entity);
						}		
		}
	}

	private void setReflashData() {
		
	}
	private void getLoadData() {
		
	}
	
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

