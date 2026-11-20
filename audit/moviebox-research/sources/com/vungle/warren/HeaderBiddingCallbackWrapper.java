package com.vungle.warren;

import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class HeaderBiddingCallbackWrapper implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f61745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExecutorService f61746b;

    public HeaderBiddingCallbackWrapper(ExecutorService executorService, k kVar) {
        this.f61745a = kVar;
        this.f61746b = executorService;
    }

    @Override // com.vungle.warren.k
    public void a(final String str, final String str2) {
        if (this.f61745a == null) {
            return;
        }
        this.f61746b.execute(new Runnable() { // from class: com.vungle.warren.HeaderBiddingCallbackWrapper.1
            @Override // java.lang.Runnable
            public void run() {
                HeaderBiddingCallbackWrapper.this.f61745a.a(str, str2);
            }
        });
    }

    @Override // com.vungle.warren.k
    public void b(final String str, final String str2) {
        if (this.f61745a == null) {
            return;
        }
        this.f61746b.execute(new Runnable() { // from class: com.vungle.warren.HeaderBiddingCallbackWrapper.2
            @Override // java.lang.Runnable
            public void run() {
                HeaderBiddingCallbackWrapper.this.f61745a.b(str, str2);
            }
        });
    }
}
