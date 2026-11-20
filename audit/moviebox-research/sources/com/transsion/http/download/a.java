package com.transsion.http.download;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ DownLoaderTask f52831a;

    public a(DownLoaderTask downLoaderTask) {
        this.f52831a = downLoaderTask;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f52831a.f52826k.a();
    }
}
