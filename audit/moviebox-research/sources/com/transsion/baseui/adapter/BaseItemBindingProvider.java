package com.transsion.baseui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n6.a;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class BaseItemBindingProvider<DATA, VB extends a> extends BaseItemProvider<DATA> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f51339f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class BindingViewHolder<VB extends a> extends BaseViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final VB f51340b;

        /* JADX WARN: Illegal instructions before constructor call */
        public BindingViewHolder(VB binding) {
            Intrinsics.g(binding, "binding");
            View root = binding.getRoot();
            Intrinsics.f(root, "binding.root");
            super(root);
            this.f51340b = binding;
        }

        public final VB e() {
            return this.f51340b;
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public void a(BaseViewHolder helper, DATA data) {
        Intrinsics.g(helper, "helper");
        u(((BindingViewHolder) helper).e(), helper, data);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public final int i() {
        return this.f51339f;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public BaseViewHolder n(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        Intrinsics.f(inflater, "inflater");
        return new BindingViewHolder(v(inflater, parent));
    }

    public abstract void u(VB vb2, BaseViewHolder baseViewHolder, DATA data);

    public abstract VB v(LayoutInflater layoutInflater, ViewGroup viewGroup);
}
