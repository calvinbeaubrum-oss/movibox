package com.transsion.usercenter.setting.feedback;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.c0;
import com.transsnet.loginapi.ILoginApi;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
@Metadata
public final class UserFeedbackViewModel extends androidx.lifecycle.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f59691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f59692c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserFeedbackViewModel(Application application) {
        super(application);
        Intrinsics.g(application, "application");
        this.f59691b = LazyKt__LazyJVMKt.b(new Function0<c0<String>>() { // from class: com.transsion.usercenter.setting.feedback.UserFeedbackViewModel$feedbackLiveData$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c0<String> invoke() {
                return new c0<>();
            }
        });
        this.f59692c = LazyKt__LazyJVMKt.b(new Function0<ILoginApi>() { // from class: com.transsion.usercenter.setting.feedback.UserFeedbackViewModel$loginApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ILoginApi invoke() {
                return (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
            }
        });
    }

    public final LiveData<String> c() {
        return d();
    }

    public final c0<String> d() {
        return (c0) this.f59691b.getValue();
    }

    @Override // androidx.lifecycle.t0
    public void onCleared() {
        super.onCleared();
    }
}
