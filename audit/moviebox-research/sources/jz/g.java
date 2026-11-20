package jz;

import android.view.View;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.view.SwitchButton;
import com.tn.lib.widget.TnTextView;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import java.util.List;
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
public final class g extends BaseItemProvider<kz.b> {
    public static final void x(BaseViewHolder helper, View view) {
        Intrinsics.g(helper, "$helper");
        helper.getView(R$id.llRoot).performClick();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return 3;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.user_item_switch_setting;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public void a(final BaseViewHolder helper, kz.b item) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        ((TnTextView) helper.getView(R$id.tvTitle)).setTextById(item.h());
        TnTextView tnTextView = (TnTextView) helper.getView(R$id.tvDes);
        String strB = item.b();
        tnTextView.setVisibility((strB == null || strB.length() == 0) ^ true ? 0 : 8);
        if (tnTextView.getVisibility() == 0) {
            tnTextView.setText(item.b());
        }
        helper.getView(R$id.divider).setVisibility(item.d() ? 0 : 8);
        SwitchButton switchButton = (SwitchButton) helper.getView(R$id.switchBtn);
        switchButton.setOnClickListener(new View.OnClickListener() { // from class: jz.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.x(helper, view);
            }
        });
        switchButton.setChecked(item.e());
        View viewOrNull = helper.getViewOrNull(R$id.bgView);
        if (viewOrNull != null) {
            Integer numA = item.a();
            viewOrNull.setBackgroundResource(numA != null ? numA.intValue() : 0);
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, kz.b item, List<? extends Object> payloads) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        Intrinsics.g(payloads, "payloads");
        super.b(helper, item, payloads);
        SwitchButton switchButton = (SwitchButton) helper.getViewOrNull(R$id.switchBtn);
        if (switchButton != null) {
            switchButton.setChecked(item.e());
        }
    }
}
