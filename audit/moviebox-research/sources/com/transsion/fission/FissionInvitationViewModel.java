package com.transsion.fission;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.c0;
import androidx.lifecycle.t0;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.manager.NetServiceGenerator;
import io.reactivex.rxjava3.core.j;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class FissionInvitationViewModel extends t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f51902a = LazyKt__LazyJVMKt.b(new Function0<dt.a>() { // from class: com.transsion.fission.FissionInvitationViewModel$mFissionInvitationApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final dt.a invoke() {
            return (dt.a) NetServiceGenerator.f49399d.a().i(dt.a.class);
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0<BaseDto<Object>> f51903b = new c0<>();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends zo.a<Object> {
        public a() {
        }

        @Override // zo.a
        public void a(String str, String str2) {
            c0 c0Var = FissionInvitationViewModel.this.f51903b;
            if (str2 == null) {
                str2 = "";
            }
            if (str == null) {
                str = "";
            }
            c0Var.q(new BaseDto(str2, str, null, ""));
        }

        @Override // zo.a
        public void d(BaseDto<Object> baseDto) {
            Intrinsics.g(baseDto, "baseDto");
            super.d(baseDto);
            FissionInvitationViewModel.this.f51903b.q(baseDto);
        }
    }

    public final dt.a c() {
        return (dt.a) this.f51902a.getValue();
    }

    public final LiveData<BaseDto<Object>> d() {
        return this.f51903b;
    }

    public final void e(String code) {
        j jVarA;
        j jVarE;
        Intrinsics.g(code, "code");
        String str = "{\"inviteCode\": \"" + code + "\"}";
        dt.a aVarC = c();
        if (aVarC == null || (jVarA = dt.a.C0650a.a(aVarC, null, RequestBody.Companion.create(str, MediaType.Companion.parse("application/json")), 1, null)) == null || (jVarE = jVarA.e(zo.d.f82109a.c())) == null) {
            return;
        }
        jVarE.subscribe(new a());
    }
}
