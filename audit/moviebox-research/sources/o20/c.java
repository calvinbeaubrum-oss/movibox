package o20;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f72275a = new byte[4096];

    public static int a(InputStream inputStream, byte[] bArr) throws IOException {
        return b(inputStream, bArr, 0, bArr.length);
    }

    public static int b(InputStream inputStream, byte[] bArr, int i11, int i12) throws IOException {
        if (i12 < 0 || i11 < 0 || i12 + i11 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i13 = 0;
        while (i13 != i12) {
            int i14 = inputStream.read(bArr, i11 + i13, i12 - i13);
            if (i14 == -1) {
                break;
            }
            i13 += i14;
        }
        return i13;
    }

    public static long c(InputStream inputStream, long j11) throws IOException {
        int iB;
        long j12 = j11;
        while (j12 > 0) {
            long jSkip = inputStream.skip(j12);
            if (jSkip == 0) {
                break;
            }
            j12 -= jSkip;
        }
        while (j12 > 0 && (iB = b(inputStream, f72275a, 0, (int) Math.min(j12, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM))) >= 1) {
            j12 -= (long) iB;
        }
        return j11 - j12;
    }
}
