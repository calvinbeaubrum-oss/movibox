package com.bytedance.adsdk.pFF.ExN;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.SparseArray;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class YIK {
    private static SparseArray<WeakReference<Interpolator>> pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static final Interpolator f26095sc = new LinearInterpolator();

    /* JADX WARN: Code duplicated, block: B:128:0x0291  */
    private static <T> com.bytedance.adsdk.pFF.qr.sc<T> pFF(com.bytedance.adsdk.pFF.qr qrVar, JsonReader jsonReader, float f11, pc<T> pcVar) throws IOException {
        Interpolator interpolatorSc;
        Interpolator interpolatorSc2;
        T t11;
        Interpolator interpolatorSc3;
        com.bytedance.adsdk.pFF.qr.sc<T> scVar;
        PointF pointF;
        T t12;
        PointF pointF2;
        float f12;
        PointF pointF3;
        T t13;
        jsonReader.beginObject();
        PointF pointFPFF = null;
        boolean z11 = false;
        PointF pointFPFF2 = null;
        PointF pointFPFF3 = null;
        PointF pointF4 = null;
        T tPFF = null;
        PointF pointF5 = null;
        PointF pointF6 = null;
        PointF pointF7 = null;
        float fNextDouble = 0.0f;
        PointF pointFPFF4 = null;
        T tPFF2 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "e":
                    tPFF2 = pcVar.pFF(jsonReader, f11);
                    continue;
                    break;
                case "h":
                    pointF = pointFPFF;
                    t12 = tPFF;
                    pointF2 = pointF7;
                    f12 = fNextDouble;
                    pointF3 = pointFPFF4;
                    if (jsonReader.nextInt() != 1) {
                        z11 = false;
                        break;
                    } else {
                        z11 = true;
                        break;
                    }
                    break;
                case "i":
                    pointF = pointFPFF;
                    t12 = tPFF;
                    pointF2 = pointF7;
                    f12 = fNextDouble;
                    pointF3 = pointFPFF4;
                    if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
                        pointFPFF3 = Sfl.pFF(jsonReader, f11);
                        break;
                    } else {
                        jsonReader.beginObject();
                        float fNextDouble2 = 0.0f;
                        float fNextDouble3 = 0.0f;
                        float fNextDouble4 = 0.0f;
                        float fNextDouble5 = 0.0f;
                        while (jsonReader.hasNext()) {
                            String strNextName2 = jsonReader.nextName();
                            strNextName2.hashCode();
                            if (strNextName2.equals("x")) {
                                JsonToken jsonTokenPeek = jsonReader.peek();
                                JsonToken jsonToken = JsonToken.NUMBER;
                                if (jsonTokenPeek == jsonToken) {
                                    fNextDouble4 = (float) jsonReader.nextDouble();
                                    fNextDouble2 = fNextDouble4;
                                } else {
                                    jsonReader.beginArray();
                                    fNextDouble2 = (float) jsonReader.nextDouble();
                                    fNextDouble4 = jsonReader.peek() == jsonToken ? (float) jsonReader.nextDouble() : fNextDouble2;
                                    jsonReader.endArray();
                                }
                            } else if (strNextName2.equals("y")) {
                                JsonToken jsonTokenPeek2 = jsonReader.peek();
                                JsonToken jsonToken2 = JsonToken.NUMBER;
                                if (jsonTokenPeek2 == jsonToken2) {
                                    fNextDouble5 = (float) jsonReader.nextDouble();
                                    fNextDouble3 = fNextDouble5;
                                } else {
                                    jsonReader.beginArray();
                                    fNextDouble3 = (float) jsonReader.nextDouble();
                                    fNextDouble5 = jsonReader.peek() == jsonToken2 ? (float) jsonReader.nextDouble() : fNextDouble3;
                                    jsonReader.endArray();
                                }
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        PointF pointF8 = new PointF(fNextDouble2, fNextDouble3);
                        PointF pointF9 = new PointF(fNextDouble4, fNextDouble5);
                        jsonReader.endObject();
                        pointF7 = pointF9;
                        pointF6 = pointF8;
                        pointFPFF4 = pointF3;
                        pointFPFF = pointF;
                        fNextDouble = f12;
                        tPFF = t12;
                    }
                    break;
                case "o":
                    PointF pointF10 = pointFPFF4;
                    PointF pointF11 = pointFPFF;
                    if (jsonReader.peek() == JsonToken.BEGIN_OBJECT) {
                        jsonReader.beginObject();
                        float fNextDouble6 = 0.0f;
                        float fNextDouble7 = 0.0f;
                        float fNextDouble8 = 0.0f;
                        float fNextDouble9 = 0.0f;
                        while (jsonReader.hasNext()) {
                            fNextDouble = fNextDouble;
                            String strNextName3 = jsonReader.nextName();
                            strNextName3.hashCode();
                            if (strNextName3.equals("x")) {
                                t13 = tPFF;
                                JsonToken jsonTokenPeek3 = jsonReader.peek();
                                JsonToken jsonToken3 = JsonToken.NUMBER;
                                if (jsonTokenPeek3 == jsonToken3) {
                                    fNextDouble8 = (float) jsonReader.nextDouble();
                                    fNextDouble6 = fNextDouble8;
                                    tPFF = t13;
                                } else {
                                    jsonReader.beginArray();
                                    PointF pointF12 = pointF7;
                                    fNextDouble6 = (float) jsonReader.nextDouble();
                                    fNextDouble8 = jsonReader.peek() == jsonToken3 ? (float) jsonReader.nextDouble() : fNextDouble6;
                                    jsonReader.endArray();
                                    tPFF = t13;
                                    pointF7 = pointF12;
                                }
                            } else if (strNextName3.equals("y")) {
                                JsonToken jsonTokenPeek4 = jsonReader.peek();
                                JsonToken jsonToken4 = JsonToken.NUMBER;
                                if (jsonTokenPeek4 == jsonToken4) {
                                    fNextDouble9 = (float) jsonReader.nextDouble();
                                    fNextDouble7 = fNextDouble9;
                                } else {
                                    jsonReader.beginArray();
                                    t13 = tPFF;
                                    fNextDouble7 = (float) jsonReader.nextDouble();
                                    fNextDouble9 = jsonReader.peek() == jsonToken4 ? (float) jsonReader.nextDouble() : fNextDouble7;
                                    jsonReader.endArray();
                                    tPFF = t13;
                                }
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        PointF pointF13 = new PointF(fNextDouble6, fNextDouble7);
                        PointF pointF14 = new PointF(fNextDouble8, fNextDouble9);
                        jsonReader.endObject();
                        pointF5 = pointF14;
                        pointF4 = pointF13;
                    } else {
                        pointFPFF2 = Sfl.pFF(jsonReader, f11);
                    }
                    pointFPFF4 = pointF10;
                    pointFPFF = pointF11;
                    continue;
                    break;
                case "s":
                    tPFF = pcVar.pFF(jsonReader, f11);
                    continue;
                    break;
                case "t":
                    fNextDouble = (float) jsonReader.nextDouble();
                    continue;
                    break;
                case "ti":
                    pointFPFF = Sfl.pFF(jsonReader, f11);
                    continue;
                    break;
                case "to":
                    pointFPFF4 = Sfl.pFF(jsonReader, f11);
                    continue;
                    break;
                default:
                    jsonReader.skipValue();
                    continue;
                    break;
            }
            pointFPFF4 = pointF3;
            pointFPFF = pointF;
            fNextDouble = f12;
            tPFF = t12;
            pointF7 = pointF2;
        }
        PointF pointF15 = pointFPFF;
        T t14 = tPFF;
        PointF pointF16 = pointF7;
        float f13 = fNextDouble;
        PointF pointF17 = pointFPFF4;
        jsonReader.endObject();
        if (!z11) {
            if (pointFPFF2 != null && pointFPFF3 != null) {
                interpolatorSc3 = sc(pointFPFF2, pointFPFF3);
                t11 = tPFF2;
                interpolatorSc = null;
                interpolatorSc2 = null;
            } else if (pointF4 != null && pointF5 != null && pointF6 != null && pointF16 != null) {
                interpolatorSc = sc(pointF4, pointF6);
                interpolatorSc2 = sc(pointF5, pointF16);
                t11 = tPFF2;
                interpolatorSc3 = null;
            }
            if (interpolatorSc != null || interpolatorSc2 == null) {
                scVar = new com.bytedance.adsdk.pFF.qr.sc<>(qrVar, t14, t11, interpolatorSc3, f13, null);
            } else {
                scVar = new com.bytedance.adsdk.pFF.qr.sc<>(qrVar, t14, t11, interpolatorSc, interpolatorSc2, f13, null);
            }
            scVar.Qj = pointF17;
            scVar.Ol = pointF15;
            return scVar;
        }
        tPFF2 = t14;
        interpolatorSc3 = f26095sc;
        t11 = tPFF2;
        interpolatorSc = null;
        interpolatorSc2 = null;
        if (interpolatorSc != null) {
            scVar = new com.bytedance.adsdk.pFF.qr.sc<>(qrVar, t14, t11, interpolatorSc3, f13, null);
        } else {
            scVar = new com.bytedance.adsdk.pFF.qr.sc<>(qrVar, t14, t11, interpolatorSc3, f13, null);
        }
        scVar.Qj = pointF17;
        scVar.Ol = pointF15;
        return scVar;
    }

    private static SparseArray<WeakReference<Interpolator>> sc() {
        if (pFF == null) {
            pFF = new SparseArray<>();
        }
        return pFF;
    }

    private static Interpolator sc(PointF pointF, PointF pointF2) {
        Interpolator interpolatorSc;
        pointF.x = com.bytedance.adsdk.pFF.TRI.ExN.pFF(pointF.x, -1.0f, 1.0f);
        pointF.y = com.bytedance.adsdk.pFF.TRI.ExN.pFF(pointF.y, -100.0f, 100.0f);
        pointF2.x = com.bytedance.adsdk.pFF.TRI.ExN.pFF(pointF2.x, -1.0f, 1.0f);
        float fPFF = com.bytedance.adsdk.pFF.TRI.ExN.pFF(pointF2.y, -100.0f, 100.0f);
        pointF2.y = fPFF;
        int iSc = com.bytedance.adsdk.pFF.TRI.TRI.sc(pointF.x, pointF.y, pointF2.x, fPFF);
        WeakReference<Interpolator> weakReferenceSc = com.bytedance.adsdk.pFF.ExN.sc() ? null : sc(iSc);
        Interpolator interpolator = weakReferenceSc != null ? weakReferenceSc.get() : null;
        if (weakReferenceSc == null || interpolator == null) {
            try {
                interpolatorSc = com.bytedance.adsdk.pFF.Xc.sc(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e11) {
                interpolatorSc = "The Path cannot loop back on itself.".equals(e11.getMessage()) ? com.bytedance.adsdk.pFF.Xc.sc(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y) : new LinearInterpolator();
            }
            interpolator = interpolatorSc;
            if (!com.bytedance.adsdk.pFF.ExN.sc()) {
                try {
                    sc(iSc, (WeakReference<Interpolator>) new WeakReference(interpolator));
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
            }
        }
        return interpolator;
    }

    private static <T> com.bytedance.adsdk.pFF.qr.sc<T> sc(JsonReader jsonReader, float f11, pc<T> pcVar) throws IOException {
        return new com.bytedance.adsdk.pFF.qr.sc<>(pcVar.pFF(jsonReader, f11));
    }

    public static <T> com.bytedance.adsdk.pFF.qr.sc<T> sc(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr qrVar, float f11, pc<T> pcVar, boolean z11, boolean z12) throws IOException {
        if (z11 && z12) {
            return pFF(qrVar, jsonReader, f11, pcVar);
        }
        return z11 ? sc(qrVar, jsonReader, f11, pcVar) : sc(jsonReader, f11, pcVar);
    }

    private static <T> com.bytedance.adsdk.pFF.qr.sc<T> sc(com.bytedance.adsdk.pFF.qr qrVar, JsonReader jsonReader, float f11, pc<T> pcVar) throws IOException {
        Interpolator interpolatorSc;
        jsonReader.beginObject();
        PointF pointFPFF = null;
        PointF pointFPFF2 = null;
        T tPFF = null;
        T tPFF2 = null;
        PointF pointFPFF3 = null;
        PointF pointFPFF4 = null;
        boolean z11 = false;
        float fNextDouble = 0.0f;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "e":
                    tPFF = pcVar.pFF(jsonReader, f11);
                    break;
                case "h":
                    if (jsonReader.nextInt() != 1) {
                        z11 = false;
                        break;
                    } else {
                        z11 = true;
                        break;
                    }
                    break;
                case "i":
                    pointFPFF2 = Sfl.pFF(jsonReader, 1.0f);
                    break;
                case "o":
                    pointFPFF = Sfl.pFF(jsonReader, 1.0f);
                    break;
                case "s":
                    tPFF2 = pcVar.pFF(jsonReader, f11);
                    break;
                case "t":
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case "ti":
                    pointFPFF4 = Sfl.pFF(jsonReader, f11);
                    break;
                case "to":
                    pointFPFF3 = Sfl.pFF(jsonReader, f11);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (!z11) {
            if (pointFPFF != null && pointFPFF2 != null) {
                interpolatorSc = sc(pointFPFF, pointFPFF2);
            }
            com.bytedance.adsdk.pFF.qr.sc<T> scVar = new com.bytedance.adsdk.pFF.qr.sc<>(qrVar, tPFF2, tPFF, interpolatorSc, fNextDouble, null);
            scVar.Qj = pointFPFF3;
            scVar.Ol = pointFPFF4;
            return scVar;
        }
        tPFF = tPFF2;
        interpolatorSc = f26095sc;
        com.bytedance.adsdk.pFF.qr.sc<T> scVar2 = new com.bytedance.adsdk.pFF.qr.sc<>(qrVar, tPFF2, tPFF, interpolatorSc, fNextDouble, null);
        scVar2.Qj = pointFPFF3;
        scVar2.Ol = pointFPFF4;
        return scVar2;
    }

    private static WeakReference<Interpolator> sc(int i11) {
        WeakReference<Interpolator> weakReference;
        synchronized (YIK.class) {
            weakReference = sc().get(i11);
        }
        return weakReference;
    }

    private static void sc(int i11, WeakReference<Interpolator> weakReference) {
        synchronized (YIK.class) {
            pFF.put(i11, weakReference);
        }
    }
}
