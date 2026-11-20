package com.bytedance.sdk.openadsdk.core.model;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.applovin.sdk.AppLovinErrorCodes;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.utils.OXF;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import x8.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class FI extends Sfl {
    private int AIZ;
    private int Ao;
    private String BR;
    private JSONObject BU;
    private Map<String, Object> Bs;
    private zY Cb;
    private String Dl;
    private String EZl;
    private String Eyy;
    private int GOt;
    private int Gb;
    private Ql HBq;
    private int HC;
    private String HJN;
    private com.bytedance.sdk.openadsdk.core.UFX.TRI.sc HL;
    private int IEI;
    private String II;
    private String JP;
    private String JoC;
    private uEA LVf;
    private String McK;
    private long MxZ;
    private JSONObject NQ;
    private boolean OKY;
    private UFX OXF;
    private int QLv;
    private com.bytedance.sdk.openadsdk.core.UFX.TRI.sc QT;
    private dE Qy;
    private String RiV;
    private BT Sfl;
    private String TEo;
    private String TI;
    public long UFX;
    private boolean VU;
    private boolean Vb;
    private Tf WMT;
    private String WP;
    private String WgX;
    private int Xc;
    private BT YIK;
    private Sfl.sc YdT;
    private a Yhz;
    private int ZM;
    private String Zn;

    /* JADX INFO: renamed from: ag, reason: collision with root package name */
    private wjp f28379ag;

    /* JADX INFO: renamed from: ap, reason: collision with root package name */
    private int f28380ap;
    private int auq;
    private String bSP;

    /* JADX INFO: renamed from: bp, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.Tf.sc f28381bp;
    private int cJ;
    private ExN coa;
    private String cvk;
    private int dE;
    private AdSlot dix;

    /* JADX INFO: renamed from: ds, reason: collision with root package name */
    private String f28382ds;

    /* JADX INFO: renamed from: eo, reason: collision with root package name */
    private int f28384eo;
    private String fKf;
    private int fT;

    /* JADX INFO: renamed from: fb, reason: collision with root package name */
    private int f28385fb;
    private String gsl;

    /* JADX INFO: renamed from: gx, reason: collision with root package name */
    private JSONObject f28386gx;

    /* JADX INFO: renamed from: ht, reason: collision with root package name */
    private boolean f28387ht;
    private boolean idT;
    private int jcs;
    private We jxU;
    private String kX;

    /* JADX INFO: renamed from: ko, reason: collision with root package name */
    private boolean f28388ko;
    private int lD;
    private int mbO;
    private JPJ pCa;
    private volatile boolean qOv;
    private boolean qY;
    private a qfG;

    /* JADX INFO: renamed from: ra, reason: collision with root package name */
    private JSONObject f28390ra;
    private String uEA;
    private int uPZ;
    private String vYl;

    /* JADX INFO: renamed from: vl, reason: collision with root package name */
    private int f28391vl;
    private boolean vzC;
    private boolean wdI;
    private int wjp;
    private String xP;
    private boolean yH;
    private a yL;
    private int ymG;
    private int ypJ;
    private cvk zGQ;
    private final List<BT> Tf = new ArrayList();
    private final List<String> Ql = new ArrayList();
    private final List<FilterWord> SR = new ArrayList();
    private final OXF BT = OXF.zY();
    public boolean WH = false;
    private List<String> JPJ = new ArrayList();
    private List<String> FI = new ArrayList();
    private String cD = "0";
    private String CYO = "";
    private int qKn = 0;

    /* JADX INFO: renamed from: pc, reason: collision with root package name */
    private int f28389pc = 2;
    private int GI = 0;
    private int kDg = 0;
    private int DNB = 1;
    private Ol NP = new Ol();
    private int otH = AppLovinErrorCodes.UNABLE_TO_PRECACHE_RESOURCES;
    private int mD = 0;
    private int PPh = 1;
    private int QST = 0;
    private int eoh = 0;
    private int Mrq = 0;
    private int AZJ = 1;
    private int hE = 1;
    private float TpG = 100.0f;
    private int Pu = 2;
    private int VZ = 1;

    /* JADX INFO: renamed from: ef, reason: collision with root package name */
    private int f28383ef = 0;
    private int bZj = -1;
    private long Flm = -1;
    private int EOI = 0;
    private boolean ofL = false;
    private int ixT = 0;
    private int uoi = 50;
    private int pXW = -1;
    private com.bytedance.sdk.openadsdk.JPJ.sc.pFF OvL = null;

    private com.bytedance.sdk.openadsdk.core.UFX.TRI.sc OvN() {
        cvk cvkVarQKn = qKn();
        if (cvkVarQKn == null) {
            return null;
        }
        return new com.bytedance.sdk.openadsdk.core.UFX.TRI.sc().sc(cvkVarQKn.sc()).pFF(cvkVarQKn.pFF()).zY(cvkVarQKn.zY()).We(cvkVarQKn.We()).ExN(QT() + "_v3");
    }

    private static double TRI(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optDouble("pack_time", 0.0d);
        }
        return 0.0d;
    }

    private String cD(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return com.bytedance.sdk.component.ExN.zY.zY.zY.sc(str);
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("MaterialMeta", "generate icon key error", th2.getMessage());
            return null;
        }
    }

    private JSONObject pFF(FilterWord filterWord) {
        if (filterWord == null) {
            return null;
        }
        try {
            if (filterWord.isValid()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", filterWord.getId());
                jSONObject.put("name", filterWord.getName());
                jSONObject.put("is_selected", filterWord.getIsSelected());
                if (filterWord.hasSecondOptions()) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<FilterWord> it = filterWord.getOptions().iterator();
                    while (it.hasNext()) {
                        jSONArray.put(pFF(it.next()));
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject.put("options", jSONArray);
                    }
                }
                return jSONObject;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static boolean qr(Sfl sfl) {
        if (sfl == null) {
            return false;
        }
        int iDix = sfl.dix();
        return sfl.ymG() || iDix == 5 || iDix == 15 || iDix == 50;
    }

    private void sc(BT bt2, int i11) {
        if (bt2 != null) {
            try {
                if (TextUtils.isEmpty(bt2.sc())) {
                    return;
                }
                if (bt2.pFF() == 0 && bt2.zY() == 0) {
                    bt2.sc(i11);
                    bt2.pFF(i11);
                    return;
                }
                if (bt2.pFF() == 0) {
                    if (bt2.zY() <= i11) {
                        bt2.sc(bt2.zY());
                        return;
                    } else {
                        bt2.pFF(i11);
                        bt2.sc(i11);
                        return;
                    }
                }
                if (bt2.zY() == 0) {
                    if (bt2.pFF() <= i11) {
                        bt2.pFF(bt2.pFF());
                        return;
                    } else {
                        bt2.pFF(i11);
                        bt2.sc(i11);
                        return;
                    }
                }
                if (bt2.pFF() > bt2.zY()) {
                    if (bt2.pFF() > i11) {
                        bt2.pFF((int) (i11 / (bt2.pFF() / bt2.zY())));
                        bt2.sc(i11);
                        return;
                    }
                    return;
                }
                if (bt2.zY() > i11) {
                    bt2.sc((int) (i11 * (bt2.pFF() / bt2.zY())));
                    bt2.pFF(i11);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private com.bytedance.sdk.openadsdk.core.UFX.TRI.sc uS() {
        Sfl.sc scVarJoC = JoC();
        if (scVarJoC == null) {
            return null;
        }
        return Sfl.sc.pFF(scVarJoC, String.valueOf(QT()));
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean AIZ() {
        return this.qY;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public float AZJ() {
        if (this.TpG <= 0.0f) {
            this.TpG = 100.0f;
        }
        return (this.TpG * 1000.0f) / 1000.0f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public uEA Af() {
        return this.LVf;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean Ao() {
        return this.WH;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int Ay() {
        return this.ixT;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void BCJ() {
        this.Vb = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int BR() {
        return this.fT;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void BR(int i11) {
        this.Gb = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public long BT() {
        We we2 = this.jxU;
        if (we2 == null) {
            return 0L;
        }
        return we2.zY();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void BT(int i11) {
        this.mbO = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void BT(String str) {
        this.WP = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    @Nullable
    public String BU() {
        zY zYVarNP = NP();
        if (zYVarNP == null || TextUtils.isEmpty(zYVarNP.sc())) {
            return null;
        }
        return zYVarNP.sc();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int Bjf() {
        return this.uoi;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public List<String> Bs() {
        return this.Ql;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void CYO(int i11) {
        this.f28385fb = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean CYO() {
        Sfl.sc scVar = this.YdT;
        if (scVar != null) {
            return !TextUtils.isEmpty(scVar.Ql());
        }
        int i11 = this.kDg;
        return i11 == 9 || i11 == 10;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public AdSlot Cb() {
        return this.dix;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void Cb(int i11) {
        this.auq = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean Chh() {
        if (this.bZj <= 0) {
            this.bZj = qY();
        }
        int i11 = this.bZj;
        return (i11 == 7 || i11 == 8) && !qr(this) && wjp() != 21 && this.f28380ap == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public com.bytedance.sdk.openadsdk.core.UFX.TRI.sc Cwg() {
        return this.HL;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public String DI() {
        return this.fKf;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public String DNB() {
        return this.BR;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public String Dl() {
        return this.CYO;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void Dl(int i11) {
        this.uPZ = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void Dl(String str) {
        this.JP = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public long EOI() {
        if (this.Flm < 0) {
            JSONObject jSONObjectJxU = jxU();
            if (jSONObjectJxU != null) {
                this.Flm = jSONObjectJxU.optLong("ad_id", 0L);
            } else {
                this.Flm = 0L;
            }
        }
        return this.Flm;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int EZl() {
        return this.f28391vl;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void ExN(int i11) {
        this.QST = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void ExN(String str) {
        this.TI = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void ExN(JSONObject jSONObject) {
        this.f28390ra = jSONObject;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void ExN(boolean z11) {
        this.ofL = z11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean ExN() {
        return this.f28388ko;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean Eyy() {
        return qY() == 8;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void FI(int i11) {
        this.hE = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void FI(String str) {
        this.McK = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean FI() {
        return this.QST == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean FJp() {
        return this.Vb;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int Flm() {
        return this.f28383ef;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public a GI() {
        return this.yL;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void GI(int i11) {
        this.f28380ap = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public com.bytedance.sdk.openadsdk.core.Tf.sc GOt() {
        return this.f28381bp;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int Gb() {
        if (ymG()) {
            return 5;
        }
        if (AZJ() != 100.0f || JPJ() == 2) {
            return 0;
        }
        return this.mD;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void Gb(int i11) {
        this.ypJ = i11;
    }

    public void Gb(String str) {
        this.EZl = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public String HBq() {
        return this.McK;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int HC() {
        return this.GOt;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int HJN() {
        return this.eoh;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void HJN(int i11) {
        this.GOt = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void HJN(String str) {
        if (TextUtils.isEmpty(str)) {
            this.Qj = com.bytedance.sdk.openadsdk.JPJ.sc.zY.zY;
        } else {
            this.Qj = str;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean HL() {
        return qY() == 5;
    }

    public String HjH() {
        return this.HJN;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean IE() {
        return this.yH;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public List<FilterWord> IEI() {
        return this.SR;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int II() {
        return this.DNB;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void II(int i11) {
        this.HC = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void II(String str) {
        this.xP = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean JK() {
        return this.VU;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public JSONObject JP() {
        Object objZY;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("interaction_type", QLv());
            jSONObject.put(Sfl.We, Nv());
            jSONObject.put("interaction_method", wjp());
            jSONObject.put(Sfl.zY, PjG());
            jSONObject.put(Sfl.ExN, Yhz());
            jSONObject.put("target_url", ko());
            jSONObject.put("app_log_url", DNB());
            jSONObject.put("gecko_id", PPh());
            jSONObject.put("extension", vl());
            jSONObject.put("ad_id", kDg());
            jSONObject.put("source", MxZ());
            jSONObject.put("app_name", HjH());
            jSONObject.put("screenshot", QST());
            jSONObject.put("dislike_control", Oy());
            jSONObject.put("play_bar_show_time", OXF());
            jSONObject.put("play_bar_style", Gb());
            jSONObject.put("if_block_lp", vBa());
            jSONObject.put("cache_sort", QfS());
            jSONObject.put("if_sp_cache", KMz());
            jSONObject.put("render_control", JPJ());
            jSONObject.put("mrc_report", this.ypJ);
            jSONObject.put("isMrcReportFinish", this.qOv);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("cta", YIK());
            jSONObject2.put("other", Sfl());
            jSONObject.put("set_click_type", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(CampaignEx.JSON_KEY_REWARD_NAME, Dl());
            jSONObject3.put(CampaignEx.JSON_KEY_REWARD_AMOUNT, uEA());
            jSONObject.put("reward_data", jSONObject3);
            if (!TextUtils.isEmpty(TRI()) && !TextUtils.isEmpty(qr())) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("adchoices_icon", TRI());
                jSONObject4.put("adchoices_url", qr());
                jSONObject.put("dsp_adchoices", jSONObject4);
            }
            BT btQfG = qfG();
            if (btQfG != null && !TextUtils.isEmpty(btQfG.sc())) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("url", btQfG.sc());
                jSONObject5.put("height", btQfG.zY());
                jSONObject5.put("width", btQfG.pFF());
                jSONObject.put(RewardPlus.ICON, jSONObject5);
            }
            BT btOKY = OKY();
            if (btOKY != null && !TextUtils.isEmpty(btOKY.sc())) {
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("url", btOKY.sc());
                jSONObject6.put("height", btOKY.zY());
                jSONObject6.put("width", btOKY.pFF());
                jSONObject.put("cover_image", jSONObject6);
            }
            Object objMrq = Mrq();
            if (objMrq != null) {
                jSONObject.put("session_params", objMrq);
            }
            Ol olCD = cD();
            if (olCD != null) {
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("click_upper_content_area", olCD.f28395sc);
                jSONObject7.put("click_upper_non_content_area", olCD.pFF);
                jSONObject7.put("click_lower_content_area", olCD.zY);
                jSONObject7.put("click_lower_non_content_area", olCD.We);
                jSONObject7.put("click_button_area", olCD.ExN);
                jSONObject7.put("click_video_area", olCD.TRI);
                jSONObject.put("click_area", jSONObject7);
            }
            ExN exNUFX = UFX();
            if (exNUFX != null) {
                jSONObject.put("arbitrage_interceptor_params", exNUFX.Qj());
            }
            AdSlot adSlotCb = Cb();
            if (adSlotCb != null) {
                jSONObject.put("adslot", adSlotCb.toJsonObj());
            }
            List<BT> listHt = ht();
            if (listHt != null) {
                JSONArray jSONArray = new JSONArray();
                for (BT bt2 : listHt) {
                    JSONObject jSONObject8 = new JSONObject();
                    jSONObject8.put("url", bt2.sc());
                    jSONObject8.put("height", bt2.zY());
                    jSONObject8.put("width", bt2.pFF());
                    jSONObject8.put("image_preview", bt2.TRI());
                    jSONObject8.put("image_key", bt2.qr());
                    jSONArray.put(jSONObject8);
                }
                jSONObject.put("image", jSONArray);
            }
            List<String> listIdT = idT();
            if (listIdT != null) {
                JSONArray jSONArray2 = new JSONArray();
                Iterator<String> it = listIdT.iterator();
                while (it.hasNext()) {
                    jSONArray2.put(it.next());
                }
                jSONObject.put("show_url", jSONArray2);
            }
            List<String> listFT = fT();
            if (listFT != null) {
                JSONArray jSONArray3 = new JSONArray();
                Iterator<String> it2 = listFT.iterator();
                while (it2.hasNext()) {
                    jSONArray3.put(it2.next());
                }
                jSONObject.put(CampaignEx.JSON_KEY_CLICK_URL, jSONArray3);
            }
            List<String> listBs = Bs();
            if (listBs != null) {
                JSONArray jSONArray4 = new JSONArray();
                Iterator<String> it3 = listBs.iterator();
                while (it3.hasNext()) {
                    jSONArray4.put(it3.next());
                }
                jSONObject.put("play_start", jSONArray4);
            }
            jSONObject.put("phone_num", ZM());
            jSONObject.put(CampaignEx.JSON_KEY_TITLE, YdT());
            jSONObject.put(TrackingKey.DESCRIPTION, bSP());
            jSONObject.put("ext", mD());
            jSONObject.put("image_mode", dix());
            jSONObject.put("cover_click_area", wDK());
            jSONObject.put("intercept_flag", oy());
            jSONObject.put("button_text", NQ());
            jSONObject.put("ad_logo", Kyy());
            jSONObject.put("video_adaptation", HJN());
            jSONObject.put("feed_video_opentype", WP());
            jSONObject.put("orientation", gx());
            jSONObject.put("aspect_ratio", AZJ());
            zY zYVarNP = NP();
            if (zYVarNP != null) {
                JSONObject jSONObject9 = new JSONObject();
                jSONObject9.put("app_name", zYVarNP.pFF());
                jSONObject9.put("package_name", zYVarNP.zY());
                jSONObject9.put("download_url", zYVarNP.sc());
                jSONObject9.put("score", zYVarNP.We());
                jSONObject9.put("comment_num", zYVarNP.ExN());
                jSONObject9.put(CampaignEx.JSON_KEY_APP_SIZE, zYVarNP.TRI());
                jSONObject9.put("app_category", zYVarNP.qr());
                jSONObject.put(MBridgeConstans.DYNAMIC_VIEW_WX_APP, jSONObject9);
            }
            UFX ufxOtH = otH();
            if (ufxOtH != null) {
                JSONObject jSONObject10 = new JSONObject();
                jSONObject10.put("deeplink_url", ufxOtH.sc());
                jSONObject10.put("fallback_url", ufxOtH.pFF());
                jSONObject10.put("fallback_type", ufxOtH.zY());
                jSONObject.put(CampaignEx.JSON_KEY_DEEP_LINK_URL, jSONObject10);
            }
            uEA ueaAf = Af();
            if (ueaAf != null && (objZY = ueaAf.zY()) != null) {
                jSONObject.put("oem", objZY);
            }
            List<FilterWord> listIEI = IEI();
            if (listIEI != null) {
                JSONArray jSONArray5 = new JSONArray();
                Iterator<FilterWord> it4 = listIEI.iterator();
                while (it4.hasNext()) {
                    JSONObject jSONObjectPFF = pFF(it4.next());
                    if (jSONObjectPFF != null) {
                        jSONArray5.put(jSONObjectPFF);
                    }
                }
                jSONObject.put("filter_words", jSONArray5);
            }
            dE().sc(jSONObject);
            jSONObject.put("count_down", nQ());
            jSONObject.put("expiration_time", gsl());
            a aVarLD = lD();
            if (aVarLD != null) {
                jSONObject.put("video", aVarLD.K());
            }
            a aVarAuq = auq();
            if (aVarAuq != null) {
                jSONObject.put("h265_video", aVarAuq.K());
            }
            jSONObject.put("video_encode_type", EZl());
            JSONObject jSONObject11 = new JSONObject();
            jSONObject11.put("if_send_click", pc());
            jSONObject.put("download_conf", jSONObject11);
            if (eoh() != null) {
                JSONObject jSONObject12 = new JSONObject();
                Set<Map.Entry<String, Object>> setEntrySet = eoh().entrySet();
                if (!setEntrySet.isEmpty()) {
                    for (Map.Entry<String, Object> entry : setEntrySet) {
                        jSONObject12.put(entry.getKey(), entry.getValue());
                    }
                }
                jSONObject.put("media_ext", jSONObject12);
            }
            Sfl.sc scVarJoC = JoC();
            if (scVarJoC != null) {
                JSONObject jSONObject13 = new JSONObject();
                jSONObject13.put("id", scVarJoC.TRI());
                jSONObject13.put("md5", scVarJoC.qr());
                jSONObject13.put("url", scVarJoC.Qj());
                jSONObject13.put("data", scVarJoC.Ol());
                jSONObject13.put("diff_data", scVarJoC.WH());
                jSONObject13.put("version", scVarJoC.ExN());
                jSONObject13.put("dynamic_creative", scVarJoC.UFX());
                jSONObject13.put("engine_version", scVarJoC.Ql());
                jSONObject13.put("ugen_data", scVarJoC.Xc());
                jSONObject13.put("ugen_md5", scVarJoC.dE());
                jSONObject13.put("ugen_url", scVarJoC.BT());
                jSONObject.put("tpl_info", jSONObject13);
            }
            cvk cvkVar = this.zGQ;
            if (cvkVar != null) {
                jSONObject.put("tpl_info_v3", cvkVar.TRI());
            }
            jSONObject.put("dynamic_creative", QoP());
            jSONObject.put("creative_extra", cJ());
            jSONObject.put("market_url", Zp());
            jSONObject.put("auction_price", McK());
            jSONObject.put("ad_info", Kv());
            jSONObject.put("is_package_open", hE());
            jSONObject.put("playable_duration_time", ds());
            jSONObject.put("playable_endcard_close_time", jcs());
            jSONObject.put("endcard_close_time", HC());
            JSONObject jSONObject14 = new JSONObject();
            jSONObject14.put("render_sequence", cvk());
            jSONObject14.put("backup_render_control", II());
            jSONObject14.put("reserve_time", WgX());
            jSONObject14.put("render_thread", ra());
            jSONObject.put("render", jSONObject14);
            if (this.f28379ag == null) {
                wjp wjpVar = new wjp();
                this.f28379ag = wjpVar;
                wjpVar.sc("");
                this.f28379ag.sc(10L);
                this.f28379ag.pFF(20L);
                this.f28379ag.zY(10L);
                this.f28379ag.We(20L);
            }
            JSONObject jSONObject15 = new JSONObject();
            jSONObject15.put("onlylp_loading_maxtime", this.f28379ag.sc());
            jSONObject15.put("straight_lp_showtime", this.f28379ag.pFF());
            jSONObject15.put("onlyagg_loading_maxtime", this.f28379ag.zY());
            jSONObject15.put("straight_agg_showtime", this.f28379ag.We());
            jSONObject15.put("loading_text", this.f28379ag.ExN());
            dE dEVar = this.Qy;
            if (dEVar != null) {
                jSONObject15 = dEVar.sc(jSONObject15);
            }
            jSONObject.put("interaction_method_params", jSONObject15);
            JSONObject jSONObject16 = new JSONObject();
            jSONObject16.put("splash_clickarea", Ql());
            jSONObject16.put("splash_layout_id", SR());
            jSONObject16.put("load_wait_time", BT());
            jSONObject.put("splash_control", jSONObject16);
            if (Pu()) {
                jSONObject.put("dsp_html", this.WgX);
            }
            if (ymG()) {
                jSONObject.put("vast_json", this.f28381bp.WH());
            }
            jSONObject.put("dsp_material_type", Vb());
            jSONObject.put("deep_link_appname", this.McK);
            jSONObject.put("landing_page_download_clicktype", this.Gb);
            Ql ql2 = this.HBq;
            if (ql2 != null) {
                jSONObject.put("dsp_style", ql2.ExN());
            }
            jSONObject.put("jump_probability", this.f28385fb);
            jSONObject.put("identificationOverlayContent", this.xP);
            if (this.HL != null) {
                JSONObject jSONObject17 = new JSONObject();
                jSONObject17.put(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD, this.HL.sc(this.QT));
                jSONObject.put("ugen", jSONObject17);
            }
            jSONObject.put("preload_h5_type", Ay());
            jSONObject.put("hasReportShow", this.wdI);
            jSONObject.put("endcard_creative", this.fKf);
            jSONObject.put("image_stay", this.f28380ap);
            JSONObject jSONObject18 = new JSONObject();
            jSONObject18.put("enable", this.TRI);
            jSONObject18.put("wait_time", this.f28403qr);
            jSONObject18.put("label", this.Qj);
            jSONObject.put("ev", jSONObject18);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int JPJ() {
        int i11 = this.Xc;
        if (i11 == 5 || i11 == 6 || i11 == 33) {
            return 1;
        }
        if (ixT()) {
            return 2;
        }
        return this.f28389pc;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void JPJ(int i11) {
        this.QLv = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void JPJ(String str) {
        this.WgX = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public Sfl.sc JoC() {
        return this.YdT;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void JoC(int i11) {
        this.EOI = i11;
    }

    public int KMz() {
        return this.mbO;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public String Kh() {
        JSONObject jSONObjectJxU;
        if (this.RiV == null && (jSONObjectJxU = jxU()) != null) {
            this.RiV = jSONObjectJxU.optString(BidResponsedEx.KEY_CID, "");
        }
        return this.RiV;
    }

    public String Kv() {
        return this.f28382ds;
    }

    public int Kyy() {
        return this.PPh;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean LVf() {
        List<Integer> listZY;
        return (JoC() == null || (listZY = JoC().zY()) == null || !listZY.contains(57)) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public String McK() {
        return this.vYl;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void McK(int i11) {
        this.ymG = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void McK(String str) {
        this.fKf = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public JSONObject Mrq() {
        return this.f28386gx;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public String MxZ() {
        return this.kX;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void MxZ(int i11) {
        if (i11 < 0 || i11 > 30) {
            i11 = 6;
        }
        this.f28403qr = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public zY NP() {
        return this.Cb;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public String NQ() {
        if (!TextUtils.isEmpty(this.II)) {
            return this.II;
        }
        Context contextSc = com.bytedance.sdk.openadsdk.core.Xc.sc();
        int iQLv = QLv();
        if (iQLv != 2 && iQLv != 3) {
            if (iQLv == 4) {
                return contextSc != null ? com.bytedance.sdk.component.utils.Sfl.sc(contextSc, "tt_video_download_apk") : this.II;
            }
            if (iQLv != 8) {
                return this.II;
            }
        }
        return contextSc != null ? com.bytedance.sdk.component.utils.Sfl.sc(contextSc, "tt_video_mobile_go_detail") : this.II;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public com.bytedance.sdk.openadsdk.core.UFX.TRI.sc NT() {
        return this.QT;
    }

    public int Nv() {
        return this.Ao;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public BT OKY() {
        return this.YIK;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int OUZ() {
        return this.f28403qr;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int OXF() {
        return this.otH;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void OXF(int i11) {
        this.ZM = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public wjp Ol() {
        return this.f28379ag;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void Ol(int i11) {
        this.eoh = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void Ol(String str) {
        this.vYl = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void Ol(boolean z11) {
        this.vzC = z11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void OvL() {
        a aVar = this.yL;
        if (aVar == null || TextUtils.isEmpty(aVar.p())) {
            return;
        }
        try {
            if (!this.yL.p().contains("style_id")) {
                this.VU = false;
            } else {
                this.VU = true;
                this.Eyy = Uri.parse(this.yL.p()).getQueryParameters("style_id").get(0);
            }
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.pFF(th2.getMessage());
        }
    }

    public int Oy() {
        return this.GI;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public String PPh() {
        return this.JP;
    }

    public int PjG() {
        return this.AIZ;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public String Pm() {
        return this.Qj;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean Pu() {
        return this.EOI == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int QLv() {
        return this.dE;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean QST() {
        return this.idT;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int QT() {
        JSONObject jSONObjectJxU = jxU();
        if (jSONObjectJxU != null) {
            return jSONObjectJxU.optInt("rit", 0);
        }
        return 0;
    }

    public int QfS() {
        return this.AZJ;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void Qj(int i11) {
        this.DNB = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void Qj(String str) {
        this.f28382ds = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void Qj(boolean z11) {
        this.wdI = z11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean Qj() {
        return (TextUtils.isEmpty(TRI()) || TextUtils.isEmpty(qr())) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int Ql() {
        We we2 = this.jxU;
        if (we2 == null) {
            return 2;
        }
        return we2.sc();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void Ql(int i11) {
        this.otH = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void Ql(String str) {
        this.Dl = str;
    }

    public JSONObject QoP() {
        return this.BU;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public String Qy() {
        return this.Eyy;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean RiV() {
        return this.BT.f28736sc > 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int SR() {
        if (LVf()) {
            return 5;
        }
        if (Pu()) {
            return 4;
        }
        We we2 = this.jxU;
        if (we2 == null) {
            return 1;
        }
        return we2.pFF();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void SR(int i11) {
        this.AZJ = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void SR(String str) {
        this.uEA = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int Sfl() {
        return this.VZ;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void Sfl(int i11) {
        this.dE = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void Sfl(String str) {
        this.BR = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean TEo() {
        a aVar = this.yL;
        return aVar == null || aVar.l() != 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int TI() {
        return this.Gb;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public String TRI() {
        return this.TI;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void TRI(int i11) {
        this.Mrq = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void TRI(String str) {
        this.TEo = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void TRI(boolean z11) {
        this.WH = z11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public We Tf() {
        return this.jxU;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void Tf(int i11) {
        this.IEI = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void Tf(String str) {
        this.HJN = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean TpG() {
        return this.ofL;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public ExN UFX() {
        return this.coa;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void UFX(int i11) {
        this.mD = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void UFX(String str) {
        this.kX = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void UFX(boolean z11) {
        this.TRI = z11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean VU() {
        return qY() == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public String VZ() {
        return this.WgX;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int Vb() {
        return this.EOI;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public dE WH() {
        return this.Qy;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void WH(int i11) {
        this.PPh = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void WH(String str) {
        this.bSP = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void WH(boolean z11) {
        this.pFF = z11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public JSONObject WMT() {
        JSONObject jSONObjectJP = JP();
        JSONObject jSONObjectWjp = com.bytedance.sdk.openadsdk.core.settings.dE.ef().wjp(String.valueOf(QT()));
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObjectJP);
            jSONObject.put("creatives", jSONArray);
            jSONObject.put("did", 1);
            jSONObject.put("processing_time_ms", 100);
            jSONObject.put(TrackingKey.REQUEST_ID, "aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa");
            jSONObject.put("s_receive_ts", 1);
            jSONObject.put("s_send_ts", 1);
            jSONObject.put("status_code", 20000);
            jSONObject.put("core_settings", jSONObjectWjp);
        } catch (JSONException e11) {
            com.bytedance.sdk.component.utils.Tf.sc("MaterialMeta", "toJsonObjPlus", e11.getMessage());
        }
        return jSONObject;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int WP() {
        return this.Mrq;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public String WP(String str) {
        JSONObject jSONObjectJxU = jxU();
        return jSONObjectJxU != null ? jSONObjectJxU.optString("rit", str) : str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void WP(int i11) {
        this.GI = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void We(int i11) {
        this.f28389pc = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void We(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.dE = 4;
        this.cD = jSONObject.optString("id");
        this.kX = jSONObject.optString("source");
        zY zYVar = new zY();
        this.Cb = zYVar;
        zYVar.zY(jSONObject.optString("pkg_name"));
        this.Cb.pFF(jSONObject.optString("name"));
        this.Cb.sc(jSONObject.optString("download_url"));
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void We(boolean z11) {
        this.idT = z11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean We() {
        return this.OKY;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int WgX() {
        return this.lD;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int Xc() {
        return this.Xc;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void Xc(int i11) {
        this.fT = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void Xc(String str) {
        this.II = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int YIK() {
        return this.Pu;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void YIK(int i11) {
        this.AIZ = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void YIK(String str) {
        this.JoC = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public String YdT() {
        return this.WP;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int Yhz() {
        return this.uPZ;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public String ZM() {
        return this.uEA;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int Zn() {
        return this.bZj;
    }

    public String Zp() {
        return this.gsl;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean ag() {
        return this.ypJ == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public long ap() {
        return this.UFX;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public a auq() {
        return this.Yhz;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public String bSP() {
        return this.cvk;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public com.bytedance.sdk.component.Ol.pFF.sc bZj() {
        com.bytedance.sdk.component.Ol.pFF.sc scVar = new com.bytedance.sdk.component.Ol.pFF.sc();
        scVar.sc(this.fT);
        scVar.pFF(this.cD);
        scVar.sc(mD());
        return scVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean bp() {
        return this.qOv;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public Ol cD() {
        return this.NP;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void cD(int i11) {
        this.lD = Math.max(0, i11);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public String cJ() {
        return this.bSP;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void cJ(int i11) {
        this.f28383ef = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public String coa() {
        return this.xP;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int cvk() {
        return this.kDg;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void cvk(int i11) {
        this.jcs = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void cvk(String str) {
        this.Zn = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public JPJ dE() {
        return this.pCa;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void dE(int i11) {
        this.f28384eo = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void dE(String str) {
        this.cvk = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int dix() {
        return this.cJ;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int ds() {
        int i11 = this.HC;
        if (i11 > 0) {
            return i11;
        }
        return 20;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int ef() {
        JSONObject jSONObject = this.f28390ra;
        if (jSONObject != null) {
            return jSONObject.optInt("easy_playable_skip_duration", 0);
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean eo() {
        return this.Ao == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public Map<String, Object> eoh() {
        return this.Bs;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Sfl sfl = (Sfl) obj;
            if (this.cD.equals(sfl.kDg()) && this.JoC.equals(sfl.mD())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public OXF fKf() {
        return this.BT;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public List<String> fT() {
        return this.FI;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean fb() {
        return qY() == 3 || qY() == 4;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public long gsl() {
        return this.MxZ;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int gx() {
        if (this.hE != 2) {
            this.hE = 1;
        }
        return this.hE;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int hE() {
        return this.jcs;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean hP() {
        return this.vzC;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int hbB() {
        if (this.pXW < 0) {
            try {
                JSONObject jSONObjectJxU = jxU();
                if (jSONObjectJxU != null) {
                    this.pXW = jSONObjectJxU.optInt("is_drop_to_retargeting_sample", 0);
                } else {
                    this.pXW = 0;
                }
            } catch (Throwable unused) {
                this.pXW = 0;
            }
        }
        return this.pXW;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public List<BT> ht() {
        return this.Tf;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int hwa() {
        Map<String, Object> map = this.Bs;
        if (map == null) {
            return 0;
        }
        try {
            Object obj = map.get(TTAdConstant.SDK_BIDDING_TYPE);
            if (obj != null) {
                return Integer.parseInt(obj.toString());
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public List<String> idT() {
        return this.JPJ;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean io() {
        return this.wdI;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean ixT() {
        return Cb() != null && Cb().getDurationSlotType() == 8 && Pu();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int jcs() {
        return this.ymG;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public JSONObject jxU() {
        if (this.NQ == null) {
            try {
                if (!TextUtils.isEmpty(this.JoC)) {
                    this.NQ = new JSONObject(this.JoC);
                }
            } catch (JSONException e11) {
                com.bytedance.sdk.component.utils.Tf.sc("MaterialMeta", e11.getMessage());
            }
        }
        return this.NQ;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public String kDg() {
        return this.cD;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void kX(int i11) {
        this.f28391vl = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean kX() {
        return wDK() == 100 || this.Xc == 20;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public String ko() {
        return this.Dl;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public a lD() {
        return this.qfG;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public String mD() {
        return this.JoC;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean mbO() {
        if (this.Tf.isEmpty()) {
            return false;
        }
        if (this.cJ == 4 && this.Tf.size() < 3) {
            return false;
        }
        Iterator<BT> it = this.Tf.iterator();
        while (it.hasNext()) {
            if (!it.next().ExN()) {
                return false;
            }
        }
        return true;
    }

    public int nQ() {
        return this.QLv;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean nW() {
        return this.f28404sc;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean nj() {
        return this.pFF;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public String ofL() {
        JSONObject jSONObjectJxU;
        String strOptString = this.EZl;
        if (TextUtils.isEmpty(strOptString) && (jSONObjectJxU = jxU()) != null) {
            strOptString = jSONObjectJxU.optString("req_id", "");
            Gb(strOptString);
        }
        return strOptString == null ? "" : strOptString;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public UFX otH() {
        return this.OXF;
    }

    public int oy() {
        return this.IEI;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void pCa() {
        this.qOv = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void pFF(double d11) {
        if (d11 == 2.0d || d11 == 1.0d) {
            this.Pu = (int) d11;
        } else {
            this.Pu = 2;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void pFF(int i11) {
        this.Xc = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void pFF(long j11) {
        this.MxZ = j11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void pFF(com.bytedance.sdk.openadsdk.core.UFX.TRI.sc scVar) {
        this.QT = scVar;
        com.bytedance.sdk.openadsdk.core.UFX.sc.pFF.sc().sc(scVar, CampaignEx.JSON_NATIVE_VIDEO_ENDCARD);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void pFF(BT bt2) {
        this.YIK = bt2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void pFF(JSONObject jSONObject) {
        this.BU = jSONObject;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void pFF(a aVar) {
        this.qfG = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void pFF(boolean z11) {
        this.f28388ko = z11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void pXW() {
        this.BT.ExN();
        qr(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int pc() {
        Tf tf2 = this.WMT;
        if (tf2 == null) {
            return 0;
        }
        return tf2.sc();
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void pc(int i11) {
        this.uoi = i11;
    }

    public com.bytedance.sdk.component.adexpress.sc.zY.We poB() {
        Sfl.sc scVarJoC = JoC();
        if (scVarJoC == null) {
            return null;
        }
        return Sfl.sc.sc(scVarJoC, String.valueOf(QT()));
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public cvk qKn() {
        return this.zGQ;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void qKn(int i11) {
        this.ixT = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int qOv() {
        return this.ZM;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int qY() {
        if (this.bZj < 0) {
            JSONObject jSONObjectJxU = jxU();
            if (jSONObjectJxU != null) {
                this.bZj = jSONObjectJxU.optInt("ad_slot_type", 0);
            } else {
                this.bZj = 0;
            }
        }
        return this.bZj;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public BT qfG() {
        return this.Sfl;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public String qr() {
        return this.TEo;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void qr(int i11) {
        this.kDg = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void qr(String str) {
        this.CYO = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void qr(boolean z11) {
        this.qY = z11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public com.bytedance.sdk.openadsdk.JPJ.sc.pFF rC() {
        return this.OvL;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int ra() {
        return this.auq;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void sc(double d11) {
        if (d11 == 2.0d || d11 == 1.0d) {
            this.VZ = (int) d11;
        } else {
            this.VZ = 1;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void sc(float f11) {
        this.TpG = f11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void sc(int i11) {
        sc(i11, -1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void sc(int i11, int i12) {
        this.wjp = i11;
        this.Xc = i11;
        if (this.dix == null) {
            this.Xc = 0;
            return;
        }
        if (i12 <= 0) {
            i12 = qY();
        }
        if (this.dix.getNativeAdType() == 3 || this.dix.getDurationSlotType() == 3 || i12 == 3) {
            this.Xc = 14;
            return;
        }
        if (this.dix.getNativeAdType() != 7 && this.dix.getNativeAdType() != 8 && this.dix.getDurationSlotType() != 7 && this.dix.getDurationSlotType() != 8 && i12 != 7 && i12 != 8) {
            if (JPJ.pFF(this)) {
                this.Xc = 4;
                return;
            }
            if (this.wjp == 4 && !JPJ.pFF(this)) {
                this.Xc = 0;
            }
            if (i11 >= 5) {
                this.Xc = 0;
                return;
            }
            if (this.wjp == 2 && QLv() != 3) {
                this.Xc = 0;
                return;
            } else {
                if (i11 == 0 || (i11 == 1 && QLv() != 3)) {
                    this.Xc = 0;
                    return;
                }
                return;
            }
        }
        if (JPJ.zY(this)) {
            this.Xc = 12;
            return;
        }
        if (JPJ.pFF(this)) {
            this.Xc = 9;
            return;
        }
        if (this.wjp == 5 && !Xc.We(this)) {
            this.Xc = 7;
        }
        if (this.wjp == 6 && !Xc.pFF(this)) {
            this.Xc = 7;
        }
        if (this.wjp == 8 && wDK() != 100) {
            this.Xc = 7;
        }
        if (this.wjp == 19 && TextUtils.isEmpty(this.Dl)) {
            this.Xc = 7;
        }
        if (this.wjp == 20 && TextUtils.isEmpty(this.Dl)) {
            this.Xc = 7;
        }
        if (this.wjp == 38 && !Xc.zY(this)) {
            this.Xc = 7;
        }
        if (i11 < 5) {
            this.Xc = 7;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void sc(AdSlot adSlot) {
        this.dix = adSlot;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void sc(FilterWord filterWord) {
        this.SR.add(filterWord);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void sc(com.bytedance.sdk.openadsdk.JPJ.sc.pFF pff) {
        this.OvL = pff;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void sc(com.bytedance.sdk.openadsdk.core.Tf.sc scVar) {
        this.f28381bp = scVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void sc(com.bytedance.sdk.openadsdk.core.UFX.TRI.sc scVar) {
        this.HL = scVar;
        com.bytedance.sdk.openadsdk.core.UFX.sc.pFF.sc().sc(scVar, CampaignEx.JSON_NATIVE_VIDEO_ENDCARD);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void sc(BT bt2) {
        sc(bt2, Sfl.Ol);
        String strCD = cD(bt2.sc());
        if (!TextUtils.isEmpty(strCD)) {
            bt2.pFF(strCD);
        }
        this.Sfl = bt2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void sc(ExN exN) {
        this.coa = exN;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void sc(JPJ jpj) {
        this.pCa = jpj;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void sc(Ol ol2) {
        this.NP = ol2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void sc(Ql ql2) {
        this.HBq = ql2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void sc(Sfl.sc scVar) {
        this.YdT = scVar;
        com.bytedance.sdk.component.adexpress.sc.zY.We wePoB = poB();
        if (wePoB != null && !CYO()) {
            com.bytedance.sdk.component.adexpress.sc.pFF.pFF.sc(wePoB);
        }
        if (scVar == null || TextUtils.isEmpty(scVar.BT())) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.UFX.sc.pFF.sc().sc(uS(), "ad");
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void sc(Tf tf2) {
        this.WMT = tf2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void sc(UFX ufx) {
        this.OXF = ufx;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void sc(We we2) {
        this.jxU = we2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void sc(cvk cvkVar) {
        this.zGQ = cvkVar;
        if (cvkVar == null || TextUtils.isEmpty(cvkVar.zY())) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.UFX.sc.pFF.sc().sc(OvN(), "adv3");
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void sc(dE dEVar) {
        this.Qy = dEVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void sc(uEA uea) {
        this.LVf = uea;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void sc(wjp wjpVar) {
        this.f28379ag = wjpVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void sc(zY zYVar) {
        this.Cb = zYVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void sc(Map<String, Object> map) {
        this.Bs = map;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void sc(a aVar) {
        this.yL = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void sc(boolean z11) {
        this.OKY = z11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int uEA() {
        return this.qKn;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void uEA(int i11) {
        this.cJ = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void uEA(String str) {
        this.gsl = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public String uPZ() {
        return this.Zn;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean uoi() {
        if (ymG() && !RiV()) {
            int iNextInt = new Random().nextInt(100);
            Ql ql2 = this.HBq;
            if (ql2 != null && iNextInt < ql2.zY()) {
                return true;
            }
        }
        return false;
    }

    public int vBa() {
        return this.QST;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean vYl() {
        return !ymG() && Oy() == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public JSONObject vl() {
        return this.f28390ra;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002a  */
    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean vzC() {
        int iPFF;
        if (!RiV()) {
            int iNextInt = new Random().nextInt(100);
            if (ymG()) {
                Ql ql2 = this.HBq;
                if (ql2 != null) {
                    iPFF = ql2.pFF();
                } else {
                    iPFF = 0;
                }
            } else if (JPJ.pFF(this)) {
                iPFF = 0;
            } else {
                iPFF = this.f28385fb;
            }
            if (iNextInt < iPFF) {
                return true;
            }
        }
        return false;
    }

    public int wDK() {
        return this.f28384eo;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean wdI() {
        Ql ql2;
        return ymG() && !RiV() && (ql2 = this.HBq) != null && ql2.sc() == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int wjp() {
        return this.wjp;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void wjp(int i11) {
        this.Ao = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void wjp(String str) {
        this.cD = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean wy() {
        return this.TRI;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean xP() {
        return qY() == 7;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean yH() {
        int i11 = this.Xc;
        return (i11 == 2 || i11 == 1) && 3 == this.dE;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean yL() {
        return this.AIZ == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public int yQN() {
        try {
            JSONObject jSONObjectJxU = jxU();
            if (jSONObjectJxU != null) {
                return jSONObjectJxU.optInt("rec_clk", 0);
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public boolean ymG() {
        int i11 = this.EOI;
        return (i11 == 1 || i11 == 3) && GOt() != null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public Ql ypJ() {
        return this.HBq;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public double zGQ() {
        return TRI(jxU());
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void zY(int i11) {
        this.qKn = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void zY(long j11) {
        this.UFX = j11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void zY(BT bt2) {
        this.Tf.add(bt2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void zY(JSONObject jSONObject) {
        this.f28386gx = jSONObject;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void zY(a aVar) {
        this.Yhz = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void zY(boolean z11) {
        this.f28387ht = z11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.model.Sfl
    public void zu() {
        this.yH = true;
    }
}
