package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.bootstrap;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.b;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.n;
import ek.a;
import ek.d;
import ek.e;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
class Worker implements Runnable {
    private final n conn;
    private final b exceptionLogger;
    private final e httpservice;

    public Worker(e eVar, n nVar, b bVar) {
    }

    public n getConnection() {
        return this.conn;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:?, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
    
        throw null;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        try {
            try {
                d.a(new a());
                if (!Thread.interrupted() && this.conn.isOpen()) {
                    throw null;
                }
                this.conn.close();
                try {
                    this.conn.shutdown();
                } catch (IOException unused) {
                    throw null;
                }
            } catch (Exception unused2) {
                throw null;
            }
        } catch (Throwable th2) {
            try {
                this.conn.shutdown();
                throw th2;
            } catch (IOException unused3) {
                throw null;
            }
        }
    }
}
