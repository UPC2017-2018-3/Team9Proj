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

public class allkecheng_ActivityAdapter extends BaseAdapter{
	ArrayList<ApkEntity> apk_list;
	LayoutInflater inflater;
	protected Context context;

	public allkecheng_ActivityAdapter(Context context, ArrayList<ApkEntity> apk_list) {
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
			convertView = inflater.inflate(R.layout.allkecheng_listitem, null);
			holder.allkechenglv_img1 = (ImageView) convertView
					.findViewById(R.id.allkechenglv_img1);
			holder.allkechenglv_tv1 = (TextView) convertView
					.findViewById(R.id.allkechenglv_tv1);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		
		Bitmap bitmap;
		try {
			bitmap = getBitmap(entity.getpictureUrls());
			holder.allkechenglv_img1.setImageBitmap(bitmap);
			bitmap = null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		holder.allkechenglv_tv1.setText(entity.gettv_chengjiitem1());
		return convertView;
	}

	class ViewHolder {
		public ImageView allkechenglv_img1;
		public TextView allkechenglv_tv1;
		
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
