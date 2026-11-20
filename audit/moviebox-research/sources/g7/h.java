package g7;

import androidx.core.os.r;
import com.amazonaws.services.s3.model.InstructionFileId;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f65439a = new String[5];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f65440b = new long[5];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f65441c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f65442d = 0;

    public void a(String str) {
        int i11 = this.f65441c;
        if (i11 == 5) {
            this.f65442d++;
            return;
        }
        this.f65439a[i11] = str;
        this.f65440b[i11] = System.nanoTime();
        r.a(str);
        this.f65441c++;
    }

    public float b(String str) {
        int i11 = this.f65442d;
        if (i11 > 0) {
            this.f65442d = i11 - 1;
            return 0.0f;
        }
        int i12 = this.f65441c - 1;
        this.f65441c = i12;
        if (i12 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (str.equals(this.f65439a[i12])) {
            r.b();
            return (System.nanoTime() - this.f65440b[this.f65441c]) / 1000000.0f;
        }
        throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + this.f65439a[this.f65441c] + InstructionFileId.DOT);
    }
}
