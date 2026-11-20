package com.bytedance.sdk.openadsdk.Ql;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.Sfl;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.Xc;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class WH extends com.bytedance.sdk.openadsdk.core.ExN.zY {
    protected com.bytedance.sdk.openadsdk.core.ExN.Qj ExN;
    protected com.bytedance.sdk.openadsdk.core.ExN.Qj TRI;
    protected com.bytedance.sdk.openadsdk.core.ExN.Qj We;
    protected com.bytedance.sdk.openadsdk.core.ExN.We pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.ExN.zY f27113sc;
    protected Xc zY;

    public WH(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        sc(context);
    }

    public com.bytedance.sdk.openadsdk.core.ExN.zY ExN(Context context) {
        return new com.bytedance.sdk.openadsdk.core.ExN.zY(context);
    }

    public PAGLogoView Qj(Context context) {
        PAGLogoView pAGLogoView = new PAGLogoView(context);
        pAGLogoView.setId(520093739);
        return pAGLogoView;
    }

    public com.bytedance.sdk.openadsdk.core.ExN.We TRI(Context context) {
        com.bytedance.sdk.openadsdk.core.ExN.We we2 = new com.bytedance.sdk.openadsdk.core.ExN.We(context);
        we2.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return we2;
    }

    public com.bytedance.sdk.openadsdk.core.ExN.Qj We(Context context) {
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj2 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        qj2.setBackground(com.bytedance.sdk.openadsdk.utils.Ol.sc(context, "tt_backup_btn_1"));
        qj2.setGravity(17);
        qj2.setText(Sfl.sc(context, "tt_video_download_apk"));
        qj2.setTextColor(-1);
        qj2.setTextSize(2, 14.0f);
        return qj2;
    }

    public FrameLayout getTtAdContainer() {
        return this.f27113sc;
    }

    public TextView getTtFullAdAppName() {
        return this.We;
    }

    public TextView getTtFullAdDesc() {
        return this.ExN;
    }

    public TextView getTtFullAdDownload() {
        return this.TRI;
    }

    public Xc getTtFullAdIcon() {
        return this.zY;
    }

    public ImageView getTtFullImg() {
        return this.pFF;
    }

    public com.bytedance.sdk.openadsdk.core.ExN.Qj pFF(Context context) {
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj2 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        qj2.setEllipsize(TextUtils.TruncateAt.END);
        qj2.setMaxLines(1);
        qj2.setTextColor(Color.parseColor("#FF999999"));
        qj2.setTextSize(2, 16.0f);
        return qj2;
    }

    public Xc qr(Context context) {
        Xc xc2 = new Xc(context);
        xc2.setScaleType(ImageView.ScaleType.FIT_XY);
        xc2.setBackgroundColor(0);
        return xc2;
    }

    public abstract void sc(Context context);

    public com.bytedance.sdk.openadsdk.core.ExN.Qj zY(Context context) {
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj2 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(context);
        qj2.setEllipsize(TextUtils.TruncateAt.END);
        qj2.setMaxLines(1);
        qj2.setSingleLine();
        qj2.setTextColor(Color.parseColor("#FF999999"));
        qj2.setTextSize(2, 12.0f);
        return qj2;
    }
}
