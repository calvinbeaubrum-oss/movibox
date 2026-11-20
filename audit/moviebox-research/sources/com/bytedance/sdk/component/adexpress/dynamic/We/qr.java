package com.bytedance.sdk.component.adexpress.dynamic.We;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.adexpress.dynamic.ExN.UFX;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class qr {
    private ExN ExN;
    private String TRI;
    private TRI We;
    public String pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public int f26770sc;
    public JSONObject zY;

    public qr(ExN exN) {
        this.ExN = exN;
        this.f26770sc = exN.sc();
        this.pFF = exN.zY();
        this.zY = exN.ExN().DNB();
        this.TRI = exN.We();
        if (com.bytedance.sdk.component.adexpress.We.zY() == 1) {
            this.We = exN.qr();
        } else {
            this.We = exN.ExN();
        }
        if (com.bytedance.sdk.component.adexpress.We.pFF()) {
            this.We = exN.ExN();
        }
    }

    private boolean QST() {
        return (com.bytedance.sdk.component.adexpress.We.pFF() && (this.ExN.pFF().contains("logo-union") || this.ExN.pFF().contains("logounion") || this.ExN.pFF().contains("logoad"))) || "logo-union".equals(this.ExN.pFF()) || "logounion".equals(this.ExN.pFF()) || "logoad".equals(this.ExN.pFF());
    }

    private boolean eoh() {
        if (com.bytedance.sdk.component.adexpress.We.pFF()) {
            return false;
        }
        return (!TextUtils.isEmpty(this.pFF) && this.pFF.contains("adx:")) || UFX.pFF();
    }

    public static float[] pFF(String str) {
        String[] strArrSplit = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",");
        return (strArrSplit == null || strArrSplit.length != 4) ? new float[]{0.0f, 0.0f, 0.0f, 0.0f} : new float[]{Float.parseFloat(strArrSplit[0]), Float.parseFloat(strArrSplit[1]), Float.parseFloat(strArrSplit[2]), Float.parseFloat(strArrSplit[3])};
    }

    public static int sc(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str)) {
            return ViewCompat.MEASURED_STATE_MASK;
        }
        if (str.equals("transparent")) {
            return 0;
        }
        if (str.charAt(0) == '#' && str.length() == 7) {
            return Color.parseColor(str);
        }
        if (str.charAt(0) == '#' && str.length() == 9) {
            return Color.parseColor(str);
        }
        if (str.startsWith("rgba") && (strArrSplit = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",")) != null) {
            try {
                if (strArrSplit.length == 4) {
                    return (((int) ((Float.parseFloat(strArrSplit[3]) * 255.0f) + 0.5f)) << 24) | (((int) Float.parseFloat(strArrSplit[0])) << 16) | (((int) Float.parseFloat(strArrSplit[1])) << 8) | ((int) Float.parseFloat(strArrSplit[2]));
                }
            } catch (NumberFormatException unused) {
                return 0;
            }
        }
        return ViewCompat.MEASURED_STATE_MASK;
    }

    public String BR() {
        return this.We.CYO();
    }

    public float BT() {
        return this.We.UFX();
    }

    public int Bs() {
        return this.We.Cb();
    }

    public int CYO() {
        return this.We.dix();
    }

    public int Cb() {
        return this.We.ExN();
    }

    public String DNB() {
        return this.We.Flm();
    }

    public String Dl() {
        return this.We.FI();
    }

    public float ExN() {
        return this.We.wjp();
    }

    public String FI() {
        return this.We.JoC();
    }

    public boolean GI() {
        return this.We.TpG();
    }

    public int Gb() {
        return this.We.zY();
    }

    public double HJN() {
        return this.We.Qj();
    }

    public int IEI() {
        return this.We.JP();
    }

    public int II() {
        String strJoC = this.We.JoC();
        if ("skip-with-time-skip-btn".equals(this.ExN.pFF()) || "skip".equals(this.ExN.pFF()) || TextUtils.equals("skip-with-countdowns-skip-btn", this.ExN.pFF())) {
            return 6;
        }
        if (!"skip-with-time-countdown".equals(this.ExN.pFF()) && !"skip-with-time".equals(this.ExN.pFF())) {
            if (this.f26770sc == 10 && TextUtils.equals(this.We.CYO(), "click")) {
                return 5;
            }
            if (QST() && eoh()) {
                return 0;
            }
            if (QST()) {
                return 7;
            }
            if ("feedback-dislike".equals(this.ExN.pFF())) {
                return 3;
            }
            if (!TextUtils.isEmpty(strJoC) && !strJoC.equals(DevicePublicKeyStringDef.NONE)) {
                if (strJoC.equals("video") || (this.ExN.sc() == 7 && TextUtils.equals(strJoC, "normal"))) {
                    return (com.bytedance.sdk.component.adexpress.We.pFF() && this.ExN.ExN() != null && this.ExN.ExN().WgX()) ? 11 : 4;
                }
                if (strJoC.equals("normal")) {
                    return 1;
                }
                return (strJoC.equals("creative") || "slide".equals(this.We.CYO())) ? 2 : 0;
            }
        }
        return 0;
    }

    public int JPJ() {
        return this.We.MxZ();
    }

    public boolean JoC() {
        return this.We.otH();
    }

    public int McK() {
        return sc(this.We.JPJ());
    }

    public int MxZ() {
        return this.We.qr();
    }

    public String NP() {
        return this.We.mbO();
    }

    public double NQ() {
        return this.We.kX();
    }

    public String OKY() {
        return this.We.HJN();
    }

    public int OXF() {
        return this.We.We();
    }

    public int Ol() {
        int iQj = Qj();
        if (iQj == 4) {
            return 17;
        }
        return iQj == 3 ? GravityCompat.END : GravityCompat.START;
    }

    public boolean PPh() {
        return this.We.jcs();
    }

    public int QLv() {
        return this.We.ef();
    }

    public int Qj() {
        String strDl = this.We.Dl();
        if (TtmlNode.LEFT.equals(strDl)) {
            return 17;
        }
        if (TtmlNode.CENTER.equals(strDl)) {
            return 4;
        }
        return TtmlNode.RIGHT.equals(strDl) ? 3 : 2;
    }

    public double Ql() {
        if (this.f26770sc == 11) {
            try {
                double d11 = Double.parseDouble(this.pFF);
                return !com.bytedance.sdk.component.adexpress.We.pFF() ? (int) d11 : d11;
            } catch (NumberFormatException unused) {
            }
        }
        return -1.0d;
    }

    public double SR() {
        return this.We.Sfl();
    }

    public int Sfl() {
        return this.We.pCa();
    }

    public String TRI() {
        if (this.f26770sc == 0) {
            return !TextUtils.isEmpty(this.pFF) ? this.pFF : this.zY.optString(com.bytedance.sdk.component.adexpress.We.Qj.zY(com.bytedance.sdk.component.adexpress.We.sc()));
        }
        return "";
    }

    public String Tf() {
        return this.TRI;
    }

    public String UFX() {
        return this.f26770sc == 1 ? this.pFF : "";
    }

    public String WH() {
        int i11 = this.f26770sc;
        return (i11 == 2 || i11 == 13) ? this.pFF : "";
    }

    public String WP() {
        return this.We.auq();
    }

    public int We() {
        return (int) this.We.dE();
    }

    public float Xc() {
        return this.We.Tf();
    }

    public boolean YIK() {
        return this.We.ag();
    }

    public int YdT() {
        return this.We.OXF();
    }

    public int Yhz() {
        return this.We.AZJ();
    }

    public boolean ZM() {
        return this.We.Ql();
    }

    public double bSP() {
        return this.We.cJ();
    }

    public int cD() {
        return this.We.pFF();
    }

    public int cJ() {
        return this.We.Ol();
    }

    public long cvk() {
        return this.We.HBq();
    }

    public int dE() {
        return sc(this.We.cvk());
    }

    public int dix() {
        return this.We.WMT();
    }

    public int eo() {
        return this.We.ra();
    }

    public String fT() {
        return this.We.Gb();
    }

    public String gsl() {
        return this.We.WP();
    }

    public String ht() {
        return this.We.ypJ();
    }

    public boolean idT() {
        return this.We.cD();
    }

    public int kDg() {
        return this.We.ymG();
    }

    public String kX() {
        return this.We.WH();
    }

    public String ko() {
        return this.We.HC();
    }

    public int mD() {
        return this.We.hE();
    }

    public boolean otH() {
        return this.We.vYl();
    }

    public int pFF() {
        return (int) this.We.Xc();
    }

    public String pc() {
        return this.We.BR();
    }

    public int qKn() {
        return this.We.mD();
    }

    public boolean qfG() {
        return this.We.jcs();
    }

    public int qr() {
        return sc(this.We.uEA());
    }

    public int sc() {
        return (int) this.We.SR();
    }

    public void sc(float f11) {
        this.We.sc(f11);
    }

    public boolean sc(int i11) {
        ExN exN = this.ExN;
        if (exN == null) {
            return false;
        }
        if (i11 == 1) {
            this.We = exN.qr();
        } else {
            this.We = exN.ExN();
        }
        return this.We != null;
    }

    public boolean uEA() {
        return this.We.GI();
    }

    public int wjp() {
        return this.We.vl();
    }

    public int yL() {
        return this.We.ds();
    }

    public int zY() {
        return (int) this.We.BT();
    }
}
