package com.vungle.warren;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.ui.view.FullAdWidget;
import com.vungle.warren.ui.view.VungleWebClient;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public interface r {

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(@NonNull Pair<b10.a, b10.b> pair, @Nullable VungleException vungleException);
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(@NonNull Pair<b10.f, b10.e> pair, @Nullable VungleException vungleException);
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        void a(@NonNull Pair<b10.g, VungleWebClient> pair, @Nullable VungleException vungleException);
    }

    void a(@NonNull Context context, @NonNull NativeAdLayout nativeAdLayout, @NonNull AdRequest adRequest, @Nullable AdConfig adConfig, @NonNull b bVar);

    void b(Context context, @NonNull AdRequest adRequest, @Nullable AdConfig adConfig, @NonNull a10.a aVar, @NonNull c cVar);

    void c(@NonNull Context context, @NonNull AdRequest adRequest, @NonNull FullAdWidget fullAdWidget, @Nullable c10.a aVar, @NonNull a10.a aVar2, @NonNull a10.e eVar, @Nullable Bundle bundle, @NonNull a aVar3);

    void d(Bundle bundle);

    void destroy();
}
