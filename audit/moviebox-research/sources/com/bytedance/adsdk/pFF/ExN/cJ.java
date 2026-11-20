package com.bytedance.adsdk.pFF.ExN;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class cJ implements pc<com.bytedance.adsdk.pFF.zY.pFF.SR> {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static final cJ f26096sc = new cJ();

    private cJ() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:10:0x0029  */
    @Override // com.bytedance.adsdk.pFF.ExN.pc
    /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.pFF.zY.pFF.SR pFF(JsonReader jsonReader, float f11) throws IOException {
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
        }
        jsonReader.beginObject();
        List<PointF> listSc = null;
        List<PointF> listSc2 = null;
        List<PointF> listSc3 = null;
        boolean zNextBoolean = false;
        while (true) {
            if (!jsonReader.hasNext()) {
                jsonReader.endObject();
                if (jsonReader.peek() == JsonToken.END_ARRAY) {
                    jsonReader.endArray();
                }
                if (listSc == null || listSc2 == null || listSc3 == null) {
                    throw new IllegalArgumentException("Shape data was missing information.");
                }
                if (listSc.isEmpty()) {
                    return new com.bytedance.adsdk.pFF.zY.pFF.SR(new PointF(), false, Collections.emptyList());
                }
                int size = listSc.size();
                PointF pointF = listSc.get(0);
                ArrayList arrayList = new ArrayList(size);
                for (int i11 = 1; i11 < size; i11++) {
                    PointF pointF2 = listSc.get(i11);
                    int i12 = i11 - 1;
                    arrayList.add(new com.bytedance.adsdk.pFF.zY.sc(com.bytedance.adsdk.pFF.TRI.ExN.sc(listSc.get(i12), listSc3.get(i12)), com.bytedance.adsdk.pFF.TRI.ExN.sc(pointF2, listSc2.get(i11)), pointF2));
                }
                if (zNextBoolean) {
                    PointF pointF3 = listSc.get(0);
                    int i13 = size - 1;
                    arrayList.add(new com.bytedance.adsdk.pFF.zY.sc(com.bytedance.adsdk.pFF.TRI.ExN.sc(listSc.get(i13), listSc3.get(i13)), com.bytedance.adsdk.pFF.TRI.ExN.sc(pointF3, listSc2.get(0)), pointF3));
                }
                return new com.bytedance.adsdk.pFF.zY.pFF.SR(pointF, zNextBoolean, arrayList);
            }
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "c":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "i":
                    listSc2 = Sfl.sc(jsonReader, f11);
                    break;
                case "o":
                    listSc3 = Sfl.sc(jsonReader, f11);
                    break;
                case "v":
                    listSc = Sfl.sc(jsonReader, f11);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
    }
}
