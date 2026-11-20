package com.amazonaws.util.json;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class GsonFactory implements AwsJsonFactory {

    /* JADX INFO: renamed from: com.amazonaws.util.json.GsonFactory$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16292a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f16292a = iArr;
            try {
                iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16292a[JsonToken.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16292a[JsonToken.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16292a[JsonToken.END_OBJECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f16292a[JsonToken.NAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f16292a[JsonToken.BOOLEAN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f16292a[JsonToken.NUMBER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f16292a[JsonToken.NULL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f16292a[JsonToken.STRING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f16292a[JsonToken.END_DOCUMENT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class GsonReader implements AwsJsonReader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final JsonReader f16293a;

        public GsonReader(Reader reader) {
            this.f16293a = new JsonReader(reader);
        }

        @Override // com.amazonaws.util.json.AwsJsonReader
        public void a() throws IOException {
            this.f16293a.beginObject();
        }

        @Override // com.amazonaws.util.json.AwsJsonReader
        public void c() throws IOException {
            this.f16293a.endObject();
        }

        @Override // com.amazonaws.util.json.AwsJsonReader
        public void close() throws IOException {
            this.f16293a.close();
        }

        @Override // com.amazonaws.util.json.AwsJsonReader
        public void d() throws IOException {
            this.f16293a.skipValue();
        }

        @Override // com.amazonaws.util.json.AwsJsonReader
        public boolean e() throws IOException {
            JsonToken jsonTokenPeek = this.f16293a.peek();
            return JsonToken.BEGIN_ARRAY.equals(jsonTokenPeek) || JsonToken.BEGIN_OBJECT.equals(jsonTokenPeek);
        }

        @Override // com.amazonaws.util.json.AwsJsonReader
        public String f() throws IOException {
            return this.f16293a.nextName();
        }

        @Override // com.amazonaws.util.json.AwsJsonReader
        public String g() throws IOException {
            JsonToken jsonTokenPeek = this.f16293a.peek();
            if (JsonToken.NULL.equals(jsonTokenPeek)) {
                this.f16293a.nextNull();
                return null;
            }
            if (JsonToken.BOOLEAN.equals(jsonTokenPeek)) {
                return this.f16293a.nextBoolean() ? "true" : "false";
            }
            return this.f16293a.nextString();
        }

        @Override // com.amazonaws.util.json.AwsJsonReader
        public boolean hasNext() throws IOException {
            return this.f16293a.hasNext();
        }

        @Override // com.amazonaws.util.json.AwsJsonReader
        public AwsJsonToken peek() throws IOException {
            try {
                return GsonFactory.d(this.f16293a.peek());
            } catch (EOFException unused) {
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class GsonWriter implements AwsJsonWriter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final JsonWriter f16294a;

        public GsonWriter(Writer writer) {
            this.f16294a = new JsonWriter(writer);
        }

        @Override // com.amazonaws.util.json.AwsJsonWriter
        public AwsJsonWriter a() throws IOException {
            this.f16294a.beginObject();
            return this;
        }

        @Override // com.amazonaws.util.json.AwsJsonWriter
        public AwsJsonWriter b(String str) throws IOException {
            this.f16294a.name(str);
            return this;
        }

        @Override // com.amazonaws.util.json.AwsJsonWriter
        public AwsJsonWriter c() throws IOException {
            this.f16294a.endObject();
            return this;
        }

        @Override // com.amazonaws.util.json.AwsJsonWriter
        public void close() throws IOException {
            this.f16294a.close();
        }

        @Override // com.amazonaws.util.json.AwsJsonWriter
        public AwsJsonWriter d(String str) throws IOException {
            this.f16294a.value(str);
            return this;
        }
    }

    public static AwsJsonToken d(JsonToken jsonToken) {
        if (jsonToken == null) {
            return null;
        }
        switch (AnonymousClass1.f16292a[jsonToken.ordinal()]) {
            case 1:
                return AwsJsonToken.BEGIN_ARRAY;
            case 2:
                return AwsJsonToken.END_ARRAY;
            case 3:
                return AwsJsonToken.BEGIN_OBJECT;
            case 4:
                return AwsJsonToken.END_OBJECT;
            case 5:
                return AwsJsonToken.FIELD_NAME;
            case 6:
                return AwsJsonToken.VALUE_BOOLEAN;
            case 7:
                return AwsJsonToken.VALUE_NUMBER;
            case 8:
                return AwsJsonToken.VALUE_NULL;
            case 9:
                return AwsJsonToken.VALUE_STRING;
            case 10:
                return null;
            default:
                return AwsJsonToken.UNKNOWN;
        }
    }

    @Override // com.amazonaws.util.json.AwsJsonFactory
    public AwsJsonWriter a(Writer writer) {
        return new GsonWriter(writer);
    }

    @Override // com.amazonaws.util.json.AwsJsonFactory
    public AwsJsonReader b(Reader reader) {
        return new GsonReader(reader);
    }
}
