package com.bytedance.sdk.component.adexpress.dynamic.zY.sc;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Qj implements View.OnTouchListener {
    private float ExN;
    private float TRI;
    private float We;
    private final boolean pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private float f26863qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final com.bytedance.sdk.component.adexpress.dynamic.zY.Qj f26864sc;
    private final int zY = 10;

    public Qj(com.bytedance.sdk.component.adexpress.dynamic.zY.Qj qj2, boolean z11) {
        this.f26864sc = qj2;
        this.pFF = z11;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.zY.Qj qj2;
        com.bytedance.sdk.component.adexpress.dynamic.zY.Qj qj3;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.We = motionEvent.getX();
            this.ExN = motionEvent.getY();
            new StringBuilder(", mStartY: ").append(this.ExN);
        } else if (action == 1) {
            this.TRI = motionEvent.getX();
            this.f26863qr = motionEvent.getY();
            new StringBuilder(", mEndY: ").append(this.f26863qr);
            if (this.pFF || (qj3 = this.f26864sc) == null) {
                float f11 = this.TRI - this.We;
                float f12 = this.f26863qr - this.ExN;
                if (com.bytedance.sdk.component.adexpress.We.Qj.pFF(com.bytedance.sdk.component.adexpress.We.sc(), Math.abs((float) Math.sqrt((f11 * f11) + (f12 * f12)))) > 10.0f && (qj2 = this.f26864sc) != null) {
                    qj2.sc();
                }
            } else {
                qj3.sc();
            }
        }
        return true;
    }
}
