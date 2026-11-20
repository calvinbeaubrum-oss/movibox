package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.w;
import androidx.compose.foundation.f0;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f2370a = new m();

    public final g a(androidx.compose.runtime.i iVar, int i11) {
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(1107739818, i11, -1, "androidx.compose.foundation.gestures.ScrollableDefaults.flingBehavior (Scrollable.kt:570)");
        }
        w wVarB = androidx.compose.animation.l.b(iVar, 0);
        boolean zQ = iVar.Q(wVarB);
        Object objY = iVar.y();
        if (zQ || objY == androidx.compose.runtime.i.f3413a.a()) {
            objY = new DefaultFlingBehavior(wVarB, null, 2, null);
            iVar.p(objY);
        }
        DefaultFlingBehavior defaultFlingBehavior = (DefaultFlingBehavior) objY;
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
        return defaultFlingBehavior;
    }

    public final f0 b(androidx.compose.runtime.i iVar, int i11) {
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(1809802212, i11, -1, "androidx.compose.foundation.gestures.ScrollableDefaults.overscrollEffect (Scrollable.kt:583)");
        }
        f0 f0VarA = androidx.compose.foundation.a.a(iVar, 0);
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
        return f0VarA;
    }

    public final boolean c(LayoutDirection layoutDirection, Orientation orientation, boolean z11) {
        return (layoutDirection != LayoutDirection.Rtl || orientation == Orientation.Vertical) ? !z11 : z11;
    }
}
