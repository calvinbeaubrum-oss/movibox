package com.google.android.gms.internal.ads;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLU;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeu {
    public static void zza() throws zzet {
        StringBuilder sb2 = new StringBuilder();
        boolean z11 = false;
        while (true) {
            int iGlGetError = GLES20.glGetError();
            if (iGlGetError == 0) {
                break;
            }
            if (z11) {
                sb2.append('\n');
            }
            String strGluErrorString = GLU.gluErrorString(iGlGetError);
            if (strGluErrorString == null) {
                strGluErrorString = "error code: 0x".concat(String.valueOf(Integer.toHexString(iGlGetError)));
            }
            sb2.append("glError: ");
            sb2.append(strGluErrorString);
            z11 = true;
        }
        if (z11) {
            throw new zzet(sb2.toString());
        }
    }

    public static void zzb(boolean z11, String str) throws zzet {
        if (!z11) {
            throw new zzet(str);
        }
    }

    public static boolean zzc(Context context) {
        int i11 = zzfy.zza;
        if (i11 < 24) {
            return false;
        }
        if (i11 < 26 && ("samsung".equals(zzfy.zzc) || "XT1650".equals(zzfy.zzd))) {
            return false;
        }
        if (i11 >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) {
            return zzes.zzk("EGL_EXT_protected_content");
        }
        return false;
    }

    public static boolean zzd() {
        int i11 = zzfy.zza;
        return zzes.zzk("EGL_KHR_surfaceless_context");
    }
}
