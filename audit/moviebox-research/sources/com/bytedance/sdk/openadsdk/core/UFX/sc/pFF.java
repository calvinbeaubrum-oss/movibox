package com.bytedance.sdk.openadsdk.core.UFX.sc;

import android.text.TextUtils;
import com.bytedance.sdk.component.Qj.Qj;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.core.Ol;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static volatile pFF f28301sc;

    /* JADX INFO: compiled from: source.java */
    public interface sc {
        void sc(int i11, String str, String str2);

        void sc(JSONObject jSONObject, String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF() {
        int iWe = Xc.We().We();
        if (iWe <= 0) {
            iWe = 100;
        }
        List<com.bytedance.sdk.openadsdk.core.UFX.sc.sc> listPFF = zY.sc().pFF();
        if (listPFF == null || listPFF.isEmpty() || iWe >= listPFF.size()) {
            if (listPFF == null) {
                return;
            }
            listPFF.size();
            return;
        }
        int size = (int) (listPFF.size() - (iWe * 0.75f));
        if (size <= 0) {
            return;
        }
        TreeMap treeMap = new TreeMap();
        for (com.bytedance.sdk.openadsdk.core.UFX.sc.sc scVar : listPFF) {
            treeMap.put(scVar.We(), scVar);
        }
        HashSet hashSet = new HashSet();
        int i11 = 0;
        for (Map.Entry entry : treeMap.entrySet()) {
            if (entry != null && i11 < size) {
                i11++;
                com.bytedance.sdk.openadsdk.core.UFX.sc.sc scVar2 = (com.bytedance.sdk.openadsdk.core.UFX.sc.sc) entry.getValue();
                if (scVar2 != null) {
                    hashSet.add(scVar2.sc());
                }
            }
        }
        sc(hashSet);
    }

    private void pFF(String str, String str2, String str3, String str4, String str5) {
        com.bytedance.sdk.openadsdk.core.UFX.sc.sc scVar = new com.bytedance.sdk.openadsdk.core.UFX.sc.sc();
        scVar.zY(str).ExN(str3).We(str4).pFF(str2).sc(str5).sc(Long.valueOf(System.currentTimeMillis()));
        zY.sc().sc(scVar);
        pFF();
    }

    public static pFF sc() {
        if (f28301sc == null) {
            synchronized (pFF.class) {
                try {
                    if (f28301sc == null) {
                        f28301sc = new pFF();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f28301sc;
    }

    private com.bytedance.sdk.openadsdk.core.UFX.sc.sc sc(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return zY.sc().sc(str, str2);
    }

    private void sc(final com.bytedance.sdk.openadsdk.core.UFX.sc.sc scVar) {
        scVar.sc(Long.valueOf(System.currentTimeMillis()));
        Cb.sc(new Qj("updateTmplTime") { // from class: com.bytedance.sdk.openadsdk.core.UFX.sc.pFF.4
            @Override // java.lang.Runnable
            public void run() {
                zY.sc().sc(scVar);
            }
        }, 10);
    }

    private void sc(final String str, final String str2, final String str3, final String str4, final sc scVar) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            if (scVar != null) {
                scVar.sc(1, "template url or id  or md5 is empty", "net");
            }
        } else {
            com.bytedance.sdk.component.qr.pFF.pFF pffZY = com.bytedance.sdk.openadsdk.Xc.zY.sc().pFF().zY();
            pffZY.pFF(str);
            pffZY.sc(7);
            pffZY.sc("load_ug_t");
            pffZY.sc(new com.bytedance.sdk.component.qr.sc.sc() { // from class: com.bytedance.sdk.openadsdk.core.UFX.sc.pFF.3
                @Override // com.bytedance.sdk.component.qr.sc.sc
                public void sc(com.bytedance.sdk.component.qr.pFF.zY zYVar, com.bytedance.sdk.component.qr.pFF pff) {
                    if (pff == null) {
                        return;
                    }
                    if (!pff.TRI()) {
                        sc scVar2 = scVar;
                        if (scVar2 != null) {
                            scVar2.sc(3, "net code error code is " + pff.sc() + " message is " + pff.pFF(), "net");
                            return;
                        }
                        return;
                    }
                    String strWe = pff.We();
                    if (TextUtils.isEmpty(strWe)) {
                        sc scVar3 = scVar;
                        if (scVar3 != null) {
                            scVar3.sc(3, "net data is null", "net");
                            return;
                        }
                        return;
                    }
                    zY.sc().sc(new com.bytedance.sdk.openadsdk.core.UFX.sc.sc().sc(str2).pFF(str3).zY(str).ExN(str4).We(strWe).sc(Long.valueOf(System.currentTimeMillis())));
                    pFF.this.pFF();
                    if (scVar != null) {
                        try {
                            scVar.sc(new JSONObject(strWe), "net");
                        } catch (JSONException unused) {
                            scVar.sc(2, "parse json exception data is".concat(String.valueOf(strWe)), "net");
                        }
                    }
                }

                @Override // com.bytedance.sdk.component.qr.sc.sc
                public void sc(com.bytedance.sdk.component.qr.pFF.zY zYVar, IOException iOException) {
                    sc scVar2 = scVar;
                    if (scVar2 != null) {
                        scVar2.sc(3, "net error " + iOException.getMessage(), "net");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(String str, String str2, String str3, String str4, String str5) {
        if (sc(str, str3) != null) {
            if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
                return;
            }
            pFF(str2, str3, str5, str4, str);
            return;
        }
        if (TextUtils.isEmpty(str4)) {
            sc(str2, str, str3, str5, (sc) null);
        } else {
            pFF(str2, str3, str5, str4, str);
        }
    }

    public String sc(String str, String str2, String str3) {
        com.bytedance.sdk.openadsdk.core.UFX.sc.sc scVarSc = sc(str + "_" + str2, str3);
        if (scVarSc == null) {
            return null;
        }
        sc(scVarSc);
        return scVarSc.ExN();
    }

    public Set<com.bytedance.sdk.openadsdk.core.UFX.sc.sc> sc(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return zY.sc().sc(str);
    }

    public void sc(com.bytedance.sdk.openadsdk.core.UFX.TRI.sc scVar, String str) {
        if (scVar == null) {
            return;
        }
        if (TextUtils.isEmpty(scVar.sc())) {
            Tf.sc("UGTemplateManager", "save ugen template error : tmpId is empty");
            return;
        }
        final String str2 = str + "_" + scVar.sc();
        final String strZY = scVar.zY();
        final String strPFF = scVar.pFF();
        final String strWe = scVar.We();
        String strExN = scVar.ExN();
        if (TextUtils.isEmpty(strExN)) {
            if (str.equals("ad")) {
                strExN = Ol.pFF().We();
            } else if (str.equals("adv3")) {
                strExN = Ol.pFF().We() + "_v3";
            }
        }
        final String str3 = strExN;
        Cb.sc(new Qj("saveUGenTemplate") { // from class: com.bytedance.sdk.openadsdk.core.UFX.sc.pFF.1
            @Override // java.lang.Runnable
            public void run() {
                pFF.this.sc(str2, strZY, strPFF, strWe, str3);
            }
        }, 10);
    }

    public void sc(String str, String str2, String str3, String str4, String str5, final sc scVar) {
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            if (scVar != null) {
                scVar.sc(1, "id  or md5 is empty", "net");
                return;
            }
            return;
        }
        String str6 = str + "_" + str3;
        com.bytedance.sdk.openadsdk.core.UFX.sc.sc scVarSc = sc(str6, str4);
        if (scVarSc == null || TextUtils.isEmpty(scVarSc.ExN())) {
            sc(str2, str6, str4, str5, new sc() { // from class: com.bytedance.sdk.openadsdk.core.UFX.sc.pFF.2
                @Override // com.bytedance.sdk.openadsdk.core.UFX.sc.pFF.sc
                public void sc(int i11, String str7, String str8) {
                    sc scVar2 = scVar;
                    if (scVar2 != null) {
                        scVar2.sc(i11, str7, str8);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.UFX.sc.pFF.sc
                public void sc(JSONObject jSONObject, String str7) {
                    sc scVar2 = scVar;
                    if (scVar2 != null) {
                        scVar2.sc(jSONObject, str7);
                    }
                }
            });
            return;
        }
        sc(scVarSc);
        if (scVar != null) {
            try {
                scVar.sc(new JSONObject(scVarSc.ExN()), ImagesContract.LOCAL);
            } catch (JSONException unused) {
                scVar.sc(2, "parse json exception data is " + scVarSc.ExN(), ImagesContract.LOCAL);
            }
        }
    }

    public void sc(Set<String> set) {
        try {
            zY.sc().sc(set);
        } catch (Throwable th2) {
            th2.getMessage();
        }
    }
}
