package com.bytedance.sdk.component.adexpress.dynamic.zY.sc;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We implements View.OnTouchListener {
    private boolean ExN = true;
    private com.bytedance.sdk.component.adexpress.dynamic.zY.Qj Ol;
    private boolean Qj;
    private float TRI;
    private boolean UFX;
    private int WH;
    private float We;
    private float pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private float f26866qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private float f26867sc;
    private float zY;

    public We(com.bytedance.sdk.component.adexpress.dynamic.zY.Qj qj2, int i11, boolean z11) {
        this.Ol = qj2;
        this.WH = i11;
        this.UFX = z11;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.zY.Qj qj2;
        com.bytedance.sdk.component.adexpress.dynamic.zY.Qj qj3;
        com.bytedance.sdk.component.adexpress.dynamic.zY.Qj qj4;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f26867sc = motionEvent.getX();
            this.pFF = motionEvent.getY();
            this.TRI = motionEvent.getY();
            this.ExN = true;
        } else if (action != 1) {
            if (action == 2) {
                float y11 = motionEvent.getY();
                this.f26866qr = y11;
                if (Math.abs(y11 - this.TRI) > 10.0f) {
                    this.Qj = true;
                }
                this.We = motionEvent.getX();
                this.zY = motionEvent.getY();
                if (Math.abs(this.We - this.f26867sc) > 8.0f || Math.abs(this.zY - this.pFF) > 8.0f) {
                    this.ExN = false;
                }
            }
        } else {
            if (!this.Qj && !this.ExN) {
                return false;
            }
            if (this.UFX || (qj4 = this.Ol) == null) {
                int iPFF = com.bytedance.sdk.component.adexpress.We.Qj.pFF(com.bytedance.sdk.component.adexpress.We.sc(), Math.abs(this.f26866qr - this.TRI));
                if (this.f26866qr - this.TRI < 0.0f && iPFF > this.WH && (qj3 = this.Ol) != null) {
                    qj3.sc();
                } else if (this.ExN && (qj2 = this.Ol) != null) {
                    qj2.sc();
                }
            } else {
                qj4.sc();
            }
        }
        return true;
    }
}
