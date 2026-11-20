package q9;

import androidx.annotation.Nullable;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class c extends ResponseBody {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ResponseBody f74465a;

    public c(ResponseBody responseBody) {
        this.f74465a = responseBody;
    }

    public abstract void a();

    @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f74465a.close();
        a();
    }

    @Override // okhttp3.ResponseBody
    public final long contentLength() {
        return this.f74465a.contentLength();
    }

    @Override // okhttp3.ResponseBody
    @Nullable
    public final MediaType contentType() {
        return this.f74465a.contentType();
    }

    @Override // okhttp3.ResponseBody
    public final BufferedSource source() {
        return this.f74465a.source();
    }
}
