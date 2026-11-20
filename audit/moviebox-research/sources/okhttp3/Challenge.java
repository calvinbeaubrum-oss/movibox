package okhttp3;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.s;
import kotlin.jvm.JvmName;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class Challenge {
    private final Map<String, String> authParams;
    private final String scheme;

    /* JADX WARN: Illegal instructions before constructor call */
    public Challenge(String scheme, String realm) {
        Intrinsics.g(scheme, "scheme");
        Intrinsics.g(realm, "realm");
        Map mapSingletonMap = Collections.singletonMap("realm", realm);
        Intrinsics.f(mapSingletonMap, "singletonMap(\"realm\", realm)");
        this(scheme, (Map<String, String>) mapSingletonMap);
    }

    public Challenge(String scheme, Map<String, String> authParams) {
        String lowerCase;
        Intrinsics.g(scheme, "scheme");
        Intrinsics.g(authParams, "authParams");
        this.scheme = scheme;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : authParams.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null) {
                Locale US = Locale.US;
                Intrinsics.f(US, "US");
                lowerCase = key.toLowerCase(US);
                Intrinsics.f(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            } else {
                lowerCase = null;
            }
            linkedHashMap.put(lowerCase, value);
        }
        Map<String, String> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        Intrinsics.f(mapUnmodifiableMap, "unmodifiableMap<String?, String>(newAuthParams)");
        this.authParams = mapUnmodifiableMap;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_authParams, reason: not valid java name */
    public final Map<String, String> m198deprecated_authParams() {
        return this.authParams;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_charset, reason: not valid java name */
    public final Charset m199deprecated_charset() {
        return charset();
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_realm, reason: not valid java name */
    public final String m200deprecated_realm() {
        return realm();
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_scheme, reason: not valid java name */
    public final String m201deprecated_scheme() {
        return this.scheme;
    }

    @JvmName
    public final Map<String, String> authParams() {
        return this.authParams;
    }

    @JvmName
    public final Charset charset() {
        String str = this.authParams.get("charset");
        if (str != null) {
            try {
                Charset charsetForName = Charset.forName(str);
                Intrinsics.f(charsetForName, "Charset.forName(charset)");
                return charsetForName;
            } catch (Exception unused) {
            }
        }
        Charset ISO_8859_1 = StandardCharsets.ISO_8859_1;
        Intrinsics.f(ISO_8859_1, "ISO_8859_1");
        return ISO_8859_1;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Challenge) {
            Challenge challenge = (Challenge) obj;
            if (Intrinsics.b(challenge.scheme, this.scheme) && Intrinsics.b(challenge.authParams, this.authParams)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((899 + this.scheme.hashCode()) * 31) + this.authParams.hashCode();
    }

    @JvmName
    public final String realm() {
        return this.authParams.get("realm");
    }

    @JvmName
    public final String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.scheme + " authParams=" + this.authParams;
    }

    public final Challenge withCharset(Charset charset) {
        Intrinsics.g(charset, "charset");
        Map mapV = s.v(this.authParams);
        String strName = charset.name();
        Intrinsics.f(strName, "charset.name()");
        mapV.put("charset", strName);
        return new Challenge(this.scheme, (Map<String, String>) mapV);
    }
}
