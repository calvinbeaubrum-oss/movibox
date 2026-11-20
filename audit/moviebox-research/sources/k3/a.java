package k3;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.ViewKt;
import androidx.customview.poolingcontainer.R$id;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
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
@JvmName
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f68230a = R$id.pooling_container_listener_holder_tag;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f68231b = R$id.is_pooling_container_tag;

    @SuppressLint({"ExecutorRegistration"})
    public static final void a(View view, b listener) {
        Intrinsics.g(view, "<this>");
        Intrinsics.g(listener, "listener");
        d(view).a(listener);
    }

    public static final void b(View view) {
        Intrinsics.g(view, "<this>");
        Iterator<View> it = ViewKt.getAllViews(view).iterator();
        while (it.hasNext()) {
            d(it.next()).b();
        }
    }

    public static final void c(ViewGroup viewGroup) {
        Intrinsics.g(viewGroup, "<this>");
        Iterator<View> it = ViewGroupKt.getChildren(viewGroup).iterator();
        while (it.hasNext()) {
            d(it.next()).b();
        }
    }

    public static final c d(View view) {
        int i11 = f68230a;
        c cVar = (c) view.getTag(i11);
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        view.setTag(i11, cVar2);
        return cVar2;
    }

    public static final boolean e(View view) {
        Intrinsics.g(view, "<this>");
        Object tag = view.getTag(f68231b);
        Boolean bool = tag instanceof Boolean ? (Boolean) tag : null;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final boolean f(View view) {
        Intrinsics.g(view, "<this>");
        for (Object obj : ViewKt.getAncestors(view)) {
            if ((obj instanceof View) && e((View) obj)) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"ExecutorRegistration"})
    public static final void g(View view, b listener) {
        Intrinsics.g(view, "<this>");
        Intrinsics.g(listener, "listener");
        d(view).c(listener);
    }

    public static final void h(View view, boolean z11) {
        Intrinsics.g(view, "<this>");
        view.setTag(f68231b, Boolean.valueOf(z11));
    }
}
