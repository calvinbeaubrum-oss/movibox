package com.bytedance.adsdk.pFF.ExN;

import android.util.JsonReader;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.b;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class Qj {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x003d  */
    public static com.bytedance.adsdk.pFF.zY.pFF.zY sc(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr qrVar) throws IOException {
        com.bytedance.adsdk.pFF.zY.pFF.zY zYVarSc;
        String strNextString;
        jsonReader.beginObject();
        byte b11 = 2;
        int iNextInt = 2;
        while (true) {
            zYVarSc = null;
            if (!jsonReader.hasNext()) {
                strNextString = null;
                break;
            }
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (!strNextName.equals(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D)) {
                if (strNextName.equals("ty")) {
                    strNextString = jsonReader.nextString();
                    break;
                }
                jsonReader.skipValue();
            } else {
                iNextInt = jsonReader.nextInt();
            }
        }
        if (strNextString == null) {
            return null;
        }
        switch (strNextString.hashCode()) {
            case 3239:
                if (!strNextString.equals("el")) {
                    b11 = -1;
                } else {
                    b11 = 0;
                }
                break;
            case 3270:
                if (!strNextString.equals("fl")) {
                    b11 = -1;
                } else {
                    b11 = 1;
                }
                break;
            case 3295:
                if (!strNextString.equals("gf")) {
                    b11 = -1;
                }
                break;
            case 3307:
                if (!strNextString.equals("gr")) {
                    b11 = -1;
                } else {
                    b11 = 3;
                }
                break;
            case 3308:
                if (!strNextString.equals("gs")) {
                    b11 = -1;
                } else {
                    b11 = 4;
                }
                break;
            case 3488:
                if (!strNextString.equals("mm")) {
                    b11 = -1;
                } else {
                    b11 = 5;
                }
                break;
            case 3633:
                if (!strNextString.equals(DownloadCommon.DOWNLOAD_REPORT_RETRY_COUNT)) {
                    b11 = -1;
                } else {
                    b11 = 6;
                }
                break;
            case 3634:
                if (!strNextString.equals("rd")) {
                    b11 = -1;
                } else {
                    b11 = 7;
                }
                break;
            case 3646:
                if (!strNextString.equals("rp")) {
                    b11 = -1;
                } else {
                    b11 = 8;
                }
                break;
            case 3669:
                if (!strNextString.equals(b.JSON_KEY_SH)) {
                    b11 = -1;
                } else {
                    b11 = 9;
                }
                break;
            case 3679:
                if (!strNextString.equals("sr")) {
                    b11 = -1;
                } else {
                    b11 = 10;
                }
                break;
            case 3681:
                if (!strNextString.equals("st")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.VT;
                }
                break;
            case 3705:
                if (!strNextString.equals("tm")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.FF;
                }
                break;
            case 3710:
                if (!strNextString.equals("tr")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.CR;
                }
                break;
            default:
                b11 = -1;
                break;
        }
        switch (b11) {
            case 0:
                zYVarSc = TRI.sc(jsonReader, qrVar, iNextInt);
                break;
            case 1:
                zYVarSc = kX.sc(jsonReader, qrVar);
                break;
            case 2:
                zYVarSc = dE.sc(jsonReader, qrVar);
                break;
            case 3:
                zYVarSc = BR.sc(jsonReader, qrVar);
                break;
            case 4:
                zYVarSc = Xc.sc(jsonReader, qrVar);
                break;
            case 5:
                zYVarSc = WP.sc(jsonReader);
                qrVar.sc("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            case 6:
                zYVarSc = Gb.sc(jsonReader, qrVar);
                break;
            case 7:
                zYVarSc = Cb.sc(jsonReader, qrVar);
                break;
            case 8:
                zYVarSc = cD.sc(jsonReader, qrVar);
                break;
            case 9:
                zYVarSc = JoC.sc(jsonReader, qrVar);
                break;
            case 10:
                zYVarSc = HJN.sc(jsonReader, qrVar, iNextInt);
                break;
            case 11:
                zYVarSc = CYO.sc(jsonReader, qrVar);
                break;
            case 12:
                zYVarSc = qKn.sc(jsonReader, qrVar);
                break;
            case 13:
                zYVarSc = zY.sc(jsonReader, qrVar);
                break;
        }
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endObject();
        return zYVarSc;
    }
}
