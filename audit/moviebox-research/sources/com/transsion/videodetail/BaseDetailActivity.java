package com.transsion.videodetail;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.transsion.baseui.activity.BaseNewActivity;
import com.transsion.memberapi.IMemberApi;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import n6.a;

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
@Metadata
public abstract class BaseDetailActivity<T extends n6.a> extends BaseNewActivity<T> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Autowired
    @JvmField
    public String f59780i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Autowired
    @JvmField
    public String f59781j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Autowired(name = "autoDownload")
    @JvmField
    public boolean f59782k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Autowired(name = "autoPlay")
    @JvmField
    public boolean f59783l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Autowired(name = "resourceId")
    @JvmField
    public String f59784m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Autowired(name = "module_name")
    @JvmField
    public String f59785n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Autowired(name = "yy_preload_id")
    @JvmField
    public int f59786o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Autowired(name = "season")
    @JvmField
    public int f59787p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Autowired(name = "episode")
    @JvmField
    public int f59788q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Autowired(name = "is_music_liked_fragment")
    @JvmField
    public boolean f59789r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Autowired
    @JvmField
    public boolean f59790s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Fragment f59791t;

    public static final void r0() {
        ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).N0(0.0f);
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public String U() {
        return "";
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void X() {
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void Y() {
        e0();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void Z() {
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean a0() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean b0() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void c0() {
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isChangeStatusBar() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public boolean isMonitorNetworkState() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseMusicFloatActivity
    public boolean isMusicFloatingAttach() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isStatusDark() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.alibaba.android.arouter.launcher.a.d().f(this);
        super.onCreate(bundle);
    }

    public final Fragment p0() {
        return this.f59791t;
    }

    public final void q0(Fragment fragment) {
        this.f59791t = fragment;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void retryLoadData() {
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity, com.transsion.baseui.activity.BaseCommonActivity
    public void setView() {
        super.setView();
        getMViewBinding().getRoot().post(new Runnable() { // from class: com.transsion.videodetail.a
            @Override // java.lang.Runnable
            public final void run() {
                BaseDetailActivity.r0();
            }
        });
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public int statusColor() {
        return com.tn.lib.widget.R$color.black;
    }
}
