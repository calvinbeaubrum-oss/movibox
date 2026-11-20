package com.transsion.room.activity;

import android.os.Bundle;
import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.tn.lib.view.TitleLayout;
import com.transsion.baselib.utils.o;
import com.transsion.baseui.activity.BaseNewActivity;
import com.transsion.room.R$id;
import com.transsion.room.fragment.RoomHomeFragment;
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
@Route(path = "/room/home")
@Metadata
public final class RoomHomeActivity extends BaseNewActivity<sw.f> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Autowired(name = "post_id")
    @JvmField
    public String f57108i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Autowired(name = "ops")
    @JvmField
    public String f57109j;

    public static final void q0(RoomHomeActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.finish();
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
        TitleLayout initViewData$lambda$1 = ((sw.f) getMViewBinding()).f76496c;
        initViewData$lambda$1.setBackVisible(true);
        initViewData$lambda$1.setLeftOnclick(new View.OnClickListener() { // from class: com.transsion.room.activity.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RoomHomeActivity.q0(this.f57117a, view);
            }
        });
        Intrinsics.f(initViewData$lambda$1, "initViewData$lambda$1");
        so.c.e(initViewData$lambda$1);
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

    @Override // com.transsion.baseui.activity.BaseNewActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.alibaba.android.arouter.launcher.a.d().f(this);
        super.onCreate(bundle);
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().replace(R$id.fl_container, RoomHomeFragment.C.a(this.f57108i, this.f57109j)).commitNow();
        }
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
    public sw.f getViewBinding() {
        sw.f fVarC = sw.f.c(getLayoutInflater());
        Intrinsics.f(fVarC, "inflate(layoutInflater)");
        return fVarC;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void retryLoadData() {
    }
}
