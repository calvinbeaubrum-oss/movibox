package com.transsnet.downloader.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.R$mipmap;
import com.transsion.baselib.utils.o;
import com.transsion.baseui.activity.BaseNewActivity;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.dialog.TransferGuideDialog;
import com.transsnet.downloader.fragment.TransferMainFragment;
import h00.d;
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
/* JADX INFO: loaded from: classes8.dex */
@Route(path = "/download/transfer")
@Metadata
public final class TransferActivity extends BaseNewActivity<d> {
    public static final void r0(TransferActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.finish();
    }

    public static final void s0(TransferActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        TransferGuideDialog.f60564g.b().j0(this$0, "TransferGuideDialog");
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public String U() {
        return "";
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void X() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void Y() {
        TitleLayout initViewData$lambda$2 = ((d) getMViewBinding()).f65781c;
        initViewData$lambda$2.setBackVisible(true);
        initViewData$lambda$2.setLeftOnclick(new View.OnClickListener() { // from class: com.transsnet.downloader.activity.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TransferActivity.r0(this.f60297a, view);
            }
        });
        initViewData$lambda$2.setRightView(R$mipmap.ic_transfer_tips_hint);
        ImageView rightImageView = initViewData$lambda$2.getRightImageView();
        if (rightImageView != null) {
            rightImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.activity.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TransferActivity.s0(this.f60298a, view);
                }
            });
        }
        Intrinsics.f(initViewData$lambda$2, "initViewData$lambda$2");
        c.e(initViewData$lambda$2);
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void Z() {
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean a0() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean b0() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void c0() {
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isStatusDark() {
        return !o.f51321a.a();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.alibaba.android.arouter.launcher.a.d().f(this);
        super.onCreate(bundle);
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().replace(R$id.fl_container, TransferMainFragment.f60864l.a()).commitNowAllowingStateLoss();
        }
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
    public d getViewBinding() {
        d dVarC = d.c(getLayoutInflater());
        Intrinsics.f(dVarC, "inflate(layoutInflater)");
        return dVarC;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void retryLoadData() {
    }
}
