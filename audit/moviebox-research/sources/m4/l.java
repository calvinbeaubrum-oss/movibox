package m4;

import android.os.Bundle;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface l {
    void a(int i11, int i12, int i13, long j11, int i14);

    @RequiresApi(19)
    void b(Bundle bundle);

    void c();

    void f(int i11, int i12, androidx.media3.decoder.c cVar, long j11, int i13);

    void flush();

    void shutdown();

    void start();
}
