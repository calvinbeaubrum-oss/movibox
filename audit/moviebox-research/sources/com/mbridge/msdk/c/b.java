package com.mbridge.msdk.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.logging.type.LogSeverity;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.foundation.tools.r;
import com.mbridge.msdk.foundation.tools.v;
import com.mbridge.msdk.foundation.tools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f42898a = 1500;
    private long G;
    private ArrayList<Integer> I;
    private d J;
    private C0476b K;
    private HashMap<String, String> P;
    private String Q;
    private int V;
    private String Y;
    private Map<String, String> Z;
    private boolean aE;
    private JSONArray aG;
    private JSONObject aH;
    private long aJ;
    private long aO;
    private boolean aP;
    private String aV;
    private String aZ;

    /* JADX INFO: renamed from: ai, reason: collision with root package name */
    private int f42907ai;

    /* JADX INFO: renamed from: al, reason: collision with root package name */
    private String f42910al;

    /* JADX INFO: renamed from: am, reason: collision with root package name */
    private String f42911am;

    /* JADX INFO: renamed from: ap, reason: collision with root package name */
    private int f42914ap;

    /* JADX INFO: renamed from: aq, reason: collision with root package name */
    private int f42915aq;

    /* JADX INFO: renamed from: ar, reason: collision with root package name */
    private int f42916ar;

    /* JADX INFO: renamed from: as, reason: collision with root package name */
    private int f42917as;

    /* JADX INFO: renamed from: av, reason: collision with root package name */
    private long f42920av;

    /* JADX INFO: renamed from: aw, reason: collision with root package name */
    private long f42921aw;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f42936m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private List<com.mbridge.msdk.foundation.entity.a> f42938o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f42940q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private com.mbridge.msdk.c.a f42941r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f42942s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Map<String, a> f42943t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f42944u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f42945v;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f42925b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONArray f42926c = new JSONArray();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private JSONArray f42927d = new JSONArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f42928e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f42929f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f42930g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f42931h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f42932i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f42933j = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f42934k = "";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f42935l = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f42937n = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f42939p = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f42946w = 1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f42947x = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private String f42948y = "";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private String f42949z = "";
    private String A = "";
    private String B = "";
    private String C = "";
    private int D = 120;
    private String E = com.mbridge.msdk.foundation.same.net.g.d.f().f44631h;
    private String F = com.mbridge.msdk.foundation.same.net.g.d.f().f44635l;
    private int H = f42898a;
    private int L = 0;
    private long M = 86400;
    private int N = 0;
    private int O = 3;
    private boolean R = true;
    private int S = 0;
    private boolean T = false;
    private boolean U = false;
    private int W = 0;
    private int X = 0;

    /* JADX INFO: renamed from: aa, reason: collision with root package name */
    private String f42899aa = "1.0";

    /* JADX INFO: renamed from: ab, reason: collision with root package name */
    private int f42900ab = 30;

    /* JADX INFO: renamed from: ac, reason: collision with root package name */
    private int f42901ac = 9377;

    /* JADX INFO: renamed from: ad, reason: collision with root package name */
    private int f42902ad = 0;

    /* JADX INFO: renamed from: ae, reason: collision with root package name */
    private int f42903ae = 5;

    /* JADX INFO: renamed from: af, reason: collision with root package name */
    private int f42904af = 1;

    /* JADX INFO: renamed from: ag, reason: collision with root package name */
    private int f42905ag = 8000;

    /* JADX INFO: renamed from: ah, reason: collision with root package name */
    private String f42906ah = "";

    /* JADX INFO: renamed from: aj, reason: collision with root package name */
    private int f42908aj = 10;

    /* JADX INFO: renamed from: ak, reason: collision with root package name */
    private int f42909ak = 120;

    /* JADX INFO: renamed from: an, reason: collision with root package name */
    private String f42912an = "";

    /* JADX INFO: renamed from: ao, reason: collision with root package name */
    private String f42913ao = "";

    /* JADX INFO: renamed from: at, reason: collision with root package name */
    private String f42918at = "";

    /* JADX INFO: renamed from: au, reason: collision with root package name */
    private String f42919au = "";

    /* JADX INFO: renamed from: ax, reason: collision with root package name */
    private List<Integer> f42922ax = new ArrayList();

    /* JADX INFO: renamed from: ay, reason: collision with root package name */
    private int f42923ay = 3;

    /* JADX INFO: renamed from: az, reason: collision with root package name */
    private int f42924az = 0;
    private int aA = 3;
    private int aB = 0;
    private int aC = 10;
    private int aD = LogSeverity.CRITICAL_VALUE;
    private int aF = 0;
    private String aI = "";
    private int aK = 8000;
    private int aL = 1;
    private long aM = 10;
    private int aN = 3;
    private int aQ = 1;
    private int aR = 1;
    private int aS = 1;
    private int aT = 1;
    private String aU = "";
    private int aW = 1300;
    private int aX = 0;
    private int aY = 0;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List<String> f42950a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<String> f42951b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private List<String> f42952c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private List<String> f42953d;

        public final List<String> a() {
            return this.f42950a;
        }

        public final void a(JSONObject jSONObject) {
            try {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("x");
                if (jSONArrayOptJSONArray != null) {
                    this.f42952c = r.a(jSONArrayOptJSONArray);
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("y");
                if (jSONArrayOptJSONArray2 != null) {
                    this.f42953d = r.a(jSONArrayOptJSONArray2);
                }
                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("width");
                if (jSONArrayOptJSONArray3 != null) {
                    this.f42951b = r.a(jSONArrayOptJSONArray3);
                }
                JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("height");
                if (jSONArrayOptJSONArray4 != null) {
                    this.f42950a = r.a(jSONArrayOptJSONArray4);
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                }
            }
        }

        public final List<String> b() {
            return this.f42951b;
        }

        public final List<String> c() {
            return this.f42952c;
        }

        public final List<String> d() {
            return this.f42953d;
        }
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.c.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0476b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f42954a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private JSONArray f42955b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f42956c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f42957d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f42958e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f42959f;

        public static C0476b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            C0476b c0476b = new C0476b();
            Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
            c0476b.f42959f = jSONObject.optString(CampaignEx.JSON_KEY_TITLE, contextC.getString(v.a(contextC, "mbridge_cm_feedback_dialog_title", "string")));
            c0476b.f42954a = jSONObject.optString("cancel", contextC.getString(v.a(contextC, "mbridge_cm_feedback_dialog_close_close", "string")));
            c0476b.f42957d = jSONObject.optString("submit", contextC.getString(v.a(contextC, "mbridge_cm_feedback_dialog_close_submit", "string")));
            c0476b.f42958e = jSONObject.optString("submit_notice", contextC.getString(v.a(contextC, "mbridge_cm_feedback_dialog_submit_notice", "string")));
            c0476b.f42956c = jSONObject.optString("privacy", contextC.getString(v.a(contextC, "mbridge_cm_feedback_dialog_privacy_des", "string")));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(AppLovinEventTypes.USER_VIEWED_CONTENT);
            c0476b.f42955b = jSONArrayOptJSONArray;
            if (jSONArrayOptJSONArray == null) {
                JSONArray jSONArray = new JSONArray();
                c0476b.f42955b = jSONArray;
                jSONArray.put(contextC.getString(v.a(contextC, "mbridge_cm_feedback_dialog_content_not_play", "string")));
                c0476b.f42955b.put(contextC.getString(v.a(contextC, "mbridge_cm_feedback_dialog_content_sound_problems", "string")));
                c0476b.f42955b.put(contextC.getString(v.a(contextC, "mbridge_cm_feedback_dialog_content_misleading", "string")));
                c0476b.f42955b.put(contextC.getString(v.a(contextC, "mbridge_cm_feedback_dialog_content_fraud", "string")));
                c0476b.f42955b.put(contextC.getString(v.a(contextC, "mbridge_cm_feedback_dialog_content_por_violence", "string")));
                c0476b.f42955b.put(contextC.getString(v.a(contextC, "mbridge_cm_feedback_dialog_content_other", "string")));
            }
            return c0476b;
        }

        public final String a() {
            return this.f42954a;
        }

        public final JSONArray b() {
            return this.f42955b;
        }

        public final String c() {
            return this.f42956c;
        }

        public final String d() {
            return this.f42957d;
        }

        public final String e() {
            return this.f42958e;
        }

        public final String f() {
            return this.f42959f;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static g a(JSONObject jSONObject) {
        g gVar;
        FastKV fastKVBuild;
        ArrayList arrayList;
        if (jSONObject == null) {
            return null;
        }
        try {
            g gVar2 = new g();
            try {
                ((b) gVar2).aH = jSONObject;
                ((b) gVar2).f42942s = jSONObject.optString("cc");
                ((b) gVar2).f42911am = jSONObject.optString("mv_wildcard", "<mvpackage>mbridge</mvpackage>");
                ((b) gVar2).f42945v = jSONObject.optInt("cfc");
                ((b) gVar2).M = jSONObject.optLong("getpf");
                ((b) gVar2).G = jSONObject.optLong("current_time");
                ((b) gVar2).f42944u = jSONObject.optBoolean("cfb");
                ((b) gVar2).f42940q = jSONObject.optLong("awct");
                ((b) gVar2).f42920av = jSONObject.optLong(CampaignEx.JSON_KEY_PLCT) == 0 ? 3600L : jSONObject.optLong(CampaignEx.JSON_KEY_PLCT);
                ((b) gVar2).aE = jSONObject.optBoolean("rurl");
                ((b) gVar2).aO = jSONObject.optLong("uct");
                ((b) gVar2).aP = jSONObject.optBoolean("ujds");
                ((b) gVar2).f42916ar = jSONObject.optInt("n2");
                ((b) gVar2).f42917as = jSONObject.optInt("n3");
                ((b) gVar2).V = jSONObject.optInt("is_startup_crashsystem", 1);
                ((b) gVar2).f42915aq = jSONObject.optInt("pcrn");
                ((b) gVar2).f42921aw = jSONObject.optLong(CampaignEx.JSON_KEY_PLCTB) == 0 ? 7200L : jSONObject.optLong(CampaignEx.JSON_KEY_PLCTB);
                ((b) gVar2).f42915aq = jSONObject.optInt("pcrn", 100);
                ((b) gVar2).f42914ap = jSONObject.optInt("opent", 1);
                ((b) gVar2).aJ = jSONObject.optLong("sfct", 1800L);
                ((b) gVar2).aS = jSONObject.optInt("upgd", 1);
                ((b) gVar2).aT = jSONObject.optInt("upsrl", 1);
                ((b) gVar2).aR = jSONObject.optInt("updevid", 1);
                ((b) gVar2).aF = jSONObject.optInt("sc", 0);
                ((b) gVar2).aQ = jSONObject.optInt("up_tips", 1);
                ((b) gVar2).W = jSONObject.optInt("iseu", -1);
                ((b) gVar2).Y = jSONObject.optString("jm_unit");
                try {
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("atf");
                    if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList();
                        for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
                            String strOptString = jSONArrayOptJSONArray.optString(i11);
                            if (an.b(strOptString)) {
                                JSONObject jSONObject2 = new JSONObject(strOptString);
                                arrayList.add(new com.mbridge.msdk.foundation.entity.a(jSONObject2.optInt("adtype"), jSONObject2.optString("unitid")));
                            }
                        }
                    }
                    if (arrayList != null) {
                        ((b) gVar2).f42938o = arrayList;
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                ((b) gVar2).f42936m = jSONObject.optInt("adct", 259200);
                ((b) gVar2).C = jSONObject.optString("confirm_title", "");
                ((b) gVar2).A = jSONObject.optString("confirm_description", "");
                ((b) gVar2).B = jSONObject.optString("confirm_t", "");
                ((b) gVar2).f42949z = jSONObject.optString("confirm_c_rv", "");
                ((b) gVar2).f42948y = jSONObject.optString("confirm_c_play", "");
                ((b) gVar2).f42933j = jSONObject.optString("adchoice_icon", "");
                ((b) gVar2).f42934k = jSONObject.optString("adchoice_link", "");
                ((b) gVar2).f42935l = jSONObject.optString("adchoice_size", "");
                ((b) gVar2).f42918at = jSONObject.optString("platform_logo", "");
                ((b) gVar2).f42919au = jSONObject.optString("platform_name", "");
                ((b) gVar2).f42943t = e(jSONObject.optString("cdnate_cfg", ""));
                ((b) gVar2).f42939p = jSONObject.optInt("atrqt", 0);
                ((b) gVar2).X = jSONObject.optInt("iupdid", 0);
                ((b) gVar2).f42909ak = jSONObject.optInt("mcs", 120);
                ((b) gVar2).f42928e = jSONObject.optString("ab_id", "");
                ((b) gVar2).aI = jSONObject.optString("rid", "");
                ((b) gVar2).f42899aa = jSONObject.optString("log_rate", "-1");
                ((b) gVar2).f42913ao = jSONObject.optString("omsdkjs_url", "");
                ((b) gVar2).f42912an = jSONObject.optString("omsdkjs_h5_url", "");
                ((b) gVar2).f42924az = jSONObject.optInt("rty_tk_clk", 0);
                ((b) gVar2).aB = jSONObject.optInt("rty_tk_imp", 0);
                ((b) gVar2).aA = jSONObject.optInt("rty_cnt", 3);
                ((b) gVar2).aD = jSONObject.optInt("rty_to", LogSeverity.CRITICAL_VALUE);
                ((b) gVar2).aC = jSONObject.optInt("rty_inr", 10);
                String strOptString2 = jSONObject.optString("dns");
                ((b) gVar2).aZ = strOptString2;
                if (!TextUtils.isEmpty(strOptString2)) {
                    e.a.f43012a.c(x.a(strOptString2));
                }
                ((b) gVar2).f42913ao = jSONObject.optString("omsdkjs_url", "");
                ((b) gVar2).f42912an = jSONObject.optString("omsdkjs_h5_url", "");
                long jOptLong = jSONObject.optLong("tcto");
                if (jOptLong == 0) {
                    ((b) gVar2).aM = 10L;
                } else {
                    ((b) gVar2).aM = jOptLong;
                    JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("jt");
                    if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                        HashMap map = new HashMap();
                        for (int i12 = 0; i12 < jSONArrayOptJSONArray2.length(); i12++) {
                            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray2.optJSONObject(i12);
                            map.put(jSONObjectOptJSONObject.optString("domain"), jSONObjectOptJSONObject.optString("format"));
                        }
                        ((b) gVar2).Z = map;
                    }
                }
                ((b) gVar2).f42910al = jSONObject.optString("mraid_js");
                ((b) gVar2).aV = jSONObject.optString("web_env_url");
                int iOptInt = jSONObject.optInt("alrbs", 0);
                if (iOptInt > 2 || iOptInt < 0) {
                    iOptInt = 0;
                }
                ((b) gVar2).f42937n = iOptInt;
                ((b) gVar2).f42925b = jSONObject.optBoolean("GDPR_area", false);
                ((b) gVar2).D = jSONObject.optInt("ct", 120);
                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("ercd");
                if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                    ArrayList<Integer> arrayList2 = new ArrayList<>();
                    for (int i13 = 0; i13 < jSONArrayOptJSONArray3.length(); i13++) {
                        int iOptInt2 = jSONArrayOptJSONArray3.optInt(i13);
                        if (iOptInt2 != 0) {
                            arrayList2.add(Integer.valueOf(iOptInt2));
                        }
                    }
                    if (arrayList2.size() > 0) {
                        arrayList2.add(-1);
                        ((b) gVar2).I = arrayList2;
                    }
                }
                String strOptString3 = jSONObject.optString("hst");
                if (!TextUtils.isEmpty(strOptString3)) {
                    try {
                        JSONObject jSONObject3 = new JSONObject(x.a(strOptString3));
                        Iterator<String> itKeys = jSONObject3.keys();
                        HashMap<String, String> map2 = new HashMap<>();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(jSONObject3.optString(next)) && !TextUtils.isEmpty(x.a(jSONObject3.optString(next)))) {
                                map2.put(next, jSONObject3.optString(next));
                            }
                        }
                        if (map2.size() > 0) {
                            ((b) gVar2).P = map2;
                        }
                    } catch (Exception e12) {
                        ad.b("SETTING", e12.getMessage());
                    }
                }
                JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("refactor_switch");
                if (jSONArrayOptJSONArray4 != null && jSONArrayOptJSONArray4.length() > 0) {
                    for (int i14 = 0; i14 < jSONArrayOptJSONArray4.length(); i14++) {
                        JSONObject jSONObject4 = jSONArrayOptJSONArray4.getJSONObject(i14);
                        Iterator<String> itKeys2 = jSONObject4.keys();
                        while (itKeys2.hasNext()) {
                            String next2 = itKeys2.next();
                            if (!TextUtils.isEmpty(next2) && jSONObject4.getBoolean(next2)) {
                                ((b) gVar2).f42922ax.add(Integer.valueOf(Integer.parseInt(next2)));
                            }
                        }
                    }
                }
                try {
                    int iOptInt3 = jSONObject.optInt("lqcnt", 30);
                    int iOptInt4 = jSONObject.optInt("lqto", 5);
                    int iOptInt5 = jSONObject.optInt("lqswt", 0);
                    int iOptInt6 = jSONObject.optInt("lqtype", 1);
                    ((b) gVar2).f42903ae = iOptInt4;
                    ((b) gVar2).f42900ab = iOptInt3;
                    ((b) gVar2).f42902ad = iOptInt5;
                    ((b) gVar2).f42904af = iOptInt6;
                    JSONArray jSONArrayOptJSONArray5 = jSONObject.optJSONArray("lg_bl");
                    if (jSONArrayOptJSONArray5 == null) {
                        jSONArrayOptJSONArray5 = new JSONArray();
                        jSONArrayOptJSONArray5.put("2000088");
                    }
                    ((b) gVar2).f42926c = jSONArrayOptJSONArray5;
                    JSONArray jSONArrayOptJSONArray6 = jSONObject.optJSONArray("lg_wl");
                    if (jSONArrayOptJSONArray6 == null) {
                        jSONArrayOptJSONArray6 = new JSONArray();
                        jSONArrayOptJSONArray6.put("2000041");
                        jSONArrayOptJSONArray6.put("2000042");
                        jSONArrayOptJSONArray6.put("2000032");
                        jSONArrayOptJSONArray6.put("2000079");
                    }
                    ((b) gVar2).f42927d = jSONArrayOptJSONArray6;
                    ((b) gVar2).aX = jSONObject.optInt("lg_wl_rt");
                    ((b) gVar2).aK = jSONObject.optInt("srml", 8000);
                    ((b) gVar2).f42905ag = jSONObject.optInt("lrml", 8000);
                    ((b) gVar2).aW = jSONObject.optInt("wgl_d_ms", 1300);
                    int iOptInt7 = jSONObject.optInt("dp_ct", f42898a);
                    ((b) gVar2).H = iOptInt7;
                    com.mbridge.msdk.click.b.a.f43105c = iOptInt7;
                    int i15 = Integer.parseInt(x.a(jSONObject.optString("lqpt")));
                    if (i15 > 0 && i15 < 65535) {
                        ((b) gVar2).f42901ac = i15;
                        com.mbridge.msdk.foundation.same.net.g.d.f().f44636m = i15;
                        com.mbridge.msdk.foundation.same.net.g.d.f().f44639p = i15;
                    }
                } catch (Exception unused) {
                }
                ((b) gVar2).aY = jSONObject.optInt("wvddt", 0);
                ((b) gVar2).E = jSONObject.optString("hst_st", "");
                ((b) gVar2).F = jSONObject.optString("hst_st_t", "");
                try {
                    int iOptInt8 = jSONObject.optInt("l", 3);
                    boolean z11 = jSONObject.optInt(CampaignEx.JSON_KEY_AD_K, 0) == 1;
                    boolean z12 = jSONObject.optInt("m", 1) == 1;
                    ((b) gVar2).f42923ay = iOptInt8;
                    ((b) gVar2).U = z11;
                    ((b) gVar2).R = z12;
                } catch (Exception e13) {
                    ad.b("Setting", e13.getMessage());
                }
                ((b) gVar2).L = jSONObject.optInt("fbk_swt", 0);
                ((b) gVar2).K = C0476b.a(jSONObject.optJSONObject("fbk"));
                try {
                    int iOptInt9 = jSONObject.optInt("ad_connection_timeout", com.mbridge.msdk.foundation.same.a.f44379o);
                    int iOptInt10 = jSONObject.optInt("ad_read_timeout", com.mbridge.msdk.foundation.same.a.f44381q);
                    int iOptInt11 = jSONObject.optInt("ad_write_timeout", com.mbridge.msdk.foundation.same.a.f44383s);
                    int iOptInt12 = jSONObject.optInt("ad_retry_count", com.mbridge.msdk.foundation.same.a.f44382r);
                    if (iOptInt9 <= 0) {
                        iOptInt9 = com.mbridge.msdk.foundation.same.a.f44379o;
                    }
                    ((b) gVar2).f42929f = iOptInt9;
                    if (iOptInt10 <= 0) {
                        iOptInt10 = com.mbridge.msdk.foundation.same.a.f44381q;
                    }
                    ((b) gVar2).f42930g = iOptInt10;
                    if (iOptInt11 <= 0) {
                        iOptInt11 = com.mbridge.msdk.foundation.same.a.f44383s;
                    }
                    ((b) gVar2).f42932i = iOptInt11;
                    if (iOptInt12 < 0) {
                        iOptInt12 = com.mbridge.msdk.foundation.same.a.f44382r;
                    }
                    ((b) gVar2).f42931h = iOptInt12;
                    int iOptInt13 = jSONObject.optInt("max_download_task_size", 10);
                    if (iOptInt13 <= 0) {
                        iOptInt13 = 10;
                    }
                    ((b) gVar2).f42907ai = iOptInt13;
                    gVar2.o(jSONObject.optInt("max_bitmap_cache_size", 10));
                    ((b) gVar2).aN = jSONObject.optInt("t_t", 3);
                    ((b) gVar2).O = jSONObject.optInt("h_t", 3);
                    int iOptInt14 = jSONObject.optInt("gtp");
                    ((b) gVar2).N = iOptInt14;
                    com.mbridge.msdk.foundation.same.net.g.d.f().a(iOptInt14);
                } catch (Exception unused2) {
                }
                try {
                    ((b) gVar2).Q = jSONObject.optString("http_track_url", "");
                } catch (Exception unused3) {
                }
                ((b) gVar2).aL = jSONObject.optInt("st_net", 1);
                ((b) gVar2).aU = jSONObject.optString("vtag", "");
                try {
                    ((b) gVar2).f42947x = jSONObject.optInt("check_webview", 0) != 0;
                } catch (Exception unused4) {
                    ((b) gVar2).f42947x = false;
                }
                String strOptString4 = jSONObject.optString("swxid");
                if (!TextUtils.isEmpty(((b) gVar2).f42906ah)) {
                    ((b) gVar2).f42906ah = strOptString4;
                    if (TextUtils.isEmpty(com.mbridge.msdk.foundation.controller.c.m().h())) {
                        com.mbridge.msdk.foundation.controller.c.m().a(((b) gVar2).f42906ah);
                    }
                }
                ((b) gVar2).aG = jSONObject.optJSONArray("sdk_filters");
                try {
                    ((b) gVar2).f42946w = jSONObject.optInt("ch_nv_im_cb", 1);
                } catch (Exception unused5) {
                    ((b) gVar2).f42946w = 1;
                }
                try {
                    ((b) gVar2).T = jSONObject.optInt("do_us_fi_re", 1) != 0;
                } catch (Exception unused6) {
                    ((b) gVar2).T = true;
                }
                try {
                    com.mbridge.msdk.foundation.controller.d.a();
                    try {
                        fastKVBuild = new FastKV.Builder(com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), x.a("H+tU+FeXHM==")).build();
                    } catch (Exception unused7) {
                        fastKVBuild = null;
                    }
                    if (fastKVBuild != null) {
                        try {
                            if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                                String strOptString5 = jSONObject.optString(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
                                if (!TextUtils.isEmpty(strOptString5) && !TextUtils.equals(com.mbridge.msdk.foundation.same.a.U, strOptString5)) {
                                    com.mbridge.msdk.foundation.same.a.U = strOptString5;
                                    com.mbridge.msdk.foundation.a.a.a.a().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.U);
                                    try {
                                        fastKVBuild.putString(x.a("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.U);
                                    } catch (Exception unused8) {
                                    }
                                }
                                String strOptString6 = jSONObject.optString("c");
                                if (!TextUtils.isEmpty(strOptString6) && !TextUtils.equals(com.mbridge.msdk.foundation.same.a.f44371g, strOptString6)) {
                                    com.mbridge.msdk.foundation.same.a.f44371g = strOptString6;
                                    com.mbridge.msdk.foundation.a.a.a.a().a("c", com.mbridge.msdk.foundation.same.a.f44371g);
                                    try {
                                        fastKVBuild.putString(x.a("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.f44371g);
                                    } catch (Exception unused9) {
                                    }
                                }
                            }
                        } catch (Exception e14) {
                            e14.printStackTrace();
                        }
                    } else {
                        try {
                            Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
                            if (contextC != null) {
                                String strOptString7 = jSONObject.optString(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
                                if (!TextUtils.isEmpty(strOptString7) && !TextUtils.equals(com.mbridge.msdk.foundation.same.a.U, strOptString7)) {
                                    com.mbridge.msdk.foundation.same.a.U = strOptString7;
                                    com.mbridge.msdk.foundation.a.a.a.a().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.U);
                                    SharedPreferences sharedPreferences = contextC.getSharedPreferences(x.a("H+tU+FeXHM=="), 0);
                                    if (sharedPreferences != null) {
                                        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                                        editorEdit.putString(x.a("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.U);
                                        editorEdit.apply();
                                    }
                                }
                                String strOptString8 = jSONObject.optString("c");
                                if (!TextUtils.isEmpty(strOptString8) && !TextUtils.equals(com.mbridge.msdk.foundation.same.a.f44371g, strOptString8)) {
                                    com.mbridge.msdk.foundation.same.a.f44371g = strOptString8;
                                    com.mbridge.msdk.foundation.a.a.a.a().a("c", com.mbridge.msdk.foundation.same.a.f44371g);
                                    SharedPreferences sharedPreferences2 = contextC.getSharedPreferences(x.a("H+tU+FeXHM=="), 0);
                                    if (sharedPreferences2 != null) {
                                        SharedPreferences.Editor editorEdit2 = sharedPreferences2.edit();
                                        editorEdit2.putString(x.a("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.f44371g);
                                        editorEdit2.apply();
                                    }
                                }
                            }
                        } catch (Exception e15) {
                            e15.printStackTrace();
                        }
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                String strOptString9 = jSONObject.optString("bcp");
                if (!TextUtils.isEmpty(strOptString9)) {
                    ((b) gVar2).f42941r = com.mbridge.msdk.c.a.a(x.a(strOptString9));
                }
                String strOptString10 = jSONObject.optString("monitor");
                if (!TextUtils.isEmpty(strOptString10)) {
                    ((b) gVar2).J = d.a(x.a(strOptString10));
                }
                return gVar2;
            } catch (Exception e17) {
                e = e17;
                gVar = gVar2;
                e.printStackTrace();
                return gVar;
            }
        } catch (Exception e18) {
            e = e18;
            gVar = null;
        }
    }

    public static String a(Context context, String str) {
        try {
            g gVarB = h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
            if (gVarB != null && ((b) gVarB).Z != null) {
                String host = Uri.parse(str).getHost();
                Iterator<Map.Entry<String, String>> it = ((b) gVarB).Z.entrySet().iterator();
                while (it.hasNext()) {
                    String key = it.next().getKey();
                    if (!TextUtils.isEmpty(host) && host.contains(key)) {
                        String str2 = ((b) gVarB).Z.get(key);
                        return TextUtils.isEmpty(str2) ? "" : str2.replace("{gaid}", com.mbridge.msdk.foundation.tools.e.c());
                    }
                }
                return "";
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private static Map<String, a> e(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HashMap map = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                a aVar = new a();
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
                if (jSONObjectOptJSONObject != null) {
                    aVar.a(jSONObjectOptJSONObject);
                }
                map.put(next, aVar);
            }
            return map;
        } catch (JSONException e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
            return null;
        } catch (Exception e12) {
            if (MBridgeConstans.DEBUG) {
                e12.printStackTrace();
            }
            return null;
        }
    }

    public final long A() {
        return this.G;
    }

    public final ArrayList<Integer> B() {
        return this.I;
    }

    public final d C() {
        return this.J;
    }

    public final C0476b D() {
        return this.K;
    }

    public final long E() {
        return this.M;
    }

    public final int F() {
        return this.O;
    }

    public final HashMap<String, String> G() {
        return this.P;
    }

    public final String H() {
        return this.Q;
    }

    public final int I() {
        return this.S;
    }

    public final int J() {
        return this.V;
    }

    public final int K() {
        return this.W;
    }

    public final JSONArray L() {
        return this.f42926c;
    }

    public final JSONArray M() {
        return this.f42927d;
    }

    public final String N() {
        return this.f42899aa;
    }

    public final int O() {
        return this.f42904af;
    }

    public final int P() {
        return this.f42905ag;
    }

    public final int Q() {
        return this.f42908aj;
    }

    public final int R() {
        return this.f42907ai;
    }

    public final int S() {
        return this.f42909ak;
    }

    public final String T() {
        return this.f42910al;
    }

    public final String U() {
        return this.f42911am;
    }

    public final String V() {
        return this.f42912an;
    }

    public final String W() {
        return this.f42913ao;
    }

    public final int X() {
        return this.f42914ap;
    }

    public final int Y() {
        return this.f42915aq;
    }

    public final int Z() {
        return this.f42916ar;
    }

    public final String a() {
        return this.f42928e;
    }

    public final void a(int i11) {
        this.f42929f = i11;
    }

    public final void a(long j11) {
        this.f42940q = j11;
    }

    public final void a(String str) {
        this.Q = str;
    }

    public final void a(boolean z11) {
        this.f42944u = z11;
    }

    public final int aA() {
        return this.aX;
    }

    public final int aB() {
        return this.aY;
    }

    public final boolean aC() {
        return this.R;
    }

    public final boolean aD() {
        return this.f42944u;
    }

    public final boolean aE() {
        return this.f42947x;
    }

    public final boolean aF() {
        return this.T;
    }

    public final boolean aG() {
        return this.f42925b;
    }

    public final boolean aH() {
        return this.U;
    }

    public final boolean aI() {
        return this.aE;
    }

    public final boolean aJ() {
        return this.aP;
    }

    public final void aK() {
        String language = Locale.getDefault().getLanguage();
        if (TextUtils.isEmpty(this.C) || TextUtils.isEmpty(this.A) || TextUtils.isEmpty(this.B) || TextUtils.isEmpty(this.f42949z)) {
            if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                this.C = "Confirm to close? ";
                this.A = "You will not be rewarded after closing the window";
                this.B = "Close it";
                this.f42949z = "Continue";
            } else {
                this.C = "确认关闭？";
                this.A = "关闭后您将不会获得任何奖励噢~ ";
                this.B = "确认关闭";
                this.f42949z = "继续观看";
            }
        }
        if (TextUtils.isEmpty(this.C) || TextUtils.isEmpty(this.A) || TextUtils.isEmpty(this.B) || TextUtils.isEmpty(this.f42948y)) {
            if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                this.C = "Confirm to close? ";
                this.A = "You will not be rewarded after closing the window";
                this.B = "Close it";
                this.f42948y = "Continue";
                return;
            }
            this.C = "确认关闭？";
            this.A = "关闭后您将不会获得任何奖励噢~ ";
            this.B = "确认关闭";
            this.f42948y = "继续试玩";
        }
    }

    public final int aa() {
        return this.f42917as;
    }

    public final long ab() {
        return this.f42920av;
    }

    public final long ac() {
        if (this.f42921aw <= 0) {
            this.f42921aw = 7200L;
        }
        return this.f42921aw;
    }

    public final int ad() {
        return this.f42923ay;
    }

    public final int ae() {
        return this.f42924az;
    }

    public final int af() {
        return this.aA;
    }

    public final int ag() {
        return this.aB;
    }

    public final int ah() {
        return this.aC;
    }

    public final int ai() {
        return this.aD;
    }

    public final int aj() {
        return this.aF;
    }

    public final JSONArray ak() {
        return this.aG;
    }

    public final JSONObject al() {
        return this.aH;
    }

    public final String am() {
        return this.aI;
    }

    public final long an() {
        return this.aJ;
    }

    public final int ao() {
        return this.aK;
    }

    public final int ap() {
        return this.aL;
    }

    public final long aq() {
        return this.aM * 1000;
    }

    public final int ar() {
        return this.aN;
    }

    public final long as() {
        return this.aO;
    }

    public final int at() {
        return this.aQ;
    }

    public final int au() {
        return this.aR;
    }

    public final int av() {
        return this.aS;
    }

    public final int aw() {
        return this.aT;
    }

    public final String ax() {
        return this.aU;
    }

    public final String ay() {
        return this.aV;
    }

    public final int az() {
        return this.aW;
    }

    public final int b() {
        return this.f42929f;
    }

    public final void b(int i11) {
        this.f42930g = i11;
    }

    public final void b(long j11) {
        this.f42920av = j11;
    }

    public final void b(String str) {
        this.f42911am = str;
    }

    public final void b(boolean z11) {
        this.f42947x = z11;
    }

    public final int c() {
        return this.f42930g;
    }

    public final void c(int i11) {
        this.f42931h = i11;
    }

    public final void c(long j11) {
        this.f42921aw = j11;
    }

    public final void c(String str) {
        this.f42912an = str;
    }

    public final void c(boolean z11) {
        this.T = z11;
    }

    public final int d() {
        return this.f42931h;
    }

    public final void d(int i11) {
        this.f42932i = i11;
    }

    public final void d(long j11) {
        this.aJ = j11;
    }

    public final void d(String str) {
        this.f42913ao = str;
    }

    public final void d(boolean z11) {
        this.f42925b = z11;
    }

    public final int e() {
        return this.f42932i;
    }

    public final void e(int i11) {
        this.f42936m = i11;
    }

    public final void e(long j11) {
        this.aM = j11;
    }

    public final void e(boolean z11) {
        this.aE = z11;
    }

    public final String f() {
        return this.f42933j;
    }

    public final void f(int i11) {
        this.f42937n = i11;
    }

    public final void f(boolean z11) {
        this.aP = z11;
    }

    public final String g() {
        return this.f42934k;
    }

    public final void g(int i11) {
        this.f42939p = i11;
    }

    public final String h() {
        return this.f42935l;
    }

    public final void h(int i11) {
        this.f42945v = i11;
    }

    public final int i() {
        return this.f42936m;
    }

    public final void i(int i11) {
        this.f42946w = i11;
    }

    public final int j() {
        return this.f42937n;
    }

    public final void j(int i11) {
        this.D = i11;
    }

    public final List<com.mbridge.msdk.foundation.entity.a> k() {
        return this.f42938o;
    }

    public final void k(int i11) {
        this.O = i11;
    }

    public final int l() {
        return this.f42939p;
    }

    public final void l(int i11) {
        this.S = i11;
    }

    public final long m() {
        return this.f42940q;
    }

    public final void m(int i11) {
        this.V = i11;
    }

    public final com.mbridge.msdk.c.a n() {
        return this.f42941r;
    }

    public final void n(int i11) {
        this.W = i11;
    }

    public final String o() {
        return this.f42942s;
    }

    public final void o(int i11) {
        if (i11 > 0) {
            this.f42908aj = i11;
        }
    }

    public final Map<String, a> p() {
        return this.f42943t;
    }

    public final void p(int i11) {
        this.f42907ai = i11;
    }

    public final int q() {
        return this.f42945v;
    }

    public final void q(int i11) {
        this.f42909ak = i11;
    }

    public final int r() {
        return this.f42946w;
    }

    public final void r(int i11) {
        this.aF = i11;
    }

    public final String s() {
        return this.f42948y;
    }

    public final void s(int i11) {
        this.aL = i11;
    }

    public final String t() {
        return this.f42949z;
    }

    public final void t(int i11) {
        this.aN = i11;
    }

    public String toString() {
        return " cfc=" + this.f42945v + " getpf=" + this.M + " rurl=" + this.aE;
    }

    public final String u() {
        return this.A;
    }

    public final void u(int i11) {
        this.aQ = i11;
    }

    public final String v() {
        return this.B;
    }

    public final void v(int i11) {
        this.aR = i11;
    }

    public final String w() {
        return this.C;
    }

    public final void w(int i11) {
        this.aS = i11;
    }

    public final int x() {
        return this.D;
    }

    public final void x(int i11) {
        this.aT = i11;
    }

    public final String y() {
        return this.E;
    }

    public final boolean y(int i11) {
        return this.f42922ax.contains(Integer.valueOf(i11));
    }

    public final String z() {
        return this.F;
    }
}
