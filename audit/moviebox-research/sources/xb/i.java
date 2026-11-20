package xb;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class i {
    public static final boolean a(View view) {
        Intrinsics.g(view, "<this>");
        return view.getVisibility() == 0;
    }

    public static final void b(View view) {
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup == null) {
            return;
        }
        viewGroup.removeView(view);
    }

    public static final void c(View view) {
        Intrinsics.g(view, "<this>");
        view.setVisibility(8);
    }

    public static final void d(View view) {
        Intrinsics.g(view, "<this>");
        view.setVisibility(4);
    }

    public static final void e(View view) {
        Intrinsics.g(view, "<this>");
        view.setVisibility(0);
    }

    public static final void f(View view, boolean z11) {
        Intrinsics.g(view, "<this>");
        if (z11) {
            e(view);
        } else {
            c(view);
        }
    }

    public static final void g(View view, boolean z11) {
        Intrinsics.g(view, "<this>");
        if (z11) {
            e(view);
        } else {
            d(view);
        }
    }
}
