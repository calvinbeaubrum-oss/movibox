package com.transsion.home.adapter.suboperate.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.blankj.utilcode.util.d0;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$string;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.R$mipmap;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.FilterItem;
import com.transsion.moviedetailapi.bean.OperateItem;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
public final class SubFilterAdapter extends BaseQuickAdapter<FilterItem, BaseViewHolder> {
    public final Integer H;
    public final OperateItem I;
    public final int J;
    public final int K;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubFilterAdapter(int i11, Integer num, OperateItem operateItem, boolean z11) {
        super(i11, null, 2, null);
        Intrinsics.g(operateItem, "operateItem");
        this.H = num;
        this.I = operateItem;
        int i12 = z11 ? 6 : 3;
        int iA = f0.a(((((f0.b(Math.min(d0.e(), d0.c())) - 12) - (i12 * 8)) - 12) * 1.0f) / i12);
        this.J = iA;
        this.K = (int) (((double) iA) * 0.46d);
    }

    public /* synthetic */ SubFilterAdapter(int i11, Integer num, OperateItem operateItem, boolean z11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? R$layout.item_sub_operation_filter_item : i11, num, operateItem, z11);
    }

    public static final void I0(FilterItem item, SubFilterAdapter this$0, View view) {
        Intrinsics.g(item, "$item");
        Intrinsics.g(this$0, "this$0");
        Uri uriD = com.transsion.baselib.helper.b.f51184a.d(Uri.parse(item.getDeepLink()));
        if (uriD != null) {
            com.alibaba.android.arouter.launcher.a.d().a(uriD).navigation();
        }
        this$0.K0(item, this$0.D().indexOf(item));
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, final FilterItem item) {
        String thumbnail;
        String url;
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        TextView textView = (TextView) holder.getView(R$id.sub_operation_filter_title);
        if (item.isAll()) {
            textView.setText(getContext().getString(R$string.all));
            so.c.k(holder.getView(R$id.sub_operation_filter_add_icon));
            ((ImageView) holder.getView(R$id.sub_operation_filter_icon)).setImageResource(R$mipmap.bg_op_filter_all);
        } else {
            String title = item.getTitle();
            if (title == null) {
                title = "";
            }
            textView.setText(title);
            textView.setTextColor(com.blankj.utilcode.util.h.a(R$color.white_80));
            so.c.g(holder.getView(R$id.sub_operation_filter_add_icon));
            ImageView imageView = (ImageView) holder.getView(R$id.sub_operation_filter_icon);
            if (item.getBuiltIn()) {
                kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new SubFilterAdapter$convert$1(item, imageView, null), 3, null);
            } else {
                ImageHelper.Companion companion = ImageHelper.f51371a;
                Context context = getContext();
                Cover image = item.getImage();
                String str = (image == null || (url = image.getUrl()) == null) ? "" : url;
                int i11 = this.J;
                Cover image2 = item.getImage();
                companion.q(context, imageView, str, (8120 & 8) != 0 ? companion.d() : i11, (8120 & 16) != 0 ? companion.c() : 0, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : (image2 == null || (thumbnail = image2.getThumbnail()) == null) ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
            }
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.adapter.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubFilterAdapter.I0(item, this, view);
            }
        });
        J0(item, D().indexOf(item));
    }

    public final void J0(FilterItem filterItem, int i11) {
        String title;
        HashMap map = new HashMap();
        map.put("event_type", "browse_filter");
        if (filterItem == null || (title = filterItem.getTitle()) == null) {
            title = "";
        }
        map.put(CampaignEx.JSON_KEY_TITLE, title);
        map.put("sequence", String.valueOf(i11));
        map.put("tabId", String.valueOf(this.H));
        ot.b.a(this.I, map);
        com.transsion.baselib.helper.a aVar = com.transsion.baselib.helper.a.f51183a;
        SubTabFragment.a aVar2 = SubTabFragment.f52541r;
        Integer num = this.H;
        aVar.d(aVar2.a(num != null ? num.intValue() : 1), map);
    }

    public final void K0(FilterItem filterItem, int i11) {
        String title;
        HashMap map = new HashMap();
        map.put("event_type", "click_filter");
        if (filterItem == null || (title = filterItem.getTitle()) == null) {
            title = "";
        }
        map.put(CampaignEx.JSON_KEY_TITLE, title);
        map.put("sequence", String.valueOf(i11));
        map.put("tabId", String.valueOf(this.H));
        ot.b.a(this.I, map);
        com.transsion.baselib.helper.a aVar = com.transsion.baselib.helper.a.f51183a;
        SubTabFragment.a aVar2 = SubTabFragment.f52541r;
        Integer num = this.H;
        aVar.e(aVar2.a(num != null ? num.intValue() : 1), map);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: g0 */
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        BaseViewHolder baseViewHolderOnCreateViewHolder = super.onCreateViewHolder(parent, i11);
        baseViewHolderOnCreateViewHolder.itemView.getLayoutParams().width = this.J;
        baseViewHolderOnCreateViewHolder.itemView.getLayoutParams().height = this.K;
        return baseViewHolderOnCreateViewHolder;
    }
}
