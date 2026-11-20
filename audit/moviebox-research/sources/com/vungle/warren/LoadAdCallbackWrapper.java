package com.vungle.warren;

import com.vungle.warren.error.VungleException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class LoadAdCallbackWrapper implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f61749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExecutorService f61750b;

    public LoadAdCallbackWrapper(ExecutorService executorService, m mVar) {
        this.f61749a = mVar;
        this.f61750b = executorService;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LoadAdCallbackWrapper loadAdCallbackWrapper = (LoadAdCallbackWrapper) obj;
        m mVar = this.f61749a;
        if (mVar == null ? loadAdCallbackWrapper.f61749a != null : !mVar.equals(loadAdCallbackWrapper.f61749a)) {
            return false;
        }
        ExecutorService executorService = this.f61750b;
        ExecutorService executorService2 = loadAdCallbackWrapper.f61750b;
        if (executorService != null) {
            return executorService.equals(executorService2);
        }
        return executorService2 == null;
    }

    public int hashCode() {
        m mVar = this.f61749a;
        int iHashCode = (mVar != null ? mVar.hashCode() : 0) * 31;
        ExecutorService executorService = this.f61750b;
        return iHashCode + (executorService != null ? executorService.hashCode() : 0);
    }

    @Override // com.vungle.warren.m
    public void onAdLoad(final String str) {
        if (this.f61749a == null) {
            return;
        }
        if (com.vungle.warren.utility.t.a()) {
            this.f61749a.onAdLoad(str);
        } else {
            this.f61750b.execute(new Runnable() { // from class: com.vungle.warren.LoadAdCallbackWrapper.1
                @Override // java.lang.Runnable
                public void run() {
                    LoadAdCallbackWrapper.this.f61749a.onAdLoad(str);
                }
            });
        }
    }

    @Override // com.vungle.warren.m
    public void onError(final String str, final VungleException vungleException) {
        if (this.f61749a == null) {
            return;
        }
        if (com.vungle.warren.utility.t.a()) {
            this.f61749a.onError(str, vungleException);
        } else {
            this.f61750b.execute(new Runnable() { // from class: com.vungle.warren.LoadAdCallbackWrapper.2
                @Override // java.lang.Runnable
                public void run() {
                    LoadAdCallbackWrapper.this.f61749a.onError(str, vungleException);
                }
            });
        }
    }
}
