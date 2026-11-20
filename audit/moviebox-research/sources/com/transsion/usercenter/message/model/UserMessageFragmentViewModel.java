package com.transsion.usercenter.message.model;

import androidx.lifecycle.c0;
import androidx.lifecycle.t0;
import com.tn.lib.net.manager.NetServiceGenerator;
import fz.a;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
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
public final class UserMessageFragmentViewModel extends t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f59486a = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.NONE, new Function0<fz.a>() { // from class: com.transsion.usercenter.message.model.UserMessageFragmentViewModel$service$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return (a) NetServiceGenerator.f49399d.a().i(a.class);
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f59487b = LazyKt__LazyJVMKt.b(new Function0<c0<ResponseMessage>>() { // from class: com.transsion.usercenter.message.model.UserMessageFragmentViewModel$messageMutableLiveData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<ResponseMessage> invoke() {
            return new c0<>();
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends zo.a<ResponseMessage> {
        public a() {
        }

        @Override // zo.a
        public void a(String str, String str2) {
            UserMessageFragmentViewModel.this.b().n(null);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(ResponseMessage responseMessage) {
            UserMessageFragmentViewModel.this.b().n(responseMessage);
        }
    }

    public final c0<ResponseMessage> b() {
        return (c0) this.f59487b.getValue();
    }

    public final fz.a c() {
        return (fz.a) this.f59486a.getValue();
    }

    public final void d(String page, String type) {
        Intrinsics.g(page, "page");
        Intrinsics.g(type, "type");
        c().a(cp.a.f62775a.a(), page, type, 30).e(d.f82109a.c()).subscribe(new a());
    }
}
