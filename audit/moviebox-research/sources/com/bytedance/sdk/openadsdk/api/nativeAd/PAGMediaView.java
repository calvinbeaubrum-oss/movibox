package com.bytedance.sdk.openadsdk.api.nativeAd;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class PAGMediaView extends FrameLayout {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected Integer f27675sc;

    public PAGMediaView(@NonNull Context context) {
        super(context);
    }

    public PAGMediaView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PAGMediaView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    @RequiresApi(api = 21)
    public PAGMediaView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
    }

    public void close() {
    }

    public void setMrcTrackerKey(Integer num) {
        this.f27675sc = num;
    }

    public void setVideoAdListener(PAGVideoAdListener pAGVideoAdListener) {
    }
}
