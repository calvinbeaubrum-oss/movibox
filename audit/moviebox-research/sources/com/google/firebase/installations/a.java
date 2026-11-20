package com.google.firebase.installations;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cl.g;
import cl.i;
import cl.j;
import cl.k;
import cl.l;
import cl.m;
import cl.n;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.remote.InstallationResponse;
import com.google.firebase.installations.remote.TokenResult;
import com.google.firebase.installations.remote.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import jj.e;
import rj.u;
import zk.h;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class a implements g {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Object f40675m = new Object();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ThreadFactory f40676n = new ThreadFactoryC0445a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f40677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f40678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PersistedInstallation f40679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n f40680d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u<el.a> f40681e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final l f40682f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f40683g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ExecutorService f40684h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Executor f40685i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f40686j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Set<dl.a> f40687k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<m> f40688l;

    /* JADX INFO: renamed from: com.google.firebase.installations.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class ThreadFactoryC0445a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f40689a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        @SuppressLint({"ThreadPoolCreation"})
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("firebase-installations-executor-%d", Integer.valueOf(this.f40689a.getAndIncrement())));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f40690a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f40691b;

        static {
            int[] iArr = new int[TokenResult.ResponseCode.values().length];
            f40691b = iArr;
            try {
                iArr[TokenResult.ResponseCode.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f40691b[TokenResult.ResponseCode.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f40691b[TokenResult.ResponseCode.AUTH_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[InstallationResponse.ResponseCode.values().length];
            f40690a = iArr2;
            try {
                iArr2[InstallationResponse.ResponseCode.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f40690a[InstallationResponse.ResponseCode.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @SuppressLint({"ThreadPoolCreation"})
    public a(ExecutorService executorService, Executor executor, e eVar, c cVar, PersistedInstallation persistedInstallation, n nVar, u<el.a> uVar, l lVar) {
        this.f40683g = new Object();
        this.f40687k = new HashSet();
        this.f40688l = new ArrayList();
        this.f40677a = eVar;
        this.f40678b = cVar;
        this.f40679c = persistedInstallation;
        this.f40680d = nVar;
        this.f40681e = uVar;
        this.f40682f = lVar;
        this.f40684h = executorService;
        this.f40685i = executor;
    }

    @SuppressLint({"ThreadPoolCreation"})
    public a(final e eVar, @NonNull bl.b<h> bVar, @NonNull ExecutorService executorService, @NonNull Executor executor) {
        this(executorService, executor, eVar, new c(eVar.j(), bVar), new PersistedInstallation(eVar), n.c(), new u(new bl.b() { // from class: cl.e
            @Override // bl.b
            public final Object get() {
                return com.google.firebase.installations.a.y(eVar);
            }
        }), new l());
    }

    @NonNull
    public static a p() {
        return q(e.k());
    }

    @NonNull
    public static a q(@NonNull e eVar) {
        Preconditions.checkArgument(eVar != null, "Null is not a valid value of FirebaseApp.");
        return (a) eVar.i(g.class);
    }

    public static /* synthetic */ el.a y(e eVar) {
        return new el.a(eVar);
    }

    public final String A(com.google.firebase.installations.local.b bVar) {
        if ((!this.f40677a.l().equals("CHIME_ANDROID_SDK") && !this.f40677a.t()) || !bVar.m()) {
            return this.f40682f.a();
        }
        String strF = o().f();
        return TextUtils.isEmpty(strF) ? this.f40682f.a() : strF;
    }

    public final com.google.firebase.installations.local.b B(com.google.firebase.installations.local.b bVar) throws FirebaseInstallationsException {
        InstallationResponse installationResponseD = this.f40678b.d(l(), bVar.d(), t(), m(), (bVar.d() == null || bVar.d().length() != 11) ? null : o().i());
        int i11 = b.f40690a[installationResponseD.e().ordinal()];
        if (i11 == 1) {
            return bVar.s(installationResponseD.c(), installationResponseD.d(), this.f40680d.b(), installationResponseD.b().c(), installationResponseD.b().d());
        }
        if (i11 == 2) {
            return bVar.q("BAD CONFIG");
        }
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
    }

    public final void C(Exception exc) {
        synchronized (this.f40683g) {
            try {
                Iterator<m> it = this.f40688l.iterator();
                while (it.hasNext()) {
                    if (it.next().a(exc)) {
                        it.remove();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void D(com.google.firebase.installations.local.b bVar) {
        synchronized (this.f40683g) {
            try {
                Iterator<m> it = this.f40688l.iterator();
                while (it.hasNext()) {
                    if (it.next().b(bVar)) {
                        it.remove();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final synchronized void E(String str) {
        this.f40686j = str;
    }

    public final synchronized void F(com.google.firebase.installations.local.b bVar, com.google.firebase.installations.local.b bVar2) {
        if (this.f40687k.size() != 0 && !TextUtils.equals(bVar.d(), bVar2.d())) {
            Iterator<dl.a> it = this.f40687k.iterator();
            while (it.hasNext()) {
                it.next().a(bVar2.d());
            }
        }
    }

    @Override // cl.g
    @NonNull
    public Task<k> a(final boolean z11) {
        z();
        Task<k> taskF = f();
        this.f40684h.execute(new Runnable() { // from class: cl.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f14959a.x(z11);
            }
        });
        return taskF;
    }

    public final Task<k> f() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        h(new i(this.f40680d, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public final Task<String> g() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        h(new j(taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    @Override // cl.g
    @NonNull
    public Task<String> getId() {
        z();
        String strN = n();
        if (strN != null) {
            return Tasks.forResult(strN);
        }
        Task<String> taskG = g();
        this.f40684h.execute(new Runnable() { // from class: cl.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f14961a.w();
            }
        });
        return taskG;
    }

    public final void h(m mVar) {
        synchronized (this.f40683g) {
            this.f40688l.add(mVar);
        }
    }

    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public final void v(boolean z11) {
        com.google.firebase.installations.local.b bVarB;
        com.google.firebase.installations.local.b bVarR = r();
        try {
            if (bVarR.i() || bVarR.l()) {
                bVarB = B(bVarR);
            } else {
                if (!z11 && !this.f40680d.f(bVarR)) {
                    return;
                }
                bVarB = k(bVarR);
            }
            u(bVarB);
            F(bVarR, bVarB);
            if (bVarB.k()) {
                E(bVarB.d());
            }
            if (bVarB.i()) {
                C(new FirebaseInstallationsException(FirebaseInstallationsException.Status.BAD_CONFIG));
            } else if (bVarB.j()) {
                C(new IOException("Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."));
            } else {
                D(bVarB);
            }
        } catch (FirebaseInstallationsException e11) {
            C(e11);
        }
    }

    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public final void x(final boolean z11) {
        com.google.firebase.installations.local.b bVarS = s();
        if (z11) {
            bVarS = bVarS.p();
        }
        D(bVarS);
        this.f40685i.execute(new Runnable() { // from class: cl.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f14963a.v(z11);
            }
        });
    }

    public final com.google.firebase.installations.local.b k(@NonNull com.google.firebase.installations.local.b bVar) throws FirebaseInstallationsException {
        TokenResult tokenResultE = this.f40678b.e(l(), bVar.d(), t(), bVar.f());
        int i11 = b.f40691b[tokenResultE.b().ordinal()];
        if (i11 == 1) {
            return bVar.o(tokenResultE.c(), tokenResultE.d(), this.f40680d.b());
        }
        if (i11 == 2) {
            return bVar.q("BAD CONFIG");
        }
        if (i11 != 3) {
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
        }
        E(null);
        return bVar.r();
    }

    @Nullable
    public String l() {
        return this.f40677a.m().b();
    }

    public String m() {
        return this.f40677a.m().c();
    }

    public final synchronized String n() {
        return this.f40686j;
    }

    public final el.a o() {
        return this.f40681e.get();
    }

    public final com.google.firebase.installations.local.b r() {
        com.google.firebase.installations.local.b bVarD;
        synchronized (f40675m) {
            try {
                cl.b bVarA = cl.b.a(this.f40677a.j(), "generatefid.lock");
                try {
                    bVarD = this.f40679c.d();
                    if (bVarA != null) {
                        bVarA.b();
                    }
                } catch (Throwable th2) {
                    if (bVarA != null) {
                        bVarA.b();
                    }
                    throw th2;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        return bVarD;
    }

    public final com.google.firebase.installations.local.b s() {
        com.google.firebase.installations.local.b bVarD;
        synchronized (f40675m) {
            try {
                cl.b bVarA = cl.b.a(this.f40677a.j(), "generatefid.lock");
                try {
                    bVarD = this.f40679c.d();
                    if (bVarD.j()) {
                        bVarD = this.f40679c.b(bVarD.t(A(bVarD)));
                    }
                    if (bVarA != null) {
                        bVarA.b();
                    }
                } catch (Throwable th2) {
                    if (bVarA != null) {
                        bVarA.b();
                    }
                    throw th2;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        return bVarD;
    }

    @Nullable
    public String t() {
        return this.f40677a.m().e();
    }

    public final void u(com.google.firebase.installations.local.b bVar) {
        synchronized (f40675m) {
            try {
                cl.b bVarA = cl.b.a(this.f40677a.j(), "generatefid.lock");
                try {
                    this.f40679c.b(bVar);
                    if (bVarA != null) {
                        bVarA.b();
                    }
                } catch (Throwable th2) {
                    if (bVarA != null) {
                        bVarA.b();
                    }
                    throw th2;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public final /* synthetic */ void w() {
        x(false);
    }

    public final void z() {
        Preconditions.checkNotEmpty(m(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkNotEmpty(t(), "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkNotEmpty(l(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkArgument(n.h(m()), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkArgument(n.g(l()), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }
}
