package o5;

import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImmutableList<y3.a> f72325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f72326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f72327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f72328d;

    public e(List<y3.a> list, long j11, long j12) {
        this.f72325a = ImmutableList.copyOf((Collection) list);
        this.f72326b = j11;
        this.f72327c = j12;
        long j13 = C.TIME_UNSET;
        if (j11 != C.TIME_UNSET && j12 != C.TIME_UNSET) {
            j13 = j11 + j12;
        }
        this.f72328d = j13;
    }
}
