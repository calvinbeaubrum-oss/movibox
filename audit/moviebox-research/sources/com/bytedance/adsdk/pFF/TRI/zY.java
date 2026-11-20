package com.bytedance.adsdk.pFF.TRI;

import android.view.Choreographer;
import com.bytedance.adsdk.pFF.qr;
import com.bytedance.component.sdk.annotation.FloatRange;
import com.bytedance.component.sdk.annotation.MainThread;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY extends sc implements Choreographer.FrameCallback {
    private qr WH;
    private float pFF = 1.0f;
    private boolean zY = false;
    private long We = 0;
    private float ExN = 0.0f;
    private float TRI = 0.0f;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private int f26156qr = 0;
    private float Qj = -2.1474836E9f;
    private float Ol = 2.1474836E9f;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected boolean f26157sc = false;
    private boolean UFX = false;

    private void Dl() {
        if (this.WH == null) {
            return;
        }
        float f11 = this.TRI;
        if (f11 < this.Qj || f11 > this.Ol) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.Qj), Float.valueOf(this.Ol), Float.valueOf(this.TRI)));
        }
    }

    private float Sfl() {
        qr qrVar = this.WH;
        if (qrVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / qrVar.Tf()) / Math.abs(this.pFF);
    }

    private boolean YIK() {
        return WH() < 0.0f;
    }

    public float BT() {
        qr qrVar = this.WH;
        if (qrVar == null) {
            return 0.0f;
        }
        float f11 = this.Qj;
        return f11 == -2.1474836E9f ? qrVar.TRI() : f11;
    }

    public void Ol() {
        zY(-WH());
    }

    public void Qj() {
        this.WH = null;
        this.Qj = -2.1474836E9f;
        this.Ol = 2.1474836E9f;
    }

    @MainThread
    public void Ql() {
        wjp();
        We();
    }

    @MainThread
    public void SR() {
        this.f26157sc = true;
        Xc();
        this.We = 0L;
        if (YIK() && qr() == BT()) {
            sc(dE());
        } else if (!YIK() && qr() == dE()) {
            sc(BT());
        }
        ExN();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float TRI() {
        qr qrVar = this.WH;
        if (qrVar == null) {
            return 0.0f;
        }
        return (this.TRI - qrVar.TRI()) / (this.WH.qr() - this.WH.TRI());
    }

    @MainThread
    public void Tf() {
        wjp();
        pFF(YIK());
    }

    @MainThread
    public void UFX() {
        this.f26157sc = true;
        sc(YIK());
        sc((int) (YIK() ? dE() : BT()));
        this.We = 0L;
        this.f26156qr = 0;
        Xc();
    }

    public float WH() {
        return this.pFF;
    }

    @MainThread
    public void We(boolean z11) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z11) {
            this.f26157sc = false;
        }
    }

    public void Xc() {
        if (isRunning()) {
            We(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        pFF();
        wjp();
    }

    public float dE() {
        qr qrVar = this.WH;
        if (qrVar == null) {
            return 0.0f;
        }
        float f11 = this.Ol;
        return f11 == 2.1474836E9f ? qrVar.qr() : f11;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j11) {
        Xc();
        if (this.WH == null || !isRunning()) {
            return;
        }
        com.bytedance.adsdk.pFF.ExN.sc("LottieValueAnimator#doFrame");
        long j12 = this.We;
        float fSfl = (j12 != 0 ? j11 - j12 : 0L) / Sfl();
        float f11 = this.ExN;
        if (YIK()) {
            fSfl = -fSfl;
        }
        float f12 = f11 + fSfl;
        boolean z11 = !ExN.zY(f12, BT(), dE());
        float f13 = this.ExN;
        float fPFF = ExN.pFF(f12, BT(), dE());
        this.ExN = fPFF;
        if (this.UFX) {
            fPFF = (float) Math.floor(fPFF);
        }
        this.TRI = fPFF;
        this.We = j11;
        if (!this.UFX || this.ExN != f13) {
            zY();
        }
        if (z11) {
            if (getRepeatCount() == -1 || this.f26156qr < getRepeatCount()) {
                sc();
                this.f26156qr++;
                if (getRepeatMode() == 2) {
                    this.zY = !this.zY;
                    Ol();
                } else {
                    float fDE = YIK() ? dE() : BT();
                    this.ExN = fDE;
                    this.TRI = fDE;
                }
                this.We = j11;
            } else {
                float fBT = this.pFF < 0.0f ? BT() : dE();
                this.ExN = fBT;
                this.TRI = fBT;
                wjp();
                pFF(YIK());
            }
        }
        Dl();
        com.bytedance.adsdk.pFF.ExN.pFF("LottieValueAnimator#doFrame");
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, to = 1.0d)
    public float getAnimatedFraction() {
        float fBT;
        float fDE;
        float fBT2;
        if (this.WH == null) {
            return 0.0f;
        }
        if (YIK()) {
            fBT = dE() - this.TRI;
            fDE = dE();
            fBT2 = BT();
        } else {
            fBT = this.TRI - BT();
            fDE = dE();
            fBT2 = BT();
        }
        return fBT / (fDE - fBT2);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(TRI());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        qr qrVar = this.WH;
        if (qrVar == null) {
            return 0L;
        }
        return (long) qrVar.ExN();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.f26157sc;
    }

    @Override // com.bytedance.adsdk.pFF.TRI.sc
    public void pFF() {
        super.pFF();
        pFF(YIK());
    }

    public void pFF(float f11) {
        sc(this.Qj, f11);
    }

    public float qr() {
        return this.TRI;
    }

    public void sc(float f11) {
        if (this.ExN == f11) {
            return;
        }
        float fPFF = ExN.pFF(f11, BT(), dE());
        this.ExN = fPFF;
        if (this.UFX) {
            fPFF = (float) Math.floor(fPFF);
        }
        this.TRI = fPFF;
        this.We = 0L;
        zY();
    }

    public void sc(float f11, float f12) {
        if (f11 > f12) {
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f11), Float.valueOf(f12)));
        }
        qr qrVar = this.WH;
        float fTRI = qrVar == null ? -3.4028235E38f : qrVar.TRI();
        qr qrVar2 = this.WH;
        float fQr = qrVar2 == null ? Float.MAX_VALUE : qrVar2.qr();
        float fPFF = ExN.pFF(f11, fTRI, fQr);
        float fPFF2 = ExN.pFF(f12, fTRI, fQr);
        if (fPFF == this.Qj && fPFF2 == this.Ol) {
            return;
        }
        this.Qj = fPFF;
        this.Ol = fPFF2;
        sc((int) ExN.pFF(this.TRI, fPFF, fPFF2));
    }

    public void sc(int i11) {
        sc(i11, (int) this.Ol);
    }

    public void sc(qr qrVar) {
        boolean z11 = this.WH == null;
        this.WH = qrVar;
        if (z11) {
            sc(Math.max(this.Qj, qrVar.TRI()), Math.min(this.Ol, qrVar.qr()));
        } else {
            sc((int) qrVar.TRI(), (int) qrVar.qr());
        }
        float f11 = this.TRI;
        this.TRI = 0.0f;
        this.ExN = 0.0f;
        sc((int) f11);
        zY();
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i11) {
        super.setRepeatMode(i11);
        if (i11 == 2 || !this.zY) {
            return;
        }
        this.zY = false;
        Ol();
    }

    @MainThread
    public void wjp() {
        We(true);
    }

    public void zY(float f11) {
        this.pFF = f11;
    }

    public void zY(boolean z11) {
        this.UFX = z11;
    }
}
