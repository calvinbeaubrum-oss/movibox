package s4;

import androidx.annotation.Nullable;
import androidx.media3.common.m0;
import androidx.media3.common.n0;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface z extends c0 {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final n0 f76107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f76108b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f76109c;

        public a(n0 n0Var, int... iArr) {
            this(n0Var, iArr, 0);
        }

        public a(n0 n0Var, int[] iArr, int i11) {
            if (iArr.length == 0) {
                z3.o.d("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
            }
            this.f76107a = n0Var;
            this.f76108b = iArr;
            this.f76109c = i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        z[] a(a[] aVarArr, androidx.media3.exoplayer.upstream.e eVar, androidx.media3.exoplayer.source.l.b bVar, m0 m0Var);
    }

    void a();

    void b(boolean z11);

    void c();

    boolean d(int i11, long j11);

    void disable();

    void enable();

    int evaluateQueueSize(long j11, List<? extends q4.m> list);

    boolean f(int i11, long j11);

    boolean g(long j11, q4.e eVar, List<? extends q4.m> list);

    androidx.media3.common.y getSelectedFormat();

    int getSelectedIndex();

    int getSelectedIndexInTrackGroup();

    @Nullable
    Object getSelectionData();

    int getSelectionReason();

    void h(long j11, long j12, long j13, List<? extends q4.m> list, q4.n[] nVarArr);

    void onPlaybackSpeed(float f11);
}
