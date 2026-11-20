package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class hf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String[] f19479a = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};

    public static fd a(bh bhVar, int i11, String str) {
        while (true) {
            int iD = bhVar.d();
            if (iD >= i11) {
                return null;
            }
            int iJ = bhVar.j();
            if (bhVar.j() == 1684108385) {
                int iJ2 = bhVar.j();
                int iJ3 = bhVar.j();
                int i12 = iJ - 16;
                byte[] bArr = new byte[i12];
                bhVar.a(bArr, 0, i12);
                return new fd(str, bArr, iJ3, iJ2);
            }
            bhVar.f(iD + iJ);
        }
    }

    private static u3 a(int i11, bh bhVar) {
        int iJ = bhVar.j();
        if (bhVar.j() == 1684108385) {
            bhVar.g(8);
            String strB = bhVar.b(iJ - 16);
            return new u3(C.LANGUAGE_UNDETERMINED, strB, strB);
        }
        pc.d("MetadataUtil", "Failed to parse comment attribute: " + j1.a(i11));
        return null;
    }

    private static v0 a(bh bhVar) {
        String str;
        int iJ = bhVar.j();
        if (bhVar.j() != 1684108385) {
            pc.d("MetadataUtil", "Failed to parse cover art attribute");
            return null;
        }
        int iB = j1.b(bhVar.j());
        if (iB == 13) {
            str = "image/jpeg";
        } else {
            str = iB == 14 ? "image/png" : null;
        }
        if (str == null) {
            pc.d("MetadataUtil", "Unrecognized cover art flags: " + iB);
            return null;
        }
        bhVar.g(4);
        int i11 = iJ - 16;
        byte[] bArr = new byte[i11];
        bhVar.a(bArr, 0, i11);
        return new v0(str, null, 3, bArr);
    }

    private static ya a(int i11, String str, bh bhVar, boolean z11, boolean z12) {
        int iD = d(bhVar);
        if (z12) {
            iD = Math.min(1, iD);
        }
        if (iD >= 0) {
            return z11 ? new zn(str, null, Integer.toString(iD)) : new u3(C.LANGUAGE_UNDETERMINED, str, Integer.toString(iD));
        }
        pc.d("MetadataUtil", "Failed to parse uint8 attribute: " + j1.a(i11));
        return null;
    }

    private static ya a(bh bhVar, int i11) {
        String strB = null;
        String strB2 = null;
        int i12 = -1;
        int i13 = -1;
        while (bhVar.d() < i11) {
            int iD = bhVar.d();
            int iJ = bhVar.j();
            int iJ2 = bhVar.j();
            bhVar.g(4);
            if (iJ2 == 1835360622) {
                strB = bhVar.b(iJ - 12);
            } else if (iJ2 == 1851878757) {
                strB2 = bhVar.b(iJ - 12);
            } else {
                if (iJ2 == 1684108385) {
                    i12 = iD;
                    i13 = iJ;
                }
                bhVar.g(iJ - 12);
            }
        }
        if (strB == null || strB2 == null || i12 == -1) {
            return null;
        }
        bhVar.f(i12);
        bhVar.g(16);
        return new sb(strB, strB2, bhVar.b(i13 - 16));
    }

    private static zn a(int i11, String str, bh bhVar) {
        int iJ = bhVar.j();
        if (bhVar.j() == 1684108385 && iJ >= 22) {
            bhVar.g(10);
            int iC = bhVar.C();
            if (iC > 0) {
                String str2 = "" + iC;
                int iC2 = bhVar.C();
                if (iC2 > 0) {
                    str2 = str2 + "/" + iC2;
                }
                return new zn(str, null, str2);
            }
        }
        pc.d("MetadataUtil", "Failed to parse index/count attribute: " + j1.a(i11));
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003c  */
    public static void a(int i11, bf bfVar, bf bfVar2, f9.b bVar, bf... bfVarArr) {
        bf bfVar3 = new bf(new bf.b[0]);
        if (i11 == 1) {
            if (bfVar == null) {
                bfVar = bfVar3;
                break;
            }
        } else {
            if (i11 != 2 || bfVar2 == null) {
                bfVar = bfVar3;
                break;
            }
            int i12 = 0;
            while (true) {
                if (i12 >= bfVar2.c()) {
                    bfVar = bfVar3;
                    break;
                }
                bf.b bVarA = bfVar2.a(i12);
                if (bVarA instanceof fd) {
                    fd fdVar = (fd) bVarA;
                    if ("com.android.capture.fps".equals(fdVar.f18963a)) {
                        bfVar = new bf(fdVar);
                        break;
                    }
                }
                i12++;
            }
        }
        for (bf bfVar4 : bfVarArr) {
            bfVar = bfVar.a(bfVar4);
        }
        if (bfVar.c() > 0) {
            bVar.a(bfVar);
        }
    }

    public static void a(int i11, z9 z9Var, f9.b bVar) {
        if (i11 == 1 && z9Var.a()) {
            bVar.e(z9Var.f24824a).f(z9Var.f24825b);
        }
    }

    public static bf.b b(bh bhVar) {
        int iD = bhVar.d() + bhVar.j();
        int iJ = bhVar.j();
        int i11 = (iJ >> 24) & 255;
        try {
            if (i11 == 169 || i11 == 253) {
                int i12 = 16777215 & iJ;
                if (i12 == 6516084) {
                    u3 u3VarA = a(iJ, bhVar);
                    bhVar.f(iD);
                    return u3VarA;
                }
                if (i12 == 7233901 || i12 == 7631467) {
                    zn znVarB = b(iJ, "TIT2", bhVar);
                    bhVar.f(iD);
                    return znVarB;
                }
                if (i12 == 6516589 || i12 == 7828084) {
                    zn znVarB2 = b(iJ, "TCOM", bhVar);
                    bhVar.f(iD);
                    return znVarB2;
                }
                if (i12 == 6578553) {
                    zn znVarB3 = b(iJ, "TDRC", bhVar);
                    bhVar.f(iD);
                    return znVarB3;
                }
                if (i12 == 4280916) {
                    zn znVarB4 = b(iJ, "TPE1", bhVar);
                    bhVar.f(iD);
                    return znVarB4;
                }
                if (i12 == 7630703) {
                    zn znVarB5 = b(iJ, "TSSE", bhVar);
                    bhVar.f(iD);
                    return znVarB5;
                }
                if (i12 == 6384738) {
                    zn znVarB6 = b(iJ, "TALB", bhVar);
                    bhVar.f(iD);
                    return znVarB6;
                }
                if (i12 == 7108978) {
                    zn znVarB7 = b(iJ, "USLT", bhVar);
                    bhVar.f(iD);
                    return znVarB7;
                }
                if (i12 == 6776174) {
                    zn znVarB8 = b(iJ, "TCON", bhVar);
                    bhVar.f(iD);
                    return znVarB8;
                }
                if (i12 == 6779504) {
                    zn znVarB9 = b(iJ, "TIT1", bhVar);
                    bhVar.f(iD);
                    return znVarB9;
                }
            } else {
                if (iJ == 1735291493) {
                    zn znVarC = c(bhVar);
                    bhVar.f(iD);
                    return znVarC;
                }
                if (iJ == 1684632427) {
                    zn znVarA = a(iJ, "TPOS", bhVar);
                    bhVar.f(iD);
                    return znVarA;
                }
                if (iJ == 1953655662) {
                    zn znVarA2 = a(iJ, "TRCK", bhVar);
                    bhVar.f(iD);
                    return znVarA2;
                }
                if (iJ == 1953329263) {
                    ya yaVarA = a(iJ, "TBPM", bhVar, true, false);
                    bhVar.f(iD);
                    return yaVarA;
                }
                if (iJ == 1668311404) {
                    ya yaVarA2 = a(iJ, "TCMP", bhVar, true, true);
                    bhVar.f(iD);
                    return yaVarA2;
                }
                if (iJ == 1668249202) {
                    v0 v0VarA = a(bhVar);
                    bhVar.f(iD);
                    return v0VarA;
                }
                if (iJ == 1631670868) {
                    zn znVarB10 = b(iJ, "TPE2", bhVar);
                    bhVar.f(iD);
                    return znVarB10;
                }
                if (iJ == 1936682605) {
                    zn znVarB11 = b(iJ, "TSOT", bhVar);
                    bhVar.f(iD);
                    return znVarB11;
                }
                if (iJ == 1936679276) {
                    zn znVarB12 = b(iJ, "TSO2", bhVar);
                    bhVar.f(iD);
                    return znVarB12;
                }
                if (iJ == 1936679282) {
                    zn znVarB13 = b(iJ, "TSOA", bhVar);
                    bhVar.f(iD);
                    return znVarB13;
                }
                if (iJ == 1936679265) {
                    zn znVarB14 = b(iJ, "TSOP", bhVar);
                    bhVar.f(iD);
                    return znVarB14;
                }
                if (iJ == 1936679791) {
                    zn znVarB15 = b(iJ, "TSOC", bhVar);
                    bhVar.f(iD);
                    return znVarB15;
                }
                if (iJ == 1920233063) {
                    ya yaVarA3 = a(iJ, "ITUNESADVISORY", bhVar, false, false);
                    bhVar.f(iD);
                    return yaVarA3;
                }
                if (iJ == 1885823344) {
                    ya yaVarA4 = a(iJ, "ITUNESGAPLESS", bhVar, false, true);
                    bhVar.f(iD);
                    return yaVarA4;
                }
                if (iJ == 1936683886) {
                    zn znVarB16 = b(iJ, "TVSHOWSORT", bhVar);
                    bhVar.f(iD);
                    return znVarB16;
                }
                if (iJ == 1953919848) {
                    zn znVarB17 = b(iJ, "TVSHOW", bhVar);
                    bhVar.f(iD);
                    return znVarB17;
                }
                if (iJ == 757935405) {
                    ya yaVarA5 = a(bhVar, iD);
                    bhVar.f(iD);
                    return yaVarA5;
                }
            }
            pc.a("MetadataUtil", "Skipped unknown metadata entry: " + j1.a(iJ));
            bhVar.f(iD);
            return null;
        } catch (Throwable th2) {
            bhVar.f(iD);
            throw th2;
        }
    }

    private static zn b(int i11, String str, bh bhVar) {
        int iJ = bhVar.j();
        if (bhVar.j() == 1684108385) {
            bhVar.g(8);
            return new zn(str, null, bhVar.b(iJ - 16));
        }
        pc.d("MetadataUtil", "Failed to parse text attribute: " + j1.a(i11));
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0011  */
    private static zn c(bh bhVar) {
        String str;
        int iD = d(bhVar);
        if (iD > 0) {
            String[] strArr = f19479a;
            if (iD <= strArr.length) {
                str = strArr[iD - 1];
            } else {
                str = null;
            }
        } else {
            str = null;
        }
        if (str != null) {
            return new zn("TCON", null, str);
        }
        pc.d("MetadataUtil", "Failed to parse standard genre code");
        return null;
    }

    private static int d(bh bhVar) {
        bhVar.g(4);
        if (bhVar.j() == 1684108385) {
            bhVar.g(8);
            return bhVar.w();
        }
        pc.d("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }
}
