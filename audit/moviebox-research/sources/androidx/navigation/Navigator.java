package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.navigation.NavDestination;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
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
public abstract class Navigator<D extends NavDestination> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r f12230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12231b;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public interface a {
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Metadata
    @kotlin.annotation.Target
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface b {
        String value();
    }

    public abstract D a();

    public final r b() {
        r rVar = this.f12230a;
        if (rVar != null) {
            return rVar;
        }
        throw new IllegalStateException("You cannot access the Navigator's state until the Navigator is attached".toString());
    }

    public final boolean c() {
        return this.f12231b;
    }

    public NavDestination d(D destination, Bundle bundle, l lVar, a aVar) {
        Intrinsics.g(destination, "destination");
        return destination;
    }

    public void e(List<NavBackStackEntry> entries, final l lVar, final a aVar) {
        Intrinsics.g(entries, "entries");
        Iterator it = SequencesKt___SequencesKt.l(SequencesKt___SequencesKt.r(CollectionsKt___CollectionsKt.V(entries), new Function1<NavBackStackEntry, NavBackStackEntry>(this) { // from class: androidx.navigation.Navigator$navigate$1
            final /* synthetic */ Navigator<D> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final NavBackStackEntry invoke(NavBackStackEntry backStackEntry) {
                NavDestination navDestinationD;
                Intrinsics.g(backStackEntry, "backStackEntry");
                NavDestination navDestinationF = backStackEntry.f();
                if (!(navDestinationF instanceof NavDestination)) {
                    navDestinationF = null;
                }
                if (navDestinationF != null && (navDestinationD = this.this$0.d(navDestinationF, backStackEntry.d(), lVar, aVar)) != null) {
                    return Intrinsics.b(navDestinationD, navDestinationF) ? backStackEntry : this.this$0.b().a(navDestinationD, navDestinationD.g(backStackEntry.d()));
                }
                return null;
            }
        })).iterator();
        while (it.hasNext()) {
            b().h((NavBackStackEntry) it.next());
        }
    }

    @CallSuper
    public void f(r state) {
        Intrinsics.g(state, "state");
        this.f12230a = state;
        this.f12231b = true;
    }

    public void g(NavBackStackEntry backStackEntry) {
        Intrinsics.g(backStackEntry, "backStackEntry");
        NavDestination navDestinationF = backStackEntry.f();
        if (!(navDestinationF instanceof NavDestination)) {
            navDestinationF = null;
        }
        if (navDestinationF == null) {
            return;
        }
        d(navDestinationF, null, n.a(new Function1<m, Unit>() { // from class: androidx.navigation.Navigator$onLaunchSingleTop$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(m mVar) {
                invoke2(mVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(m navOptions) {
                Intrinsics.g(navOptions, "$this$navOptions");
                navOptions.h(true);
            }
        }), null);
        b().f(backStackEntry);
    }

    public void h(Bundle savedState) {
        Intrinsics.g(savedState, "savedState");
    }

    public Bundle i() {
        return null;
    }

    public void j(NavBackStackEntry popUpTo, boolean z11) {
        Intrinsics.g(popUpTo, "popUpTo");
        List<NavBackStackEntry> value = b().b().getValue();
        if (!value.contains(popUpTo)) {
            throw new IllegalStateException(("popBackStack was called with " + popUpTo + " which does not exist in back stack " + value).toString());
        }
        ListIterator<NavBackStackEntry> listIterator = value.listIterator(value.size());
        NavBackStackEntry navBackStackEntryPrevious = null;
        while (k()) {
            navBackStackEntryPrevious = listIterator.previous();
            if (Intrinsics.b(navBackStackEntryPrevious, popUpTo)) {
                break;
            }
        }
        if (navBackStackEntryPrevious != null) {
            b().g(navBackStackEntryPrevious, z11);
        }
    }

    public boolean k() {
        return true;
    }
}
