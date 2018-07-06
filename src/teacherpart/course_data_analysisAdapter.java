package teacherpart;

import java.util.ArrayList;

import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class course_data_analysisAdapter extends BaseAdapter{
	ArrayList<ApkEntity> apk_list;
	LayoutInflater inflater;
	protected Context context;

	public course_data_analysisAdapter(Context context, ArrayList<ApkEntity> apk_list) {
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
			convertView = inflater.inflate(R.layout.teacher_coursemanagementlv, null);
			holder.teacher_coursemanagementt1 = (TextView) convertView
					.findViewById(R.id.teacher_coursemanagementt1);
			/*holder.teacher_coursemanagementt2 = (TextView) convertView
					.findViewById(R.id.teacher_coursemanagementt1);*/
			
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.teacher_coursemanagementt1.setText(entity.getteacher_coursemanagementt1());
		/*holder.teacher_coursemanagementt2.setOnClickListener(new ListOnClick(position));*/
		
		
		return convertView;
	}

	class ViewHolder {
		TextView teacher_coursemanagementt1;
		/*TextView teacher_coursemanagementt2;*/
		
		
	}
	
	/*class ListOnClick  implements OnClickListener{

		private int position;// 记录ListView中Button所在的Item的位置

		public ListOnClick(int position) {
			this.position = position;
		}
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
		
			Intent intent = new Intent();
			intent.setClass(ListOnClick.this, teacherpage.class);
			startActivity(intent);
			Toast.makeText(context,"抢单成功！",
					Toast.LENGTH_LONG).show();
		}
	}*/
	

}


