package wq;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f79581a = new a();

    public static /* synthetic */ int f(a aVar, String str, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 5;
        }
        return aVar.e(str, i11);
    }

    public static /* synthetic */ int h(a aVar, String str, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 5;
        }
        return aVar.g(str, i11);
    }

    public final int a(String sceneId) {
        JsonElement jsonElement;
        Intrinsics.g(sceneId, "sceneId");
        JsonObject jsonObjectB = d.f79584a.b(sceneId);
        if (jsonObjectB == null || (jsonElement = jsonObjectB.get("biddingTime")) == null) {
            return 2;
        }
        return jsonElement.getAsInt();
    }

    public final String b(String str) {
        Object objM163constructorimpl;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.Companion;
            JsonObject jsonObjectB = d.f79584a.b(str);
            objM163constructorimpl = Result.m163constructorimpl((jsonObjectB == null || (jsonElement = jsonObjectB.get("hiId")) == null) ? null : jsonElement.getAsString());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        return (String) (Result.m166exceptionOrNullimpl(objM163constructorimpl) == null ? objM163constructorimpl : null);
    }

    public final int c(String sceneId) {
        JsonElement jsonElement;
        Intrinsics.g(sceneId, "sceneId");
        JsonObject jsonObjectB = d.f79584a.b(sceneId);
        if (jsonObjectB == null || (jsonElement = jsonObjectB.get("interval")) == null) {
            return 10;
        }
        return jsonElement.getAsInt();
    }

    public final int d(String str) {
        JsonElement jsonElement;
        JsonObject jsonObjectB = d.f79584a.b(str);
        if (jsonObjectB == null || (jsonElement = jsonObjectB.get("refreshTime")) == null) {
            return 30;
        }
        return jsonElement.getAsInt();
    }

    public final int e(String sceneId, int i11) {
        Object objM163constructorimpl;
        JsonElement jsonElement;
        Intrinsics.g(sceneId, "sceneId");
        try {
            Result.Companion companion = Result.Companion;
            JsonObject jsonObjectB = d.f79584a.b(sceneId);
            objM163constructorimpl = Result.m163constructorimpl(Integer.valueOf((jsonObjectB == null || (jsonElement = jsonObjectB.get("x")) == null) ? i11 : jsonElement.getAsInt()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
            objM163constructorimpl = Integer.valueOf(i11);
        }
        return ((Number) objM163constructorimpl).intValue();
    }

    public final int g(String sceneId, int i11) {
        Object objM163constructorimpl;
        JsonElement jsonElement;
        Intrinsics.g(sceneId, "sceneId");
        try {
            Result.Companion companion = Result.Companion;
            JsonObject jsonObjectB = d.f79584a.b(sceneId);
            objM163constructorimpl = Result.m163constructorimpl(Integer.valueOf((jsonObjectB == null || (jsonElement = jsonObjectB.get("y")) == null) ? i11 : jsonElement.getAsInt()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
            objM163constructorimpl = Integer.valueOf(i11);
        }
        return ((Number) objM163constructorimpl).intValue();
    }

    public final int i(String sceneId) {
        Object objM163constructorimpl;
        JsonElement jsonElement;
        Intrinsics.g(sceneId, "sceneId");
        try {
            Result.Companion companion = Result.Companion;
            JsonObject jsonObjectB = d.f79584a.b(sceneId);
            objM163constructorimpl = Result.m163constructorimpl(Integer.valueOf((jsonObjectB == null || (jsonElement = jsonObjectB.get("countDown")) == null) ? 5 : jsonElement.getAsInt()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
            objM163constructorimpl = 5;
        }
        return ((Number) objM163constructorimpl).intValue();
    }

    public final int j(String sceneId) {
        Object objM163constructorimpl;
        JsonElement jsonElement;
        Intrinsics.g(sceneId, "sceneId");
        try {
            Result.Companion companion = Result.Companion;
            JsonObject jsonObjectB = d.f79584a.b(sceneId);
            objM163constructorimpl = Result.m163constructorimpl(Integer.valueOf((jsonObjectB == null || (jsonElement = jsonObjectB.get("timeOut")) == null) ? 5 : jsonElement.getAsInt()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
            objM163constructorimpl = 5;
        }
        return ((Number) objM163constructorimpl).intValue();
    }
}
