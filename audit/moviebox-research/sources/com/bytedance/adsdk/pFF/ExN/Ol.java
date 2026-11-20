package com.bytedance.adsdk.pFF.ExN;

import android.graphics.PointF;
import android.util.JsonReader;
import com.applovin.exoplayer2.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Ol implements pc<com.bytedance.adsdk.pFF.zY.pFF> {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static final Ol f26090sc = new Ol();

    private Ol() {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.bytedance.adsdk.pFF.ExN.pc
    /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.pFF.zY.pFF pFF(JsonReader jsonReader, float f11) throws IOException {
        com.bytedance.adsdk.pFF.zY.pFF.sc scVar = com.bytedance.adsdk.pFF.zY.pFF.sc.CENTER;
        jsonReader.beginObject();
        com.bytedance.adsdk.pFF.zY.pFF.sc scVar2 = scVar;
        String strNextString = null;
        String strNextString2 = null;
        PointF pointF = null;
        PointF pointF2 = null;
        float fNextDouble = 0.0f;
        int iNextInt = 0;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        int iSc = 0;
        int iSc2 = 0;
        float fNextDouble4 = 0.0f;
        boolean zNextBoolean = true;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            byte b11 = -1;
            switch (strNextName.hashCode()) {
                case 102:
                    if (strNextName.equals("f")) {
                        b11 = 0;
                    }
                    break;
                case 106:
                    if (strNextName.equals("j")) {
                        b11 = 1;
                    }
                    break;
                case 115:
                    if (strNextName.equals("s")) {
                        b11 = 2;
                    }
                    break;
                case 116:
                    if (strNextName.equals("t")) {
                        b11 = 3;
                    }
                    break;
                case 3261:
                    if (strNextName.equals("fc")) {
                        b11 = 4;
                    }
                    break;
                case 3452:
                    if (strNextName.equals("lh")) {
                        b11 = 5;
                    }
                    break;
                case 3463:
                    if (strNextName.equals("ls")) {
                        b11 = 6;
                    }
                    break;
                case 3543:
                    if (strNextName.equals("of")) {
                        b11 = 7;
                    }
                    break;
                case 3587:
                    if (strNextName.equals("ps")) {
                        b11 = 8;
                    }
                    break;
                case 3664:
                    if (strNextName.equals("sc")) {
                        b11 = 9;
                    }
                    break;
                case 3684:
                    if (strNextName.equals("sw")) {
                        b11 = 10;
                    }
                    break;
                case 3687:
                    if (strNextName.equals("sz")) {
                        b11 = Ascii.VT;
                    }
                    break;
                case 3710:
                    if (strNextName.equals("tr")) {
                        b11 = Ascii.FF;
                    }
                    break;
            }
            switch (b11) {
                case 0:
                    strNextString2 = jsonReader.nextString();
                    break;
                case 1:
                    int iNextInt2 = jsonReader.nextInt();
                    scVar2 = com.bytedance.adsdk.pFF.zY.pFF.sc.CENTER;
                    if (iNextInt2 <= scVar2.ordinal() && iNextInt2 >= 0) {
                        scVar2 = com.bytedance.adsdk.pFF.zY.pFF.sc.values()[iNextInt2];
                    }
                    break;
                case 2:
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case 3:
                    strNextString = jsonReader.nextString();
                    break;
                case 4:
                    iSc = Sfl.sc(jsonReader);
                    break;
                case 5:
                    fNextDouble2 = (float) jsonReader.nextDouble();
                    break;
                case 6:
                    fNextDouble3 = (float) jsonReader.nextDouble();
                    break;
                case 7:
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case 8:
                    jsonReader.beginArray();
                    PointF pointF3 = new PointF(((float) jsonReader.nextDouble()) * f11, ((float) jsonReader.nextDouble()) * f11);
                    jsonReader.endArray();
                    pointF = pointF3;
                    break;
                case 9:
                    iSc2 = Sfl.sc(jsonReader);
                    break;
                case 10:
                    fNextDouble4 = (float) jsonReader.nextDouble();
                    break;
                case 11:
                    jsonReader.beginArray();
                    PointF pointF4 = new PointF(((float) jsonReader.nextDouble()) * f11, ((float) jsonReader.nextDouble()) * f11);
                    jsonReader.endArray();
                    pointF2 = pointF4;
                    break;
                case 12:
                    iNextInt = jsonReader.nextInt();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.bytedance.adsdk.pFF.zY.pFF(strNextString, strNextString2, fNextDouble, scVar2, iNextInt, fNextDouble2, fNextDouble3, iSc, iSc2, fNextDouble4, zNextBoolean, pointF, pointF2);
    }
}
