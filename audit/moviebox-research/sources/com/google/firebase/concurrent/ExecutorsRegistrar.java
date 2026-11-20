package com.google.firebase.concurrent;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.StrictMode;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import rj.b0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ThreadPoolCreation"})
public class ExecutorsRegistrar implements ComponentRegistrar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final rj.u<ScheduledExecutorService> f38966a = new rj.u<>(new bl.b() { // from class: com.google.firebase.concurrent.s
        @Override // bl.b
        public final Object get() {
            return ExecutorsRegistrar.p();
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final rj.u<ScheduledExecutorService> f38967b = new rj.u<>(new bl.b() { // from class: com.google.firebase.concurrent.t
        @Override // bl.b
        public final Object get() {
            return ExecutorsRegistrar.q();
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final rj.u<ScheduledExecutorService> f38968c = new rj.u<>(new bl.b() { // from class: com.google.firebase.concurrent.u
        @Override // bl.b
        public final Object get() {
            return ExecutorsRegistrar.r();
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final rj.u<ScheduledExecutorService> f38969d = new rj.u<>(new bl.b() { // from class: com.google.firebase.concurrent.v
        @Override // bl.b
        public final Object get() {
            return ExecutorsRegistrar.s();
        }
    });

    public static StrictMode.ThreadPolicy i() {
        StrictMode.ThreadPolicy.Builder builderDetectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 23) {
            builderDetectNetwork.detectResourceMismatches();
            if (i11 >= 26) {
                builderDetectNetwork.detectUnbufferedIo();
            }
        }
        return builderDetectNetwork.penaltyLog().build();
    }

    public static ThreadFactory j(String str, int i11) {
        return new b(str, i11, null);
    }

    public static ThreadFactory k(String str, int i11, StrictMode.ThreadPolicy threadPolicy) {
        return new b(str, i11, threadPolicy);
    }

    public static /* synthetic */ ScheduledExecutorService l(rj.e eVar) {
        return f38966a.get();
    }

    public static /* synthetic */ ScheduledExecutorService m(rj.e eVar) {
        return f38968c.get();
    }

    public static /* synthetic */ ScheduledExecutorService n(rj.e eVar) {
        return f38967b.get();
    }

    public static /* synthetic */ Executor o(rj.e eVar) {
        return UiExecutor.INSTANCE;
    }

    public static /* synthetic */ ScheduledExecutorService p() {
        return u(Executors.newFixedThreadPool(4, k("Firebase Background", 10, i())));
    }

    public static /* synthetic */ ScheduledExecutorService q() {
        return u(Executors.newFixedThreadPool(Math.max(2, Runtime.getRuntime().availableProcessors()), k("Firebase Lite", 0, t())));
    }

    public static /* synthetic */ ScheduledExecutorService r() {
        return u(Executors.newCachedThreadPool(j("Firebase Blocking", 11)));
    }

    public static /* synthetic */ ScheduledExecutorService s() {
        return Executors.newSingleThreadScheduledExecutor(j("Firebase Scheduler", 0));
    }

    public static StrictMode.ThreadPolicy t() {
        return new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
    }

    public static ScheduledExecutorService u(ExecutorService executorService) {
        return new o(executorService, f38969d.get());
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<rj.c<?>> getComponents() {
        return Arrays.asList(rj.c.f(b0.a(qj.a.class, ScheduledExecutorService.class), b0.a(qj.a.class, ExecutorService.class), b0.a(qj.a.class, Executor.class)).f(new rj.h() { // from class: com.google.firebase.concurrent.w
            @Override // rj.h
            public final Object a(rj.e eVar) {
                return ExecutorsRegistrar.l(eVar);
            }
        }).d(), rj.c.f(b0.a(qj.b.class, ScheduledExecutorService.class), b0.a(qj.b.class, ExecutorService.class), b0.a(qj.b.class, Executor.class)).f(new rj.h() { // from class: com.google.firebase.concurrent.x
            @Override // rj.h
            public final Object a(rj.e eVar) {
                return ExecutorsRegistrar.m(eVar);
            }
        }).d(), rj.c.f(b0.a(qj.c.class, ScheduledExecutorService.class), b0.a(qj.c.class, ExecutorService.class), b0.a(qj.c.class, Executor.class)).f(new rj.h() { // from class: com.google.firebase.concurrent.y
            @Override // rj.h
            public final Object a(rj.e eVar) {
                return ExecutorsRegistrar.n(eVar);
            }
        }).d(), rj.c.e(b0.a(qj.d.class, Executor.class)).f(new rj.h() { // from class: com.google.firebase.concurrent.z
            @Override // rj.h
            public final Object a(rj.e eVar) {
                return ExecutorsRegistrar.o(eVar);
            }
        }).d());
    }
}
