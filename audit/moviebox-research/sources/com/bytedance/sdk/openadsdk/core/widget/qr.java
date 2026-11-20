package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class qr extends com.bytedance.sdk.openadsdk.core.ExN.We {
    private int pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private float f28552sc;

    public qr(Context context) {
        super(context);
        this.f28552sc = 2.25f;
        this.pFF = 12;
        sc();
    }

    public qr(Context context, int i11, float f11) {
        super(context);
        this.f28552sc = f11;
        this.pFF = i11;
        sc();
    }

    public static com.bytedance.sdk.openadsdk.core.ExN.We pFF(Context context) {
        return new qr(context, 28, 5.0f);
    }

    public static com.bytedance.sdk.openadsdk.core.ExN.We sc(Context context) {
        return new qr(context);
    }

    private void sc() {
        setBackground(We.sc());
        setImageResource(com.bytedance.sdk.component.utils.Sfl.We(getContext(), "tt_close_btn"));
        int iZY = kX.zY(getContext(), this.f28552sc);
        setPadding(iZY, iZY, iZY, iZY);
        setScaleType(ImageView.ScaleType.FIT_XY);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ExN.We, android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams != null) {
            int iZY = kX.zY(getContext(), this.pFF);
            layoutParams.width = iZY;
            layoutParams.height = iZY;
        }
        super.setLayoutParams(layoutParams);
    }
}
