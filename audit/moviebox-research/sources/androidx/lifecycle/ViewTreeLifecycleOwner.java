package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.runtime.R$id;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@JvmName
public final class ViewTreeLifecycleOwner {
    @JvmName
    public static final u a(View view) {
        Intrinsics.g(view, "<this>");
        return (u) SequencesKt___SequencesKt.m(SequencesKt___SequencesKt.s(SequencesKt__SequencesKt.f(view, new Function1<View, View>() { // from class: androidx.lifecycle.ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1
            @Override // kotlin.jvm.functions.Function1
            public final View invoke(View currentView) {
                Intrinsics.g(currentView, "currentView");
                Object parent = currentView.getParent();
                if (parent instanceof View) {
                    return (View) parent;
                }
                return null;
            }
        }), new Function1<View, u>() { // from class: androidx.lifecycle.ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2
            @Override // kotlin.jvm.functions.Function1
            public final u invoke(View viewParent) {
                Intrinsics.g(viewParent, "viewParent");
                Object tag = viewParent.getTag(R$id.view_tree_lifecycle_owner);
                if (tag instanceof u) {
                    return (u) tag;
                }
                return null;
            }
        }));
    }

    @JvmName
    public static final void b(View view, u uVar) {
        Intrinsics.g(view, "<this>");
        view.setTag(R$id.view_tree_lifecycle_owner, uVar);
    }
}
