package androidx.media3.ui;

import android.graphics.Color;
import com.amazonaws.services.s3.model.InstructionFileId;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h {
    public static String a(String str) {
        return InstructionFileId.DOT + str + ",." + str + " *";
    }

    public static String b(int i11) {
        return u0.G("rgba(%d,%d,%d,%.3f)", Integer.valueOf(Color.red(i11)), Integer.valueOf(Color.green(i11)), Integer.valueOf(Color.blue(i11)), Double.valueOf(((double) Color.alpha(i11)) / 255.0d));
    }
}
