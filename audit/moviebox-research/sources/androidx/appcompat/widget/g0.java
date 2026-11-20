package androidx.appcompat.widget;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1664a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1665b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1666c = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1667d = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1668e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1669f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1670g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1671h = false;

    public int a() {
        return this.f1670g ? this.f1664a : this.f1665b;
    }

    public int b() {
        return this.f1664a;
    }

    public int c() {
        return this.f1665b;
    }

    public int d() {
        return this.f1670g ? this.f1665b : this.f1664a;
    }

    public void e(int i11, int i12) {
        this.f1671h = false;
        if (i11 != Integer.MIN_VALUE) {
            this.f1668e = i11;
            this.f1664a = i11;
        }
        if (i12 != Integer.MIN_VALUE) {
            this.f1669f = i12;
            this.f1665b = i12;
        }
    }

    public void f(boolean z11) {
        if (z11 == this.f1670g) {
            return;
        }
        this.f1670g = z11;
        if (!this.f1671h) {
            this.f1664a = this.f1668e;
            this.f1665b = this.f1669f;
            return;
        }
        if (z11) {
            int i11 = this.f1667d;
            if (i11 == Integer.MIN_VALUE) {
                i11 = this.f1668e;
            }
            this.f1664a = i11;
            int i12 = this.f1666c;
            if (i12 == Integer.MIN_VALUE) {
                i12 = this.f1669f;
            }
            this.f1665b = i12;
            return;
        }
        int i13 = this.f1666c;
        if (i13 == Integer.MIN_VALUE) {
            i13 = this.f1668e;
        }
        this.f1664a = i13;
        int i14 = this.f1667d;
        if (i14 == Integer.MIN_VALUE) {
            i14 = this.f1669f;
        }
        this.f1665b = i14;
    }

    public void g(int i11, int i12) {
        this.f1666c = i11;
        this.f1667d = i12;
        this.f1671h = true;
        if (this.f1670g) {
            if (i12 != Integer.MIN_VALUE) {
                this.f1664a = i12;
            }
            if (i11 != Integer.MIN_VALUE) {
                this.f1665b = i11;
                return;
            }
            return;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.f1664a = i11;
        }
        if (i12 != Integer.MIN_VALUE) {
            this.f1665b = i12;
        }
    }
}
