package w5;

import androidx.annotation.Nullable;
import androidx.media3.common.ParserException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import z3.c0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f79339a = Pattern.compile("^NOTE([ \t].*)?$");

    @Nullable
    public static Matcher a(c0 c0Var) {
        String strS;
        while (true) {
            String strS2 = c0Var.s();
            if (strS2 == null) {
                return null;
            }
            if (f79339a.matcher(strS2).matches()) {
                do {
                    strS = c0Var.s();
                    if (strS == null) {
                        break;
                    }
                } while (!strS.isEmpty());
            } else {
                Matcher matcher = e.f79313a.matcher(strS2);
                if (matcher.matches()) {
                    return matcher;
                }
            }
        }
    }

    public static boolean b(c0 c0Var) {
        String strS = c0Var.s();
        return strS != null && strS.startsWith("WEBVTT");
    }

    public static float c(String str) throws NumberFormatException {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static long d(String str) throws NumberFormatException {
        String[] strArrP1 = u0.p1(str, "\\.");
        long j11 = 0;
        for (String str2 : u0.o1(strArrP1[0], ":")) {
            j11 = (j11 * 60) + Long.parseLong(str2);
        }
        long j12 = j11 * 1000;
        if (strArrP1.length == 2) {
            j12 += Long.parseLong(strArrP1[1]);
        }
        return j12 * 1000;
    }

    public static void e(c0 c0Var) throws ParserException {
        int iF = c0Var.f();
        if (b(c0Var)) {
            return;
        }
        c0Var.U(iF);
        throw ParserException.createForMalformedContainer("Expected WEBVTT. Got " + c0Var.s(), null);
    }
}
