package com.transsnet.downloader.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import java.util.List;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class f0 extends BaseQuickAdapter<Subject, BaseViewHolder> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(List<Subject> dataList) {
        super(R$layout.item_movie_rec_footview, dataList);
        Intrinsics.g(dataList, "dataList");
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, Subject item) {
        String url;
        String thumbnail;
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        int[] iArrH0 = H0();
        ShapeableImageView shapeableImageView = (ShapeableImageView) holder.getViewOrNull(R$id.iv_cover);
        if (shapeableImageView != null) {
            ViewGroup.LayoutParams layoutParams = shapeableImageView.getLayoutParams();
            layoutParams.width = iArrH0[0];
            layoutParams.height = iArrH0[1];
            shapeableImageView.setLayoutParams(layoutParams);
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
        holder.setText(R$id.tv_title, item.getTitle());
        AppCompatImageView appCompatImageView = (AppCompatImageView) holder.getViewOrNull(R$id.icon_download);
        if (appCompatImageView != null) {
            if (com.transsion.baselib.utils.m.f51320a.b()) {
                so.c.g(appCompatImageView);
            } else {
                so.c.k(appCompatImageView);
            }
        }
        TextView textView = (TextView) holder.getViewOrNull(R$id.tv_download_foryou_corner);
        if (textView != null) {
            textView.setText(item.getCorner());
        }
        if (textView == null) {
            return;
        }
        String corner = item.getCorner();
        textView.setVisibility((corner == null || corner.length() == 0) ^ true ? 0 : 8);
    }

    public final int[] H0() {
        int iA = com.blankj.utilcode.util.f0.a(6.0f);
        int iA2 = com.blankj.utilcode.util.f0.a(8.0f);
        int i11 = com.transsion.baseui.util.b.a(getContext()) ? 4 : 3;
        int iE = ((com.blankj.utilcode.util.d0.e() - ((iA * 2) * i11)) - (iA2 * 2)) / i11;
        return new int[]{iE, (int) (iE * 1.3925234f)};
    }
}
