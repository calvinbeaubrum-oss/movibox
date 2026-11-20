package com.bytedance.sdk.openadsdk.We;

import java.text.SimpleDateFormat;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TRI extends sc {
    public static final SimpleDateFormat zY = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    public TRI(String str, JSONObject jSONObject) {
        super(str, jSONObject);
    }

    @Override // com.bytedance.sdk.openadsdk.We.sc
    public JSONObject zY() {
        return this.pFF;
    }
}
