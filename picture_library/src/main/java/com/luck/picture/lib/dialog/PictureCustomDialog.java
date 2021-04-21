package com.luck.picture.lib.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.luck.picture.lib.R;
import com.luck.picture.lib.utils.MResource;

public class PictureCustomDialog extends Dialog {

    public PictureCustomDialog(Context context, int layout) {
        super(context, MResource.getIdentifier(context, "style", "a_sdk_dialog_theme"));
        setContentView(layout);
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams params = window.getAttributes();
            params.width = ViewGroup.LayoutParams.MATCH_PARENT;
            params.height = ViewGroup.LayoutParams.MATCH_PARENT;
            params.gravity = Gravity.CENTER;
            window.setAttributes(params);
        }
    }
}
