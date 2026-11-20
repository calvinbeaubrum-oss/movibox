package com.bykv.vk.openvk.preload.a.d;

import com.bykv.vk.openvk.preload.a.b.e;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import okio.internal.BufferKt;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class a implements Closeable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Reader f25584b;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f25591i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f25592j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f25593k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int[] f25594l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String[] f25596n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int[] f25597o;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f25585c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final char[] f25586d = new char[1024];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f25587e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f25588f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f25589g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f25590h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f25583a = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f25595m = 1;

    static {
        e.f25521a = new e() { // from class: com.bykv.vk.openvk.preload.a.d.a.1
            @Override // com.bykv.vk.openvk.preload.a.b.e
            public final void a(a aVar) throws IOException {
                if (aVar instanceof com.bykv.vk.openvk.preload.a.b.a.e) {
                    ((com.bykv.vk.openvk.preload.a.b.a.e) aVar).o();
                    return;
                }
                int iR = aVar.f25583a;
                if (iR == 0) {
                    iR = aVar.r();
                }
                if (iR == 13) {
                    aVar.f25583a = 9;
                    return;
                }
                if (iR == 12) {
                    aVar.f25583a = 8;
                } else {
                    if (iR == 14) {
                        aVar.f25583a = 10;
                        return;
                    }
                    throw new IllegalStateException("Expected a name but was " + aVar.f() + aVar.s());
                }
            }
        };
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.f25594l = iArr;
        iArr[0] = 6;
        this.f25596n = new String[32];
        this.f25597o = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.f25584b = reader;
    }

    private void a(int i11) {
        int i12 = this.f25595m;
        int[] iArr = this.f25594l;
        if (i12 == iArr.length) {
            int i13 = i12 << 1;
            this.f25594l = Arrays.copyOf(iArr, i13);
            this.f25597o = Arrays.copyOf(this.f25597o, i13);
            this.f25596n = (String[]) Arrays.copyOf(this.f25596n, i13);
        }
        int[] iArr2 = this.f25594l;
        int i14 = this.f25595m;
        this.f25595m = i14 + 1;
        iArr2[i14] = i11;
    }

    private boolean a(char c11) throws IOException {
        if (c11 == '\t' || c11 == '\n' || c11 == '\f' || c11 == '\r' || c11 == ' ') {
            return false;
        }
        if (c11 != '#') {
            if (c11 == ',') {
                return false;
            }
            if (c11 != '/' && c11 != '=') {
                if (c11 == '{' || c11 == '}' || c11 == ':') {
                    return false;
                }
                if (c11 != ';') {
                    switch (c11) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        v();
        return false;
    }

    private boolean a(String str) throws IOException {
        int length = str.length();
        while (true) {
            if (this.f25587e + length > this.f25588f && !b(length)) {
                return false;
            }
            char[] cArr = this.f25586d;
            int i11 = this.f25587e;
            if (cArr[i11] != '\n') {
                for (int i12 = 0; i12 < length; i12++) {
                    if (this.f25586d[this.f25587e + i12] == str.charAt(i12)) {
                    }
                }
                return true;
            }
            this.f25589g++;
            this.f25590h = i11 + 1;
            this.f25587e++;
        }
    }

    private int b(boolean z11) throws IOException {
        char[] cArr = this.f25586d;
        int i11 = this.f25587e;
        int i12 = this.f25588f;
        while (true) {
            if (i11 == i12) {
                this.f25587e = i11;
                if (!b(1)) {
                    if (!z11) {
                        return -1;
                    }
                    throw new EOFException("End of input" + s());
                }
                i11 = this.f25587e;
                i12 = this.f25588f;
            }
            int i13 = i11 + 1;
            char c11 = cArr[i11];
            if (c11 == '\n') {
                this.f25589g++;
                this.f25590h = i13;
            } else if (c11 != ' ' && c11 != '\r' && c11 != '\t') {
                if (c11 == '/') {
                    this.f25587e = i13;
                    if (i13 == i12) {
                        this.f25587e = i11;
                        boolean zB = b(2);
                        this.f25587e++;
                        if (!zB) {
                            return c11;
                        }
                    }
                    v();
                    int i14 = this.f25587e;
                    char c12 = cArr[i14];
                    if (c12 == '*') {
                        this.f25587e = i14 + 1;
                        if (!a("*/")) {
                            throw b("Unterminated comment");
                        }
                        i11 = this.f25587e + 2;
                        i12 = this.f25588f;
                    } else {
                        if (c12 != '/') {
                            return c11;
                        }
                        this.f25587e = i14 + 1;
                        w();
                        i11 = this.f25587e;
                        i12 = this.f25588f;
                    }
                } else {
                    if (c11 != '#') {
                        this.f25587e = i13;
                        return c11;
                    }
                    this.f25587e = i13;
                    v();
                    w();
                    i11 = this.f25587e;
                    i12 = this.f25588f;
                }
            }
            i11 = i13;
        }
    }

    private IOException b(String str) throws IOException {
        throw new d(str + s());
    }

    private String b(char c11) throws IOException {
        char[] cArr = this.f25586d;
        StringBuilder sb2 = null;
        while (true) {
            int i11 = this.f25587e;
            int i12 = this.f25588f;
            int i13 = i11;
            while (true) {
                if (i13 >= i12) {
                    if (sb2 == null) {
                        sb2 = new StringBuilder(Math.max((i13 - i11) << 1, 16));
                    }
                    sb2.append(cArr, i11, i13 - i11);
                    this.f25587e = i13;
                    if (b(1)) {
                        break;
                    }
                    throw b("Unterminated string");
                }
                int i14 = i13 + 1;
                char c12 = cArr[i13];
                if (c12 == c11) {
                    this.f25587e = i14;
                    int i15 = (i14 - i11) - 1;
                    if (sb2 == null) {
                        return new String(cArr, i11, i15);
                    }
                    sb2.append(cArr, i11, i15);
                    return sb2.toString();
                }
                if (c12 == '\\') {
                    this.f25587e = i14;
                    int i16 = i14 - i11;
                    int i17 = i16 - 1;
                    if (sb2 == null) {
                        sb2 = new StringBuilder(Math.max(i16 << 1, 16));
                    }
                    sb2.append(cArr, i11, i17);
                    sb2.append(x());
                    break;
                }
                if (c12 == '\n') {
                    this.f25589g++;
                    this.f25590h = i14;
                }
                i13 = i14;
            }
        }
    }

    private boolean b(int i11) throws IOException {
        int i12;
        int i13;
        char[] cArr = this.f25586d;
        int i14 = this.f25590h;
        int i15 = this.f25587e;
        this.f25590h = i14 - i15;
        int i16 = this.f25588f;
        if (i16 != i15) {
            int i17 = i16 - i15;
            this.f25588f = i17;
            System.arraycopy(cArr, i15, cArr, 0, i17);
        } else {
            this.f25588f = 0;
        }
        this.f25587e = 0;
        do {
            Reader reader = this.f25584b;
            int i18 = this.f25588f;
            int i19 = reader.read(cArr, i18, 1024 - i18);
            if (i19 == -1) {
                return false;
            }
            i12 = this.f25588f + i19;
            this.f25588f = i12;
            if (this.f25589g == 0 && (i13 = this.f25590h) == 0 && i12 > 0 && cArr[0] == 65279) {
                this.f25587e++;
                this.f25590h = i13 + 1;
                i11++;
            }
        } while (i12 < i11);
        return true;
    }

    private void c(char c11) throws IOException {
        char[] cArr = this.f25586d;
        while (true) {
            int i11 = this.f25587e;
            int i12 = this.f25588f;
            while (true) {
                if (i11 >= i12) {
                    this.f25587e = i11;
                    if (!b(1)) {
                        throw b("Unterminated string");
                    }
                    break;
                }
                int i13 = i11 + 1;
                char c12 = cArr[i11];
                if (c12 == c11) {
                    this.f25587e = i13;
                    return;
                }
                if (c12 == '\\') {
                    this.f25587e = i13;
                    x();
                    break;
                } else {
                    if (c12 == '\n') {
                        this.f25589g++;
                        this.f25590h = i13;
                    }
                    i11 = i13;
                }
            }
        }
    }

    private int o() throws IOException {
        String str;
        String str2;
        int i11;
        char c11 = this.f25586d[this.f25587e];
        if (c11 == 't' || c11 == 'T') {
            str = "true";
            str2 = "TRUE";
            i11 = 5;
        } else if (c11 == 'f' || c11 == 'F') {
            str = "false";
            str2 = "FALSE";
            i11 = 6;
        } else {
            if (c11 != 'n' && c11 != 'N') {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i11 = 7;
        }
        int length = str.length();
        for (int i12 = 1; i12 < length; i12++) {
            if (this.f25587e + i12 >= this.f25588f && !b(i12 + 1)) {
                return 0;
            }
            char c12 = this.f25586d[this.f25587e + i12];
            if (c12 != str.charAt(i12) && c12 != str2.charAt(i12)) {
                return 0;
            }
        }
        if ((this.f25587e + length < this.f25588f || b(length + 1)) && a(this.f25586d[this.f25587e + length])) {
            return 0;
        }
        this.f25587e += length;
        this.f25583a = i11;
        return i11;
    }

    /* JADX WARN: Code duplicated, block: B:109:0x00f9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:13:0x002f  */
    /* JADX WARN: Code duplicated, block: B:89:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:91:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:96:0x00ee  */
    private int t() throws IOException {
        char c11;
        char[] cArr = this.f25586d;
        int i11 = this.f25587e;
        int i12 = this.f25588f;
        int i13 = 0;
        int i14 = 0;
        char c12 = 0;
        boolean z11 = true;
        long j11 = 0;
        boolean z12 = false;
        while (true) {
            if (i11 + i14 == i12) {
                if (i14 != 1024) {
                    if (!b(i14 + 1)) {
                        break;
                    }
                    i11 = this.f25587e;
                    i12 = this.f25588f;
                    c11 = cArr[i11 + i14];
                    if (c11 != '+') {
                        if (c11 != 'E') {
                            i13 = 0;
                            if (c12 == 2) {
                            }
                            c12 = 5;
                        } else {
                            i13 = 0;
                            if (c12 == 2) {
                            }
                            c12 = 5;
                        }
                        i14++;
                    } else {
                        i13 = 0;
                        if (c12 != 5) {
                            return 0;
                        }
                    }
                    c12 = 6;
                    i14++;
                } else {
                    return i13;
                }
            } else {
                c11 = cArr[i11 + i14];
                if (c11 != '+') {
                    if (c11 != 'E' || c11 == 'e') {
                        i13 = 0;
                        if (c12 == 2 && c12 != 4) {
                            return 0;
                        }
                        c12 = 5;
                    } else if (c11 == '-') {
                        i13 = 0;
                        if (c12 == 0) {
                            c12 = 1;
                            z12 = true;
                        } else if (c12 != 5) {
                            return 0;
                        }
                    } else if (c11 == '.') {
                        i13 = 0;
                        if (c12 != 2) {
                            return 0;
                        }
                        c12 = 3;
                    } else {
                        if (c11 < '0' || c11 > '9') {
                            if (!a(c11)) {
                                break;
                            }
                            return 0;
                        }
                        if (c12 == 1 || c12 == 0) {
                            j11 = -(c11 - '0');
                            i13 = 0;
                            c12 = 2;
                        } else {
                            if (c12 == 2) {
                                if (j11 == 0) {
                                    return 0;
                                }
                                long j12 = (10 * j11) - ((long) (c11 - '0'));
                                z11 &= j11 > BufferKt.OVERFLOW_ZONE || (j11 == BufferKt.OVERFLOW_ZONE && j12 < j11);
                                j11 = j12;
                            } else if (c12 == 3) {
                                i13 = 0;
                                c12 = 4;
                            } else if (c12 == 5 || c12 == 6) {
                                i13 = 0;
                                c12 = 7;
                            }
                            i13 = 0;
                        }
                    }
                    i14++;
                } else {
                    i13 = 0;
                    if (c12 != 5) {
                        return 0;
                    }
                }
                c12 = 6;
                i14++;
            }
        }
        if (c12 == 2 && z11 && ((j11 != Long.MIN_VALUE || z12) && (j11 != 0 || !z12))) {
            if (!z12) {
                j11 = -j11;
            }
            this.f25591i = j11;
            this.f25587e += i14;
            this.f25583a = 15;
            return 15;
        }
        if (c12 != 2 && c12 != 4 && c12 != 7) {
            return 0;
        }
        this.f25592j = i14;
        this.f25583a = 16;
        return 16;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0044. Please report as an issue. */
    private String u() throws IOException {
        String string;
        StringBuilder sb2 = null;
        int i11 = 0;
        while (true) {
            int i12 = 0;
            while (true) {
                int i13 = this.f25587e;
                if (i13 + i12 < this.f25588f) {
                    char c11 = this.f25586d[i13 + i12];
                    if (c11 != '\t' && c11 != '\n' && c11 != '\f' && c11 != '\r' && c11 != ' ') {
                        if (c11 != '#') {
                            if (c11 != ',') {
                                if (c11 != '/' && c11 != '=') {
                                    if (c11 != '{' && c11 != '}' && c11 != ':') {
                                        if (c11 != ';') {
                                            switch (c11) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i12++;
                                                    break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        v();
                    }
                    i11 = i12;
                } else if (i12 >= 1024) {
                    if (sb2 == null) {
                        sb2 = new StringBuilder(Math.max(i12, 16));
                    }
                    sb2.append(this.f25586d, this.f25587e, i12);
                    this.f25587e += i12;
                    if (!b(1)) {
                    }
                } else if (!b(i12 + 1)) {
                    i11 = i12;
                }
                if (sb2 == null) {
                    string = new String(this.f25586d, this.f25587e, i11);
                } else {
                    sb2.append(this.f25586d, this.f25587e, i11);
                    string = sb2.toString();
                }
                this.f25587e += i11;
                return string;
            }
        }
    }

    private void v() throws IOException {
        if (!this.f25585c) {
            throw b("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void w() throws IOException {
        char c11;
        do {
            if (this.f25587e >= this.f25588f && !b(1)) {
                return;
            }
            char[] cArr = this.f25586d;
            int i11 = this.f25587e;
            int i12 = i11 + 1;
            this.f25587e = i12;
            c11 = cArr[i11];
            if (c11 == '\n') {
                this.f25589g++;
                this.f25590h = i12;
                return;
            }
        } while (c11 != '\r');
    }

    private char x() throws IOException {
        int i11;
        if (this.f25587e == this.f25588f && !b(1)) {
            throw b("Unterminated escape sequence");
        }
        char[] cArr = this.f25586d;
        int i12 = this.f25587e;
        int i13 = i12 + 1;
        this.f25587e = i13;
        char c11 = cArr[i12];
        if (c11 == '\n') {
            this.f25589g++;
            this.f25590h = i13;
        } else if (c11 != '\"' && c11 != '\'' && c11 != '/' && c11 != '\\') {
            if (c11 == 'b') {
                return '\b';
            }
            if (c11 == 'f') {
                return '\f';
            }
            if (c11 == 'n') {
                return '\n';
            }
            if (c11 == 'r') {
                return '\r';
            }
            if (c11 == 't') {
                return '\t';
            }
            if (c11 != 'u') {
                throw b("Invalid escape sequence");
            }
            if (i12 + 5 > this.f25588f && !b(4)) {
                throw b("Unterminated escape sequence");
            }
            int i14 = this.f25587e;
            int i15 = i14 + 4;
            char c12 = 0;
            while (i14 < i15) {
                char c13 = this.f25586d[i14];
                char c14 = (char) (c12 << 4);
                if (c13 >= '0' && c13 <= '9') {
                    i11 = c13 - '0';
                } else if (c13 >= 'a' && c13 <= 'f') {
                    i11 = c13 - 'W';
                } else {
                    if (c13 < 'A' || c13 > 'F') {
                        throw new NumberFormatException("\\u" + new String(this.f25586d, this.f25587e, 4));
                    }
                    i11 = c13 - '7';
                }
                c12 = (char) (c14 + i11);
                i14++;
            }
            this.f25587e += 4;
            return c12;
        }
        return c11;
    }

    private void y() throws IOException {
        b(true);
        int i11 = this.f25587e;
        int i12 = i11 - 1;
        this.f25587e = i12;
        if (i11 + 4 <= this.f25588f || b(5)) {
            char[] cArr = this.f25586d;
            if (cArr[i12] == ')' && cArr[i11] == ']' && cArr[i11 + 1] == '}' && cArr[i11 + 2] == '\'' && cArr[i11 + 3] == '\n') {
                this.f25587e += 5;
            }
        }
    }

    public void a() throws IOException {
        int iR = this.f25583a;
        if (iR == 0) {
            iR = r();
        }
        if (iR == 3) {
            a(1);
            this.f25597o[this.f25595m - 1] = 0;
            this.f25583a = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + f() + s());
        }
    }

    public final void a(boolean z11) {
        this.f25585c = z11;
    }

    public void b() throws IOException {
        int iR = this.f25583a;
        if (iR == 0) {
            iR = r();
        }
        if (iR != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + f() + s());
        }
        int i11 = this.f25595m;
        this.f25595m = i11 - 1;
        int[] iArr = this.f25597o;
        int i12 = i11 - 2;
        iArr[i12] = iArr[i12] + 1;
        this.f25583a = 0;
    }

    public void c() throws IOException {
        int iR = this.f25583a;
        if (iR == 0) {
            iR = r();
        }
        if (iR == 1) {
            a(3);
            this.f25583a = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + f() + s());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f25583a = 0;
        this.f25594l[0] = 8;
        this.f25595m = 1;
        this.f25584b.close();
    }

    public void d() throws IOException {
        int iR = this.f25583a;
        if (iR == 0) {
            iR = r();
        }
        if (iR != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + f() + s());
        }
        int i11 = this.f25595m;
        int i12 = i11 - 1;
        this.f25595m = i12;
        this.f25596n[i12] = null;
        int[] iArr = this.f25597o;
        int i13 = i11 - 2;
        iArr[i13] = iArr[i13] + 1;
        this.f25583a = 0;
    }

    public boolean e() throws IOException {
        int iR = this.f25583a;
        if (iR == 0) {
            iR = r();
        }
        return (iR == 2 || iR == 4) ? false : true;
    }

    public b f() throws IOException {
        int iR = this.f25583a;
        if (iR == 0) {
            iR = r();
        }
        switch (iR) {
            case 1:
                return b.BEGIN_OBJECT;
            case 2:
                return b.END_OBJECT;
            case 3:
                return b.BEGIN_ARRAY;
            case 4:
                return b.END_ARRAY;
            case 5:
            case 6:
                return b.BOOLEAN;
            case 7:
                return b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return b.STRING;
            case 12:
            case 13:
            case 14:
                return b.NAME;
            case 15:
            case 16:
                return b.NUMBER;
            case 17:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public String g() throws IOException {
        String strB;
        int iR = this.f25583a;
        if (iR == 0) {
            iR = r();
        }
        if (iR == 14) {
            strB = u();
        } else if (iR == 12) {
            strB = b('\'');
        } else {
            if (iR != 13) {
                throw new IllegalStateException("Expected a name but was " + f() + s());
            }
            strB = b('\"');
        }
        this.f25583a = 0;
        this.f25596n[this.f25595m - 1] = strB;
        return strB;
    }

    public String h() throws IOException {
        String str;
        int iR = this.f25583a;
        if (iR == 0) {
            iR = r();
        }
        if (iR == 10) {
            str = u();
        } else if (iR == 8) {
            str = b('\'');
        } else if (iR == 9) {
            str = b('\"');
        } else if (iR == 11) {
            str = this.f25593k;
            this.f25593k = null;
        } else if (iR == 15) {
            str = Long.toString(this.f25591i);
        } else {
            if (iR != 16) {
                throw new IllegalStateException("Expected a string but was " + f() + s());
            }
            str = new String(this.f25586d, this.f25587e, this.f25592j);
            this.f25587e += this.f25592j;
        }
        this.f25583a = 0;
        int[] iArr = this.f25597o;
        int i11 = this.f25595m - 1;
        iArr[i11] = iArr[i11] + 1;
        return str;
    }

    public boolean i() throws IOException {
        int iR = this.f25583a;
        if (iR == 0) {
            iR = r();
        }
        if (iR == 5) {
            this.f25583a = 0;
            int[] iArr = this.f25597o;
            int i11 = this.f25595m - 1;
            iArr[i11] = iArr[i11] + 1;
            return true;
        }
        if (iR != 6) {
            throw new IllegalStateException("Expected a boolean but was " + f() + s());
        }
        this.f25583a = 0;
        int[] iArr2 = this.f25597o;
        int i12 = this.f25595m - 1;
        iArr2[i12] = iArr2[i12] + 1;
        return false;
    }

    public void j() throws IOException {
        int iR = this.f25583a;
        if (iR == 0) {
            iR = r();
        }
        if (iR != 7) {
            throw new IllegalStateException("Expected null but was " + f() + s());
        }
        this.f25583a = 0;
        int[] iArr = this.f25597o;
        int i11 = this.f25595m - 1;
        iArr[i11] = iArr[i11] + 1;
    }

    public double k() throws IOException {
        int iR = this.f25583a;
        if (iR == 0) {
            iR = r();
        }
        if (iR == 15) {
            this.f25583a = 0;
            int[] iArr = this.f25597o;
            int i11 = this.f25595m - 1;
            iArr[i11] = iArr[i11] + 1;
            return this.f25591i;
        }
        if (iR == 16) {
            this.f25593k = new String(this.f25586d, this.f25587e, this.f25592j);
            this.f25587e += this.f25592j;
        } else if (iR == 8 || iR == 9) {
            this.f25593k = b(iR == 8 ? '\'' : '\"');
        } else if (iR == 10) {
            this.f25593k = u();
        } else if (iR != 11) {
            throw new IllegalStateException("Expected a double but was " + f() + s());
        }
        this.f25583a = 11;
        double d11 = Double.parseDouble(this.f25593k);
        if (!this.f25585c && (Double.isNaN(d11) || Double.isInfinite(d11))) {
            throw new d("JSON forbids NaN and infinities: " + d11 + s());
        }
        this.f25593k = null;
        this.f25583a = 0;
        int[] iArr2 = this.f25597o;
        int i12 = this.f25595m - 1;
        iArr2[i12] = iArr2[i12] + 1;
        return d11;
    }

    public long l() throws IOException {
        int iR = this.f25583a;
        if (iR == 0) {
            iR = r();
        }
        if (iR == 15) {
            this.f25583a = 0;
            int[] iArr = this.f25597o;
            int i11 = this.f25595m - 1;
            iArr[i11] = iArr[i11] + 1;
            return this.f25591i;
        }
        if (iR == 16) {
            this.f25593k = new String(this.f25586d, this.f25587e, this.f25592j);
            this.f25587e += this.f25592j;
        } else {
            if (iR != 8 && iR != 9 && iR != 10) {
                throw new IllegalStateException("Expected a long but was " + f() + s());
            }
            if (iR == 10) {
                this.f25593k = u();
            } else {
                this.f25593k = b(iR == 8 ? '\'' : '\"');
            }
            try {
                long j11 = Long.parseLong(this.f25593k);
                this.f25583a = 0;
                int[] iArr2 = this.f25597o;
                int i12 = this.f25595m - 1;
                iArr2[i12] = iArr2[i12] + 1;
                return j11;
            } catch (NumberFormatException unused) {
            }
        }
        this.f25583a = 11;
        double d11 = Double.parseDouble(this.f25593k);
        long j12 = (long) d11;
        if (j12 != d11) {
            throw new NumberFormatException("Expected a long but was " + this.f25593k + s());
        }
        this.f25593k = null;
        this.f25583a = 0;
        int[] iArr3 = this.f25597o;
        int i13 = this.f25595m - 1;
        iArr3[i13] = iArr3[i13] + 1;
        return j12;
    }

    public int m() throws IOException {
        int iR = this.f25583a;
        if (iR == 0) {
            iR = r();
        }
        if (iR == 15) {
            long j11 = this.f25591i;
            int i11 = (int) j11;
            if (j11 != i11) {
                throw new NumberFormatException("Expected an int but was " + this.f25591i + s());
            }
            this.f25583a = 0;
            int[] iArr = this.f25597o;
            int i12 = this.f25595m - 1;
            iArr[i12] = iArr[i12] + 1;
            return i11;
        }
        if (iR == 16) {
            this.f25593k = new String(this.f25586d, this.f25587e, this.f25592j);
            this.f25587e += this.f25592j;
        } else {
            if (iR != 8 && iR != 9 && iR != 10) {
                throw new IllegalStateException("Expected an int but was " + f() + s());
            }
            if (iR == 10) {
                this.f25593k = u();
            } else {
                this.f25593k = b(iR == 8 ? '\'' : '\"');
            }
            try {
                int i13 = Integer.parseInt(this.f25593k);
                this.f25583a = 0;
                int[] iArr2 = this.f25597o;
                int i14 = this.f25595m - 1;
                iArr2[i14] = iArr2[i14] + 1;
                return i13;
            } catch (NumberFormatException unused) {
            }
        }
        this.f25583a = 11;
        double d11 = Double.parseDouble(this.f25593k);
        int i15 = (int) d11;
        if (i15 != d11) {
            throw new NumberFormatException("Expected an int but was " + this.f25593k + s());
        }
        this.f25593k = null;
        this.f25583a = 0;
        int[] iArr3 = this.f25597o;
        int i16 = this.f25595m - 1;
        iArr3[i16] = iArr3[i16] + 1;
        return i15;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:61:0x009d. Please report as an issue. */
    public void n() throws IOException {
        int i11 = 0;
        do {
            int iR = this.f25583a;
            if (iR == 0) {
                iR = r();
            }
            if (iR == 3) {
                a(1);
            } else {
                if (iR == 1) {
                    a(3);
                } else if (iR == 4 || iR == 2) {
                    this.f25595m--;
                    i11--;
                } else if (iR == 14 || iR == 10) {
                    while (true) {
                        int i12 = 0;
                        while (true) {
                            int i13 = this.f25587e;
                            if (i13 + i12 < this.f25588f) {
                                char c11 = this.f25586d[i13 + i12];
                                if (c11 != '\t' && c11 != '\n' && c11 != '\f' && c11 != '\r' && c11 != ' ') {
                                    if (c11 != '#') {
                                        if (c11 != ',') {
                                            if (c11 != '/' && c11 != '=') {
                                                if (c11 != '{' && c11 != '}' && c11 != ':') {
                                                    if (c11 != ';') {
                                                        switch (c11) {
                                                            case '[':
                                                            case ']':
                                                                break;
                                                            case '\\':
                                                                break;
                                                            default:
                                                                i12++;
                                                                break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    v();
                                }
                                this.f25587e += i12;
                            } else {
                                this.f25587e = i13 + i12;
                                if (!b(1)) {
                                }
                            }
                        }
                    }
                } else if (iR == 8 || iR == 12) {
                    c('\'');
                } else if (iR == 9 || iR == 13) {
                    c('\"');
                } else if (iR == 16) {
                    this.f25587e += this.f25592j;
                }
                this.f25583a = 0;
            }
            i11++;
            this.f25583a = 0;
        } while (i11 != 0);
        int[] iArr = this.f25597o;
        int i14 = this.f25595m;
        int i15 = i14 - 1;
        iArr[i15] = iArr[i15] + 1;
        this.f25596n[i14 - 1] = "null";
    }

    public String p() {
        StringBuilder sb2 = new StringBuilder("$");
        int i11 = this.f25595m;
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = this.f25594l[i12];
            if (i13 == 1 || i13 == 2) {
                sb2.append('[');
                sb2.append(this.f25597o[i12]);
                sb2.append(']');
            } else if (i13 == 3 || i13 == 4 || i13 == 5) {
                sb2.append('.');
                String str = this.f25596n[i12];
                if (str != null) {
                    sb2.append(str);
                }
            }
        }
        return sb2.toString();
    }

    public final boolean q() {
        return this.f25585c;
    }

    public final int r() throws IOException {
        int iB;
        int[] iArr = this.f25594l;
        int i11 = this.f25595m;
        int i12 = iArr[i11 - 1];
        if (i12 == 1) {
            iArr[i11 - 1] = 2;
        } else if (i12 == 2) {
            int iB2 = b(true);
            if (iB2 != 44) {
                if (iB2 != 59) {
                    if (iB2 != 93) {
                        throw b("Unterminated array");
                    }
                    this.f25583a = 4;
                    return 4;
                }
                v();
            }
        } else {
            if (i12 == 3 || i12 == 5) {
                iArr[i11 - 1] = 4;
                if (i12 == 5 && (iB = b(true)) != 44) {
                    if (iB != 59) {
                        if (iB != 125) {
                            throw b("Unterminated object");
                        }
                        this.f25583a = 2;
                        return 2;
                    }
                    v();
                }
                int iB3 = b(true);
                if (iB3 == 34) {
                    this.f25583a = 13;
                    return 13;
                }
                if (iB3 == 39) {
                    v();
                    this.f25583a = 12;
                    return 12;
                }
                if (iB3 == 125) {
                    if (i12 == 5) {
                        throw b("Expected name");
                    }
                    this.f25583a = 2;
                    return 2;
                }
                v();
                this.f25587e--;
                if (!a((char) iB3)) {
                    throw b("Expected name");
                }
                this.f25583a = 14;
                return 14;
            }
            if (i12 == 4) {
                iArr[i11 - 1] = 5;
                int iB4 = b(true);
                if (iB4 != 58) {
                    if (iB4 != 61) {
                        throw b("Expected ':'");
                    }
                    v();
                    if (this.f25587e < this.f25588f || b(1)) {
                        char[] cArr = this.f25586d;
                        int i13 = this.f25587e;
                        if (cArr[i13] == '>') {
                            this.f25587e = i13 + 1;
                        }
                    }
                }
            } else if (i12 == 6) {
                if (this.f25585c) {
                    y();
                }
                this.f25594l[this.f25595m - 1] = 7;
            } else if (i12 == 7) {
                if (b(false) == -1) {
                    this.f25583a = 17;
                    return 17;
                }
                v();
                this.f25587e--;
            } else if (i12 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iB5 = b(true);
        if (iB5 == 34) {
            this.f25583a = 9;
            return 9;
        }
        if (iB5 == 39) {
            v();
            this.f25583a = 8;
            return 8;
        }
        if (iB5 != 44 && iB5 != 59) {
            if (iB5 == 91) {
                this.f25583a = 3;
                return 3;
            }
            if (iB5 != 93) {
                if (iB5 == 123) {
                    this.f25583a = 1;
                    return 1;
                }
                this.f25587e--;
                int iO = o();
                if (iO != 0) {
                    return iO;
                }
                int iT = t();
                if (iT != 0) {
                    return iT;
                }
                if (!a(this.f25586d[this.f25587e])) {
                    throw b("Expected value");
                }
                v();
                this.f25583a = 10;
                return 10;
            }
            if (i12 == 1) {
                this.f25583a = 4;
                return 4;
            }
        }
        if (i12 != 1 && i12 != 2) {
            throw b("Unexpected value");
        }
        v();
        this.f25587e--;
        this.f25583a = 7;
        return 7;
    }

    public final String s() {
        return " at line " + (this.f25589g + 1) + " column " + ((this.f25587e - this.f25590h) + 1) + " path " + p();
    }

    public String toString() {
        return getClass().getSimpleName() + s();
    }
}
