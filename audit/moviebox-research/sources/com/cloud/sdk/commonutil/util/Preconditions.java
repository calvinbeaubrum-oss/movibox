package com.cloud.sdk.commonutil.util;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public final class Preconditions {

    /* JADX INFO: renamed from: com.cloud.sdk.commonutil.util.Preconditions$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ a val$callback;

        public AnonymousClass2(a aVar) {
            this.val$callback = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$callback.onRun();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public interface a {
        void onRun();
    }

    public static void a() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new RuntimeException("Must be called from the UiThread");
        }
    }

    @NonNull
    public static <T> T b(T t11) {
        t11.getClass();
        return t11;
    }

    public static <T> T c(T t11, String str) {
        if (t11 != null) {
            return t11;
        }
        throw new IllegalArgumentException(str);
    }

    public static void d(final a aVar) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cloud.sdk.commonutil.util.Preconditions.1
                @Override // java.lang.Runnable
                public void run() {
                    aVar.onRun();
                }
            });
        } else {
            aVar.onRun();
        }
    }
}
