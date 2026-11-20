package com.applovin.impl.sdk;

import com.applovin.impl.la;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sj;
import com.applovin.impl.yp;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class NativeCrashReporter implements e.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f22384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f22385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final NativeCrashReporter f22386c = new NativeCrashReporter();

    private NativeCrashReporter() {
    }

    public static void a(j jVar) {
        if (jVar == null) {
            return;
        }
        if (!((Boolean) jVar.a(sj.A4)).booleanValue() && !yp.i(j.l())) {
            if (f22385b) {
                try {
                    e eVarJ = jVar.j();
                    NativeCrashReporter nativeCrashReporter = f22386c;
                    eVarJ.a(nativeCrashReporter);
                    nativeCrashReporter.disable();
                    return;
                } catch (Throwable th2) {
                    jVar.J();
                    if (n.a()) {
                        jVar.J().a("NativeCrashReporter", "Failed to disable native crash reporter", th2);
                    }
                    jVar.E().a("NativeCrashReporter", "disableInstance", th2);
                    return;
                }
            }
            return;
        }
        if (a()) {
            List listC = jVar.c(sj.B4);
            int[] iArr = new int[listC.size()];
            for (int i11 = 0; i11 < listC.size(); i11++) {
                try {
                    iArr[i11] = Integer.parseInt((String) listC.get(i11));
                } catch (NumberFormatException unused) {
                }
            }
            File file = new File(j.l().getCacheDir(), "al-reports");
            if (file.exists()) {
                a(file, jVar);
            } else if (!file.mkdir()) {
                jVar.J();
                if (n.a()) {
                    jVar.J().b("NativeCrashReporter", "Failed to create reports directory");
                    return;
                }
                return;
            }
            try {
                NativeCrashReporter nativeCrashReporter2 = f22386c;
                nativeCrashReporter2.enable(file.getAbsolutePath(), iArr);
                HashSet hashSet = new HashSet();
                hashSet.add(e.c.SHOW);
                hashSet.add(e.c.CLICK);
                hashSet.add(e.c.SHOW_ERROR);
                hashSet.add(e.c.DESTROY);
                jVar.j().a(nativeCrashReporter2, hashSet);
            } catch (Throwable th3) {
                jVar.J();
                if (n.a()) {
                    jVar.J().a("NativeCrashReporter", "Failed to enable native crash reporter", th3);
                }
                jVar.E().a("NativeCrashReporter", "enableInstance", th3);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x009c  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a5  */
    /* JADX WARN: Instruction removed from duplicated block: B:32:0x00a5, please report this as an issue */
    private static void a(File file, j jVar) throws Throwable {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            String strE = jVar.B().e(file2);
            if (StringUtils.isValidString(strE)) {
                String[] strArrSplit = strE.split("@@@@@");
                if (strArrSplit.length == 3) {
                    try {
                        String str = strArrSplit[0];
                        String str2 = strArrSplit[1];
                        JSONArray jSONArray = new JSONArray(strArrSplit[2]);
                        String strSymbolicateSource = symbolicateSource(str2);
                        if (jSONArray.length() == 0) {
                            jVar.E().a(la.N, strSymbolicateSource, (Map) CollectionUtils.hashMap(TrackingKey.ERROR_MESSAGE, str));
                        } else {
                            ArrayList arrayList = new ArrayList(jSONArray.length());
                            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                                JSONObject jSONObject = JsonUtils.getJSONObject(jSONArray, i11, (JSONObject) null);
                                if (jSONObject != null) {
                                    HashMap<String, String> mapHashMap = CollectionUtils.hashMap(TrackingKey.ERROR_MESSAGE, str);
                                    mapHashMap.putAll(JsonUtils.toStringMap(jSONObject));
                                    arrayList.add(mapHashMap);
                                }
                            }
                            jVar.E().a(la.N, strSymbolicateSource, arrayList, 0L);
                        }
                    } catch (Throwable th2) {
                        jVar.J();
                        if (n.a()) {
                            jVar.J().a("NativeCrashReporter", "Failed to symbolicate native crash report", th2);
                        }
                    }
                } else {
                    jVar.J();
                    if (n.a()) {
                        jVar.J().b("NativeCrashReporter", "Failed to read native crash error report: " + file2.getAbsolutePath());
                    }
                }
            } else {
                jVar.J();
                if (n.a()) {
                    jVar.J().b("NativeCrashReporter", "Failed to read native crash error report: " + file2.getAbsolutePath());
                }
            }
            try {
                if (!file2.delete()) {
                    jVar.J();
                    if (n.a()) {
                        jVar.J().b("NativeCrashReporter", "Failed to delete native crash report: " + file2.getAbsolutePath());
                    }
                }
            } catch (Throwable th3) {
                jVar.J();
                if (n.a()) {
                    jVar.J().a("NativeCrashReporter", "Failed to delete native crash report: " + file2.getAbsolutePath(), th3);
                }
            }
        }
    }

    private static boolean a() {
        if (!f22384a) {
            f22384a = true;
            try {
                System.loadLibrary("applovin-native-crash-reporter");
                f22385b = true;
            } catch (Throwable th2) {
                n.b("NativeCrashReporter", "Failed to load native crash reporter library", th2);
            }
        }
        return f22385b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(e.b bVar) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "ad_unit_id", bVar.a());
        JsonUtils.putString(jSONObject, "ad_format", bVar.g());
        JsonUtils.putString(jSONObject, "network_name", bVar.c());
        JsonUtils.putString(jSONObject, "adapter_class", bVar.b());
        JsonUtils.putString(jSONObject, "adapter_version", bVar.d());
        JsonUtils.putString(jSONObject, "bcode", bVar.e());
        JsonUtils.putString(jSONObject, CampaignEx.JSON_KEY_CREATIVE_ID, bVar.f());
        JsonUtils.putString(jSONObject, "operation", bVar.i().toString());
        updateAdInfo(bVar.h(), jSONObject.toString());
    }

    private native void disable();

    private native void enable(String str, int[] iArr);

    private native void removeAdInfo(int i11);

    private static native String symbolicateSource(String str);

    private native void updateAdInfo(int i11, String str);

    @Override // com.applovin.impl.sdk.e.d
    public void a(final e.b bVar) {
        if (bVar.i() == e.c.DESTROY) {
            removeAdInfo(bVar.h());
        } else {
            yp.a(new Runnable() { // from class: com.applovin.impl.sdk.z
                @Override // java.lang.Runnable
                public final void run() {
                    this.f22879a.b(bVar);
                }
            });
        }
    }
}
