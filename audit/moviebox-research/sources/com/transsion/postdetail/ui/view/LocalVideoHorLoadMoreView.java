package com.transsion.postdetail.ui.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baseui.R$id;
import com.transsion.baseui.widget.BaseLoadMoreView;
import com.transsion.postdetail.R$layout;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class LocalVideoHorLoadMoreView extends BaseLoadMoreView {
    @Override // com.transsion.baseui.widget.BaseLoadMoreView, g9.a
    public View getLoadEndView(BaseViewHolder holder) {
        Intrinsics.g(holder, "holder");
        View viewFindViewById = holder.itemView.findViewById(R$id.tv_no_more);
        Intrinsics.f(viewFindViewById, "holder.itemView.findView…n.baseui.R.id.tv_no_more)");
        return viewFindViewById;
    }

    @Override // com.transsion.baseui.widget.BaseLoadMoreView, g9.a
    public View getRootView(ViewGroup parent) {
        Intrinsics.g(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R$layout.view_video_item_load_more_hor, parent, false);
        view.addOnAttachStateChangeListener(this);
        Intrinsics.f(view, "view");
        return view;
    }
}
