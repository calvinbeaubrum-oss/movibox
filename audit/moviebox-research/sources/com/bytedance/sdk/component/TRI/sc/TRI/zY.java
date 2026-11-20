package com.bytedance.sdk.component.TRI.sc.TRI;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.TRI.sc.Qj;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY implements pFF {
    private final ExN pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final Context f26591sc;

    /* JADX INFO: compiled from: source.java */
    @SuppressLint({"StaticFieldLeak"})
    public class sc extends com.bytedance.sdk.component.TRI.sc.ExN.ExN {
        private final Map<String, String> We;
        private final We pFF;
        private final String zY;

        private sc(We we2, String str, Map<String, String> map) {
            super("AdsStats");
            this.pFF = we2;
            this.zY = str;
            this.We = map;
        }

        private String zY(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (str.contains("{TS}") || str.contains("__TS__")) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                str = str.replace("{TS}", String.valueOf(jCurrentTimeMillis)).replace("__TS__", String.valueOf(jCurrentTimeMillis));
            }
            return ((str.contains("{UID}") || str.contains("__UID__")) && !TextUtils.isEmpty(this.zY)) ? str.replace("{UID}", this.zY).replace("__UID__", this.zY) : str;
        }

        public String pFF(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            try {
                return str.replace("[ss_random]", String.valueOf(zY.zY().nextLong())).replace("[ss_timestamp]", String.valueOf(System.currentTimeMillis()));
            } catch (Exception unused) {
                return str;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.component.TRI.sc.ExN.We weSc;
            com.bytedance.sdk.component.TRI.sc.ExN exNDE = Qj.qr().dE();
            if (exNDE == null || Qj.qr().TRI() == null || !exNDE.zY() || !sc(this.pFF.pFF())) {
                return;
            }
            if (this.pFF.We() >= exNDE.zY(this.pFF.TRI())) {
                zY.this.pFF.zY(this.pFF);
                return;
            }
            try {
                exNDE.Ql();
                if (this.pFF.UFX()) {
                    zY.this.pFF.sc(this.pFF);
                }
                if (exNDE.sc(zY.this.sc())) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    String strPFF = this.pFF.pFF();
                    if (exNDE.TRI() == 0) {
                        strPFF = zY(this.pFF.pFF());
                        if (this.pFF.zY()) {
                            strPFF = pFF(strPFF);
                        }
                    }
                    com.bytedance.sdk.component.TRI.sc.ExN.zY zYVarWH = exNDE.WH();
                    if (zYVarWH == null) {
                        return;
                    }
                    zYVarWH.sc("User-Agent", exNDE.Ol());
                    zYVarWH.sc("csj_client_source_from", "1");
                    if (this.We != null) {
                        JSONObject jSONObject = new JSONObject();
                        for (Map.Entry<String, String> entry : this.We.entrySet()) {
                            jSONObject.put(entry.getKey(), entry.getValue());
                        }
                        zYVarWH.sc("csj_extra_info", jSONObject.toString());
                    }
                    zYVarWH.sc(strPFF);
                    try {
                        weSc = zYVarWH.sc();
                        try {
                            exNDE.sc(weSc.sc());
                        } catch (Throwable unused) {
                        }
                    } catch (Throwable unused2) {
                        weSc = null;
                    }
                    We we2 = this.pFF;
                    we2.sc(we2.We() + 1);
                    if (weSc != null && weSc.sc()) {
                        zY.this.pFF.zY(this.pFF);
                        this.pFF.pFF();
                        exNDE.sc(true, 200, System.currentTimeMillis() - jCurrentTimeMillis, this.pFF);
                        return;
                    }
                    if (weSc != null) {
                        this.pFF.pFF(weSc.pFF());
                        this.pFF.zY(weSc.zY());
                    }
                    if (weSc == null || weSc.pFF() != 8848) {
                        this.pFF.pFF();
                        if (this.pFF.We() >= exNDE.zY(this.pFF.TRI())) {
                            zY.this.pFF.zY(this.pFF);
                            this.pFF.pFF();
                        } else {
                            zY.this.pFF.pFF(this.pFF);
                        }
                    } else {
                        weSc.zY();
                        zY.this.pFF.zY(this.pFF);
                    }
                    exNDE.sc(false, this.pFF.Qj(), System.currentTimeMillis() - jCurrentTimeMillis, this.pFF);
                }
            } catch (Throwable unused3) {
            }
        }

        public boolean sc(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.startsWith("http://") || str.startsWith(AgentPageJsBridge.HTTPS);
        }
    }

    public zY(Context context, ExN exN) {
        this.f26591sc = context;
        this.pFF = exN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(List<We> list, String str, boolean z11) {
        if (list == null || list.size() == 0) {
            return;
        }
        com.bytedance.sdk.component.TRI.sc.ExN exNDE = Qj.qr().dE();
        for (We we2 : list) {
            if (exNDE != null && exNDE.We() != null) {
                we2.sc(z11);
                exNDE.We().execute(new sc(we2, str, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Random zY() {
        if (Build.VERSION.SDK_INT < 26) {
            return new SecureRandom();
        }
        try {
            return SecureRandom.getInstanceStrong();
        } catch (Throwable unused) {
            return new SecureRandom();
        }
    }

    public Context sc() {
        Context context = this.f26591sc;
        return context == null ? Qj.qr().TRI() : context;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.TRI.pFF
    public Runnable sc(final We we2, final String str, final Map<String, String> map) {
        if (we2 == null || TextUtils.isEmpty(we2.sc())) {
            return null;
        }
        return new Runnable() { // from class: com.bytedance.sdk.component.TRI.sc.TRI.zY.1
            @Override // java.lang.Runnable
            public void run() {
                if (zY.this.pFF.sc(we2.sc()) != null) {
                    new sc(we2, str, map).run();
                }
            }
        };
    }

    @Override // com.bytedance.sdk.component.TRI.sc.TRI.pFF
    public void sc(String str, List<String> list, boolean z11, Map<String, String> map, int i11, String str2) {
        com.bytedance.sdk.component.TRI.sc.ExN exNDE = Qj.qr().dE();
        if (exNDE == null || Qj.qr().TRI() == null || exNDE.We() == null || !exNDE.zY() || list == null || list.size() == 0) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            exNDE.We().execute(new sc(new We(UUID.randomUUID().toString() + "_" + System.currentTimeMillis(), it.next(), z11, i11, str2), str, map));
        }
    }

    @Override // com.bytedance.sdk.component.TRI.sc.TRI.pFF
    public void sc(final String str, final boolean z11) {
        com.bytedance.sdk.component.TRI.sc.ExN exNDE = Qj.qr().dE();
        if (exNDE == null || Qj.qr().TRI() == null || !exNDE.zY()) {
            return;
        }
        com.bytedance.sdk.component.TRI.sc.ExN.ExN exN = new com.bytedance.sdk.component.TRI.sc.ExN.ExN("trackFailedUrls") { // from class: com.bytedance.sdk.component.TRI.sc.TRI.zY.2
            @Override // java.lang.Runnable
            public void run() {
                zY.this.sc(zY.this.pFF.sc(), str, z11);
            }
        };
        exN.sc(1);
        if (exNDE.We() != null) {
            exNDE.We().execute(exN);
        }
    }
}
