package com.example.student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.zhy.tree_view.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class zhishidian_lvActivity extends Activity{
	private ListView list = null;
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.zhishidian);
	    list = (ListView) findViewById(R.id.zhishidian_listview);
	    //��֯����Դ
	    List<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
	    for(int i=0;i<10;i++) {
	      HashMap<String, String> map = new HashMap<String, String>();  
	      map.put("tv_zhishidianitem1", "֪知识点111");
	      mylist.add(map);
	    }
	    //����������
	    SimpleAdapter adapter = new SimpleAdapter(this, 
	     mylist,//����Դ 
	     R.layout.zhishidian_listitem,//��ʾ����
	     new String[] {"tv_zhishidianitem1","ib_zhishidianitem2","ib_zhishidianitem3"}, //����Դ�������ֶ�
	     new int[] {R.id.tv_zhishidianitem1,R.id.ib_zhishidianitem2,R.id.ib_zhishidianitem3}); //������Ŀؼ�id
	    //��Ӳ�����ʾ
	    list.setAdapter(adapter);

	  }
}
