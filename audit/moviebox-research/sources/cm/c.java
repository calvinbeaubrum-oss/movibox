package cm;

import androidx.annotation.Nullable;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class c extends ResponseBody {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ResponseBody f14980a;

    public c(ResponseBody responseBody) {
        this.f14980a = responseBody;
    }

    public abstract void a();

    @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f14980a.close();
        a();
    }

    @Override // okhttp3.ResponseBody
    public final long contentLength() {
        return this.f14980a.contentLength();
    }

    @Override // okhttp3.ResponseBody
    @Nullable
    public final MediaType contentType() {
        return this.f14980a.contentType();
    }

    @Override // okhttp3.ResponseBody
    public final BufferedSource source() {
        return this.f14980a.source();
    }
}
