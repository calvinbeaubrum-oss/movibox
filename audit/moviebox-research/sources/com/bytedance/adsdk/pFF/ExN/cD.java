package com.bytedance.adsdk.pFF.ExN;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class cD {
    public static com.bytedance.adsdk.pFF.zY.pFF.Tf sc(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr qrVar) throws IOException {
        String strNextString = null;
        com.bytedance.adsdk.pFF.zY.sc.pFF pffSc = null;
        com.bytedance.adsdk.pFF.zY.sc.pFF pffSc2 = null;
        com.bytedance.adsdk.pFF.zY.sc.Tf tfSc = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "c":
                    pffSc = We.sc(jsonReader, qrVar, false);
                    break;
                case "o":
                    pffSc2 = We.sc(jsonReader, qrVar, false);
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "tr":
                    tfSc = zY.sc(jsonReader, qrVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.pFF.zY.pFF.Tf(strNextString, pffSc, pffSc2, tfSc, zNextBoolean);
    }
}
