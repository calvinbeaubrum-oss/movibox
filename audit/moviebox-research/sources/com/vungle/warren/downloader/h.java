package com.vungle.warren.downloader;

import android.text.TextUtils;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f62005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f62006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f62007c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f62008d;

    /* JADX WARN: Code duplicated, block: B:29:0x006c  */
    /* JADX WARN: Code duplicated, block: B:34:0x0081 A[PHI: r3
  0x0081: PHI (r3v1 java.lang.String) = 
  (r3v0 java.lang.String)
  (r3v0 java.lang.String)
  (r3v4 java.lang.String)
  (r3v4 java.lang.String)
  (r3v4 java.lang.String)
 binds: [B:3:0x000a, B:5:0x0018, B:10:0x0022, B:12:0x002a, B:14:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    public h(String str) {
        long j11;
        String str2;
        long j12;
        long j13;
        long j14 = -1;
        String str3 = null;
        if (TextUtils.isEmpty(str)) {
            j11 = -1;
            str2 = str3;
            j12 = -1;
        } else {
            String[] strArrSplit = str.trim().split("\\s+");
            if (strArrSplit.length < 2) {
                j11 = -1;
                str2 = str3;
                j12 = -1;
            } else {
                str3 = strArrSplit.length > 0 ? strArrSplit[0] : null;
                if (strArrSplit.length <= 1 || TextUtils.isEmpty(strArrSplit[1])) {
                    j11 = -1;
                    str2 = str3;
                    j12 = -1;
                } else {
                    String[] strArrSplit2 = strArrSplit[1].split("/");
                    if (strArrSplit2.length == 2) {
                        if (TextUtils.isEmpty(strArrSplit2[0])) {
                            j13 = -1;
                            j11 = -1;
                        } else {
                            String[] strArrSplit3 = strArrSplit2[0].split("-");
                            if (strArrSplit3.length != 2 || TextUtils.isEmpty(strArrSplit3[0]) || TextUtils.isEmpty(strArrSplit3[1])) {
                                j13 = -1;
                                j11 = -1;
                            } else {
                                try {
                                    j13 = Long.parseLong(strArrSplit3[0]);
                                } catch (Throwable unused) {
                                    j13 = -1;
                                }
                                try {
                                    j11 = Long.parseLong(strArrSplit3[1]);
                                } catch (Throwable unused2) {
                                    j11 = -1;
                                }
                            }
                        }
                        if (!TextUtils.isEmpty(strArrSplit2[1])) {
                            try {
                                j14 = Long.parseLong(strArrSplit2[1]);
                            } catch (Throwable unused3) {
                            }
                        }
                        str2 = str3;
                        long j15 = j14;
                        j14 = j13;
                        j12 = j15;
                    } else {
                        j11 = -1;
                        str2 = str3;
                        j12 = -1;
                    }
                }
            }
        }
        this.f62006b = j14;
        this.f62007c = j11;
        this.f62008d = j12;
        this.f62005a = str2;
    }
}
