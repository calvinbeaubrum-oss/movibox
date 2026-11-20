package k8;

import android.os.Build;
import android.view.View;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f68498a = Build.VERSION.SDK_INT;

    public static int a(long j11, long j12) {
        return Math.min(Math.max(0, j12 > 0 ? (int) (((j11 * 1.0d) / j12) * 100.0d) : 0), 100);
    }

    public static String b(long j11) {
        StringBuilder sb2 = new StringBuilder();
        long j12 = j11 / ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS;
        long j13 = ((j11 % 3600000) % ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS) / 1000;
        if (j12 >= 10) {
            sb2.append(j12);
        } else if (j12 > 0) {
            sb2.append(0);
            sb2.append(j12);
        } else {
            sb2.append(0);
            sb2.append(0);
        }
        sb2.append(":");
        if (j13 >= 10) {
            sb2.append(j13);
        } else if (j13 > 0) {
            sb2.append(0);
            sb2.append(j13);
        } else {
            sb2.append(0);
            sb2.append(0);
        }
        return sb2.toString();
    }

    public static void c(View view, boolean z11) {
        if (view == null) {
            return;
        }
        if (z11) {
            view.setSystemUiVisibility(0);
            return;
        }
        int i11 = f68498a;
        if (i11 >= 19) {
            view.setSystemUiVisibility(3846);
        } else if (i11 >= 16) {
            view.setSystemUiVisibility(5);
        } else {
            view.setSystemUiVisibility(1);
        }
    }
}
