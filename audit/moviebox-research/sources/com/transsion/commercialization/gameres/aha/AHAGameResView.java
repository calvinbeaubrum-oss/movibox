package com.transsion.commercialization.gameres.aha;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.commercialization.gameres.GameResView;
import com.transsion.commercialization.pslink.PsLinkDownLoadButton;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class AHAGameResView extends GameResView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AHAGameResView(Context context) {
        super(context);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AHAGameResView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AHAGameResView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
    }

    public static final void c(AHAGameResView this$0, ps.a info, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(info, "$info");
        this$0.b(info);
    }

    public final void b(ps.a aVar) {
        String strA;
        c cVarA = aVar.a();
        if (cVarA == null || (strA = cVarA.a()) == null) {
            return;
        }
        qs.a.f74884a.d(aVar, getGamePageStyle());
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(strA));
        getContext().startActivity(intent);
    }

    @Override // com.transsion.commercialization.gameres.GameResView
    public void setContent(final ps.a info) {
        Intrinsics.g(info, "info");
        super.setContent(info);
        PsLinkDownLoadButton psLinkDownLoadButton = getViewBinding().f73415f;
        Intrinsics.f(psLinkDownLoadButton, "viewBinding.tvPsBtn");
        so.c.h(psLinkDownLoadButton);
        AppCompatTextView appCompatTextView = getViewBinding().f73413c;
        Intrinsics.f(appCompatTextView, "viewBinding.tvAhaBtn");
        so.c.k(appCompatTextView);
        getViewBinding().f73413c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.commercialization.gameres.aha.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AHAGameResView.c(this.f51678a, info, view);
            }
        });
    }
}
