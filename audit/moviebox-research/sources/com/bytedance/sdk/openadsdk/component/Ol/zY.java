package com.bytedance.sdk.openadsdk.component.Ol;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.Xc;
import com.bytedance.sdk.openadsdk.core.widget.dE;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zY extends com.bytedance.sdk.openadsdk.core.ExN.qr {
    com.bytedance.sdk.openadsdk.core.ExN.Qj ExN;
    Xc Ol;
    final qr Qj;
    Xc TRI;
    com.bytedance.sdk.openadsdk.core.widget.zY Tf;
    com.bytedance.sdk.openadsdk.core.ExN.Qj UFX;
    com.bytedance.sdk.openadsdk.core.ExN.Qj WH;
    PAGLogoView We;
    com.bytedance.sdk.openadsdk.core.ExN.zY pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    com.bytedance.sdk.openadsdk.core.ExN.Qj f27747qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    com.bytedance.sdk.openadsdk.core.ExN.We f27748sc;
    com.bytedance.sdk.openadsdk.core.ExN.We zY;

    public zY(Context context) {
        super(context);
        this.Qj = new qr(context);
    }

    public abstract com.bytedance.sdk.openadsdk.core.ExN.We getAdIconView();

    public PAGLogoView getAdLogo() {
        return this.We;
    }

    public abstract com.bytedance.sdk.openadsdk.core.ExN.Qj getAdTitleTextView();

    public com.bytedance.sdk.openadsdk.core.ExN.We getBackImage() {
        return this.f27748sc;
    }

    public com.bytedance.sdk.openadsdk.core.ExN.Qj getClickButton() {
        return this.ExN;
    }

    public com.bytedance.sdk.openadsdk.core.ExN.Qj getContent() {
        return this.UFX;
    }

    public com.bytedance.sdk.openadsdk.core.widget.zY getDspAdChoice() {
        return this.Tf;
    }

    public Xc getHostAppIcon() {
        return this.TRI;
    }

    public com.bytedance.sdk.openadsdk.core.ExN.Qj getHostAppName() {
        return this.f27747qr;
    }

    public Xc getIconOnlyView() {
        return this.Ol;
    }

    public com.bytedance.sdk.openadsdk.core.ExN.We getImageView() {
        return this.zY;
    }

    public com.bytedance.sdk.openadsdk.core.ExN.ExN getOverlayLayout() {
        return null;
    }

    public abstract dE getScoreBar();

    public com.bytedance.sdk.openadsdk.core.ExN.Qj getTitle() {
        return this.WH;
    }

    public View getTopDisLike() {
        qr qrVar = this.Qj;
        if (qrVar != null) {
            return qrVar.getTopDislike();
        }
        return null;
    }

    public com.bytedance.sdk.openadsdk.core.ExN.We getTopSkip() {
        qr qrVar = this.Qj;
        if (qrVar != null) {
            return qrVar.getTopSkip();
        }
        return null;
    }

    public abstract View getUserInfo();

    public com.bytedance.sdk.openadsdk.core.ExN.zY getVideoContainer() {
        return this.pFF;
    }
}
