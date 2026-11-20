package n0;

import android.app.Application;
import android.content.res.Resources;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.cloud.tmc.kernel.log.TmcLogger;
import java.io.File;
import java.lang.ref.WeakReference;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import p012Oooo0oO.o0OO00O;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Application f71356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static o0.b f71357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static o0.c<?> f71358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static o0.d f71359d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static WeakReference<d> f71360e;

    @JvmStatic
    public static final void a() {
        d dVar;
        o0.b bVar;
        WeakReference<d> weakReference = f71360e;
        if (weakReference == null || (dVar = weakReference.get()) == null) {
            return;
        }
        o0.c<?> cVar = dVar.f71326g;
        if (!Intrinsics.b(cVar != null ? cVar.OooO00o() : null, o0.a.b.f72240b) || (bVar = dVar.f71327h) == null) {
            return;
        }
        bVar.OooO00o();
    }

    public static void b(int i11, int i12, long j11, boolean z11, int i13) {
        String strValueOf;
        CharSequence charSequence;
        Resources resources;
        CharSequence text;
        int i14 = (i13 & 2) != 0 ? 0 : i12;
        if ((i13 & 4) != 0) {
            j11 = 0;
        }
        long j12 = j11;
        boolean z12 = (i13 & 8) != 0 ? false : z11;
        try {
            Application application = f71356a;
            if (application == null || (resources = application.getResources()) == null || (text = resources.getText(i11)) == null) {
                strValueOf = "";
                charSequence = strValueOf;
            } else {
                charSequence = text;
            }
        } catch (Resources.NotFoundException unused) {
            strValueOf = String.valueOf(i11);
        }
        c(charSequence, i14, j12, z12, null, 16);
    }

    public static void c(CharSequence text, int i11, long j11, boolean z11, Function0 function0, int i12) {
        int i13 = (i12 & 2) != 0 ? 0 : i11;
        long j12 = (i12 & 4) != 0 ? 0L : j11;
        boolean z12 = (i12 & 8) != 0 ? false : z11;
        Function0 function1 = (i12 & 16) != 0 ? null : function0;
        Intrinsics.g(text, "text");
        e(new d(text, i13, j12, z12, null, 0, null, null, null, function1, 496));
    }

    public static void d(CharSequence text, o0.a aVar, int i11, long j11, boolean z11, File file, Function0 function0, int i12) {
        o0.a type = (i12 & 2) != 0 ? o0.a.b.f72240b : aVar;
        int i13 = (i12 & 4) != 0 ? 0 : i11;
        long j12 = (i12 & 8) != 0 ? 0L : j11;
        boolean z12 = (i12 & 16) != 0 ? false : z11;
        File file2 = (i12 & 32) != 0 ? null : file;
        Function0 function1 = (i12 & 64) != 0 ? null : function0;
        Intrinsics.g(text, "text");
        Intrinsics.g(type, "type");
        e(new d(text, i13, j12, z12, file2, 0, new f0.c(type, true), null, null, function1, TTAdConstant.PACKAGE_NAME_CODE));
    }

    @JvmStatic
    public static final void e(d params) {
        o0.b bVar;
        Intrinsics.g(params, "params");
        if (f71356a == null || f71357b == null || f71358c == null) {
            TmcLogger.c("ToastUtils", "It's not init");
            return;
        }
        if (params.f71320a.length() == 0) {
            TmcLogger.c("ToastUtils", "It's empty");
            return;
        }
        if (params.f71327h == null) {
            o0.b bVar2 = f71357b;
            if (bVar2 == null) {
                bVar = bVar2;
                o0OO00O strategy = new o0OO00O(0);
                Intrinsics.g(strategy, "strategy");
                strategy.c(f71356a);
                f71357b = strategy;
                bVar = strategy;
            }
            bVar = bVar2;
            params.f71327h = bVar;
        }
        if (params.f71326g == null) {
            o0.c<?> style = f71358c;
            if (style == null) {
                style = new f0.b();
                Intrinsics.g(style, "style");
                f71358c = style;
            }
            params.f71326g = style;
        }
        if (params.f71328i == null) {
            o0.d interceptor = f71359d;
            if (interceptor == null) {
                interceptor = new c();
                Intrinsics.g(interceptor, "interceptor");
                f71359d = interceptor;
            }
            params.f71328i = interceptor;
        }
        o0.d dVar = params.f71328i;
        if (dVar == null || !dVar.a(params)) {
            if (params.f71321b == -1) {
                params.f71321b = params.f71320a.length() > 20 ? 1 : 0;
            }
            f71360e = new WeakReference<>(params);
            o0.b bVar3 = params.f71327h;
            if (bVar3 != null) {
                bVar3.a(params);
            }
        }
    }

    @JvmStatic
    public static final void f() {
        d dVar;
        o0.b bVar;
        WeakReference<d> weakReference = f71360e;
        if (weakReference == null || (dVar = weakReference.get()) == null) {
            return;
        }
        o0.c<?> cVar = dVar.f71326g;
        if (Intrinsics.b(cVar != null ? cVar.OooO00o() : null, o0.a.b.f72240b) || (bVar = dVar.f71327h) == null) {
            return;
        }
        bVar.OooO00o();
    }
}
