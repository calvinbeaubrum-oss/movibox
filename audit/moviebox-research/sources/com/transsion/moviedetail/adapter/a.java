package com.transsion.moviedetail.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.blankj.utilcode.util.d0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetailapi.bean.Staff;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
public final class a extends BaseQuickAdapter<Staff, BaseViewHolder> {
    public final int H;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(List<? extends Staff> staffList) {
        super(R$layout.adapter_crew, CollectionsKt___CollectionsKt.M0(staffList));
        Intrinsics.g(staffList, "staffList");
        this.H = d0.e();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, Staff item) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        TextView textView = (TextView) holder.getView(R$id.tv_staff_name);
        String name = item.getName();
        textView.setVisibility((name == null || name.length() == 0) ^ true ? 0 : 8);
        textView.setText(item.getName());
        TextView textView2 = (TextView) holder.getView(R$id.tv_staff_job);
        String character = item.getCharacter();
        textView2.setVisibility((character == null || character.length() == 0) ^ true ? 0 : 8);
        textView2.setText(item.getCharacter());
        ImageView imageView = (ImageView) holder.getView(R$id.iv_staff_avatar);
        int i11 = this.H / 4;
        int i12 = (i11 * 4) / 3;
        String avatarUrl = item.getAvatarUrl();
        if (avatarUrl == null || avatarUrl.length() == 0) {
            return;
        }
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context context = getContext();
        String avatarUrl2 = item.getAvatarUrl();
        if (avatarUrl2 == null) {
            avatarUrl2 = "";
        }
        companion.r(context, imageView, avatarUrl2, (4088 & 8) != 0 ? companion.d() : i11, (4088 & 16) != 0 ? companion.c() : i12, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: d0 */
    public void onBindViewHolder(BaseViewHolder holder, int i11) {
        Intrinsics.g(holder, "holder");
        super.onBindViewHolder(holder, i11);
    }
}
