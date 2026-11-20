package androidx.media3.exoplayer.source;

import androidx.annotation.Nullable;
import androidx.media3.common.n0;
import androidx.media3.common.y;
import androidx.media3.exoplayer.b3;
import androidx.media3.exoplayer.w1;
import com.google.common.collect.Lists;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import p4.e0;
import p4.k0;
import s4.z;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n implements k, k.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k[] f11219a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p4.d f11221c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public k.a f11224g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public k0 f11225h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public t f11227j;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<k> f11222d = new ArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<n0, n0> f11223f = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IdentityHashMap<e0, Integer> f11220b = new IdentityHashMap<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public k[] f11226i = new k[0];

    /* JADX INFO: compiled from: source.java */
    public static final class a implements z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final z f11228a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final n0 f11229b;

        public a(z zVar, n0 n0Var) {
            this.f11228a = zVar;
            this.f11229b = n0Var;
        }

        @Override // s4.z
        public void a() {
            this.f11228a.a();
        }

        @Override // s4.z
        public void b(boolean z11) {
            this.f11228a.b(z11);
        }

        @Override // s4.z
        public void c() {
            this.f11228a.c();
        }

        @Override // s4.z
        public boolean d(int i11, long j11) {
            return this.f11228a.d(i11, j11);
        }

        @Override // s4.z
        public void disable() {
            this.f11228a.disable();
        }

        @Override // s4.c0
        public int e(y yVar) {
            return this.f11228a.indexOf(this.f11229b.b(yVar));
        }

        @Override // s4.z
        public void enable() {
            this.f11228a.enable();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f11228a.equals(aVar.f11228a) && this.f11229b.equals(aVar.f11229b);
        }

        @Override // s4.z
        public int evaluateQueueSize(long j11, List<? extends q4.m> list) {
            return this.f11228a.evaluateQueueSize(j11, list);
        }

        @Override // s4.z
        public boolean f(int i11, long j11) {
            return this.f11228a.f(i11, j11);
        }

        @Override // s4.z
        public boolean g(long j11, q4.e eVar, List<? extends q4.m> list) {
            return this.f11228a.g(j11, eVar, list);
        }

        @Override // s4.c0
        public y getFormat(int i11) {
            return this.f11229b.a(this.f11228a.getIndexInTrackGroup(i11));
        }

        @Override // s4.c0
        public int getIndexInTrackGroup(int i11) {
            return this.f11228a.getIndexInTrackGroup(i11);
        }

        @Override // s4.z
        public y getSelectedFormat() {
            return this.f11229b.a(this.f11228a.getSelectedIndexInTrackGroup());
        }

        @Override // s4.z
        public int getSelectedIndex() {
            return this.f11228a.getSelectedIndex();
        }

        @Override // s4.z
        public int getSelectedIndexInTrackGroup() {
            return this.f11228a.getSelectedIndexInTrackGroup();
        }

        @Override // s4.z
        @Nullable
        public Object getSelectionData() {
            return this.f11228a.getSelectionData();
        }

        @Override // s4.z
        public int getSelectionReason() {
            return this.f11228a.getSelectionReason();
        }

        @Override // s4.c0
        public n0 getTrackGroup() {
            return this.f11229b;
        }

        @Override // s4.z
        public void h(long j11, long j12, long j13, List<? extends q4.m> list, q4.n[] nVarArr) {
            this.f11228a.h(j11, j12, j13, list, nVarArr);
        }

        public int hashCode() {
            return ((527 + this.f11229b.hashCode()) * 31) + this.f11228a.hashCode();
        }

        @Override // s4.c0
        public int indexOf(int i11) {
            return this.f11228a.indexOf(i11);
        }

        @Override // s4.c0
        public int length() {
            return this.f11228a.length();
        }

        @Override // s4.z
        public void onPlaybackSpeed(float f11) {
            this.f11228a.onPlaybackSpeed(f11);
        }
    }

    public n(p4.d dVar, long[] jArr, k... kVarArr) {
        this.f11221c = dVar;
        this.f11219a = kVarArr;
        this.f11227j = dVar.b();
        for (int i11 = 0; i11 < kVarArr.length; i11++) {
            long j11 = jArr[i11];
            if (j11 != 0) {
                this.f11219a[i11] = new w(kVarArr[i11], j11);
            }
        }
    }

    public static /* synthetic */ List j(k kVar) {
        return kVar.getTrackGroups().c();
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public boolean a(w1 w1Var) {
        if (this.f11222d.isEmpty()) {
            return this.f11227j.a(w1Var);
        }
        int size = this.f11222d.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f11222d.get(i11).a(w1Var);
        }
        return false;
    }

    @Override // androidx.media3.exoplayer.source.k
    public long b(long j11, b3 b3Var) {
        k[] kVarArr = this.f11226i;
        return (kVarArr.length > 0 ? kVarArr[0] : this.f11219a[0]).b(j11, b3Var);
    }

    @Override // androidx.media3.exoplayer.source.k
    public void discardBuffer(long j11, boolean z11) {
        for (k kVar : this.f11226i) {
            kVar.discardBuffer(j11, z11);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.exoplayer.source.k
    public long e(z[] zVarArr, boolean[] zArr, e0[] e0VarArr, boolean[] zArr2, long j11) {
        Integer num;
        int[] iArr = new int[zVarArr.length];
        int[] iArr2 = new int[zVarArr.length];
        int i11 = 0;
        while (true) {
            num = null;
            if (i11 >= zVarArr.length) {
                break;
            }
            e0 e0Var = e0VarArr[i11];
            num = e0Var != null ? this.f11220b.get(e0Var) : null;
            iArr[i11] = num == null ? -1 : num.intValue();
            z zVar = zVarArr[i11];
            if (zVar != null) {
                String str = zVar.getTrackGroup().f9331b;
                iArr2[i11] = Integer.parseInt(str.substring(0, str.indexOf(":")));
            } else {
                iArr2[i11] = -1;
            }
            i11++;
        }
        this.f11220b.clear();
        int length = zVarArr.length;
        e0[] e0VarArr2 = new e0[length];
        e0[] e0VarArr3 = new e0[zVarArr.length];
        Object[] objArr = new z[zVarArr.length];
        ArrayList arrayList = new ArrayList(this.f11219a.length);
        long j12 = j11;
        int i12 = 0;
        while (i12 < this.f11219a.length) {
            for (int i13 = 0; i13 < zVarArr.length; i13++) {
                e0VarArr3[i13] = iArr[i13] == i12 ? e0VarArr[i13] : num;
                if (iArr2[i13] == i12) {
                    z zVar2 = (z) z3.a.e(zVarArr[i13]);
                    objArr[i13] = new a(zVar2, (n0) z3.a.e(this.f11223f.get(zVar2.getTrackGroup())));
                } else {
                    objArr[i13] = num;
                }
            }
            int i14 = i12;
            ArrayList arrayList2 = arrayList;
            Object[] objArr2 = objArr;
            long jE = this.f11219a[i12].e(objArr, zArr, e0VarArr3, zArr2, j12);
            if (i14 == 0) {
                j12 = jE;
            } else if (jE != j12) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z11 = false;
            for (int i15 = 0; i15 < zVarArr.length; i15++) {
                if (iArr2[i15] == i14) {
                    e0 e0Var2 = (e0) z3.a.e(e0VarArr3[i15]);
                    e0VarArr2[i15] = e0VarArr3[i15];
                    this.f11220b.put(e0Var2, Integer.valueOf(i14));
                    z11 = true;
                } else if (iArr[i15] == i14) {
                    z3.a.g(e0VarArr3[i15] == 0);
                }
            }
            if (z11) {
                arrayList2.add(this.f11219a[i14]);
            }
            i12 = i14 + 1;
            arrayList = arrayList2;
            objArr = objArr2;
            num = null;
        }
        ArrayList arrayList3 = arrayList;
        System.arraycopy(e0VarArr2, 0, e0VarArr, 0, length);
        this.f11226i = (k[]) arrayList3.toArray(new k[0]);
        this.f11227j = this.f11221c.a(arrayList3, Lists.o(arrayList3, new com.google.common.base.f() { // from class: p4.x
            @Override // com.google.common.base.f
            public final Object apply(Object obj) {
                return androidx.media3.exoplayer.source.n.j((androidx.media3.exoplayer.source.k) obj);
            }
        }));
        return j12;
    }

    @Override // androidx.media3.exoplayer.source.k.a
    public void f(k kVar) {
        this.f11222d.remove(kVar);
        if (!this.f11222d.isEmpty()) {
            return;
        }
        int i11 = 0;
        for (k kVar2 : this.f11219a) {
            i11 += kVar2.getTrackGroups().f73574a;
        }
        n0[] n0VarArr = new n0[i11];
        int i12 = 0;
        int i13 = 0;
        while (true) {
            k[] kVarArr = this.f11219a;
            if (i12 >= kVarArr.length) {
                this.f11225h = new k0(n0VarArr);
                ((k.a) z3.a.e(this.f11224g)).f(this);
                return;
            }
            k0 trackGroups = kVarArr[i12].getTrackGroups();
            int i14 = trackGroups.f73574a;
            int i15 = 0;
            while (i15 < i14) {
                n0 n0VarB = trackGroups.b(i15);
                y[] yVarArr = new y[n0VarB.f9330a];
                for (int i16 = 0; i16 < n0VarB.f9330a; i16++) {
                    y yVarA = n0VarB.a(i16);
                    y.b bVarB = yVarA.b();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i12);
                    sb2.append(":");
                    String str = yVarA.f9489a;
                    if (str == null) {
                        str = "";
                    }
                    sb2.append(str);
                    yVarArr[i16] = bVarB.X(sb2.toString()).I();
                }
                n0 n0Var = new n0(i12 + ":" + n0VarB.f9331b, yVarArr);
                this.f11223f.put(n0Var, n0VarB);
                n0VarArr[i13] = n0Var;
                i15++;
                i13++;
            }
            i12++;
        }
    }

    @Override // androidx.media3.exoplayer.source.k
    public void g(k.a aVar, long j11) {
        this.f11224g = aVar;
        Collections.addAll(this.f11222d, this.f11219a);
        for (k kVar : this.f11219a) {
            kVar.g(this, j11);
        }
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public long getBufferedPositionUs() {
        return this.f11227j.getBufferedPositionUs();
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public long getNextLoadPositionUs() {
        return this.f11227j.getNextLoadPositionUs();
    }

    @Override // androidx.media3.exoplayer.source.k
    public k0 getTrackGroups() {
        return (k0) z3.a.e(this.f11225h);
    }

    public k i(int i11) {
        k kVar = this.f11219a[i11];
        return kVar instanceof w ? ((w) kVar).c() : kVar;
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public boolean isLoading() {
        return this.f11227j.isLoading();
    }

    @Override // androidx.media3.exoplayer.source.t.a
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public void h(k kVar) {
        ((k.a) z3.a.e(this.f11224g)).h(this);
    }

    @Override // androidx.media3.exoplayer.source.k
    public void maybeThrowPrepareError() throws IOException {
        for (k kVar : this.f11219a) {
            kVar.maybeThrowPrepareError();
        }
    }

    @Override // androidx.media3.exoplayer.source.k
    public long readDiscontinuity() {
        long j11 = -9223372036854775807L;
        for (k kVar : this.f11226i) {
            long discontinuity = kVar.readDiscontinuity();
            if (discontinuity == C.TIME_UNSET) {
                if (j11 != C.TIME_UNSET && kVar.seekToUs(j11) != j11) {
                    throw new IllegalStateException("Unexpected child seekToUs result.");
                }
            } else if (j11 == C.TIME_UNSET) {
                for (k kVar2 : this.f11226i) {
                    if (kVar2 == kVar) {
                        break;
                    }
                    if (kVar2.seekToUs(discontinuity) != discontinuity) {
                        throw new IllegalStateException("Unexpected child seekToUs result.");
                    }
                }
                j11 = discontinuity;
            } else if (discontinuity != j11) {
                throw new IllegalStateException("Conflicting discontinuities.");
            }
        }
        return j11;
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public void reevaluateBuffer(long j11) {
        this.f11227j.reevaluateBuffer(j11);
    }

    @Override // androidx.media3.exoplayer.source.k
    public long seekToUs(long j11) {
        long jSeekToUs = this.f11226i[0].seekToUs(j11);
        int i11 = 1;
        while (true) {
            k[] kVarArr = this.f11226i;
            if (i11 >= kVarArr.length) {
                return jSeekToUs;
            }
            if (kVarArr[i11].seekToUs(jSeekToUs) != jSeekToUs) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
            i11++;
        }
    }
}
