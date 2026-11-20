package com.cloud.tupdate.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.Log;
import com.applovin.sdk.AppLovinMediationProvider;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.cloud.tupdate.bean.UpdateContent;
import com.cloud.tupdate.net.utils.LogUtil;
import com.transsion.core.deviceinfo.DeviceInfo;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.mvel2.ast.ASTNode;

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
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f32241a = new d();

    public final void a(Context context, Dialog dialog, UpdateContent updateContent) {
        if (updateContent == null) {
            return;
        }
        try {
            if (Intrinsics.b(updateContent.getForce(), Boolean.FALSE) && dialog != null) {
                dialog.dismiss();
            }
        } catch (Exception e11) {
            LogUtil.f32213a.d(e11);
        }
    }

    public final String b(Context context) {
        Exception e11;
        String str;
        if (context == null) {
            return "";
        }
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            Intrinsics.f(str, "packageInfo.versionName");
            try {
                return str.length() == 0 ? "" : str;
            } catch (Exception e12) {
                e11 = e12;
                a.j().a(Log.getStackTraceString(e11));
            }
        } catch (Exception e13) {
            e11 = e13;
            str = "";
        }
    }

    public final String c() {
        String BRAND = Build.BRAND;
        if (BRAND == null || kotlin.text.l.y(BRAND)) {
            return "";
        }
        Intrinsics.f(BRAND, "BRAND");
        return BRAND;
    }

    public final String d() {
        String str;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Object objInvoke = cls.getMethod("get", String.class, String.class).invoke(cls, "persist.sys.oobe_country", AppLovinMediationProvider.UNKNOWN);
            if (objInvoke == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            str = (String) objInvoke;
            try {
                if (!kotlin.text.l.y(str) && !Intrinsics.b(AppLovinMediationProvider.UNKNOWN, str)) {
                    return str;
                }
                Locale localeE = e();
                return String.valueOf(localeE == null ? null : localeE.getCountry());
            } catch (Exception e11) {
                a.j().a(Log.getStackTraceString(e11));
                return "";
            }
        } catch (Exception e12) {
            a.j().a(Log.getStackTraceString(e12));
            str = "";
        }
    }

    public final Locale e() {
        try {
            return Build.VERSION.SDK_INT >= 24 ? LocaleList.getDefault().get(0) : Locale.getDefault();
        } catch (Exception e11) {
            Locale locale = Locale.getDefault();
            a.j().a(Log.getStackTraceString(e11));
            return locale;
        }
    }

    public final String f() {
        try {
            String deviceOperator = DeviceInfo.f();
            if (TextUtils.isEmpty(deviceOperator) || deviceOperator.length() < 3) {
                return "";
            }
            Intrinsics.f(deviceOperator, "deviceOperator");
            String strSubstring = deviceOperator.substring(0, 3);
            Intrinsics.f(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring;
        } catch (Exception e11) {
            a.j().a(Log.getStackTraceString(e11));
            return "";
        }
    }

    public final PackageInfo g(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public final String h() {
        String language;
        Locale localeE = e();
        return (localeE == null || (language = localeE.getLanguage()) == null) ? "" : language;
    }

    public final int i(Context context) {
        Intrinsics.g(context, "context");
        PackageInfo packageInfoG = g(context);
        if (packageInfoG == null) {
            return -1;
        }
        try {
            return packageInfoG.versionCode;
        } catch (Exception e11) {
            a.j().a(Log.getStackTraceString(e11));
            return -1;
        }
    }

    public final String j(Context context) {
        Intrinsics.g(context, "context");
        PackageInfo packageInfoG = g(context);
        if (packageInfoG == null) {
            return "";
        }
        String str = packageInfoG.versionName;
        Intrinsics.f(str, "packageInfo.versionName");
        return str;
    }

    public final void k(Context context, String str) {
        Intrinsics.g(context, "context");
        if (str == null || kotlin.text.l.y(str)) {
            return;
        }
        if (kotlin.text.l.L(str, "http://", false, 2, null) || kotlin.text.l.L(str, AgentPageJsBridge.HTTPS, false, 2, null)) {
            m(context, str);
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (!(context instanceof Activity)) {
                intent.addFlags(ASTNode.DEOP);
            }
            context.startActivity(intent);
        } catch (Exception unused) {
            n(context, false);
        }
    }

    public final void l(UpdateContent updateContent, te.e updateManager, Dialog dialog) {
        Context context;
        Intrinsics.g(updateManager, "updateManager");
        String updateUrl = updateContent == null ? null : updateContent.getUpdateUrl();
        if (updateUrl == null || kotlin.text.l.y(updateUrl) || (context = updateManager.getContext()) == null) {
            return;
        }
        if (!kotlin.text.l.L(updateUrl, "http://", false, 2, null) && !kotlin.text.l.L(updateUrl, AgentPageJsBridge.HTTPS, false, 2, null)) {
            o(context, updateContent, dialog);
        } else {
            a(context, dialog, updateContent);
            m(context, updateUrl);
        }
    }

    public final void m(Context context, String str) {
        if (context == null || str == null || kotlin.text.l.y(str)) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            if (!(context instanceof Activity)) {
                intent.addFlags(ASTNode.DEOP);
            }
            context.startActivity(intent);
        } catch (Exception e11) {
            LogUtil.f32213a.d(e11);
        }
    }

    public final void n(Context context, boolean z11) {
        Bundle bundle = new Bundle();
        bundle.putString("page", z11 ? "upgrade" : "score");
        bundle.putString("action", z11 ? "upgrade_click" : "score_click");
        bundle.putString("button_type", z11 ? "upgrade" : "score");
        bundle.putString("action_url", "http://www.palmplaystore.com/");
        b.f32235a.i("open_palmstore_home", bundle);
        m(context, "http://www.palmplaystore.com/");
    }

    public final void o(Context context, UpdateContent updateContent, Dialog dialog) {
        String updateUrl = updateContent == null ? null : updateContent.getUpdateUrl();
        if (updateUrl == null || kotlin.text.l.y(updateUrl) || context == null) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(updateUrl));
            if (!(context instanceof Activity)) {
                intent.addFlags(ASTNode.DEOP);
            }
            a(context, dialog, updateContent);
            context.startActivity(intent);
        } catch (Exception unused) {
            n(context, true);
        }
    }

    public final String p() {
        String RELEASE = Build.VERSION.RELEASE;
        if (RELEASE == null || kotlin.text.l.y(RELEASE)) {
            return "";
        }
        Intrinsics.f(RELEASE, "RELEASE");
        return RELEASE;
    }
}
