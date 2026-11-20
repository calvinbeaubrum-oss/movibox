package com.transsion.member.dialog;

import android.content.Context;
import androidx.appcompat.widget.AppCompatImageView;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.member.R$id;
import com.transsion.member.R$layout;
import com.transsion.memberapi.MemberRights;
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
public final class f extends BaseQuickAdapter<MemberRights, BaseViewHolder> {
    public final int H;

    public f(List<MemberRights> list) {
        super(R$layout.item_dialog_fragment_member_guide_adapter_layout, list);
        this.H = f0.a(36.0f);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, MemberRights item) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        AppCompatImageView appCompatImageView = (AppCompatImageView) holder.getView(R$id.ivMemberRightIcon);
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context context = getContext();
        int i11 = this.H;
        companion.o(context, appCompatImageView, item.getIcon(), (32704 & 8) != 0 ? R$color.skeleton : R$color.transparent, (32704 & 16) != 0 ? companion.d() : i11, (32704 & 32) != 0 ? companion.c() : i11, (32704 & 64) != 0 ? 0 : 0, (32704 & 128) != 0, (32704 & 256) != 0 ? "" : null, (32704 & 512) != 0, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
        holder.setText(R$id.tvMemberRightTitle, item.getDescription());
    }
}
