package com.google.android.exoplayer2.upstream.cache;

import androidx.annotation.Nullable;
import java.io.File;
import java.util.ArrayList;
import java.util.TreeSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f35338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f35339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TreeSet<s> f35340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<a> f35341d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public o f35342e;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f35343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f35344b;

        public a(long j11, long j12) {
            this.f35343a = j11;
            this.f35344b = j12;
        }

        public boolean a(long j11, long j12) {
            long j13 = this.f35344b;
            if (j13 == -1) {
                return j11 >= this.f35343a;
            }
            if (j12 == -1) {
                return false;
            }
            long j14 = this.f35343a;
            return j14 <= j11 && j11 + j12 <= j14 + j13;
        }

        public boolean b(long j11, long j12) {
            long j13 = this.f35343a;
            if (j13 > j11) {
                return j12 == -1 || j11 + j12 > j13;
            }
            long j14 = this.f35344b;
            return j14 == -1 || j13 + j14 > j11;
        }
    }

    public j(int i11, String str) {
        this(i11, str, o.f35365c);
    }

    public j(int i11, String str, o oVar) {
        this.f35338a = i11;
        this.f35339b = str;
        this.f35342e = oVar;
        this.f35340c = new TreeSet<>();
        this.f35341d = new ArrayList<>();
    }

    public void a(s sVar) {
        this.f35340c.add(sVar);
    }

    public boolean b(n nVar) {
        o oVar = this.f35342e;
        o oVarC = oVar.c(nVar);
        this.f35342e = oVarC;
        return !oVarC.equals(oVar);
    }

    public long c(long j11, long j12) {
        com.google.android.exoplayer2.util.a.a(j11 >= 0);
        com.google.android.exoplayer2.util.a.a(j12 >= 0);
        s sVarE = e(j11, j12);
        if (sVarE.b()) {
            return -Math.min(sVarE.c() ? Long.MAX_VALUE : sVarE.f35324c, j12);
        }
        long j13 = j11 + j12;
        long j14 = j13 >= 0 ? j13 : Long.MAX_VALUE;
        long jMax = sVarE.f35323b + sVarE.f35324c;
        if (jMax < j14) {
            for (s sVar : this.f35340c.tailSet(sVarE, false)) {
                long j15 = sVar.f35323b;
                if (j15 > jMax) {
                    break;
                }
                jMax = Math.max(jMax, j15 + sVar.f35324c);
                if (jMax >= j14) {
                    break;
                }
            }
        }
        return Math.min(jMax - j11, j12);
    }

    public o d() {
        return this.f35342e;
    }

    public s e(long j11, long j12) {
        s sVarJ = s.j(this.f35339b, j11);
        s sVarFloor = this.f35340c.floor(sVarJ);
        if (sVarFloor != null && sVarFloor.f35323b + sVarFloor.f35324c > j11) {
            return sVarFloor;
        }
        s sVarCeiling = this.f35340c.ceiling(sVarJ);
        if (sVarCeiling != null) {
            long j13 = sVarCeiling.f35323b - j11;
            j12 = j12 == -1 ? j13 : Math.min(j13, j12);
        }
        return s.i(this.f35339b, j11, j12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        return this.f35338a == jVar.f35338a && this.f35339b.equals(jVar.f35339b) && this.f35340c.equals(jVar.f35340c) && this.f35342e.equals(jVar.f35342e);
    }

    public TreeSet<s> f() {
        return this.f35340c;
    }

    public boolean g() {
        return this.f35340c.isEmpty();
    }

    public boolean h(long j11, long j12) {
        for (int i11 = 0; i11 < this.f35341d.size(); i11++) {
            if (this.f35341d.get(i11).a(j11, j12)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.f35338a * 31) + this.f35339b.hashCode()) * 31) + this.f35342e.hashCode();
    }

    public boolean i() {
        return this.f35341d.isEmpty();
    }

    public boolean j(long j11, long j12) {
        for (int i11 = 0; i11 < this.f35341d.size(); i11++) {
            if (this.f35341d.get(i11).b(j11, j12)) {
                return false;
            }
        }
        this.f35341d.add(new a(j11, j12));
        return true;
    }

    public boolean k(h hVar) {
        if (!this.f35340c.remove(hVar)) {
            return false;
        }
        File file = hVar.f35326f;
        if (file == null) {
            return true;
        }
        file.delete();
        return true;
    }

    public s l(s sVar, long j11, boolean z11) {
        com.google.android.exoplayer2.util.a.g(this.f35340c.remove(sVar));
        File file = (File) com.google.android.exoplayer2.util.a.e(sVar.f35326f);
        if (z11) {
            File fileK = s.k((File) com.google.android.exoplayer2.util.a.e(file.getParentFile()), this.f35338a, sVar.f35323b, j11);
            if (file.renameTo(fileK)) {
                file = fileK;
            } else {
                com.google.android.exoplayer2.util.s.i("CachedContent", "Failed to rename " + file + " to " + fileK);
            }
        }
        s sVarD = sVar.d(file, j11);
        this.f35340c.add(sVarD);
        return sVarD;
    }

    public void m(long j11) {
        for (int i11 = 0; i11 < this.f35341d.size(); i11++) {
            if (this.f35341d.get(i11).f35343a == j11) {
                this.f35341d.remove(i11);
                return;
            }
        }
        throw new IllegalStateException();
    }
}
