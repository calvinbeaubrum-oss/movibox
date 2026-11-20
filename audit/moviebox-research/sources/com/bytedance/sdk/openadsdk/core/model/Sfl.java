package com.bytedance.sdk.openadsdk.core.model;

import a9.a;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.utils.OXF;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.cloud.config.utils.CommonUtils;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class Sfl {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected boolean f28404sc;
    public static final String zY = a.a("_", new CharSequence[]{"is", cJ.Dl()});
    public static final String We = a.a("_", new CharSequence[]{"is", cJ.Dl(), "sample"});
    public static final String ExN = a.a("_", new CharSequence[]{cJ.Dl(), "strategy"});
    protected static int Ol = 330;
    private long WH = 0;
    protected boolean pFF = false;
    protected boolean TRI = com.bytedance.sdk.openadsdk.JPJ.sc.zY.f27102sc;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    protected int f28403qr = com.bytedance.sdk.openadsdk.JPJ.sc.zY.pFF;
    protected String Qj = com.bytedance.sdk.openadsdk.JPJ.sc.zY.zY;

    /* JADX INFO: compiled from: source.java */
    public static class sc {
        private String ExN;
        private String Ol;
        private List<Integer> Qj;
        private String Ql;
        private String SR;
        private String TRI;
        private String Tf;
        private String UFX;
        private String WH;
        private String We;
        private String pFF;

        /* JADX INFO: renamed from: qr, reason: collision with root package name */
        private String f28405qr;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private String f28406sc;
        private String zY;

        @NonNull
        public static com.bytedance.sdk.openadsdk.core.UFX.TRI.sc pFF(sc scVar, String str) {
            return new com.bytedance.sdk.openadsdk.core.UFX.TRI.sc().sc(scVar.TRI()).pFF(scVar.dE()).zY(scVar.BT()).We(scVar.Xc()).ExN(str);
        }

        @NonNull
        public static com.bytedance.sdk.component.adexpress.sc.zY.We sc(sc scVar, String str) {
            return com.bytedance.sdk.component.adexpress.sc.zY.We.sc().sc(scVar.TRI()).pFF(scVar.qr()).zY(scVar.Qj()).We(scVar.Ol()).ExN(scVar.ExN()).TRI(str);
        }

        public String BT() {
            return this.Tf;
        }

        public String ExN() {
            return this.TRI;
        }

        public void ExN(String str) {
            this.zY = str;
        }

        public String Ol() {
            return this.We;
        }

        public void Ol(String str) {
            this.UFX = str;
        }

        public String Qj() {
            return this.zY;
        }

        public void Qj(String str) {
            this.f28405qr = str;
        }

        public String Ql() {
            return this.WH;
        }

        public void Ql(String str) {
            this.SR = str;
        }

        public boolean SR() {
            return !TextUtils.isEmpty(this.WH) && this.WH.equals("v3");
        }

        public String TRI() {
            return this.f28406sc;
        }

        public void TRI(String str) {
            this.We = str;
        }

        public String Tf() {
            return this.UFX;
        }

        public void Tf(String str) {
            this.Ql = str;
        }

        public String UFX() {
            return this.f28405qr;
        }

        public void UFX(String str) {
            this.Tf = str;
        }

        public String WH() {
            return this.ExN;
        }

        public void WH(String str) {
            this.WH = str;
        }

        public String We() {
            return this.Ol;
        }

        public void We(String str) {
            this.pFF = str;
        }

        public String Xc() {
            return this.SR;
        }

        public String dE() {
            return this.Ql;
        }

        public void pFF(String str) {
            this.TRI = str;
        }

        public String qr() {
            return this.pFF;
        }

        public void qr(String str) {
            this.ExN = str;
        }

        public void sc(String str) {
            this.Ol = str;
        }

        public void sc(List<Integer> list) {
            this.Qj = list;
        }

        public List<Integer> zY() {
            return this.Qj;
        }

        public void zY(String str) {
            this.f28406sc = str;
        }
    }

    public Sfl() {
        this.f28404sc = false;
        this.f28404sc = com.bytedance.sdk.openadsdk.YIK.sc.sc("is_new_playable", false);
    }

    public static boolean ExN(Sfl sfl) {
        if (sfl == null) {
            return false;
        }
        int iDix = sfl.dix();
        return sfl.ymG() || iDix == 5 || iDix == 15 || iDix == 50;
    }

    private static long TRI(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optLong(CommonUtils.PARAM_UID, 0L);
        }
        return 0L;
    }

    public static boolean TRI(Sfl sfl) {
        Object obj;
        if (sfl == null) {
            return false;
        }
        try {
            Map<String, Object> mapEoh = sfl.eoh();
            return (mapEoh == null || (obj = mapEoh.get(TTAdConstant.SDK_BIDDING_TYPE)) == null || 2 != Integer.parseInt(obj.toString())) ? false : true;
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("MaterialMeta", th2.getMessage());
            return false;
        }
    }

    public static int We(String str) {
        return sc(zY(str));
    }

    public static boolean We(Sfl sfl) {
        return (sfl == null || sfl.GI() == null || sfl.GI().E() != 1) ? false : true;
    }

    public static double pFF(String str) {
        return qr(zY(str));
    }

    public static String pFF(Context context, Sfl sfl) {
        if (context != null && sfl != null) {
            try {
                if (sfl.QLv() != 8) {
                    if (sfl.UFX().sc()) {
                    }
                }
                String strSc = com.bytedance.sdk.openadsdk.core.act.sc.sc(context);
                if (TextUtils.isEmpty(strSc)) {
                    return null;
                }
                return strSc;
            } catch (Throwable th2) {
                com.bytedance.sdk.component.utils.Tf.sc("MaterialMeta", th2.getMessage());
            }
        }
        return null;
    }

    public static boolean pFF(Sfl sfl) {
        return (sc(sfl) || zY(sfl)) ? false : true;
    }

    private static double qr(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optDouble("pack_time", 0.0d);
        }
        return 0.0d;
    }

    public static int sc(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optInt("ut", 0);
        }
        return 0;
    }

    public static long sc(String str) {
        return TRI(zY(str));
    }

    public static com.bytedance.sdk.openadsdk.core.Ql.sc.pFF sc(String str, Sfl sfl) {
        int i11;
        sfl.cJ(0);
        int iQY = sfl.qY();
        if (iQY == 3) {
            i11 = 4;
        } else if (iQY != 7) {
            i11 = iQY != 8 ? 3 : 2;
        } else {
            i11 = 1;
        }
        return new com.bytedance.sdk.openadsdk.core.Ql.sc.pFF(str, sfl.lD(), sfl.auq(), sfl.Flm(), sfl.EZl(), i11);
    }

    public static String sc(Context context, Sfl sfl) {
        if (context == null || sfl == null || !((sfl.qY() == 8 || sfl.qY() == 7) && sfl.kX())) {
            return null;
        }
        String strPFF = pFF(context, sfl);
        if (TextUtils.isEmpty(strPFF) || com.bytedance.sdk.openadsdk.core.act.sc.sc() != 1) {
            return null;
        }
        return strPFF;
    }

    public static boolean sc(Sfl sfl) {
        return (sfl == null || sfl.GI() == null || sfl.GI().t() != 1) ? false : true;
    }

    public static boolean sc(Sfl sfl, boolean z11, boolean z12, boolean z13, boolean z14) {
        if (sc(sfl) || z14 || sfl == null || sfl.GI() == null || TextUtils.isEmpty(sfl.GI().p())) {
            return false;
        }
        if (zY(sfl)) {
            return z13;
        }
        return (sfl.GI() == null || sfl.GI().E() != 1) ? z11 : z12;
    }

    public static Sfl zY() {
        return new FI();
    }

    public static JSONObject zY(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str);
            } catch (JSONException e11) {
                com.bytedance.sdk.component.utils.Tf.sc("MaterialMeta", e11.getMessage());
            }
        }
        return null;
    }

    public static boolean zY(Sfl sfl) {
        return (sfl == null || sfl.GI() == null || sfl.GI().t() != 7 || JPJ.qr(sfl)) ? false : true;
    }

    public abstract boolean AIZ();

    public abstract float AZJ();

    public abstract uEA Af();

    public abstract boolean Ao();

    public abstract int Ay();

    public abstract void BCJ();

    public abstract int BR();

    public abstract void BR(int i11);

    public abstract long BT();

    public abstract void BT(int i11);

    public abstract void BT(String str);

    @Nullable
    public abstract String BU();

    public abstract int Bjf();

    public abstract List<String> Bs();

    public abstract void CYO(int i11);

    public abstract boolean CYO();

    public abstract AdSlot Cb();

    public abstract void Cb(int i11);

    public abstract boolean Chh();

    public abstract com.bytedance.sdk.openadsdk.core.UFX.TRI.sc Cwg();

    public abstract String DI();

    public abstract String DNB();

    public abstract String Dl();

    public abstract void Dl(int i11);

    public abstract void Dl(String str);

    public abstract long EOI();

    public abstract int EZl();

    public abstract void ExN(int i11);

    public abstract void ExN(String str);

    public abstract void ExN(JSONObject jSONObject);

    public abstract void ExN(boolean z11);

    public abstract boolean ExN();

    public abstract boolean Eyy();

    public abstract void FI(int i11);

    public abstract void FI(String str);

    public abstract boolean FI();

    public abstract boolean FJp();

    public abstract int Flm();

    public abstract x8.a GI();

    public abstract void GI(int i11);

    public abstract com.bytedance.sdk.openadsdk.core.Tf.sc GOt();

    public abstract int Gb();

    public abstract void Gb(int i11);

    public abstract String HBq();

    public abstract int HC();

    public abstract int HJN();

    public abstract void HJN(int i11);

    public abstract void HJN(String str);

    public abstract boolean HL();

    public abstract boolean IE();

    public abstract List<FilterWord> IEI();

    public abstract int II();

    public abstract void II(int i11);

    public abstract void II(String str);

    public abstract boolean JK();

    public abstract JSONObject JP();

    public abstract int JPJ();

    public abstract void JPJ(int i11);

    public abstract void JPJ(String str);

    public abstract sc JoC();

    public abstract void JoC(int i11);

    public abstract String Kh();

    public abstract boolean LVf();

    public abstract String McK();

    public abstract void McK(int i11);

    public abstract void McK(String str);

    public abstract JSONObject Mrq();

    public abstract String MxZ();

    public abstract void MxZ(int i11);

    public abstract zY NP();

    public abstract String NQ();

    public abstract com.bytedance.sdk.openadsdk.core.UFX.TRI.sc NT();

    public abstract BT OKY();

    public abstract int OUZ();

    public abstract int OXF();

    public abstract void OXF(int i11);

    public abstract wjp Ol();

    public abstract void Ol(int i11);

    public abstract void Ol(String str);

    public abstract void Ol(boolean z11);

    public abstract void OvL();

    public abstract String PPh();

    public abstract String Pm();

    public abstract boolean Pu();

    public abstract int QLv();

    public abstract boolean QST();

    public abstract int QT();

    public abstract void Qj(int i11);

    public abstract void Qj(String str);

    public abstract void Qj(boolean z11);

    public boolean Qj() {
        return (TextUtils.isEmpty(TRI()) || TextUtils.isEmpty(qr())) ? false : true;
    }

    public abstract int Ql();

    public abstract void Ql(int i11);

    public abstract void Ql(String str);

    public abstract String Qy();

    public abstract boolean RiV();

    public abstract int SR();

    public abstract void SR(int i11);

    public abstract void SR(String str);

    public abstract int Sfl();

    public abstract void Sfl(int i11);

    public abstract void Sfl(String str);

    public abstract boolean TEo();

    public abstract int TI();

    public abstract String TRI();

    public abstract void TRI(int i11);

    public abstract void TRI(String str);

    public abstract void TRI(boolean z11);

    public abstract We Tf();

    public abstract void Tf(int i11);

    public abstract void Tf(String str);

    public abstract boolean TpG();

    public abstract ExN UFX();

    public abstract void UFX(int i11);

    public abstract void UFX(String str);

    public abstract void UFX(boolean z11);

    public abstract boolean VU();

    public abstract String VZ();

    public abstract int Vb();

    public abstract dE WH();

    public abstract void WH(int i11);

    public abstract void WH(String str);

    public abstract void WH(boolean z11);

    public abstract JSONObject WMT();

    public abstract int WP();

    public abstract String WP(String str);

    public abstract void WP(int i11);

    public abstract void We(int i11);

    public abstract void We(JSONObject jSONObject);

    public abstract void We(boolean z11);

    public abstract boolean We();

    public abstract int WgX();

    public abstract int Xc();

    public abstract void Xc(int i11);

    public abstract void Xc(String str);

    public abstract int YIK();

    public abstract void YIK(int i11);

    public abstract void YIK(String str);

    public abstract String YdT();

    public abstract int Yhz();

    public abstract String ZM();

    public abstract int Zn();

    public abstract boolean ag();

    public abstract long ap();

    public abstract x8.a auq();

    public abstract String bSP();

    public abstract com.bytedance.sdk.component.Ol.pFF.sc bZj();

    public abstract boolean bp();

    public abstract Ol cD();

    public abstract void cD(int i11);

    public abstract String cJ();

    public abstract void cJ(int i11);

    public abstract String coa();

    public abstract int cvk();

    public abstract void cvk(int i11);

    public abstract void cvk(String str);

    public abstract JPJ dE();

    public abstract void dE(int i11);

    public abstract void dE(String str);

    public abstract int dix();

    public abstract int ds();

    public abstract int ef();

    public abstract boolean eo();

    public abstract Map<String, Object> eoh();

    public abstract OXF fKf();

    public abstract List<String> fT();

    public abstract boolean fb();

    public abstract long gsl();

    public abstract int gx();

    public abstract int hE();

    public abstract boolean hP();

    public abstract int hbB();

    public abstract List<BT> ht();

    public abstract int hwa();

    public abstract List<String> idT();

    public abstract boolean io();

    public abstract boolean ixT();

    public abstract int jcs();

    public abstract JSONObject jxU();

    public abstract String kDg();

    public abstract void kX(int i11);

    public abstract boolean kX();

    public abstract String ko();

    public abstract x8.a lD();

    public abstract String mD();

    public abstract boolean mbO();

    public abstract boolean nW();

    public abstract boolean nj();

    public abstract String ofL();

    public abstract UFX otH();

    public abstract void pCa();

    public long pFF() {
        return this.WH;
    }

    public abstract void pFF(double d11);

    public abstract void pFF(int i11);

    public abstract void pFF(long j11);

    public abstract void pFF(com.bytedance.sdk.openadsdk.core.UFX.TRI.sc scVar);

    public abstract void pFF(BT bt2);

    public abstract void pFF(JSONObject jSONObject);

    public abstract void pFF(x8.a aVar);

    public abstract void pFF(boolean z11);

    public abstract void pXW();

    public abstract int pc();

    public abstract void pc(int i11);

    public abstract cvk qKn();

    public abstract void qKn(int i11);

    public abstract int qOv();

    public abstract int qY();

    public abstract BT qfG();

    public abstract String qr();

    public abstract void qr(int i11);

    public abstract void qr(String str);

    public abstract void qr(boolean z11);

    public abstract com.bytedance.sdk.openadsdk.JPJ.sc.pFF rC();

    public abstract int ra();

    public abstract void sc(double d11);

    public abstract void sc(float f11);

    public abstract void sc(int i11);

    public abstract void sc(int i11, int i12);

    public void sc(long j11) {
        this.WH = j11;
    }

    public abstract void sc(AdSlot adSlot);

    public abstract void sc(FilterWord filterWord);

    public abstract void sc(com.bytedance.sdk.openadsdk.JPJ.sc.pFF pff);

    public abstract void sc(com.bytedance.sdk.openadsdk.core.Tf.sc scVar);

    public abstract void sc(com.bytedance.sdk.openadsdk.core.UFX.TRI.sc scVar);

    public abstract void sc(BT bt2);

    public abstract void sc(ExN exN);

    public abstract void sc(JPJ jpj);

    public abstract void sc(Ol ol2);

    public abstract void sc(Ql ql2);

    public abstract void sc(sc scVar);

    public abstract void sc(Tf tf2);

    public abstract void sc(UFX ufx);

    public abstract void sc(We we2);

    public abstract void sc(cvk cvkVar);

    public abstract void sc(dE dEVar);

    public abstract void sc(uEA uea);

    public abstract void sc(wjp wjpVar);

    public abstract void sc(zY zYVar);

    public abstract void sc(Map<String, Object> map);

    public abstract void sc(x8.a aVar);

    public abstract void sc(boolean z11);

    public boolean sc() {
        int iXc = Xc();
        return (JPJ() != 2 || iXc == 5 || iXc == 6 || iXc == 19 || iXc == 12) ? false : true;
    }

    public abstract int uEA();

    public abstract void uEA(int i11);

    public abstract void uEA(String str);

    public abstract String uPZ();

    public abstract boolean uoi();

    public abstract boolean vYl();

    public abstract JSONObject vl();

    public abstract boolean vzC();

    public abstract boolean wdI();

    public abstract int wjp();

    public abstract void wjp(int i11);

    public abstract void wjp(String str);

    public abstract boolean wy();

    public abstract boolean xP();

    public abstract boolean yH();

    public abstract boolean yL();

    public abstract int yQN();

    public abstract boolean ymG();

    public abstract Ql ypJ();

    public abstract double zGQ();

    public abstract void zY(int i11);

    public abstract void zY(long j11);

    public abstract void zY(BT bt2);

    public abstract void zY(JSONObject jSONObject);

    public abstract void zY(x8.a aVar);

    public abstract void zY(boolean z11);

    public abstract void zu();
}
