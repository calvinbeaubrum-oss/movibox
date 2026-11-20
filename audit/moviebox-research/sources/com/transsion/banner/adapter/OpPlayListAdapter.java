package com.transsion.banner.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.banner.R$id;
import com.transsion.banner.R$layout;
import com.transsion.banner.R$mipmap;
import com.transsion.baselib.utils.i;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
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
public final class OpPlayListAdapter extends BaseQuickAdapter<Subject, BaseViewHolder> {
    public final boolean H;
    public final boolean I;
    public final Pair<Integer, Integer> J;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OpPlayListAdapter(List<Subject> datas, boolean z11, boolean z12) {
        super(R$layout.item_op_play_list, datas);
        Intrinsics.g(datas, "datas");
        this.H = z11;
        this.I = z12;
        this.J = tp.f.f77260a.b();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, Subject subject) {
        String thumbnail;
        String url;
        String url2;
        String thumbnail2;
        Integer height;
        Integer width;
        Intrinsics.g(holder, "holder");
        ConstraintLayout constraintLayout = (ConstraintLayout) holder.getViewOrNull(R$id.item_root);
        if (constraintLayout != null) {
            ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
            layoutParams.width = this.J.getFirst().intValue();
            layoutParams.height = -2;
            constraintLayout.setLayoutParams(layoutParams);
        }
        if (subject == null) {
            ConstraintLayout constraintLayout2 = (ConstraintLayout) holder.getViewOrNull(R$id.item_root);
            if (constraintLayout2 != null) {
                so.c.h(constraintLayout2);
                return;
            }
            return;
        }
        ConstraintLayout constraintLayout3 = (ConstraintLayout) holder.getViewOrNull(R$id.item_root);
        if (constraintLayout3 != null) {
            so.c.k(constraintLayout3);
        }
        ShapeableImageView shapeableImageView = (ShapeableImageView) holder.getViewOrNull(R$id.iv_cover);
        if (shapeableImageView != null) {
            ViewGroup.LayoutParams layoutParams2 = shapeableImageView.getLayoutParams();
            layoutParams2.width = -1;
            layoutParams2.height = this.J.getSecond().intValue();
            shapeableImageView.setLayoutParams(layoutParams2);
            if (this.I) {
                j.d(l0.a(w0.c()), null, null, new OpPlayListAdapter$convert$2$1(subject, shapeableImageView, null), 3, null);
            } else {
                Cover cover = subject.getCover();
                int iIntValue = 1;
                float fIntValue = (cover == null || (width = cover.getWidth()) == null) ? 1 : width.intValue();
                Cover cover2 = subject.getCover();
                if (cover2 != null && (height = cover2.getHeight()) != null) {
                    iIntValue = height.intValue();
                }
                if (fIntValue / iIntValue > 1.5d) {
                    ImageHelper.Companion companion = ImageHelper.f51371a;
                    Context context = shapeableImageView.getContext();
                    Cover cover3 = subject.getCover();
                    if (cover3 == null || (url2 = cover3.getUrl()) == null) {
                        url2 = "";
                    }
                    int iIntValue2 = this.J.getFirst().intValue() * 2;
                    int iIntValue3 = this.J.getSecond().intValue();
                    Cover cover4 = subject.getCover();
                    if (cover4 == null || (thumbnail2 = cover4.getThumbnail()) == null) {
                        thumbnail2 = "";
                    }
                    Intrinsics.f(context, "context");
                    companion.q(context, shapeableImageView, url2, (8120 & 8) != 0 ? companion.d() : iIntValue2, (8120 & 16) != 0 ? companion.c() : iIntValue3, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : thumbnail2, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : true, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
                } else {
                    ImageHelper.Companion companion2 = ImageHelper.f51371a;
                    Context context2 = shapeableImageView.getContext();
                    Intrinsics.f(context2, "context");
                    Cover cover5 = subject.getCover();
                    String str = (cover5 == null || (url = cover5.getUrl()) == null) ? "" : url;
                    int iIntValue4 = this.J.getFirst().intValue();
                    Cover cover6 = subject.getCover();
                    companion2.q(context2, shapeableImageView, str, (8120 & 8) != 0 ? companion2.d() : iIntValue4, (8120 & 16) != 0 ? companion2.c() : 0, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : (cover6 == null || (thumbnail = cover6.getThumbnail()) == null) ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
                }
            }
        }
        holder.setText(R$id.tv_title, subject.getTitle());
        holder.setText(R$id.tv_score, subject.getImdbRate());
        AppCompatImageView appCompatImageView = (AppCompatImageView) holder.getViewOrNull(R$id.iv_tag);
        if (appCompatImageView != null) {
            if (this.H) {
                appCompatImageView.setImageResource(H0(i.b(D(), subject)));
                so.c.k(appCompatImageView);
            } else {
                so.c.g(appCompatImageView);
            }
        }
        holder.setText(R$id.tv_playlist_corner, subject.getCorner());
    }

    public final int H0(int i11) {
        if (i11 == 0) {
            return R$mipmap.ic_rank_01;
        }
        if (i11 == 1) {
            return R$mipmap.ic_rank_02;
        }
        if (i11 != 2) {
            return 0;
        }
        return R$mipmap.ic_rank_03;
    }
}
