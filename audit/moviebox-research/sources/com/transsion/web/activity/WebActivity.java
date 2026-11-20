package com.transsion.web.activity;

import android.content.Intent;
import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.transsion.baselib.utils.o;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.web.R$id;
import com.transsion.web.api.WebConstants;
import com.transsion.web.api.WebPageIdentity;
import com.transsion.web.fragment.WebFragmentV2;
import es.c;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import zz.a;

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
@Route(path = WebPageIdentity.WEB_VIEW)
@Metadata
public final class WebActivity extends BaseActivity<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Autowired(name = "url")
    @JvmField
    public String f60146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Autowired(name = WebConstants.FIELD_DEEPLINK)
    @JvmField
    public String f60147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Autowired(name = WebConstants.FIELD_LOAD_URL_ONLY)
    @JvmField
    public boolean f60148c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Autowired(name = WebConstants.PAGE_FROM)
    @JvmField
    public String f60149d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f60150f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WebFragmentV2 f60151g;

    private final void initView() {
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public a getViewBinding() {
        a aVarC = a.c(getLayoutInflater());
        Intrinsics.f(aVarC, "inflate(layoutInflater)");
        return aVarC;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isChangeStatusBar() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return !o.f51321a.a();
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a00.a.f355a.a();
        com.alibaba.android.arouter.launcher.a.d().f(this);
        if (bundle == null) {
            this.f60151g = WebFragmentV2.f60174r.b();
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable(WebConstants.FIELD_ITEM, getIntent().getParcelableExtra(WebConstants.FIELD_ITEM));
            bundle2.putString("url", this.f60146a);
            bundle2.putString(WebConstants.FIELD_DEEPLINK, this.f60147b);
            bundle2.putBoolean(WebConstants.FIELD_LOAD_URL_ONLY, this.f60148c);
            bundle2.putString(WebConstants.PAGE_FROM, getIntent().getStringExtra(WebConstants.PAGE_FROM));
            WebFragmentV2 webFragmentV2 = this.f60151g;
            if (webFragmentV2 != null) {
                webFragmentV2.setArguments(bundle2);
            }
            WebFragmentV2 webFragmentV3 = this.f60151g;
            if (webFragmentV3 != null) {
                getSupportFragmentManager().beginTransaction().replace(R$id.container, webFragmentV3).commitNow();
            }
        }
        initView();
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        c cVar;
        super.onDestroy();
        a00.a.f355a.b();
        if (!getIntent().getBooleanExtra("fromTask", false) || (cVar = (c) es.a.f64348a.a(c.class)) == null) {
            return;
        }
        cVar.b(System.currentTimeMillis() - this.f60150f);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        try {
            setIntent(intent);
            com.alibaba.android.arouter.launcher.a.d().f(this);
        } catch (Exception unused) {
        }
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a00.a.f355a.a();
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseMusicFloatActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a00.a.f355a.a();
        this.f60150f = System.currentTimeMillis();
    }

    @Override // com.transsion.baseui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        a00.a.f355a.a();
    }
}
