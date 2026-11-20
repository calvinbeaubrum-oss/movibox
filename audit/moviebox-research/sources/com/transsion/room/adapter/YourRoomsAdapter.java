package com.transsion.room.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLTextView;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.bean.RoomItem;
import com.transsion.room.R$layout;
import com.transsion.room.R$string;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import sw.s;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class YourRoomsAdapter extends BaseQuickAdapter<RoomItem, YourRoomsItemVH> {
    public final int H;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class YourRoomsItemVH extends BaseViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final s f57127b;

        /* JADX WARN: Illegal instructions before constructor call */
        public YourRoomsItemVH(s viewBinding) {
            Intrinsics.g(viewBinding, "viewBinding");
            ConstraintLayout root = viewBinding.getRoot();
            Intrinsics.f(root, "viewBinding.root");
            super(root);
            this.f57127b = viewBinding;
        }

        public final s e() {
            return this.f57127b;
        }
    }

    public YourRoomsAdapter() {
        super(R$layout.item_your_rooms, null, 2, null);
        this.H = f0.a(78.0f);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(YourRoomsItemVH holder, RoomItem item) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        String avatar = item.getAvatar();
        if (avatar != null) {
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Context context = getContext();
            ShapeableImageView shapeableImageView = holder.e().f76603b;
            Intrinsics.f(shapeableImageView, "holder.viewBinding.ivCover");
            int i11 = this.H;
            companion.r(context, shapeableImageView, avatar, (4088 & 8) != 0 ? companion.d() : i11, (4088 & 16) != 0 ? companion.c() : i11, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
        }
        holder.e().f76604c.setText(item.getName());
        Long newPostCount = item.getNewPostCount();
        J0(holder, newPostCount != null ? newPostCount.longValue() : 0L);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public void y(YourRoomsItemVH holder, RoomItem item, List<? extends Object> payloads) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        Intrinsics.g(payloads, "payloads");
        super.y(holder, item, payloads);
        if (payloads.isEmpty()) {
            return;
        }
        Object objR0 = CollectionsKt___CollectionsKt.r0(payloads);
        if (objR0 instanceof Long) {
            J0(holder, ((Number) objR0).longValue());
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: I0, reason: merged with bridge method [inline-methods] */
    public YourRoomsItemVH f0(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        s sVarC = s.c(LayoutInflater.from(getContext()), parent, false);
        Intrinsics.f(sVarC, "inflate(LayoutInflater.f…(context), parent, false)");
        return new YourRoomsItemVH(sVarC);
    }

    public final void J0(YourRoomsItemVH yourRoomsItemVH, long j11) {
        BLTextView bLTextView = yourRoomsItemVH.e().f76605d;
        Intrinsics.f(bLTextView, "holder.viewBinding.tvNewCount");
        bLTextView.setVisibility((j11 > 0L ? 1 : (j11 == 0L ? 0 : -1)) > 0 ? 0 : 8);
        yourRoomsItemVH.e().f76605d.setText(Utils.a().getString(R$string.x_new, j11 > 99 ? "99+" : String.valueOf(j11)));
    }
}
