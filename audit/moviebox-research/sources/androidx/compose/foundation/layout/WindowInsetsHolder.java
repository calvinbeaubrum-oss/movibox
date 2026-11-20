package androidx.compose.foundation.layout;

import android.view.View;
import android.view.WindowInsets;
import androidx.compose.ui.R$id;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class WindowInsetsHolder {
    public static boolean A;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Companion f2435x = new Companion(null);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f2436y = 8;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final WeakHashMap<View, WindowInsetsHolder> f2437z = new WeakHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f2438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f2439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f2440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f2441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f2442e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f2443f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f2444g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f2445h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f2446i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final g0 f2447j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final h0 f2448k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final h0 f2449l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final h0 f2450m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final g0 f2451n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final g0 f2452o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final g0 f2453p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final g0 f2454q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final g0 f2455r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final g0 f2456s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final g0 f2457t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f2458u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f2459v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final InsetsListener f2460w;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WindowInsetsHolder c(androidx.compose.runtime.i iVar, int i11) {
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.S(-1366542614, i11, -1, "androidx.compose.foundation.layout.WindowInsetsHolder.Companion.current (WindowInsets.android.kt:626)");
            }
            final View view = (View) iVar.l(AndroidCompositionLocals_androidKt.j());
            final WindowInsetsHolder windowInsetsHolderD = d(view);
            boolean zA = iVar.A(windowInsetsHolderD) | iVar.A(view);
            Object objY = iVar.y();
            if (zA || objY == androidx.compose.runtime.i.f3413a.a()) {
                objY = new Function1<androidx.compose.runtime.d0, androidx.compose.runtime.c0>() { // from class: androidx.compose.foundation.layout.WindowInsetsHolder$Companion$current$1$1

                    /* JADX INFO: compiled from: source.java */
                    @Metadata
                    @SourceDebugExtension
                    public static final class a implements androidx.compose.runtime.c0 {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        public final /* synthetic */ WindowInsetsHolder f2461a;

                        /* JADX INFO: renamed from: b, reason: collision with root package name */
                        public final /* synthetic */ View f2462b;

                        public a(WindowInsetsHolder windowInsetsHolder, View view) {
                            this.f2461a = windowInsetsHolder;
                            this.f2462b = view;
                        }

                        @Override // androidx.compose.runtime.c0
                        public void dispose() {
                            this.f2461a.b(this.f2462b);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final androidx.compose.runtime.c0 invoke(androidx.compose.runtime.d0 d0Var) {
                        windowInsetsHolderD.p(view);
                        return new a(windowInsetsHolderD, view);
                    }
                };
                iVar.p(objY);
            }
            androidx.compose.runtime.g0.a(windowInsetsHolderD, (Function1) objY, iVar, 0);
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.R();
            }
            return windowInsetsHolderD;
        }

        public final WindowInsetsHolder d(View view) {
            WindowInsetsHolder windowInsetsHolder;
            synchronized (WindowInsetsHolder.f2437z) {
                try {
                    WeakHashMap weakHashMap = WindowInsetsHolder.f2437z;
                    Object obj = weakHashMap.get(view);
                    Object obj2 = obj;
                    if (obj == null) {
                        WindowInsetsHolder windowInsetsHolder2 = new WindowInsetsHolder(null, view, false ? 1 : 0);
                        weakHashMap.put(view, windowInsetsHolder2);
                        obj2 = windowInsetsHolder2;
                    }
                    windowInsetsHolder = (WindowInsetsHolder) obj2;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return windowInsetsHolder;
        }

        public final a e(WindowInsetsCompat windowInsetsCompat, int i11, String str) {
            a aVar = new a(i11, str);
            if (windowInsetsCompat != null) {
                aVar.h(windowInsetsCompat, i11);
            }
            return aVar;
        }

        public final g0 f(WindowInsetsCompat windowInsetsCompat, int i11, String str) {
            c3.c insetsIgnoringVisibility;
            if (windowInsetsCompat == null || (insetsIgnoringVisibility = windowInsetsCompat.getInsetsIgnoringVisibility(i11)) == null) {
                insetsIgnoringVisibility = c3.c.f14553e;
            }
            return j0.a(insetsIgnoringVisibility, str);
        }
    }

    public WindowInsetsHolder(WindowInsetsCompat windowInsetsCompat, View view) {
        DisplayCutoutCompat displayCutout;
        c3.c waterfallInsets;
        Companion companion = f2435x;
        this.f2438a = companion.e(windowInsetsCompat, WindowInsetsCompat.Type.captionBar(), "captionBar");
        a aVarE = companion.e(windowInsetsCompat, WindowInsetsCompat.Type.displayCutout(), "displayCutout");
        this.f2439b = aVarE;
        a aVarE2 = companion.e(windowInsetsCompat, WindowInsetsCompat.Type.ime(), "ime");
        this.f2440c = aVarE2;
        a aVarE3 = companion.e(windowInsetsCompat, WindowInsetsCompat.Type.mandatorySystemGestures(), "mandatorySystemGestures");
        this.f2441d = aVarE3;
        this.f2442e = companion.e(windowInsetsCompat, WindowInsetsCompat.Type.navigationBars(), "navigationBars");
        this.f2443f = companion.e(windowInsetsCompat, WindowInsetsCompat.Type.statusBars(), "statusBars");
        a aVarE4 = companion.e(windowInsetsCompat, WindowInsetsCompat.Type.systemBars(), "systemBars");
        this.f2444g = aVarE4;
        a aVarE5 = companion.e(windowInsetsCompat, WindowInsetsCompat.Type.systemGestures(), "systemGestures");
        this.f2445h = aVarE5;
        a aVarE6 = companion.e(windowInsetsCompat, WindowInsetsCompat.Type.tappableElement(), "tappableElement");
        this.f2446i = aVarE6;
        g0 g0VarA = j0.a((windowInsetsCompat == null || (displayCutout = windowInsetsCompat.getDisplayCutout()) == null || (waterfallInsets = displayCutout.getWaterfallInsets()) == null) ? c3.c.f14553e : waterfallInsets, "waterfall");
        this.f2447j = g0VarA;
        h0 h0VarC = i0.c(i0.c(aVarE4, aVarE2), aVarE);
        this.f2448k = h0VarC;
        h0 h0VarC2 = i0.c(i0.c(i0.c(aVarE6, aVarE3), aVarE5), g0VarA);
        this.f2449l = h0VarC2;
        this.f2450m = i0.c(h0VarC, h0VarC2);
        this.f2451n = companion.f(windowInsetsCompat, WindowInsetsCompat.Type.captionBar(), "captionBarIgnoringVisibility");
        this.f2452o = companion.f(windowInsetsCompat, WindowInsetsCompat.Type.navigationBars(), "navigationBarsIgnoringVisibility");
        this.f2453p = companion.f(windowInsetsCompat, WindowInsetsCompat.Type.statusBars(), "statusBarsIgnoringVisibility");
        this.f2454q = companion.f(windowInsetsCompat, WindowInsetsCompat.Type.systemBars(), "systemBarsIgnoringVisibility");
        this.f2455r = companion.f(windowInsetsCompat, WindowInsetsCompat.Type.tappableElement(), "tappableElementIgnoringVisibility");
        this.f2456s = companion.f(windowInsetsCompat, WindowInsetsCompat.Type.ime(), "imeAnimationTarget");
        this.f2457t = companion.f(windowInsetsCompat, WindowInsetsCompat.Type.ime(), "imeAnimationSource");
        Object parent = view.getParent();
        View view2 = parent instanceof View ? (View) parent : null;
        Object tag = view2 != null ? view2.getTag(R$id.consume_window_insets_tag) : null;
        Boolean bool = tag instanceof Boolean ? (Boolean) tag : null;
        this.f2458u = bool != null ? bool.booleanValue() : true;
        this.f2460w = new InsetsListener(this);
    }

    public /* synthetic */ WindowInsetsHolder(WindowInsetsCompat windowInsetsCompat, View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(windowInsetsCompat, view);
    }

    public static /* synthetic */ void r(WindowInsetsHolder windowInsetsHolder, WindowInsetsCompat windowInsetsCompat, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        windowInsetsHolder.q(windowInsetsCompat, i11);
    }

    public final void b(View view) {
        int i11 = this.f2459v - 1;
        this.f2459v = i11;
        if (i11 == 0) {
            ViewCompat.setOnApplyWindowInsetsListener(view, null);
            ViewCompat.setWindowInsetsAnimationCallback(view, null);
            view.removeOnAttachStateChangeListener(this.f2460w);
        }
    }

    public final a c() {
        return this.f2438a;
    }

    public final boolean d() {
        return this.f2458u;
    }

    public final a e() {
        return this.f2439b;
    }

    public final a f() {
        return this.f2440c;
    }

    public final a g() {
        return this.f2441d;
    }

    public final a h() {
        return this.f2442e;
    }

    public final h0 i() {
        return this.f2450m;
    }

    public final h0 j() {
        return this.f2448k;
    }

    public final h0 k() {
        return this.f2449l;
    }

    public final a l() {
        return this.f2443f;
    }

    public final a m() {
        return this.f2444g;
    }

    public final a n() {
        return this.f2445h;
    }

    public final g0 o() {
        return this.f2447j;
    }

    public final void p(View view) {
        if (this.f2459v == 0) {
            ViewCompat.setOnApplyWindowInsetsListener(view, this.f2460w);
            if (view.isAttachedToWindow()) {
                view.requestApplyInsets();
            }
            view.addOnAttachStateChangeListener(this.f2460w);
            ViewCompat.setWindowInsetsAnimationCallback(view, this.f2460w);
        }
        this.f2459v++;
    }

    public final void q(WindowInsetsCompat windowInsetsCompat, int i11) {
        if (A) {
            WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
            Intrinsics.d(windowInsets);
            windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets);
        }
        this.f2438a.h(windowInsetsCompat, i11);
        this.f2440c.h(windowInsetsCompat, i11);
        this.f2439b.h(windowInsetsCompat, i11);
        this.f2442e.h(windowInsetsCompat, i11);
        this.f2443f.h(windowInsetsCompat, i11);
        this.f2444g.h(windowInsetsCompat, i11);
        this.f2445h.h(windowInsetsCompat, i11);
        this.f2446i.h(windowInsetsCompat, i11);
        this.f2441d.h(windowInsetsCompat, i11);
        if (i11 == 0) {
            this.f2451n.f(j0.b(windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.captionBar())));
            this.f2452o.f(j0.b(windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.navigationBars())));
            this.f2453p.f(j0.b(windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.statusBars())));
            this.f2454q.f(j0.b(windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.systemBars())));
            this.f2455r.f(j0.b(windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.tappableElement())));
            DisplayCutoutCompat displayCutout = windowInsetsCompat.getDisplayCutout();
            if (displayCutout != null) {
                this.f2447j.f(j0.b(displayCutout.getWaterfallInsets()));
            }
        }
        androidx.compose.runtime.snapshots.j.f3684e.n();
    }

    public final void s(WindowInsetsCompat windowInsetsCompat) {
        this.f2457t.f(j0.b(windowInsetsCompat.getInsets(WindowInsetsCompat.Type.ime())));
    }

    public final void t(WindowInsetsCompat windowInsetsCompat) {
        this.f2456s.f(j0.b(windowInsetsCompat.getInsets(WindowInsetsCompat.Type.ime())));
    }
}
