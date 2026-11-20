package com.transsion.commercialization.gameres.ps;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.tn.lib.util.networkinfo.f;
import com.tn.lib.widget.R$string;
import com.transsion.ad.ps.model.RecommendInfo;
import com.transsion.commercialization.gameres.GameResView;
import com.transsion.commercialization.pslink.PsLinkDownLoadButton;
import com.transsion.commercialization.pslink.PsLinkServiceHelper;
import com.transsion.memberapi.IMemberApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import so.c;

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
public final class PSGameResView extends GameResView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PSGameResView(Context context) {
        super(context);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PSGameResView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PSGameResView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
    }

    private final void b(ps.a aVar) {
        String str;
        PsLinkServiceHelper psLinkServiceHelper = PsLinkServiceHelper.f51717a;
        if (psLinkServiceHelper.k()) {
            psLinkServiceHelper.h();
        }
        RecommendInfo recommendInfoI = aVar.i();
        com.transsion.ad.ps.b bVar = com.transsion.ad.ps.b.f50555a;
        if (bVar.b(recommendInfoI != null ? recommendInfoI.getPackageName() : null)) {
            if (!bVar.n(recommendInfoI != null ? recommendInfoI.getPackageName() : null)) {
                bVar.a(recommendInfoI, true, "PSGame");
            }
            str = "open";
        } else if (!f.f49475a.e()) {
            zp.b.f82110a.d(R$string.no_network_toast);
            return;
        } else {
            bVar.a(recommendInfoI, true, "PSGame");
            c();
            str = "install";
        }
        qs.a.f74884a.e(aVar, getGamePageStyle(), str);
    }

    public static final void e(PSGameResView this$0, ps.a info, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(info, "$info");
        this$0.b(info);
    }

    public final void c() {
        ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).A0();
    }

    @Override // com.transsion.commercialization.gameres.GameResView
    public void setContent(final ps.a info) {
        Intrinsics.g(info, "info");
        super.setContent(info);
        PsLinkServiceHelper.f51717a.h();
        AppCompatTextView appCompatTextView = getViewBinding().f73413c;
        Intrinsics.f(appCompatTextView, "viewBinding.tvAhaBtn");
        c.h(appCompatTextView);
        PsLinkDownLoadButton psLinkDownLoadButton = getViewBinding().f73415f;
        Intrinsics.f(psLinkDownLoadButton, "viewBinding.tvPsBtn");
        c.k(psLinkDownLoadButton);
        PsLinkDownLoadButton psLinkDownLoadButton2 = getViewBinding().f73415f;
        Intrinsics.f(psLinkDownLoadButton2, "viewBinding.tvPsBtn");
        c.k(psLinkDownLoadButton2);
        RecommendInfo recommendInfoI = info.i();
        if (recommendInfoI != null) {
            getViewBinding().f73415f.setItemInfo(recommendInfoI);
        }
        getViewBinding().f73415f.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.commercialization.gameres.ps.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PSGameResView.e(this.f51686a, info, view);
            }
        });
    }
}
