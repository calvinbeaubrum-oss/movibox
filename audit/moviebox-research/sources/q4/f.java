package q4;

import androidx.annotation.Nullable;
import androidx.media3.common.y;
import e4.x3;
import java.io.IOException;
import java.util.List;
import o5.s;
import u4.r0;
import u4.t;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface f {

    /* JADX INFO: compiled from: source.java */
    public interface a {
        a a(s.a aVar);

        a b(boolean z11);

        y c(y yVar);

        @Nullable
        f d(int i11, y yVar, boolean z11, List<y> list, @Nullable r0 r0Var, x3 x3Var);
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        r0 track(int i11, int i12);
    }

    boolean a(t tVar) throws IOException;

    @Nullable
    u4.h b();

    @Nullable
    y[] c();

    void d(@Nullable b bVar, long j11, long j12);

    void release();
}
