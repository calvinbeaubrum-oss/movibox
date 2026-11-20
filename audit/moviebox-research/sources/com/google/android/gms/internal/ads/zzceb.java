package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzceb {
    public static final /* synthetic */ int zza = 0;
    private static boolean zzc = false;
    private static boolean zzd = false;
    private final List zzg;
    private static final Object zzb = new Object();
    private static final Clock zze = DefaultClock.getInstance();
    private static final Set zzf = new HashSet(Arrays.asList(new String[0]));

    public zzceb() {
        this(null);
    }

    public zzceb(@Nullable String str) {
        this.zzg = !zzk() ? new ArrayList() : Arrays.asList("network_request_".concat(String.valueOf(UUID.randomUUID().toString())));
    }

    public static /* synthetic */ void zza(String str, String str2, Map map, byte[] bArr, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("uri").value(str);
        jsonWriter.name("verb").value(str2);
        jsonWriter.endObject();
        zzr(jsonWriter, map);
        if (bArr != null) {
            jsonWriter.name(TtmlNode.TAG_BODY).value(Base64Utils.encode(bArr));
        }
        jsonWriter.endObject();
    }

    public static /* synthetic */ void zzb(int i11, Map map, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name(TrackingKey.CODE).value(i11);
        jsonWriter.endObject();
        zzr(jsonWriter, map);
        jsonWriter.endObject();
    }

    public static void zzi() {
        synchronized (zzb) {
            zzc = false;
            zzd = false;
            zzcec.zzj("Ad debug logging enablement is out of date.");
        }
    }

    public static void zzj(boolean z11) {
        synchronized (zzb) {
            zzc = true;
            zzd = z11;
        }
    }

    public static boolean zzk() {
        boolean z11;
        synchronized (zzb) {
            try {
                z11 = false;
                if (zzc && zzd) {
                    z11 = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return z11;
    }

    public static boolean zzl() {
        boolean z11;
        synchronized (zzb) {
            z11 = zzc;
        }
        return z11;
    }

    private static synchronized void zzm(String str) {
        try {
            zzcec.zzi("GMA Debug BEGIN");
            int i11 = 0;
            while (i11 < str.length()) {
                int i12 = i11 + 4000;
                zzcec.zzi("GMA Debug CONTENT ".concat(String.valueOf(str.substring(i11, Math.min(i12, str.length())))));
                i11 = i12;
            }
            zzcec.zzi("GMA Debug FINISH");
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private final void zzn(String str, zzcea zzceaVar) {
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            jsonWriter.beginObject();
            jsonWriter.name(CampaignEx.JSON_KEY_TIMESTAMP).value(zze.currentTimeMillis());
            jsonWriter.name(NotificationCompat.CATEGORY_EVENT).value(str);
            jsonWriter.name("components").beginArray();
            Iterator it = this.zzg.iterator();
            while (it.hasNext()) {
                jsonWriter.value((String) it.next());
            }
            jsonWriter.endArray();
            zzceaVar.zza(jsonWriter);
            jsonWriter.endObject();
            jsonWriter.flush();
            jsonWriter.close();
        } catch (IOException e11) {
            zzcec.zzh("unable to log", e11);
        }
        zzm(stringWriter.toString());
    }

    private final void zzo(@Nullable final String str) {
        zzn("onNetworkRequestError", new zzcea() { // from class: com.google.android.gms.internal.ads.zzcdy
            @Override // com.google.android.gms.internal.ads.zzcea
            public final void zza(JsonWriter jsonWriter) throws IOException {
                int i11 = zzceb.zza;
                jsonWriter.name("params").beginObject();
                String str2 = str;
                if (str2 != null) {
                    jsonWriter.name("error_description").value(str2);
                }
                jsonWriter.endObject();
            }
        });
    }

    private final void zzp(final String str, final String str2, @Nullable final Map map, @Nullable final byte[] bArr) {
        zzn("onNetworkRequest", new zzcea() { // from class: com.google.android.gms.internal.ads.zzcdw
            @Override // com.google.android.gms.internal.ads.zzcea
            public final void zza(JsonWriter jsonWriter) throws IOException {
                zzceb.zza(str, str2, map, bArr, jsonWriter);
            }
        });
    }

    private final void zzq(@Nullable final Map map, final int i11) {
        zzn("onNetworkResponse", new zzcea() { // from class: com.google.android.gms.internal.ads.zzcdz
            @Override // com.google.android.gms.internal.ads.zzcea
            public final void zza(JsonWriter jsonWriter) throws IOException {
                zzceb.zzb(i11, map, jsonWriter);
            }
        });
    }

    private static void zzr(JsonWriter jsonWriter, @Nullable Map map) throws IOException {
        if (map == null) {
            return;
        }
        jsonWriter.name("headers").beginArray();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (!zzf.contains(str)) {
                if (!(entry.getValue() instanceof List)) {
                    if (!(entry.getValue() instanceof String)) {
                        zzcec.zzg("Connection headers should be either Map<String, String> or Map<String, List<String>>");
                        break;
                    }
                    jsonWriter.beginObject();
                    jsonWriter.name("name").value(str);
                    jsonWriter.name(AppMeasurementSdk.ConditionalUserProperty.VALUE).value((String) entry.getValue());
                    jsonWriter.endObject();
                } else {
                    for (String str2 : (List) entry.getValue()) {
                        jsonWriter.beginObject();
                        jsonWriter.name("name").value(str);
                        jsonWriter.name(AppMeasurementSdk.ConditionalUserProperty.VALUE).value(str2);
                        jsonWriter.endObject();
                    }
                }
            }
        }
        jsonWriter.endArray();
    }

    public final void zzc(HttpURLConnection httpURLConnection, @Nullable byte[] bArr) {
        if (zzk()) {
            zzp(new String(httpURLConnection.getURL().toString()), new String(httpURLConnection.getRequestMethod()), httpURLConnection.getRequestProperties() == null ? null : new HashMap(httpURLConnection.getRequestProperties()), bArr);
        }
    }

    public final void zzd(String str, String str2, @Nullable Map map, @Nullable byte[] bArr) {
        if (zzk()) {
            zzp(str, "GET", map, bArr);
        }
    }

    public final void zze(HttpURLConnection httpURLConnection, int i11) {
        if (zzk()) {
            String responseMessage = null;
            zzq(httpURLConnection.getHeaderFields() == null ? null : new HashMap(httpURLConnection.getHeaderFields()), i11);
            if (i11 < 200 || i11 >= 300) {
                try {
                    responseMessage = httpURLConnection.getResponseMessage();
                } catch (IOException e11) {
                    zzcec.zzj("Can not get error message from error HttpURLConnection\n".concat(String.valueOf(e11.getMessage())));
                }
                zzo(responseMessage);
            }
        }
    }

    public final void zzf(@Nullable Map map, int i11) {
        if (zzk()) {
            zzq(map, i11);
            if (i11 < 200 || i11 >= 300) {
                zzo(null);
            }
        }
    }

    public final void zzg(@Nullable String str) {
        if (zzk() && str != null) {
            zzh(str.getBytes());
        }
    }

    public final void zzh(final byte[] bArr) {
        zzn("onNetworkResponseBody", new zzcea() { // from class: com.google.android.gms.internal.ads.zzcdx
            @Override // com.google.android.gms.internal.ads.zzcea
            public final void zza(JsonWriter jsonWriter) throws IOException {
                int i11 = zzceb.zza;
                jsonWriter.name("params").beginObject();
                byte[] bArr2 = bArr;
                int length = bArr2.length;
                String strEncode = Base64Utils.encode(bArr2);
                if (length < 10000) {
                    jsonWriter.name(TtmlNode.TAG_BODY).value(strEncode);
                } else {
                    String strZze = zzcdv.zze(strEncode);
                    if (strZze != null) {
                        jsonWriter.name("bodydigest").value(strZze);
                    }
                }
                jsonWriter.name("bodylength").value(length);
                jsonWriter.endObject();
            }
        });
    }
}
