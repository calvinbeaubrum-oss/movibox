package com.google.android.exoplayer2.offline;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.offline.c;
import com.google.android.exoplayer2.upstream.b0;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d<T extends c<T>> implements b0.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0.a<? extends T> f33663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final List<StreamKey> f33664b;

    public d(b0.a<? extends T> aVar, @Nullable List<StreamKey> list) {
        this.f33663a = aVar;
        this.f33664b = list;
    }

    @Override // com.google.android.exoplayer2.upstream.b0.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public T parse(Uri uri, InputStream inputStream) throws IOException {
        T t11 = this.f33663a.parse(uri, inputStream);
        List<StreamKey> list = this.f33664b;
        return (list == null || list.isEmpty()) ? t11 : (T) t11.copy(this.f33664b);
    }
}
