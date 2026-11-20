package yg;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f81335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a> f81336b;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f81337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f81338b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f81339c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f81340d;

        public a(String str, String str2, long j11, long j12) {
            this.f81337a = str;
            this.f81338b = str2;
            this.f81339c = j11;
            this.f81340d = j12;
        }
    }

    public b(long j11, List<a> list) {
        this.f81335a = j11;
        this.f81336b = list;
    }

    @Nullable
    public MotionPhotoMetadata a(long j11) {
        long j12;
        if (this.f81336b.size() < 2) {
            return null;
        }
        long j13 = j11;
        long j14 = -1;
        long j15 = -1;
        long j16 = -1;
        long j17 = -1;
        boolean z11 = false;
        for (int size = this.f81336b.size() - 1; size >= 0; size--) {
            a aVar = this.f81336b.get(size);
            boolean zEquals = MimeTypes.VIDEO_MP4.equals(aVar.f81337a) | z11;
            if (size == 0) {
                j13 -= aVar.f81340d;
                j12 = 0;
            } else {
                j12 = j13 - aVar.f81339c;
            }
            long j18 = j13;
            j13 = j12;
            if (!zEquals || j13 == j18) {
                z11 = zEquals;
            } else {
                j17 = j18 - j13;
                j16 = j13;
                z11 = false;
            }
            if (size == 0) {
                j14 = j13;
                j15 = j18;
            }
        }
        if (j16 == -1 || j17 == -1 || j14 == -1 || j15 == -1) {
            return null;
        }
        return new MotionPhotoMetadata(j14, j15, this.f81335a, j16, j17);
    }
}
