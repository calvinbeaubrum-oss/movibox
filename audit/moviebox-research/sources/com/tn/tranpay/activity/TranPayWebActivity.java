package com.tn.tranpay.activity;

import android.content.Intent;
import android.os.Bundle;
import com.tn.lib.tranpay.R$id;
import com.tn.lib.tranpay.R$layout;
import com.tn.tranpay.fragment.TranPayWebFragment;
import kotlin.Deprecated;
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
public final class TranPayWebActivity extends BaseActivity<np.a> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f50065i = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @JvmField
    public String f50066d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @JvmField
    public String f50067f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @JvmField
    public boolean f50068g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TranPayWebFragment f50069h;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.tn.tranpay.activity.BaseActivity
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public np.a getViewBinding() {
        np.a aVarC = np.a.c(getLayoutInflater());
        Intrinsics.f(aVarC, "inflate(layoutInflater)");
        return aVarC;
    }

    @Override // com.tn.tranpay.activity.BaseActivity
    public boolean isChangeStatusBar() {
        return true;
    }

    @Override // com.tn.tranpay.activity.BaseActivity
    public boolean isStatusDark() {
        return false;
    }

    @Override // com.tn.tranpay.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @Deprecated
    public void onBackPressed() {
        TranPayWebFragment tranPayWebFragment = this.f50069h;
        if (tranPayWebFragment == null || !tranPayWebFragment.H0()) {
            super.onBackPressed();
        }
    }

    @Override // com.tn.tranpay.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.tran_activity_web_pay);
        this.f50066d = getIntent().getStringExtra("url");
        this.f50067f = getIntent().getStringExtra("cpFrontPage");
        boolean booleanExtra = getIntent().getBooleanExtra("shouldOpenCpFrontPage", true);
        this.f50068g = booleanExtra;
        fq.a.g(fq.a.f65215a, "The url is " + this.f50066d + " and cpFrontPage is " + this.f50067f + " and shouldOpenCpFrontPage is " + booleanExtra, null, 2, null);
        if (bundle == null) {
            this.f50069h = TranPayWebFragment.f50145q.a();
            Bundle bundle2 = new Bundle();
            bundle2.putString("url", this.f50066d);
            bundle2.putString("cpFrontPage", this.f50067f);
            bundle2.putBoolean("shouldOpenCpFrontPage", this.f50068g);
            TranPayWebFragment tranPayWebFragment = this.f50069h;
            if (tranPayWebFragment != null) {
                tranPayWebFragment.setArguments(bundle2);
            }
            TranPayWebFragment tranPayWebFragment2 = this.f50069h;
            if (tranPayWebFragment2 != null) {
                getSupportFragmentManager().beginTransaction().replace(R$id.container, tranPayWebFragment2).commitNow();
            }
        }
    }

    @Override // com.tn.tranpay.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        try {
            setIntent(intent);
            TranPayWebFragment tranPayWebFragment = this.f50069h;
            if (tranPayWebFragment != null) {
                tranPayWebFragment.newIntent(intent);
            }
        } catch (Exception e11) {
            fq.a.e(fq.a.f65215a, e11.toString(), null, 2, null);
        }
    }

    @Override // com.tn.tranpay.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.tn.tranpay.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // com.tn.tranpay.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }
}
