package com.google.protobuf;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class b0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final p f41210e = p.b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteString f41211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p f41212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile n0 f41213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile ByteString f41214d;

    public void a(n0 n0Var) {
        if (this.f41213c != null) {
            return;
        }
        synchronized (this) {
            if (this.f41213c != null) {
                return;
            }
            try {
                if (this.f41211a != null) {
                    this.f41213c = n0Var.p().a(this.f41211a, this.f41212b);
                    this.f41214d = this.f41211a;
                } else {
                    this.f41213c = n0Var;
                    this.f41214d = ByteString.EMPTY;
                }
            } catch (InvalidProtocolBufferException unused) {
                this.f41213c = n0Var;
                this.f41214d = ByteString.EMPTY;
            }
        }
    }

    public int b() {
        if (this.f41214d != null) {
            return this.f41214d.size();
        }
        ByteString byteString = this.f41211a;
        if (byteString != null) {
            return byteString.size();
        }
        if (this.f41213c != null) {
            return this.f41213c.g();
        }
        return 0;
    }

    public n0 c(n0 n0Var) {
        a(n0Var);
        return this.f41213c;
    }

    public n0 d(n0 n0Var) {
        n0 n0Var2 = this.f41213c;
        this.f41211a = null;
        this.f41214d = null;
        this.f41213c = n0Var;
        return n0Var2;
    }

    public ByteString e() {
        if (this.f41214d != null) {
            return this.f41214d;
        }
        ByteString byteString = this.f41211a;
        if (byteString != null) {
            return byteString;
        }
        synchronized (this) {
            try {
                if (this.f41214d != null) {
                    return this.f41214d;
                }
                if (this.f41213c == null) {
                    this.f41214d = ByteString.EMPTY;
                } else {
                    this.f41214d = this.f41213c.c();
                }
                return this.f41214d;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        n0 n0Var = this.f41213c;
        n0 n0Var2 = b0Var.f41213c;
        if (n0Var == null && n0Var2 == null) {
            return e().equals(b0Var.e());
        }
        if (n0Var == null || n0Var2 == null) {
            return n0Var != null ? n0Var.equals(b0Var.c(n0Var.k())) : c(n0Var2.k()).equals(n0Var2);
        }
        return n0Var.equals(n0Var2);
    }

    public int hashCode() {
        return 1;
    }
}
