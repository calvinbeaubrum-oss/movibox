package com.bytedance.sdk.openadsdk.core.settings;

import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface ExN {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static final pFF<JSONObject> f28484sc = new pFF<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.settings.ExN.1
        @Override // com.bytedance.sdk.openadsdk.core.settings.ExN.pFF
        /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
        public JSONObject pFF(String str) {
            try {
                return new JSONObject(str);
            } catch (Exception e11) {
                com.bytedance.sdk.component.utils.Tf.sc("ISettingsDataRepository", "", e11);
                return null;
            }
        }
    };
    public static final pFF<Set<String>> pFF = new pFF<Set<String>>() { // from class: com.bytedance.sdk.openadsdk.core.settings.ExN.2
        @Override // com.bytedance.sdk.openadsdk.core.settings.ExN.pFF
        /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
        public Set<String> pFF(String str) {
            HashSet hashSet = new HashSet();
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i11 = 0; i11 < length; i11++) {
                    hashSet.add(jSONArray.getString(i11));
                }
            } catch (Exception e11) {
                com.bytedance.sdk.component.utils.Tf.sc("ISettingsDataRepository", "", e11);
            }
            return hashSet;
        }
    };

    /* JADX INFO: compiled from: source.java */
    public interface pFF<T> {
        T pFF(String str);
    }

    /* JADX INFO: compiled from: source.java */
    public interface sc {
        sc sc(String str);

        sc sc(String str, float f11);

        sc sc(String str, int i11);

        sc sc(String str, long j11);

        sc sc(String str, String str2);

        sc sc(String str, boolean z11);

        void sc();
    }

    void sc(JSONObject jSONObject);
}
