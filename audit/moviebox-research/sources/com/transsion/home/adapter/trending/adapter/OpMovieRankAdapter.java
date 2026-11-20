package com.transsion.home.adapter.trending.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blankj.utilcode.util.d0;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.baselib.utils.i;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class OpMovieRankAdapter extends BaseQuickAdapter<Subject, BaseViewHolder> {
    public final OperateItem H;
    public final boolean I;
    public final int J;
    public final int K;
    public final int L;

    public OpMovieRankAdapter(int i11, OperateItem operateItem, boolean z11, int i12, boolean z12, boolean z13) {
        super(i11, null, 2, null);
        this.H = operateItem;
        this.I = z11;
        this.J = i12;
        int i13 = z12 ? 2 : z13 ? 4 : 3;
        float f11 = z12 ? 0.56f : 1.39f;
        int iA = f0.a(((((f0.b(kotlin.ranges.a.g(d0.e(), d0.c())) - 12) - (i13 * 8)) - 12) * 1.0f) / i13);
        this.K = iA;
        this.L = (int) (iA * f11);
    }

    public /* synthetic */ OpMovieRankAdapter(int i11, OperateItem operateItem, boolean z11, int i12, boolean z12, boolean z13, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? R$layout.item_main_operation_movie_rank : i11, operateItem, z11, i12, z12, z13);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, Subject item) {
        String thumbnail;
        String url;
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        int iB = i.b(D(), item);
        r(holder, getItemViewType(iB));
        ShapeableImageView shapeableImageView = (ShapeableImageView) holder.getViewOrNull(R$id.main_op_movie_rank_image);
        if (shapeableImageView != null) {
            if (item.getBuiltIn()) {
                j.d(l0.a(w0.c()), null, null, new OpMovieRankAdapter$convert$1$1(item, shapeableImageView, null), 3, null);
            } else {
                ImageHelper.Companion companion = ImageHelper.f51371a;
                Context context = shapeableImageView.getContext();
                Intrinsics.f(context, "context");
                Cover cover = item.getCover();
                String str = (cover == null || (url = cover.getUrl()) == null) ? "" : url;
                int i11 = this.K;
                int i12 = this.L;
                Cover cover2 = item.getCover();
                companion.q(context, shapeableImageView, str, (8120 & 8) != 0 ? companion.d() : i11, (8120 & 16) != 0 ? companion.c() : i12, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : (cover2 == null || (thumbnail = cover2.getThumbnail()) == null) ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
            }
            if (shapeableImageView.getLayoutParams().width != this.K || shapeableImageView.getLayoutParams().height != this.L) {
                shapeableImageView.getLayoutParams().width = this.K;
                shapeableImageView.getLayoutParams().height = this.L;
            }
        }
        if (F(iB) == 100) {
            return;
        }
        TextView textView = (TextView) holder.getViewOrNull(R$id.main_op_movie_rank_title);
        if (textView != null) {
            textView.setText(item.getTitle());
            textView.setMaxWidth(this.K);
        }
        holder.setText(R$id.main_op_movie_rank_corner, item.getCorner());
        if (this.I) {
            H0(item, iB);
        } else {
            pr.a.f74040a.r(item, iB, this.H);
        }
    }

    public final void H0(Subject subject, int i11) {
        HashMap map = new HashMap();
        map.put("event_type", "browse_rank_item");
        map.put("sequence", String.valueOf(i11));
        map.put("tabId", String.valueOf(this.J));
        OperateItem operateItem = this.H;
        if (operateItem != null) {
            ot.b.a(operateItem, map);
        }
        ot.b.c(subject, map);
        com.transsion.baselib.helper.a.f51183a.d(SubTabFragment.f52541r.a(this.J), map);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public BaseViewHolder f0(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        if (i11 != 100) {
            BaseViewHolder baseViewHolderF0 = super.f0(parent, i11);
            ShapeableImageView shapeableImageView = (ShapeableImageView) baseViewHolderF0.getViewOrNull(R$id.main_op_movie_rank_image);
            if (shapeableImageView != null) {
                shapeableImageView.getLayoutParams().width = this.K;
                shapeableImageView.getLayoutParams().height = this.L;
            }
            return baseViewHolderF0;
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_main_operation_movie_rank_more, parent, false);
        View viewFindViewById = view.findViewById(R$id.main_op_movie_rank_image);
        if (viewFindViewById != null) {
            viewFindViewById.getLayoutParams().width = this.K;
            viewFindViewById.getLayoutParams().height = this.L;
        }
        View viewFindViewById2 = view.findViewById(R$id.main_op_movie_rank_more_mask);
        viewFindViewById2.getLayoutParams().width = this.K;
        viewFindViewById2.getLayoutParams().height = this.L;
        Intrinsics.f(view, "view");
        return new BaseViewHolder(view);
    }
}
