package com.bytedance.adsdk.pFF.ExN;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc {
    public static com.bytedance.adsdk.pFF.zY.sc.Ql<PointF, PointF> pFF(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr qrVar) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.pFF.zY.sc.ExN exNSc = null;
        com.bytedance.adsdk.pFF.zY.sc.pFF pffSc = null;
        com.bytedance.adsdk.pFF.zY.sc.pFF pffSc2 = null;
        boolean z11 = false;
        while (jsonReader.peek() != JsonToken.END_OBJECT) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "k":
                    exNSc = sc(jsonReader, qrVar);
                    break;
                case "x":
                    if (jsonReader.peek() != JsonToken.STRING) {
                        pffSc = We.sc(jsonReader, qrVar);
                        break;
                    } else {
                        z11 = true;
                        jsonReader.skipValue();
                        break;
                    }
                    break;
                case "y":
                    if (jsonReader.peek() != JsonToken.STRING) {
                        pffSc2 = We.sc(jsonReader, qrVar);
                        break;
                    } else {
                        z11 = true;
                        jsonReader.skipValue();
                        break;
                    }
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (z11) {
            qrVar.sc("Lottie doesn't support expressions.");
        }
        return exNSc != null ? exNSc : new com.bytedance.adsdk.pFF.zY.sc.Ol(pffSc, pffSc2);
    }

    public static com.bytedance.adsdk.pFF.zY.sc.ExN sc(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr qrVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(cvk.sc(jsonReader, qrVar));
            }
            jsonReader.endArray();
            Dl.sc(arrayList);
        } else {
            arrayList.add(new com.bytedance.adsdk.pFF.qr.sc(Sfl.pFF(jsonReader, com.bytedance.adsdk.pFF.TRI.TRI.sc())));
        }
        return new com.bytedance.adsdk.pFF.zY.sc.ExN(arrayList);
    }
}
