package com.bytedance.sdk.component;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY {
    private static volatile Handler pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static final Object f27043sc = new Object();
    private static final LinkedList<Runnable> zY = new LinkedList<>();
    private static Object We = new Object();

    /* JADX INFO: compiled from: source.java */
    public static class sc extends Handler {
        public sc(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                try {
                    zY.zY();
                } catch (OutOfMemoryError unused) {
                }
            }
        }
    }

    private static Handler pFF() {
        Handler handler;
        if (pFF != null) {
            return pFF;
        }
        synchronized (f27043sc) {
            try {
                if (pFF == null) {
                    HandlerThread handlerThread = new HandlerThread("queued-work-looper", -2);
                    handlerThread.start();
                    pFF = new sc(handlerThread.getLooper());
                }
                handler = pFF;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return handler;
    }

    public static void sc(Runnable runnable, boolean z11) {
        try {
            Handler handlerPFF = pFF();
            synchronized (f27043sc) {
                try {
                    zY.add(runnable);
                    if (z11) {
                        handlerPFF.sendEmptyMessageDelayed(1, 100L);
                    } else {
                        handlerPFF.sendEmptyMessage(1);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (OutOfMemoryError unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zY() {
        LinkedList linkedList;
        synchronized (We) {
            try {
                synchronized (f27043sc) {
                    LinkedList<Runnable> linkedList2 = zY;
                    linkedList = (LinkedList) linkedList2.clone();
                    linkedList2.clear();
                    pFF().removeMessages(1);
                }
                if (linkedList.size() > 0) {
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        ((Runnable) it.next()).run();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
