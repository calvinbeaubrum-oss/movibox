package com.transsion.moviedetail.view;

import android.view.View;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.ResourcesSeason;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class o extends BaseQuickAdapter<ResourcesSeason, BaseViewHolder> implements h9.j {
    public Integer H;

    public o() {
        super(R$layout.item_item_season_tab, null, 2, null);
        this.H = Integer.valueOf(SubjectType.MOVIE.getValue());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, ResourcesSeason item) {
        String strA;
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        View view = holder.itemView;
        Intrinsics.e(view, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) view;
        Integer num = this.H;
        int value = SubjectType.EDUCATION.getValue();
        if (num != null && num.intValue() == value) {
            strA = "Unit " + item.getSe();
        } else {
            strA = com.transsion.baseui.util.l.a(item.getSe());
        }
        textView.setText(strA);
        textView.setSelected(item.isSelected());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public void y(BaseViewHolder holder, ResourcesSeason item, List<? extends Object> payloads) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        Intrinsics.g(payloads, "payloads");
        super.y(holder, item, payloads);
        if (payloads.isEmpty()) {
            return;
        }
        Object obj = payloads.get(payloads.size() - 1);
        if (obj instanceof Boolean) {
            View view = holder.itemView;
            Intrinsics.e(view, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) view).setSelected(((Boolean) obj).booleanValue());
        }
    }

    public final void I0(Integer num) {
        this.H = num;
    }

    @Override // h9.j
    public /* synthetic */ h9.f a(BaseQuickAdapter baseQuickAdapter) {
        return h9.i.a(this, baseQuickAdapter);
    }
}
