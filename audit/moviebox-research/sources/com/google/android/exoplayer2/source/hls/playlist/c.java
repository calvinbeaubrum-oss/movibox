package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.e0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c extends sh.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f34161d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f34162e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f34163f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f34164g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f34165h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f34166i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f34167j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f34168k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f34169l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f34170m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f34171n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f34172o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f34173p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public final DrmInitData f34174q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List<d> f34175r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final List<b> f34176s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Map<Uri, C0367c> f34177t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final long f34178u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final f f34179v;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends e {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final boolean f34180m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final boolean f34181n;

        public b(String str, @Nullable d dVar, long j11, int i11, long j12, @Nullable DrmInitData drmInitData, @Nullable String str2, @Nullable String str3, long j13, long j14, boolean z11, boolean z12, boolean z13) {
            super(str, dVar, j11, i11, j12, drmInitData, str2, str3, j13, j14, z11);
            this.f34180m = z12;
            this.f34181n = z13;
        }

        public b b(long j11, int i11) {
            return new b(this.f34187a, this.f34188b, this.f34189c, i11, j11, this.f34192g, this.f34193h, this.f34194i, this.f34195j, this.f34196k, this.f34197l, this.f34180m, this.f34181n);
        }
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.source.hls.playlist.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0367c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f34182a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f34183b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f34184c;

        public C0367c(Uri uri, long j11, int i11) {
            this.f34182a = uri;
            this.f34183b = j11;
            this.f34184c = i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d extends e {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final String f34185m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final List<b> f34186n;

        public d(String str, long j11, long j12, @Nullable String str2, @Nullable String str3) {
            this(str, null, "", 0L, -1, C.TIME_UNSET, null, str2, str3, j11, j12, false, ImmutableList.of());
        }

        public d(String str, @Nullable d dVar, String str2, long j11, int i11, long j12, @Nullable DrmInitData drmInitData, @Nullable String str3, @Nullable String str4, long j13, long j14, boolean z11, List<b> list) {
            super(str, dVar, j11, i11, j12, drmInitData, str3, str4, j13, j14, z11);
            this.f34185m = str2;
            this.f34186n = ImmutableList.copyOf((Collection) list);
        }

        public d b(long j11, int i11) {
            ArrayList arrayList = new ArrayList();
            long j12 = j11;
            for (int i12 = 0; i12 < this.f34186n.size(); i12++) {
                b bVar = this.f34186n.get(i12);
                arrayList.add(bVar.b(j12, i11));
                j12 += bVar.f34189c;
            }
            return new d(this.f34187a, this.f34188b, this.f34185m, this.f34189c, i11, j11, this.f34192g, this.f34193h, this.f34194i, this.f34195j, this.f34196k, this.f34197l, arrayList);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e implements Comparable<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f34187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final d f34188b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f34189c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f34190d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f34191f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        public final DrmInitData f34192g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        public final String f34193h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Nullable
        public final String f34194i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final long f34195j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final long f34196k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final boolean f34197l;

        public e(String str, @Nullable d dVar, long j11, int i11, long j12, @Nullable DrmInitData drmInitData, @Nullable String str2, @Nullable String str3, long j13, long j14, boolean z11) {
            this.f34187a = str;
            this.f34188b = dVar;
            this.f34189c = j11;
            this.f34190d = i11;
            this.f34191f = j12;
            this.f34192g = drmInitData;
            this.f34193h = str2;
            this.f34194i = str3;
            this.f34195j = j13;
            this.f34196k = j14;
            this.f34197l = z11;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(Long l11) {
            if (this.f34191f > l11.longValue()) {
                return 1;
            }
            return this.f34191f < l11.longValue() ? -1 : 0;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f34198a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f34199b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f34200c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f34201d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f34202e;

        public f(long j11, boolean z11, long j12, long j13, boolean z12) {
            this.f34198a = j11;
            this.f34199b = z11;
            this.f34200c = j12;
            this.f34201d = j13;
            this.f34202e = z12;
        }
    }

    public c(int i11, String str, List<String> list, long j11, boolean z11, long j12, boolean z12, int i12, long j13, int i13, long j14, long j15, boolean z13, boolean z14, boolean z15, @Nullable DrmInitData drmInitData, List<d> list2, List<b> list3, f fVar, Map<Uri, C0367c> map) {
        super(str, list, z13);
        this.f34161d = i11;
        this.f34165h = j12;
        this.f34164g = z11;
        this.f34166i = z12;
        this.f34167j = i12;
        this.f34168k = j13;
        this.f34169l = i13;
        this.f34170m = j14;
        this.f34171n = j15;
        this.f34172o = z14;
        this.f34173p = z15;
        this.f34174q = drmInitData;
        this.f34175r = ImmutableList.copyOf((Collection) list2);
        this.f34176s = ImmutableList.copyOf((Collection) list3);
        this.f34177t = ImmutableMap.copyOf((Map) map);
        if (!list3.isEmpty()) {
            b bVar = (b) e0.g(list3);
            this.f34178u = bVar.f34191f + bVar.f34189c;
        } else if (list2.isEmpty()) {
            this.f34178u = 0L;
        } else {
            d dVar = (d) e0.g(list2);
            this.f34178u = dVar.f34191f + dVar.f34189c;
        }
        this.f34162e = j11 != C.TIME_UNSET ? j11 >= 0 ? Math.min(this.f34178u, j11) : Math.max(0L, this.f34178u + j11) : C.TIME_UNSET;
        this.f34163f = j11 >= 0;
        this.f34179v = fVar;
    }

    @Override // com.google.android.exoplayer2.offline.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public c copy(List<StreamKey> list) {
        return this;
    }

    public c b(long j11, int i11) {
        return new c(this.f34161d, this.f76359a, this.f76360b, this.f34162e, this.f34164g, j11, true, i11, this.f34168k, this.f34169l, this.f34170m, this.f34171n, this.f76361c, this.f34172o, this.f34173p, this.f34174q, this.f34175r, this.f34176s, this.f34179v, this.f34177t);
    }

    public c c() {
        return this.f34172o ? this : new c(this.f34161d, this.f76359a, this.f76360b, this.f34162e, this.f34164g, this.f34165h, this.f34166i, this.f34167j, this.f34168k, this.f34169l, this.f34170m, this.f34171n, this.f76361c, true, this.f34173p, this.f34174q, this.f34175r, this.f34176s, this.f34179v, this.f34177t);
    }

    public long d() {
        return this.f34165h + this.f34178u;
    }

    public boolean e(@Nullable c cVar) {
        if (cVar == null) {
            return true;
        }
        long j11 = this.f34168k;
        long j12 = cVar.f34168k;
        if (j11 > j12) {
            return true;
        }
        if (j11 < j12) {
            return false;
        }
        int size = this.f34175r.size() - cVar.f34175r.size();
        if (size != 0) {
            return size > 0;
        }
        int size2 = this.f34176s.size();
        int size3 = cVar.f34176s.size();
        if (size2 <= size3) {
            return size2 == size3 && this.f34172o && !cVar.f34172o;
        }
        return true;
    }
}
