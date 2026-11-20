package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItemKt;
import androidx.compose.runtime.g2;
import androidx.compose.runtime.v1;
import java.util.List;
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
public final class LazyListItemProviderImpl implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LazyListState f2533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LazyListIntervalContent f2534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f2535c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.compose.foundation.lazy.layout.p f2536d;

    public LazyListItemProviderImpl(LazyListState lazyListState, LazyListIntervalContent lazyListIntervalContent, c cVar, androidx.compose.foundation.lazy.layout.p pVar) {
        this.f2533a = lazyListState;
        this.f2534b = lazyListIntervalContent;
        this.f2535c = cVar;
        this.f2536d = pVar;
    }

    @Override // androidx.compose.foundation.lazy.layout.m
    public int a(Object obj) {
        return e().a(obj);
    }

    @Override // androidx.compose.foundation.lazy.layout.m
    public Object b(int i11) {
        Object objB = e().b(i11);
        return objB == null ? this.f2534b.e(i11) : objB;
    }

    @Override // androidx.compose.foundation.lazy.layout.m
    public Object c(int i11) {
        return this.f2534b.b(i11);
    }

    @Override // androidx.compose.foundation.lazy.k
    public c d() {
        return this.f2535c;
    }

    @Override // androidx.compose.foundation.lazy.k
    public androidx.compose.foundation.lazy.layout.p e() {
        return this.f2536d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LazyListItemProviderImpl) {
            return Intrinsics.b(this.f2534b, ((LazyListItemProviderImpl) obj).f2534b);
        }
        return false;
    }

    @Override // androidx.compose.foundation.lazy.k
    public List<Integer> f() {
        return this.f2534b.f();
    }

    @Override // androidx.compose.foundation.lazy.layout.m
    public void g(final int i11, final Object obj, androidx.compose.runtime.i iVar, final int i12) {
        int i13;
        androidx.compose.runtime.i iVarG = iVar.g(-462424778);
        if ((i12 & 6) == 0) {
            i13 = (iVarG.c(i11) ? 4 : 2) | i12;
        } else {
            i13 = i12;
        }
        if ((i12 & 48) == 0) {
            i13 |= iVarG.A(obj) ? 32 : 16;
        }
        if ((i12 & 384) == 0) {
            i13 |= iVarG.Q(this) ? 256 : 128;
        }
        if ((i13 & 147) == 146 && iVarG.h()) {
            iVarG.H();
        } else {
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.S(-462424778, i13, -1, "androidx.compose.foundation.lazy.LazyListItemProviderImpl.Item (LazyListItemProvider.kt:75)");
            }
            LazyLayoutPinnableItemKt.a(obj, i11, this.f2533a.w(), androidx.compose.runtime.internal.b.e(-824725566, true, new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListItemProviderImpl$Item$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar2, Integer num) {
                    invoke(iVar2, num.intValue());
                    return Unit.f68710a;
                }

                public final void invoke(androidx.compose.runtime.i iVar2, int i14) {
                    if ((i14 & 3) == 2 && iVar2.h()) {
                        iVar2.H();
                        return;
                    }
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(-824725566, i14, -1, "androidx.compose.foundation.lazy.LazyListItemProviderImpl.Item.<anonymous> (LazyListItemProvider.kt:77)");
                    }
                    LazyListIntervalContent lazyListIntervalContent = this.this$0.f2534b;
                    int i15 = i11;
                    LazyListItemProviderImpl lazyListItemProviderImpl = this.this$0;
                    androidx.compose.foundation.lazy.layout.b.a<i> aVar = lazyListIntervalContent.c().get(i15);
                    aVar.c().a().invoke(lazyListItemProviderImpl.d(), Integer.valueOf(i15 - aVar.b()), iVar2, 0);
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                }
            }, iVarG, 54), iVarG, ((i13 >> 3) & 14) | 3072 | ((i13 << 3) & 112));
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.R();
            }
        }
        g2 g2VarJ = iVarG.j();
        if (g2VarJ != null) {
            g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListItemProviderImpl$Item$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar2, Integer num) {
                    invoke(iVar2, num.intValue());
                    return Unit.f68710a;
                }

                public final void invoke(androidx.compose.runtime.i iVar2, int i14) {
                    this.$tmp0_rcvr.g(i11, obj, iVar2, v1.a(i12 | 1));
                }
            });
        }
    }

    @Override // androidx.compose.foundation.lazy.layout.m
    public int getItemCount() {
        return this.f2534b.d();
    }

    public int hashCode() {
        return this.f2534b.hashCode();
    }
}
