package androidx.media3.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Locale;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class g implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f12062a;

    public g(Resources resources) {
        this.f12062a = (Resources) z3.a.e(resources);
    }

    public static int i(androidx.media3.common.y yVar) {
        int iK = androidx.media3.common.f0.k(yVar.f9501m);
        if (iK != -1) {
            return iK;
        }
        if (androidx.media3.common.f0.n(yVar.f9498j) != null) {
            return 2;
        }
        if (androidx.media3.common.f0.c(yVar.f9498j) != null) {
            return 1;
        }
        if (yVar.f9506r == -1 && yVar.f9507s == -1) {
            return (yVar.f9514z == -1 && yVar.A == -1) ? -1 : 1;
        }
        return 2;
    }

    @Override // androidx.media3.ui.p0
    public String a(androidx.media3.common.y yVar) {
        String strJ;
        int i11 = i(yVar);
        if (i11 == 2) {
            strJ = j(h(yVar), g(yVar), c(yVar));
        } else {
            strJ = i11 == 1 ? j(e(yVar), b(yVar), c(yVar)) : e(yVar);
        }
        if (strJ.length() != 0) {
            return strJ;
        }
        String str = yVar.f9492d;
        return (str == null || str.trim().isEmpty()) ? this.f12062a.getString(R$string.exo_track_unknown) : this.f12062a.getString(R$string.exo_track_unknown_name, str);
    }

    public final String b(androidx.media3.common.y yVar) {
        int i11 = yVar.f9514z;
        if (i11 == -1 || i11 < 1) {
            return "";
        }
        if (i11 == 1) {
            return this.f12062a.getString(R$string.exo_track_mono);
        }
        if (i11 == 2) {
            return this.f12062a.getString(R$string.exo_track_stereo);
        }
        if (i11 == 6 || i11 == 7) {
            return this.f12062a.getString(R$string.exo_track_surround_5_point_1);
        }
        return i11 != 8 ? this.f12062a.getString(R$string.exo_track_surround) : this.f12062a.getString(R$string.exo_track_surround_7_point_1);
    }

    public final String c(androidx.media3.common.y yVar) {
        int i11 = yVar.f9497i;
        return i11 == -1 ? "" : this.f12062a.getString(R$string.exo_track_bitrate, Float.valueOf(i11 / 1000000.0f));
    }

    public final String d(androidx.media3.common.y yVar) {
        return TextUtils.isEmpty(yVar.f9490b) ? "" : yVar.f9490b;
    }

    public final String e(androidx.media3.common.y yVar) {
        String strJ = j(f(yVar), h(yVar));
        return TextUtils.isEmpty(strJ) ? d(yVar) : strJ;
    }

    public final String f(androidx.media3.common.y yVar) {
        String str = yVar.f9492d;
        if (TextUtils.isEmpty(str) || C.LANGUAGE_UNDETERMINED.equals(str)) {
            return "";
        }
        Locale localeForLanguageTag = u0.f81838a >= 21 ? Locale.forLanguageTag(str) : new Locale(str);
        Locale localeW = u0.W();
        String displayName = localeForLanguageTag.getDisplayName(localeW);
        if (TextUtils.isEmpty(displayName)) {
            return "";
        }
        try {
            int iOffsetByCodePoints = displayName.offsetByCodePoints(0, 1);
            return displayName.substring(0, iOffsetByCodePoints).toUpperCase(localeW) + displayName.substring(iOffsetByCodePoints);
        } catch (IndexOutOfBoundsException unused) {
            return displayName;
        }
    }

    public final String g(androidx.media3.common.y yVar) {
        int i11 = yVar.f9506r;
        int i12 = yVar.f9507s;
        return (i11 == -1 || i12 == -1) ? "" : this.f12062a.getString(R$string.exo_track_resolution, Integer.valueOf(i11), Integer.valueOf(i12));
    }

    public final String h(androidx.media3.common.y yVar) {
        String string = (yVar.f9494f & 2) != 0 ? this.f12062a.getString(R$string.exo_track_role_alternate) : "";
        if ((yVar.f9494f & 4) != 0) {
            string = j(string, this.f12062a.getString(R$string.exo_track_role_supplementary));
        }
        if ((yVar.f9494f & 8) != 0) {
            string = j(string, this.f12062a.getString(R$string.exo_track_role_commentary));
        }
        return (yVar.f9494f & 1088) != 0 ? j(string, this.f12062a.getString(R$string.exo_track_role_closed_captions)) : string;
    }

    public final String j(String... strArr) {
        String string = "";
        for (String str : strArr) {
            if (str.length() > 0) {
                string = TextUtils.isEmpty(string) ? str : this.f12062a.getString(R$string.exo_item_list, string, str);
            }
        }
        return string;
    }
}
