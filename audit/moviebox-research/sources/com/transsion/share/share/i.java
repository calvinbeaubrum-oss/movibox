package com.transsion.share.share;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f57758a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f57759b = "https://play.google.com/store/apps/details?id=com.community.oneroom";

    /* JADX WARN: Code duplicated, block: B:12:0x0034 A[Catch: Exception -> 0x0030, TRY_LEAVE, TryCatch #0 {Exception -> 0x0030, blocks: (B:4:0x0007, B:7:0x000e, B:9:0x0027, B:12:0x0034), top: B:18:0x0007 }] */
    public final void a(Activity activity, String str, Uri uri, Function1<? super Boolean, Unit> function1) {
        Intrinsics.g(activity, "activity");
        if (str != null) {
            try {
                if (str.length() != 0) {
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType("image/*");
                    intent.putExtra("android.intent.extra.STREAM", uri);
                    intent.setPackage(str);
                    activity.startActivity(intent);
                    if (function1 != null) {
                        function1.invoke(Boolean.TRUE);
                    }
                } else if (function1 != null) {
                    function1.invoke(Boolean.FALSE);
                }
            } catch (Exception unused) {
                if (function1 != null) {
                    function1.invoke(Boolean.FALSE);
                }
            }
        } else if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x003f  */
    /* JADX WARN: Code duplicated, block: B:20:? A[RETURN, SYNTHETIC] */
    public final void b(Activity activity, Uri uri, Function1<? super Boolean, Unit> function1) {
        Intrinsics.g(activity, "activity");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/*");
        intent.putExtra("android.intent.extra.STREAM", uri);
        try {
            try {
                intent.setPackage("org.telegram.messenger");
                activity.startActivity(intent);
                if (function1 != null) {
                    function1.invoke(Boolean.TRUE);
                    return;
                }
                return;
            } catch (Exception unused) {
                if (function1 != null) {
                    function1.invoke(Boolean.FALSE);
                }
            }
        } catch (ActivityNotFoundException unused2) {
            intent.setPackage("org.thunderdog.challegram");
            activity.startActivity(intent);
            if (function1 != null) {
                function1.invoke(Boolean.TRUE);
                return;
            }
            return;
        }
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0047  */
    /* JADX WARN: Code duplicated, block: B:20:? A[RETURN, SYNTHETIC] */
    public final void c(Activity activity, String shareContent, Function1<? super Boolean, Unit> function1) {
        Intrinsics.g(activity, "activity");
        Intrinsics.g(shareContent, "shareContent");
        Intent intent = new Intent();
        try {
            try {
                intent.setAction("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.TEXT", shareContent);
                intent.setType("text/plain");
                intent.setPackage("org.telegram.messenger");
                activity.startActivity(intent);
                if (function1 != null) {
                    function1.invoke(Boolean.TRUE);
                    return;
                }
                return;
            } catch (Exception unused) {
                if (function1 != null) {
                    function1.invoke(Boolean.FALSE);
                }
            }
        } catch (ActivityNotFoundException unused2) {
            intent.setPackage("org.thunderdog.challegram");
            activity.startActivity(intent);
            if (function1 != null) {
                function1.invoke(Boolean.TRUE);
                return;
            }
            return;
        }
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
    }

    public final void d(Activity activity, String shareContent, Function1<? super Boolean, Unit> function1) {
        Intrinsics.g(activity, "activity");
        Intrinsics.g(shareContent, "shareContent");
        try {
            Intent intent = new Intent();
            Uri uri = Uri.parse("whatsapp://send?text=" + Uri.encode(shareContent));
            intent.setAction("android.intent.action.VIEW");
            intent.setData(uri);
            activity.startActivity(intent);
            if (function1 != null) {
                function1.invoke(Boolean.TRUE);
            }
        } catch (Exception unused) {
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
            }
        }
    }
}
