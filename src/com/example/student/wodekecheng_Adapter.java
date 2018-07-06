package com.example.student;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class wodekecheng_Adapter extends BaseAdapter{

	ArrayList<ApkEntity> apk_list;
	LayoutInflater inflater;
	protected Context context;

	public wodekecheng_Adapter(Context context, ArrayList<ApkEntity> apk_list) {
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
			convertView = inflater.inflate(R.layout.wodekecheng_listitem, null);
			holder.tv1_wodekecheng = (TextView) convertView
					.findViewById(R.id.tv1_wodekecheng);
			holder.tv2_wodekecheng = (TextView) convertView
					.findViewById(R.id.tv2_wodekecheng);
			holder.tv3_wodekecheng = (TextView) convertView
					.findViewById(R.id.tv3_wodekecheng);
			holder.tv5_wodekecheng = (TextView) convertView
					.findViewById(R.id.tv5_wodekecheng);
			holder.img_wodekecheng = (ImageView) convertView
					.findViewById(R.id.img_wodekecheng);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}

		holder.tv1_wodekecheng.setText(entity.gettv1_wodekecheng());	
		holder.tv2_wodekecheng.setText(entity.gettv2_wodekecheng());
		holder.tv3_wodekecheng.setText(entity.gettv3_wodekecheng());
		holder.tv5_wodekecheng.setText(entity.gettv5_wodekecheng());
		Bitmap bitmap;
		try {
			bitmap = getBitmap(entity.getpictureUrls());
			holder.img_wodekecheng.setImageBitmap(bitmap);
			bitmap = null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return convertView;
	}

	class ViewHolder {
		public TextView tv5_wodekecheng;
		public TextView tv3_wodekecheng;
		public TextView tv2_wodekecheng;
		public TextView tv1_wodekecheng;
		public ImageView img_wodekecheng;
		
	}
	
	class ListOnClick implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
		}

	}
	
	public Bitmap getBitmap(String path) throws IOException {
		try {
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setRequestMethod("GET");
			if (conn.getResponseCode() == 200) {
				InputStream inputStream = conn.getInputStream();
				Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
				return bitmap;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
