package com.airbnb.lottie.parser.moshi;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class JsonReader implements Closeable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String[] f15293h = new String[128];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f15294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f15295b = new int[32];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String[] f15296c = new String[32];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f15297d = new int[32];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f15298f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f15299g;

    /* JADX INFO: compiled from: source.java */
    public enum Token {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String[] f15300a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Options f15301b;

        public a(String[] strArr, Options options) {
            this.f15300a = strArr;
            this.f15301b = options;
        }

        public static a a(String... strArr) {
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                Buffer buffer = new Buffer();
                for (int i11 = 0; i11 < strArr.length; i11++) {
                    JsonReader.t(buffer, strArr[i11]);
                    buffer.readByte();
                    byteStringArr[i11] = buffer.readByteString();
                }
                return new a((String[]) strArr.clone(), Options.of(byteStringArr));
            } catch (IOException e11) {
                throw new AssertionError(e11);
            }
        }
    }

    static {
        for (int i11 = 0; i11 <= 31; i11++) {
            f15293h[i11] = String.format("\\u%04x", Integer.valueOf(i11));
        }
        String[] strArr = f15293h;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    public static JsonReader m(BufferedSource bufferedSource) {
        return new b(bufferedSource);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x002b  */
    public static void t(BufferedSink bufferedSink, String str) throws IOException {
        String str2;
        String[] strArr = f15293h;
        bufferedSink.writeByte(34);
        int length = str.length();
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            char cCharAt = str.charAt(i12);
            if (cCharAt < 128) {
                str2 = strArr[cCharAt];
                if (str2 != null) {
                    if (i11 < i12) {
                        bufferedSink.writeUtf8(str, i11, i12);
                    }
                    bufferedSink.writeUtf8(str2);
                    i11 = i12 + 1;
                }
            } else {
                if (cCharAt == 8232) {
                    str2 = "\\u2028";
                } else if (cCharAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i11 < i12) {
                    bufferedSink.writeUtf8(str, i11, i12);
                }
                bufferedSink.writeUtf8(str2);
                i11 = i12 + 1;
            }
        }
        if (i11 < length) {
            bufferedSink.writeUtf8(str, i11, length);
        }
        bufferedSink.writeByte(34);
    }

    public abstract void b() throws IOException;

    public abstract void c() throws IOException;

    public abstract void d() throws IOException;

    public abstract void e() throws IOException;

    public abstract boolean g() throws IOException;

    public final String getPath() {
        return com.airbnb.lottie.parser.moshi.a.a(this.f15294a, this.f15295b, this.f15296c, this.f15297d);
    }

    public abstract boolean h() throws IOException;

    public abstract double i() throws IOException;

    public abstract int j() throws IOException;

    public abstract String k() throws IOException;

    public abstract String l() throws IOException;

    public abstract Token n() throws IOException;

    public final void o(int i11) {
        int i12 = this.f15294a;
        int[] iArr = this.f15295b;
        if (i12 == iArr.length) {
            if (i12 == 256) {
                throw new JsonDataException("Nesting too deep at " + getPath());
            }
            this.f15295b = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.f15296c;
            this.f15296c = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
            int[] iArr2 = this.f15297d;
            this.f15297d = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.f15295b;
        int i13 = this.f15294a;
        this.f15294a = i13 + 1;
        iArr3[i13] = i11;
    }

    public abstract int p(a aVar) throws IOException;

    public abstract void q() throws IOException;

    public abstract void r() throws IOException;

    public final JsonEncodingException u(String str) throws JsonEncodingException {
        throw new JsonEncodingException(str + " at path " + getPath());
    }
}
