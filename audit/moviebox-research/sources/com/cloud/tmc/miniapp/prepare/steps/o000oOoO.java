package com.cloud.tmc.miniapp.prepare.steps;

import com.cloud.tmc.integration.utils.AppUtils;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class o000oOoO {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o000oOoO f31635a = new o000oOoO();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f31636b = LazyKt__LazyJVMKt.b(OooO00o.OooO00o);

    /* JADX INFO: compiled from: source.java */
    public static final class OooO00o extends Lambda implements Function0<Boolean> {
        public static final OooO00o OooO00o = new OooO00o();

        public OooO00o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Boolean invoke() {
            return Boolean.valueOf(AppUtils.C());
        }
    }

    @JvmStatic
    public static final w a() {
        if (!f31635a.d()) {
            return new u.d();
        }
        StepType STEP_TYPE = a0.a.f352h;
        Intrinsics.f(STEP_TYPE, "STEP_TYPE");
        return new z.g(STEP_TYPE);
    }

    @JvmStatic
    public static final w b() {
        if (!f31635a.d()) {
            return new u.a();
        }
        StepType STEP_TYPE = a0.b.f353h;
        Intrinsics.f(STEP_TYPE, "STEP_TYPE");
        return new z.g(STEP_TYPE);
    }

    @JvmStatic
    public static final w c() {
        if (!f31635a.d()) {
            return new u.e();
        }
        StepType STEP_TYPE = a0.c.f354h;
        Intrinsics.f(STEP_TYPE, "STEP_TYPE");
        return new z.g(STEP_TYPE);
    }

    public final boolean d() {
        return ((Boolean) f31636b.getValue()).booleanValue();
    }
}
