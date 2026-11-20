package androidx.navigation;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.l0;
import androidx.lifecycle.q0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u;
import androidx.lifecycle.v0;
import androidx.lifecycle.w;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class NavBackStackEntry implements u, y0, androidx.lifecycle.m, f6.e {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f12139o = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f12140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public NavDestination f12141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bundle f12142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Lifecycle.State f12143d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p f12144f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f12145g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Bundle f12146h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public w f12147i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final f6.d f12148j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f12149k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f12150l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f12151m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Lifecycle.State f12152n;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ NavBackStackEntry b(a aVar, Context context, NavDestination navDestination, Bundle bundle, Lifecycle.State state, p pVar, String str, Bundle bundle2, int i11, Object obj) {
            String str2;
            Bundle bundle3 = (i11 & 4) != 0 ? null : bundle;
            Lifecycle.State state2 = (i11 & 8) != 0 ? Lifecycle.State.CREATED : state;
            p pVar2 = (i11 & 16) != 0 ? null : pVar;
            if ((i11 & 32) != 0) {
                String string = UUID.randomUUID().toString();
                Intrinsics.f(string, "randomUUID().toString()");
                str2 = string;
            } else {
                str2 = str;
            }
            return aVar.a(context, navDestination, bundle3, state2, pVar2, str2, (i11 & 64) != 0 ? null : bundle2);
        }

        public final NavBackStackEntry a(Context context, NavDestination destination, Bundle bundle, Lifecycle.State hostLifecycleState, p pVar, String id2, Bundle bundle2) {
            Intrinsics.g(destination, "destination");
            Intrinsics.g(hostLifecycleState, "hostLifecycleState");
            Intrinsics.g(id2, "id");
            return new NavBackStackEntry(context, destination, bundle, hostLifecycleState, pVar, id2, bundle2, null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static final class b extends androidx.lifecycle.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(f6.e owner, Bundle bundle) {
            super(owner, bundle);
            Intrinsics.g(owner, "owner");
        }

        @Override // androidx.lifecycle.a
        public <T extends t0> T c(String key, Class<T> modelClass, l0 handle) {
            Intrinsics.g(key, "key");
            Intrinsics.g(modelClass, "modelClass");
            Intrinsics.g(handle, "handle");
            return new c(handle);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static final class c extends t0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l0 f12153a;

        public c(l0 handle) {
            Intrinsics.g(handle, "handle");
            this.f12153a = handle;
        }

        public final l0 b() {
            return this.f12153a;
        }
    }

    public NavBackStackEntry(Context context, NavDestination navDestination, Bundle bundle, Lifecycle.State state, p pVar, String str, Bundle bundle2) {
        this.f12140a = context;
        this.f12141b = navDestination;
        this.f12142c = bundle;
        this.f12143d = state;
        this.f12144f = pVar;
        this.f12145g = str;
        this.f12146h = bundle2;
        this.f12147i = new w(this);
        f6.d dVarA = f6.d.a(this);
        Intrinsics.f(dVarA, "create(this)");
        this.f12148j = dVarA;
        this.f12150l = LazyKt__LazyJVMKt.b(new Function0<q0>() { // from class: androidx.navigation.NavBackStackEntry$defaultFactory$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final q0 invoke() {
                Context context2 = this.this$0.f12140a;
                Context applicationContext = context2 == null ? null : context2.getApplicationContext();
                Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
                NavBackStackEntry navBackStackEntry = this.this$0;
                return new q0(application, navBackStackEntry, navBackStackEntry.d());
            }
        });
        this.f12151m = LazyKt__LazyJVMKt.b(new Function0<l0>() { // from class: androidx.navigation.NavBackStackEntry$savedStateHandle$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final l0 invoke() {
                if (!this.this$0.f12149k) {
                    throw new IllegalStateException("You cannot access the NavBackStackEntry's SavedStateHandle until it is added to the NavController's back stack (i.e., the Lifecycle of the NavBackStackEntry reaches the CREATED state).".toString());
                }
                if (this.this$0.f12147i.b() == Lifecycle.State.DESTROYED) {
                    throw new IllegalStateException("You cannot access the NavBackStackEntry's SavedStateHandle after the NavBackStackEntry is destroyed.".toString());
                }
                NavBackStackEntry navBackStackEntry = this.this$0;
                return ((NavBackStackEntry.c) new v0(navBackStackEntry, new NavBackStackEntry.b(navBackStackEntry, null)).a(NavBackStackEntry.c.class)).b();
            }
        });
        this.f12152n = Lifecycle.State.INITIALIZED;
    }

    public /* synthetic */ NavBackStackEntry(Context context, NavDestination navDestination, Bundle bundle, Lifecycle.State state, p pVar, String str, Bundle bundle2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, navDestination, bundle, state, pVar, str, bundle2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NavBackStackEntry(NavBackStackEntry entry, Bundle bundle) {
        this(entry.f12140a, entry.f12141b, bundle, entry.f12143d, entry.f12144f, entry.f12145g, entry.f12146h);
        Intrinsics.g(entry, "entry");
        this.f12143d = entry.f12143d;
        l(entry.f12152n);
    }

    public final Bundle d() {
        return this.f12142c;
    }

    public final q0 e() {
        return (q0) this.f12150l.getValue();
    }

    public boolean equals(Object obj) {
        Set<String> setKeySet;
        if (obj == null || !(obj instanceof NavBackStackEntry)) {
            return false;
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
        if (!Intrinsics.b(this.f12145g, navBackStackEntry.f12145g) || !Intrinsics.b(this.f12141b, navBackStackEntry.f12141b) || !Intrinsics.b(this.f12147i, navBackStackEntry.f12147i) || !Intrinsics.b(getSavedStateRegistry(), navBackStackEntry.getSavedStateRegistry())) {
            return false;
        }
        if (!Intrinsics.b(this.f12142c, navBackStackEntry.f12142c)) {
            Bundle bundle = this.f12142c;
            if (bundle == null || (setKeySet = bundle.keySet()) == null) {
                return false;
            }
            Set<String> set = setKeySet;
            if (!(set instanceof Collection) || !set.isEmpty()) {
                for (String str : set) {
                    Object obj2 = d().get(str);
                    Bundle bundleD = navBackStackEntry.d();
                    if (!Intrinsics.b(obj2, bundleD == null ? null : bundleD.get(str))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public final NavDestination f() {
        return this.f12141b;
    }

    public final String g() {
        return this.f12145g;
    }

    @Override // androidx.lifecycle.m
    public /* synthetic */ r3.a getDefaultViewModelCreationExtras() {
        return androidx.lifecycle.l.a(this);
    }

    @Override // androidx.lifecycle.m
    public v0.c getDefaultViewModelProviderFactory() {
        return e();
    }

    @Override // androidx.lifecycle.u
    public Lifecycle getLifecycle() {
        return this.f12147i;
    }

    @Override // f6.e
    public f6.c getSavedStateRegistry() {
        f6.c cVarB = this.f12148j.b();
        Intrinsics.f(cVarB, "savedStateRegistryController.savedStateRegistry");
        return cVarB;
    }

    @Override // androidx.lifecycle.y0
    public x0 getViewModelStore() {
        if (!this.f12149k) {
            throw new IllegalStateException("You cannot access the NavBackStackEntry's ViewModels until it is added to the NavController's back stack (i.e., the Lifecycle of the NavBackStackEntry reaches the CREATED state).".toString());
        }
        if (this.f12147i.b() == Lifecycle.State.DESTROYED) {
            throw new IllegalStateException("You cannot access the NavBackStackEntry's ViewModels after the NavBackStackEntry is destroyed.".toString());
        }
        p pVar = this.f12144f;
        if (pVar != null) {
            return pVar.a(this.f12145g);
        }
        throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.".toString());
    }

    public final Lifecycle.State h() {
        return this.f12152n;
    }

    public int hashCode() {
        Set<String> setKeySet;
        int iHashCode = (this.f12145g.hashCode() * 31) + this.f12141b.hashCode();
        Bundle bundle = this.f12142c;
        if (bundle != null && (setKeySet = bundle.keySet()) != null) {
            Iterator<T> it = setKeySet.iterator();
            while (it.hasNext()) {
                int i11 = iHashCode * 31;
                Object obj = d().get((String) it.next());
                iHashCode = i11 + (obj == null ? 0 : obj.hashCode());
            }
        }
        return (((iHashCode * 31) + this.f12147i.hashCode()) * 31) + getSavedStateRegistry().hashCode();
    }

    public final void i(Lifecycle.Event event) {
        Intrinsics.g(event, "event");
        Lifecycle.State targetState = event.getTargetState();
        Intrinsics.f(targetState, "event.targetState");
        this.f12143d = targetState;
        m();
    }

    public final void j(Bundle outBundle) {
        Intrinsics.g(outBundle, "outBundle");
        this.f12148j.e(outBundle);
    }

    public final void k(NavDestination navDestination) {
        Intrinsics.g(navDestination, "<set-?>");
        this.f12141b = navDestination;
    }

    public final void l(Lifecycle.State maxState) {
        Intrinsics.g(maxState, "maxState");
        this.f12152n = maxState;
        m();
    }

    public final void m() {
        if (!this.f12149k) {
            this.f12148j.d(this.f12146h);
            this.f12149k = true;
        }
        if (this.f12143d.ordinal() < this.f12152n.ordinal()) {
            this.f12147i.n(this.f12143d);
        } else {
            this.f12147i.n(this.f12152n);
        }
    }
}
