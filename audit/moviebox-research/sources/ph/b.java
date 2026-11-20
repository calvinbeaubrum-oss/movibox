package ph;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class b implements o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f73783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f73784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f73785d;

    public b(long j11, long j12) {
        this.f73783b = j11;
        this.f73784c = j12;
        f();
    }

    public final void c() {
        long j11 = this.f73785d;
        if (j11 < this.f73783b || j11 > this.f73784c) {
            throw new NoSuchElementException();
        }
    }

    public final long d() {
        return this.f73785d;
    }

    public boolean e() {
        return this.f73785d > this.f73784c;
    }

    public void f() {
        this.f73785d = this.f73783b - 1;
    }

    @Override // ph.o
    public boolean next() {
        this.f73785d++;
        return !e();
    }
}
