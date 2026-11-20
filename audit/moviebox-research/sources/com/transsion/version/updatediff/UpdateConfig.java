package com.transsion.version.updatediff;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.blankj.utilcode.util.g0;
import com.transsion.lib.diffupdate.DownloadStrategy;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class UpdateConfig extends com.transsion.lib.diffupdate.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f59774d = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f59775b = LazyKt__LazyJVMKt.b(new Function0<ILoginApi>() { // from class: com.transsion.version.updatediff.UpdateConfig$mLogin$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ILoginApi invoke() {
            return (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DownloadStrategy f59776c = DiffUpdateConfig.f59770a.d();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.transsion.lib.diffupdate.a
    public String a() {
        return e() + "/wefeed-mobile-bff/app/check-update";
    }

    @Override // com.transsion.lib.diffupdate.a
    public Map<String, String> b() {
        String strD;
        HashMap map = new HashMap();
        fp.b.a aVar = fp.b.f65208a;
        map.put("X-Client-Info", aVar.c());
        ap.a.C0129a c0129a = ap.a.f13586a;
        UserInfo userInfoP = f().P();
        if (userInfoP == null || (strD = userInfoP.getToken()) == null) {
            strD = d();
        }
        map.put(HttpHeaders.AUTHORIZATION, c0129a.a(strD));
        map.putAll(aVar.f());
        return map;
    }

    @Override // com.transsion.lib.diffupdate.a
    public DownloadStrategy c() {
        return this.f59776c;
    }

    public final String d() {
        String strValueOf = String.valueOf(System.currentTimeMillis());
        String reverse = g0.e(strValueOf);
        qp.a.C0819a c0819a = qp.a.f74869a;
        Intrinsics.f(reverse, "reverse");
        return strValueOf + "," + c0819a.a(reverse);
    }

    public final String e() {
        return cp.a.f62775a.a();
    }

    public final ILoginApi f() {
        return (ILoginApi) this.f59775b.getValue();
    }
}
