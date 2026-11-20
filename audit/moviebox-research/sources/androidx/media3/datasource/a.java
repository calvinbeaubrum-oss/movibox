package androidx.media3.datasource;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.l;
import c4.g;
import c4.o;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface a extends l {

    /* JADX INFO: renamed from: androidx.media3.datasource.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0090a {
        a createDataSource();
    }

    long a(g gVar) throws IOException;

    void c(o oVar);

    void close() throws IOException;

    Map<String, List<String>> getResponseHeaders();

    @Nullable
    Uri getUri();
}
