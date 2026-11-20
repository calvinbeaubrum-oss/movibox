package com.bytedance.adsdk.pFF.ExN;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF {
    private static com.bytedance.adsdk.pFF.zY.sc.UFX pFF(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr qrVar) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.pFF.zY.sc.sc scVarQr = null;
        com.bytedance.adsdk.pFF.zY.sc.sc scVarQr2 = null;
        com.bytedance.adsdk.pFF.zY.sc.pFF pffSc = null;
        com.bytedance.adsdk.pFF.zY.sc.pFF pffSc2 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "t":
                    pffSc2 = We.sc(jsonReader, qrVar);
                    break;
                case "fc":
                    scVarQr = We.qr(jsonReader, qrVar);
                    break;
                case "sc":
                    scVarQr2 = We.qr(jsonReader, qrVar);
                    break;
                case "sw":
                    pffSc = We.sc(jsonReader, qrVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.bytedance.adsdk.pFF.zY.sc.UFX(scVarQr, scVarQr2, pffSc, pffSc2);
    }

    public static com.bytedance.adsdk.pFF.zY.sc.UFX sc(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr qrVar) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.pFF.zY.sc.UFX ufxPFF = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("a")) {
                ufxPFF = pFF(jsonReader, qrVar);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return ufxPFF == null ? new com.bytedance.adsdk.pFF.zY.sc.UFX(null, null, null, null) : ufxPFF;
    }
}
