package com.cloud.tmc.miniapp.performanceanalyse.screen;

import android.os.CountDownTimer;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0344a f31561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<Integer> f31562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f31563c;

    /* JADX INFO: renamed from: com.cloud.tmc.miniapp.performanceanalyse.screen.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0344a {
        void OooO00o();

        void b();

        void c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(long j11, long j12, List<Integer> _timePoints, InterfaceC0344a timeCallback) {
        super(j11, j12);
        Intrinsics.g(_timePoints, "_timePoints");
        Intrinsics.g(timeCallback, "timeCallback");
        this.f31561a = timeCallback;
        this.f31562b = CollectionsKt___CollectionsKt.M0(_timePoints);
    }

    public final long a() {
        return ((long) this.f31563c) * 1000;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.f31561a.OooO00o();
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j11) {
        this.f31563c++;
        if (this.f31562b.size() <= 0) {
            return;
        }
        if (this.f31563c != this.f31562b.get(0).intValue()) {
            this.f31561a.b();
        } else {
            this.f31562b.remove(0);
            this.f31561a.c();
        }
    }
}
