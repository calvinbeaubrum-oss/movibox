package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzafq {
    private static final String[] zza = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};
    private static final String[] zzb = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};
    private static final String[] zzc = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    @Nullable
    public static zzafm zza(String str) throws IOException {
        long j11;
        try {
            XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
            xmlPullParserNewPullParser.setInput(new StringReader(str));
            xmlPullParserNewPullParser.next();
            if (!zzfz.zzc(xmlPullParserNewPullParser, "x:xmpmeta")) {
                throw zzcc.zza("Couldn't find xmp metadata", null);
            }
            zzgaa zzgaaVarZzl = zzgaa.zzl();
            long j12 = -9223372036854775807L;
            do {
                xmlPullParserNewPullParser.next();
                if (zzfz.zzc(xmlPullParserNewPullParser, "rdf:Description")) {
                    String[] strArr = zza;
                    int i11 = 0;
                    for (int i12 = 0; i12 < 4; i12++) {
                        String strZza = zzfz.zza(xmlPullParserNewPullParser, strArr[i12]);
                        if (strZza != null) {
                            if (Integer.parseInt(strZza) != 1) {
                                return null;
                            }
                            String[] strArr2 = zzb;
                            int i13 = 0;
                            while (true) {
                                if (i13 < 4) {
                                    String strZza2 = zzfz.zza(xmlPullParserNewPullParser, strArr2[i13]);
                                    if (strZza2 != null) {
                                        j11 = Long.parseLong(strZza2);
                                        if (j11 != -1) {
                                            break;
                                        }
                                        break;
                                    }
                                    i13++;
                                }
                                j11 = -9223372036854775807L;
                                break;
                            }
                            String[] strArr3 = zzc;
                            while (true) {
                                if (i11 >= 2) {
                                    zzgaaVarZzl = zzgaa.zzl();
                                    break;
                                }
                                String strZza3 = zzfz.zza(xmlPullParserNewPullParser, strArr3[i11]);
                                if (strZza3 != null) {
                                    zzgaaVarZzl = zzgaa.zzn(new zzafl("image/jpeg", "Primary", 0L, 0L), new zzafl(MimeTypes.VIDEO_MP4, "MotionPhoto", Long.parseLong(strZza3), 0L));
                                    break;
                                }
                                i11++;
                            }
                            j12 = j11;
                        }
                    }
                    return null;
                }
                if (zzfz.zzc(xmlPullParserNewPullParser, "Container:Directory")) {
                    zzgaaVarZzl = zzb(xmlPullParserNewPullParser, "Container", "Item");
                } else if (zzfz.zzc(xmlPullParserNewPullParser, "GContainer:Directory")) {
                    zzgaaVarZzl = zzb(xmlPullParserNewPullParser, "GContainer", "GContainerItem");
                }
            } while (!zzfz.zzb(xmlPullParserNewPullParser, "x:xmpmeta"));
            if (zzgaaVarZzl.isEmpty()) {
                return null;
            }
            return new zzafm(j12, zzgaaVarZzl);
        } catch (zzcc | NumberFormatException | XmlPullParserException unused) {
            zzff.zzf("MotionPhotoXmpParser", "Ignoring unexpected XMP metadata");
            return null;
        }
    }

    private static zzgaa zzb(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        zzfzx zzfzxVar = new zzfzx();
        do {
            String strConcat = str.concat(":Item");
            xmlPullParser.next();
            if (zzfz.zzc(xmlPullParser, strConcat)) {
                String strConcat2 = str2.concat(":Mime");
                String strConcat3 = str2.concat(":Semantic");
                String strConcat4 = str2.concat(":Length");
                String strConcat5 = str2.concat(":Padding");
                String strZza = zzfz.zza(xmlPullParser, strConcat2);
                String strZza2 = zzfz.zza(xmlPullParser, strConcat3);
                String strZza3 = zzfz.zza(xmlPullParser, strConcat4);
                String strZza4 = zzfz.zza(xmlPullParser, strConcat5);
                if (strZza == null || strZza2 == null) {
                    return zzgaa.zzl();
                }
                zzfzxVar.zzf(new zzafl(strZza, strZza2, strZza3 != null ? Long.parseLong(strZza3) : 0L, strZza4 != null ? Long.parseLong(strZza4) : 0L));
            }
        } while (!zzfz.zzb(xmlPullParser, str.concat(":Directory")));
        return zzfzxVar.zzi();
    }
}
