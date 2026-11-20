package com.bytedance.sdk.component.adexpress.dynamic.zY.sc;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExN implements View.OnTouchListener {
    private int ExN;
    private com.bytedance.sdk.component.adexpress.dynamic.zY.Qj We;
    private float pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private float f26862sc;
    private boolean zY;

    public ExN(com.bytedance.sdk.component.adexpress.dynamic.zY.Qj qj2, int i11) {
        this.We = qj2;
        this.ExN = i11;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.zY.Qj qj2;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f26862sc = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float y11 = motionEvent.getY();
                this.pFF = y11;
                if (Math.abs(y11 - this.f26862sc) > 10.0f) {
                    this.zY = true;
                }
            }
        } else {
            if (!this.zY) {
                return false;
            }
            int iPFF = com.bytedance.sdk.component.adexpress.We.Qj.pFF(com.bytedance.sdk.component.adexpress.We.sc(), Math.abs(this.pFF - this.f26862sc));
            if (this.pFF - this.f26862sc < 0.0f && iPFF > this.ExN && (qj2 = this.We) != null) {
                qj2.sc();
                this.f26862sc = 0.0f;
                this.pFF = 0.0f;
                this.zY = false;
            }
        }
        return true;
    }
}
