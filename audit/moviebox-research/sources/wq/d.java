package wq;

import android.text.TextUtils;
import com.blankj.utilcode.util.n;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.tencent.mmkv.MMKV;
import com.transsion.ad.monopoly.model.MbAdPlansBean;
import com.transsion.ad.monopoly.model.MbAdPlansDto;
import com.transsion.ad.strategy.AdMmkv;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f79584a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, JsonObject> f79585b = new HashMap<>();

    public final String a() {
        String simpleName = d.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final JsonObject b(String str) {
        JsonObject asJsonObject;
        try {
            Result.Companion companion = Result.Companion;
            HashMap<String, JsonObject> map = f79585b;
            if (map.containsKey(str)) {
                return map.get(str);
            }
            JsonArray array = (JsonArray) n.d(AdMmkv.f50558a.b().getString("non_ad_scene_config_data", ""), JsonArray.class);
            if (array != null) {
                Intrinsics.f(array, "array");
                for (JsonElement jsonElement : array) {
                    if (jsonElement != null && (asJsonObject = jsonElement.getAsJsonObject()) != null) {
                        Intrinsics.f(asJsonObject, "asJsonObject");
                        JsonElement jsonElement2 = asJsonObject.get("id");
                        String asString = jsonElement2 != null ? jsonElement2.getAsString() : null;
                        if (asString == null) {
                            asString = "";
                        } else {
                            Intrinsics.f(asString, "json.get(SCENE_CONFIG_KEY_ID)?.asString ?: \"\"");
                        }
                        f79585b.put(asString, asJsonObject);
                    }
                }
            }
            HashMap<String, JsonObject> map2 = f79585b;
            if (map2.containsKey(str)) {
                return map2.get(str);
            }
            Result.m163constructorimpl(Unit.f68710a);
            return null;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public final String c() {
        Object objM163constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(AdMmkv.f50558a.b().getString("non_ad_scene_config_data", ""));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
            objM163constructorimpl = null;
        }
        return (String) objM163constructorimpl;
    }

    public final String d() {
        return AdMmkv.f50558a.b().getString("non_ad_scene_version", "");
    }

    public final boolean e() {
        return !TextUtils.isEmpty(AdMmkv.f50558a.b().getString("non_ad_scene_config_data", ""));
    }

    public final void f(String assetsString) {
        Intrinsics.g(assetsString, "assetsString");
        AdMmkv.f50558a.b().putString("non_ad_scene_config_data", assetsString);
        com.transsion.ad.a.b(com.transsion.ad.a.f50276a, a() + " --> setScene4Assets() --> 场景信息保存到MMKV --> success", false, 2, null);
    }

    public final void g(MbAdPlansDto mbAdPlansDto) {
        Intrinsics.g(mbAdPlansDto, "mbAdPlansDto");
        AdMmkv adMmkv = AdMmkv.f50558a;
        String string = adMmkv.b().getString("non_ad_scene_version", "");
        MbAdPlansBean data = mbAdPlansDto.getData();
        if (TextUtils.equals(string, data != null ? data.getVersionAdScene() : null)) {
            return;
        }
        MMKV mmkvB = adMmkv.b();
        MbAdPlansBean data2 = mbAdPlansDto.getData();
        mmkvB.putString("non_ad_scene_version", data2 != null ? data2.getVersionAdScene() : null);
        MMKV mmkvB2 = adMmkv.b();
        MbAdPlansBean data3 = mbAdPlansDto.getData();
        mmkvB2.putString("non_ad_scene_config_data", data3 != null ? data3.getAdSceneConfigData() : null);
        com.transsion.ad.a aVar = com.transsion.ad.a.f50276a;
        String strA = a();
        MbAdPlansBean data4 = mbAdPlansDto.getData();
        com.transsion.ad.a.b(aVar, strA + " --> setSceneConfig() --> 场景信息保存到MMKV --> success --> newVersion = " + (data4 != null ? data4.getVersionAdScene() : null), false, 2, null);
    }
}
