package androidx.compose.foundation;

import androidx.compose.ui.node.l0;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.d1;
import androidx.compose.ui.platform.e1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class FocusableKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d1 f2235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FocusableKt$FocusableInNonTouchModeElement$1 f2236b;

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.foundation.FocusableKt$FocusableInNonTouchModeElement$1] */
    static {
        f2235a = new d1(InspectableValueKt.b() ? new Function1<e1, Unit>() { // from class: androidx.compose.foundation.FocusableKt$special$$inlined$debugInspectorInfo$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(e1 e1Var) {
                invoke2(e1Var);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(e1 e1Var) {
                e1Var.b("focusGroup");
            }
        } : InspectableValueKt.a());
        f2236b = new l0<q>() { // from class: androidx.compose.foundation.FocusableKt$FocusableInNonTouchModeElement$1
            public boolean equals(Object obj) {
                return this == obj;
            }

            public int hashCode() {
                return r.a(this);
            }

            @Override // androidx.compose.ui.node.l0
            /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
            public q a() {
                return new q();
            }

            @Override // androidx.compose.ui.node.l0
            /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
            public void o(q qVar) {
            }
        };
    }

    public static final androidx.compose.ui.f a(androidx.compose.ui.f fVar, boolean z11, o1.i iVar) {
        return fVar.f(z11 ? new FocusableElement(iVar) : androidx.compose.ui.f.f3863a);
    }
}
