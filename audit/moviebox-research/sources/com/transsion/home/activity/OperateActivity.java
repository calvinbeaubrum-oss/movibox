package com.transsion.home.activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.f0;
import com.blankj.utilcode.util.h;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.home.R$id;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.home.preload.MainXMLPreloadControlImp;
import com.transsion.home.preload.a;
import com.transsion.home.preload.b;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import lt.c;
import tp.f;

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
@Route(path = "/home/operatePage")
@Metadata
public final class OperateActivity extends BaseActivity<c> implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Autowired(name = "tabId")
    @JvmField
    public int f51994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Autowired(name = "tabCode")
    @JvmField
    public String f51995b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Autowired(name = CampaignEx.JSON_KEY_TITLE)
    @JvmField
    public String f51996c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f51997d;

    public final int M() {
        f fVar = f.f77260a;
        Context applicationContext = getApplicationContext();
        Intrinsics.f(applicationContext, "applicationContext");
        return fVar.d(applicationContext) + f0.a(44.0f);
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public c getViewBinding() {
        com.alibaba.android.arouter.launcher.a.d().f(this);
        c cVarC = c.c(getLayoutInflater());
        Intrinsics.f(cVarC, "inflate(layoutInflater)");
        return cVarC;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Q() {
        TitleLayout titleLayout = ((c) getMViewBinding()).f70401c;
        titleLayout.setTitleText(this.f51996c);
        f fVar = f.f77260a;
        Context context = titleLayout.getContext();
        Intrinsics.f(context, "context");
        titleLayout.setPadding(0, fVar.d(context), 0, 0);
        titleLayout.setBackgroundColor(h.a(R$color.transparent));
        titleLayout.setViewLineVisible(false);
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public String getPageName() {
        return SubTabFragment.f52541r.a(this.f51994a);
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public void initView(Bundle bundle) {
        Q();
        getSupportFragmentManager().beginTransaction().replace(R$id.operate_page_container, SubTabFragment.f52541r.b(this.f51994a, this.f51995b)).commitAllowingStateLoss();
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        b bVar = this.f51997d;
        if (bVar != null) {
            bVar.reset();
        }
        this.f51997d = null;
    }

    @Override // com.transsion.home.preload.a
    public b r() {
        if (this.f51997d == null && Build.VERSION.SDK_INT > 28) {
            this.f51997d = new MainXMLPreloadControlImp(this);
        }
        return this.f51997d;
    }
}
