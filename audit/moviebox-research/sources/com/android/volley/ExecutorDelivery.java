package com.android.volley;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExecutorDelivery implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f16487a;

    /* JADX INFO: compiled from: source.java */
    public static class ResponseDeliveryRunnable implements Runnable {
        private final Request mRequest;
        private final i mResponse;
        private final Runnable mRunnable;

        public ResponseDeliveryRunnable(Request request, i iVar, Runnable runnable) {
            this.mRequest = request;
            this.mResponse = iVar;
            this.mRunnable = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mRequest.isCanceled()) {
                this.mRequest.finish("canceled-at-delivery");
                return;
            }
            if (this.mResponse.b()) {
                this.mRequest.deliverResponse(this.mResponse.f16521a);
            } else {
                this.mRequest.deliverError(this.mResponse.f16523c);
            }
            if (this.mResponse.f16524d) {
                this.mRequest.addMarker("intermediate-response");
            } else {
                this.mRequest.finish("done");
            }
            Runnable runnable = this.mRunnable;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Handler f16488a;

        public a(Handler handler) {
            this.f16488a = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f16488a.post(runnable);
        }
    }

    public ExecutorDelivery(Handler handler) {
        this.f16487a = new a(handler);
    }

    @Override // com.android.volley.j
    public void a(Request<?> request, i<?> iVar) {
        b(request, iVar, null);
    }

    @Override // com.android.volley.j
    public void b(Request<?> request, i<?> iVar, Runnable runnable) {
        request.markDelivered();
        request.addMarker("post-response");
        this.f16487a.execute(new ResponseDeliveryRunnable(request, iVar, runnable));
    }

    @Override // com.android.volley.j
    public void c(Request<?> request, VolleyError volleyError) {
        request.addMarker("post-error");
        this.f16487a.execute(new ResponseDeliveryRunnable(request, i.a(volleyError), null));
    }
}
