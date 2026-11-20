package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.o0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface AudioProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ByteBuffer f32701a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    /* JADX INFO: compiled from: source.java */
    public static final class UnhandledAudioFormatException extends Exception {
        public UnhandledAudioFormatException(a aVar) {
            super("Unhandled format: " + aVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f32702e = new a(-1, -1, -1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f32703a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f32704b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f32705c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f32706d;

        public a(int i11, int i12, int i13) {
            this.f32703a = i11;
            this.f32704b = i12;
            this.f32705c = i13;
            this.f32706d = o0.u0(i13) ? o0.e0(i13, i12) : -1;
        }

        public String toString() {
            return "AudioFormat[sampleRate=" + this.f32703a + ", channelCount=" + this.f32704b + ", encoding=" + this.f32705c + ']';
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
