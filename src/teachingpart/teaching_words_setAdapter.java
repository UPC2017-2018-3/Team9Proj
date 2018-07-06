package teachingpart;

import java.util.ArrayList;
import java.util.List;

import com.imooc.systemwork.ApkEntity;
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
import webservice.Byallsensitivewords;
import webservice.Bydeletetcourse;
import webservice.Bydeletewords;


public class teaching_words_setAdapter extends BaseAdapter{
	ArrayList<ApkEntity> apk_list;
	LayoutInflater inflater;
	protected Context context;

	public teaching_words_setAdapter(Context context, ArrayList<ApkEntity> apk_list) {
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
			convertView = inflater.inflate(R.layout.teaching_words_setlv, null);
			holder.teaching_words_setlv_t1 = (TextView) convertView
					.findViewById(R.id.teaching_words_setlv_t1);
			holder.teaching_words_setlv_b1 = (Button) convertView
					.findViewById(R.id.teaching_words_setlv_b1);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.teaching_words_setlv_t1.setText(entity.getteaching_words_setlv_t1());
		holder.teaching_words_setlv_b1.setOnClickListener(new OnClick(position));
		
		
		return convertView;
	}

	class ViewHolder {
		TextView teaching_words_setlv_t1;
		Button teaching_words_setlv_b1;
		
	}
	
	private String word=null;
	
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
			teaching_words_setAdapter.this.notifyDataSetChanged(); //记得调用它
			String organization = ApkEntity.getorganization();
			String strParams = "organization:" + organization;
			List<Byallsensitivewords> lgroup=Byallsensitivewords.listGroup(strParams);
			word=lgroup.get(position).word;
			String str = "organization:" + organization+ "|word:" + word ;
			String retString=Bydeletewords.LogSelect(str);
			if (retString.equals("1")) {
	    		
				
				Toast.makeText(context,"该词已被删除",
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

