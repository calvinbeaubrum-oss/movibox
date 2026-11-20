package com.bytedance.sdk.openadsdk.We;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.hisavana.common.tracking.TrackingKey;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Xc implements com.bytedance.sdk.openadsdk.We.We.ExN {
    private Boolean ExN;
    private JSONArray Qj;
    private JSONObject TRI;
    private Boolean We;
    private Sfl pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private JSONArray f27339qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private String f27340sc;
    private Boolean zY;

    public Xc() {
        this.f27340sc = "embeded_ad";
        Boolean bool = Boolean.FALSE;
        this.zY = bool;
        this.We = bool;
        this.ExN = bool;
    }

    public Xc(int i11, String str, Sfl sfl) {
        Boolean bool = Boolean.FALSE;
        this.zY = bool;
        this.We = bool;
        this.ExN = bool;
        this.f27340sc = str;
        this.pFF = sfl;
        this.TRI = new JSONObject();
        this.f27339qr = new JSONArray();
        this.Qj = new JSONArray();
        sc(this.TRI, "webview_source", Integer.valueOf(i11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Xc() {
        if (this.ExN.booleanValue()) {
            return true;
        }
        return this.We.booleanValue() && this.zY.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(JSONArray jSONArray, Object obj) {
        if (jSONArray == null || jSONArray.length() >= 10) {
            return;
        }
        try {
            jSONArray.put(obj);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(JSONObject jSONObject, String str, Object obj) {
        sc(jSONObject, str, obj, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(JSONObject jSONObject, String str, Object obj, boolean z11) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (!z11) {
            try {
                if (jSONObject.has(str)) {
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
        jSONObject.put(str, obj);
    }

    @Override // com.bytedance.sdk.openadsdk.We.We.We
    public void BT() {
        com.bytedance.sdk.component.utils.qr.sc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.We.Xc.16
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                Xc.this.sc(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                Xc xc2 = Xc.this;
                xc2.sc(xc2.TRI, "render_failed", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.We.We.TRI
    public void ExN() {
        com.bytedance.sdk.component.utils.qr.sc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.We.Xc.27
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                Xc.this.sc(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                Xc xc2 = Xc.this;
                xc2.sc(xc2.TRI, "webview_load_start", (Object) jSONObject, false);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.We.We.sc
    public void ExN(final String str) {
        try {
            com.bytedance.sdk.component.utils.qr.sc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.We.Xc.19
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    Xc.this.sc(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    Xc xc2 = Xc.this;
                    xc2.sc(xc2.TRI, str, jSONObject);
                }
            });
        } catch (Throwable th2) {
            th2.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.We.We.zY
    public void Ol() {
        com.bytedance.sdk.component.utils.qr.sc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.We.Xc.3
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                Xc.this.sc(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                Xc.this.sc(jSONObject, "type", "native_enterBackground");
                Xc xc2 = Xc.this;
                xc2.sc(xc2.f27339qr, jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.We.We.zY
    public void Qj() {
        com.bytedance.sdk.component.utils.qr.sc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.We.Xc.2
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                Xc.this.sc(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                Xc xc2 = Xc.this;
                xc2.sc(xc2.TRI, "native_endcard_close", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.We.We.pFF
    public void Ql() {
        com.bytedance.sdk.component.utils.qr.sc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.We.Xc.14
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                Xc.this.sc(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                Xc xc2 = Xc.this;
                xc2.sc(xc2.TRI, "native_render_end", jSONObject);
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                JSONObject jSONObject2 = new JSONObject();
                Xc.this.sc(jSONObject2, "ts", Long.valueOf(jCurrentTimeMillis2));
                Xc xc3 = Xc.this;
                xc3.sc(xc3.TRI, "render_success", jSONObject2);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.We.We.pFF
    public void SR() {
        com.bytedance.sdk.component.utils.qr.sc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.We.Xc.15
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                Xc.this.sc(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                Xc xc2 = Xc.this;
                xc2.sc(xc2.TRI, "no_native_render", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.We.We.TRI
    public void TRI() {
        com.bytedance.sdk.component.utils.qr.sc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.We.Xc.28
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                Xc.this.sc(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                Xc xc2 = Xc.this;
                xc2.sc(xc2.TRI, "webview_load_success", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.We.We.sc
    public void TRI(final String str) {
        try {
            com.bytedance.sdk.component.utils.qr.sc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.We.Xc.20
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    Xc.this.sc(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    Xc xc2 = Xc.this;
                    xc2.sc(xc2.TRI, str, jSONObject);
                }
            });
        } catch (Throwable th2) {
            th2.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.We.We.ExN
    public void Tf() {
        com.bytedance.sdk.component.utils.qr.sc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.We.Xc.10
            @Override // java.lang.Runnable
            public void run() {
                if (Xc.this.Xc()) {
                    if (Xc.this.f27339qr != null && Xc.this.f27339qr.length() != 0) {
                        try {
                            Xc.this.TRI.put("native_switchBackgroundAndForeground", Xc.this.f27339qr);
                        } catch (Exception unused) {
                        }
                    }
                    if (Xc.this.Qj != null && Xc.this.Qj.length() != 0) {
                        try {
                            Xc.this.TRI.put("intercept_source", Xc.this.Qj);
                        } catch (Exception unused2) {
                        }
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("webview_time_track", Xc.this.TRI);
                    } catch (JSONException e11) {
                        com.bytedance.sdk.component.utils.Tf.sc("WebviewTimeTrack", "trySendTrackInfo json error", e11);
                    }
                    if (com.bytedance.sdk.openadsdk.core.Ol.pFF().Xc() && Xc.this.TRI != null) {
                        JSONObject unused3 = Xc.this.TRI;
                    }
                    zY.pFF(Xc.this.pFF, Xc.this.f27340sc, "webview_time_track", jSONObject);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.We.We.ExN
    public void UFX() {
        this.zY = Boolean.TRUE;
    }

    @Override // com.bytedance.sdk.openadsdk.We.We.zY
    public void WH() {
        com.bytedance.sdk.component.utils.qr.sc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.We.Xc.4
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                Xc.this.sc(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                Xc.this.sc(jSONObject, "type", "native_enterForeground");
                Xc xc2 = Xc.this;
                xc2.sc(xc2.f27339qr, jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.We.We.zY
    public void We() {
        com.bytedance.sdk.component.utils.qr.sc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.We.Xc.26
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                Xc.this.sc(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                Xc xc2 = Xc.this;
                xc2.sc(xc2.TRI, "native_render_end", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.We.We.sc
    public void We(final String str) {
        com.bytedance.sdk.component.utils.qr.sc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.We.Xc.18
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                Xc.this.sc(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                Xc xc2 = Xc.this;
                xc2.sc(xc2.TRI, str, jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.We.We.We
    public void dE() {
        try {
            com.bytedance.sdk.component.utils.qr.sc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.We.Xc.17
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    Xc.this.sc(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    Xc xc2 = Xc.this;
                    xc2.sc(xc2.TRI, "render_did_finish", jSONObject);
                }
            });
        } catch (Throwable th2) {
            th2.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.We.We.We
    public void pFF() {
        com.bytedance.sdk.component.utils.qr.sc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.We.Xc.12
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                Xc.this.sc(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                Xc xc2 = Xc.this;
                xc2.sc(xc2.TRI, "render_success", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.We.We.sc
    public void pFF(final int i11, final String str) {
        com.bytedance.sdk.component.utils.qr.sc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.We.Xc.13
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                Xc.this.sc(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                Xc.this.sc(jSONObject, TrackingKey.CODE, Integer.valueOf(i11));
                Xc xc2 = Xc.this;
                xc2.sc(xc2.TRI, str, jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.We.We.TRI
    public void pFF(final String str) {
        com.bytedance.sdk.component.utils.qr.sc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.We.Xc.8
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                Xc.this.sc(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                Xc.this.sc(jSONObject, "jsb", str);
                Xc xc2 = Xc.this;
                xc2.sc(xc2.TRI, "webview_jsb_end", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.We.We.TRI
    public void pFF(final String str, final long j11, final long j12, final int i11) {
        com.bytedance.sdk.component.utils.qr.sc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.We.Xc.6
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(str) || j12 < j11) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                Xc.this.sc(jSONObject, "start_ts", Long.valueOf(j11));
                Xc.this.sc(jSONObject, "end_ts", Long.valueOf(j12));
                Xc.this.sc(jSONObject, "intercept_type", Integer.valueOf(i11));
                Xc.this.sc(jSONObject, "type", "intercept_js");
                Xc.this.sc(jSONObject, "url", str);
                Xc.this.sc(jSONObject, "duration", Long.valueOf(j12 - j11));
                Xc xc2 = Xc.this;
                xc2.sc(xc2.Qj, jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.We.We.TRI
    public void pFF(final JSONObject jSONObject) {
        com.bytedance.sdk.component.utils.qr.sc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.We.Xc.9
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject2;
                if (Xc.this.TRI == null || (jSONObject2 = jSONObject) == null) {
                    return;
                }
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    Xc xc2 = Xc.this;
                    xc2.sc(xc2.TRI, next, jSONObject.opt(next));
                }
                Xc.this.We = Boolean.TRUE;
                Xc.this.Tf();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.We.We.zY
    public void qr() {
        com.bytedance.sdk.component.utils.qr.sc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.We.Xc.30
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                Xc.this.sc(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                Xc xc2 = Xc.this;
                xc2.sc(xc2.TRI, "native_endcard_show", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.We.We.sc
    public void qr(final String str) {
        com.bytedance.sdk.component.utils.qr.sc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.We.Xc.22
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                Xc.this.sc(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                Xc xc2 = Xc.this;
                xc2.sc(xc2.TRI, str, jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.We.We.We
    public void sc() {
        com.bytedance.sdk.component.utils.qr.sc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.We.Xc.1
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                Xc.this.sc(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                Xc xc2 = Xc.this;
                xc2.sc(jSONObject, "render_sequence", Integer.valueOf(xc2.pFF.cvk()));
                if (Xc.this.pFF != null) {
                    if (Xc.this.pFF.JoC() != null) {
                        if (Xc.this.pFF.JoC().SR()) {
                            Xc.this.sc(jSONObject, "webview_count", Integer.valueOf(com.bytedance.sdk.component.adexpress.ExN.ExN.sc().We()));
                            Xc.this.sc(jSONObject, "available_cache_count", Integer.valueOf(com.bytedance.sdk.component.adexpress.ExN.ExN.sc().We()));
                        } else {
                            Xc.this.sc(jSONObject, "webview_count", Integer.valueOf(com.bytedance.sdk.component.adexpress.ExN.ExN.sc().zY()));
                            Xc.this.sc(jSONObject, "available_cache_count", Integer.valueOf(com.bytedance.sdk.component.adexpress.ExN.ExN.sc().zY()));
                        }
                    } else if (Xc.this.pFF.qKn() != null) {
                        Xc.this.sc(jSONObject, "webview_count", Integer.valueOf(com.bytedance.sdk.component.adexpress.ExN.ExN.sc().We()));
                        Xc.this.sc(jSONObject, "available_cache_count", Integer.valueOf(com.bytedance.sdk.component.adexpress.ExN.ExN.sc().We()));
                    }
                }
                Xc xc3 = Xc.this;
                xc3.sc(xc3.TRI, "render_start", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.We.We.TRI
    public void sc(final int i11) {
        com.bytedance.sdk.component.utils.qr.sc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.We.Xc.24
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                Xc.this.sc(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                Xc.this.sc(jSONObject, "isWebViewCache", Integer.valueOf(i11));
                if (Xc.this.pFF != null) {
                    if (Xc.this.pFF.CYO()) {
                        Xc.this.sc(jSONObject, "engine_version", "v3");
                    } else {
                        Xc.this.sc(jSONObject, "engine_version", "v1");
                    }
                }
                Xc xc2 = Xc.this;
                xc2.sc(xc2.TRI, "before_webview_request", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.We.We.We
    public void sc(final int i11, final String str) {
        com.bytedance.sdk.component.utils.qr.sc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.We.Xc.23
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                Xc.this.sc(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                Xc.this.sc(jSONObject, TrackingKey.CODE, Integer.valueOf(i11));
                String str2 = str;
                if (str2 != null) {
                    Xc.this.sc(jSONObject, "reason", str2);
                }
                Xc xc2 = Xc.this;
                xc2.sc(xc2.TRI, "render_error", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.We.We.TRI
    public void sc(final String str) {
        com.bytedance.sdk.component.utils.qr.sc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.We.Xc.7
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                Xc.this.sc(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                Xc.this.sc(jSONObject, "jsb", str);
                Xc xc2 = Xc.this;
                xc2.sc(xc2.TRI, "webview_jsb_start", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.We.We.TRI
    public void sc(final String str, final long j11, final long j12, final int i11) {
        com.bytedance.sdk.component.utils.qr.sc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.We.Xc.5
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(str) || j12 < j11) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                Xc.this.sc(jSONObject, "start_ts", Long.valueOf(j11));
                Xc.this.sc(jSONObject, "end_ts", Long.valueOf(j12));
                Xc.this.sc(jSONObject, "intercept_type", Integer.valueOf(i11));
                Xc.this.sc(jSONObject, "type", "intercept_html");
                Xc.this.sc(jSONObject, "url", str);
                Xc.this.sc(jSONObject, "duration", Long.valueOf(j12 - j11));
                Xc xc2 = Xc.this;
                xc2.sc(xc2.Qj, jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.We.We.TRI
    public void sc(final JSONObject jSONObject) {
        com.bytedance.sdk.component.utils.qr.sc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.We.Xc.29
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject2 = jSONObject;
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                Xc.this.sc(jSONObject2, "ts", Long.valueOf(System.currentTimeMillis()));
                Xc xc2 = Xc.this;
                xc2.sc(xc2.TRI, "webview_load_error", jSONObject2);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.We.We.ExN
    public void sc(boolean z11) {
        this.ExN = Boolean.valueOf(z11);
    }

    @Override // com.bytedance.sdk.openadsdk.We.We.pFF
    public void zY() {
        com.bytedance.sdk.component.utils.qr.sc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.We.Xc.25
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                Xc.this.sc(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                Xc xc2 = Xc.this;
                xc2.sc(xc2.TRI, "native_render_start", jSONObject);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.We.We.sc
    public void zY(final int i11, final String str) {
        try {
            com.bytedance.sdk.component.utils.qr.sc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.We.Xc.21
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    Xc.this.sc(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    Xc.this.sc(jSONObject, TrackingKey.CODE, Integer.valueOf(i11));
                    Xc xc2 = Xc.this;
                    xc2.sc(xc2.TRI, str, jSONObject);
                }
            });
        } catch (Throwable th2) {
            th2.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.We.We.sc
    public void zY(final String str) {
        com.bytedance.sdk.component.utils.qr.sc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.We.Xc.11
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                Xc.this.sc(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                Xc xc2 = Xc.this;
                xc2.sc(xc2.TRI, str, jSONObject);
            }
        });
    }
}
