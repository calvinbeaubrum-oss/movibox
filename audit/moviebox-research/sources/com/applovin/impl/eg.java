package com.applovin.impl;

import android.os.Process;
import android.os.SystemClock;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class eg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PriorityBlockingQueue f18694a = new PriorityBlockingQueue();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f18695b;

    /* JADX INFO: compiled from: source.java */
    public static class b extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final BlockingQueue f18696a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.applovin.impl.sdk.j f18697b;

        private b(BlockingQueue blockingQueue, int i11, com.applovin.impl.sdk.j jVar) {
            super("AppLovinSdk:network");
            if (blockingQueue == null) {
                throw new IllegalArgumentException("No request queue specified");
            }
            if (jVar == null) {
                throw new IllegalArgumentException("No sdk specified");
            }
            this.f18696a = blockingQueue;
            this.f18697b = jVar;
            setPriority(((Integer) jVar.a(sj.Y)).intValue());
        }

        private HttpURLConnection a(c cVar) throws ProtocolException {
            HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(cVar.f18699a).openConnection()));
            httpURLConnection.setRequestMethod(cVar.f18700b);
            httpURLConnection.setConnectTimeout(cVar.f18703f);
            httpURLConnection.setReadTimeout(cVar.f18703f);
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setAllowUserInteraction(false);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setDoInput(true);
            if (!cVar.f18701c.isEmpty()) {
                for (Map.Entry entry : cVar.f18701c.entrySet()) {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
            return httpURLConnection;
        }

        private void a() throws Throwable {
            b((c) this.f18696a.take());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(c cVar, d dVar) {
            cVar.f18704g.accept(dVar);
        }

        /* JADX WARN: Code duplicated, block: B:131:0x024c A[Catch: all -> 0x0256, TRY_LEAVE, TryCatch #19 {all -> 0x0256, blocks: (B:129:0x0234, B:131:0x024c), top: B:190:0x0234 }] */
        /* JADX WARN: Code duplicated, block: B:150:0x02a1  */
        /* JADX WARN: Code duplicated, block: B:161:0x025d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:179:0x0104 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:197:0x00f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:61:0x00e9 A[Catch: all -> 0x00f3, TRY_LEAVE, TryCatch #7 {all -> 0x00f3, blocks: (B:59:0x00d1, B:61:0x00e9, B:85:0x0120), top: B:169:0x00d1 }] */
        /* JADX WARN: Code duplicated, block: B:87:0x013b  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r15v0 */
        /* JADX WARN: Type inference failed for: r15v1, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r15v16 */
        /* JADX WARN: Type inference failed for: r15v17 */
        /* JADX WARN: Type inference failed for: r15v18 */
        /* JADX WARN: Type inference failed for: r15v19 */
        /* JADX WARN: Type inference failed for: r15v2, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r15v20 */
        /* JADX WARN: Type inference failed for: r15v3 */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        private void b(final c cVar) throws Throwable {
            Throwable th2;
            HttpURLConnection httpURLConnectionA;
            ?? r15;
            Throwable th3;
            InputStream inputStream;
            long jElapsedRealtime;
            InputStream inputStream2;
            InputStream errorStream;
            byte[] bArrA;
            byte[] bArrA2;
            ?? r16;
            InputStream inputStream3;
            Throwable th4;
            HttpURLConnection httpURLConnectionA2;
            byte[] bArrA3;
            long jElapsedRealtime2;
            byte[] bArrA4;
            byte[] bArr;
            byte[] bArr2;
            InputStream errorStream2;
            int responseCode = 0;
            if (!((Boolean) this.f18697b.a(sj.F)).booleanValue()) {
                long jElapsedRealtime3 = SystemClock.elapsedRealtime();
                try {
                    httpURLConnectionA = a(cVar);
                    try {
                        if (cVar.f18702d != null && cVar.f18702d.length > 0) {
                            httpURLConnectionA.setDoOutput(true);
                            httpURLConnectionA.setFixedLengthStreamingMode(cVar.f18702d.length);
                            if (((Boolean) this.f18697b.a(sj.G)).booleanValue()) {
                                try {
                                    OutputStream outputStream = httpURLConnectionA.getOutputStream();
                                    outputStream.write(cVar.f18702d);
                                    outputStream.close();
                                } catch (Throwable th5) {
                                    CollectionUtils.putStringIfValid("details", "outputStream", new HashMap());
                                    this.f18697b.E().a("NetworkCommunicationThread", "processRequest", th5);
                                    throw th5;
                                }
                            } else {
                                OutputStream outputStream2 = httpURLConnectionA.getOutputStream();
                                outputStream2.write(cVar.f18702d);
                                outputStream2.close();
                            }
                        }
                        jElapsedRealtime3 = SystemClock.elapsedRealtime();
                        responseCode = httpURLConnectionA.getResponseCode();
                        jElapsedRealtime = SystemClock.elapsedRealtime();
                        if (responseCode > 0) {
                            com.applovin.impl.sdk.j jVar = this.f18697b;
                            sj sjVar = sj.G;
                            try {
                                if (((Boolean) jVar.a(sjVar)).booleanValue()) {
                                    try {
                                        InputStream inputStream4 = httpURLConnectionA.getInputStream();
                                        try {
                                            bArrA = e4.a(inputStream4, this.f18697b);
                                            inputStream3 = inputStream4;
                                        } catch (Throwable th6) {
                                            th = th6;
                                            HashMap map = new HashMap();
                                            CollectionUtils.putStringIfValid("details", "responseDataInputStream", map);
                                            this.f18697b.E().a("NetworkCommunicationThread", "processRequest", th, map);
                                            throw th;
                                        }
                                    } catch (Throwable th7) {
                                        th = th7;
                                    }
                                } else {
                                    InputStream inputStream5 = httpURLConnectionA.getInputStream();
                                    bArrA = e4.a(inputStream5, this.f18697b);
                                    inputStream3 = inputStream5;
                                }
                                bArrA2 = null;
                                errorStream = null;
                                th2 = null;
                                r16 = inputStream3;
                            } catch (Throwable th8) {
                                th2 = th8;
                                r15 = sjVar;
                                try {
                                    jElapsedRealtime = SystemClock.elapsedRealtime();
                                    this.f18697b.J().a("NetworkCommunicationThread", th2);
                                    this.f18697b.J();
                                    if (com.applovin.impl.sdk.n.a()) {
                                        this.f18697b.J().d("NetworkCommunicationThread", "Failed to make HTTP request", th2);
                                    }
                                    if (httpURLConnectionA != null) {
                                        try {
                                            errorStream = httpURLConnectionA.getErrorStream();
                                            try {
                                                bArrA2 = e4.a(errorStream, this.f18697b);
                                                bArrA = null;
                                                r16 = r15;
                                            } catch (Throwable th9) {
                                                th = th9;
                                                inputStream2 = errorStream;
                                                try {
                                                    Throwable th10 = th2;
                                                    if (((Boolean) this.f18697b.a(sj.G)).booleanValue()) {
                                                        HashMap map2 = new HashMap();
                                                        CollectionUtils.putStringIfValid("details", "responseErrorDataInputStream", map2);
                                                        this.f18697b.E().a("NetworkCommunicationThread", "processRequest", th, map2);
                                                    }
                                                    errorStream = inputStream2;
                                                    th2 = th10;
                                                    bArrA = null;
                                                    bArrA2 = null;
                                                    r16 = r15;
                                                } catch (Throwable th11) {
                                                    th3 = th11;
                                                    inputStream = inputStream2;
                                                    yp.a((Closeable) r15, this.f18697b);
                                                    yp.a(inputStream, this.f18697b);
                                                    yp.a(httpURLConnectionA, this.f18697b);
                                                    throw th3;
                                                }
                                            }
                                        } catch (Throwable th12) {
                                            th = th12;
                                            inputStream2 = null;
                                        }
                                    } else {
                                        bArrA = null;
                                        bArrA2 = null;
                                        errorStream = null;
                                        r16 = r15;
                                    }
                                } catch (Throwable th13) {
                                    th3 = th13;
                                    inputStream = null;
                                }
                            }
                        } else {
                            bArrA = null;
                            bArrA2 = null;
                            errorStream = null;
                            th2 = null;
                            r16 = 0;
                        }
                    } catch (Throwable th14) {
                        th2 = th14;
                        r15 = 0;
                        jElapsedRealtime = SystemClock.elapsedRealtime();
                        this.f18697b.J().a("NetworkCommunicationThread", th2);
                        this.f18697b.J();
                        if (com.applovin.impl.sdk.n.a()) {
                            this.f18697b.J().d("NetworkCommunicationThread", "Failed to make HTTP request", th2);
                        }
                        if (httpURLConnectionA != null) {
                            errorStream = httpURLConnectionA.getErrorStream();
                            bArrA2 = e4.a(errorStream, this.f18697b);
                            bArrA = null;
                            r16 = r15;
                        } else {
                            bArrA = null;
                            bArrA2 = null;
                            errorStream = null;
                            r16 = r15;
                        }
                        yp.a((Closeable) r16, this.f18697b);
                        yp.a(errorStream, this.f18697b);
                        yp.a(httpURLConnectionA, this.f18697b);
                        final d dVarA = d.a().a(responseCode).a(bArrA).b(bArrA2).a(jElapsedRealtime - jElapsedRealtime3).a(th2).a();
                        cVar.f18705h.execute(new Runnable() { // from class: com.applovin.impl.jv
                            @Override // java.lang.Runnable
                            public final void run() {
                                eg.b.b(cVar, dVarA);
                            }
                        });
                        return;
                    }
                } catch (Throwable th15) {
                    th2 = th15;
                    httpURLConnectionA = null;
                }
                yp.a((Closeable) r16, this.f18697b);
                yp.a(errorStream, this.f18697b);
                yp.a(httpURLConnectionA, this.f18697b);
                final d dVarA2 = d.a().a(responseCode).a(bArrA).b(bArrA2).a(jElapsedRealtime - jElapsedRealtime3).a(th2).a();
                cVar.f18705h.execute(new Runnable() { // from class: com.applovin.impl.jv
                    @Override // java.lang.Runnable
                    public final void run() {
                        eg.b.b(cVar, dVarA2);
                    }
                });
                return;
            }
            long jElapsedRealtime4 = SystemClock.elapsedRealtime();
            try {
                httpURLConnectionA2 = a(cVar);
                try {
                    if (cVar.f18702d != null && cVar.f18702d.length > 0) {
                        httpURLConnectionA2.setDoOutput(true);
                        httpURLConnectionA2.setFixedLengthStreamingMode(cVar.f18702d.length);
                        try {
                            OutputStream outputStream3 = httpURLConnectionA2.getOutputStream();
                            try {
                                outputStream3.write(cVar.f18702d);
                                outputStream3.close();
                            } catch (Throwable th16) {
                                if (outputStream3 == null) {
                                    throw th16;
                                }
                                try {
                                    outputStream3.close();
                                    throw th16;
                                } catch (Throwable th17) {
                                    th16.addSuppressed(th17);
                                    throw th16;
                                }
                            }
                        } catch (Throwable th18) {
                            CollectionUtils.putStringIfValid("details", "outputStream", new HashMap());
                            this.f18697b.E().a("NetworkCommunicationThread", "processRequest", th18);
                            throw th18;
                        }
                    }
                    jElapsedRealtime4 = SystemClock.elapsedRealtime();
                    responseCode = httpURLConnectionA2.getResponseCode();
                    jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    if (responseCode > 0) {
                        try {
                            InputStream inputStream6 = httpURLConnectionA2.getInputStream();
                            try {
                                bArrA3 = e4.a(inputStream6, this.f18697b);
                                if (inputStream6 != null) {
                                    try {
                                        inputStream6.close();
                                    } catch (Throwable th19) {
                                        th = th19;
                                        try {
                                            HashMap map3 = new HashMap();
                                            CollectionUtils.putStringIfValid("details", "responseDataInputStream", map3);
                                            this.f18697b.E().a("NetworkCommunicationThread", "processRequest", th, map3);
                                            throw th;
                                        } catch (Throwable th20) {
                                            th4 = th20;
                                            try {
                                                jElapsedRealtime2 = SystemClock.elapsedRealtime();
                                                this.f18697b.J().a("NetworkCommunicationThread", th4);
                                                this.f18697b.J();
                                                if (com.applovin.impl.sdk.n.a()) {
                                                    this.f18697b.J().d("NetworkCommunicationThread", "Failed to make HTTP request", th4);
                                                }
                                                if (httpURLConnectionA2 != null) {
                                                    try {
                                                        errorStream2 = httpURLConnectionA2.getErrorStream();
                                                        try {
                                                            bArrA4 = e4.a(errorStream2, this.f18697b);
                                                            if (errorStream2 != null) {
                                                                try {
                                                                    errorStream2.close();
                                                                } catch (Throwable th21) {
                                                                    th = th21;
                                                                    this.f18697b.J().a("NetworkCommunicationThread", th4);
                                                                    HashMap map4 = new HashMap();
                                                                    CollectionUtils.putStringIfValid("details", "responseErrorDataInputStream", map4);
                                                                    this.f18697b.E().a("NetworkCommunicationThread", "processRequest", th, map4);
                                                                    bArr = bArrA4;
                                                                    bArr2 = bArrA3;
                                                                    yp.a(httpURLConnectionA2, this.f18697b);
                                                                    final d dVarA3 = d.a().a(responseCode).a(bArr2).b(bArr).a(jElapsedRealtime2 - jElapsedRealtime4).a(th4).a();
                                                                    cVar.f18705h.execute(new Runnable() { // from class: com.applovin.impl.iv
                                                                        @Override // java.lang.Runnable
                                                                        public final void run() {
                                                                            eg.b.a(cVar, dVarA3);
                                                                        }
                                                                    });
                                                                }
                                                            }
                                                        } catch (Throwable th22) {
                                                            if (errorStream2 == null) {
                                                                throw th22;
                                                            }
                                                            try {
                                                                errorStream2.close();
                                                                throw th22;
                                                            } catch (Throwable th23) {
                                                                th22.addSuppressed(th23);
                                                                throw th22;
                                                            }
                                                            th = th;
                                                            bArrA4 = null;
                                                            this.f18697b.J().a("NetworkCommunicationThread", th4);
                                                            HashMap map5 = new HashMap();
                                                            CollectionUtils.putStringIfValid("details", "responseErrorDataInputStream", map5);
                                                            this.f18697b.E().a("NetworkCommunicationThread", "processRequest", th, map5);
                                                            bArr = bArrA4;
                                                            bArr2 = bArrA3;
                                                            yp.a(httpURLConnectionA2, this.f18697b);
                                                            final d dVarA4 = d.a().a(responseCode).a(bArr2).b(bArr).a(jElapsedRealtime2 - jElapsedRealtime4).a(th4).a();
                                                            cVar.f18705h.execute(new Runnable() { // from class: com.applovin.impl.iv
                                                                @Override // java.lang.Runnable
                                                                public final void run() {
                                                                    eg.b.a(cVar, dVarA4);
                                                                }
                                                            });
                                                        }
                                                    } catch (Throwable th24) {
                                                        th = th24;
                                                        bArrA4 = null;
                                                    }
                                                    bArr = bArrA4;
                                                    bArr2 = bArrA3;
                                                } else {
                                                    bArr2 = bArrA3;
                                                    bArr = null;
                                                }
                                                yp.a(httpURLConnectionA2, this.f18697b);
                                                final d dVarA5 = d.a().a(responseCode).a(bArr2).b(bArr).a(jElapsedRealtime2 - jElapsedRealtime4).a(th4).a();
                                                cVar.f18705h.execute(new Runnable() { // from class: com.applovin.impl.iv
                                                    @Override // java.lang.Runnable
                                                    public final void run() {
                                                        eg.b.a(cVar, dVarA5);
                                                    }
                                                });
                                            } catch (Throwable th25) {
                                                yp.a(httpURLConnectionA2, this.f18697b);
                                                throw th25;
                                            }
                                        }
                                    }
                                }
                                bArr2 = bArrA3;
                                bArr = null;
                                th4 = null;
                            } catch (Throwable th26) {
                                if (inputStream6 == null) {
                                    throw th26;
                                }
                                try {
                                    inputStream6.close();
                                    throw th26;
                                } catch (Throwable th27) {
                                    th26.addSuppressed(th27);
                                    throw th26;
                                }
                                th = th;
                                bArrA3 = null;
                                HashMap map6 = new HashMap();
                                CollectionUtils.putStringIfValid("details", "responseDataInputStream", map6);
                                this.f18697b.E().a("NetworkCommunicationThread", "processRequest", th, map6);
                                throw th;
                            }
                        } catch (Throwable th28) {
                            th = th28;
                            bArrA3 = null;
                        }
                    } else {
                        bArr = null;
                        th4 = null;
                        bArr2 = null;
                    }
                } catch (Throwable th29) {
                    th4 = th29;
                    bArrA3 = null;
                    jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    this.f18697b.J().a("NetworkCommunicationThread", th4);
                    this.f18697b.J();
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f18697b.J().d("NetworkCommunicationThread", "Failed to make HTTP request", th4);
                    }
                    if (httpURLConnectionA2 != null) {
                        errorStream2 = httpURLConnectionA2.getErrorStream();
                        bArrA4 = e4.a(errorStream2, this.f18697b);
                        if (errorStream2 != null) {
                            errorStream2.close();
                        }
                        bArr = bArrA4;
                        bArr2 = bArrA3;
                    } else {
                        bArr2 = bArrA3;
                        bArr = null;
                    }
                    yp.a(httpURLConnectionA2, this.f18697b);
                    final d dVarA6 = d.a().a(responseCode).a(bArr2).b(bArr).a(jElapsedRealtime2 - jElapsedRealtime4).a(th4).a();
                    cVar.f18705h.execute(new Runnable() { // from class: com.applovin.impl.iv
                        @Override // java.lang.Runnable
                        public final void run() {
                            eg.b.a(cVar, dVarA6);
                        }
                    });
                }
            } catch (Throwable th30) {
                th4 = th30;
                httpURLConnectionA2 = null;
            }
            yp.a(httpURLConnectionA2, this.f18697b);
            final d dVarA7 = d.a().a(responseCode).a(bArr2).b(bArr).a(jElapsedRealtime2 - jElapsedRealtime4).a(th4).a();
            cVar.f18705h.execute(new Runnable() { // from class: com.applovin.impl.iv
                @Override // java.lang.Runnable
                public final void run() {
                    eg.b.a(cVar, dVarA7);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(c cVar, d dVar) {
            cVar.f18704g.accept(dVar);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws Throwable {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    a();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c implements Comparable {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final AtomicInteger f18698j = new AtomicInteger();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f18699a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f18700b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Map f18701c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final byte[] f18702d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f18703f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final androidx.core.util.a f18704g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Executor f18705h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final int f18706i;

        /* JADX INFO: compiled from: source.java */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private String f18707a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private String f18708b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private Map f18709c = new HashMap();

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private byte[] f18710d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private int f18711e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private androidx.core.util.a f18712f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private Executor f18713g;

            public a a(int i11) {
                this.f18711e = i11;
                return this;
            }

            public a a(androidx.core.util.a aVar) {
                this.f18712f = aVar;
                return this;
            }

            public a a(String str) {
                this.f18707a = str;
                return this;
            }

            public a a(String str, String str2) {
                this.f18709c.put(str, str2);
                return this;
            }

            public a a(Map map) {
                if (map == null) {
                    map = new HashMap();
                }
                this.f18709c = map;
                return this;
            }

            public a a(Executor executor) {
                this.f18713g = executor;
                return this;
            }

            public a a(byte[] bArr) {
                this.f18710d = bArr;
                return this;
            }

            public c a() {
                return new c(this);
            }

            public a b(String str) {
                this.f18708b = str;
                return this;
            }
        }

        private c(a aVar) {
            this.f18699a = aVar.f18707a;
            this.f18700b = aVar.f18708b;
            this.f18701c = aVar.f18709c != null ? aVar.f18709c : Collections.emptyMap();
            this.f18702d = aVar.f18710d;
            this.f18703f = aVar.f18711e;
            this.f18704g = aVar.f18712f;
            this.f18705h = aVar.f18713g;
            this.f18706i = f18698j.incrementAndGet();
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            return this.f18706i - cVar.f18706i;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f18714a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final byte[] f18715b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final byte[] f18716c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f18717d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Throwable f18718e;

        /* JADX INFO: compiled from: source.java */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f18719a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private byte[] f18720b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private byte[] f18721c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private long f18722d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private Throwable f18723e;

            public a a(int i11) {
                this.f18719a = i11;
                return this;
            }

            public a a(long j11) {
                this.f18722d = j11;
                return this;
            }

            public a a(Throwable th2) {
                this.f18723e = th2;
                return this;
            }

            public a a(byte[] bArr) {
                this.f18720b = bArr;
                return this;
            }

            public d a() {
                return new d(this);
            }

            public a b(byte[] bArr) {
                this.f18721c = bArr;
                return this;
            }
        }

        private d(a aVar) {
            this.f18714a = aVar.f18719a;
            this.f18715b = aVar.f18720b;
            this.f18716c = aVar.f18721c;
            this.f18717d = aVar.f18722d;
            this.f18718e = aVar.f18723e;
        }

        public static a a() {
            return new a();
        }

        public int b() {
            return this.f18714a;
        }

        public int c() throws Throwable {
            Throwable th2 = this.f18718e;
            if (th2 == null) {
                return this.f18714a;
            }
            throw th2;
        }

        public byte[] d() throws Throwable {
            Throwable th2 = this.f18718e;
            if (th2 == null) {
                return this.f18715b;
            }
            throw th2;
        }

        public long e() {
            return this.f18717d;
        }

        public byte[] f() {
            return this.f18716c;
        }
    }

    public eg(com.applovin.impl.sdk.j jVar) {
        this.f18695b = jVar;
    }

    public void a() {
        for (int i11 = 0; i11 < ((Integer) this.f18695b.a(sj.X)).intValue(); i11++) {
            new b(this.f18694a, i11, this.f18695b).start();
        }
    }

    public void a(c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException("No request specified");
        }
        this.f18694a.add(cVar);
    }
}
