package androidx.compose.ui.platform;

import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.R$id;
import androidx.compose.ui.node.LayoutNode;
import java.util.Collections;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
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
public final class e3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ViewGroup.LayoutParams f5467a = new ViewGroup.LayoutParams(-2, -2);

    public static final androidx.compose.runtime.d2 a(LayoutNode layoutNode, androidx.compose.runtime.m mVar) {
        return androidx.compose.runtime.p.b(new androidx.compose.ui.node.o1(layoutNode), mVar);
    }

    public static final androidx.compose.runtime.l b(AndroidComposeView androidComposeView, androidx.compose.runtime.m mVar, Function2<? super androidx.compose.runtime.i, ? super Integer, Unit> function2) {
        if (InspectableValueKt.b() && androidComposeView.getTag(R$id.inspection_slot_table_set) == null) {
            androidComposeView.setTag(R$id.inspection_slot_table_set, Collections.newSetFromMap(new WeakHashMap()));
        }
        androidx.compose.runtime.l lVarA = androidx.compose.runtime.p.a(new androidx.compose.ui.node.o1(androidComposeView.getRoot()), mVar);
        Object tag = androidComposeView.getView().getTag(R$id.wrapped_composition_tag);
        WrappedComposition wrappedComposition = tag instanceof WrappedComposition ? (WrappedComposition) tag : null;
        if (wrappedComposition == null) {
            wrappedComposition = new WrappedComposition(androidComposeView, lVarA);
            androidComposeView.getView().setTag(R$id.wrapped_composition_tag, wrappedComposition);
        }
        wrappedComposition.d(function2);
        if (!Intrinsics.b(androidComposeView.getCoroutineContext(), mVar.i())) {
            androidComposeView.setCoroutineContext(mVar.i());
        }
        return wrappedComposition;
    }

    public static final androidx.compose.runtime.l c(AbstractComposeView abstractComposeView, androidx.compose.runtime.m mVar, Function2<? super androidx.compose.runtime.i, ? super Integer, Unit> function2) {
        GlobalSnapshotManager.f5332a.b();
        AndroidComposeView androidComposeView = null;
        if (abstractComposeView.getChildCount() > 0) {
            View childAt = abstractComposeView.getChildAt(0);
            if (childAt instanceof AndroidComposeView) {
                androidComposeView = (AndroidComposeView) childAt;
            }
        } else {
            abstractComposeView.removeAllViews();
        }
        if (androidComposeView == null) {
            androidComposeView = new AndroidComposeView(abstractComposeView.getContext(), mVar.i());
            abstractComposeView.addView(androidComposeView.getView(), f5467a);
        }
        return b(androidComposeView, mVar, function2);
    }
}
