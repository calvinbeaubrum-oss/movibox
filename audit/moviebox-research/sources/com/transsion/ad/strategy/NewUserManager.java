package com.transsion.ad.strategy;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class NewUserManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NewUserManager f50581a = new NewUserManager();

    public final long a() {
        Object objM163constructorimpl;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.Companion;
            JsonObject jsonObjectB = wq.d.f79584a.b("GlobConfigScene");
            objM163constructorimpl = Result.m163constructorimpl(Long.valueOf(((long) (((jsonObjectB == null || (jsonElement = jsonObjectB.get("newUserMaskTime")) == null) ? 5 : jsonElement.getAsInt()) * 86400)) * 1000));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
            objM163constructorimpl = 432000000L;
        }
        return ((Number) objM163constructorimpl).longValue();
    }

    public final Object b(Continuation<? super Unit> continuation) {
        Object objG = kotlinx.coroutines.h.g(w0.b(), new NewUserManager$initFirstOpen$2(null), continuation);
        return objG == kotlin.coroutines.intrinsics.a.e() ? objG : Unit.f68710a;
    }

    public final boolean c() {
        return System.currentTimeMillis() - AdMmkv.f50558a.a().getLong("mmkv_key_new_user_first_use_time_stamp", -1L) <= a();
    }
}
