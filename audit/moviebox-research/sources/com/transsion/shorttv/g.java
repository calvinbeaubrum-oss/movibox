package com.transsion.shorttv;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import h9.i;
import h9.j;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class g extends BaseProviderMultiAdapter<qx.e> implements j {
    public static final a I = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(List<qx.e> dataList, ShortTvBaseListFragment fragment, boolean z11, String str, String str2, boolean z12) {
        super(CollectionsKt___CollectionsKt.M0(dataList));
        Intrinsics.g(dataList, "dataList");
        Intrinsics.g(fragment, "fragment");
        K0(new h(fragment, z11, str, str2, z12));
        K0(new b());
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public int S0(List<? extends qx.e> data, int i11) {
        Intrinsics.g(data, "data");
        return CollectionsKt___CollectionsKt.h0(data, i11) instanceof qx.d ? 1 : 2;
    }

    public final qx.d V0(int i11, boolean z11) {
        Object next;
        if (D().size() >= i11) {
            qx.e eVar = (z11 || i11 == 0) ? (qx.e) CollectionsKt___CollectionsKt.h0(D(), i11) : (qx.e) CollectionsKt___CollectionsKt.h0(D(), i11 - 1);
            if (eVar instanceof qx.d) {
                qx.d dVar = (qx.d) eVar;
                if (dVar.b() == i11) {
                    return dVar;
                }
            }
        }
        Iterator<T> it = D().iterator();
        while (it.hasNext()) {
            next = it.next();
            qx.e eVar2 = (qx.e) next;
            if ((eVar2 instanceof qx.d) && ((qx.d) eVar2).b() == i11) {
                return (qx.d) next;
            }
        }
        next = null;
        return (qx.d) next;
    }

    public final int W0(int i11, boolean z11) {
        if (D().size() >= i11) {
            if (z11 || i11 == 0) {
                qx.e eVar = (qx.e) CollectionsKt___CollectionsKt.h0(D(), i11);
                if ((eVar instanceof qx.d) && ((qx.d) eVar).b() == i11) {
                    return i11;
                }
            } else {
                int i12 = i11 - 1;
                qx.e eVar2 = (qx.e) CollectionsKt___CollectionsKt.h0(D(), i12);
                if ((eVar2 instanceof qx.d) && ((qx.d) eVar2).b() == i11) {
                    return i12;
                }
            }
        }
        int i13 = 0;
        for (qx.e eVar3 : D()) {
            if ((eVar3 instanceof qx.d) && ((qx.d) eVar3).b() == i11) {
                return i13;
            }
            i13++;
        }
        return -1;
    }

    @Override // h9.j
    public /* synthetic */ h9.f a(BaseQuickAdapter baseQuickAdapter) {
        return i.a(this, baseQuickAdapter);
    }
}
