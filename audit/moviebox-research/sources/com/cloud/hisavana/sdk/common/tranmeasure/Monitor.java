package com.cloud.hisavana.sdk.common.tranmeasure;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class Monitor {

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Monitor f29461a = new b();
    }

    public static Monitor getInstance() {
        return a.f29461a;
    }

    public abstract void end();

    public abstract void start();
}
