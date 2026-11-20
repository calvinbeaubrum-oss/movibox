package ck;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14949c;

    public g(int i11, int i12) {
        if (i11 < 0) {
            throw new IndexOutOfBoundsException("Lower bound cannot be negative");
        }
        if (i11 > i12) {
            throw new IndexOutOfBoundsException("Lower bound cannot be greater then upper bound");
        }
        this.f14947a = i11;
        this.f14948b = i12;
        this.f14949c = i11;
    }

    public boolean a() {
        return this.f14949c >= this.f14948b;
    }

    public int b() {
        return this.f14949c;
    }

    public int c() {
        return this.f14948b;
    }

    public void d(int i11) {
        if (i11 < this.f14947a) {
            throw new IndexOutOfBoundsException("pos: " + i11 + " < lowerBound: " + this.f14947a);
        }
        if (i11 <= this.f14948b) {
            this.f14949c = i11;
            return;
        }
        throw new IndexOutOfBoundsException("pos: " + i11 + " > upperBound: " + this.f14948b);
    }

    public String toString() {
        return '[' + Integer.toString(this.f14947a) + '>' + Integer.toString(this.f14949c) + '>' + Integer.toString(this.f14948b) + ']';
    }
}
