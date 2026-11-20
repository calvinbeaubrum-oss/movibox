package com.transsion.postdetail.shorttv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.bean.BannerData;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.postdetail.R$layout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

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
@SourceDebugExtension
public final class ShortTVBannerAdapter extends RecyclerView.Adapter<b> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<BannerData> f55387i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function3<? super View, ? super Integer, ? super BannerData, Unit> f55388j;

    public static final void g(BannerData bannerData, ShortTVBannerAdapter this$0, int i11, View view) {
        Function3<? super View, ? super Integer, ? super BannerData, Unit> function3;
        Intrinsics.g(this$0, "this$0");
        if (bannerData == null || (function3 = this$0.f55388j) == null) {
            return;
        }
        Intrinsics.f(view, "view");
        function3.invoke(view, Integer.valueOf(i11), bannerData);
    }

    public final List<BannerData> e() {
        return this.f55387i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b holder, final int i11) {
        Image image;
        String thumbnail;
        Image image2;
        String url;
        Boolean hasResource;
        Intrinsics.g(holder, "holder");
        final BannerData bannerData = this.f55387i.get(i11);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.shorttv.adapter.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShortTVBannerAdapter.g(bannerData, this, i11, view);
            }
        });
        if (bannerData == null || !bannerData.getBuiltIn()) {
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Context context = holder.itemView.getContext();
            Intrinsics.f(context, "holder.itemView.context");
            ShapeableImageView shapeableImageView = holder.e().f77953b;
            Intrinsics.f(shapeableImageView, "holder.viewBinding.ivCover");
            companion.q(context, shapeableImageView, (bannerData == null || (image2 = bannerData.getImage()) == null || (url = image2.getUrl()) == null) ? "" : url, (8120 & 8) != 0 ? companion.d() : R$color.module_04, (8120 & 16) != 0 ? companion.c() : 0, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : (bannerData == null || (image = bannerData.getImage()) == null || (thumbnail = image.getThumbnail()) == null) ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
        } else {
            j.d(l0.a(w0.c()), null, null, new ShortTVBannerAdapter$onBindViewHolder$1$2(bannerData, holder, null), 3, null);
        }
        holder.e().f77955d.setText(bannerData != null ? bannerData.getContent() : null);
        AppCompatImageView appCompatImageView = holder.e().f77954c;
        Intrinsics.f(appCompatImageView, "holder.viewBinding.ivPlay");
        appCompatImageView.setVisibility((bannerData == null || (hasResource = bannerData.getHasResource()) == null) ? false : hasResource.booleanValue() ? 0 : 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f55387i.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_short_tv_banner, parent, false);
        Intrinsics.f(view, "view");
        return new b(view);
    }

    public final void i(List<BannerData> list) {
        Intrinsics.g(list, "list");
        this.f55387i.clear();
        this.f55387i.addAll(list);
        notifyDataSetChanged();
    }

    public final void j(Function3<? super View, ? super Integer, ? super BannerData, Unit> listener) {
        Intrinsics.g(listener, "listener");
        this.f55388j = listener;
    }
}
