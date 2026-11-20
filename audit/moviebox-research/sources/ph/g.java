package ph;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1;
import java.io.IOException;
import java.util.List;
import qg.u1;
import tg.e0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface g {

    /* JADX INFO: compiled from: source.java */
    public interface a {
        @Nullable
        g a(int i11, m1 m1Var, boolean z11, List<m1> list, @Nullable e0 e0Var, u1 u1Var);
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        e0 track(int i11, int i12);
    }

    boolean a(tg.m mVar) throws IOException;

    @Nullable
    tg.d b();

    @Nullable
    m1[] c();

    void d(@Nullable b bVar, long j11, long j12);

    void release();
}
