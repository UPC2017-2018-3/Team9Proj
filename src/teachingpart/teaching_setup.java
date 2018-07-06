package teachingpart;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.example.student.loginActivity;
import com.imooc.systemwork.ApkEntity;
import com.zhy.tree_view.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import teacherpart.teacher_setup;
import webservice.Bychangeadminname;
import webservice.Byupclass;


public class teaching_setup extends Activity{
	
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
							String retString=Bychangeadminname.LogSelect(str);
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
				intent.setClass(teaching_setup.this, teachingpage.class);
				startActivity(intent);
		}
		});	
		teacher_setup_zx.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(teaching_setup.this, loginActivity.class);
				startActivity(intent);
		}
		});	
		teacher_setup_picbt.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new AlertDialog.Builder(teaching_setup.this)
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
				sharp.CircleImageView head2 = (sharp.CircleImageView) 
	  					findViewById(R.id.teacher_setup_picture);
				/*head.setImageBitmap(bm);*/
				head2.setImageBitmap(bm);
				
			}
			
				
		}

}

