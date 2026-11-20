package androidx.media3.datasource;

import c4.g;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class HttpEngineDataSource$OpenException extends HttpDataSource.HttpDataSourceException {
    public final int httpEngineConnectionStatus;

    public HttpEngineDataSource$OpenException(g gVar, int i11, int i12) {
        super(gVar, i11, 1);
        this.httpEngineConnectionStatus = i12;
    }

    public HttpEngineDataSource$OpenException(IOException iOException, g gVar, int i11, int i12) {
        super(iOException, gVar, i11, 1);
        this.httpEngineConnectionStatus = i12;
    }

    public HttpEngineDataSource$OpenException(String str, g gVar, int i11, int i12) {
        super(str, gVar, i11, 1);
        this.httpEngineConnectionStatus = i12;
    }
}
