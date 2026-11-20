package com.transsion.home.view;

import android.content.Context;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
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
public final class RankingAdapter extends BaseQuickAdapter<Subject, BaseViewHolder> {
    public final Pair<Integer, Integer> H;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RankingAdapter(List<Subject> datas) {
        super(R$layout.item_ranking, datas);
        Intrinsics.g(datas, "datas");
        this.H = tp.f.f77260a.b();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, Subject item) {
        String string;
        String url;
        String thumbnail;
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        ConstraintLayout constraintLayout = (ConstraintLayout) holder.getViewOrNull(R$id.item_root);
        if (constraintLayout != null) {
            ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
            layoutParams.width = this.H.getFirst().intValue();
            layoutParams.height = -2;
            constraintLayout.setLayoutParams(layoutParams);
        }
        ShapeableImageView shapeableImageView = (ShapeableImageView) holder.getViewOrNull(R$id.iv_cover);
        if (shapeableImageView != null) {
            ViewGroup.LayoutParams layoutParams2 = shapeableImageView.getLayoutParams();
            layoutParams2.width = -1;
            layoutParams2.height = this.H.getSecond().intValue();
            if (item.getBuiltIn()) {
                j.d(l0.a(w0.c()), null, null, new RankingAdapter$convert$2$1(item, shapeableImageView, null), 3, null);
            } else {
                ImageHelper.Companion companion = ImageHelper.f51371a;
                Context context = shapeableImageView.getContext();
                Intrinsics.f(context, "context");
                Cover cover = item.getCover();
                if (cover == null || (url = cover.getUrl()) == null) {
                    url = "";
                }
                int iIntValue = this.H.getFirst().intValue();
                int iIntValue2 = this.H.getSecond().intValue();
                Cover cover2 = item.getCover();
                if (cover2 == null || (thumbnail = cover2.getThumbnail()) == null) {
                    thumbnail = "";
                }
                companion.q(context, shapeableImageView, url, (8120 & 8) != 0 ? companion.d() : iIntValue, (8120 & 16) != 0 ? companion.c() : iIntValue2, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
            }
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) holder.getViewOrNull(R$id.tv_score);
        if (appCompatTextView != null) {
            so.c.k(appCompatTextView);
            appCompatTextView.setText(item.getImdbRate());
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) holder.getViewOrNull(R$id.tv_title);
        if (appCompatTextView2 != null) {
            appCompatTextView2.setText(item.getTitle());
        }
        AppCompatTextView appCompatTextView3 = (AppCompatTextView) holder.getViewOrNull(R$id.tv_tag);
        if (appCompatTextView3 != null) {
            String tag = item.getTag();
            if (tag == null || tag.length() == 0) {
                appCompatTextView3.setTextColor(z2.a.getColor(appCompatTextView3.getContext(), R$color.text_03));
                StringBuilder sb2 = new StringBuilder();
                sb2.append(item.getCountryName());
                String genre = item.getGenre();
                List listE0 = genre != null ? StringsKt__StringsKt.E0(genre, new String[]{","}, false, 0, 6, null) : null;
                if (listE0 != null && (!listE0.isEmpty())) {
                    sb2.append(" ");
                    sb2.append((String) listE0.get(0));
                }
                string = sb2.toString();
            } else {
                appCompatTextView3.setTextColor(z2.a.getColor(appCompatTextView3.getContext(), R$color.rank_tag_color));
                string = item.getTag();
            }
            appCompatTextView3.setText(string);
        }
    }
}
