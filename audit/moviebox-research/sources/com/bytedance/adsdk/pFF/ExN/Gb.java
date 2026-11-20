package com.bytedance.adsdk.pFF.ExN;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class Gb {
    public static com.bytedance.adsdk.pFF.zY.pFF.UFX sc(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr qrVar) throws IOException {
        String strNextString = null;
        com.bytedance.adsdk.pFF.zY.sc.Ql<PointF, PointF> qlPFF = null;
        com.bytedance.adsdk.pFF.zY.sc.TRI triZY = null;
        com.bytedance.adsdk.pFF.zY.sc.pFF pffSc = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "p":
                    qlPFF = sc.pFF(jsonReader, qrVar);
                    break;
                case "r":
                    pffSc = We.sc(jsonReader, qrVar);
                    break;
                case "s":
                    triZY = We.zY(jsonReader, qrVar);
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.pFF.zY.pFF.UFX(strNextString, qlPFF, triZY, pffSc, zNextBoolean);
    }
}
