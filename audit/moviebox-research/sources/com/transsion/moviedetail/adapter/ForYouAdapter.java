package com.transsion.moviedetail.adapter;

import android.content.Context;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.blankj.utilcode.util.d0;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import h9.f;
import h9.i;
import h9.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
public final class ForYouAdapter extends BaseQuickAdapter<Subject, BaseViewHolder> implements j {
    public final Integer H;
    public final int I;
    public final float J;
    public final float K;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForYouAdapter(List<Subject> datas, Integer num) {
        super((num != null && num.intValue() == SubjectType.MUSIC.getValue()) ? R$layout.movie_detail_item_for_you_music : R$layout.movie_detail_item_for_you, datas);
        Intrinsics.g(datas, "datas");
        this.H = num;
        int iE = d0.e();
        this.I = iE;
        float fA = (iE - f0.a(40.0f)) / 3.0f;
        this.J = fA;
        this.K = (fA * 149.0f) / 107.0f;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, Subject item) {
        String url;
        String thumbnail;
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        ShapeableImageView shapeableImageView = (ShapeableImageView) holder.getViewOrNull(R$id.iv_cover);
        if (shapeableImageView != null) {
            if (item.getBuiltIn()) {
                kotlinx.coroutines.j.d(l0.a(w0.c()), null, null, new ForYouAdapter$convert$1$1(item, shapeableImageView, null), 3, null);
            } else {
                ImageHelper.Companion companion = ImageHelper.f51371a;
                Context context = shapeableImageView.getContext();
                Intrinsics.f(context, "context");
                Cover cover = item.getCover();
                if (cover == null || (url = cover.getUrl()) == null) {
                    url = "";
                }
                int i11 = (int) this.J;
                int i12 = (int) this.K;
                Cover cover2 = item.getCover();
                if (cover2 == null || (thumbnail = cover2.getThumbnail()) == null) {
                    thumbnail = "";
                }
                companion.q(context, shapeableImageView, url, (8120 & 8) != 0 ? companion.d() : i11, (8120 & 16) != 0 ? companion.c() : i12, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
            }
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) holder.getViewOrNull(R$id.tv_title);
        if (appCompatTextView != null) {
            appCompatTextView.setText(item.getTitle());
        }
        TextView textView = (TextView) holder.getView(R$id.tv_for_you_corner);
        textView.setText(item.getCorner());
        String corner = item.getCorner();
        textView.setVisibility((corner == null || corner.length() == 0) ^ true ? 0 : 8);
    }

    @Override // h9.j
    public /* synthetic */ f a(BaseQuickAdapter baseQuickAdapter) {
        return i.a(this, baseQuickAdapter);
    }
}
