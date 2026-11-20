package com.bytedance.adsdk.pFF.ExN;

import android.util.JsonReader;
import android.util.JsonToken;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class Dl {
    public static <T> List<com.bytedance.adsdk.pFF.qr.sc<T>> sc(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr qrVar, float f11, pc<T> pcVar, boolean z11) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.STRING) {
            qrVar.sc("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (!strNextName.equals(CampaignEx.JSON_KEY_AD_K)) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                if (jsonReader.peek() == JsonToken.NUMBER) {
                    arrayList.add(YIK.sc(jsonReader, qrVar, f11, pcVar, false, z11));
                } else {
                    while (jsonReader.hasNext()) {
                        arrayList.add(YIK.sc(jsonReader, qrVar, f11, pcVar, true, z11));
                    }
                }
                jsonReader.endArray();
            } else {
                arrayList.add(YIK.sc(jsonReader, qrVar, f11, pcVar, false, z11));
            }
        }
        jsonReader.endObject();
        sc(arrayList);
        return arrayList;
    }

    public static <T> void sc(List<? extends com.bytedance.adsdk.pFF.qr.sc<T>> list) {
        int i11;
        T t11;
        int size = list.size();
        int i12 = 0;
        while (true) {
            i11 = size - 1;
            if (i12 >= i11) {
                break;
            }
            com.bytedance.adsdk.pFF.qr.sc<T> scVar = list.get(i12);
            i12++;
            com.bytedance.adsdk.pFF.qr.sc<T> scVar2 = list.get(i12);
            scVar.f26179qr = Float.valueOf(scVar2.TRI);
            if (scVar.pFF == null && (t11 = scVar2.f26180sc) != null) {
                scVar.pFF = t11;
                if (scVar instanceof com.bytedance.adsdk.pFF.sc.pFF.Ol) {
                    ((com.bytedance.adsdk.pFF.sc.pFF.Ol) scVar).sc();
                }
            }
        }
        com.bytedance.adsdk.pFF.qr.sc<T> scVar3 = list.get(i11);
        if ((scVar3.f26180sc == null || scVar3.pFF == null) && list.size() > 1) {
            list.remove(scVar3);
        }
    }
}
