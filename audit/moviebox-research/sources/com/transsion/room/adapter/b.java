package com.transsion.room.adapter;

import android.R;
import android.content.Context;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.bean.RoomItem;
import com.transsion.room.R$drawable;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;
import com.transsion.room.R$string;
import com.transsion.room.view.roundimage.PileLayout;
import h9.f;
import h9.i;
import h9.j;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yi.n;

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
public final class b extends BaseQuickAdapter<RoomItem, BaseViewHolder> implements j {
    public final int H;
    public n I;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(List<RoomItem> dataList) {
        super(R$layout.adapter_hot_room, dataList);
        Intrinsics.g(dataList, "dataList");
        this.H = f0.a(20.0f);
        n nVarM = n.a().q(0, 20.0f).p(n.f81423m).m();
        Intrinsics.f(nVarM, "builder()\n        .setAl…el.PILL)\n        .build()");
        this.I = nVarM;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, RoomItem item) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        ShapeableImageView shapeableImageView = (ShapeableImageView) holder.getView(R$id.iv_cover);
        String avatar = item.getAvatar();
        if (avatar != null) {
            ImageHelper.Companion companion = ImageHelper.f51371a;
            companion.r(getContext(), shapeableImageView, avatar, (4088 & 8) != 0 ? companion.d() : f0.a(48.0f), (4088 & 16) != 0 ? companion.c() : f0.a(48.0f), (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
        }
        holder.setText(R$id.tv_name, item.getName());
        holder.setText(R$id.tv_desc, item.getDescription());
        int i11 = R$id.tv_focus_num;
        Long postCount = item.getPostCount();
        String string = postCount != null ? postCount.toString() : null;
        holder.setText(i11, string + getContext().getResources().getString(R$string.str_checkin));
        PileLayout pileLayout = (PileLayout) holder.getView(R$id.pl_member_ic);
        pileLayout.removeAllViews();
        List<String> memberAvatars = item.getMemberAvatars();
        int size = memberAvatars != null ? memberAvatars.size() : 0;
        for (int i12 = 0; i12 < size; i12++) {
            List<String> memberAvatars2 = item.getMemberAvatars();
            String str = memberAvatars2 != null ? memberAvatars2.get(i12) : null;
            ShapeableImageView shapeableImageView2 = new ShapeableImageView(getContext());
            shapeableImageView2.setStrokeWidth(com.transsion.baseui.util.a.f51450a.a(getContext(), 1.0f));
            shapeableImageView2.setStrokeColor(z2.a.getColorStateList(getContext(), R.color.white));
            shapeableImageView2.setShapeAppearanceModel(this.I);
            if (str != null) {
                ImageHelper.Companion companion2 = ImageHelper.f51371a;
                Context context = getContext();
                int i13 = R$drawable.ic_avatar_default;
                int i14 = this.H;
                companion2.o(context, shapeableImageView2, str, (32704 & 8) != 0 ? R$color.skeleton : i13, (32704 & 16) != 0 ? companion2.d() : i14, (32704 & 32) != 0 ? companion2.c() : i14, (32704 & 64) != 0 ? 0 : 0, (32704 & 128) != 0, (32704 & 256) != 0 ? "" : null, (32704 & 512) != 0, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
            }
            int i15 = this.H;
            pileLayout.addView(shapeableImageView2, i15, i15);
        }
        HashMap map = new HashMap();
        String groupId = item.getGroupId();
        if (groupId == null) {
            groupId = "";
        }
        map.put("group_id", groupId);
        map.put("sequence", String.valueOf(P(item)));
        com.transsion.baselib.helper.a.f51183a.a("rooms", map);
    }

    @Override // h9.j
    public /* synthetic */ f a(BaseQuickAdapter baseQuickAdapter) {
        return i.a(this, baseQuickAdapter);
    }
}
