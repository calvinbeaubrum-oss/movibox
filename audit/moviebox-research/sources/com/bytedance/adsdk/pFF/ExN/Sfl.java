package com.bytedance.adsdk.pFF.ExN;

import android.graphics.Color;
import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.bytedance.component.sdk.annotation.ColorInt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class Sfl {

    /* JADX INFO: renamed from: com.bytedance.adsdk.pFF.ExN.Sfl$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        static final /* synthetic */ int[] f26091sc;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f26091sc = iArr;
            try {
                iArr[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26091sc[JsonToken.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26091sc[JsonToken.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static PointF ExN(JsonReader jsonReader, float f11) throws IOException {
        jsonReader.beginObject();
        float fPFF = 0.0f;
        float fPFF2 = 0.0f;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("x")) {
                fPFF = pFF(jsonReader);
            } else if (strNextName.equals("y")) {
                fPFF2 = pFF(jsonReader);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return new PointF(fPFF * f11, fPFF2 * f11);
    }

    private static PointF We(JsonReader jsonReader, float f11) throws IOException {
        jsonReader.beginArray();
        float fNextDouble = (float) jsonReader.nextDouble();
        float fNextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.peek() != JsonToken.END_ARRAY) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return new PointF(fNextDouble * f11, fNextDouble2 * f11);
    }

    public static float pFF(JsonReader jsonReader) throws IOException {
        JsonToken jsonTokenPeek = jsonReader.peek();
        int i11 = AnonymousClass1.f26091sc[jsonTokenPeek.ordinal()];
        if (i11 == 1) {
            return (float) jsonReader.nextDouble();
        }
        if (i11 != 2) {
            throw new IllegalArgumentException("Unknown value for token of type ".concat(String.valueOf(jsonTokenPeek)));
        }
        jsonReader.beginArray();
        float fNextDouble = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return fNextDouble;
    }

    public static PointF pFF(JsonReader jsonReader, float f11) throws IOException {
        int i11 = AnonymousClass1.f26091sc[jsonReader.peek().ordinal()];
        if (i11 == 1) {
            return zY(jsonReader, f11);
        }
        if (i11 == 2) {
            return We(jsonReader, f11);
        }
        if (i11 == 3) {
            return ExN(jsonReader, f11);
        }
        throw new IllegalArgumentException("Unknown point starts with " + jsonReader.peek());
    }

    @ColorInt
    public static int sc(JsonReader jsonReader) throws IOException {
        jsonReader.beginArray();
        int iNextDouble = (int) (jsonReader.nextDouble() * 255.0d);
        int iNextDouble2 = (int) (jsonReader.nextDouble() * 255.0d);
        int iNextDouble3 = (int) (jsonReader.nextDouble() * 255.0d);
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return Color.argb(255, iNextDouble, iNextDouble2, iNextDouble3);
    }

    public static List<PointF> sc(JsonReader jsonReader, float f11) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            arrayList.add(pFF(jsonReader, f11));
            jsonReader.endArray();
        }
        jsonReader.endArray();
        return arrayList;
    }

    private static PointF zY(JsonReader jsonReader, float f11) throws IOException {
        float fNextDouble = (float) jsonReader.nextDouble();
        float fNextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        return new PointF(fNextDouble * f11, fNextDouble2 * f11);
    }
}
