package com.bytedance.sdk.component.adexpress.dynamic.zY.sc;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.SoftReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc implements View.OnTouchListener {
    private static int zY = 10;
    private int ExN;
    private com.bytedance.sdk.component.adexpress.dynamic.zY.Qj We;
    private float pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private float f26873sc;
    private RectF TRI = new RectF();

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private long f26872qr = 0;
    private final int Qj = 200;
    private final int Ol = 3;
    private SoftReference<ViewGroup> WH = new SoftReference<>(null);

    public sc(com.bytedance.sdk.component.adexpress.dynamic.zY.Qj qj2, int i11, final ViewGroup viewGroup) {
        this.ExN = zY;
        this.We = qj2;
        if (i11 > 0) {
            this.ExN = i11;
        }
        if (viewGroup != null) {
            viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.zY.sc.sc.1
                @Override // java.lang.Runnable
                public void run() {
                    sc.this.WH = new SoftReference(viewGroup);
                }
            });
        }
    }

    private RectF sc(View view) {
        if (view == null) {
            return new RectF();
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i11 = iArr[0];
        return new RectF(i11, iArr[1], i11 + view.getWidth(), iArr[1] + view.getHeight());
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.zY.Qj qj2;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.TRI = sc(this.WH.get());
            this.f26873sc = motionEvent.getRawX();
            this.pFF = motionEvent.getRawY();
            this.f26872qr = System.currentTimeMillis();
        } else if (action == 1) {
            RectF rectF = this.TRI;
            if (rectF != null && !rectF.contains(this.f26873sc, this.pFF)) {
                return false;
            }
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            float fAbs = Math.abs(rawX - this.f26873sc);
            float fAbs2 = Math.abs(rawY - this.pFF);
            int i11 = this.ExN;
            if (fAbs >= i11 && fAbs2 >= i11) {
                com.bytedance.sdk.component.adexpress.dynamic.zY.Qj qj3 = this.We;
                if (qj3 != null) {
                    qj3.sc();
                }
            } else if ((System.currentTimeMillis() - this.f26872qr < 200 || (fAbs < 3.0f && fAbs2 < 3.0f)) && (qj2 = this.We) != null) {
                qj2.sc();
            }
        }
        return true;
    }
}
