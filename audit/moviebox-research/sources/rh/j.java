package rh;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f75443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m1 f75444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImmutableList<rh.b> f75445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f75446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<e> f75447e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<e> f75448f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<e> f75449g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final i f75450h;

    /* JADX INFO: compiled from: source.java */
    public static class b extends j implements qh.e {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final k.a f75451i;

        public b(long j11, m1 m1Var, List<rh.b> list, k.a aVar, @Nullable List<e> list2, List<e> list3, List<e> list4) {
            super(j11, m1Var, list, aVar, list2, list3, list4);
            this.f75451i = aVar;
        }

        @Override // qh.e
        public long a(long j11, long j12) {
            return this.f75451i.h(j11, j12);
        }

        @Override // qh.e
        public long b(long j11, long j12) {
            return this.f75451i.d(j11, j12);
        }

        @Override // qh.e
        public long c(long j11, long j12) {
            return this.f75451i.f(j11, j12);
        }

        @Override // qh.e
        public i d(long j11) {
            return this.f75451i.k(this, j11);
        }

        @Override // qh.e
        public long e(long j11, long j12) {
            return this.f75451i.i(j11, j12);
        }

        @Override // qh.e
        public long f(long j11) {
            return this.f75451i.g(j11);
        }

        @Override // qh.e
        public boolean g() {
            return this.f75451i.l();
        }

        @Override // qh.e
        public long getTimeUs(long j11) {
            return this.f75451i.j(j11);
        }

        @Override // qh.e
        public long h() {
            return this.f75451i.e();
        }

        @Override // qh.e
        public long i(long j11, long j12) {
            return this.f75451i.c(j11, j12);
        }

        @Override // rh.j
        @Nullable
        public String j() {
            return null;
        }

        @Override // rh.j
        public qh.e k() {
            return this;
        }

        @Override // rh.j
        @Nullable
        public i l() {
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c extends j {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Uri f75452i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final long f75453j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @Nullable
        public final String f75454k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @Nullable
        public final i f75455l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @Nullable
        public final m f75456m;

        public c(long j11, m1 m1Var, List<rh.b> list, k.e eVar, @Nullable List<e> list2, List<e> list3, List<e> list4, @Nullable String str, long j12) {
            super(j11, m1Var, list, eVar, list2, list3, list4);
            this.f75452i = Uri.parse(list.get(0).f75390a);
            i iVarC = eVar.c();
            this.f75455l = iVarC;
            this.f75454k = str;
            this.f75453j = j12;
            this.f75456m = iVarC != null ? null : new m(new i(null, 0L, j12));
        }

        @Override // rh.j
        @Nullable
        public String j() {
            return this.f75454k;
        }

        @Override // rh.j
        @Nullable
        public qh.e k() {
            return this.f75456m;
        }

        @Override // rh.j
        @Nullable
        public i l() {
            return this.f75455l;
        }
    }

    public j(long j11, m1 m1Var, List<rh.b> list, k kVar, @Nullable List<e> list2, List<e> list3, List<e> list4) {
        com.google.android.exoplayer2.util.a.a(!list.isEmpty());
        this.f75443a = j11;
        this.f75444b = m1Var;
        this.f75445c = ImmutableList.copyOf((Collection) list);
        this.f75447e = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.f75448f = list3;
        this.f75449g = list4;
        this.f75450h = kVar.a(this);
        this.f75446d = kVar.b();
    }

    public static j n(long j11, m1 m1Var, List<rh.b> list, k kVar, @Nullable List<e> list2, List<e> list3, List<e> list4, @Nullable String str) {
        if (kVar instanceof k.e) {
            return new c(j11, m1Var, list, (k.e) kVar, list2, list3, list4, str, -1L);
        }
        if (kVar instanceof k.a) {
            return new b(j11, m1Var, list, (k.a) kVar, list2, list3, list4);
        }
        throw new IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
    }

    @Nullable
    public abstract String j();

    @Nullable
    public abstract qh.e k();

    @Nullable
    public abstract i l();

    @Nullable
    public i m() {
        return this.f75450h;
    }
}
