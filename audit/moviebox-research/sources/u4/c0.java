package u4;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import androidx.media3.common.Metadata;
import androidx.media3.extractor.metadata.flac.PictureFrame;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f78219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f78220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f78221c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f78222d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f78223e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f78224f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f78225g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f78226h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f78227i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f78228j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final a f78229k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public final Metadata f78230l;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f78231a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f78232b;

        public a(long[] jArr, long[] jArr2) {
            this.f78231a = jArr;
            this.f78232b = jArr2;
        }
    }

    public c0(int i11, int i12, int i13, int i14, int i15, int i16, int i17, long j11, @Nullable a aVar, @Nullable Metadata metadata) {
        this.f78219a = i11;
        this.f78220b = i12;
        this.f78221c = i13;
        this.f78222d = i14;
        this.f78223e = i15;
        this.f78224f = j(i15);
        this.f78225g = i16;
        this.f78226h = i17;
        this.f78227i = e(i17);
        this.f78228j = j11;
        this.f78229k = aVar;
        this.f78230l = metadata;
    }

    public c0(byte[] bArr, int i11) {
        z3.b0 b0Var = new z3.b0(bArr);
        b0Var.p(i11 * 8);
        this.f78219a = b0Var.h(16);
        this.f78220b = b0Var.h(16);
        this.f78221c = b0Var.h(24);
        this.f78222d = b0Var.h(24);
        int iH = b0Var.h(20);
        this.f78223e = iH;
        this.f78224f = j(iH);
        this.f78225g = b0Var.h(3) + 1;
        int iH2 = b0Var.h(5) + 1;
        this.f78226h = iH2;
        this.f78227i = e(iH2);
        this.f78228j = b0Var.j(36);
        this.f78229k = null;
        this.f78230l = null;
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

    public c0 a(List<PictureFrame> list) {
        return new c0(this.f78219a, this.f78220b, this.f78221c, this.f78222d, this.f78223e, this.f78225g, this.f78226h, this.f78228j, this.f78229k, h(new Metadata(list)));
    }

    public c0 b(@Nullable a aVar) {
        return new c0(this.f78219a, this.f78220b, this.f78221c, this.f78222d, this.f78223e, this.f78225g, this.f78226h, this.f78228j, aVar, this.f78230l);
    }

    public c0 c(List<String> list) {
        return new c0(this.f78219a, this.f78220b, this.f78221c, this.f78222d, this.f78223e, this.f78225g, this.f78226h, this.f78228j, this.f78229k, h(u0.d(list)));
    }

    public long d() {
        long j11;
        long j12;
        int i11 = this.f78222d;
        if (i11 > 0) {
            j11 = (((long) i11) + ((long) this.f78221c)) / 2;
            j12 = 1;
        } else {
            int i12 = this.f78219a;
            j11 = ((((i12 != this.f78220b || i12 <= 0) ? PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM : i12) * ((long) this.f78225g)) * ((long) this.f78226h)) / 8;
            j12 = 64;
        }
        return j11 + j12;
    }

    public long f() {
        long j11 = this.f78228j;
        return j11 == 0 ? C.TIME_UNSET : (j11 * 1000000) / ((long) this.f78223e);
    }

    public androidx.media3.common.y g(byte[] bArr, @Nullable Metadata metadata) {
        bArr[4] = -128;
        int i11 = this.f78222d;
        if (i11 <= 0) {
            i11 = -1;
        }
        return new androidx.media3.common.y.b().k0(MimeTypes.AUDIO_FLAC).c0(i11).L(this.f78225g).l0(this.f78223e).e0(z3.u0.j0(this.f78226h)).Y(Collections.singletonList(bArr)).d0(h(metadata)).I();
    }

    @Nullable
    public Metadata h(@Nullable Metadata metadata) {
        Metadata metadata2 = this.f78230l;
        return metadata2 == null ? metadata : metadata2.copyWithAppendedEntriesFrom(metadata);
    }

    public long i(long j11) {
        return z3.u0.q((j11 * ((long) this.f78223e)) / 1000000, 0L, this.f78228j - 1);
    }
}
