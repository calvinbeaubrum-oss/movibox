package com.transsion.ad.strategy;

import android.net.Uri;
import android.text.TextUtils;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.l;

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
@SourceDebugExtension
public final class AdUrlParameterReplaceManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AdUrlParameterReplaceManager f50563a = new AdUrlParameterReplaceManager();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public enum UrlParameterReplaceEnum {
        GAID("GAID"),
        CUSTOM_USER_ID("CUSTOM_USER_ID");

        private final String value;

        UrlParameterReplaceEnum(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f50564a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f50565b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f50566c;

        public a(String key, String value, String type) {
            Intrinsics.g(key, "key");
            Intrinsics.g(value, "value");
            Intrinsics.g(type, "type");
            this.f50564a = key;
            this.f50565b = value;
            this.f50566c = type;
        }

        public final String a() {
            return this.f50564a;
        }

        public final String b() {
            return this.f50566c;
        }

        public final String c() {
            return this.f50565b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.b(this.f50564a, aVar.f50564a) && Intrinsics.b(this.f50565b, aVar.f50565b) && Intrinsics.b(this.f50566c, aVar.f50566c);
        }

        public int hashCode() {
            return (((this.f50564a.hashCode() * 31) + this.f50565b.hashCode()) * 31) + this.f50566c.hashCode();
        }

        public String toString() {
            return "UrlParameterReplaceEntity(key=" + this.f50564a + ", value=" + this.f50565b + ", type=" + this.f50566c + ")";
        }
    }

    public final String a(String url) {
        Intrinsics.g(url, "url");
        try {
            Result.Companion companion = Result.Companion;
            if (TextUtils.isEmpty(url)) {
                return url;
            }
            List<a> listF = wq.b.f79582a.f();
            if (listF.isEmpty()) {
                return url;
            }
            Uri uri = Uri.parse(url);
            Intrinsics.f(uri, "parse(url)");
            Set<String> queryParameterNames = uri.getQueryParameterNames();
            String strF = url;
            for (a aVar : listF) {
                if (queryParameterNames.contains(aVar.a()) && Intrinsics.b(uri.getQueryParameter(aVar.a()), aVar.c())) {
                    strF = strF;
                    if (Intrinsics.b(aVar.b(), UrlParameterReplaceEnum.GAID.getValue())) {
                        String strC = aVar.c();
                        String strE = DeviceUtil.e();
                        Intrinsics.f(strE, "getGAId()");
                        strF = l.F(strF, strC, strE, false, 4, null);
                    }
                    if (Intrinsics.b(aVar.b(), UrlParameterReplaceEnum.CUSTOM_USER_ID.getValue())) {
                        strF = l.F(strF, aVar.c(), "custom_use_id_ashdjhv1234dhb", false, 4, null);
                    }
                }
            }
            com.transsion.ad.a.t(com.transsion.ad.a.f50276a, "AdUrlParameterReplaceManager --> replaceParameter() --> url = " + url + " --> replaceList = " + listF + " --> newUrl = " + ((Object) strF), false, 2, null);
            return strF;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Object objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
            Object obj = url;
            if (Result.m166exceptionOrNullimpl(objM163constructorimpl) == null) {
                obj = objM163constructorimpl;
            }
            return (String) obj;
        }
    }
}
