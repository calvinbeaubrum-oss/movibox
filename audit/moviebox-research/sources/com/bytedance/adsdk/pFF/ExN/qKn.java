package com.bytedance.adsdk.pFF.ExN;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class qKn {
    public static com.bytedance.adsdk.pFF.zY.pFF.Sfl sc(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr qrVar) throws IOException {
        String strNextString = null;
        com.bytedance.adsdk.pFF.zY.pFF.Sfl.sc scVarSc = null;
        com.bytedance.adsdk.pFF.zY.sc.pFF pffSc = null;
        com.bytedance.adsdk.pFF.zY.sc.pFF pffSc2 = null;
        com.bytedance.adsdk.pFF.zY.sc.pFF pffSc3 = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "e":
                    pffSc2 = We.sc(jsonReader, qrVar, false);
                    break;
                case "m":
                    scVarSc = com.bytedance.adsdk.pFF.zY.pFF.Sfl.sc.sc(jsonReader.nextInt());
                    break;
                case "o":
                    pffSc3 = We.sc(jsonReader, qrVar, false);
                    break;
                case "s":
                    pffSc = We.sc(jsonReader, qrVar, false);
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
        return new com.bytedance.adsdk.pFF.zY.pFF.Sfl(strNextString, scVarSc, pffSc, pffSc2, pffSc3, zNextBoolean);
    }
}
