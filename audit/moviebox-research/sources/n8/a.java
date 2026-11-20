package n8;

import android.content.Context;
import android.media.MediaDataSource;
import android.text.TextUtils;
import com.bykv.vk.openvk.sc.sc.pFF.sc.sc.b;
import com.bykv.vk.openvk.sc.sc.sc.zY.zY;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends MediaDataSource {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f71768f = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f71769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f71770b = -2147483648L;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f71771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zY f71772d;

    public a(Context context, zY zYVar) {
        this.f71771c = context;
        this.f71772d = zYVar;
        this.f71769a = new com.bykv.vk.openvk.sc.sc.pFF.sc.sc.a(context, zYVar);
    }

    public static a b(Context context, zY zYVar) {
        a aVar = new a(context, zYVar);
        f71768f.put(zYVar.SR(), aVar);
        return aVar;
    }

    public zY a() {
        return this.f71772d;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f71772d.Ql();
        b bVar = this.f71769a;
        if (bVar != null) {
            bVar.pFF();
        }
        f71768f.remove(this.f71772d.SR());
    }

    @Override // android.media.MediaDataSource
    public long getSize() throws IOException {
        if (this.f71770b == -2147483648L) {
            if (this.f71771c == null || TextUtils.isEmpty(this.f71772d.Ql())) {
                return -1L;
            }
            this.f71770b = this.f71769a.zY();
        }
        return this.f71770b;
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j11, byte[] bArr, int i11, int i12) throws IOException {
        int iA = this.f71769a.a(j11, bArr, i11, i12);
        int length = bArr.length;
        Objects.toString(Thread.currentThread());
        return iA;
    }
}
