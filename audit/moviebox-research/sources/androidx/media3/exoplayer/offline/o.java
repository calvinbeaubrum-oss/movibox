package androidx.media3.exoplayer.offline;

import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface o {

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void onProgress(long j11, long j12, float f11);
    }

    void a(@Nullable a aVar) throws InterruptedException, IOException;

    void cancel();

    void remove();
}
