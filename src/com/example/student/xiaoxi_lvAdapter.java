package com.example.student;

import java.util.ArrayList;

import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;


public class xiaoxi_lvAdapter extends BaseAdapter{
	ArrayList<ApkEntity> apk_list;
	LayoutInflater inflater;
	protected Context context;

	public xiaoxi_lvAdapter(Context context, ArrayList<ApkEntity> apk_list) {
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
			convertView = inflater.inflate(R.layout.xiaoxi_item, null);
			holder.tv_xiaoxi1 = (TextView) convertView
					.findViewById(R.id.tv_xiaoxi1);
			holder.tv_xiaoxi3 = (TextView) convertView
					.findViewById(R.id.tv_xiaoxi3);
			holder.btn_xiaoxi = (Button) convertView
					.findViewById(R.id.btn_xiaoxi);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.tv_xiaoxi1.setText(entity.gettv_xiaoxi1());	
		holder.tv_xiaoxi3.setText(entity.gettv_xiaoxi3());	
		holder.btn_xiaoxi.setOnClickListener(new ListOnClick(position));
		return convertView;
	}

	class ViewHolder {
		TextView tv_xiaoxi1;
		TextView tv_xiaoxi3;
		Button btn_xiaoxi;
		
	}
	
	class ListOnClick implements OnClickListener{

		private int position;// ��¼ListView��Button���ڵ�Item��λ��
		public ListOnClick(int position) {
			this.position = position;
		}
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
		 new AlertDialog.Builder(context).setTitle("我的提示ʾ").setMessage("确定要删除嘛")                  
         .setPositiveButton("确定", new DialogInterface.OnClickListener()
        		 {
		@Override
		public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
			apk_list.remove(position); //�������ɾ��������position������ѡ�е�����
			xiaoxi_lvAdapter.this.notifyDataSetChanged(); //�ǵõ�����
		}
        		 }).show();
		}


	}

}
