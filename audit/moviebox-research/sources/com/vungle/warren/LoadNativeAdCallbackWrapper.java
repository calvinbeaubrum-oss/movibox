package com.vungle.warren;

import androidx.annotation.Nullable;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class LoadNativeAdCallbackWrapper extends LoadAdCallbackWrapper implements n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f61751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ExecutorService f61752d;

    public LoadNativeAdCallbackWrapper(ExecutorService executorService, n nVar) {
        super(executorService, nVar);
        this.f61751c = nVar;
        this.f61752d = executorService;
    }

    @Override // com.vungle.warren.n
    public void a(@Nullable final com.vungle.warren.model.c cVar) {
        if (this.f61751c == null) {
            return;
        }
        this.f61752d.execute(new Runnable() { // from class: com.vungle.warren.LoadNativeAdCallbackWrapper.1
            @Override // java.lang.Runnable
            public void run() {
                LoadNativeAdCallbackWrapper.this.f61751c.a(cVar);
            }
        });
    }
}
