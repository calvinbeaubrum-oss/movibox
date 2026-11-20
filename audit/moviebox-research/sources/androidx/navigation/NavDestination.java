package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.annotation.CallSuper;
import androidx.collection.w0;
import androidx.collection.y0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.u;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;

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
public class NavDestination {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Companion f12205k = new Companion(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Map<String, Class<?>> f12206l = new LinkedHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public NavGraph f12208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f12209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CharSequence f12210d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<NavDeepLink> f12211f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final w0<c> f12212g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<String, d> f12213h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f12214i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f12215j;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(String str) {
            return str != null ? Intrinsics.p("android-app://androidx.navigation/", str) : "";
        }

        @JvmStatic
        public final String b(Context context, int i11) {
            String strValueOf;
            Intrinsics.g(context, "context");
            if (i11 <= 16777215) {
                return String.valueOf(i11);
            }
            try {
                strValueOf = context.getResources().getResourceName(i11);
            } catch (Resources.NotFoundException unused) {
                strValueOf = String.valueOf(i11);
            }
            Intrinsics.f(strValueOf, "try {\n                co….toString()\n            }");
            return strValueOf;
        }

        public final Sequence<NavDestination> c(NavDestination navDestination) {
            Intrinsics.g(navDestination, "<this>");
            return SequencesKt__SequencesKt.f(navDestination, new Function1<NavDestination, NavDestination>() { // from class: androidx.navigation.NavDestination$Companion$hierarchy$1
                @Override // kotlin.jvm.functions.Function1
                public final NavDestination invoke(NavDestination it) {
                    Intrinsics.g(it, "it");
                    return it.w();
                }
            });
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static final class a implements Comparable<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final NavDestination f12216a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Bundle f12217b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f12218c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f12219d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f12220f;

        public a(NavDestination destination, Bundle bundle, boolean z11, boolean z12, int i11) {
            Intrinsics.g(destination, "destination");
            this.f12216a = destination;
            this.f12217b = bundle;
            this.f12218c = z11;
            this.f12219d = z12;
            this.f12220f = i11;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a other) {
            Intrinsics.g(other, "other");
            boolean z11 = this.f12218c;
            if (z11 && !other.f12218c) {
                return 1;
            }
            if (!z11 && other.f12218c) {
                return -1;
            }
            Bundle bundle = this.f12217b;
            if (bundle != null && other.f12217b == null) {
                return 1;
            }
            if (bundle == null && other.f12217b != null) {
                return -1;
            }
            if (bundle != null) {
                int size = bundle.size();
                Bundle bundle2 = other.f12217b;
                Intrinsics.d(bundle2);
                int size2 = size - bundle2.size();
                if (size2 > 0) {
                    return 1;
                }
                if (size2 < 0) {
                    return -1;
                }
            }
            boolean z12 = this.f12219d;
            if (z12 && !other.f12219d) {
                return 1;
            }
            if (z12 || !other.f12219d) {
                return this.f12220f - other.f12220f;
            }
            return -1;
        }

        public final NavDestination b() {
            return this.f12216a;
        }

        public final Bundle c() {
            return this.f12217b;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NavDestination(Navigator<? extends NavDestination> navigator) {
        this(q.f12332b.a(navigator.getClass()));
        Intrinsics.g(navigator, "navigator");
    }

    public NavDestination(String navigatorName) {
        Intrinsics.g(navigatorName, "navigatorName");
        this.f12207a = navigatorName;
        this.f12211f = new ArrayList();
        this.f12212g = new w0<>();
        this.f12213h = new LinkedHashMap();
    }

    public static /* synthetic */ int[] j(NavDestination navDestination, NavDestination navDestination2, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildDeepLinkIds");
        }
        if ((i11 & 1) != 0) {
            navDestination2 = null;
        }
        return navDestination.i(navDestination2);
    }

    public final void A(int i11, c action) {
        Intrinsics.g(action, "action");
        if (F()) {
            if (i11 == 0) {
                throw new IllegalArgumentException("Cannot have an action with actionId 0".toString());
            }
            this.f12212g.m(i11, action);
        } else {
            throw new UnsupportedOperationException("Cannot add action " + i11 + " to " + this + " as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
        }
    }

    public final void B(int i11) {
        this.f12214i = i11;
        this.f12209c = null;
    }

    public final void C(CharSequence charSequence) {
        this.f12210d = charSequence;
    }

    public final void D(NavGraph navGraph) {
        this.f12208b = navGraph;
    }

    public final void E(String str) {
        if (str == null) {
            B(0);
        } else {
            if (!(!kotlin.text.l.y(str))) {
                throw new IllegalArgumentException("Cannot have an empty route".toString());
            }
            String strA = f12205k.a(str);
            B(strA.hashCode());
            f(strA);
        }
        List<NavDeepLink> list = this.f12211f;
        List<NavDeepLink> list2 = list;
        for (Object obj : list) {
            if (Intrinsics.b(((NavDeepLink) obj).k(), f12205k.a(this.f12215j))) {
                list2.remove(obj);
                this.f12215j = str;
            }
        }
        obj = null;
        list2.remove(obj);
        this.f12215j = str;
    }

    public boolean F() {
        return true;
    }

    public final void a(String argumentName, d argument) {
        Intrinsics.g(argumentName, "argumentName");
        Intrinsics.g(argument, "argument");
        this.f12213h.put(argumentName, argument);
    }

    public final void e(NavDeepLink navDeepLink) {
        Intrinsics.g(navDeepLink, "navDeepLink");
        Map<String, d> mapR = r();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, d> entry : mapR.entrySet()) {
            d value = entry.getValue();
            if (!value.c() && !value.b()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Set setKeySet = linkedHashMap.keySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            if (!navDeepLink.e().contains((String) obj)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            this.f12211f.add(navDeepLink);
            return;
        }
        throw new IllegalArgumentException(("Deep link " + ((Object) navDeepLink.k()) + " can't be used to open destination " + this + ".\nFollowing required arguments are missing: " + arrayList).toString());
    }

    public boolean equals(Object obj) {
        boolean z11;
        boolean z12;
        if (obj == null || !(obj instanceof NavDestination)) {
            return false;
        }
        NavDestination navDestination = (NavDestination) obj;
        boolean z13 = CollectionsKt___CollectionsKt.k0(this.f12211f, navDestination.f12211f).size() == this.f12211f.size();
        if (this.f12212g.q() != navDestination.f12212g.q()) {
            z11 = false;
            break;
        }
        Iterator it = SequencesKt__SequencesKt.c(y0.a(this.f12212g)).iterator();
        while (true) {
            if (!it.hasNext()) {
                Iterator it2 = SequencesKt__SequencesKt.c(y0.a(navDestination.f12212g)).iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z11 = true;
                        break;
                    }
                    if (!this.f12212g.f((c) it2.next())) {
                    }
                }
            } else {
                if (!navDestination.f12212g.f((c) it.next())) {
                }
            }
            z11 = false;
            break;
        }
        if (r().size() != navDestination.r().size()) {
            z12 = false;
            break;
        }
        Iterator it3 = u.w(r()).iterator();
        while (true) {
            if (!it3.hasNext()) {
                Iterator it4 = u.w(navDestination.r()).iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        z12 = true;
                        break;
                    }
                    Map.Entry entry = (Map.Entry) it4.next();
                    if (!r().containsKey(entry.getKey()) || !Intrinsics.b(r().get(entry.getKey()), entry.getValue())) {
                    }
                }
            } else {
                Map.Entry entry2 = (Map.Entry) it3.next();
                if (!navDestination.r().containsKey(entry2.getKey()) || !Intrinsics.b(navDestination.r().get(entry2.getKey()), entry2.getValue())) {
                }
            }
            z12 = false;
            break;
        }
        return this.f12214i == navDestination.f12214i && Intrinsics.b(this.f12215j, navDestination.f12215j) && z13 && z11 && z12;
    }

