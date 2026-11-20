package com.bytedance.sdk.openadsdk.SR;

import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.Qj.Qj;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.SR.sc.We;
import com.bytedance.sdk.openadsdk.core.SR;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.settings.dE;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.Dl;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.hisavana.common.tracking.TrackingKey;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static volatile zY f27124sc;

    private zY() {
    }

    public static void We() {
        sc("disk_log", false, new pFF() { // from class: com.bytedance.sdk.openadsdk.SR.zY.11
            @Override // com.bytedance.sdk.openadsdk.SR.pFF
            public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                File file = new File(CacheDirFactory.getRootDir());
                long j11 = 0;
                if (file.exists() && file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        long jSc = zY.sc(file2);
                        j11 += jSc;
                        jSONObject.put(file2.getName(), jSc);
                    }
                }
                if (j11 < 524288000) {
                    return null;
                }
                return We.pFF().sc("disk_log").pFF(jSONObject.toString());
            }
        });
    }

    public static void pFF() {
        Cb.zY(new Qj("showFailLog") { // from class: com.bytedance.sdk.openadsdk.SR.zY.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    zY.sc().sc("show_fail_log", new JSONObject());
                } catch (Throwable th2) {
                    Tf.sc("StatsLogManager", th2.getMessage());
                }
            }
        });
    }

    public static void pFF(final Sfl sfl) {
        if (cJ.sc(sfl) == null || TextUtils.isEmpty(sfl.PPh())) {
            return;
        }
        sc("download_gecko_start", false, new pFF() { // from class: com.bytedance.sdk.openadsdk.SR.zY.18
            @Override // com.bytedance.sdk.openadsdk.SR.pFF
            @Nullable
            public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", sfl.ko());
                jSONObject.put("channel_name", sfl.PPh());
                return We.pFF().sc("download_gecko_start").sc(sfl.Zn()).pFF(jSONObject.toString());
            }
        });
    }

    public static void pFF(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                final We wePFF = We.pFF().sc(str).pFF(str2);
                Xc.ExN().sc(new pFF() { // from class: com.bytedance.sdk.openadsdk.SR.zY.13
                    @Override // com.bytedance.sdk.openadsdk.SR.pFF
                    public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                        return wePFF;
                    }
                }, false);
            }
        } catch (Throwable th2) {
            Tf.sc("StatsLogManager", th2.getMessage());
        }
    }

    public static long sc(File file) {
        if (file.isFile()) {
            return file.length();
        }
        long jSc = 0;
        for (File file2 : file.listFiles()) {
            jSc += sc(file2);
        }
        return jSc;
    }

    public static zY sc() {
        if (f27124sc == null) {
            synchronized (zY.class) {
                try {
                    if (f27124sc == null) {
                        f27124sc = new zY();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f27124sc;
    }

    public static void sc(int i11, String str) {
        sc(i11, str, 0, (String) null);
    }

    public static void sc(final int i11, final String str, final int i12, final String str2) {
        sc("ipv6_req", false, (pFF) new pFF<com.bytedance.sdk.openadsdk.SR.sc.zY>() { // from class: com.bytedance.sdk.openadsdk.SR.zY.15
            @Override // com.bytedance.sdk.openadsdk.SR.pFF
            @Nullable
            public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                String str3;
                JSONObject jSONObject = new JSONObject();
                int i13 = i11;
                if (i13 == 1) {
                    str3 = "success";
                } else if (i13 == -1) {
                    jSONObject.put(TrackingKey.ERROR_CODE, i12);
                    jSONObject.put("error_msg", str2);
                    str3 = "fail";
                } else {
                    str3 = "start";
                }
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("url", str);
                }
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, str3);
                return We.pFF().sc("ipv6_req").pFF(jSONObject.toString());
            }
        });
    }

    public static void sc(long j11, long j12, final String str, final int i11) {
        if (j11 == 0) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        final long j13 = jElapsedRealtime - j11;
        final long j14 = jElapsedRealtime - j12;
        final long j15 = j12 - j11;
        sc("ad_show_cost_time", false, new pFF() { // from class: com.bytedance.sdk.openadsdk.SR.zY.14
            @Override // com.bytedance.sdk.openadsdk.SR.pFF
            public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("duration", j13);
                jSONObject.put("renderDuration", j14);
                jSONObject.put("showToRenderDuration", j15);
                jSONObject.put("tag", str);
                jSONObject.put("renderType", i11);
                return We.pFF().sc("ad_show_cost_time").pFF(jSONObject.toString());
            }
        });
    }

    public static void sc(final Sfl sfl) {
        if (sfl == null) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        sc("bidding_receive", false, new pFF() { // from class: com.bytedance.sdk.openadsdk.SR.zY.1
            @Override // com.bytedance.sdk.openadsdk.SR.pFF
            @Nullable
            public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("reveice_ts", jCurrentTimeMillis);
                if (sfl.Zn() == 3) {
                    jSONObject.put("is_icon_only", sfl.LVf() ? 1 : 0);
                }
                return We.pFF().sc("bidding_receive").pFF(jSONObject.toString());
            }
        });
    }

    public static void sc(Sfl sfl, final long j11) {
        if (sfl == null) {
            return;
        }
        sc("bidding_load", false, new pFF() { // from class: com.bytedance.sdk.openadsdk.SR.zY.12
            @Override // com.bytedance.sdk.openadsdk.SR.pFF
            @Nullable
            public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("duration", j11);
                return We.pFF().sc("bidding_load").pFF(jSONObject.toString());
            }
        });
    }

    public static void sc(final Sfl sfl, final JSONObject jSONObject) {
        if (cJ.sc(sfl) == null || TextUtils.isEmpty(sfl.PPh())) {
            return;
        }
        sc("download_gecko_end", false, new pFF() { // from class: com.bytedance.sdk.openadsdk.SR.zY.19
            @Override // com.bytedance.sdk.openadsdk.SR.pFF
            @Nullable
            public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("url", sfl.ko());
                jSONObject2.put("channel_name", sfl.PPh());
                jSONObject2.put("data", jSONObject);
                return We.pFF().sc("download_gecko_end").sc(sfl.Zn()).pFF(jSONObject2.toString());
            }
        });
    }

    public static void sc(final String str, final com.bytedance.sdk.openadsdk.We.ExN.pFF.sc scVar) {
        if (scVar == null) {
            return;
        }
        sc(str, false, new pFF() { // from class: com.bytedance.sdk.openadsdk.SR.zY.17
            @Override // com.bytedance.sdk.openadsdk.SR.pFF
            @Nullable
            public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                JSONObject jSONObjectZY = scVar.zY();
                if (jSONObjectZY == null) {
                    jSONObjectZY = new JSONObject();
                }
                com.bytedance.sdk.openadsdk.We.ExN.pFF.zY zYVarWe = scVar.We();
                if (zYVarWe != null) {
                    zYVarWe.sc(jSONObjectZY);
                }
                return We.pFF().sc(str).sc(scVar.sc().Zn()).pFF(jSONObjectZY.toString());
            }
        });
    }

    public static void sc(String str, boolean z11, pFF pff) {
        int iPFF = dE.ef().pFF(str);
        if (TextUtils.isEmpty(str) || iPFF == 0 || pff == null) {
            return;
        }
        boolean z12 = iPFF == 100;
        if (z12) {
            if (!z12) {
                return;
            }
        } else if (((int) ((Math.random() * 100.0d) + 1.0d)) > iPFF) {
            return;
        }
        Xc.ExN().sc(pff, z11);
    }

    public static void zY(final String str, final String str2) {
        sc("playable_url_mime", false, new pFF() { // from class: com.bytedance.sdk.openadsdk.SR.zY.16
            @Override // com.bytedance.sdk.openadsdk.SR.pFF
            @Nullable
            public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    String str3 = str;
                    Object obj = "not validate";
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "not validate";
                    }
                    jSONObject.put("original_mime", str3);
                    String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str2));
                    if (!TextUtils.isEmpty(mimeTypeFromExtension)) {
                        obj = mimeTypeFromExtension;
                    }
                    jSONObject.put("new_mime", obj);
                    jSONObject.put("url", str2);
                    jSONObject.put("is_same", str3.equals(obj) ? 1 : 0);
                } catch (Throwable unused) {
                }
                return We.pFF().sc("playable_url_mime").pFF(jSONObject.toString());
            }
        });
    }

    private boolean zY(We we2) {
        return we2 == null;
    }

    public void pFF(final We we2) {
        if (zY(we2)) {
            return;
        }
        we2.sc("show_backup_endcard");
        Xc.ExN().sc(new pFF() { // from class: com.bytedance.sdk.openadsdk.SR.zY.21
            @Override // com.bytedance.sdk.openadsdk.SR.pFF
            public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                return we2;
            }
        });
    }

    public void pFF(final String str) {
        sc("close_playable_test_tool", false, new pFF() { // from class: com.bytedance.sdk.openadsdk.SR.zY.3
            @Override // com.bytedance.sdk.openadsdk.SR.pFF
            public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("playable_url", str);
                } catch (Throwable unused) {
                }
                return We.pFF().sc("close_playable_test_tool").pFF(jSONObject.toString());
            }
        });
    }

    public void sc(final long j11, final long j12) {
        final long j13 = j12 - j11;
        sc("general_label", false, new pFF() { // from class: com.bytedance.sdk.openadsdk.SR.zY.5
            @Override // com.bytedance.sdk.openadsdk.SR.pFF
            public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                int i11 = !SR.pFF.get() ? 1 : 0;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("starttime", j11);
                    jSONObject.put("endtime", j12);
                    jSONObject.put("start_type", i11);
                } catch (Throwable unused) {
                }
                return We.pFF().sc("general_label").Qj(String.valueOf(j13)).pFF(jSONObject.toString());
            }
        });
    }

    public void sc(final We we2) {
        if (zY(we2)) {
            return;
        }
        we2.sc("express_ad_render");
        Xc.ExN().sc(new pFF() { // from class: com.bytedance.sdk.openadsdk.SR.zY.20
            @Override // com.bytedance.sdk.openadsdk.SR.pFF
            public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                return we2;
            }
        });
    }

    public void sc(final String str) {
        sc("click_playable_test_tool", false, new pFF() { // from class: com.bytedance.sdk.openadsdk.SR.zY.2
            @Override // com.bytedance.sdk.openadsdk.SR.pFF
            public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("playable_url", str);
                } catch (Throwable unused) {
                }
                return We.pFF().sc("click_playable_test_tool").pFF(jSONObject.toString());
            }
        });
    }

    public void sc(final String str, final int i11, final String str2) {
        sc("use_playable_test_tool_error", false, new pFF() { // from class: com.bytedance.sdk.openadsdk.SR.zY.4
            @Override // com.bytedance.sdk.openadsdk.SR.pFF
            public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("playable_url", str);
                    jSONObject.put(TrackingKey.ERROR_CODE, i11);
                    jSONObject.put(TrackingKey.ERROR_MESSAGE, str2);
                } catch (Throwable unused) {
                }
                return We.pFF().sc("use_playable_test_tool_error").pFF(jSONObject.toString());
            }
        });
    }

    public void sc(final String str, final String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        sc(str, false, new pFF() { // from class: com.bytedance.sdk.openadsdk.SR.zY.8
            @Override // com.bytedance.sdk.openadsdk.SR.pFF
            public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                return We.pFF().sc(str).pFF(str2);
            }
        });
    }

    public void sc(final String str, final JSONObject jSONObject) {
        if (str == null || jSONObject == null) {
            return;
        }
        sc(str, false, new pFF() { // from class: com.bytedance.sdk.openadsdk.SR.zY.7
            @Override // com.bytedance.sdk.openadsdk.SR.pFF
            public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                return We.pFF().sc(str).pFF(jSONObject.toString());
            }
        });
    }

    public void sc(final JSONObject jSONObject) {
        if (jSONObject == null) {
            Dl.sc("adRevenuePangle", "You must pass adRevenue json to pangle");
            return;
        }
        Object objOpt = jSONObject.opt("device_ad_mediation_platform");
        if (!(objOpt instanceof String) || TextUtils.isEmpty((String) objOpt)) {
            Dl.sc("adRevenuePangle", "You must pass device_ad_mediation_platform to pangle");
        } else {
            Dl.sc("adRevenuePangle", "pangle", "You successfully passed the parameters to pangle. The parameters are:", jSONObject);
            sc("ad_revenue", true, new pFF() { // from class: com.bytedance.sdk.openadsdk.SR.zY.10
                @Override // com.bytedance.sdk.openadsdk.SR.pFF
                public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                    try {
                        jSONObject.put(NotificationCompat.CATEGORY_EVENT, 272);
                        jSONObject.put("uuid", com.bytedance.sdk.openadsdk.core.Tf.zY(Xc.sc()));
                        String strSc = "";
                        try {
                            if (com.bytedance.sdk.openadsdk.core.Tf.sc(Xc.sc()) != null) {
                                strSc = com.bytedance.sdk.openadsdk.core.Tf.sc(Xc.sc());
                            }
                        } catch (Throwable th2) {
                            th2.getMessage();
                        }
                        jSONObject.put("device_id", strSc);
                        jSONObject.put(TrackingKey.PLATFORM, "android");
                        jSONObject.put("partner", "PangleSDK");
                    } catch (Throwable th3) {
                        th3.getMessage();
                    }
                    return We.pFF().sc("ad_revenue").pFF(jSONObject.toString());
                }
            });
        }
    }

    public void zY() {
        sc("blind_mode_status", true, new pFF() { // from class: com.bytedance.sdk.openadsdk.SR.zY.9
            @Override // com.bytedance.sdk.openadsdk.SR.pFF
            public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                return We.pFF().sc("blind_mode_status");
            }
        });
    }
}
