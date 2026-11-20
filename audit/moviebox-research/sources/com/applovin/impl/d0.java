package com.applovin.impl;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class d0 extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewGroup f18329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AppLovinSdkUtils.Size f18330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Activity f18331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private RelativeLayout f18332d;

    public d0(ViewGroup viewGroup, AppLovinSdkUtils.Size size, Activity activity) {
        super(activity, R.style.Theme.Translucent.NoTitleBar);
        this.f18329a = viewGroup;
        this.f18330b = size;
        this.f18331c = activity;
        requestWindowFeature(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        dismiss();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.f18332d.removeView(this.f18329a);
        super.dismiss();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(AppLovinSdkUtils.dpToPx(this.f18331c, this.f18330b.getWidth()), AppLovinSdkUtils.dpToPx(this.f18331c, this.f18330b.getHeight()));
        layoutParams.addRule(13);
        this.f18329a.setLayoutParams(layoutParams);
        int iDpToPx = AppLovinSdkUtils.dpToPx(this.f18331c, 60);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iDpToPx, iDpToPx);
        layoutParams2.addRule(14);
        layoutParams2.addRule(12);
        ImageButton imageButton = new ImageButton(this.f18331c);
        imageButton.setLayoutParams(layoutParams2);
        imageButton.setImageDrawable(this.f18331c.getResources().getDrawable(com.applovin.sdk.R.drawable.applovin_ic_x_mark));
        imageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageButton.setColorFilter(-1);
        imageButton.setBackground(null);
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.xu
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f24418a.a(view);
            }
        });
        RelativeLayout relativeLayout = new RelativeLayout(this.f18331c);
        this.f18332d = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f18332d.setBackgroundColor(Integer.MIN_VALUE);
        this.f18332d.addView(imageButton);
        this.f18332d.addView(this.f18329a);
        this.f18332d.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.yu
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f24722a.b(view);
            }
        });
        setContentView(this.f18332d);
    }
}
