package wq;

import android.text.TextUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import oq.e;

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
@SourceDebugExtension
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f79583a = new c();

    public final boolean a(String str) {
        Object objM163constructorimpl;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.Companion;
            JsonObject jsonObjectB = d.f79584a.b(str);
            objM163constructorimpl = Result.m163constructorimpl(Boolean.valueOf((jsonObjectB == null || (jsonElement = jsonObjectB.get("hiOff")) == null) ? false : jsonElement.getAsBoolean()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
            objM163constructorimpl = Boolean.FALSE;
        }
        return ((Boolean) objM163constructorimpl).booleanValue();
    }

    public final boolean b(String sceneId) {
        Object objM163constructorimpl;
        JsonElement jsonElement;
        Intrinsics.g(sceneId, "sceneId");
        try {
            Result.Companion companion = Result.Companion;
            JsonObject jsonObjectB = d.f79584a.b(sceneId);
            objM163constructorimpl = Result.m163constructorimpl(Boolean.valueOf((jsonObjectB == null || (jsonElement = jsonObjectB.get("nonOff")) == null) ? false : jsonElement.getAsBoolean()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
            objM163constructorimpl = Boolean.FALSE;
        }
        return ((Boolean) objM163constructorimpl).booleanValue();
    }

    public final boolean c(String str) {
        Object objM163constructorimpl;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.Companion;
            JsonObject jsonObjectB = d.f79584a.b(str);
            objM163constructorimpl = Result.m163constructorimpl(Boolean.valueOf((jsonObjectB == null || (jsonElement = jsonObjectB.get("sceneOff")) == null) ? false : jsonElement.getAsBoolean()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
            objM163constructorimpl = Boolean.FALSE;
        }
        return ((Boolean) objM163constructorimpl).booleanValue();
    }

    public final String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return "sceneId is empty";
        }
        e eVar = e.f72517a;
        if (eVar.b()) {
            Iterator<T> it = eVar.a().iterator();
            boolean z11 = false;
            while (it.hasNext()) {
                if (TextUtils.equals(str, (String) it.next())) {
                    z11 = true;
                }
            }
            if (z11) {
                return "当前是会员 --> 当前场景ID在黑名单中 --> 跳过广告";
            }
        }
        if (!b.f79582a.i()) {
            return "全局场景关闭";
        }
        if (!c(str)) {
            return d.f79584a.b(str) == null ? "场景配置为空" : "";
        }
        return "场景关闭 --> sceneId = " + str;
    }
}
