package com.bytedance.sdk.openadsdk.component.Ol;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.dE;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ExN extends zY {
    sc Ql;

    /* JADX INFO: compiled from: source.java */
    public interface sc {
        void sc(View view, int i11);
    }

    public ExN(Context context, Sfl sfl) {
        super(context);
        sc(context, sfl);
    }

    private void sc(Context context, Sfl sfl) {
        com.bytedance.sdk.openadsdk.core.Qj.ExN exN = new com.bytedance.sdk.openadsdk.core.Qj.ExN(context);
        com.bytedance.sdk.openadsdk.core.Qj.We.sc().zY(exN);
        exN.sc(sfl, new com.bytedance.sdk.openadsdk.core.Qj.ExN.pFF() { // from class: com.bytedance.sdk.openadsdk.component.Ol.ExN.1
            @Override // com.bytedance.sdk.openadsdk.core.Qj.ExN.pFF
            public void e_() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.Qj.ExN.pFF
            public View pFF() {
                return ExN.this;
            }

            @Override // com.bytedance.sdk.openadsdk.core.Qj.ExN.pFF
            public View sc() {
                qr qrVar = ExN.this.Qj;
                if (qrVar != null) {
                    return qrVar.getTopDislike();
                }
                return null;
            }

            @Override // com.bytedance.sdk.openadsdk.core.Qj.ExN.pFF
            public void sc(int i11, int i12) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.Qj.ExN.pFF
            public void sc(View view, int i11) {
                sc scVar = ExN.this.Ql;
                if (scVar != null) {
                    scVar.sc(view, i11);
                }
            }
        }, "open_ad");
        addView(exN, new ViewGroup.LayoutParams(-1, -1));
        exN.dE();
        int iZY = kX.zY(context, 9.0f);
        int iZY2 = kX.zY(context, 10.0f);
        this.We = new PAGLogoView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, kX.zY(context, 14.0f));
        layoutParams.leftMargin = iZY2;
        layoutParams.bottomMargin = iZY2;
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        addView(this.We, layoutParams);
        com.bytedance.sdk.openadsdk.core.widget.zY zYVar = new com.bytedance.sdk.openadsdk.core.widget.zY(context);
        this.Tf = zYVar;
        zYVar.setPadding(iZY, 0, iZY, 0);
        this.Tf.setScaleType(ImageView.ScaleType.FIT_CENTER);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(kX.zY(context, 32.0f), kX.zY(context, 14.0f));
        layoutParams2.addRule(12);
        layoutParams2.addRule(11);
        layoutParams2.setMargins(0, 0, iZY2, iZY2);
        addView(this.Tf, layoutParams2);
        View view = this.Qj;
        if (view != null) {
            addView(view);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.Ol.zY
    public com.bytedance.sdk.openadsdk.core.ExN.We getAdIconView() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.component.Ol.zY
    public com.bytedance.sdk.openadsdk.core.ExN.Qj getAdTitleTextView() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.component.Ol.zY
    public dE getScoreBar() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.component.Ol.zY
    public View getUserInfo() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.Ql = null;
    }

    public void setRenderListener(sc scVar) {
        this.Ql = scVar;
    }
}
