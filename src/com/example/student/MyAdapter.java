package com.example.student;

import java.util.List;

import com.example.bean.Payment;
import com.example.payItemStyle.PayItem;
import com.example.payItemStyle.PayItem.MyItemClicked;
import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;
import webservice.Byfourcourse;

public class MyAdapter extends BaseAdapter {
	private List<Payment> mList;
	private Context mContext;
	private int sumCount;
	private ChangeTextView changeTextView;

	public Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 1:

				changeTextView.changeTheText(msg.arg1);
				break;

			default:
				break;
			}
		};
	};

	public MyAdapter(List<Payment> List, Context context, ChangeTextView changeTextView) {
		this.mList = List;
		this.mContext = context;
		this.changeTextView = changeTextView;
	}

	@Override
	public int getCount() {
		int count = mList.size();
		if (count % 2 == 0) {
			sumCount = count / 2; // �����˫��ֱ�Ӽ���
		} else {
			sumCount = (int) Math.floor((double) count / 2) + 1;
		}
		return sumCount;
	}

	@Override
	public Object getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	static class ViewHolder {
		PayItem payitem1;
		PayItem payitem2;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = LayoutInflater.from(mContext).inflate(R.layout.list_pay_item, null);
			holder.payitem1 = (PayItem) convertView.findViewById(R.id.payItem1);
			holder.payitem2 = (PayItem) convertView.findViewById(R.id.payItem2);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.payitem1.setstudent_tv(mList.get(position * 2).getDescription());
		/*holder.payitem1.setstudent_img(mList.get(position * 2).getCharge());*/
		holder.payitem1.setIsSelected(mList.get(position * 2).getStatus());
		if (position * 2 + 1 == mList.size()) {
			holder.payitem2.setVisibility(View.INVISIBLE); // ����ǵ����Ļ�����ô���һ��item���Ҳ�����Ϊ��
		} else {
			holder.payitem2.setVisibility(View.VISIBLE); // ����������ã�������ڸ���holder��ʱ�򣬻�����Ҳ�ĳ������ף������һ��һ�������Ҳ����д��ƪ������������
			holder.payitem2.setstudent_tv(mList.get(position * 2 + 1).getDescription());
			/*holder.payitem2.setstudent_img(mList.get(position * 2 + 1).getCharge());*/
			holder.payitem2.setIsSelected(mList.get(position * 2+1).getStatus());
		}

		holder.payitem1.setMyItemClickedListener(new MyOnEvenClick(position));
		holder.payitem2.setMyItemClickedListener(new MyOnOddClick(position));
		return convertView;
	}

	private class MyOnEvenClick implements MyItemClicked {
		int pos = 0;

		public MyOnEvenClick(int position) {
			this.pos = position * 2;
		}

		@Override
		public void myItemClicked() {
			String strParams = "organization:" + "哈佛大学";	
			List<Byfourcourse> lgroup=Byfourcourse.listGroup(strParams);
			((ApkEntity) mContext.getApplicationContext()).setcoursename(lgroup.get(pos).coursename);
			Intent intent = new Intent(mContext, youkekecheng_MainActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
			mContext.startActivity(intent);
		}

	}

	private class MyOnOddClick implements MyItemClicked {
		int pos = 0;

		public MyOnOddClick(int position) {
			this.pos = position * 2 + 1;
		}

		@Override
		public void myItemClicked() {
			String strParams = "organization:" + "哈佛大学";	
			List<Byfourcourse> lgroup=Byfourcourse.listGroup(strParams);
			((ApkEntity) mContext.getApplicationContext()).setcoursename(lgroup.get(pos).coursename);
			((ApkEntity) mContext.getApplicationContext()).setteacher_account(lgroup.get(pos).courseteacheraccount);
			Intent intent = new Intent(mContext, youkekecheng_MainActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
			mContext.startActivity(intent);
		}

	}

	// ���ü���
	interface ChangeTextView {
		void changeTheText(int position);
	}

}
