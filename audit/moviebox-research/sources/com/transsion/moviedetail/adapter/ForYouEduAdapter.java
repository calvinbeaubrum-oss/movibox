package com.transsion.moviedetail.adapter;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.blankj.utilcode.util.d0;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.edcation.CourseManager;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import h9.f;
import h9.i;
import h9.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
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
public final class ForYouEduAdapter extends BaseQuickAdapter<Subject, BaseViewHolder> implements j {
    public final int H;
    public final float I;
    public final float J;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForYouEduAdapter(List<Subject> data) {
        super(R$layout.movie_detail_item_for_you_edu, data);
        Intrinsics.g(data, "data");
        int iE = d0.e();
        this.H = iE;
        float fA = (iE - f0.a(40.0f)) / 3.0f;
        this.I = fA;
        this.J = (fA * 149.0f) / 107.0f;
    }

    public static final void K0(Subject item, View view) {
        Intrinsics.g(item, "$item");
        CourseManager.q(CourseManager.f51853a, item, null, 2, null);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, Subject item) {
        String url;
        String thumbnail;
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        ShapeableImageView shapeableImageView = (ShapeableImageView) holder.getViewOrNull(R$id.iv_cover);
        if (shapeableImageView != null) {
            if (item.getBuiltIn()) {
                kotlinx.coroutines.j.d(l0.a(w0.c()), null, null, new ForYouEduAdapter$convert$1$1(item, shapeableImageView, null), 3, null);
            } else {
                ImageHelper.Companion companion = ImageHelper.f51371a;
                Context context = shapeableImageView.getContext();
                Intrinsics.f(context, "context");
                Cover cover = item.getCover();
                if (cover == null || (url = cover.getUrl()) == null) {
                    url = "";
                }
                int i11 = (int) this.I;
                int i12 = (int) this.J;
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
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) holder.getViewOrNull(R$id.tvTag);
        if (appCompatTextView2 != null) {
            Context context2 = appCompatTextView2.getContext();
            Intrinsics.f(context2, "context");
            appCompatTextView2.setText(defpackage.a.b(context2, item));
        }
        J0(holder, item);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: I0, reason: merged with bridge method [inline-methods] */
    public void y(BaseViewHolder holder, Subject item, List<? extends Object> payloads) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        Intrinsics.g(payloads, "payloads");
        if (!payloads.isEmpty() && (payloads.get(payloads.size() - 1) instanceof Integer)) {
            J0(holder, item);
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0019  */
    public final void J0(BaseViewHolder baseViewHolder, final Subject subject) {
        boolean z11;
        AppCompatImageView appCompatImageView = (AppCompatImageView) baseViewHolder.getViewOrNull(R$id.ivAdd);
        if (appCompatImageView != null) {
            Integer seenStatus = subject.getSeenStatus();
            if (seenStatus != null) {
                z11 = seenStatus.intValue() == 1;
            }
            appCompatImageView.setSelected(z11);
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.moviedetail.adapter.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ForYouEduAdapter.K0(subject, view);
                }
            });
        }
    }

    @Override // h9.j
    public /* synthetic */ f a(BaseQuickAdapter baseQuickAdapter) {
        return i.a(this, baseQuickAdapter);
    }
}
