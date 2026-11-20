package u4;

import androidx.annotation.Nullable;
import com.amazonaws.services.s3.model.InstructionFileId;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f78349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f78350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f78351c;

    public n(int i11, int i12, String str) {
        this.f78349a = i11;
        this.f78350b = i12;
        this.f78351c = str;
    }

    @Nullable
    public static n a(z3.c0 c0Var) {
        String str;
        c0Var.V(2);
        int iH = c0Var.H();
        int i11 = iH >> 1;
        int iH2 = ((c0Var.H() >> 3) & 31) | ((iH & 1) << 5);
        if (i11 == 4 || i11 == 5 || i11 == 7) {
            str = "dvhe";
        } else if (i11 == 8) {
            str = "hev1";
        } else {
            if (i11 != 9) {
                return null;
            }
            str = "avc3";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(".0");
        sb2.append(i11);
        sb2.append(iH2 >= 10 ? InstructionFileId.DOT : ".0");
        sb2.append(iH2);
        return new n(i11, iH2, sb2.toString());
    }
}
