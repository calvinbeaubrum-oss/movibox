package com.transsnet.downloader.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.view.CornerTextView;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.widget.DownloadView;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class e0 extends BaseQuickAdapter<Subject, BaseViewHolder> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(List<Subject> datas) {
        super(R$layout.item_movie_rec, datas);
        Intrinsics.g(datas, "datas");
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00a7  */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, Subject item) {
        boolean z11;
        String url;
        String thumbnail;
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        ShapeableImageView shapeableImageView = (ShapeableImageView) holder.getViewOrNull(R$id.iv_cover);
        if (shapeableImageView != null) {
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Context context = shapeableImageView.getContext();
            Intrinsics.f(context, "context");
            Cover cover = item.getCover();
            if (cover == null || (url = cover.getUrl()) == null) {
                url = "";
            }
            Cover cover2 = item.getCover();
            if (cover2 == null || (thumbnail = cover2.getThumbnail()) == null) {
                thumbnail = "";
            }
            companion.q(context, shapeableImageView, url, (8120 & 8) != 0 ? companion.d() : 0, (8120 & 16) != 0 ? companion.c() : 0, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
        }
        holder.setText(R$id.tv_score, item.getImdbRate());
        holder.setText(R$id.tv_title, item.getTitle());
        DownloadView downloadView = (DownloadView) holder.getViewOrNull(R$id.download);
        if (downloadView != null) {
            if (com.transsion.baselib.utils.m.f51320a.b()) {
                downloadView.setShowPlayType();
            } else if (Intrinsics.b(item.getHasResource(), Boolean.TRUE)) {
                so.c.k(downloadView);
                ResourceDetectors resourceDetector = item.getResourceDetector();
                if (resourceDetector != null) {
                    String subjectId = item.getSubjectId();
                    String resourceId = resourceDetector.getResourceId();
                    Integer type = resourceDetector.getType();
                    if (type != null) {
                        z11 = type.intValue() == 1;
                    }
                    DownloadView.setShowType$default(downloadView, subjectId, resourceId, Boolean.valueOf(z11), false, 0, 24, null);
                }
            } else {
                so.c.g(downloadView);
            }
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) holder.getViewOrNull(R$id.icon_download);
        if (appCompatImageView != null) {
            if (com.transsion.baselib.utils.m.f51320a.b()) {
                so.c.g(appCompatImageView);
            } else {
                so.c.k(appCompatImageView);
            }
        }
        ((CornerTextView) holder.getView(R$id.tv_download_corner)).setTextWithType(item.getCorner(), item.getSubjectType());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: d0 */
    public void onBindViewHolder(BaseViewHolder holder, int i11) {
        Intrinsics.g(holder, "holder");
        super.onBindViewHolder(holder, i11);
        ConstraintLayout constraintLayout = (ConstraintLayout) holder.getViewOrNull(R$id.item);
        if (constraintLayout != null) {
            ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
            Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            RecyclerView.n nVar = (RecyclerView.n) layoutParams;
            if (i11 == 0) {
                nVar.setMarginStart(com.blankj.utilcode.util.f0.a(16.0f));
                nVar.setMarginEnd(0);
            } else if (i11 == getItemCount() - 1) {
                nVar.setMarginStart(com.blankj.utilcode.util.f0.a(8.0f));
                nVar.setMarginEnd(com.blankj.utilcode.util.f0.a(16.0f));
            } else {
                nVar.setMarginStart(com.blankj.utilcode.util.f0.a(8.0f));
                nVar.setMarginEnd(0);
            }
        }
    }
}
