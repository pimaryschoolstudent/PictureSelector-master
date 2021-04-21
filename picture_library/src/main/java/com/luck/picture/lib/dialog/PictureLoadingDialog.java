package com.luck.picture.lib.dialog;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

import com.luck.picture.lib.R;
import com.luck.picture.lib.utils.MResource;

public class PictureLoadingDialog extends Dialog {
    private Context mContext;

    public PictureLoadingDialog(Context context) {
        //super(context, R.style.Picture_Theme_AlertDialog);
        super(context, MResource.getIdentifier(context,"style","Picture_Theme_AlertDialog"));
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        if (window != null) {
            window.setWindowAnimations(MResource.getIdentifier(context,"style","PictureThemeDialogWindowStyle"));
        }
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(MResource.getIdentifier(mContext,"layout","picture_alert_dialog"));
    }
}