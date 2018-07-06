package teachingpart;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import android.widget.ImageView;
import android.widget.Toast;
import webservice.Byallsensitivewords;
import webservice.Bychangeicon1;
import webservice.Bychangeteachericon;
import webservice.Bylunbo;
import webservice.Byuplunbo;

public class teaching_carousel_diagram_management extends Activity{
	
	private static int CAMERE_REQUEST_CODE=1;
	private static int GALLERY_REQUEST_CODE=2;
	private static int CROP_REQUEST_CODE=3;
	private static String number;
	private  String intArray[]=new String[5]; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState)

	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.teaching_carousel_diagram_management);
		Button teacher_setupfh = (Button) findViewById(R.id.carousel_diagram_managementfhbt);
		Button teacher_setup_picbt1 = (Button) findViewById(R.id.carousel_diagram_bj1);
		Button teacher_setup_picbt2 = (Button) findViewById(R.id.carousel_diagram_bj2);
		Button teacher_setup_picbt3 = (Button) findViewById(R.id.carousel_diagram_bj3);
		ImageView carousel_diagram_img1 =(ImageView)findViewById(R.id.carousel_diagram_img1);
		ImageView carousel_diagram_img2 =(ImageView)findViewById(R.id.carousel_diagram_img2);
		ImageView carousel_diagram_img3 =(ImageView)findViewById(R.id.carousel_diagram_img3);
		String organization = ApkEntity.getorganization();
		String strParams = "organization:" + organization;
		List<Bylunbo> lgroup=Bylunbo.listGroup(strParams);
		
		for (int i = 0; i < lgroup.size(); i++) {
			
			intArray[i] = lgroup.get(i).lb;
		
		}

		try {
			Bitmap bitmap1 = getBitmap(intArray[0]);
			carousel_diagram_img1.setImageBitmap(bitmap1);
			bitmap1 = null;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Bitmap bitmap2 = getBitmap(intArray[1]);
			carousel_diagram_img2.setImageBitmap(bitmap2);
			bitmap2 = null;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		teacher_setupfh.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(teaching_carousel_diagram_management.this, teachingpage.class);
				startActivity(intent);
		}
		});	
		try {
			Bitmap bitmap3 = getBitmap(intArray[2]);
			carousel_diagram_img3.setImageBitmap(bitmap3);
			bitmap3 = null;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		teacher_setup_picbt1.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				number = "1";
				new AlertDialog.Builder(teaching_carousel_diagram_management.this)
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
		teacher_setup_picbt2.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				number = "2";
				new AlertDialog.Builder(teaching_carousel_diagram_management.this)
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
		teacher_setup_picbt3.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				number = "3";
				new AlertDialog.Builder(teaching_carousel_diagram_management.this)
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
		intent.putExtra("aspectX", 5);
		intent.putExtra("aspectY", 3);
		intent.putExtra("outputX", 350);
		intent.putExtra("outputY", 210);
		intent.putExtra("return-data",true);
		startActivityForResult(intent, CROP_REQUEST_CODE);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
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
			if(number.equals("1")) {
				ImageView carousel_diagram_img1 =(ImageView)findViewById(R.id.carousel_diagram_img1);
			/*head.setImageBitmap(bm);*/
				carousel_diagram_img1.setImageBitmap(bm);
				//将bitmap格式的图片转化为base64格式并上传
				ByteArrayOutputStream bStream = new ByteArrayOutputStream();
				bm.compress(CompressFormat.JPEG, 100, bStream);
				String uploadBuffer = new String(Base64.encode(bStream.toByteArray(), Base64.DEFAULT));  //进行Base64编码
				//自定义名称 id+时间
				SimpleDateFormat   formatter   =   new   SimpleDateFormat   ("yyyy-MM-dd-HH-mm-ss"); 
				Date   curDate   =   new   Date(System.currentTimeMillis());
				String   str   =   formatter.format(curDate); 
				String organization = ApkEntity.getorganization();
				String filename = organization+str+".jpg";
				String strParams = "number:" + number
						+ "|fileName:" + filename
						+ "|buffer:" + uploadBuffer
						+ "|organization:" + organization;  
				String retString=Byuplunbo.LogSelect(strParams);
				if (retString.equals("1")) {
	        		
					
					Toast.makeText(getApplicationContext(), "图片修改成功", Toast.LENGTH_LONG).show();
					
				}
	        	else  {						
						Toast.makeText(getApplicationContext(), "图片修改失败", Toast.LENGTH_SHORT).show();
						
					}
			}
			else if(number.equals("2")) {
				ImageView carousel_diagram_img2 =(ImageView)findViewById(R.id.carousel_diagram_img2);
			/*head.setImageBitmap(bm);*/
				carousel_diagram_img2.setImageBitmap(bm);
				ByteArrayOutputStream bStream = new ByteArrayOutputStream();
				bm.compress(CompressFormat.JPEG, 100, bStream);
				String uploadBuffer = new String(Base64.encode(bStream.toByteArray(), Base64.DEFAULT));  //进行Base64编码
				//自定义名称 id+时间
				SimpleDateFormat   formatter   =   new   SimpleDateFormat   ("yyyy-MM-dd-HH-mm-ss"); 
				Date   curDate   =   new   Date(System.currentTimeMillis());
				String   str   =   formatter.format(curDate); 
				String organization = ApkEntity.getorganization();
				String filename = organization+str+".jpg";
				String strParams = "number:" + number
						+ "|fileName:" + filename
						+ "|buffer:" + uploadBuffer
						+ "|organization:" + organization;  
				String retString=Byuplunbo.LogSelect(strParams);
				if (retString.equals("1")) {
	        		
					
					Toast.makeText(getApplicationContext(), "图片修改成功", Toast.LENGTH_LONG).show();
					
				}
	        	else  {						
						Toast.makeText(getApplicationContext(), "图片修改失败", Toast.LENGTH_SHORT).show();
						
					}
			}
			else {
				ImageView carousel_diagram_img3 =(ImageView)findViewById(R.id.carousel_diagram_img3);
			/*head.setImageBitmap(bm);*/
				carousel_diagram_img3.setImageBitmap(bm);
				ByteArrayOutputStream bStream = new ByteArrayOutputStream();
				bm.compress(CompressFormat.JPEG, 100, bStream);
				String uploadBuffer = new String(Base64.encode(bStream.toByteArray(), Base64.DEFAULT));  //进行Base64编码
				//自定义名称 id+时间
				SimpleDateFormat   formatter   =   new   SimpleDateFormat   ("yyyy-MM-dd-HH-mm-ss"); 
				Date   curDate   =   new   Date(System.currentTimeMillis());
				String   str   =   formatter.format(curDate); 
				String organization = ApkEntity.getorganization();
				String filename = organization+str+".jpg";
				String strParams = "number:" + number
						+ "|fileName:" + filename
						+ "|buffer:" + uploadBuffer
						+ "|organization:" + organization;  
				String retString=Byuplunbo.LogSelect(strParams);
				if (retString.equals("1")) {
	        		
					
					Toast.makeText(getApplicationContext(), "图片修改成功", Toast.LENGTH_LONG).show();
					
				}
	        	else  {						
						Toast.makeText(getApplicationContext(), "图片修改失败", Toast.LENGTH_SHORT).show();
						
					}
			}
			
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
				inputStream.close();
				return bitmap;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
