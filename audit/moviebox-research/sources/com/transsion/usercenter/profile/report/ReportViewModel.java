package com.transsion.usercenter.profile.report;

import android.app.Application;
import androidx.lifecycle.c0;
import androidx.lifecycle.u0;
import com.google.gson.JsonObject;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.manager.NetServiceGenerator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;

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
public final class ReportViewModel extends androidx.lifecycle.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f59600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f59601c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f59602d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReportViewModel(Application application) {
        super(application);
        Intrinsics.g(application, "application");
        this.f59600b = LazyKt__LazyJVMKt.b(new Function0<b>() { // from class: com.transsion.usercenter.profile.report.ReportViewModel$service$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return (b) NetServiceGenerator.f49399d.a().i(b.class);
            }
        });
        this.f59601c = LazyKt__LazyJVMKt.b(new Function0<c0<BaseDto<Object>>>() { // from class: com.transsion.usercenter.profile.report.ReportViewModel$reportLiveData$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c0<BaseDto<Object>> invoke() {
                return new c0<>();
            }
        });
        this.f59602d = LazyKt__LazyJVMKt.b(new Function0<c0<BaseDto<Object>>>() { // from class: com.transsion.usercenter.profile.report.ReportViewModel$blockLiveData$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c0<BaseDto<Object>> invoke() {
                return new c0<>();
            }
        });
    }

    public final void d(String userId) {
        Intrinsics.g(userId, "userId");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("userId", userId);
        j.d(u0.a(this), null, null, new ReportViewModel$block$1(jsonObject, this, null), 3, null);
    }

    public final c0<BaseDto<Object>> e() {
        return (c0) this.f59602d.getValue();
    }

    public final c0<BaseDto<Object>> f() {
        return (c0) this.f59601c.getValue();
    }

    public final b g() {
        return (b) this.f59600b.getValue();
    }

    public final void h(String str, String str2, String str3) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", str);
        jsonObject.addProperty("id", str2);
        jsonObject.addProperty("reason", str3);
        j.d(u0.a(this), null, null, new ReportViewModel$report$1(jsonObject, this, null), 3, null);
    }

    public final void i(String userId) {
        Intrinsics.g(userId, "userId");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("userId", userId);
        j.d(u0.a(this), null, null, new ReportViewModel$unBlock$1(jsonObject, this, null), 3, null);
    }
}
