package com.transsion.room.activity;

import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.transsion.baselib.utils.o;
import com.transsion.baseui.activity.BaseNewActivity;
import com.transsion.room.R$id;
import com.transsion.room.fragment.RoomListMainFragment;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import sw.g;

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
@Route(path = "/room/list")
@Metadata
public final class RoomListActivity extends BaseNewActivity<g> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Autowired(name = "is_select_room")
    @JvmField
    public boolean f57110i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Autowired(name = "index")
    @JvmField
    public int f57111j;

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public String U() {
        return "";
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void X() {
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void Y() {
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

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public g getViewBinding() {
        g gVarC = g.c(getLayoutInflater());
        Intrinsics.f(gVarC, "inflate(layoutInflater)");
        return gVarC;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.alibaba.android.arouter.launcher.a.d().f(this);
        super.onCreate(bundle);
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().replace(R$id.fl_container, RoomListMainFragment.f57219g.a(this.f57110i, this.f57111j)).commitNowAllowingStateLoss();
        }
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void retryLoadData() {
    }
}
