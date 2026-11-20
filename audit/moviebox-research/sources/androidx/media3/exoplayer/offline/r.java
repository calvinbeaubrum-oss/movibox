package androidx.media3.exoplayer.offline;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.StreamKey;
import androidx.media3.exoplayer.offline.q;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r<T extends q<T>> implements androidx.media3.exoplayer.upstream.o.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.media3.exoplayer.upstream.o.a<? extends T> f10917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final List<StreamKey> f10918b;

    public r(androidx.media3.exoplayer.upstream.o.a<? extends T> aVar, @Nullable List<StreamKey> list) {
        this.f10917a = aVar;
        this.f10918b = list;
    }

    @Override // androidx.media3.exoplayer.upstream.o.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public T parse(Uri uri, InputStream inputStream) throws IOException {
        T t11 = this.f10917a.parse(uri, inputStream);
        List<StreamKey> list = this.f10918b;
        return (list == null || list.isEmpty()) ? t11 : (T) t11.copy(this.f10918b);
    }
}
