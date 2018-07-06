package teachingpart;

import java.util.ArrayList;

import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class finished_courseAdapter extends BaseAdapter{
	ArrayList<ApkEntity> apk_list;
	LayoutInflater inflater;
	protected Context context;

	public finished_courseAdapter(Context context, ArrayList<ApkEntity> apk_list) {
		this.apk_list = apk_list;
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
			convertView = inflater.inflate(R.layout.finished_courselv, null);
			holder.teacher_filelv_t1 = (TextView) convertView
					.findViewById(R.id.class_t1);
			holder.teacher_filelv_t2 = (TextView) convertView
					.findViewById(R.id.class_t2);
			holder.teacher_filelv_t3 = (TextView) convertView
					.findViewById(R.id.class_t3);
			holder.teacher_filelv_t4 = (TextView) convertView
					.findViewById(R.id.class_t4);
			holder.teacher_filelv_t5 = (TextView) convertView
					.findViewById(R.id.class_t5);
			holder.teacher_filelv_t6 = (TextView) convertView
					.findViewById(R.id.class_t6);
			
			
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.teacher_filelv_t1.setText(entity.getteaching_class_t1());
		holder.teacher_filelv_t2.setText(entity.getteaching_class_t2());
		holder.teacher_filelv_t3.setText(entity.getteaching_class_t3());
		holder.teacher_filelv_t4.setText(entity.getteaching_class_t4());
		holder.teacher_filelv_t5.setText(entity.getteaching_class_t5());
		holder.teacher_filelv_t6.setText(entity.getteaching_class_t6());
	
		
		
		return convertView;
	}

	class ViewHolder {
		TextView teacher_filelv_t1;
		TextView teacher_filelv_t2;
		TextView teacher_filelv_t3;
		TextView teacher_filelv_t4;
		TextView teacher_filelv_t5;
		TextView teacher_filelv_t6;

		
	}

}


