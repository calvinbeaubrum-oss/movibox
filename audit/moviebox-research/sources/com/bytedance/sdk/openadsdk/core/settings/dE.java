package com.bytedance.sdk.openadsdk.core.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.applovin.sdk.AppLovinMediationProvider;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.cloud.tmc.integration.core.TmcEngineFactory;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.common.api.Api;
import com.google.logging.type.LogSeverity;
import com.hisavana.common.constant.ComConstants;
import com.transsion.push.PushConstants;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class dE implements SR.sc, TRI {
    private final Ql BT;
    private boolean Dl;
    private ExN.pFF<JSONObject> Gb;
    private final ExN.pFF<Set<String>> HJN;
    private final ExN.pFF<Map<String, Integer>> II;
    private Ol JPJ;
    private final Set<String> McK;
    ExN.pFF<com.bytedance.sdk.openadsdk.We.sc.SR> Qj;
    private final WH Ql;
    private final com.bytedance.sdk.openadsdk.core.settings.sc SR;
    private int Sfl;
    private Set<String> WH;
    private final BroadcastReceiver WP;
    private volatile boolean Xc;
    private int YIK;
    private final Runnable cvk;
    private final AtomicBoolean dE;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    final ExN.pFF<ConcurrentHashMap<String, Integer>> f28499qr;
    private boolean wjp;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static final String f28498sc = a9.a.a("_", new CharSequence[]{"bus_con_collect", cJ.Dl()});
    public static final String pFF = a9.a.a("_", new CharSequence[]{"bus_con", cJ.Dl(), cJ.YIK(), "timeout"});
    public static final String zY = a9.a.a("_", new CharSequence[]{"bus_con", cJ.Dl(), cJ.YIK(), "alpha"});
    private static final String Ol = cJ.SR();
    private static final com.bytedance.sdk.component.Qj.Qj UFX = new com.bytedance.sdk.component.Qj.Qj("TemplateReInitTask") { // from class: com.bytedance.sdk.openadsdk.core.settings.dE.1
        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.component.adexpress.sc.pFF.ExN.pFF().Ol();
            com.bytedance.sdk.component.adexpress.sc.pFF.ExN.pFF().pFF(false);
            com.bytedance.sdk.component.adexpress.sc.pFF.pFF.pFF();
            com.bytedance.sdk.component.adexpress.sc.pFF.ExN.pFF().zY();
        }
    };
    public static String We = "";
    public static String ExN = "IABTCF_TCString";
    private static boolean Tf = false;
    private static final ConcurrentLinkedQueue<BT.sc> uEA = new ConcurrentLinkedQueue<>();
    private static final UFX FI = new UFX();
    static final ConcurrentHashMap<String, Integer> TRI = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.settings.dE$11, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public class AnonymousClass11 extends BroadcastReceiver {
        private final Runnable pFF = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.settings.dE.11.1
            @Override // java.lang.Runnable
            public void run() {
                Cb.pFF(new com.bytedance.sdk.component.Qj.Qj("LoadLocalData") { // from class: com.bytedance.sdk.openadsdk.core.settings.dE.11.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            dE.this.pFF();
                        } catch (Exception unused) {
                        }
                    }
                });
            }
        };

        public AnonymousClass11() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            if (intent == null) {
                return;
            }
            Cb.pFF(new com.bytedance.sdk.component.Qj.Qj("setting_receiver") { // from class: com.bytedance.sdk.openadsdk.core.settings.dE.11.2
                @Override // java.lang.Runnable
                public void run() {
                    String action = intent.getAction();
                    if ("_tryFetRemoDat".equals(action)) {
                        dE.this.sc(intent.getIntExtra("_source", 0), intent.getBooleanExtra("_force", false));
                    } else if ("_dataChanged".equals(action)) {
                        com.bytedance.sdk.component.utils.qr.sc().removeCallbacks(AnonymousClass11.this.pFF);
                        com.bytedance.sdk.component.utils.qr.sc().postDelayed(AnonymousClass11.this.pFF, 10000L);
                    }
                }
            });
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class sc {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        static final dE f28515sc = new dE();
    }

    private dE() {
        this.WH = Collections.synchronizedSet(new HashSet());
        this.Ql = new WH();
        this.SR = new com.bytedance.sdk.openadsdk.core.settings.sc();
        this.BT = new Ql(new BT.sc() { // from class: com.bytedance.sdk.openadsdk.core.settings.dE.6
            @Override // com.bytedance.sdk.openadsdk.core.settings.BT.sc
            public void pFF() {
                if (dE.uEA == null || dE.uEA.isEmpty()) {
                    return;
                }
                Iterator it = dE.uEA.iterator();
                while (it.hasNext()) {
                    ((BT.sc) it.next()).pFF();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.settings.BT.sc
            public void sc() {
                BT.sc[] scVarArr;
                boolean unused = dE.Tf = true;
                if (dE.uEA == null || dE.uEA.size() == 0 || (scVarArr = (BT.sc[]) dE.uEA.toArray()) == null) {
                    return;
                }
                for (BT.sc scVar : scVarArr) {
                    scVar.sc();
                }
            }
        });
        this.dE = new AtomicBoolean(false);
        this.Xc = false;
        this.wjp = false;
        this.Sfl = 5000;
        this.YIK = 10;
        AnonymousClass11 anonymousClass11 = new AnonymousClass11();
        this.WP = anonymousClass11;
        this.cvk = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.settings.dE.12
            @Override // java.lang.Runnable
            public void run() {
                dE.this.We(2);
                dE.this.vl();
            }
        };
        this.f28499qr = new ExN.pFF<ConcurrentHashMap<String, Integer>>() { // from class: com.bytedance.sdk.openadsdk.core.settings.dE.13
            @Override // com.bytedance.sdk.openadsdk.core.settings.ExN.pFF
            /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
            public ConcurrentHashMap<String, Integer> pFF(String str) {
                if (TextUtils.isEmpty(str)) {
                    return dE.TRI;
                }
                ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        int iOptInt = jSONObject.optInt(next, 100);
                        if (!TextUtils.isEmpty(next) && iOptInt >= 0 && iOptInt <= 100) {
                            concurrentHashMap.put(next, Integer.valueOf(iOptInt));
                        }
                    }
                } catch (JSONException e11) {
                    e11.getMessage();
                }
                return concurrentHashMap;
            }
        };
        this.II = new ExN.pFF<Map<String, Integer>>() { // from class: com.bytedance.sdk.openadsdk.core.settings.dE.2
            @Override // com.bytedance.sdk.openadsdk.core.settings.ExN.pFF
            /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
            public Map<String, Integer> pFF(String str) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    HashMap map = new HashMap(jSONObject.length());
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        if (!TextUtils.isEmpty(next)) {
                            int iOptInt = jSONObject.optInt(next, 100);
                            if (iOptInt < 0 || iOptInt > 100) {
                                map.put(next, 100);
                            } else {
                                map.put(next, Integer.valueOf(iOptInt));
                            }
                        }
                    }
                    return map;
                } catch (Exception e11) {
                    com.bytedance.sdk.component.utils.Tf.pFF("get applog rate from sp failed:" + e11.getMessage());
                    return null;
                }
            }
        };
        this.McK = new HashSet();
        this.HJN = new ExN.pFF<Set<String>>() { // from class: com.bytedance.sdk.openadsdk.core.settings.dE.3
            @Override // com.bytedance.sdk.openadsdk.core.settings.ExN.pFF
            /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
            public Set<String> pFF(String str) {
                HashSet hashSet = new HashSet();
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        int iOptInt = jSONObject.optInt("applog_count");
                        if (iOptInt >= 2 && iOptInt <= 100) {
                            dE.this.YIK = iOptInt;
                        }
                        int iOptInt2 = jSONObject.optInt("applog_interval");
                        if (iOptInt2 >= 100 && iOptInt2 <= 30000) {
                            dE.this.Sfl = iOptInt2;
                        }
                        JSONArray jSONArray = jSONObject.getJSONArray("core_label_arr");
                        if (jSONArray != null) {
                            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                                String string = jSONArray.getString(i11);
                                if (!TextUtils.isEmpty(string)) {
                                    hashSet.add(string);
                                }
                            }
                        }
                    } catch (JSONException e11) {
                        e11.getMessage();
                    }
                }
                return hashSet.size() == 0 ? new HashSet(Arrays.asList("click", PushConstants.PUSH_SERVICE_TYPE_SHOW, "insight_log", "mrc_show")) : hashSet;
            }
        };
        this.Gb = new ExN.pFF<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.settings.dE.4
            @Override // com.bytedance.sdk.openadsdk.core.settings.ExN.pFF
            /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
            public JSONObject pFF(String str) {
                JSONObject jSONObject;
                try {
                    jSONObject = new JSONObject(str);
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.Tf.sc("TTAD.SdkSettings", th2.getMessage());
                    jSONObject = null;
                }
                return jSONObject == null ? new JSONObject() : jSONObject;
            }
        };
        this.Qj = new ExN.pFF<com.bytedance.sdk.openadsdk.We.sc.SR>() { // from class: com.bytedance.sdk.openadsdk.core.settings.dE.5
            private com.bytedance.sdk.openadsdk.We.sc.SR.sc sc(JSONObject jSONObject) {
                if (jSONObject != null) {
                    return new com.bytedance.sdk.openadsdk.We.sc.SR.sc(jSONObject.optInt("retry_times", -1), jSONObject.optInt("time_interval", -1));
                }
                return null;
            }

            @Override // com.bytedance.sdk.openadsdk.core.settings.ExN.pFF
            /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
            public com.bytedance.sdk.openadsdk.We.sc.SR pFF(String str) {
                com.bytedance.sdk.openadsdk.We.sc.SR sr2 = new com.bytedance.sdk.openadsdk.We.sc.SR();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    sr2.sc(jSONObject.optInt("enable_strategy", 0) == 1);
                    sr2.sc(sc(jSONObject.optJSONObject(TmcEngineFactory.ENGINE_TYPE_DEFAULT)));
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("adid_configs");
                    if (jSONObjectOptJSONObject != null) {
                        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            sr2.sc(next, sc(jSONObjectOptJSONObject.getJSONObject(next)));
                        }
                    }
                } catch (Exception unused) {
                }
                return sr2;
            }
        };
        try {
            Context contextSc = Xc.sc();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("_dataChanged");
            if (Build.VERSION.SDK_INT >= 33) {
                contextSc.registerReceiver(anonymousClass11, intentFilter, 4);
            } else {
                contextSc.registerReceiver(anonymousClass11, intentFilter);
            }
        } catch (Exception e11) {
            com.bytedance.sdk.component.utils.Tf.sc("TTAD.SdkSettings", "", e11);
        }
    }

    public static void VZ() {
        Context contextSc;
        if (com.bytedance.sdk.openadsdk.multipro.pFF.zY() && (contextSc = Xc.sc()) != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(contextSc.getPackageName());
                intent.setAction("_dataChanged");
                contextSc.sendBroadcast(intent);
            } catch (Throwable th2) {
                com.bytedance.sdk.component.utils.Tf.sc("TTAD.SdkSettings", "", th2);
            }
        }
    }

    @Nullable
    private static SharedPreferences We(Context context) {
        try {
            return PreferenceManager.getDefaultSharedPreferences(context);
        } catch (Exception unused) {
            return null;
        }
    }

    private String WgX() {
        return this.BT.sc("force_language", "");
    }

    public static boolean ag() {
        return Tf;
    }

    private Set<String> bZj() {
        return (Set) this.BT.sc("perf_con_applog_send", this.McK, this.HJN);
    }

    public static TRI ef() {
        if (Xc.sc() != null) {
            return sc.f28515sc;
        }
        IllegalStateException illegalStateException = new IllegalStateException("context is null");
        Log.e("Pangle", "context is null", illegalStateException);
        ApmHelper.reportCustomError("context is null", "context is null", illegalStateException);
        return FI;
    }

    public static int pFF(Context context) {
        SharedPreferences sharedPreferencesWe;
        if (context == null || (sharedPreferencesWe = We(context)) == null) {
            return -2;
        }
        int i11 = sharedPreferencesWe.getInt("IABTCF_CmpSdkID", Integer.MIN_VALUE);
        int i12 = sharedPreferencesWe.getInt("IABTCF_CmpSdkVersion", Integer.MIN_VALUE);
        if (i11 == Integer.MIN_VALUE && i12 == Integer.MIN_VALUE) {
            return -2;
        }
        return sharedPreferencesWe.getInt("IABTCF_gdprApplies", -1);
    }

    private static void pFF(int i11, boolean z11) {
        Context contextSc = Xc.sc();
        if (contextSc != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(contextSc.getPackageName());
                intent.setAction("_tryFetRemoDat");
                intent.putExtra("_force", z11);
                intent.putExtra("_source", i11);
                contextSc.sendBroadcast(intent);
            } catch (Throwable unused) {
            }
        }
    }

    private long qOv() {
        return this.BT.sc("last_req_time", 0L);
    }

    private int ra() {
        return this.BT.sc("coppa", -99);
    }

    public static void sc(BT.sc scVar) {
        ConcurrentLinkedQueue<BT.sc> concurrentLinkedQueue = uEA;
        if (concurrentLinkedQueue.contains(scVar)) {
            return;
        }
        concurrentLinkedQueue.add(scVar);
    }

    private long ypJ() {
        long jSc = this.BT.sc("req_inter_min", TTAdConstant.AD_MAX_EVENT_TIME);
        return (jSc < 0 || jSc > ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED) ? TTAdConstant.AD_MAX_EVENT_TIME : jSc;
    }

    private static int zY(boolean z11) {
        return z11 ? 20 : 5;
    }

    public static String zY(Context context) {
        SharedPreferences sharedPreferencesWe;
        return (context == null || (sharedPreferencesWe = We(context)) == null) ? "" : sharedPreferencesWe.getString(ExN, "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int AZJ() {
        return this.BT.sc("perf_con_drawable_code", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public String BR() {
        return this.BT.sc("dyn_draw_engine_url", Ol);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int BT() {
        bZj();
        return this.Sfl;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int BT(String str) {
        return II(str).WH;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public void Bs() {
        this.wjp = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int CYO() {
        return this.BT.sc("isGdprUser", -1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public String Cb() {
        return this.BT.sc("app_log_url", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean DNB() {
        return this.BT.sc("bus_con_adshow_check_enable", true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int Dl(String str) {
        return II(str).cvk;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    @NonNull
    public Ol Dl() {
        Ol ol2 = this.JPJ;
        if (ol2 != null) {
            return ol2;
        }
        Ol ol3 = (Ol) this.Ql.sc("mediation_init_conf", Ol.f28485sc, new ExN.pFF<Ol>() { // from class: com.bytedance.sdk.openadsdk.core.settings.dE.9
            @Override // com.bytedance.sdk.openadsdk.core.settings.ExN.pFF
            /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
            public Ol pFF(String str) {
                return new Ol(str);
            }
        });
        this.JPJ = ol3;
        return ol3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    @Nullable
    public JSONObject ExN() {
        return (JSONObject) this.BT.sc("digest", null, ExN.f28484sc);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean ExN(String str) {
        int i11 = II(str).ExN;
        if (i11 != 1) {
            return i11 == 2 && com.bytedance.sdk.component.utils.BT.zY(Xc.sc()) != 0;
        }
        return com.bytedance.sdk.component.utils.BT.We(Xc.sc());
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int FI() {
        return this.BT.sc(AppLovinMediationProvider.MAX, 50);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean FI(String str) {
        return II(str).cD;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int GI() {
        int iSc = this.BT.sc("privacy_personalized_ad", Api.BaseClientBuilder.API_PRIORITY_OTHER);
        if (iSc != Integer.MAX_VALUE) {
            return iSc;
        }
        int iDE = cJ.dE();
        if (iDE == 1 || iDE == 2) {
            return 2;
        }
        return iDE != 3 ? 0 : 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public Set<String> GOt() {
        return (Set) this.BT.sc("perf_con_drop2rt_skip_label_list", Collections.emptySet(), ExN.pFF);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean Gb() {
        return this.BT.pFF();
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean HC() {
        return this.BT.sc("perf_con_is_new_net_thread", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int HJN(String str) {
        Integer num;
        Map map = (Map) this.BT.sc("perf_con_applog_rate", null, this.II);
        if (map == null || (num = (Integer) map.get(str)) == null || num.intValue() < 0 || num.intValue() > 100) {
            return 100;
        }
        return num.intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public void HJN() {
        String strWgX = WgX();
        if (TextUtils.isEmpty(strWgX)) {
            return;
        }
        if (strWgX.equals("zh-Hant")) {
            com.bytedance.sdk.component.utils.Ol.sc(Xc.sc(), "zh", "tw");
        } else {
            com.bytedance.sdk.component.utils.Ol.sc(Xc.sc(), strWgX, null);
        }
        try {
            TTAdDislikeToast.onResourceUpdated();
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("TTAD.SdkSettings", th2.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int IEI() {
        int iSc = this.BT.sc("bus_con_token_thread_count", 4);
        if (iSc <= 0 || iSc > 30) {
            return 4;
        }
        return iSc;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int II() {
        int iSc = this.BT.sc("fetch_tpl_timeout_ctrl", AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
        return iSc <= 0 ? AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS : iSc;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    @NonNull
    public pFF II(String str) {
        return zY.sc(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int JP() {
        return this.BT.sc(pFF, 10000);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int JPJ(String str) {
        return II(str).McK;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public long JPJ() {
        return this.BT.sc("duration", 10000L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public String JoC() {
        return this.BT.sc("dc", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int McK() {
        int iSc = this.BT.sc("fetch_tpl_second", 0);
        if (iSc <= 0) {
            return 0;
        }
        return iSc;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean McK(@NonNull String str) {
        Set set = (Set) this.BT.sc("privacy_fields_allowed", Collections.emptySet(), ExN.pFF);
        if (!set.isEmpty()) {
            return set.contains(str);
        }
        int iDE = cJ.dE();
        if (iDE != 1) {
            if (iDE != 2 && iDE != 3) {
                return false;
            }
            if (!"mcc".equals(str) && !"mnc".equals(str)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int Mrq() {
        int iSc = this.BT.sc("bus_con_auto_click_delay", AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
        return iSc <= 0 ? AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS : iSc;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean MxZ() {
        int iSc = this.SR.sc("perf_con_apm", 100);
        if (iSc == 0) {
            return false;
        }
        return iSc < 0 || iSc >= 100 || iSc > ((int) (Math.random() * 100.0d));
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public long NP() {
        return this.BT.sc("perf_con_adlog_expire_time", 0L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean NQ() {
        return this.BT.sc("perf_con_apm_native", Api.BaseClientBuilder.API_PRIORITY_OTHER) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean OKY() {
        return this.BT.sc("read_video_from_cache", 1) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public String OXF() {
        return this.SR.sc("apm_url", "pangolin16.sgsnssdk.com");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int Ol(String str) {
        if (str == null) {
            return 1500;
        }
        return II(str).dE;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean Ol() {
        return this.BT.sc("support_tnc", 1) != 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public String PPh() {
        return this.BT.sc("bus_con_express_host", "https://sf16-static.i18n-pglstatp.com/obj/ad-pattern-sg/");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean Pu() {
        return this.BT.sc("privacy_app_reg", true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean QLv() {
        return this.BT.sc("bus_con_sec_type", Api.BaseClientBuilder.API_PRIORITY_OTHER) != 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean QST() {
        return this.BT.sc("perf_con_use_new_thread_pool", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean Qj() {
        return this.BT.sc("if_both_open", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean Qj(String str) {
        return str == null || II(str).SR == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int Ql(String str) {
        return II(String.valueOf(str)).Qj;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public Set<String> Ql() {
        return bZj();
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int SR() {
        bZj();
        return this.YIK;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean SR(String str) {
        return Ql(str) != 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int Sfl() {
        return this.BT.sc("loadedCallbackOpportunity", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int Sfl(String str) {
        return II(str).YIK;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public long TRI() {
        return this.BT.sc("data_time", 0L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean TRI(String str) {
        return II(str).f28518qr == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int Tf() {
        return this.BT.sc("splash_video_load_strategy", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean Tf(String str) {
        try {
            return II(str).JPJ != null;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public String TpG() {
        return this.BT.sc("bus_con_check_clz", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int UFX() {
        return this.BT.sc("load_callback_strategy", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int UFX(String str) {
        return II(str).Tf;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int WH(String str) {
        return II(str).UFX;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public String WH() {
        return this.BT.sc("ab_test_version", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public float WMT() {
        return this.BT.sc(zY, 1.0f);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int WP(String str) {
        return II(str).Cb;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public qr WP() {
        return (qr) this.BT.sc("insert_js_config", qr.f28520sc, new ExN.pFF<qr>() { // from class: com.bytedance.sdk.openadsdk.core.settings.dE.10
            @Override // com.bytedance.sdk.openadsdk.core.settings.ExN.pFF
            /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
            public qr pFF(String str) {
                return new qr(str);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int We() {
        return this.BT.sc("max_tpl_cnts", 100);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public void We(@TTSdkSettings.FETCH_REQUEST_SOURCE int i11) {
        sc(i11, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean We(String str) {
        return II(str).HJN;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean Xc() {
        return this.BT.sc("support_gzip", false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean Xc(String str) {
        return str == null || DeviceUtils.Qj(Xc.sc()) == 0 || II(str).Ql == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public String YIK() {
        return this.BT.sc("ab_test_param", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean YIK(String str) {
        return II(str).Dl;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean YdT() {
        if (com.bytedance.sdk.component.adexpress.We.pFF.sc(Xc.sc())) {
            return this.BT.sc("support_rtl", false);
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean Yhz() {
        return this.Xc;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public String[] ZM() {
        try {
            Set<String> set = this.WH;
            if (set == null || set.size() == 0) {
                JSONArray jSONArray = new JSONArray(this.BT.sc("gecko_hosts", (String) null));
                if (jSONArray.length() != 0) {
                    for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                        this.WH.add(jSONArray.getString(i11));
                    }
                }
                Set<String> setSc = Ql.sc(this.WH);
                this.WH = setSc;
                if (setSc != null) {
                    if (setSc.size() == 0) {
                    }
                }
                return null;
            }
            return (String[]) this.WH.toArray(new String[0]);
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int bSP() {
        return this.BT.sc("bus_con_send_log_type", 1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public String cD() {
        return this.BT.sc("ads_url", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public String cJ() {
        return this.BT.sc("policy_url", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public String cvk() {
        return this.BT.sc("playableLoadH5Url", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean cvk(String str) {
        return Xc.We().II(str).BT == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean dE() {
        return this.BT.sc("allow_blind_mode_request_ad", false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean dE(String str) {
        return II(str).uEA == 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public long dix() {
        long jSc = this.BT.sc("bus_con_tnc_interval", TTAdConstant.AD_MAX_EVENT_TIME);
        if (jSc < 10000) {
            return 10000L;
        }
        return jSc;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean ds() {
        return this.BT.sc("bus_con_url_check", 1) != 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean eo() {
        return this.BT.sc("bus_con_dislike_report_raw", false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public String eoh() {
        return this.BT.sc("dual_event_url", (String) null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public JSONObject fT() {
        return (JSONObject) this.BT.sc("video_cache_config", null, ExN.f28484sc);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int gsl() {
        return this.BT.sc("bus_con_behavior_count", LogSeverity.NOTICE_VALUE);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public com.bytedance.sdk.openadsdk.We.sc.SR gx() {
        return (com.bytedance.sdk.openadsdk.We.sc.SR) this.BT.sc("perf_con_track_url_strategy", com.bytedance.sdk.openadsdk.We.sc.SR.f27386sc, this.Qj);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean hE() {
        return this.BT.sc("bus_con_rewardedfull_link", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int ht() {
        int iSc = this.BT.sc("perf_con_webview_cache_count_v3", 0);
        if (iSc < 0) {
            return 0;
        }
        return iSc;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int idT() {
        return this.BT.sc("blank_detect_rate", 30);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int jcs() {
        return this.BT.sc("perf_con_close_button_delay_check_time", -1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int kDg() {
        return this.BT.sc("perf_con_thread_stack_size", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int kX() {
        return this.BT.sc("ivrv_downward", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int ko() {
        int iSc = this.BT.sc("perf_con_webview_cache_count", 0);
        if (iSc < 0) {
            return 0;
        }
        return iSc;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean mD() {
        return this.BT.sc("perf_con_adlog_turn_off_retry_stats", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public JSONObject mbO() {
        return (JSONObject) this.BT.sc("perf_con_thread_pool_config", new JSONObject(), this.Gb);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean otH() {
        return this.BT.sc("perf_con_adlog_turn_off_retry_ad", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int pFF(int i11) {
        return II(String.valueOf(i11)).pFF;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int pFF(String str) {
        Integer num;
        Map map = (Map) this.BT.sc("perf_con_stats_rate", TRI, this.f28499qr);
        if (map == null || (num = (Integer) map.get(str)) == null || num.intValue() < 0 || num.intValue() > 100) {
            return 100;
        }
        return num.intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public synchronized void pFF() {
        SystemClock.elapsedRealtime();
        boolean z11 = !this.Xc;
        this.Ql.sc(this.Xc);
        this.SR.sc(this.Xc);
        this.BT.sc(this.Xc);
        zY.sc(z11);
        com.bytedance.sdk.openadsdk.core.Ol.pFF().We(ra());
        this.Xc = true;
        SystemClock.elapsedRealtime();
        if (z11) {
            com.bytedance.sdk.openadsdk.core.SR.pFF().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.settings.dE.7
                @Override // java.lang.Runnable
                public void run() {
                    if (!SR.sc()) {
                        com.bytedance.sdk.openadsdk.multipro.aidl.sc.sc().pFF();
                    } else {
                        dE.this.We(1);
                        dE.this.vl();
                    }
                }
            }, 1000L);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public void pFF(JSONObject jSONObject, ExN.sc scVar) {
        if (jSONObject.has("is_gdpr_user")) {
            int iOptInt = jSONObject.optInt("is_gdpr_user", -1);
            scVar.sc("isGdprUser", (iOptInt == -1 || iOptInt == 1 || iOptInt == 0) ? iOptInt : -1);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean pc() {
        int iSc = this.BT.sc("privacy_ad_enable", Api.BaseClientBuilder.API_PRIORITY_OTHER);
        if (iSc == 1) {
            return true;
        }
        if (iSc == 0) {
            return false;
        }
        int iDE = cJ.dE();
        return iDE == 1 || iDE == 2 || iDE == 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int qKn() {
        return this.BT.sc("vbtt", 5);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean qfG() {
        return this.BT.sc("global_rate", 1.0f) == 1.0f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int qr(String str) {
        return II(str).wjp;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public void qr() {
        this.BT.sc().sc("tt_sdk_settings").sc("ab_test_param").sc();
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int sc(int i11) {
        return II(String.valueOf(i11)).OXF;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int sc(String str) {
        if (str == null) {
            return 0;
        }
        return Xc.We().II(str).Sfl;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int sc(String str, boolean z11) {
        int i11;
        return (str == null || (i11 = II(str).WP) == -1) ? zY(z11) : i11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public void sc() {
        try {
            zY.sc();
            this.BT.zY();
            this.Ql.zY();
            this.SR.zY();
            Context contextSc = Xc.sc();
            int i11 = Build.VERSION.SDK_INT;
            File file = new File(i11 >= 24 ? new File(contextSc.getDataDir(), "shared_prefs") : new File(contextSc.getDatabasePath("1").getParentFile().getParentFile(), "shared_prefs"), "tt_sdk_settings.xml");
            if (file.exists() && file.isFile()) {
                String strReplace = file.getName().replace(".xml", "");
                if (i11 >= 24) {
                    contextSc.deleteSharedPreferences(strReplace);
                } else {
                    contextSc.getSharedPreferences(strReplace, 0).edit().clear().apply();
                    com.bytedance.sdk.component.utils.TRI.zY(file);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public void sc(@TTSdkSettings.FETCH_REQUEST_SOURCE int i11, boolean z11) {
        if (!com.bytedance.sdk.openadsdk.core.SR.ExN() && i11 != 1 && i11 != 2) {
            if (z11) {
                this.Dl = true;
                return;
            }
            return;
        }
        try {
            if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.Ol.pFF().We())) {
                return;
            }
            if (this.Dl) {
                this.Dl = false;
                if (!z11) {
                    z11 = true;
                }
            }
            long jQOv = qOv();
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jYpJ = ypJ();
            long j11 = jCurrentTimeMillis - jQOv;
            if (!z11 && j11 < jYpJ) {
                com.bytedance.sdk.openadsdk.core.WH.sc.sc();
                return;
            }
            if (!SR.sc()) {
                pFF(i11, z11);
            } else if (this.dE.compareAndSet(false, true)) {
                Cb.pFF((com.bytedance.sdk.component.Qj.Qj) new SR(this, this.BT, this.Ql, this.SR));
                com.bytedance.sdk.openadsdk.core.SR.pFF().removeCallbacks(this.cvk);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public void sc(long j11) {
        this.BT.sc().sc("last_req_time", j11).sc();
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public void sc(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("_tryFetRemoDat");
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                context.registerReceiver(this.WP, intentFilter, 4);
            } else {
                context.registerReceiver(this.WP, intentFilter);
            }
        } catch (Exception e11) {
            com.bytedance.sdk.component.utils.Tf.sc("TTAD.SdkSettings", "", e11);
        }
        if (Yhz()) {
            We(1);
            vl();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public void sc(JSONObject jSONObject, ExN.sc scVar) {
        if (jSONObject == null || !jSONObject.has("dyn_draw_engine_url")) {
            return;
        }
        Ql ql2 = this.BT;
        String str = Ol;
        String strSc = ql2.sc("dyn_draw_engine_url", str);
        final String strOptString = jSONObject.optString("dyn_draw_engine_url", str);
        if (!TextUtils.isEmpty(strSc) && !TextUtils.isEmpty(strOptString) && !strOptString.equals(strSc)) {
            com.bytedance.sdk.openadsdk.core.SR.pFF().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.settings.dE.8
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.equals(dE.this.BT.sc("dyn_draw_engine_url", dE.Ol), strOptString)) {
                        com.bytedance.sdk.component.adexpress.sc.pFF.ExN.pFF().zY();
                    }
                }
            }, 5000L);
        }
        scVar.sc("dyn_draw_engine_url", strOptString);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.SR.sc
    public void sc(boolean z11) {
        this.dE.set(false);
        vl();
        if (z11) {
            VZ();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean sc(PangleEncryptConstant.CryptDataScene cryptDataScene) {
        if (cryptDataScene == PangleEncryptConstant.CryptDataScene.GET_ADS || cryptDataScene == PangleEncryptConstant.CryptDataScene.BIDDING_TOKEN) {
            return this.BT.sc("perf_con_crypt_V4_get_ad", false);
        }
        return cryptDataScene == PangleEncryptConstant.CryptDataScene.APP_LOG ? this.BT.sc("perf_con_crypt_V4_applog", false) : this.BT.sc("perf_con_crypt_V4", false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int uEA(String str) {
        return II(str).II;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean uEA() {
        return this.BT.sc("landingpage_new_style", -1) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean vYl() {
        return this.BT.sc(f28498sc, false);
    }

    public void vl() {
        if (SR.sc()) {
            com.bytedance.sdk.openadsdk.core.SR.pFF().removeCallbacks(this.cvk);
            com.bytedance.sdk.openadsdk.core.SR.pFF().postDelayed(this.cvk, ypJ());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public JSONObject wjp(String str) {
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject(this.BT.sc("core_settings", ""));
            try {
                jSONObject2.put("ad_slot_setting", II(str).f28516eo);
                return jSONObject2;
            } catch (JSONException e11) {
                e = e11;
                jSONObject = jSONObject2;
                com.bytedance.sdk.component.utils.Tf.sc("TTAD.SdkSettings", "getCoreSettingJsonObj", e.getMessage());
                return jSONObject;
            }
        } catch (JSONException e12) {
            e = e12;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean wjp() {
        return this.BT.sc("ad_revenue_enable", false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean yL() {
        return this.BT.sc("privacy_debug_unlock", 1) != 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean ymG() {
        return this.BT.sc("bus_con_video_keep_screen_on", 1) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public int zY(int i11) {
        return II(String.valueOf(i11)).Ol;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public String zY() {
        return this.BT.sc("aes_key", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.TRI
    public boolean zY(String str) {
        return II(str).zY == 1;
    }
}
