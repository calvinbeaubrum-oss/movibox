package com.google.firebase.remoteconfig.internal;

import android.text.format.DateUtils;
import androidx.annotation.Nullable;
import cl.g;
import cl.k;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigFetchThrottledException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f41079j = TimeUnit.HOURS.toSeconds(12);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f41080k = {2, 4, 8, 16, 32, 64, 128, 256};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f41081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bl.b<nj.a> f41082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f41083c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Clock f41084d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Random f41085e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final zl.d f41086f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConfigFetchHttpClient f41087g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f41088h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, String> f41089i;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Date f41090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f41091b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.google.firebase.remoteconfig.internal.a f41092c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final String f41093d;

        public a(Date date, int i11, com.google.firebase.remoteconfig.internal.a aVar, @Nullable String str) {
            this.f41090a = date;
            this.f41091b = i11;
            this.f41092c = aVar;
            this.f41093d = str;
        }

        public static a a(Date date) {
            return new a(date, 1, null, null);
        }

        public static a b(com.google.firebase.remoteconfig.internal.a aVar, String str) {
            return new a(aVar.e(), 0, aVar, str);
        }

        public static a c(Date date) {
            return new a(date, 2, null, null);
        }

        public com.google.firebase.remoteconfig.internal.a d() {
            return this.f41092c;
        }

        @Nullable
        public String e() {
            return this.f41093d;
        }

        public int f() {
            return this.f41091b;
        }
    }

    public b(g gVar, bl.b<nj.a> bVar, Executor executor, Clock clock, Random random, zl.d dVar, ConfigFetchHttpClient configFetchHttpClient, c cVar, Map<String, String> map) {
        this.f41081a = gVar;
        this.f41082b = bVar;
        this.f41083c = executor;
        this.f41084d = clock;
        this.f41085e = random;
        this.f41086f = dVar;
        this.f41087g = configFetchHttpClient;
        this.f41088h = cVar;
        this.f41089i = map;
    }

    public static /* synthetic */ Task s(a aVar, com.google.firebase.remoteconfig.internal.a aVar2) throws Exception {
        return Tasks.forResult(aVar);
    }

    public final boolean e(long j11, Date date) {
        Date dateE = this.f41088h.e();
        if (dateE.equals(c.f41094d)) {
            return false;
        }
        return date.before(new Date(dateE.getTime() + TimeUnit.SECONDS.toMillis(j11)));
    }

    public final FirebaseRemoteConfigServerException f(FirebaseRemoteConfigServerException firebaseRemoteConfigServerException) throws FirebaseRemoteConfigClientException {
        String str;
        int httpStatusCode = firebaseRemoteConfigServerException.getHttpStatusCode();
        if (httpStatusCode == 401) {
            str = "The request did not have the required credentials. Please make sure your google-services.json is valid.";
        } else if (httpStatusCode == 403) {
            str = "The user is not authorized to access the project. Please make sure you are using the API key that corresponds to your Firebase project.";
        } else {
            if (httpStatusCode == 429) {
                throw new FirebaseRemoteConfigClientException("The throttled response from the server was not handled correctly by the FRC SDK.");
            }
            if (httpStatusCode != 500) {
                switch (httpStatusCode) {
                    case 502:
                    case 503:
                    case 504:
                        str = "The server is unavailable. Please try again later.";
                        break;
                    default:
                        str = "The server returned an unexpected error.";
                        break;
                }
            } else {
                str = "There was an internal server error.";
            }
        }
        return new FirebaseRemoteConfigServerException(firebaseRemoteConfigServerException.getHttpStatusCode(), "Fetch failed: " + str, firebaseRemoteConfigServerException);
    }

    public final String g(long j11) {
        return String.format("Fetch is throttled. Please wait before calling fetch again: %s", DateUtils.formatElapsedTime(TimeUnit.MILLISECONDS.toSeconds(j11)));
    }

    public Task<a> h() {
        return i(this.f41088h.f());
    }

    public Task<a> i(final long j11) {
        return this.f41086f.e().continueWithTask(this.f41083c, new Continuation() { // from class: zl.e
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return this.f82076a.r(j11, task);
            }
        });
    }

    public final a j(String str, String str2, Date date) throws FirebaseRemoteConfigException {
        try {
            a aVarFetch = this.f41087g.fetch(this.f41087g.d(), str, str2, p(), this.f41088h.d(), this.f41089i, n(), date);
            if (aVarFetch.e() != null) {
                this.f41088h.j(aVarFetch.e());
            }
            this.f41088h.g();
            return aVarFetch;
        } catch (FirebaseRemoteConfigServerException e11) {
            c.a aVarW = w(e11.getHttpStatusCode(), date);
            if (v(aVarW, e11.getHttpStatusCode())) {
                throw new FirebaseRemoteConfigFetchThrottledException(aVarW.a().getTime());
            }
            throw f(e11);
        }
    }

    public final Task<a> k(String str, String str2, Date date) {
        try {
            final a aVarJ = j(str, str2, date);
            return aVarJ.f() != 0 ? Tasks.forResult(aVarJ) : this.f41086f.k(aVarJ.d()).onSuccessTask(this.f41083c, new SuccessContinuation() { // from class: zl.h
                @Override // com.google.android.gms.tasks.SuccessContinuation
                public final Task then(Object obj) {
                    return com.google.firebase.remoteconfig.internal.b.s(aVarJ, (com.google.firebase.remoteconfig.internal.a) obj);
                }
            });
        } catch (FirebaseRemoteConfigException e11) {
            return Tasks.forException(e11);
        }
    }

    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public final Task<a> r(Task<com.google.firebase.remoteconfig.internal.a> task, long j11) {
        Task taskContinueWithTask;
        final Date date = new Date(this.f41084d.currentTimeMillis());
        if (task.isSuccessful() && e(j11, date)) {
            return Tasks.forResult(a.c(date));
        }
        Date dateM = m(date);
        if (dateM != null) {
            taskContinueWithTask = Tasks.forException(new FirebaseRemoteConfigFetchThrottledException(g(dateM.getTime() - date.getTime()), dateM.getTime()));
        } else {
            final Task<String> id2 = this.f41081a.getId();
            final Task<k> taskA = this.f41081a.a(false);
            taskContinueWithTask = Tasks.whenAllComplete((Task<?>[]) new Task[]{id2, taskA}).continueWithTask(this.f41083c, new Continuation() { // from class: zl.f
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task2) {
                    return this.f82078a.t(id2, taskA, date, task2);
                }
            });
        }
        return taskContinueWithTask.continueWithTask(this.f41083c, new Continuation() { // from class: zl.g
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                return this.f82082a.u(date, task2);
            }
        });
    }

    @Nullable
    public final Date m(Date date) {
        Date dateA = this.f41088h.a().a();
        if (date.before(dateA)) {
            return dateA;
        }
        return null;
    }

    public final Long n() {
        nj.a aVar = this.f41082b.get();
        if (aVar == null) {
            return null;
        }
        return (Long) aVar.e(true).get("_fot");
    }

    public final long o(int i11) {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        int[] iArr = f41080k;
        long millis = timeUnit.toMillis(iArr[Math.min(i11, iArr.length) - 1]);
        return (millis / 2) + ((long) this.f41085e.nextInt((int) millis));
    }

    public final Map<String, String> p() {
        HashMap map = new HashMap();
        nj.a aVar = this.f41082b.get();
        if (aVar == null) {
            return map;
        }
        for (Map.Entry<String, Object> entry : aVar.e(false).entrySet()) {
            map.put(entry.getKey(), entry.getValue().toString());
        }
        return map;
    }

    public final boolean q(int i11) {
        return i11 == 429 || i11 == 502 || i11 == 503 || i11 == 504;
    }

    public final /* synthetic */ Task t(Task task, Task task2, Date date, Task task3) throws Exception {
        if (task.isSuccessful()) {
            return !task2.isSuccessful() ? Tasks.forException(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation auth token for fetch.", task2.getException())) : k((String) task.getResult(), ((k) task2.getResult()).b(), date);
        }
        return Tasks.forException(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation ID for fetch.", task.getException()));
    }

    public final /* synthetic */ Task u(Date date, Task task) throws Exception {
        y(task, date);
        return task;
    }

    public final boolean v(c.a aVar, int i11) {
        return aVar.b() > 1 || i11 == 429;
    }

    public final c.a w(int i11, Date date) {
        if (q(i11)) {
            x(date);
        }
        return this.f41088h.a();
    }

    public final void x(Date date) {
        int iB = this.f41088h.a().b() + 1;
        this.f41088h.h(iB, new Date(date.getTime() + o(iB)));
    }

    public final void y(Task<a> task, Date date) {
        if (task.isSuccessful()) {
            this.f41088h.l(date);
            return;
        }
        Exception exception = task.getException();
        if (exception == null) {
            return;
        }
        if (exception instanceof FirebaseRemoteConfigFetchThrottledException) {
            this.f41088h.m();
        } else {
            this.f41088h.k();
        }
    }
}
