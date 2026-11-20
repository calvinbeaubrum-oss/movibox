package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigator;
import androidx.navigation.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.k;
import kotlin.collections.s;
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
@Navigator.b("fragment")
public class e extends Navigator<b> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f12271g = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f12272c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FragmentManager f12273d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f12274e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<String> f12275f;

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
    public static class b extends NavDestination {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f12276m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Navigator<? extends b> fragmentNavigator) {
            super(fragmentNavigator);
            Intrinsics.g(fragmentNavigator, "fragmentNavigator");
        }

        public final String G() {
            String str = this.f12276m;
            if (str == null) {
                throw new IllegalStateException("Fragment class was not set".toString());
            }
            if (str != null) {
                return str;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }

        public final b H(String className) {
            Intrinsics.g(className, "className");
            this.f12276m = className;
            return this;
        }

        @Override // androidx.navigation.NavDestination
        public boolean equals(Object obj) {
            return obj != null && (obj instanceof b) && super.equals(obj) && Intrinsics.b(this.f12276m, ((b) obj).f12276m);
        }

        @Override // androidx.navigation.NavDestination
        public int hashCode() {
            int iHashCode = super.hashCode() * 31;
            String str = this.f12276m;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        @Override // androidx.navigation.NavDestination
        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(super.toString());
            sb2.append(" class=");
            String str = this.f12276m;
            if (str == null) {
                sb2.append("null");
            } else {
                sb2.append(str);
            }
            String string = sb2.toString();
            Intrinsics.f(string, "sb.toString()");
            return string;
        }

        @Override // androidx.navigation.NavDestination
        @CallSuper
        public void z(Context context, AttributeSet attrs) {
            Intrinsics.g(context, "context");
            Intrinsics.g(attrs, "attrs");
            super.z(context, attrs);
            TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attrs, R$styleable.FragmentNavigator);
            Intrinsics.f(typedArrayObtainAttributes, "context.resources.obtain…leable.FragmentNavigator)");
            String string = typedArrayObtainAttributes.getString(R$styleable.FragmentNavigator_android_name);
            if (string != null) {
                H(string);
            }
            Unit unit = Unit.f68710a;
            typedArrayObtainAttributes.recycle();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements Navigator.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LinkedHashMap<View, String> f12277a;

        public final Map<View, String> a() {
            return s.t(this.f12277a);
        }
    }

    public e(Context context, FragmentManager fragmentManager, int i11) {
        Intrinsics.g(context, "context");
        Intrinsics.g(fragmentManager, "fragmentManager");
        this.f12272c = context;
        this.f12273d = fragmentManager;
        this.f12274e = i11;
        this.f12275f = new LinkedHashSet();
    }

    private final void m(NavBackStackEntry navBackStackEntry, l lVar, Navigator.a aVar) {
        List<NavBackStackEntry> value = b().b().getValue();
        boolean zIsEmpty = value.isEmpty();
        if (lVar != null && !zIsEmpty && lVar.i() && this.f12275f.remove(navBackStackEntry.g())) {
            this.f12273d.restoreBackStack(navBackStackEntry.g());
            b().h(navBackStackEntry);
            return;
        }
        b bVar = (b) navBackStackEntry.f();
        Bundle bundleD = navBackStackEntry.d();
        String strG = bVar.G();
        boolean z11 = false;
        if (strG.charAt(0) == '.') {
            strG = Intrinsics.p(this.f12272c.getPackageName(), strG);
        }
        Fragment fragmentInstantiate = this.f12273d.getFragmentFactory().instantiate(this.f12272c.getClassLoader(), strG);
        Intrinsics.f(fragmentInstantiate, "fragmentManager.fragment…t.classLoader, className)");
        fragmentInstantiate.setArguments(bundleD);
        FragmentTransaction fragmentTransactionBeginTransaction = this.f12273d.beginTransaction();
        Intrinsics.f(fragmentTransactionBeginTransaction, "fragmentManager.beginTransaction()");
        int iA = lVar == null ? -1 : lVar.a();
        int iB = lVar == null ? -1 : lVar.b();
        int iC = lVar == null ? -1 : lVar.c();
        int iD = lVar == null ? -1 : lVar.d();
        if (iA != -1 || iB != -1 || iC != -1 || iD != -1) {
            if (iA == -1) {
                iA = 0;
            }
            if (iB == -1) {
                iB = 0;
            }
            if (iC == -1) {
                iC = 0;
            }
            if (iD == -1) {
                iD = 0;
            }
            fragmentTransactionBeginTransaction.setCustomAnimations(iA, iB, iC, iD);
        }
        fragmentTransactionBeginTransaction.replace(this.f12274e, fragmentInstantiate);
        fragmentTransactionBeginTransaction.setPrimaryNavigationFragment(fragmentInstantiate);
        boolean z12 = lVar != null && !zIsEmpty && lVar.g() && ((NavBackStackEntry) CollectionsKt___CollectionsKt.q0(value)).f().u() == bVar.u();
        if (zIsEmpty) {
            z11 = true;
        } else if (!z12) {
            fragmentTransactionBeginTransaction.addToBackStack(navBackStackEntry.g());
            z11 = true;
        } else if (value.size() > 1) {
            this.f12273d.popBackStack(navBackStackEntry.g(), 1);
            fragmentTransactionBeginTransaction.addToBackStack(navBackStackEntry.g());
        }
        if (aVar instanceof c) {
            for (Map.Entry<View, String> entry : ((c) aVar).a().entrySet()) {
                fragmentTransactionBeginTransaction.addSharedElement(entry.getKey(), entry.getValue());
            }
        }
        fragmentTransactionBeginTransaction.setReorderingAllowed(true);
        fragmentTransactionBeginTransaction.commit();
        if (z11) {
            b().h(navBackStackEntry);
        }
    }

    @Override // androidx.navigation.Navigator
    public void e(List<NavBackStackEntry> entries, l lVar, Navigator.a aVar) {
        Intrinsics.g(entries, "entries");
        if (this.f12273d.isStateSaved()) {
            return;
        }
        Iterator<NavBackStackEntry> it = entries.iterator();
        while (it.hasNext()) {
            m(it.next(), lVar, aVar);
        }
    }

    @Override // androidx.navigation.Navigator
    public void h(Bundle savedState) {
        Intrinsics.g(savedState, "savedState");
        ArrayList<String> stringArrayList = savedState.getStringArrayList("androidx-nav-fragment:navigator:savedIds");
        if (stringArrayList != null) {
            this.f12275f.clear();
            k.A(this.f12275f, stringArrayList);
        }
    }

    @Override // androidx.navigation.Navigator
    public Bundle i() {
        if (this.f12275f.isEmpty()) {
            return null;
        }
        return androidx.core.os.c.b(TuplesKt.a("androidx-nav-fragment:navigator:savedIds", new ArrayList(this.f12275f)));
    }

    @Override // androidx.navigation.Navigator
    public void j(NavBackStackEntry popUpTo, boolean z11) {
        Intrinsics.g(popUpTo, "popUpTo");
        if (this.f12273d.isStateSaved()) {
            return;
        }
        if (z11) {
            List<NavBackStackEntry> value = b().b().getValue();
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) CollectionsKt___CollectionsKt.e0(value);
            for (NavBackStackEntry navBackStackEntry2 : CollectionsKt___CollectionsKt.z0(value.subList(value.indexOf(popUpTo), value.size()))) {
                if (Intrinsics.b(navBackStackEntry2, navBackStackEntry)) {
                    Intrinsics.p("FragmentManager cannot save the state of the initial destination ", navBackStackEntry2);
                } else {
                    this.f12273d.saveBackStack(navBackStackEntry2.g());
                    this.f12275f.add(navBackStackEntry2.g());
                }
            }
        } else {
            this.f12273d.popBackStack(popUpTo.g(), 1);
        }
        b().g(popUpTo, z11);
    }

    @Override // androidx.navigation.Navigator
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public b a() {
        return new b(this);
    }
}
