package com.bytedance.sdk.openadsdk.zY;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class UFX extends View {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final int f28814sc;

    public UFX(Context context) {
        this(context, Color.parseColor("#25000000"));
    }

    public UFX(Context context, int i11) {
        super(context);
        setBackgroundColor(i11);
        this.f28814sc = kX.zY(getContext(), 0.66f);
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        setMeasuredDimension(getMeasuredWidth(), this.f28814sc);
    }
}
