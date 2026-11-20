package com.bytedance.sdk.openadsdk.Sfl.sc;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import androidx.annotation.Nullable;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.bytedance.sdk.component.Qj.Qj;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.component.utils.cvk;
import com.bytedance.sdk.openadsdk.core.SR;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.utils.Cb;
import java.io.File;
import java.io.FileInputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static volatile zY f27265sc;
    private final Set<String> ExN = Collections.synchronizedSet(new HashSet());
    private String We;
    private String pFF;
    private String zY;

    private String ExN() {
        if (TextUtils.isEmpty(this.zY)) {
            String str = We() + File.separator + "common";
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.zY = str;
        }
        return this.zY;
    }

    private String TRI() {
        if (TextUtils.isEmpty(this.We)) {
            String str = We() + File.separator + "pregames";
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.We = str;
        }
        return this.We;
    }

    private String We() {
        if (TextUtils.isEmpty(this.pFF)) {
            try {
                File file = new File(Xc.sc().getCacheDir(), "playable");
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.pFF = file.getAbsolutePath();
            } catch (Throwable th2) {
                Tf.sc("PlayableResManager", "init root path error: ".concat(String.valueOf(th2)));
            }
        }
        return this.pFF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF(final String str) {
        Cb.sc(new Qj("pag_plb_update_config") { // from class: com.bytedance.sdk.openadsdk.Sfl.sc.zY.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.component.qr.pFF.pFF pffZY = com.bytedance.sdk.openadsdk.Xc.zY.sc().pFF().zY();
                try {
                    pffZY.pFF(com.bytedance.sdk.openadsdk.Qj.We.sc(pffZY, str));
                    com.bytedance.sdk.component.qr.pFF pffSc = pffZY.sc();
                    if (pffSc == null || !pffSc.TRI()) {
                        return;
                    }
                    String strWe = pffSc.We();
                    com.bytedance.sdk.openadsdk.Sfl.pFF.sc scVarPFF = com.bytedance.sdk.openadsdk.Sfl.pFF.sc.pFF(strWe);
                    com.bytedance.sdk.openadsdk.multipro.We.We.sc("pag_plb_config", "last_update_time", Long.valueOf(System.currentTimeMillis()));
                    if (scVarPFF != null) {
                        com.bytedance.sdk.openadsdk.Sfl.pFF.sc scVarPFF2 = com.bytedance.sdk.openadsdk.Sfl.pFF.sc.pFF(com.bytedance.sdk.openadsdk.multipro.We.We.pFF("pag_plb_config", "model", ""));
                        if (scVarPFF2 != null && scVarPFF.sc().equals(scVarPFF2.sc())) {
                            return;
                        }
                        com.bytedance.sdk.openadsdk.multipro.We.We.sc("pag_plb_config", "model", strWe);
                        zY.this.sc(scVarPFF, scVarPFF2, 1);
                    }
                } catch (Exception e11) {
                    Tf.sc("PlayableResManager", e11.getMessage());
                }
            }
        });
    }

    public static zY sc() {
        if (f27265sc == null) {
            synchronized (zY.class) {
                try {
                    if (f27265sc == null) {
                        f27265sc = new zY();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f27265sc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void sc(com.bytedance.sdk.openadsdk.Sfl.pFF.sc scVar, @Nullable com.bytedance.sdk.openadsdk.Sfl.pFF.sc scVar2, int i11) {
        List<com.bytedance.sdk.openadsdk.Sfl.pFF.sc.C0270sc> listZY = null;
        sc(scVar.pFF(), scVar2 == null ? null : scVar2.pFF(), 1, i11);
        List<com.bytedance.sdk.openadsdk.Sfl.pFF.sc.C0270sc> listZY2 = scVar.zY();
        if (scVar2 != null) {
            listZY = scVar2.zY();
        }
        sc(listZY2, listZY, 2, i11);
    }

    private void sc(final String str, final String str2, final String str3, final int i11, final File file, final boolean z11) {
        String strConcat;
        if (this.ExN.contains(str)) {
            return;
        }
        if (i11 == 2) {
            strConcat = str3 + ".zip";
        } else {
            strConcat = z11 ? "tmp".concat(String.valueOf(str3)) : str3;
        }
        this.ExN.add(str);
        com.bytedance.sdk.component.qr.pFF.sc scVarWe = com.bytedance.sdk.openadsdk.Xc.zY.sc().pFF().We();
        scVarWe.pFF(str);
        scVarWe.sc(str2, strConcat);
        final com.bytedance.sdk.component.qr.pFF pffSc = scVarWe.sc();
        this.ExN.remove(str);
        if (pffSc != null && pffSc.TRI() && pffSc.ExN() != null && pffSc.ExN().exists()) {
            if (i11 == 2) {
                Cb.pFF(new Qj("downloadZip") { // from class: com.bytedance.sdk.openadsdk.Sfl.sc.zY.5
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (z11) {
                                file.delete();
                            }
                            String str4 = str2 + File.separator + str3;
                            cvk.sc(pffSc.ExN().getAbsolutePath(), str4);
                            File file2 = new File(str4);
                            File fileSc = com.bytedance.sdk.openadsdk.core.Ql.zY.sc.sc(file2);
                            if (fileSc != null && fileSc.exists()) {
                                com.bytedance.sdk.openadsdk.core.Ql.zY.sc.sc().zY().put(file2.getName(), fileSc.getAbsolutePath());
                            }
                            com.bytedance.sdk.openadsdk.core.Ql.zY.sc.pFF(file2);
                        } catch (Throwable th2) {
                            Tf.sc("PlayableResManager", "unzip error: ", th2, "tp=", Integer.valueOf(i11), ", url=", str);
                        }
                        try {
                            pffSc.ExN().delete();
                        } catch (Throwable unused) {
                        }
                    }
                });
                return;
            } else {
                if (z11) {
                    file.delete();
                    pffSc.ExN().renameTo(file);
                    return;
                }
                return;
            }
        }
        File file2 = new File(str2 + File.separator + str3 + ".tmp");
        if (file2.exists()) {
            try {
                file2.delete();
            } catch (Throwable unused) {
            }
        }
    }

    private void sc(@Nullable List<com.bytedance.sdk.openadsdk.Sfl.pFF.sc.C0270sc> list, @Nullable List<com.bytedance.sdk.openadsdk.Sfl.pFF.sc.C0270sc> list2, int i11, int i12) {
        if (list == null || list.isEmpty()) {
            return;
        }
        String strExN = i11 == 1 ? ExN() : TRI();
        for (com.bytedance.sdk.openadsdk.Sfl.pFF.sc.C0270sc c0270sc : list) {
            String strSc = c0270sc.sc();
            String strSc2 = com.bytedance.sdk.component.ExN.zY.zY.zY.sc(strSc);
            if (!TextUtils.isEmpty(strSc2)) {
                if (i11 == 1) {
                    strSc2 = strSc2 + zY(strSc);
                }
                String str = strSc2;
                File file = new File(strExN, str);
                boolean zExists = file.exists();
                if (i12 == 1) {
                    if (zExists && list2 != null && list2.contains(c0270sc)) {
                        com.bytedance.sdk.openadsdk.core.Ql.zY.sc.zY(file);
                    } else {
                        sc(strSc, strExN, str, i11, file, zExists);
                    }
                } else if (!zExists) {
                    sc(strSc, strExN, str, i11, file, zExists);
                }
            }
        }
    }

    private static String zY(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int iIndexOf = str.indexOf("?");
        if (iIndexOf != -1) {
            str = str.substring(0, iIndexOf);
        }
        int iLastIndexOf = str.lastIndexOf(InstructionFileId.DOT);
        if (iLastIndexOf == -1) {
            return "";
        }
        return InstructionFileId.DOT + str.substring(iLastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zY() {
        Cb.sc(new Qj("pag_plb_res_check") { // from class: com.bytedance.sdk.openadsdk.Sfl.sc.zY.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.Sfl.pFF.sc scVarPFF = com.bytedance.sdk.openadsdk.Sfl.pFF.sc.pFF(com.bytedance.sdk.openadsdk.multipro.We.We.pFF("pag_plb_config", "model", ""));
                if (scVarPFF != null) {
                    zY.this.sc(scVarPFF, null, 0);
                }
            }
        });
    }

    public void pFF() {
        if (com.bytedance.sdk.openadsdk.core.settings.Tf.sc() && com.bytedance.sdk.openadsdk.YIK.sc.sc("plb_res_enable", 0) == 1) {
            long jCurrentTimeMillis = System.currentTimeMillis() - com.bytedance.sdk.openadsdk.multipro.We.We.sc("pag_plb_config", "last_update_time", 0L);
            final String strSc = com.bytedance.sdk.openadsdk.YIK.sc.sc("plb_res", "");
            long jSc = com.bytedance.sdk.openadsdk.YIK.sc.sc("plb_res_fetch_interval", 3600000);
            if (jSc <= 0 || jSc > 259200000) {
                jSc = 3600000;
            }
            if (jCurrentTimeMillis < jSc || TextUtils.isEmpty(strSc)) {
                return;
            }
            int iSc = com.bytedance.sdk.openadsdk.YIK.sc.sc("plb_res_delay_fetch_time", 0);
            if (iSc <= 0) {
                pFF(strSc);
            } else {
                SR.pFF().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.Sfl.sc.zY.3
                    @Override // java.lang.Runnable
                    public void run() {
                        zY.this.pFF(strSc);
                    }
                }, iSc);
            }
        }
    }

    public WebResourceResponse sc(String str) {
        if (com.bytedance.sdk.openadsdk.core.settings.Tf.sc() && com.bytedance.sdk.openadsdk.YIK.sc.sc("plb_res_enable", 0) == 1) {
            String strSc = com.bytedance.sdk.component.ExN.zY.zY.zY.sc(str);
            if (TextUtils.isEmpty(strSc)) {
                return null;
            }
            File file = new File(ExN(), strSc + zY(str));
            if (file.exists()) {
                try {
                    return new WebResourceResponse(com.bytedance.sdk.component.utils.SR.sc(Xc.sc(), str), "UTF-8", new FileInputStream(file));
                } catch (Throwable unused) {
                }
            }
        }
        return null;
    }

    public void sc(Map<String, String> map) {
        File[] fileArrListFiles;
        if (com.bytedance.sdk.openadsdk.core.settings.Tf.sc() && com.bytedance.sdk.openadsdk.YIK.sc.sc("plb_res_enable", 0) == 1) {
            String strTRI = TRI();
            if (!TextUtils.isEmpty(strTRI)) {
                File file = new File(strTRI);
                if (file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                    for (File file2 : fileArrListFiles) {
                        if (file2 != null) {
                            try {
                                File fileSc = com.bytedance.sdk.openadsdk.core.Ql.zY.sc.sc(file2);
                                if (fileSc != null && fileSc.exists()) {
                                    map.put(file2.getName(), fileSc.getAbsolutePath());
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    }
                }
            }
            int iSc = com.bytedance.sdk.openadsdk.YIK.sc.sc("plb_res_delay_fetch_time", 0);
            if (iSc <= 0) {
                zY();
            } else {
                SR.pFF().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.Sfl.sc.zY.1
                    @Override // java.lang.Runnable
                    public void run() {
                        zY.this.zY();
                    }
                }, iSc);
            }
        }
    }
}
