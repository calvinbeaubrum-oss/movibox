package fi;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.j3;
import com.google.android.exoplayer2.m1;
import java.util.List;
import nh.i0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface s extends v {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i0 f65041a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f65042b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f65043c;

        public a(i0 i0Var, int... iArr) {
            this(i0Var, iArr, 0);
        }

        public a(i0 i0Var, int[] iArr, int i11) {
            if (iArr.length == 0) {
                com.google.android.exoplayer2.util.s.d("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
            }
            this.f65041a = i0Var;
            this.f65042b = iArr;
            this.f65043c = i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        s[] a(a[] aVarArr, com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.source.i.b bVar, j3 j3Var);
    }

    void a();

    void b(boolean z11);

    boolean blacklist(int i11, long j11);

    void c();

    void d(long j11, long j12, long j13, List<? extends ph.n> list, ph.o[] oVarArr);

    void disable();

    boolean e(int i11, long j11);

    void enable();

    int evaluateQueueSize(long j11, List<? extends ph.n> list);

    boolean f(long j11, ph.f fVar, List<? extends ph.n> list);

    m1 getSelectedFormat();

    int getSelectedIndex();

    int getSelectedIndexInTrackGroup();

    @Nullable
    Object getSelectionData();

    int getSelectionReason();

    void onPlaybackSpeed(float f11);
}
