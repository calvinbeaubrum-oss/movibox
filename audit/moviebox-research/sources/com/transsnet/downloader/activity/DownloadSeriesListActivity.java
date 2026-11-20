package com.transsnet.downloader.activity;

import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.R$color;
import com.transsion.baselib.utils.o;
import com.transsion.baseui.activity.BaseActivity;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.fragment.DownloadEpisodesListFragment;
import h00.c;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
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
/* JADX INFO: loaded from: classes8.dex */
@Route(path = "/download/series_list")
@Metadata
public final class DownloadSeriesListActivity extends BaseActivity<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Autowired(name = "extra_name")
    @JvmField
    public String f60294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Autowired(name = "extra_subject_id")
    @JvmField
    public String f60295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Autowired(name = "extra_parent_position")
    @JvmField
    public int f60296c = -1;

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public c getViewBinding() {
        c cVarC = c.c(getLayoutInflater());
        Intrinsics.f(cVarC, "inflate(layoutInflater)");
        return cVarC;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isChangeStatusBar() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return !o.f51321a.a();
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.alibaba.android.arouter.launcher.a.d().f(this);
        super.onCreate(bundle);
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().replace(R$id.container, DownloadEpisodesListFragment.f60636w.a(this.f60295b, this.f60296c)).commitNow();
        }
        TitleLayout titleLayout = ((c) getMViewBinding()).f65752c;
        String str = this.f60294a;
        if (str == null) {
            str = "";
        }
        titleLayout.setTitleText(str);
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public int statusColor() {
        return R$color.text_01;
    }
}
