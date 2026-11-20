package ei;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f64265a = Pattern.compile("^NOTE([ \t].*)?$");

    @Nullable
    public static Matcher a(c0 c0Var) {
        String strP;
        while (true) {
            String strP2 = c0Var.p();
            if (strP2 == null) {
                return null;
            }
            if (f64265a.matcher(strP2).matches()) {
                do {
                    strP = c0Var.p();
                    if (strP == null) {
                        break;
                    }
                } while (!strP.isEmpty());
            } else {
                Matcher matcher = f.f64239a.matcher(strP2);
                if (matcher.matches()) {
                    return matcher;
                }
            }
        }
    }

    public static boolean b(c0 c0Var) {
        String strP = c0Var.p();
        return strP != null && strP.startsWith("WEBVTT");
    }

    public static float c(String str) throws NumberFormatException {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static long d(String str) throws NumberFormatException {
        String[] strArrU0 = o0.U0(str, "\\.");
        long j11 = 0;
        for (String str2 : o0.T0(strArrU0[0], ":")) {
            j11 = (j11 * 60) + Long.parseLong(str2);
        }
        long j12 = j11 * 1000;
        if (strArrU0.length == 2) {
            j12 += Long.parseLong(strArrU0[1]);
        }
        return j12 * 1000;
    }

    public static void e(c0 c0Var) throws ParserException {
        int iE = c0Var.e();
        if (b(c0Var)) {
            return;
        }
        c0Var.P(iE);
        throw ParserException.createForMalformedContainer("Expected WEBVTT. Got " + c0Var.p(), null);
    }
}
