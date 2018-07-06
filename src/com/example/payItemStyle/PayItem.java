package com.example.payItemStyle;






import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.zhy.tree_view.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class PayItem extends RelativeLayout {
	private RelativeLayout relativeLayout1;// ����������Ŀ
	private TextView student_tv1;// �շѽ��
	private ImageView student_img1;// ��������
	private Boolean isSelected = false;// �Ƿ�ѡ��

	private String student_tv;
	private String student_img;
	private String description;
	private MyItemClicked myItemClicked;

	public PayItem(Context context) {
		this(context, null);
	}

	public PayItem(Context context, AttributeSet attrs) {
		super(context, attrs);
		View.inflate(context, R.layout.pay_item_layout, this);
		relativeLayout1 = (RelativeLayout) findViewById(R.id.relativeLayout1);
		student_tv1 = (TextView) findViewById(R.id.student_tv1);
		student_img1 = (ImageView) findViewById(R.id.student_img1);
		relativeLayout1.setOnClickListener(new MyOnClick());
	}

	public String getstudent_tv() {
		return student_tv;
	}

	public void setstudent_tv(String student_tv) {
		this.student_tv = student_tv;
		student_tv1.setText(student_tv);
	}

	public String getstudent_img() {
		return student_img;
	}

	public void setstudent_img(String student_img) {
		this.student_img = student_img;
		try {
			Bitmap bitmap = getBitmap(student_img);
			student_img1.setImageBitmap(bitmap);
			bitmap = null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Boolean getIsSelected() {
		return isSelected;
	}

	public void setIsSelected(Boolean isSelected) {
		this.isSelected = isSelected;
		
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

	private class MyOnClick implements OnClickListener {

		@Override
		public void onClick(View v) {
		/*	if (!isSelected) {
				relativeLayout1.setBackgroundResource(R.drawable.selectedborder);
				myItemClicked.myItemClicked();
			} else {
				relativeLayout1.setBackgroundResource(R.drawable.border);
				myItemClicked.myItemClicked();
			}*/
			myItemClicked.myItemClicked();
		}
	}

	public interface MyItemClicked {
		public void myItemClicked();
	}

	public void setMyItemClickedListener(MyItemClicked myItemClicked) {
		this.myItemClicked = myItemClicked;
	}
}
