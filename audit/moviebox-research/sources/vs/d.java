package vs;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public interface d {
    void close();

    String getPath();

    InputStream open() throws IOException;
}
