package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
import androidx.annotation.Nullable;
import bh.p;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.offline.c;
import com.google.android.exoplayer2.util.m0;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a implements c<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f34742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f34743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f34744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f34745d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final C0371a f34746e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b[] f34747f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f34748g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f34749h;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.source.smoothstreaming.manifest.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0371a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UUID f34750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f34751b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final p[] f34752c;

        public C0371a(UUID uuid, byte[] bArr, p[] pVarArr) {
            this.f34750a = uuid;
            this.f34751b = bArr;
            this.f34752c = pVarArr;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f34753a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f34754b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f34755c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f34756d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f34757e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f34758f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f34759g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f34760h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Nullable
        public final String f34761i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final m1[] f34762j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f34763k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final String f34764l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final String f34765m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final List<Long> f34766n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final long[] f34767o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final long f34768p;

        public b(String str, String str2, int i11, String str3, long j11, String str4, int i12, int i13, int i14, int i15, @Nullable String str5, m1[] m1VarArr, List<Long> list, long j12) {
            this(str, str2, i11, str3, j11, str4, i12, i13, i14, i15, str5, m1VarArr, list, o0.P0(list, 1000000L, j11), o0.O0(j12, 1000000L, j11));
        }

        public b(String str, String str2, int i11, String str3, long j11, String str4, int i12, int i13, int i14, int i15, @Nullable String str5, m1[] m1VarArr, List<Long> list, long[] jArr, long j12) {
            this.f34764l = str;
            this.f34765m = str2;
            this.f34753a = i11;
            this.f34754b = str3;
            this.f34755c = j11;
            this.f34756d = str4;
            this.f34757e = i12;
            this.f34758f = i13;
            this.f34759g = i14;
            this.f34760h = i15;
            this.f34761i = str5;
            this.f34762j = m1VarArr;
            this.f34766n = list;
            this.f34767o = jArr;
            this.f34768p = j12;
            this.f34763k = list.size();
        }

        public Uri a(int i11, int i12) {
            com.google.android.exoplayer2.util.a.g(this.f34762j != null);
            com.google.android.exoplayer2.util.a.g(this.f34766n != null);
            com.google.android.exoplayer2.util.a.g(i12 < this.f34766n.size());
            String string = Integer.toString(this.f34762j[i11].f33441i);
            String string2 = this.f34766n.get(i12).toString();
            return m0.e(this.f34764l, this.f34765m.replace("{bitrate}", string).replace("{Bitrate}", string).replace("{start time}", string2).replace("{start_time}", string2));
        }

        public b b(m1[] m1VarArr) {
            return new b(this.f34764l, this.f34765m, this.f34753a, this.f34754b, this.f34755c, this.f34756d, this.f34757e, this.f34758f, this.f34759g, this.f34760h, this.f34761i, m1VarArr, this.f34766n, this.f34767o, this.f34768p);
        }

        public long c(int i11) {
            if (i11 == this.f34763k - 1) {
                return this.f34768p;
            }
            long[] jArr = this.f34767o;
            return jArr[i11 + 1] - jArr[i11];
        }

        public int d(long j11) {
            return o0.i(this.f34767o, j11, true, true);
        }

        public long e(int i11) {
            return this.f34767o[i11];
        }
    }

    public a(int i11, int i12, long j11, long j12, int i13, boolean z11, @Nullable C0371a c0371a, b[] bVarArr) {
        this.f34742a = i11;
        this.f34743b = i12;
        this.f34748g = j11;
        this.f34749h = j12;
        this.f34744c = i13;
        this.f34745d = z11;
        this.f34746e = c0371a;
        this.f34747f = bVarArr;
    }

    public a(int i11, int i12, long j11, long j12, long j13, int i13, boolean z11, @Nullable C0371a c0371a, b[] bVarArr) {
        this(i11, i12, j12 == 0 ? -9223372036854775807L : o0.O0(j12, 1000000L, j11), j13 != 0 ? o0.O0(j13, 1000000L, j11) : C.TIME_UNSET, i13, z11, c0371a, bVarArr);
    }

    @Override // com.google.android.exoplayer2.offline.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final a copy(List<StreamKey> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        b bVar = null;
        int i11 = 0;
        while (i11 < arrayList.size()) {
            StreamKey streamKey = (StreamKey) arrayList.get(i11);
            b bVar2 = this.f34747f[streamKey.groupIndex];
            if (bVar2 != bVar && bVar != null) {
                arrayList2.add(bVar.b((m1[]) arrayList3.toArray(new m1[0])));
                arrayList3.clear();
            }
            arrayList3.add(bVar2.f34762j[streamKey.streamIndex]);
            i11++;
            bVar = bVar2;
        }
        if (bVar != null) {
            arrayList2.add(bVar.b((m1[]) arrayList3.toArray(new m1[0])));
        }
        return new a(this.f34742a, this.f34743b, this.f34748g, this.f34749h, this.f34744c, this.f34745d, this.f34746e, (b[]) arrayList2.toArray(new b[0]));
    }
}
