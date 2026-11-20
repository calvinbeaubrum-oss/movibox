package com.bytedance.adsdk.pFF.ExN;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.JsonReader;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.b;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class uEA {

    /* JADX INFO: renamed from: com.bytedance.adsdk.pFF.ExN.uEA$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        static final /* synthetic */ int[] f26098sc;

        static {
            int[] iArr = new int[com.bytedance.adsdk.pFF.zY.zY.ExN.pFF.values().length];
            f26098sc = iArr;
            try {
                iArr[com.bytedance.adsdk.pFF.zY.zY.ExN.pFF.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26098sc[com.bytedance.adsdk.pFF.zY.zY.ExN.pFF.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static com.bytedance.adsdk.pFF.zY.zY.ExN sc(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr qrVar) throws IOException {
        com.bytedance.adsdk.pFF.zY.zY.ExN.pFF pff = com.bytedance.adsdk.pFF.zY.zY.ExN.pFF.NONE;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        jsonReader.beginObject();
        Float fValueOf = Float.valueOf(0.0f);
        Float fValueOf2 = Float.valueOf(1.0f);
        com.bytedance.adsdk.pFF.zY.zY.ExN.pFF pff2 = pff;
        com.bytedance.adsdk.pFF.zY.zY.ExN.sc scVar = null;
        String strNextString = null;
        com.bytedance.adsdk.pFF.zY.sc.Tf tfSc = null;
        com.bytedance.adsdk.pFF.zY.sc.WH whTRI = null;
        com.bytedance.adsdk.pFF.zY.sc.UFX ufxSc = null;
        com.bytedance.adsdk.pFF.zY.sc.pFF pffSc = null;
        com.bytedance.adsdk.pFF.zY.pFF.sc scVarSc = null;
        WH whSc = null;
        long jNextInt = 0;
        long jNextInt2 = -1;
        float fNextDouble = 0.0f;
        int iNextInt = 0;
        int iNextInt2 = 0;
        int color = 0;
        float fNextDouble2 = 1.0f;
        float fNextDouble3 = 0.0f;
        float fNextDouble4 = 0.0f;
        float fNextDouble5 = 0.0f;
        boolean zNextBoolean = false;
        float fQr = 0.0f;
        String strNextString2 = "UNSET";
        String strNextString3 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            byte b11 = -1;
            switch (strNextName.hashCode()) {
                case -995424086:
                    if (strNextName.equals("parent")) {
                        b11 = 0;
                    }
                    break;
                case -903568142:
                    if (strNextName.equals("shapes")) {
                        b11 = 1;
                    }
                    break;
                case 104:
                    if (strNextName.equals("h")) {
                        b11 = 2;
                    }
                    break;
                case 116:
                    if (strNextName.equals("t")) {
                        b11 = 3;
                    }
                    break;
                case 119:
                    if (strNextName.equals("w")) {
                        b11 = 4;
                    }
                    break;
                case 3177:
                    if (strNextName.equals("cl")) {
                        b11 = 5;
                    }
                    break;
                case 3233:
                    if (strNextName.equals("ef")) {
                        b11 = 6;
                    }
                    break;
                case 3324:
                    if (strNextName.equals("hd")) {
                        b11 = 7;
                    }
                    break;
                case 3367:
                    if (strNextName.equals("ip")) {
                        b11 = 8;
                    }
                    break;
                case 3432:
                    if (strNextName.equals("ks")) {
                        b11 = 9;
                    }
                    break;
                case 3519:
                    if (strNextName.equals("nm")) {
                        b11 = 10;
                    }
                    break;
                case 3553:
                    if (strNextName.equals("op")) {
                        b11 = Ascii.VT;
                    }
                    break;
                case 3664:
                    if (strNextName.equals("sc")) {
                        b11 = Ascii.FF;
                    }
                    break;
                case 3669:
                    if (strNextName.equals(b.JSON_KEY_SH)) {
                        b11 = Ascii.CR;
                    }
                    break;
                case 3679:
                    if (strNextName.equals("sr")) {
                        b11 = Ascii.SO;
                    }
                    break;
                case 3681:
                    if (strNextName.equals("st")) {
                        b11 = Ascii.SI;
                    }
                    break;
                case 3684:
                    if (strNextName.equals("sw")) {
                        b11 = Ascii.DLE;
                    }
                    break;
                case 3705:
                    if (strNextName.equals("tm")) {
                        b11 = 17;
                    }
                    break;
                case 3712:
                    if (strNextName.equals(TtmlNode.TAG_TT)) {
                        b11 = Ascii.DC2;
                    }
                    break;
                case 3717:
                    if (strNextName.equals("ty")) {
                        b11 = 19;
                    }
                    break;
                case 104415:
                    if (strNextName.equals("ind")) {
                        b11 = Ascii.DC4;
                    }
                    break;
                case 108390670:
                    if (strNextName.equals("refId")) {
                        b11 = Ascii.NAK;
                    }
                    break;
                case 1441620890:
                    if (strNextName.equals("masksProperties")) {
                        b11 = Ascii.SYN;
                    }
                    break;
            }
            switch (b11) {
                case 0:
                    jNextInt2 = jsonReader.nextInt();
                    break;
                case 1:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        com.bytedance.adsdk.pFF.zY.pFF.zY zYVarSc = Qj.sc(jsonReader, qrVar);
                        if (zYVarSc != null) {
                            arrayList2.add(zYVarSc);
                        }
                    }
                    jsonReader.endArray();
                    break;
                case 2:
                    fNextDouble5 = (float) (jsonReader.nextDouble() * ((double) com.bytedance.adsdk.pFF.TRI.TRI.sc()));
                    break;
                case 3:
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.hashCode();
                        if (strNextName2.equals("a")) {
                            jsonReader.beginArray();
                            if (jsonReader.hasNext()) {
                                ufxSc = pFF.sc(jsonReader, qrVar);
                            }
                            while (jsonReader.hasNext()) {
                                jsonReader.skipValue();
                            }
                            jsonReader.endArray();
                        } else if (strNextName2.equals(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D)) {
                            whTRI = We.TRI(jsonReader, qrVar);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case 4:
                    fNextDouble4 = (float) (jsonReader.nextDouble() * ((double) com.bytedance.adsdk.pFF.TRI.TRI.sc()));
                    break;
                case 5:
                    strNextString3 = jsonReader.nextString();
                    break;
                case 6:
                    jsonReader.beginArray();
                    ArrayList arrayList3 = new ArrayList();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String strNextName3 = jsonReader.nextName();
                            strNextName3.hashCode();
                            if (strNextName3.equals("nm")) {
                                arrayList3.add(jsonReader.nextString());
                            } else if (strNextName3.equals("ty")) {
                                int iNextInt3 = jsonReader.nextInt();
                                if (iNextInt3 == 29) {
                                    scVarSc = ExN.sc(jsonReader, qrVar);
                                } else if (iNextInt3 == 25) {
                                    whSc = new UFX().sc(jsonReader, qrVar);
                                }
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        jsonReader.endObject();
                    }
                    jsonReader.endArray();
                    qrVar.sc("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: ".concat(String.valueOf(arrayList3)));
                    break;
                case 7:
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case 8:
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case 9:
                    tfSc = zY.sc(jsonReader, qrVar);
                    break;
                case 10:
                    strNextString2 = jsonReader.nextString();
                    break;
                case 11:
                    fQr = (float) jsonReader.nextDouble();
                    break;
                case 12:
                    color = Color.parseColor(jsonReader.nextString());
                    break;
                case 13:
                    iNextInt2 = (int) (jsonReader.nextInt() * com.bytedance.adsdk.pFF.TRI.TRI.sc());
                    break;
                case 14:
                    fNextDouble2 = (float) jsonReader.nextDouble();
                    break;
                case 15:
                    fNextDouble3 = (float) jsonReader.nextDouble();
                    break;
                case 16:
                    iNextInt = (int) (jsonReader.nextInt() * com.bytedance.adsdk.pFF.TRI.TRI.sc());
                    break;
                case 17:
                    pffSc = We.sc(jsonReader, qrVar, false);
                    break;
                case 18:
                    int iNextInt4 = jsonReader.nextInt();
                    if (iNextInt4 < com.bytedance.adsdk.pFF.zY.zY.ExN.pFF.values().length) {
                        pff2 = com.bytedance.adsdk.pFF.zY.zY.ExN.pFF.values()[iNextInt4];
                        int i11 = AnonymousClass1.f26098sc[pff2.ordinal()];
                        if (i11 == 1) {
                            qrVar.sc("Unsupported matte type: Luma");
                        } else if (i11 == 2) {
                            qrVar.sc("Unsupported matte type: Luma Inverted");
                        }
                        qrVar.sc(1);
                    } else {
                        qrVar.sc("Unsupported matte type: ".concat(String.valueOf(iNextInt4)));
                    }
                    break;
                case 19:
                    int iNextInt5 = jsonReader.nextInt();
                    scVar = com.bytedance.adsdk.pFF.zY.zY.ExN.sc.UNKNOWN;
                    if (iNextInt5 < scVar.ordinal()) {
                        scVar = com.bytedance.adsdk.pFF.zY.zY.ExN.sc.values()[iNextInt5];
                    }
                    break;
                case 20:
                    jNextInt = jsonReader.nextInt();
                    break;
                case 21:
                    strNextString = jsonReader.nextString();
                    break;
                case 22:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        arrayList.add(FI.sc(jsonReader, qrVar));
                    }
                    qrVar.sc(arrayList.size());
                    jsonReader.endArray();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        ArrayList arrayList4 = new ArrayList();
        if (fNextDouble > 0.0f) {
            arrayList4.add(new com.bytedance.adsdk.pFF.qr.sc(qrVar, fValueOf, fValueOf, null, 0.0f, Float.valueOf(fNextDouble)));
        }
        if (fQr <= 0.0f) {
            fQr = qrVar.qr();
        }
        arrayList4.add(new com.bytedance.adsdk.pFF.qr.sc(qrVar, fValueOf2, fValueOf2, null, fNextDouble, Float.valueOf(fQr)));
        arrayList4.add(new com.bytedance.adsdk.pFF.qr.sc(qrVar, fValueOf, fValueOf, null, fQr, Float.valueOf(Float.MAX_VALUE)));
        if (strNextString2.endsWith(".ai") || "ai".equals(strNextString3)) {
            qrVar.sc("Convert your Illustrator layers to shape layers.");
        }
        return new com.bytedance.adsdk.pFF.zY.zY.ExN(arrayList2, qrVar, strNextString2, jNextInt, scVar, jNextInt2, strNextString, arrayList, tfSc, iNextInt, iNextInt2, color, fNextDouble2, fNextDouble3, fNextDouble4, fNextDouble5, whTRI, ufxSc, arrayList4, pff2, pffSc, zNextBoolean, scVarSc, whSc);
    }

    public static com.bytedance.adsdk.pFF.zY.zY.ExN sc(com.bytedance.adsdk.pFF.qr qrVar) {
        Rect rectWe = qrVar.We();
        return new com.bytedance.adsdk.pFF.zY.zY.ExN(Collections.emptyList(), qrVar, "__container", -1L, com.bytedance.adsdk.pFF.zY.zY.ExN.sc.PRE_COMP, -1L, null, Collections.emptyList(), new com.bytedance.adsdk.pFF.zY.sc.Tf(), 0, 0, 0, 0.0f, 0.0f, rectWe.width(), rectWe.height(), null, null, Collections.emptyList(), com.bytedance.adsdk.pFF.zY.zY.ExN.pFF.NONE, null, false, null, null);
    }
}
