package com.transsion.fission;

import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsnet.loginapi.ILoginApi;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class FissionManager {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static FissionConfig f51907c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FissionManager f51905a = new FissionManager();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f51906b = "FissionManager";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final k0 f51908d = l0.a(w0.b());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f51909e = LazyKt__LazyJVMKt.b(new Function0<dt.a>() { // from class: com.transsion.fission.FissionManager$mFissionInvitationApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final dt.a invoke() {
            return (dt.a) NetServiceGenerator.f49399d.a().i(dt.a.class);
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f51910f = LazyKt__LazyJVMKt.b(new Function0<ILoginApi>() { // from class: com.transsion.fission.FissionManager$loginApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ILoginApi invoke() {
            return (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
        }
    });

    public final String a() {
        return e.f51915a.b();
    }

    public final FissionConfig b() {
        return f51907c;
    }
}
