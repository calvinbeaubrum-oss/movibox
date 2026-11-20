package wq;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.transsion.ad.strategy.AdUrlParameterReplaceManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.g;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

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
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f79582a = new b();

    public final String a() {
        return "GlobConfigScene";
    }

    public final int b() {
        Object objM163constructorimpl;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.Companion;
            JsonObject jsonObjectB = d.f79584a.b(f79582a.a());
            objM163constructorimpl = Result.m163constructorimpl(Integer.valueOf((jsonObjectB == null || (jsonElement = jsonObjectB.get("interstitialCd")) == null) ? 5 : jsonElement.getAsInt()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
            objM163constructorimpl = 5;
        }
        return ((Number) objM163constructorimpl).intValue();
    }

    public final float c() {
        Object objM163constructorimpl;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.Companion;
            JsonObject jsonObjectB = d.f79584a.b(f79582a.a());
            objM163constructorimpl = Result.m163constructorimpl(Float.valueOf((jsonObjectB == null || (jsonElement = jsonObjectB.get("lowMemoryValue")) == null) ? 1.0f : jsonElement.getAsFloat()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
            objM163constructorimpl = Float.valueOf(1.0f);
        }
        return ((Number) objM163constructorimpl).floatValue();
    }

    public final int d() {
        Object objM163constructorimpl;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.Companion;
            JsonObject jsonObjectB = d.f79584a.b(f79582a.a());
            objM163constructorimpl = Result.m163constructorimpl(Integer.valueOf((jsonObjectB == null || (jsonElement = jsonObjectB.get("nativeCacheUpperLimit")) == null) ? 1 : jsonElement.getAsInt()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
            objM163constructorimpl = 1;
        }
        return ((Number) objM163constructorimpl).intValue();
    }

    public final int e() {
        Object objM163constructorimpl;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.Companion;
            JsonObject jsonObjectB = d.f79584a.b(f79582a.a());
            objM163constructorimpl = Result.m163constructorimpl(Integer.valueOf((jsonObjectB == null || (jsonElement = jsonObjectB.get("psLinkInterval")) == null) ? 6 : jsonElement.getAsInt()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
            objM163constructorimpl = 6;
        }
        return ((Number) objM163constructorimpl).intValue();
    }

    public final List<AdUrlParameterReplaceManager.a> f() {
        Object objM163constructorimpl;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.Companion;
            JsonObject jsonObjectB = d.f79584a.b(f79582a.a());
            JSONArray jSONArray = new JSONArray((jsonObjectB == null || (jsonElement = jsonObjectB.get("urlParameterReplace")) == null) ? null : jsonElement.getAsString());
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i11 = 0; i11 < length; i11++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i11);
                String string = jSONObject.getString("key");
                Intrinsics.f(string, "item.getString(\"key\")");
                String string2 = jSONObject.getString(AppMeasurementSdk.ConditionalUserProperty.VALUE);
                Intrinsics.f(string2, "item.getString(\"value\")");
                String string3 = jSONObject.getString("type");
                Intrinsics.f(string3, "item.getString(\"type\")");
                arrayList.add(new AdUrlParameterReplaceManager.a(string, string2, string3));
            }
            objM163constructorimpl = Result.m163constructorimpl(arrayList);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
            objM163constructorimpl = g.l();
        }
        return (List) objM163constructorimpl;
    }

    public final int g() {
        Object objM163constructorimpl;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.Companion;
            JsonObject jsonObjectB = d.f79584a.b(f79582a.a());
            objM163constructorimpl = Result.m163constructorimpl(Integer.valueOf((jsonObjectB == null || (jsonElement = jsonObjectB.get("videoCd")) == null) ? 15 : jsonElement.getAsInt()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
            objM163constructorimpl = 15;
        }
        return ((Number) objM163constructorimpl).intValue();
    }

    public final boolean h() {
        Object objM163constructorimpl;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.Companion;
            JsonObject jsonObjectB = d.f79584a.b(f79582a.a());
            objM163constructorimpl = Result.m163constructorimpl(Boolean.valueOf((jsonObjectB == null || (jsonElement = jsonObjectB.get("adLinkOff")) == null) ? false : jsonElement.getAsBoolean()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
            objM163constructorimpl = Boolean.FALSE;
        }
        return ((Boolean) objM163constructorimpl).booleanValue();
    }

    public final boolean i() {
        Object objM163constructorimpl;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.Companion;
            JsonObject jsonObjectB = d.f79584a.b(f79582a.a());
            objM163constructorimpl = Result.m163constructorimpl(Boolean.valueOf((jsonObjectB == null || (jsonElement = jsonObjectB.get("isOpenAd")) == null) ? true : jsonElement.getAsBoolean()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
            objM163constructorimpl = Boolean.TRUE;
        }
        return ((Boolean) objM163constructorimpl).booleanValue();
    }

    public final boolean j() {
        Object objM163constructorimpl;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.Companion;
            JsonObject jsonObjectB = d.f79584a.b(f79582a.a());
            objM163constructorimpl = Result.m163constructorimpl(Boolean.valueOf((jsonObjectB == null || (jsonElement = jsonObjectB.get("showAdTag")) == null) ? false : jsonElement.getAsBoolean()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
            objM163constructorimpl = Boolean.FALSE;
        }
        return ((Boolean) objM163constructorimpl).booleanValue();
    }
}
