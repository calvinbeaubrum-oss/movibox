package c00;

import com.alibaba.android.arouter.facade.Postcard;
import com.blankj.utilcode.util.n;
import com.transsion.web.bean.ApiRequestData;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14537a = new a();

    public final Map<String, Object> a(JSONObject jSONObject) throws JSONException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> itKeys = jSONObject != null ? jSONObject.keys() : null;
        while (itKeys != null && itKeys.hasNext()) {
            String key = itKeys.next();
            Object value = jSONObject.get(key);
            Intrinsics.f(key, "key");
            Intrinsics.f(value, "value");
            linkedHashMap.put(key, value);
        }
        return linkedHashMap;
    }

    public final void b(Postcard postcard, Map<String, Object> params) {
        Intrinsics.g(postcard, "postcard");
        Intrinsics.g(params, "params");
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                postcard.withString(key, (String) value);
            } else if (value instanceof Integer) {
                postcard.withInt(key, ((Number) value).intValue());
            } else if (value instanceof Boolean) {
                postcard.withBoolean(key, ((Boolean) value).booleanValue());
            } else if (value instanceof Double) {
                postcard.withDouble(key, ((Number) value).doubleValue());
            } else if (value instanceof Float) {
                postcard.withFloat(key, ((Number) value).floatValue());
            } else if (value instanceof Long) {
                postcard.withLong(key, ((Number) value).longValue());
            } else if (value instanceof Byte) {
                postcard.withByte(key, ((Number) value).byteValue());
            } else if (value instanceof Character) {
                postcard.withChar(key, ((Character) value).charValue());
            } else if (value instanceof char[]) {
                postcard.withCharArray(key, (char[]) value);
            } else if (value instanceof Serializable) {
                postcard.withSerializable(key, (Serializable) value);
            } else {
                postcard.withObject(key, value);
            }
        }
    }

    public final ApiRequestData c(String str) {
        try {
            return (ApiRequestData) n.d(str, ApiRequestData.class);
        } catch (Throwable unused) {
            return null;
        }
    }
}
