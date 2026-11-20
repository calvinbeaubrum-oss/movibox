package com.transsion.usercenter.laboratory;

import android.widget.LinearLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R$color;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
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
public final class z0 extends BaseQuickAdapter<a1, BaseViewHolder> {
    public z0() {
        super(R$layout.item_national_information_layout, null, 2, null);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, a1 item) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        LinearLayout linearLayout = (LinearLayout) holder.getView(R$id.llRoot);
        if (item.b()) {
            linearLayout.setBackgroundResource(R$color.brand_trans_20);
        } else {
            linearLayout.setBackgroundResource(R$color.black_10);
        }
        holder.setText(R$id.tvCountry, "Country : " + item.a().getCountry());
        holder.setText(R$id.tvMcc, "Mcc : " + item.a().getMcc());
        holder.setText(R$id.tvIso, "Iso : " + item.a().getIso());
        holder.setText(R$id.tvCountryCode, "CountryCode : " + item.a().getCountryCode());
    }
}
