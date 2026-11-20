package com.bytedance.adsdk.pFF.ExN;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class McK implements pc<PointF> {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static final McK f26088sc = new McK();

    private McK() {
    }

    @Override // com.bytedance.adsdk.pFF.ExN.pc
    /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
    public PointF pFF(JsonReader jsonReader, float f11) throws IOException {
        JsonToken jsonTokenPeek = jsonReader.peek();
        if (jsonTokenPeek != JsonToken.BEGIN_ARRAY && jsonTokenPeek != JsonToken.BEGIN_OBJECT) {
            if (jsonTokenPeek != JsonToken.NUMBER) {
                throw new IllegalArgumentException("Cannot convert json to point. Next token is ".concat(String.valueOf(jsonTokenPeek)));
            }
            PointF pointF = new PointF(((float) jsonReader.nextDouble()) * f11, ((float) jsonReader.nextDouble()) * f11);
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            return pointF;
        }
        return Sfl.pFF(jsonReader, f11);
    }
}
