package androidx.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.collection.w0;
import androidx.collection.y0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

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
public class NavGraph extends NavDestination implements Iterable<NavDestination>, KMappedMarker {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Companion f12221q = new Companion(null);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final w0<NavDestination> f12222m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f12223n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f12224o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f12225p;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final NavDestination a(NavGraph navGraph) {
            Intrinsics.g(navGraph, "<this>");
            return (NavDestination) SequencesKt___SequencesKt.q(SequencesKt__SequencesKt.f(navGraph.H(navGraph.N()), new Function1<NavDestination, NavDestination>() { // from class: androidx.navigation.NavGraph$Companion$findStartDestination$1
                @Override // kotlin.jvm.functions.Function1
                public final NavDestination invoke(NavDestination it) {
                    Intrinsics.g(it, "it");
                    if (!(it instanceof NavGraph)) {
                        return null;
                    }
                    NavGraph navGraph2 = (NavGraph) it;
                    return navGraph2.H(navGraph2.N());
                }
            }));
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static final class a implements Iterator<NavDestination>, KMutableIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12226a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f12227b;

        public a() {
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public NavDestination next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f12227b = true;
            w0<NavDestination> w0VarL = NavGraph.this.L();
            int i11 = this.f12226a + 1;
            this.f12226a = i11;
            NavDestination navDestinationR = w0VarL.r(i11);
            Intrinsics.f(navDestinationR, "nodes.valueAt(++index)");
            return navDestinationR;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12226a + 1 < NavGraph.this.L().q();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f12227b) {
                throw new IllegalStateException("You must call next() before you can remove an element".toString());
            }
            w0<NavDestination> w0VarL = NavGraph.this.L();
            w0VarL.r(this.f12226a).D(null);
            w0VarL.o(this.f12226a);
            this.f12226a--;
            this.f12227b = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavGraph(Navigator<? extends NavGraph> navGraphNavigator) {
        super(navGraphNavigator);
        Intrinsics.g(navGraphNavigator, "navGraphNavigator");
        this.f12222m = new w0<>();
    }

    public final void G(NavDestination node) {
        Intrinsics.g(node, "node");
        int iU = node.u();
        String strX = node.x();
        if (iU == 0 && strX == null) {
            throw new IllegalArgumentException("Destinations must have an id or route. Call setId(), setRoute(), or include an android:id or app:route in your navigation XML.".toString());
        }
        if (x() != null && !(!Intrinsics.b(strX, x()))) {
            throw new IllegalArgumentException(("Destination " + node + " cannot have the same route as graph " + this).toString());
        }
        if (iU == u()) {
            throw new IllegalArgumentException(("Destination " + node + " cannot have the same id as graph " + this).toString());
        }
        NavDestination navDestinationG = this.f12222m.g(iU);
        if (navDestinationG == node) {
            return;
        }
        if (node.w() != null) {
            throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.".toString());
        }
        if (navDestinationG != null) {
            navDestinationG.D(null);
        }
        node.D(this);
        this.f12222m.m(node.u(), node);
    }

    public final NavDestination H(int i11) {
        return I(i11, true);
    }

    public final NavDestination I(int i11, boolean z11) {
        NavDestination navDestinationG = this.f12222m.g(i11);
        if (navDestinationG != null) {
            return navDestinationG;
        }
        if (!z11 || w() == null) {
            return null;
        }
        NavGraph navGraphW = w();
        Intrinsics.d(navGraphW);
        return navGraphW.H(i11);
    }

    public final NavDestination J(String str) {
        if (str == null || kotlin.text.l.y(str)) {
            return null;
        }
        return K(str, true);
    }

    public final NavDestination K(String route, boolean z11) {
        Intrinsics.g(route, "route");
        NavDestination navDestinationG = this.f12222m.g(NavDestination.f12205k.a(route).hashCode());
        if (navDestinationG != null) {
            return navDestinationG;
        }
        if (!z11 || w() == null) {
            return null;
        }
        NavGraph navGraphW = w();
        Intrinsics.d(navGraphW);
        return navGraphW.J(route);
    }

    public final w0<NavDestination> L() {
        return this.f12222m;
    }

    public final String M() {
        if (this.f12224o == null) {
            String strValueOf = this.f12225p;
            if (strValueOf == null) {
                strValueOf = String.valueOf(this.f12223n);
            }
            this.f12224o = strValueOf;
        }
        String str = this.f12224o;
        Intrinsics.d(str);
        return str;
    }

    public final int N() {
        return this.f12223n;
    }

