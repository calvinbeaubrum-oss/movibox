package com.transsion.publish.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class MatchParentVideoView extends VideoView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f56645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f56646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f56647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f56648d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f56649f;

    public MatchParentVideoView(Context context) {
        this(context, null);
    }

    public MatchParentVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MatchParentVideoView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f56645a = 0;
        this.f56646b = 0;
        this.f56647c = 0;
        this.f56648d = 0;
        this.f56649f = 0;
    }

    public int getVideoHeight() {
        return this.f56646b;
    }

    public int getVideoWidth() {
        return this.f56645a;
    }

    @Override // android.widget.VideoView
    public void setVideoPath(String str) {
        super.setVideoPath(str);
    }
}
