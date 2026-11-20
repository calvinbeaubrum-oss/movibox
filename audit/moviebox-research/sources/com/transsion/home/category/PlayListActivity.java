package com.transsion.home.category;

import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.immersionbar.ImmersionBar;
import com.transsion.baselib.utils.o;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.home.R$id;
import com.transsion.home.category.fragment.PlayListFragment;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import lt.d;

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
@Route(path = "/home/playlist")
@Metadata
public final class PlayListActivity extends BaseActivity<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Autowired(name = "category")
    @JvmField
    public String f52336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Autowired(name = "label")
    @JvmField
    public String f52337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Autowired(name = "recType")
    @JvmField
    public String f52338c;

    public final void M(boolean z11) {
        ImmersionBar immersionBarWith = ImmersionBar.with(this);
        boolean z12 = false;
        if (z11 && !o.f51321a.a()) {
            z12 = true;
        }
        immersionBarWith.statusBarDarkFont(z12).init();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public d getViewBinding() {
        d dVarC = d.c(getLayoutInflater());
        Intrinsics.f(dVarC, "inflate(layoutInflater)");
        return dVarC;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public void initView(Bundle bundle) {
        super.initView(bundle);
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().replace(R$id.container, PlayListFragment.f52349v.a(getIntent().getStringExtra("label"), getIntent().getStringExtra("category"), getIntent().getStringExtra("recType"), getIntent().getStringExtra("topIds"), getIntent().getIntExtra("tabId", 0))).commitNow();
        }
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isChangeStatusBar() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }
}
