package com.transsion.home.activity;

import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.transsion.baselib.utils.o;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.home.R$id;
import com.transsion.home.fragment.RankAllFragment;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import lt.a;

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
@Route(path = "/rank/all")
@Metadata
public final class RankAllActivity extends BaseActivity<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Autowired(name = "category")
    @JvmField
    public String f51998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Autowired(name = "tabId")
    @JvmField
    public int f51999b;

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public a getViewBinding() {
        com.alibaba.android.arouter.launcher.a.d().f(this);
        a aVarC = a.c(getLayoutInflater());
        Intrinsics.f(aVarC, "inflate(layoutInflater)");
        return aVarC;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public void initView(Bundle bundle) {
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().replace(R$id.container, RankAllFragment.f52425g.a(this.f51998a, Integer.valueOf(this.f51999b))).commitNow();
        }
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return !o.f51321a.a();
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }
}
