package androidx.navigation;

import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@Navigator.b(NotificationCompat.CATEGORY_NAVIGATION)
public class h extends Navigator<NavGraph> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q f12281c;

    public h(q navigatorProvider) {
        Intrinsics.g(navigatorProvider, "navigatorProvider");
        this.f12281c = navigatorProvider;
    }

    @Override // androidx.navigation.Navigator
    public void e(List<NavBackStackEntry> entries, l lVar, Navigator.a aVar) {
        Intrinsics.g(entries, "entries");
        Iterator<NavBackStackEntry> it = entries.iterator();
        while (it.hasNext()) {
            m(it.next(), lVar, aVar);
        }
    }

    @Override // androidx.navigation.Navigator
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public NavGraph a() {
        return new NavGraph(this);
    }

    public final void m(NavBackStackEntry navBackStackEntry, l lVar, Navigator.a aVar) {
        NavGraph navGraph = (NavGraph) navBackStackEntry.f();
        Bundle bundleD = navBackStackEntry.d();
        int iN = navGraph.N();
        String strO = navGraph.O();
        if (iN == 0 && strO == null) {
            throw new IllegalStateException(Intrinsics.p("no start destination defined via app:startDestination for ", navGraph.s()).toString());
        }
        NavDestination navDestinationK = strO != null ? navGraph.K(strO, false) : navGraph.I(iN, false);
        if (navDestinationK != null) {
            this.f12281c.d(navDestinationK.v()).e(kotlin.collections.f.e(b().a(navDestinationK, navDestinationK.g(bundleD))), lVar, aVar);
            return;
        }
        throw new IllegalArgumentException("navigation destination " + navGraph.M() + " is not a direct child of this NavGraph");
    }
}
