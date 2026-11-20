package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.bootstrap;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.b;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.h;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.n;
import ek.e;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import zj.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
class RequestListener implements Runnable {
    private final h<? extends n> connectionFactory;
    private final b exceptionLogger;
    private final ExecutorService executorService;
    private final e httpService;
    private final ServerSocket serversocket;
    private final a socketConfig;
    private final AtomicBoolean terminated = new AtomicBoolean(false);

    public RequestListener(a aVar, ServerSocket serverSocket, e eVar, h<? extends n> hVar, b bVar, ExecutorService executorService) {
        this.serversocket = serverSocket;
        this.executorService = executorService;
    }

    public boolean isTerminated() {
        return this.terminated.get();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
    
        throw null;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        try {
            if (!isTerminated() && !Thread.interrupted()) {
                this.serversocket.accept();
                throw null;
            }
        } catch (Exception unused) {
            throw null;
        }
    }

    public void terminate() throws IOException {
        if (this.terminated.compareAndSet(false, true)) {
            this.serversocket.close();
        }
    }
}
