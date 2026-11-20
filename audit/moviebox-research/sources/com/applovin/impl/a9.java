package com.applovin.impl;

import android.support.v4.media.session.PlaybackStateCompat;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f17482d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f17483e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f17484f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f17485g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f17486h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f17487i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f17488j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a f17489k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final bf f17490l;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f17491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f17492b;

        public a(long[] jArr, long[] jArr2) {
            this.f17491a = jArr;
            this.f17492b = jArr2;
        }
    }

    private a9(int i11, int i12, int i13, int i14, int i15, int i16, int i17, long j11, a aVar, bf bfVar) {
        this.f17479a = i11;
        this.f17480b = i12;
        this.f17481c = i13;
        this.f17482d = i14;
        this.f17483e = i15;
        this.f17484f = b(i15);
        this.f17485g = i16;
        this.f17486h = i17;
        this.f17487i = a(i17);
        this.f17488j = j11;
        this.f17489k = aVar;
        this.f17490l = bfVar;
    }

    public a9(byte[] bArr, int i11) {
        ah ahVar = new ah(bArr);
        ahVar.c(i11 * 8);
        this.f17479a = ahVar.a(16);
        this.f17480b = ahVar.a(16);
        this.f17481c = ahVar.a(24);
        this.f17482d = ahVar.a(24);
        int iA = ahVar.a(20);
        this.f17483e = iA;
        this.f17484f = b(iA);
        this.f17485g = ahVar.a(3) + 1;
        int iA2 = ahVar.a(5) + 1;
        this.f17486h = iA2;
        this.f17487i = a(iA2);
        this.f17488j = ahVar.b(36);
        this.f17489k = null;
        this.f17490l = null;
    }

    private static int a(int i11) {
        if (i11 == 8) {
            return 1;
        }
        if (i11 == 12) {
            return 2;
        }
        if (i11 == 16) {
            return 4;
        }
        if (i11 != 20) {
            return i11 != 24 ? -1 : 6;
        }
        return 5;
    }

    private static bf a(List list, List list2) {
        if (list.isEmpty() && list2.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            String str = (String) list.get(i11);
            String[] strArrB = xp.b(str, "=");
            if (strArrB.length != 2) {
                pc.d("FlacStreamMetadata", "Failed to parse Vorbis comment: " + str);
            } else {
                arrayList.add(new dr(strArrB[0], strArrB[1]));
            }
        }
        arrayList.addAll(list2);
        if (arrayList.isEmpty()) {
            return null;
        }
        return new bf(arrayList);
    }

    private static int b(int i11) {
        switch (i11) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    public long a() {
        long j11;
        long j12;
        int i11 = this.f17482d;
        if (i11 > 0) {
            j11 = (((long) i11) + ((long) this.f17481c)) / 2;
            j12 = 1;
        } else {
            int i12 = this.f17479a;
            j11 = ((((i12 != this.f17480b || i12 <= 0) ? PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM : i12) * ((long) this.f17485g)) * ((long) this.f17486h)) / 8;
            j12 = 64;
        }
        return j11 + j12;
    }

    public long a(long j11) {
        return xp.b((j11 * ((long) this.f17483e)) / 1000000, 0L, this.f17488j - 1);
    }

    public a9 a(a aVar) {
        return new a9(this.f17479a, this.f17480b, this.f17481c, this.f17482d, this.f17483e, this.f17485g, this.f17486h, this.f17488j, aVar, this.f17490l);
    }

    public a9 a(List list) {
        return new a9(this.f17479a, this.f17480b, this.f17481c, this.f17482d, this.f17483e, this.f17485g, this.f17486h, this.f17488j, this.f17489k, a(a(Collections.emptyList(), list)));
    }

    public bf a(bf bfVar) {
        bf bfVar2 = this.f17490l;
        return bfVar2 == null ? bfVar : bfVar2.a(bfVar);
    }

    public f9 a(byte[] bArr, bf bfVar) {
        bArr[4] = -128;
        int i11 = this.f17482d;
        if (i11 <= 0) {
            i11 = -1;
        }
        return new f9.b().f(MimeTypes.AUDIO_FLAC).i(i11).c(this.f17485g).n(this.f17483e).a(Collections.singletonList(bArr)).a(a(bfVar)).a();
    }

    public long b() {
        long j11 = this.f17488j;
        return j11 == 0 ? C.TIME_UNSET : (j11 * 1000000) / ((long) this.f17483e);
    }

    public a9 b(List list) {
        return new a9(this.f17479a, this.f17480b, this.f17481c, this.f17482d, this.f17483e, this.f17485g, this.f17486h, this.f17488j, this.f17489k, a(a(list, Collections.emptyList())));
    }
}
