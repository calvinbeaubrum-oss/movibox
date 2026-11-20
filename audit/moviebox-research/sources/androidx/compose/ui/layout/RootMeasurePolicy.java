package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import java.util.ArrayList;
import java.util.List;
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
public final class RootMeasurePolicy extends LayoutNode.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final RootMeasurePolicy f4842b = new RootMeasurePolicy();

    public RootMeasurePolicy() {
        super("Undefined intrinsics block and it is required");
    }

    @Override // androidx.compose.ui.layout.u
    public w c(y yVar, List<? extends t> list, long j11) {
        if (list.isEmpty()) {
            return x.b(yVar, q2.b.n(j11), q2.b.m(j11), null, new Function1<k0.a, Unit>() { // from class: androidx.compose.ui.layout.RootMeasurePolicy$measure$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(k0.a aVar) {
                    invoke2(aVar);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(k0.a aVar) {
                }
            }, 4, null);
        }
        if (list.size() == 1) {
            final k0 k0VarL = list.get(0).L(j11);
            return x.b(yVar, q2.c.i(j11, k0VarL.s0()), q2.c.h(j11, k0VarL.g0()), null, new Function1<k0.a, Unit>() { // from class: androidx.compose.ui.layout.RootMeasurePolicy$measure$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(k0.a aVar) {
                    invoke2(aVar);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(k0.a aVar) {
                    k0.a.n(aVar, k0VarL, 0, 0, 0.0f, null, 12, null);
                }
            }, 4, null);
        }
        final ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            arrayList.add(list.get(i11).L(j11));
        }
        int size2 = arrayList.size();
        int iMax = 0;
        int iMax2 = 0;
        for (int i12 = 0; i12 < size2; i12++) {
            k0 k0Var = (k0) arrayList.get(i12);
            iMax = Math.max(k0Var.s0(), iMax);
            iMax2 = Math.max(k0Var.g0(), iMax2);
        }
        return x.b(yVar, q2.c.i(j11, iMax), q2.c.h(j11, iMax2), null, new Function1<k0.a, Unit>() { // from class: androidx.compose.ui.layout.RootMeasurePolicy$measure$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(k0.a aVar) {
                invoke2(aVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(k0.a aVar) {
                List<k0> list2 = arrayList;
                int size3 = list2.size();
                for (int i13 = 0; i13 < size3; i13++) {
                    k0.a.n(aVar, list2.get(i13), 0, 0, 0.0f, null, 12, null);
                }
            }
        }, 4, null);
    }
}
