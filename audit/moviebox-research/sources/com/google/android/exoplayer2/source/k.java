package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.b3;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.n1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import nh.d0;
import nh.i0;
import nh.k0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class k implements h, h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h[] f34239a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final nh.d f34241c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public h.a f34244g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public k0 f34245h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public q f34247j;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<h> f34242d = new ArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<i0, i0> f34243f = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IdentityHashMap<d0, Integer> f34240b = new IdentityHashMap<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public h[] f34246i = new h[0];

    /* JADX INFO: compiled from: source.java */
    public static final class a implements fi.s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final fi.s f34248a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final i0 f34249b;

        public a(fi.s sVar, i0 i0Var) {
            this.f34248a = sVar;
            this.f34249b = i0Var;
        }

        @Override // fi.s
        public void a() {
            this.f34248a.a();
        }

        @Override // fi.s
        public void b(boolean z11) {
            this.f34248a.b(z11);
        }

        @Override // fi.s
        public boolean blacklist(int i11, long j11) {
            return this.f34248a.blacklist(i11, j11);
        }

        @Override // fi.s
        public void c() {
            this.f34248a.c();
        }

        @Override // fi.s
        public void d(long j11, long j12, long j13, List<? extends ph.n> list, ph.o[] oVarArr) {
            this.f34248a.d(j11, j12, j13, list, oVarArr);
        }

        @Override // fi.s
        public void disable() {
            this.f34248a.disable();
        }

        @Override // fi.s
        public boolean e(int i11, long j11) {
            return this.f34248a.e(i11, j11);
        }

        @Override // fi.s
        public void enable() {
            this.f34248a.enable();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f34248a.equals(aVar.f34248a) && this.f34249b.equals(aVar.f34249b);
        }

        @Override // fi.s
        public int evaluateQueueSize(long j11, List<? extends ph.n> list) {
            return this.f34248a.evaluateQueueSize(j11, list);
        }

        @Override // fi.s
        public boolean f(long j11, ph.f fVar, List<? extends ph.n> list) {
            return this.f34248a.f(j11, fVar, list);
        }

        @Override // fi.v
        public int g(m1 m1Var) {
            return this.f34248a.g(m1Var);
        }

        @Override // fi.v
        public m1 getFormat(int i11) {
            return this.f34248a.getFormat(i11);
        }

        @Override // fi.v
        public int getIndexInTrackGroup(int i11) {
            return this.f34248a.getIndexInTrackGroup(i11);
        }

        @Override // fi.s
        public m1 getSelectedFormat() {
            return this.f34248a.getSelectedFormat();
        }

        @Override // fi.s
        public int getSelectedIndex() {
            return this.f34248a.getSelectedIndex();
        }

        @Override // fi.s
        public int getSelectedIndexInTrackGroup() {
            return this.f34248a.getSelectedIndexInTrackGroup();
        }

        @Override // fi.s
        @Nullable
        public Object getSelectionData() {
            return this.f34248a.getSelectionData();
        }

        @Override // fi.s
        public int getSelectionReason() {
            return this.f34248a.getSelectionReason();
        }

        @Override // fi.v
        public i0 getTrackGroup() {
            return this.f34249b;
        }

        public int hashCode() {
            return ((527 + this.f34249b.hashCode()) * 31) + this.f34248a.hashCode();
        }

        @Override // fi.v
        public int indexOf(int i11) {
            return this.f34248a.indexOf(i11);
        }

        @Override // fi.v
        public int length() {
            return this.f34248a.length();
        }

        @Override // fi.s
        public void onPlaybackSpeed(float f11) {
            this.f34248a.onPlaybackSpeed(f11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements h, h.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h f34250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f34251b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public h.a f34252c;

        public b(h hVar, long j11) {
            this.f34250a = hVar;
            this.f34251b = j11;
        }

        @Override // com.google.android.exoplayer2.source.h
        public long a(long j11, b3 b3Var) {
            return this.f34250a.a(j11 - this.f34251b, b3Var) + this.f34251b;
        }

        @Override // com.google.android.exoplayer2.source.q.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void g(h hVar) {
            ((h.a) com.google.android.exoplayer2.util.a.e(this.f34252c)).g(this);
        }

        @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
        public boolean continueLoading(long j11) {
            return this.f34250a.continueLoading(j11 - this.f34251b);
        }

        @Override // com.google.android.exoplayer2.source.h
        public void discardBuffer(long j11, boolean z11) {
            this.f34250a.discardBuffer(j11 - this.f34251b, z11);
        }

        @Override // com.google.android.exoplayer2.source.h
        public long e(fi.s[] sVarArr, boolean[] zArr, d0[] d0VarArr, boolean[] zArr2, long j11) {
            d0[] d0VarArr2 = new d0[d0VarArr.length];
            int i11 = 0;
            while (true) {
                d0 d0VarA = null;
                if (i11 >= d0VarArr.length) {
                    break;
                }
                c cVar = (c) d0VarArr[i11];
                if (cVar != null) {
                    d0VarA = cVar.a();
                }
                d0VarArr2[i11] = d0VarA;
                i11++;
            }
            long jE = this.f34250a.e(sVarArr, zArr, d0VarArr2, zArr2, j11 - this.f34251b);
            for (int i12 = 0; i12 < d0VarArr.length; i12++) {
                d0 d0Var = d0VarArr2[i12];
                if (d0Var == null) {
                    d0VarArr[i12] = null;
                } else {
                    d0 d0Var2 = d0VarArr[i12];
                    if (d0Var2 == null || ((c) d0Var2).a() != d0Var) {
                        d0VarArr[i12] = new c(d0Var, this.f34251b);
                    }
                }
            }
            return jE + this.f34251b;
        }

        @Override // com.google.android.exoplayer2.source.h
        public void f(h.a aVar, long j11) {
            this.f34252c = aVar;
            this.f34250a.f(this, j11 - this.f34251b);
        }

        @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
        public long getBufferedPositionUs() {
            long bufferedPositionUs = this.f34250a.getBufferedPositionUs();
            if (bufferedPositionUs == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            return this.f34251b + bufferedPositionUs;
        }

        @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
        public long getNextLoadPositionUs() {
            long nextLoadPositionUs = this.f34250a.getNextLoadPositionUs();
            if (nextLoadPositionUs == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            return this.f34251b + nextLoadPositionUs;
        }

        @Override // com.google.android.exoplayer2.source.h
        public k0 getTrackGroups() {
            return this.f34250a.getTrackGroups();
        }

        @Override // com.google.android.exoplayer2.source.h.a
        public void h(h hVar) {
            ((h.a) com.google.android.exoplayer2.util.a.e(this.f34252c)).h(this);
        }

        @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
        public boolean isLoading() {
            return this.f34250a.isLoading();
        }

        @Override // com.google.android.exoplayer2.source.h
        public void maybeThrowPrepareError() throws IOException {
            this.f34250a.maybeThrowPrepareError();
        }

        @Override // com.google.android.exoplayer2.source.h
        public long readDiscontinuity() {
            long discontinuity = this.f34250a.readDiscontinuity();
            return discontinuity == C.TIME_UNSET ? C.TIME_UNSET : this.f34251b + discontinuity;
        }

        @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
        public void reevaluateBuffer(long j11) {
            this.f34250a.reevaluateBuffer(j11 - this.f34251b);
        }

        @Override // com.google.android.exoplayer2.source.h
        public long seekToUs(long j11) {
            return this.f34250a.seekToUs(j11 - this.f34251b) + this.f34251b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d0 f34253a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f34254b;

        public c(d0 d0Var, long j11) {
            this.f34253a = d0Var;
            this.f34254b = j11;
        }

        public d0 a() {
            return this.f34253a;
        }

        @Override // nh.d0
        public int b(n1 n1Var, DecoderInputBuffer decoderInputBuffer, int i11) {
            int iB = this.f34253a.b(n1Var, decoderInputBuffer, i11);
            if (iB == -4) {
                decoderInputBuffer.f33032f = Math.max(0L, decoderInputBuffer.f33032f + this.f34254b);
            }
            return iB;
        }

        @Override // nh.d0
        public boolean isReady() {
            return this.f34253a.isReady();
        }

        @Override // nh.d0
        public void maybeThrowError() throws IOException {
            this.f34253a.maybeThrowError();
        }

        @Override // nh.d0
        public int skipData(long j11) {
            return this.f34253a.skipData(j11 - this.f34254b);
        }
    }

    public k(nh.d dVar, long[] jArr, h... hVarArr) {
        this.f34241c = dVar;
        this.f34239a = hVarArr;
        this.f34247j = dVar.a(new q[0]);
        for (int i11 = 0; i11 < hVarArr.length; i11++) {
            long j11 = jArr[i11];
            if (j11 != 0) {
                this.f34239a[i11] = new b(hVarArr[i11], j11);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.h
    public long a(long j11, b3 b3Var) {
        h[] hVarArr = this.f34246i;
        return (hVarArr.length > 0 ? hVarArr[0] : this.f34239a[0]).a(j11, b3Var);
    }

    public h b(int i11) {
        h hVar = this.f34239a[i11];
        return hVar instanceof b ? ((b) hVar).f34250a : hVar;
    }

    @Override // com.google.android.exoplayer2.source.q.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void g(h hVar) {
        ((h.a) com.google.android.exoplayer2.util.a.e(this.f34244g)).g(this);
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public boolean continueLoading(long j11) {
        if (this.f34242d.isEmpty()) {
            return this.f34247j.continueLoading(j11);
        }
        int size = this.f34242d.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f34242d.get(i11).continueLoading(j11);
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.h
    public void discardBuffer(long j11, boolean z11) {
        for (h hVar : this.f34246i) {
            hVar.discardBuffer(j11, z11);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.exoplayer2.source.h
    public long e(fi.s[] sVarArr, boolean[] zArr, d0[] d0VarArr, boolean[] zArr2, long j11) {
        Integer num;
        int[] iArr = new int[sVarArr.length];
        int[] iArr2 = new int[sVarArr.length];
        int i11 = 0;
        while (true) {
            num = null;
            if (i11 >= sVarArr.length) {
                break;
            }
            d0 d0Var = d0VarArr[i11];
            num = d0Var != null ? this.f34240b.get(d0Var) : null;
            iArr[i11] = num == null ? -1 : num.intValue();
            iArr2[i11] = -1;
            fi.s sVar = sVarArr[i11];
            if (sVar != null) {
                i0 i0Var = (i0) com.google.android.exoplayer2.util.a.e(this.f34243f.get(sVar.getTrackGroup()));
                int i12 = 0;
                while (true) {
                    h[] hVarArr = this.f34239a;
                    if (i12 >= hVarArr.length) {
                        break;
                    }
                    if (hVarArr[i12].getTrackGroups().c(i0Var) != -1) {
                        iArr2[i11] = i12;
                        break;
                    }
                    i12++;
                }
            }
            i11++;
        }
        this.f34240b.clear();
        int length = sVarArr.length;
        d0[] d0VarArr2 = new d0[length];
        d0[] d0VarArr3 = new d0[sVarArr.length];
        Object[] objArr = new fi.s[sVarArr.length];
        ArrayList arrayList = new ArrayList(this.f34239a.length);
        long j12 = j11;
        int i13 = 0;
        while (i13 < this.f34239a.length) {
            for (int i14 = 0; i14 < sVarArr.length; i14++) {
                d0VarArr3[i14] = iArr[i14] == i13 ? d0VarArr[i14] : num;
                if (iArr2[i14] == i13) {
                    fi.s sVar2 = (fi.s) com.google.android.exoplayer2.util.a.e(sVarArr[i14]);
                    objArr[i14] = new a(sVar2, (i0) com.google.android.exoplayer2.util.a.e(this.f34243f.get(sVar2.getTrackGroup())));
                } else {
                    objArr[i14] = num;
                }
            }
            int i15 = i13;
            ArrayList arrayList2 = arrayList;
            Object[] objArr2 = objArr;
            long jE = this.f34239a[i13].e(objArr, zArr, d0VarArr3, zArr2, j12);
            if (i15 == 0) {
                j12 = jE;
            } else if (jE != j12) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z11 = false;
            for (int i16 = 0; i16 < sVarArr.length; i16++) {
                if (iArr2[i16] == i15) {
                    d0 d0Var2 = (d0) com.google.android.exoplayer2.util.a.e(d0VarArr3[i16]);
                    d0VarArr2[i16] = d0VarArr3[i16];
                    this.f34240b.put(d0Var2, Integer.valueOf(i15));
                    z11 = true;
                } else if (iArr[i16] == i15) {
                    com.google.android.exoplayer2.util.a.g(d0VarArr3[i16] == 0);
                }
            }
            if (z11) {
                arrayList2.add(this.f34239a[i15]);
            }
            i13 = i15 + 1;
            arrayList = arrayList2;
            objArr = objArr2;
            num = null;
        }
        System.arraycopy(d0VarArr2, 0, d0VarArr, 0, length);
        h[] hVarArr2 = (h[]) arrayList.toArray(new h[0]);
        this.f34246i = hVarArr2;
        this.f34247j = this.f34241c.a(hVarArr2);
        return j12;
    }

    @Override // com.google.android.exoplayer2.source.h
    public void f(h.a aVar, long j11) {
        this.f34244g = aVar;
        Collections.addAll(this.f34242d, this.f34239a);
        for (h hVar : this.f34239a) {
            hVar.f(this, j11);
        }
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public long getBufferedPositionUs() {
        return this.f34247j.getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public long getNextLoadPositionUs() {
        return this.f34247j.getNextLoadPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.h
    public k0 getTrackGroups() {
        return (k0) com.google.android.exoplayer2.util.a.e(this.f34245h);
    }

    @Override // com.google.android.exoplayer2.source.h.a
    public void h(h hVar) {
        this.f34242d.remove(hVar);
        if (!this.f34242d.isEmpty()) {
            return;
        }
        int i11 = 0;
        for (h hVar2 : this.f34239a) {
            i11 += hVar2.getTrackGroups().f71941a;
        }
        i0[] i0VarArr = new i0[i11];
        int i12 = 0;
        int i13 = 0;
        while (true) {
            h[] hVarArr = this.f34239a;
            if (i12 >= hVarArr.length) {
                this.f34245h = new k0(i0VarArr);
                ((h.a) com.google.android.exoplayer2.util.a.e(this.f34244g)).h(this);
                return;
            }
            k0 trackGroups = hVarArr[i12].getTrackGroups();
            int i14 = trackGroups.f71941a;
            int i15 = 0;
            while (i15 < i14) {
                i0 i0VarB = trackGroups.b(i15);
                i0 i0VarB2 = i0VarB.b(i12 + ":" + i0VarB.f71932b);
                this.f34243f.put(i0VarB2, i0VarB);
                i0VarArr[i13] = i0VarB2;
                i15++;
                i13++;
            }
            i12++;
        }
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public boolean isLoading() {
        return this.f34247j.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.h
    public void maybeThrowPrepareError() throws IOException {
        for (h hVar : this.f34239a) {
            hVar.maybeThrowPrepareError();
        }
    }

    @Override // com.google.android.exoplayer2.source.h
    public long readDiscontinuity() {
        long j11 = -9223372036854775807L;
        for (h hVar : this.f34246i) {
            long discontinuity = hVar.readDiscontinuity();
            if (discontinuity == C.TIME_UNSET) {
                if (j11 != C.TIME_UNSET && hVar.seekToUs(j11) != j11) {
                    throw new IllegalStateException("Unexpected child seekToUs result.");
                }
            } else if (j11 == C.TIME_UNSET) {
                for (h hVar2 : this.f34246i) {
                    if (hVar2 == hVar) {
                        break;
                    }
                    if (hVar2.seekToUs(discontinuity) != discontinuity) {
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

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public void reevaluateBuffer(long j11) {
        this.f34247j.reevaluateBuffer(j11);
    }

    @Override // com.google.android.exoplayer2.source.h
    public long seekToUs(long j11) {
        long jSeekToUs = this.f34246i[0].seekToUs(j11);
        int i11 = 1;
        while (true) {
            h[] hVarArr = this.f34246i;
            if (i11 >= hVarArr.length) {
                return jSeekToUs;
            }
            if (hVarArr[i11].seekToUs(jSeekToUs) != jSeekToUs) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
            i11++;
        }
    }
}
