package u4;

import androidx.annotation.Nullable;
import androidx.media3.common.ParserException;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class v {
    public static void a(boolean z11, @Nullable String str) throws ParserException {
        if (!z11) {
            throw ParserException.createForMalformedContainer(str, null);
        }
    }

    public static boolean b(t tVar, byte[] bArr, int i11, int i12, boolean z11) throws IOException {
        try {
            return tVar.peekFully(bArr, i11, i12, z11);
        } catch (EOFException e11) {
            if (z11) {
                return false;
            }
            throw e11;
        }
    }

    public static int c(t tVar, byte[] bArr, int i11, int i12) throws IOException {
        int i13 = 0;
        while (i13 < i12) {
            int iB = tVar.b(bArr, i11 + i13, i12 - i13);
            if (iB == -1) {
                break;
            }
            i13 += iB;
        }
        return i13;
    }

    public static boolean d(t tVar, byte[] bArr, int i11, int i12) throws IOException {
        try {
            tVar.readFully(bArr, i11, i12);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean e(t tVar, int i11) throws IOException {
        try {
            tVar.skipFully(i11);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
