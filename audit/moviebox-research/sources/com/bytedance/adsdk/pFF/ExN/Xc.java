package com.bytedance.adsdk.pFF.ExN;

import android.util.JsonReader;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.gslb.Worker;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class Xc {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0036  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static com.bytedance.adsdk.pFF.zY.pFF.TRI sc(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr qrVar) throws IOException {
        byte b11;
        com.bytedance.adsdk.pFF.zY.pFF.wjp.sc scVar;
        com.bytedance.adsdk.pFF.zY.pFF.wjp.pFF pff;
        ArrayList arrayList = new ArrayList();
        String strNextString = null;
        com.bytedance.adsdk.pFF.zY.pFF.qr qrVar2 = null;
        com.bytedance.adsdk.pFF.zY.sc.zY zYVarSc = null;
        com.bytedance.adsdk.pFF.zY.sc.TRI triZY = null;
        com.bytedance.adsdk.pFF.zY.sc.TRI triZY2 = null;
        com.bytedance.adsdk.pFF.zY.sc.pFF pffSc = null;
        com.bytedance.adsdk.pFF.zY.pFF.wjp.sc scVar2 = null;
        com.bytedance.adsdk.pFF.zY.pFF.wjp.pFF pff2 = null;
        float fNextDouble = 0.0f;
        com.bytedance.adsdk.pFF.zY.sc.pFF pff3 = null;
        boolean zNextBoolean = false;
        com.bytedance.adsdk.pFF.zY.sc.We we2 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            zNextBoolean = zNextBoolean;
            com.bytedance.adsdk.pFF.zY.sc.pFF pff4 = pff3;
            float f11 = fNextDouble;
            switch (strNextName.hashCode()) {
                case 100:
                    if (!strNextName.equals(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D)) {
                        b11 = -1;
                    } else {
                        b11 = 0;
                    }
                    break;
                case 101:
                    if (!strNextName.equals("e")) {
                        b11 = -1;
                    } else {
                        b11 = 1;
                    }
                    break;
                case Worker.WHAT_SYNC_DATA /* 103 */:
                    if (!strNextName.equals("g")) {
                        b11 = -1;
                    } else {
                        b11 = 2;
                    }
                    break;
                case 111:
                    if (!strNextName.equals("o")) {
                        b11 = -1;
                    } else {
                        b11 = 3;
                    }
                    break;
                case 115:
                    if (!strNextName.equals("s")) {
                        b11 = -1;
                    } else {
                        b11 = 4;
                    }
                    break;
                case 116:
                    if (!strNextName.equals("t")) {
                        b11 = -1;
                    } else {
                        b11 = 5;
                    }
                    break;
                case 119:
                    if (!strNextName.equals("w")) {
                        b11 = -1;
                    } else {
                        b11 = 6;
                    }
                    break;
                case 3324:
                    if (!strNextName.equals("hd")) {
                        b11 = -1;
                    } else {
                        b11 = 7;
                    }
                    break;
                case 3447:
                    if (!strNextName.equals("lc")) {
                        b11 = -1;
                    } else {
                        b11 = 8;
                    }
                    break;
                case 3454:
                    if (!strNextName.equals("lj")) {
                        b11 = -1;
                    } else {
                        b11 = 9;
                    }
                    break;
                case 3487:
                    if (!strNextName.equals("ml")) {
                        b11 = -1;
                    } else {
                        b11 = 10;
                    }
                    break;
                case 3519:
                    if (!strNextName.equals("nm")) {
                        b11 = -1;
                    } else {
                        b11 = Ascii.VT;
                    }
                    break;
                default:
                    b11 = -1;
                    break;
            }
            switch (b11) {
                case 0:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        com.bytedance.adsdk.pFF.zY.sc.pFF pffSc2 = null;
                        String strNextString2 = null;
                        while (jsonReader.hasNext()) {
                            com.bytedance.adsdk.pFF.zY.pFF.wjp.pFF pff5 = pff2;
                            String strNextName2 = jsonReader.nextName();
                            strNextName2.hashCode();
                            com.bytedance.adsdk.pFF.zY.pFF.wjp.sc scVar3 = scVar2;
                            if (strNextName2.equals("n")) {
                                strNextString2 = jsonReader.nextString();
                            } else if (strNextName2.equals("v")) {
                                pffSc2 = We.sc(jsonReader, qrVar);
                            } else {
                                jsonReader.skipValue();
                            }
                            pff2 = pff5;
                            scVar2 = scVar3;
                        }
                        com.bytedance.adsdk.pFF.zY.pFF.wjp.sc scVar4 = scVar2;
                        com.bytedance.adsdk.pFF.zY.pFF.wjp.pFF pff6 = pff2;
                        jsonReader.endObject();
                        if (strNextString2.equals("o")) {
                            pff4 = pffSc2;
                        } else if (strNextString2.equals(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D) || strNextString2.equals("g")) {
                            qrVar.sc(true);
                            arrayList.add(pffSc2);
                        }
                        pff2 = pff6;
                        scVar2 = scVar4;
                    }
                    scVar = scVar2;
                    pff = pff2;
                    jsonReader.endArray();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                        pff3 = pff4;
                    } else {
                        pff3 = pff4;
                    }
                    pff2 = pff;
                    fNextDouble = f11;
                    scVar2 = scVar;
                    break;
                case 1:
                    triZY2 = We.zY(jsonReader, qrVar);
                    zNextBoolean = zNextBoolean;
                    pff3 = pff4;
                    fNextDouble = f11;
                    break;
                case 2:
                    jsonReader.beginObject();
                    int iNextInt = -1;
                    while (jsonReader.hasNext()) {
                        String strNextName3 = jsonReader.nextName();
                        strNextName3.hashCode();
                        if (strNextName3.equals(CampaignEx.JSON_KEY_AD_K)) {
                            zYVarSc = We.sc(jsonReader, qrVar, iNextInt);
                        } else if (strNextName3.equals(TtmlNode.TAG_P)) {
                            iNextInt = jsonReader.nextInt();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    zNextBoolean = zNextBoolean;
                    pff3 = pff4;
                    fNextDouble = f11;
                    break;
                case 3:
                    we2 = We.pFF(jsonReader, qrVar);
                    zNextBoolean = zNextBoolean;
                    pff3 = pff4;
                    fNextDouble = f11;
                    break;
                case 4:
                    triZY = We.zY(jsonReader, qrVar);
                    zNextBoolean = zNextBoolean;
                    pff3 = pff4;
                    fNextDouble = f11;
                    break;
                case 5:
                    qrVar2 = jsonReader.nextInt() == 1 ? com.bytedance.adsdk.pFF.zY.pFF.qr.LINEAR : com.bytedance.adsdk.pFF.zY.pFF.qr.RADIAL;
                    zNextBoolean = zNextBoolean;
                    pff3 = pff4;
                    fNextDouble = f11;
                    break;
                case 6:
                    pffSc = We.sc(jsonReader, qrVar);
                    zNextBoolean = zNextBoolean;
                    pff3 = pff4;
                    fNextDouble = f11;
                    break;
                case 7:
                    zNextBoolean = jsonReader.nextBoolean();
                    pff3 = pff4;
                    fNextDouble = f11;
                    break;
                case 8:
                    scVar2 = com.bytedance.adsdk.pFF.zY.pFF.wjp.sc.values()[jsonReader.nextInt() - 1];
                    zNextBoolean = zNextBoolean;
                    pff3 = pff4;
                    fNextDouble = f11;
                    break;
                case 9:
                    pff2 = com.bytedance.adsdk.pFF.zY.pFF.wjp.pFF.values()[jsonReader.nextInt() - 1];
                    zNextBoolean = zNextBoolean;
                    pff3 = pff4;
                    fNextDouble = f11;
                    break;
                case 10:
                    fNextDouble = (float) jsonReader.nextDouble();
                    zNextBoolean = zNextBoolean;
                    pff3 = pff4;
                    break;
                case 11:
                    strNextString = jsonReader.nextString();
                    zNextBoolean = zNextBoolean;
                    pff3 = pff4;
                    fNextDouble = f11;
                    break;
                default:
                    jsonReader.skipValue();
                    scVar = scVar2;
                    pff = pff2;
                    pff3 = pff4;
                    pff2 = pff;
                    fNextDouble = f11;
                    scVar2 = scVar;
                    break;
            }
        }
        com.bytedance.adsdk.pFF.zY.pFF.wjp.sc scVar5 = scVar2;
        com.bytedance.adsdk.pFF.zY.pFF.wjp.pFF pff7 = pff2;
        float f12 = fNextDouble;
        com.bytedance.adsdk.pFF.zY.sc.pFF pff8 = pff3;
        boolean z11 = zNextBoolean;
        if (we2 == null) {
            we2 = new com.bytedance.adsdk.pFF.zY.sc.We(Collections.singletonList(new com.bytedance.adsdk.pFF.qr.sc(100)));
        }
        return new com.bytedance.adsdk.pFF.zY.pFF.TRI(strNextString, qrVar2, zYVarSc, we2, triZY, triZY2, pffSc, scVar5, pff7, f12, arrayList, pff8, z11);
    }
}
