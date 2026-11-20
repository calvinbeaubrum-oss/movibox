package go;

import androidx.annotation.Nullable;
import io.l;
import io.o;
import io.r;
import java.util.Objects;
import l.p;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class g implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f65581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f65582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f65583c;

    public g(long j11, f fVar, f fVar2) {
        this.f65581a = j11;
        this.f65582b = fVar;
        this.f65583c = fVar2;
    }

    @Override // io.l
    public void a(r rVar) {
        rVar.n(1, this.f65581a);
        if (!this.f65582b.c()) {
            rVar.q(2, this.f65582b);
        }
        if (this.f65583c.c()) {
            return;
        }
        rVar.q(3, this.f65583c);
    }

    public f c() {
        return this.f65582b;
    }

    @Override // io.l
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public g b(o oVar) {
        long j11 = this.f65581a;
        f fVar = this.f65582b;
        f fVar2 = this.f65583c;
        while (oVar.b()) {
            int iN = oVar.n();
            if (iN == 1) {
                j11 = oVar.j();
            } else if (iN == 2) {
                fVar = (f) oVar.l(this.f65582b);
            } else if (iN != 3) {
                oVar.c();
            } else {
                fVar2 = (f) oVar.l(this.f65583c);
            }
        }
        return new g(j11, fVar, fVar2);
    }

    public f e() {
        return this.f65583c;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f65581a == gVar.f65581a && Objects.equals(this.f65582b, gVar.f65582b) && Objects.equals(this.f65583c, gVar.f65583c);
    }

    public int hashCode() {
        return p.a(this.f65581a);
    }

    public String toString() {
        return super.toString();
    }
}
