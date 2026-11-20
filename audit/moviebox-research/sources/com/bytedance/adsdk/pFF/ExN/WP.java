package com.bytedance.adsdk.pFF.ExN;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class WP {
    public static com.bytedance.adsdk.pFF.zY.pFF.Ol sc(JsonReader jsonReader) throws IOException {
        String strNextString = null;
        com.bytedance.adsdk.pFF.zY.pFF.Ol.sc scVarSc = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "mm":
                    scVarSc = com.bytedance.adsdk.pFF.zY.pFF.Ol.sc.sc(jsonReader.nextInt());
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.pFF.zY.pFF.Ol(strNextString, scVarSc, zNextBoolean);
    }
}
