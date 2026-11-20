package com.transsion.baselib.helper;

import android.net.Uri;
import android.text.TextUtils;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.common.base.p;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.transsion.core.utils.ToastUtil;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;

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
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f51184a = new b();

    public final ReferrerBean a(Uri uri) {
        String queryParameter;
        String string;
        ReferrerBean referrerBean = new ReferrerBean(null, null, null, null, null, 31, null);
        if (StringsKt__StringsKt.Q(String.valueOf(uri != null ? uri.getPath() : null), "/share", false, 2, null)) {
            referrerBean.setUtmSource(AppLovinEventTypes.USER_SHARED_LINK);
        } else {
            if (uri != null && (string = uri.toString()) != null && StringsKt__StringsKt.Q(string, "utm_source", false, 2, null)) {
                Uri uri2 = Uri.parse("?" + uri);
                String strValueOf = String.valueOf(uri2.getQueryParameter("utm_source"));
                referrerBean.setUtmContent(uri2.getQueryParameter("utm_content"));
                referrerBean.setUtmCampaign(uri2.getQueryParameter("utm_campaign"));
                if (!TextUtils.isEmpty(strValueOf)) {
                    referrerBean.setUtmSource(strValueOf);
                    return referrerBean;
                }
            }
            String str = "";
            if (!TextUtils.isEmpty(uri != null ? uri.getQueryParameter("utm_source") : null) ? !(uri == null || (queryParameter = uri.getQueryParameter("utm_source")) == null) : !(uri == null || (queryParameter = uri.getQueryParameter("channel")) == null)) {
                str = queryParameter;
            }
            referrerBean.setUtmSource(str);
            referrerBean.setUtmContent(uri != null ? uri.getQueryParameter("utm_content") : null);
            referrerBean.setUtmCampaign(uri != null ? uri.getQueryParameter("utm_campaign") : null);
        }
        return referrerBean;
    }

    public final ReferrerBean b(String str) {
        return (str == null || str.length() == 0) ? new ReferrerBean(null, null, null, null, null, 31, null) : a(Uri.parse(str));
    }

    /* JADX WARN: Code duplicated, block: B:12:0x001f  */
    /* JADX WARN: Code duplicated, block: B:14:0x0029 A[RETURN, SYNTHETIC] */
    public final boolean c(Uri uri) {
        if (!Intrinsics.b(uri != null ? uri.getScheme() : null, "https")) {
            if (Intrinsics.b(uri != null ? uri.getScheme() : null, HttpHost.DEFAULT_SCHEME_NAME)) {
                if (p.b(uri.getQuery())) {
                    return true;
                }
            }
        } else if (p.b(uri.getQuery())) {
            return true;
        }
        return false;
    }

    public final Uri d(Uri uri) {
        Object objM163constructorimpl;
        if (uri == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            String queryParameter = uri.getQueryParameter("type");
            String str = "";
            if (queryParameter == null) {
                queryParameter = "";
            }
            Intrinsics.f(queryParameter, "uri.getQueryParameter(QUERY_TYPE) ?: \"\"");
            if (queryParameter.length() > 0) {
                return uri.buildUpon().path(queryParameter).build();
            }
            HashMap map = new HashMap();
            map.put("subject", "/movie/detail");
            map.put("post", "/post/detail");
            String string = uri.toString();
            Intrinsics.f(string, "uri.toString()");
            if (!TextUtils.isEmpty(string)) {
                List listE0 = StringsKt__StringsKt.E0(string, new String[]{"-"}, false, 0, 6, null);
                if (listE0.size() >= 2) {
                    String str2 = (String) map.get(listE0.get(0));
                    String str3 = (String) listE0.get(1);
                    return new Uri.Builder().encodedPath(str2).encodedQuery("id=" + str3).build();
                }
            }
            String path = uri.getPath();
            if (path != null) {
                str = path;
            }
            Intrinsics.f(str, "uri.path ?: \"\"");
            int i11 = 0;
            for (int i12 = 0; i12 < str.length(); i12++) {
                if (str.charAt(i12) == '/') {
                    i11++;
                }
            }
            if (i11 < 2) {
                return null;
            }
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
            if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
                ToastUtil.e("请升级最新版本");
            }
            return uri;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
    }
}
