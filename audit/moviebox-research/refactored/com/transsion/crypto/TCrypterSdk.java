// =============================================================================
// TCrypterSdk (original : com.transsion.crypto.TCrypterSdk) — MovieBox 3.0.05
// Façade du SDK de chiffrement Transsion : délègue à zs.a (instance par
// contexte : b() = chiffrer, d() = stocker) et ys.m.b() (initialisation asynchrone,
// pool de 4 threads max). La logique réelle est dans les packages obfusqués
// ys/zs (cf. glossaire — non résolue à ce stade).
// =============================================================================
package com.transsion.crypto;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import ys.m;
import zs.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class TCrypterSdk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ExecutorService f51850a = new ThreadPoolExecutor(0, 4, 2, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadPoolExecutor.CallerRunsPolicy());

    public static String a(Context context, String str) {
        return a.a(context).b(str);
    }

    public static void b(final Context context) {
        f51850a.execute(new Runnable() { // from class: com.transsion.crypto.TCrypterSdk.1
            @Override // java.lang.Runnable
            public void run() {
                m.b().a(context);
            }
        });
    }

    public static void c(Context context, String str, String str2) throws Exception {
        a.a(context).d(str, str2);
    }
}
