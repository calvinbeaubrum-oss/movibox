package jz;

import android.view.View;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.TnTextView;
import com.transsion.baseui.widget.text.GradientTextView;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import kotlin.Metadata;
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
public final class e extends BaseItemProvider<kz.b> {
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return 1;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.user_item_setting;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, kz.b item) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        ((TnTextView) helper.getView(R$id.tv_title)).setTextById(item.h());
        helper.setText(R$id.tv_content, item.b()).setGone(R$id.progress_bar, !item.c()).setGone(R$id.tv_content, item.c());
        View viewOrNull = helper.getViewOrNull(R$id.divider);
        if (viewOrNull != null) {
            so.c.j(viewOrNull, item.d());
        }
        View viewOrNull2 = helper.getViewOrNull(R$id.bgView);
        if (viewOrNull2 != null) {
            Integer numA = item.a();
            viewOrNull2.setBackgroundResource(numA != null ? numA.intValue() : 0);
        }
        GradientTextView gradientTextView = (GradientTextView) helper.getView(R$id.tv_tips);
        gradientTextView.setEnableGradientColor(item.g());
        gradientTextView.setTextColor(g().getResources().getColor(R$color.white_60));
        String strF = item.f();
        if (strF == null) {
            strF = "";
        }
        gradientTextView.setText(strF);
        String strF2 = item.f();
        gradientTextView.setVisibility(strF2 != null && strF2.length() > 0 ? 0 : 8);
    }
}
