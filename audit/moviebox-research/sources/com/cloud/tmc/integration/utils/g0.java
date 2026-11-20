package com.cloud.tmc.integration.utils;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class g0 extends TypeAdapter<Object> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Gson f31058b = new Gson();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TypeAdapter f31059a = f31058b.getAdapter(Object.class);

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f31060a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f31060a = iArr;
            try {
                iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31060a[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31060a[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f31060a[JsonToken.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f31060a[JsonToken.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f31060a[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: read */
    public Object read2(JsonReader jsonReader) throws IOException {
        switch (a.f31060a[jsonReader.peek().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    arrayList.add(read2(jsonReader));
                }
                jsonReader.endArray();
                return arrayList;
            case 2:
                LinkedTreeMap linkedTreeMap = new LinkedTreeMap();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    linkedTreeMap.put(jsonReader.nextName(), read2(jsonReader));
                }
                jsonReader.endObject();
                return linkedTreeMap;
            case 3:
                return jsonReader.nextString();
            case 4:
                String strNextString = jsonReader.nextString();
                if (strNextString.contains(InstructionFileId.DOT)) {
                    Double dValueOf = Double.valueOf(Double.parseDouble(strNextString));
                    return (dValueOf.doubleValue() > 3.4028234663852886E38d || dValueOf.doubleValue() < 1.401298464324817E-45d) ? Double.valueOf(Double.parseDouble(strNextString)) : Float.valueOf(Float.parseFloat(strNextString));
                }
                Long lValueOf = Long.valueOf(Long.parseLong(strNextString));
                if (lValueOf.longValue() > 2147483647L || lValueOf.longValue() < -2147483648L) {
                    return Long.valueOf(Long.parseLong(strNextString));
                }
                return (lValueOf.longValue() > 32767 || lValueOf.longValue() < -32768) ? Integer.valueOf(Integer.parseInt(strNextString)) : Short.valueOf(Short.parseShort(strNextString));
            case 5:
                return Boolean.valueOf(jsonReader.nextBoolean());
            case 6:
                jsonReader.nextNull();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Object obj) throws IOException {
        this.f31059a.write(jsonWriter, obj);
    }
}
