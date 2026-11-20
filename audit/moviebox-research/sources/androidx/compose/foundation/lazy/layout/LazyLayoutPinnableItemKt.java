package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.g2;
import androidx.compose.runtime.t1;
import androidx.compose.runtime.v1;
import androidx.compose.ui.layout.PinnableContainerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
public final class LazyLayoutPinnableItemKt {
    public static final void a(final Object obj, final int i11, final w wVar, final Function2<? super androidx.compose.runtime.i, ? super Integer, Unit> function2, androidx.compose.runtime.i iVar, final int i12) {
        int i13;
        androidx.compose.runtime.i iVarG = iVar.g(-2079116560);
        if ((i12 & 6) == 0) {
            i13 = (iVarG.A(obj) ? 4 : 2) | i12;
        } else {
            i13 = i12;
        }
        if ((i12 & 48) == 0) {
            i13 |= iVarG.c(i11) ? 32 : 16;
        }
        if ((i12 & 384) == 0) {
            i13 |= iVarG.A(wVar) ? 256 : 128;
        }
        if ((i12 & 3072) == 0) {
            i13 |= iVarG.A(function2) ? 2048 : 1024;
        }
        if ((i13 & 1171) == 1170 && iVarG.h()) {
            iVarG.H();
        } else {
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.S(-2079116560, i13, -1, "androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItem (LazyLayoutPinnableItem.kt:52)");
            }
            boolean zQ = iVarG.Q(obj) | iVarG.Q(wVar);
            Object objY = iVarG.y();
            if (zQ || objY == androidx.compose.runtime.i.f3413a.a()) {
                objY = new v(obj, wVar);
                iVarG.p(objY);
            }
            final v vVar = (v) objY;
            vVar.g(i11);
            vVar.i((androidx.compose.ui.layout.j0) iVarG.l(PinnableContainerKt.a()));
            boolean zQ2 = iVarG.Q(vVar);
            Object objY2 = iVarG.y();
            if (zQ2 || objY2 == androidx.compose.runtime.i.f3413a.a()) {
                objY2 = new Function1<androidx.compose.runtime.d0, androidx.compose.runtime.c0>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItemKt$LazyLayoutPinnableItem$1$1

                    /* JADX INFO: compiled from: source.java */
                    @Metadata
                    @SourceDebugExtension
                    public static final class a implements androidx.compose.runtime.c0 {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        public final /* synthetic */ v f2651a;

                        public a(v vVar) {
                            this.f2651a = vVar;
                        }

                        @Override // androidx.compose.runtime.c0
                        public void dispose() {
                            this.f2651a.f();
                        }
                    }

                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final androidx.compose.runtime.c0 invoke(androidx.compose.runtime.d0 d0Var) {
                        return new a(vVar);
                    }
                };
                iVarG.p(objY2);
            }
            androidx.compose.runtime.g0.a(vVar, (Function1) objY2, iVarG, 0);
            CompositionLocalKt.a(PinnableContainerKt.a().d(vVar), function2, iVarG, ((i13 >> 6) & 112) | t1.f3721i);
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.R();
            }
        }
        g2 g2VarJ = iVarG.j();
        if (g2VarJ != null) {
            g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItemKt$LazyLayoutPinnableItem$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar2, Integer num) {
                    invoke(iVar2, num.intValue());
                    return Unit.f68710a;
                }

                public final void invoke(androidx.compose.runtime.i iVar2, int i14) {
                    LazyLayoutPinnableItemKt.a(obj, i11, wVar, function2, iVar2, v1.a(i12 | 1));
                }
            });
        }
    }
}
