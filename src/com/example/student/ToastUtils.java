package com.example.student;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

public class ToastUtils {

    private ToastUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /* �Ƿ�toast�ܿ��� */
    public static boolean isShow = true;

    public static void showStaticToast(final Activity act, final String msg) {
        //��ȡ��ǰ�߳�
        String nowThreadName = Thread.currentThread().getName();
        //���Ϊ���߳�
        if ("main".equals(nowThreadName)) {
            if (isShow)
                showToast(act, msg);

            //���Ϊ���߳�
        } else {
            act.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (isShow)
                        showToast(act, msg);
                }
            });
        }
    }


    private static Toast toast;

    //��������̵߳���̬��˾����ʹ����������������ļ���
    public static void showToast(Context context, final String msg) {

        if (toast == null) {
            toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        }
        toast.setText(msg);
        if (isShow)
            toast.show();
    }

    /**
     * ��ʱ����ʾToast
     */
    public static void showShortToast(Context context, String message) {
        if (isShow)
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * ��ʱ����ʾToast
     */
    public static void showLongToast(Context context, String message) {
        if (isShow)
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

}
