package com.transsion.member;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.c0;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.member.bean.request.MemberPromoCodeReq;
import com.transsion.member.bean.request.MemberPromoCodeRes;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class MemberPromoCodeViewModel extends androidx.lifecycle.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f53160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0<i> f53161c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends zo.a<MemberPromoCodeRes> {
        public a() {
        }

        @Override // zo.a
        public void a(String str, String str2) {
            MemberPromoCodeViewModel.this.f53161c.q(new i(false, str, str2, null));
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(MemberPromoCodeRes memberPromoCodeRes) {
            super.c(memberPromoCodeRes);
            MemberPromoCodeViewModel.this.f53161c.q(new i(true, null, null, memberPromoCodeRes));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberPromoCodeViewModel(Application application) {
        super(application);
        Intrinsics.g(application, "application");
        this.f53160b = LazyKt__LazyJVMKt.b(new Function0<pu.a>() { // from class: com.transsion.member.MemberPromoCodeViewModel$memberApi$2
            @Override // kotlin.jvm.functions.Function0
            public final pu.a invoke() {
                return (pu.a) NetServiceGenerator.f49399d.a().i(pu.a.class);
            }
        });
        this.f53161c = new c0<>();
    }

    private final pu.a e() {
        return (pu.a) this.f53160b.getValue();
    }

    public final LiveData<i> d() {
        return this.f53161c;
    }

    public final void f(String code) {
        Intrinsics.g(code, "code");
        pu.a.C0809a.k(e(), null, new MemberPromoCodeReq(code), 1, null).e(zo.d.f82109a.c()).subscribe(new a());
    }
}
