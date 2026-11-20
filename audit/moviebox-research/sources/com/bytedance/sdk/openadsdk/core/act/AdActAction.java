package com.bytedance.sdk.openadsdk.core.act;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.c;
import androidx.browser.customtabs.j;
import androidx.browser.customtabs.l;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.core.Ol;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.model.WH;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.bytedance.sdk.openadsdk.utils.kX;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class AdActAction {
    private Long BT;
    private String ExN;
    private ActServiceConnection Qj;
    private String We;
    private BindCustomTabsServiceCallback dE;
    private Context pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private j f28355qr;
    private Sfl zY;
    private CustomTabsClient TRI = null;
    private boolean Ol = false;
    private boolean WH = false;
    private boolean UFX = false;
    private boolean Tf = false;
    private boolean Ql = false;
    private long SR = 0;
    private pFF Xc = new pFF() { // from class: com.bytedance.sdk.openadsdk.core.act.AdActAction.1
        @Override // com.bytedance.sdk.openadsdk.core.act.pFF
        public void sc() {
            AdActAction.this.TRI = null;
            AdActAction.this.Qj = null;
            AdActAction.this.f28355qr = null;
        }

        @Override // com.bytedance.sdk.openadsdk.core.act.pFF
        public void sc(final CustomTabsClient customTabsClient) {
            if (Cb.ExN()) {
                AdActAction.this.sc(customTabsClient);
            } else {
                Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.act.AdActAction.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AdActAction.this.sc(customTabsClient);
                    }
                });
            }
        }
    };

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public l f28356sc = new PAGEngagementSignalsCallback();
    private c wjp = new PAGCustomTabsCallback();

    /* JADX INFO: compiled from: source.java */
    public interface BindCustomTabsServiceCallback {
        void onBindFail(int i11, String str);

        void onBindSuccess(j jVar);
    }

    /* JADX INFO: compiled from: source.java */
    public class PAGCustomTabsCallback extends c {
        public PAGCustomTabsCallback() {
        }

        @Override // androidx.browser.customtabs.c
        public void onNavigationEvent(int i11, @Nullable Bundle bundle) {
            if (i11 == 1) {
                AdActAction.this.BT = Long.valueOf(SystemClock.elapsedRealtime());
                if (AdActAction.this.Tf || AdActAction.this.zY == null) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("render_type", "h5");
                    jSONObject.putOpt("render_type_2", 0);
                    AdActAction.this.sc("load_start", jSONObject, 0L);
                    AdActAction.this.Tf = true;
                    return;
                } catch (Throwable th2) {
                    Tf.sc("AdActAction", th2.getMessage());
                    return;
                }
            }
            if (i11 == 2) {
                if (AdActAction.this.WH || AdActAction.this.BT == null || AdActAction.this.zY == null) {
                    return;
                }
                long jLongValue = AdActAction.this.BT.longValue() - SystemClock.elapsedRealtime();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("first_page", true);
                    jSONObject2.putOpt("render_type", "h5");
                    jSONObject2.putOpt("render_type_2", 0);
                    jSONObject2.put("url", AdActAction.this.ExN);
                    jSONObject2.put("preload_h5_type", AdActAction.this.zY.Ay());
                    AdActAction.this.sc("load_finish", jSONObject2, jLongValue);
                    AdActAction.this.WH = true;
                    return;
                } catch (Throwable th3) {
                    Tf.sc("AdActAction", th3.getMessage());
                    return;
                }
            }
            if (i11 != 3) {
                if (i11 != 6) {
                    return;
                }
                AdActAction.this.sc();
                if (AdActAction.this.Ql || AdActAction.this.zY == null || AdActAction.this.UFX || AdActAction.this.WH || AdActAction.this.BT == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.We.zY.sc(AdActAction.this.zY, cJ.sc(AdActAction.this.zY), SystemClock.elapsedRealtime() - AdActAction.this.BT.longValue(), 0, 1);
                return;
            }
            if (AdActAction.this.UFX || AdActAction.this.zY == null) {
                return;
            }
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.putOpt("render_type", "h5");
                jSONObject3.putOpt("render_type_2", 0);
                jSONObject3.put("url", AdActAction.this.ExN);
                jSONObject3.put("preload_h5_type", AdActAction.this.zY.Ay());
                AdActAction.this.sc("load_fail", jSONObject3, 0L);
                AdActAction.this.UFX = true;
            } catch (Throwable th4) {
                Tf.sc("AdActAction", th4.getMessage());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class PAGEngagementSignalsCallback implements l {
        public PAGEngagementSignalsCallback() {
        }

        @Override // androidx.browser.customtabs.l
        public void onGreatestScrollPercentageIncreased(int i11, @NonNull Bundle bundle) {
        }

        @Override // androidx.browser.customtabs.l
        public void onSessionEnded(boolean z11, @NonNull Bundle bundle) {
        }

        @Override // androidx.browser.customtabs.l
        public void onVerticalScrollEvent(boolean z11, @NonNull Bundle bundle) {
            AdActAction.this.SR = System.currentTimeMillis();
            if (AdActAction.this.zY == null || AdActAction.this.Ol) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", AdActAction.this.ExN);
                jSONObject.put("down_time", AdActAction.this.SR);
                long jCurrentTimeMillis = System.currentTimeMillis();
                jSONObject.put("up_time", jCurrentTimeMillis);
                com.bytedance.sdk.openadsdk.We.zY.pFF(AdActAction.this.zY, cJ.sc(AdActAction.this.zY), "in_web_click", jSONObject, jCurrentTimeMillis - AdActAction.this.SR);
            } catch (Throwable th2) {
                Tf.sc("AdActAction", th2.getMessage());
            }
            if (!TextUtils.isEmpty(Sfl.sc(AdActAction.this.pFF, AdActAction.this.zY))) {
                com.bytedance.sdk.openadsdk.We.zY.sc("click", AdActAction.this.zY, new WH.sc().pFF(AdActAction.this.SR).sc(System.currentTimeMillis()).pFF(Ol.pFF().sc() ? 1 : 2).zY(kX.qr(AdActAction.this.pFF)).sc(kX.ExN(AdActAction.this.pFF)).pFF(kX.TRI(AdActAction.this.pFF)).sc(), cJ.sc(AdActAction.this.zY), true, (Map<String, Object>) new HashMap(), 2);
            }
            AdActAction.this.Ol = true;
        }
    }

    public AdActAction(Context context, Sfl sfl, String str, String str2) {
        this.pFF = context;
        this.zY = sfl;
        this.We = str;
        this.ExN = str2;
    }

    private com.bytedance.sdk.openadsdk.SR.sc.pFF sc(int i11) {
        com.bytedance.sdk.openadsdk.SR.sc.pFF pff = new com.bytedance.sdk.openadsdk.SR.sc.pFF();
        pff.sc(this.We);
        pff.sc(this.zY);
        pff.pFF(cJ.sc(this.zY));
        pff.sc(i11);
        pff.sc(false);
        pff.pFF(8);
        return pff;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc() {
        try {
            ActServiceConnection actServiceConnection = this.Qj;
            if (actServiceConnection == null) {
                return;
            }
            this.pFF.unbindService(actServiceConnection);
            this.TRI = null;
            this.f28355qr = null;
            this.Qj = null;
        } catch (Throwable th2) {
            Tf.sc("AdActAction", th2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(CustomTabsClient customTabsClient) {
        this.TRI = customTabsClient;
        this.f28355qr = customTabsClient.e(this.wjp);
        com.bytedance.sdk.openadsdk.SR.sc.pFF pffSc = sc(9);
        try {
            j jVar = this.f28355qr;
            Bundle bundle = Bundle.EMPTY;
            if (jVar.h(bundle)) {
                boolean zM = this.f28355qr.m(this.f28356sc, bundle);
                pffSc.zY(1);
                sc.sc(1);
                if (zM) {
                    pffSc.We(1);
                    sc.pFF(1);
                } else {
                    sc.pFF(0);
                }
            } else {
                pffSc.zY(0);
                sc.sc(0);
            }
            com.bytedance.sdk.openadsdk.We.zY.sc(pffSc);
            BindCustomTabsServiceCallback bindCustomTabsServiceCallback = this.dE;
            if (bindCustomTabsServiceCallback != null) {
                bindCustomTabsServiceCallback.onBindSuccess(this.f28355qr);
            }
        } catch (Throwable th2) {
            BindCustomTabsServiceCallback bindCustomTabsServiceCallback2 = this.dE;
            if (bindCustomTabsServiceCallback2 != null) {
                bindCustomTabsServiceCallback2.onBindFail(11, th2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(String str, final JSONObject jSONObject, final long j11) {
        if (this.zY == null || TextUtils.isEmpty(str)) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Sfl sfl = this.zY;
        com.bytedance.sdk.openadsdk.We.zY.sc(jCurrentTimeMillis, sfl, cJ.sc(sfl), str, new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.core.act.AdActAction.2
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject2;
                Throwable th2;
                try {
                    jSONObject.put("is_playable", JPJ.pFF(AdActAction.this.zY) ? 1 : 0);
                    jSONObject.put("usecache", com.bytedance.sdk.openadsdk.core.Ql.zY.sc.sc().sc(AdActAction.this.zY) ? 1 : 0);
                    jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("ad_extra_data", jSONObject.toString());
                        long j12 = j11;
                        if (j12 > 0) {
                            jSONObject2.put("duration", j12);
                        }
                    } catch (Throwable th3) {
                        th2 = th3;
                        Tf.sc("AdActAction", th2.getMessage());
                    }
                } catch (Throwable th4) {
                    jSONObject2 = null;
                    th2 = th4;
                }
                return jSONObject2;
            }
        });
    }

    public void sc(BindCustomTabsServiceCallback bindCustomTabsServiceCallback) {
        this.dE = bindCustomTabsServiceCallback;
        if (this.pFF == null || this.zY == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.We.zY.sc(sc(8));
            String strSc = sc.sc(this.pFF);
            if (strSc == null) {
                return;
            }
            ActServiceConnection actServiceConnection = new ActServiceConnection(this.Xc);
            this.Qj = actServiceConnection;
            CustomTabsClient.a(this.pFF, strSc, actServiceConnection);
        } catch (Throwable th2) {
            String message = th2.getMessage();
            Tf.sc("AdActAction", message);
            BindCustomTabsServiceCallback bindCustomTabsServiceCallback2 = this.dE;
            if (bindCustomTabsServiceCallback2 != null) {
                bindCustomTabsServiceCallback2.onBindFail(10, message);
            }
        }
    }
}
