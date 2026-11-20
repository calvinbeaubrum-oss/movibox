package com.transsnet.downloader.adapter;

import android.widget.ImageView;
import android.widget.TextView;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R$color;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.R$string;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class l extends BaseItemProvider<f00.b> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f60383f;

    public l() {
        String string = Utils.a().getString(R$string.available);
        Intrinsics.f(string, "getApp().getString(R.string.available)");
        this.f60383f = string;
    }

    private final void w(BaseViewHolder baseViewHolder, boolean z11) {
        ((ImageView) baseViewHolder.getView(R$id.iv_sdcard_check)).setSelected(z11);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return 3;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.item_download_res_path_sdcard;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, f00.b item) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        TextView textView = (TextView) helper.getView(R$id.tv_sd_title);
        String str = item.d() + item.c();
        Intrinsics.f(str, "toString(...)");
        textView.setText(str);
        int color = Utils.a().getResources().getColor(item.a() <= 0 ? R$color.error_50 : R$color.text_02);
        TextView textView2 = (TextView) helper.getView(R$id.tv_sd_size);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(item.a() <= 0 ? "0Mb" : tp.a.a(item.a(), 2));
        sb2.append(" ");
        sb2.append(this.f60383f);
        String string = sb2.toString();
        Intrinsics.f(string, "toString(...)");
        textView2.setText(string);
        textView2.setTextColor(color);
        ((ImageView) helper.getView(R$id.iv_sdcard_check)).setSelected(item.f());
        w(helper, item.f());
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, f00.b item, List<? extends Object> payloads) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        Intrinsics.g(payloads, "payloads");
        super.b(helper, item, payloads);
        if (payloads.isEmpty()) {
            return;
        }
        Object obj = payloads.get(payloads.size() - 1);
        if (obj instanceof Boolean) {
            w(helper, ((Boolean) obj).booleanValue());
        }
    }
}
