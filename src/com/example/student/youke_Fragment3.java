package com.example.student;

import com.zhy.tree_view.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class youke_Fragment3 extends Fragment{
	 @Override
	    public void onAttach(Activity activity) {
	    	
	    	Log.i("liujun", "youke_Fragment3--onAttach");
	    	
	        super.onAttach(activity);
	     
	    }


		@Override
		public void onCreate(Bundle savedInstanceState) {
			
			Log.i("liujun", "youke_Fragment3--onCreate");
			
			super.onCreate(savedInstanceState);
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			
			Log.i("liujun", "youke_Fragment3--onCreateView");
			
			//����Ƭ�ζ�Ӧ�Ĳ����ļ�
			View parentView = inflater.inflate(R.layout.youkekecheng_ping, container, false);

			return parentView;
			// return super.onCreateView(, container, savedInstanceState);
		}


		@Override
		public void onDestroy() {
			
			Log.i("liujun", "youke_Fragment3--onDestroy");
			
			super.onDestroy();
			
		}


		@Override
		public void onDestroyView() {
			Log.i("liujun", "youke_Fragment3--onDestroyView");
			super.onDestroyView();
		}


		@Override
		public void onDetach() {
			Log.i("liujun", "youke_Fragment3--onDetach");
			super.onDetach();
		}


		@Override
		public void onStop() {
			Log.i("liujun", "youke_Fragment3--onStop");
			
			super.onStop();
		}


}
