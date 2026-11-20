package com.bytedance.sdk.openadsdk.Sfl.sc;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.Tf.ExN;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF extends sc {
    private FrameLayout ExN;
    private String TRI;
    private final FrameLayout We;
    private volatile boolean pFF;
    private ExN zY;

    public pFF(Context context, Sfl sfl, int i11, boolean z11, FrameLayout frameLayout, String str) {
        super(context, sfl, i11, z11, frameLayout);
        this.We = frameLayout;
        this.TRI = str;
        pFF(false);
        int iZY = kX.zY(context);
        int iWe = kX.We(context);
        if (i11 == 1) {
            if (iZY <= iWe) {
                this.f27257sc.layout(0, 0, iZY, iWe);
                return;
            }
        } else {
            if (i11 != 2) {
                return;
            }
            if (iZY > iWe) {
                this.f27257sc.layout(0, 0, iZY, iWe);
                return;
            }
        }
        this.f27257sc.layout(0, 0, iWe, iZY);
    }

    public String Qj() {
        return this.TRI;
    }

    public void qr() {
        super.sc(true, new ExN() { // from class: com.bytedance.sdk.openadsdk.Sfl.sc.pFF.1
            @Override // com.bytedance.sdk.openadsdk.Tf.ExN
            public void sc() {
                if (pFF.this.zY != null) {
                    pFF.this.zY.sc();
                } else {
                    pFF.this.pFF = true;
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.Sfl.sc.sc
    public void sc() {
        this.ExN.setVisibility(0);
        super.sc();
    }

    public void sc(FrameLayout frameLayout, ExN exN) {
        this.ExN = frameLayout;
        frameLayout.addView(this.We);
        this.zY = exN;
        if (this.pFF) {
            this.zY.sc();
        }
    }
}
