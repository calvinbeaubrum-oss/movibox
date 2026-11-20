package com.blankj.utilcode.util;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class BusUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f25222a = "nULl";

    /* JADX INFO: renamed from: com.blankj.utilcode.util.BusUtils$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ BusUtils this$0;
        final /* synthetic */ Object val$arg;
        final /* synthetic */ Object val$bus;
        final /* synthetic */ a val$busInfo;
        final /* synthetic */ boolean val$sticky;

        public AnonymousClass1(BusUtils busUtils, Object obj, Object obj2, a aVar, boolean z11) {
            this.val$bus = obj;
            this.val$arg = obj2;
            this.val$sticky = z11;
        }

        @Override // java.lang.Runnable
        public void run() {
            BusUtils.a(null, this.val$bus, this.val$arg, null, this.val$sticky);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum ThreadMode {
        MAIN,
        IO,
        CPU,
        CACHED,
        SINGLE,
        POSTING
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a {
    }

    public static /* synthetic */ void a(BusUtils busUtils, Object obj, Object obj2, a aVar, boolean z11) {
        throw null;
    }
}
