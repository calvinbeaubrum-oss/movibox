package q4;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f74297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f74298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f74299d;

    public b(long j11, long j12) {
        this.f74297b = j11;
        this.f74298c = j12;
        f();
    }

    public final void c() {
        long j11 = this.f74299d;
        if (j11 < this.f74297b || j11 > this.f74298c) {
            throw new NoSuchElementException();
        }
    }

    public final long d() {
        return this.f74299d;
    }

    public boolean e() {
        return this.f74299d > this.f74298c;
    }

    public void f() {
        this.f74299d = this.f74297b - 1;
    }

    @Override // q4.n
    public boolean next() {
        this.f74299d++;
        return !e();
    }
}
