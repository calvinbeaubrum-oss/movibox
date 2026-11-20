package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzfm extends BroadcastReceiver {
    final /* synthetic */ zzfn zza;

    public /* synthetic */ zzfm(zzfn zzfnVar, zzfl zzflVar) {
        this.zza = zzfnVar;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0036  */
    /* JADX WARN: Code duplicated, block: B:21:0x0038  */
    /* JADX WARN: Code duplicated, block: B:22:0x003a  */
    /* JADX WARN: Code duplicated, block: B:24:0x0041  */
    /* JADX WARN: Code duplicated, block: B:25:0x0043  */
    /* JADX WARN: Code duplicated, block: B:27:0x0049  */
    /* JADX WARN: Code duplicated, block: B:28:0x004c  */
    /* JADX WARN: Code duplicated, block: B:29:0x004e  */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        int i11 = 0;
        if (connectivityManager != null) {
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    i11 = 1;
                } else {
                    int type = activeNetworkInfo.getType();
                    if (type == 0) {
                        switch (activeNetworkInfo.getSubtype()) {
                            case 1:
                            case 2:
                                i11 = 3;
                                break;
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 14:
                            case 15:
                            case 17:
                                i11 = 4;
                                break;
                            case 13:
                                i11 = 5;
                                break;
                            case 16:
                            case 19:
                            default:
                                i11 = 6;
                                break;
                            case 18:
                                i11 = 2;
                                break;
                            case 20:
                                if (zzfy.zza >= 29) {
                                    i11 = 9;
                                }
                                break;
                        }
                    } else if (type == 1) {
                        i11 = 2;
                    } else if (type == 4 || type == 5) {
                        switch (activeNetworkInfo.getSubtype()) {
                            case 1:
                            case 2:
                                i11 = 3;
                                break;
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 14:
                            case 15:
                            case 17:
                                i11 = 4;
                                break;
                            case 13:
                                i11 = 5;
                                break;
                            case 16:
                            case 19:
                            default:
                                i11 = 6;
                                break;
                            case 18:
                                i11 = 2;
                                break;
                            case 20:
                                if (zzfy.zza >= 29) {
                                    i11 = 9;
                                }
                                break;
                        }
                    } else if (type != 6) {
                        i11 = type != 9 ? 8 : 7;
                    } else {
                        i11 = 5;
                    }
                }
            } catch (SecurityException unused) {
            }
        }
        if (zzfy.zza < 31 || i11 != 5) {
            zzfn.zzc(this.zza, i11);
            return;
        }
        zzfn zzfnVar = this.zza;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            telephonyManager.getClass();
            zzfk zzfkVar = new zzfk(zzfnVar);
            telephonyManager.registerTelephonyCallback(context.getMainExecutor(), zzfkVar);
            telephonyManager.unregisterTelephonyCallback(zzfkVar);
        } catch (RuntimeException unused2) {
            zzfn.zzc(zzfnVar, 5);
        }
    }
}
