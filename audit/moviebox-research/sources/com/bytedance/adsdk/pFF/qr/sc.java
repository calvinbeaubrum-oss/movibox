package com.bytedance.adsdk.pFF.qr;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.bytedance.adsdk.pFF.qr;
import com.bytedance.component.sdk.annotation.FloatRange;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc<T> {
    private float BT;
    public final Interpolator ExN;
    public PointF Ol;
    public PointF Qj;
    private int Ql;
    private int SR;
    public final float TRI;
    private float Tf;
    private float UFX;
    private final qr WH;
    public final Interpolator We;
    private float dE;
    public T pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    public Float f26179qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public final T f26180sc;
    public final Interpolator zY;

    public sc(qr qrVar, T t11, T t12, Interpolator interpolator, float f11, Float f12) {
        this.UFX = -3987645.8f;
        this.Tf = -3987645.8f;
        this.Ql = 784923401;
        this.SR = 784923401;
        this.BT = Float.MIN_VALUE;
        this.dE = Float.MIN_VALUE;
        this.Qj = null;
        this.Ol = null;
        this.WH = qrVar;
        this.f26180sc = t11;
        this.pFF = t12;
        this.zY = interpolator;
        this.We = null;
        this.ExN = null;
        this.TRI = f11;
        this.f26179qr = f12;
    }

    public sc(qr qrVar, T t11, T t12, Interpolator interpolator, Interpolator interpolator2, float f11, Float f12) {
        this.UFX = -3987645.8f;
        this.Tf = -3987645.8f;
        this.Ql = 784923401;
        this.SR = 784923401;
        this.BT = Float.MIN_VALUE;
        this.dE = Float.MIN_VALUE;
        this.Qj = null;
        this.Ol = null;
        this.WH = qrVar;
        this.f26180sc = t11;
        this.pFF = t12;
        this.zY = null;
        this.We = interpolator;
        this.ExN = interpolator2;
        this.TRI = f11;
        this.f26179qr = f12;
    }

    public sc(qr qrVar, T t11, T t12, Interpolator interpolator, Interpolator interpolator2, Interpolator interpolator3, float f11, Float f12) {
        this.UFX = -3987645.8f;
        this.Tf = -3987645.8f;
        this.Ql = 784923401;
        this.SR = 784923401;
        this.BT = Float.MIN_VALUE;
        this.dE = Float.MIN_VALUE;
        this.Qj = null;
        this.Ol = null;
        this.WH = qrVar;
        this.f26180sc = t11;
        this.pFF = t12;
        this.zY = interpolator;
        this.We = interpolator2;
        this.ExN = interpolator3;
        this.TRI = f11;
        this.f26179qr = f12;
    }

    public sc(T t11) {
        this.UFX = -3987645.8f;
        this.Tf = -3987645.8f;
        this.Ql = 784923401;
        this.SR = 784923401;
        this.BT = Float.MIN_VALUE;
        this.dE = Float.MIN_VALUE;
        this.Qj = null;
        this.Ol = null;
        this.WH = null;
        this.f26180sc = t11;
        this.pFF = t11;
        this.zY = null;
        this.We = null;
        this.ExN = null;
        this.TRI = Float.MIN_VALUE;
        this.f26179qr = Float.valueOf(Float.MAX_VALUE);
    }

    private sc(T t11, T t12) {
        this.UFX = -3987645.8f;
        this.Tf = -3987645.8f;
        this.Ql = 784923401;
        this.SR = 784923401;
        this.BT = Float.MIN_VALUE;
        this.dE = Float.MIN_VALUE;
        this.Qj = null;
        this.Ol = null;
        this.WH = null;
        this.f26180sc = t11;
        this.pFF = t12;
        this.zY = null;
        this.We = null;
        this.ExN = null;
        this.TRI = Float.MIN_VALUE;
        this.f26179qr = Float.valueOf(Float.MAX_VALUE);
    }

    public boolean ExN() {
        return this.zY == null && this.We == null && this.ExN == null;
    }

    public int Ol() {
        if (this.SR == 784923401) {
            this.SR = ((Integer) this.pFF).intValue();
        }
        return this.SR;
    }

    public int Qj() {
        if (this.Ql == 784923401) {
            this.Ql = ((Integer) this.f26180sc).intValue();
        }
        return this.Ql;
    }

    public float TRI() {
        if (this.UFX == -3987645.8f) {
            this.UFX = ((Float) this.f26180sc).floatValue();
        }
        return this.UFX;
    }

    public float We() {
        if (this.WH == null) {
            return 1.0f;
        }
        if (this.dE == Float.MIN_VALUE) {
            if (this.f26179qr == null) {
                this.dE = 1.0f;
            } else {
                this.dE = zY() + ((this.f26179qr.floatValue() - this.TRI) / this.WH.Xc());
            }
        }
        return this.dE;
    }

    public float qr() {
        if (this.Tf == -3987645.8f) {
            this.Tf = ((Float) this.pFF).floatValue();
        }
        return this.Tf;
    }

    public sc<T> sc(T t11, T t12) {
        return new sc<>(t11, t12);
    }

    public boolean sc(@FloatRange(from = 0.0d, to = 1.0d) float f11) {
        return f11 >= zY() && f11 < We();
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f26180sc + ", endValue=" + this.pFF + ", startFrame=" + this.TRI + ", endFrame=" + this.f26179qr + ", interpolator=" + this.zY + '}';
    }

    public float zY() {
        qr qrVar = this.WH;
        if (qrVar == null) {
            return 0.0f;
        }
        if (this.BT == Float.MIN_VALUE) {
            this.BT = (this.TRI - qrVar.TRI()) / this.WH.Xc();
        }
        return this.BT;
    }
}
