package com.transsion.ad.strategy;

import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.View;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class MeasureManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MeasureManager f50573a = new MeasureManager();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Rect f50574b = new Rect();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CopyOnWriteArrayList<a> f50575c = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f50576d = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.NONE, new Function0<HandlerThread>() { // from class: com.transsion.ad.strategy.MeasureManager$myWorkerThreadHandler$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final HandlerThread invoke() {
            HandlerThread handlerThread = new HandlerThread("MyHandlerThread");
            handlerThread.start();
            return handlerThread;
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f50577e = LazyKt__LazyJVMKt.b(new Function0<Handler>() { // from class: com.transsion.ad.strategy.MeasureManager$myWorkerHandler$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Handler invoke() {
            return new Handler(MeasureManager.f50573a.l().getLooper());
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f50578f = LazyKt__LazyJVMKt.b(new Function0<Handler>() { // from class: com.transsion.ad.strategy.MeasureManager$mHandler$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Runnable f50579g = new Runnable() { // from class: com.transsion.ad.strategy.g
        @Override // java.lang.Runnable
        public final void run() {
            MeasureManager.o();
        }
    };

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface a {

        /* JADX INFO: renamed from: com.transsion.ad.strategy.MeasureManager$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class C0550a {
            public static double a(a aVar) {
                return 10.0d;
            }
        }

        double getVisibilityThreshold();

        View getVisibilityView();

        void onVisibilityChanged(boolean z11);
    }

    public static final void h(a listener) {
        Intrinsics.g(listener, "$listener");
        CopyOnWriteArrayList<a> copyOnWriteArrayList = f50575c;
        if (!copyOnWriteArrayList.contains(listener)) {
            copyOnWriteArrayList.add(listener);
        }
        if (copyOnWriteArrayList.size() == 1) {
            f50573a.r();
        }
    }

    public static final void o() {
        f50573a.n();
    }

    public static final void q(a listener) {
        Intrinsics.g(listener, "$listener");
        f50575c.remove(listener);
    }

    public static final void s() {
        f50573a.n();
    }

    public static final void u() {
        f50573a.k().removeCallbacks(f50579g);
    }

    public final void g(final a listener) {
        Intrinsics.g(listener, "listener");
        k().post(new Runnable() { // from class: com.transsion.ad.strategy.i
            @Override // java.lang.Runnable
            public final void run() {
                MeasureManager.h(listener);
            }
        });
    }

    public final void i(View view, Function1<? super Double, Unit> function1) {
        if (view != null) {
            if (view.getWindowVisibility() != 0) {
                if (function1 != null) {
                    function1.invoke(Double.valueOf(0.0d));
                    return;
                }
                return;
            }
            Rect rect = f50574b;
            if (!view.getGlobalVisibleRect(rect) || !view.isShown()) {
                if (function1 != null) {
                    function1.invoke(Double.valueOf(0.0d));
                    return;
                }
                return;
            }
            double dHeight = ((double) rect.height()) * ((double) rect.width());
            double height = ((double) view.getHeight()) * ((double) view.getWidth());
            if (height <= 0.0d) {
                if (function1 != null) {
                    function1.invoke(Double.valueOf(0.0d));
                }
            } else {
                double d11 = (dHeight * ((double) 100)) / height;
                if (function1 != null) {
                    function1.invoke(Double.valueOf(d11));
                }
            }
        }
    }

    public final String j() {
        String simpleName = MeasureManager.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final Handler k() {
        return (Handler) f50577e.getValue();
    }

    public final HandlerThread l() {
        return (HandlerThread) f50576d.getValue();
    }

    public final boolean m(View view) {
        if (view == null || view.getWindowVisibility() != 0) {
            return false;
        }
        Rect rect = f50574b;
        if (!view.getGlobalVisibleRect(rect) || !view.isShown()) {
            return false;
        }
        double dHeight = ((double) rect.height()) * ((double) rect.width());
        double height = ((double) view.getHeight()) * ((double) view.getWidth());
        return height > 0.0d && (dHeight * ((double) 100)) / height > 0.0d;
    }

    public final void n() {
        k().removeCallbacks(f50579g);
        for (final a aVar : f50575c) {
            f50573a.i(aVar.getVisibilityView(), new Function1<Double, Unit>() { // from class: com.transsion.ad.strategy.MeasureManager$measure$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Double d11) {
                    invoke(d11.doubleValue());
                    return Unit.f68710a;
                }

                public final void invoke(double d11) {
                    if (d11 >= aVar.getVisibilityThreshold()) {
                        aVar.onVisibilityChanged(true);
                    } else {
                        aVar.onVisibilityChanged(false);
                    }
                }
            });
        }
        if (!f50575c.isEmpty()) {
            k().postDelayed(f50579g, 500L);
            return;
        }
        com.transsion.ad.a.f50276a.s(j() + " --> measure() --> true = sessionList.isEmpty()", false);
    }

    public final void p(final a listener) {
        Intrinsics.g(listener, "listener");
        k().post(new Runnable() { // from class: com.transsion.ad.strategy.h
            @Override // java.lang.Runnable
            public final void run() {
                MeasureManager.q(listener);
            }
        });
    }

    public final void r() {
        k().post(new Runnable() { // from class: com.transsion.ad.strategy.j
            @Override // java.lang.Runnable
            public final void run() {
                MeasureManager.s();
            }
        });
    }

    public final void t() {
        k().post(new Runnable() { // from class: com.transsion.ad.strategy.k
            @Override // java.lang.Runnable
            public final void run() {
                MeasureManager.u();
            }
        });
        n();
    }
}
