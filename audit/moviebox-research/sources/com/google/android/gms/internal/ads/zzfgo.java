package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import com.hisavana.common.tracking.TrackingKey;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfgo {
    private String zza;

    /* JADX WARN: Code duplicated, block: B:16:0x0036  */
    public zzfgo(JsonReader jsonReader) throws IOException {
        byte b11;
        jsonReader.beginObject();
        String strNextString = "";
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            int iHashCode = strNextName.hashCode();
            if (iHashCode != -1724546052) {
                if (iHashCode == 3059181 && strNextName.equals(TrackingKey.CODE)) {
                    b11 = 0;
                } else {
                    b11 = -1;
                }
            } else if (strNextName.equals(TrackingKey.DESCRIPTION)) {
                b11 = 1;
            } else {
                b11 = -1;
            }
            if (b11 == 0) {
                jsonReader.nextInt();
            } else if (b11 != 1) {
                jsonReader.skipValue();
            } else {
                strNextString = jsonReader.nextString();
            }
        }
        jsonReader.endObject();
        this.zza = strNextString;
    }

    public final String zza() {
        return this.zza;
    }
}
