package com.transsion.usercenter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.usercenter.UserCenterActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import so.c;
import xy.k;

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
public final class UserCenterActivity extends BaseActivity<k> {
    public static final void T(UserCenterActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) ProfileEditActivity.class));
    }

    public static final void U(UserCenterActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Intent intent = new Intent(this$0, (Class<?>) FollowActivity.class);
        intent.putExtra("follow_type_key", 1);
        this$0.startActivity(intent);
    }

    public static final void V(UserCenterActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Intent intent = new Intent(this$0, (Class<?>) FollowActivity.class);
        intent.putExtra("follow_type_key", 2);
        this$0.startActivity(intent);
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public k getViewBinding() {
        k kVarC = k.c(getLayoutInflater());
        Intrinsics.f(kVarC, "inflate(layoutInflater)");
        return kVarC;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S() {
        ((k) getMViewBinding()).f80838b.setOnClickListener(new View.OnClickListener() { // from class: wy.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserCenterActivity.T(this.f79762a, view);
            }
        });
        ((k) getMViewBinding()).f80840d.setOnClickListener(new View.OnClickListener() { // from class: wy.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserCenterActivity.U(this.f79763a, view);
            }
        });
        ((k) getMViewBinding()).f80839c.setOnClickListener(new View.OnClickListener() { // from class: wy.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserCenterActivity.V(this.f79764a, view);
            }
        });
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayoutCompat root = ((k) getMViewBinding()).getRoot();
        Intrinsics.f(root, "mViewBinding.root");
        c.e(root);
        S();
    }
}
