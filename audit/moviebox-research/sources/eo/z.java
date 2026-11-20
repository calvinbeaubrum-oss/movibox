package eo;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import androidx.compose.animation.core.j0;
import com.google.common.io.BaseEncoding;
import com.google.common.util.concurrent.Futures;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.a0;
import io.d0;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Member;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p007do.g0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class z {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f64329i = TimeUnit.MINUTES.toMillis(1);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final com.google.common.util.concurrent.s f64330j = Futures.h();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f64331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g0 f64332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReadWriteLock f64333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedTransferQueue f64334d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicReference f64335e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WeakReference f64336f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.google.common.util.concurrent.s f64337g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public p007do.p f64338h;

    public z(s sVar) {
        this.f64331a = sVar;
        g0 g0Var = new g0(this);
        this.f64332b = g0Var;
        this.f64333c = d0.d();
        this.f64334d = new LinkedTransferQueue();
        this.f64335e = new AtomicReference();
        try {
            ((Application) sVar.d().q()).registerActivityLifecycleCallbacks(g0Var);
        } catch (Throwable unused) {
        }
    }

    public final com.google.common.util.concurrent.s a(int i11, final String str) {
        com.polygamma.ogm.w wVar;
        com.polygamma.ogm.w wVar2;
        if (i11 == 1) {
            return this.f64331a.d().p(new Callable() { // from class: eo.y
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f64327a.f(str);
                }
            });
        }
        boolean zIsEmpty = this.f64334d.isEmpty();
        this.f64334d.add(str);
        if (!zIsEmpty) {
            return Futures.g(null);
        }
        Lock lockWriteLock = this.f64333c.writeLock();
        lockWriteLock.lock();
        try {
            WeakReference weakReference = this.f64336f;
            p007do.c cVar = weakReference == null ? null : (p007do.c) weakReference.get();
            if (cVar == null) {
                c(0L);
            } else if (this.f64335e.get() == null) {
                do {
                    wVar = (com.polygamma.ogm.w) this.f64335e.get();
                    if (wVar == null || wVar.f48889a != cVar) {
                        wVar2 = new com.polygamma.ogm.w(this, cVar);
                    }
                } while (!j0.a(this.f64335e, wVar, wVar2));
                this.f64331a.d().w().execute(wVar2);
            }
            lockWriteLock.unlock();
            return Futures.g(null);
        } catch (Throwable th2) {
            lockWriteLock.unlock();
            throw th2;
        }
    }

    public final void b() {
        Lock lockWriteLock = this.f64333c.writeLock();
        this.f64335e.set(null);
        lockWriteLock.lock();
        try {
            com.google.common.util.concurrent.s sVar = this.f64337g;
            com.google.common.util.concurrent.s sVar2 = f64330j;
            if (sVar == sVar2) {
                lockWriteLock.unlock();
                return;
            }
            this.f64337g = sVar2;
            lockWriteLock.unlock();
            io.g.c(sVar);
            lockWriteLock.lock();
            try {
                this.f64334d.clear();
                WeakReference weakReference = this.f64336f;
                p007do.c cVar = weakReference == null ? null : (p007do.c) weakReference.get();
                this.f64336f = null;
                lockWriteLock.unlock();
                if (cVar != null) {
                    cVar.f63438f.run();
                }
                this.f64338h = null;
            } catch (Throwable th2) {
                lockWriteLock.unlock();
                throw th2;
            }
        } catch (Throwable th3) {
            lockWriteLock.unlock();
            throw th3;
        }
    }

    public final void c(long j11) {
        if (this.f64337g == null) {
            this.f64337g = this.f64331a.d().w().schedule(new Runnable() { // from class: eo.u
                @Override // java.lang.Runnable
                public final void run() {
                    this.f64323a.i();
                }
            }, j11, TimeUnit.MILLISECONDS);
        }
    }

    public final void d(p007do.c cVar) {
        Lock lockWriteLock = this.f64333c.writeLock();
        lockWriteLock.lock();
        try {
            WeakReference weakReference = this.f64336f;
            if (cVar != (weakReference == null ? null : (p007do.c) weakReference.get())) {
                return;
            }
            this.f64336f = null;
            cVar.f63438f.run();
            this.f64338h = null;
            this.f64335e.set(null);
            if (this.f64337g == null && !this.f64334d.isEmpty()) {
                c(f64329i);
            }
        } finally {
            lockWriteLock.unlock();
        }
    }

    public final byte[] e(Uri uri) {
        String strE = com.google.common.base.p.e(uri.getPath());
        try {
            if ("/entropy".equalsIgnoreCase(strE)) {
                return this.f64331a.A(true, null);
            }
            if (strE.startsWith("/cram")) {
                Context contextQ = this.f64331a.d().q();
                String queryParameter = uri.getQueryParameter(CampaignEx.JSON_KEY_AD_R);
                if (com.google.common.base.p.b(queryParameter)) {
                    throw new IllegalArgumentException();
                }
                return p007do.t.b(contextQ, new JSONObject(new String(BaseEncoding.b().c(queryParameter), StandardCharsets.UTF_8)));
            }
            if (!strE.startsWith("/okayomit")) {
                return "UNKNOWN".getBytes(StandardCharsets.UTF_8);
            }
            String queryParameter2 = uri.getQueryParameter(CampaignEx.JSON_KEY_AD_R);
            if (com.google.common.base.p.b(queryParameter2)) {
                throw new IllegalArgumentException();
            }
            return g(new JSONObject(new String(BaseEncoding.b().c(queryParameter2), StandardCharsets.UTF_8)));
        } catch (Exception e11) {
            throw new RuntimeException(e11);
        }
    }

    public final /* synthetic */ byte[] f(String str) {
        return e(Uri.parse(str));
    }

    public final byte[] g(JSONObject jSONObject) throws ExecutionException, JSONException, InterruptedException, TimeoutException, IOException {
        JSONArray jSONArray = jSONObject.getJSONArray("ops");
        JSONArray jSONArray2 = new JSONArray();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            JSONObject jSONObjectH = h(jSONArray.getJSONObject(i11));
            jSONObjectH.put("i", i11);
            if (jSONObjectH.getInt("s") != 0) {
                jSONArray2.put(jSONObjectH);
                break;
            }
            if (jSONObjectH.has(CampaignEx.JSON_KEY_AD_R) && !jSONObjectH.isNull(CampaignEx.JSON_KEY_AD_R)) {
                jSONArray2.put(jSONObjectH);
            }
        }
        return jSONArray2.toString().getBytes(StandardCharsets.UTF_8);
    }

    public final JSONObject h(JSONObject jSONObject) throws ExecutionException, JSONException, InterruptedException, TimeoutException, IOException {
        Object objOptString;
        Object str;
        int i11 = jSONObject.getInt("op");
        Object obj = null;
        if (jSONObject.has("imm")) {
            objOptString = jSONObject.isNull("imm") ? null : jSONObject.get("imm");
            if (i11 == 4 || i11 == 5 || i11 == 6) {
                com.google.common.util.concurrent.v vVarN = this.f64331a.d().n();
                final androidx.core.util.l<Member> lVarR = a0.r((String) objOptString);
                Objects.requireNonNull(lVarR);
                objOptString = vVarN.submit(new Callable() { // from class: eo.x
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return (Member) lVarR.get();
                    }
                }).get(30L, TimeUnit.SECONDS);
            }
        } else if (jSONObject.has("opq")) {
            objOptString = jSONObject.isNull("opq") ? null : jSONObject.optString("opq");
            if ("cx".equals(objOptString)) {
                objOptString = p007do.p.f63491d;
            } else if ("ax".equals(objOptString)) {
                objOptString = this.f64332b.f63456a.get();
            } else if ("bg".equals(objOptString)) {
                objOptString = p007do.p.f63492e;
            } else if ("fg".equals(objOptString)) {
                objOptString = p007do.p.f63493f;
            }
        } else {
            objOptString = null;
        }
        int i12 = 0;
        try {
            if (i11 == 0) {
                this.f64338h = null;
                str = null;
            } else {
                p007do.p pVar = this.f64338h;
                if (pVar == null) {
                    pVar = new p007do.p(this.f64331a.d());
                    this.f64338h = pVar;
                }
                str = pVar.b(i11, objOptString);
            }
        } catch (Exception e11) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                PrintStream printStream = new PrintStream(byteArrayOutputStream);
                try {
                    e11.printStackTrace(printStream);
                    printStream.flush();
                    str = new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8);
                    printStream.close();
                    byteArrayOutputStream.close();
                    i12 = 1;
                } catch (Throwable th2) {
                    try {
                        printStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th5) {
                    th4.addSuppressed(th5);
                }
                throw th4;
            }
        }
        JSONObject jSONObjectPut = new JSONObject().put("s", i12);
        if (i11 == 1 && ((str instanceof Boolean) || (str instanceof String) || (str instanceof Number))) {
            obj = str;
        }
        return jSONObjectPut.put(CampaignEx.JSON_KEY_AD_R, obj);
    }

    public final void i() {
        p007do.c cVar;
        com.polygamma.ogm.w wVar;
        com.polygamma.ogm.w wVar2;
        Activity activity = (Activity) this.f64332b.f63456a.get();
        try {
            cVar = new p007do.c(this.f64331a.d(), activity, new androidx.core.util.a() { // from class: eo.v
                @Override // androidx.core.util.a
                public final void accept(Object obj) {
                    this.f64324a.d((p007do.c) obj);
                }
            }, new com.google.common.base.f() { // from class: eo.w
                @Override // com.google.common.base.f
                public final Object apply(Object obj) {
                    return this.f64325a.e((Uri) obj);
                }
            });
            try {
                cVar.c();
                Lock lock = this.f64333c.readLock();
                Lock lockWriteLock = this.f64333c.writeLock();
                lock.lock();
                try {
                    if (cVar == null) {
                        if (this.f64337g != f64330j) {
                            this.f64337g = null;
                            c(f64329i);
                        }
                        lock.unlock();
                        return;
                    }
                    com.google.common.util.concurrent.s sVar = this.f64337g;
                    if (sVar == null || sVar == f64330j) {
                        this.f64336f = new WeakReference(cVar);
                        lock.unlock();
                        return;
                    }
                    lock.unlock();
                    lockWriteLock.lock();
                    try {
                        this.f64336f = new WeakReference(cVar);
                        do {
                            wVar = (com.polygamma.ogm.w) this.f64335e.get();
                            if (wVar == null || wVar.f48889a != cVar) {
                                wVar2 = new com.polygamma.ogm.w(this, cVar);
                            }
                        } while (!j0.a(this.f64335e, wVar, wVar2));
                        this.f64331a.d().w().execute(wVar2);
                    } finally {
                        this.f64337g = null;
                        lockWriteLock.unlock();
                    }
                } catch (Throwable th2) {
                    lock.unlock();
                    throw th2;
                }
            } catch (Throwable th3) {
                cVar.f63438f.run();
                throw new RuntimeException("failed to prepare view", th3);
            }
        } catch (Throwable unused) {
            j0.a(this.f64332b.f63456a, activity, null);
            cVar = null;
        }
    }
}
