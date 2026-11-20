package com.bytedance.sdk.component.adexpress.dynamic.zY.sc;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.SoftReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class qr implements View.OnTouchListener {
    private static int zY = 10;
    private int ExN;
    private com.bytedance.sdk.component.adexpress.dynamic.zY.Qj We;
    private float pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private float f26870sc;
    private RectF TRI = new RectF();

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private long f26869qr = 0;
    private final int Qj = 200;
    private final int Ol = 3;
    private SoftReference<View> WH = new SoftReference<>(null);

    public qr(com.bytedance.sdk.component.adexpress.dynamic.zY.Qj qj2, int i11, final ViewGroup viewGroup) {
        this.ExN = zY;
        this.We = qj2;
        if (i11 > 0) {
            this.ExN = i11;
        }
        if (viewGroup != null) {
            viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.zY.sc.qr.1
                @Override // java.lang.Runnable
                public void run() {
                    View viewFindViewById = viewGroup.findViewById(2097610746);
                    qr.this.WH = new SoftReference(viewFindViewById);
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
        com.bytedance.sdk.component.adexpress.dynamic.zY.Qj qj3;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.TRI = sc(this.WH.get());
            this.f26870sc = motionEvent.getRawX();
            this.pFF = motionEvent.getRawY();
            this.f26869qr = System.currentTimeMillis();
        } else if (action == 1) {
            RectF rectF = this.TRI;
            if (rectF != null && !rectF.contains(this.f26870sc, this.pFF)) {
                return false;
            }
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            float fAbs = Math.abs(rawX - this.f26870sc);
            float fAbs2 = Math.abs(rawY - this.pFF);
            int iPFF = com.bytedance.sdk.component.adexpress.We.Qj.pFF(com.bytedance.sdk.component.adexpress.We.sc(), Math.abs(rawX - this.f26870sc));
            int i11 = zY;
            if (fAbs < i11 || fAbs2 < i11) {
                if ((System.currentTimeMillis() - this.f26869qr < 200 || (fAbs < 3.0f && fAbs2 < 3.0f)) && (qj2 = this.We) != null) {
                    qj2.sc();
                }
            } else if (rawX > this.f26870sc && iPFF > this.ExN && (qj3 = this.We) != null) {
                qj3.sc();
            }
        }
        return true;
    }
}
