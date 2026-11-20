package com.bytedance.sdk.openadsdk.core;

import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface Sfl<T> {

    /* JADX INFO: compiled from: source.java */
    public interface pFF {
        void sc(int i11, String str);

        void sc(YIK.pFF pff);
    }

    /* JADX INFO: compiled from: source.java */
    public interface sc {
        void sc(int i11, String str);

        void sc(com.bytedance.sdk.openadsdk.core.model.sc scVar, com.bytedance.sdk.openadsdk.core.model.pFF pff);
    }

    com.bytedance.sdk.openadsdk.We.ExN pFF(JSONObject jSONObject);

    com.bytedance.sdk.component.adexpress.sc.zY.sc sc();

    com.bytedance.sdk.openadsdk.We.ExN sc(JSONObject jSONObject, String str, boolean z11);

    JSONObject sc(JSONObject jSONObject);

    void sc(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.Dl dl2, int i11, sc scVar);

    void sc(String str);

    void sc(String str, List<FilterWord> list, String str2, String str3, String str4);

    void sc(JSONObject jSONObject, pFF pff);

    void sc(JSONObject jSONObject, String str);
}
