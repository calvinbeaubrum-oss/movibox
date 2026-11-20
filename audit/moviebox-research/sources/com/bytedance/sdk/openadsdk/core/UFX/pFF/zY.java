package com.bytedance.sdk.openadsdk.core.UFX.pFF;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY extends com.bytedance.adsdk.ugeno.pFF.zY<com.bytedance.sdk.openadsdk.core.widget.ExN> {
    protected ImageView.ScaleType pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected String f28290sc;

    public zY(Context context) {
        super(context);
        this.pFF = ImageView.ScaleType.FIT_CENTER;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private ImageView.ScaleType qr(String str) {
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        str.hashCode();
        byte b11 = -1;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals(TtmlNode.CENTER)) {
                    b11 = 0;
                }
                break;
            case -1274298614:
                if (str.equals("fitEnd")) {
                    b11 = 1;
                }
                break;
            case -522179887:
                if (str.equals("fitStart")) {
                    b11 = 2;
                }
                break;
            case -340708175:
                if (str.equals("centerInside")) {
                    b11 = 3;
                }
                break;
            case 97441490:
                if (str.equals("fitXY")) {
                    b11 = 4;
                }
                break;
            case 520762310:
                if (str.equals("fitCenter")) {
                    b11 = 5;
                }
                break;
            case 1161480325:
                if (str.equals("centerCrop")) {
                    b11 = 6;
                }
                break;
        }
        switch (b11) {
            case 0:
                return ImageView.ScaleType.CENTER;
            case 1:
                return ImageView.ScaleType.FIT_END;
            case 2:
                return ImageView.ScaleType.FIT_START;
            case 3:
                return ImageView.ScaleType.CENTER_INSIDE;
            case 4:
            default:
                return scaleType;
            case 5:
                return ImageView.ScaleType.FIT_CENTER;
            case 6:
                return ImageView.ScaleType.CENTER_CROP;
        }
    }

    private void zY() {
        if (TextUtils.isEmpty(this.f28290sc)) {
            return;
        }
        if (!this.f28290sc.startsWith("local://")) {
            com.bytedance.adsdk.ugeno.We.sc().pFF().sc(this.Tf, this.f28290sc, (ImageView) this.Qj);
        } else {
            ((com.bytedance.sdk.openadsdk.core.widget.ExN) this.Qj).sc(com.bytedance.adsdk.ugeno.qr.We.sc(this.ExN, this.f28290sc.replace("local://", "")), false);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.zY
    public void pFF() {
        super.pFF();
        zY();
        ((com.bytedance.sdk.openadsdk.core.widget.ExN) this.Qj).setScaleType(this.pFF);
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.zY
    /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.openadsdk.core.widget.ExN We() {
        com.bytedance.sdk.openadsdk.core.widget.ExN exN = new com.bytedance.sdk.openadsdk.core.widget.ExN(this.ExN);
        this.Qj = exN;
        return exN;
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.zY
    public void sc(String str, String str2) {
        super.sc(str, str2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.hashCode();
        if (str.equals("scaleType")) {
            this.pFF = qr(str2);
        } else if (str.equals("src")) {
            this.f28290sc = str2;
        }
    }
}
