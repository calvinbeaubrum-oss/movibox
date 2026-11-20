package com.transsion.postdetail.shorttv;

import android.widget.FrameLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.transsion.baseui.activity.BaseNewActivity;
import com.transsion.postdetail.R$id;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Route(path = "/shorts/favorite")
@Metadata
@SourceDebugExtension
public final class ShortTVFavoriteActivity extends BaseNewActivity<tv.c> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f55330i = new a();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends androidx.activity.p {
        public a() {
            super(true);
        }

        @Override // androidx.activity.p
        public void handleOnBackPressed() {
            uo.b.a.g(uo.b.f78622a, "ShortTVFavoriteActivity --> onBackPress --> handleOnBackPressed() --> setResult(RESULT_OK)", false, 2, null);
            ShortTVFavoriteActivity.this.finish();
        }
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
        FrameLayout root = ((tv.c) getMViewBinding()).getRoot();
        Intrinsics.f(root, "mViewBinding.root");
        so.c.e(root);
        e0();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void Z() {
        getOnBackPressedDispatcher().i(this, this.f55330i);
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean b0() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void c0() {
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void d0() {
        super.d0();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.f(supportFragmentManager, "supportFragmentManager");
        FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.f(fragmentTransactionBeginTransaction, "beginTransaction()");
        fragmentTransactionBeginTransaction.replace(R$id.flContent, new ShortTVFavoriteFragment(), "ShortTVFavoriteFragment");
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public tv.c getViewBinding() {
        tv.c cVarC = tv.c.c(getLayoutInflater());
        Intrinsics.f(cVarC, "inflate(layoutInflater)");
        return cVarC;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void retryLoadData() {
    }
}