    public final void f(String uriPattern) {
        Intrinsics.g(uriPattern, "uriPattern");
        e(new NavDeepLink.a().d(uriPattern).a());
    }

    public final Bundle g(Bundle bundle) {
        Map<String, d> map;
        if (bundle == null && ((map = this.f12213h) == null || map.isEmpty())) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        for (Map.Entry<String, d> entry : this.f12213h.entrySet()) {
            entry.getValue().d(entry.getKey(), bundle2);
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
            for (Map.Entry<String, d> entry2 : this.f12213h.entrySet()) {
                String key = entry2.getKey();
                d value = entry2.getValue();
                if (!value.e(key, bundle2)) {
                    throw new IllegalArgumentException(("Wrong argument type for '" + key + "' in argument bundle. " + value.a().b() + " expected.").toString());
                }
            }
        }
        return bundle2;
    }

    public int hashCode() {
        Set<String> setKeySet;
        int i11 = this.f12214i * 31;
        String str = this.f12215j;
        int iHashCode = i11 + (str == null ? 0 : str.hashCode());
        for (NavDeepLink navDeepLink : this.f12211f) {
            int i12 = iHashCode * 31;
            String strK = navDeepLink.k();
            int iHashCode2 = (i12 + (strK == null ? 0 : strK.hashCode())) * 31;
            String strD = navDeepLink.d();
            int iHashCode3 = (iHashCode2 + (strD == null ? 0 : strD.hashCode())) * 31;
            String strG = navDeepLink.g();
            iHashCode = iHashCode3 + (strG == null ? 0 : strG.hashCode());
        }
        Iterator itA = y0.a(this.f12212g);
        while (itA.hasNext()) {
            c cVar = (c) itA.next();
            int iB = ((iHashCode * 31) + cVar.b()) * 31;
            l lVarC = cVar.c();
            iHashCode = iB + (lVarC == null ? 0 : lVarC.hashCode());
            Bundle bundleA = cVar.a();
            if (bundleA != null && (setKeySet = bundleA.keySet()) != null) {
                for (String str2 : setKeySet) {
                    int i13 = iHashCode * 31;
                    Bundle bundleA2 = cVar.a();
                    Intrinsics.d(bundleA2);
                    Object obj = bundleA2.get(str2);
                    iHashCode = i13 + (obj == null ? 0 : obj.hashCode());
                }
            }
        }
        for (String str3 : r().keySet()) {
            int iHashCode4 = ((iHashCode * 31) + str3.hashCode()) * 31;
            d dVar = r().get(str3);
            iHashCode = iHashCode4 + (dVar == null ? 0 : dVar.hashCode());
        }
        return iHashCode;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0024  */
    /* JADX WARN: Code duplicated, block: B:14:0x002e  */
    @JvmOverloads
    public final int[] i(NavDestination navDestination) {
        ArrayDeque arrayDeque = new ArrayDeque();
        NavDestination navDestination2 = this;
        while (true) {
            Intrinsics.d(navDestination2);
            NavGraph navGraph = navDestination2.f12208b;
            if ((navDestination == null ? null : navDestination.f12208b) != null) {
                NavGraph navGraph2 = navDestination.f12208b;
                Intrinsics.d(navGraph2);
                if (navGraph2.H(navDestination2.f12214i) != navDestination2) {
                    if (navGraph != null || navGraph.N() != navDestination2.f12214i) {
                        arrayDeque.addFirst(navDestination2);
                    }
                    if (!Intrinsics.b(navGraph, navDestination) || navGraph == null) {
                        break;
                    }
                    navDestination2 = navGraph;
                } else {
                    arrayDeque.addFirst(navDestination2);
                    break;
                }
            } else {
                if (navGraph != null) {
                    arrayDeque.addFirst(navDestination2);
                } else {
                    arrayDeque.addFirst(navDestination2);
                }
                if (!Intrinsics.b(navGraph, navDestination)) {
                    break;
                }
                navDestination2 = navGraph;
            }
        }
        List listJ0 = CollectionsKt___CollectionsKt.J0(arrayDeque);
        ArrayList arrayList = new ArrayList(kotlin.collections.h.v(listJ0, 10));
        Iterator it = listJ0.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((NavDestination) it.next()).u()));
        }
        return CollectionsKt___CollectionsKt.I0(arrayList);
    }

    public final Map<String, d> r() {
        return kotlin.collections.s.t(this.f12213h);
    }

    public String s() {
        String str = this.f12209c;
        return str == null ? String.valueOf(this.f12214i) : str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append("(");
        String str = this.f12209c;
        if (str == null) {
            sb2.append("0x");
            sb2.append(Integer.toHexString(this.f12214i));
        } else {
            sb2.append(str);
        }
        sb2.append(")");
        String str2 = this.f12215j;
        if (str2 != null && !kotlin.text.l.y(str2)) {
            sb2.append(" route=");
            sb2.append(this.f12215j);
        }
        if (this.f12210d != null) {
            sb2.append(" label=");
            sb2.append(this.f12210d);
        }
        String string = sb2.toString();
        Intrinsics.f(string, "sb.toString()");
        return string;
    }

    public final int u() {
        return this.f12214i;
    }

    public final String v() {
        return this.f12207a;
    }

    public final NavGraph w() {
        return this.f12208b;
    }

    public final String x() {
        return this.f12215j;
    }

    public a y(g navDeepLinkRequest) {
        Intrinsics.g(navDeepLinkRequest, "navDeepLinkRequest");
        if (this.f12211f.isEmpty()) {
            return null;
        }
        a aVar = null;
        for (NavDeepLink navDeepLink : this.f12211f) {
            Uri uriC = navDeepLinkRequest.c();
            Bundle bundleF = uriC != null ? navDeepLink.f(uriC, r()) : null;
            String strA = navDeepLinkRequest.a();
            boolean z11 = strA != null && Intrinsics.b(strA, navDeepLink.d());
            String strB = navDeepLinkRequest.b();
            int iH = strB != null ? navDeepLink.h(strB) : -1;
            if (bundleF != null || z11 || iH > -1) {
                a aVar2 = new a(this, bundleF, navDeepLink.l(), z11, iH);
                if (aVar == null || aVar2.compareTo(aVar) > 0) {
                    aVar = aVar2;
                }
            }
        }
        return aVar;
    }

    @CallSuper
    public void z(Context context, AttributeSet attrs) {
        Intrinsics.g(context, "context");
        Intrinsics.g(attrs, "attrs");
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attrs, androidx.navigation.common.R$styleable.Navigator);
        Intrinsics.f(typedArrayObtainAttributes, "context.resources.obtain…s, R.styleable.Navigator)");
        E(typedArrayObtainAttributes.getString(androidx.navigation.common.R$styleable.Navigator_route));
        if (typedArrayObtainAttributes.hasValue(androidx.navigation.common.R$styleable.Navigator_android_id)) {
            B(typedArrayObtainAttributes.getResourceId(androidx.navigation.common.R$styleable.Navigator_android_id, 0));
            this.f12209c = f12205k.b(context, u());
        }
        C(typedArrayObtainAttributes.getText(androidx.navigation.common.R$styleable.Navigator_android_label));
        Unit unit = Unit.f68710a;
        typedArrayObtainAttributes.recycle();
    }
}
