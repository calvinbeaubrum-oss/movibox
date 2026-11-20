package com.bytedance.adsdk.ugeno.yoga.pFF;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.We;
import com.bytedance.adsdk.ugeno.qr.zY;
import com.bytedance.adsdk.ugeno.yoga.BT;
import com.bytedance.adsdk.ugeno.yoga.ExN;
import com.bytedance.adsdk.ugeno.yoga.Qj;
import com.bytedance.adsdk.ugeno.yoga.TRI;
import com.bytedance.adsdk.ugeno.yoga.Tf;
import com.bytedance.adsdk.ugeno.yoga.dE;
import com.bytedance.adsdk.ugeno.yoga.pFF;
import com.bytedance.adsdk.ugeno.yoga.qr;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc extends com.bytedance.adsdk.ugeno.pFF.sc<Qj> {
    private pFF HC;
    private qr We;
    private pFF jcs;
    private TRI pFF;
    private Tf ymG;
    private dE zY;

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.yoga.pFF.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0238sc extends com.bytedance.adsdk.ugeno.pFF.sc.C0233sc {
        public float BR;
        private boolean CYO;
        public int Cb;
        private boolean GI;
        public float Gb;
        public int HJN;
        public float II;
        private boolean JoC;
        public float McK;
        private boolean MxZ;
        public int OXF;
        public int cD;
        public int cJ;
        public int cvk;
        public int kX;

        /* JADX INFO: renamed from: pc, reason: collision with root package name */
        private boolean f26482pc;
        private boolean qKn;

        public C0238sc(com.bytedance.adsdk.ugeno.pFF.sc scVar) {
            super(scVar);
            this.cvk = 1;
            this.II = 0.0f;
            this.McK = 1.0f;
            this.HJN = pFF.AUTO.sc();
            this.Gb = -1.0f;
            this.cD = BT.RELATIVE.sc();
        }

        @Override // com.bytedance.adsdk.ugeno.pFF.sc.C0233sc
        /* JADX INFO: renamed from: pFF, reason: merged with bridge method [inline-methods] */
        public Qj.sc sc() {
            Qj.sc scVar = new Qj.sc((int) this.f26419sc, (int) this.pFF);
            scVar.Tf((int) (this.YIK ? this.TRI : this.ExN));
            scVar.SR((int) (this.Dl ? this.f26418qr : this.ExN));
            scVar.UFX((int) (this.uEA ? this.Qj : this.ExN));
            scVar.Ql((int) (this.JPJ ? this.Ol : this.ExN));
            scVar.sc(this.cvk);
            scVar.ExN(this.HJN);
            scVar.pFF(this.II);
            scVar.zY(this.McK);
            scVar.dE(this.zY);
            scVar.Xc(this.We);
            if (this.JoC) {
                scVar.We(this.Gb);
            }
            scVar.TRI(this.cD);
            if (this.CYO) {
                scVar.qr(this.Cb);
            }
            if (this.qKn) {
                scVar.Ol(this.OXF);
            }
            if (this.f26482pc) {
                scVar.Qj(this.cJ);
            }
            if (this.GI) {
                scVar.WH(this.kX);
            }
            if (this.MxZ && zY()) {
                float f11 = this.BR;
                if (f11 > 0.0f) {
                    scVar.BT(f11);
                }
            }
            return scVar;
        }

        @Override // com.bytedance.adsdk.ugeno.pFF.sc.C0233sc
        public void sc(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
            }
            super.sc(context, str, str2);
            str.hashCode();
            switch (str) {
                case "flexBasis":
                    this.JoC = true;
                    this.Gb = zY.sc(str2, -1.0f);
                    break;
                case "bottom":
                    this.qKn = true;
                    this.OXF = (int) com.bytedance.adsdk.ugeno.qr.Qj.sc(context, zY.sc(str2, 0));
                    break;
                case "top":
                    this.CYO = true;
                    this.Cb = (int) com.bytedance.adsdk.ugeno.qr.Qj.sc(context, zY.sc(str2, 0));
                    break;
                case "left":
                    this.f26482pc = true;
                    this.cJ = (int) com.bytedance.adsdk.ugeno.qr.Qj.sc(context, zY.sc(str2, 0));
                    break;
                case "order":
                    this.cvk = zY.sc(str2, 1);
                    break;
                case "ratio":
                    this.MxZ = true;
                    this.BR = zY.sc(str2, 0.0f);
                    break;
                case "right":
                    this.GI = true;
                    this.kX = (int) com.bytedance.adsdk.ugeno.qr.Qj.sc(context, zY.sc(str2, 0));
                    break;
                case "position":
                    this.cD = BT.sc(str2).sc();
                    break;
                case "flexShrink":
                    this.McK = zY.sc(str2, 1.0f);
                    break;
                case "flexGrow":
                    this.II = zY.sc(str2, 0.0f);
                    break;
                case "alignSelf":
                    this.HJN = pFF.sc(str2).sc();
                    break;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.pFF.sc.C0233sc
        public String toString() {
            return "LayoutParams{mOrder=" + this.cvk + ", mFlexGrow=" + this.II + ", mFlexShrink=" + this.McK + ", mAlignSelf=" + this.HJN + ", mFlexBasis=" + this.Gb + ", mPosition=" + this.cD + ", mTop=" + this.Cb + ", mBottom=" + this.OXF + ", mLeft=" + this.cJ + ", mRight=" + this.kX + '}';
        }

        public boolean zY() {
            float f11 = this.f26419sc;
            if (f11 == -1.0f && this.pFF == -1.0f) {
                return false;
            }
            return f11 == -2.0f || this.pFF == -2.0f;
        }
    }

    public sc(Context context) {
        super(context);
        this.pFF = TRI.ROW;
        this.zY = dE.NO_WRAP;
        this.We = qr.FLEX_START;
        pFF pff = pFF.STRETCH;
        this.jcs = pff;
        this.HC = pff;
    }

    private void sc(final ImageView imageView) {
        this.Qj.post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.yoga.pFF.sc.2
            @Override // java.lang.Runnable
            public void run() {
                Tf tfSc;
                if (((com.bytedance.adsdk.ugeno.pFF.zY) sc.this).Qj == null || (tfSc = ((Qj) ((com.bytedance.adsdk.ugeno.pFF.zY) sc.this).Qj).sc(imageView)) == null) {
                    return;
                }
                tfSc.We(((com.bytedance.adsdk.ugeno.pFF.zY) sc.this).Qj.getWidth());
                tfSc.TRI(((com.bytedance.adsdk.ugeno.pFF.zY) sc.this).Qj.getHeight());
                ((com.bytedance.adsdk.ugeno.pFF.zY) sc.this).Qj.requestLayout();
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.zY
    public void FI() {
        ImageView.ScaleType scaleType;
        if (this.QLv) {
            We.sc().pFF().sc(this.Tf, this.f26429pc, new com.bytedance.adsdk.ugeno.sc.InterfaceC0235sc() { // from class: com.bytedance.adsdk.ugeno.yoga.pFF.sc.1
                @Override // com.bytedance.adsdk.ugeno.sc.InterfaceC0235sc
                public void sc(Bitmap bitmap) {
                    final Bitmap bitmapSc;
                    if (bitmap == null || (bitmapSc = com.bytedance.adsdk.ugeno.qr.Qj.sc(((com.bytedance.adsdk.ugeno.pFF.zY) sc.this).ExN, bitmap, (int) ((com.bytedance.adsdk.ugeno.pFF.zY) sc.this).MxZ)) == null) {
                        return;
                    }
                    com.bytedance.adsdk.ugeno.qr.Qj.sc(new Runnable() { // from class: com.bytedance.adsdk.ugeno.yoga.pFF.sc.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            sc.this.sc(new BitmapDrawable(bitmapSc));
                        }
                    });
                }
            });
            return;
        }
        ImageView imageView = new ImageView(this.ExN);
        We.sc().pFF().sc(this.Tf, this.f26429pc, imageView, this.Qj.getWidth(), this.Qj.getHeight());
        if (!this.f26424eo || (scaleType = this.GI) == ImageView.ScaleType.FIT_XY) {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            imageView.setScaleType(scaleType);
        }
        Qj.sc scVar = new Qj.sc(-1, -1);
        scVar.TRI(BT.ABSOLUTE.sc());
        T t11 = this.Qj;
        if (t11 instanceof Qj) {
            ((Qj) t11).addView(imageView, 0, scVar);
            sc(imageView);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.zY
    public void UFX() {
        if (this.cJ) {
            this.ymG.pFF(ExN.ALL, this.HJN);
        }
        if (this.kX) {
            this.ymG.pFF(ExN.LEFT, this.Gb);
        }
        if (this.BR) {
            this.ymG.pFF(ExN.RIGHT, this.cD);
        }
        if (this.JoC) {
            this.ymG.pFF(ExN.TOP, this.Cb);
        }
        if (this.CYO) {
            this.ymG.pFF(ExN.BOTTOM, this.OXF);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.zY
    /* JADX INFO: renamed from: eo, reason: merged with bridge method [inline-methods] */
    public Qj We() {
        Qj qj2 = new Qj(this.ExN);
        qj2.sc(this);
        this.ymG = qj2.getYogaNode();
        return qj2;
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.sc, com.bytedance.adsdk.ugeno.pFF.zY
    public void pFF() {
        super.pFF();
        this.ymG.sc(this.pFF);
        this.ymG.sc(this.zY);
        this.ymG.sc(this.We);
        this.ymG.sc(this.jcs);
        this.ymG.zY(this.HC);
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.zY
    public void sc(Drawable drawable) {
        ImageView.ScaleType scaleType;
        ImageView imageView = new ImageView(this.ExN);
        imageView.setImageDrawable(drawable);
        if (!this.f26424eo || (scaleType = this.GI) == ImageView.ScaleType.FIT_XY) {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            imageView.setScaleType(scaleType);
        }
        Qj.sc scVar = new Qj.sc(-1, -1);
        scVar.TRI(BT.ABSOLUTE.sc());
        T t11 = this.Qj;
        if (t11 instanceof Qj) {
            ((Qj) t11).addView(imageView, 0, scVar);
            sc(imageView);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.sc
    public void sc(com.bytedance.adsdk.ugeno.pFF.zY zYVar) {
        super.sc(zYVar);
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.sc
    public void sc(com.bytedance.adsdk.ugeno.pFF.zY zYVar, ViewGroup.LayoutParams layoutParams) {
        if (zYVar == null) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.pFF.sc) this).f26417sc.add(zYVar);
        View viewOl = zYVar.Ol();
        if (viewOl != null) {
            ((Qj) this.Qj).addView(viewOl, layoutParams);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.zY
    public void sc(String str, String str2) {
        super.sc(str, str2);
        str.hashCode();
        switch (str) {
            case "alignItems":
                this.jcs = pFF.sc(str2);
                break;
            case "flexDirection":
                this.pFF = TRI.sc(str2);
                break;
            case "alignContent":
                this.HC = pFF.sc(str2);
                break;
            case "flexWrap":
                this.zY = dE.sc(str2);
                break;
            case "justifyContent":
                this.We = qr.sc(str2);
                break;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.sc
    /* JADX INFO: renamed from: yL, reason: merged with bridge method [inline-methods] */
    public C0238sc zY() {
        return new C0238sc(this);
    }
}
