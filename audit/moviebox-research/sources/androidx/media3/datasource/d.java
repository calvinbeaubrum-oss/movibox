package androidx.media3.datasource;

import android.net.Uri;
import androidx.annotation.Nullable;
import c4.g;
import c4.o;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f9776a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a.InterfaceC0090a f9777b = new a.InterfaceC0090a() { // from class: c4.k
        @Override // androidx.media3.datasource.a.InterfaceC0090a
        public final androidx.media3.datasource.a createDataSource() {
            return androidx.media3.datasource.d.d();
        }
    };

    public static /* synthetic */ d d() {
        return new d();
    }

    @Override // androidx.media3.datasource.a
    public long a(g gVar) throws IOException {
        throw new IOException("PlaceholderDataSource cannot be opened");
    }

    @Override // androidx.media3.datasource.a
    public void c(o oVar) {
    }

    @Override // androidx.media3.datasource.a
    public void close() {
    }

    @Override // androidx.media3.datasource.a
    public /* synthetic */ Map getResponseHeaders() {
        return c4.d.a(this);
    }

    @Override // androidx.media3.datasource.a
    @Nullable
    public Uri getUri() {
        return null;
    }

    @Override // androidx.media3.common.l
    public int read(byte[] bArr, int i11, int i12) {
        throw new UnsupportedOperationException();
    }
}
