package com.bytedance.adsdk.pFF;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.bytedance.adsdk.pFF.ExN.uEA;
import com.bytedance.component.sdk.annotation.FloatRange;
import com.bytedance.component.sdk.annotation.IntRange;
import com.bytedance.component.sdk.annotation.MainThread;
import com.bytedance.component.sdk.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Ol extends Drawable implements Animatable, Drawable.Callback {
    private RectF BR;
    private com.bytedance.adsdk.pFF.pFF.sc BT;
    private Matrix CYO;
    private Paint Cb;
    private int Dl;
    private final com.bytedance.adsdk.pFF.TRI.zY ExN;
    private boolean FI;
    private Rect Gb;
    private Canvas HJN;
    private final Matrix II;
    private boolean JPJ;
    private Matrix JoC;
    private Bitmap McK;
    private Rect OXF;
    private pFF Ol;
    private boolean Qj;
    private String Ql;
    private We SR;
    private boolean Sfl;
    private boolean TRI;
    private com.bytedance.adsdk.pFF.pFF.pFF Tf;
    private final ValueAnimator.AnimatorUpdateListener UFX;
    private final ArrayList<sc> WH;
    private Sfl WP;
    private qr We;
    private boolean Xc;
    private com.bytedance.adsdk.pFF.zY.zY.pFF YIK;
    private RectF cD;
    private Rect cJ;
    private boolean cvk;
    private Map<String, Typeface> dE;
    private RectF kX;
    zY pFF;

    /* JADX INFO: renamed from: pc, reason: collision with root package name */
    private boolean f26100pc;
    private View qKn;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private boolean f26101qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    String f26102sc;
    private boolean uEA;
    private boolean wjp;
    YIK zY;

    /* JADX INFO: compiled from: source.java */
    public enum pFF {
        NONE,
        PLAY,
        RESUME
    }

    /* JADX INFO: compiled from: source.java */
    public interface sc {
        void sc(qr qrVar);
    }

    public Ol() {
        com.bytedance.adsdk.pFF.TRI.zY zYVar = new com.bytedance.adsdk.pFF.TRI.zY();
        this.ExN = zYVar;
        this.TRI = true;
        this.f26101qr = false;
        this.Qj = false;
        this.Ol = pFF.NONE;
        this.WH = new ArrayList<>();
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.pFF.Ol.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (Ol.this.YIK != null) {
                    Ol.this.YIK.sc(Ol.this.ExN.TRI());
                }
            }
        };
        this.UFX = animatorUpdateListener;
        this.wjp = false;
        this.Sfl = true;
        this.Dl = 255;
        this.WP = Sfl.AUTOMATIC;
        this.cvk = false;
        this.II = new Matrix();
        this.f26100pc = false;
        zYVar.addUpdateListener(animatorUpdateListener);
    }

    private void BR() {
        if (this.HJN != null) {
            return;
        }
        this.HJN = new Canvas();
        this.BR = new RectF();
        this.JoC = new Matrix();
        this.CYO = new Matrix();
        this.Gb = new Rect();
        this.cD = new RectF();
        this.Cb = new com.bytedance.adsdk.pFF.sc.sc();
        this.OXF = new Rect();
        this.cJ = new Rect();
        this.kX = new RectF();
    }

    private boolean Cb() {
        return this.TRI || this.f26101qr;
    }

    private boolean JoC() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View)) {
            return false;
        }
        ViewParent parent = ((View) callback).getParent();
        return (parent instanceof ViewGroup) && !((ViewGroup) parent).getClipChildren();
    }

    private com.bytedance.adsdk.pFF.pFF.pFF OXF() {
        com.bytedance.adsdk.pFF.pFF.pFF pff = this.Tf;
        if (pff != null && !pff.sc(kX())) {
            this.Tf = null;
        }
        if (this.Tf == null) {
            this.Tf = new com.bytedance.adsdk.pFF.pFF.pFF(getCallback(), this.Ql, this.SR, this.We.dE());
        }
        return this.Tf;
    }

    private void cD() {
        qr qrVar = this.We;
        if (qrVar == null) {
            return;
        }
        this.cvk = this.WP.sc(Build.VERSION.SDK_INT, qrVar.sc(), qrVar.pFF());
    }

    private com.bytedance.adsdk.pFF.pFF.sc cJ() {
        if (getCallback() == null) {
            return null;
        }
        if (this.BT == null) {
            com.bytedance.adsdk.pFF.pFF.sc scVar = new com.bytedance.adsdk.pFF.pFF.sc(getCallback(), this.pFF);
            this.BT = scVar;
            String str = this.f26102sc;
            if (str != null) {
                scVar.sc(str);
            }
        }
        return this.BT;
    }

    private Context kX() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    private void pFF(int i11, int i12) {
        Bitmap bitmap = this.McK;
        if (bitmap == null || bitmap.getWidth() < i11 || this.McK.getHeight() < i12) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i11, i12, Bitmap.Config.ARGB_8888);
            this.McK = bitmapCreateBitmap;
            this.HJN.setBitmap(bitmapCreateBitmap);
            this.f26100pc = true;
            return;
        }
        if (this.McK.getWidth() > i11 || this.McK.getHeight() > i12) {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(this.McK, 0, 0, i11, i12);
            this.McK = bitmapCreateBitmap2;
            this.HJN.setBitmap(bitmapCreateBitmap2);
            this.f26100pc = true;
        }
    }

    private void sc(Context context) {
        qr qrVar = this.We;
        if (qrVar == null) {
            return;
        }
        com.bytedance.adsdk.pFF.zY.zY.pFF pff = new com.bytedance.adsdk.pFF.zY.zY.pFF(this, uEA.sc(qrVar), qrVar.Ql(), qrVar, context);
        this.YIK = pff;
        if (this.JPJ) {
            pff.sc(true);
        }
        this.YIK.pFF(this.Sfl);
    }

    private void sc(Canvas canvas) {
        com.bytedance.adsdk.pFF.zY.zY.pFF pff = this.YIK;
        qr qrVar = this.We;
        if (pff == null || qrVar == null) {
            return;
        }
        this.II.reset();
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            this.II.preScale(bounds.width() / qrVar.We().width(), bounds.height() / qrVar.We().height());
            this.II.preTranslate(bounds.left, bounds.top);
        }
        pff.sc(canvas, this.II, this.Dl);
    }

    private void sc(Canvas canvas, com.bytedance.adsdk.pFF.zY.zY.pFF pff) {
        if (this.We == null || pff == null) {
            return;
        }
        BR();
        canvas.getMatrix(this.JoC);
        canvas.getClipBounds(this.Gb);
        sc(this.Gb, this.cD);
        this.JoC.mapRect(this.cD);
        sc(this.cD, this.Gb);
        if (this.Sfl) {
            this.BR.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        } else {
            pff.sc(this.BR, (Matrix) null, false);
        }
        this.JoC.mapRect(this.BR);
        Rect bounds = getBounds();
        float fWidth = bounds.width() / getIntrinsicWidth();
        float fHeight = bounds.height() / getIntrinsicHeight();
        sc(this.BR, fWidth, fHeight);
        if (!JoC()) {
            RectF rectF = this.BR;
            Rect rect = this.Gb;
            rectF.intersect(rect.left, rect.top, rect.right, rect.bottom);
        }
        int iCeil = (int) Math.ceil(this.BR.width());
        int iCeil2 = (int) Math.ceil(this.BR.height());
        if (iCeil == 0 || iCeil2 == 0) {
            return;
        }
        pFF(iCeil, iCeil2);
        if (this.f26100pc) {
            this.II.set(this.JoC);
            this.II.preScale(fWidth, fHeight);
            Matrix matrix = this.II;
            RectF rectF2 = this.BR;
            matrix.postTranslate(-rectF2.left, -rectF2.top);
            this.McK.eraseColor(0);
            pff.sc(this.HJN, this.II, this.Dl);
            this.JoC.invert(this.CYO);
            this.CYO.mapRect(this.kX, this.BR);
            sc(this.kX, this.cJ);
        }
        this.OXF.set(0, 0, iCeil, iCeil2);
        canvas.drawBitmap(this.McK, this.OXF, this.cJ, this.Cb);
    }

    private void sc(Rect rect, RectF rectF) {
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    private void sc(RectF rectF, float f11, float f12) {
        rectF.set(rectF.left * f11, rectF.top * f12, rectF.right * f11, rectF.bottom * f12);
    }

    private void sc(RectF rectF, Rect rect) {
        rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    public float BT() {
        return this.ExN.dE();
    }

    public int Dl() {
        return this.ExN.getRepeatCount();
    }

    public Bitmap ExN(String str) {
        com.bytedance.adsdk.pFF.pFF.pFF pffOXF = OXF();
        if (pffOXF != null) {
            return pffOXF.sc(str);
        }
        return null;
    }

    public void ExN(int i11) {
        this.ExN.setRepeatCount(i11);
    }

    public void ExN(boolean z11) {
        this.FI = z11;
    }

    public boolean ExN() {
        return this.wjp;
    }

    public YIK FI() {
        return this.zY;
    }

    public RectF Gb() {
        return this.BR;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float HJN() {
        return this.ExN.TRI();
    }

    public void II() {
        this.WH.clear();
        this.ExN.cancel();
        if (isVisible()) {
            return;
        }
        this.Ol = pFF.NONE;
    }

    public boolean JPJ() {
        if (isVisible()) {
            return this.ExN.isRunning();
        }
        pFF pff = this.Ol;
        return pff == pFF.PLAY || pff == pFF.RESUME;
    }

    public void McK() {
        this.WH.clear();
        this.ExN.Ql();
        if (isVisible()) {
            return;
        }
        this.Ol = pFF.NONE;
    }

    public boolean Ol() {
        return this.FI;
    }

    public wjp Qj() {
        qr qrVar = this.We;
        if (qrVar != null) {
            return qrVar.zY();
        }
        return null;
    }

    public void Qj(boolean z11) {
        this.ExN.zY(z11);
    }

    @MainThread
    public void Ql() {
        if (this.YIK == null) {
            this.WH.add(new sc() { // from class: com.bytedance.adsdk.pFF.Ol.7
                @Override // com.bytedance.adsdk.pFF.Ol.sc
                public void sc(qr qrVar) {
                    Ol.this.Ql();
                }
            });
            return;
        }
        cD();
        if (Cb() || Dl() == 0) {
            if (isVisible()) {
                this.ExN.SR();
                this.Ol = pFF.NONE;
            } else {
                this.Ol = pFF.RESUME;
            }
        }
        if (Cb()) {
            return;
        }
        zY((int) (dE() < 0.0f ? SR() : BT()));
        this.ExN.Tf();
        if (isVisible()) {
            return;
        }
        this.Ol = pFF.NONE;
    }

    public float SR() {
        return this.ExN.BT();
    }

    public int Sfl() {
        return (int) this.ExN.qr();
    }

    public Sfl TRI() {
        return this.cvk ? Sfl.SOFTWARE : Sfl.HARDWARE;
    }

    public WH TRI(String str) {
        qr qrVar = this.We;
        if (qrVar == null) {
            return null;
        }
        return qrVar.dE().get(str);
    }

    public void TRI(boolean z11) {
        this.Qj = z11;
    }

    @MainThread
    public void Tf() {
        this.WH.clear();
        this.ExN.Tf();
        if (isVisible()) {
            return;
        }
        this.Ol = pFF.NONE;
    }

    @MainThread
    public void UFX() {
        if (this.YIK == null) {
            this.WH.add(new sc() { // from class: com.bytedance.adsdk.pFF.Ol.6
                @Override // com.bytedance.adsdk.pFF.Ol.sc
                public void sc(qr qrVar) {
                    Ol.this.UFX();
                }
            });
            return;
        }
        cD();
        if (Cb() || Dl() == 0) {
            if (isVisible()) {
                this.ExN.UFX();
                this.Ol = pFF.NONE;
            } else {
                this.Ol = pFF.PLAY;
            }
        }
        if (Cb()) {
            return;
        }
        zY((int) (dE() < 0.0f ? SR() : BT()));
        this.ExN.Tf();
        if (isVisible()) {
            return;
        }
        this.Ol = pFF.NONE;
    }

    public void WH() {
        if (this.ExN.isRunning()) {
            this.ExN.cancel();
            if (!isVisible()) {
                this.Ol = pFF.NONE;
            }
        }
        this.We = null;
        this.YIK = null;
        this.Tf = null;
        this.ExN.Qj();
        invalidateSelf();
    }

    public boolean WP() {
        return this.dE == null && this.zY == null && this.We.SR().size() > 0;
    }

    public String We() {
        return this.Ql;
    }

    public void We(@FloatRange(from = 0.0d, to = 1.0d) final float f11) {
        if (this.We == null) {
            this.WH.add(new sc() { // from class: com.bytedance.adsdk.pFF.Ol.5
                @Override // com.bytedance.adsdk.pFF.Ol.sc
                public void sc(qr qrVar) {
                    Ol.this.We(f11);
                }
            });
            return;
        }
        ExN.sc("Drawable#setProgress");
        this.ExN.sc(this.We.sc(f11));
        ExN.pFF("Drawable#setProgress");
    }

    public void We(int i11) {
        this.ExN.setRepeatMode(i11);
    }

    public void We(final String str) {
        qr qrVar = this.We;
        if (qrVar == null) {
            this.WH.add(new sc() { // from class: com.bytedance.adsdk.pFF.Ol.2
                @Override // com.bytedance.adsdk.pFF.Ol.sc
                public void sc(qr qrVar2) {
                    Ol.this.We(str);
                }
            });
            return;
        }
        com.bytedance.adsdk.pFF.zY.TRI triZY = qrVar.zY(str);
        if (triZY != null) {
            int i11 = (int) triZY.f26227sc;
            sc(i11, ((int) triZY.pFF) + i11);
        } else {
            throw new IllegalArgumentException("Cannot find marker with name " + str + InstructionFileId.DOT);
        }
    }

    public void We(boolean z11) {
        if (this.JPJ == z11) {
            return;
        }
        this.JPJ = z11;
        com.bytedance.adsdk.pFF.zY.zY.pFF pff = this.YIK;
        if (pff != null) {
            pff.sc(z11);
        }
    }

    public void Xc() {
        this.ExN.removeAllUpdateListeners();
        this.ExN.addUpdateListener(this.UFX);
    }

    @SuppressLint({"WrongConstant"})
    public int YIK() {
        return this.ExN.getRepeatMode();
    }

    public qr cvk() {
        return this.We;
    }

    public float dE() {
        return this.ExN.WH();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        ExN.sc("Drawable#draw");
        try {
            if (this.cvk) {
                sc(canvas, this.YIK);
            } else {
                sc(canvas);
            }
        } catch (Throwable unused) {
        }
        this.f26100pc = false;
        ExN.pFF("Drawable#draw");
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.Dl;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        qr qrVar = this.We;
        if (qrVar == null) {
            return -1;
        }
        return qrVar.We().height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        qr qrVar = this.We;
        if (qrVar == null) {
            return -1;
        }
        return qrVar.We().width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.f26100pc) {
            return;
        }
        this.f26100pc = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return uEA();
    }

    public com.bytedance.adsdk.pFF.zY.zY.pFF pFF() {
        return this.YIK;
    }

    public void pFF(@FloatRange(from = 0.0d, to = 1.0d) final float f11) {
        qr qrVar = this.We;
        if (qrVar == null) {
            this.WH.add(new sc() { // from class: com.bytedance.adsdk.pFF.Ol.11
                @Override // com.bytedance.adsdk.pFF.Ol.sc
                public void sc(qr qrVar2) {
                    Ol.this.pFF(f11);
                }
            });
        } else {
            this.ExN.pFF(com.bytedance.adsdk.pFF.TRI.ExN.sc(qrVar.TRI(), this.We.qr(), f11));
        }
    }

    public void pFF(final int i11) {
        if (this.We == null) {
            this.WH.add(new sc() { // from class: com.bytedance.adsdk.pFF.Ol.10
                @Override // com.bytedance.adsdk.pFF.Ol.sc
                public void sc(qr qrVar) {
                    Ol.this.pFF(i11);
                }
            });
        } else {
            this.ExN.pFF(i11 + 0.99f);
        }
    }

    public void pFF(Animator.AnimatorListener animatorListener) {
        this.ExN.removeListener(animatorListener);
    }

    public void pFF(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.ExN.removeUpdateListener(animatorUpdateListener);
    }

    public void pFF(final String str) {
        qr qrVar = this.We;
        if (qrVar == null) {
            this.WH.add(new sc() { // from class: com.bytedance.adsdk.pFF.Ol.12
                @Override // com.bytedance.adsdk.pFF.Ol.sc
                public void sc(qr qrVar2) {
                    Ol.this.pFF(str);
                }
            });
            return;
        }
        com.bytedance.adsdk.pFF.zY.TRI triZY = qrVar.zY(str);
        if (triZY != null) {
            sc((int) triZY.f26227sc);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + InstructionFileId.DOT);
    }

    public void pFF(boolean z11) {
        this.wjp = z11;
    }

    public void qr(String str) {
        this.f26102sc = str;
        com.bytedance.adsdk.pFF.pFF.sc scVarCJ = cJ();
        if (scVarCJ != null) {
            scVarCJ.sc(str);
        }
    }

    public void qr(boolean z11) {
        this.f26101qr = z11;
    }

    public boolean qr() {
        return this.cvk;
    }

    public Bitmap sc(String str, Bitmap bitmap) {
        com.bytedance.adsdk.pFF.pFF.pFF pffOXF = OXF();
        if (pffOXF == null) {
            return null;
        }
        Bitmap bitmapSc = pffOXF.sc(str, bitmap);
        invalidateSelf();
        return bitmapSc;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Typeface sc(com.bytedance.adsdk.pFF.zY.zY zYVar) {
        Map<String, Typeface> map = this.dE;
        if (map != null) {
            String strSc = zYVar.sc();
            if (map.containsKey(strSc)) {
                return map.get(strSc);
            }
            String strPFF = zYVar.pFF();
            if (map.containsKey(strPFF)) {
                return map.get(strPFF);
            }
            String str = zYVar.sc() + "-" + zYVar.zY();
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        com.bytedance.adsdk.pFF.pFF.sc scVarCJ = cJ();
        if (scVarCJ != null) {
            return scVarCJ.sc(zYVar);
        }
        return null;
    }

    public View sc() {
        return this.qKn;
    }

    public void sc(final float f11) {
        qr qrVar = this.We;
        if (qrVar == null) {
            this.WH.add(new sc() { // from class: com.bytedance.adsdk.pFF.Ol.9
                @Override // com.bytedance.adsdk.pFF.Ol.sc
                public void sc(qr qrVar2) {
                    Ol.this.sc(f11);
                }
            });
        } else {
            sc((int) com.bytedance.adsdk.pFF.TRI.ExN.sc(qrVar.TRI(), this.We.qr(), f11));
        }
    }

    public void sc(final int i11) {
        if (this.We == null) {
            this.WH.add(new sc() { // from class: com.bytedance.adsdk.pFF.Ol.8
                @Override // com.bytedance.adsdk.pFF.Ol.sc
                public void sc(qr qrVar) {
                    Ol.this.sc(i11);
                }
            });
        } else {
            this.ExN.sc(i11);
        }
    }

    public void sc(final int i11, final int i12) {
        if (this.We == null) {
            this.WH.add(new sc() { // from class: com.bytedance.adsdk.pFF.Ol.3
                @Override // com.bytedance.adsdk.pFF.Ol.sc
                public void sc(qr qrVar) {
                    Ol.this.sc(i11, i12);
                }
            });
        } else {
            this.ExN.sc(i11, i12 + 0.99f);
        }
    }

    public void sc(Animator.AnimatorListener animatorListener) {
        this.ExN.addListener(animatorListener);
    }

    public void sc(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.ExN.addUpdateListener(animatorUpdateListener);
    }

    public void sc(View view) {
        this.qKn = view;
    }

    public void sc(Sfl sfl) {
        this.WP = sfl;
        cD();
    }

    public void sc(We we2) {
        this.SR = we2;
        com.bytedance.adsdk.pFF.pFF.pFF pff = this.Tf;
        if (pff != null) {
            pff.sc(we2);
        }
    }

    public void sc(YIK yik) {
        this.zY = yik;
    }

    public void sc(zY zYVar) {
        this.pFF = zYVar;
        com.bytedance.adsdk.pFF.pFF.sc scVar = this.BT;
        if (scVar != null) {
            scVar.sc(zYVar);
        }
    }

    public void sc(Boolean bool) {
        this.TRI = bool.booleanValue();
    }

    public void sc(String str) {
        this.Ql = str;
    }

    public void sc(Map<String, Typeface> map) {
        if (map == this.dE) {
            return;
        }
        this.dE = map;
        invalidateSelf();
    }

    public void sc(boolean z11) {
        if (z11 != this.Sfl) {
            this.Sfl = z11;
            com.bytedance.adsdk.pFF.zY.zY.pFF pff = this.YIK;
            if (pff != null) {
                pff.pFF(z11);
            }
            invalidateSelf();
        }
    }

    public void sc(boolean z11, Context context) {
        if (this.Xc == z11) {
            return;
        }
        this.Xc = z11;
        if (this.We != null) {
            sc(context);
        }
    }

    public boolean sc(qr qrVar, Context context) {
        if (this.We == qrVar) {
            return false;
        }
        this.f26100pc = true;
        WH();
        this.We = qrVar;
        sc(context);
        this.ExN.sc(qrVar);
        We(this.ExN.getAnimatedFraction());
        Iterator it = new ArrayList(this.WH).iterator();
        while (it.hasNext()) {
            sc scVar = (sc) it.next();
            if (scVar != null) {
                scVar.sc(qrVar);
            }
            it.remove();
        }
        this.WH.clear();
        qrVar.pFF(this.uEA);
        cD();
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j11) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i11) {
        this.Dl = i11;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z11, boolean z12) {
        boolean z13 = !isVisible();
        boolean visible = super.setVisible(z11, z12);
        if (z11) {
            pFF pff = this.Ol;
            if (pff == pFF.PLAY) {
                UFX();
            } else if (pff == pFF.RESUME) {
                Ql();
            }
        } else if (this.ExN.isRunning()) {
            McK();
            this.Ol = pFF.RESUME;
        } else if (!z13) {
            this.Ol = pFF.NONE;
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && ((View) callback).isInEditMode()) {
            return;
        }
        UFX();
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void stop() {
        Tf();
    }

    public boolean uEA() {
        com.bytedance.adsdk.pFF.TRI.zY zYVar = this.ExN;
        if (zYVar == null) {
            return false;
        }
        return zYVar.isRunning();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public void wjp() {
        this.ExN.removeAllListeners();
    }

    public void zY(float f11) {
        this.ExN.zY(f11);
    }

    public void zY(final int i11) {
        if (this.We == null) {
            this.WH.add(new sc() { // from class: com.bytedance.adsdk.pFF.Ol.4
                @Override // com.bytedance.adsdk.pFF.Ol.sc
                public void sc(qr qrVar) {
                    Ol.this.zY(i11);
                }
            });
        } else {
            this.ExN.sc(i11);
        }
    }

    public void zY(final String str) {
        qr qrVar = this.We;
        if (qrVar == null) {
            this.WH.add(new sc() { // from class: com.bytedance.adsdk.pFF.Ol.13
                @Override // com.bytedance.adsdk.pFF.Ol.sc
                public void sc(qr qrVar2) {
                    Ol.this.zY(str);
                }
            });
            return;
        }
        com.bytedance.adsdk.pFF.zY.TRI triZY = qrVar.zY(str);
        if (triZY != null) {
            pFF((int) (triZY.f26227sc + triZY.pFF));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + InstructionFileId.DOT);
    }

    public void zY(boolean z11) {
        this.uEA = z11;
        qr qrVar = this.We;
        if (qrVar != null) {
            qrVar.pFF(z11);
        }
    }

    public boolean zY() {
        return this.Sfl;
    }
}
