package com.google.android.exoplayer2.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.exoplayer2.m1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class g implements o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f35107a;

    public g(Resources resources) {
        this.f35107a = (Resources) com.google.android.exoplayer2.util.a.e(resources);
    }

    public static int i(m1 m1Var) {
        int iK = com.google.android.exoplayer2.util.w.k(m1Var.f33445m);
        if (iK != -1) {
            return iK;
        }
        if (com.google.android.exoplayer2.util.w.n(m1Var.f33442j) != null) {
            return 2;
        }
        if (com.google.android.exoplayer2.util.w.c(m1Var.f33442j) != null) {
            return 1;
        }
        if (m1Var.f33450r == -1 && m1Var.f33451s == -1) {
            return (m1Var.f33458z == -1 && m1Var.A == -1) ? -1 : 1;
        }
        return 2;
    }

    @Override // com.google.android.exoplayer2.ui.o0
    public String a(m1 m1Var) {
        String strJ;
        int i11 = i(m1Var);
        if (i11 == 2) {
            strJ = j(h(m1Var), g(m1Var), c(m1Var));
        } else {
            strJ = i11 == 1 ? j(e(m1Var), b(m1Var), c(m1Var)) : e(m1Var);
        }
        return strJ.length() == 0 ? this.f35107a.getString(R$string.exo_track_unknown) : strJ;
    }

    public final String b(m1 m1Var) {
        int i11 = m1Var.f33458z;
        if (i11 == -1 || i11 < 1) {
            return "";
        }
        if (i11 == 1) {
            return this.f35107a.getString(R$string.exo_track_mono);
        }
        if (i11 == 2) {
            return this.f35107a.getString(R$string.exo_track_stereo);
        }
        if (i11 == 6 || i11 == 7) {
            return this.f35107a.getString(R$string.exo_track_surround_5_point_1);
        }
        return i11 != 8 ? this.f35107a.getString(R$string.exo_track_surround) : this.f35107a.getString(R$string.exo_track_surround_7_point_1);
    }

    public final String c(m1 m1Var) {
        int i11 = m1Var.f33441i;
        return i11 == -1 ? "" : this.f35107a.getString(R$string.exo_track_bitrate, Float.valueOf(i11 / 1000000.0f));
    }

    public final String d(m1 m1Var) {
        return TextUtils.isEmpty(m1Var.f33435b) ? "" : m1Var.f33435b;
    }

    public final String e(m1 m1Var) {
        String strJ = j(f(m1Var), h(m1Var));
        return TextUtils.isEmpty(strJ) ? d(m1Var) : strJ;
    }

    public final String f(m1 m1Var) {
        String str = m1Var.f33436c;
        if (TextUtils.isEmpty(str) || C.LANGUAGE_UNDETERMINED.equals(str)) {
            return "";
        }
        Locale localeForLanguageTag = com.google.android.exoplayer2.util.o0.f35608a >= 21 ? Locale.forLanguageTag(str) : new Locale(str);
        Locale localeR = com.google.android.exoplayer2.util.o0.R();
        String displayName = localeForLanguageTag.getDisplayName(localeR);
        if (TextUtils.isEmpty(displayName)) {
            return "";
        }
        try {
            int iOffsetByCodePoints = displayName.offsetByCodePoints(0, 1);
            return displayName.substring(0, iOffsetByCodePoints).toUpperCase(localeR) + displayName.substring(iOffsetByCodePoints);
        } catch (IndexOutOfBoundsException unused) {
            return displayName;
        }
    }

    public final String g(m1 m1Var) {
        int i11 = m1Var.f33450r;
        int i12 = m1Var.f33451s;
        return (i11 == -1 || i12 == -1) ? "" : this.f35107a.getString(R$string.exo_track_resolution, Integer.valueOf(i11), Integer.valueOf(i12));
    }

    public final String h(m1 m1Var) {
        String string = (m1Var.f33438f & 2) != 0 ? this.f35107a.getString(R$string.exo_track_role_alternate) : "";
        if ((m1Var.f33438f & 4) != 0) {
            string = j(string, this.f35107a.getString(R$string.exo_track_role_supplementary));
        }
        if ((m1Var.f33438f & 8) != 0) {
            string = j(string, this.f35107a.getString(R$string.exo_track_role_commentary));
        }
        return (m1Var.f33438f & 1088) != 0 ? j(string, this.f35107a.getString(R$string.exo_track_role_closed_captions)) : string;
    }

    public final String j(String... strArr) {
        String string = "";
        for (String str : strArr) {
            if (str.length() > 0) {
                string = TextUtils.isEmpty(string) ? str : this.f35107a.getString(R$string.exo_item_list, string, str);
            }
        }
        return string;
    }
}
