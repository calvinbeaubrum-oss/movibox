package com.vungle.warren;

import com.vungle.warren.error.VungleException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class PlayAdCallbackWrapper implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f61773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExecutorService f61774b;

    public PlayAdCallbackWrapper(ExecutorService executorService, q qVar) {
        this.f61773a = qVar;
        this.f61774b = executorService;
    }

    @Override // com.vungle.warren.q
    public void creativeId(final String str) {
        if (this.f61773a == null) {
            return;
        }
        if (com.vungle.warren.utility.t.a()) {
            this.f61773a.creativeId(str);
        } else {
            this.f61774b.execute(new Runnable() { // from class: com.vungle.warren.PlayAdCallbackWrapper.1
                @Override // java.lang.Runnable
                public void run() {
                    PlayAdCallbackWrapper.this.f61773a.creativeId(str);
                }
            });
        }
    }

    @Override // com.vungle.warren.q
    public void onAdClick(final String str) {
        if (this.f61773a == null) {
            return;
        }
        if (com.vungle.warren.utility.t.a()) {
            this.f61773a.onAdClick(str);
        } else {
            this.f61774b.execute(new Runnable() { // from class: com.vungle.warren.PlayAdCallbackWrapper.5
                @Override // java.lang.Runnable
                public void run() {
                    PlayAdCallbackWrapper.this.f61773a.onAdClick(str);
                }
            });
        }
    }

    @Override // com.vungle.warren.q
    public void onAdEnd(final String str) {
        if (this.f61773a == null) {
            return;
        }
        if (com.vungle.warren.utility.t.a()) {
            this.f61773a.onAdEnd(str);
        } else {
            this.f61774b.execute(new Runnable() { // from class: com.vungle.warren.PlayAdCallbackWrapper.4
                @Override // java.lang.Runnable
                public void run() {
                    PlayAdCallbackWrapper.this.f61773a.onAdEnd(str);
                }
            });
        }
    }

    @Override // com.vungle.warren.q
    public void onAdEnd(final String str, final boolean z11, final boolean z12) {
        if (this.f61773a == null) {
            return;
        }
        if (com.vungle.warren.utility.t.a()) {
            this.f61773a.onAdEnd(str, z11, z12);
        } else {
            this.f61774b.execute(new Runnable() { // from class: com.vungle.warren.PlayAdCallbackWrapper.3
                @Override // java.lang.Runnable
                public void run() {
                    PlayAdCallbackWrapper.this.f61773a.onAdEnd(str, z11, z12);
                }
            });
        }
    }

    @Override // com.vungle.warren.q
    public void onAdLeftApplication(final String str) {
        if (this.f61773a == null) {
            return;
        }
        if (com.vungle.warren.utility.t.a()) {
            this.f61773a.onAdLeftApplication(str);
        } else {
            this.f61774b.execute(new Runnable() { // from class: com.vungle.warren.PlayAdCallbackWrapper.6
                @Override // java.lang.Runnable
                public void run() {
                    PlayAdCallbackWrapper.this.f61773a.onAdLeftApplication(str);
                }
            });
        }
    }

    @Override // com.vungle.warren.q
    public void onAdRewarded(final String str) {
        if (this.f61773a == null) {
            return;
        }
        if (com.vungle.warren.utility.t.a()) {
            this.f61773a.onAdRewarded(str);
        } else {
            this.f61774b.execute(new Runnable() { // from class: com.vungle.warren.PlayAdCallbackWrapper.7
                @Override // java.lang.Runnable
                public void run() {
                    PlayAdCallbackWrapper.this.f61773a.onAdRewarded(str);
                }
            });
        }
    }

    @Override // com.vungle.warren.q
    public void onAdStart(final String str) {
        if (this.f61773a == null) {
            return;
        }
        if (com.vungle.warren.utility.t.a()) {
            this.f61773a.onAdStart(str);
        } else {
            this.f61774b.execute(new Runnable() { // from class: com.vungle.warren.PlayAdCallbackWrapper.2
                @Override // java.lang.Runnable
                public void run() {
                    PlayAdCallbackWrapper.this.f61773a.onAdStart(str);
                }
            });
        }
    }

    @Override // com.vungle.warren.q
    public void onAdViewed(final String str) {
        if (this.f61773a == null) {
            return;
        }
        if (com.vungle.warren.utility.t.a()) {
            this.f61773a.onAdViewed(str);
        } else {
            this.f61774b.execute(new Runnable() { // from class: com.vungle.warren.PlayAdCallbackWrapper.9
                @Override // java.lang.Runnable
                public void run() {
                    PlayAdCallbackWrapper.this.f61773a.onAdViewed(str);
                }
            });
        }
    }

    @Override // com.vungle.warren.q
    public void onError(final String str, final VungleException vungleException) {
        if (this.f61773a == null) {
            return;
        }
        if (com.vungle.warren.utility.t.a()) {
            this.f61773a.onError(str, vungleException);
        } else {
            this.f61774b.execute(new Runnable() { // from class: com.vungle.warren.PlayAdCallbackWrapper.8
                @Override // java.lang.Runnable
                public void run() {
                    PlayAdCallbackWrapper.this.f61773a.onError(str, vungleException);
                }
            });
        }
    }
}
