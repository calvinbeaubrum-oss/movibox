package com.bykv.vk.openvk.preload.a.d;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements Closeable, Flushable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f25609a = new String[128];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f25610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Writer f25611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int[] f25612d = new int[32];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f25613e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f25614f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f25615g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f25616h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f25617i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f25618j;

    static {
        for (int i11 = 0; i11 <= 31; i11++) {
            f25609a[i11] = String.format("\\u%04x", Integer.valueOf(i11));
        }
        String[] strArr = f25609a;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f25610b = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        a(6);
        this.f25614f = ":";
        this.f25618j = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.f25611c = writer;
    }

    private c a(int i11, char c11) throws IOException {
        l();
        a(i11);
        this.f25611c.write(c11);
        return this;
    }

    private c a(int i11, int i12, char c11) throws IOException {
        int i13 = i();
        if (i13 != i12 && i13 != i11) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f25617i == null) {
            this.f25613e--;
            this.f25611c.write(c11);
            return this;
        }
        throw new IllegalStateException("Dangling name: " + this.f25617i);
    }

    private void a(int i11) {
        int i12 = this.f25613e;
        int[] iArr = this.f25612d;
        if (i12 == iArr.length) {
            this.f25612d = Arrays.copyOf(iArr, i12 << 1);
        }
        int[] iArr2 = this.f25612d;
        int i13 = this.f25613e;
        this.f25613e = i13 + 1;
        iArr2[i13] = i11;
    }

    private void b(int i11) {
        this.f25612d[this.f25613e - 1] = i11;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0034  */
    private void c(String str) throws IOException {
        String str2;
        String[] strArr = this.f25616h ? f25610b : f25609a;
        this.f25611c.write(34);
        int length = str.length();
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            char cCharAt = str.charAt(i12);
            if (cCharAt < 128) {
                str2 = strArr[cCharAt];
                if (str2 != null) {
                    if (i11 < i12) {
                        this.f25611c.write(str, i11, i12 - i11);
                    }
                    this.f25611c.write(str2);
                    i11 = i12 + 1;
                }
            } else {
                if (cCharAt == 8232) {
                    str2 = "\\u2028";
                } else if (cCharAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i11 < i12) {
                    this.f25611c.write(str, i11, i12 - i11);
                }
                this.f25611c.write(str2);
                i11 = i12 + 1;
            }
        }
        if (i11 < length) {
            this.f25611c.write(str, i11, length - i11);
        }
        this.f25611c.write(34);
    }

    private int i() {
        int i11 = this.f25613e;
        if (i11 != 0) {
            return this.f25612d[i11 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void j() throws IOException {
        if (this.f25617i != null) {
            k();
            c(this.f25617i);
            this.f25617i = null;
        }
    }

    private void k() throws IOException {
        int i11 = i();
        if (i11 == 5) {
            this.f25611c.write(44);
        } else if (i11 != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        b(4);
    }

    private void l() throws IOException {
        int i11 = i();
        if (i11 == 1) {
            b(2);
            return;
        }
        if (i11 == 2) {
            this.f25611c.append(',');
            return;
        }
        if (i11 == 4) {
            this.f25611c.append((CharSequence) this.f25614f);
            b(5);
            return;
        }
        if (i11 != 6) {
            if (i11 != 7) {
                throw new IllegalStateException("Nesting problem.");
            }
            if (!this.f25615g) {
                throw new IllegalStateException("JSON must have only one top-level value.");
            }
        }
        b(7);
    }

    public final c a(long j11) throws IOException {
        j();
        l();
        this.f25611c.write(Long.toString(j11));
        return this;
    }

    public final c a(Boolean bool) throws IOException {
        if (bool == null) {
            return h();
        }
        j();
        l();
        this.f25611c.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public final c a(Number number) throws IOException {
        if (number == null) {
            return h();
        }
        j();
        String string = number.toString();
        if (!this.f25615g && (string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was ".concat(String.valueOf(number)));
        }
        l();
        this.f25611c.append((CharSequence) string);
        return this;
    }

    public final c a(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.f25617i != null) {
            throw new IllegalStateException();
        }
        if (this.f25613e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f25617i = str;
        return this;
    }

    public final void a(boolean z11) {
        this.f25615g = z11;
    }

    public final boolean a() {
        return this.f25615g;
    }

    public final c b(String str) throws IOException {
        if (str == null) {
            return h();
        }
        j();
        l();
        c(str);
        return this;
    }

    public final void b(boolean z11) {
        this.f25616h = z11;
    }

    public final boolean b() {
        return this.f25616h;
    }

    public final void c(boolean z11) {
        this.f25618j = z11;
    }

    public final boolean c() {
        return this.f25618j;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f25611c.close();
        int i11 = this.f25613e;
        if (i11 > 1 || (i11 == 1 && this.f25612d[i11 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f25613e = 0;
    }

    public final c d() throws IOException {
        j();
        return a(1, '[');
    }

    public final c d(boolean z11) throws IOException {
        j();
        l();
        this.f25611c.write(z11 ? "true" : "false");
        return this;
    }

    public final c e() throws IOException {
        return a(1, 2, ']');
    }

    public final c f() throws IOException {
        j();
        return a(3, '{');
    }

    @Override // java.io.Flushable
    public final void flush() throws IOException {
        if (this.f25613e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f25611c.flush();
    }

    public final c g() throws IOException {
        return a(3, 5, '}');
    }

    public final c h() throws IOException {
        if (this.f25617i != null) {
            if (!this.f25618j) {
                this.f25617i = null;
                return this;
            }
            j();
        }
        l();
        this.f25611c.write("null");
        return this;
    }
}
