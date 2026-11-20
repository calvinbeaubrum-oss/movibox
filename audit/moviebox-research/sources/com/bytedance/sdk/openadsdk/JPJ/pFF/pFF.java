package com.bytedance.sdk.openadsdk.JPJ.pFF;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class pFF {
    private final AtomicBoolean ExN;
    private volatile boolean Ol = false;
    private final Integer Qj;
    private final ExN.sc TRI;
    private final AtomicLong We;
    protected Sfl pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final int f27092qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected WeakReference<View> f27093sc;
    protected final AtomicBoolean zY;

    public pFF(Integer num, View view, Sfl sfl, int i11, ExN.sc scVar) {
        this.Qj = num;
        this.f27092qr = i11;
        this.pFF = sfl;
        this.TRI = scVar;
        sc(view);
        this.zY = new AtomicBoolean(false);
        this.We = new AtomicLong(-1L);
        this.ExN = new AtomicBoolean(false);
    }

    public static pFF sc(boolean z11, Integer num, View view, Sfl sfl, ExN.sc scVar) {
        return z11 ? new Qj(num, view, sfl, scVar) : new zY(num, view, sfl, scVar);
    }

    public sc ExN() {
        WeakReference<View> weakReference = this.f27093sc;
        if (weakReference == null) {
            return new sc(-1, -1, -1.0f);
        }
        View view = weakReference.get();
        return view == null ? new sc(0, 0, 0.0f) : new sc(view.getWidth(), view.getHeight(), view.getAlpha());
    }

    public boolean Ol() {
        return this.ExN.get();
    }

    public void Qj() {
        this.We.set(-1L);
    }

    public void Ql() {
        this.zY.set(false);
        Qj();
    }

    public abstract int TRI();

    public boolean Tf() {
        return this.zY.get();
    }

    public Integer UFX() {
        return this.Qj;
    }

    public void WH() {
        this.Ol = true;
        qr.pFF(this);
    }

    public void We() {
        if (this.ExN.compareAndSet(false, true)) {
            We.sc(this.pFF, ExN(), this.TRI);
        }
    }

    public int pFF() {
        if (Ol()) {
            return 1;
        }
        WeakReference<View> weakReference = this.f27093sc;
        View view = weakReference != null ? weakReference.get() : null;
        if (view == null || this.Ol) {
            return 3;
        }
        if (UFX().equals(view.getTag(InputDeviceCompat.SOURCE_HDMI))) {
            return (UFX().equals(view.getTag(InputDeviceCompat.SOURCE_HDMI)) && zY()) ? 1 : 2;
        }
        WH();
        ExN.pFF(UFX());
        return 3;
    }

    public abstract void pFF(int i11);

    public void qr() {
        if (Ol()) {
            return;
        }
        if (!this.zY.get()) {
            Qj();
        } else if (!this.We.compareAndSet(-1L, System.currentTimeMillis()) && System.currentTimeMillis() - this.We.get() >= this.f27092qr) {
            We();
        }
    }

    public void sc() {
        if (this.zY.compareAndSet(false, true)) {
            qr.sc(this);
        }
    }

    public void sc(int i11) {
        if (i11 == 4) {
            sc();
            return;
        }
        if (i11 == 8) {
            Ql();
        } else if (i11 == 9) {
            We();
        } else {
            pFF(i11);
        }
    }

    public void sc(View view) {
        if (view != null) {
            view.setTag(InputDeviceCompat.SOURCE_HDMI, UFX());
        }
        this.f27093sc = new WeakReference<>(view);
    }

    public abstract boolean zY();
}
