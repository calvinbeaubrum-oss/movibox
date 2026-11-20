package com.transsion.banner.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.TnTextView;
import com.transsion.banner.R$id;
import com.transsion.banner.R$layout;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.R$mipmap;
import com.transsion.moviedetailapi.bean.Staff;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
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
public final class StaffAdapter extends BaseQuickAdapter<Staff, BaseViewHolder> {
    public final boolean H;
    public final Pair<Integer, Integer> I;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaffAdapter(List<Staff> datas, boolean z11) {
        super(R$layout.item_staff, datas);
        Intrinsics.g(datas, "datas");
        this.H = z11;
        this.I = tp.f.f77260a.b();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, Staff item) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        ConstraintLayout constraintLayout = (ConstraintLayout) holder.getViewOrNull(R$id.item_root);
        if (constraintLayout != null) {
            ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
            layoutParams.width = this.I.getFirst().intValue();
            layoutParams.height = -2;
            constraintLayout.setLayoutParams(layoutParams);
        }
        TnTextView tnTextView = (TnTextView) holder.getViewOrNull(R$id.tv_title);
        if (tnTextView != null) {
            tnTextView.setTextWithString(item.getName());
        }
        ShapeableImageView shapeableImageView = (ShapeableImageView) holder.getViewOrNull(R$id.iv_cover);
        if (shapeableImageView != null) {
            ViewGroup.LayoutParams layoutParams2 = shapeableImageView.getLayoutParams();
            layoutParams2.width = -1;
            layoutParams2.height = this.I.getSecond().intValue();
            shapeableImageView.setLayoutParams(layoutParams2);
            if (this.H) {
                j.d(l0.a(w0.c()), null, null, new StaffAdapter$convert$3$1(item, shapeableImageView, null), 3, null);
                return;
            }
            int i11 = R$mipmap.movie_staff_default_avatar;
            String avatarUrl = item.getAvatarUrl();
            if (avatarUrl == null || avatarUrl.length() == 0) {
                shapeableImageView.setImageResource(i11);
                return;
            }
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Context context = shapeableImageView.getContext();
            Intrinsics.f(context, "context");
            String avatarUrl2 = item.getAvatarUrl();
            if (avatarUrl2 == null) {
                avatarUrl2 = "";
            }
            companion.o(context, shapeableImageView, avatarUrl2, (32704 & 8) != 0 ? R$color.skeleton : i11, (32704 & 16) != 0 ? companion.d() : this.I.getFirst().intValue(), (32704 & 32) != 0 ? companion.c() : this.I.getSecond().intValue(), (32704 & 64) != 0 ? 0 : 0, (32704 & 128) != 0, (32704 & 256) != 0 ? "" : null, (32704 & 512) != 0, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
        }
    }
}
