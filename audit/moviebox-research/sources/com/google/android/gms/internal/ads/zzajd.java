package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzajd {
    static final String[] zza = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};
    public static final /* synthetic */ int zzb = 0;

    /* JADX WARN: Code duplicated, block: B:135:0x026b A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:9:0x002c, B:13:0x0036, B:18:0x0042, B:19:0x004e, B:22:0x005a, B:25:0x0067, B:28:0x0076, B:31:0x0083, B:34:0x0091, B:36:0x009b, B:44:0x00b4, B:45:0x00ca, B:46:0x00dd, B:49:0x00e9, B:52:0x00f6, B:55:0x0103, B:58:0x0110, B:61:0x011d, B:64:0x012a, B:67:0x0137, B:70:0x0144, B:73:0x0154, B:76:0x0164, B:80:0x0178, B:82:0x017e, B:84:0x0192, B:85:0x0199, B:87:0x01a0, B:92:0x01ab, B:97:0x01b7, B:135:0x026b, B:98:0x01cc, B:100:0x01d3, B:102:0x01dd, B:103:0x01f1, B:116:0x021d, B:119:0x022a, B:122:0x0236, B:125:0x0242, B:128:0x024e, B:131:0x025a, B:134:0x0264, B:136:0x0284, B:137:0x028b), top: B:142:0x001e }] */
    /* JADX WARN: Instruction removed from duplicated block: B:135:0x026b, please report this as an issue */
    @Nullable
    public static zzbx zza(zzfp zzfpVar) {
        String str;
        int iZzd = zzfpVar.zzd() + zzfpVar.zzg();
        int iZzg = zzfpVar.zzg();
        int i11 = (iZzg >> 24) & 255;
        zzbx zzbxVarZze = null;
        try {
            if (i11 == 169 || i11 == 253) {
                int i12 = iZzg & 16777215;
                if (i12 == 6516084) {
                    int iZzg2 = zzfpVar.zzg();
                    if (zzfpVar.zzg() == 1684108385) {
                        zzfpVar.zzL(8);
                        String strZzz = zzfpVar.zzz(iZzg2 - 16);
                        zzbxVarZze = new zzagk(C.LANGUAGE_UNDETERMINED, strZzz, strZzz);
                    } else {
                        zzff.zzf("MetadataUtil", "Failed to parse comment attribute: ".concat(zzaio.zzf(iZzg)));
                    }
                } else if (i12 == 7233901 || i12 == 7631467) {
                    zzbxVarZze = zze(iZzg, "TIT2", zzfpVar);
                } else if (i12 == 6516589 || i12 == 7828084) {
                    zzbxVarZze = zze(iZzg, "TCOM", zzfpVar);
                } else if (i12 == 6578553) {
                    zzbxVarZze = zze(iZzg, "TDRC", zzfpVar);
                } else if (i12 == 4280916) {
                    zzbxVarZze = zze(iZzg, "TPE1", zzfpVar);
                } else if (i12 == 7630703) {
                    zzbxVarZze = zze(iZzg, "TSSE", zzfpVar);
                } else if (i12 == 6384738) {
                    zzbxVarZze = zze(iZzg, "TALB", zzfpVar);
                } else if (i12 == 7108978) {
                    zzbxVarZze = zze(iZzg, "USLT", zzfpVar);
                } else if (i12 == 6776174) {
                    zzbxVarZze = zze(iZzg, "TCON", zzfpVar);
                } else if (i12 == 6779504) {
                    zzbxVarZze = zze(iZzg, "TIT1", zzfpVar);
                } else {
                    zzff.zzb("MetadataUtil", "Skipped unknown metadata entry: " + zzaio.zzf(iZzg));
                }
            } else if (iZzg == 1735291493) {
                int iZzb = zzb(zzfpVar);
                String str2 = (iZzb <= 0 || iZzb > 192) ? null : zza[iZzb - 1];
                if (str2 != null) {
                    zzbxVarZze = new zzagz("TCON", null, zzgaa.zzm(str2));
                } else {
                    zzff.zzf("MetadataUtil", "Failed to parse standard genre code");
                }
            } else if (iZzg == 1684632427) {
                zzbxVarZze = zzd(1684632427, "TPOS", zzfpVar);
            } else if (iZzg == 1953655662) {
                zzbxVarZze = zzd(1953655662, "TRCK", zzfpVar);
            } else if (iZzg == 1953329263) {
                zzbxVarZze = zzc(1953329263, "TBPM", zzfpVar, true, false);
            } else if (iZzg == 1668311404) {
                zzbxVarZze = zzc(1668311404, "TCMP", zzfpVar, true, true);
            } else if (iZzg == 1668249202) {
                int iZzg3 = zzfpVar.zzg();
                if (zzfpVar.zzg() == 1684108385) {
                    int iZzg4 = zzfpVar.zzg() & 16777215;
                    if (iZzg4 == 13) {
                        str = "image/jpeg";
                    } else if (iZzg4 == 14) {
                        str = "image/png";
                        iZzg4 = 14;
                    } else {
                        str = null;
                    }
                    if (str == null) {
                        zzff.zzf("MetadataUtil", "Unrecognized cover art flags: " + iZzg4);
                    } else {
                        zzfpVar.zzL(4);
                        int i13 = iZzg3 - 16;
                        byte[] bArr = new byte[i13];
                        zzfpVar.zzG(bArr, 0, i13);
                        zzbxVarZze = new zzagc(str, null, 3, bArr);
                    }
                } else {
                    zzff.zzf("MetadataUtil", "Failed to parse cover art attribute");
                }
            } else if (iZzg == 1631670868) {
                zzbxVarZze = zze(1631670868, "TPE2", zzfpVar);
            } else if (iZzg == 1936682605) {
                zzbxVarZze = zze(1936682605, "TSOT", zzfpVar);
            } else if (iZzg == 1936679276) {
                zzbxVarZze = zze(1936679276, "TSO2", zzfpVar);
            } else if (iZzg == 1936679282) {
                zzbxVarZze = zze(1936679282, "TSOA", zzfpVar);
            } else if (iZzg == 1936679265) {
                zzbxVarZze = zze(1936679265, "TSOP", zzfpVar);
            } else if (iZzg == 1936679791) {
                zzbxVarZze = zze(1936679791, "TSOC", zzfpVar);
            } else if (iZzg == 1920233063) {
                zzbxVarZze = zzc(1920233063, "ITUNESADVISORY", zzfpVar, false, false);
            } else if (iZzg == 1885823344) {
                zzbxVarZze = zzc(1885823344, "ITUNESGAPLESS", zzfpVar, false, true);
            } else if (iZzg == 1936683886) {
                zzbxVarZze = zze(1936683886, "TVSHOWSORT", zzfpVar);
            } else if (iZzg == 1953919848) {
                zzbxVarZze = zze(1953919848, "TVSHOW", zzfpVar);
            } else if (iZzg == 757935405) {
                String strZzz2 = null;
                String strZzz3 = null;
                int i14 = -1;
                int i15 = -1;
                while (zzfpVar.zzd() < iZzd) {
                    int iZzd2 = zzfpVar.zzd();
                    int iZzg5 = zzfpVar.zzg();
                    int iZzg6 = zzfpVar.zzg();
                    zzfpVar.zzL(4);
                    if (iZzg6 == 1835360622) {
                        strZzz2 = zzfpVar.zzz(iZzg5 - 12);
                    } else {
                        int i16 = iZzg5 - 12;
                        if (iZzg6 == 1851878757) {
                            strZzz3 = zzfpVar.zzz(i16);
                        } else {
                            if (iZzg6 == 1684108385) {
                                i15 = iZzg5;
                            }
                            if (iZzg6 == 1684108385) {
                                i14 = iZzd2;
                            }
                            zzfpVar.zzL(i16);
                        }
                    }
                }
                if (strZzz2 != null && strZzz3 != null && i14 != -1) {
                    zzfpVar.zzK(i14);
                    zzfpVar.zzL(16);
                    zzbxVarZze = new zzagt(strZzz2, strZzz3, zzfpVar.zzz(i15 - 16));
                }
            } else {
                zzff.zzb("MetadataUtil", "Skipped unknown metadata entry: " + zzaio.zzf(iZzg));
            }
            zzfpVar.zzK(iZzd);
            return zzbxVarZze;
        } catch (Throwable th2) {
            zzfpVar.zzK(iZzd);
            throw th2;
        }
    }

    private static int zzb(zzfp zzfpVar) {
        zzfpVar.zzL(4);
        if (zzfpVar.zzg() == 1684108385) {
            zzfpVar.zzL(8);
            return zzfpVar.zzm();
        }
        zzff.zzf("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    @Nullable
    private static zzagr zzc(int i11, String str, zzfp zzfpVar, boolean z11, boolean z12) {
        int iZzb = zzb(zzfpVar);
        if (z12) {
            iZzb = Math.min(1, iZzb);
        }
        if (iZzb >= 0) {
            return z11 ? new zzagz(str, null, zzgaa.zzm(Integer.toString(iZzb))) : new zzagk(C.LANGUAGE_UNDETERMINED, str, Integer.toString(iZzb));
        }
        zzff.zzf("MetadataUtil", "Failed to parse uint8 attribute: ".concat(zzaio.zzf(i11)));
        return null;
    }

    @Nullable
    private static zzagz zzd(int i11, String str, zzfp zzfpVar) {
        int iZzg = zzfpVar.zzg();
        if (zzfpVar.zzg() == 1684108385 && iZzg >= 22) {
            zzfpVar.zzL(10);
            int iZzq = zzfpVar.zzq();
            if (iZzq > 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(iZzq);
                String string = sb2.toString();
                int iZzq2 = zzfpVar.zzq();
                if (iZzq2 > 0) {
                    string = string + "/" + iZzq2;
                }
                return new zzagz(str, null, zzgaa.zzm(string));
            }
        }
        zzff.zzf("MetadataUtil", "Failed to parse index/count attribute: ".concat(zzaio.zzf(i11)));
        return null;
    }

    @Nullable
    private static zzagz zze(int i11, String str, zzfp zzfpVar) {
        int iZzg = zzfpVar.zzg();
        if (zzfpVar.zzg() == 1684108385) {
            zzfpVar.zzL(8);
            return new zzagz(str, null, zzgaa.zzm(zzfpVar.zzz(iZzg - 16)));
        }
        zzff.zzf("MetadataUtil", "Failed to parse text attribute: ".concat(zzaio.zzf(i11)));
        return null;
    }
}
