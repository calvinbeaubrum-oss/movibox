package com.cloud.tupdate.net.utils;

import com.applovin.sdk.AppLovinMediationProvider;
import java.util.Map;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.l;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class CollectionUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CollectionUtil f32211a = new CollectionUtil();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f32212b = "";

    private CollectionUtil() {
    }

    public final String a() {
        if (!c(f32212b)) {
            String str = f32212b;
            Intrinsics.d(str);
            return str;
        }
        TimeZone timeZone = TimeZone.getDefault();
        String id2 = timeZone.getID();
        if (c(id2)) {
            String displayName = timeZone.getDisplayName(false, 0);
            if (c(displayName)) {
                f32212b = "";
                displayName = AppLovinMediationProvider.UNKNOWN;
            } else {
                f32212b = displayName;
            }
            id2 = displayName;
            Intrinsics.f(id2, "{\n            val name =…e\n            }\n        }");
        } else {
            f32212b = id2;
            Intrinsics.f(id2, "{\n            zoneStr = …\n            id\n        }");
        }
        return id2;
    }

    public final String b(Map<String, ? extends Object> map) {
        if (map == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            stringBuffer.append(entry.getKey() + '=' + entry.getValue());
            stringBuffer.append("&");
        }
        String string = stringBuffer.toString();
        Intrinsics.f(string, "sb.toString()");
        if (!l.u(string, "&", false, 2, null)) {
            return string;
        }
        String strSubstring = string.substring(0, string.length() - 2);
        Intrinsics.f(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final boolean c(String str) {
        return str == null || str.length() == 0;
    }

    public final boolean d(Map<?, ?> map) {
        return (map == null || map.isEmpty()) ? false : true;
    }
}
