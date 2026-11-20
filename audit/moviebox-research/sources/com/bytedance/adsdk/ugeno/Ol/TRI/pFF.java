package com.bytedance.adsdk.ugeno.Ol.TRI;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.ViewCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import com.bytedance.adsdk.ugeno.pFF.zY;
import com.bytedance.adsdk.ugeno.qr.Qj;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF extends zY<sc> {
    private float Flm;
    private int GOt;
    private int HC;
    private int Pu;

    @Deprecated
    private TextUtils.TruncateAt VZ;
    private float We;

    @Deprecated
    private float WgX;

    /* JADX INFO: renamed from: ag, reason: collision with root package name */
    private float f26324ag;
    private float bZj;

    /* JADX INFO: renamed from: bp, reason: collision with root package name */
    private boolean f26325bp;

    /* JADX INFO: renamed from: ef, reason: collision with root package name */
    private TextUtils.TruncateAt f26326ef;
    private int jcs;
    private int pCa;
    protected int pFF;
    private float qOv;

    /* JADX INFO: renamed from: ra, reason: collision with root package name */
    @Deprecated
    private float f26327ra;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected String f26328sc;

    /* JADX INFO: renamed from: vl, reason: collision with root package name */
    private float f26329vl;
    private int ymG;
    private float ypJ;
    protected int zY;

    public pFF(Context context) {
        super(context);
        this.pFF = ViewCompat.MEASURED_STATE_MASK;
        this.We = 12.0f;
        this.HC = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.GOt = 2;
        this.zY = 3;
        this.f26326ef = TextUtils.TruncateAt.END;
        this.f26329vl = -1.0f;
        this.f26324ag = 400.0f;
    }

    private TextUtils.TruncateAt Ol(String str) {
        if (TextUtils.equals(str, DevicePublicKeyStringDef.NONE)) {
            return null;
        }
        return TextUtils.TruncateAt.END;
    }

    private TextUtils.TruncateAt Qj(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                this.VZ = TextUtils.TruncateAt.MIDDLE;
                break;
            case "end":
                this.VZ = TextUtils.TruncateAt.END;
                break;
            case "start":
                this.VZ = TextUtils.TruncateAt.START;
                break;
            default:
                this.VZ = null;
                break;
        }
        return this.VZ;
    }

    private int Tf(String str) {
        str.hashCode();
        switch (str) {
            case "underline":
                return 8;
            case "strikethrough":
                return 16;
            case "none":
            default:
                return Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
    }

    private int UFX(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                return 17;
            case "left":
                return 3;
            case "right":
                return 5;
            default:
                return 2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0035  */
    private int WH(String str) {
        byte b11;
        int iHashCode = str.hashCode();
        if (iHashCode != -1178781136) {
            if (iHashCode != -1039745817) {
                if (iHashCode == 3029637 && str.equals(TtmlNode.BOLD)) {
                    b11 = 0;
                } else {
                    b11 = -1;
                }
            } else if (str.equals("normal")) {
                b11 = 2;
            } else {
                b11 = -1;
            }
        } else if (str.equals(TtmlNode.ITALIC)) {
            b11 = 1;
        } else {
            b11 = -1;
        }
        if (b11 != 0) {
            return b11 != 1 ? 0 : 2;
        }
        return 1;
    }

    private void eo() {
        float f11 = this.f26329vl;
        if (f11 <= 3.0f) {
            ((sc) this.Qj).setLineSpacing(0.0f, f11);
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            int iRound = Math.round(Qj.sc(this.ExN, (f11 - this.We) / 2.0f));
            int paddingTop = ((sc) this.Qj).getPaddingTop() + iRound;
            int paddingBottom = ((sc) this.Qj).getPaddingBottom() + iRound;
            T t11 = this.Qj;
            ((sc) t11).setPadding(((sc) t11).getPaddingLeft(), paddingTop, ((sc) this.Qj).getPaddingRight(), paddingBottom);
            ((sc) this.Qj).setLineHeight(Math.round(Qj.sc(this.ExN, this.f26329vl)));
        }
    }

    private void zY() {
        ((sc) this.Qj).setLineSpacing(0.0f, this.f26329vl);
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.zY
    public void pFF() {
        super.pFF();
        if (TextUtils.equals("null", this.f26328sc)) {
            this.f26328sc = "";
        }
        qr(this.f26328sc);
        ((sc) this.Qj).setTextSize(1, this.We);
        ((sc) this.Qj).setTextColor(this.pFF);
        ((sc) this.Qj).setLines(this.ymG);
        ((sc) this.Qj).setMaxLines(this.HC);
        ((sc) this.Qj).setGravity(this.GOt);
        ((sc) this.Qj).setIncludeFontPadding(false);
        sc(this.Pu);
        if (McK()) {
            sc(this.f26326ef);
        } else {
            sc(this.VZ);
        }
        if (this.f26329vl > 0.0f) {
            if (McK()) {
                eo();
            } else {
                zY();
            }
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 23) {
            ((sc) this.Qj).setBreakStrategy(0);
        }
        if (!McK()) {
            ((sc) this.Qj).setShadowLayer(this.bZj, this.WgX, this.f26327ra, this.pCa);
        } else if (this.f26325bp) {
            if (this.bZj <= 0.0f) {
                this.bZj = 1.0E-5f;
            }
            ((sc) this.Qj).setShadowLayer(this.bZj, this.ypJ, this.qOv, this.pCa);
        }
        int i12 = this.jcs;
        if (i12 == 1) {
            ((sc) this.Qj).setTypeface(Typeface.DEFAULT, i12);
        } else if (i11 >= 28) {
            ((sc) this.Qj).setTypeface(Typeface.create(Typeface.DEFAULT, (int) this.f26324ag, i12 == 2));
        } else if (this.f26324ag >= 500.0f) {
            ((sc) this.Qj).setTypeface(Typeface.DEFAULT, 1);
        }
        if (Qj.sc(this.ExN, this.We) > 0.0f) {
            ((sc) this.Qj).setLetterSpacing(this.Flm / Qj.sc(this.ExN, this.We));
        }
    }

    public void qr(String str) {
        this.f26328sc = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.equals("null", str)) {
            this.f26328sc = "";
        }
        ((sc) this.Qj).setText(this.f26328sc);
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.zY
    /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
    public sc We() {
        sc scVar = new sc(this.ExN);
        scVar.sc(this);
        return scVar;
    }

    public void sc(int i11) {
        this.Pu = i11;
        if (i11 == Integer.MAX_VALUE) {
            return;
        }
        ((sc) this.Qj).setPaintFlags(i11);
    }

    public void sc(TextUtils.TruncateAt truncateAt) {
        if (truncateAt == null) {
            return;
        }
        ((sc) this.Qj).setEllipsize(truncateAt);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.bytedance.adsdk.ugeno.pFF.zY
    public void sc(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.sc(str, str2);
        str.hashCode();
        byte b11 = -1;
        switch (str.hashCode()) {
            case -1621067310:
                if (str.equals("shadowRadius")) {
                    b11 = 0;
                }
                break;
            case -1589741021:
                if (str.equals("shadowColor")) {
                    b11 = 1;
                }
                break;
            case -1230714651:
                if (str.equals("shadowOffsetX")) {
                    b11 = 2;
                }
                break;
            case -1230714650:
                if (str.equals("shadowOffsetY")) {
                    b11 = 3;
                }
                break;
            case -1065511464:
                if (str.equals(TtmlNode.ATTR_TTS_TEXT_ALIGN)) {
                    b11 = 4;
                }
                break;
            case -1063571914:
                if (str.equals("textColor")) {
                    b11 = 5;
                }
                break;
            case -1048634236:
                if (str.equals("textStyle")) {
                    b11 = 6;
                }
                break;
            case -1021145689:
                if (str.equals("shadowBlur")) {
                    b11 = 7;
                }
                break;
            case -1003668786:
                if (str.equals("textSize")) {
                    b11 = 8;
                }
                break;
            case -879295043:
                if (str.equals(TtmlNode.ATTR_TTS_TEXT_DECORATION)) {
                    b11 = 9;
                }
                break;
            case -756368940:
                if (str.equals("shadowDx")) {
                    b11 = 10;
                }
                break;
            case -756368939:
                if (str.equals("shadowDy")) {
                    b11 = Ascii.VT;
                }
                break;
            case -734428249:
                if (str.equals(TtmlNode.ATTR_TTS_FONT_WEIGHT)) {
                    b11 = Ascii.FF;
                }
                break;
            case -515807685:
                if (str.equals("lineHeight")) {
                    b11 = Ascii.CR;
                }
                break;
            case 3556653:
                if (str.equals(MimeTypes.BASE_TYPE_TEXT)) {
                    b11 = Ascii.SO;
                }
                break;
            case 102977279:
                if (str.equals("lines")) {
                    b11 = Ascii.SI;
                }
                break;
            case 188702929:
                if (str.equals("ellipsis")) {
                    b11 = Ascii.DLE;
                }
                break;
            case 390232059:
                if (str.equals("maxLines")) {
                    b11 = 17;
                }
                break;
            case 1554823821:
                if (str.equals("ellipsize")) {
                    b11 = Ascii.DC2;
                }
                break;
            case 2111078717:
                if (str.equals("letterSpacing")) {
                    b11 = 19;
                }
                break;
        }
        switch (b11) {
            case 0:
            case 7:
                this.bZj = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, 0.0f);
                break;
            case 1:
                this.pCa = com.bytedance.adsdk.ugeno.qr.sc.sc(str2);
                this.f26325bp = true;
                break;
            case 2:
                this.ypJ = Qj.sc(this.ExN, com.bytedance.adsdk.ugeno.qr.zY.sc(str2, 0.0f));
                break;
            case 3:
                this.qOv = Qj.sc(this.ExN, com.bytedance.adsdk.ugeno.qr.zY.sc(str2, 0.0f));
                break;
            case 4:
                this.GOt = UFX(str2);
                break;
            case 5:
                this.pFF = com.bytedance.adsdk.ugeno.qr.sc.sc(str2);
                break;
            case 6:
                this.jcs = WH(str2);
                break;
            case 8:
                this.We = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, 0.0f);
                break;
            case 9:
                this.Pu = Tf(str2);
                break;
            case 10:
                this.WgX = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, 0.0f);
                break;
            case 11:
                this.f26327ra = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, 0.0f);
                break;
            case 12:
                float fSc = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, -1.0f);
                this.f26324ag = fSc;
                if (fSc < 1.0f || fSc > 1000.0f) {
                    this.f26324ag = 400.0f;
                }
                break;
            case 13:
                this.f26329vl = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, 1.0f);
                break;
            case 14:
                this.f26328sc = str2;
                break;
            case 15:
                this.ymG = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, 0);
                break;
            case 16:
                this.f26326ef = Ol(str2);
                break;
            case 17:
                int i11 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                int iSc = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, Api.BaseClientBuilder.API_PRIORITY_OTHER);
                if (iSc > 0) {
                    i11 = iSc;
                }
                this.HC = i11;
                break;
            case 18:
                this.VZ = Qj(str2);
                break;
            case 19:
                this.Flm = Qj.sc(this.ExN, com.bytedance.adsdk.ugeno.qr.zY.sc(str2, 0.0f));
                break;
        }
    }
}
