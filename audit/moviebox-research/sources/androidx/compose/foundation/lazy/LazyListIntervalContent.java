package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.c0;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

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
public final class LazyListIntervalContent extends androidx.compose.foundation.lazy.layout.j<i> implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0<i> f2531a = new c0<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<Integer> f2532b;

    public LazyListIntervalContent(Function1<? super u, Unit> function1) {
        function1.invoke(this);
    }

    @Override // androidx.compose.foundation.lazy.u
    public void a(final Object obj, final Object obj2, final Function3<? super b, ? super androidx.compose.runtime.i, ? super Integer, Unit> function3) {
        c().b(1, new i(obj != null ? new Function1<Integer, Object>() { // from class: androidx.compose.foundation.lazy.LazyListIntervalContent$item$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Object invoke(int i11) {
                return obj;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }
        } : null, new Function1<Integer, Object>() { // from class: androidx.compose.foundation.lazy.LazyListIntervalContent$item$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Object invoke(int i11) {
                return obj2;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }
        }, androidx.compose.runtime.internal.b.c(-1010194746, true, new Function4<b, Integer, androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListIntervalContent$item$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(b bVar, Integer num, androidx.compose.runtime.i iVar, Integer num2) {
                invoke(bVar, num.intValue(), iVar, num2.intValue());
                return Unit.f68710a;
            }

            public final void invoke(b bVar, int i11, androidx.compose.runtime.i iVar, int i12) {
                if ((i12 & 6) == 0) {
                    i12 |= iVar.Q(bVar) ? 4 : 2;
                }
                if ((i12 & 131) == 130 && iVar.h()) {
                    iVar.H();
                    return;
                }
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.S(-1010194746, i12, -1, "androidx.compose.foundation.lazy.LazyListIntervalContent.item.<anonymous> (LazyListIntervalContent.kt:58)");
                }
                function3.invoke(bVar, iVar, Integer.valueOf(i12 & 14));
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.R();
                }
            }
        })));
    }

    public final List<Integer> f() {
        List<Integer> list = this.f2532b;
        return list == null ? kotlin.collections.g.l() : list;
    }

    @Override // androidx.compose.foundation.lazy.layout.j
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public c0<i> c() {
        return this.f2531a;
    }
}
