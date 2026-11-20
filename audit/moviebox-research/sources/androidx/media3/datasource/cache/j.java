package androidx.media3.datasource.cache;

import androidx.annotation.Nullable;
import java.io.File;
import java.util.ArrayList;
import java.util.TreeSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TreeSet<s> f9700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<a> f9701d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public o f9702e;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f9703a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f9704b;

        public a(long j11, long j12) {
            this.f9703a = j11;
            this.f9704b = j12;
        }

        public boolean a(long j11, long j12) {
            long j13 = this.f9704b;
            if (j13 == -1) {
                return j11 >= this.f9703a;
            }
            if (j12 == -1) {
                return false;
            }
            long j14 = this.f9703a;
            return j14 <= j11 && j11 + j12 <= j14 + j13;
        }

        public boolean b(long j11, long j12) {
            long j13 = this.f9703a;
            if (j13 > j11) {
                return j12 == -1 || j11 + j12 > j13;
            }
            long j14 = this.f9704b;
            return j14 == -1 || j13 + j14 > j11;
        }
    }

    public j(int i11, String str) {
        this(i11, str, o.f9725c);
    }

    public j(int i11, String str, o oVar) {
        this.f9698a = i11;
        this.f9699b = str;
        this.f9702e = oVar;
        this.f9700c = new TreeSet<>();
        this.f9701d = new ArrayList<>();
    }

    public void a(s sVar) {
        this.f9700c.add(sVar);
    }

    public boolean b(n nVar) {
        o oVar = this.f9702e;
        o oVarC = oVar.c(nVar);
        this.f9702e = oVarC;
        return !oVarC.equals(oVar);
    }

    public long c(long j11, long j12) {
        z3.a.a(j11 >= 0);
        z3.a.a(j12 >= 0);
        s sVarE = e(j11, j12);
        if (sVarE.b()) {
            return -Math.min(sVarE.c() ? Long.MAX_VALUE : sVarE.f9684c, j12);
        }
        long j13 = j11 + j12;
        long j14 = j13 >= 0 ? j13 : Long.MAX_VALUE;
        long jMax = sVarE.f9683b + sVarE.f9684c;
        if (jMax < j14) {
            for (s sVar : this.f9700c.tailSet(sVarE, false)) {
                long j15 = sVar.f9683b;
                if (j15 > jMax) {
                    break;
                }
                jMax = Math.max(jMax, j15 + sVar.f9684c);
                if (jMax >= j14) {
                    break;
                }
            }
        }
        return Math.min(jMax - j11, j12);
    }

    public o d() {
        return this.f9702e;
    }

    public s e(long j11, long j12) {
        s sVarJ = s.j(this.f9699b, j11);
        s sVarFloor = this.f9700c.floor(sVarJ);
        if (sVarFloor != null && sVarFloor.f9683b + sVarFloor.f9684c > j11) {
            return sVarFloor;
        }
        s sVarCeiling = this.f9700c.ceiling(sVarJ);
        if (sVarCeiling != null) {
            long j13 = sVarCeiling.f9683b - j11;
            j12 = j12 == -1 ? j13 : Math.min(j13, j12);
        }
        return s.i(this.f9699b, j11, j12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        return this.f9698a == jVar.f9698a && this.f9699b.equals(jVar.f9699b) && this.f9700c.equals(jVar.f9700c) && this.f9702e.equals(jVar.f9702e);
    }

    public TreeSet<s> f() {
        return this.f9700c;
    }

    public boolean g() {
        return this.f9700c.isEmpty();
    }

    public boolean h(long j11, long j12) {
        for (int i11 = 0; i11 < this.f9701d.size(); i11++) {
            if (this.f9701d.get(i11).a(j11, j12)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.f9698a * 31) + this.f9699b.hashCode()) * 31) + this.f9702e.hashCode();
    }

    public boolean i() {
        return this.f9701d.isEmpty();
    }

    public boolean j(long j11, long j12) {
        for (int i11 = 0; i11 < this.f9701d.size(); i11++) {
            if (this.f9701d.get(i11).b(j11, j12)) {
                return false;
            }
        }
        this.f9701d.add(new a(j11, j12));
        return true;
    }

    public boolean k(h hVar) {
        if (!this.f9700c.remove(hVar)) {
            return false;
        }
        File file = hVar.f9686f;
        if (file == null) {
            return true;
        }
        file.delete();
        return true;
    }

    public s l(s sVar, long j11, boolean z11) {
        z3.a.g(this.f9700c.remove(sVar));
        File file = (File) z3.a.e(sVar.f9686f);
        if (z11) {
            File fileK = s.k((File) z3.a.e(file.getParentFile()), this.f9698a, sVar.f9683b, j11);
            if (file.renameTo(fileK)) {
                file = fileK;
            } else {
                z3.o.h("CachedContent", "Failed to rename " + file + " to " + fileK);
            }
        }
        s sVarD = sVar.d(file, j11);
        this.f9700c.add(sVarD);
        return sVarD;
    }

    public void m(long j11) {
        for (int i11 = 0; i11 < this.f9701d.size(); i11++) {
            if (this.f9701d.get(i11).f9703a == j11) {
                this.f9701d.remove(i11);
                return;
            }
        }
        throw new IllegalStateException();
    }
}
