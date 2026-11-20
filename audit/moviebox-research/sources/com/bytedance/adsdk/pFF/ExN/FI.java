package com.bytedance.adsdk.pFF.ExN;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class FI {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:28:0x0062  */
    /* JADX WARN: Code duplicated, block: B:7:0x0020  */
    public static com.bytedance.adsdk.pFF.zY.pFF.Qj sc(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr qrVar) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.pFF.zY.pFF.Qj.sc scVar = null;
        com.bytedance.adsdk.pFF.zY.sc.Qj qjExN = null;
        com.bytedance.adsdk.pFF.zY.sc.We wePFF = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "o":
                    wePFF = We.pFF(jsonReader, qrVar);
                    break;
                case "pt":
                    qjExN = We.ExN(jsonReader, qrVar);
                    break;
                case "inv":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "mode":
                    String strNextString = jsonReader.nextString();
                    strNextString.hashCode();
                    switch (strNextString) {
                        case "a":
                            scVar = com.bytedance.adsdk.pFF.zY.pFF.Qj.sc.MASK_MODE_ADD;
                            break;
                        case "i":
                            qrVar.sc("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            scVar = com.bytedance.adsdk.pFF.zY.pFF.Qj.sc.MASK_MODE_INTERSECT;
                            break;
                        case "n":
                            scVar = com.bytedance.adsdk.pFF.zY.pFF.Qj.sc.MASK_MODE_NONE;
                            break;
                        case "s":
                            scVar = com.bytedance.adsdk.pFF.zY.pFF.Qj.sc.MASK_MODE_SUBTRACT;
                            break;
                        default:
                            scVar = com.bytedance.adsdk.pFF.zY.pFF.Qj.sc.MASK_MODE_ADD;
                            break;
                    }
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.bytedance.adsdk.pFF.zY.pFF.Qj(scVar, qjExN, wePFF, zNextBoolean);
    }
}
