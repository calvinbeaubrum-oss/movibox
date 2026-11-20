package vs;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InputStream f79084a;

    public abstract InputStream a() throws IOException;

    @Override // vs.d
    public void close() {
        InputStream inputStream = this.f79084a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            } finally {
                this.f79084a = null;
            }
        }
    }

    @Override // vs.d
    public InputStream open() throws IOException {
        close();
        InputStream inputStreamA = a();
        this.f79084a = inputStreamA;
        return inputStreamA;
    }
}
