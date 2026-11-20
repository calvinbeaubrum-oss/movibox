package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import com.bytedance.JProtect;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.bytedance.sdk.openadsdk.utils.kX;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.transsion.push.PushConstants;
import com.vungle.warren.error.VungleException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class HJN implements com.bytedance.sdk.component.adexpress.ExN.pFF, com.bytedance.sdk.component.utils.FI.sc, com.bytedance.sdk.openadsdk.WH.pFF {
    private static final Map<String, Boolean> Qj;
    private com.bytedance.sdk.component.sc.Xc BR;
    private int BT;
    private HashMap<String, WH> Cb;
    private JSONObject Dl;
    private com.bytedance.sdk.openadsdk.Tf.ExN FI;
    private boolean GI;
    private com.bytedance.sdk.openadsdk.Tf.Ol HJN;
    private com.bytedance.sdk.openadsdk.core.pFF.We II;
    private com.bytedance.sdk.openadsdk.Tf.sc JPJ;
    private String JoC;
    private com.bytedance.sdk.openadsdk.Tf.pFF McK;
    private boolean MxZ;
    private com.bytedance.sdk.openadsdk.WH.zY Ol;
    private Context QLv;
    private int Ql;
    private String SR;
    private com.bytedance.sdk.component.adexpress.pFF.UFX Sfl;
    private String TRI;
    private String Tf;
    private WeakReference<View> UFX;
    private String WH;
    private com.bytedance.sdk.openadsdk.Tf.We WP;
    private WeakReference<com.bytedance.sdk.component.Ol.We> We;
    private com.bytedance.sdk.openadsdk.core.model.Sfl Xc;
    private com.bytedance.sdk.openadsdk.core.Qj.SR YIK;
    private zY Yhz;
    private List<com.bytedance.sdk.openadsdk.core.model.Sfl> cD;
    private JSONObject cvk;

    /* JADX INFO: renamed from: eo, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.Ql.We.pFF f28008eo;
    private com.bytedance.sdk.openadsdk.We.We.ExN kX;
    boolean pFF;

    /* JADX INFO: renamed from: pc, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.Tf.TRI f28009pc;
    private com.bytedance.sdk.openadsdk.core.widget.sc.sc qKn;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.widget.TRI f28010qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected Map<String, Object> f28011sc;
    private com.bytedance.sdk.openadsdk.WH.We uEA;
    private JSONObject wjp;
    private sc yL;
    private boolean dE = true;
    private boolean Gb = true;
    private boolean OXF = false;
    private boolean cJ = false;
    boolean zY = false;
    private boolean CYO = false;
    private final com.bytedance.sdk.component.utils.FI ExN = new com.bytedance.sdk.component.utils.FI(Looper.getMainLooper(), this);

    /* JADX INFO: compiled from: source.java */
    public static class pFF {
        public int ExN;
        public JSONObject We;
        public String pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        public String f28022sc;
        public String zY;
    }

    /* JADX INFO: compiled from: source.java */
    public interface sc {
        void sc();
    }

    /* JADX INFO: compiled from: source.java */
    public static class zY implements Runnable {
        private final JSONObject pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final com.bytedance.sdk.openadsdk.core.Qj.SR f28023sc;

        public zY(com.bytedance.sdk.openadsdk.core.Qj.SR sr2, JSONObject jSONObject) {
            this.f28023sc = sr2;
            this.pFF = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            HJN.pFF(this.f28023sc, this.pFF);
        }
    }

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        Qj = concurrentHashMap;
        Boolean bool = Boolean.TRUE;
        concurrentHashMap.put("log_event", bool);
        concurrentHashMap.put("private", bool);
        concurrentHashMap.put("dispatch_message", bool);
        concurrentHashMap.put("custom_event", bool);
        concurrentHashMap.put("log_event_v3", bool);
    }

    public HJN(Context context) {
        this.QLv = context;
    }

    private static List<String> BT() {
        return Arrays.asList("appInfo", "adInfo", "getTemplateInfo", "getTeMaiAds");
    }

    @JProtect
    private void BT(JSONObject jSONObject) {
        int i11;
        double dOptDouble;
        double dOptDouble2;
        com.bytedance.sdk.openadsdk.Tf.TRI tri;
        HJN hjn = this;
        if (hjn.Sfl == null || jSONObject == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.We.We.ExN exN = hjn.kX;
        if (exN != null) {
            exN.dE();
        }
        com.bytedance.sdk.component.adexpress.pFF.SR sr2 = new com.bytedance.sdk.component.adexpress.pFF.SR();
        sr2.sc(1);
        try {
            boolean zOptBoolean = jSONObject.optBoolean("isRenderSuc");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("AdSize");
            if (jSONObjectOptJSONObject != null) {
                dOptDouble = jSONObjectOptJSONObject.optDouble("width");
                dOptDouble2 = jSONObjectOptJSONObject.optDouble("height");
            } else {
                dOptDouble = 0.0d;
                dOptDouble2 = 0.0d;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("videoInfo");
            if (jSONObjectOptJSONObject2 != null) {
                try {
                    double dOptDouble3 = jSONObjectOptJSONObject2.optDouble("x");
                    double dOptDouble4 = jSONObjectOptJSONObject2.optDouble("y");
                    double dOptDouble5 = jSONObjectOptJSONObject2.optDouble("width");
                    double dOptDouble6 = jSONObjectOptJSONObject2.optDouble("height");
                    if (hjn.dE(jSONObjectOptJSONObject2)) {
                        sr2.sc((float) jSONObjectOptJSONObject2.optDouble("borderRadiusTopLeft"));
                        sr2.pFF((float) jSONObjectOptJSONObject2.optDouble("borderRadiusTopRight"));
                        sr2.zY((float) jSONObjectOptJSONObject2.optDouble("borderRadiusBottomLeft"));
                        sr2.We((float) jSONObjectOptJSONObject2.optDouble("borderRadiusBottomRight"));
                    }
                    sr2.zY(dOptDouble3);
                    sr2.We(dOptDouble4);
                    sr2.ExN(dOptDouble5);
                    sr2.TRI(dOptDouble6);
                } catch (Exception unused) {
                    i11 = 101;
                    hjn = this;
                }
            } else {
                dOptDouble2 = dOptDouble2;
            }
            try {
                String strOptString = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE, Qj.sc(101));
                int iOptInt = jSONObject.optInt(TrackingKey.CODE, 101);
                sr2.sc(zOptBoolean);
                sr2.sc(dOptDouble);
                sr2.pFF(dOptDouble2);
                sr2.sc(strOptString);
                sr2.pFF(iOptInt);
                hjn = this;
                hjn.Sfl.sc(sr2);
                if (jSONObjectOptJSONObject2 == null || (tri = hjn.f28009pc) == null) {
                    return;
                }
                tri.sc(sr2);
                return;
            } catch (Exception unused2) {
                hjn = this;
            }
        } catch (Exception unused3) {
        }
        i11 = 101;
        sr2.pFF(i11);
        sr2.sc(Qj.sc(i11));
        hjn.Sfl.sc(sr2);
    }

    @JProtect
    private JSONObject Dl() {
        return pFF(this.Xc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject Dl(JSONObject jSONObject) {
        if (this.f28011sc != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                String strOptString = jSONObject.optString("ad_extra_data", null);
                if (strOptString != null) {
                    jSONObject2 = new JSONObject(strOptString);
                }
                for (Map.Entry<String, Object> entry : this.f28011sc.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            } catch (Exception e11) {
                com.bytedance.sdk.component.utils.Tf.pFF(e11.toString());
            }
        }
        return jSONObject;
    }

    private void JPJ() {
        if (this.Ol == null) {
            this.Ol = com.bytedance.sdk.openadsdk.WH.sc.sc(this, this.Xc);
        }
    }

    private void Ol(String str) {
        int iIndexOf;
        if (str != null && str.startsWith("bytedance://")) {
            try {
                if (str.equals("bytedance://dispatch_message/")) {
                    WebView webViewQl = Ql();
                    if (webViewQl != null) {
                        com.bytedance.sdk.component.utils.UFX.sc(webViewQl, "javascript:ToutiaoJSBridge._fetchQueue()");
                        return;
                    }
                    return;
                }
                if (!str.startsWith("bytedance://private/setresult/") || (iIndexOf = str.indexOf(38, 30)) <= 0) {
                    return;
                }
                String strSubstring = str.substring(30, iIndexOf);
                String strSubstring2 = str.substring(iIndexOf + 1);
                if (!strSubstring.equals("SCENE_FETCHQUEUE") || strSubstring2.length() <= 0) {
                    return;
                }
                qr(strSubstring2);
            } catch (Exception unused) {
            }
        }
    }

    private void Ol(JSONObject jSONObject) throws Exception {
        if (this.GI) {
            com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.Xc;
            if ((sfl instanceof com.bytedance.sdk.openadsdk.core.model.YIK) && ((com.bytedance.sdk.openadsdk.core.model.YIK) sfl).Kv()) {
                JSONArray jSONArray = new JSONArray();
                jSONObject.put("adInfos", jSONArray);
                for (com.bytedance.sdk.openadsdk.core.model.Sfl sfl2 : ((com.bytedance.sdk.openadsdk.core.model.YIK) this.Xc).oy()) {
                    JSONObject jSONObject2 = new JSONObject();
                    sc(jSONObject2, sfl2);
                    jSONArray.put(jSONObject2);
                }
                return;
            }
        }
        sc(jSONObject, this.Xc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Qj(String str) {
        if (!TextUtils.isEmpty(str) && "click_other".equals(str)) {
            return Ol();
        }
        return true;
    }

    private WebView Ql() {
        com.bytedance.sdk.component.Ol.We we2;
        WeakReference<com.bytedance.sdk.component.Ol.We> weakReference = this.We;
        if (weakReference == null || (we2 = weakReference.get()) == null) {
            return null;
        }
        return we2.getWebView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ql(JSONObject jSONObject) {
        if (this.YIK == null || jSONObject == null) {
            return;
        }
        try {
            this.YIK.sc(jSONObject.optInt("stateType", -1));
        } catch (Exception unused) {
        }
    }

    @JProtect
    private JSONObject SR() {
        try {
            View view = this.UFX.get();
            com.bytedance.sdk.component.Ol.We we2 = this.We.get();
            if (view == null || we2 == null) {
                com.bytedance.sdk.component.utils.Tf.sc("TTAD.AndroidObject", "setCloseButtonInfo error closeButton is null");
                return null;
            }
            int[] iArrPFF = kX.pFF(view);
            int[] iArrPFF2 = kX.pFF((View) we2);
            if (iArrPFF != null && iArrPFF2 != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", kX.We(Xc.sc(), iArrPFF[0] - iArrPFF2[0]));
                jSONObject.put("y", kX.We(Xc.sc(), iArrPFF[1] - iArrPFF2[1]));
                jSONObject.put("w", kX.We(Xc.sc(), view.getWidth()));
                jSONObject.put("h", kX.We(Xc.sc(), view.getHeight()));
                jSONObject.put("isExist", true);
                return jSONObject;
            }
            com.bytedance.sdk.component.utils.Tf.sc("TTAD.AndroidObject", "setCloseButtonInfo error position or webViewPosition is null");
            return null;
        } catch (Throwable unused) {
        }
    }

    private boolean SR(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.Qj.SR sr2 = this.YIK;
        if (sr2 != null && jSONObject != null) {
            double dZY = sr2.zY();
            int iWe = this.YIK.We();
            try {
                jSONObject.put("currentTime", dZY / 1000.0d);
                jSONObject.put("state", iWe);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sfl() {
        com.bytedance.sdk.openadsdk.core.Qj.SR sr2 = this.YIK;
        if (sr2 != null) {
            sr2.sc();
        }
    }

    private boolean Sfl(JSONObject jSONObject) {
        try {
            jSONObject.put("creatives", pFF(this.cD));
        } catch (Exception unused) {
        }
        return true;
    }

    private void Tf(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.Tf.pFF pff = this.McK;
        if (pff == null || jSONObject == null) {
            return;
        }
        pff.sc(jSONObject.optBoolean("isRenderSuc", false), jSONObject.optInt(TrackingKey.CODE, -1), jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE, ""));
    }

    private void UFX(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.We.We.ExN exN;
        if (jSONObject == null || (exN = this.kX) == null) {
            return;
        }
        exN.pFF(jSONObject);
    }

    private void WH(JSONObject jSONObject) throws Exception {
        if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.model.JPJ.UFX(this.Xc))) {
            return;
        }
        jSONObject.put("playable_style", com.bytedance.sdk.openadsdk.core.model.JPJ.UFX(this.Xc));
    }

    private void Xc() {
        com.bytedance.sdk.openadsdk.Tf.Ol ol2 = this.HJN;
        if (ol2 == null) {
            return;
        }
        ol2.sc();
    }

    private void Xc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            Uri uri = Uri.parse(jSONObject.optString("trackData"));
            if ("bytedance".equals(uri.getScheme().toLowerCase())) {
                com.bytedance.sdk.openadsdk.utils.Xc.sc(uri, this);
            }
        } catch (Exception unused) {
        }
    }

    private void YIK() {
        if (this.QLv == null || TextUtils.isEmpty(Xc.We().cJ())) {
            return;
        }
        TTWebsiteActivity.sc(this.QLv, this.Xc, this.JoC);
    }

    private void YIK(JSONObject jSONObject) {
        WebView webViewQl;
        if (jSONObject == null || (webViewQl = Ql()) == null) {
            return;
        }
        com.bytedance.sdk.component.utils.UFX.sc(webViewQl, "javascript:ToutiaoJSBridge._handleMessageFromToutiao(" + jSONObject + ")");
    }

    private Context dE() {
        WeakReference<com.bytedance.sdk.component.Ol.We> weakReference = this.We;
        Activity activitySc = (weakReference == null || weakReference.get() == null) ? null : com.bytedance.sdk.component.utils.pFF.sc(this.We.get());
        return activitySc == null ? this.QLv : activitySc;
    }

    private boolean dE(@NonNull JSONObject jSONObject) {
        return jSONObject.has("borderRadiusTopLeft") && jSONObject.has("borderRadiusBottomLeft") && jSONObject.has("borderRadiusTopRight") && jSONObject.has("borderRadiusBottomRight");
    }

    public static JSONArray pFF(List<com.bytedance.sdk.openadsdk.core.model.Sfl> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null) {
            return jSONArray;
        }
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            jSONArray.put(list.get(i11).JP());
        }
        return jSONArray;
    }

    public static JSONObject pFF(com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        int iQT;
        JSONObject jSONObject = new JSONObject();
        if (Xc.We() == null) {
            return jSONObject;
        }
        int i11 = 0;
        if (sfl != null) {
            try {
                iQT = sfl.QT();
            } catch (Exception unused) {
            }
        } else {
            iQT = 0;
        }
        int iQY = sfl != null ? sfl.qY() : 0;
        int iWH = Xc.We().WH(String.valueOf(iQT));
        int iSfl = Xc.We().Sfl(String.valueOf(iQT));
        boolean zTRI = Xc.We().TRI(String.valueOf(iQT));
        boolean z11 = Xc.We().Ql(String.valueOf(iQT)) == 1;
        jSONObject.put("voice_control", (iQY == 7 || iQY == 8) ? Xc.We().Xc(String.valueOf(iQT)) : Xc.We().zY(String.valueOf(iQT)));
        jSONObject.put("rv_skip_time", iWH);
        jSONObject.put("fv_skip_show", zTRI);
        jSONObject.put("iv_skip_time", iSfl);
        jSONObject.put("show_dislike", sfl != null && sfl.vYl());
        jSONObject.put("video_adaptation", sfl != null ? sfl.HJN() : 0);
        if (com.bytedance.sdk.openadsdk.core.model.Xc.zY(sfl)) {
            jSONObject.put("skip_change_to_close", true);
        } else {
            jSONObject.put("skip_change_to_close", z11);
        }
        if (sfl.hP() && com.bytedance.sdk.openadsdk.core.settings.dE.ef().hE()) {
            i11 = 1;
        }
        jSONObject.put("bar_render_platform", i11);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void pFF(com.bytedance.sdk.openadsdk.core.Qj.SR sr2, JSONObject jSONObject) {
        if (sr2 == null || jSONObject == null) {
            return;
        }
        try {
            sr2.sc(jSONObject.optBoolean(CampaignEx.JSON_NATIVE_VIDEO_MUTE, false));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF(String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", "callback");
            jSONObject2.put("__callback_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            YIK(jSONObject2);
        } catch (Exception unused) {
        }
    }

    @JProtect
    public static void pFF(JSONObject jSONObject) throws Exception {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = BT().iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        jSONObject.put("appName", com.bytedance.sdk.openadsdk.common.pFF.sc());
        jSONObject.put("innerAppName", com.bytedance.sdk.openadsdk.common.pFF.ExN());
        jSONObject.put("aid", com.bytedance.sdk.openadsdk.common.pFF.pFF());
        jSONObject.put("sdkEdition", com.bytedance.sdk.openadsdk.common.pFF.zY());
        jSONObject.put("appVersion", com.bytedance.sdk.openadsdk.common.pFF.We());
        jSONObject.put("netType", com.bytedance.sdk.openadsdk.common.pFF.TRI());
        jSONObject.put("supportList", jSONArray);
        jSONObject.put("deviceId", com.bytedance.sdk.openadsdk.common.pFF.sc(Xc.sc()));
        if (DeviceUtils.pFF(Xc.sc())) {
            jSONObject.put("device_platform", "Android_Pad");
        } else {
            jSONObject.put("device_platform", "Android");
        }
        jSONObject.put("device_type", Build.VERSION.RELEASE);
    }

    private void qr(String str) {
        try {
            JSONArray jSONArray = new JSONArray(new String(Base64.decode(str, 2)));
            int length = jSONArray.length();
            for (int i11 = 0; i11 < length; i11++) {
                pFF pff = new pFF();
                try {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i11);
                    if (jSONObjectOptJSONObject != null) {
                        pff.f28022sc = jSONObjectOptJSONObject.optString("__msg_type", null);
                        pff.pFF = jSONObjectOptJSONObject.optString("__callback_id", null);
                        pff.zY = jSONObjectOptJSONObject.optString("func");
                        pff.We = jSONObjectOptJSONObject.optJSONObject("params");
                        pff.ExN = jSONObjectOptJSONObject.optInt("JSSDK");
                    }
                } catch (Throwable unused) {
                }
                if (!TextUtils.isEmpty(pff.f28022sc) && !TextUtils.isEmpty(pff.zY)) {
                    Message messageObtainMessage = this.ExN.obtainMessage(11);
                    messageObtainMessage.obj = pff;
                    this.ExN.sendMessage(messageObtainMessage);
                }
            }
        } catch (Exception unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String sc(String str, String str2) {
        if (com.bytedance.sdk.openadsdk.core.model.Xc.ExN(this.Xc)) {
            return PushConstants.PUSH_SERVICE_TYPE_SHOW.equals(str2) ? cJ.sc(this.Ql) : "aggregate_page";
        }
        if (com.bytedance.sdk.openadsdk.core.model.JPJ.ExN(this.Xc)) {
            return this.TRI;
        }
        if (this.McK != null) {
            return cJ.sc(this.Ql);
        }
        return this.Sfl == null ? cJ.pFF(this.Ql) : str;
    }

    private void sc(final pFF pff, final JSONObject jSONObject) {
        if (pff == null) {
            return;
        }
        try {
            sc(pff.We, new com.bytedance.sdk.openadsdk.Tf.zY() { // from class: com.bytedance.sdk.openadsdk.core.HJN.6
                @Override // com.bytedance.sdk.openadsdk.Tf.zY
                public void sc(boolean z11, List<com.bytedance.sdk.openadsdk.core.model.Sfl> list) {
                    if (!z11) {
                        HJN.this.pFF(pff.pFF, jSONObject);
                        return;
                    }
                    try {
                        jSONObject.put("creatives", HJN.pFF(list));
                        HJN.this.pFF(pff.pFF, jSONObject);
                    } catch (Exception unused) {
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    private void sc(com.bytedance.sdk.openadsdk.core.model.Sfl sfl, String str, boolean z11) {
        com.bytedance.sdk.openadsdk.core.pFF.sc scVar = new com.bytedance.sdk.openadsdk.core.pFF.sc(Xc.sc(), sfl, str, this.Ql);
        scVar.sc(com.bytedance.sdk.openadsdk.wjp.sc.sc.qr.sc(Xc.sc(), sfl, str));
        if (!z11) {
            scVar.sc(false);
        }
        scVar.onClick(null);
    }

    private void sc(String str, boolean z11) {
        if (this.kX == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (z11) {
            this.kX.sc(str);
        } else {
            this.kX.pFF(str);
        }
    }

    public static void sc(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.model.Sfl sfl) throws Exception {
        String strKDg = sfl.kDg();
        if (!TextUtils.isEmpty(strKDg)) {
            jSONObject.put(BidResponsedEx.KEY_CID, strKDg);
        }
        String strMD = sfl.mD();
        if (!TextUtils.isEmpty(strMD)) {
            jSONObject.put("log_extra", strMD);
        }
        String strBU = sfl.BU();
        if (!TextUtils.isEmpty(strBU)) {
            jSONObject.put("download_url", strBU);
        }
        jSONObject.put("dc", TextUtils.isEmpty(Xc.We().JoC()) ? Xc.We().JoC() : "SG");
        jSONObject.put("language", Tf.pFF());
        jSONObject.put("isRTL", com.bytedance.sdk.openadsdk.core.settings.dE.ef().YdT());
    }

    private void sc(JSONObject jSONObject, boolean z11, String str) {
        com.bytedance.sdk.openadsdk.core.widget.TRI tri;
        if (z11) {
            try {
                String strOptString = jSONObject.optString("ad_extra_data");
                if (TextUtils.isEmpty(strOptString) || new JSONObject(strOptString).optInt("agg_request_type", -1) != 1 || !"click".equals(str) || (tri = this.f28010qr) == null) {
                    return;
                }
                tri.sc();
            } catch (Throwable th2) {
                com.bytedance.sdk.component.utils.Tf.sc("TTAD.AndroidObject", "callAggClickListener faile", th2);
            }
        }
    }

    @JProtect
    private boolean sc(String str, int i11, com.bytedance.sdk.openadsdk.core.model.SR sr2) {
        HashMap<String, WH> map;
        if (TextUtils.isEmpty(str) || (map = this.Cb) == null || map.get(str) == null) {
            return false;
        }
        throw null;
    }

    private boolean sc(JSONObject jSONObject, JSONObject jSONObject2) {
        String strOptString;
        int iOptInt;
        String strOptString2;
        if (jSONObject != null) {
            iOptInt = jSONObject.optInt("landingStyle");
            strOptString = jSONObject.optString("url");
            strOptString2 = jSONObject.optString("fallback_url");
        } else {
            strOptString = null;
            iOptInt = -1;
            strOptString2 = null;
        }
        boolean z11 = false;
        if (iOptInt == 1) {
            if (!com.bytedance.sdk.component.utils.BT.sc(strOptString)) {
                try {
                    jSONObject2.put("invalid_url", 1);
                } catch (JSONException e11) {
                    com.bytedance.sdk.component.utils.Tf.sc("TTAD.AndroidObject", "handleUrl, EX1->: ", e11);
                }
            }
            return z11;
        }
        if (iOptInt == 2) {
            try {
                if (TextUtils.isEmpty(strOptString) && TextUtils.isEmpty(strOptString2)) {
                    jSONObject2.put("empty_url", 1);
                } else if (!com.bytedance.sdk.component.utils.BT.sc(strOptString2)) {
                    jSONObject2.put("invalid_url", 1);
                }
            } catch (JSONException e12) {
                com.bytedance.sdk.component.utils.Tf.sc("TTAD.AndroidObject", "handleUrl, EX2->: ", e12);
            }
        }
        return z11;
        z11 = true;
        return z11;
    }

    private boolean uEA() {
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.Xc;
        if (sfl == null || sfl.Mrq() == null || com.bytedance.sdk.openadsdk.core.model.JPJ.pFF(this.Xc) || this.OXF || this.Xc.Mrq().optInt("parent_type") != 2) {
            return false;
        }
        int iQY = this.Xc.qY();
        if (iQY != 8 && iQY != 7) {
            return false;
        }
        this.OXF = true;
        return true;
    }

    private void wjp() {
        com.bytedance.sdk.openadsdk.Tf.Ol ol2 = this.HJN;
        if (ol2 == null) {
            return;
        }
        ol2.pFF();
    }

    private void wjp(JSONObject jSONObject) {
        if (jSONObject == null || this.uEA == null) {
            return;
        }
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("temaiProductIds");
            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                this.uEA.sc(false, null);
            } else {
                this.uEA.sc(true, jSONArrayOptJSONArray);
            }
        } catch (Exception unused) {
            this.uEA.sc(false, null);
        }
    }

    private JSONObject zY(com.bytedance.sdk.openadsdk.core.model.Sfl sfl) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("is_ad_event", "1");
        jSONObject2.put(BidResponsedEx.KEY_CID, sfl.Kh());
        jSONObject2.put("req_id", sfl.ofL());
        jSONObject2.put("ad_id", sfl.kDg());
        jSONObject2.put("log_extra", sfl.mD());
        jSONObject2.put("isRTL", com.bytedance.sdk.openadsdk.core.settings.dE.ef().YdT());
        jSONObject.put("ad_info", jSONObject2);
        jSONObject.put("endcard_creative", sfl.DI());
        return jSONObject;
    }

    private void zY(String str, JSONObject jSONObject) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", NotificationCompat.CATEGORY_EVENT);
            jSONObject2.put("__event_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            YIK(jSONObject2);
        } catch (Exception unused) {
        }
    }

    public HJN ExN(String str) {
        this.SR = str;
        return this;
    }

    public void ExN(JSONObject jSONObject) {
        double d11;
        double d12;
        double dOptDouble;
        double d13;
        double d14;
        double d15;
        double d16;
        double d17;
        double d18;
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.utils.Dl.sc("TTAD.AndroidObject", "trigger Class1 method1");
        try {
            String strOptString = jSONObject.optString("adId");
            int iOptInt = jSONObject.optInt("areaType", 1);
            String strOptString2 = jSONObject.optString("clickAreaType");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("clickInfo");
            double d19 = 0.0d;
            if (jSONObjectOptJSONObject2 != null) {
                double dOptDouble2 = jSONObjectOptJSONObject2.optDouble("down_x", 0.0d);
                dOptDouble = jSONObjectOptJSONObject2.optDouble("down_y", 0.0d);
                double dOptDouble3 = jSONObjectOptJSONObject2.optDouble("up_x", 0.0d);
                double dOptDouble4 = jSONObjectOptJSONObject2.optDouble("up_y", 0.0d);
                double dOptDouble5 = jSONObjectOptJSONObject2.optDouble("down_time", 0.0d);
                double dOptDouble6 = jSONObjectOptJSONObject2.optDouble("up_time", 0.0d);
                double dOptDouble7 = jSONObjectOptJSONObject2.optDouble("button_x", 0.0d);
                double dOptDouble8 = jSONObjectOptJSONObject2.optDouble("button_y", 0.0d);
                double dOptDouble9 = jSONObjectOptJSONObject2.optDouble("button_width", 0.0d);
                double dOptDouble10 = jSONObjectOptJSONObject2.optDouble("button_height", 0.0d);
                jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("rectInfo");
                d18 = dOptDouble10;
                d19 = dOptDouble2;
                d12 = dOptDouble3;
                d13 = dOptDouble5;
                d14 = dOptDouble6;
                d15 = dOptDouble7;
                d16 = dOptDouble8;
                d17 = dOptDouble9;
                d11 = dOptDouble4;
            } else {
                d11 = 0.0d;
                d12 = 0.0d;
                dOptDouble = 0.0d;
                d13 = 0.0d;
                d14 = 0.0d;
                d15 = 0.0d;
                d16 = 0.0d;
                d17 = 0.0d;
                d18 = 0.0d;
                jSONObjectOptJSONObject = null;
            }
            com.bytedance.sdk.openadsdk.core.model.SR srSc = new com.bytedance.sdk.openadsdk.core.model.SR.sc().We((float) d19).zY((float) dOptDouble).pFF((float) d12).sc((float) d11).pFF((long) d13).sc((long) d14).zY((int) d15).We((int) d16).ExN((int) d17).TRI((int) d18).sc(strOptString2).sc((SparseArray<com.bytedance.sdk.openadsdk.core.pFF.zY.sc>) null).sc(true).pFF(iOptInt).sc(jSONObjectOptJSONObject).sc(jSONObject.optInt("clickAreaCategory", -1)).pFF(jSONObjectOptJSONObject2).sc();
            com.bytedance.sdk.component.adexpress.pFF.UFX ufx = this.Sfl;
            if (ufx != null) {
                ufx.sc(null, iOptInt, srSc);
            }
            sc(strOptString, iOptInt, srSc);
        } catch (Exception unused) {
            com.bytedance.sdk.component.adexpress.pFF.UFX ufx2 = this.Sfl;
            if (ufx2 != null) {
                ufx2.sc(null, -1, null);
            }
        }
    }

    public void ExN(boolean z11) {
        this.MxZ = z11;
    }

    public boolean ExN() {
        return this.zY;
    }

    public boolean Ol() {
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.Xc;
        return sfl != null && sfl.pc() == 1;
    }

    public void Qj(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.model.sc scVarVBa;
        if (jSONObject == null) {
            return;
        }
        int iOptInt = jSONObject.optInt("index");
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.Xc;
        if (!(sfl instanceof com.bytedance.sdk.openadsdk.core.model.YIK) || (scVarVBa = ((com.bytedance.sdk.openadsdk.core.model.YIK) sfl).vBa()) == null) {
            return;
        }
        List<com.bytedance.sdk.openadsdk.core.model.Sfl> listWe = scVarVBa.We();
        if (iOptInt < 0 || iOptInt >= listWe.size()) {
            return;
        }
        sc(listWe.get(iOptInt), this.JoC, false);
        com.bytedance.sdk.openadsdk.core.Ql.We.pFF pff = this.f28008eo;
        if (pff != null) {
            pff.We();
        }
    }

    public boolean Qj() {
        return this.CYO;
    }

    public void TRI() {
        com.bytedance.sdk.openadsdk.Tf.pFF pff;
        if (this.MxZ && (pff = this.McK) != null) {
            pff.sc();
            return;
        }
        Context context = this.QLv;
        if ((context instanceof Activity) && com.bytedance.sdk.openadsdk.utils.YIK.sc((Activity) context)) {
            ((Activity) this.QLv).finish();
        }
    }

    public void TRI(String str) {
        this.JoC = str;
    }

    public void TRI(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.model.Sfl sflSc = com.bytedance.sdk.openadsdk.core.pFF.sc(jSONObject);
        if (sflSc != null) {
            boolean zExN = com.bytedance.sdk.openadsdk.core.model.Xc.ExN(this.Xc);
            sc(sflSc, zExN ? cJ.pFF(this.Ql) : this.JoC, !zExN);
        }
    }

    public void Tf() {
        sc scVar = this.yL;
        if (scVar != null) {
            scVar.sc();
        }
    }

    public void UFX() {
        com.bytedance.sdk.openadsdk.WH.zY zYVar = this.Ol;
        if (zYVar != null) {
            zYVar.sc();
        }
        zY zYVar2 = this.Yhz;
        if (zYVar2 != null) {
            com.bytedance.sdk.openadsdk.utils.Cb.pFF(zYVar2);
            this.Yhz = null;
        }
        this.QLv = null;
        this.f28008eo = null;
    }

    public void WH() {
        uEA();
    }

    public HJN We(String str) {
        this.Tf = str;
        return this;
    }

    public void We(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        int iOptInt = jSONObject.optInt("zoom_type", 1);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("videoInfo");
        com.bytedance.sdk.component.adexpress.pFF.SR sr2 = new com.bytedance.sdk.component.adexpress.pFF.SR();
        if (jSONObjectOptJSONObject != null) {
            double dOptDouble = jSONObjectOptJSONObject.optDouble("x");
            double dOptDouble2 = jSONObjectOptJSONObject.optDouble("y");
            double dOptDouble3 = jSONObjectOptJSONObject.optDouble("width");
            double dOptDouble4 = jSONObjectOptJSONObject.optDouble("height");
            sr2.zY(dOptDouble);
            sr2.We(dOptDouble2);
            sr2.ExN(dOptDouble3);
            sr2.TRI(dOptDouble4);
        }
        com.bytedance.sdk.openadsdk.core.Qj.SR sr3 = this.YIK;
        if (sr3 != null) {
            sr3.sc(iOptInt, sr2);
        }
    }

    public void We(boolean z11) {
        this.GI = z11;
    }

    public boolean We() {
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.Xc;
        return sfl != null && sfl.FI();
    }

    @Override // com.bytedance.sdk.component.adexpress.ExN.pFF
    @JavascriptInterface
    public String adInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            Ol(jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.component.adexpress.ExN.pFF
    @JavascriptInterface
    public String appInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            pFF(jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.component.adexpress.ExN.pFF
    @JavascriptInterface
    public void changeVideoState(String str) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            com.bytedance.sdk.openadsdk.utils.Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.HJN.2
                @Override // java.lang.Runnable
                public void run() {
                    HJN.this.Ql(jSONObject);
                }
            });
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ExN.pFF
    @JavascriptInterface
    public void chooseAdResult(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("video_choose");
            long jOptLong = jSONObject.optLong("video_choose_duration");
            com.bytedance.sdk.openadsdk.Tf.TRI tri = this.f28009pc;
            if (tri != null) {
                tri.sc(iOptInt, jOptLong);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ExN.pFF
    @JavascriptInterface
    public void clickEvent(String str) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            com.bytedance.sdk.openadsdk.utils.Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.HJN.3
                @Override // java.lang.Runnable
                public void run() {
                    HJN.this.ExN(jSONObject);
                }
            });
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ExN.pFF
    @JavascriptInterface
    public void dynamicTrack(String str) {
        try {
            Xc(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ExN.pFF
    @JavascriptInterface
    public String getCurrentVideoState() {
        JSONObject jSONObject = new JSONObject();
        SR(jSONObject);
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.component.adexpress.ExN.pFF
    @JavascriptInterface
    public String getData(String str) {
        if (TextUtils.isEmpty(str)) {
            return this.Dl.toString();
        }
        try {
            JSONObject jSONObjectSc = com.bytedance.sdk.openadsdk.core.Qj.sc.pFF.sc(this.Dl, new JSONObject(str));
            return jSONObjectSc == null ? this.Dl.toString() : jSONObjectSc.toString();
        } catch (Exception unused) {
            return this.Dl.toString();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ExN.pFF
    @JavascriptInterface
    public String getTemplateInfo() {
        sc("getTemplateInfo", true);
        try {
            JSONObject jSONObject = this.Dl;
            if (jSONObject != null) {
                jSONObject.put("setting", Dl());
                com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.Xc;
                if (sfl != null) {
                    this.Dl.put("extension", sfl.vl());
                }
            }
            sc("getTemplateInfo", false);
            return this.Dl.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ExN.pFF
    @JavascriptInterface
    public void initRenderFinish() {
        com.bytedance.sdk.openadsdk.utils.Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.HJN.5
            @Override // java.lang.Runnable
            public void run() {
                if (HJN.this.qKn != null) {
                    HJN.this.qKn.sc();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.ExN.pFF
    @JavascriptInterface
    public void muteVideo(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            zY zYVar = this.Yhz;
            if (zYVar != null) {
                com.bytedance.sdk.openadsdk.utils.Cb.pFF(zYVar);
            }
            zY zYVar2 = new zY(this.YIK, jSONObject);
            this.Yhz = zYVar2;
            com.bytedance.sdk.openadsdk.utils.Cb.sc(zYVar2);
        } catch (Exception unused) {
            com.bytedance.sdk.component.utils.Tf.sc("TTAD.AndroidObject", "");
        }
    }

    public HJN pFF(int i11) {
        this.Ql = i11;
        return this;
    }

    public HJN pFF(com.bytedance.sdk.component.Ol.We we2) {
        this.We = new WeakReference<>(we2);
        return this;
    }

    public HJN pFF(String str) {
        this.TRI = str;
        return this;
    }

    public HJN pFF(boolean z11) {
        this.cJ = z11;
        return this;
    }

    public void pFF() {
        com.bytedance.sdk.component.sc.Xc xc2 = this.BR;
        if (xc2 == null) {
            return;
        }
        xc2.sc();
        this.BR = null;
    }

    public void pFF(@NonNull final Uri uri) {
        try {
            String host = uri.getHost();
            if (!"log_event".equals(host) && !"custom_event".equals(host) && !"log_event_v3".equals(host)) {
                if ("private".equals(host) || "dispatch_message".equals(host)) {
                    Ol(uri.toString());
                    return;
                }
                return;
            }
            com.bytedance.sdk.openadsdk.We.zY.sc(new com.bytedance.sdk.component.Qj.Qj("log_event_handleUri") { // from class: com.bytedance.sdk.openadsdk.core.HJN.9
                @Override // java.lang.Runnable
                public void run() {
                    long j11;
                    String strSc;
                    String queryParameter = uri.getQueryParameter("category");
                    String queryParameter2 = uri.getQueryParameter("tag");
                    HJN.this.JoC = queryParameter2;
                    String queryParameter3 = uri.getQueryParameter("label");
                    if (HJN.this.Qj(queryParameter3)) {
                        long j12 = 0;
                        try {
                            j11 = Long.parseLong(uri.getQueryParameter(AppMeasurementSdk.ConditionalUserProperty.VALUE));
                        } catch (Exception unused) {
                            j11 = 0;
                        }
                        try {
                            j12 = Long.parseLong(uri.getQueryParameter("ext_value"));
                        } catch (Exception unused2) {
                        }
                        long j13 = j12;
                        String queryParameter4 = uri.getQueryParameter("extra");
                        JSONObject jSONObjectDl = null;
                        if (!TextUtils.isEmpty(queryParameter4)) {
                            try {
                                JSONObject jSONObject = new JSONObject(queryParameter4);
                                try {
                                    jSONObject.putOpt("ua_policy", Integer.valueOf(HJN.this.BT));
                                } catch (Exception unused3) {
                                }
                                jSONObjectDl = jSONObject;
                            } catch (Exception unused4) {
                            }
                        }
                        if ("click".equals(queryParameter3)) {
                            jSONObjectDl = HJN.this.Dl(jSONObjectDl);
                        }
                        if ("landing_perf_error".equals(queryParameter3) || "landing_perf_stats".equals(queryParameter3)) {
                            try {
                                JSONObject jSONObject2 = new JSONObject();
                                for (String str : uri.getQueryParameterNames()) {
                                    try {
                                        if ("extra".equals(str)) {
                                            jSONObject2.put("ad_extra_data", new JSONObject(uri.getQueryParameter(str)).optString("ad_extra_data"));
                                        } else {
                                            jSONObject2.put(str, uri.getQueryParameter(str));
                                        }
                                    } catch (Exception unused5) {
                                    }
                                }
                                strSc = HJN.this.TRI;
                                jSONObjectDl = jSONObject2;
                            } catch (Exception unused6) {
                                return;
                            }
                        } else {
                            strSc = HJN.this.sc(queryParameter2, queryParameter3);
                        }
                        com.bytedance.sdk.openadsdk.We.zY.sc(HJN.this.Xc, queryParameter, strSc, queryParameter3, j11, j13, jSONObjectDl, com.bytedance.sdk.openadsdk.core.model.Xc.ExN(HJN.this.Xc));
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    public JSONObject qr(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.Xc;
            if (sfl instanceof com.bytedance.sdk.openadsdk.core.model.YIK) {
                List<com.bytedance.sdk.openadsdk.core.model.Sfl> listWe = ((com.bytedance.sdk.openadsdk.core.model.YIK) sfl).vBa().We();
                for (int i11 = 0; i11 < listWe.size(); i11++) {
                    jSONArray.put(zY(listWe.get(i11)));
                }
            }
            jSONObject2.put("creatives", jSONArray);
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    public void qr() {
        com.bytedance.sdk.openadsdk.core.Qj.SR sr2 = this.YIK;
        if (sr2 != null) {
            sr2.pFF();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ExN.pFF
    @JavascriptInterface
    public void renderDidFinish(String str) {
        try {
            BT(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    public com.bytedance.sdk.component.sc.Xc sc() {
        return this.BR;
    }

    public HJN sc(int i11) {
        this.BT = i11;
        return this;
    }

    public HJN sc(View view) {
        this.UFX = new WeakReference<>(view);
        return this;
    }

    public HJN sc(com.bytedance.sdk.component.Ol.We we2) {
        WebView webView = we2.getWebView();
        if (webView == null) {
            return this;
        }
        try {
            com.bytedance.sdk.component.sc.Xc xcPFF = com.bytedance.sdk.component.sc.Xc.sc(webView).sc(new com.bytedance.sdk.openadsdk.UFX.sc()).sc("ToutiaoJSBridge").sc(new com.bytedance.sdk.component.sc.Tf() { // from class: com.bytedance.sdk.openadsdk.core.HJN.1
                @Override // com.bytedance.sdk.component.sc.Tf
                @NonNull
                public <T> T sc(@NonNull String str, @NonNull Type type) {
                    return null;
                }

                @Override // com.bytedance.sdk.component.sc.Tf
                @NonNull
                public <T> String sc(@NonNull T t11) {
                    return null;
                }
            }).sc(Ol.pFF().Xc()).pFF(true).sc().pFF();
            this.BR = xcPFF;
            com.bytedance.sdk.openadsdk.UFX.sc.qr.sc(xcPFF, this);
            com.bytedance.sdk.openadsdk.UFX.sc.sc.sc(this.BR, this);
            com.bytedance.sdk.openadsdk.UFX.sc.pFF.sc(this.BR, this);
            com.bytedance.sdk.openadsdk.UFX.sc.zY.sc(this.BR, this);
            com.bytedance.sdk.openadsdk.UFX.sc.TRI.sc(this.BR, this);
            com.bytedance.sdk.openadsdk.UFX.sc.Ol.sc(this.BR, this);
            com.bytedance.sdk.openadsdk.UFX.sc.UFX.sc(this.BR, this);
            com.bytedance.sdk.openadsdk.UFX.sc.WH.sc(this.BR, we2);
            com.bytedance.sdk.openadsdk.UFX.sc.Qj.sc(this.BR, this);
            com.bytedance.sdk.openadsdk.UFX.sc.ExN.sc(this.BR, this.Dl);
            com.bytedance.sdk.openadsdk.UFX.sc.We.sc(this.BR, this);
        } catch (Exception unused) {
        }
        return this;
    }

    public HJN sc(com.bytedance.sdk.component.adexpress.pFF.UFX ufx) {
        this.Sfl = ufx;
        return this;
    }

    public HJN sc(com.bytedance.sdk.openadsdk.Tf.ExN exN) {
        this.FI = exN;
        return this;
    }

    public HJN sc(com.bytedance.sdk.openadsdk.Tf.Ol ol2) {
        this.HJN = ol2;
        return this;
    }

    public HJN sc(com.bytedance.sdk.openadsdk.Tf.TRI tri) {
        this.f28009pc = tri;
        return this;
    }

    public HJN sc(com.bytedance.sdk.openadsdk.Tf.We we2) {
        this.WP = we2;
        return this;
    }

    public HJN sc(com.bytedance.sdk.openadsdk.Tf.pFF pff) {
        this.McK = pff;
        return this;
    }

    public HJN sc(com.bytedance.sdk.openadsdk.Tf.sc scVar) {
        this.JPJ = scVar;
        return this;
    }

    public HJN sc(com.bytedance.sdk.openadsdk.We.We.ExN exN) {
        this.kX = exN;
        return this;
    }

    public HJN sc(com.bytedance.sdk.openadsdk.core.Qj.SR sr2) {
        this.YIK = sr2;
        return this;
    }

    public HJN sc(com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        this.Xc = sfl;
        if (sfl != null) {
            this.wjp = sfl.Mrq();
        }
        return this;
    }

    public HJN sc(com.bytedance.sdk.openadsdk.core.pFF.We we2) {
        this.II = we2;
        return this;
    }

    public HJN sc(com.bytedance.sdk.openadsdk.core.widget.TRI tri) {
        this.f28010qr = tri;
        return this;
    }

    public HJN sc(com.bytedance.sdk.openadsdk.core.widget.sc.sc scVar) {
        this.qKn = scVar;
        return this;
    }

    public HJN sc(List<com.bytedance.sdk.openadsdk.core.model.Sfl> list) {
        this.cD = list;
        return this;
    }

    public HJN sc(Map<String, Object> map) {
        this.f28011sc = map;
        return this;
    }

    public HJN sc(JSONObject jSONObject) {
        this.Dl = jSONObject;
        return this;
    }

    public HJN sc(boolean z11) {
        this.pFF = z11;
        return this;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:10:0x0045  */
    /* JADX WARN: Code duplicated, block: B:209:0x0348 A[PHI: r4
  0x0348: PHI (r4v19 org.json.JSONObject) = (r4v14 org.json.JSONObject), (r4v20 org.json.JSONObject) binds: [B:226:0x0393, B:208:0x0346] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    @JProtect
    public JSONObject sc(pFF pff, int i11) throws Exception {
        byte b11;
        JSONObject jSONObjectSR;
        Context context;
        JSONObject jSONObject;
        if (!NotificationCompat.CATEGORY_CALL.equals(pff.f28022sc)) {
            return null;
        }
        if (Ol.pFF().Xc()) {
            StringBuilder sb2 = new StringBuilder("[JSB-REQ] version:");
            sb2.append(i11);
            sb2.append(" method:");
            sb2.append(pff.zY);
        }
        JSONObject jSONObject2 = new JSONObject();
        String str = pff.zY;
        str.hashCode();
        switch (str.hashCode()) {
            case -2036781162:
                if (!str.equals("subscribe_app_ad")) {
                    b11 = -1;
                } else {
                    b11 = 0;
                }
                break;
            case -1423303823:
                if (!str.equals("adInfo")) {
                    b11 = -1;
                } else {
                    b11 = 1;
                }
                break;
            case -1330994877:
                if (!str.equals("pauseWebView")) {
                    b11 = -1;
                } else {
                    b11 = 2;
                }
                break;
            case -1169135450:
                if (!str.equals("changeVideoState")) {
                    b11 = -1;
                } else {
                    b11 = 3;
                }
                break;
            case -1023873614:
                if (!str.equals("openAdLandPageLinks")) {
                    b11 = -1;
                } else {
                    b11 = 4;
                }
                break;
            case -844321441:
                if (!str.equals("webview_time_track")) {
                    b11 = -1;
                } else {
                    b11 = 5;
                }
                break;
            case -800853518:
                if (!str.equals("clickEvent")) {
                    b11 = -1;
                } else {
                    b11 = 6;
                }
                break;
            case -794273169:
                if (!str.equals("appInfo")) {
                    b11 = -1;
                } else {
                    b11 = 7;
                }
                break;
            case -715147645:
                if (!str.equals("getScreenSize")) {
                    b11 = -1;
                } else {
                    b11 = 8;
                }
                break;
            case -511324706:
                if (!str.equals("openPrivacy")) {
                    b11 = -1;
                } else {
                    b11 = 9;
                }
                break;
            case -489318846:
                if (!str.equals("getMaterialMeta")) {
                    b11 = -1;
                } else {
                    b11 = 10;
                }
                break;
            case -278382602:
                if (!str.equals("send_temai_product_ids")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.VT;
                }
                break;
            case -173752734:
                if (!str.equals("getTeMaiAds")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.FF;
                }
                break;
            case 27837080:
                if (!str.equals("download_app_ad")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.CR;
                }
                break;
            case 94756344:
                if (!str.equals(CampaignEx.JSON_NATIVE_VIDEO_CLOSE)) {
                    b11 = -1;
                } else {
                    b11 = Ascii.SO;
                }
                break;
            case 105049135:
                if (!str.equals("unsubscribe_app_ad")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.SI;
                }
                break;
            case 399543522:
                if (!str.equals("getCloseButtonInfo")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.DLE;
                }
                break;
            case 402955465:
                if (!str.equals("isViewable")) {
                    b11 = -1;
                } else {
                    b11 = 17;
                }
                break;
            case 425443791:
                if (!str.equals("getNativeSiteCustomData")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.DC2;
                }
                break;
            case 442647767:
                if (!str.equals("sendReward")) {
                    b11 = -1;
                } else {
                    b11 = 19;
                }
                break;
            case 571273292:
                if (!str.equals("dynamicTrack")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.DC4;
                }
                break;
            case 650209982:
                if (!str.equals("getTemplateInfo")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.NAK;
                }
                break;
            case 672928467:
                if (!str.equals("cancel_download_app_ad")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.SYN;
                }
                break;
            case 711635577:
                if (!str.equals("getCurrentVideoState")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.ETB;
                }
                break;
            case 885131792:
                if (!str.equals("getVolume")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.CAN;
                }
                break;
            case 1107374321:
                if (!str.equals("pauseWebViewTimers")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.EM;
                }
                break;
            case 1151744482:
                if (!str.equals("muteVideo")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.SUB;
                }
                break;
            case 1237100796:
                if (!str.equals("renderDidFinish")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.ESC;
                }
                break;
            case 1532142616:
                if (!str.equals("removeLoading")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.FS;
                }
                break;
            case 1634511418:
                if (!str.equals("endcard_load")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.GS;
                }
                break;
            case 1713585602:
                if (!str.equals("getNetworkData")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.RS;
                }
                break;
            case 1731806400:
                if (!str.equals("playable_style")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.US;
                }
                break;
            case 1979895452:
                if (!str.equals("sendLog")) {
                    b11 = -1;
                } else {
                    b11 = 32;
                }
                break;
            case 2086000188:
                if (!str.equals("skipVideo")) {
                    b11 = -1;
                } else {
                    b11 = 33;
                }
                break;
            case 2105008900:
                if (!str.equals("landscape_click")) {
                    b11 = -1;
                } else {
                    b11 = 34;
                }
                break;
            default:
                b11 = -1;
                break;
        }
        switch (b11) {
            case 0:
                JPJ();
                com.bytedance.sdk.openadsdk.We.zY.pFF(this.Xc, this.JoC, 0, (JSONObject) null);
                Context context2 = this.QLv;
                if (context2 == null) {
                    com.bytedance.sdk.openadsdk.We.zY.pFF(this.Xc, this.JoC, -1, (JSONObject) null);
                } else {
                    this.Ol.sc(context2, pff.We, this.Tf, this.Ql, this.dE);
                }
                break;
            case 1:
                Ol(jSONObject2);
                break;
            case 2:
                Xc();
                break;
            case 3:
                Ql(pff.We);
                break;
            case 4:
                JSONObject jSONObject3 = pff.We;
                if (sc(jSONObject3, jSONObject2)) {
                    zY(jSONObject3);
                }
                break;
            case 5:
                UFX(pff.We);
                break;
            case 6:
                ExN(pff.We);
                break;
            case 7:
                pFF(jSONObject2);
                break;
            case 8:
                com.bytedance.sdk.openadsdk.Tf.sc scVar = this.JPJ;
                if (scVar != null) {
                    int iPFF = scVar.pFF();
                    int iSc = this.JPJ.sc();
                    jSONObject2.put("width", iPFF);
                    jSONObject2.put("height", iSc);
                }
                break;
            case 9:
                YIK();
                break;
            case 10:
                Sfl(jSONObject2);
                break;
            case 11:
                wjp(pff.We);
                break;
            case 12:
                jSONObjectSR = this.cvk;
                if (jSONObjectSR != null) {
                    jSONObject2 = jSONObjectSR;
                }
                break;
            case 13:
                this.CYO = true;
                com.bytedance.sdk.openadsdk.We.zY.pFF(this.Xc, this.JoC, 1, (JSONObject) null);
                com.bytedance.sdk.openadsdk.core.pFF.We we2 = this.II;
                if (we2 == null) {
                    com.bytedance.sdk.openadsdk.WH.zY zYVar = this.Ol;
                    if (zYVar == null || (context = this.QLv) == null) {
                        com.bytedance.sdk.openadsdk.We.zY.pFF(this.Xc, this.JoC, -2, (JSONObject) null);
                    } else {
                        zYVar.sc(context, pff.We, this.JoC);
                        com.bytedance.sdk.openadsdk.core.Ql.We.pFF pff2 = this.f28008eo;
                        if (pff2 != null) {
                            pff2.We();
                        }
                    }
                } else {
                    we2.sc(this.Gb);
                }
                break;
            case 14:
                TRI();
                break;
            case 15:
                com.bytedance.sdk.openadsdk.WH.zY zYVar2 = this.Ol;
                if (zYVar2 != null) {
                    zYVar2.sc(pff.We);
                }
                break;
            case 16:
                jSONObjectSR = SR();
                if (jSONObjectSR != null) {
                    jSONObject2 = jSONObjectSR;
                }
                break;
            case 17:
                jSONObject2.put("viewStatus", this.cJ ? 1 : 0);
                break;
            case 18:
                com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.Xc;
                if (sfl != null && !TextUtils.isEmpty(sfl.cJ())) {
                    jSONObject2.put("data", this.Xc.cJ());
                }
                break;
            case 19:
                this.zY = true;
                com.bytedance.sdk.openadsdk.Tf.ExN exN = this.FI;
                if (exN != null) {
                    exN.sc();
                }
                break;
            case 20:
                Xc(pff.We);
                break;
            case 21:
                JSONObject jSONObject4 = this.Dl;
                if (jSONObject4 != null) {
                    jSONObject4.put("setting", Dl());
                    com.bytedance.sdk.openadsdk.core.model.Sfl sfl2 = this.Xc;
                    if (sfl2 != null) {
                        this.Dl.put("extension", sfl2.vl());
                    }
                }
                jSONObject2 = this.Dl;
                break;
            case 23:
                SR(jSONObject2);
                break;
            case 24:
                AudioManager audioManager = (AudioManager) Xc.sc().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
                jSONObject2.put("endcard_mute", audioManager == null || audioManager.getStreamVolume(3) <= 0);
                break;
            case 25:
                wjp();
                break;
            case 26:
                pFF(this.YIK, pff.We);
                break;
            case 27:
                BT(pff.We);
                break;
            case 28:
                com.bytedance.sdk.openadsdk.Tf.We we3 = this.WP;
                if (we3 != null) {
                    we3.sc();
                }
                break;
            case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                Tf(pff.We);
                break;
            case 30:
                sc(pff, jSONObject2);
                break;
            case VungleException.WEB_CRASH /* 31 */:
                WH(jSONObject2);
                break;
            case 32:
                JSONObject jSONObject5 = pff.We;
                if (jSONObject5 != null && (jSONObject = jSONObject5.getJSONObject("extJson")) != null && jSONObject.has("category") && jSONObject.has("tag") && jSONObject.has("label")) {
                    String strOptString = jSONObject.optString("category");
                    String strOptString2 = jSONObject.optString("tag");
                    String strOptString3 = jSONObject.optString("label");
                    long jOptLong = jSONObject5.optLong(AppMeasurementSdk.ConditionalUserProperty.VALUE);
                    long jOptLong2 = jSONObject5.optLong("extValue");
                    try {
                        jSONObject.putOpt("ua_policy", Integer.valueOf(this.BT));
                        break;
                    } catch (Exception unused) {
                    }
                    if ("click".equals(strOptString3)) {
                        jSONObject = Dl(jSONObject);
                    }
                    String strSc = sc(strOptString2, strOptString3);
                    boolean zExN = com.bytedance.sdk.openadsdk.core.model.Xc.ExN(this.Xc);
                    sc(jSONObject, zExN, strOptString3);
                    com.bytedance.sdk.openadsdk.We.zY.sc(this.Xc, strOptString, strSc, strOptString3, jOptLong, jOptLong2, jSONObject, zExN);
                }
                break;
            case 33:
                Sfl();
                break;
            case 34:
                Context context3 = this.QLv;
                if (context3 instanceof com.bytedance.sdk.openadsdk.core.Ql.We.pFF) {
                    ((com.bytedance.sdk.openadsdk.core.Ql.We.pFF) context3).We();
                }
                break;
        }
        if (i11 == 1 && !TextUtils.isEmpty(pff.pFF)) {
            pFF(pff.pFF, jSONObject2);
            if (Ol.pFF().Xc()) {
                StringBuilder sb3 = new StringBuilder("[JSB-RSP] version:");
                sb3.append(i11);
                sb3.append(" data=");
                sb3.append(jSONObject2);
            }
        }
        return jSONObject2;
    }

    @Override // com.bytedance.sdk.component.utils.FI.sc
    public void sc(Message message) {
        if (message != null && message.what == 11) {
            Object obj = message.obj;
            if (obj instanceof pFF) {
                try {
                    sc((pFF) obj, 1);
                } catch (Exception unused) {
                }
            }
        }
    }

    public void sc(sc scVar) {
        this.yL = scVar;
    }

    public void sc(com.bytedance.sdk.openadsdk.core.Ql.We.pFF pff) {
        this.f28008eo = pff;
    }

    @Override // com.bytedance.sdk.component.adexpress.ExN.pFF
    public void sc(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("time");
            String strOptString = jSONObject.optString("flag");
            com.bytedance.sdk.openadsdk.core.Qj.SR sr2 = this.YIK;
            if (sr2 != null) {
                sr2.sc(iOptInt, strOptString);
            }
        } catch (JSONException unused) {
            com.bytedance.sdk.component.utils.Tf.sc("TTAD.AndroidObject", "requestPauseVideo json exception");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.WH.pFF
    public void sc(String str, JSONObject jSONObject) {
        zY(str, jSONObject);
    }

    @JProtect
    public void sc(JSONObject jSONObject, final com.bytedance.sdk.openadsdk.Tf.zY zYVar) {
        if (zYVar == null) {
            return;
        }
        try {
            final com.bytedance.sdk.openadsdk.Tf.zY zYVar2 = new com.bytedance.sdk.openadsdk.Tf.zY() { // from class: com.bytedance.sdk.openadsdk.core.HJN.7
                @Override // com.bytedance.sdk.openadsdk.Tf.zY
                public void sc(final boolean z11, final List<com.bytedance.sdk.openadsdk.core.model.Sfl> list) {
                    com.bytedance.sdk.openadsdk.utils.Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.HJN.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            zYVar.sc(z11, list);
                        }
                    });
                }
            };
            if (this.Xc != null && !TextUtils.isEmpty(this.Tf)) {
                int iQY = this.Xc.qY();
                AdSlot adSlotCb = this.Xc.Cb();
                com.bytedance.sdk.openadsdk.core.model.Dl dl2 = new com.bytedance.sdk.openadsdk.core.model.Dl();
                dl2.TRI = true;
                if (this.Xc.JoC() != null || this.Xc.qKn() != null) {
                    dl2.Qj = 2;
                }
                JSONObject jSONObject2 = this.wjp;
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                if (jSONObject != null) {
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObject2.put(next, jSONObject.opt(next));
                    }
                }
                dl2.f28375qr = jSONObject2;
                Xc.zY().sc(adSlotCb, dl2, iQY, new Sfl.sc() { // from class: com.bytedance.sdk.openadsdk.core.HJN.8
                    @Override // com.bytedance.sdk.openadsdk.core.Sfl.sc
                    public void sc(int i11, String str) {
                        zYVar2.sc(false, null);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.Sfl.sc
                    public void sc(com.bytedance.sdk.openadsdk.core.model.sc scVar, com.bytedance.sdk.openadsdk.core.model.pFF pff) {
                        if (scVar.We() == null || scVar.We().isEmpty()) {
                            zYVar2.sc(false, null);
                            pff.sc(-3);
                            com.bytedance.sdk.openadsdk.core.model.pFF.sc(pff);
                        } else {
                            com.bytedance.sdk.openadsdk.core.model.Sfl sfl = scVar.We().get(0);
                            if (sfl != null) {
                                HJN.this.wjp = sfl.Mrq();
                            }
                            zYVar2.sc(true, scVar.We());
                        }
                    }
                });
                return;
            }
            zYVar2.sc(false, null);
        } catch (Exception e11) {
            com.bytedance.sdk.component.utils.Tf.sc("TTAD.AndroidObject", "get ads error", e11);
        }
    }

    public void sc(JSONObject jSONObject, String str) {
        com.bytedance.sdk.openadsdk.core.Qj.SR sr2 = this.YIK;
        if (sr2 != null) {
            sr2.sc(str, jSONObject);
        }
    }

    public boolean sc(Uri uri) {
        if (uri == null) {
            return false;
        }
        try {
            if (!"bytedance".equals(uri.getScheme())) {
                return false;
            }
            if (Qj.containsKey(uri.getHost())) {
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.adexpress.ExN.pFF
    @JavascriptInterface
    public void skipVideo() {
        com.bytedance.sdk.openadsdk.utils.Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.HJN.4
            @Override // java.lang.Runnable
            public void run() {
                HJN.this.Sfl();
            }
        });
    }

    public HJN zY(String str) {
        this.WH = str;
        return this;
    }

    public com.bytedance.sdk.openadsdk.core.model.Sfl zY() {
        return this.Xc;
    }

    public void zY(int i11) {
        com.bytedance.sdk.openadsdk.core.Qj.SR sr2 = this.YIK;
        if (sr2 != null) {
            sr2.pFF(i11);
        }
    }

    public void zY(JSONObject jSONObject) {
        wjp.sc(dE(), this.QLv instanceof Activity, jSONObject, this.Xc, this.JoC, this.Ql, Ql(), this.f28010qr);
    }

    public void zY(boolean z11) {
        this.zY = z11;
    }
}