    public final String O() {
        return this.f12225p;
    }

    public final void P(int i11) {
        if (i11 != u()) {
            if (this.f12225p != null) {
                Q(null);
            }
            this.f12223n = i11;
            this.f12224o = null;
            return;
        }
        throw new IllegalArgumentException(("Start destination " + i11 + " cannot use the same id as the graph " + this).toString());
    }

    public final void Q(String str) {
        int iHashCode;
        if (str == null) {
            iHashCode = 0;
        } else {
            if (!(!Intrinsics.b(str, x()))) {
                throw new IllegalArgumentException(("Start destination " + ((Object) str) + " cannot use the same route as the graph " + this).toString());
            }
            if (!(!kotlin.text.l.y(str))) {
                throw new IllegalArgumentException("Cannot have an empty start destination route".toString());
            }
            iHashCode = NavDestination.f12205k.a(str).hashCode();
        }
        this.f12223n = iHashCode;
        this.f12225p = str;
    }

    @Override // androidx.navigation.NavDestination
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof NavGraph)) {
            return false;
        }
        List listW = SequencesKt___SequencesKt.w(SequencesKt__SequencesKt.c(y0.a(this.f12222m)));
        NavGraph navGraph = (NavGraph) obj;
        Iterator itA = y0.a(navGraph.f12222m);
        while (itA.hasNext()) {
            listW.remove((NavDestination) itA.next());
        }
        return super.equals(obj) && this.f12222m.q() == navGraph.f12222m.q() && N() == navGraph.N() && listW.isEmpty();
    }

    @Override // androidx.navigation.NavDestination
    public int hashCode() {
        int iN = N();
        w0<NavDestination> w0Var = this.f12222m;
        int iQ = w0Var.q();
        for (int i11 = 0; i11 < iQ; i11++) {
            iN = (((iN * 31) + w0Var.l(i11)) * 31) + w0Var.r(i11).hashCode();
        }
        return iN;
    }

    @Override // java.lang.Iterable
    public final Iterator<NavDestination> iterator() {
        return new a();
    }

    @Override // androidx.navigation.NavDestination
    public String s() {
        return u() != 0 ? super.s() : "the root navigation";
    }

    @Override // androidx.navigation.NavDestination
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        NavDestination navDestinationJ = J(this.f12225p);
        if (navDestinationJ == null) {
            navDestinationJ = H(N());
        }
        sb2.append(" startDestination=");
        if (navDestinationJ == null) {
            String str = this.f12225p;
            if (str != null) {
                sb2.append(str);
            } else {
                String str2 = this.f12224o;
                if (str2 != null) {
                    sb2.append(str2);
                } else {
                    sb2.append(Intrinsics.p("0x", Integer.toHexString(this.f12223n)));
                }
            }
        } else {
            sb2.append("{");
            sb2.append(navDestinationJ.toString());
            sb2.append("}");
        }
        String string = sb2.toString();
        Intrinsics.f(string, "sb.toString()");
        return string;
    }

    @Override // androidx.navigation.NavDestination
    public NavDestination.a y(g navDeepLinkRequest) {
        Intrinsics.g(navDeepLinkRequest, "navDeepLinkRequest");
        NavDestination.a aVarY = super.y(navDeepLinkRequest);
        ArrayList arrayList = new ArrayList();
        Iterator<NavDestination> it = iterator();
        while (it.hasNext()) {
            NavDestination.a aVarY2 = it.next().y(navDeepLinkRequest);
            if (aVarY2 != null) {
                arrayList.add(aVarY2);
            }
        }
        return (NavDestination.a) CollectionsKt___CollectionsKt.s0(kotlin.collections.g.p(aVarY, (NavDestination.a) CollectionsKt___CollectionsKt.s0(arrayList)));
    }

    @Override // androidx.navigation.NavDestination
    public void z(Context context, AttributeSet attrs) {
        Intrinsics.g(context, "context");
        Intrinsics.g(attrs, "attrs");
        super.z(context, attrs);
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attrs, androidx.navigation.common.R$styleable.NavGraphNavigator);
        Intrinsics.f(typedArrayObtainAttributes, "context.resources.obtain…vGraphNavigator\n        )");
        P(typedArrayObtainAttributes.getResourceId(androidx.navigation.common.R$styleable.NavGraphNavigator_startDestination, 0));
        this.f12224o = NavDestination.f12205k.b(context, this.f12223n);
        Unit unit = Unit.f68710a;
        typedArrayObtainAttributes.recycle();
    }
}
