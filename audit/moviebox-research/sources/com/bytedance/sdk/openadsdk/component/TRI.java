package com.bytedance.sdk.openadsdk.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.ExN.UFX;
import com.bytedance.sdk.component.ExN.dE;
import com.bytedance.sdk.component.Qj.Qj;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.core.Sfl;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.BT;
import com.bytedance.sdk.openadsdk.core.model.Dl;
import com.bytedance.sdk.openadsdk.core.model.WP;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.OXF;
import com.bytedance.sdk.openadsdk.utils.kX;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
import q8.c;
import r8.b;
import x8.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TRI {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static volatile TRI f27751sc;
    private final Map<String, AtomicInteger> ExN = new ConcurrentHashMap();
    private final Context We;
    private final com.bytedance.sdk.openadsdk.pFF.pFF pFF;
    private final Sfl<com.bytedance.sdk.openadsdk.We.sc> zY;

    /* JADX INFO: compiled from: source.java */
    public interface We {
        void sc(Bitmap bitmap);
    }

    /* JADX INFO: compiled from: source.java */
    public interface pFF {
        void sc();

        void sc(@Nullable com.bytedance.sdk.openadsdk.Xc.sc.pFF pff);
    }

    /* JADX INFO: compiled from: source.java */
    public class sc extends Qj {
        private final com.bytedance.sdk.openadsdk.component.ExN.sc pFF;

        public sc(com.bytedance.sdk.openadsdk.component.ExN.sc scVar) {
            super("App Open Ad Write Cache");
            this.pFF = scVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (com.bytedance.sdk.openadsdk.common.sc.sc()) {
                    com.bytedance.sdk.openadsdk.common.sc.sc("tt_openad_materialMeta").sc(this.pFF.pFF().Cb(), this.pFF.zY());
                    return;
                }
                com.bytedance.sdk.openadsdk.multipro.We.We.sc("tt_openad_materialMeta", "material" + this.pFF.sc(), com.bytedance.sdk.component.utils.sc.sc(this.pFF.pFF().JP()).toString());
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface zY {
        void sc();

        void sc(int i11, String str);
    }

    private TRI(Context context) {
        if (context != null) {
            this.We = context.getApplicationContext();
        } else {
            this.We = Xc.sc();
        }
        this.pFF = new com.bytedance.sdk.openadsdk.pFF.pFF(10, 8, true);
        this.zY = Xc.zY();
        com.bytedance.sdk.openadsdk.common.sc.sc("tt_openad_materialMeta", new com.bytedance.sdk.openadsdk.common.sc.pFF("tt_openad_materialMeta") { // from class: com.bytedance.sdk.openadsdk.component.TRI.1
            @Override // com.bytedance.sdk.openadsdk.common.sc.pFF
            public String We(String str) {
                return com.bytedance.sdk.openadsdk.multipro.We.We.pFF("tt_openad_materialMeta", "ad_slot".concat(String.valueOf(str)), null);
            }

            @Override // com.bytedance.sdk.openadsdk.common.sc.pFF
            public String pFF(String str) {
                return com.bytedance.sdk.openadsdk.multipro.We.We.pFF("tt_openad_materialMeta", "material".concat(String.valueOf(str)), null);
            }

            @Override // com.bytedance.sdk.openadsdk.common.sc.pFF
            public String sc(String str) {
                return "tt_openad_materialMeta";
            }

            @Override // com.bytedance.sdk.openadsdk.common.sc.pFF
            public void sc(AdSlot adSlot, String str, String str2) {
                String codeId = adSlot.getCodeId();
                com.bytedance.sdk.openadsdk.multipro.We.We.sc("tt_openad_materialMeta", "material".concat(String.valueOf(codeId)), str);
                com.bytedance.sdk.openadsdk.multipro.We.We.sc("tt_openad_materialMeta", "ad_slot".concat(String.valueOf(codeId)), adSlot.toJsonObj().toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF(AdSlot adSlot) {
        AtomicInteger atomicInteger = this.ExN.get(adSlot.getCodeId());
        if (atomicInteger == null) {
            atomicInteger = new AtomicInteger(0);
        } else {
            atomicInteger.decrementAndGet();
        }
        this.ExN.put(adSlot.getCodeId(), atomicInteger);
    }

    private void pFF(com.bytedance.sdk.openadsdk.component.ExN.sc scVar) {
        Cb.sc(new sc(scVar), 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF(@NonNull final com.bytedance.sdk.openadsdk.core.model.Sfl sfl, final AdSlot adSlot, final WP wp2, final com.bytedance.sdk.openadsdk.core.model.sc scVar) {
        final int iQT = sfl.QT();
        sc(sfl, wp2, new pFF() { // from class: com.bytedance.sdk.openadsdk.component.TRI.6
            @Override // com.bytedance.sdk.openadsdk.component.TRI.pFF
            public void sc() {
                TRI.this.pFF(adSlot);
            }

            @Override // com.bytedance.sdk.openadsdk.component.TRI.pFF
            public void sc(com.bytedance.sdk.openadsdk.Xc.sc.pFF pff) {
                com.bytedance.sdk.openadsdk.component.ExN.sc scVar2 = new com.bytedance.sdk.openadsdk.component.ExN.sc(iQT, sfl, scVar);
                TRI.this.sc(scVar2);
                com.bytedance.sdk.openadsdk.component.We.sc.sc(scVar2.pFF(), 1, wp2);
                TRI.this.pFF(adSlot);
            }
        });
    }

    public static TRI sc(Context context) {
        if (f27751sc == null) {
            synchronized (TRI.class) {
                try {
                    if (f27751sc == null) {
                        f27751sc = new TRI(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f27751sc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(@NonNull final com.bytedance.sdk.openadsdk.core.model.Sfl sfl, final AdSlot adSlot, final WP wp2, final com.bytedance.sdk.openadsdk.core.model.sc scVar) {
        final int iQT = sfl.QT();
        sc(sfl, adSlot, wp2, new zY() { // from class: com.bytedance.sdk.openadsdk.component.TRI.5
            @Override // com.bytedance.sdk.openadsdk.component.TRI.zY
            public void sc() {
                com.bytedance.sdk.openadsdk.component.ExN.sc scVar2 = new com.bytedance.sdk.openadsdk.component.ExN.sc(iQT, sfl, scVar);
                TRI.this.sc(scVar2);
                com.bytedance.sdk.openadsdk.component.We.sc.sc(scVar2.pFF(), 1, wp2);
                TRI.this.pFF(adSlot);
            }

            @Override // com.bytedance.sdk.openadsdk.component.TRI.zY
            public void sc(int i11, String str) {
                TRI.this.pFF(adSlot);
            }
        });
    }

    public static void sc(com.bytedance.sdk.openadsdk.core.model.Sfl sfl, We we2) {
        sc(sfl, we2, 0);
    }

    public static void sc(com.bytedance.sdk.openadsdk.core.model.Sfl sfl, final We we2, final int i11) {
        String strR = sfl.GI().r();
        if (TextUtils.isEmpty(strR)) {
            return;
        }
        com.bytedance.sdk.openadsdk.Ol.We.sc(strR).sc(sfl.GI().L()).pFF(sfl.GI().z()).ExN(kX.We(Xc.sc())).We(kX.zY(Xc.sc())).zY(2).sc(new com.bytedance.sdk.component.ExN.Qj() { // from class: com.bytedance.sdk.openadsdk.component.TRI.3
            @Override // com.bytedance.sdk.component.ExN.Qj
            public Bitmap sc(Bitmap bitmap) {
                return i11 <= 0 ? bitmap : com.bytedance.sdk.component.adexpress.We.sc.sc(Xc.sc(), bitmap, i11);
            }
        }).sc(new com.bytedance.sdk.openadsdk.Ol.pFF(sfl, strR, new dE<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.component.TRI.2
            @Override // com.bytedance.sdk.component.ExN.dE
            public void sc(int i12, String str, @Nullable Throwable th2) {
            }

            @Override // com.bytedance.sdk.component.ExN.dE
            public void sc(UFX<Bitmap> ufx) {
                We we3;
                if (ufx == null || ufx.pFF() == null || ufx.zY() == null || (we3 = we2) == null) {
                    return;
                }
                we3.sc(ufx.pFF());
            }
        }));
    }

    private int zY(AdSlot adSlot) {
        StringBuilder sb2 = new StringBuilder("material_expiration_time");
        sb2.append(adSlot.getCodeId());
        return com.bytedance.sdk.openadsdk.multipro.We.We.sc("tt_openad", sb2.toString(), -1L) == -1 ? 0 : 1;
    }

    @Nullable
    public com.bytedance.sdk.openadsdk.core.model.Sfl ExN(int i11) {
        com.bytedance.sdk.openadsdk.core.model.Sfl sflTRI;
        if (com.bytedance.sdk.openadsdk.common.sc.sc()) {
            com.bytedance.sdk.openadsdk.core.model.sc scVarSc = com.bytedance.sdk.openadsdk.common.sc.sc("tt_openad_materialMeta").sc(String.valueOf(i11), false);
            sflTRI = scVarSc != null ? scVarSc.TRI() : null;
        } else {
            sflTRI = TRI(i11);
        }
        long jSc = com.bytedance.sdk.openadsdk.multipro.We.We.sc("tt_openad", "material_expiration_time".concat(String.valueOf(i11)), -1L);
        if (System.currentTimeMillis() / 1000 < jSc && sflTRI != null) {
            return sflTRI;
        }
        if (sflTRI != null || jSc != -1) {
            qr(i11);
            if (sflTRI != null) {
                com.bytedance.sdk.openadsdk.component.We.sc.sc(sflTRI);
            }
        }
        return null;
    }

    @Nullable
    public com.bytedance.sdk.openadsdk.core.model.Sfl TRI(int i11) {
        String strPFF = com.bytedance.sdk.openadsdk.multipro.We.We.pFF("tt_openad_materialMeta", "material".concat(String.valueOf(i11)), null);
        if (!TextUtils.isEmpty(strPFF)) {
            try {
                JSONObject jSONObjectSc = Xc.zY().sc(new JSONObject(strPFF));
                return jSONObjectSc.has("creatives") ? com.bytedance.sdk.openadsdk.core.model.sc.zY(jSONObjectSc).TRI() : com.bytedance.sdk.openadsdk.core.pFF.sc(jSONObjectSc);
            } catch (Exception e11) {
                Tf.sc("TTAppOpenAdCacheManager", e11.getMessage());
            }
        }
        return null;
    }

    public boolean We(int i11) {
        return com.bytedance.sdk.openadsdk.multipro.We.We.sc("tt_openad", "image_has_cached".concat(String.valueOf(i11)), false);
    }

    public String pFF() {
        String name = new File(CacheDirFactory.getRootDir()).getName();
        if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            return name + "/openad_image_cache/";
        }
        return name + "//openad_image_cache/";
    }

    public boolean pFF(int i11) {
        return com.bytedance.sdk.openadsdk.multipro.We.We.sc("tt_openad", "video_has_cached".concat(String.valueOf(i11)), false);
    }

    public boolean pFF(com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        if (sfl == null || sfl.ht() == null || sfl.ht().size() == 0 || TextUtils.isEmpty(sfl.ht().get(0).sc())) {
            return false;
        }
        BT bt2 = sfl.ht().get(0);
        return sc(bt2.sc(), bt2.qr());
    }

    public void qr(int i11) {
        com.bytedance.sdk.openadsdk.multipro.We.We.sc("tt_openad_materialMeta", "material".concat(String.valueOf(i11)));
        com.bytedance.sdk.openadsdk.multipro.We.We.sc("tt_openad", "material_expiration_time".concat(String.valueOf(i11)));
        com.bytedance.sdk.openadsdk.multipro.We.We.sc("tt_openad", "video_has_cached".concat(String.valueOf(i11)));
        com.bytedance.sdk.openadsdk.multipro.We.We.sc("tt_openad", "image_has_cached".concat(String.valueOf(i11)));
    }

    @Nullable
    public String sc(com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        if (sfl != null && sfl.GI() != null && !TextUtils.isEmpty(sfl.GI().q())) {
            String strQ = sfl.GI().q();
            String strK = sfl.GI().k();
            if (TextUtils.isEmpty(strK)) {
                strK = com.bytedance.sdk.component.utils.ExN.sc(strQ);
            }
            File fileSc = com.bytedance.sdk.openadsdk.component.qr.sc.sc(strK);
            if (fileSc.exists() && fileSc.isFile()) {
                return fileSc.getAbsolutePath();
            }
        }
        return null;
    }

    public void sc() {
        File[] fileArrListFiles;
        try {
            com.bytedance.sdk.openadsdk.multipro.We.We.sc("tt_openad_materialMeta");
            com.bytedance.sdk.openadsdk.multipro.We.We.sc("tt_openad");
        } catch (Throwable unused) {
        }
        try {
            File cacheDir = this.We.getCacheDir();
            if (cacheDir == null || !cacheDir.exists() || !cacheDir.isDirectory() || (fileArrListFiles = cacheDir.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.component.TRI.9
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    if (file == null) {
                        return false;
                    }
                    String name = file.getName();
                    return name.contains("openad_image_cache") || name.contains("openad_video_cache");
                }
            })) == null) {
                return;
            }
            for (File file : fileArrListFiles) {
                try {
                    com.bytedance.sdk.component.utils.TRI.zY(file);
                } catch (Throwable unused2) {
                }
            }
        } catch (Throwable unused3) {
        }
    }

    public void sc(int i11) {
        com.bytedance.sdk.openadsdk.multipro.We.We.sc("tt_openad", "video_has_cached".concat(String.valueOf(i11)), Boolean.TRUE);
    }

    public void sc(final AdSlot adSlot) {
        if (adSlot == null || !TextUtils.isEmpty(adSlot.getBidAdm())) {
            return;
        }
        AtomicInteger atomicInteger = this.ExN.get(adSlot.getCodeId());
        if (atomicInteger == null) {
            atomicInteger = new AtomicInteger(0);
        }
        if (atomicInteger.get() + zY(adSlot) > 0) {
            return;
        }
        atomicInteger.incrementAndGet();
        this.ExN.put(adSlot.getCodeId(), atomicInteger);
        final WP wp2 = new WP();
        wp2.sc(OXF.pFF());
        Dl dl2 = new Dl();
        dl2.WH = wp2;
        dl2.We = 2;
        dl2.Qj = 2;
        this.zY.sc(adSlot, dl2, 3, new Sfl.sc() { // from class: com.bytedance.sdk.openadsdk.component.TRI.4
            @Override // com.bytedance.sdk.openadsdk.core.Sfl.sc
            public void sc(int i11, String str) {
                TRI.this.pFF(adSlot);
            }

            @Override // com.bytedance.sdk.openadsdk.core.Sfl.sc
            public void sc(com.bytedance.sdk.openadsdk.core.model.sc scVar, com.bytedance.sdk.openadsdk.core.model.pFF pff) {
                if (scVar == null || scVar.We() == null || scVar.We().size() == 0) {
                    pff.sc(-3);
                    com.bytedance.sdk.openadsdk.core.model.pFF.sc(pff);
                    return;
                }
                com.bytedance.sdk.openadsdk.core.model.Sfl sfl = scVar.We().get(0);
                if (sfl == null || !sfl.LVf()) {
                    if (com.bytedance.sdk.openadsdk.core.model.Sfl.ExN(sfl)) {
                        TRI.this.sc(sfl, adSlot, wp2, scVar);
                        return;
                    } else {
                        TRI.this.pFF(sfl, adSlot, wp2, scVar);
                        return;
                    }
                }
                com.bytedance.sdk.openadsdk.component.ExN.sc scVar2 = new com.bytedance.sdk.openadsdk.component.ExN.sc(sfl.QT(), sfl, scVar);
                TRI.this.sc(scVar2);
                com.bytedance.sdk.openadsdk.component.We.sc.sc(scVar2.pFF(), 1, wp2);
                TRI.this.pFF(adSlot);
            }
        });
    }

    public void sc(com.bytedance.sdk.openadsdk.component.ExN.sc scVar) {
        if (scVar.pFF() == null || com.bytedance.sdk.openadsdk.core.model.Sfl.TRI(scVar.pFF())) {
            return;
        }
        com.bytedance.sdk.openadsdk.multipro.We.We.sc("tt_openad", "material_expiration_time" + scVar.sc(), Long.valueOf(scVar.pFF().gsl()));
        pFF(scVar);
    }

    public void sc(@NonNull final com.bytedance.sdk.openadsdk.core.model.Sfl sfl, AdSlot adSlot, final WP wp2, final zY zYVar) {
        final OXF oxfPFF = OXF.pFF();
        final int iQT = sfl.QT();
        a aVarGI = sfl.GI();
        String strQ = aVarGI.q();
        String strK = aVarGI.k();
        if (TextUtils.isEmpty(strK)) {
            strK = com.bytedance.sdk.component.utils.ExN.sc(strQ);
        }
        final File fileSc = com.bytedance.sdk.openadsdk.component.qr.sc.sc(strK);
        if (fileSc.exists()) {
            com.bytedance.sdk.openadsdk.component.qr.sc.sc(fileSc);
            sc(iQT);
            long jWe = oxfPFF.We();
            if (wp2 != null) {
                wp2.sc(jWe);
                wp2.sc(1);
            }
            zYVar.sc();
            sc(sfl, (We) null);
            return;
        }
        if (Xc.We().cvk(String.valueOf(iQT)) && !com.bytedance.sdk.component.utils.BT.We(Xc.sc())) {
            zYVar.sc(100, "OnlyWifi");
            return;
        }
        com.bytedance.sdk.openadsdk.core.Ql.sc.pFF pffSc = com.bytedance.sdk.openadsdk.core.model.Sfl.sc(fileSc.getParent(), sfl);
        pffSc.sc("material_meta", sfl);
        pffSc.sc("ad_slot", adSlot);
        com.bytedance.sdk.openadsdk.core.Ql.ExN.sc.sc(pffSc, new b.a() { // from class: com.bytedance.sdk.openadsdk.component.TRI.7
            @Override // r8.b.a
            public void pFF(com.bykv.vk.openvk.sc.sc.sc.zY.zY zYVar2, int i11) {
            }

            @Override // r8.b.a
            public void sc(com.bykv.vk.openvk.sc.sc.sc.zY.zY zYVar2, int i11) {
                TRI.this.sc(iQT);
                long jWe2 = oxfPFF.We();
                com.bytedance.sdk.openadsdk.component.We.sc.pFF(sfl, jWe2, true);
                WP wp3 = wp2;
                if (wp3 != null) {
                    wp3.sc(jWe2);
                    wp2.sc(2);
                }
                zYVar.sc();
                TRI.sc(sfl, (We) null);
            }

            @Override // r8.b.a
            public void sc(com.bykv.vk.openvk.sc.sc.sc.zY.zY zYVar2, int i11, String str) {
                long jWe2 = oxfPFF.We();
                com.bytedance.sdk.openadsdk.component.We.sc.pFF(sfl, jWe2, false);
                WP wp3 = wp2;
                if (wp3 != null) {
                    wp3.sc(jWe2);
                }
                zYVar.sc(i11, str);
                try {
                    if (fileSc.exists() && fileSc.isFile()) {
                        com.bytedance.sdk.component.utils.TRI.zY(fileSc);
                    }
                } catch (Throwable unused) {
                }
            }
        });
        if (Build.VERSION.SDK_INT < 23) {
            sc(new File(c.e().getCacheDir(), "proxy_cache"));
            sc(iQT);
            long jWe2 = oxfPFF.We();
            com.bytedance.sdk.openadsdk.component.We.sc.pFF(sfl, jWe2, true);
            if (wp2 != null) {
                wp2.sc(jWe2);
                wp2.sc(2);
            }
            zYVar.sc();
            sc(sfl, (We) null);
        }
    }

    public void sc(final com.bytedance.sdk.openadsdk.core.model.Sfl sfl, final WP wp2, final pFF pff) {
        final OXF oxfPFF = OXF.pFF();
        final int iQT = sfl.QT();
        BT bt2 = sfl.ht().get(0);
        String strQr = bt2.qr();
        String strSc = bt2.sc();
        int iPFF = bt2.pFF();
        int iZY = bt2.zY();
        String strSc2 = TextUtils.isEmpty(strQr) ? com.bytedance.sdk.component.utils.ExN.sc(strSc) : strQr;
        if (TextUtils.isEmpty(strSc2)) {
            if (pff != null) {
                pff.sc();
                return;
            }
            return;
        }
        File filePFF = com.bytedance.sdk.openadsdk.component.qr.sc.pFF(strSc2);
        if (!sc(strSc, strQr)) {
            com.bytedance.sdk.openadsdk.utils.BT.sc(new com.bytedance.sdk.openadsdk.Xc.sc(strSc, bt2.qr()), iPFF, iZY, new com.bytedance.sdk.openadsdk.utils.BT.sc() { // from class: com.bytedance.sdk.openadsdk.component.TRI.8
                @Override // com.bytedance.sdk.openadsdk.utils.BT.sc
                public void sc() {
                    com.bytedance.sdk.openadsdk.component.We.sc.sc(sfl, oxfPFF.We(), false);
                    pff.sc();
                }

                @Override // com.bytedance.sdk.openadsdk.utils.BT.sc
                public void sc(@NonNull com.bytedance.sdk.openadsdk.Xc.sc.pFF pff2) {
                    if (!pff2.We()) {
                        com.bytedance.sdk.openadsdk.component.We.sc.sc(sfl, oxfPFF.We(), false);
                        pff.sc();
                        return;
                    }
                    TRI.this.zY(iQT);
                    long jWe = oxfPFF.We();
                    com.bytedance.sdk.openadsdk.component.We.sc.sc(sfl, jWe, true);
                    WP wp3 = wp2;
                    if (wp3 != null) {
                        wp3.sc(jWe);
                        wp2.sc(2);
                    }
                    pff.sc(pff2);
                }
            }, filePFF.getParent());
            return;
        }
        zY(iQT);
        long jWe = oxfPFF.We();
        if (wp2 != null) {
            wp2.sc(jWe);
            wp2.sc(1);
        }
        pff.sc(null);
    }

    public void sc(File file) {
        try {
            this.pFF.sc(file);
        } catch (IOException e11) {
            Tf.sc("TTAppOpenAdCacheManager", "trimFileCache fail", e11);
        }
    }

    public boolean sc(String str, String str2) {
        boolean z11;
        try {
            if (TextUtils.isEmpty(str2)) {
                str2 = com.bytedance.sdk.component.utils.ExN.sc(str);
            }
            File filePFF = com.bytedance.sdk.openadsdk.component.qr.sc.pFF(str2);
            InputStream inputStreamSc = com.bytedance.sdk.openadsdk.Ol.We.sc(str, str2);
            if (inputStreamSc != null) {
                try {
                    inputStreamSc.close();
                } catch (IOException e11) {
                    Tf.sc("TTAppOpenAdCacheManager", e11.getMessage());
                }
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                if (com.bytedance.sdk.openadsdk.Ol.We.sc(str, str2, filePFF.getParent())) {
                    return true;
                }
                if (new File(filePFF.getPath() + ".0").exists()) {
                    return true;
                }
            }
            return z11;
        } catch (Exception e12) {
            Tf.sc("TTAppOpenAdCacheManager", e12.getMessage());
            return false;
        }
    }

    public void zY(int i11) {
        com.bytedance.sdk.openadsdk.multipro.We.We.sc("tt_openad", "image_has_cached".concat(String.valueOf(i11)), Boolean.TRUE);
    }
}
