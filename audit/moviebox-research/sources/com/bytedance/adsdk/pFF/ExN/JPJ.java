package com.bytedance.adsdk.pFF.ExN;

import android.graphics.Rect;
import android.util.JsonReader;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.applovin.exoplayer2.common.base.Ascii;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class JPJ {
    /* JADX WARN: Code duplicated, block: B:44:0x0085  */
    private static List<com.bytedance.adsdk.pFF.WH.sc> We(JsonReader jsonReader) {
        try {
            ArrayList arrayList = new ArrayList();
            while (jsonReader.hasNext()) {
                com.bytedance.adsdk.pFF.WH.sc scVar = new com.bytedance.adsdk.pFF.WH.sc();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    switch (jsonReader.nextName()) {
                        case "l":
                            scVar.f26162sc = jsonReader.nextInt();
                            break;
                        case "le":
                            scVar.pFF = jsonReader.nextInt();
                            break;
                        case "s":
                            scVar.ExN = jsonReader.nextInt();
                            break;
                        case "c":
                            scVar.zY = jsonReader.nextString();
                            break;
                        case "f":
                            scVar.We = jsonReader.nextString();
                            break;
                        case "bs":
                            scVar.TRI = jsonReader.nextInt();
                            break;
                        case "ali":
                            scVar.f26161qr = jsonReader.nextString();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
                jsonReader.endObject();
                arrayList.add(scVar);
            }
            return arrayList;
        } catch (Exception unused) {
            return null;
        }
    }

    private static Map<String, Object> pFF(JsonReader jsonReader) throws IOException {
        HashMap map = new HashMap();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("lel")) {
                map.put("lel", zY(jsonReader));
            } else if (strNextName.equals("lottie_back")) {
                JSONObject jSONObject = new JSONObject();
                map.put("lottie_back", jSONObject);
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName2 = jsonReader.nextName();
                    strNextName2.hashCode();
                    if (strNextName2.equals("hd")) {
                        try {
                            jSONObject.putOpt("hd", Integer.valueOf(jsonReader.nextInt()));
                            jSONObject.putOpt("vid", "lottie_back");
                        } catch (JSONException unused) {
                        }
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        Object objRemove = map.remove("lottie_back");
        if (objRemove instanceof JSONObject) {
            Object obj = map.get("lel");
            if (obj instanceof JSONArray) {
                ((JSONArray) obj).put(objRemove);
            } else {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(objRemove);
                map.put("lel", jSONArray);
            }
        }
        return map;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x003f  */
    private static void pFF(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr.sc scVar) {
        byte b11;
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                int iHashCode = strNextName.hashCode();
                if (iHashCode != 3239) {
                    if (iHashCode != 3276) {
                        if (iHashCode == 107027 && strNextName.equals("lel")) {
                            b11 = 2;
                        } else {
                            b11 = -1;
                        }
                    } else if (strNextName.equals("fr")) {
                        b11 = 0;
                    } else {
                        b11 = -1;
                    }
                } else if (strNextName.equals("el")) {
                    b11 = 1;
                } else {
                    b11 = -1;
                }
                if (b11 == 0) {
                    scVar.ExN = jsonReader.nextInt();
                } else if (b11 == 1) {
                    scVar.TRI = jsonReader.nextString();
                } else if (b11 != 2) {
                    jsonReader.skipValue();
                } else {
                    scVar.f26175qr = zY(jsonReader);
                }
            }
            jsonReader.endObject();
        } catch (IOException unused) {
        }
    }

    public static com.bytedance.adsdk.pFF.qr sc(JsonReader jsonReader) throws IOException {
        int i11;
        float fSc = com.bytedance.adsdk.pFF.TRI.TRI.sc();
        LongSparseArray<com.bytedance.adsdk.pFF.zY.zY.ExN> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        SparseArray<com.bytedance.adsdk.pFF.zY.We> sparseArray = new SparseArray<>();
        com.bytedance.adsdk.pFF.qr.zY zYVar = new com.bytedance.adsdk.pFF.qr.zY();
        com.bytedance.adsdk.pFF.qr.sc scVar = new com.bytedance.adsdk.pFF.qr.sc();
        com.bytedance.adsdk.pFF.qr.pFF pff = new com.bytedance.adsdk.pFF.qr.pFF();
        com.bytedance.adsdk.pFF.qr qrVar = new com.bytedance.adsdk.pFF.qr();
        jsonReader.beginObject();
        String strNextString = null;
        int iNextInt = 0;
        int iNextInt2 = 0;
        float fNextDouble = 0.0f;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            byte b11 = -1;
            switch (strNextName.hashCode()) {
                case -1408207997:
                    i11 = iNextInt2;
                    if (strNextName.equals("assets")) {
                        b11 = 0;
                    }
                    break;
                case -1109732030:
                    i11 = iNextInt2;
                    if (strNextName.equals("layers")) {
                        b11 = 1;
                    }
                    break;
                case -865448777:
                    i11 = iNextInt2;
                    if (strNextName.equals("globalEvent")) {
                        b11 = 2;
                    }
                    break;
                case 104:
                    i11 = iNextInt2;
                    if (strNextName.equals("h")) {
                        b11 = 3;
                    }
                    break;
                case 118:
                    i11 = iNextInt2;
                    if (strNextName.equals("v")) {
                        b11 = 4;
                    }
                    break;
                case 119:
                    i11 = iNextInt2;
                    if (strNextName.equals("w")) {
                        b11 = 5;
                    }
                    break;
                case 3208:
                    i11 = iNextInt2;
                    if (strNextName.equals("dl")) {
                        b11 = 6;
                    }
                    break;
                case 3276:
                    i11 = iNextInt2;
                    if (strNextName.equals("fr")) {
                        b11 = 7;
                    }
                    break;
                case 3292:
                    i11 = iNextInt2;
                    if (strNextName.equals("gc")) {
                        b11 = 8;
                    }
                    break;
                case 3367:
                    i11 = iNextInt2;
                    if (strNextName.equals("ip")) {
                        b11 = 9;
                    }
                    break;
                case 3553:
                    i11 = iNextInt2;
                    if (strNextName.equals("op")) {
                        b11 = 10;
                    }
                    break;
                case 94623709:
                    i11 = iNextInt2;
                    if (strNextName.equals("chars")) {
                        b11 = Ascii.VT;
                    }
                    break;
                case 97615364:
                    i11 = iNextInt2;
                    if (strNextName.equals("fonts")) {
                        b11 = Ascii.FF;
                    }
                    break;
                case 110364485:
                    i11 = iNextInt2;
                    if (strNextName.equals("timer")) {
                        b11 = Ascii.CR;
                    }
                    break;
                case 839250809:
                    i11 = iNextInt2;
                    if (strNextName.equals("markers")) {
                        b11 = Ascii.SO;
                    }
                    break;
                default:
                    i11 = iNextInt2;
                    break;
            }
            switch (b11) {
                case 0:
                    sc(jsonReader, qrVar, map, map2);
                    break;
                case 1:
                    sc(jsonReader, qrVar, arrayList, longSparseArray);
                    break;
                case 2:
                    sc(jsonReader, pff);
                    break;
                case 3:
                    iNextInt2 = jsonReader.nextInt();
                    continue;
                case 4:
                    String[] strArrSplit = jsonReader.nextString().split("\\.");
                    if (!com.bytedance.adsdk.pFF.TRI.TRI.sc(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), 4, 4, 0)) {
                        qrVar.sc("Lottie only supports bodymovin >= 4.4.0");
                    }
                    break;
                case 5:
                    iNextInt = jsonReader.nextInt();
                    break;
                case 6:
                    strNextString = jsonReader.nextString();
                    break;
                case 7:
                    fNextDouble3 = (float) jsonReader.nextDouble();
                    break;
                case 8:
                    sc(jsonReader, scVar);
                    break;
                case 9:
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case 10:
                    fNextDouble2 = ((float) jsonReader.nextDouble()) - 0.01f;
                    break;
                case 11:
                    sc(jsonReader, qrVar, sparseArray);
                    break;
                case 12:
                    sc(jsonReader, map3);
                    break;
                case 13:
                    sc(jsonReader, zYVar);
                    break;
                case 14:
                    sc(jsonReader, arrayList2);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
            iNextInt2 = i11;
        }
        jsonReader.endObject();
        qrVar.sc(new Rect(0, 0, (int) (iNextInt * fSc), (int) (iNextInt2 * fSc)), fNextDouble, fNextDouble2, fNextDouble3, arrayList, longSparseArray, map, map2, sparseArray, map3, arrayList2, zYVar, strNextString, scVar, pff);
        return qrVar;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0042  */
    private static void sc(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr.pFF pff) {
        byte b11;
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                int iHashCode = strNextName.hashCode();
                if (iHashCode != 3239) {
                    if (iHashCode != 107027) {
                        if (iHashCode == 3237004 && strNextName.equals("inel")) {
                            b11 = 0;
                        } else {
                            b11 = -1;
                        }
                    } else if (strNextName.equals("lel")) {
                        b11 = 2;
                    } else {
                        b11 = -1;
                    }
                } else if (strNextName.equals("el")) {
                    b11 = 1;
                } else {
                    b11 = -1;
                }
                if (b11 == 0) {
                    pff.pFF = new int[][]{new int[]{-1, -1}};
                    jsonReader.beginArray();
                    if (jsonReader.hasNext()) {
                        jsonReader.beginArray();
                        for (int i11 = 0; i11 < 2; i11++) {
                            if (jsonReader.hasNext()) {
                                pff.pFF[0][i11] = jsonReader.nextInt();
                            }
                        }
                        jsonReader.endArray();
                    }
                    jsonReader.endArray();
                } else if (b11 == 1) {
                    pff.f26174sc = jsonReader.nextString();
                } else if (b11 != 2) {
                    jsonReader.skipValue();
                } else {
                    pff.zY = zY(jsonReader);
                }
            }
            jsonReader.endObject();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    private static void sc(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr.sc scVar) {
        byte b11;
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                int iHashCode = strNextName.hashCode();
                if (iHashCode != 3139) {
                    if (iHashCode != 3232) {
                        if (iHashCode != 3571) {
                            if (iHashCode != 3666) {
                                if (iHashCode == 98713 && strNextName.equals("cpf")) {
                                    b11 = 4;
                                } else {
                                    b11 = -1;
                                }
                            } else if (strNextName.equals("se")) {
                                b11 = 0;
                            } else {
                                b11 = -1;
                            }
                        } else if (strNextName.equals("pc")) {
                            b11 = 3;
                        } else {
                            b11 = -1;
                        }
                    } else if (strNextName.equals("ee")) {
                        b11 = 2;
                    } else {
                        b11 = -1;
                    }
                } else if (strNextName.equals("be")) {
                    b11 = 1;
                } else {
                    b11 = -1;
                }
                if (b11 == 0) {
                    scVar.f26176sc = jsonReader.nextInt();
                } else if (b11 == 1) {
                    scVar.pFF = pFF(jsonReader);
                } else if (b11 == 2) {
                    scVar.zY = pFF(jsonReader);
                } else if (b11 == 3) {
                    scVar.We = jsonReader.nextInt();
                } else if (b11 != 4) {
                    jsonReader.skipValue();
                } else {
                    pFF(jsonReader, scVar);
                }
            }
            jsonReader.endObject();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0079  */
    private static void sc(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr.zY zYVar) {
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                switch (jsonReader.nextName()) {
                    case "ke":
                        zYVar.f26178sc = jsonReader.nextInt();
                        break;
                    case "id":
                        zYVar.pFF = jsonReader.nextString();
                        break;
                    case "tl":
                        zYVar.zY = jsonReader.nextString();
                        break;
                    case "at":
                        zYVar.We = jsonReader.nextString();
                        break;
                    case "inel":
                        zYVar.ExN = new int[]{-1, -1};
                        jsonReader.beginArray();
                        for (int i11 = 0; i11 < 2; i11++) {
                            if (jsonReader.hasNext()) {
                                zYVar.ExN[i11] = jsonReader.nextInt();
                            }
                        }
                        jsonReader.endArray();
                        break;
                    case "el":
                        zYVar.TRI = jsonReader.nextString();
                        break;
                    case "lel":
                        zYVar.f26177qr = zY(jsonReader);
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
        } catch (Exception unused) {
        }
    }

    private static void sc(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr qrVar, SparseArray<com.bytedance.adsdk.pFF.zY.We> sparseArray) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            com.bytedance.adsdk.pFF.zY.We weSc = Ql.sc(jsonReader, qrVar);
            sparseArray.put(weSc.hashCode(), weSc);
        }
        jsonReader.endArray();
    }

    private static void sc(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr qrVar, List<com.bytedance.adsdk.pFF.zY.zY.ExN> list, LongSparseArray<com.bytedance.adsdk.pFF.zY.zY.ExN> longSparseArray) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            com.bytedance.adsdk.pFF.zY.zY.ExN exNSc = uEA.sc(jsonReader, qrVar);
            exNSc.UFX();
            com.bytedance.adsdk.pFF.zY.zY.ExN.sc scVar = com.bytedance.adsdk.pFF.zY.zY.ExN.sc.PRE_COMP;
            list.add(exNSc);
            longSparseArray.put(exNSc.ExN(), exNSc);
        }
        jsonReader.endArray();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:10:0x0037  */
    private static void sc(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr qrVar, Map<String, List<com.bytedance.adsdk.pFF.zY.zY.ExN>> map, Map<String, com.bytedance.adsdk.pFF.WH> map2) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            jsonReader.beginObject();
            String strNextString = null;
            String strNextString2 = null;
            String strNextString3 = null;
            String strNextString4 = null;
            List<com.bytedance.adsdk.pFF.WH.sc> listWe = null;
            String strNextString5 = null;
            int[][] iArr = null;
            JSONArray jSONArrayZY = null;
            int iNextInt = 0;
            int iNextInt2 = 0;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                strNextName.hashCode();
                switch (strNextName) {
                    case "layers":
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            com.bytedance.adsdk.pFF.zY.zY.ExN exNSc = uEA.sc(jsonReader, qrVar);
                            longSparseArray.put(exNSc.ExN(), exNSc);
                            arrayList.add(exNSc);
                        }
                        jsonReader.endArray();
                        break;
                    case "h":
                        iNextInt2 = jsonReader.nextInt();
                        break;
                    case "p":
                        strNextString2 = jsonReader.nextString();
                        break;
                    case "u":
                        strNextString3 = jsonReader.nextString();
                        break;
                    case "w":
                        iNextInt = jsonReader.nextInt();
                        break;
                    case "el":
                        strNextString5 = jsonReader.nextString();
                        break;
                    case "id":
                        strNextString = jsonReader.nextString();
                        break;
                    case "tc":
                        jsonReader.beginArray();
                        listWe = We(jsonReader);
                        jsonReader.endArray();
                        break;
                    case "lel":
                        jSONArrayZY = zY(jsonReader);
                        break;
                    case "rel":
                        strNextString4 = jsonReader.nextString();
                        break;
                    case "inel":
                        iArr = new int[][]{new int[]{-1, -1}};
                        jsonReader.beginArray();
                        if (jsonReader.hasNext()) {
                            jsonReader.beginArray();
                            for (int i11 = 0; i11 < 2; i11++) {
                                if (jsonReader.hasNext()) {
                                    iArr[0][i11] = jsonReader.nextInt();
                                }
                            }
                            jsonReader.endArray();
                        }
                        jsonReader.endArray();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            if (strNextString2 != null) {
                com.bytedance.adsdk.pFF.WH wh2 = new com.bytedance.adsdk.pFF.WH(iNextInt, iNextInt2, strNextString, strNextString2, strNextString3, strNextString4, listWe, strNextString5, iArr, jSONArrayZY);
                map2.put(wh2.Qj(), wh2);
            } else {
                map.put(strNextString, arrayList);
            }
        }
        jsonReader.endArray();
    }

    private static void sc(JsonReader jsonReader, List<com.bytedance.adsdk.pFF.zY.TRI> list) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            float fNextDouble = 0.0f;
            String strNextString = null;
            float fNextDouble2 = 0.0f;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                strNextName.hashCode();
                switch (strNextName) {
                    case "cm":
                        strNextString = jsonReader.nextString();
                        break;
                    case "dr":
                        fNextDouble2 = (float) jsonReader.nextDouble();
                        break;
                    case "tm":
                        fNextDouble = (float) jsonReader.nextDouble();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            list.add(new com.bytedance.adsdk.pFF.zY.TRI(strNextString, fNextDouble, fNextDouble2));
        }
        jsonReader.endArray();
    }

    private static void sc(JsonReader jsonReader, Map<String, com.bytedance.adsdk.pFF.zY.zY> map) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("list")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.bytedance.adsdk.pFF.zY.zY zYVarSc = SR.sc(jsonReader);
                    map.put(zYVarSc.pFF(), zYVarSc);
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0046  */
    private static JSONArray zY(JsonReader jsonReader) {
        byte b11;
        JSONArray jSONArray = new JSONArray();
        try {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                JSONObject jSONObject = new JSONObject();
                jSONArray.put(jSONObject);
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName = jsonReader.nextName();
                    int iHashCode = strNextName.hashCode();
                    if (iHashCode != 3324) {
                        if (iHashCode == 116753 && strNextName.equals("vid")) {
                            b11 = 0;
                        } else {
                            b11 = -1;
                        }
                    } else if (strNextName.equals("hd")) {
                        b11 = 1;
                    } else {
                        b11 = -1;
                    }
                    if (b11 == 0) {
                        jSONObject.put("vid", jsonReader.nextString());
                    } else if (b11 != 1) {
                        jsonReader.skipValue();
                    } else {
                        try {
                            jSONObject.put("hd", jsonReader.nextInt());
                        } catch (JSONException unused) {
                        }
                    }
                }
                jsonReader.endObject();
            }
            jsonReader.endArray();
        } catch (Exception unused2) {
        }
        return jSONArray;
    }
}
