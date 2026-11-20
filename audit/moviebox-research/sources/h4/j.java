package h4;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.y;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f66301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y f66302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImmutableList<h4.b> f66303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f66304d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<e> f66305e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<e> f66306f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<e> f66307g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final i f66308h;

    /* JADX INFO: compiled from: source.java */
    public static class b extends j implements g4.f {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final k.a f66309i;

        public b(long j11, y yVar, List<h4.b> list, k.a aVar, @Nullable List<e> list2, List<e> list3, List<e> list4) {
            super(j11, yVar, list, aVar, list2, list3, list4);
            this.f66309i = aVar;
        }

        @Override // g4.f
        public long a(long j11, long j12) {
            return this.f66309i.h(j11, j12);
        }

        @Override // g4.f
        public long b(long j11, long j12) {
            return this.f66309i.d(j11, j12);
        }

        @Override // g4.f
        public long c(long j11, long j12) {
            return this.f66309i.f(j11, j12);
        }

        @Override // g4.f
        public i d(long j11) {
            return this.f66309i.k(this, j11);
        }

        @Override // g4.f
        public long e(long j11, long j12) {
            return this.f66309i.i(j11, j12);
        }

        @Override // g4.f
        public long f(long j11) {
            return this.f66309i.g(j11);
        }

        @Override // g4.f
        public boolean g() {
            return this.f66309i.l();
        }

        @Override // g4.f
        public long getTimeUs(long j11) {
            return this.f66309i.j(j11);
        }

        @Override // g4.f
        public long h() {
            return this.f66309i.e();
        }

        @Override // g4.f
        public long i(long j11, long j12) {
            return this.f66309i.c(j11, j12);
        }

        @Override // h4.j
        @Nullable
        public String j() {
            return null;
        }

        @Override // h4.j
        public g4.f k() {
            return this;
        }

        @Override // h4.j
        @Nullable
        public i l() {
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c extends j {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Uri f66310i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final long f66311j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @Nullable
        public final String f66312k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @Nullable
        public final i f66313l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @Nullable
        public final m f66314m;

        public c(long j11, y yVar, List<h4.b> list, k.e eVar, @Nullable List<e> list2, List<e> list3, List<e> list4, @Nullable String str, long j12) {
            super(j11, yVar, list, eVar, list2, list3, list4);
            this.f66310i = Uri.parse(list.get(0).f66248a);
            i iVarC = eVar.c();
            this.f66313l = iVarC;
            this.f66312k = str;
            this.f66311j = j12;
            this.f66314m = iVarC != null ? null : new m(new i(null, 0L, j12));
        }

        @Override // h4.j
        @Nullable
        public String j() {
            return this.f66312k;
        }

        @Override // h4.j
        @Nullable
        public g4.f k() {
            return this.f66314m;
        }

        @Override // h4.j
        @Nullable
        public i l() {
            return this.f66313l;
        }
    }

    public j(long j11, y yVar, List<h4.b> list, k kVar, @Nullable List<e> list2, List<e> list3, List<e> list4) {
        z3.a.a(!list.isEmpty());
        this.f66301a = j11;
        this.f66302b = yVar;
        this.f66303c = ImmutableList.copyOf((Collection) list);
        this.f66305e = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.f66306f = list3;
        this.f66307g = list4;
        this.f66308h = kVar.a(this);
        this.f66304d = kVar.b();
    }

    public static j n(long j11, y yVar, List<h4.b> list, k kVar, @Nullable List<e> list2, List<e> list3, List<e> list4, @Nullable String str) {
        if (kVar instanceof k.e) {
            return new c(j11, yVar, list, (k.e) kVar, list2, list3, list4, str, -1L);
        }
        if (kVar instanceof k.a) {
            return new b(j11, yVar, list, (k.a) kVar, list2, list3, list4);
        }
        throw new IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
    }

    @Nullable
    public abstract String j();

    @Nullable
    public abstract g4.f k();

    @Nullable
    public abstract i l();

    @Nullable
    public i m() {
        return this.f66308h;
    }
}
