package com.bytedance.sdk.openadsdk.core.pFF;

import android.util.SparseArray;
import android.view.MotionEvent;
import com.bytedance.sdk.openadsdk.core.Xc;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TRI {
    private static float BT = 0.0f;
    private static float Ql = 0.0f;
    private static float SR = 0.0f;
    public static int WH = 8;
    private static long Xc;
    private static float dE;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public float f28459sc = -1.0f;
    public float pFF = -1.0f;
    public float zY = -1.0f;
    public float We = -1.0f;
    public long ExN = -1;
    public long TRI = -1;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    public int f28458qr = -1;
    public int Qj = -1024;
    public int Ol = -1;
    public boolean UFX = true;
    public SparseArray<zY.sc> Tf = new SparseArray<>();
    private int wjp = 0;
    private int Sfl = 0;

    static {
        if (Xc.sc() != null) {
            WH = Xc.pFF();
        }
        Ql = 0.0f;
        SR = 0.0f;
        BT = 0.0f;
        dE = 0.0f;
        Xc = 0L;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0074  */
    public void sc(MotionEvent motionEvent) {
        int i11;
        this.Qj = motionEvent.getDeviceId();
        this.f28458qr = motionEvent.getToolType(0);
        this.Ol = motionEvent.getSource();
        int actionMasked = motionEvent.getActionMasked();
        int i12 = 1;
        if (actionMasked == 0) {
            this.wjp = (int) motionEvent.getRawX();
            this.Sfl = (int) motionEvent.getRawY();
            this.f28459sc = motionEvent.getRawX();
            this.pFF = motionEvent.getRawY();
            this.ExN = System.currentTimeMillis();
            this.f28458qr = motionEvent.getToolType(0);
            this.Qj = motionEvent.getDeviceId();
            this.Ol = motionEvent.getSource();
            Xc = System.currentTimeMillis();
            this.UFX = true;
            i11 = 0;
        } else if (actionMasked == 1) {
            this.zY = motionEvent.getRawX();
            this.We = motionEvent.getRawY();
            this.TRI = System.currentTimeMillis();
            if (Math.abs(this.zY - this.wjp) >= WH || Math.abs(this.We - this.Sfl) >= WH) {
                this.UFX = false;
            }
            i11 = 3;
        } else if (actionMasked != 2) {
            i11 = actionMasked != 3 ? -1 : 4;
        } else {
            BT += Math.abs(motionEvent.getX() - Ql);
            dE += Math.abs(motionEvent.getY() - SR);
            Ql = motionEvent.getX();
            SR = motionEvent.getY();
            if (System.currentTimeMillis() - Xc > 200) {
                float f11 = BT;
                int i13 = WH;
                if (f11 <= i13 && dE <= i13) {
                    i12 = 2;
                }
            } else {
                i12 = 2;
            }
            this.zY = motionEvent.getRawX();
            this.We = motionEvent.getRawY();
            if (Math.abs(this.zY - this.wjp) >= WH || Math.abs(this.We - this.Sfl) >= WH) {
                this.UFX = false;
            }
            i11 = i12;
        }
        this.Tf.put(motionEvent.getActionMasked(), new zY.sc(i11, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
    }
}
