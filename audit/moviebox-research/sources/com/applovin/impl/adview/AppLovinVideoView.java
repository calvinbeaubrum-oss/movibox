package com.applovin.impl.adview;

import android.content.Context;
import android.widget.VideoView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class AppLovinVideoView extends VideoView {
    public AppLovinVideoView(Context context) {
        super(context, null, 0);
    }

    public void setVideoSize(int i11, int i12) {
        getHolder().setFixedSize(i11, i12);
        requestLayout();
        invalidate();
    }
}
