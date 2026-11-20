package tg;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f77080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f77081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f77082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f77083d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f77084e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f77085f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f77086g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f77087h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f77088i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f77089j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final a f77090k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public final Metadata f77091l;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f77092a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f77093b;

        public a(long[] jArr, long[] jArr2) {
            this.f77092a = jArr;
            this.f77093b = jArr2;
        }
    }

    public v(int i11, int i12, int i13, int i14, int i15, int i16, int i17, long j11, @Nullable a aVar, @Nullable Metadata metadata) {
        this.f77080a = i11;
        this.f77081b = i12;
        this.f77082c = i13;
        this.f77083d = i14;
        this.f77084e = i15;
        this.f77085f = j(i15);
        this.f77086g = i16;
        this.f77087h = i17;
        this.f77088i = e(i17);
        this.f77089j = j11;
        this.f77090k = aVar;
        this.f77091l = metadata;
    }

    public v(byte[] bArr, int i11) {
        com.google.android.exoplayer2.util.b0 b0Var = new com.google.android.exoplayer2.util.b0(bArr);
        b0Var.p(i11 * 8);
        this.f77080a = b0Var.h(16);
        this.f77081b = b0Var.h(16);
        this.f77082c = b0Var.h(24);
        this.f77083d = b0Var.h(24);
        int iH = b0Var.h(20);
        this.f77084e = iH;
        this.f77085f = j(iH);
        this.f77086g = b0Var.h(3) + 1;
        int iH2 = b0Var.h(5) + 1;
        this.f77087h = iH2;
        this.f77088i = e(iH2);
        this.f77089j = b0Var.j(36);
        this.f77090k = null;
        this.f77091l = null;
    }

    public static int e(int i11) {
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

    public static int j(int i11) {
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

    public v a(List<PictureFrame> list) {
        return new v(this.f77080a, this.f77081b, this.f77082c, this.f77083d, this.f77084e, this.f77086g, this.f77087h, this.f77089j, this.f77090k, h(new Metadata(list)));
    }

    public v b(@Nullable a aVar) {
        return new v(this.f77080a, this.f77081b, this.f77082c, this.f77083d, this.f77084e, this.f77086g, this.f77087h, this.f77089j, aVar, this.f77091l);
    }

    public v c(List<String> list) {
        return new v(this.f77080a, this.f77081b, this.f77082c, this.f77083d, this.f77084e, this.f77086g, this.f77087h, this.f77089j, this.f77090k, h(h0.c(list)));
    }

    public long d() {
        long j11;
        long j12;
        int i11 = this.f77083d;
        if (i11 > 0) {
            j11 = (((long) i11) + ((long) this.f77082c)) / 2;
            j12 = 1;
        } else {
            int i12 = this.f77080a;
            j11 = ((((i12 != this.f77081b || i12 <= 0) ? PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM : i12) * ((long) this.f77086g)) * ((long) this.f77087h)) / 8;
            j12 = 64;
        }
        return j11 + j12;
    }

    public long f() {
        long j11 = this.f77089j;
        return j11 == 0 ? C.TIME_UNSET : (j11 * 1000000) / ((long) this.f77084e);
    }

    public m1 g(byte[] bArr, @Nullable Metadata metadata) {
        bArr[4] = -128;
        int i11 = this.f77083d;
        if (i11 <= 0) {
            i11 = -1;
        }
        return new m1.b().e0(MimeTypes.AUDIO_FLAC).W(i11).H(this.f77086g).f0(this.f77084e).T(Collections.singletonList(bArr)).X(h(metadata)).E();
    }

    @Nullable
    public Metadata h(@Nullable Metadata metadata) {
        Metadata metadata2 = this.f77091l;
        return metadata2 == null ? metadata : metadata2.copyWithAppendedEntriesFrom(metadata);
    }

    public long i(long j11) {
        return o0.r((j11 * ((long) this.f77084e)) / 1000000, 0L, this.f77089j - 1);
    }
}
