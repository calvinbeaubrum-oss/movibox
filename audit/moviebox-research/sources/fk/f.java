package fk;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class f {
    public static boolean a(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        for (int i11 = 0; i11 < charSequence.length(); i11++) {
            if (Character.isWhitespace(charSequence.charAt(i11))) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(CharSequence charSequence) {
        if (charSequence == null) {
            return true;
        }
        for (int i11 = 0; i11 < charSequence.length(); i11++) {
            if (!Character.isWhitespace(charSequence.charAt(i11))) {
                return false;
            }
        }
        return true;
    }

    public static boolean c(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }
}
