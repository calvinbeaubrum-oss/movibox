package com.transsion.postdetail.ui.adapter;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.postdetail.ui.adapter.provider.PostRecommendAudioProvider;
import com.transsion.postdetail.ui.adapter.provider.h;
import h9.i;
import h9.j;
import java.util.List;
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
public final class c extends BaseProviderMultiAdapter<PostSubjectItem> implements j {
    public final List<PostSubjectItem> I;
    public final zr.b J;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(List<PostSubjectItem> list, zr.b bVar) {
        super(list);
        Intrinsics.g(list, "list");
        this.I = list;
        this.J = bVar;
        K0(new PostRecommendAudioProvider());
        K0(new h());
        K0(new com.transsion.postdetail.ui.adapter.provider.f());
        K0(new com.transsion.postdetail.ui.adapter.provider.c());
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public int S0(List<? extends PostSubjectItem> data, int i11) {
        Intrinsics.g(data, "data");
        if (data.get(i11).getNonAdDelegate() != null) {
            return MediaType.POST_DETAIL_FOR_YOU_NATIVE_AD.ordinal();
        }
        Media media = data.get(i11).getMedia();
        String mediaType = media != null ? media.getMediaType() : null;
        if (Intrinsics.b(mediaType, MediaType.TEXT.getValue())) {
            return MediaType.IMAGE.ordinal();
        }
        MediaType mediaType2 = MediaType.IMAGE;
        if (Intrinsics.b(mediaType, mediaType2.getValue())) {
            return mediaType2.ordinal();
        }
        MediaType mediaType3 = MediaType.AUDIO;
        if (Intrinsics.b(mediaType, mediaType3.getValue())) {
            return mediaType3.ordinal();
        }
        MediaType mediaType4 = MediaType.VIDEO;
        return Intrinsics.b(mediaType, mediaType4.getValue()) ? mediaType4.ordinal() : mediaType2.ordinal();
    }

    @Override // h9.j
    public /* synthetic */ h9.f a(BaseQuickAdapter baseQuickAdapter) {
        return i.a(this, baseQuickAdapter);
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter, com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: i0 */
    public void onViewAttachedToWindow(BaseViewHolder holder) {
        Intrinsics.g(holder, "holder");
        super.onViewAttachedToWindow(holder);
        int adapterPosition = holder.getAdapterPosition();
        zr.b bVar = this.J;
        if (bVar != null) {
            RecyclerView.m layoutManager = W().getLayoutManager();
            Intrinsics.e(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            zr.b.j(bVar, (LinearLayoutManager) layoutManager, adapterPosition, true, false, 8, null);
        }
    }
}
