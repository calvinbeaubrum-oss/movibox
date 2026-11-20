package com.bytedance.adsdk.pFF.ExN;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class TRI {
    public static com.bytedance.adsdk.pFF.zY.pFF.pFF sc(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr qrVar, int i11) throws IOException {
        boolean z11 = i11 == 3;
        String strNextString = null;
        com.bytedance.adsdk.pFF.zY.sc.Ql<PointF, PointF> qlPFF = null;
        com.bytedance.adsdk.pFF.zY.sc.TRI triZY = null;
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
        return new com.bytedance.adsdk.pFF.zY.pFF.pFF(strNextString, qlPFF, triZY, z11, zNextBoolean);
    }
}
