package com.bytedance.sdk.openadsdk.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.cJ;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {
    private final String ExN;
    private final Map<Sfl, Long> TRI = Collections.synchronizedMap(new HashMap());
    private final pFF We;

    @SuppressLint({"StaticFieldLeak"})
    private final Context zY;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static final HashMap<String, sc> f27718sc = new HashMap<>();
    private static final HashMap<String, pFF> pFF = new HashMap<>();

    /* JADX INFO: compiled from: source.java */
    public static class pFF {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        protected final String f27724sc;
        private final HashSet<String> Qj = new HashSet<>();
        String pFF = "material_data";
        String zY = "has_played";
        String We = "create_time";
        String ExN = "in_use_process";
        String TRI = "req_id";

        /* JADX INFO: renamed from: qr, reason: collision with root package name */
        String f27723qr = "ad_slot";

        public pFF(String str) {
            this.f27724sc = TextUtils.isEmpty(str) ? "" : str;
        }

        public long ExN(String str) {
            try {
                return com.bytedance.sdk.openadsdk.multipro.We.We.sc(sc(str), this.We, 0L);
            } catch (Throwable unused) {
                return 0L;
            }
        }

        public void Ol(String str) {
            try {
                com.bytedance.sdk.openadsdk.multipro.We.We.sc(sc(str));
                this.Qj.remove(str);
            } catch (Throwable unused) {
            }
        }

        public boolean Qj(String str) {
            try {
                String strSc = sc(str);
                String strPFF = com.bytedance.sdk.openadsdk.multipro.We.We.pFF(strSc, this.ExN, "");
                if (TextUtils.isEmpty(strPFF)) {
                    return false;
                }
                if (strPFF.equals(com.bytedance.sdk.component.utils.Xc.pFF(com.bytedance.sdk.openadsdk.core.Xc.sc())) && !this.Qj.contains(str)) {
                    com.bytedance.sdk.openadsdk.multipro.We.We.sc(strSc, this.ExN, "");
                    return false;
                }
            } catch (Throwable unused) {
            }
            return true;
        }

        public boolean TRI(String str) {
            try {
                return com.bytedance.sdk.openadsdk.multipro.We.We.sc(sc(str), this.zY, true);
            } catch (Throwable unused) {
                return true;
            }
        }

        public String We(String str) {
            try {
                return com.bytedance.sdk.openadsdk.multipro.We.We.pFF(sc(str), this.f27723qr, null);
            } catch (Throwable unused) {
                return null;
            }
        }

        public String pFF(String str) {
            try {
                return com.bytedance.sdk.openadsdk.multipro.We.We.pFF(sc(str), this.pFF, null);
            } catch (Throwable unused) {
                return null;
            }
        }

        public void qr(String str) {
            try {
                com.bytedance.sdk.openadsdk.multipro.We.We.sc(sc(str), this.ExN, com.bytedance.sdk.component.utils.Xc.pFF(com.bytedance.sdk.openadsdk.core.Xc.sc()));
                this.Qj.add(str);
            } catch (Throwable unused) {
            }
        }

        public String sc(String str) {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            return this.f27724sc + "_cache_" + str;
        }

        public void sc(AdSlot adSlot, String str, String str2) {
            try {
                String codeId = adSlot.getCodeId();
                String strSc = sc(codeId);
                com.bytedance.sdk.openadsdk.multipro.We.We.sc(strSc, this.zY, Boolean.FALSE);
                com.bytedance.sdk.openadsdk.multipro.We.We.sc(strSc, this.We, Long.valueOf(System.currentTimeMillis()));
                com.bytedance.sdk.openadsdk.multipro.We.We.sc(strSc, this.pFF, str);
                com.bytedance.sdk.openadsdk.multipro.We.We.sc(strSc, this.ExN, "");
                com.bytedance.sdk.openadsdk.multipro.We.We.sc(strSc, this.TRI, str2);
                com.bytedance.sdk.openadsdk.multipro.We.We.sc(strSc, this.f27723qr, adSlot.toJsonObj().toString());
                this.Qj.remove(codeId);
            } catch (Throwable unused) {
            }
        }

        public String zY(String str) {
            try {
                return com.bytedance.sdk.openadsdk.multipro.We.We.pFF(sc(str), this.TRI, null);
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.common.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0281sc<T> {
        void sc(boolean z11, T t11);
    }

    private sc(Context context, String str) {
        this.zY = context;
        pFF pff = pFF.get(str);
        this.We = pff == null ? new pFF(str) : pff;
        this.ExN = str;
    }

    private boolean pFF(Sfl sfl) {
        if (sfl != null) {
            if (JPJ.wjp(sfl)) {
                return true;
            }
            x8.a aVarGI = sfl.GI();
            if (aVarGI != null) {
                return Build.VERSION.SDK_INT >= 23 || !TextUtils.isEmpty(sc(aVarGI.q(), aVarGI.k(), sfl.Flm()));
            }
        }
        return false;
    }

    public static sc sc(String str) {
        sc scVar;
        HashMap<String, sc> map = f27718sc;
        sc scVar2 = map.get(str);
        if (scVar2 != null) {
            return scVar2;
        }
        synchronized (sc.class) {
            try {
                scVar = map.get(str);
                if (scVar == null) {
                    scVar = new sc(com.bytedance.sdk.openadsdk.core.Xc.sc(), str);
                    map.put(str, scVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return scVar;
    }

    private File sc(String str, int i11) {
        return new File(CacheDirFactory.getICacheDir(i11).sc(), str);
    }

    public static void sc(String str, pFF pff) {
        pFF.put(str, pff);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(final boolean z11, final Sfl sfl, final long j11, String str) {
        Long lRemove = this.TRI.remove(sfl);
        final long jElapsedRealtime = lRemove == null ? 0L : SystemClock.elapsedRealtime() - lRemove.longValue();
        final String str2 = z11 ? "load_video_success" : "load_video_error";
        final String str3 = (z11 || str == null) ? null : str;
        com.bytedance.sdk.openadsdk.SR.zY.sc(str2, false, new com.bytedance.sdk.openadsdk.SR.pFF() { // from class: com.bytedance.sdk.openadsdk.common.sc.2
            @Override // com.bytedance.sdk.openadsdk.SR.pFF
            @Nullable
            public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                return com.bytedance.sdk.openadsdk.SR.sc.We.pFF().sc(str2).pFF(cJ.sc(z11, sfl, jElapsedRealtime, j11, str3).toString());
            }
        });
    }

    public static boolean sc() {
        return com.bytedance.sdk.openadsdk.YIK.sc.sc("material_cache_disk_format", 0) == 1;
    }

    private String zY() {
        return CacheDirFactory.getICacheDir(0).sc();
    }

    public void pFF() {
        File[] fileArrListFiles;
        try {
            int i11 = Build.VERSION.SDK_INT;
            boolean zQr = com.bytedance.sdk.openadsdk.core.Ol.qr(this.ExN);
            String str = zQr ? "files" : "shared_prefs";
            File file = i11 >= 24 ? new File(this.zY.getDataDir(), str) : new File(this.zY.getDatabasePath("1").getParentFile().getParentFile(), str);
            if (file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.common.sc.1
                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    if (file2 != null) {
                        return file2.getName().contains(sc.this.ExN);
                    }
                    return false;
                }
            })) != null) {
                for (File file2 : fileArrListFiles) {
                    if (zQr) {
                        try {
                            com.bytedance.sdk.component.utils.TRI.zY(file2);
                        } catch (Throwable unused) {
                        }
                    } else {
                        String strReplace = file2.getName().replace(".xml", "");
                        if (Build.VERSION.SDK_INT >= 24) {
                            this.zY.deleteSharedPreferences(strReplace);
                        } else {
                            this.zY.getSharedPreferences(strReplace, 0).edit().clear().apply();
                            com.bytedance.sdk.component.utils.TRI.zY(file2);
                        }
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        try {
            File file3 = new File(zY());
            if (file3.exists() && file3.isDirectory()) {
                com.bytedance.sdk.component.utils.TRI.zY(file3);
            }
        } catch (Throwable unused3) {
        }
    }

    public void pFF(String str) {
        this.We.qr(str);
    }

    public com.bytedance.sdk.openadsdk.core.model.sc sc(String str, long j11) {
        long jExN = this.We.ExN(str);
        boolean zTRI = this.We.TRI(str);
        if (System.currentTimeMillis() - jExN >= j11 || zTRI) {
            return null;
        }
        return sc(str, true);
    }

    public com.bytedance.sdk.openadsdk.core.model.sc sc(String str, boolean z11) {
        com.bytedance.sdk.openadsdk.core.model.sc scVarZY;
        AdSlot adSlotPFF;
        Sfl sflTRI;
        try {
            String strPFF = this.We.pFF(str);
            if (!TextUtils.isEmpty(strPFF)) {
                JSONObject jSONObject = new JSONObject(strPFF);
                if (jSONObject.has("cypher")) {
                    jSONObject = com.bytedance.sdk.openadsdk.core.Xc.zY().sc(jSONObject);
                }
                if (jSONObject.has("creatives")) {
                    scVarZY = com.bytedance.sdk.openadsdk.core.model.sc.zY(jSONObject);
                } else {
                    Sfl sflSc = com.bytedance.sdk.openadsdk.core.pFF.sc(jSONObject);
                    com.bytedance.sdk.openadsdk.core.model.sc scVar = new com.bytedance.sdk.openadsdk.core.model.sc();
                    scVar.sc(sflSc);
                    scVarZY = scVar;
                }
                if (scVarZY != null && scVarZY.ExN()) {
                    if (z11) {
                        Iterator<Sfl> it = scVarZY.We().iterator();
                        while (it.hasNext()) {
                            if (!pFF(it.next())) {
                                it.remove();
                            }
                        }
                    }
                    if (scVarZY.ExN()) {
                        String strWe = this.We.We(str);
                        if (!TextUtils.isEmpty(strWe) && (adSlotPFF = com.bytedance.sdk.openadsdk.core.pFF.pFF(new JSONObject(strWe))) != null && (sflTRI = scVarZY.TRI()) != null) {
                            sflTRI.sc(adSlotPFF);
                        }
                        return scVarZY;
                    }
                }
            }
        } catch (JSONException unused) {
        }
        return null;
    }

    public String sc(Sfl sfl) {
        if (sfl == null || sfl.GI() == null || TextUtils.isEmpty(sfl.GI().q())) {
            return null;
        }
        return sc(sfl.GI().q(), sfl.GI().k(), sfl.Flm());
    }

    public String sc(String str, String str2, int i11) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = com.bytedance.sdk.component.utils.ExN.sc(str);
        }
        File fileSc = sc(str2, i11);
        if (fileSc == null || !fileSc.exists() || !fileSc.isFile() || fileSc.length() <= 0) {
            return null;
        }
        return fileSc.getAbsolutePath();
    }

    public void sc(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.sc scVar) {
        Sfl sflTRI;
        if (scVar == null || adSlot == null || !TextUtils.isEmpty(adSlot.getBidAdm()) || (sflTRI = scVar.TRI()) == null || sflTRI.hwa() == 2) {
            return;
        }
        try {
            this.We.sc(adSlot, scVar.SR(), scVar.pFF());
        } catch (Throwable unused) {
        }
    }

    public void sc(final Sfl sfl, final InterfaceC0281sc<Object> interfaceC0281sc) {
        this.TRI.put(sfl, Long.valueOf(SystemClock.elapsedRealtime()));
        if (sfl.GI() == null || TextUtils.isEmpty(sfl.GI().q())) {
            if (interfaceC0281sc != null) {
                interfaceC0281sc.sc(false, null);
            }
            sc(false, sfl, -1L, null);
        } else {
            String strQ = sfl.GI().q();
            File fileSc = sc(sfl.GI().k(), sfl.Flm());
            com.bytedance.sdk.component.qr.pFF.sc scVarWe = com.bytedance.sdk.openadsdk.Xc.zY.sc().pFF().We();
            scVarWe.pFF(strQ);
            scVarWe.sc(fileSc.getParent(), fileSc.getName());
            scVarWe.sc(new com.bytedance.sdk.component.qr.sc.sc() { // from class: com.bytedance.sdk.openadsdk.common.sc.3
                @Override // com.bytedance.sdk.component.qr.sc.sc
                public void sc(com.bytedance.sdk.component.qr.pFF.zY zYVar, com.bytedance.sdk.component.qr.pFF pff) {
                    if (pff.TRI() && pff.ExN() != null && pff.ExN().exists()) {
                        InterfaceC0281sc interfaceC0281sc2 = interfaceC0281sc;
                        if (interfaceC0281sc2 != null) {
                            interfaceC0281sc2.sc(true, null);
                        }
                        sc.this.sc(true, sfl, pff.sc(), pff.pFF());
                        return;
                    }
                    InterfaceC0281sc interfaceC0281sc3 = interfaceC0281sc;
                    if (interfaceC0281sc3 != null) {
                        interfaceC0281sc3.sc(false, null);
                    }
                    sc.this.sc(false, sfl, pff.sc(), pff.pFF());
                }

                @Override // com.bytedance.sdk.component.qr.sc.sc
                public void sc(com.bytedance.sdk.component.qr.pFF.zY zYVar, IOException iOException) {
                    InterfaceC0281sc interfaceC0281sc2 = interfaceC0281sc;
                    if (interfaceC0281sc2 != null) {
                        interfaceC0281sc2.sc(false, null);
                    }
                    sc.this.sc(false, sfl, -2L, iOException.getMessage());
                }
            });
        }
    }

    public void sc(String str, Sfl sfl) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strZY = this.We.zY(str);
        String strOfL = sfl != null ? sfl.ofL() : "";
        if (TextUtils.isEmpty(strZY) || TextUtils.isEmpty(strOfL) || strZY.equals(strOfL)) {
            this.We.Ol(str);
        }
    }

    public boolean zY(String str) {
        return this.We.Qj(str);
    }
}
