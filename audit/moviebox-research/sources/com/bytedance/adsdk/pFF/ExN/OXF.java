package com.bytedance.adsdk.pFF.ExN;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class OXF implements pc<com.bytedance.adsdk.pFF.qr.zY> {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static final OXF f26089sc = new OXF();

    private OXF() {
    }

    @Override // com.bytedance.adsdk.pFF.ExN.pc
    /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.pFF.qr.zY pFF(JsonReader jsonReader, float f11) throws IOException {
        boolean z11 = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z11) {
            jsonReader.beginArray();
        }
        float fNextDouble = (float) jsonReader.nextDouble();
        float fNextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        if (z11) {
            jsonReader.endArray();
        }
        return new com.bytedance.adsdk.pFF.qr.zY((fNextDouble / 100.0f) * f11, (fNextDouble2 / 100.0f) * f11);
    }
}
