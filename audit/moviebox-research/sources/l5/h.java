package l5;

import androidx.annotation.Nullable;
import androidx.media3.common.Metadata;
import androidx.media3.common.y;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.extractor.metadata.id3.ApicFrame;
import androidx.media3.extractor.metadata.id3.CommentFrame;
import androidx.media3.extractor.metadata.id3.Id3Frame;
import androidx.media3.extractor.metadata.id3.InternalFrame;
import androidx.media3.extractor.metadata.id3.TextInformationFrame;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import u4.f0;
import z3.c0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f69883a = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};

    @Nullable
    public static CommentFrame a(int i11, c0 c0Var) {
        int iQ = c0Var.q();
        if (c0Var.q() == 1684108385) {
            c0Var.V(8);
            String strC = c0Var.C(iQ - 16);
            return new CommentFrame(C.LANGUAGE_UNDETERMINED, strC, strC);
        }
        z3.o.h("MetadataUtil", "Failed to parse comment attribute: " + a.a(i11));
        return null;
    }

    @Nullable
    public static ApicFrame b(c0 c0Var) {
        String str;
        int iQ = c0Var.q();
        if (c0Var.q() != 1684108385) {
            z3.o.h("MetadataUtil", "Failed to parse cover art attribute");
            return null;
        }
        int iB = a.b(c0Var.q());
        if (iB == 13) {
            str = "image/jpeg";
        } else {
            str = iB == 14 ? "image/png" : null;
        }
        if (str == null) {
            z3.o.h("MetadataUtil", "Unrecognized cover art flags: " + iB);
            return null;
        }
        c0Var.V(4);
        int i11 = iQ - 16;
        byte[] bArr = new byte[i11];
        c0Var.l(bArr, 0, i11);
        return new ApicFrame(str, null, 3, bArr);
    }

    @Nullable
    public static Metadata.Entry c(c0 c0Var) {
        int iF = c0Var.f() + c0Var.q();
        int iQ = c0Var.q();
        int i11 = (iQ >> 24) & 255;
        try {
            if (i11 == 169 || i11 == 253) {
                int i12 = 16777215 & iQ;
                if (i12 == 6516084) {
                    CommentFrame commentFrameA = a(iQ, c0Var);
                    c0Var.U(iF);
                    return commentFrameA;
                }
                if (i12 == 7233901 || i12 == 7631467) {
                    TextInformationFrame textInformationFrameH = h(iQ, "TIT2", c0Var);
                    c0Var.U(iF);
                    return textInformationFrameH;
                }
                if (i12 == 6516589 || i12 == 7828084) {
                    TextInformationFrame textInformationFrameH2 = h(iQ, "TCOM", c0Var);
                    c0Var.U(iF);
                    return textInformationFrameH2;
                }
                if (i12 == 6578553) {
                    TextInformationFrame textInformationFrameH3 = h(iQ, "TDRC", c0Var);
                    c0Var.U(iF);
                    return textInformationFrameH3;
                }
                if (i12 == 4280916) {
                    TextInformationFrame textInformationFrameH4 = h(iQ, "TPE1", c0Var);
                    c0Var.U(iF);
                    return textInformationFrameH4;
                }
                if (i12 == 7630703) {
                    TextInformationFrame textInformationFrameH5 = h(iQ, "TSSE", c0Var);
                    c0Var.U(iF);
                    return textInformationFrameH5;
                }
                if (i12 == 6384738) {
                    TextInformationFrame textInformationFrameH6 = h(iQ, "TALB", c0Var);
                    c0Var.U(iF);
                    return textInformationFrameH6;
                }
                if (i12 == 7108978) {
                    TextInformationFrame textInformationFrameH7 = h(iQ, "USLT", c0Var);
                    c0Var.U(iF);
                    return textInformationFrameH7;
                }
                if (i12 == 6776174) {
                    TextInformationFrame textInformationFrameH8 = h(iQ, "TCON", c0Var);
                    c0Var.U(iF);
                    return textInformationFrameH8;
                }
                if (i12 == 6779504) {
                    TextInformationFrame textInformationFrameH9 = h(iQ, "TIT1", c0Var);
                    c0Var.U(iF);
                    return textInformationFrameH9;
                }
            } else {
                if (iQ == 1735291493) {
                    TextInformationFrame textInformationFrameG = g(c0Var);
                    c0Var.U(iF);
                    return textInformationFrameG;
                }
                if (iQ == 1684632427) {
                    TextInformationFrame textInformationFrameD = d(iQ, "TPOS", c0Var);
                    c0Var.U(iF);
                    return textInformationFrameD;
                }
                if (iQ == 1953655662) {
                    TextInformationFrame textInformationFrameD2 = d(iQ, "TRCK", c0Var);
                    c0Var.U(iF);
                    return textInformationFrameD2;
                }
                if (iQ == 1953329263) {
                    Id3Frame id3FrameI = i(iQ, "TBPM", c0Var, true, false);
                    c0Var.U(iF);
                    return id3FrameI;
                }
                if (iQ == 1668311404) {
                    Id3Frame id3FrameI2 = i(iQ, "TCMP", c0Var, true, true);
                    c0Var.U(iF);
                    return id3FrameI2;
                }
                if (iQ == 1668249202) {
                    ApicFrame apicFrameB = b(c0Var);
                    c0Var.U(iF);
                    return apicFrameB;
                }
                if (iQ == 1631670868) {
                    TextInformationFrame textInformationFrameH10 = h(iQ, "TPE2", c0Var);
                    c0Var.U(iF);
                    return textInformationFrameH10;
                }
                if (iQ == 1936682605) {
                    TextInformationFrame textInformationFrameH11 = h(iQ, "TSOT", c0Var);
                    c0Var.U(iF);
                    return textInformationFrameH11;
                }
                if (iQ == 1936679276) {
                    TextInformationFrame textInformationFrameH12 = h(iQ, "TSO2", c0Var);
                    c0Var.U(iF);
                    return textInformationFrameH12;
                }
                if (iQ == 1936679282) {
                    TextInformationFrame textInformationFrameH13 = h(iQ, "TSOA", c0Var);
                    c0Var.U(iF);
                    return textInformationFrameH13;
                }
                if (iQ == 1936679265) {
                    TextInformationFrame textInformationFrameH14 = h(iQ, "TSOP", c0Var);
                    c0Var.U(iF);
                    return textInformationFrameH14;
                }
                if (iQ == 1936679791) {
                    TextInformationFrame textInformationFrameH15 = h(iQ, "TSOC", c0Var);
                    c0Var.U(iF);
                    return textInformationFrameH15;
                }
                if (iQ == 1920233063) {
                    Id3Frame id3FrameI3 = i(iQ, "ITUNESADVISORY", c0Var, false, false);
                    c0Var.U(iF);
                    return id3FrameI3;
                }
                if (iQ == 1885823344) {
                    Id3Frame id3FrameI4 = i(iQ, "ITUNESGAPLESS", c0Var, false, true);
                    c0Var.U(iF);
                    return id3FrameI4;
                }
                if (iQ == 1936683886) {
                    TextInformationFrame textInformationFrameH16 = h(iQ, "TVSHOWSORT", c0Var);
                    c0Var.U(iF);
                    return textInformationFrameH16;
                }
                if (iQ == 1953919848) {
                    TextInformationFrame textInformationFrameH17 = h(iQ, "TVSHOW", c0Var);
                    c0Var.U(iF);
                    return textInformationFrameH17;
                }
                if (iQ == 757935405) {
                    Id3Frame id3FrameE = e(c0Var, iF);
                    c0Var.U(iF);
                    return id3FrameE;
                }
            }
            z3.o.b("MetadataUtil", "Skipped unknown metadata entry: " + a.a(iQ));
            c0Var.U(iF);
            return null;
        } catch (Throwable th2) {
            c0Var.U(iF);
            throw th2;
        }
    }

    @Nullable
    public static TextInformationFrame d(int i11, String str, c0 c0Var) {
        int iQ = c0Var.q();
        if (c0Var.q() == 1684108385 && iQ >= 22) {
            c0Var.V(10);
            int iN = c0Var.N();
            if (iN > 0) {
                String str2 = "" + iN;
                int iN2 = c0Var.N();
                if (iN2 > 0) {
                    str2 = str2 + "/" + iN2;
                }
                return new TextInformationFrame(str, (String) null, ImmutableList.of(str2));
            }
        }
        z3.o.h("MetadataUtil", "Failed to parse index/count attribute: " + a.a(i11));
        return null;
    }

    @Nullable
    public static Id3Frame e(c0 c0Var, int i11) {
        String strC = null;
        String strC2 = null;
        int i12 = -1;
        int i13 = -1;
        while (c0Var.f() < i11) {
            int iF = c0Var.f();
            int iQ = c0Var.q();
            int iQ2 = c0Var.q();
            c0Var.V(4);
            if (iQ2 == 1835360622) {
                strC = c0Var.C(iQ - 12);
            } else if (iQ2 == 1851878757) {
                strC2 = c0Var.C(iQ - 12);
            } else {
                if (iQ2 == 1684108385) {
                    i12 = iF;
                    i13 = iQ;
                }
                c0Var.V(iQ - 12);
            }
        }
        if (strC == null || strC2 == null || i12 == -1) {
            return null;
        }
        c0Var.U(i12);
        c0Var.V(16);
        return new InternalFrame(strC, strC2, c0Var.C(i13 - 16));
    }

    @Nullable
    public static MdtaMetadataEntry f(c0 c0Var, int i11, String str) {
        while (true) {
            int iF = c0Var.f();
            if (iF >= i11) {
                return null;
            }
            int iQ = c0Var.q();
            if (c0Var.q() == 1684108385) {
                int iQ2 = c0Var.q();
                int iQ3 = c0Var.q();
                int i12 = iQ - 16;
                byte[] bArr = new byte[i12];
                c0Var.l(bArr, 0, i12);
                return new MdtaMetadataEntry(str, bArr, iQ3, iQ2);
            }
            c0Var.U(iF + iQ);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0011  */
    @Nullable
    public static TextInformationFrame g(c0 c0Var) {
        String str;
        int iJ = j(c0Var);
        if (iJ > 0) {
            String[] strArr = f69883a;
            if (iJ <= strArr.length) {
                str = strArr[iJ - 1];
            } else {
                str = null;
            }
        } else {
            str = null;
        }
        if (str != null) {
            return new TextInformationFrame("TCON", (String) null, ImmutableList.of(str));
        }
        z3.o.h("MetadataUtil", "Failed to parse standard genre code");
        return null;
    }

    @Nullable
    public static TextInformationFrame h(int i11, String str, c0 c0Var) {
        int iQ = c0Var.q();
        if (c0Var.q() == 1684108385) {
            c0Var.V(8);
            return new TextInformationFrame(str, (String) null, ImmutableList.of(c0Var.C(iQ - 16)));
        }
        z3.o.h("MetadataUtil", "Failed to parse text attribute: " + a.a(i11));
        return null;
    }

    @Nullable
    public static Id3Frame i(int i11, String str, c0 c0Var, boolean z11, boolean z12) {
        int iJ = j(c0Var);
        if (z12) {
            iJ = Math.min(1, iJ);
        }
        if (iJ >= 0) {
            return z11 ? new TextInformationFrame(str, (String) null, ImmutableList.of(Integer.toString(iJ))) : new CommentFrame(C.LANGUAGE_UNDETERMINED, str, Integer.toString(iJ));
        }
        z3.o.h("MetadataUtil", "Failed to parse uint8 attribute: " + a.a(i11));
        return null;
    }

    public static int j(c0 c0Var) {
        c0Var.V(4);
        if (c0Var.q() == 1684108385) {
            c0Var.V(8);
            return c0Var.H();
        }
        z3.o.h("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    public static void k(int i11, f0 f0Var, y.b bVar) {
        if (i11 == 1 && f0Var.a()) {
            bVar.S(f0Var.f78270a).T(f0Var.f78271b);
        }
    }

    public static void l(int i11, @Nullable Metadata metadata, y.b bVar, Metadata... metadataArr) {
        Metadata metadata2 = new Metadata(new Metadata.Entry[0]);
        if (metadata != null) {
            for (int i12 = 0; i12 < metadata.length(); i12++) {
                Metadata.Entry entry = metadata.get(i12);
                if (entry instanceof MdtaMetadataEntry) {
                    MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) entry;
                    if (!mdtaMetadataEntry.key.equals("com.android.capture.fps")) {
                        metadata2 = metadata2.copyWithAppendedEntries(mdtaMetadataEntry);
                    } else if (i11 == 2) {
                        metadata2 = metadata2.copyWithAppendedEntries(mdtaMetadataEntry);
                    }
                }
            }
        }
        for (Metadata metadata3 : metadataArr) {
            metadata2 = metadata2.copyWithAppendedEntriesFrom(metadata3);
        }
        if (metadata2.length() > 0) {
            bVar.d0(metadata2);
        }
    }
}
