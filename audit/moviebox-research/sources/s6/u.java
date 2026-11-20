package s6;

import androidx.work.BackoffPolicy;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class u {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final a f76196u = new a(null);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f76197v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @JvmField
    public static final j1.a<List<c>, List<WorkInfo>> f76198w;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public final String f76199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public WorkInfo.State f76200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public String f76201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @JvmField
    public String f76202d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @JvmField
    public androidx.work.d f76203e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @JvmField
    public androidx.work.d f76204f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @JvmField
    public long f76205g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @JvmField
    public long f76206h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @JvmField
    public long f76207i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @JvmField
    public androidx.work.b f76208j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @JvmField
    public int f76209k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @JvmField
    public BackoffPolicy f76210l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @JvmField
    public long f76211m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @JvmField
    public long f76212n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @JvmField
    public long f76213o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @JvmField
    public long f76214p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @JvmField
    public boolean f76215q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @JvmField
    public OutOfQuotaPolicy f76216r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f76217s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f76218t;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @JvmField
        public String f76219a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @JvmField
        public WorkInfo.State f76220b;

        public b(String id2, WorkInfo.State state) {
            Intrinsics.g(id2, "id");
            Intrinsics.g(state, "state");
            this.f76219a = id2;
            this.f76220b = state;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.b(this.f76219a, bVar.f76219a) && this.f76220b == bVar.f76220b;
        }

        public int hashCode() {
            return (this.f76219a.hashCode() * 31) + this.f76220b.hashCode();
        }

        public String toString() {
            return "IdAndState(id=" + this.f76219a + ", state=" + this.f76220b + ')';
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f76221a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public WorkInfo.State f76222b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public androidx.work.d f76223c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f76224d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f76225e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<String> f76226f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List<androidx.work.d> f76227g;

        public c(String id2, WorkInfo.State state, androidx.work.d output, int i11, int i12, List<String> tags, List<androidx.work.d> progress) {
            Intrinsics.g(id2, "id");
            Intrinsics.g(state, "state");
            Intrinsics.g(output, "output");
            Intrinsics.g(tags, "tags");
            Intrinsics.g(progress, "progress");
            this.f76221a = id2;
            this.f76222b = state;
            this.f76223c = output;
            this.f76224d = i11;
            this.f76225e = i12;
            this.f76226f = tags;
            this.f76227g = progress;
        }

        public final WorkInfo a() {
            return new WorkInfo(UUID.fromString(this.f76221a), this.f76222b, this.f76223c, this.f76226f, this.f76227g.isEmpty() ^ true ? this.f76227g.get(0) : androidx.work.d.f13305c, this.f76224d, this.f76225e);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return Intrinsics.b(this.f76221a, cVar.f76221a) && this.f76222b == cVar.f76222b && Intrinsics.b(this.f76223c, cVar.f76223c) && this.f76224d == cVar.f76224d && this.f76225e == cVar.f76225e && Intrinsics.b(this.f76226f, cVar.f76226f) && Intrinsics.b(this.f76227g, cVar.f76227g);
        }

        public int hashCode() {
            return (((((((((((this.f76221a.hashCode() * 31) + this.f76222b.hashCode()) * 31) + this.f76223c.hashCode()) * 31) + this.f76224d) * 31) + this.f76225e) * 31) + this.f76226f.hashCode()) * 31) + this.f76227g.hashCode();
        }

        public String toString() {
            return "WorkInfoPojo(id=" + this.f76221a + ", state=" + this.f76222b + ", output=" + this.f76223c + ", runAttemptCount=" + this.f76224d + ", generation=" + this.f76225e + ", tags=" + this.f76226f + ", progress=" + this.f76227g + ')';
        }
    }

    static {
        String strI = androidx.work.j.i("WorkSpec");
        Intrinsics.f(strI, "tagWithPrefix(\"WorkSpec\")");
        f76197v = strI;
        f76198w = new j1.a() { // from class: s6.t
            @Override // j1.a
            public final Object apply(Object obj) {
                return u.b((List) obj);
            }
        };
    }

    public u(String id2, WorkInfo.State state, String workerClassName, String str, androidx.work.d input, androidx.work.d output, long j11, long j12, long j13, androidx.work.b constraints, int i11, BackoffPolicy backoffPolicy, long j14, long j15, long j16, long j17, boolean z11, OutOfQuotaPolicy outOfQuotaPolicy, int i12, int i13) {
        Intrinsics.g(id2, "id");
        Intrinsics.g(state, "state");
        Intrinsics.g(workerClassName, "workerClassName");
        Intrinsics.g(input, "input");
        Intrinsics.g(output, "output");
        Intrinsics.g(constraints, "constraints");
        Intrinsics.g(backoffPolicy, "backoffPolicy");
        Intrinsics.g(outOfQuotaPolicy, "outOfQuotaPolicy");
        this.f76199a = id2;
        this.f76200b = state;
        this.f76201c = workerClassName;
        this.f76202d = str;
        this.f76203e = input;
        this.f76204f = output;
        this.f76205g = j11;
        this.f76206h = j12;
        this.f76207i = j13;
        this.f76208j = constraints;
        this.f76209k = i11;
        this.f76210l = backoffPolicy;
        this.f76211m = j14;
        this.f76212n = j15;
        this.f76213o = j16;
        this.f76214p = j17;
        this.f76215q = z11;
        this.f76216r = outOfQuotaPolicy;
        this.f76217s = i12;
        this.f76218t = i13;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ u(String str, WorkInfo.State state, String str2, String str3, androidx.work.d dVar, androidx.work.d dVar2, long j11, long j12, long j13, androidx.work.b bVar, int i11, BackoffPolicy backoffPolicy, long j14, long j15, long j16, long j17, boolean z11, OutOfQuotaPolicy outOfQuotaPolicy, int i12, int i13, int i14, DefaultConstructorMarker defaultConstructorMarker) {
        androidx.work.d dVar3;
        androidx.work.d dVar4;
        WorkInfo.State state2 = (i14 & 2) != 0 ? WorkInfo.State.ENQUEUED : state;
        String str4 = (i14 & 8) != 0 ? null : str3;
        if ((i14 & 16) != 0) {
            androidx.work.d EMPTY = androidx.work.d.f13305c;
            Intrinsics.f(EMPTY, "EMPTY");
            dVar3 = EMPTY;
        } else {
            dVar3 = dVar;
        }
        if ((i14 & 32) != 0) {
            androidx.work.d EMPTY2 = androidx.work.d.f13305c;
            Intrinsics.f(EMPTY2, "EMPTY");
            dVar4 = EMPTY2;
        } else {
            dVar4 = dVar2;
        }
        this(str, state2, str2, str4, dVar3, dVar4, (i14 & 64) != 0 ? 0L : j11, (i14 & 128) != 0 ? 0L : j12, (i14 & 256) != 0 ? 0L : j13, (i14 & 512) != 0 ? androidx.work.b.f13284j : bVar, (i14 & 1024) != 0 ? 0 : i11, (i14 & 2048) != 0 ? BackoffPolicy.EXPONENTIAL : backoffPolicy, (i14 & 4096) != 0 ? 30000L : j14, (i14 & 8192) != 0 ? 0L : j15, (i14 & 16384) != 0 ? 0L : j16, (32768 & i14) != 0 ? -1L : j17, (65536 & i14) != 0 ? false : z11, (131072 & i14) != 0 ? OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST : outOfQuotaPolicy, (262144 & i14) != 0 ? 0 : i12, (i14 & 524288) != 0 ? 0 : i13);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public u(String id2, String workerClassName_) {
        this(id2, null, workerClassName_, null, null, null, 0L, 0L, 0L, null, 0, null, 0L, 0L, 0L, 0L, false, null, 0, 0, 1048570, null);
        Intrinsics.g(id2, "id");
        Intrinsics.g(workerClassName_, "workerClassName_");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public u(String newId, u other) {
        this(newId, other.f76200b, other.f76201c, other.f76202d, new androidx.work.d(other.f76203e), new androidx.work.d(other.f76204f), other.f76205g, other.f76206h, other.f76207i, new androidx.work.b(other.f76208j), other.f76209k, other.f76210l, other.f76211m, other.f76212n, other.f76213o, other.f76214p, other.f76215q, other.f76216r, other.f76217s, 0, 524288, null);
        Intrinsics.g(newId, "newId");
        Intrinsics.g(other, "other");
    }

    public static final List b(List list) {
        if (list == null) {
            return null;
        }
        List list2 = list;
        ArrayList arrayList = new ArrayList(kotlin.collections.h.v(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((c) it.next()).a());
        }
        return arrayList;
    }

    public final long c() {
        if (i()) {
            return this.f76212n + kotlin.ranges.a.h(this.f76210l == BackoffPolicy.LINEAR ? this.f76211m * ((long) this.f76209k) : (long) Math.scalb(this.f76211m, this.f76209k - 1), 18000000L);
        }
        long j11 = 0;
        if (!j()) {
            long jCurrentTimeMillis = this.f76212n;
            if (jCurrentTimeMillis == 0) {
                jCurrentTimeMillis = System.currentTimeMillis();
            }
            return jCurrentTimeMillis + this.f76205g;
        }
        int i11 = this.f76217s;
        long j12 = this.f76212n;
        if (i11 == 0) {
            j12 += this.f76205g;
        }
        long j13 = this.f76207i;
        long j14 = this.f76206h;
        if (j13 != j14) {
            j11 = i11 == 0 ? ((long) (-1)) * j13 : 0L;
            j12 += j14;
        } else if (i11 != 0) {
            j11 = j14;
        }
        return j12 + j11;
    }

    public final u d(String id2, WorkInfo.State state, String workerClassName, String str, androidx.work.d input, androidx.work.d output, long j11, long j12, long j13, androidx.work.b constraints, int i11, BackoffPolicy backoffPolicy, long j14, long j15, long j16, long j17, boolean z11, OutOfQuotaPolicy outOfQuotaPolicy, int i12, int i13) {
        Intrinsics.g(id2, "id");
        Intrinsics.g(state, "state");
        Intrinsics.g(workerClassName, "workerClassName");
        Intrinsics.g(input, "input");
        Intrinsics.g(output, "output");
        Intrinsics.g(constraints, "constraints");
        Intrinsics.g(backoffPolicy, "backoffPolicy");
        Intrinsics.g(outOfQuotaPolicy, "outOfQuotaPolicy");
        return new u(id2, state, workerClassName, str, input, output, j11, j12, j13, constraints, i11, backoffPolicy, j14, j15, j16, j17, z11, outOfQuotaPolicy, i12, i13);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return Intrinsics.b(this.f76199a, uVar.f76199a) && this.f76200b == uVar.f76200b && Intrinsics.b(this.f76201c, uVar.f76201c) && Intrinsics.b(this.f76202d, uVar.f76202d) && Intrinsics.b(this.f76203e, uVar.f76203e) && Intrinsics.b(this.f76204f, uVar.f76204f) && this.f76205g == uVar.f76205g && this.f76206h == uVar.f76206h && this.f76207i == uVar.f76207i && Intrinsics.b(this.f76208j, uVar.f76208j) && this.f76209k == uVar.f76209k && this.f76210l == uVar.f76210l && this.f76211m == uVar.f76211m && this.f76212n == uVar.f76212n && this.f76213o == uVar.f76213o && this.f76214p == uVar.f76214p && this.f76215q == uVar.f76215q && this.f76216r == uVar.f76216r && this.f76217s == uVar.f76217s && this.f76218t == uVar.f76218t;
    }

    public final int f() {
        return this.f76218t;
    }

    public final int g() {
        return this.f76217s;
    }

    public final boolean h() {
        return !Intrinsics.b(androidx.work.b.f13284j, this.f76208j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v33, types: [int] */
    /* JADX WARN: Type inference failed for: r1v31, types: [int] */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v38 */
    public int hashCode() {
        int iHashCode = ((((this.f76199a.hashCode() * 31) + this.f76200b.hashCode()) * 31) + this.f76201c.hashCode()) * 31;
        String str = this.f76202d;
        int iHashCode2 = (((((((((((((((((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f76203e.hashCode()) * 31) + this.f76204f.hashCode()) * 31) + l.p.a(this.f76205g)) * 31) + l.p.a(this.f76206h)) * 31) + l.p.a(this.f76207i)) * 31) + this.f76208j.hashCode()) * 31) + this.f76209k) * 31) + this.f76210l.hashCode()) * 31) + l.p.a(this.f76211m)) * 31) + l.p.a(this.f76212n)) * 31) + l.p.a(this.f76213o)) * 31) + l.p.a(this.f76214p)) * 31;
        boolean z11 = this.f76215q;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return ((((((iHashCode2 + r11) * 31) + this.f76216r.hashCode()) * 31) + this.f76217s) * 31) + this.f76218t;
    }

    public final boolean i() {
        return this.f76200b == WorkInfo.State.ENQUEUED && this.f76209k > 0;
    }

    public final boolean j() {
        return this.f76206h != 0;
    }

    public final void k(long j11) {
        if (j11 < 900000) {
            androidx.work.j.e().k(f76197v, "Interval duration lesser than minimum allowed value; Changed to 900000");
        }
        l(kotlin.ranges.a.e(j11, 900000L), kotlin.ranges.a.e(j11, 900000L));
    }

    public final void l(long j11, long j12) {
        if (j11 < 900000) {
            androidx.work.j.e().k(f76197v, "Interval duration lesser than minimum allowed value; Changed to 900000");
        }
        this.f76206h = kotlin.ranges.a.e(j11, 900000L);
        if (j12 < 300000) {
            androidx.work.j.e().k(f76197v, "Flex duration lesser than minimum allowed value; Changed to 300000");
        }
        if (j12 > this.f76206h) {
            androidx.work.j.e().k(f76197v, "Flex duration greater than interval duration; Changed to " + j11);
        }
        this.f76207i = kotlin.ranges.a.l(j12, 300000L, this.f76206h);
    }

    public String toString() {
        return "{WorkSpec: " + this.f76199a + '}';
    }
}
