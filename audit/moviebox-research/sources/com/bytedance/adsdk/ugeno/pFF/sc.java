package com.bytedance.adsdk.ugeno.pFF;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.applovin.exoplayer2.common.base.Ascii;
import com.bytedance.adsdk.ugeno.qr.Qj;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc<E extends ViewGroup> extends zY {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected List<zY<View>> f26417sc;

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.pFF.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0233sc {
        protected boolean BT;
        protected boolean Dl;
        protected float ExN;
        protected ViewGroup.LayoutParams FI;
        protected boolean JPJ;
        protected float Ol;
        protected float Qj;
        protected float Ql;
        protected float SR;
        protected boolean Sfl;
        protected float TRI;
        protected float Tf;
        protected float UFX;
        protected float WH;
        protected sc WP;
        protected boolean Xc;
        protected boolean YIK;
        protected boolean dE;

        /* JADX INFO: renamed from: qr, reason: collision with root package name */
        protected float f26418qr;
        protected boolean uEA;
        protected boolean wjp;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        protected float f26419sc = -2.0f;
        protected float pFF = -2.0f;
        protected float zY = 0.0f;
        protected float We = 0.0f;

        public C0233sc(sc scVar) {
            this.WP = scVar;
        }

        public ViewGroup.LayoutParams sc() {
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams((int) this.f26419sc, (int) this.pFF);
            marginLayoutParams.leftMargin = (int) (this.YIK ? this.TRI : this.ExN);
            marginLayoutParams.rightMargin = (int) (this.Dl ? this.f26418qr : this.ExN);
            marginLayoutParams.topMargin = (int) (this.uEA ? this.Qj : this.ExN);
            marginLayoutParams.bottomMargin = (int) (this.JPJ ? this.Ol : this.ExN);
            return marginLayoutParams;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public void sc(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
            }
            str.hashCode();
            byte b11 = -1;
            switch (str.hashCode()) {
                case -1501175880:
                    if (str.equals("paddingLeft")) {
                        b11 = 0;
                    }
                    break;
                case -1375815020:
                    if (str.equals("minWidth")) {
                        b11 = 1;
                    }
                    break;
                case -1221029593:
                    if (str.equals("height")) {
                        b11 = 2;
                    }
                    break;
                case -1081309778:
                    if (str.equals("margin")) {
                        b11 = 3;
                    }
                    break;
                case -1044792121:
                    if (str.equals("marginTop")) {
                        b11 = 4;
                    }
                    break;
                case -806339567:
                    if (str.equals("padding")) {
                        b11 = 5;
                    }
                    break;
                case -289173127:
                    if (str.equals("marginBottom")) {
                        b11 = 6;
                    }
                    break;
                case -133587431:
                    if (str.equals("minHeight")) {
                        b11 = 7;
                    }
                    break;
                case 90130308:
                    if (str.equals("paddingTop")) {
                        b11 = 8;
                    }
                    break;
                case 113126854:
                    if (str.equals("width")) {
                        b11 = 9;
                    }
                    break;
                case 202355100:
                    if (str.equals("paddingBottom")) {
                        b11 = 10;
                    }
                    break;
                case 713848971:
                    if (str.equals("paddingRight")) {
                        b11 = Ascii.VT;
                    }
                    break;
                case 975087886:
                    if (str.equals("marginRight")) {
                        b11 = Ascii.FF;
                    }
                    break;
                case 1970934485:
                    if (str.equals("marginLeft")) {
                        b11 = Ascii.CR;
                    }
                    break;
            }
            switch (b11) {
                case 0:
                    this.UFX = Qj.sc(context, str2);
                    this.dE = true;
                    break;
                case 1:
                    this.zY = Qj.sc(context, str2);
                    break;
                case 2:
                    if (TextUtils.equals(str2, "match_parent")) {
                        sc scVar = this.WP;
                        if (scVar != null && scVar.McK() && this.WP.OXF() == -2) {
                            this.pFF = -2.0f;
                        } else {
                            this.pFF = -1.0f;
                        }
                    } else if (!TextUtils.equals(str2, "wrap_content")) {
                        this.pFF = Qj.sc(context, str2);
                    } else {
                        this.pFF = -2.0f;
                    }
                    break;
                case 3:
                    this.ExN = Qj.sc(context, str2);
                    break;
                case 4:
                    this.Qj = Qj.sc(context, str2);
                    this.uEA = true;
                    break;
                case 5:
                    this.WH = Qj.sc(context, str2);
                    this.BT = true;
                    break;
                case 6:
                    this.Ol = Qj.sc(context, str2);
                    this.JPJ = true;
                    break;
                case 7:
                    this.We = Qj.sc(context, str2);
                    break;
                case 8:
                    this.Tf = Qj.sc(context, str2);
                    this.wjp = true;
                    break;
                case 9:
                    if (TextUtils.equals(str2, "match_parent")) {
                        sc scVar2 = this.WP;
                        if (scVar2 != null && scVar2.McK() && this.WP.Cb() == -2) {
                            this.f26419sc = -2.0f;
                        } else {
                            this.f26419sc = -1.0f;
                        }
                    } else if (!TextUtils.equals(str2, "wrap_content")) {
                        this.f26419sc = Qj.sc(context, str2);
                    } else {
                        this.f26419sc = -2.0f;
                    }
                    break;
                case 10:
                    this.SR = Qj.sc(context, str2);
                    this.Sfl = true;
                    break;
                case 11:
                    this.Ql = Qj.sc(context, str2);
                    this.Xc = true;
                    break;
                case 12:
                    this.f26418qr = Qj.sc(context, str2);
                    this.Dl = true;
                    break;
                case 13:
                    this.TRI = Qj.sc(context, str2);
                    this.YIK = true;
                    break;
            }
        }

        public String toString() {
            return "LayoutParams{mWidth=" + this.f26419sc + ", mHeight=" + this.pFF + ", mMargin=" + this.ExN + ", mMarginLeft=" + this.TRI + ", mMarginRight=" + this.f26418qr + ", mMarginTop=" + this.Qj + ", mMarginBottom=" + this.Ol + ", mParams=" + this.FI + '}';
        }
    }

    public sc(Context context) {
        this(context, null);
    }

    public sc(Context context, sc scVar) {
        super(context, scVar);
        this.f26417sc = new ArrayList();
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.zY
    public zY pFF(String str) {
        zY<T> zYVarWe;
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, this.BT)) {
            return this;
        }
        for (zY<View> zYVar : this.f26417sc) {
            if (zYVar != null && (zYVarWe = zYVar.We(str)) != 0) {
                return zYVarWe;
            }
        }
        return null;
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.zY
    public void pFF() {
        super.pFF();
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.zY
    public zY sc(String str) {
        zY<T> zYVarZY;
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, this.SR)) {
            return this;
        }
        for (zY<View> zYVar : this.f26417sc) {
            if (zYVar != null && (zYVarZY = zYVar.zY(str)) != 0) {
                return zYVarZY;
            }
        }
        return null;
    }

    public List<zY<View>> sc() {
        return this.f26417sc;
    }

    public void sc(zY zYVar) {
        if (zYVar == null) {
            return;
        }
        this.f26417sc.add(zYVar);
        View viewOl = zYVar.Ol();
        if (viewOl != null) {
            ((ViewGroup) this.Qj).addView(viewOl);
        }
    }

    public void sc(zY zYVar, ViewGroup.LayoutParams layoutParams) {
        if (zYVar == null) {
            return;
        }
        this.f26417sc.add(zYVar);
        View viewOl = zYVar.Ol();
        if (viewOl != null) {
            ((ViewGroup) this.Qj).addView(viewOl, layoutParams);
        }
    }

    public C0233sc zY() {
        return new C0233sc(this);
    }
}
