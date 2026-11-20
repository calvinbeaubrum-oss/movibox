package com.applovin.impl;

import android.content.Context;
import android.graphics.PorterDuff;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class o extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ProgressBar f21433a;

    public o(Context context, int i11, int i12) {
        RelativeLayout.LayoutParams layoutParams;
        super(context);
        setClickable(false);
        ProgressBar progressBar = new ProgressBar(context, null, i12);
        this.f21433a = progressBar;
        progressBar.setIndeterminate(true);
        progressBar.setClickable(false);
        if (i11 == -2 || i11 == -1) {
            layoutParams = new RelativeLayout.LayoutParams(i11, i11);
        } else {
            int iDpToPx = AppLovinSdkUtils.dpToPx(context, i11);
            layoutParams = new RelativeLayout.LayoutParams(iDpToPx, iDpToPx);
        }
        layoutParams.addRule(13);
        progressBar.setLayoutParams(layoutParams);
        addView(progressBar);
    }

    public void a() {
        setVisibility(0);
    }

    public void b() {
        setVisibility(8);
    }

    public void setColor(int i11) {
        this.f21433a.getIndeterminateDrawable().setColorFilter(i11, PorterDuff.Mode.SRC_IN);
    }
}
