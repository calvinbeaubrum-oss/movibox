package com.bytedance.adsdk.pFF.ExN;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class cvk {
    public static com.bytedance.adsdk.pFF.sc.pFF.Ol sc(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr qrVar) throws IOException {
        return new com.bytedance.adsdk.pFF.sc.pFF.Ol(qrVar, YIK.sc(jsonReader, qrVar, com.bytedance.adsdk.pFF.TRI.TRI.sc(), II.f26087sc, jsonReader.peek() == JsonToken.BEGIN_OBJECT, false));
    }
}
