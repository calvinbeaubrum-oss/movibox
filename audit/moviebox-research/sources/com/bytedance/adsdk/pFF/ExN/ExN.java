package com.bytedance.adsdk.pFF.ExN;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class ExN {
    private static com.bytedance.adsdk.pFF.zY.pFF.sc pFF(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr qrVar) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.pFF.zY.pFF.sc scVar = null;
        while (true) {
            boolean z11 = false;
            while (true) {
                if (!jsonReader.hasNext()) {
                    jsonReader.endObject();
                    return scVar;
                }
                String strNextName = jsonReader.nextName();
                strNextName.hashCode();
                if (strNextName.equals("v")) {
                    if (z11) {
                        scVar = new com.bytedance.adsdk.pFF.zY.pFF.sc(We.sc(jsonReader, qrVar));
                    } else {
                        jsonReader.skipValue();
                    }
                } else if (!strNextName.equals("ty")) {
                    jsonReader.skipValue();
                } else if (jsonReader.nextInt() == 0) {
                    z11 = true;
                }
            }
        }
    }

    public static com.bytedance.adsdk.pFF.zY.pFF.sc sc(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr qrVar) throws IOException {
        com.bytedance.adsdk.pFF.zY.pFF.sc scVar = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("ef")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.bytedance.adsdk.pFF.zY.pFF.sc scVarPFF = pFF(jsonReader, qrVar);
                    if (scVarPFF != null) {
                        scVar = scVarPFF;
                    }
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        return scVar;
    }
}
