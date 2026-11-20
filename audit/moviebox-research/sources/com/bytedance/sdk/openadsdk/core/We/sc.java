package com.bytedance.sdk.openadsdk.core.We;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.ExN;
import com.bytedance.sdk.component.utils.TRI;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.SR.sc.We;
import com.bytedance.sdk.openadsdk.core.Ql.zY.zY;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.multipro.pFF;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final List<String> f28318sc = new CopyOnWriteArrayList();
    private final zY pFF = new zY(5, 5, true);
    private final ConcurrentHashMap<String, Long> zY = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.We.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0299sc {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private static final sc f28323sc = new sc();
    }

    public static sc sc() {
        return C0299sc.f28323sc;
    }

    private File sc(Context context, boolean z11) {
        String str;
        String name = new File(CacheDirFactory.getRootDir()).getName();
        if (pFF.zY()) {
            str = name + "/music";
        } else {
            str = name + "//music";
        }
        return TRI.sc(context, z11, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(final int i11, final long j11, final int i12, final String str) {
        com.bytedance.sdk.openadsdk.SR.zY.sc("music_preload_finish", false, new com.bytedance.sdk.openadsdk.SR.pFF() { // from class: com.bytedance.sdk.openadsdk.core.We.sc.3
            @Override // com.bytedance.sdk.openadsdk.SR.pFF
            public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("result", i11);
                long j12 = j11;
                if (j12 != -1) {
                    jSONObject.put("load_duration", j12);
                }
                We wePFF = We.pFF().sc("music_preload_finish").pFF(jSONObject.toString());
                if (!TextUtils.isEmpty(str)) {
                    wePFF.pFF(i12);
                    wePFF.TRI(str);
                }
                wePFF.sc();
                return wePFF;
            }
        });
    }

    private void sc(Sfl sfl) {
        Sfl.sc scVarJoC;
        String strUFX;
        if (sfl == null || (scVarJoC = sfl.JoC()) == null || (strUFX = scVarJoC.UFX()) == null || !strUFX.contains("music_url")) {
            return;
        }
        zY();
        String strWe = scVarJoC.We();
        if (TextUtils.isEmpty(strWe)) {
            try {
                new JSONObject().put("result", 0);
            } catch (JSONException e11) {
                Tf.sc("MusicCacheManager", e11.getMessage());
            }
            sc(0, -1L, 10001, "music url string is null");
            return;
        }
        File filePFF = pFF(strWe);
        if (filePFF == null) {
            return;
        }
        filePFF.getPath();
        if (sc(filePFF)) {
            sc(2, -1L, -1, null);
        } else {
            sc(sfl, strWe, filePFF);
        }
    }

    private void sc(Sfl sfl, String str, File file) {
        if (zY(str)) {
            this.zY.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
            com.bytedance.sdk.component.qr.pFF.sc scVarWe = com.bytedance.sdk.openadsdk.Xc.zY.sc().pFF().We();
            scVarWe.pFF(str);
            scVarWe.sc(file.getParent(), file.getName());
            scVarWe.zY(str);
            this.f28318sc.add(str);
            scVarWe.sc(new com.bytedance.sdk.component.qr.sc.sc() { // from class: com.bytedance.sdk.openadsdk.core.We.sc.1
                @Override // com.bytedance.sdk.component.qr.sc.sc
                public void sc(com.bytedance.sdk.component.qr.pFF.zY zYVar, com.bytedance.sdk.component.qr.pFF pff) {
                    pff.zY();
                    pff.sc();
                    String strZY = zYVar.zY();
                    Long l11 = (Long) sc.this.zY.get(strZY);
                    if (pff.TRI() && pff.ExN() != null && pff.ExN().exists()) {
                        pff.ExN();
                        if (l11 != null) {
                            sc.this.zY.remove(strZY);
                            sc.this.sc(1, SystemClock.elapsedRealtime() - l11.longValue(), -1, null);
                        }
                        try {
                            TRI.pFF(pff.ExN());
                        } catch (IOException e11) {
                            Tf.sc("MusicCacheManager", e11.getMessage());
                        }
                    }
                    if (pff.TRI() || l11 == null) {
                        return;
                    }
                    sc.this.sc(0, SystemClock.elapsedRealtime() - l11.longValue(), -2, "http response status code isn't 200");
                }

                @Override // com.bytedance.sdk.component.qr.sc.sc
                public void sc(com.bytedance.sdk.component.qr.pFF.zY zYVar, IOException iOException) {
                    Long l11 = (Long) sc.this.zY.get(zYVar.zY());
                    if (l11 != null) {
                        sc.this.sc(0, SystemClock.elapsedRealtime() - l11.longValue(), -2, "http response status code isn't 200");
                    }
                }
            });
        }
    }

    private boolean sc(File file) {
        return file.exists() && file.length() != 0;
    }

    private boolean zY(String str) {
        return !this.f28318sc.contains(str);
    }

    public File pFF(String str) {
        String str2;
        String strSc = ExN.sc(str);
        if (strSc == null) {
            return null;
        }
        String name = new File(CacheDirFactory.getRootDir()).getName();
        if (pFF.zY()) {
            str2 = name + "/music/";
        } else {
            str2 = name + "//music/";
        }
        return TRI.sc(Xc.sc(), pFF.zY(), str2, strSc);
    }

    public void pFF() {
        File fileSc = sc(Xc.sc(), pFF.zY());
        fileSc.getAbsolutePath();
        try {
            this.pFF.sc(fileSc);
        } catch (IOException e11) {
            Tf.sc("MusicCacheManager", "trimFileCache fail", e11);
        }
    }

    public InputStream sc(String str) {
        File filePFF = pFF(str);
        if (filePFF != null && sc(filePFF)) {
            try {
                return new FileInputStream(filePFF);
            } catch (Exception e11) {
                Tf.sc("MusicCacheManager", e11.getMessage());
            }
        }
        return null;
    }

    public void sc(com.bytedance.sdk.openadsdk.core.model.sc scVar) {
        List<Sfl> listWe = scVar.We();
        if (listWe == null || listWe.size() == 0) {
            return;
        }
        for (int i11 = 0; i11 < listWe.size(); i11++) {
            Sfl sfl = listWe.get(i11);
            if (sfl != null) {
                sc(sfl);
            }
        }
    }

    public void sc(final boolean z11) {
        com.bytedance.sdk.openadsdk.SR.zY.sc("music_cache", false, new com.bytedance.sdk.openadsdk.SR.pFF() { // from class: com.bytedance.sdk.openadsdk.core.We.sc.4
            @Override // com.bytedance.sdk.openadsdk.SR.pFF
            public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("result", z11);
                We wePFF = We.pFF().sc("music_cache").pFF(jSONObject.toString());
                wePFF.sc();
                return wePFF;
            }
        });
    }

    public void zY() {
        com.bytedance.sdk.openadsdk.SR.zY.sc("music_preload_start", false, new com.bytedance.sdk.openadsdk.SR.pFF() { // from class: com.bytedance.sdk.openadsdk.core.We.sc.2
            @Override // com.bytedance.sdk.openadsdk.SR.pFF
            public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                We weSc = We.pFF().sc("music_preload_start");
                weSc.sc();
                return weSc;
            }
        });
    }
}
