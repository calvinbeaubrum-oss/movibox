package com.bytedance.sdk.openadsdk.oem;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import android.util.LruCache;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.Qj.Qj;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.We.zY;
import com.bytedance.sdk.openadsdk.core.SR;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.model.uEA;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.cJ;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class IPMiBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static volatile IPMiBroadcastReceiver f28656sc;
    private int We = 0;
    private final LruCache<String, Sfl> pFF;
    private sc zY;

    private IPMiBroadcastReceiver() {
        int i11 = 10;
        int iSc = com.bytedance.sdk.openadsdk.YIK.sc.sc("ip_data_config", "ip_ad_cache_count", 10);
        if (iSc > 0 && iSc <= 200) {
            i11 = iSc;
        }
        this.pFF = new LruCache<>(i11);
    }

    public static IPMiBroadcastReceiver sc(Context context) {
        int iSc = com.bytedance.sdk.openadsdk.YIK.sc.sc("ip_data_config", "ip_link_listener", 0);
        Tf.sc("IPMiBroadcastReceiver", "open =", Integer.valueOf(iSc));
        if (iSc == 0) {
            return null;
        }
        if (f28656sc == null) {
            synchronized (IPMiBroadcastReceiver.class) {
                try {
                    if (f28656sc == null) {
                        f28656sc = new IPMiBroadcastReceiver();
                        IntentFilter intentFilter = new IntentFilter("com.xiaomi.market.DOWNLOAD_INSTALL_RESULT");
                        if (Build.VERSION.SDK_INT < 34 || cJ.WH(context) < 34) {
                            context.registerReceiver(f28656sc, intentFilter);
                        } else {
                            context.registerReceiver(f28656sc, intentFilter, 2);
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f28656sc;
    }

    public static void sc(final Context context, Sfl sfl) {
        uEA ueaAf;
        if (f28656sc == null && sfl != null && (ueaAf = sfl.Af()) != null && ueaAf.sc()) {
            SR.pFF().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        IPMiBroadcastReceiver.sc(Xc.sc(context));
                    } catch (Throwable th2) {
                        Tf.sc("IPMiBroadcastReceiver", th2.getMessage());
                    }
                }
            });
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, final Intent intent) {
        if ("com.xiaomi.market.DOWNLOAD_INSTALL_RESULT".equals(intent.getAction())) {
            Cb.zY(new Qj("ip-mi") { // from class: com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver.1
                /* JADX WARN: Code duplicated, block: B:33:0x009c A[Catch: all -> 0x0020, TRY_LEAVE, TryCatch #0 {all -> 0x0020, blocks: (B:3:0x0004, B:5:0x000f, B:16:0x0028, B:27:0x004b, B:30:0x005d, B:31:0x0060, B:33:0x009c, B:21:0x003c, B:19:0x0033), top: B:37:0x0004, inners: #1 }] */
                /* JADX WARN: Code duplicated, block: B:41:? A[RETURN, SYNTHETIC] */
                @Override // java.lang.Runnable
                public void run() {
                    final int i11;
                    final int intExtra;
                    final int intExtra2;
                    String stringExtra;
                    sc scVar;
                    Sfl sflSc;
                    try {
                        final int intExtra3 = intent.getIntExtra("errorCode", 0);
                        if (intExtra3 < 0) {
                            int intExtra4 = intent.getIntExtra("reason", 0);
                            if (intExtra3 == -4 && intExtra4 == -1) {
                                return;
                            } else {
                                i11 = intExtra4;
                            }
                        } else {
                            i11 = 0;
                        }
                        if (intExtra3 == 5) {
                            intExtra = intent.getIntExtra(NotificationCompat.CATEGORY_STATUS, 0);
                            if (intExtra == -2) {
                                try {
                                    intExtra2 = intent.getIntExtra(NotificationCompat.CATEGORY_PROGRESS, 0);
                                } catch (Throwable unused) {
                                    IPMiBroadcastReceiver.this.We = 1;
                                    intExtra2 = 0;
                                }
                                if (intExtra2 < 100) {
                                    return;
                                }
                            }
                            stringExtra = intent.getStringExtra("packageName");
                            scVar = IPMiBroadcastReceiver.this.zY;
                            if (intExtra3 > 0 && scVar != null) {
                                scVar.sc(stringExtra, intExtra3);
                            }
                            sflSc = IPMiBroadcastReceiver.this.sc(stringExtra);
                            Tf.sc("IPMiBroadcastReceiver", "err_code=", Integer.valueOf(intExtra3), " reason=", Integer.valueOf(i11), " status=", Integer.valueOf(intExtra), " progress=", Integer.valueOf(intExtra2));
                            if (sflSc != null) {
                                zY.sc(System.currentTimeMillis(), sflSc, cJ.sc(sflSc), "ip_listener_log", new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver.1.1
                                    @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
                                    public JSONObject sc() {
                                        JSONObject jSONObject = new JSONObject();
                                        try {
                                            JSONObject jSONObject2 = new JSONObject();
                                            JSONObject jSONObject3 = new JSONObject();
                                            jSONObject3.put("ip_error_code", intExtra3);
                                            int i12 = intExtra3;
                                            if (i12 > 0) {
                                                if (i12 == 5) {
                                                    jSONObject3.put("ip_status", intExtra);
                                                    jSONObject3.put("ip_exec_type", IPMiBroadcastReceiver.this.We);
                                                }
                                                if (intExtra == -2) {
                                                    jSONObject3.put("ip_progress", intExtra2);
                                                }
                                            }
                                            if (intExtra3 < 0) {
                                                jSONObject3.put("ip_reason", i11);
                                            }
                                            jSONObject2.put("pag_json_data", jSONObject3.toString());
                                            jSONObject.put("ad_extra_data", jSONObject2);
                                        } catch (Throwable th2) {
                                            Tf.sc("IPMiBroadcastReceiver", th2.getMessage());
                                        }
                                        return jSONObject;
                                    }
                                });
                            }
                        }
                        intExtra = 0;
                        intExtra2 = 0;
                        stringExtra = intent.getStringExtra("packageName");
                        scVar = IPMiBroadcastReceiver.this.zY;
                        if (intExtra3 > 0) {
                            scVar.sc(stringExtra, intExtra3);
                        }
                        sflSc = IPMiBroadcastReceiver.this.sc(stringExtra);
                        Tf.sc("IPMiBroadcastReceiver", "err_code=", Integer.valueOf(intExtra3), " reason=", Integer.valueOf(i11), " status=", Integer.valueOf(intExtra), " progress=", Integer.valueOf(intExtra2));
                        if (sflSc != null) {
                            zY.sc(System.currentTimeMillis(), sflSc, cJ.sc(sflSc), "ip_listener_log", new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver.1.1
                                @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
                                public JSONObject sc() {
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        JSONObject jSONObject2 = new JSONObject();
                                        JSONObject jSONObject3 = new JSONObject();
                                        jSONObject3.put("ip_error_code", intExtra3);
                                        int i12 = intExtra3;
                                        if (i12 > 0) {
                                            if (i12 == 5) {
                                                jSONObject3.put("ip_status", intExtra);
                                                jSONObject3.put("ip_exec_type", IPMiBroadcastReceiver.this.We);
                                            }
                                            if (intExtra == -2) {
                                                jSONObject3.put("ip_progress", intExtra2);
                                            }
                                        }
                                        if (intExtra3 < 0) {
                                            jSONObject3.put("ip_reason", i11);
                                        }
                                        jSONObject2.put("pag_json_data", jSONObject3.toString());
                                        jSONObject.put("ad_extra_data", jSONObject2);
                                    } catch (Throwable th2) {
                                        Tf.sc("IPMiBroadcastReceiver", th2.getMessage());
                                    }
                                    return jSONObject;
                                }
                            });
                        }
                    } catch (Throwable th2) {
                        Tf.sc("IPMiBroadcastReceiver", th2.getMessage());
                    }
                }
            });
        }
    }

    public Sfl sc(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.pFF.get(str);
    }

    public void sc() {
        this.zY = null;
    }

    public void sc(sc scVar) {
        this.zY = scVar;
    }

    public void sc(String str, Sfl sfl) {
        if (TextUtils.isEmpty(str) || sfl == null || this.pFF.get(str) != null) {
            return;
        }
        this.pFF.put(str, sfl);
    }
}
