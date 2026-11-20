package com.bytedance.adsdk.pFF.ExN;

import android.graphics.Path;
import android.util.JsonReader;
import java.io.IOException;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class kX {
    public static com.bytedance.adsdk.pFF.zY.pFF.BT sc(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr qrVar) throws IOException {
        com.bytedance.adsdk.pFF.zY.sc.We we2 = null;
        String strNextString = null;
        com.bytedance.adsdk.pFF.zY.sc.sc scVarQr = null;
        int iNextInt = 1;
        boolean zNextBoolean = false;
        boolean zNextBoolean2 = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "fillEnabled":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "c":
                    scVarQr = We.qr(jsonReader, qrVar);
                    break;
                case "o":
                    we2 = We.pFF(jsonReader, qrVar);
                    break;
                case "r":
                    iNextInt = jsonReader.nextInt();
                    break;
                case "hd":
                    zNextBoolean2 = jsonReader.nextBoolean();
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        if (we2 == null) {
            we2 = new com.bytedance.adsdk.pFF.zY.sc.We(Collections.singletonList(new com.bytedance.adsdk.pFF.qr.sc(100)));
        }
        return new com.bytedance.adsdk.pFF.zY.pFF.BT(strNextString, zNextBoolean, iNextInt == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, scVarQr, we2, zNextBoolean2);
    }
}
