package br.com.carregai.carregai2.model;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import br.com.carregai.carregai2.R;

public class CustomProgressDialog extends Dialog {
    private ImageView imageview;

    public CustomProgressDialog(Context context, int resourceIdOfImage) {
        super(context, R.style.TransparentProgressDialog);
        WindowManager.LayoutParams windowmanger = getWindow().getAttributes();
        windowmanger.gravity = Gravity.CENTER_HORIZONTAL;
        getWindow().setAttributes(windowmanger);
        setTitle(null);
        setCancelable(false);
        setOnCancelListener(null);
        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams params = new  LinearLayout.LayoutParams(196, 138);
        imageview = new ImageView(context);
        imageview.setBackgroundResource(R.drawable.loading_animation);
        layout.addView(imageview, params);
        addContentView(layout, params);
    }

    @Override
    public void show() {
        super.show();
        AnimationDrawable frameAnimation = (AnimationDrawable)imageview.getBackground();
        frameAnimation.start();
    }

    public void dismiss(){

    }
}