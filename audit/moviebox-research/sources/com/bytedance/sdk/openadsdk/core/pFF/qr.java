package com.bytedance.sdk.openadsdk.core.pFF;

import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.SR;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class qr extends zY {
    private final com.bytedance.sdk.openadsdk.core.Tf.sc pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final String f28462sc;
    private zY zY;

    public qr(String str, com.bytedance.sdk.openadsdk.core.Tf.sc scVar) {
        this(str, scVar, null);
    }

    public qr(String str, com.bytedance.sdk.openadsdk.core.Tf.sc scVar, zY zYVar) {
        this.f28462sc = str;
        this.pFF = scVar;
        this.zY = zYVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pFF.zY, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return super.onTouch(view, motionEvent);
    }

    @Override // com.bytedance.sdk.openadsdk.core.pFF.zY
    public void sc(View view, float f11, float f12, float f13, float f14, SparseArray<zY.sc> sparseArray, boolean z11) {
        com.bytedance.sdk.openadsdk.core.Tf.sc scVar = this.pFF;
        if (scVar != null) {
            scVar.ExN(this.f28462sc);
        }
        if (view != null) {
            if (view.getId() == SR.zY) {
                view.setTag(570425345, "VAST_TITLE");
            } else if (view.getId() == SR.f28752qr) {
                view.setTag(570425345, "VAST_DESCRIPTION");
            } else {
                view.setTag(570425345, this.f28462sc);
            }
        }
        zY zYVar = this.zY;
        if (zYVar != null) {
            zYVar.WP = this.WP;
            zYVar.cvk = this.cvk;
            zYVar.II = this.II;
            int i11 = this.II;
            zYVar.McK = i11;
            zYVar.HJN = i11;
            zYVar.sc(view, f11, f12, f13, f14, sparseArray, z11);
        }
    }

    public void sc(zY zYVar) {
        this.zY = zYVar;
    }
}
