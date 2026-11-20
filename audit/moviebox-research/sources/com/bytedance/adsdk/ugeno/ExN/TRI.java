package com.bytedance.adsdk.ugeno.ExN;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class TRI extends com.bytedance.adsdk.ugeno.pFF.sc<ExN> {
    private int HC;
    private int We;
    private int jcs;
    private int pFF;
    private int zY;

    /* JADX INFO: compiled from: source.java */
    public static class sc extends com.bytedance.adsdk.ugeno.pFF.sc.C0233sc {
        public int Cb;
        public float Gb;
        public int HJN;
        public float II;
        public float McK;
        public int OXF;
        public int cD;
        public int cJ;
        public int cvk;

        public sc(com.bytedance.adsdk.ugeno.pFF.sc scVar) {
            super(scVar);
            this.cvk = 1;
            this.II = 0.0f;
            this.McK = 0.0f;
            this.HJN = -1;
            this.Gb = -1.0f;
            this.cD = -1;
            this.Cb = -1;
            this.OXF = 16777215;
            this.cJ = 16777215;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:4:0x0010  */
        private int ExN(String str) {
            str.hashCode();
            switch (str) {
                case "stretch":
                    return 4;
                case "baseline":
                    return 3;
                case "center":
                    return 2;
                case "flex_start":
                    return 0;
                case "flex_end":
                    return 1;
                default:
                    return -1;
            }
        }

        private float We(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception unused) {
                return -1.0f;
            }
        }

        private float pFF(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception unused) {
                return 0.0f;
            }
        }

        private int sc(String str) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return 1;
            }
        }

        private float zY(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception unused) {
                return 0.0f;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.pFF.sc.C0233sc
        /* JADX INFO: renamed from: pFF, reason: merged with bridge method [inline-methods] */
        public ExN.sc sc() {
            ExN.sc scVar = new ExN.sc((int) this.f26419sc, (int) this.pFF);
            ((ViewGroup.MarginLayoutParams) scVar).leftMargin = (int) this.TRI;
            ((ViewGroup.MarginLayoutParams) scVar).rightMargin = (int) this.f26418qr;
            ((ViewGroup.MarginLayoutParams) scVar).topMargin = (int) this.Qj;
            ((ViewGroup.MarginLayoutParams) scVar).bottomMargin = (int) this.Ol;
            scVar.zY(this.cvk);
            scVar.We(this.HJN);
            scVar.sc(this.II);
            scVar.pFF(this.McK);
            scVar.zY(this.Gb);
            return scVar;
        }

        @Override // com.bytedance.adsdk.ugeno.pFF.sc.C0233sc
        public void sc(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
            }
            super.sc(context, str, str2);
            str.hashCode();
            switch (str) {
                case "flexBasisPercent":
                    this.Gb = We(str2);
                    break;
                case "order":
                    this.cvk = sc(str2);
                    break;
                case "flexShrink":
                    this.McK = zY(str2);
                    break;
                case "flexGrow":
                    this.II = pFF(str2);
                    break;
                case "alignSelf":
                    this.HJN = ExN(str2);
                    break;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.pFF.sc.C0233sc
        public String toString() {
            return "LayoutParams{mWidth=" + this.f26419sc + ", mHeight=" + this.pFF + ", mMargin=" + this.ExN + ", mMarginLeft=" + this.TRI + ", mMarginRight=" + this.f26418qr + ", mMarginTop=" + this.Qj + ", mMarginBottom=" + this.Ol + ", mParams=" + this.FI + ", mOrder=" + this.cvk + ", mFlexGrow=" + this.II + ", mFlexShrink=" + this.McK + ", mAlignSelf=" + this.HJN + ", mFlexBasisPercent=" + this.Gb + ", mMinWidth=" + this.cD + ", mMinHeight=" + this.Cb + ", mMaxWidth=" + this.OXF + ", mMaxHeight=" + this.cJ + "} " + super.toString();
        }
    }

    public TRI(Context context) {
        super(context);
    }

    private int Ol(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                return 2;
            case "space_around":
                return 4;
            case "space_between":
                return 3;
            case "flex_end":
                return 1;
            default:
                return 0;
        }
    }

    private int Qj(String str) {
        str.hashCode();
        return !str.equals("wrap") ? 0 : 1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:23:0x004a  */
    private int UFX(String str) {
        byte b11;
        switch (str) {
            case "stretch":
                b11 = 5;
                break;
            case "center":
                b11 = 2;
                break;
            case "space_around":
                b11 = 3;
                break;
            case "flex_start":
                b11 = 0;
                break;
            case "space_between":
                b11 = 4;
                break;
            case "flex_end":
                b11 = 1;
                break;
            default:
                b11 = -1;
                break;
        }
        if (b11 == 0) {
            return 0;
        }
        if (b11 == 1) {
            return 1;
        }
        if (b11 == 2) {
            return 2;
        }
        if (b11 != 3) {
            return b11 != 4 ? 5 : 3;
        }
        return 4;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x003f  */
    private int WH(String str) {
        byte b11;
        switch (str) {
            case "stretch":
                b11 = 4;
                break;
            case "baseline":
                b11 = 3;
                break;
            case "center":
                b11 = 2;
                break;
            case "flex_start":
                b11 = 0;
                break;
            case "flex_end":
                b11 = 1;
                break;
            default:
                b11 = -1;
                break;
        }
        if (b11 == 0) {
            return 0;
        }
        if (b11 == 1) {
            return 1;
        }
        if (b11 != 2) {
            return b11 != 3 ? 4 : 3;
        }
        return 2;
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.zY
    /* JADX INFO: renamed from: eo, reason: merged with bridge method [inline-methods] */
    public ExN We() {
        ExN exN = new ExN(this.ExN);
        exN.sc(this);
        return exN;
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.sc, com.bytedance.adsdk.ugeno.pFF.zY
    public void pFF() {
        super.pFF();
        ((ExN) this.Qj).setFlexDirection(this.pFF);
        ((ExN) this.Qj).setFlexWrap(this.zY);
        ((ExN) this.Qj).setJustifyContent(this.We);
        ((ExN) this.Qj).setAlignItems(this.jcs);
        ((ExN) this.Qj).setAlignContent(this.HC);
    }

    public int qr(String str) {
        str.hashCode();
        switch (str) {
            case "column_reverse":
                return 3;
            case "column":
                return 2;
            case "row_reverse":
                return 1;
            default:
                return 0;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.zY
    public void sc(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.sc(str, str2);
        str.hashCode();
        switch (str) {
            case "alignItems":
                this.jcs = WH(str2);
                break;
            case "flexDirection":
                this.pFF = qr(str2);
                break;
            case "alignContent":
                this.HC = UFX(str2);
                break;
            case "flexWrap":
                this.zY = Qj(str2);
                break;
            case "justifyContent":
                this.We = Ol(str2);
                break;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.sc
    public com.bytedance.adsdk.ugeno.pFF.sc.C0233sc zY() {
        return new sc(this);
    }
}
