package com.transsion.baselib.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import com.blankj.utilcode.util.Utils;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f51308a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, ArrayList<String>> f51309b = new HashMap<>();

    @JvmStatic
    public static final String c(Context context) {
        Intrinsics.g(context, "context");
        ArrayList<String> arrayListD = f51308a.d(context, "SHA1");
        if (arrayListD == null || !(!arrayListD.isEmpty())) {
            return "";
        }
        String str = arrayListD.get(0);
        Intrinsics.f(str, "mlist[0]");
        return str;
    }

    public final String a(Context context) {
        Intrinsics.g(context, "context");
        ArrayList<String> arrayListD = d(context, "MD5");
        if (arrayListD == null || arrayListD.isEmpty()) {
            return "";
        }
        String str = arrayListD.get(0);
        Intrinsics.f(str, "list[0]");
        return str;
    }

    public final String b(Context context) {
        Intrinsics.g(context, "context");
        ArrayList<String> arrayListD = d(context, "SHA256");
        if (arrayListD == null || arrayListD.isEmpty()) {
            return "";
        }
        String str = arrayListD.get(0);
        Intrinsics.f(str, "list[0]");
        return str;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0061  */
    public final ArrayList<String> d(Context context, String str) {
        String strE;
        ArrayList<String> arrayList = null;
        if (context != null && str != null) {
            String packageName = context.getPackageName();
            if (packageName == null) {
                return null;
            }
            ArrayList<String> arrayList2 = f51309b.get(str);
            if (arrayList2 != null) {
                return arrayList2;
            }
            arrayList = new ArrayList<>();
            try {
                for (Signature signature : f(context, packageName)) {
                    int iHashCode = str.hashCode();
                    if (iHashCode != -1850268089) {
                        if (iHashCode != 76158) {
                            if (iHashCode == 2543909 && str.equals("SHA1")) {
                                strE = e(signature, "SHA1");
                            } else {
                                strE = "error!";
                            }
                        } else if (str.equals("MD5")) {
                            strE = e(signature, "MD5");
                        } else {
                            strE = "error!";
                        }
                    } else if (str.equals("SHA256")) {
                        strE = e(signature, "SHA256");
                    } else {
                        strE = "error!";
                    }
                    arrayList.add(strE);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            f51309b.put(str, arrayList);
        }
        return arrayList;
    }

    public final String e(Signature signature, String str) {
        try {
            byte[] digestBytes = MessageDigest.getInstance(str).digest(signature.toByteArray());
            StringBuilder sb2 = new StringBuilder();
            Intrinsics.f(digestBytes, "digestBytes");
            for (byte b11 : digestBytes) {
                String hexString = Integer.toHexString((b11 & 255) | 256);
                Intrinsics.f(hexString, "toHexString((digestByte.…Int() and 0xFF) or 0x100)");
                String strSubstring = hexString.substring(1, 3);
                Intrinsics.f(strSubstring, "substring(...)");
                String upperCase = strSubstring.toUpperCase(Locale.ROOT);
                Intrinsics.f(upperCase, "toUpperCase(...)");
                sb2.append(upperCase);
                sb2.append(":");
            }
            return sb2.substring(0, sb2.length() - 1).toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public final Signature[] f(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (Build.VERSION.SDK_INT >= 28) {
                Signature[] apkContentsSigners = packageManager.getPackageInfo(Utils.a().getPackageName(), ASTNode.NOJIT).signingInfo.getApkContentsSigners();
                Intrinsics.f(apkContentsSigners, "pi.signingInfo.apkContentsSigners");
                return apkContentsSigners;
            }
            Signature[] signatureArr = packageManager.getPackageInfo(Utils.a().getPackageName(), 64).signatures;
            Intrinsics.f(signatureArr, "pi.signatures");
            return signatureArr;
        } catch (Exception e11) {
            e11.printStackTrace();
            return new Signature[0];
        }
    }
}
