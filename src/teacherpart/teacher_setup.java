package teacherpart;

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

import com.example.student.loginActivity;
import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import webservice.Bychangeicon1;
import webservice.Bychangeteachericon;
import webservice.Bychangeteachername;
import webservice.Byupclass;

public class teacher_setup  extends Activity{
	
	private static int CAMERE_REQUEST_CODE=1;
	private static int GALLERY_REQUEST_CODE=2;
	private static int CROP_REQUEST_CODE=3;
	final Context context = this;
	TextView teacher_setup_picbt;

	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.teacher_setup);
		//从数据库获取图片
		sharp.CircleImageView head2 = (sharp.CircleImageView) 
					findViewById(R.id.teacher_setup_picture);
		String account = ApkEntity.getaccount();
		String strParams = "account:" + account;
		String retString=Bychangeicon1.LogSelect(strParams);
		String strURL = retString;
		try {
			Bitmap bitmap = getBitmap(strURL);
			head2.setImageBitmap(bitmap);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Button teacher_setupfh = (Button) findViewById(R.id.teacher_setupfh);
		teacher_setup_picbt = (TextView) findViewById(R.id.teacher_setup_picbt);
		Button teacher_setup_ghbt = (Button) findViewById(R.id.teacher_setup_ghbt);
		Button teacher_setup_bdsjhbt = (Button) findViewById(R.id.teacher_setup_bdsjhbt);
		Button teacher_setup_zx = (Button) findViewById(R.id.teacher_setup_zx);
		
		teacher_setup_picbt.setText(ApkEntity.getaccount_name());
		
		teacher_setup_ghbt.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LayoutInflater li = LayoutInflater.from(context);
				View promptsView = li.inflate(R.layout.prompts, null);

				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
						context);

				// set prompts.xml to alertdialog builder
				alertDialogBuilder.setView(promptsView);

				final EditText userInput = (EditText) promptsView
						.findViewById(R.id.editTextDialogUserInput);

				// set dialog message
				alertDialogBuilder
					.setCancelable(false)
					.setPositiveButton("OK",
					  new DialogInterface.OnClickListener() {
					    public void onClick(DialogInterface dialog,int id) {
						// get user input and set it to result
						// edit text
					    	String account = ApkEntity.getaccount();
					    	String deadline=userInput.getText().toString();
					    	String str = "account:" + account+"|newname:" + deadline;
							String retString=Bychangeteachername.LogSelect(str);
							if (retString.equals("1")) {
					    		
								
								Toast.makeText(context,"修改昵称成功",
										Toast.LENGTH_LONG).show();
								teacher_setup_picbt.setText(deadline);
								
							}
					    	else {
					    		Toast.makeText(context,"请重新修改！",
										Toast.LENGTH_LONG).show();
					    	}
					    }
					  })
					.setNegativeButton("Cancel",
					  new DialogInterface.OnClickListener() {
					    public void onClick(DialogInterface dialog,int id) {
						dialog.cancel();
					    }
					  });

				// create alert dialog
				AlertDialog alertDialog = alertDialogBuilder.create();

				// show it
				alertDialog.show();
		}
		});	
		teacher_setupfh.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(teacher_setup.this, teacherpage.class);
				startActivity(intent);
		}
		});	
		teacher_setup_zx.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(teacher_setup.this, loginActivity.class);
				startActivity(intent);
		}
		});	
		head2.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new AlertDialog.Builder(teacher_setup.this)
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
			intent.putExtra("aspectX", 1);
			intent.putExtra("aspectY", 1);
			intent.putExtra("outputX", 150);
			intent.putExtra("outputY", 150);
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
				sharp.CircleImageView head2 = (sharp.CircleImageView) 
	  					findViewById(R.id.teacher_setup_picture);
				/*head.setImageBitmap(bm);*/
				head2.setImageBitmap(bm);
				
				//将bitmap格式的图片转化为base64格式并上传
				ByteArrayOutputStream bStream = new ByteArrayOutputStream();
				bm.compress(CompressFormat.JPEG, 100, bStream);
				String uploadBuffer = new String(Base64.encode(bStream.toByteArray(), Base64.DEFAULT));  //进行Base64编码
				//自定义名称 id+时间
				SimpleDateFormat   formatter   =   new   SimpleDateFormat   ("yyyy-MM-dd-HH-mm-ss"); 
				Date   curDate   =   new   Date(System.currentTimeMillis());
				String   str   =   formatter.format(curDate); 
				String account = ApkEntity.getaccount();
				String filename = account+str+".jpg";
				Toast.makeText(getApplicationContext(), filename, Toast.LENGTH_SHORT).show();
				String strParams = "account:" + account
						+ "|fileName:" + filename
						+ "|buffer:" + uploadBuffer;  
				String retString=Bychangeteachericon.LogSelect(strParams);
				if (retString.equals("1")) {
	        		
					
					Toast.makeText(getApplicationContext(), "图片修改成功", Toast.LENGTH_LONG).show();
					
				}
	        	else  {						
						Toast.makeText(getApplicationContext(), "图片修改失败", Toast.LENGTH_SHORT).show();
						
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
					return bitmap;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

}
