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
import teachingpart.review_training_planAdapter.ViewHolder;

public class teaching_student_markAdapter extends BaseAdapter{
	ArrayList<ApkEntity> apk_list;
	LayoutInflater inflater;
	protected Context context;

	public teaching_student_markAdapter(Context context, ArrayList<ApkEntity> apk_list) {
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
			convertView = inflater.inflate(R.layout.teaching_student_marklv, null);
			holder.teaching_student_mark_t1 = (TextView) convertView
					.findViewById(R.id.teaching_student_mark_t1);
			holder.teaching_student_mark_t2 = (TextView) convertView
					.findViewById(R.id.teaching_student_mark_t2);
			convertView.setTag(holder);

		}else{
			holder = (ViewHolder) convertView.getTag();
			
			
		}
		

		holder.teaching_student_mark_t1.setText(entity.getteaching_student_mark_t1());
		holder.teaching_student_mark_t2.setText(entity.getteaching_student_mark_t2());
		
		
		return convertView;
	}

	class ViewHolder {
		TextView teaching_student_mark_t1;
		TextView teaching_student_mark_t2;

		
	}

}
