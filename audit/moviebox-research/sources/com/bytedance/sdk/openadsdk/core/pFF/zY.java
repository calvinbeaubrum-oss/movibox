package com.bytedance.sdk.openadsdk.core.pFF;

import android.graphics.Point;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.settings.Tf;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zY implements View.OnClickListener, View.OnTouchListener {
    private static long ExN = 0;
    protected static int Gb = 8;
    private static float We;
    private static float pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static float f28464sc;
    private static float zY;
    protected View Cb;
    protected float Dl = -1.0f;
    protected float uEA = -1.0f;
    protected float JPJ = -1.0f;
    protected float FI = -1.0f;
    protected long WP = -1;
    protected long cvk = -1;
    protected int II = -1;
    protected int McK = -1024;
    protected int HJN = -1;
    protected boolean cD = true;
    public SparseArray<sc> OXF = new SparseArray<>();
    private int TRI = 0;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private int f28465qr = 0;

    /* JADX INFO: compiled from: source.java */
    public static class sc {
        public long We;
        public double pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        public int f28466sc;
        public double zY;

        public sc(int i11, double d11, double d12, long j11) {
            this.f28466sc = i11;
            this.pFF = d11;
            this.zY = d12;
            this.We = j11;
        }
    }

    static {
        if (Xc.sc() != null) {
            Gb = Xc.pFF();
        }
        f28464sc = 0.0f;
        pFF = 0.0f;
        zY = 0.0f;
        We = 0.0f;
        ExN = 0L;
    }

    private boolean sc(View view, Point point) {
        int i11;
        int i12;
        int i13;
        int i14;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i15 = 0; i15 < viewGroup.getChildCount(); i15++) {
                View childAt = viewGroup.getChildAt(i15);
                if (pFF.zY(childAt)) {
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    return view.isShown() && (i11 = point.x) >= (i12 = iArr[0]) && i11 <= i12 + childAt.getWidth() && (i13 = point.y) >= (i14 = iArr[1]) && i13 <= i14 + childAt.getHeight();
                }
                if (sc(childAt, point)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (Tf.sc()) {
            sc(view, this.Dl, this.uEA, this.JPJ, this.FI, this.OXF, this.cD);
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0074  */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i11;
        this.McK = motionEvent.getDeviceId();
        this.II = motionEvent.getToolType(0);
        this.HJN = motionEvent.getSource();
        int actionMasked = motionEvent.getActionMasked();
        int i12 = 1;
        if (actionMasked == 0) {
            this.TRI = (int) motionEvent.getRawX();
            this.f28465qr = (int) motionEvent.getRawY();
            this.Dl = motionEvent.getRawX();
            this.uEA = motionEvent.getRawY();
            this.WP = System.currentTimeMillis();
            this.II = motionEvent.getToolType(0);
            this.McK = motionEvent.getDeviceId();
            this.HJN = motionEvent.getSource();
            ExN = System.currentTimeMillis();
            this.cD = true;
            this.Cb = view;
            com.bytedance.sdk.openadsdk.core.Ol.zY.sc(motionEvent);
            i11 = 0;
        } else if (actionMasked == 1) {
            this.JPJ = motionEvent.getRawX();
            this.FI = motionEvent.getRawY();
            this.cvk = System.currentTimeMillis();
            if (Math.abs(this.JPJ - this.TRI) >= Gb || Math.abs(this.FI - this.f28465qr) >= Gb) {
                this.cD = false;
            }
            Point point = new Point((int) this.JPJ, (int) this.FI);
            if (view != null && !pFF.zY(view) && sc((View) view.getParent(), point)) {
                return true;
            }
            i11 = 3;
        } else if (actionMasked != 2) {
            i11 = actionMasked != 3 ? -1 : 4;
        } else {
            zY += Math.abs(motionEvent.getX() - f28464sc);
            We += Math.abs(motionEvent.getY() - pFF);
            f28464sc = motionEvent.getX();
            pFF = motionEvent.getY();
            if (System.currentTimeMillis() - ExN > 200) {
                float f11 = zY;
                int i13 = Gb;
                if (f11 <= i13 && We <= i13) {
                    i12 = 2;
                }
            } else {
                i12 = 2;
            }
            this.JPJ = motionEvent.getRawX();
            this.FI = motionEvent.getRawY();
            if (Math.abs(this.JPJ - this.TRI) >= Gb || Math.abs(this.FI - this.f28465qr) >= Gb) {
                this.cD = false;
            }
            i11 = i12;
        }
        this.OXF.put(motionEvent.getActionMasked(), new sc(i11, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
        return false;
    }

    public boolean qr() {
        return this.cD;
    }

    public abstract void sc(View view, float f11, float f12, float f13, float f14, SparseArray<sc> sparseArray, boolean z11);
}
