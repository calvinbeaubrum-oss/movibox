package com.bytedance.sdk.openadsdk.core.Ql.zY;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.bytedance.sdk.component.Qj.Qj;
import com.bytedance.sdk.component.utils.ExN;
import com.bytedance.sdk.component.utils.SR;
import com.bytedance.sdk.component.utils.TRI;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.component.utils.cvk;
import com.bytedance.sdk.openadsdk.Sfl.sc.We;
import com.bytedance.sdk.openadsdk.core.Ol;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static volatile sc f28185sc;
    private String pFF;
    private final Map<Sfl, pFF> zY = new ConcurrentHashMap();
    private final Map<String, JSONObject> We = new ConcurrentHashMap();
    private final AtomicBoolean ExN = new AtomicBoolean(false);
    private final Set<String> TRI = Collections.synchronizedSet(new HashSet());

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final ConcurrentHashMap<String, com.bytedance.sdk.component.qr.pFF.sc> f28186qr = new ConcurrentHashMap<>();
    private final Map<String, String> Qj = new ConcurrentHashMap();

    /* JADX INFO: compiled from: source.java */
    public static class pFF {
        long We;
        long pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        long f28191sc;
        long zY;

        private pFF() {
        }

        public pFF We(long j11) {
            this.We = j11;
            return this;
        }

        public long pFF() {
            return this.We - this.zY;
        }

        public pFF pFF(long j11) {
            this.pFF = j11;
            return this;
        }

        public long sc() {
            return this.pFF - this.f28191sc;
        }

        public pFF sc(long j11) {
            this.f28191sc = j11;
            return this;
        }

        public pFF zY(long j11) {
            this.zY = j11;
            return this;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.Ql.zY.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0290sc {
    }

    private sc() {
    }

    private String ExN() {
        if (TextUtils.isEmpty(this.pFF)) {
            try {
                File file = new File(Xc.sc().getCacheDir(), "playable");
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.pFF = file.getAbsolutePath();
            } catch (Throwable th2) {
                Tf.sc("PlayableCache", "init root path error: ".concat(String.valueOf(th2)));
            }
        }
        return this.pFF;
    }

    private boolean ExN(File file) {
        return file != null && file.exists() && file.isFile() && file.canRead();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File We(File file) {
        File file2 = new File(file, "tt_open_ad_sdk_check_res.dat");
        return ExN(file2) ? file2 : new File(file, "tt_open_ad_sdk_check_res.dat");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String We() {
        File file = new File(ExN(), "games");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static void pFF(File file) {
        zY(file);
        try {
            Ol.pFF().SR().sc(file);
        } catch (Throwable unused) {
        }
    }

    public static sc sc() {
        if (f28185sc == null) {
            synchronized (sc.class) {
                try {
                    if (f28185sc == null) {
                        f28185sc = new sc();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f28185sc;
    }

    public static File sc(File file) {
        File[] fileArrListFiles;
        if (file != null && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length != 0) {
            for (File file2 : fileArrListFiles) {
                if (file2 != null && file2.isFile() && "index.html".equals(file2.getName())) {
                    return file;
                }
            }
            for (File file3 : fileArrListFiles) {
                if (file3 != null && file3.isDirectory()) {
                    return sc(file3);
                }
            }
        }
        return null;
    }

    private String sc(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split("\\?");
        if (strArrSplit != null && strArrSplit.length == 2) {
            String str2 = strArrSplit[0];
            if (str2 != null && str2.endsWith("/")) {
                str = str.substring(0, strArrSplit.length - 1);
            }
            String str3 = strArrSplit[0];
            if (str3 != null && str3.endsWith("index.html")) {
                str = strArrSplit[0];
            }
        }
        return str.replace("index.html", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject sc(File file, boolean z11) {
        byte[] bArrWe;
        try {
            if (!ExN(file) || (bArrWe = TRI.We(file)) == null || bArrWe.length <= 0) {
                return null;
            }
            String strZY = TextUtils.equals(file.getName(), "tt_open_ad_sdk_check_res.dat") ? com.bytedance.sdk.component.utils.sc.zY(new String(bArrWe)) : com.bytedance.sdk.component.We.sc.pFF(new String(bArrWe), com.bytedance.sdk.openadsdk.core.sc.pFF());
            if (TextUtils.isEmpty(strZY)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(strZY);
            if (z11 && jSONObject.length() > 0) {
                this.We.put(file.getParentFile().getName(), jSONObject);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(final InterfaceC0290sc interfaceC0290sc, final boolean z11) {
        Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Ql.zY.sc.3
            @Override // java.lang.Runnable
            public void run() {
            }
        });
    }

    private boolean sc(String str, String str2, File file) {
        if (file != null && file.exists()) {
            JSONObject jSONObject = this.We.get(str);
            if (jSONObject == null) {
                return true;
            }
            String strOptString = jSONObject.optString(str2);
            if (strOptString != null && strOptString.equalsIgnoreCase(ExN.sc(file))) {
                return true;
            }
        }
        return false;
    }

    public static void zY(File file) {
        try {
            if (!file.exists() || file.setLastModified(System.currentTimeMillis())) {
                return;
            }
            file.renameTo(file);
            file.lastModified();
        } catch (Throwable unused) {
        }
    }

    public void pFF() {
        if (this.ExN.get()) {
            return;
        }
        Cb.sc(new Qj("PlayableCache_init") { // from class: com.bytedance.sdk.openadsdk.core.Ql.zY.sc.1
            @Override // java.lang.Runnable
            public void run() {
                File[] fileArrListFiles;
                try {
                    String strWe = sc.this.We();
                    if (!TextUtils.isEmpty(strWe)) {
                        File file = new File(strWe);
                        if (file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                            for (File file2 : fileArrListFiles) {
                                if (file2 != null) {
                                    try {
                                        File fileSc = sc.sc(file2);
                                        if (fileSc != null && fileSc.exists()) {
                                            sc.this.Qj.put(file2.getName(), fileSc.getAbsolutePath());
                                        }
                                        sc.this.sc(sc.this.We(fileSc), true);
                                    } catch (Throwable unused) {
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable unused2) {
                }
                com.bytedance.sdk.openadsdk.Sfl.sc.zY.sc().sc(sc.this.Qj);
                sc.this.ExN.set(true);
            }
        });
    }

    public void pFF(Sfl sfl) {
        if (sfl == null || sfl.GI() == null || TextUtils.isEmpty(sfl.GI().j()) || !com.bytedance.sdk.openadsdk.YIK.sc.sc("can_cancel_playable", false)) {
            return;
        }
        com.bytedance.sdk.component.qr.pFF.sc scVar = this.f28186qr.get(sfl.GI().j());
        if (scVar != null) {
            scVar.pFF();
        }
    }

    public WebResourceResponse sc(String str, String str2, String str3) {
        File fileSc;
        try {
            WebResourceResponse webResourceResponseSc = com.bytedance.sdk.openadsdk.Sfl.sc.zY.sc().sc(str3);
            if (webResourceResponseSc != null) {
                return webResourceResponseSc;
            }
            if (this.ExN.get() && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                try {
                    if ((str3.startsWith("http://") || str3.startsWith(AgentPageJsBridge.HTTPS)) && str3.contains("?")) {
                        str3 = str3.split("\\?")[0];
                        if (str3.endsWith("/")) {
                            str3 = str3.substring(0, str3.length() - 1);
                        }
                    }
                } catch (Throwable unused) {
                }
                String strSc = SR.sc(Xc.sc(), str3);
                com.bytedance.sdk.openadsdk.SR.zY.zY(strSc, str3);
                if (TextUtils.isEmpty(strSc)) {
                    return null;
                }
                String strSc2 = ExN.sc(str);
                if (TextUtils.isEmpty(strSc2)) {
                    return null;
                }
                String str4 = this.Qj.get(strSc2);
                if (TextUtils.isEmpty(str4)) {
                    fileSc = sc(new File(We(), strSc2));
                    if (fileSc != null && fileSc.exists()) {
                        this.Qj.put(strSc2, fileSc.getAbsolutePath());
                    }
                } else {
                    fileSc = new File(str4);
                }
                if (fileSc != null && fileSc.exists()) {
                    String strSc3 = sc(str2);
                    if (TextUtils.isEmpty(strSc3)) {
                        return null;
                    }
                    String strReplace = str3.replace(strSc3, "");
                    if (!TextUtils.isEmpty(strReplace) && !strReplace.startsWith(AgentPageJsBridge.HTTPS) && !strReplace.startsWith("http://")) {
                        File file = new File(fileSc, strReplace);
                        if (file.exists() && sc(strSc2, strReplace, file) && file.getCanonicalPath().startsWith(fileSc.getCanonicalPath())) {
                            return new WebResourceResponse(strSc, "utf-8", new FileInputStream(file));
                        }
                    }
                }
            }
            return null;
        } catch (Throwable th2) {
            Tf.sc("PlayableCache", "playable intercept error: ", th2);
        }
        return null;
    }

    @SuppressLint({"[ByDesign4.2]BadDomainNameVerifier"})
    public void sc(final Sfl sfl, final InterfaceC0290sc interfaceC0290sc) {
        File file;
        if (We.sc().pFF() && sfl != null && JPJ.TRI(sfl) && sfl.Cb() != null && !TextUtils.isEmpty(sfl.Cb().getBidAdm())) {
            com.bytedance.sdk.openadsdk.core.Ql.zY.pFF.sc(sfl, -705, "server bidding pre render");
            sc(interfaceC0290sc, false);
            return;
        }
        if (sfl == null || sfl.GI() == null || TextUtils.isEmpty(sfl.GI().j())) {
            com.bytedance.sdk.openadsdk.core.Ql.zY.pFF.sc(sfl, -701, (String) null);
            sc(interfaceC0290sc, false);
            return;
        }
        final String strJ = sfl.GI().j();
        if (this.TRI.contains(strJ)) {
            return;
        }
        this.zY.put(sfl, new pFF().sc(System.currentTimeMillis()));
        com.bytedance.sdk.openadsdk.core.Ql.zY.pFF.sc(sfl);
        String strSc = ExN.sc(strJ);
        final File file2 = new File(We(), strSc);
        String str = this.Qj.get(strSc);
        if (TextUtils.isEmpty(str)) {
            file = sc(file2);
            if (file != null && file.exists()) {
                this.Qj.put(strSc, file.getAbsolutePath());
            }
        } else {
            file = new File(str);
        }
        if (file != null && file.exists()) {
            com.bytedance.sdk.openadsdk.core.Ql.zY.pFF.sc(sfl, -702, (String) null);
            zY(file2);
            this.zY.remove(sfl);
            sc(interfaceC0290sc, true);
            return;
        }
        try {
            TRI.zY(file2);
        } catch (Throwable unused) {
        }
        this.TRI.add(strJ);
        File file3 = new File(ExN(), strSc + ".zip");
        com.bytedance.sdk.component.qr.pFF.sc scVarWe = com.bytedance.sdk.openadsdk.Xc.zY.sc().pFF().We();
        this.f28186qr.put(strJ, scVarWe);
        scVarWe.pFF(strJ);
        scVarWe.sc(file3.getParent(), file3.getName());
        scVarWe.sc(7);
        scVarWe.sc("playable_download");
        scVarWe.sc(new com.bytedance.sdk.component.qr.sc.sc() { // from class: com.bytedance.sdk.openadsdk.core.Ql.zY.sc.2
            @Override // com.bytedance.sdk.component.qr.sc.sc
            public void sc(com.bytedance.sdk.component.qr.pFF.zY zYVar, final com.bytedance.sdk.component.qr.pFF pff) {
                sc.this.TRI.remove(strJ);
                sc.this.f28186qr.remove(strJ);
                final pFF pff2 = (pFF) sc.this.zY.remove(sfl);
                if (pff2 != null) {
                    pff2.pFF(System.currentTimeMillis());
                }
                if (pff.TRI() && pff.ExN() != null && pff.ExN().exists()) {
                    Cb.pFF(new Qj("downloadZip") { // from class: com.bytedance.sdk.openadsdk.core.Ql.zY.sc.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            boolean z11;
                            long jSc;
                            long jPFF;
                            try {
                                pFF pff3 = pff2;
                                if (pff3 != null) {
                                    pff3.zY(System.currentTimeMillis());
                                }
                                cvk.sc(pff.ExN().getAbsolutePath(), file2.getAbsolutePath());
                                pFF pff4 = pff2;
                                if (pff4 != null) {
                                    pff4.We(System.currentTimeMillis());
                                }
                                pFF pff5 = pff2;
                                if (pff5 != null) {
                                    jSc = pff5.sc();
                                    jPFF = pff2.pFF();
                                } else {
                                    jSc = 0;
                                    jPFF = 0;
                                }
                                com.bytedance.sdk.openadsdk.core.Ql.zY.pFF.sc(sfl, jSc, jPFF);
                                sc.pFF(file2);
                                z11 = true;
                                try {
                                    File fileSc = sc.sc(file2);
                                    if (fileSc != null && fileSc.exists()) {
                                        sc.this.Qj.put(file2.getName(), fileSc.getAbsolutePath());
                                    }
                                    sc.this.sc(sc.this.We(fileSc), true);
                                } catch (Throwable unused2) {
                                }
                            } catch (Throwable th2) {
                                Tf.sc("PlayableCache", "unzip error: ", th2);
                                com.bytedance.sdk.openadsdk.core.Ql.zY.pFF.sc(sfl, -704, th2.getMessage());
                                z11 = false;
                            }
                            try {
                                pff.ExN().delete();
                            } catch (Throwable unused3) {
                            }
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            sc.this.sc(interfaceC0290sc, z11);
                        }
                    });
                } else {
                    com.bytedance.sdk.openadsdk.core.Ql.zY.pFF.sc(sfl, pff.sc() != 0 ? pff.sc() : -700, (String) null);
                    sc.this.sc(interfaceC0290sc, false);
                }
            }

            @Override // com.bytedance.sdk.component.qr.sc.sc
            public void sc(com.bytedance.sdk.component.qr.pFF.zY zYVar, IOException iOException) {
                sc.this.TRI.remove(strJ);
                sc.this.f28186qr.remove(strJ);
                sc.this.zY.remove(sfl);
                com.bytedance.sdk.openadsdk.core.Ql.zY.pFF.sc(sfl, -700, iOException.getMessage());
                sc.this.sc(interfaceC0290sc, false);
            }
        });
    }

    public boolean sc(Sfl sfl) {
        if (this.ExN.get() && sfl != null && sfl.GI() != null && sfl.GI().j() != null) {
            try {
                if (!TextUtils.isEmpty(this.Qj.get(ExN.sc(sfl.GI().j())))) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public Map<String, String> zY() {
        return this.Qj;
    }
}
