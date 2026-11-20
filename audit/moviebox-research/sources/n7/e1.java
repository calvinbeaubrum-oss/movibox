package n7;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e1 f71599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f71600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f71601c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f71602d;

    public e1(e1 e1Var, Object obj, Object obj2, int i11, int i12) {
        this.f71599a = e1Var;
        this.f71600b = obj;
        this.f71601c = obj2;
        this.f71602d = i11;
    }

    public void a(StringBuilder sb2) {
        e1 e1Var = this.f71599a;
        if (e1Var == null) {
            sb2.append('$');
            return;
        }
        e1Var.a(sb2);
        Object obj = this.f71601c;
        if (obj == null) {
            sb2.append(".null");
            return;
        }
        if (obj instanceof Integer) {
            sb2.append('[');
            sb2.append(((Integer) this.f71601c).intValue());
            sb2.append(']');
            return;
        }
        sb2.append('.');
        String string = this.f71601c.toString();
        for (int i11 = 0; i11 < string.length(); i11++) {
            char cCharAt = string.charAt(i11);
            if ((cCharAt < '0' || cCharAt > '9') && ((cCharAt < 'A' || cCharAt > 'Z') && ((cCharAt < 'a' || cCharAt > 'z') && cCharAt <= 128))) {
                for (int i12 = 0; i12 < string.length(); i12++) {
                    char cCharAt2 = string.charAt(i12);
                    if (cCharAt2 == '\\') {
                        sb2.append('\\');
                        sb2.append('\\');
                        sb2.append('\\');
                    } else {
                        if ((cCharAt2 >= '0' && cCharAt2 <= '9') || ((cCharAt2 >= 'A' && cCharAt2 <= 'Z') || ((cCharAt2 >= 'a' && cCharAt2 <= 'z') || cCharAt2 > 128))) {
                            sb2.append(cCharAt2);
                        } else if (cCharAt2 == '\"') {
                            sb2.append('\\');
                            sb2.append('\\');
                            sb2.append('\\');
                        } else {
                            sb2.append('\\');
                            sb2.append('\\');
                        }
                    }
                    sb2.append(cCharAt2);
                }
                return;
            }
        }
        sb2.append(string);
    }

    public String toString() {
        if (this.f71599a == null) {
            return "$";
        }
        StringBuilder sb2 = new StringBuilder();
        a(sb2);
        return sb2.toString();
    }
}
