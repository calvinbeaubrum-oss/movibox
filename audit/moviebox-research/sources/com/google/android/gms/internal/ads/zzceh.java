package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.ClientLibraryUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzceh implements zzcdu {

    @Nullable
    private final String zza;

    public zzceh() {
        this.zza = null;
    }

    public zzceh(@Nullable String str) {
        this.zza = str;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00e4 A[PHI: r1
  0x00e4: PHI (r1v1 boolean) = (r1v0 boolean), (r1v0 boolean), (r1v3 boolean) binds: [B:39:0x00e2, B:35:0x00bd, B:23:0x008e] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.ads.zzcdu
    public final boolean zza(String str) {
        boolean z11 = false;
        try {
            try {
                if (ClientLibraryUtils.isPackageSide()) {
                    TrafficStats.setThreadStatsTag(263);
                }
                zzcec.zze("Pinging URL: " + str);
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    com.google.android.gms.ads.internal.client.zzay.zzb();
                    String str2 = this.zza;
                    httpURLConnection.setConnectTimeout(60000);
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.setReadTimeout(60000);
                    if (str2 != null) {
                        httpURLConnection.setRequestProperty("User-Agent", str2);
                    }
                    httpURLConnection.setUseCaches(false);
                    zzceb zzcebVar = new zzceb(null);
                    zzcebVar.zzc(httpURLConnection, null);
                    int responseCode = httpURLConnection.getResponseCode();
                    zzcebVar.zze(httpURLConnection, responseCode);
                    if (responseCode < 200 || responseCode >= 300) {
                        zzcec.zzj("Received non-success response code " + responseCode + " from pinging URL: " + str);
                    } else {
                        z11 = true;
                    }
                    httpURLConnection.disconnect();
                    if (ClientLibraryUtils.isPackageSide()) {
                        TrafficStats.clearThreadStatsTag();
                    }
                } catch (Throwable th2) {
                    httpURLConnection.disconnect();
                    throw th2;
                }
            } catch (IOException e11) {
                e = e11;
                zzcec.zzj("Error while pinging URL: " + str + ". " + e.getMessage());
                if (ClientLibraryUtils.isPackageSide()) {
                    TrafficStats.clearThreadStatsTag();
                }
            } catch (IndexOutOfBoundsException e12) {
                zzcec.zzj("Error while parsing ping URL: " + str + ". " + e12.getMessage());
                if (ClientLibraryUtils.isPackageSide()) {
                    TrafficStats.clearThreadStatsTag();
                }
            } catch (RuntimeException e13) {
                e = e13;
                zzcec.zzj("Error while pinging URL: " + str + ". " + e.getMessage());
                if (ClientLibraryUtils.isPackageSide()) {
                    TrafficStats.clearThreadStatsTag();
                }
            }
            return z11;
        } catch (Throwable th3) {
            if (ClientLibraryUtils.isPackageSide()) {
                TrafficStats.clearThreadStatsTag();
            }
            throw th3;
        }
    }
}
