package teachingpart;

import java.util.ArrayList;

import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import teachingpart.teaching_words_setAdapter.OnClick;


public class teaching_comment_supervisionAdapter extends BaseAdapter{
	ArrayList<ApkEntity> apk_list;
	LayoutInflater inflater;
	protected Context context;

	public teaching_comment_supervisionAdapter(Context context, ArrayList<ApkEntity> apk_list) {
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
			convertView = inflater.inflate(R.layout.teaching_comment_supervisionlv, null);
			/*holder.teaching_comment_supervision_pic = (sharp.CircleImageView) convertView.findViewById(R.id.teaching_comment_supervision_pic);*/
			holder.teaching_comment_supervision_t1 = (TextView) convertView
					.findViewById(R.id.teaching_comment_supervision_t1);
			holder.teaching_comment_supervision_t2 = (TextView) convertView
					.findViewById(R.id.teaching_comment_supervision_t2);
			holder.teaching_comment_supervision_b1 = (Button) convertView
					.findViewById(R.id.teaching_comment_supervision_b1);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		/*holder.teaching_comment_supervision_pic.setImageBitmap(BitmapFactory.decodeResource(
				context.getResources(), entity.getteaching_comment_supervision_pic()));*/
		holder.teaching_comment_supervision_t1.setText(entity.getteaching_comment_supervision_t1());
		holder.teaching_comment_supervision_t2.setText(entity.getteaching_comment_supervision_t2());
		holder.teaching_comment_supervision_b1.setOnClickListener(new OnClick(position));
		
		
		return convertView;
	}

	class ViewHolder {
		sharp.CircleImageView teaching_comment_supervision_pic;
		TextView teaching_comment_supervision_t1;
		TextView teaching_comment_supervision_t2;
		Button teaching_comment_supervision_b1;
		
	}
	
	class OnClick implements OnClickListener{

		private int position;// 记录ListView中Button所在的Item的位置

		public OnClick(int position) {
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
			apk_list.remove(position); //这个就是删除方法，position就是你选中的子项
			teaching_comment_supervisionAdapter.this.notifyDataSetChanged(); //记得调用它
		}
        		 }).show();
		}
	}

}

