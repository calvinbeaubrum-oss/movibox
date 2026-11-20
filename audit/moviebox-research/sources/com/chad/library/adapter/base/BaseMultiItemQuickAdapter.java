package com.chad.library.adapter.base;

import android.util.SparseIntArray;
import android.view.ViewGroup;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import e9.a;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public abstract class BaseMultiItemQuickAdapter<T extends a, VH extends BaseViewHolder> extends BaseQuickAdapter<T, VH> {
    public final Lazy H;

    public BaseMultiItemQuickAdapter(List<T> list) {
        super(0, list);
        this.H = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.NONE, new Function0<SparseIntArray>() { // from class: com.chad.library.adapter.base.BaseMultiItemQuickAdapter$layouts$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SparseIntArray invoke() {
                return new SparseIntArray();
            }
        });
    }

    public /* synthetic */ BaseMultiItemQuickAdapter(List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : list);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public int F(int i11) {
        return D().get(i11).getItemType();
    }

    public final void G0(int i11, int i12) {
        H0().put(i11, i12);
    }

    public final SparseIntArray H0() {
        return (SparseIntArray) this.H.getValue();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public VH f0(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        int i12 = H0().get(i11);
        if (i12 != 0) {
            return B(parent, i12);
        }
        throw new IllegalArgumentException(("ViewType: " + i11 + " found layoutResId，please use addItemType() first!").toString());
    }
}
