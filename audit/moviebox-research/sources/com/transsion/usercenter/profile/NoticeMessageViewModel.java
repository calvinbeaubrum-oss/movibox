package com.transsion.usercenter.profile;

import androidx.lifecycle.c0;
import androidx.lifecycle.t0;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.usercenter.profile.bean.ProfileNewMessage;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class NoticeMessageViewModel extends t0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f59506d = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f59507f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0<Integer> f59508a = new c0<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0<ProfileNewMessage> f59509b = new c0<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f59510c = LazyKt__LazyJVMKt.b(new Function0<com.transsion.usercenter.profile.b>() { // from class: com.transsion.usercenter.profile.NoticeMessageViewModel$mProfileApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final b invoke() {
            return (b) NetServiceGenerator.f49399d.a().i(b.class);
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends zo.a<ProfileNewMessage> {
        public b() {
        }

        @Override // zo.a
        public void a(String str, String str2) {
            NoticeMessageViewModel.f59507f = false;
            NoticeMessageViewModel.this.f().n(null);
            NoticeMessageViewModel.this.g().q(0);
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(ProfileNewMessage profileNewMessage) {
            NoticeMessageViewModel.f59507f = false;
            NoticeMessageViewModel.this.f().n(profileNewMessage);
            NoticeMessageViewModel.this.g().q(Integer.valueOf(profileNewMessage != null ? profileNewMessage.getSystemCnt() + profileNewMessage.getInteractiveCnt() : 0));
        }
    }

    private final com.transsion.usercenter.profile.b e() {
        return (com.transsion.usercenter.profile.b) this.f59510c.getValue();
    }

    public final void c() {
        if (f59507f) {
            return;
        }
        f59507f = true;
        com.transsion.usercenter.profile.b.a.a(e(), null, 1, null).e(zo.d.f82109a.c()).subscribe(new b());
    }

    public final void d() {
        this.f59508a.q(0);
    }

    public final c0<ProfileNewMessage> f() {
        return this.f59509b;
    }

    public final c0<Integer> g() {
        return this.f59508a;
    }
}
