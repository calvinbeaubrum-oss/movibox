package com.vungle.warren;

import com.vungle.warren.error.VungleException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class InitCallbackWrapper implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f61747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExecutorService f61748b;

    public InitCallbackWrapper(ExecutorService executorService, l lVar) {
        this.f61747a = lVar;
        this.f61748b = executorService;
    }

    @Override // com.vungle.warren.l
    public void onAutoCacheAdAvailable(final String str) {
        if (this.f61747a == null) {
            return;
        }
        if (com.vungle.warren.utility.t.a()) {
            this.f61747a.onAutoCacheAdAvailable(str);
        } else {
            this.f61748b.execute(new Runnable() { // from class: com.vungle.warren.InitCallbackWrapper.3
                @Override // java.lang.Runnable
                public void run() {
                    InitCallbackWrapper.this.f61747a.onAutoCacheAdAvailable(str);
                }
            });
        }
    }

    @Override // com.vungle.warren.l
    public void onError(final VungleException vungleException) {
        if (this.f61747a == null) {
            return;
        }
        if (com.vungle.warren.utility.t.a()) {
            this.f61747a.onError(vungleException);
        } else {
            this.f61748b.execute(new Runnable() { // from class: com.vungle.warren.InitCallbackWrapper.2
                @Override // java.lang.Runnable
                public void run() {
                    InitCallbackWrapper.this.f61747a.onError(vungleException);
                }
            });
        }
    }

    @Override // com.vungle.warren.l
    public void onSuccess() {
        if (this.f61747a == null) {
            return;
        }
        if (com.vungle.warren.utility.t.a()) {
            this.f61747a.onSuccess();
        } else {
            this.f61748b.execute(new Runnable() { // from class: com.vungle.warren.InitCallbackWrapper.1
                @Override // java.lang.Runnable
                public void run() {
                    InitCallbackWrapper.this.f61747a.onSuccess();
                }
            });
        }
    }
}
