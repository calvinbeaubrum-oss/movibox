package com.applovin.impl;

import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class wl implements ja {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List f24112b = new ArrayList(50);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f24113a;

    /* JADX INFO: compiled from: source.java */
    public static final class b implements ja.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Message f24114a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private wl f24115b;

        private b() {
        }

        private void b() {
            this.f24114a = null;
            this.f24115b = null;
            wl.b(this);
        }

        public b a(Message message, wl wlVar) {
            this.f24114a = message;
            this.f24115b = wlVar;
            return this;
        }

        @Override // com.applovin.impl.ja.a
        public void a() {
            ((Message) b1.a(this.f24114a)).sendToTarget();
            b();
        }

        public boolean a(Handler handler) {
            boolean zSendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue((Message) b1.a(this.f24114a));
            b();
            return zSendMessageAtFrontOfQueue;
        }
    }

    public wl(Handler handler) {
        this.f24113a = handler;
    }

    private static b a() {
        b bVar;
        List list = f24112b;
        synchronized (list) {
            try {
                bVar = list.isEmpty() ? new b() : (b) list.remove(list.size() - 1);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(b bVar) {
        List list = f24112b;
        synchronized (list) {
            try {
                if (list.size() < 50) {
                    list.add(bVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.applovin.impl.ja
    public ja.a a(int i11, int i12, int i13) {
        return a().a(this.f24113a.obtainMessage(i11, i12, i13), this);
    }

    @Override // com.applovin.impl.ja
    public ja.a a(int i11, int i12, int i13, Object obj) {
        return a().a(this.f24113a.obtainMessage(i11, i12, i13, obj), this);
    }

    @Override // com.applovin.impl.ja
    public ja.a a(int i11, Object obj) {
        return a().a(this.f24113a.obtainMessage(i11, obj), this);
    }

    @Override // com.applovin.impl.ja
    public void a(Object obj) {
        this.f24113a.removeCallbacksAndMessages(obj);
    }

    @Override // com.applovin.impl.ja
    public boolean a(int i11) {
        return this.f24113a.hasMessages(i11);
    }

    @Override // com.applovin.impl.ja
    public boolean a(int i11, long j11) {
        return this.f24113a.sendEmptyMessageAtTime(i11, j11);
    }

    @Override // com.applovin.impl.ja
    public boolean a(ja.a aVar) {
        return ((b) aVar).a(this.f24113a);
    }

    @Override // com.applovin.impl.ja
    public boolean a(Runnable runnable) {
        return this.f24113a.post(runnable);
    }

    @Override // com.applovin.impl.ja
    public void b(int i11) {
        this.f24113a.removeMessages(i11);
    }

    @Override // com.applovin.impl.ja
    public boolean c(int i11) {
        return this.f24113a.sendEmptyMessage(i11);
    }

    @Override // com.applovin.impl.ja
    public ja.a d(int i11) {
        return a().a(this.f24113a.obtainMessage(i11), this);
    }
}
