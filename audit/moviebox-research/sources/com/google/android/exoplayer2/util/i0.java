package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class i0 implements o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<b> f35576b = new ArrayList(50);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f35577a;

    /* JADX INFO: compiled from: source.java */
    public static final class b implements o.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public Message f35578a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public i0 f35579b;

        public b() {
        }

        @Override // com.google.android.exoplayer2.util.o.a
        public void a() {
            ((Message) com.google.android.exoplayer2.util.a.e(this.f35578a)).sendToTarget();
            b();
        }

        public final void b() {
            this.f35578a = null;
            this.f35579b = null;
            i0.e(this);
        }

        public boolean c(Handler handler) {
            boolean zSendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue((Message) com.google.android.exoplayer2.util.a.e(this.f35578a));
            b();
            return zSendMessageAtFrontOfQueue;
        }

        public b d(Message message, i0 i0Var) {
            this.f35578a = message;
            this.f35579b = i0Var;
            return this;
        }
    }

    public i0(Handler handler) {
        this.f35577a = handler;
    }

    public static b d() {
        b bVar;
        List<b> list = f35576b;
        synchronized (list) {
            try {
                bVar = list.isEmpty() ? new b() : list.remove(list.size() - 1);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return bVar;
    }

    public static void e(b bVar) {
        List<b> list = f35576b;
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

    @Override // com.google.android.exoplayer2.util.o
    public boolean a(int i11) {
        return this.f35577a.hasMessages(i11);
    }

    @Override // com.google.android.exoplayer2.util.o
    public boolean b(o.a aVar) {
        return ((b) aVar).c(this.f35577a);
    }

    @Override // com.google.android.exoplayer2.util.o
    public o.a obtainMessage(int i11) {
        return d().d(this.f35577a.obtainMessage(i11), this);
    }

    @Override // com.google.android.exoplayer2.util.o
    public o.a obtainMessage(int i11, int i12, int i13) {
        return d().d(this.f35577a.obtainMessage(i11, i12, i13), this);
    }

    @Override // com.google.android.exoplayer2.util.o
    public o.a obtainMessage(int i11, int i12, int i13, @Nullable Object obj) {
        return d().d(this.f35577a.obtainMessage(i11, i12, i13, obj), this);
    }

    @Override // com.google.android.exoplayer2.util.o
    public o.a obtainMessage(int i11, @Nullable Object obj) {
        return d().d(this.f35577a.obtainMessage(i11, obj), this);
    }

    @Override // com.google.android.exoplayer2.util.o
    public boolean post(Runnable runnable) {
        return this.f35577a.post(runnable);
    }

    @Override // com.google.android.exoplayer2.util.o
    public void removeCallbacksAndMessages(@Nullable Object obj) {
        this.f35577a.removeCallbacksAndMessages(obj);
    }

    @Override // com.google.android.exoplayer2.util.o
    public void removeMessages(int i11) {
        this.f35577a.removeMessages(i11);
    }

    @Override // com.google.android.exoplayer2.util.o
    public boolean sendEmptyMessage(int i11) {
        return this.f35577a.sendEmptyMessage(i11);
    }

    @Override // com.google.android.exoplayer2.util.o
    public boolean sendEmptyMessageAtTime(int i11, long j11) {
        return this.f35577a.sendEmptyMessageAtTime(i11, j11);
    }
}
