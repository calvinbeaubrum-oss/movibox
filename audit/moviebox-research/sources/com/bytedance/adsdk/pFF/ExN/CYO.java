package com.bytedance.adsdk.pFF.ExN;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class CYO {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:70:0x0117  */
    /* JADX WARN: Code duplicated, block: B:7:0x002a  */
    public static com.bytedance.adsdk.pFF.zY.pFF.wjp sc(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr qrVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        String strNextString = null;
        com.bytedance.adsdk.pFF.zY.sc.pFF pff = null;
        com.bytedance.adsdk.pFF.zY.sc.sc scVarQr = null;
        com.bytedance.adsdk.pFF.zY.sc.pFF pffSc = null;
        com.bytedance.adsdk.pFF.zY.pFF.wjp.sc scVar = null;
        com.bytedance.adsdk.pFF.zY.pFF.wjp.pFF pff2 = null;
        float fNextDouble = 0.0f;
        boolean zNextBoolean = false;
        com.bytedance.adsdk.pFF.zY.sc.We we2 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "c":
                    scVarQr = We.qr(jsonReader, qrVar);
                    continue;
                    break;
                case "d":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        com.bytedance.adsdk.pFF.zY.sc.pFF pffSc2 = null;
                        String strNextString2 = null;
                        while (jsonReader.hasNext()) {
                            String strNextName2 = jsonReader.nextName();
                            strNextName2.hashCode();
                            if (strNextName2.equals("n")) {
                                strNextString2 = jsonReader.nextString();
                            } else if (strNextName2.equals("v")) {
                                pffSc2 = We.sc(jsonReader, qrVar);
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        jsonReader.endObject();
                        strNextString2.hashCode();
                        switch (strNextString2) {
                            case "d":
                            case "g":
                                qrVar.sc(true);
                                arrayList.add(pffSc2);
                                break;
                            case "o":
                                pff = pffSc2;
                                break;
                        }
                    }
                    jsonReader.endArray();
                    if (arrayList.size() != 1) {
                        break;
                    } else {
                        arrayList.add(arrayList.get(0));
                    }
                    break;
                case "o":
                    we2 = We.pFF(jsonReader, qrVar);
                    continue;
                    break;
                case "w":
                    pffSc = We.sc(jsonReader, qrVar);
                    continue;
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    continue;
                    break;
                case "lc":
                    scVar = com.bytedance.adsdk.pFF.zY.pFF.wjp.sc.values()[jsonReader.nextInt() - 1];
                    continue;
                    break;
                case "lj":
                    pff2 = com.bytedance.adsdk.pFF.zY.pFF.wjp.pFF.values()[jsonReader.nextInt() - 1];
                    continue;
                    break;
                case "ml":
                    fNextDouble = (float) jsonReader.nextDouble();
                    continue;
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    continue;
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        if (we2 == null) {
            we2 = new com.bytedance.adsdk.pFF.zY.sc.We(Collections.singletonList(new com.bytedance.adsdk.pFF.qr.sc(100)));
        }
        return new com.bytedance.adsdk.pFF.zY.pFF.wjp(strNextString, pff, arrayList, scVarQr, we2, pffSc, scVar, pff2, fNextDouble, zNextBoolean);
    }
}
