package com.bytedance.sdk.openadsdk.Sfl;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.google.logging.type.LogSeverity;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Qj {
    private String AZJ;
    private long BR;
    private pFF BT;
    private int Bs;
    private String CYO;
    private long Cb;
    private int DNB;
    private String Dl;
    private boolean EOI;
    private boolean EZl;
    public final String ExN;
    private volatile boolean Eyy;
    private boolean FI;
    private boolean Flm;
    private String GI;
    private float GOt;
    private long Gb;
    private boolean HBq;
    private JSONObject HC;
    private long HJN;
    private ViewTreeObserver.OnGlobalLayoutListener HL;
    private WeakReference<View> IEI;
    private long II;
    private Map<String, String> JP;
    private boolean JPJ;
    private long JoC;
    private int McK;
    private int Mrq;
    private int MxZ;
    private int NP;
    private long NQ;
    private int OKY;
    private long OXF;
    private Runnable Ol;
    private TRI PPh;
    private float Pu;
    private int QLv;
    private zY QST;
    private int QT;
    private final Handler Qj;
    private Runnable Ql;
    private Runnable SR;
    private Set<String> Sfl;
    private String TEo;
    private boolean TI;
    private final String TRI;
    private final Handler Tf;
    private String TpG;
    private Runnable UFX;
    private volatile boolean VU;
    private int VZ;
    private Runnable WH;
    private JSONObject WMT;
    private String WP;
    public final String We;
    private int WgX;
    private boolean Xc;
    private String YIK;
    private int YdT;
    private int Yhz;
    private boolean ZM;
    private String Zn;

    /* JADX INFO: renamed from: ag, reason: collision with root package name */
    private int f27148ag;
    private boolean auq;
    private long bSP;
    private String bZj;

    /* JADX INFO: renamed from: bp, reason: collision with root package name */
    private int f27149bp;
    private long cD;
    private long cJ;
    private long cvk;
    private boolean dE;

    @Nullable
    private WebView dix;

    /* JADX INFO: renamed from: ds, reason: collision with root package name */
    private String f27150ds;

    /* JADX INFO: renamed from: ef, reason: collision with root package name */
    private int f27151ef;

    /* JADX INFO: renamed from: eo, reason: collision with root package name */
    private boolean f27152eo;
    private int eoh;
    private int fT;

    /* JADX INFO: renamed from: fb, reason: collision with root package name */
    private List<JSONObject> f27153fb;
    private com.bytedance.sdk.openadsdk.Sfl.sc gsl;

    /* JADX INFO: renamed from: gx, reason: collision with root package name */
    private JSONObject f27154gx;
    private String hE;

    /* JADX INFO: renamed from: ht, reason: collision with root package name */
    private String f27155ht;
    private int idT;
    private String jcs;
    private String jxU;
    private JSONObject kDg;
    private long kX;

    /* JADX INFO: renamed from: ko, reason: collision with root package name */
    private int f27156ko;
    private boolean lD;
    private Context mD;
    private String mbO;
    private sc otH;
    private int pCa;
    public final String pFF;

    /* JADX INFO: renamed from: pc, reason: collision with root package name */
    private String f27157pc;
    private String qKn;
    private int qOv;
    private String qY;
    private int qfG;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final String f27158qr;

    /* JADX INFO: renamed from: ra, reason: collision with root package name */
    private int f27159ra;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public final String f27160sc;
    private boolean uEA;
    private String vYl;

    /* JADX INFO: renamed from: vl, reason: collision with root package name */
    private int f27161vl;
    private boolean wjp;
    private boolean xP;
    private int yL;
    private float ymG;
    private int ypJ;
    private boolean zGQ;
    public final String zY;

    /* JADX INFO: compiled from: source.java */
    public enum sc {
        LAND_PAGE,
        FEED,
        OTHER,
        FEED_AWEME
    }

    private Qj(Context context, int i11, zY zYVar, com.bytedance.sdk.openadsdk.Sfl.sc scVar) {
        this.TRI = "playable_stuck_check_ping";
        this.f27158qr = "playable_apply_media_permission_callback";
        this.Qj = new Handler(Looper.getMainLooper());
        this.Tf = new Handler(Looper.getMainLooper());
        this.dE = true;
        this.Xc = true;
        this.wjp = true;
        this.f27160sc = "PL_sdk_playable_global_viewable";
        this.pFF = "PL_sdk_page_screen_blank";
        this.zY = "PL_sdk_playable_destroy_analyze_summary";
        this.We = "PL_sdk_playable_hardware_dialog_cancel";
        this.ExN = "PL_sdk_playable_hardware_dialog_setting";
        this.Sfl = new HashSet(Arrays.asList("adInfo", "appInfo", "subscribe_app_ad", "download_app_ad"));
        this.YIK = null;
        this.Dl = "embeded_ad";
        this.uEA = true;
        this.JPJ = true;
        this.FI = false;
        this.WP = "";
        this.cvk = 10L;
        this.II = 10L;
        this.McK = LogSeverity.ALERT_VALUE;
        this.HJN = 0L;
        this.Gb = 0L;
        this.cD = -1L;
        this.Cb = -1L;
        this.OXF = -1L;
        this.cJ = -1L;
        this.kX = -1L;
        this.BR = -1L;
        this.JoC = -1L;
        this.CYO = "";
        this.qKn = "";
        this.f27157pc = "";
        this.GI = "";
        this.MxZ = 0;
        this.QLv = 0;
        this.f27152eo = false;
        this.yL = 0;
        this.Yhz = -1;
        this.qfG = 0;
        this.OKY = 0;
        this.f27156ko = 0;
        this.f27155ht = null;
        this.ZM = false;
        this.idT = 0;
        this.fT = 0;
        this.Bs = 0;
        this.YdT = 0;
        this.bSP = 0L;
        this.NQ = 0L;
        this.DNB = -2;
        this.NP = 0;
        this.eoh = 0;
        this.Mrq = 0;
        this.f27154gx = new JSONObject();
        this.JP = new HashMap();
        this.WMT = new JSONObject();
        this.jcs = "";
        this.ymG = 0.0f;
        this.GOt = 0.0f;
        this.lD = false;
        this.TI = false;
        this.EOI = false;
        this.f27153fb = new ArrayList();
        this.xP = true;
        this.Eyy = true;
        this.VU = true;
        this.HL = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.Sfl.Qj.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    View view = (View) Qj.this.IEI.get();
                    if (view == null) {
                        return;
                    }
                    Qj.this.pFF(view);
                } catch (Throwable th2) {
                    qr.sc("PlayablePlugin", "onSizeChanged error", th2);
                }
            }
        };
        this.QT = -1;
        this.DNB = i11;
        this.otH = sc.LAND_PAGE;
        sc(context, zYVar, scVar);
    }

    private Qj(Context context, WebView webView, zY zYVar, com.bytedance.sdk.openadsdk.Sfl.sc scVar, sc scVar2) {
        this.TRI = "playable_stuck_check_ping";
        this.f27158qr = "playable_apply_media_permission_callback";
        this.Qj = new Handler(Looper.getMainLooper());
        this.Tf = new Handler(Looper.getMainLooper());
        this.dE = true;
        this.Xc = true;
        this.wjp = true;
        this.f27160sc = "PL_sdk_playable_global_viewable";
        this.pFF = "PL_sdk_page_screen_blank";
        this.zY = "PL_sdk_playable_destroy_analyze_summary";
        this.We = "PL_sdk_playable_hardware_dialog_cancel";
        this.ExN = "PL_sdk_playable_hardware_dialog_setting";
        this.Sfl = new HashSet(Arrays.asList("adInfo", "appInfo", "subscribe_app_ad", "download_app_ad"));
        this.YIK = null;
        this.Dl = "embeded_ad";
        this.uEA = true;
        this.JPJ = true;
        this.FI = false;
        this.WP = "";
        this.cvk = 10L;
        this.II = 10L;
        this.McK = LogSeverity.ALERT_VALUE;
        this.HJN = 0L;
        this.Gb = 0L;
        this.cD = -1L;
        this.Cb = -1L;
        this.OXF = -1L;
        this.cJ = -1L;
        this.kX = -1L;
        this.BR = -1L;
        this.JoC = -1L;
        this.CYO = "";
        this.qKn = "";
        this.f27157pc = "";
        this.GI = "";
        this.MxZ = 0;
        this.QLv = 0;
        this.f27152eo = false;
        this.yL = 0;
        this.Yhz = -1;
        this.qfG = 0;
        this.OKY = 0;
        this.f27156ko = 0;
        this.f27155ht = null;
        this.ZM = false;
        this.idT = 0;
        this.fT = 0;
        this.Bs = 0;
        this.YdT = 0;
        this.bSP = 0L;
        this.NQ = 0L;
        this.DNB = -2;
        this.NP = 0;
        this.eoh = 0;
        this.Mrq = 0;
        this.f27154gx = new JSONObject();
        this.JP = new HashMap();
        this.WMT = new JSONObject();
        this.jcs = "";
        this.ymG = 0.0f;
        this.GOt = 0.0f;
        this.lD = false;
        this.TI = false;
        this.EOI = false;
        this.f27153fb = new ArrayList();
        this.xP = true;
        this.Eyy = true;
        this.VU = true;
        this.HL = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.Sfl.Qj.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    View view = (View) Qj.this.IEI.get();
                    if (view == null) {
                        return;
                    }
                    Qj.this.pFF(view);
                } catch (Throwable th2) {
                    qr.sc("PlayablePlugin", "onSizeChanged error", th2);
                }
            }
        };
        this.QT = -1;
        this.DNB = 0;
        this.otH = scVar2;
        this.dix = webView;
        Ol.sc(webView);
        sc(webView);
        sc(context, zYVar, scVar);
    }

    private void CYO() {
        this.BT = new pFF(this, this.McK);
        this.Ol = new Runnable() { // from class: com.bytedance.sdk.openadsdk.Sfl.Qj.5
            @Override // java.lang.Runnable
            public void run() {
                if (Qj.this.uEA) {
                    Qj.this.uEA = false;
                    Qj.this.Qj.removeCallbacks(Qj.this.WH);
                    Qj.this.sc(2, "ContainerLoadTimeOut");
                }
            }
        };
        this.WH = new Runnable() { // from class: com.bytedance.sdk.openadsdk.Sfl.Qj.6
            @Override // java.lang.Runnable
            public void run() {
                if (Qj.this.uEA) {
                    Qj.this.uEA = false;
                    Qj.this.Eyy = false;
                    Qj.this.Qj.removeCallbacks(Qj.this.Ol);
                    Qj.this.sc(3, "JSSDKLoadTimeOut");
                }
            }
        };
        this.Ql = new Runnable() { // from class: com.bytedance.sdk.openadsdk.Sfl.Qj.7
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                if (Qj.this.dix != null) {
                    Qj.this.dix.evaluateJavascript("javascript:typeof playable_callJS === 'function' && playable_callJS()", new ValueCallback<String>() { // from class: com.bytedance.sdk.openadsdk.Sfl.Qj.7.1
                        @Override // android.webkit.ValueCallback
                        /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
                        public void onReceiveValue(String str) {
                            if (Qj.this.BT != null) {
                                Qj.this.BT.sc(System.currentTimeMillis());
                            }
                        }
                    });
                }
                if (Qj.this.Tf != null) {
                    Qj.this.Tf.postDelayed(this, 500L);
                }
            }
        };
        this.SR = new Runnable() { // from class: com.bytedance.sdk.openadsdk.Sfl.Qj.8
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                Qj.this.sc("playable_stuck_check_ping", new JSONObject());
                if (Qj.this.Tf != null) {
                    Qj.this.Tf.postDelayed(this, 500L);
                }
            }
        };
        this.UFX = new Runnable() { // from class: com.bytedance.sdk.openadsdk.Sfl.Qj.9
            @Override // java.lang.Runnable
            public void run() {
                if (Qj.this.NQ <= 0) {
                    Qj.this.pFF(1, "Clicking on the hot zone causes the program to freeze.");
                } else {
                    if (Qj.this.NQ - Qj.this.bSP > Qj.this.McK) {
                        Qj.this.pFF(1, "Clicking on the hot zone causes the program to freeze.");
                        return;
                    }
                    Qj.this.cD();
                    Qj.this.bSP = 0L;
                    Qj.this.NQ = 0L;
                }
            }
        };
    }

    private void ExN(String str, JSONObject jSONObject) {
        try {
            int i11 = this.DNB;
            if (i11 == 0) {
                if (this.otH != sc.LAND_PAGE && !Tf(this.hE)) {
                    qKn();
                }
                jSONObject.put("playable_url", this.hE);
            } else if (i11 == 3 || i11 == 4) {
                jSONObject.put("playable_url", We(this.qY, this.Zn));
            } else if (i11 == 1 || i11 == 2) {
                jSONObject.put("playable_url", zY(this.TEo, this.jxU));
            }
            jSONObject.put("playable_render_type", this.DNB);
            if (this.gsl != null) {
                if (this.DNB == 0 && (this.otH != sc.LAND_PAGE || Tf(this.hE))) {
                    this.gsl.sc(jSONObject);
                } else if (this.DNB != 0) {
                    this.gsl.sc(jSONObject);
                }
            }
        } catch (JSONException unused) {
        }
    }

    public static /* synthetic */ int Ql(Qj qj2) {
        int i11 = qj2.QLv;
        qj2.QLv = i11 + 1;
        return i11;
    }

    public static /* synthetic */ int Tf(Qj qj2) {
        int i11 = qj2.MxZ;
        qj2.MxZ = i11 + 1;
        return i11;
    }

    private boolean Tf(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("/union-fe/playable/") || str.contains("/union-fe-sg/playable/") || str.contains("/union-fe-i18n/playable/");
    }

    private String We(String str, String str2) {
        String str3 = String.format("rubeex://playable-minigamelite?id=%1s&schema=%2s", str, Uri.encode(str2));
        this.hE = str3;
        return str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF(View view) {
        if (view == null) {
            return;
        }
        try {
            if (this.eoh == view.getWidth() && this.Mrq == view.getHeight()) {
                return;
            }
            this.eoh = view.getWidth();
            this.Mrq = view.getHeight();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", this.eoh);
            jSONObject.put("height", this.Mrq);
            sc("resize", jSONObject);
            this.f27154gx = jSONObject;
        } catch (Throwable th2) {
            qr.sc("PlayablePlugin", "resetViewDataJsonByView error", th2);
        }
    }

    private void pc() {
        Runnable runnable;
        Runnable runnable2;
        this.BT.sc(System.currentTimeMillis());
        Handler handler = this.Tf;
        if (handler != null) {
            int i11 = this.DNB;
            if (i11 == 0 && (runnable2 = this.Ql) != null) {
                handler.post(runnable2);
            } else if ((i11 == 1 || i11 == 2) && (runnable = this.SR) != null) {
                handler.post(runnable);
            }
            this.BT.sc(500);
        }
    }

    private void qKn() {
        String str;
        if (this.WMT == null || (str = this.hE) == null || str.contains("/cid_")) {
            return;
        }
        String strOptString = this.WMT.optString(BidResponsedEx.KEY_CID);
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        String host = Uri.parse(this.hE).getHost();
        if (TextUtils.isEmpty(host)) {
            this.hE += "/cid_" + strOptString;
            return;
        }
        this.hE = this.hE.replace(host, host + "/cid_" + strOptString);
    }

    public static Qj sc(Context context, @Nullable WebView webView, zY zYVar, com.bytedance.sdk.openadsdk.Sfl.sc scVar) {
        if (zYVar == null || scVar == null) {
            return null;
        }
        return webView == null ? new Qj(context, 0, zYVar, scVar) : new Qj(context, webView, zYVar, scVar, sc.LAND_PAGE);
    }

    private void sc(Context context, zY zYVar, com.bytedance.sdk.openadsdk.Sfl.sc scVar) {
        this.YIK = UUID.randomUUID().toString();
        this.mD = context;
        this.gsl = scVar;
        this.QST = zYVar;
        WH.sc(scVar);
        this.PPh = new TRI(this);
        CYO();
        if (this.dix == null) {
            this.QT = 4;
            this.Qj.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.Sfl.Qj.4
                @Override // java.lang.Runnable
                public void run() {
                    Qj.this.sc(5, "webview is null");
                }
            });
        }
    }

    private String zY(String str, String str2) {
        String queryParameter;
        String queryParameter2;
        if (TextUtils.isEmpty(this.f27150ds) && !TextUtils.isEmpty(this.jcs)) {
            Uri uri = Uri.parse(this.jcs);
            String host = uri.getHost();
            if ("lynxview".equalsIgnoreCase(host) || (host != null && host.contains("lynxview"))) {
                queryParameter = uri.getQueryParameter("surl");
                queryParameter2 = uri.getQueryParameter("playable_hash");
            } else {
                queryParameter = "";
                queryParameter2 = "";
            }
            Uri.Builder builderAppendQueryParameter = new Uri.Builder().scheme(uri.getScheme()).authority(host).appendQueryParameter("surl", queryParameter);
            if (!TextUtils.isEmpty(queryParameter2)) {
                builderAppendQueryParameter.appendQueryParameter("playable_hash", queryParameter2);
            }
            this.f27150ds = builderAppendQueryParameter.toString();
        }
        return this.f27150ds;
    }

    private void zY(int i11, String str) {
        com.bytedance.sdk.openadsdk.Sfl.sc scVar = this.gsl;
        if (scVar != null) {
            scVar.sc(i11, str);
        }
    }

    public String BR() {
        return "function playable_callJS(){return \"Android call the JS method is callJS\";}";
    }

    public JSONObject BT() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scene_type", this.otH.ordinal());
            jSONObject.put("safe_area_top_height", this.ymG);
            jSONObject.put("safe_area_bottom_height", this.GOt);
            jSONObject.put("playable_enter_from", this.OKY);
            jSONObject.put("playable_retry_count", this.qfG);
            jSONObject.put("playable_card_session", this.CYO);
            jSONObject.put("playable_video_session", this.qKn);
            jSONObject.put("playable_network_type", dE());
            jSONObject.put("aweme_id", this.GI);
            return jSONObject;
        } catch (Throwable th2) {
            qr.sc("PlayablePlugin", "playableInfo error", th2);
            return new JSONObject();
        }
    }

    public void Cb() {
        try {
            pFF pff = this.BT;
            if (pff != null) {
                pff.sc();
            }
            Handler handler = this.Tf;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Throwable th2) {
            th2.toString();
        }
    }

    public void Dl() {
        com.bytedance.sdk.openadsdk.Sfl.sc scVar = this.gsl;
        if (scVar != null) {
            scVar.pFF();
        }
    }

    public Qj ExN(String str) {
        this.bZj = str;
        return this;
    }

    public Qj ExN(boolean z11) {
        this.xP = z11;
        return this;
    }

    public String ExN() {
        return this.AZJ;
    }

    public void ExN(JSONObject jSONObject) {
        this.kDg = jSONObject;
        this.f27156ko++;
        Cb();
        this.Qj.removeCallbacks(this.UFX);
        if (this.JPJ) {
            this.BR = System.currentTimeMillis();
            this.bSP = System.currentTimeMillis();
            this.NQ = 0L;
            int i11 = this.DNB;
            if (i11 == 0) {
                WebView webView = this.dix;
                if (webView != null) {
                    webView.evaluateJavascript("javascript:typeof playable_callJS === 'function' && playable_callJS()", new ValueCallback<String>() { // from class: com.bytedance.sdk.openadsdk.Sfl.Qj.10
                        @Override // android.webkit.ValueCallback
                        /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
                        public void onReceiveValue(String str) {
                            Qj.this.NQ = System.currentTimeMillis();
                        }
                    });
                }
            } else if (i11 == 1 || i11 == 2) {
                sc("playable_stuck_check_ping", new JSONObject());
            }
            this.Qj.postDelayed(this.UFX, this.McK);
        }
    }

    public void FI() {
        this.ZM = true;
    }

    public void Gb() {
        this.VU = false;
        this.Qj.removeCallbacks(this.WH);
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.OXF > 0) {
                jSONObject.put("playable_jssdk_load_success_duration", System.currentTimeMillis() - this.OXF);
            } else {
                jSONObject.put("playable_jssdk_load_success_duration", 0L);
            }
            zY("PL_sdk_jssdk_load_success", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void HJN() {
        int i11;
        int i12 = this.DNB;
        if (i12 == 0 || i12 == 1 || i12 == 2) {
            if (this.Eyy) {
                this.Qj.postDelayed(this.Ol, this.cvk * 1000);
            }
            if ((this.VU && Tf(this.hE)) || (i11 = this.DNB) == 1 || i11 == 2) {
                this.Qj.postDelayed(this.WH, this.II * 1000);
            }
        }
    }

    public void II() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.kX > 0) {
                jSONObject.put("playable_material_first_frame_show_duration", System.currentTimeMillis() - this.kX);
            } else {
                jSONObject.put("playable_material_first_frame_show_duration", 0L);
            }
            if (this.OXF > 0) {
                jSONObject.put("playable_material_first_frame_load_duration", System.currentTimeMillis() - this.OXF);
            } else {
                jSONObject.put("playable_material_first_frame_load_duration", 0L);
            }
            zY("PL_sdk_material_first_frame_show", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void JPJ() {
        this.Yhz = 2;
    }

    public int JoC() {
        return this.QT;
    }

    public void McK() {
        pFF pff;
        this.NQ = System.currentTimeMillis();
        int i11 = this.DNB;
        if ((i11 == 1 || i11 == 2) && (pff = this.BT) != null) {
            pff.sc(System.currentTimeMillis());
        }
    }

    public void OXF() {
        this.eoh = 0;
        this.Mrq = 0;
        this.Pu = 0.0f;
        this.VZ = 0;
        this.f27151ef = 0;
        this.f27161vl = 0;
        this.f27148ag = 0;
        this.pCa = 0;
        this.f27149bp = 0;
        this.WgX = 0;
        this.f27159ra = 0;
        this.ypJ = 0;
        this.qOv = 0;
    }

    public void Ol(String str) {
        WebView webView;
        boolean z11 = this.NP == -1;
        this.NP = 2;
        if (!z11) {
            this.TpG = str;
            JSONObject jSONObject = new JSONObject();
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.cJ = jCurrentTimeMillis;
                long j11 = this.OXF;
                jSONObject.put("playable_html_load_start_duration", j11 != -1 ? jCurrentTimeMillis - j11 : 0L);
                jSONObject.put("playable_has_show", kX());
            } catch (Throwable th2) {
                qr.sc("PlayablePlugin", "reportUrlLoadFinish error", th2);
            }
            zY("PL_sdk_html_load_finish", jSONObject);
        }
        this.Eyy = false;
        this.Qj.removeCallbacks(this.Ol);
        try {
            if (this.DNB == 0) {
                if (this.dE && (webView = this.dix) != null) {
                    this.dE = false;
                    webView.evaluateJavascript(BR(), new ValueCallback<String>() { // from class: com.bytedance.sdk.openadsdk.Sfl.Qj.11
                        @Override // android.webkit.ValueCallback
                        public /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
                        }
                    });
                }
                cD();
            }
        } catch (Throwable th3) {
            qr.sc("PlayablePlugin", "crashMonitor error", th3);
        }
    }

    public void Ol(JSONObject jSONObject) {
        if (jSONObject != null) {
            boolean zOptBoolean = jSONObject.optBoolean("success", true);
            if (zOptBoolean) {
                this.NP = 3;
                cD();
            } else {
                this.NP = -2;
            }
            if (zOptBoolean || !this.uEA) {
                return;
            }
            this.uEA = false;
            this.Eyy = false;
            this.VU = false;
            this.Qj.removeCallbacks(this.Ol);
            this.Qj.removeCallbacks(this.WH);
            sc(4, "CaseRenderFail");
        }
    }

    public boolean Ol() {
        return this.EZl;
    }

    public JSONObject Qj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        int iOptInt = jSONObject.optInt("type", 0);
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (iOptInt != 1) {
                if (iOptInt != 2) {
                    if (iOptInt == 3) {
                        if (Build.VERSION.SDK_INT >= 23) {
                            jSONObject2.put("result", ExN.sc(this.mD));
                        } else {
                            jSONObject2.put("result", false);
                        }
                    }
                    return jSONObject2;
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    jSONObject2.put("result", ExN.pFF(this.mD, "android.permission.CAMERA"));
                } else {
                    jSONObject2.put("result", false);
                }
            } else if (Build.VERSION.SDK_INT >= 23) {
                jSONObject2.put("result", ExN.pFF(this.mD, "android.permission.RECORD_AUDIO"));
            } else {
                jSONObject2.put("result", false);
            }
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    public void Qj(String str) {
        this.NP = 1;
        JSONObject jSONObject = new JSONObject();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.OXF = jCurrentTimeMillis;
            long j11 = this.Cb;
            jSONObject.put("playable_page_show_duration", j11 != -1 ? jCurrentTimeMillis - j11 : 0L);
        } catch (Throwable th2) {
            qr.sc("PlayablePlugin", "reportUrlLoadStart error", th2);
        }
        zY("PL_sdk_html_load_start", jSONObject);
        this.Eyy = true;
        this.VU = true;
        if (this.xP) {
            HJN();
            this.Eyy = false;
            this.VU = false;
        }
        if (this.Xc) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                StringBuffer stringBuffer2 = new StringBuffer();
                StringBuffer stringBuffer3 = new StringBuffer();
                if (ExN.sc(this.mD, ExN.Tf)) {
                    stringBuffer.append("Microphone_");
                    stringBuffer2.append("1");
                    if (ExN.pFF(this.mD, "android.permission.RECORD_AUDIO")) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (ExN.sc(this.mD, ExN.UFX)) {
                    stringBuffer.append("Magetometer_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (ExN.sc(this.mD, ExN.WH)) {
                    stringBuffer.append("Accelerometer_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (ExN.sc(this.mD, ExN.Ol)) {
                    stringBuffer.append("Gyro_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (ExN.sc(this.mD, ExN.Qj)) {
                    stringBuffer.append("Camera_");
                    stringBuffer2.append("1");
                    if (ExN.pFF(this.mD, "android.permission.CAMERA")) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (ExN.sc(this.mD, ExN.f27146qr)) {
                    stringBuffer.append("Photo");
                    stringBuffer2.append("1");
                    if (ExN.sc(this.mD)) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("playable_available_hardware_name", stringBuffer.toString());
                jSONObject2.put("playable_available_hardware_code", stringBuffer2.toString());
                jSONObject2.put("playable_available_hardware_auth_code", stringBuffer3.toString());
                zY("PL_sdk_hardware_detect", jSONObject2);
                this.Xc = false;
            } catch (Throwable th3) {
                qr.sc("PlayablePlugin", "Hardware detect error", th3);
            }
        }
    }

    public boolean Qj() {
        return this.Flm;
    }

    public JSONObject Ql() {
        try {
            boolean zSc = ExN.sc(this.mD, "android.permission.CAMERA");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", zSc);
            return jSONObject;
        } catch (Throwable th2) {
            qr.sc("PlayablePlugin", "getCameraPermission error", th2);
            return new JSONObject();
        }
    }

    public JSONObject SR() {
        boolean zSc;
        boolean zSc2;
        try {
            boolean z11 = true;
            if (Build.VERSION.SDK_INT >= 33) {
                zSc = ExN.sc(this.mD, "android.permission.READ_MEDIA_IMAGES");
                zSc2 = true;
            } else {
                zSc = ExN.sc(this.mD, "android.permission.READ_EXTERNAL_STORAGE");
                zSc2 = ExN.sc(this.mD, "android.permission.WRITE_EXTERNAL_STORAGE");
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isHasRead", zSc);
            jSONObject.put("isHasWrite", zSc2);
            if (!zSc || !zSc2) {
                z11 = false;
            }
            jSONObject.put("result", z11);
            return jSONObject;
        } catch (Throwable th2) {
            qr.sc("PlayablePlugin", "getCameraPermission error", th2);
            return new JSONObject();
        }
    }

    public JSONObject Sfl() {
        return this.WMT;
    }

    public Qj TRI(String str) {
        this.Dl = str;
        return this;
    }

    public String TRI() {
        return this.vYl;
    }

    public void TRI(JSONObject jSONObject) {
        pFF(2, jSONObject != null ? jSONObject.optString("error_msg", "The material directly invokes the exception pocket mask on the client") : "The material directly invokes the exception pocket mask on the client");
    }

    public void TRI(boolean z11) {
        this.zGQ = z11;
    }

    public JSONObject Tf() {
        try {
            boolean zSc = ExN.sc(this.mD, "android.permission.RECORD_AUDIO");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", zSc);
            return jSONObject;
        } catch (Throwable th2) {
            qr.sc("PlayablePlugin", "getCameraPermission error", th2);
            return new JSONObject();
        }
    }

    public Set<String> UFX() {
        return this.PPh.sc();
    }

    public void UFX(String str) {
        this.Qj.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.Sfl.Qj.3
            @Override // java.lang.Runnable
            public void run() {
                Qj.Ql(Qj.this);
            }
        });
    }

    public JSONObject WH() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("send_click", this.auq);
            return jSONObject;
        } catch (Throwable th2) {
            qr.sc("PlayablePlugin", "getPlayableClickStatus error", th2);
            return new JSONObject();
        }
    }

    public void WH(String str) {
        this.Qj.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.Sfl.Qj.2
            @Override // java.lang.Runnable
            public void run() {
                Qj.Tf(Qj.this);
            }
        });
    }

    public void WP() {
        if (this.gsl != null) {
            sc scVar = sc.LAND_PAGE;
        }
    }

    public Qj We(String str) {
        this.vYl = str;
        return this;
    }

    public Qj We(boolean z11) {
        this.auq = z11;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("send_click", this.auq);
            sc("change_playable_click", jSONObject);
        } catch (Throwable th2) {
            qr.sc("PlayablePlugin", "setPlayableClick error", th2);
        }
        return this;
    }

    public String We() {
        return this.mbO;
    }

    public JSONObject We(String str, JSONObject jSONObject) {
        System.currentTimeMillis();
        if (qr.sc() && jSONObject != null) {
            jSONObject.toString();
        }
        JSONObject jSONObjectSc = this.PPh.sc(str, jSONObject);
        if (qr.sc()) {
            System.currentTimeMillis();
            if (jSONObjectSc != null) {
                jSONObjectSc.toString();
            }
        }
        return jSONObjectSc;
    }

    public void We(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f27155ht = jSONObject.optString("section");
        }
    }

    public com.bytedance.sdk.openadsdk.Sfl.sc Xc() {
        return this.gsl;
    }

    public JSONObject YIK() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("devicePixelRatio", this.Pu);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", this.VZ);
            jSONObject2.put("height", this.f27151ef);
            jSONObject.put("screen", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("x", this.f27148ag);
            jSONObject3.put("y", this.f27161vl);
            jSONObject3.put("width", this.pCa);
            jSONObject3.put("height", this.f27149bp);
            jSONObject.put("webview", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("x", this.f27159ra);
            jSONObject4.put("y", this.WgX);
            jSONObject4.put("width", this.ypJ);
            jSONObject4.put("height", this.qOv);
            jSONObject.put("visible", jSONObject4);
        } catch (Throwable th2) {
            qr.sc("PlayablePlugin", "getViewport error", th2);
        }
        return jSONObject;
    }

    public void cD() {
        if (this.JPJ) {
            this.BR = System.currentTimeMillis();
            if (this.otH == sc.FEED_AWEME) {
                if (this.EZl && this.NP == 3) {
                    pFF pff = this.BT;
                    if (pff != null && pff.pFF()) {
                        pc();
                        return;
                    } else {
                        if (this.BT == null) {
                            this.BT = new pFF(this, this.McK);
                            pc();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (this.EZl && this.NP == 2) {
                pFF pff2 = this.BT;
                if (pff2 != null && pff2.pFF()) {
                    pc();
                } else if (this.BT == null) {
                    this.BT = new pFF(this, this.McK);
                    pc();
                }
            }
        }
    }

    public void cJ() {
        if (this.EOI) {
            return;
        }
        this.EOI = true;
        this.Gb = 0L;
        this.Xc = true;
        OXF();
        try {
            View view = this.IEI.get();
            if (view != null) {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this.HL);
            }
        } catch (Throwable unused) {
        }
        try {
            this.PPh.pFF();
        } catch (Throwable unused2) {
        }
        try {
            pFF pff = this.BT;
            if (pff != null) {
                pff.sc();
                this.BT = null;
            }
            Handler handler = this.Tf;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Throwable th2) {
            th2.toString();
        }
        try {
            if (!TextUtils.isEmpty(this.hE)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("playable_all_times", this.MxZ);
                jSONObject.put("playable_hit_times", this.QLv);
                int i11 = this.MxZ;
                if (i11 > 0) {
                    jSONObject.put("playable_hit_ratio", ((double) this.QLv) / (((double) i11) * 1.0d));
                } else {
                    jSONObject.put("playable_hit_ratio", 0);
                }
                zY("PL_sdk_preload_times", jSONObject);
            }
        } catch (Throwable unused3) {
        }
        try {
            if (!TextUtils.isEmpty(this.hE)) {
                if (this.cD != -1) {
                    this.HJN += System.currentTimeMillis() - this.cD;
                    this.cD = -1L;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("playable_user_play_duration", this.HJN);
                zY("PL_sdk_user_play_duration", jSONObject2);
            }
        } catch (Throwable unused4) {
        }
        this.Eyy = false;
        this.VU = false;
        this.Qj.removeCallbacks(this.Ol);
        this.Qj.removeCallbacks(this.WH);
        this.Qj.removeCallbacksAndMessages(null);
    }

    public void cvk() {
        if (this.gsl != null) {
            sc scVar = sc.LAND_PAGE;
        }
    }

    public String dE() {
        com.bytedance.sdk.openadsdk.Sfl.sc scVar;
        if (TextUtils.isEmpty(this.f27157pc) && (scVar = this.gsl) != null) {
            this.f27157pc = scVar.sc().toString();
        }
        return this.f27157pc;
    }

    public int kX() {
        return (this.Cb == -1 || !this.EZl) ? 1 : 2;
    }

    public Qj pFF(int i11) {
        this.DNB = i11;
        return this;
    }

    public Qj pFF(long j11) {
        if (j11 <= 0) {
            this.II = 10L;
        } else {
            this.II = j11;
        }
        return this;
    }

    public Qj pFF(String str) {
        this.mbO = str;
        return this;
    }

    public Qj pFF(boolean z11) {
        this.HBq = z11;
        return this;
    }

    public Map<String, String> pFF() {
        return this.JP;
    }

    public void pFF(int i11, String str) {
        this.Yhz = i11;
        if (this.kDg == null) {
            this.kDg = new JSONObject();
        }
        try {
            this.kDg.put("playable_stuck_type", i11);
            this.kDg.put("playable_stuck_reason", str);
            if (this.BR > 0) {
                this.kDg.put("playable_stuck_duration", System.currentTimeMillis() - this.BR);
            } else {
                this.kDg.put("playable_stuck_duration", 0L);
            }
        } catch (Throwable unused) {
        }
        zY("PL_sdk_page_stuck", this.kDg);
        Cb();
        if (this.gsl == null || i11 != 2) {
            return;
        }
        this.kDg = new JSONObject();
    }

    public void pFF(String str, String str2) {
        Bitmap bitmapSc;
        if (TextUtils.isEmpty(str2) || (bitmapSc = ExN.sc(str2)) == null) {
            return;
        }
        MediaStore.Images.Media.insertImage(this.mD.getContentResolver(), bitmapSc, str, "");
    }

    public void pFF(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ExN(str, jSONObject);
    }

    public void pFF(JSONObject jSONObject) {
        if (this.gsl != null) {
            try {
                jSONObject.optBoolean("isPrevent", false);
            } catch (Exception unused) {
            }
        }
    }

    public Qj qr(String str) {
        int iIndexOf;
        String strDecode;
        this.jcs = str;
        try {
            Uri uri = Uri.parse(str);
            String scheme = uri.getScheme();
            if (HttpHost.DEFAULT_SCHEME_NAME.equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                pFF(0);
                if (str != null && (iIndexOf = str.indexOf("?")) != -1) {
                    str = str.substring(0, iIndexOf);
                }
            } else {
                String host = uri.getHost();
                if ("webview".equalsIgnoreCase(host) || (host != null && host.contains("webview"))) {
                    pFF(0);
                    String queryParameter = uri.getQueryParameter("url");
                    if (!TextUtils.isEmpty(queryParameter) && (strDecode = Uri.decode(queryParameter)) != null) {
                        int iIndexOf2 = strDecode.indexOf("?");
                        str = iIndexOf2 != -1 ? strDecode.substring(0, iIndexOf2) : strDecode;
                    }
                } else if ("lynxview".equalsIgnoreCase(host) || (host != null && host.contains("lynxview"))) {
                    if (this.DNB == -1) {
                        pFF(2);
                    } else {
                        pFF(1);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        this.hE = str;
        return this;
    }

    public String qr() {
        return this.bZj;
    }

    public JSONObject qr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        int iOptInt = jSONObject.optInt("type", 0);
        JSONObject jSONObject2 = new JSONObject();
        if (iOptInt == 1) {
            return Tf();
        }
        if (iOptInt != 2) {
            return iOptInt != 3 ? jSONObject2 : SR();
        }
        return Ql();
    }

    public Context sc() {
        return this.mD;
    }

    public Qj sc(float f11) {
        this.Pu = f11;
        return this;
    }

    public Qj sc(long j11) {
        if (j11 <= 0) {
            this.cvk = 10L;
        } else {
            this.cvk = j11;
        }
        return this;
    }

    public Qj sc(String str) {
        this.AZJ = str;
        return this;
    }

    public Qj sc(String str, String str2) {
        this.JP.put(str, str2);
        return this;
    }

    public Qj sc(boolean z11) {
        this.Flm = z11;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", this.Flm);
            sc("volumeChange", jSONObject);
        } catch (Throwable th2) {
            qr.sc("PlayablePlugin", "setIsMute error", th2);
        }
        return this;
    }

    public void sc(int i11) {
        this.QT = i11;
    }

    public void sc(int i11, String str) {
        Cb();
        zY(i11, str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_code", i11);
            jSONObject.put("playable_msg", str);
        } catch (Throwable th2) {
            qr.sc("PlayablePlugin", "reportRenderFatal error", th2);
        }
        zY("PL_sdk_global_faild", jSONObject);
    }

    public void sc(int i11, String str, String str2) {
        this.NP = -1;
        this.TpG = str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_code", i11);
            jSONObject.put("playable_msg", str);
            jSONObject.put("playable_fail_url", str2);
            jSONObject.put("playable_has_show", kX());
        } catch (Throwable th2) {
            qr.sc("PlayablePlugin", "onWebReceivedError error", th2);
        }
        zY("PL_sdk_html_load_error", jSONObject);
        if (this.uEA) {
            this.uEA = false;
            this.Eyy = false;
            this.VU = false;
            this.Qj.removeCallbacks(this.Ol);
            this.Qj.removeCallbacks(this.WH);
            sc(1, "ContainerLoadFail");
        }
    }

    public void sc(View view) {
        if (view == null) {
            return;
        }
        try {
            this.IEI = new WeakReference<>(view);
            pFF(view);
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.HL);
        } catch (Throwable th2) {
            qr.sc("PlayablePlugin", "setViewForScreenSize error", th2);
        }
    }

    public void sc(String str, JSONObject jSONObject) {
        if (qr.sc() && jSONObject != null) {
            jSONObject.toString();
        }
        zY zYVar = this.QST;
        if (zYVar != null) {
            zYVar.sc(str, jSONObject);
        }
    }

    public void sc(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.Sfl.sc scVar = this.gsl;
        if (scVar == null || scVar.pFF(jSONObject) || jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("resource_base64");
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        int iOptInt = jSONObject.optInt("resource_type", -1);
        String strOptString2 = jSONObject.optString("resource_name", "playable_media");
        if (iOptInt == 1) {
            pFF(strOptString2, strOptString);
        }
    }

    public void sc(boolean z11, String str, int i11) {
        if (z11) {
            this.NP = -1;
            this.TpG = str;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("playable_code", i11);
                jSONObject.put("playable_msg", "url load error");
                jSONObject.put("playable_fail_url", str);
                jSONObject.put("playable_has_show", kX());
            } catch (Throwable th2) {
                qr.sc("PlayablePlugin", "onWebReceivedHttpError error", th2);
            }
            zY("PL_sdk_html_load_error", jSONObject);
            if (this.uEA) {
                this.uEA = false;
                this.Eyy = false;
                this.VU = false;
                this.Qj.removeCallbacks(this.Ol);
                this.Qj.removeCallbacks(this.WH);
                sc(1, "ContainerLoadFail");
            }
        }
    }

    public void uEA() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.kX > 0) {
                jSONObject.put("playable_material_interactable_duration", System.currentTimeMillis() - this.kX);
            } else {
                jSONObject.put("playable_material_interactable_duration", 0L);
            }
            if (this.OXF > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis() - this.OXF;
                this.JoC = jCurrentTimeMillis;
                jSONObject.put("playable_material_interactable_load_duration", jCurrentTimeMillis);
            } else {
                jSONObject.put("playable_material_interactable_load_duration", 0L);
            }
            zY("PL_sdk_material_interactable", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public JSONObject wjp() {
        if (this.f27154gx.isNull("width")) {
            View view = this.IEI.get();
            if (view == null) {
                return this.f27154gx;
            }
            pFF(view);
        }
        return this.f27154gx;
    }

    public Qj zY(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("playable_style", str);
            this.HC = jSONObject;
        } catch (Throwable th2) {
            qr.sc("PlayablePlugin", "setPlayableStyle error", th2);
        }
        return this;
    }

    public Qj zY(JSONObject jSONObject) {
        this.WMT = jSONObject;
        return this;
    }

    public Qj zY(boolean z11) {
        if (this.QT == -1 || this.EZl == z11) {
            return this;
        }
        this.EZl = z11;
        JSONObject jSONObject = new JSONObject();
        try {
            if (!this.EZl) {
                jSONObject.put("playable_background_show_type", this.fT);
            }
        } catch (JSONException unused) {
        }
        zY(this.EZl ? "PL_sdk_viewable_true" : "PL_sdk_viewable_false", jSONObject);
        if (this.Cb == -1 && this.EZl) {
            this.Cb = System.currentTimeMillis();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("render_type", this.QT == 1 ? 1 : 2);
                int i11 = this.QT;
                if (i11 != -1) {
                    jSONObject2.put("webview_state", i11);
                }
            } catch (JSONException unused2) {
            }
            zY("PL_sdk_page_show", jSONObject2);
        }
        if (this.Cb != -1 && !this.EZl && !this.lD) {
            this.lD = true;
        }
        if (this.EZl) {
            this.cD = System.currentTimeMillis();
        } else if (this.cD != -1) {
            this.HJN += System.currentTimeMillis() - this.cD;
            this.cD = -1L;
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("viewStatus", this.EZl);
            sc("viewableChange", jSONObject3);
        } catch (Throwable th2) {
            qr.sc("PlayablePlugin", "setViewable error", th2);
        }
        if (this.EZl) {
            cD();
        } else {
            Cb();
        }
        return this;
    }

    public JSONObject zY() {
        return this.HC;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void zY(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            if (!this.f27152eo && this.QLv > 0) {
                this.f27152eo = true;
            }
            if ("PL_sdk_html_load_start".equals(str) || "PL_sdk_html_load_finish".equals(str) || "PL_sdk_html_load_error".equals(str)) {
                jSONObject.put("usecache", this.zGQ ? 1 : 0);
            }
            jSONObject.put("playable_event", str);
            jSONObject.put("playable_ts", System.currentTimeMillis());
            jSONObject.put("playable_viewable", this.EZl);
            jSONObject.put("playable_session_id", this.YIK);
            int i11 = this.DNB;
            if (i11 == 0) {
                if (this.otH != sc.LAND_PAGE && !Tf(this.hE)) {
                    qKn();
                }
                jSONObject.put("playable_url", this.hE);
            } else if (i11 == 3 || i11 == 4) {
                jSONObject.put("playable_url", We(this.qY, this.Zn));
            } else if (i11 == 1 || i11 == 2) {
                jSONObject.put("playable_url", zY(this.TEo, this.jxU));
            }
            jSONObject.put("playable_full_url", this.jcs);
            jSONObject.put("playable_replay_count", this.yL);
            jSONObject.put("playable_is_prerender", this.HBq);
            jSONObject.put("playable_is_preload", this.f27152eo);
            jSONObject.put("playable_render_type", this.DNB);
            jSONObject.put("playable_scenes_type", this.otH.ordinal());
            String str2 = "";
            jSONObject.put("playable_gecko_key", TextUtils.isEmpty(this.TEo) ? "" : this.TEo);
            if (!TextUtils.isEmpty(this.jxU)) {
                str2 = this.jxU;
            }
            jSONObject.put("playable_gecko_channel", str2);
            jSONObject.put("playable_sdk_version", "6.6.0");
            jSONObject.put("playable_minigamelite_id", this.qY);
            jSONObject.put("playable_minigamelite_schema", this.Zn);
            jSONObject.put("playable_is_debug", this.TI);
            jSONObject.put("playable_retry_count", this.qfG);
            jSONObject.put("playable_enter_from", this.OKY);
            jSONObject.put("playable_sequence", this.f27156ko);
            jSONObject.put("playable_current_section", this.f27155ht);
            jSONObject.put("is_playable_finish", this.ZM);
            jSONObject.put("playable_card_session", this.CYO);
            jSONObject.put("playable_video_session", this.qKn);
            jSONObject.put("playable_network_type", dE());
            jSONObject.put("playable_lynx_version", this.WP);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ad_extra_data", jSONObject);
            jSONObject2.put("tag", this.Dl);
            jSONObject2.put("nt", 4);
            jSONObject2.put("category", "umeng");
            jSONObject2.put("is_ad_event", "1");
            jSONObject2.put("refer", "playable");
            jSONObject2.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, this.WMT.opt(BidResponsedEx.KEY_CID));
            jSONObject2.put("log_extra", this.WMT.opt("log_extra"));
            int i12 = this.DNB;
            if (i12 != -1 && i12 != -2) {
                if (this.gsl != null) {
                    List<JSONObject> list = this.f27153fb;
                    if (list != null && !list.isEmpty()) {
                        Iterator<JSONObject> it = this.f27153fb.iterator();
                        while (it.hasNext()) {
                            JSONObject jSONObjectOptJSONObject = it.next().optJSONObject("ad_extra_data");
                            if (jSONObjectOptJSONObject != null) {
                                jSONObjectOptJSONObject.put("playable_render_type", this.DNB);
                                jSONObjectOptJSONObject.put("playable_url", this.hE);
                            }
                            this.gsl.sc(jSONObjectOptJSONObject);
                        }
                        this.f27153fb.clear();
                    }
                    if (this.DNB == 0 && (this.otH != sc.LAND_PAGE || Tf(this.hE))) {
                        this.gsl.sc(jSONObject);
                        return;
                    } else {
                        if (this.DNB != 0) {
                            this.gsl.sc(jSONObject);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (this.f27153fb == null) {
                this.f27153fb = new ArrayList();
            }
            this.f27153fb.add(jSONObject2);
        } catch (Throwable th2) {
            qr.sc("PlayablePlugin", "reportEvent error", th2);
        }
    }
}
