package com.bytedance.sdk.openadsdk.component.reward;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.cJ;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import x8.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
class We {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile We f27832sc;
    private final Map<Sfl, Long> We = Collections.synchronizedMap(new HashMap());
    private final Context pFF;
    private final com.bytedance.sdk.openadsdk.common.sc.pFF zY;

    private We(Context context) {
        this.pFF = context == null ? Xc.sc() : context.getApplicationContext();
        this.zY = new com.bytedance.sdk.openadsdk.common.sc.pFF("sp_full_screen_video");
    }

    private boolean pFF(Sfl sfl) {
        if (sfl != null) {
            if (JPJ.zY(sfl)) {
                return true;
            }
            a aVarGI = sfl.GI();
            if (aVarGI != null) {
                return Build.VERSION.SDK_INT >= 23 || !TextUtils.isEmpty(sc(aVarGI.q(), aVarGI.k(), sfl.Flm()));
            }
        }
        return false;
    }

    public static We sc(Context context) {
        if (f27832sc == null) {
            synchronized (We.class) {
                try {
                    if (f27832sc == null) {
                        f27832sc = new We(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f27832sc;
    }

    private File sc(String str, int i11) {
        return new File(CacheDirFactory.getICacheDir(i11).sc(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(final boolean z11, final Sfl sfl, final long j11, String str) {
        Long lRemove = this.We.remove(sfl);
        final long jElapsedRealtime = lRemove == null ? 0L : SystemClock.elapsedRealtime() - lRemove.longValue();
        final String str2 = z11 ? "load_video_success" : "load_video_error";
        final String str3 = (z11 || str == null) ? null : str;
        com.bytedance.sdk.openadsdk.SR.zY.sc(str2, false, new com.bytedance.sdk.openadsdk.SR.pFF() { // from class: com.bytedance.sdk.openadsdk.component.reward.We.3
            @Override // com.bytedance.sdk.openadsdk.SR.pFF
            @Nullable
            public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                return com.bytedance.sdk.openadsdk.SR.sc.We.pFF().sc(str2).pFF(cJ.sc(z11, sfl, jElapsedRealtime, j11, str3).toString());
            }
        });
    }

    public com.bytedance.sdk.openadsdk.core.model.sc sc(String str, boolean z11) {
        com.bytedance.sdk.openadsdk.core.model.sc scVarZY;
        if (com.bytedance.sdk.openadsdk.common.sc.sc()) {
            com.bytedance.sdk.openadsdk.common.sc scVarSc = com.bytedance.sdk.openadsdk.common.sc.sc("sp_full_screen_video");
            com.bytedance.sdk.openadsdk.core.model.sc scVarSc2 = scVarSc.sc(str, 10500000L);
            if (z11 && scVarSc2 != null && ExN.pFF() == 2 && scVarSc.zY(str)) {
                return null;
            }
            return scVarSc2;
        }
        long jExN = this.zY.ExN(str);
        boolean zTRI = this.zY.TRI(str);
        boolean zQj = this.zY.Qj(str);
        int iPFF = ExN.pFF();
        if (System.currentTimeMillis() - jExN < 10500000 && !zTRI && (!z11 || iPFF != 2 || !zQj)) {
            try {
                String strPFF = this.zY.pFF(str);
                if (!TextUtils.isEmpty(strPFF)) {
                    JSONObject jSONObject = new JSONObject(strPFF);
                    if (jSONObject.has("cypher")) {
                        jSONObject = Xc.zY().sc(jSONObject);
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
                        Iterator<Sfl> it = scVarZY.We().iterator();
                        while (it.hasNext()) {
                            if (!pFF(it.next())) {
                                it.remove();
                            }
                        }
                        if (scVarZY.ExN()) {
                            return scVarZY;
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public String sc(Sfl sfl) {
        if (com.bytedance.sdk.openadsdk.common.sc.sc()) {
            return com.bytedance.sdk.openadsdk.common.sc.sc("sp_full_screen_video").sc(sfl);
        }
        if (sfl == null || sfl.GI() == null || TextUtils.isEmpty(sfl.GI().q())) {
            return null;
        }
        return sc(sfl.GI().q(), sfl.GI().k(), sfl.Flm());
    }

    public String sc(String str, String str2, int i11) {
        if (com.bytedance.sdk.openadsdk.common.sc.sc()) {
            return com.bytedance.sdk.openadsdk.common.sc.sc("sp_full_screen_video").sc(str, str2, i11);
        }
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

    public void sc() {
        File[] fileArrListFiles;
        File[] fileArrListFiles2;
        if (com.bytedance.sdk.openadsdk.common.sc.sc()) {
            com.bytedance.sdk.openadsdk.common.sc.sc("sp_full_screen_video").pFF();
            return;
        }
        try {
            int i11 = Build.VERSION.SDK_INT;
            boolean zQr = com.bytedance.sdk.openadsdk.core.Ol.qr("sp_full_screen_video");
            String str = zQr ? "files" : "shared_prefs";
            File file = i11 >= 24 ? new File(this.pFF.getDataDir(), str) : new File(this.pFF.getDatabasePath("1").getParentFile().getParentFile(), str);
            if (file.exists() && file.isDirectory() && (fileArrListFiles2 = file.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.component.reward.We.1
                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    if (file2 != null) {
                        return file2.getName().contains("sp_full_screen_video");
                    }
                    return false;
                }
            })) != null) {
                for (File file2 : fileArrListFiles2) {
                    if (zQr) {
                        try {
                            com.bytedance.sdk.component.utils.TRI.zY(file2);
                        } catch (Throwable unused) {
                        }
                    } else {
                        String strReplace = file2.getName().replace(".xml", "");
                        if (Build.VERSION.SDK_INT >= 24) {
                            this.pFF.deleteSharedPreferences(strReplace);
                        } else {
                            this.pFF.getSharedPreferences(strReplace, 0).edit().clear().apply();
                            com.bytedance.sdk.component.utils.TRI.zY(file2);
                        }
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        try {
            File cacheDir = this.pFF.getCacheDir();
            if (cacheDir == null || !cacheDir.exists() || !cacheDir.isDirectory() || (fileArrListFiles = cacheDir.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.component.reward.We.2
                @Override // java.io.FileFilter
                public boolean accept(File file3) {
                    if (file3 != null) {
                        return file3.getName().contains("full_screen_video_cache");
                    }
                    return false;
                }
            })) == null) {
                return;
            }
            for (File file3 : fileArrListFiles) {
                try {
                    com.bytedance.sdk.component.utils.TRI.zY(file3);
                } catch (Throwable unused3) {
                }
            }
        } catch (Throwable unused4) {
        }
    }

    public void sc(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.sc scVar) {
        Sfl sflTRI;
        if (com.bytedance.sdk.openadsdk.common.sc.sc()) {
            com.bytedance.sdk.openadsdk.common.sc.sc("sp_full_screen_video").sc(adSlot, scVar);
            return;
        }
        if (scVar == null || adSlot == null || !TextUtils.isEmpty(adSlot.getBidAdm()) || (sflTRI = scVar.TRI()) == null || sflTRI.hwa() == 2) {
            return;
        }
        try {
            this.zY.sc(adSlot, scVar.Ql().toString(), scVar.pFF());
        } catch (Throwable unused) {
        }
    }

    public void sc(final Sfl sfl, final com.bytedance.sdk.openadsdk.common.sc.InterfaceC0281sc<Object> interfaceC0281sc) {
        if (!com.bytedance.sdk.openadsdk.core.Ql.ExN.sc.sc()) {
            interfaceC0281sc.sc(true, null);
            return;
        }
        if (com.bytedance.sdk.openadsdk.common.sc.sc()) {
            com.bytedance.sdk.openadsdk.common.sc.sc("sp_full_screen_video").sc(sfl, interfaceC0281sc);
            return;
        }
        this.We.put(sfl, Long.valueOf(SystemClock.elapsedRealtime()));
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
            scVarWe.sc(new com.bytedance.sdk.component.qr.sc.sc() { // from class: com.bytedance.sdk.openadsdk.component.reward.We.4
                @Override // com.bytedance.sdk.component.qr.sc.sc
                public void sc(com.bytedance.sdk.component.qr.pFF.zY zYVar, com.bytedance.sdk.component.qr.pFF pff) {
                    if (pff.TRI() && pff.ExN() != null && pff.ExN().exists()) {
                        com.bytedance.sdk.openadsdk.common.sc.InterfaceC0281sc interfaceC0281sc2 = interfaceC0281sc;
                        if (interfaceC0281sc2 != null) {
                            interfaceC0281sc2.sc(true, null);
                        }
                        We.this.sc(true, sfl, pff.sc(), pff.pFF());
                        return;
                    }
                    com.bytedance.sdk.openadsdk.common.sc.InterfaceC0281sc interfaceC0281sc3 = interfaceC0281sc;
                    if (interfaceC0281sc3 != null) {
                        interfaceC0281sc3.sc(false, null);
                    }
                    We.this.sc(false, sfl, pff.sc(), pff.pFF());
                }

                @Override // com.bytedance.sdk.component.qr.sc.sc
                public void sc(com.bytedance.sdk.component.qr.pFF.zY zYVar, IOException iOException) {
                    com.bytedance.sdk.openadsdk.common.sc.InterfaceC0281sc interfaceC0281sc2 = interfaceC0281sc;
                    if (interfaceC0281sc2 != null) {
                        interfaceC0281sc2.sc(false, null);
                    }
                    We.this.sc(false, sfl, -2L, iOException.getMessage());
                }
            });
        }
    }

    public void sc(String str) {
        if (com.bytedance.sdk.openadsdk.common.sc.sc()) {
            com.bytedance.sdk.openadsdk.common.sc.sc("sp_full_screen_video").pFF(str);
        } else {
            this.zY.qr(str);
        }
    }

    public void sc(String str, Sfl sfl) {
        if (com.bytedance.sdk.openadsdk.common.sc.sc()) {
            com.bytedance.sdk.openadsdk.common.sc.sc("sp_full_screen_video").sc(str, sfl);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strZY = this.zY.zY(str);
        String strOfL = sfl != null ? sfl.ofL() : "";
        if (TextUtils.isEmpty(strZY) || TextUtils.isEmpty(strOfL) || strZY.equals(strOfL)) {
            this.zY.Ol(str);
        }
    }
}
