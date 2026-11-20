package com.bykv.vk.openvk.preload.a.b.a;

import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends com.bykv.vk.openvk.preload.a.d.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f25388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object[] f25389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f25390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String[] f25391e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int[] f25392f;

    static {
        new Reader() { // from class: com.bykv.vk.openvk.preload.a.b.a.e.1
            @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
            public final void close() throws IOException {
                throw new AssertionError();
            }

            @Override // java.io.Reader
            public final int read(char[] cArr, int i11, int i12) throws IOException {
                throw new AssertionError();
            }
        };
        f25388b = new Object();
    }

    private void a(com.bykv.vk.openvk.preload.a.d.b bVar) throws IOException {
        if (f() == bVar) {
            return;
        }
        throw new IllegalStateException("Expected " + bVar + " but was " + f() + v());
    }

    private void a(Object obj) {
        int i11 = this.f25390d;
        Object[] objArr = this.f25389c;
        if (i11 == objArr.length) {
            int i12 = i11 << 1;
            this.f25389c = Arrays.copyOf(objArr, i12);
            this.f25392f = Arrays.copyOf(this.f25392f, i12);
            this.f25391e = (String[]) Arrays.copyOf(this.f25391e, i12);
        }
        Object[] objArr2 = this.f25389c;
        int i13 = this.f25390d;
        this.f25390d = i13 + 1;
        objArr2[i13] = obj;
    }

    private Object t() {
        return this.f25389c[this.f25390d - 1];
    }

    private Object u() {
        Object[] objArr = this.f25389c;
        int i11 = this.f25390d - 1;
        this.f25390d = i11;
        Object obj = objArr[i11];
        objArr[i11] = null;
        return obj;
    }

    private String v() {
        return " at path " + p();
    }

    @Override // com.bykv.vk.openvk.preload.a.d.a
    public final void a() throws IOException {
        a(com.bykv.vk.openvk.preload.a.d.b.BEGIN_ARRAY);
        a(((com.bykv.vk.openvk.preload.a.f) t()).iterator());
        this.f25392f[this.f25390d - 1] = 0;
    }

    @Override // com.bykv.vk.openvk.preload.a.d.a
    public final void b() throws IOException {
        a(com.bykv.vk.openvk.preload.a.d.b.END_ARRAY);
        u();
        u();
        int i11 = this.f25390d;
        if (i11 > 0) {
            int[] iArr = this.f25392f;
            int i12 = i11 - 1;
            iArr[i12] = iArr[i12] + 1;
        }
    }

    @Override // com.bykv.vk.openvk.preload.a.d.a
    public final void c() throws IOException {
        a(com.bykv.vk.openvk.preload.a.d.b.BEGIN_OBJECT);
        a(((com.bykv.vk.openvk.preload.a.k) t()).g().iterator());
    }

    @Override // com.bykv.vk.openvk.preload.a.d.a, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f25389c = new Object[]{f25388b};
        this.f25390d = 1;
    }

    @Override // com.bykv.vk.openvk.preload.a.d.a
    public final void d() throws IOException {
        a(com.bykv.vk.openvk.preload.a.d.b.END_OBJECT);
        u();
        u();
        int i11 = this.f25390d;
        if (i11 > 0) {
            int[] iArr = this.f25392f;
            int i12 = i11 - 1;
            iArr[i12] = iArr[i12] + 1;
        }
    }

    @Override // com.bykv.vk.openvk.preload.a.d.a
    public final boolean e() throws IOException {
        com.bykv.vk.openvk.preload.a.d.b bVarF = f();
        return (bVarF == com.bykv.vk.openvk.preload.a.d.b.END_OBJECT || bVarF == com.bykv.vk.openvk.preload.a.d.b.END_ARRAY) ? false : true;
    }

    @Override // com.bykv.vk.openvk.preload.a.d.a
    public final com.bykv.vk.openvk.preload.a.d.b f() throws IOException {
        while (this.f25390d != 0) {
            Object objT = t();
            if (!(objT instanceof Iterator)) {
                if (objT instanceof com.bykv.vk.openvk.preload.a.k) {
                    return com.bykv.vk.openvk.preload.a.d.b.BEGIN_OBJECT;
                }
                if (objT instanceof com.bykv.vk.openvk.preload.a.f) {
                    return com.bykv.vk.openvk.preload.a.d.b.BEGIN_ARRAY;
                }
                if (!(objT instanceof com.bykv.vk.openvk.preload.a.m)) {
                    if (objT instanceof com.bykv.vk.openvk.preload.a.j) {
                        return com.bykv.vk.openvk.preload.a.d.b.NULL;
                    }
                    if (objT == f25388b) {
                        throw new IllegalStateException("JsonReader is closed");
                    }
                    throw new AssertionError();
                }
                com.bykv.vk.openvk.preload.a.m mVar = (com.bykv.vk.openvk.preload.a.m) objT;
                if (mVar.i()) {
                    return com.bykv.vk.openvk.preload.a.d.b.STRING;
                }
                if (mVar.g()) {
                    return com.bykv.vk.openvk.preload.a.d.b.BOOLEAN;
                }
                if (mVar.h()) {
                    return com.bykv.vk.openvk.preload.a.d.b.NUMBER;
                }
                throw new AssertionError();
            }
            boolean z11 = this.f25389c[this.f25390d - 2] instanceof com.bykv.vk.openvk.preload.a.k;
            Iterator it = (Iterator) objT;
            if (!it.hasNext()) {
                return z11 ? com.bykv.vk.openvk.preload.a.d.b.END_OBJECT : com.bykv.vk.openvk.preload.a.d.b.END_ARRAY;
            }
            if (z11) {
                return com.bykv.vk.openvk.preload.a.d.b.NAME;
            }
            a(it.next());
        }
        return com.bykv.vk.openvk.preload.a.d.b.END_DOCUMENT;
    }

    @Override // com.bykv.vk.openvk.preload.a.d.a
    public final String g() throws IOException {
        a(com.bykv.vk.openvk.preload.a.d.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) t()).next();
        String str = (String) entry.getKey();
        this.f25391e[this.f25390d - 1] = str;
        a(entry.getValue());
        return str;
    }

    @Override // com.bykv.vk.openvk.preload.a.d.a
    public final String h() throws IOException {
        com.bykv.vk.openvk.preload.a.d.b bVarF = f();
        com.bykv.vk.openvk.preload.a.d.b bVar = com.bykv.vk.openvk.preload.a.d.b.STRING;
        if (bVarF != bVar && bVarF != com.bykv.vk.openvk.preload.a.d.b.NUMBER) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarF + v());
        }
        String strB = ((com.bykv.vk.openvk.preload.a.m) u()).b();
        int i11 = this.f25390d;
        if (i11 > 0) {
            int[] iArr = this.f25392f;
            int i12 = i11 - 1;
            iArr[i12] = iArr[i12] + 1;
        }
        return strB;
    }

    @Override // com.bykv.vk.openvk.preload.a.d.a
    public final boolean i() throws IOException {
        a(com.bykv.vk.openvk.preload.a.d.b.BOOLEAN);
        boolean zF = ((com.bykv.vk.openvk.preload.a.m) u()).f();
        int i11 = this.f25390d;
        if (i11 > 0) {
            int[] iArr = this.f25392f;
            int i12 = i11 - 1;
            iArr[i12] = iArr[i12] + 1;
        }
        return zF;
    }

    @Override // com.bykv.vk.openvk.preload.a.d.a
    public final void j() throws IOException {
        a(com.bykv.vk.openvk.preload.a.d.b.NULL);
        u();
        int i11 = this.f25390d;
        if (i11 > 0) {
            int[] iArr = this.f25392f;
            int i12 = i11 - 1;
            iArr[i12] = iArr[i12] + 1;
        }
    }

    @Override // com.bykv.vk.openvk.preload.a.d.a
    public final double k() throws IOException {
        com.bykv.vk.openvk.preload.a.d.b bVarF = f();
        com.bykv.vk.openvk.preload.a.d.b bVar = com.bykv.vk.openvk.preload.a.d.b.NUMBER;
        if (bVarF != bVar && bVarF != com.bykv.vk.openvk.preload.a.d.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarF + v());
        }
        double dC = ((com.bykv.vk.openvk.preload.a.m) t()).c();
        if (!q() && (Double.isNaN(dC) || Double.isInfinite(dC))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: ".concat(String.valueOf(dC)));
        }
        u();
        int i11 = this.f25390d;
        if (i11 > 0) {
            int[] iArr = this.f25392f;
            int i12 = i11 - 1;
            iArr[i12] = iArr[i12] + 1;
        }
        return dC;
    }

    @Override // com.bykv.vk.openvk.preload.a.d.a
    public final long l() throws IOException {
        com.bykv.vk.openvk.preload.a.d.b bVarF = f();
        com.bykv.vk.openvk.preload.a.d.b bVar = com.bykv.vk.openvk.preload.a.d.b.NUMBER;
        if (bVarF != bVar && bVarF != com.bykv.vk.openvk.preload.a.d.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarF + v());
        }
        long jD = ((com.bykv.vk.openvk.preload.a.m) t()).d();
        u();
        int i11 = this.f25390d;
        if (i11 > 0) {
            int[] iArr = this.f25392f;
            int i12 = i11 - 1;
            iArr[i12] = iArr[i12] + 1;
        }
        return jD;
    }

    @Override // com.bykv.vk.openvk.preload.a.d.a
    public final int m() throws IOException {
        com.bykv.vk.openvk.preload.a.d.b bVarF = f();
        com.bykv.vk.openvk.preload.a.d.b bVar = com.bykv.vk.openvk.preload.a.d.b.NUMBER;
        if (bVarF != bVar && bVarF != com.bykv.vk.openvk.preload.a.d.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarF + v());
        }
        int iE = ((com.bykv.vk.openvk.preload.a.m) t()).e();
        u();
        int i11 = this.f25390d;
        if (i11 > 0) {
            int[] iArr = this.f25392f;
            int i12 = i11 - 1;
            iArr[i12] = iArr[i12] + 1;
        }
        return iE;
    }

    @Override // com.bykv.vk.openvk.preload.a.d.a
    public final void n() throws IOException {
        if (f() == com.bykv.vk.openvk.preload.a.d.b.NAME) {
            g();
            this.f25391e[this.f25390d - 2] = "null";
        } else {
            u();
            int i11 = this.f25390d;
            if (i11 > 0) {
                this.f25391e[i11 - 1] = "null";
            }
        }
        int i12 = this.f25390d;
        if (i12 > 0) {
            int[] iArr = this.f25392f;
            int i13 = i12 - 1;
            iArr[i13] = iArr[i13] + 1;
        }
    }

    public final void o() throws IOException {
        a(com.bykv.vk.openvk.preload.a.d.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) t()).next();
        a(entry.getValue());
        a(new com.bykv.vk.openvk.preload.a.m((String) entry.getKey()));
    }

    @Override // com.bykv.vk.openvk.preload.a.d.a
    public final String p() {
        StringBuilder sb2 = new StringBuilder("$");
        int i11 = 0;
        while (i11 < this.f25390d) {
            Object[] objArr = this.f25389c;
            Object obj = objArr[i11];
            if (obj instanceof com.bykv.vk.openvk.preload.a.f) {
                i11++;
                if (objArr[i11] instanceof Iterator) {
                    sb2.append('[');
                    sb2.append(this.f25392f[i11]);
                    sb2.append(']');
                }
            } else if (obj instanceof com.bykv.vk.openvk.preload.a.k) {
                i11++;
                if (objArr[i11] instanceof Iterator) {
                    sb2.append('.');
                    String str = this.f25391e[i11];
                    if (str != null) {
                        sb2.append(str);
                    }
                }
            }
            i11++;
        }
        return sb2.toString();
    }

    @Override // com.bykv.vk.openvk.preload.a.d.a
    public final String toString() {
        return e.class.getSimpleName();
    }
}
