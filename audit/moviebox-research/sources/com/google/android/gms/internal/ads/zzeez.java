package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import com.google.android.gms.common.util.IOUtils;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeez {
    public int zza = 0;
    public Map zzb = new HashMap();
    public String zzc = "";
    public long zzd = -1;

    public static zzeez zza(Reader reader) throws zzfgq {
        try {
            try {
                JsonReader jsonReader = new JsonReader(reader);
                HashMap map = new HashMap();
                String strNextString = "";
                jsonReader.beginObject();
                long jNextLong = -1;
                int iNextInt = 0;
                while (jsonReader.hasNext()) {
                    String strNextName = jsonReader.nextName();
                    if ("response".equals(strNextName)) {
                        iNextInt = jsonReader.nextInt();
                    } else if (TtmlNode.TAG_BODY.equals(strNextName)) {
                        strNextString = jsonReader.nextString();
                    } else if ("latency".equals(strNextName)) {
                        jNextLong = jsonReader.nextLong();
                    } else if ("headers".equals(strNextName)) {
                        map = new HashMap();
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            map.put(jsonReader.nextName(), com.google.android.gms.ads.internal.util.zzbw.zzd(jsonReader));
                        }
                        jsonReader.endObject();
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
                zzeez zzeezVar = new zzeez();
                zzeezVar.zza = iNextInt;
                if (strNextString != null) {
                    zzeezVar.zzc = strNextString;
                }
                zzeezVar.zzd = jNextLong;
                zzeezVar.zzb = map;
                IOUtils.closeQuietly(reader);
                return zzeezVar;
            } catch (Throwable th2) {
                IOUtils.closeQuietly(reader);
                throw th2;
            }
        } catch (IOException e11) {
            e = e11;
            throw new zzfgq("Unable to parse Response", e);
        } catch (AssertionError e12) {
            e = e12;
            throw new zzfgq("Unable to parse Response", e);
        } catch (IllegalStateException e13) {
            e = e13;
            throw new zzfgq("Unable to parse Response", e);
        } catch (NumberFormatException e14) {
            e = e14;
            throw new zzfgq("Unable to parse Response", e);
        }
    }
}
