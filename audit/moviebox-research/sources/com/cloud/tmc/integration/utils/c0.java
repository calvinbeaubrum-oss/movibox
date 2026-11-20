package com.cloud.tmc.integration.utils;

import android.content.Context;
import android.content.res.Resources;
import android.telephony.TelephonyManager;
import com.cloud.tmc.kernel.log.TmcLogger;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f31035a = new c0();

    @JvmStatic
    public static final String a(Context context) {
        if (context == null) {
            return "";
        }
        try {
            TelephonyManager telephonyManagerB = xb.f.b(context);
            String simCountryIso = telephonyManagerB != null ? telephonyManagerB.getSimCountryIso() : null;
            if (simCountryIso == null) {
                simCountryIso = "";
            }
            if (simCountryIso.length() == 0) {
                return b(context);
            }
            Locale US = Locale.US;
            Intrinsics.f(US, "US");
            String upperCase = simCountryIso.toUpperCase(US);
            Intrinsics.f(upperCase, "this as java.lang.String).toUpperCase(locale)");
            return upperCase;
        } catch (Throwable unused) {
            return "";
        }
    }

    @JvmStatic
    public static final String b(Context context) {
        Intrinsics.g(context, "context");
        try {
            Locale localeF = f();
            String country = localeF != null ? localeF.getCountry() : null;
            if (country == null) {
                country = "";
            }
            Locale US = Locale.US;
            Intrinsics.f(US, "US");
            String upperCase = country.toUpperCase(US);
            Intrinsics.f(upperCase, "this as java.lang.String).toUpperCase(locale)");
            return upperCase;
        } catch (Throwable unused) {
            return "";
        }
    }

    @JvmStatic
    public static final String c(Context context) {
        Intrinsics.g(context, "context");
        try {
            TelephonyManager telephonyManagerB = xb.f.b(context);
            String simCountryIso = telephonyManagerB != null ? telephonyManagerB.getSimCountryIso() : null;
            if (simCountryIso == null) {
                simCountryIso = "";
            }
            Locale US = Locale.US;
            Intrinsics.f(US, "US");
            String upperCase = simCountryIso.toUpperCase(US);
            Intrinsics.f(upperCase, "this as java.lang.String).toUpperCase(locale)");
            return upperCase;
        } catch (Throwable unused) {
            return "";
        }
    }

    @JvmStatic
    public static final Locale f() {
        try {
            androidx.core.os.h hVarA = androidx.core.os.e.a(Resources.getSystem().getConfiguration());
            Intrinsics.f(hVarA, "getLocales(Resources.getSystem().configuration)");
            return hVarA.f() ? Locale.getDefault() : hVarA.d(0);
        } catch (Throwable unused) {
            return Locale.getDefault();
        }
    }

    @JvmStatic
    public static final String g(Context context) {
        Intrinsics.g(context, "context");
        String strI = i(context);
        if (strI.length() < 3) {
            return "";
        }
        String strSubstring = strI.substring(0, 3);
        Intrinsics.f(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @JvmStatic
    public static final String h(Context context) {
        Intrinsics.g(context, "context");
        String strI = i(context);
        if (strI.length() < 3) {
            return "";
        }
        String strSubstring = strI.substring(3);
        Intrinsics.f(strSubstring, "this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    @JvmStatic
    public static final String i(Context context) {
        Intrinsics.g(context, "context");
        try {
            TelephonyManager telephonyManagerB = xb.f.b(context);
            String simOperator = telephonyManagerB != null ? telephonyManagerB.getSimOperator() : null;
            return simOperator == null ? "" : simOperator;
        } catch (Throwable unused) {
            return "";
        }
    }

    public final String d(Context context) {
        Intrinsics.g(context, "context");
        String strC = c(context);
        return strC.length() > 0 ? strC : b(context);
    }

    public final String e() {
        try {
            String language = Locale.getDefault().getLanguage();
            Intrinsics.f(language, "{\n            Locale.get…ault().language\n        }");
            return language;
        } catch (Throwable th2) {
            TmcLogger.h("getLanguage", th2);
            return "";
        }
    }
}
