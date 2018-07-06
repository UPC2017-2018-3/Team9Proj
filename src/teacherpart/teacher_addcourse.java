package teacherpart;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import webservice.Byupcourse;

public class teacher_addcourse extends Activity{
	
	private static int CAMERE_REQUEST_CODE=1;
	private static int GALLERY_REQUEST_CODE=2;
	private static int CROP_REQUEST_CODE=3;
	private  Bitmap bit;
	private EditText teacher_addcourseet1,teacher_addcourseet2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.teacher_addcourse);
		Button fanhuibt = (Button) findViewById(R.id.teacher_addcourserb);
		ImageView teacher_addcoursepic = (ImageView) findViewById(R.id.teacher_addcoursepic);
		teacher_addcourseet1 = (EditText)findViewById(R.id.teacher_addcourseet1);
		teacher_addcourseet2 = (EditText)findViewById(R.id.teacher_addcourseet2);
		Button teacher_setup_zx = (Button) findViewById(R.id.teacher_setup_zx);
		
		teacher_setup_zx.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String name=teacher_addcourseet1.getText().toString();
				String tips=teacher_addcourseet2.getText().toString();
				//将bitmap格式的图片转化为base64格式并上传
				ByteArrayOutputStream bStream = new ByteArrayOutputStream();
				bit.compress(CompressFormat.JPEG, 100, bStream);
				String uploadBuffer = new String(Base64.encode(bStream.toByteArray(), Base64.DEFAULT));  //进行Base64编码
				//自定义名称 id+时间
				SimpleDateFormat   formatter   =   new   SimpleDateFormat   ("yyyy-MM-dd-HH-mm-ss"); 
				Date   curDate   =   new   Date(System.currentTimeMillis());
				String   str   =   formatter.format(curDate); 
				String account = ApkEntity.getaccount();
				String filename = account+str+".jpg";
				
				 String strParams="name:"+name+"|account:"+account+"|fileName:"+filename+"|buffer:"+uploadBuffer
			             +"|content:"+tips;
	             String retString=Byupcourse.LogSelect(strParams);
	             if (retString.equals("1")) {
		        		
						
						Toast.makeText(getApplicationContext(), "新建课程成功", Toast.LENGTH_LONG).show();
						
					}		     
		        	else {
		        		Toast.makeText(getApplicationContext(), "新建课程失败", Toast.LENGTH_SHORT).show();
		        	}
			}
		});
		
		
		fanhuibt.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(teacher_addcourse.this, teacher_coursemanagement.class);
				startActivity(intent);
			}
		});
		
		teacher_addcoursepic.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new AlertDialog.Builder(teacher_addcourse.this)
				.setTitle("修改头像")
				.setItems(
						new String[] {
								"拍照上传",
								"上传手机中的照片" },
						new DialogInterface.OnClickListener() {

							public void onClick(
									DialogInterface dialog,
									int which) {
								Intent intent = null;
								switch (which) {
								case 0:
									intent = new Intent(
											MediaStore.ACTION_IMAGE_CAPTURE);
									startActivityForResult(intent, CAMERE_REQUEST_CODE);
									
									break;

								case 1:
									intent = new Intent(
											Intent.ACTION_GET_CONTENT);
									intent.setType(	"image/*");
										startActivityForResult(
													intent,GALLERY_REQUEST_CODE
													);
									break;
								}
							}
						})
				.setNegativeButton(
						"取消",
						new DialogInterface.OnClickListener() {

							public void onClick(
									DialogInterface dialog,
									int which) {
								dialog.cancel();
							}
						}).create().show();
		
			}
		});
	}
	
	private Uri savebitmap (Bitmap bm)
    {
		File tmpDir = new File(Environment.getExternalStorageDirectory()+"/com.education.avater");
		if(!tmpDir.exists())
		{
			tmpDir.mkdir();
		}
		File img = new File(tmpDir.getAbsolutePath()+"avater.png");
		try {
			FileOutputStream fos = new FileOutputStream(img);
			bm.compress(Bitmap.CompressFormat.PNG, 85, fos);
			fos.flush();
			fos.close();
			return Uri.fromFile(img);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
    
    private Uri convertUri (Uri uri)
    {
		InputStream is = null;
		try {
			is = getContentResolver().openInputStream(uri);
			Bitmap bitmap = BitmapFactory.decodeStream(is);
			is.close();
			return savebitmap(bitmap);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
    
    private void startImageZoom(Uri uri) 
    {
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(uri,"image/*");
		intent.putExtra("crop", "ture");
		intent.putExtra("aspectX", 6);
		intent.putExtra("aspectY", 5);
		intent.putExtra("outputX", 360);
		intent.putExtra("outputY", 300);
		intent.putExtra("return-data",true);
		startActivityForResult(intent, CROP_REQUEST_CODE);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if(requestCode==CAMERE_REQUEST_CODE)
			
		{
			if(data==null)
			{
				return;
			}
			
			else
			{
			    Bundle extras = data.getExtras();
			    if(extras != null)
			    {
			    	Bitmap bm= extras.getParcelable("data");
			    	Uri uri = savebitmap(bm);
			    	startImageZoom(uri);
			    }
			}
		}
			
		else if(requestCode==GALLERY_REQUEST_CODE)
			
		{
			if(data==null)
			{
				return;
			}
			Uri uri;
			uri=data.getData();
			
			Uri fileUri = convertUri(uri);
			startImageZoom(fileUri);
			
		}
		else if (requestCode==CROP_REQUEST_CODE)
		{
			if(data==null)
			{
				return;
			}
			Bundle extras =data.getExtras();
			Bitmap bm= extras.getParcelable("data");
			/*ImageView head = (ImageView) 
  					findViewById(R.id.mine_picture);*/
			ImageView head2 = (ImageView) 
  					findViewById(R.id.teacher_addcoursepic);
			/*head.setImageBitmap(bm);*/
			head2.setImageBitmap(bm);
			bit = bm;
		}
		
			
	}


}
