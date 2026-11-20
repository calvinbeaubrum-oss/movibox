package com.bytedance.adsdk.pFF.ExN;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class UFX {
    private com.bytedance.adsdk.pFF.zY.sc.pFF ExN;
    private com.bytedance.adsdk.pFF.zY.sc.pFF We;
    private com.bytedance.adsdk.pFF.zY.sc.pFF pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private com.bytedance.adsdk.pFF.zY.sc.sc f26093sc;
    private com.bytedance.adsdk.pFF.zY.sc.pFF zY;

    private void pFF(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr qrVar) throws IOException {
        jsonReader.beginObject();
        String strNextString = "";
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("v")) {
                strNextString.hashCode();
                switch (strNextString) {
                    case "Distance":
                        this.We = We.sc(jsonReader, qrVar);
                        break;
                    case "Opacity":
                        this.pFF = We.sc(jsonReader, qrVar, false);
                        break;
                    case "Direction":
                        this.zY = We.sc(jsonReader, qrVar, false);
                        break;
                    case "Shadow Color":
                        this.f26093sc = We.qr(jsonReader, qrVar);
                        break;
                    case "Softness":
                        this.ExN = We.sc(jsonReader, qrVar);
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            } else if (strNextName.equals("nm")) {
                strNextString = jsonReader.nextString();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }

    public WH sc(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr qrVar) throws IOException {
        com.bytedance.adsdk.pFF.zY.sc.pFF pff;
        com.bytedance.adsdk.pFF.zY.sc.pFF pff2;
        com.bytedance.adsdk.pFF.zY.sc.pFF pff3;
        com.bytedance.adsdk.pFF.zY.sc.pFF pff4;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("ef")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    pFF(jsonReader, qrVar);
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        com.bytedance.adsdk.pFF.zY.sc.sc scVar = this.f26093sc;
        if (scVar == null || (pff = this.pFF) == null || (pff2 = this.zY) == null || (pff3 = this.We) == null || (pff4 = this.ExN) == null) {
            return null;
        }
        return new WH(scVar, pff, pff2, pff3, pff4);
    }
}
