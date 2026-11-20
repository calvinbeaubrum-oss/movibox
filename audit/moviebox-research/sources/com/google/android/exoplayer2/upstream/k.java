package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface k extends g {

    /* JADX INFO: compiled from: source.java */
    public interface a {
        k createDataSource();
    }

    long a(n nVar) throws IOException;

    void close() throws IOException;

    void e(k0 k0Var);

    Map<String, List<String>> getResponseHeaders();

    @Nullable
    Uri getUri();
}
