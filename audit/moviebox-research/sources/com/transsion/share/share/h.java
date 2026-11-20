package com.transsion.share.share;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.transsion.share.R$string;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f57754a = new h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f57755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f57756c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f57757d;

    static {
        f57755b = Build.VERSION.SDK_INT < 33 ? new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"} : new String[]{"android.permission.READ_MEDIA_VIDEO"};
    }

    public static /* synthetic */ boolean e(h hVar, int i11, long j11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            j11 = AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS;
        }
        return hVar.d(i11, j11);
    }

    public static final void g(Function0 onConfirm, DialogInterface dialogInterface, int i11) {
        Intrinsics.g(onConfirm, "$onConfirm");
        onConfirm.invoke();
        dialogInterface.dismiss();
    }

    public static final void h(DialogInterface dialogInterface, int i11) {
        dialogInterface.dismiss();
    }

    public static /* synthetic */ void j(h hVar, Activity activity, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 14;
        }
        hVar.i(activity, i11);
    }

    public final String[] c() {
        return f57755b;
    }

    public final boolean d(int i11, long j11) {
        if (f57757d != i11) {
            f57757d = i11;
            f57756c = System.currentTimeMillis();
            return false;
        }
        if (System.currentTimeMillis() - f57756c <= j11) {
            return true;
        }
        f57757d = i11;
        f57756c = System.currentTimeMillis();
        return false;
    }

    public final void f(Context context, String title, String message, final Function0<Unit> onConfirm) {
        Intrinsics.g(context, "context");
        Intrinsics.g(title, "title");
        Intrinsics.g(message, "message");
        Intrinsics.g(onConfirm, "onConfirm");
        androidx.appcompat.app.c.a aVar = new androidx.appcompat.app.c.a(context);
        aVar.setTitle(title);
        aVar.d(message);
        aVar.g(context.getString(R$string.system_settings), new DialogInterface.OnClickListener() { // from class: com.transsion.share.share.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                h.g(onConfirm, dialogInterface, i11);
            }
        });
        aVar.e(context.getString(R$string.cancel), new DialogInterface.OnClickListener() { // from class: com.transsion.share.share.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                h.h(dialogInterface, i11);
            }
        });
        androidx.appcompat.app.c cVarCreate = aVar.create();
        Intrinsics.f(cVarCreate, "builder.create()");
        cVarCreate.show();
    }

    public final void i(Activity activity, int i11) {
        Intrinsics.g(activity, "activity");
        String packageName = activity.getPackageName();
        Intrinsics.f(packageName, "activity.packageName");
        Intent intent = new Intent("com.android.setting.ACTION_GET_PERMISSION_DETAILS");
        intent.putExtra("packagename", packageName);
        intent.addFlags(ASTNode.DEOP);
        try {
            try {
                try {
                    if (i11 > 0) {
                        activity.startActivityForResult(intent, i11);
                    } else {
                        activity.startActivity(intent);
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            } catch (ActivityNotFoundException unused) {
                Intent intent2 = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
                intent2.addFlags(ASTNode.DEOP);
                if (i11 > 0) {
                    activity.startActivityForResult(intent2, i11);
                } else {
                    activity.startActivity(intent2);
                }
            }
        } catch (ActivityNotFoundException unused2) {
            Intent intent3 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent3.setData(Uri.parse("package:" + packageName));
            intent3.addFlags(ASTNode.DEOP);
            if (i11 > 0) {
                activity.startActivityForResult(intent3, i11);
            } else {
                activity.startActivity(intent3);
            }
        } catch (Exception e12) {
            e12.printStackTrace();
        }
    }

    public final boolean k(int[] grantResults) {
        Intrinsics.g(grantResults, "grantResults");
        for (int i11 : grantResults) {
            if (i11 == -1) {
                return false;
            }
        }
        return true;
    }
}
