package com.chad.library.adapter.base.binder;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class QuickDataBindingItemBinder$BinderDataBindingHolder<DB extends ViewDataBinding> extends BaseViewHolder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DB f28849b;

    /* JADX WARN: Illegal instructions before constructor call */
    public QuickDataBindingItemBinder$BinderDataBindingHolder(DB dataBinding) {
        Intrinsics.g(dataBinding, "dataBinding");
        View root = dataBinding.getRoot();
        Intrinsics.f(root, "dataBinding.root");
        super(root);
        this.f28849b = dataBinding;
    }
}
