package com.bytedance.sdk.openadsdk.core.settings;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.utils.Gb;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static final ConcurrentHashMap<String, pFF> f28521sc = new ConcurrentHashMap<>();

    private static pFF pFF(String str) {
        return new pFF(str, 1);
    }

    @NonNull
    private static File pFF() {
        return new File(Xc.sc().getFilesDir(), "tt_ads_conf");
    }

    @NonNull
    private static HashMap<String, pFF> pFF(JSONArray jSONArray) {
        HashMap<String, pFF> map = new HashMap<>();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            try {
                pFF pffSc = sc(jSONArray.getJSONObject(i11));
                if (pffSc != null) {
                    map.put(pffSc.f28519sc, pffSc);
                }
            } catch (Exception unused) {
            }
        }
        return map;
    }

    @NonNull
    public static pFF sc(String str) {
        pFF pff = f28521sc.get(str);
        return pff == null ? pFF(str) : pff;
    }

    private static pFF sc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new pFF(jSONObject);
    }

    public static void sc() {
        File filePFF = pFF();
        if (filePFF.exists()) {
            filePFF.delete();
        }
    }

    public static void sc(JSONArray jSONArray) throws Throwable {
        if (jSONArray == null) {
            return;
        }
        File filePFF = pFF();
        File file = new File(filePFF.getParent(), filePFF.getName() + ".tmp");
        FileWriter fileWriter = null;
        try {
            try {
                if (file.exists()) {
                    file.delete();
                }
                FileWriter fileWriter2 = new FileWriter(file);
                try {
                    fileWriter2.write(jSONArray.toString());
                    file.renameTo(filePFF);
                    Gb.sc("tt_sdk_settings", Xc.sc()).sc("ad_slot_conf");
                    if (file.exists()) {
                        file.delete();
                    }
                    com.bytedance.sdk.openadsdk.utils.UFX.sc(fileWriter2);
                } catch (Exception e11) {
                    e = e11;
                    fileWriter = fileWriter2;
                    Log.e("SdkSettings.AdSlot", "saveAdSlotToLocal: ", e);
                    if (file.exists()) {
                        file.delete();
                    }
                    com.bytedance.sdk.openadsdk.utils.UFX.sc(fileWriter);
                } catch (Throwable th2) {
                    th = th2;
                    fileWriter = fileWriter2;
                    if (file.exists()) {
                        file.delete();
                    }
                    com.bytedance.sdk.openadsdk.utils.UFX.sc(fileWriter);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e12) {
            e = e12;
        }
        HashMap<String, pFF> mapPFF = pFF(jSONArray);
        if (mapPFF.isEmpty()) {
            return;
        }
        for (Map.Entry<String, pFF> entry : mapPFF.entrySet()) {
            String key = entry.getKey();
            pFF value = entry.getValue();
            if (value.cJ) {
                pFF pff = f28521sc.get(key);
                if (pff != null) {
                    pff.GI = value.f28517pc;
                }
            } else {
                f28521sc.put(key, value);
            }
        }
    }

    public static void sc(boolean z11) {
        File filePFF = pFF();
        if (!filePFF.exists()) {
            String strPFF = com.bytedance.sdk.openadsdk.multipro.pFF.zY() ? com.bytedance.sdk.openadsdk.multipro.We.sc.pFF("tt_sdk_settings", "ad_slot_conf", null) : Gb.sc("tt_sdk_settings", Xc.sc()).sc("ad_slot_conf", (String) null);
            if (TextUtils.isEmpty(strPFF)) {
                return;
            }
            try {
                HashMap<String, pFF> mapPFF = pFF(new JSONArray(strPFF));
                if (mapPFF.isEmpty()) {
                    return;
                }
                ConcurrentHashMap<String, pFF> concurrentHashMap = f28521sc;
                concurrentHashMap.clear();
                concurrentHashMap.putAll(mapPFF);
                return;
            } catch (Exception unused) {
                return;
            }
        }
        try {
            HashMap<String, pFF> mapPFF2 = pFF(new JSONArray(new String(com.bytedance.sdk.component.utils.TRI.We(filePFF))));
            if (mapPFF2.isEmpty()) {
                return;
            }
            for (Map.Entry<String, pFF> entry : mapPFF2.entrySet()) {
                String key = entry.getKey();
                pFF value = entry.getValue();
                if (!value.cJ || z11) {
                    f28521sc.put(key, value);
                } else {
                    pFF pff = f28521sc.get(key);
                    if (pff != null) {
                        pff.GI = value.f28517pc;
                    }
                }
            }
        } catch (Exception unused2) {
        }
    }
}
