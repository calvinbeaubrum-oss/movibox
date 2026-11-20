package com.bytedance.sdk.component.adexpress.sc.pFF;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.Tf;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class qr {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static volatile qr f26905sc;
    private AtomicBoolean pFF = new AtomicBoolean(false);

    private qr() {
    }

    private void pFF() {
        if (com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().zY() == null) {
            return;
        }
        int iSc = com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().zY().sc();
        if (iSc <= 0) {
            iSc = 100;
        }
        List<com.bytedance.sdk.component.adexpress.sc.zY.pFF> listPFF = TRI.sc().pFF();
        if (listPFF == null || listPFF.isEmpty() || iSc >= listPFF.size()) {
            if (listPFF == null) {
                return;
            }
            listPFF.size();
            return;
        }
        TreeMap treeMap = new TreeMap();
        for (com.bytedance.sdk.component.adexpress.sc.zY.pFF pff : listPFF) {
            treeMap.put(pff.qr(), pff);
        }
        HashSet hashSet = new HashSet();
        int size = (int) (listPFF.size() - (iSc * 0.75f));
        int i11 = 0;
        for (Map.Entry entry : treeMap.entrySet()) {
            if (entry != null && i11 < size) {
                i11++;
                ((Long) entry.getKey()).longValue();
                com.bytedance.sdk.component.adexpress.sc.zY.pFF pff2 = (com.bytedance.sdk.component.adexpress.sc.zY.pFF) entry.getValue();
                if (pff2 != null) {
                    hashSet.add(pff2.pFF());
                }
            }
        }
        sc(hashSet);
        this.pFF.set(false);
    }

    private void pFF(String str, String str2, String str3, String str4, String str5, String str6) {
        TRI.sc().sc(new com.bytedance.sdk.component.adexpress.sc.zY.pFF().sc(str).pFF(str2).zY(str3).We(str4).ExN(str5).TRI(str6).sc(Long.valueOf(System.currentTimeMillis())), false);
        pFF();
    }

    public static qr sc() {
        if (f26905sc == null) {
            synchronized (qr.class) {
                try {
                    if (f26905sc == null) {
                        f26905sc = new qr();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f26905sc;
    }

    private void sc(String str, String str2, String str3) {
        JSONObject jSONObjectZY;
        if (TextUtils.isEmpty(str) || (jSONObjectZY = zY(str)) == null) {
            return;
        }
        String strOptString = jSONObjectZY.optString("md5");
        String strOptString2 = jSONObjectZY.optString("version");
        String strOptString3 = jSONObjectZY.optString("data");
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2) || TextUtils.isEmpty(strOptString3)) {
            return;
        }
        com.bytedance.sdk.component.adexpress.sc.zY.pFF pffSc = new com.bytedance.sdk.component.adexpress.sc.zY.pFF().sc(str2).pFF(str3).zY(strOptString).We(str).ExN(strOptString3).TRI(strOptString2).sc(Long.valueOf(System.currentTimeMillis()));
        TRI.sc().sc(pffSc, false);
        pFF();
        if (Qj.sc(strOptString2)) {
            pffSc.TRI(strOptString2);
            ExN.pFF().sc(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void sc(String str, String str2, String str3, String str4, String str5, String str6) {
        if (sc(str) != null) {
            if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
                pFF(str6, str, str3, str2, str4, str5);
            }
            return;
        } else if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
            sc(str2, str6, str);
        } else {
            pFF(str6, str, str3, str2, str4, str5);
        }
        boolean zSc = Qj.sc(str5);
        if (!pFF.ExN() || zSc) {
            ExN.pFF().sc(true);
        }
    }

    private JSONObject zY(String str) {
        com.bytedance.sdk.component.adexpress.sc.sc.zY zYVarZY = com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().zY();
        if (zYVarZY == null) {
            return null;
        }
        com.bytedance.sdk.component.qr.pFF.pFF pffQr = zYVarZY.qr();
        pffQr.pFF(str);
        com.bytedance.sdk.component.qr.pFF pffSc = pffQr.sc();
        if (pffSc != null) {
            try {
                if (pffSc.TRI() && pffSc.We() != null) {
                    return new JSONObject(pffSc.We());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public Set<String> pFF(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return TRI.sc().pFF(str);
    }

    public com.bytedance.sdk.component.adexpress.sc.zY.pFF sc(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return TRI.sc().sc(str);
    }

    public void sc(com.bytedance.sdk.component.adexpress.sc.zY.We we2, String str) {
        if (we2 == null) {
            Tf.sc("TmplDiffManager", "saveTemplate error: tplInfo == null");
            return;
        }
        final String str2 = we2.f26910sc;
        final String str3 = we2.zY;
        final String str4 = we2.pFF;
        final String str5 = we2.We;
        final String str6 = we2.ExN;
        final String strQj = TextUtils.isEmpty(str) ? com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().zY() != null ? com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().zY().Qj() : "" : str;
        if (TextUtils.isEmpty(str2)) {
            Tf.sc("TmplDiffManager", "saveTemplate error:tmpId is empty");
        } else {
            com.bytedance.sdk.component.adexpress.We.We.sc(new com.bytedance.sdk.component.Qj.Qj("saveTemplate") { // from class: com.bytedance.sdk.component.adexpress.sc.pFF.qr.1
                @Override // java.lang.Runnable
                public void run() {
                    qr.this.sc(str2, str3, str4, str5, str6, strQj);
                }
            }, 10);
        }
    }

    public void sc(Set<String> set) {
        try {
            TRI.sc().sc(set);
        } catch (Throwable th2) {
            th2.getMessage();
        }
    }
}
