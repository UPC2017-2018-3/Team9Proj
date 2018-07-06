package teacherpart;

import java.util.ArrayList;
import java.util.List;

import com.imooc.systemwork.ApkEntity;
import com.imooc.systemwork.courseAdapter;
import com.zhy.tree_view.R;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import webservice.Byallpoint;
import webservice.Bydeleteexercise;
import webservice.Bydeletepoint;
import webservice.Bysearchexercise;

public class teacher_knowledgeAdapter extends BaseAdapter{
	ArrayList<ApkEntity> apk_list;
	LayoutInflater inflater;
	protected Context context;

	public teacher_knowledgeAdapter(Context context, ArrayList<ApkEntity> apk_list) {
		this.apk_list = apk_list;
		this.context = context;
		this.inflater = LayoutInflater.from(context);
	}

	public void onDateChange(ArrayList<ApkEntity> apk_list) {
		this.apk_list = apk_list;
		this.notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return apk_list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return apk_list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ApkEntity entity = apk_list.get(position);
		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.teacher_knowledgelv, null);
			holder.teacher_knowledgelvt1 = (TextView) convertView
					.findViewById(R.id.teacher_knowledgelvt1);
			holder.teacher_knowledgelvb1 = (Button) convertView
					.findViewById(R.id.teacher_knowledgelvb1);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.teacher_knowledgelvt1.setText(entity.getteacher_knowledgelv());
		holder.teacher_knowledgelvb1.setOnClickListener(new ListOnClick(position));
		
		
		return convertView;
	}

	class ViewHolder {
		TextView teacher_knowledgelvt1;
		Button teacher_knowledgelvb1;
		
	}
	
	private String content=null;
	
	class ListOnClick implements OnClickListener{

		private int position;// 记录ListView中Button所在的Item的位置

		public ListOnClick(int position) {
			this.position = position;
		}
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
		 new AlertDialog.Builder(context).setTitle("我的提示").setMessage("确定要删除吗？")                  
         .setPositiveButton("确定", new DialogInterface.OnClickListener()
        		 {
		@Override
		public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
			
			String account = ApkEntity.getaccount();
			 String coursename = ApkEntity.getcoursename();
				String strParams = "account:" + account+"|course:" + coursename;
				List<Byallpoint> lgroup=Byallpoint.listGroup(strParams);
				content=lgroup.get(position).knowledge;
				String str = "point:" + content+"|account:" + account+"|course:" + coursename;
				String retString=Bydeletepoint.LogSelect(str);
				if (retString.equals("1")) {
					apk_list.remove(position); //这个就是删除方法，position就是你选中的子项
					teacher_knowledgeAdapter.this.notifyDataSetChanged(); //记得调用它
					Toast.makeText(context,"该题已被删除",
							Toast.LENGTH_LONG).show();
					
				}
		    	else {
		    		Toast.makeText(context,"请重新删除！",
							Toast.LENGTH_LONG).show();
		    	}
		}
        		 }).show().getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLACK);
		}
	}

}

