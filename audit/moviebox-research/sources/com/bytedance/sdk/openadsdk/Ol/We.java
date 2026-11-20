package com.bytedance.sdk.openadsdk.Ol;

import android.content.Context;
import com.bytedance.sdk.component.ExN.BT;
import com.bytedance.sdk.component.ExN.Dl;
import com.bytedance.sdk.component.ExN.WH;
import com.bytedance.sdk.component.pFF.sc.Ql;
import com.bytedance.sdk.component.pFF.sc.TRI;
import com.bytedance.sdk.component.pFF.sc.UFX;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.cD;
import com.bytedance.sdk.openadsdk.utils.kX;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class We {

    /* JADX INFO: compiled from: source.java */
    public static final class sc {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private static final BT f27104sc = sc(Xc.sc());

        /* JADX INFO: Access modifiers changed from: private */
        public static WH pFF(com.bytedance.sdk.openadsdk.core.model.BT bt2) {
            return sc(f27104sc.sc(bt2.sc()).sc(bt2.pFF()).pFF(bt2.zY()).ExN(kX.We(Xc.sc())).We(kX.zY(Xc.sc())).sc(bt2.qr()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static WH pFF(String str) {
            return sc(f27104sc.sc(str).ExN(kX.We(Xc.sc())).We(kX.zY(Xc.sc())));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static InputStream pFF(String str, String str2) {
            return f27104sc.sc(str, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean pFF(String str, String str2, String str3) {
            return f27104sc.sc(str, str2, str3);
        }

        private static BT sc(Context context) {
            return com.bytedance.sdk.component.ExN.zY.pFF.sc(context, new com.bytedance.sdk.component.ExN.zY.ExN.sc().sc(new com.bytedance.sdk.component.ExN.zY.sc.sc(Math.max(Math.min(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16, 83886080), 10485760), 41943040L, new File(CacheDirFactory.getImageCacheDir()))).sc(new Dl() { // from class: com.bytedance.sdk.openadsdk.Ol.We.sc.2
                @Override // com.bytedance.sdk.component.ExN.Dl
                public ExecutorService sc() {
                    return Cb.pFF();
                }
            }).sc(new com.bytedance.sdk.component.ExN.We() { // from class: com.bytedance.sdk.openadsdk.Ol.We.sc.1
                private com.bytedance.sdk.component.ExN.pFF.We sc(com.bytedance.sdk.component.ExN.pFF.ExN exN, Throwable th2) {
                    th2.getMessage();
                    if (exN != null) {
                        exN.zY(System.currentTimeMillis());
                    }
                    com.bytedance.sdk.component.ExN.pFF.We we2 = new com.bytedance.sdk.component.ExN.pFF.We(98765, th2, "net failed");
                    we2.sc(exN);
                    return we2;
                }

                private Map<String, String> sc(com.bytedance.sdk.component.ExN.ExN exN, com.bytedance.sdk.component.pFF.sc.BT bt2) {
                    if (!exN.pFF()) {
                        return null;
                    }
                    TRI triQr = bt2.qr();
                    HashMap map = new HashMap();
                    int iSc = triQr.sc();
                    for (int i11 = 0; i11 < iSc; i11++) {
                        String strSc = triQr.sc(i11);
                        String strPFF = triQr.pFF(i11);
                        if (strSc != null) {
                            map.put(strSc, strPFF);
                        }
                    }
                    return map;
                }

                @Override // com.bytedance.sdk.component.ExN.We
                /* JADX INFO: renamed from: pFF, reason: merged with bridge method [inline-methods] */
                public com.bytedance.sdk.component.ExN.pFF.We sc(com.bytedance.sdk.component.ExN.ExN exN) {
                    UFX ufxExN = com.bytedance.sdk.openadsdk.Xc.zY.sc().pFF().ExN();
                    Ql qlPFF = new Ql.sc().pFF(exN.sc()).sc().pFF();
                    com.bytedance.sdk.component.pFF.sc.BT btPFF = null;
                    com.bytedance.sdk.component.ExN.pFF.ExN exN2 = exN.zY() ? new com.bytedance.sdk.component.ExN.pFF.ExN() : null;
                    if (exN2 != null) {
                        exN2.sc(System.currentTimeMillis());
                    }
                    try {
                        btPFF = ufxExN.sc(qlPFF).pFF();
                        if (exN2 != null) {
                            exN2.pFF(System.currentTimeMillis());
                        }
                        Map<String, String> mapSc = sc(exN, btPFF);
                        byte[] bArrWe = btPFF.TRI().We();
                        if (exN2 != null) {
                            exN2.zY(System.currentTimeMillis());
                        }
                        com.bytedance.sdk.component.ExN.pFF.We we2 = new com.bytedance.sdk.component.ExN.pFF.We(btPFF.zY(), bArrWe, "", mapSc);
                        we2.sc(exN2);
                        com.bytedance.sdk.component.ExN.zY.zY.pFF.sc(btPFF);
                        return we2;
                    } catch (Throwable th2) {
                        try {
                            return sc(exN2, th2);
                        } finally {
                            com.bytedance.sdk.component.ExN.zY.zY.pFF.sc(btPFF);
                        }
                    }
                }
            }).sc());
        }

        private static WH sc(WH wh2) {
            return cD.sc() ? wh2.sc(new ExN()) : wh2;
        }
    }

    public static BT sc() {
        return sc.f27104sc;
    }

    public static WH sc(com.bytedance.sdk.openadsdk.core.model.BT bt2) {
        return sc.pFF(bt2);
    }

    public static WH sc(String str) {
        return sc.pFF(str);
    }

    public static InputStream sc(String str, String str2) {
        return sc.pFF(str, str2);
    }

    public static boolean sc(String str, String str2, String str3) {
        return sc.pFF(str, str2, str3);
    }
}
