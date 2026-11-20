package com.bytedance.adsdk.pFF.ExN;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class HJN {
    public static com.bytedance.adsdk.pFF.zY.pFF.WH sc(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr qrVar, int i11) throws IOException {
        boolean z11 = i11 == 3;
        String strNextString = null;
        com.bytedance.adsdk.pFF.zY.pFF.WH.sc scVarSc = null;
        com.bytedance.adsdk.pFF.zY.sc.pFF pffSc = null;
        com.bytedance.adsdk.pFF.zY.sc.Ql<PointF, PointF> qlPFF = null;
        com.bytedance.adsdk.pFF.zY.sc.pFF pffSc2 = null;
        com.bytedance.adsdk.pFF.zY.sc.pFF pffSc3 = null;
        com.bytedance.adsdk.pFF.zY.sc.pFF pffSc4 = null;
        com.bytedance.adsdk.pFF.zY.sc.pFF pffSc5 = null;
        com.bytedance.adsdk.pFF.zY.sc.pFF pffSc6 = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "d":
                    if (jsonReader.nextInt() != 3) {
                        z11 = false;
                        break;
                    } else {
                        z11 = true;
                        break;
                    }
                    break;
                case "p":
                    qlPFF = sc.pFF(jsonReader, qrVar);
                    break;
                case "r":
                    pffSc2 = We.sc(jsonReader, qrVar, false);
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "ir":
                    pffSc3 = We.sc(jsonReader, qrVar);
                    break;
                case "is":
                    pffSc5 = We.sc(jsonReader, qrVar, false);
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "or":
                    pffSc4 = We.sc(jsonReader, qrVar);
                    break;
                case "os":
                    pffSc6 = We.sc(jsonReader, qrVar, false);
                    break;
                case "pt":
                    pffSc = We.sc(jsonReader, qrVar, false);
                    break;
                case "sy":
                    scVarSc = com.bytedance.adsdk.pFF.zY.pFF.WH.sc.sc(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.pFF.zY.pFF.WH(strNextString, scVarSc, pffSc, qlPFF, pffSc2, pffSc3, pffSc4, pffSc5, pffSc6, zNextBoolean, z11);
    }
}
