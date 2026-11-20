package com.bytedance.sdk.openadsdk.core;

import android.os.Build;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import com.hisavana.common.constant.ComConstants;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class uEA {
    private static final AtomicInteger We;
    private static final AtomicInteger pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static final AtomicInteger f28523sc;
    private static final AtomicInteger zY;

    static {
        AtomicInteger atomicInteger = new AtomicInteger();
        f28523sc = atomicInteger;
        AtomicInteger atomicInteger2 = new AtomicInteger();
        pFF = atomicInteger2;
        AtomicInteger atomicInteger3 = new AtomicInteger();
        zY = atomicInteger3;
        AtomicInteger atomicInteger4 = new AtomicInteger();
        We = atomicInteger4;
        atomicInteger.addAndGet(com.bytedance.sdk.openadsdk.multipro.We.We.sc("encrypt_statistics_file", "encrypt_success_count", 0));
        atomicInteger2.addAndGet(com.bytedance.sdk.openadsdk.multipro.We.We.sc("encrypt_statistics_file", "encrypt_fail_count", 0));
        atomicInteger3.addAndGet(com.bytedance.sdk.openadsdk.multipro.We.We.sc("encrypt_statistics_file", "decrypt_success_count", 0));
        atomicInteger4.addAndGet(com.bytedance.sdk.openadsdk.multipro.We.We.sc("encrypt_statistics_file", "decrypt_fail_count", 0));
    }

    private static void pFF() {
        final int i11 = f28523sc.get();
        final int i12 = pFF.get();
        final int i13 = zY.get();
        final int i14 = We.get();
        com.bytedance.sdk.openadsdk.SR.zY.sc("crypt_v4_statistics", false, new com.bytedance.sdk.openadsdk.SR.pFF() { // from class: com.bytedance.sdk.openadsdk.core.uEA.1
            @Override // com.bytedance.sdk.openadsdk.SR.pFF
            @Nullable
            public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("encrypt_success_count", i11);
                    jSONObject.put("encrypt_fail_count", i12);
                    jSONObject.put("decrypt_success_count", i13);
                    jSONObject.put("decrypt_fail_count", i14);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.SR.sc.We.pFF().sc("crypt_v4_statistics").pFF(jSONObject.toString());
            }
        });
    }

    public static synchronized void pFF(boolean z11) {
        try {
            if (z11) {
                com.bytedance.sdk.openadsdk.multipro.We.We.sc("encrypt_statistics_file", "encrypt_success_count", Integer.valueOf(f28523sc.incrementAndGet()));
            } else {
                com.bytedance.sdk.openadsdk.multipro.We.We.sc("encrypt_statistics_file", "encrypt_fail_count", Integer.valueOf(pFF.incrementAndGet()));
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static void sc() {
        try {
            long jSc = com.bytedance.sdk.openadsdk.multipro.We.We.sc("encrypt_statistics_file", "upload_time_key", 0L);
            if (jSc <= 0 || System.currentTimeMillis() - jSc < ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED) {
                if (jSc <= 0 || jSc > System.currentTimeMillis()) {
                    com.bytedance.sdk.openadsdk.multipro.We.We.sc("encrypt_statistics_file", "upload_time_key", Long.valueOf(System.currentTimeMillis()));
                    return;
                }
                return;
            }
            pFF();
            synchronized (uEA.class) {
                f28523sc.set(0);
                pFF.set(0);
                zY.set(0);
                We.set(0);
                com.bytedance.sdk.openadsdk.multipro.We.We.sc("encrypt_statistics_file");
                com.bytedance.sdk.openadsdk.multipro.We.We.sc("encrypt_statistics_file", "upload_time_key", Long.valueOf(System.currentTimeMillis()));
            }
        } catch (Throwable unused) {
        }
    }

    public static void sc(final int i11, final PangleEncryptConstant.CryptDataScene cryptDataScene, final int i12) {
        com.bytedance.sdk.openadsdk.SR.zY.sc("crypt_v4_fail", false, new com.bytedance.sdk.openadsdk.SR.pFF() { // from class: com.bytedance.sdk.openadsdk.core.uEA.2
            @Override // com.bytedance.sdk.openadsdk.SR.pFF
            @Nullable
            public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("crypt", i11);
                    jSONObject.put("scene", cryptDataScene.value());
                    jSONObject.put("reason", i12);
                    if (i12 == 6) {
                        jSONObject.put("model", Build.MODEL);
                        jSONObject.put("vendor", Build.MANUFACTURER);
                    }
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.SR.sc.We.pFF().sc("crypt_v4_fail").pFF(jSONObject.toString());
            }
        });
    }

    public static void sc(JSONObject jSONObject) {
        pFF(jSONObject != null && jSONObject.optInt("cypher") == 4);
    }

    public static synchronized void sc(boolean z11) {
        try {
            if (z11) {
                com.bytedance.sdk.openadsdk.multipro.We.We.sc("encrypt_statistics_file", "decrypt_success_count", Integer.valueOf(zY.incrementAndGet()));
            } else {
                com.bytedance.sdk.openadsdk.multipro.We.We.sc("encrypt_statistics_file", "decrypt_fail_count", Integer.valueOf(zY.incrementAndGet()));
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
