package com.bytedance.sdk.component.qr.zY;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.FI;
import com.bytedance.sdk.component.utils.Xc;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc implements FI.sc {
    private static zY Ol;
    private static boolean Qj;
    private static ThreadPoolExecutor WH;
    private int BT;
    private com.bytedance.sdk.component.qr.sc SR;
    private final Context Tf;
    private final boolean pFF;
    private volatile boolean zY = false;
    private boolean We = true;
    private boolean ExN = false;
    private long TRI = 0;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private long f26988qr = 0;
    private AtomicBoolean UFX = new AtomicBoolean(false);
    private volatile boolean Ql = false;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    final FI f26989sc = com.bytedance.sdk.component.Qj.sc.sc.sc().sc(this, "tt-net");

    public sc(Context context, int i11) {
        this.Tf = context;
        this.pFF = Xc.sc(context);
        this.BT = i11;
    }

    private com.bytedance.sdk.component.qr.sc Ol() {
        if (this.SR == null) {
            com.bytedance.sdk.component.qr.sc.C0264sc c0264sc = new com.bytedance.sdk.component.qr.sc.C0264sc();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            this.SR = c0264sc.sc(10L, timeUnit).pFF(10L, timeUnit).zY(10L, timeUnit).sc();
        }
        return this.SR;
    }

    private boolean Qj() {
        String[] strArrTRI = TRI();
        if (strArrTRI != null && strArrTRI.length != 0) {
            sc(0);
        }
        return false;
    }

    private void We(boolean z11) {
        if (this.ExN) {
            return;
        }
        if (this.We) {
            this.We = false;
            this.TRI = 0L;
            this.f26988qr = 0L;
        }
        long j11 = z11 ? 360000L : 43200000L;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.TRI > j11) {
            if (jCurrentTimeMillis - this.f26988qr > 120000 || !this.Ql) {
                zY();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF(int i11) {
        FI fi2 = this.f26989sc;
        if (fi2 != null) {
            fi2.sendEmptyMessage(i11);
        }
    }

    public static void pFF(boolean z11) {
        Qj = z11;
    }

    public static ExecutorService qr() {
        zY zYVar = Ol;
        ExecutorService threadPool = zYVar != null ? zYVar.getThreadPool() : null;
        if (threadPool != null) {
            return threadPool;
        }
        if (WH == null) {
            synchronized (sc.class) {
                try {
                    if (WH == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                        WH = threadPoolExecutor;
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return WH;
    }

    private String sc(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return AgentPageJsBridge.HTTPS + str + "/get_domains/v4/";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(final int i11) {
        String[] strArrTRI = TRI();
        if (strArrTRI == null || strArrTRI.length <= i11) {
            pFF(102);
            return;
        }
        String str = strArrTRI[i11];
        if (TextUtils.isEmpty(str)) {
            pFF(102);
            return;
        }
        try {
            String strSc = sc(str);
            if (TextUtils.isEmpty(strSc)) {
                pFF(102);
                return;
            }
            com.bytedance.sdk.component.qr.pFF.pFF pffZY = Ol().zY();
            pffZY.pFF(strSc);
            sc(pffZY);
            pffZY.sc(new com.bytedance.sdk.component.qr.sc.sc() { // from class: com.bytedance.sdk.component.qr.zY.sc.3
                @Override // com.bytedance.sdk.component.qr.sc.sc
                public void sc(com.bytedance.sdk.component.qr.pFF.zY zYVar, com.bytedance.sdk.component.qr.pFF pff) {
                    JSONObject jSONObject;
                    if (pff == null || !pff.TRI()) {
                        sc.this.sc(i11 + 1);
                        return;
                    }
                    String string = null;
                    try {
                        jSONObject = new JSONObject(pff.We());
                    } catch (Exception unused) {
                        jSONObject = null;
                    }
                    if (jSONObject == null) {
                        sc.this.sc(i11 + 1);
                        return;
                    }
                    try {
                        string = jSONObject.getString("message");
                    } catch (Exception unused2) {
                    }
                    if (!"success".equals(string)) {
                        sc.this.sc(i11 + 1);
                        return;
                    }
                    try {
                        if (sc.this.sc(jSONObject)) {
                            sc.this.pFF(101);
                        } else {
                            sc.this.sc(i11 + 1);
                        }
                    } catch (Exception unused3) {
                    }
                }

                @Override // com.bytedance.sdk.component.qr.sc.sc
                public void sc(com.bytedance.sdk.component.qr.pFF.zY zYVar, IOException iOException) {
                    sc.this.sc(i11 + 1);
                }
            });
        } catch (Throwable th2) {
            th2.toString();
        }
    }

    private void sc(com.bytedance.sdk.component.qr.pFF.pFF pff) {
        if (pff == null) {
            return;
        }
        Address addressSc = Qj.sc().sc(this.BT).We() != null ? Qj.sc().sc(this.BT).We().sc(this.Tf) : null;
        if (addressSc != null && addressSc.hasLatitude() && addressSc.hasLongitude()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(addressSc.getLatitude());
            pff.sc("latitude", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(addressSc.getLongitude());
            pff.sc("longitude", sb3.toString());
            String locality = addressSc.getLocality();
            if (!TextUtils.isEmpty(locality)) {
                pff.sc("city", Uri.encode(locality));
            }
        }
        if (this.zY) {
            pff.sc("force", "1");
        }
        try {
            pff.sc("abi", Build.SUPPORTED_ABIS[0]);
        } catch (Throwable unused) {
        }
        if (Qj.sc().sc(this.BT).We() != null) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(Qj.sc().sc(this.BT).We().sc());
            pff.sc("aid", sb4.toString());
            pff.sc("device_platform", Qj.sc().sc(this.BT).We().zY());
            pff.sc("channel", Qj.sc().sc(this.BT).We().pFF());
            StringBuilder sb5 = new StringBuilder();
            sb5.append(Qj.sc().sc(this.BT).We().We());
            pff.sc("version_code", sb5.toString());
            pff.sc("custom_info_1", Qj.sc().sc(this.BT).We().ExN());
        }
    }

    public static void sc(zY zYVar) {
        Ol = zYVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sc(Object obj) throws Exception {
        JSONObject jSONObject;
        if (obj instanceof String) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            jSONObject = new JSONObject(str);
            if (!"success".equals(jSONObject.getString("message"))) {
                return false;
            }
        } else {
            jSONObject = obj instanceof JSONObject ? (JSONObject) obj : null;
        }
        if (jSONObject == null) {
            return false;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        synchronized (this) {
            SharedPreferences.Editor editorEdit = this.Tf.getSharedPreferences("ss_app_config", 0).edit();
            editorEdit.putLong("last_refresh_time", System.currentTimeMillis());
            editorEdit.apply();
        }
        if (Qj.sc().sc(this.BT).Qj() == null) {
            return true;
        }
        Qj.sc().sc(this.BT).Qj().sc(jSONObject2);
        return true;
    }

    public void ExN() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        try {
            if (this.pFF) {
                We();
            } else {
                pFF();
            }
        } catch (Throwable unused) {
        }
    }

    public String[] TRI() {
        String[] strArrTRI = Qj.sc().sc(this.BT).We() != null ? Qj.sc().sc(this.BT).We().TRI() : null;
        return (strArrTRI == null || strArrTRI.length <= 0) ? new String[0] : strArrTRI;
    }

    public synchronized void We() {
        if (this.Ql) {
            return;
        }
        this.Ql = true;
        long j11 = this.Tf.getSharedPreferences("ss_app_config", 0).getLong("last_refresh_time", 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (j11 > jCurrentTimeMillis) {
            j11 = jCurrentTimeMillis;
        }
        this.TRI = j11;
        try {
            if (Qj.sc().sc(this.BT).Qj() != null) {
                Qj.sc().sc(this.BT).Qj().sc();
            }
        } catch (Exception unused) {
        }
    }

    public synchronized void pFF() {
        if (System.currentTimeMillis() - this.TRI > 3600000) {
            this.TRI = System.currentTimeMillis();
            try {
                if (Qj.sc().sc(this.BT).Qj() != null) {
                    Qj.sc().sc(this.BT).Qj().pFF();
                }
            } catch (Exception unused) {
            }
        }
    }

    public void sc() {
        sc(false);
    }

    @Override // com.bytedance.sdk.component.utils.FI.sc
    public void sc(Message message) {
        int i11 = message.what;
        if (i11 == 101) {
            this.ExN = false;
            this.TRI = System.currentTimeMillis();
            if (this.We) {
                sc();
            }
            this.UFX.set(false);
            return;
        }
        if (i11 != 102) {
            return;
        }
        this.ExN = false;
        if (this.We) {
            sc();
        }
        this.UFX.set(false);
    }

    public synchronized void sc(boolean z11) {
        if (this.pFF) {
            We(z11);
            return;
        }
        if (this.TRI <= 0) {
            try {
                qr().execute(new Runnable() { // from class: com.bytedance.sdk.component.qr.zY.sc.1
                    @Override // java.lang.Runnable
                    public void run() {
                        sc.this.pFF();
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    public void zY(boolean z11) {
        We();
        this.ExN = true;
        if (!z11) {
            this.f26989sc.sendEmptyMessage(102);
            return;
        }
        try {
            Qj();
        } catch (Exception unused) {
            this.UFX.set(false);
        }
    }

    public boolean zY() {
        this.UFX.get();
        qr().execute(new Runnable() { // from class: com.bytedance.sdk.component.qr.zY.sc.2
            @Override // java.lang.Runnable
            public void run() {
                boolean zSc = com.bytedance.sdk.component.qr.We.ExN.sc(sc.this.Tf);
                if (zSc) {
                    sc.this.f26988qr = System.currentTimeMillis();
                    if (sc.this.UFX.compareAndSet(false, true)) {
                        sc.this.zY(zSc);
                    }
                }
            }
        });
        return true;
    }
}
