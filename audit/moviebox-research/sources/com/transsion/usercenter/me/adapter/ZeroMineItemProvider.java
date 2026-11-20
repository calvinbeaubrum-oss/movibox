package com.transsion.usercenter.me.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$mipmap;
import com.transsion.baselib.utils.i;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.profile.bean.ButtonInfo;
import com.transsion.usercenter.profile.bean.MeItemInfo;
import com.transsion.usercenter.profile.bean.ZeroInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class ZeroMineItemProvider extends BaseItemProvider<MeItemInfo> {
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return 3;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.mine_item_vip_layout;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, MeItemInfo item) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        Object data = item.getData();
        ZeroInfo zeroInfo = data instanceof ZeroInfo ? (ZeroInfo) data : null;
        if (zeroInfo == null) {
            return;
        }
        final ButtonInfo button = zeroInfo.getButton();
        View view = helper.itemView;
        Intrinsics.f(view, "helper.itemView");
        so.c.c(view, 0L, new Function1<View, Unit>() { // from class: com.transsion.usercenter.me.adapter.ZeroMineItemProvider$convert$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                invoke2(view2);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                String link;
                Intrinsics.g(it, "it");
                ButtonInfo buttonInfo = button;
                if (buttonInfo != null && (link = buttonInfo.getLink()) != null) {
                    i.e(link, null, 1, null);
                }
                com.transsion.usercenter.me.b.f59452a.b("free_buy");
            }
        }, 1, null);
        ((TextView) helper.getView(R$id.titleTv)).setText(zeroInfo.getTitle());
        TextView textView = (TextView) helper.getView(R$id.desTv);
        textView.setText(zeroInfo.getSubtitle());
        String subtitle = zeroInfo.getSubtitle();
        textView.setVisibility((subtitle == null || subtitle.length() == 0) ^ true ? 0 : 8);
        ImageHelper.f51371a.g(g(), (ImageView) helper.getView(R$id.icIV), zeroInfo.getIconUrl(), (112 & 8) != 0 ? R$color.cl37 : R$mipmap.ic_point_purchase, (112 & 16) != 0 ? 0 : 0, (112 & 32) != 0 ? -1 : 0, (112 & 64) != 0 ? -1 : 0);
        TextView textView2 = (TextView) helper.getView(R$id.btnTv);
        View view2 = helper.getView(R$id.arrowIV);
        textView2.setVisibility(8);
        view2.setVisibility(8);
        if (zeroInfo.getShowButton()) {
            String type = button != null ? button.getType() : null;
            if (Intrinsics.b(type, "TEXT")) {
                textView2.setText(button.getText());
                textView2.setVisibility(0);
            } else if (Intrinsics.b(type, "ARROW")) {
                view2.setVisibility(0);
            }
        }
    }
}
