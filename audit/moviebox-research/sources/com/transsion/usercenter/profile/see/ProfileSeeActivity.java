package com.transsion.usercenter.profile.see;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.a;
import com.tn.lib.util.networkinfo.f;
import com.transsion.baselib.utils.o;
import com.transsion.baseui.activity.BaseNewActivity;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$string;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import xy.g0;

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
@Route(path = "/profile/see")
@Metadata
@SourceDebugExtension
public final class ProfileSeeActivity extends BaseNewActivity<g0> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f59611m = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Autowired(name = "userId")
    @JvmField
    public String f59612i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f59613j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f59614k = LazyKt__LazyJVMKt.b(new Function0<ILoginApi>() { // from class: com.transsion.usercenter.profile.see.ProfileSeeActivity$mLoginApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ILoginApi invoke() {
            return (ILoginApi) a.d().h(ILoginApi.class);
        }
    });

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ProfileSeeListFragment f59615l;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final ILoginApi o0() {
        Object value = this.f59614k.getValue();
        Intrinsics.f(value, "<get-mLoginApi>(...)");
        return (ILoginApi) value;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public String U() {
        return p0();
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
    public void c0() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.f(supportFragmentManager, "supportFragmentManager");
        FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.f(fragmentTransactionBeginTransaction, "beginTransaction()");
        ProfileSeeListFragment profileSeeListFragmentA = ProfileSeeListFragment.f59616t.a(1, this.f59612i, p0());
        fragmentTransactionBeginTransaction.replace(R$id.flContent, profileSeeListFragmentA);
        this.f59615l = profileSeeListFragmentA;
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public String getPageName() {
        return "movie_audio_archies";
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isChangeStatusBar() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isStatusDark() {
        return !o.f51321a.a();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("want2SeeCount", this.f59613j);
        setResult(-1, intent);
        super.onBackPressed();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.alibaba.android.arouter.launcher.a.d().f(this);
        super.onCreate(bundle);
    }

    public final String p0() {
        String str = this.f59612i;
        if (str != null && str.length() != 0) {
            String str2 = this.f59612i;
            UserInfo userInfoP = o0().P();
            if (!Intrinsics.b(str2, userInfoP != null ? userInfoP.getUserId() : null)) {
                String string = getString(R$string.profile_list);
                Intrinsics.f(string, "{\n            getString(…g.profile_list)\n        }");
                return string;
            }
        }
        String string2 = getString(R$string.profile_your_list);
        Intrinsics.f(string2, "{\n            getString(…file_your_list)\n        }");
        return string2;
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
    public g0 getViewBinding() {
        g0 g0VarC = g0.c(getLayoutInflater());
        Intrinsics.f(g0VarC, "inflate(layoutInflater)");
        return g0VarC;
    }

    public final void r0(int i11) {
        if (this.f59613j < 0) {
            i11 = 0;
        }
        this.f59613j = i11;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void retryLoadData() {
        i0();
        if (!f.f49475a.e()) {
            k0();
            return;
        }
        g0();
        if (this.f59615l == null) {
            c0();
        }
    }
}
