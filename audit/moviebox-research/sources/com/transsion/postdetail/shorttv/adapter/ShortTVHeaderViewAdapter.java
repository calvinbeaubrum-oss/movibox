package com.transsion.postdetail.shorttv.adapter;

import android.content.Context;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.R$string;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.f;
import kotlin.collections.g;
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
public final class ShortTVHeaderViewAdapter extends BaseQuickAdapter<Subject, BaseViewHolder> {
    public final zr.b H;

    public ShortTVHeaderViewAdapter(zr.b bVar) {
        super(R$layout.item_short_tv_history, null, 2, null);
        this.H = bVar;
    }

    public /* synthetic */ ShortTVHeaderViewAdapter(zr.b bVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : bVar);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0054  */
    /* JADX WARN: Code duplicated, block: B:18:0x0080  */
    /* JADX WARN: Code duplicated, block: B:20:0x0086  */
    /* JADX WARN: Code duplicated, block: B:21:0x008a  */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, Subject item) {
        List listL;
        int totalEpisode;
        ResourceDetectors resourceDetectors;
        Integer totalEpisode2;
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        AppCompatImageView appCompatImageView = (AppCompatImageView) holder.getView(R$id.iv_cover);
        if (item.getBuiltIn()) {
            H0(appCompatImageView, item);
        } else {
            I0(appCompatImageView, item);
        }
        ((TextView) holder.getView(R$id.tv_title)).setText(item.getTitle());
        List<String> tags = item.getTags();
        if (tags == null) {
            listL = g.l();
        } else {
            listL = tags.isEmpty() ^ true ? f.e(CollectionsKt___CollectionsKt.e0(f.f(tags))) : g.l();
            if (listL == null) {
                listL = g.l();
            }
        }
        c cVar = new c(CollectionsKt___CollectionsKt.M0(listL));
        RecyclerView recyclerView = (RecyclerView) holder.getView(R$id.rv_list);
        if (item.getShortTVFirstEp() != null) {
            ShortTVItem shortTVFirstEp = item.getShortTVFirstEp();
            Intrinsics.d(shortTVFirstEp);
            if (shortTVFirstEp.getEp() > 0) {
                so.c.g(recyclerView);
            } else if (listL.isEmpty()) {
                so.c.g(recyclerView);
            } else {
                FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(recyclerView.getContext());
                flexboxLayoutManager.P(0);
                flexboxLayoutManager.Q(1);
                flexboxLayoutManager.R(0);
                recyclerView.setLayoutManager(flexboxLayoutManager);
                recyclerView.setAdapter(cVar);
                so.c.k(recyclerView);
            }
        } else if (listL.isEmpty()) {
            so.c.g(recyclerView);
        } else {
            FlexboxLayoutManager flexboxLayoutManager2 = new FlexboxLayoutManager(recyclerView.getContext());
            flexboxLayoutManager2.P(0);
            flexboxLayoutManager2.Q(1);
            flexboxLayoutManager2.R(0);
            recyclerView.setLayoutManager(flexboxLayoutManager2);
            recyclerView.setAdapter(cVar);
            so.c.k(recyclerView);
        }
        TextView textView = (TextView) holder.getView(R$id.tv_ep);
        if (item.getTotalEpisode() == 0) {
            List<ResourceDetectors> resourceDetectors2 = item.getResourceDetectors();
            totalEpisode = (resourceDetectors2 == null || (resourceDetectors = (ResourceDetectors) CollectionsKt___CollectionsKt.e0(resourceDetectors2)) == null || (totalEpisode2 = resourceDetectors.getTotalEpisode()) == null) ? 0 : totalEpisode2.intValue();
        } else {
            totalEpisode = item.getTotalEpisode();
        }
        textView.setText(Utils.a().getString(R$string.short_tv_watch_ad_tips, String.valueOf(totalEpisode)));
    }

    public final void H0(AppCompatImageView appCompatImageView, Subject subject) {
        j.d(l0.a(w0.c()), null, null, new ShortTVHeaderViewAdapter$loadBuiltInCover$1(subject, appCompatImageView, null), 3, null);
    }

    public final void I0(AppCompatImageView appCompatImageView, Subject subject) {
        String thumbnail;
        String url;
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context context = appCompatImageView.getContext();
        Intrinsics.f(context, "context");
        Cover cover = subject.getCover();
        String str = (cover == null || (url = cover.getUrl()) == null) ? "" : url;
        int i11 = R$color.module_04;
        Cover cover2 = subject.getCover();
        companion.q(context, appCompatImageView, str, (8120 & 8) != 0 ? companion.d() : i11, (8120 & 16) != 0 ? companion.c() : 0, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : (cover2 == null || (thumbnail = cover2.getThumbnail()) == null) ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: i0 */
    public void onViewAttachedToWindow(BaseViewHolder holder) {
        Intrinsics.g(holder, "holder");
        super.onViewAttachedToWindow(holder);
        int bindingAdapterPosition = holder.getBindingAdapterPosition();
        zr.b bVar = this.H;
        if (bVar != null) {
            RecyclerView.m layoutManager = W().getLayoutManager();
            Intrinsics.e(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            bVar.i((LinearLayoutManager) layoutManager, bindingAdapterPosition, true, true);
        }
    }
}
