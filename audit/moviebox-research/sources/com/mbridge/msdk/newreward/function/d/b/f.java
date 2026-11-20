package com.mbridge.msdk.newreward.function.d.b;

import com.mbridge.msdk.e.a.a.i;
import com.mbridge.msdk.e.a.a.l;
import com.mbridge.msdk.e.a.p;
import com.mbridge.msdk.e.a.q;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile f f46334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private q f46335b;

    private f() {
    }

    public static f a() {
        if (f46334a == null) {
            synchronized (f.class) {
                try {
                    if (f46334a == null) {
                        f46334a = new f();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f46334a;
    }

    public final void a(p<JSONObject> pVar) {
        b().a(pVar);
    }

    public final q b() {
        if (this.f46335b == null) {
            q qVarA = l.a(new com.mbridge.msdk.e.a.a.b(new com.mbridge.msdk.e.a.a.g()), new com.mbridge.msdk.e.a.h(new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.mbridge.msdk.newreward.function.d.b.f.1
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setName("campaign_response_thread");
                    return thread;
                }
            }, new ThreadPoolExecutor.DiscardPolicy())), 5, new i());
            this.f46335b = qVarA;
            qVarA.a();
        }
        return this.f46335b;
    }
}
