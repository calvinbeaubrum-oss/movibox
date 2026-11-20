package com.transsion.usercenter.profile;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.transsion.baseui.activity.BaseNewActivity;
import com.transsion.usercenter.R$id;
import com.transsnet.loginapi.bean.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import xy.f0;

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
/* JADX INFO: loaded from: classes8.dex */
@Route(path = "/profile/user_center")
@Metadata
@SourceDebugExtension
public final class ProfileActivity extends BaseNewActivity<f0> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f59512l = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Autowired
    @JvmField
    public UserInfo f59513i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Autowired
    @JvmField
    public String f59514j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Fragment f59515k;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(UserInfo userInfo) {
            Intrinsics.g(userInfo, "userInfo");
            com.alibaba.android.arouter.launcher.a.d().b("/profile/user_center").withSerializable("userInfo", userInfo).navigation();
        }

        public final void b(String str) {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserId(str);
            a(userInfo);
        }
    }

    private final void o0() {
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag("profile_fragment_tag");
        this.f59515k = fragmentFindFragmentByTag instanceof ProfileFragment ? (ProfileFragment) fragmentFindFragmentByTag : ProfileFragment.f59516v.a(this.f59514j, this.f59513i);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.f(supportFragmentManager, "supportFragmentManager");
        FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.f(fragmentTransactionBeginTransaction, "beginTransaction()");
        Fragment fragment = this.f59515k;
        if (fragment != null) {
            fragmentTransactionBeginTransaction.replace(R$id.f59293fl, fragment, "profile_fragment_tag");
        }
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
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
    public boolean b0() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void c0() {
        o0();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public String getPageName() {
        return "profiledetail";
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

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        com.alibaba.android.arouter.launcher.a.d().f(this);
        o0();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
    public f0 getViewBinding() {
        f0 f0VarC = f0.c(getLayoutInflater());
        Intrinsics.f(f0VarC, "inflate(layoutInflater)");
        return f0VarC;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void retryLoadData() {
        i0();
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            k0();
        } else {
            g0();
            c0();
        }
    }
}
