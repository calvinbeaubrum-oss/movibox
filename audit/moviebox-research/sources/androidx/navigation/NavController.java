package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.CallSuper;
import androidx.core.app.f0;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.t;
import androidx.lifecycle.u;
import androidx.lifecycle.x0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.f1;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.u0;
import kotlinx.coroutines.flow.v0;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public class NavController {
    public static final a G = new a(null);
    public static boolean H = true;
    public final Map<NavBackStackEntry, Boolean> A;
    public int B;
    public final List<NavBackStackEntry> C;
    public final Lazy D;
    public final u0<NavBackStackEntry> E;
    public final kotlinx.coroutines.flow.a<NavBackStackEntry> F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f12155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Activity f12156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k f12157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public NavGraph f12158d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bundle f12159e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Parcelable[] f12160f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f12161g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayDeque<NavBackStackEntry> f12162h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final v0<List<NavBackStackEntry>> f12163i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final f1<List<NavBackStackEntry>> f12164j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<NavBackStackEntry, NavBackStackEntry> f12165k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<NavBackStackEntry, AtomicInteger> f12166l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<Integer, String> f12167m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<String, ArrayDeque<NavBackStackEntryState>> f12168n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public u f12169o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public OnBackPressedDispatcher f12170p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public f f12171q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final CopyOnWriteArrayList<b> f12172r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Lifecycle.State f12173s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final t f12174t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final androidx.activity.p f12175u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f12176v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public q f12177w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> f12178x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Function1<? super NavBackStackEntry, Unit> f12179y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Function1<? super NavBackStackEntry, Unit> f12180z;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class NavControllerNavigatorState extends r {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Navigator<? extends NavDestination> f12181g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ NavController f12182h;

        public NavControllerNavigatorState(NavController this$0, Navigator<? extends NavDestination> navigator) {
            Intrinsics.g(this$0, "this$0");
            Intrinsics.g(navigator, "navigator");
            this.f12182h = this$0;
            this.f12181g = navigator;
        }

        @Override // androidx.navigation.r
        public NavBackStackEntry a(NavDestination destination, Bundle bundle) {
            Intrinsics.g(destination, "destination");
            return NavBackStackEntry.a.b(NavBackStackEntry.f12139o, this.f12182h.y(), destination, bundle, this.f12182h.D(), this.f12182h.f12171q, null, null, 96, null);
        }

        @Override // androidx.navigation.r
        public void e(NavBackStackEntry entry) {
            f fVar;
            Intrinsics.g(entry, "entry");
            boolean zB = Intrinsics.b(this.f12182h.A.get(entry), Boolean.TRUE);
            super.e(entry);
            this.f12182h.A.remove(entry);
            if (this.f12182h.v().contains(entry)) {
                if (d()) {
                    return;
                }
                this.f12182h.h0();
                this.f12182h.f12163i.b(this.f12182h.W());
                return;
            }
            this.f12182h.g0(entry);
            if (entry.getLifecycle().b().isAtLeast(Lifecycle.State.CREATED)) {
                entry.l(Lifecycle.State.DESTROYED);
            }
            ArrayDeque<NavBackStackEntry> arrayDequeV = this.f12182h.v();
            if (!(arrayDequeV instanceof Collection) || !arrayDequeV.isEmpty()) {
                Iterator<NavBackStackEntry> it = arrayDequeV.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.b(it.next().g(), entry.g())) {
                    }
                }
                if (!zB && (fVar = this.f12182h.f12171q) != null) {
                    fVar.c(entry.g());
                }
            } else if (!zB) {
                fVar.c(entry.g());
            }
            this.f12182h.h0();
            this.f12182h.f12163i.b(this.f12182h.W());
        }

        @Override // androidx.navigation.r
        public void g(final NavBackStackEntry popUpTo, final boolean z11) {
            Intrinsics.g(popUpTo, "popUpTo");
            Navigator navigatorD = this.f12182h.f12177w.d(popUpTo.f().v());
            if (!Intrinsics.b(navigatorD, this.f12181g)) {
                Object obj = this.f12182h.f12178x.get(navigatorD);
                Intrinsics.d(obj);
                ((NavControllerNavigatorState) obj).g(popUpTo, z11);
            } else {
                Function1 function1 = this.f12182h.f12180z;
                if (function1 == null) {
                    this.f12182h.Q(popUpTo, new Function0<Unit>() { // from class: androidx.navigation.NavController$NavControllerNavigatorState$pop$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.f68710a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            super/*androidx.navigation.r*/.g(popUpTo, z11);
                        }
                    });
                } else {
                    function1.invoke(popUpTo);
                    super.g(popUpTo, z11);
                }
            }
        }

        @Override // androidx.navigation.r
        public void h(NavBackStackEntry backStackEntry) {
            Intrinsics.g(backStackEntry, "backStackEntry");
            Navigator navigatorD = this.f12182h.f12177w.d(backStackEntry.f().v());
            if (!Intrinsics.b(navigatorD, this.f12181g)) {
                Object obj = this.f12182h.f12178x.get(navigatorD);
                if (obj != null) {
                    ((NavControllerNavigatorState) obj).h(backStackEntry);
                    return;
                }
                throw new IllegalStateException(("NavigatorBackStack for " + backStackEntry.f().v() + " should already be created").toString());
            }
            Function1 function1 = this.f12182h.f12179y;
            if (function1 != null) {
                function1.invoke(backStackEntry);
                k(backStackEntry);
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Ignoring add of destination ");
                sb2.append(backStackEntry.f());
                sb2.append(" outside of the call to navigate(). ");
            }
        }

        public final void k(NavBackStackEntry backStackEntry) {
            Intrinsics.g(backStackEntry, "backStackEntry");
            super.h(backStackEntry);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public interface b {
        void a(NavController navController, NavDestination navDestination, Bundle bundle);
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static final class c extends androidx.activity.p {
        public c() {
            super(false);
        }

        @Override // androidx.activity.p
        public void handleOnBackPressed() {
            NavController.this.N();
        }
    }

    public NavController(Context context) {
        Intrinsics.g(context, "context");
        this.f12155a = context;
        for (Object obj : SequencesKt__SequencesKt.f(context, new Function1<Context, Context>() { // from class: androidx.navigation.NavController$activity$1
            @Override // kotlin.jvm.functions.Function1
            public final Context invoke(Context it) {
                Intrinsics.g(it, "it");
                if (it instanceof ContextWrapper) {
                    return ((ContextWrapper) it).getBaseContext();
                }
                return null;
            }
        })) {
            if (((Context) obj) instanceof Activity) {
                this.f12156b = (Activity) obj;
                this.f12162h = new ArrayDeque<>();
                v0<List<NavBackStackEntry>> v0VarA = g1.a(kotlin.collections.g.l());
                this.f12163i = v0VarA;
                this.f12164j = kotlinx.coroutines.flow.c.b(v0VarA);
                this.f12165k = new LinkedHashMap();
                this.f12166l = new LinkedHashMap();
                this.f12167m = new LinkedHashMap();
                this.f12168n = new LinkedHashMap();
                this.f12172r = new CopyOnWriteArrayList<>();
                this.f12173s = Lifecycle.State.INITIALIZED;
                this.f12174t = new androidx.lifecycle.r() { // from class: androidx.navigation.e
                    @Override // androidx.lifecycle.r
                    public final void onStateChanged(u uVar, Lifecycle.Event event) {
                        NavController.I(this.f12247a, uVar, event);
                    }
                };
                this.f12175u = new c();
                this.f12176v = true;
                this.f12177w = new q();
                this.f12178x = new LinkedHashMap();
                this.A = new LinkedHashMap();
                q qVar = this.f12177w;
                qVar.b(new h(qVar));
                this.f12177w.b(new ActivityNavigator(this.f12155a));
                this.C = new ArrayList();
                this.D = LazyKt__LazyJVMKt.b(new Function0<k>() { // from class: androidx.navigation.NavController$navInflater$2
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final k invoke() {
                        k kVar = this.this$0.f12157c;
                        return kVar == null ? new k(this.this$0.y(), this.this$0.f12177w) : kVar;
                    }
                });
                u0<NavBackStackEntry> u0VarB = a1.b(1, 0, BufferOverflow.DROP_OLDEST, 2, null);
                this.E = u0VarB;
                this.F = kotlinx.coroutines.flow.c.a(u0VarB);
            }
        }
        obj = null;
        this.f12156b = (Activity) obj;
        this.f12162h = new ArrayDeque<>();
        v0<List<NavBackStackEntry>> v0VarA2 = g1.a(kotlin.collections.g.l());
        this.f12163i = v0VarA2;
        this.f12164j = kotlinx.coroutines.flow.c.b(v0VarA2);
        this.f12165k = new LinkedHashMap();
        this.f12166l = new LinkedHashMap();
        this.f12167m = new LinkedHashMap();
        this.f12168n = new LinkedHashMap();
        this.f12172r = new CopyOnWriteArrayList<>();
        this.f12173s = Lifecycle.State.INITIALIZED;
        this.f12174t = new androidx.lifecycle.r() { // from class: androidx.navigation.e
            @Override // androidx.lifecycle.r
            public final void onStateChanged(u uVar, Lifecycle.Event event) {
                NavController.I(this.f12247a, uVar, event);
            }
        };
        this.f12175u = new c();
        this.f12176v = true;
        this.f12177w = new q();
        this.f12178x = new LinkedHashMap();
        this.A = new LinkedHashMap();
        q qVar2 = this.f12177w;
        qVar2.b(new h(qVar2));
        this.f12177w.b(new ActivityNavigator(this.f12155a));
        this.C = new ArrayList();
        this.D = LazyKt__LazyJVMKt.b(new Function0<k>() { // from class: androidx.navigation.NavController$navInflater$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final k invoke() {
                k kVar = this.this$0.f12157c;
                return kVar == null ? new k(this.this$0.y(), this.this$0.f12177w) : kVar;
            }
        });
        u0<NavBackStackEntry> u0VarB2 = a1.b(1, 0, BufferOverflow.DROP_OLDEST, 2, null);
        this.E = u0VarB2;
        this.F = kotlinx.coroutines.flow.c.a(u0VarB2);
    }

    public static final void I(NavController this$0, u noName_0, Lifecycle.Event event) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(noName_0, "$noName_0");
        Intrinsics.g(event, "event");
        Lifecycle.State targetState = event.getTargetState();
        Intrinsics.f(targetState, "event.targetState");
        this$0.f12173s = targetState;
        if (this$0.f12158d != null) {
            Iterator<NavBackStackEntry> it = this$0.v().iterator();
            while (it.hasNext()) {
                it.next().i(event);
            }
        }
    }

    public static /* synthetic */ boolean T(NavController navController, int i11, boolean z11, boolean z12, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStackInternal");
        }
        if ((i12 & 4) != 0) {
            z12 = false;
        }
        return navController.S(i11, z11, z12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void V(NavController navController, NavBackStackEntry navBackStackEntry, boolean z11, ArrayDeque arrayDeque, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popEntryFromBackStack");
        }
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        if ((i11 & 4) != 0) {
            arrayDeque = new ArrayDeque();
        }
        navController.U(navBackStackEntry, z11, arrayDeque);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void o(NavController navController, NavDestination navDestination, Bundle bundle, NavBackStackEntry navBackStackEntry, List list, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addEntryToBackStack");
        }
        if ((i11 & 8) != 0) {
            list = kotlin.collections.g.l();
        }
        navController.n(navDestination, bundle, navBackStackEntry, list);
    }

    public NavDestination A() {
        NavBackStackEntry navBackStackEntryZ = z();
        if (navBackStackEntryZ == null) {
            return null;
        }
        return navBackStackEntryZ.f();
    }

    public final int B() {
        ArrayDeque<NavBackStackEntry> arrayDequeV = v();
        int i11 = 0;
        if (!(arrayDequeV instanceof Collection) || !arrayDequeV.isEmpty()) {
            Iterator<NavBackStackEntry> it = arrayDequeV.iterator();
            while (it.hasNext()) {
                if ((!(it.next().f() instanceof NavGraph)) && (i11 = i11 + 1) < 0) {
                    kotlin.collections.g.t();
                }
            }
        }
        return i11;
    }

    public NavGraph C() {
        NavGraph navGraph = this.f12158d;
        if (navGraph == null) {
            throw new IllegalStateException("You must call setGraph() before calling getGraph()".toString());
        }
        if (navGraph != null) {
            return navGraph;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.NavGraph");
    }

    public final Lifecycle.State D() {
        return this.f12169o == null ? Lifecycle.State.CREATED : this.f12173s;
    }

    public k E() {
        return (k) this.D.getValue();
    }

    public q F() {
        return this.f12177w;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0063  */
    public boolean G(Intent intent) {
        int[] iArr;
        NavDestination navDestinationH;
        Bundle bundle;
        int i11 = 0;
        if (intent == null) {
            return false;
        }
        Bundle extras = intent.getExtras();
        int[] intArray = extras == null ? null : extras.getIntArray("android-support-nav:controller:deepLinkIds");
        ArrayList parcelableArrayList = extras == null ? null : extras.getParcelableArrayList("android-support-nav:controller:deepLinkArgs");
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = extras == null ? null : extras.getBundle("android-support-nav:controller:deepLinkExtras");
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        if (intArray == null || intArray.length == 0) {
            NavGraph navGraph = this.f12158d;
            Intrinsics.d(navGraph);
            NavDestination.a aVarY = navGraph.y(new g(intent));
            if (aVarY != null) {
                NavDestination navDestinationB = aVarY.b();
                int[] iArrJ = NavDestination.j(navDestinationB, null, 1, null);
                Bundle bundleG = navDestinationB.g(aVarY.c());
                if (bundleG != null) {
                    bundle2.putAll(bundleG);
                }
                iArr = iArrJ;
                parcelableArrayList = null;
            } else {
                iArr = intArray;
            }
        } else {
            iArr = intArray;
        }
        if (iArr == null || iArr.length == 0) {
            return false;
        }
        String strU = u(iArr);
        if (strU != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Could not find destination ");
            sb2.append((Object) strU);
            sb2.append(" in the navigation graph, ignoring the deep link from ");
            sb2.append(intent);
            return false;
        }
        bundle2.putParcelable("android-support-nav:controller:deepLinkIntent", intent);
        int length = iArr.length;
        Bundle[] bundleArr = new Bundle[length];
        int i12 = 0;
        while (i12 < length) {
            int i13 = i12 + 1;
            Bundle bundle4 = new Bundle();
            bundle4.putAll(bundle2);
            if (parcelableArrayList != null && (bundle = (Bundle) parcelableArrayList.get(i12)) != null) {
                bundle4.putAll(bundle);
            }
            bundleArr[i12] = bundle4;
            i12 = i13;
        }
        int flags = intent.getFlags();
        int i14 = 268435456 & flags;
        if (i14 != 0 && (flags & 32768) == 0) {
            intent.addFlags(32768);
            f0 f0VarB = f0.g(this.f12155a).b(intent);
            Intrinsics.f(f0VarB, "create(context)\n        …ntWithParentStack(intent)");
            f0VarB.i();
            Activity activity = this.f12156b;
            if (activity != null) {
                activity.finish();
                activity.overridePendingTransition(0, 0);
            }
            return true;
        }
        if (i14 != 0) {
            if (!v().isEmpty()) {
                NavGraph navGraph2 = this.f12158d;
                Intrinsics.d(navGraph2);
                T(this, navGraph2.u(), true, false, 4, null);
            }
            while (i11 < iArr.length) {
                int i15 = iArr[i11];
                int i16 = i11 + 1;
                Bundle bundle5 = bundleArr[i11];
                final NavDestination navDestinationS = s(i15);
                if (navDestinationS == null) {
                    throw new IllegalStateException("Deep Linking failed: destination " + NavDestination.f12205k.b(this.f12155a, i15) + " cannot be found from the current destination " + A());
                }
                K(navDestinationS, bundle5, n.a(new Function1<m, Unit>() { // from class: androidx.navigation.NavController$handleDeepLink$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(m mVar) {
                        invoke2(mVar);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(m navOptions) {
                        Intrinsics.g(navOptions, "$this$navOptions");
                        navOptions.a(new Function1<a, Unit>() { // from class: androidx.navigation.NavController$handleDeepLink$2.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(a aVar) {
                                invoke2(aVar);
                                return Unit.f68710a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(a anim) {
                                Intrinsics.g(anim, "$this$anim");
                                anim.e(0);
                                anim.f(0);
                            }
                        });
                        NavDestination navDestination = navDestinationS;
                        if (navDestination instanceof NavGraph) {
                            Sequence<NavDestination> sequenceC = NavDestination.f12205k.c(navDestination);
                            NavController navController = this;
                            for (NavDestination navDestination2 : sequenceC) {
                                NavDestination navDestinationA = navController.A();
                                if (Intrinsics.b(navDestination2, navDestinationA == null ? null : navDestinationA.w())) {
                                    return;
                                }
                            }
                            if (NavController.H) {
                                navOptions.g(NavGraph.f12221q.a(this.C()).u(), new Function1<s, Unit>() { // from class: androidx.navigation.NavController$handleDeepLink$2.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(s sVar) {
                                        invoke2(sVar);
                                        return Unit.f68710a;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(s popUpTo) {
                                        Intrinsics.g(popUpTo, "$this$popUpTo");
                                        popUpTo.c(true);
                                    }
                                });
                            }
                        }
                    }
                }), null);
                i11 = i16;
            }
            return true;
        }
        NavGraph navGraph3 = this.f12158d;
        int length2 = iArr.length;
        int i17 = 0;
        while (i17 < length2) {
            int i18 = i17 + 1;
            int i19 = iArr[i17];
            Bundle bundle6 = bundleArr[i17];
            if (i17 == 0) {
                navDestinationH = this.f12158d;
            } else {
                Intrinsics.d(navGraph3);
                navDestinationH = navGraph3.H(i19);
            }
            if (navDestinationH == null) {
                throw new IllegalStateException("Deep Linking failed: destination " + NavDestination.f12205k.b(this.f12155a, i19) + " cannot be found in graph " + navGraph3);
            }
            if (i17 == iArr.length - 1) {
                l.a aVar = new l.a();
                NavGraph navGraph4 = this.f12158d;
                Intrinsics.d(navGraph4);
                K(navDestinationH, bundle6, l.a.i(aVar, navGraph4.u(), true, false, 4, null).b(0).c(0).a(), null);
            } else if (navDestinationH instanceof NavGraph) {
                navGraph3 = (NavGraph) navDestinationH;
                while (true) {
                    Intrinsics.d(navGraph3);
                    if (navGraph3.H(navGraph3.N()) instanceof NavGraph) {
                        navGraph3 = (NavGraph) navGraph3.H(navGraph3.N());
                    }
                }
            }
            i17 = i18;
        }
        this.f12161g = true;
        return true;
    }

    public final List<NavBackStackEntry> H(ArrayDeque<NavBackStackEntryState> arrayDeque) {
        ArrayList arrayList = new ArrayList();
        NavBackStackEntry navBackStackEntryR = v().r();
        NavDestination navDestinationF = navBackStackEntryR == null ? null : navBackStackEntryR.f();
        if (navDestinationF == null) {
            navDestinationF = C();
        }
        if (arrayDeque != null) {
            for (NavBackStackEntryState navBackStackEntryState : arrayDeque) {
                NavDestination navDestinationT = t(navDestinationF, navBackStackEntryState.getDestinationId());
                if (navDestinationT == null) {
                    throw new IllegalStateException(("Restore State failed: destination " + NavDestination.f12205k.b(y(), navBackStackEntryState.getDestinationId()) + " cannot be found from the current destination " + navDestinationF).toString());
                }
                arrayList.add(navBackStackEntryState.instantiate(y(), navDestinationT, D(), this.f12171q));
                navDestinationF = navDestinationT;
            }
        }
        return arrayList;
    }

    public final void J(NavBackStackEntry navBackStackEntry, NavBackStackEntry navBackStackEntry2) {
        this.f12165k.put(navBackStackEntry, navBackStackEntry2);
        if (this.f12166l.get(navBackStackEntry2) == null) {
            this.f12166l.put(navBackStackEntry2, new AtomicInteger(0));
        }
        AtomicInteger atomicInteger = this.f12166l.get(navBackStackEntry2);
        Intrinsics.d(atomicInteger);
        atomicInteger.incrementAndGet();
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0112 A[LOOP:1: B:40:0x010c->B:42:0x0112, LOOP_END] */
    public final void K(final NavDestination navDestination, Bundle bundle, l lVar, Navigator.a aVar) {
        boolean z11;
        NavDestination navDestinationF;
        Iterator<T> it;
        Iterator<T> it2 = this.f12178x.values().iterator();
        while (true) {
            z11 = true;
            if (!it2.hasNext()) {
                break;
            } else {
                ((NavControllerNavigatorState) it2.next()).i(true);
            }
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        boolean zS = (lVar == null || lVar.e() == -1) ? false : S(lVar.e(), lVar.f(), lVar.h());
        final Bundle bundleG = navDestination.g(bundle);
        if (lVar != null && lVar.i() && this.f12167m.containsKey(Integer.valueOf(navDestination.u()))) {
            booleanRef.element = Y(navDestination.u(), bundleG, lVar, aVar);
        } else {
            NavBackStackEntry navBackStackEntryZ = z();
            Navigator<? extends NavDestination> navigatorD = this.f12177w.d(navDestination.v());
            if (lVar != null && lVar.g()) {
                int iU = navDestination.u();
                if (navBackStackEntryZ != null && (navDestinationF = navBackStackEntryZ.f()) != null && iU == navDestinationF.u()) {
                    g0(v().removeLast());
                    NavBackStackEntry navBackStackEntry = new NavBackStackEntry(navBackStackEntryZ, bundleG);
                    v().addLast(navBackStackEntry);
                    NavGraph navGraphW = navBackStackEntry.f().w();
                    if (navGraphW != null) {
                        J(navBackStackEntry, w(navGraphW.u()));
                    }
                    navigatorD.g(navBackStackEntry);
                }
                i0();
                it = this.f12178x.values().iterator();
                while (it.hasNext()) {
                    ((NavControllerNavigatorState) it.next()).i(false);
                }
                if (!zS || booleanRef.element || z11) {
                    q();
                } else {
                    h0();
                    return;
                }
            }
            L(navigatorD, kotlin.collections.f.e(NavBackStackEntry.a.b(NavBackStackEntry.f12139o, this.f12155a, navDestination, bundleG, D(), this.f12171q, null, null, 96, null)), lVar, aVar, new Function1<NavBackStackEntry, Unit>() { // from class: androidx.navigation.NavController$navigate$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(NavBackStackEntry navBackStackEntry2) {
                    invoke2(navBackStackEntry2);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(NavBackStackEntry it3) {
                    Intrinsics.g(it3, "it");
                    booleanRef.element = true;
                    NavController.o(this, navDestination, bundleG, it3, null, 8, null);
                }
            });
        }
        z11 = false;
        i0();
        it = this.f12178x.values().iterator();
        while (it.hasNext()) {
            ((NavControllerNavigatorState) it.next()).i(false);
        }
        if (zS) {
        }
        q();
    }

    public final void L(Navigator<? extends NavDestination> navigator, List<NavBackStackEntry> list, l lVar, Navigator.a aVar, Function1<? super NavBackStackEntry, Unit> function1) {
        this.f12179y = function1;
        navigator.e(list, lVar, aVar);
        this.f12179y = null;
    }

    public final void M(Bundle bundle) {
        Activity activity;
        ArrayList<String> stringArrayList;
        Bundle bundle2 = this.f12159e;
        if (bundle2 != null && (stringArrayList = bundle2.getStringArrayList("android-support-nav:controller:navigatorState:names")) != null) {
            for (String name : stringArrayList) {
                q qVar = this.f12177w;
                Intrinsics.f(name, "name");
                Navigator navigatorD = qVar.d(name);
                Bundle bundle3 = bundle2.getBundle(name);
                if (bundle3 != null) {
                    navigatorD.h(bundle3);
                }
            }
        }
        Parcelable[] parcelableArr = this.f12160f;
        if (parcelableArr != null) {
            int length = parcelableArr.length;
            int i11 = 0;
            while (i11 < length) {
                Parcelable parcelable = parcelableArr[i11];
                i11++;
                NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) parcelable;
                NavDestination navDestinationS = s(navBackStackEntryState.getDestinationId());
                if (navDestinationS == null) {
                    throw new IllegalStateException("Restoring the Navigation back stack failed: destination " + NavDestination.f12205k.b(y(), navBackStackEntryState.getDestinationId()) + " cannot be found from the current destination " + A());
                }
                NavBackStackEntry navBackStackEntryInstantiate = navBackStackEntryState.instantiate(y(), navDestinationS, D(), this.f12171q);
                Navigator<? extends NavDestination> navigatorD2 = this.f12177w.d(navDestinationS.v());
                Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> map = this.f12178x;
                NavControllerNavigatorState navControllerNavigatorState = map.get(navigatorD2);
                if (navControllerNavigatorState == null) {
                    navControllerNavigatorState = new NavControllerNavigatorState(this, navigatorD2);
                    map.put(navigatorD2, navControllerNavigatorState);
                }
                v().add(navBackStackEntryInstantiate);
                navControllerNavigatorState.k(navBackStackEntryInstantiate);
                NavGraph navGraphW = navBackStackEntryInstantiate.f().w();
                if (navGraphW != null) {
                    J(navBackStackEntryInstantiate, w(navGraphW.u()));
                }
            }
            i0();
            this.f12160f = null;
        }
        Collection<Navigator<? extends NavDestination>> collectionValues = this.f12177w.e().values();
        ArrayList<Navigator<? extends NavDestination>> arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (!((Navigator) obj).c()) {
                arrayList.add(obj);
            }
        }
        for (Navigator<? extends NavDestination> navigator : arrayList) {
            Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> map2 = this.f12178x;
            NavControllerNavigatorState navControllerNavigatorState2 = map2.get(navigator);
            if (navControllerNavigatorState2 == null) {
                navControllerNavigatorState2 = new NavControllerNavigatorState(this, navigator);
                map2.put(navigator, navControllerNavigatorState2);
            }
            navigator.f(navControllerNavigatorState2);
        }
        if (this.f12158d == null || !v().isEmpty()) {
            q();
            return;
        }
        if (!this.f12161g && (activity = this.f12156b) != null) {
            Intrinsics.d(activity);
            if (G(activity.getIntent())) {
                return;
            }
        }
        NavGraph navGraph = this.f12158d;
        Intrinsics.d(navGraph);
        K(navGraph, bundle, null, null);
    }

    public boolean N() {
        if (v().isEmpty()) {
            return false;
        }
        NavDestination navDestinationA = A();
        Intrinsics.d(navDestinationA);
        return O(navDestinationA.u(), true);
    }

    public boolean O(int i11, boolean z11) {
        return P(i11, z11, false);
    }

    public boolean P(int i11, boolean z11, boolean z12) {
        return S(i11, z11, z12) && q();
    }

    public final void Q(NavBackStackEntry popUpTo, Function0<Unit> onComplete) {
        Intrinsics.g(popUpTo, "popUpTo");
        Intrinsics.g(onComplete, "onComplete");
        int iIndexOf = v().indexOf(popUpTo);
        if (iIndexOf < 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Ignoring pop of ");
            sb2.append(popUpTo);
            sb2.append(" as it was not found on the current back stack");
            return;
        }
        int i11 = iIndexOf + 1;
        if (i11 != v().size()) {
            S(v().get(i11).f().u(), true, false);
        }
        V(this, popUpTo, false, null, 6, null);
        onComplete.invoke();
        i0();
        q();
    }

    public final void R(Navigator<? extends NavDestination> navigator, NavBackStackEntry navBackStackEntry, boolean z11, Function1<? super NavBackStackEntry, Unit> function1) {
        this.f12180z = function1;
        navigator.j(navBackStackEntry, z11);
        this.f12180z = null;
    }

    public final boolean S(int i11, boolean z11, final boolean z12) {
        NavDestination navDestination;
        if (v().isEmpty()) {
            return false;
        }
        ArrayList<Navigator<? extends NavDestination>> arrayList = new ArrayList();
        Iterator it = CollectionsKt___CollectionsKt.z0(v()).iterator();
        while (true) {
            if (!it.hasNext()) {
                navDestination = null;
                break;
            }
            NavDestination navDestinationF = ((NavBackStackEntry) it.next()).f();
            Navigator navigatorD = this.f12177w.d(navDestinationF.v());
            if (z11 || navDestinationF.u() != i11) {
                arrayList.add(navigatorD);
            }
            if (navDestinationF.u() == i11) {
                navDestination = navDestinationF;
                break;
            }
        }
        if (navDestination == null) {
            String strB = NavDestination.f12205k.b(this.f12155a, i11);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Ignoring popBackStack to destination ");
            sb2.append(strB);
            sb2.append(" as it was not found on the current back stack");
            return false;
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final ArrayDeque<NavBackStackEntryState> arrayDeque = new ArrayDeque<>();
        for (Navigator<? extends NavDestination> navigator : arrayList) {
            final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            R(navigator, v().last(), z12, new Function1<NavBackStackEntry, Unit>() { // from class: androidx.navigation.NavController$popBackStackInternal$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(NavBackStackEntry navBackStackEntry) {
                    invoke2(navBackStackEntry);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(NavBackStackEntry entry) {
                    Intrinsics.g(entry, "entry");
                    booleanRef2.element = true;
                    booleanRef.element = true;
                    this.U(entry, z12, arrayDeque);
                }
            });
            if (!booleanRef2.element) {
                break;
            }
        }
        if (z12) {
            if (!z11) {
                for (NavDestination navDestination2 : SequencesKt___SequencesKt.t(SequencesKt__SequencesKt.f(navDestination, new Function1<NavDestination, NavDestination>() { // from class: androidx.navigation.NavController$popBackStackInternal$3
                    @Override // kotlin.jvm.functions.Function1
                    public final NavDestination invoke(NavDestination destination) {
                        Intrinsics.g(destination, "destination");
                        NavGraph navGraphW = destination.w();
                        if (navGraphW != null && navGraphW.N() == destination.u()) {
                            return destination.w();
                        }
                        return null;
                    }
                }), new Function1<NavDestination, Boolean>() { // from class: androidx.navigation.NavController$popBackStackInternal$4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(NavDestination destination) {
                        Intrinsics.g(destination, "destination");
                        return Boolean.valueOf(!this.this$0.f12167m.containsKey(Integer.valueOf(destination.u())));
                    }
                })) {
                    Map<Integer, String> map = this.f12167m;
                    Integer numValueOf = Integer.valueOf(navDestination2.u());
                    NavBackStackEntryState navBackStackEntryStateI = arrayDeque.i();
                    map.put(numValueOf, navBackStackEntryStateI == null ? null : navBackStackEntryStateI.getId());
                }
            }
            if (!arrayDeque.isEmpty()) {
                NavBackStackEntryState navBackStackEntryStateFirst = arrayDeque.first();
                Iterator it2 = SequencesKt___SequencesKt.t(SequencesKt__SequencesKt.f(s(navBackStackEntryStateFirst.getDestinationId()), new Function1<NavDestination, NavDestination>() { // from class: androidx.navigation.NavController$popBackStackInternal$6
                    @Override // kotlin.jvm.functions.Function1
                    public final NavDestination invoke(NavDestination destination) {
                        Intrinsics.g(destination, "destination");
                        NavGraph navGraphW = destination.w();
                        if (navGraphW != null && navGraphW.N() == destination.u()) {
                            return destination.w();
                        }
                        return null;
                    }
                }), new Function1<NavDestination, Boolean>() { // from class: androidx.navigation.NavController$popBackStackInternal$7
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(NavDestination destination) {
                        Intrinsics.g(destination, "destination");
                        return Boolean.valueOf(!this.this$0.f12167m.containsKey(Integer.valueOf(destination.u())));
                    }
                }).iterator();
                while (it2.hasNext()) {
                    this.f12167m.put(Integer.valueOf(((NavDestination) it2.next()).u()), navBackStackEntryStateFirst.getId());
                }
                this.f12168n.put(navBackStackEntryStateFirst.getId(), arrayDeque);
            }
        }
        i0();
        return booleanRef.element;
    }

    public final void U(NavBackStackEntry navBackStackEntry, boolean z11, ArrayDeque<NavBackStackEntryState> arrayDeque) {
        f fVar;
        f1<Set<NavBackStackEntry>> f1VarC;
        Set<NavBackStackEntry> value;
        NavBackStackEntry navBackStackEntryLast = v().last();
        if (!Intrinsics.b(navBackStackEntryLast, navBackStackEntry)) {
            throw new IllegalStateException(("Attempted to pop " + navBackStackEntry.f() + ", which is not the top of the back stack (" + navBackStackEntryLast.f() + ')').toString());
        }
        v().removeLast();
        NavControllerNavigatorState navControllerNavigatorState = this.f12178x.get(F().d(navBackStackEntryLast.f().v()));
        boolean z12 = true;
        if ((navControllerNavigatorState == null || (f1VarC = navControllerNavigatorState.c()) == null || (value = f1VarC.getValue()) == null || !value.contains(navBackStackEntryLast)) && !this.f12166l.containsKey(navBackStackEntryLast)) {
            z12 = false;
        }
        Lifecycle.State stateB = navBackStackEntryLast.getLifecycle().b();
        Lifecycle.State state = Lifecycle.State.CREATED;
        if (stateB.isAtLeast(state)) {
            if (z11) {
                navBackStackEntryLast.l(state);
                arrayDeque.addFirst(new NavBackStackEntryState(navBackStackEntryLast));
            }
            if (z12) {
                navBackStackEntryLast.l(state);
            } else {
                navBackStackEntryLast.l(Lifecycle.State.DESTROYED);
                g0(navBackStackEntryLast);
            }
        }
        if (z11 || z12 || (fVar = this.f12171q) == null) {
            return;
        }
        fVar.c(navBackStackEntryLast.g());
    }

    public final List<NavBackStackEntry> W() {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = this.f12178x.values().iterator();
        while (it.hasNext()) {
            Set<NavBackStackEntry> value = ((NavControllerNavigatorState) it.next()).c().getValue();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : value) {
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
                if (!arrayList.contains(navBackStackEntry) && !navBackStackEntry.getLifecycle().b().isAtLeast(Lifecycle.State.STARTED)) {
                    arrayList2.add(obj);
                }
            }
            kotlin.collections.k.A(arrayList, arrayList2);
        }
        ArrayDeque<NavBackStackEntry> arrayDequeV = v();
        ArrayList arrayList3 = new ArrayList();
        for (NavBackStackEntry navBackStackEntry2 : arrayDequeV) {
            NavBackStackEntry navBackStackEntry3 = navBackStackEntry2;
            if (!arrayList.contains(navBackStackEntry3) && navBackStackEntry3.getLifecycle().b().isAtLeast(Lifecycle.State.STARTED)) {
                arrayList3.add(navBackStackEntry2);
            }
        }
        kotlin.collections.k.A(arrayList, arrayList3);
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (!(((NavBackStackEntry) obj2).f() instanceof NavGraph)) {
                arrayList4.add(obj2);
            }
        }
        return arrayList4;
    }

    @CallSuper
    public void X(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(this.f12155a.getClassLoader());
        this.f12159e = bundle.getBundle("android-support-nav:controller:navigatorState");
        this.f12160f = bundle.getParcelableArray("android-support-nav:controller:backStack");
        this.f12168n.clear();
        int[] intArray = bundle.getIntArray("android-support-nav:controller:backStackDestIds");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("android-support-nav:controller:backStackIds");
        if (intArray != null && stringArrayList != null) {
            int length = intArray.length;
            int i11 = 0;
            int i12 = 0;
            while (i11 < length) {
                int i13 = intArray[i11];
                i11++;
                this.f12167m.put(Integer.valueOf(i13), stringArrayList.get(i12));
                i12++;
            }
        }
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("android-support-nav:controller:backStackStates");
        if (stringArrayList2 != null) {
            for (String id2 : stringArrayList2) {
                Parcelable[] parcelableArray = bundle.getParcelableArray(Intrinsics.p("android-support-nav:controller:backStackStates:", id2));
                if (parcelableArray != null) {
                    Map<String, ArrayDeque<NavBackStackEntryState>> map = this.f12168n;
                    Intrinsics.f(id2, "id");
                    ArrayDeque<NavBackStackEntryState> arrayDeque = new ArrayDeque<>(parcelableArray.length);
                    Iterator itA = ArrayIteratorKt.a(parcelableArray);
                    while (itA.hasNext()) {
                        Parcelable parcelable = (Parcelable) itA.next();
                        if (parcelable == null) {
                            throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.NavBackStackEntryState");
                        }
                        arrayDeque.add((NavBackStackEntryState) parcelable);
                    }
                    Unit unit = Unit.f68710a;
                    map.put(id2, arrayDeque);
                }
            }
        }
        this.f12161g = bundle.getBoolean("android-support-nav:controller:deepLinkHandled");
    }

    public final boolean Y(int i11, final Bundle bundle, l lVar, Navigator.a aVar) {
        NavBackStackEntry navBackStackEntry;
        NavDestination navDestinationF;
        if (!this.f12167m.containsKey(Integer.valueOf(i11))) {
            return false;
        }
        final String str = this.f12167m.get(Integer.valueOf(i11));
        kotlin.collections.k.F(this.f12167m.values(), new Function1<String, Boolean>() { // from class: androidx.navigation.NavController$restoreStateInternal$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String str2) {
                return Boolean.valueOf(Intrinsics.b(str2, str));
            }
        });
        final List<NavBackStackEntry> listH = H(this.f12168n.remove(str));
        ArrayList<List<NavBackStackEntry>> arrayList = new ArrayList();
        ArrayList<NavBackStackEntry> arrayList2 = new ArrayList();
        for (Object obj : listH) {
            if (!(((NavBackStackEntry) obj).f() instanceof NavGraph)) {
                arrayList2.add(obj);
            }
        }
        for (NavBackStackEntry navBackStackEntry2 : arrayList2) {
            List list = (List) CollectionsKt___CollectionsKt.r0(arrayList);
            String strV = null;
            if (list != null && (navBackStackEntry = (NavBackStackEntry) CollectionsKt___CollectionsKt.q0(list)) != null && (navDestinationF = navBackStackEntry.f()) != null) {
                strV = navDestinationF.v();
            }
            if (Intrinsics.b(strV, navBackStackEntry2.f().v())) {
                list.add(navBackStackEntry2);
            } else {
                arrayList.add(kotlin.collections.g.q(navBackStackEntry2));
            }
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        for (List<NavBackStackEntry> list2 : arrayList) {
            Navigator<? extends NavDestination> navigatorD = this.f12177w.d(((NavBackStackEntry) CollectionsKt___CollectionsKt.e0(list2)).f().v());
            final Ref.IntRef intRef = new Ref.IntRef();
            L(navigatorD, list2, lVar, aVar, new Function1<NavBackStackEntry, Unit>() { // from class: androidx.navigation.NavController$restoreStateInternal$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(NavBackStackEntry navBackStackEntry3) {
                    invoke2(navBackStackEntry3);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(NavBackStackEntry entry) {
                    List<NavBackStackEntry> listL;
                    Intrinsics.g(entry, "entry");
                    booleanRef.element = true;
                    int iIndexOf = listH.indexOf(entry);
                    if (iIndexOf != -1) {
                        int i12 = iIndexOf + 1;
                        listL = listH.subList(intRef.element, i12);
                        intRef.element = i12;
                    } else {
                        listL = kotlin.collections.g.l();
                    }
                    this.n(entry.f(), bundle, entry, listL);
                }
            });
        }
        return booleanRef.element;
    }

    @CallSuper
    public Bundle Z() {
        Bundle bundle;
        ArrayList<String> arrayList = new ArrayList<>();
        Bundle bundle2 = new Bundle();
        for (Map.Entry<String, Navigator<? extends NavDestination>> entry : this.f12177w.e().entrySet()) {
            String key = entry.getKey();
            Bundle bundleI = entry.getValue().i();
            if (bundleI != null) {
                arrayList.add(key);
                bundle2.putBundle(key, bundleI);
            }
        }
        if (!arrayList.isEmpty()) {
            bundle = new Bundle();
            bundle2.putStringArrayList("android-support-nav:controller:navigatorState:names", arrayList);
            bundle.putBundle("android-support-nav:controller:navigatorState", bundle2);
        } else {
            bundle = null;
        }
        if (!v().isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Parcelable[] parcelableArr = new Parcelable[v().size()];
            Iterator<NavBackStackEntry> it = v().iterator();
            int i11 = 0;
            while (it.hasNext()) {
                parcelableArr[i11] = new NavBackStackEntryState(it.next());
                i11++;
            }
            bundle.putParcelableArray("android-support-nav:controller:backStack", parcelableArr);
        }
        if (!this.f12167m.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            int[] iArr = new int[this.f12167m.size()];
            ArrayList<String> arrayList2 = new ArrayList<>();
            int i12 = 0;
            for (Map.Entry<Integer, String> entry2 : this.f12167m.entrySet()) {
                int iIntValue = entry2.getKey().intValue();
                String value = entry2.getValue();
                iArr[i12] = iIntValue;
                arrayList2.add(value);
                i12++;
            }
            bundle.putIntArray("android-support-nav:controller:backStackDestIds", iArr);
            bundle.putStringArrayList("android-support-nav:controller:backStackIds", arrayList2);
        }
        if (!this.f12168n.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            ArrayList<String> arrayList3 = new ArrayList<>();
            for (Map.Entry<String, ArrayDeque<NavBackStackEntryState>> entry3 : this.f12168n.entrySet()) {
                String key2 = entry3.getKey();
                ArrayDeque<NavBackStackEntryState> value2 = entry3.getValue();
                arrayList3.add(key2);
                Parcelable[] parcelableArr2 = new Parcelable[value2.size()];
                int i13 = 0;
                for (NavBackStackEntryState navBackStackEntryState : value2) {
                    int i14 = i13 + 1;
                    if (i13 < 0) {
                        kotlin.collections.g.u();
                    }
                    parcelableArr2[i13] = navBackStackEntryState;
                    i13 = i14;
                }
                bundle.putParcelableArray(Intrinsics.p("android-support-nav:controller:backStackStates:", key2), parcelableArr2);
            }
            bundle.putStringArrayList("android-support-nav:controller:backStackStates", arrayList3);
        }
        if (this.f12161g) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android-support-nav:controller:deepLinkHandled", this.f12161g);
        }
        return bundle;
    }

    @CallSuper
    public void a0(int i11) {
        c0(E().b(i11), null);
    }

    @CallSuper
    public void b0(int i11, Bundle bundle) {
        c0(E().b(i11), bundle);
    }

    @CallSuper
    public void c0(NavGraph graph, Bundle bundle) {
        Intrinsics.g(graph, "graph");
        if (!Intrinsics.b(this.f12158d, graph)) {
            NavGraph navGraph = this.f12158d;
            if (navGraph != null) {
                for (Integer id2 : new ArrayList(this.f12167m.keySet())) {
                    Intrinsics.f(id2, "id");
                    p(id2.intValue());
                }
                T(this, navGraph.u(), true, false, 4, null);
            }
            this.f12158d = graph;
            M(bundle);
            return;
        }
        int iQ = graph.L().q();
        int i11 = 0;
        while (i11 < iQ) {
            int i12 = i11 + 1;
            NavDestination newDestination = graph.L().r(i11);
            NavGraph navGraph2 = this.f12158d;
            Intrinsics.d(navGraph2);
            navGraph2.L().p(i11, newDestination);
            ArrayDeque<NavBackStackEntry> arrayDequeV = v();
            ArrayList<NavBackStackEntry> arrayList = new ArrayList();
            for (NavBackStackEntry navBackStackEntry : arrayDequeV) {
                int iU = navBackStackEntry.f().u();
                if (newDestination != null && iU == newDestination.u()) {
                    arrayList.add(navBackStackEntry);
                }
            }
            for (NavBackStackEntry navBackStackEntry2 : arrayList) {
                Intrinsics.f(newDestination, "newDestination");
                navBackStackEntry2.k(newDestination);
            }
            i11 = i12;
        }
    }

    public void d0(u owner) {
        Lifecycle lifecycle;
        Intrinsics.g(owner, "owner");
        if (Intrinsics.b(owner, this.f12169o)) {
            return;
        }
        u uVar = this.f12169o;
        if (uVar != null && (lifecycle = uVar.getLifecycle()) != null) {
            lifecycle.d(this.f12174t);
        }
        this.f12169o = owner;
        owner.getLifecycle().a(this.f12174t);
    }

    public void e0(OnBackPressedDispatcher dispatcher) {
        Intrinsics.g(dispatcher, "dispatcher");
        if (Intrinsics.b(dispatcher, this.f12170p)) {
            return;
        }
        u uVar = this.f12169o;
        if (uVar == null) {
            throw new IllegalStateException("You must call setLifecycleOwner() before calling setOnBackPressedDispatcher()".toString());
        }
        this.f12175u.remove();
        this.f12170p = dispatcher;
        dispatcher.i(uVar, this.f12175u);
        Lifecycle lifecycle = uVar.getLifecycle();
        lifecycle.d(this.f12174t);
        lifecycle.a(this.f12174t);
    }

    public void f0(x0 viewModelStore) {
        Intrinsics.g(viewModelStore, "viewModelStore");
        f fVar = this.f12171q;
        f.b bVar = f.f12248b;
        if (Intrinsics.b(fVar, bVar.a(viewModelStore))) {
            return;
        }
        if (!v().isEmpty()) {
            throw new IllegalStateException("ViewModelStore should be set before setGraph call".toString());
        }
        this.f12171q = bVar.a(viewModelStore);
    }

    public final NavBackStackEntry g0(NavBackStackEntry child) {
        Intrinsics.g(child, "child");
        NavBackStackEntry navBackStackEntryRemove = this.f12165k.remove(child);
        if (navBackStackEntryRemove == null) {
            return null;
        }
        AtomicInteger atomicInteger = this.f12166l.get(navBackStackEntryRemove);
        Integer numValueOf = atomicInteger != null ? Integer.valueOf(atomicInteger.decrementAndGet()) : null;
        if (numValueOf != null && numValueOf.intValue() == 0) {
            NavControllerNavigatorState navControllerNavigatorState = this.f12178x.get(this.f12177w.d(navBackStackEntryRemove.f().v()));
            if (navControllerNavigatorState != null) {
                navControllerNavigatorState.e(navBackStackEntryRemove);
            }
            this.f12166l.remove(navBackStackEntryRemove);
        }
        return navBackStackEntryRemove;
    }

    public final void h0() {
        NavDestination navDestinationW;
        f1<Set<NavBackStackEntry>> f1VarC;
        Set<NavBackStackEntry> value;
        AtomicInteger atomicInteger;
        List<NavBackStackEntry> listM0 = CollectionsKt___CollectionsKt.M0(v());
        if (listM0.isEmpty()) {
            return;
        }
        NavDestination navDestinationF = ((NavBackStackEntry) CollectionsKt___CollectionsKt.q0(listM0)).f();
        if (!(navDestinationF instanceof androidx.navigation.b)) {
            navDestinationW = null;
            break;
        }
        Iterator it = CollectionsKt___CollectionsKt.z0(listM0).iterator();
        while (true) {
            if (!it.hasNext()) {
                navDestinationW = null;
                break;
            }
            navDestinationW = ((NavBackStackEntry) it.next()).f();
            if (!(navDestinationW instanceof NavGraph) && !(navDestinationW instanceof androidx.navigation.b)) {
                break;
            }
        }
        HashMap map = new HashMap();
        for (NavBackStackEntry navBackStackEntry : CollectionsKt___CollectionsKt.z0(listM0)) {
            Lifecycle.State stateH = navBackStackEntry.h();
            NavDestination navDestinationF2 = navBackStackEntry.f();
            if (navDestinationF != null && navDestinationF2.u() == navDestinationF.u()) {
                Lifecycle.State state = Lifecycle.State.RESUMED;
                if (stateH != state) {
                    NavControllerNavigatorState navControllerNavigatorState = this.f12178x.get(F().d(navBackStackEntry.f().v()));
                    if (Intrinsics.b((navControllerNavigatorState == null || (f1VarC = navControllerNavigatorState.c()) == null || (value = f1VarC.getValue()) == null) ? null : Boolean.valueOf(value.contains(navBackStackEntry)), Boolean.TRUE) || ((atomicInteger = this.f12166l.get(navBackStackEntry)) != null && atomicInteger.get() == 0)) {
                        map.put(navBackStackEntry, Lifecycle.State.STARTED);
                    } else {
                        map.put(navBackStackEntry, state);
                    }
                }
                navDestinationF = navDestinationF.w();
            } else if (navDestinationW == null || navDestinationF2.u() != navDestinationW.u()) {
                navBackStackEntry.l(Lifecycle.State.CREATED);
            } else {
                if (stateH == Lifecycle.State.RESUMED) {
                    navBackStackEntry.l(Lifecycle.State.STARTED);
                } else {
                    Lifecycle.State state2 = Lifecycle.State.STARTED;
                    if (stateH != state2) {
                        map.put(navBackStackEntry, state2);
                    }
                }
                navDestinationW = navDestinationW.w();
            }
        }
        for (NavBackStackEntry navBackStackEntry2 : listM0) {
            Lifecycle.State state3 = (Lifecycle.State) map.get(navBackStackEntry2);
            if (state3 != null) {
                navBackStackEntry2.l(state3);
            } else {
                navBackStackEntry2.m();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x000e  */
    public final void i0() {
        boolean z11;
        androidx.activity.p pVar = this.f12175u;
        if (this.f12176v) {
            z11 = B() > 1;
        }
        pVar.setEnabled(z11);
    }

    public final void n(NavDestination navDestination, Bundle bundle, NavBackStackEntry navBackStackEntry, List<NavBackStackEntry> list) {
        NavBackStackEntry navBackStackEntry2;
        NavBackStackEntry navBackStackEntryPrevious;
        NavBackStackEntry navBackStackEntryPrevious2;
        Bundle bundle2 = bundle;
        NavBackStackEntry navBackStackEntry3 = navBackStackEntry;
        List<NavBackStackEntry> list2 = list;
        NavDestination navDestinationF = navBackStackEntry.f();
        if (!(navDestinationF instanceof androidx.navigation.b)) {
            while (!v().isEmpty() && (v().last().f() instanceof androidx.navigation.b) && T(this, v().last().f().u(), true, false, 4, null)) {
            }
        }
        ArrayDeque<NavBackStackEntry> arrayDeque = new ArrayDeque();
        NavBackStackEntry navBackStackEntry4 = null;
        if (navDestination instanceof NavGraph) {
            NavDestination navDestination2 = navDestinationF;
            while (true) {
                Intrinsics.d(navDestination2);
                NavGraph navGraphW = navDestination2.w();
                if (navGraphW != null) {
                    ListIterator<NavBackStackEntry> listIterator = list2.listIterator(list.size());
                    do {
                        if (!listIterator.hasPrevious()) {
                            navBackStackEntryPrevious2 = null;
                            break;
                        }
                        navBackStackEntryPrevious2 = listIterator.previous();
                    } while (!Intrinsics.b(navBackStackEntryPrevious2.f(), navGraphW));
                    NavBackStackEntry navBackStackEntryB = navBackStackEntryPrevious2;
                    if (navBackStackEntryB == null) {
                        navBackStackEntry2 = navBackStackEntry3;
                        navBackStackEntryB = NavBackStackEntry.a.b(NavBackStackEntry.f12139o, this.f12155a, navGraphW, bundle, D(), this.f12171q, null, null, 96, null);
                    } else {
                        navBackStackEntry2 = navBackStackEntry3;
                    }
                    arrayDeque.addFirst(navBackStackEntryB);
                    if ((!v().isEmpty()) && v().last().f() == navGraphW) {
                        V(this, v().last(), false, null, 6, null);
                    }
                } else {
                    navDestinationF = navDestinationF;
                    navBackStackEntry2 = navBackStackEntry3;
                }
                if (navGraphW == 0 || navGraphW == navDestination) {
                    break;
                }
                navBackStackEntry3 = navBackStackEntry2;
                navDestination2 = navGraphW;
                arrayDeque = arrayDeque;
                bundle2 = bundle2;
                list2 = list2;
                navDestinationF = navDestinationF;
            }
        } else {
            arrayDeque = arrayDeque;
            navDestinationF = navDestinationF;
            list2 = list2;
            navBackStackEntry2 = navBackStackEntry3;
            bundle2 = bundle2;
        }
        NavDestination navDestinationF2 = arrayDeque.isEmpty() ? navDestinationF : ((NavBackStackEntry) arrayDeque.first()).f();
        while (navDestinationF2 != null && s(navDestinationF2.u()) == null) {
            navDestinationF2 = navDestinationF2.w();
            if (navDestinationF2 != null) {
                ListIterator<NavBackStackEntry> listIterator2 = list2.listIterator(list.size());
                do {
                    if (!listIterator2.hasPrevious()) {
                        navBackStackEntryPrevious = null;
                        break;
                    }
                    navBackStackEntryPrevious = listIterator2.previous();
                } while (!Intrinsics.b(navBackStackEntryPrevious.f(), navDestinationF2));
                NavBackStackEntry navBackStackEntryB2 = navBackStackEntryPrevious;
                if (navBackStackEntryB2 == null) {
                    navBackStackEntryB2 = NavBackStackEntry.a.b(NavBackStackEntry.f12139o, this.f12155a, navDestinationF2, navDestinationF2.g(bundle2), D(), this.f12171q, null, null, 96, null);
                }
                arrayDeque.addFirst(navBackStackEntryB2);
            }
        }
        if (!arrayDeque.isEmpty()) {
            navDestinationF = ((NavBackStackEntry) arrayDeque.last()).f();
        }
        while (!v().isEmpty() && (v().last().f() instanceof NavGraph) && ((NavGraph) v().last().f()).I(navDestinationF.u(), false) == null) {
            V(this, v().last(), false, null, 6, null);
        }
        NavBackStackEntry navBackStackEntryI = v().i();
        if (navBackStackEntryI == null) {
            navBackStackEntryI = (NavBackStackEntry) arrayDeque.i();
        }
        if (!Intrinsics.b(navBackStackEntryI == null ? null : navBackStackEntryI.f(), this.f12158d)) {
            ListIterator<NavBackStackEntry> listIterator3 = list2.listIterator(list.size());
            while (listIterator3.hasPrevious()) {
                NavBackStackEntry navBackStackEntryPrevious3 = listIterator3.previous();
                NavDestination navDestinationF3 = navBackStackEntryPrevious3.f();
                NavGraph navGraph = this.f12158d;
                Intrinsics.d(navGraph);
                if (Intrinsics.b(navDestinationF3, navGraph)) {
                    navBackStackEntry4 = navBackStackEntryPrevious3;
                    break;
                }
            }
            NavBackStackEntry navBackStackEntryB3 = navBackStackEntry4;
            if (navBackStackEntryB3 == null) {
                NavBackStackEntry.a aVar = NavBackStackEntry.f12139o;
                Context context = this.f12155a;
                NavGraph navGraph2 = this.f12158d;
                Intrinsics.d(navGraph2);
                NavGraph navGraph3 = this.f12158d;
                Intrinsics.d(navGraph3);
                navBackStackEntryB3 = NavBackStackEntry.a.b(aVar, context, navGraph2, navGraph3.g(bundle2), D(), this.f12171q, null, null, 96, null);
            }
            arrayDeque.addFirst(navBackStackEntryB3);
        }
        for (NavBackStackEntry navBackStackEntry5 : arrayDeque) {
            NavControllerNavigatorState navControllerNavigatorState = this.f12178x.get(this.f12177w.d(navBackStackEntry5.f().v()));
            if (navControllerNavigatorState == null) {
                throw new IllegalStateException(("NavigatorBackStack for " + navDestination.v() + " should already be created").toString());
            }
            navControllerNavigatorState.k(navBackStackEntry5);
        }
        v().addAll(arrayDeque);
        v().add(navBackStackEntry2);
        for (NavBackStackEntry navBackStackEntry6 : CollectionsKt___CollectionsKt.y0(arrayDeque, navBackStackEntry2)) {
            NavGraph navGraphW2 = navBackStackEntry6.f().w();
            if (navGraphW2 != null) {
                J(navBackStackEntry6, w(navGraphW2.u()));
            }
        }
    }

    public final boolean p(int i11) {
        Iterator<T> it = this.f12178x.values().iterator();
        while (it.hasNext()) {
            ((NavControllerNavigatorState) it.next()).i(true);
        }
        boolean zY = Y(i11, null, null, null);
        Iterator<T> it2 = this.f12178x.values().iterator();
        while (it2.hasNext()) {
            ((NavControllerNavigatorState) it2.next()).i(false);
        }
        return zY && S(i11, true, false);
    }

    public final boolean q() {
        while (!v().isEmpty() && (v().last().f() instanceof NavGraph)) {
            V(this, v().last(), false, null, 6, null);
        }
        NavBackStackEntry navBackStackEntryR = v().r();
        if (navBackStackEntryR != null) {
            this.C.add(navBackStackEntryR);
        }
        this.B++;
        h0();
        int i11 = this.B - 1;
        this.B = i11;
        if (i11 == 0) {
            List<NavBackStackEntry> listM0 = CollectionsKt___CollectionsKt.M0(this.C);
            this.C.clear();
            for (NavBackStackEntry navBackStackEntry : listM0) {
                Iterator<b> it = this.f12172r.iterator();
                while (it.hasNext()) {
                    it.next().a(this, navBackStackEntry.f(), navBackStackEntry.d());
                }
                this.E.b(navBackStackEntry);
            }
            this.f12163i.b(W());
        }
        return navBackStackEntryR != null;
    }

    public void r(boolean z11) {
        this.f12176v = z11;
        i0();
    }

    public final NavDestination s(int i11) {
        NavGraph navGraph = this.f12158d;
        if (navGraph == null) {
            return null;
        }
        Intrinsics.d(navGraph);
        if (navGraph.u() == i11) {
            return this.f12158d;
        }
        NavBackStackEntry navBackStackEntryR = v().r();
        NavDestination navDestinationF = navBackStackEntryR != null ? navBackStackEntryR.f() : null;
        if (navDestinationF == null) {
            navDestinationF = this.f12158d;
            Intrinsics.d(navDestinationF);
        }
        return t(navDestinationF, i11);
    }

    public final NavDestination t(NavDestination navDestination, int i11) {
        NavGraph navGraphW;
        if (navDestination.u() == i11) {
            return navDestination;
        }
        if (navDestination instanceof NavGraph) {
            navGraphW = (NavGraph) navDestination;
        } else {
            navGraphW = navDestination.w();
            Intrinsics.d(navGraphW);
        }
        return navGraphW.H(i11);
    }

    public final String u(int[] iArr) {
        NavGraph navGraph = this.f12158d;
        int length = iArr.length;
        int i11 = 0;
        while (true) {
            NavDestination navDestinationH = null;
            if (i11 >= length) {
                return null;
            }
            int i12 = i11 + 1;
            int i13 = iArr[i11];
            if (i11 == 0) {
                NavGraph navGraph2 = this.f12158d;
                Intrinsics.d(navGraph2);
                if (navGraph2.u() == i13) {
                    navDestinationH = this.f12158d;
                }
            } else {
                Intrinsics.d(navGraph);
                navDestinationH = navGraph.H(i13);
            }
            if (navDestinationH == null) {
                return NavDestination.f12205k.b(this.f12155a, i13);
            }
            if (i11 != iArr.length - 1 && (navDestinationH instanceof NavGraph)) {
                navGraph = (NavGraph) navDestinationH;
                while (true) {
                    Intrinsics.d(navGraph);
                    if (navGraph.H(navGraph.N()) instanceof NavGraph) {
                        navGraph = (NavGraph) navGraph.H(navGraph.N());
                    }
                }
            }
            i11 = i12;
        }
    }

    public ArrayDeque<NavBackStackEntry> v() {
        return this.f12162h;
    }

    public NavBackStackEntry w(int i11) {
        NavBackStackEntry navBackStackEntryPrevious;
        ArrayDeque<NavBackStackEntry> arrayDequeV = v();
        ListIterator<NavBackStackEntry> listIterator = arrayDequeV.listIterator(arrayDequeV.size());
        do {
            if (!listIterator.hasPrevious()) {
                navBackStackEntryPrevious = null;
                break;
            }
            navBackStackEntryPrevious = listIterator.previous();
        } while (navBackStackEntryPrevious.f().u() != i11);
        NavBackStackEntry navBackStackEntry = navBackStackEntryPrevious;
        if (navBackStackEntry != null) {
            return navBackStackEntry;
        }
        throw new IllegalArgumentException(("No destination with ID " + i11 + " is on the NavController's back stack. The current destination is " + A()).toString());
    }

    public final NavBackStackEntry x(String route) {
        NavBackStackEntry navBackStackEntryPrevious;
        Intrinsics.g(route, "route");
        ArrayDeque<NavBackStackEntry> arrayDequeV = v();
        ListIterator<NavBackStackEntry> listIterator = arrayDequeV.listIterator(arrayDequeV.size());
        do {
            if (!listIterator.hasPrevious()) {
                navBackStackEntryPrevious = null;
                break;
            }
            navBackStackEntryPrevious = listIterator.previous();
        } while (!Intrinsics.b(navBackStackEntryPrevious.f().x(), route));
        NavBackStackEntry navBackStackEntry = navBackStackEntryPrevious;
        if (navBackStackEntry != null) {
            return navBackStackEntry;
        }
        throw new IllegalArgumentException(("No destination with route " + route + " is on the NavController's back stack. The current destination is " + A()).toString());
    }

    public final Context y() {
        return this.f12155a;
    }

    public NavBackStackEntry z() {
        return v().r();
    }
}
