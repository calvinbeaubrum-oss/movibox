package com.transsion.usercenter.setting;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.c0;
import com.transsion.usercenter.setting.feedback.api.ApiServer;
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
public final class UserSettingViewModel extends androidx.lifecycle.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0<Long> f59659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0<String> f59660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c0<Boolean> f59661d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f59662f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public h10.b f59663g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserSettingViewModel(Application application) {
        super(application);
        Intrinsics.g(application, "application");
        this.f59659b = new c0<>();
        this.f59660c = new c0<>();
        this.f59661d = new c0<>();
        this.f59662f = LazyKt__LazyJVMKt.b(new Function0<ApiServer>() { // from class: com.transsion.usercenter.setting.UserSettingViewModel$api$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ApiServer invoke() {
                return new ApiServer();
            }
        });
    }

    public final void c() {
        h10.b bVar;
        h10.b bVar2 = this.f59663g;
        if (bVar2 == null || bVar2.isDisposed() || (bVar = this.f59663g) == null) {
            return;
        }
        bVar.dispose();
    }

    public final LiveData<Long> d() {
        return this.f59659b;
    }

    public final LiveData<String> e() {
        return this.f59660c;
    }

    public final LiveData<Boolean> f() {
        return this.f59661d;
    }

    @Override // androidx.lifecycle.t0
    public void onCleared() {
        super.onCleared();
        c();
    }
}
