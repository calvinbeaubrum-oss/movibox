package com.transsion.usercenter;

import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.publish.api.IPublishApi;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import so.c;
import xy.i;

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
public final class ProfileEditActivity extends BaseActivity<i> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f59273i = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f59274a = LazyKt__LazyJVMKt.b(new Function0<IPublishApi>() { // from class: com.transsion.usercenter.ProfileEditActivity$publishApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IPublishApi invoke() {
            return (IPublishApi) com.alibaba.android.arouter.launcher.a.d().h(IPublishApi.class);
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f59275b = LazyKt__LazyJVMKt.b(new Function0<ProfileEditActivityModel>() { // from class: com.transsion.usercenter.ProfileEditActivity$model$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ProfileEditActivityModel invoke() {
            return new ProfileEditActivityModel();
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f59276c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f59277d = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f59278f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f59279g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f59280h = "2020-06-15";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public i getViewBinding() {
        i iVarC = i.c(getLayoutInflater());
        Intrinsics.f(iVarC, "inflate(layoutInflater)");
        return iVarC;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ConstraintLayout root = ((i) getMViewBinding()).getRoot();
        Intrinsics.f(root, "mViewBinding.root");
        c.e(root);
    }
}
