package teacherpart;

import java.util.ArrayList;
import java.util.List;

import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import teacherpart.comprehensive_trainingAdapter.OnClick;
import teacherpart.comprehensive_trainingAdapter.ViewHolder;
import webservice.Byallrenwu;

public class teacher_task_managementAdapter extends BaseAdapter{
	ArrayList<ApkEntity> apk_list;
	LayoutInflater inflater;
	protected Context context;

	public teacher_task_managementAdapter(Context context, ArrayList<ApkEntity> apk_list) {
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
			convertView = inflater.inflate(R.layout.teacher_task_managementlv, null);
			holder.teacher_task_managementlv_t1 = (TextView) convertView
					.findViewById(R.id.teacher_task_managementlv_t1);
			holder.teacher_task_managementlv_t2 = (TextView) convertView
					.findViewById(R.id.teacher_task_managementlv_t2);
			holder.teacher_task_managementlv_t3 = (TextView) convertView
					.findViewById(R.id.teacher_task_managementlv_t3);
			
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.teacher_task_managementlv_t1.setText(entity.getteacher_task_managementlv_t1());
		holder.teacher_task_managementlv_t2.setText(entity.getteacher_task_managementlv_t2());
		holder.teacher_task_managementlv_t3.setText(entity.getteacher_task_managementlv_t3());
		
		
		return convertView;
	}

	class ViewHolder {
		TextView teacher_task_managementlv_t1;
		TextView teacher_task_managementlv_t2;
		TextView teacher_task_managementlv_t3;
		
		
	}
	
	

}
