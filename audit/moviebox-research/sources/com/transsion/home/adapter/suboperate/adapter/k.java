package com.transsion.home.adapter.suboperate.adapter;

import android.content.res.ColorStateList;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R$color;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.moviedetailapi.bean.RankingListItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class k extends BaseQuickAdapter<RankingListItem, BaseViewHolder> {
    public int H;

    public k(int i11) {
        super(i11, null, 2, null);
    }

    public /* synthetic */ k(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? R$layout.item_provider_ranklist_tab : i11);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, RankingListItem item) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        TextView textView = (TextView) holder.getView(R$id.sub_operation_rankinglist_tab_text);
        textView.setText(item.getTitle());
        if (D().indexOf(item) == this.H) {
            textView.setTextColor(z2.a.getColor(getContext(), R$color.brand));
            textView.setBackgroundTintList(ColorStateList.valueOf(z2.a.getColor(getContext(), com.transsion.usercenter.R$color.pair_FFFFFF)));
        } else {
            textView.setTextColor(z2.a.getColor(getContext(), R$color.text_02));
            textView.setBackgroundTintList(ColorStateList.valueOf(z2.a.getColor(getContext(), R$color.transparent)));
        }
    }

    public final void H0(int i11) {
        this.H = i11;
        notifyDataSetChanged();
    }
}
