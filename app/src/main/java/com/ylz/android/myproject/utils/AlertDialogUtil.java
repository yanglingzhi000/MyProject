package com.ylz.android.myproject.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ylz.android.myproject.R;


public class AlertDialogUtil {

	public static final int SETOK = -100;
	public static final int SETCANCEL = -99;
	public static final int GETNUMBER = -98;

	/**
	 * 弹出对话框
	 */
	@SuppressLint("NewApi")
	public static void showDialog(Activity context,String title,String message,final Handler mhandler) {
		Builder builer = new Builder(context, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
		builer.setTitle(title);
		builer.setMessage(message);
		//当点确定按钮时从服务器上下载 新的apk 然后安装
		builer.setPositiveButton("确定", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				mhandler.obtainMessage(AlertDialogUtil.SETOK).sendToTarget();
			}
		});
		//当点取消按钮时进行登录
		builer.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				mhandler.obtainMessage(AlertDialogUtil.SETCANCEL).sendToTarget();
			}
		});
		AlertDialog dialog = builer.create();
		dialog.show();
	}
	public static void showNumEditDialog(Activity context, String title, String message, final Handler mhandler){
		Builder builder = new Builder(context, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
		View view  = context.getLayoutInflater().inflate(R.layout.alert_edit_dialog,null);
		TextView dialog_text = (TextView) view.findViewById(R.id.dialog_text);
		builder.setTitle(title);
		dialog_text.setText(message);
		final EditText dialog_edit = (EditText) view.findViewById(R.id.dialog_edit);
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				mhandler.obtainMessage(GETNUMBER, dialog_edit.getText().toString()).sendToTarget();
			}
		});
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				mhandler.obtainMessage(AlertDialogUtil.SETCANCEL).sendToTarget();
			}
		});
		builder.setView(view);
		AlertDialog dialog = builder.create();
		dialog.show();
	}



}

