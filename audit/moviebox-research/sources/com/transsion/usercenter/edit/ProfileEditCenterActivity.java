package com.transsion.usercenter.edit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.R$color;
import com.transsion.baselib.utils.o;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.publish.R$string;
import com.transsion.usercenter.R$id;
import com.transsnet.loginapi.bean.UserInfo;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.mvel2.ast.ASTNode;

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
@Metadata
public final class ProfileEditCenterActivity extends BaseActivity<xy.h> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f59299b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ProfileEditCenterFragment f59300a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, UserInfo userInfo) {
            Intrinsics.g(context, "context");
            Intent intent = new Intent(context, (Class<?>) ProfileEditCenterActivity.class);
            if (userInfo != null) {
                intent.putExtra("user", userInfo);
            }
            intent.setFlags(ASTNode.DEOP);
            context.startActivity(intent);
        }
    }

    public static final void R(ProfileEditCenterActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        ProfileEditCenterFragment profileEditCenterFragment = this$0.f59300a;
        if (profileEditCenterFragment == null) {
            Intrinsics.y("profileEditFragment");
            profileEditCenterFragment = null;
        }
        profileEditCenterFragment.checkBack();
    }

    public static final void S(ProfileEditCenterActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        ProfileEditCenterFragment profileEditCenterFragment = this$0.f59300a;
        if (profileEditCenterFragment == null) {
            Intrinsics.y("profileEditFragment");
            profileEditCenterFragment = null;
        }
        profileEditCenterFragment.confirmSubmit();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initData() {
        Serializable serializableExtra = getIntent().getSerializableExtra("user");
        ProfileEditCenterFragment profileEditCenterFragment = null;
        UserInfo userInfo = (serializableExtra == null || !(serializableExtra instanceof UserInfo)) ? null : (UserInfo) serializableExtra;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.f(supportFragmentManager, "supportFragmentManager");
        FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.f(fragmentTransactionBeginTransaction, "fm.beginTransaction()");
        ProfileEditCenterFragment profileEditCenterFragmentA = ProfileEditCenterFragment.Companion.a(userInfo);
        this.f59300a = profileEditCenterFragmentA;
        if (profileEditCenterFragmentA == null) {
            Intrinsics.y("profileEditFragment");
        }
        int i11 = R$id.fl_content;
        ProfileEditCenterFragment profileEditCenterFragment2 = this.f59300a;
        if (profileEditCenterFragment2 == null) {
            Intrinsics.y("profileEditFragment");
        } else {
            profileEditCenterFragment = profileEditCenterFragment2;
        }
        fragmentTransactionBeginTransaction.add(i11, profileEditCenterFragment);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        TitleLayout titleLayout = ((xy.h) getMViewBinding()).f80815d;
        titleLayout.setLeftOnclick(new View.OnClickListener() { // from class: com.transsion.usercenter.edit.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileEditCenterActivity.R(this.f59312a, view);
            }
        });
        String string = getString(R$string.profile_empty_done);
        Intrinsics.f(string, "getString(com.transsion.…tring.profile_empty_done)");
        titleLayout.setRightView(string, z2.a.getColor(titleLayout.getContext(), R$color.main), new View.OnClickListener() { // from class: com.transsion.usercenter.edit.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileEditCenterActivity.S(this.f59313a, view);
            }
        });
        String string2 = getString(com.transsion.usercenter.R$string.profile_edit_profile);
        Intrinsics.f(string2, "getString(R.string.profile_edit_profile)");
        titleLayout.setTitleText(string2);
        ProgressBar progressBar = ((xy.h) getMViewBinding()).f80814c;
        Intrinsics.f(progressBar, "mViewBinding.loadView");
        so.c.g(progressBar);
    }

    private final void initView() {
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public xy.h getViewBinding() {
        xy.h hVarC = xy.h.c(getLayoutInflater());
        Intrinsics.f(hVarC, "inflate(layoutInflater)");
        return hVarC;
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

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        ProfileEditCenterFragment profileEditCenterFragment = this.f59300a;
        if (profileEditCenterFragment == null) {
            Intrinsics.y("profileEditFragment");
            profileEditCenterFragment = null;
        }
        profileEditCenterFragment.checkEditSubmit(true);
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData();
    }
}
