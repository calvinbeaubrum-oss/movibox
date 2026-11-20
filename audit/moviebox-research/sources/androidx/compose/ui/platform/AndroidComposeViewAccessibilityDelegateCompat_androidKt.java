package androidx.compose.ui.platform;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
public final class AndroidComposeViewAccessibilityDelegateCompat_androidKt {
    public static final boolean h(androidx.compose.ui.semantics.a<?> aVar, Object obj) {
        if (aVar == obj) {
            return true;
        }
        if (!(obj instanceof androidx.compose.ui.semantics.a)) {
            return false;
        }
        androidx.compose.ui.semantics.a aVar2 = (androidx.compose.ui.semantics.a) obj;
        if (!Intrinsics.b(aVar.b(), aVar2.b())) {
            return false;
        }
        if (aVar.a() != null || aVar2.a() == null) {
            return aVar.a() == null || aVar2.a() != null;
        }
        return false;
    }

    public static final boolean i(SemanticsNode semanticsNode) {
        return !semanticsNode.n().f(SemanticsProperties.f5594a.f());
    }

    public static final boolean j(SemanticsNode semanticsNode) {
        androidx.compose.ui.semantics.l lVarF;
        androidx.compose.ui.semantics.l lVarW = semanticsNode.w();
        SemanticsProperties semanticsProperties = SemanticsProperties.f5594a;
        if (lVarW.f(semanticsProperties.g()) && !Intrinsics.b(SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties.i()), Boolean.TRUE)) {
            return true;
        }
        LayoutNode layoutNodeK = k(semanticsNode.q(), new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt$excludeLineAndPageGranularities$ancestor$1
            /* JADX WARN: Code duplicated, block: B:9:0x001a  */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(LayoutNode layoutNode) {
                boolean z11;
                androidx.compose.ui.semantics.l lVarF2 = layoutNode.F();
                if (lVarF2 != null) {
                    z11 = lVarF2.v() && lVarF2.f(SemanticsProperties.f5594a.g());
                }
                return Boolean.valueOf(z11);
            }
        });
        return layoutNodeK != null && ((lVarF = layoutNodeK.F()) == null || !Intrinsics.b(SemanticsConfigurationKt.a(lVarF, semanticsProperties.i()), Boolean.TRUE));
    }

    public static final LayoutNode k(LayoutNode layoutNode, Function1<? super LayoutNode, Boolean> function1) {
        for (LayoutNode layoutNodeH0 = layoutNode.h0(); layoutNodeH0 != null; layoutNodeH0 = layoutNodeH0.h0()) {
            if (function1.invoke(layoutNodeH0).booleanValue()) {
                return layoutNodeH0;
            }
        }
        return null;
    }

    public static final boolean l(SemanticsNode semanticsNode) {
        return semanticsNode.p().getLayoutDirection() == LayoutDirection.Rtl;
    }

    public static final boolean m(SemanticsNode semanticsNode) {
        return (semanticsNode.z() || semanticsNode.w().f(SemanticsProperties.f5594a.n())) ? false : true;
    }

    public static final boolean n(SemanticsNode semanticsNode, androidx.compose.ui.semantics.l lVar) {
        Iterator<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>> it = lVar.iterator();
        while (it.hasNext()) {
            if (!semanticsNode.n().f(it.next().getKey())) {
                return true;
            }
        }
        return false;
    }
}
