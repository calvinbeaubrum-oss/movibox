package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.CallSuper;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.t;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.r;
import androidx.lifecycle.u;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigator;
import androidx.navigation.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@Navigator.b("dialog")
public final class c extends Navigator<b> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f12265g = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f12266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FragmentManager f12267d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<String> f12268e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final r f12269f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static class b extends NavDestination implements androidx.navigation.b {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f12270m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Navigator<? extends b> fragmentNavigator) {
            super(fragmentNavigator);
            Intrinsics.g(fragmentNavigator, "fragmentNavigator");
        }

        public final String G() {
            String str = this.f12270m;
            if (str == null) {
                throw new IllegalStateException("DialogFragment class was not set".toString());
            }
            if (str != null) {
                return str;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }

        public final b H(String className) {
            Intrinsics.g(className, "className");
            this.f12270m = className;
            return this;
        }

        @Override // androidx.navigation.NavDestination
        public boolean equals(Object obj) {
            return obj != null && (obj instanceof b) && super.equals(obj) && Intrinsics.b(this.f12270m, ((b) obj).f12270m);
        }

        @Override // androidx.navigation.NavDestination
        public int hashCode() {
            int iHashCode = super.hashCode() * 31;
            String str = this.f12270m;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        @Override // androidx.navigation.NavDestination
        @CallSuper
        public void z(Context context, AttributeSet attrs) {
            Intrinsics.g(context, "context");
            Intrinsics.g(attrs, "attrs");
            super.z(context, attrs);
            TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attrs, R$styleable.DialogFragmentNavigator);
            Intrinsics.f(typedArrayObtainAttributes, "context.resources.obtain…ntNavigator\n            )");
            String string = typedArrayObtainAttributes.getString(R$styleable.DialogFragmentNavigator_android_name);
            if (string != null) {
                H(string);
            }
            typedArrayObtainAttributes.recycle();
        }
    }

    public c(Context context, FragmentManager fragmentManager) {
        Intrinsics.g(context, "context");
        Intrinsics.g(fragmentManager, "fragmentManager");
        this.f12266c = context;
        this.f12267d = fragmentManager;
        this.f12268e = new LinkedHashSet();
        this.f12269f = new r() { // from class: androidx.navigation.fragment.b
            @Override // androidx.lifecycle.r
            public final void onStateChanged(u uVar, Lifecycle.Event event) {
                c.p(this.f12264a, uVar, event);
            }
        };
    }

    public static final void p(c this$0, u source, Lifecycle.Event event) {
        NavBackStackEntry navBackStackEntryPrevious;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(source, "source");
        Intrinsics.g(event, "event");
        if (event == Lifecycle.Event.ON_CREATE) {
            DialogFragment dialogFragment = (DialogFragment) source;
            List<NavBackStackEntry> value = this$0.b().b().getValue();
            if (!(value instanceof Collection) || !value.isEmpty()) {
                Iterator<T> it = value.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.b(((NavBackStackEntry) it.next()).g(), dialogFragment.getTag())) {
                        return;
                    }
                }
            }
            dialogFragment.dismiss();
            return;
        }
        if (event == Lifecycle.Event.ON_STOP) {
            DialogFragment dialogFragment2 = (DialogFragment) source;
            if (dialogFragment2.requireDialog().isShowing()) {
                return;
            }
            List<NavBackStackEntry> value2 = this$0.b().b().getValue();
            ListIterator<NavBackStackEntry> listIterator = value2.listIterator(value2.size());
            do {
                if (!listIterator.hasPrevious()) {
                    navBackStackEntryPrevious = null;
                    break;
                }
                navBackStackEntryPrevious = listIterator.previous();
            } while (!Intrinsics.b(navBackStackEntryPrevious.g(), dialogFragment2.getTag()));
            if (navBackStackEntryPrevious == null) {
                throw new IllegalStateException(("Dialog " + dialogFragment2 + " has already been popped off of the Navigation back stack").toString());
            }
            NavBackStackEntry navBackStackEntry = navBackStackEntryPrevious;
            if (!Intrinsics.b(CollectionsKt___CollectionsKt.r0(value2), navBackStackEntry)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Dialog ");
                sb2.append(dialogFragment2);
                sb2.append(" was dismissed while it was not the top of the back stack, popping all dialogs above this dismissed dialog");
            }
            this$0.j(navBackStackEntry, false);
        }
    }

    public static final void q(c this$0, FragmentManager noName_0, Fragment childFragment) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(noName_0, "$noName_0");
        Intrinsics.g(childFragment, "childFragment");
        if (this$0.f12268e.remove(childFragment.getTag())) {
            childFragment.getLifecycle().a(this$0.f12269f);
        }
    }

    @Override // androidx.navigation.Navigator
    public void e(List<NavBackStackEntry> entries, l lVar, Navigator.a aVar) {
        Intrinsics.g(entries, "entries");
        if (this.f12267d.isStateSaved()) {
            return;
        }
        Iterator<NavBackStackEntry> it = entries.iterator();
        while (it.hasNext()) {
            o(it.next());
        }
    }

    @Override // androidx.navigation.Navigator
    public void f(androidx.navigation.r state) {
        Lifecycle lifecycle;
        Intrinsics.g(state, "state");
        super.f(state);
        for (NavBackStackEntry navBackStackEntry : state.b().getValue()) {
            DialogFragment dialogFragment = (DialogFragment) this.f12267d.findFragmentByTag(navBackStackEntry.g());
            Unit unit = null;
            if (dialogFragment != null && (lifecycle = dialogFragment.getLifecycle()) != null) {
                lifecycle.a(this.f12269f);
                unit = Unit.f68710a;
            }
            if (unit == null) {
                this.f12268e.add(navBackStackEntry.g());
            }
        }
        this.f12267d.addFragmentOnAttachListener(new t() { // from class: androidx.navigation.fragment.a
            @Override // androidx.fragment.app.t
            public final void a(FragmentManager fragmentManager, Fragment fragment) {
                c.q(this.f12263a, fragmentManager, fragment);
            }
        });
    }

    @Override // androidx.navigation.Navigator
    public void j(NavBackStackEntry popUpTo, boolean z11) {
        Intrinsics.g(popUpTo, "popUpTo");
        if (this.f12267d.isStateSaved()) {
            return;
        }
        List<NavBackStackEntry> value = b().b().getValue();
        Iterator it = CollectionsKt___CollectionsKt.z0(value.subList(value.indexOf(popUpTo), value.size())).iterator();
        while (it.hasNext()) {
            Fragment fragmentFindFragmentByTag = this.f12267d.findFragmentByTag(((NavBackStackEntry) it.next()).g());
            if (fragmentFindFragmentByTag != null) {
                fragmentFindFragmentByTag.getLifecycle().d(this.f12269f);
                ((DialogFragment) fragmentFindFragmentByTag).dismiss();
            }
        }
        b().g(popUpTo, z11);
    }

    @Override // androidx.navigation.Navigator
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public b a() {
        return new b(this);
    }

    public final void o(NavBackStackEntry navBackStackEntry) {
        b bVar = (b) navBackStackEntry.f();
        String strG = bVar.G();
        if (strG.charAt(0) == '.') {
            strG = Intrinsics.p(this.f12266c.getPackageName(), strG);
        }
        Fragment fragmentInstantiate = this.f12267d.getFragmentFactory().instantiate(this.f12266c.getClassLoader(), strG);
        Intrinsics.f(fragmentInstantiate, "fragmentManager.fragment…ader, className\n        )");
        if (!DialogFragment.class.isAssignableFrom(fragmentInstantiate.getClass())) {
            throw new IllegalArgumentException(("Dialog destination " + bVar.G() + " is not an instance of DialogFragment").toString());
        }
        DialogFragment dialogFragment = (DialogFragment) fragmentInstantiate;
        dialogFragment.setArguments(navBackStackEntry.d());
        dialogFragment.getLifecycle().a(this.f12269f);
        dialogFragment.show(this.f12267d, navBackStackEntry.g());
        b().h(navBackStackEntry);
    }
}
