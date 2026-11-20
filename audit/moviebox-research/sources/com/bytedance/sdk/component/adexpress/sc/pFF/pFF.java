package com.bytedance.sdk.component.adexpress.sc.pFF;

import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebResourceResponse;
import com.bytedance.sdk.component.adexpress.We.WH;
import com.bytedance.sdk.component.utils.Tf;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    static Object f26903sc = new Object();

    public static boolean ExN() {
        return ExN.pFF().ExN();
    }

    private static boolean ExN(String str) {
        com.bytedance.sdk.component.adexpress.sc.zY.sc scVarWe;
        List<com.bytedance.sdk.component.adexpress.sc.zY.sc.C0259sc> listTRI;
        if (!ExN() || (scVarWe = We()) == null || (listTRI = scVarWe.TRI()) == null) {
            return false;
        }
        for (com.bytedance.sdk.component.adexpress.sc.zY.sc.C0259sc c0259sc : listTRI) {
            if (c0259sc != null && TextUtils.equals(str, c0259sc.sc())) {
                return true;
            }
        }
        return false;
    }

    private static File TRI(String str) {
        if (!ExN()) {
            return null;
        }
        for (com.bytedance.sdk.component.adexpress.sc.zY.sc.C0259sc c0259sc : We().TRI()) {
            if (c0259sc.sc() != null && c0259sc.sc().equals(str)) {
                File file = new File(ExN.Qj(), com.bytedance.sdk.component.utils.ExN.sc(c0259sc.sc()));
                String strSc = com.bytedance.sdk.component.utils.ExN.sc(file);
                if (c0259sc.pFF() == null || !c0259sc.pFF().equals(strSc)) {
                    return null;
                }
                return file;
            }
        }
        return null;
    }

    @Deprecated
    private static String TRI() {
        com.bytedance.sdk.component.adexpress.sc.zY.sc scVarWe = We();
        if (scVarWe == null) {
            return null;
        }
        return scVarWe.We();
    }

    public static com.bytedance.sdk.component.adexpress.sc.zY.sc We() {
        return ExN.pFF().TRI();
    }

    public static String We(String str) {
        com.bytedance.sdk.component.adexpress.sc.zY.sc scVar;
        com.bytedance.sdk.component.adexpress.sc.zY.sc scVarWe = We();
        if (scVarWe == null) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return TRI();
        }
        Map<String, com.bytedance.sdk.component.adexpress.sc.zY.sc> mapSc = scVarWe.sc();
        if (mapSc == null || mapSc.size() <= 0 || (scVar = mapSc.get(str)) == null) {
            return null;
        }
        return scVar.We();
    }

    private static File pFF(String str, String str2) {
        com.bytedance.sdk.component.adexpress.sc.zY.sc scVar;
        com.bytedance.sdk.component.adexpress.sc.zY.sc scVarWe = We();
        if (scVarWe == null || !ExN()) {
            return null;
        }
        Map<String, com.bytedance.sdk.component.adexpress.sc.zY.sc> mapSc = scVarWe.sc();
        if (mapSc.size() == 0 || (scVar = mapSc.get(str)) == null) {
            return null;
        }
        for (com.bytedance.sdk.component.adexpress.sc.zY.sc.C0259sc c0259sc : scVar.TRI()) {
            if (c0259sc.sc() != null && c0259sc.sc().equals(str2)) {
                File file = new File(ExN.Qj(), com.bytedance.sdk.component.utils.ExN.sc(c0259sc.sc()));
                String strSc = com.bytedance.sdk.component.utils.ExN.sc(file);
                if (c0259sc.pFF() == null || !c0259sc.pFF().equals(strSc)) {
                    return null;
                }
                return file;
            }
        }
        return null;
    }

    public static Set<String> pFF(String str) {
        return qr.sc().pFF(str);
    }

    public static void pFF() {
        try {
            Qj.We();
            File fileQj = ExN.Qj();
            if (fileQj == null || !fileQj.exists()) {
                return;
            }
            if (fileQj.getParentFile() != null) {
                com.bytedance.sdk.component.utils.TRI.zY(fileQj.getParentFile());
            } else {
                com.bytedance.sdk.component.utils.TRI.zY(fileQj);
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean pFF(JSONObject jSONObject) {
        Object objOpt;
        return (jSONObject == null || (objOpt = jSONObject.opt("xTemplate")) == null || TextUtils.isEmpty(objOpt.toString())) ? false : true;
    }

    private static File qr(String str) {
        List<Pair<String, String>> listPFF;
        com.bytedance.sdk.component.adexpress.sc.zY.sc.pFF pffExN = We().ExN();
        if (pffExN == null || (listPFF = pffExN.pFF()) == null || listPFF.size() <= 0) {
            return null;
        }
        for (Pair<String, String> pair : listPFF) {
            Object obj = pair.second;
            if (obj != null && ((String) obj).equals(str)) {
                return new File(ExN.Qj(), (String) pair.first);
            }
        }
        return null;
    }

    public static sc sc(String str, WH.sc scVar, String str2, String str3) {
        File fileTRI;
        sc scVar2 = new sc();
        if (TextUtils.isEmpty(str3)) {
            fileTRI = null;
        } else {
            fileTRI = pFF(str3, str);
            if (fileTRI != null) {
                scVar2.sc(1);
            }
        }
        if (fileTRI == null && (fileTRI = qr(str)) != null) {
            scVar2.sc(3);
        }
        if (fileTRI == null && (fileTRI = TRI(str)) != null) {
            scVar2.sc(2);
        }
        if (TextUtils.isEmpty(str3)) {
            if (!ExN(str)) {
                scVar2.sc(6);
            }
        } else if (!sc(str, str3)) {
            scVar2.sc(4);
        }
        scVar2.pFF();
        if (fileTRI != null) {
            try {
                scVar2.sc(new WebResourceResponse(scVar.sc(), "utf-8", new FileInputStream(fileTRI)));
            } catch (Throwable th2) {
                Tf.sc("TTDynamic", "get html WebResourceResponse error", th2);
            }
        }
        return scVar2;
    }

    public static com.bytedance.sdk.component.adexpress.sc.zY.pFF sc(String str) {
        return qr.sc().sc(str);
    }

    public static void sc() {
        ExN.pFF();
    }

    public static void sc(com.bytedance.sdk.component.adexpress.sc.zY.We we2) {
        qr.sc().sc(we2, we2.TRI);
    }

    private static void sc(final com.bytedance.sdk.component.adexpress.sc.zY.pFF pff) {
        com.bytedance.sdk.component.adexpress.We.We.sc(new com.bytedance.sdk.component.Qj.Qj("updateTmplTime") { // from class: com.bytedance.sdk.component.adexpress.sc.pFF.pFF.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (pFF.f26903sc) {
                    TRI.sc().sc(pff, true);
                }
            }
        }, 10);
    }

    private static boolean sc(String str, String str2) {
        com.bytedance.sdk.component.adexpress.sc.zY.sc scVarWe;
        com.bytedance.sdk.component.adexpress.sc.zY.sc scVar;
        if (!ExN() || (scVarWe = We()) == null) {
            return false;
        }
        Map<String, com.bytedance.sdk.component.adexpress.sc.zY.sc> mapSc = scVarWe.sc();
        if (mapSc.size() == 0 || (scVar = mapSc.get(str2)) == null) {
            return false;
        }
        for (com.bytedance.sdk.component.adexpress.sc.zY.sc.C0259sc c0259sc : scVar.TRI()) {
            if (c0259sc != null && TextUtils.equals(str, c0259sc.sc())) {
                return true;
            }
        }
        return false;
    }

    public static boolean sc(JSONObject jSONObject) {
        Object objOpt;
        return (jSONObject == null || (objOpt = jSONObject.opt("template_Plugin")) == null || TextUtils.isEmpty(objOpt.toString())) ? false : true;
    }

    public static com.bytedance.sdk.component.adexpress.sc.zY.pFF zY(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.bytedance.sdk.component.adexpress.sc.zY.pFF pffSc = qr.sc().sc(str);
        if (pffSc != null) {
            pffSc.sc(Long.valueOf(System.currentTimeMillis()));
            sc(pffSc);
        }
        return pffSc;
    }

    public static String zY() {
        return TRI.zY();
    }

    public static boolean zY(JSONObject jSONObject) {
        Object objOpt;
        if (jSONObject == null) {
            return false;
        }
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("creatives");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i11);
                    if (jSONObjectOptJSONObject == null || (objOpt = jSONObjectOptJSONObject.opt("template_Plugin")) == null || TextUtils.isEmpty(objOpt.toString())) {
                        return false;
                    }
                }
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
