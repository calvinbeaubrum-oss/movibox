package com.bytedance.adsdk.pFF.ExN;

import android.graphics.Path;
import android.util.JsonReader;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class dE {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0021  */
    public static com.bytedance.adsdk.pFF.zY.pFF.ExN sc(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr qrVar) throws IOException {
        com.bytedance.adsdk.pFF.zY.sc.We wePFF = null;
        Path.FillType fillType = Path.FillType.WINDING;
        String strNextString = null;
        com.bytedance.adsdk.pFF.zY.pFF.qr qrVar2 = null;
        com.bytedance.adsdk.pFF.zY.sc.zY zYVarSc = null;
        com.bytedance.adsdk.pFF.zY.sc.TRI triZY = null;
        com.bytedance.adsdk.pFF.zY.sc.TRI triZY2 = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            int iNextInt = -1;
            switch (strNextName) {
                case "e":
                    triZY2 = We.zY(jsonReader, qrVar);
                    break;
                case "g":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.hashCode();
                        if (strNextName2.equals(CampaignEx.JSON_KEY_AD_K)) {
                            zYVarSc = We.sc(jsonReader, qrVar, iNextInt);
                        } else if (strNextName2.equals(TtmlNode.TAG_P)) {
                            iNextInt = jsonReader.nextInt();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "o":
                    wePFF = We.pFF(jsonReader, qrVar);
                    break;
                case "r":
                    fillType = jsonReader.nextInt() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case "s":
                    triZY = We.zY(jsonReader, qrVar);
                    break;
                case "t":
                    qrVar2 = jsonReader.nextInt() == 1 ? com.bytedance.adsdk.pFF.zY.pFF.qr.LINEAR : com.bytedance.adsdk.pFF.zY.pFF.qr.RADIAL;
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
        return new com.bytedance.adsdk.pFF.zY.pFF.ExN(strNextString, qrVar2, fillType, zYVarSc, wePFF == null ? new com.bytedance.adsdk.pFF.zY.sc.We(Collections.singletonList(new com.bytedance.adsdk.pFF.qr.sc(100))) : wePFF, triZY, triZY2, null, null, zNextBoolean);
    }
}
