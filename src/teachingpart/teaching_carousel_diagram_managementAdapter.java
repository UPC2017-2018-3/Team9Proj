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

public class teaching_carousel_diagram_managementAdapter extends BaseAdapter{
	ArrayList<ApkEntity> apk_list;
	LayoutInflater inflater;
	protected Context context;

	public teaching_carousel_diagram_managementAdapter(Context context, ArrayList<ApkEntity> apk_list) {
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
			convertView = inflater.inflate(R.layout.review_training_planlv, null);
			holder.review_training_planlvt1 = (TextView) convertView
					.findViewById(R.id.review_training_planlvt1);
			holder.review_training_planlvt2 = (TextView) convertView
					.findViewById(R.id.review_training_planlvt2);
			holder.review_training_planlvt3 = (TextView) convertView
					.findViewById(R.id.review_training_planlvt3);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.review_training_planlvt1.setText(entity.getreview_training_planlvt1());
		holder.review_training_planlvt2.setText(entity.getreview_training_planlvt2());
		holder.review_training_planlvt3.setText(entity.getreview_training_planlvt3());
		
		
		return convertView;
	}

	class ViewHolder {
		TextView review_training_planlvt1;
		TextView review_training_planlvt2;
		TextView review_training_planlvt3;
		
	}

}

