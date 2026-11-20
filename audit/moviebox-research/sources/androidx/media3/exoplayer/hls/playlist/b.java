package androidx.media3.exoplayer.hls.playlist;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.StreamKey;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.e0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends k4.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f10524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f10525e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f10526f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f10527g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f10528h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f10529i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f10530j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f10531k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f10532l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f10533m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f10534n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f10535o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f10536p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public final DrmInitData f10537q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List<d> f10538r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final List<C0100b> f10539s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Map<Uri, c> f10540t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final long f10541u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final f f10542v;

    /* JADX INFO: renamed from: androidx.media3.exoplayer.hls.playlist.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0100b extends e {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final boolean f10543m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final boolean f10544n;

        public C0100b(String str, @Nullable d dVar, long j11, int i11, long j12, @Nullable DrmInitData drmInitData, @Nullable String str2, @Nullable String str3, long j13, long j14, boolean z11, boolean z12, boolean z13) {
            super(str, dVar, j11, i11, j12, drmInitData, str2, str3, j13, j14, z11);
            this.f10543m = z12;
            this.f10544n = z13;
        }

        public C0100b b(long j11, int i11) {
            return new C0100b(this.f10550a, this.f10551b, this.f10552c, i11, j11, this.f10555g, this.f10556h, this.f10557i, this.f10558j, this.f10559k, this.f10560l, this.f10543m, this.f10544n);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f10545a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f10546b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f10547c;

        public c(Uri uri, long j11, int i11) {
            this.f10545a = uri;
            this.f10546b = j11;
            this.f10547c = i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d extends e {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final String f10548m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final List<C0100b> f10549n;

        public d(String str, long j11, long j12, @Nullable String str2, @Nullable String str3) {
            this(str, null, "", 0L, -1, C.TIME_UNSET, null, str2, str3, j11, j12, false, ImmutableList.of());
        }

        public d(String str, @Nullable d dVar, String str2, long j11, int i11, long j12, @Nullable DrmInitData drmInitData, @Nullable String str3, @Nullable String str4, long j13, long j14, boolean z11, List<C0100b> list) {
            super(str, dVar, j11, i11, j12, drmInitData, str3, str4, j13, j14, z11);
            this.f10548m = str2;
            this.f10549n = ImmutableList.copyOf((Collection) list);
        }

        public d b(long j11, int i11) {
            ArrayList arrayList = new ArrayList();
            long j12 = j11;
            for (int i12 = 0; i12 < this.f10549n.size(); i12++) {
                C0100b c0100b = this.f10549n.get(i12);
                arrayList.add(c0100b.b(j12, i11));
                j12 += c0100b.f10552c;
            }
            return new d(this.f10550a, this.f10551b, this.f10548m, this.f10552c, i11, j11, this.f10555g, this.f10556h, this.f10557i, this.f10558j, this.f10559k, this.f10560l, arrayList);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e implements Comparable<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f10550a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final d f10551b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f10552c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f10553d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f10554f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        public final DrmInitData f10555g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        public final String f10556h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Nullable
        public final String f10557i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final long f10558j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final long f10559k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final boolean f10560l;

        public e(String str, @Nullable d dVar, long j11, int i11, long j12, @Nullable DrmInitData drmInitData, @Nullable String str2, @Nullable String str3, long j13, long j14, boolean z11) {
            this.f10550a = str;
            this.f10551b = dVar;
            this.f10552c = j11;
            this.f10553d = i11;
            this.f10554f = j12;
            this.f10555g = drmInitData;
            this.f10556h = str2;
            this.f10557i = str3;
            this.f10558j = j13;
            this.f10559k = j14;
            this.f10560l = z11;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(Long l11) {
            if (this.f10554f > l11.longValue()) {
                return 1;
            }
            return this.f10554f < l11.longValue() ? -1 : 0;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f10561a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f10562b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f10563c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f10564d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f10565e;

        public f(long j11, boolean z11, long j12, long j13, boolean z12) {
            this.f10561a = j11;
            this.f10562b = z11;
            this.f10563c = j12;
            this.f10564d = j13;
            this.f10565e = z12;
        }
    }

    public b(int i11, String str, List<String> list, long j11, boolean z11, long j12, boolean z12, int i12, long j13, int i13, long j14, long j15, boolean z13, boolean z14, boolean z15, @Nullable DrmInitData drmInitData, List<d> list2, List<C0100b> list3, f fVar, Map<Uri, c> map) {
        super(str, list, z13);
        this.f10524d = i11;
        this.f10528h = j12;
        this.f10527g = z11;
        this.f10529i = z12;
        this.f10530j = i12;
        this.f10531k = j13;
        this.f10532l = i13;
        this.f10533m = j14;
        this.f10534n = j15;
        this.f10535o = z14;
        this.f10536p = z15;
        this.f10537q = drmInitData;
        this.f10538r = ImmutableList.copyOf((Collection) list2);
        this.f10539s = ImmutableList.copyOf((Collection) list3);
        this.f10540t = ImmutableMap.copyOf((Map) map);
        if (!list3.isEmpty()) {
            C0100b c0100b = (C0100b) e0.g(list3);
            this.f10541u = c0100b.f10554f + c0100b.f10552c;
        } else if (list2.isEmpty()) {
            this.f10541u = 0L;
        } else {
            d dVar = (d) e0.g(list2);
            this.f10541u = dVar.f10554f + dVar.f10552c;
        }
        this.f10525e = j11 != C.TIME_UNSET ? j11 >= 0 ? Math.min(this.f10541u, j11) : Math.max(0L, this.f10541u + j11) : C.TIME_UNSET;
        this.f10526f = j11 >= 0;
        this.f10542v = fVar;
    }

    @Override // androidx.media3.exoplayer.offline.q
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public b copy(List<StreamKey> list) {
        return this;
    }

    public b b(long j11, int i11) {
        return new b(this.f10524d, this.f68239a, this.f68240b, this.f10525e, this.f10527g, j11, true, i11, this.f10531k, this.f10532l, this.f10533m, this.f10534n, this.f68241c, this.f10535o, this.f10536p, this.f10537q, this.f10538r, this.f10539s, this.f10542v, this.f10540t);
    }

    public b c() {
        return this.f10535o ? this : new b(this.f10524d, this.f68239a, this.f68240b, this.f10525e, this.f10527g, this.f10528h, this.f10529i, this.f10530j, this.f10531k, this.f10532l, this.f10533m, this.f10534n, this.f68241c, true, this.f10536p, this.f10537q, this.f10538r, this.f10539s, this.f10542v, this.f10540t);
    }

    public long d() {
        return this.f10528h + this.f10541u;
    }

    public boolean e(@Nullable b bVar) {
        if (bVar == null) {
            return true;
        }
        long j11 = this.f10531k;
        long j12 = bVar.f10531k;
        if (j11 > j12) {
            return true;
        }
        if (j11 < j12) {
            return false;
        }
        int size = this.f10538r.size() - bVar.f10538r.size();
        if (size != 0) {
            return size > 0;
        }
        int size2 = this.f10539s.size();
        int size3 = bVar.f10539s.size();
        if (size2 <= size3) {
            return size2 == size3 && this.f10535o && !bVar.f10535o;
        }
        return true;
    }
}
