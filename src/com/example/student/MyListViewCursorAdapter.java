package com.example.student;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

//public class MyListViewCursorAdapter extends CursorAdapter{
//    public MyListViewCursorAdapter(Context context, Cursor c) {
//        super(context, c);
//    }
//
//    public View newView(Context context, Cursor cursor, ViewGroup parent) {
//        ViewHolder viewHolder=new ViewHolder();
//        //获取view
//        View view = View.inflate(context, R.layout.search_listview, null);
//        //寻找控件
//        viewHolder.tv= (TextView) view.findViewById(R.id.search_tv1);
//
//        view.setTag(viewHolder);
//        return view;
//    }
//
//    public void bindView(View view, Context context, Cursor cursor) {
//
//        ViewHolder viewHolder= (ViewHolder) view.getTag();
//        //从cursor中获取值
//        String name = cursor.getString(cursor.getColumnIndex("name"));
//        //把数据设置到控件上面
//        viewHolder.tv.setText(name);
//
//    }
//
//    class ViewHolder{
//        TextView tv;
//    }
//}
