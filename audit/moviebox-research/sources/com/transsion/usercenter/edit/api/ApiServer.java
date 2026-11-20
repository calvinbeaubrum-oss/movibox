package com.transsion.usercenter.edit.api;

import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsnet.loginapi.bean.UserInfo;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import yy.a;
import zo.d;

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
public final class ApiServer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f59307a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<yy.a> f59308b = LazyKt__LazyJVMKt.b(new Function0<yy.a>() { // from class: com.transsion.usercenter.edit.api.ApiServer$Companion$service$2
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return (a) NetServiceGenerator.f49399d.a().i(a.class);
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: com.transsion.usercenter.edit.api.ApiServer$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class C0611a extends zo.a<String> {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ com.transsion.usercenter.edit.a<String> f59309d;

            public C0611a(com.transsion.usercenter.edit.a<String> aVar) {
                this.f59309d = aVar;
            }

            @Override // zo.a
            public void a(String str, String str2) {
                ApiServer.f59307a.g(str, str2);
                com.transsion.usercenter.edit.a<String> aVar = this.f59309d;
                if (aVar != null) {
                    aVar.a(str, str2);
                }
            }

            @Override // zo.a
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void c(String str) {
                this.f59309d.b(str, false, "");
            }
        }

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class b extends zo.a<UserInfo> {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ com.transsion.usercenter.edit.a<UserInfo> f59310d;

            public b(com.transsion.usercenter.edit.a<UserInfo> aVar) {
                this.f59310d = aVar;
            }

            @Override // zo.a
            public void a(String str, String str2) {
                ApiServer.f59307a.g(str, str2);
                com.transsion.usercenter.edit.a<UserInfo> aVar = this.f59310d;
                if (aVar != null) {
                    aVar.a(str, str2);
                }
            }

            @Override // zo.a
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void c(UserInfo userInfo) {
                this.f59310d.b(userInfo, false, "");
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void b(RequstUserEntity entity, com.transsion.usercenter.edit.a<String> callback) {
            Intrinsics.g(entity, "entity");
            Intrinsics.g(callback, "callback");
            d().b(cp.a.f62775a.a(), c(f(entity))).e(d.f82109a.c()).subscribe(new C0611a(callback));
        }

        public final RequestBody c(String str) {
            return RequestBody.Companion.create(str, MediaType.Companion.parse("application/json"));
        }

        public final yy.a d() {
            return (yy.a) ApiServer.f59308b.getValue();
        }

        public final void e(com.transsion.usercenter.edit.a<UserInfo> callback) {
            Intrinsics.g(callback, "callback");
            d().a(cp.a.f62775a.a()).e(d.f82109a.c()).subscribe(new b(callback));
        }

        public final String f(Object obj) {
            return String.valueOf(cz.a.f62835a.a(obj));
        }

        public final void g(String str, String str2) {
            uo.b.a.f(uo.b.f78622a, "ApiServer", "onFailure code=" + str + " message=" + str2, false, 4, null);
        }
    }
}
