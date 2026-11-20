package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfrt {
    public static boolean zza(int i11) {
        int i12 = i11 - 1;
        return i12 == 2 || i12 == 4 || i12 == 5 || i12 == 6 || i12 == 7;
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:53:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:55:0x00da  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:76:0x0123 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:77:0x0125 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:78:0x0127 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:79:0x0129 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:80:0x012b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:81:0x012d  */
    /* JADX WARN: Code duplicated, block: B:82:0x0130  */
    /* JADX WARN: Code duplicated, block: B:83:0x0133  */
    /* JADX WARN: Code duplicated, block: B:84:0x0136  */
    /* JADX WARN: Code duplicated, block: B:85:0x0139  */
    /* JADX WARN: Code duplicated, block: B:86:0x013c  */
    /* JADX WARN: Code duplicated, block: B:87:0x013f  */
    public static final int zzb(Context context, zzfqr zzfqrVar) {
        int i11;
        String str;
        String strZzc;
        File file = new File(new File(context.getApplicationInfo().dataDir), "lib");
        if (file.exists()) {
            File[] fileArrListFiles = file.listFiles(new zzgcj(Pattern.compile(".*\\.so$", 2)));
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                zzfqrVar.zzb(5017, "No .so");
            } else {
                try {
                    FileInputStream fileInputStream = new FileInputStream(fileArrListFiles[0]);
                    try {
                        byte[] bArr = new byte[20];
                        if (fileInputStream.read(bArr) == 20) {
                            byte[] bArr2 = {0, 0};
                            if (bArr[5] == 2) {
                                zzd(bArr, null, context, zzfqrVar);
                            } else {
                                bArr2[0] = bArr[19];
                                bArr2[1] = bArr[18];
                                short s11 = ByteBuffer.wrap(bArr2).getShort();
                                if (s11 == 3) {
                                    fileInputStream.close();
                                    i11 = 5;
                                } else if (s11 == 40) {
                                    fileInputStream.close();
                                    i11 = 3;
                                } else if (s11 == 62) {
                                    fileInputStream.close();
                                    i11 = 7;
                                } else if (s11 == 183) {
                                    fileInputStream.close();
                                    i11 = 6;
                                } else if (s11 != 243) {
                                    zzd(bArr, null, context, zzfqrVar);
                                } else {
                                    fileInputStream.close();
                                    i11 = 8;
                                }
                            }
                        }
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                        throw th2;
                    }
                } catch (IOException e11) {
                    zzd(null, e11.toString(), context, zzfqrVar);
                }
                i11 = 1;
            }
            if (i11 == 1000) {
                strZzc = zzc(context, zzfqrVar);
                if (TextUtils.isEmpty(strZzc)) {
                    zzd(null, "Empty dev arch", context, zzfqrVar);
                } else if (!strZzc.equalsIgnoreCase("i686") || strZzc.equalsIgnoreCase("x86")) {
                    i11 = 5;
                } else if (strZzc.equalsIgnoreCase("x86_64")) {
                    i11 = 7;
                } else if (strZzc.equalsIgnoreCase("arm64-v8a")) {
                    i11 = 6;
                } else if (strZzc.equalsIgnoreCase("armeabi-v7a") || strZzc.equalsIgnoreCase("armv71")) {
                    i11 = 3;
                } else if (strZzc.equalsIgnoreCase("riscv64")) {
                    i11 = 8;
                } else {
                    zzd(null, strZzc, context, zzfqrVar);
                }
                i11 = 1;
            }
            if (i11 != 1) {
                str = "UNSUPPORTED";
            } else if (i11 != 3) {
                str = "ARM7";
            } else if (i11 != 5) {
                str = "X86";
            } else if (i11 != 6) {
                str = "ARM64";
            } else if (i11 != 7) {
                str = "X86_64";
            } else if (i11 != 8) {
                str = "null";
            } else {
                str = "RISCV64";
            }
            zzfqrVar.zzb(5018, str);
            return i11;
        }
        zzfqrVar.zzb(5017, "No lib/");
        i11 = 1000;
        if (i11 == 1000) {
            strZzc = zzc(context, zzfqrVar);
            if (TextUtils.isEmpty(strZzc)) {
                zzd(null, "Empty dev arch", context, zzfqrVar);
            } else if (strZzc.equalsIgnoreCase("i686")) {
                i11 = 5;
            } else {
                i11 = 5;
            }
            i11 = 1;
        }
        if (i11 != 1) {
            str = "UNSUPPORTED";
        } else if (i11 != 3) {
            str = "ARM7";
        } else if (i11 != 5) {
            str = "X86";
        } else if (i11 != 6) {
            str = "ARM64";
        } else if (i11 != 7) {
            str = "X86_64";
        } else if (i11 != 8) {
            str = "null";
        } else {
            str = "RISCV64";
        }
        zzfqrVar.zzb(5018, str);
        return i11;
    }

    private static final String zzc(Context context, zzfqr zzfqrVar) {
        HashSet hashSet = new HashSet(Arrays.asList("i686", "armv71"));
        String strZza = zzfxs.OS_ARCH.zza();
        if (!TextUtils.isEmpty(strZza) && hashSet.contains(strZza)) {
            return strZza;
        }
        try {
            String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get(null);
            if (strArr != null && strArr.length > 0) {
                return strArr[0];
            }
        } catch (IllegalAccessException e11) {
            zzfqrVar.zzc(2024, 0L, e11);
        } catch (NoSuchFieldException e12) {
            zzfqrVar.zzc(2024, 0L, e12);
        }
        String str = Build.CPU_ABI;
        return str != null ? str : Build.CPU_ABI2;
    }

    private static final void zzd(byte[] bArr, String str, Context context, zzfqr zzfqrVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("os.arch:");
        sb2.append(zzfxs.OS_ARCH.zza());
        sb2.append(";");
        try {
            String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get(null);
            if (strArr != null) {
                sb2.append("supported_abis:");
                sb2.append(Arrays.toString(strArr));
                sb2.append(";");
            }
        } catch (IllegalAccessException | NoSuchFieldException unused) {
        }
        sb2.append("CPU_ABI:");
        sb2.append(Build.CPU_ABI);
        sb2.append(";CPU_ABI2:");
        sb2.append(Build.CPU_ABI2);
        sb2.append(";");
        if (bArr != null) {
            sb2.append("ELF:");
            sb2.append(Arrays.toString(bArr));
            sb2.append(";");
        }
        if (str != null) {
            sb2.append("dbg:");
            sb2.append(str);
            sb2.append(";");
        }
        zzfqrVar.zzb(4007, sb2.toString());
    }
}
