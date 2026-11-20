package com.bytedance.sdk.component.adexpress.dynamic.zY.sc;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY implements View.OnTouchListener {
    private boolean ExN;
    private boolean Ol;
    private boolean Qj;
    private com.bytedance.sdk.component.adexpress.dynamic.zY.Qj TRI;
    private float We;
    private float pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private int f26875qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private float f26876sc;
    private float zY;

    public zY(com.bytedance.sdk.component.adexpress.dynamic.zY.Qj qj2) {
        this(qj2, 5);
    }

    public zY(com.bytedance.sdk.component.adexpress.dynamic.zY.Qj qj2, int i11) {
        this.f26875qr = 5;
        this.Qj = true;
        this.TRI = qj2;
        if (i11 > 0) {
            this.f26875qr = i11;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.zY.Qj qj2;
        com.bytedance.sdk.component.adexpress.dynamic.zY.Qj qj3;
        com.bytedance.sdk.component.adexpress.dynamic.zY.Qj qj4;
        if (this.Ol) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f26876sc = motionEvent.getX();
            this.pFF = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                this.We = motionEvent.getX();
                this.zY = motionEvent.getY();
                if (Math.abs(this.We - this.f26876sc) > 10.0f) {
                    this.ExN = true;
                }
                if (Math.abs(this.We - this.f26876sc) > 8.0f || Math.abs(this.zY - this.pFF) > 8.0f) {
                    this.Qj = false;
                }
                int iPFF = com.bytedance.sdk.component.adexpress.We.Qj.pFF(com.bytedance.sdk.component.adexpress.We.sc(), Math.abs(this.We - this.f26876sc));
                if (this.We > this.f26876sc && iPFF > this.f26875qr && (qj4 = this.TRI) != null) {
                    qj4.sc();
                    this.Ol = true;
                }
            }
        } else {
            if (!this.ExN && !this.Qj) {
                return false;
            }
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            int iPFF2 = com.bytedance.sdk.component.adexpress.We.Qj.pFF(com.bytedance.sdk.component.adexpress.We.sc(), Math.abs(this.We - this.f26876sc));
            if (this.We > this.f26876sc && iPFF2 > this.f26875qr && (qj3 = this.TRI) != null) {
                qj3.sc();
                this.Ol = true;
            }
            float fAbs = Math.abs(x11 - this.f26876sc);
            float fAbs2 = Math.abs(y11 - this.pFF);
            if ((fAbs < 8.0f || fAbs2 < 8.0f) && (qj2 = this.TRI) != null) {
                qj2.pFF();
                this.Ol = true;
            }
        }
        return true;
    }
}
