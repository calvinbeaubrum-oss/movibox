package com.bytedance.sdk.openadsdk.core.Ol;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.SR.sc.We;
import com.bytedance.sdk.openadsdk.core.Ol;
import com.bytedance.sdk.openadsdk.core.SR;
import com.bytedance.sdk.openadsdk.core.Tf;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.utils.Dl;
import com.pgl.ssdk.ces.out.PglSSConfig;
import com.pgl.ssdk.ces.out.PglSSManager;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
class sc {
    private volatile boolean pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private PglSSManager f28036sc;
    private volatile boolean zY = true;
    private volatile boolean We = false;

    public sc() {
        sc();
    }

    private void Ol() {
        if (this.f28036sc == null) {
            this.f28036sc = PglSSManager.getInstance();
        }
    }

    private boolean Qj() {
        if (!this.pFF && this.zY) {
            sc();
        }
        return this.pFF;
    }

    private Class WH() {
        Class<PglSSManager> cls;
        try {
            cls = PglSSManager.class;
            String str = PglSSManager.REPORT_SCENE_ADSHOW;
            try {
                this.zY = true;
            } catch (Throwable unused) {
                this.zY = false;
            }
        } catch (Throwable unused2) {
            cls = null;
        }
        return cls;
    }

    private void zY(final String str) {
        if (this.We || TextUtils.isEmpty(str)) {
            return;
        }
        Xc.ExN().sc(new com.bytedance.sdk.openadsdk.SR.pFF() { // from class: com.bytedance.sdk.openadsdk.core.Ol.sc.2
            @Override // com.bytedance.sdk.openadsdk.SR.pFF
            public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                return We.pFF().sc("secsdk_init_error").pFF(str);
            }
        }, false);
        this.We = true;
    }

    public String ExN() {
        if (!Qj()) {
            return "";
        }
        Ol();
        PglSSManager pglSSManager = this.f28036sc;
        return pglSSManager != null ? pglSSManager.getSofChara() : "";
    }

    public long TRI() {
        if (!Qj()) {
            return 0L;
        }
        Ol();
        PglSSManager pglSSManager = this.f28036sc;
        if (pglSSManager != null) {
            return pglSSManager.getECForBidding();
        }
        return 0L;
    }

    public String We() {
        if (!Qj()) {
            return "";
        }
        Ol();
        PglSSManager pglSSManager = this.f28036sc;
        return pglSSManager != null ? pglSSManager.getToken() : "";
    }

    public void pFF(String str) {
        if (Qj()) {
            Ol();
            PglSSManager pglSSManager = this.f28036sc;
            if (pglSSManager != null) {
                pglSSManager.setDeviceId(str);
            }
        }
    }

    public boolean pFF() {
        return this.pFF;
    }

    public int qr() {
        if (this.zY) {
            return PglSSManager.getInitStatus();
        }
        return 5;
    }

    public Map<String, String> sc(String str, byte[] bArr) {
        Map<String, String> featureHash;
        return (!Qj() || (featureHash = this.f28036sc.getFeatureHash(str, bArr)) == null) ? new HashMap() : featureHash;
    }

    public synchronized void sc() {
        if (!this.pFF) {
            try {
                Context contextSc = Xc.sc();
                String strWe = Ol.pFF().We();
                if (TextUtils.isEmpty(strWe)) {
                    strWe = Ol.sc("app_id", Long.MAX_VALUE);
                }
                if (TextUtils.isEmpty(strWe)) {
                    return;
                }
                PglSSManager.init(contextSc, PglSSConfig.builder().setAppId(strWe).setOVRegionType(0).setAdsdkVersion(BuildConfig.VERSION_NAME).build(), null, null, Tf.sc(contextSc), com.bytedance.sdk.openadsdk.wjp.sc.pFF.sc.sc().pFF());
                Ol();
                this.pFF = true;
            } catch (Throwable unused) {
                WH();
                this.pFF = false;
            }
            try {
                if (this.zY) {
                    zY(PglSSManager.getLoadError());
                }
            } catch (Throwable th2) {
                Dl.pFF("mssdk", th2.getMessage());
            }
        }
    }

    public void sc(MotionEvent motionEvent) {
        if (pFF()) {
            Ol();
            PglSSManager pglSSManager = this.f28036sc;
            if (pglSSManager != null) {
                pglSSManager.checkEventVirtual(motionEvent);
            }
        }
    }

    public void sc(String str) {
        if (Qj()) {
            Ol();
            PglSSManager pglSSManager = this.f28036sc;
            if (pglSSManager != null) {
                pglSSManager.setGaid(str);
            }
        }
    }

    public void sc(String str, Map<String, Object> map) {
        if (Qj()) {
            Ol();
            PglSSManager pglSSManager = this.f28036sc;
            if (pglSSManager != null) {
                pglSSManager.reportNow(str, map);
            }
        }
    }

    public void zY() {
        if (Qj()) {
            Ol();
            if (this.f28036sc != null) {
                SR.pFF().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Ol.sc.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            HashMap map = new HashMap();
                            map.put(PglSSConfig.CUSTOMINFO_KEY_CHECKCLAZZ, Xc.We().TpG());
                            sc.this.f28036sc.setCustomInfo(map);
                        } catch (Throwable th2) {
                            Dl.pFF("MSSdkImpl", "setCustomInfo", th2.getMessage());
                        }
                    }
                });
            }
        }
    }
}
