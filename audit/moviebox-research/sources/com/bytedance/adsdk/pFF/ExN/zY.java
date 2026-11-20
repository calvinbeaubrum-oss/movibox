package com.bytedance.adsdk.pFF.ExN;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY {
    /* JADX WARN: Multi-variable type inference failed */
    private static boolean pFF(com.bytedance.adsdk.pFF.zY.sc.pFF pff) {
        if (pff != null) {
            return pff.pFF() && ((Float) ((com.bytedance.adsdk.pFF.qr.sc) pff.zY().get(0)).f26180sc).floatValue() == 0.0f;
        }
        return true;
    }

    public static com.bytedance.adsdk.pFF.zY.sc.Tf sc(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr qrVar) throws IOException {
        boolean z11 = jsonReader.peek() == JsonToken.BEGIN_OBJECT;
        if (z11) {
            jsonReader.beginObject();
        }
        com.bytedance.adsdk.pFF.zY.sc.pFF pff = null;
        com.bytedance.adsdk.pFF.zY.sc.ExN exNSc = null;
        com.bytedance.adsdk.pFF.zY.sc.Ql<PointF, PointF> qlPFF = null;
        com.bytedance.adsdk.pFF.zY.sc.qr qrVarWe = null;
        com.bytedance.adsdk.pFF.zY.sc.pFF pffSc = null;
        com.bytedance.adsdk.pFF.zY.sc.pFF pffSc2 = null;
        com.bytedance.adsdk.pFF.zY.sc.We wePFF = null;
        com.bytedance.adsdk.pFF.zY.sc.pFF pffSc3 = null;
        com.bytedance.adsdk.pFF.zY.sc.pFF pffSc4 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "a":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.hashCode();
                        if (strNextName2.equals(CampaignEx.JSON_KEY_AD_K)) {
                            exNSc = sc.sc(jsonReader, qrVar);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    continue;
                    break;
                case "o":
                    wePFF = We.pFF(jsonReader, qrVar);
                    continue;
                    break;
                case "p":
                    qlPFF = sc.pFF(jsonReader, qrVar);
                    continue;
                    break;
                case "r":
                    break;
                case "s":
                    qrVarWe = We.We(jsonReader, qrVar);
                    continue;
                    break;
                case "eo":
                    pffSc4 = We.sc(jsonReader, qrVar, false);
                    continue;
                    break;
                case "rz":
                    qrVar.sc("Lottie doesn't support 3D layers.");
                    break;
                case "sa":
                    pffSc2 = We.sc(jsonReader, qrVar, false);
                    continue;
                    break;
                case "sk":
                    pffSc = We.sc(jsonReader, qrVar, false);
                    continue;
                    break;
                case "so":
                    pffSc3 = We.sc(jsonReader, qrVar, false);
                    continue;
                    break;
                default:
                    jsonReader.skipValue();
                    continue;
                    break;
            }
            com.bytedance.adsdk.pFF.zY.sc.pFF pffSc5 = We.sc(jsonReader, qrVar, false);
            if (pffSc5.zY().isEmpty()) {
                pffSc5.zY().add(new com.bytedance.adsdk.pFF.qr.sc(qrVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(qrVar.qr())));
            } else if (((com.bytedance.adsdk.pFF.qr.sc) pffSc5.zY().get(0)).f26180sc == 0) {
                pffSc5.zY().set(0, new com.bytedance.adsdk.pFF.qr.sc(qrVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(qrVar.qr())));
            }
            pff = pffSc5;
        }
        if (z11) {
            jsonReader.endObject();
        }
        if (sc(exNSc)) {
            exNSc = null;
        }
        return new com.bytedance.adsdk.pFF.zY.sc.Tf(exNSc, sc(qlPFF) ? null : qlPFF, sc(qrVarWe) ? null : qrVarWe, sc(pff) ? null : pff, wePFF, pffSc3, pffSc4, pFF(pffSc) ? null : pffSc, zY(pffSc2) ? null : pffSc2);
    }

    private static boolean sc(com.bytedance.adsdk.pFF.zY.sc.ExN exN) {
        if (exN != null) {
            return exN.pFF() && exN.zY().get(0).f26180sc.equals(0.0f, 0.0f);
        }
        return true;
    }

    private static boolean sc(com.bytedance.adsdk.pFF.zY.sc.Ql<PointF, PointF> ql2) {
        if (ql2 != null) {
            return !(ql2 instanceof com.bytedance.adsdk.pFF.zY.sc.Ol) && ql2.pFF() && ql2.zY().get(0).f26180sc.equals(0.0f, 0.0f);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean sc(com.bytedance.adsdk.pFF.zY.sc.pFF pff) {
        if (pff != null) {
            return pff.pFF() && ((Float) ((com.bytedance.adsdk.pFF.qr.sc) pff.zY().get(0)).f26180sc).floatValue() == 0.0f;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean sc(com.bytedance.adsdk.pFF.zY.sc.qr qrVar) {
        if (qrVar != null) {
            return qrVar.pFF() && ((com.bytedance.adsdk.pFF.qr.zY) ((com.bytedance.adsdk.pFF.qr.sc) qrVar.zY().get(0)).f26180sc).pFF(1.0f, 1.0f);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zY(com.bytedance.adsdk.pFF.zY.sc.pFF pff) {
        if (pff != null) {
            return pff.pFF() && ((Float) ((com.bytedance.adsdk.pFF.qr.sc) pff.zY().get(0)).f26180sc).floatValue() == 0.0f;
        }
        return true;
    }
}
