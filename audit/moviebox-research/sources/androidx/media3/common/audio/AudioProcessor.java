package androidx.media3.common.audio;

import androidx.annotation.Nullable;
import androidx.media3.common.y;
import com.google.common.base.j;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface AudioProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ByteBuffer f8908a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    /* JADX INFO: compiled from: source.java */
    public static final class UnhandledAudioFormatException extends Exception {
        public final a inputAudioFormat;

        public UnhandledAudioFormatException(a aVar) {
            this("Unhandled input format:", aVar);
        }

        public UnhandledAudioFormatException(String str, a aVar) {
            super(str + " " + aVar);
            this.inputAudioFormat = aVar;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f8909e = new a(-1, -1, -1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8910a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f8911b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f8912c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f8913d;

        public a(int i11, int i12, int i13) {
            this.f8910a = i11;
            this.f8911b = i12;
            this.f8912c = i13;
            this.f8913d = u0.I0(i13) ? u0.l0(i13, i12) : -1;
        }

        public a(y yVar) {
            this(yVar.A, yVar.f9514z, yVar.B);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f8910a == aVar.f8910a && this.f8911b == aVar.f8911b && this.f8912c == aVar.f8912c;
        }

        public int hashCode() {
            return j.b(Integer.valueOf(this.f8910a), Integer.valueOf(this.f8911b), Integer.valueOf(this.f8912c));
        }

        public String toString() {
            return "AudioFormat[sampleRate=" + this.f8910a + ", channelCount=" + this.f8911b + ", encoding=" + this.f8912c + ']';
        }
    }

    a a(a aVar) throws UnhandledAudioFormatException;

    void flush();

    ByteBuffer getOutput();

    boolean isActive();

    boolean isEnded();

    void queueEndOfStream();

    void queueInput(ByteBuffer byteBuffer);

    void reset();
}
