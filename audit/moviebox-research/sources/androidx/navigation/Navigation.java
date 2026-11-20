package androidx.navigation;

import android.view.View;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class Navigation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Navigation f12229a = new Navigation();

    @JvmStatic
    public static final NavController b(View view) {
        Intrinsics.g(view, "view");
        NavController navControllerC = f12229a.c(view);
        if (navControllerC != null) {
            return navControllerC;
        }
        throw new IllegalStateException("View " + view + " does not have a NavController set");
    }

    @JvmStatic
    public static final void e(View view, NavController navController) {
        Intrinsics.g(view, "view");
        view.setTag(R$id.nav_controller_view_tag, navController);
    }

    public final NavController c(View view) {
        return (NavController) SequencesKt___SequencesKt.m(SequencesKt___SequencesKt.s(SequencesKt__SequencesKt.f(view, new Function1<View, View>() { // from class: androidx.navigation.Navigation$findViewNavController$1
            @Override // kotlin.jvm.functions.Function1
            public final View invoke(View it) {
                Intrinsics.g(it, "it");
                Object parent = it.getParent();
                if (parent instanceof View) {
                    return (View) parent;
                }
                return null;
            }
        }), new Function1<View, NavController>() { // from class: androidx.navigation.Navigation$findViewNavController$2
            @Override // kotlin.jvm.functions.Function1
            public final NavController invoke(View it) {
                Intrinsics.g(it, "it");
                return Navigation.f12229a.d(it);
            }
        }));
    }

    public final NavController d(View view) {
        Object tag = view.getTag(R$id.nav_controller_view_tag);
        if (tag instanceof WeakReference) {
            return (NavController) ((WeakReference) tag).get();
        }
        if (tag instanceof NavController) {
            return (NavController) tag;
        }
        return null;
    }
}
