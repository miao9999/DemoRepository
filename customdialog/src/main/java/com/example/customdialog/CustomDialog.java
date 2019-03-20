package com.example.customdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * Created by limiao on 2018/8/9.
 */
public  class CustomDialog {


    public interface ClickListener{
        void yesClick();
        void noClick();
    }


    /**
     * 确认退出
     */
    public static void confirmClose(Context context, String detailMsg, String titleMsg, final ClickListener clickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.item_exit_dialog, null);
        TextView msgTv, yesTv, noTv, detailTv;
        detailTv = view.findViewById(R.id.detail_tv);
        msgTv = view.findViewById(R.id.msg_tv);
        yesTv = view.findViewById(R.id.yes_tv);
        noTv = view.findViewById(R.id.no_tv);
        detailTv.setText(detailMsg);
        msgTv.setText(titleMsg);
        builder.setView(view);
        final AlertDialog dialog = builder.create();
        yesTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clickListener.yesClick();
            }
        });
        noTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
                clickListener.noClick();
            }
        });
        dialog.show();
    }
}
