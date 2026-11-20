package com.transsion.room.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.noober.background.view.BLFrameLayout;
import com.noober.background.view.BLTextView;
import com.transsion.moviedetailapi.bean.RoomFilter;
import com.transsion.room.R$layout;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import sw.r;

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
public final class RoomFilterTabListAdapter extends BaseQuickAdapter<RoomFilter, FilterTabListItemVH> {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class FilterTabListItemVH extends BaseViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final r f57124b;

        /* JADX WARN: Illegal instructions before constructor call */
        public FilterTabListItemVH(r viewBinding) {
            Intrinsics.g(viewBinding, "viewBinding");
            BLFrameLayout root = viewBinding.getRoot();
            Intrinsics.f(root, "viewBinding.root");
            super(root);
            this.f57124b = viewBinding;
        }

        public final r e() {
            return this.f57124b;
        }
    }

    public RoomFilterTabListAdapter() {
        super(R$layout.item_room_list_tab, null, 2, null);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(FilterTabListItemVH holder, RoomFilter item) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        holder.e().f76600c.setText(item.getTitle());
        J0(holder, item.isSelected());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public void y(FilterTabListItemVH holder, RoomFilter item, List<? extends Object> payloads) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        Intrinsics.g(payloads, "payloads");
        super.y(holder, item, payloads);
        if (payloads.isEmpty()) {
            return;
        }
        Object objR0 = CollectionsKt___CollectionsKt.r0(payloads);
        if (objR0 instanceof Boolean) {
            J0(holder, ((Boolean) objR0).booleanValue());
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: I0, reason: merged with bridge method [inline-methods] */
    public FilterTabListItemVH f0(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        r rVarC = r.c(LayoutInflater.from(getContext()), parent, false);
        Intrinsics.f(rVarC, "inflate(LayoutInflater.f…(context), parent, false)");
        return new FilterTabListItemVH(rVarC);
    }

    public final void J0(FilterTabListItemVH filterTabListItemVH, boolean z11) {
        Typeface typefaceD;
        filterTabListItemVH.e().f76599b.setSelected(z11);
        filterTabListItemVH.e().f76600c.setSelected(z11);
        View view = filterTabListItemVH.e().f76601d;
        Intrinsics.f(view, "holder.viewBinding.vSelected");
        view.setVisibility(z11 ? 0 : 8);
        BLTextView bLTextView = filterTabListItemVH.e().f76600c;
        if (z11) {
            Context context = filterTabListItemVH.itemView.getContext();
            Intrinsics.f(context, "holder.itemView.context");
            typefaceD = so.a.c(context);
        } else {
            Context context2 = filterTabListItemVH.itemView.getContext();
            Intrinsics.f(context2, "holder.itemView.context");
            typefaceD = so.a.d(context2);
        }
        bLTextView.setTypeface(typefaceD);
    }
}
