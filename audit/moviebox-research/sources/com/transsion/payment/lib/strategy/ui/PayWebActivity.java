package com.transsion.payment.lib.strategy.ui;

import android.content.Intent;
import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.transsion.baselib.utils.o;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.payment.lib.R$id;
import com.transsion.web.api.WebConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PayWebActivity extends BaseActivity<cv.a> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f54082d = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f54083f = WebConstants.PAGE_FROM;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f54084g = "url";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Autowired(name = "url")
    @JvmField
    public String f54085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Autowired(name = WebConstants.PAGE_FROM)
    @JvmField
    public String f54086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PayWebFragment f54087c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return PayWebActivity.f54084g;
        }

        public final String b() {
            return PayWebActivity.f54083f;
        }
    }

    private final void initView() {
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public cv.a getViewBinding() {
        cv.a aVarC = cv.a.c(getLayoutInflater());
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

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        PayWebFragment payWebFragment = this.f54087c;
        if (payWebFragment == null || !payWebFragment.z0()) {
            super.onBackPressed();
        }
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.alibaba.android.arouter.launcher.a.d().f(this);
        if (bundle == null) {
            this.f54087c = PayWebFragment.f54088l.a();
            Bundle bundle2 = new Bundle();
            bundle2.putString(f54084g, this.f54085a);
            String str = f54083f;
            bundle2.putString(str, getIntent().getStringExtra(str));
            PayWebFragment payWebFragment = this.f54087c;
            if (payWebFragment != null) {
                payWebFragment.setArguments(bundle2);
            }
            PayWebFragment payWebFragment2 = this.f54087c;
            if (payWebFragment2 != null) {
                getSupportFragmentManager().beginTransaction().replace(R$id.container, payWebFragment2).commitNow();
            }
        }
        initView();
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        try {
            setIntent(intent);
            com.alibaba.android.arouter.launcher.a.d().f(this);
            PayWebFragment payWebFragment = this.f54087c;
            if (payWebFragment != null) {
                payWebFragment.newIntent(intent);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseMusicFloatActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // com.transsion.baseui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }
}
