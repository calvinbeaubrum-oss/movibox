package com.transsion.postdetail.layer.local;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.transsion.ad.middle.nativead.WrapperNativeManager;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.postdetail.ui.view.AdCountDownView;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

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
public final class LocalVideoLandAdControl {
    public static final a C = new a(null);
    public static final Lazy<LocalVideoLandAdControl> D = LazyKt__LazyJVMKt.b(new Function0<LocalVideoLandAdControl>() { // from class: com.transsion.postdetail.layer.local.LocalVideoLandAdControl$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LocalVideoLandAdControl invoke() {
            return new LocalVideoLandAdControl();
        }
    });
    public DownloadBean B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f55158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f55159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f55160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f55161d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f55162e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f55163f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f55164g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f55165h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f55166i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Context f55167j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public FrameLayout f55168k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public FrameLayout f55169l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public AdCountDownView f55170m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public AppCompatImageView f55171n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Function1<? super Integer, Unit> f55172o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Function0<Unit> f55173p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public WrapperNativeManager f55174q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public WrapperNativeManager f55175r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public WrapperNativeManager f55176s;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f55180w;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f55177t = 15;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f55178u = 15;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f55179v = 180000;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Handler f55181x = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f55182y = 1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f55183z = 1;
    public final Runnable A = new Runnable() { // from class: com.transsion.postdetail.layer.local.p
        @Override // java.lang.Runnable
        public final void run() {
            LocalVideoLandAdControl.o(this.f55291a);
        }
    };

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LocalVideoLandAdControl a() {
            return (LocalVideoLandAdControl) LocalVideoLandAdControl.D.getValue();
        }
    }

    public static final void o(LocalVideoLandAdControl this$0) {
        int i11;
        Intrinsics.g(this$0, "this$0");
        if (this$0.f55180w < 1) {
            this$0.r();
            return;
        }
        int i12 = this$0.f55166i == 1 ? this$0.f55182y : this$0.f55183z;
        if (wq.b.f79582a.i() && this$0.f55178u - this$0.f55180w >= i12 && ((i11 = this$0.f55166i) == 1 || i11 == 3)) {
            AppCompatImageView appCompatImageView = this$0.f55171n;
            if (appCompatImageView != null) {
                so.c.k(appCompatImageView);
            }
            uo.b.a.f(uo.b.f78622a, "LocalVideoLandAdControl", "countdownRunnable, show adCloseView", false, 4, null);
        }
        AdCountDownView adCountDownView = this$0.f55170m;
        if (adCountDownView != null) {
            int i13 = this$0.f55180w;
            this$0.f55180w = i13 - 1;
            adCountDownView.refreshCountDown(i13);
        }
        this$0.n();
    }

    public final void m(int i11) {
        uo.b.a.f(uo.b.f78622a, "LocalVideoLandAdControl", "----closeLandAd, adType = " + i11, false, 4, null);
        this.f55166i = 0;
        w();
        AppCompatImageView appCompatImageView = this.f55171n;
        if (appCompatImageView != null) {
            so.c.g(appCompatImageView);
        }
        if (i11 == 1) {
            WrapperNativeManager wrapperNativeManager = this.f55174q;
            if (wrapperNativeManager != null) {
                wrapperNativeManager.destroy();
            }
            this.f55174q = null;
            return;
        }
        if (i11 == 2) {
            WrapperNativeManager wrapperNativeManager2 = this.f55175r;
            if (wrapperNativeManager2 != null) {
                wrapperNativeManager2.destroy();
            }
            this.f55175r = null;
            return;
        }
        if (i11 != 3) {
            return;
        }
        WrapperNativeManager wrapperNativeManager3 = this.f55176s;
        if (wrapperNativeManager3 != null) {
            wrapperNativeManager3.destroy();
        }
        this.f55176s = null;
    }

    public final void n() {
        this.f55181x.postDelayed(this.A, 1000L);
    }

    public final boolean p() {
        if (this.f55163f || this.f55164g || this.f55158a - this.f55159b > this.f55179v) {
            return false;
        }
        if (!this.f55165h) {
            this.f55165h = true;
        }
        return true;
    }

    public final boolean q() {
        return this.f55162e;
    }

    public final void r() {
        uo.b.a aVar = uo.b.f78622a;
        uo.b.a.f(aVar, "LocalVideoLandAdControl", "onCountdownFinish, curAdType = " + this.f55166i, false, 4, null);
        int i11 = this.f55166i;
        if (i11 == 1) {
            this.f55160c = this.f55161d;
            Function0<Unit> function0 = this.f55173p;
            if (function0 != null) {
                function0.invoke();
            }
            AdCountDownView adCountDownView = this.f55170m;
            if (adCountDownView != null) {
                adCountDownView.setVisibility(8);
            }
            if (p()) {
                uo.b.a.f(aVar, "LocalVideoLandAdControl", "onCountdownFinish, start finish, show end", false, 4, null);
                m(this.f55166i);
                x(3, new Function1<Integer, Unit>() { // from class: com.transsion.postdetail.layer.local.LocalVideoLandAdControl$onCountdownFinish$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(int i12) {
                    }
                });
                return;
            } else if (q()) {
                uo.b.a.f(aVar, "LocalVideoLandAdControl", "onCountdownFinish, start finish, show pause", false, 4, null);
                m(this.f55166i);
                x(2, new Function1<Integer, Unit>() { // from class: com.transsion.postdetail.layer.local.LocalVideoLandAdControl$onCountdownFinish$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(int i12) {
                    }
                });
                return;
            } else {
                uo.b.a.f(aVar, "LocalVideoLandAdControl", "onCountdownFinish, start finish now", false, 4, null);
                Function1<? super Integer, Unit> function1 = this.f55172o;
                if (function1 != null) {
                    function1.invoke(Integer.valueOf(this.f55166i));
                    return;
                }
                return;
            }
        }
        if (i11 == 2) {
            uo.b.a.f(aVar, "LocalVideoLandAdControl", "onCountdownFinish, pause finish now", false, 4, null);
            Function1<? super Integer, Unit> function2 = this.f55172o;
            if (function2 != null) {
                function2.invoke(Integer.valueOf(this.f55166i));
                return;
            }
            return;
        }
        if (i11 != 3) {
            return;
        }
        this.f55163f = true;
        this.f55164g = false;
        AdCountDownView adCountDownView2 = this.f55170m;
        if (adCountDownView2 != null) {
            adCountDownView2.setVisibility(8);
        }
        if (q()) {
            uo.b.a.f(aVar, "LocalVideoLandAdControl", "onCountdownFinish, end finish , show pause", false, 4, null);
            m(this.f55166i);
            x(2, new Function1<Integer, Unit>() { // from class: com.transsion.postdetail.layer.local.LocalVideoLandAdControl$onCountdownFinish$3
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.f68710a;
                }

                public final void invoke(int i12) {
                }
            });
        } else {
            uo.b.a.f(aVar, "LocalVideoLandAdControl", "onCountdownFinish, end finish now", false, 4, null);
            Function1<? super Integer, Unit> function3 = this.f55172o;
            if (function3 != null) {
                function3.invoke(Integer.valueOf(this.f55166i));
            }
        }
    }

    public final void s(Function1<? super Integer, Unit> function1) {
        kotlinx.coroutines.j.d(l0.a(w0.c()), null, null, new LocalVideoLandAdControl$onShowEndAd$1(this, function1, null), 3, null);
        y(this.f55178u);
    }

    public final void t(Function1<? super Integer, Unit> function1) {
        kotlinx.coroutines.j.d(l0.a(w0.c()), null, null, new LocalVideoLandAdControl$onShowPauseAd$1(this, function1, null), 3, null);
        AdCountDownView adCountDownView = this.f55170m;
        if (adCountDownView != null) {
            adCountDownView.refreshCountDown(-1);
        }
        AdCountDownView adCountDownView2 = this.f55170m;
        if (adCountDownView2 != null) {
            adCountDownView2.setVisibility(0);
        }
        uo.b.a.f(uo.b.f78622a, "LocalVideoLandAdControl", "onShowPauseAd", false, 4, null);
    }

    public final void u(Function1<? super Integer, Unit> function1) {
        kotlinx.coroutines.j.d(l0.a(w0.c()), null, null, new LocalVideoLandAdControl$onShowStartAd$1(this, function1, null), 3, null);
        uo.b.a.f(uo.b.f78622a, "LocalVideoLandAdControl", "onShowStartAd", false, 4, null);
        y(this.f55177t);
    }

    public final void v(long j11, long j12) {
        this.f55159b = j11;
        this.f55158a = j12;
    }

    public final void w() {
        this.f55181x.removeCallbacksAndMessages(this.A);
    }

    public final void x(int i11, Function1<? super Integer, Unit> function1) {
        uo.b.a.f(uo.b.f78622a, "LocalVideoLandAdControl", "----showLandAd, adType = " + i11, false, 4, null);
        this.f55166i = i11;
        if (i11 == 1) {
            u(function1);
        } else if (i11 == 2) {
            t(function1);
        } else {
            if (i11 != 3) {
                return;
            }
            s(function1);
        }
    }

    public final void y(int i11) {
        uo.b.a.f(uo.b.f78622a, "LocalVideoLandAdControl", "startCountdown, countdownTime = " + i11, false, 4, null);
        this.f55180w = i11;
        AdCountDownView adCountDownView = this.f55170m;
        if (adCountDownView != null) {
            adCountDownView.setVisibility(0);
        }
        this.f55181x.post(this.A);
    }
}
