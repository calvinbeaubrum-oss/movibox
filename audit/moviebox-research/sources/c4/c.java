package c4;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface c {

    /* JADX INFO: compiled from: source.java */
    public interface a {
        c createDataSink();
    }

    void a(g gVar) throws IOException;

    void close() throws IOException;

    void write(byte[] bArr, int i11, int i12) throws IOException;
}
