package androidx.media3.exoplayer;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.audio.DefaultAudioSink;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class s implements a3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.media3.exoplayer.mediacodec.b f11002b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f11005e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f11007g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f11008h;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11003c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f11004d = 5000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public androidx.media3.exoplayer.mediacodec.f f11006f = androidx.media3.exoplayer.mediacodec.f.f10768a;

    public s(Context context) {
        this.f11001a = context;
        this.f11002b = new androidx.media3.exoplayer.mediacodec.b(context);
    }

    @Override // androidx.media3.exoplayer.a3
    public w2[] a(Handler handler, androidx.media3.exoplayer.video.f0 f0Var, androidx.media3.exoplayer.audio.c cVar, r4.h hVar, n4.b bVar) {
        ArrayList<w2> arrayList = new ArrayList<>();
        i(this.f11001a, this.f11003c, this.f11006f, this.f11005e, handler, f0Var, this.f11004d, arrayList);
        AudioSink audioSinkC = c(this.f11001a, this.f11007g, this.f11008h);
        if (audioSinkC != null) {
            b(this.f11001a, this.f11003c, this.f11006f, this.f11005e, audioSinkC, handler, cVar, arrayList);
        }
        h(this.f11001a, hVar, handler.getLooper(), this.f11003c, arrayList);
        f(this.f11001a, bVar, handler.getLooper(), this.f11003c, arrayList);
        d(this.f11001a, this.f11003c, arrayList);
        e(arrayList);
        g(this.f11001a, handler, this.f11003c, arrayList);
        return (w2[]) arrayList.toArray(new w2[0]);
    }

    public void b(Context context, int i11, androidx.media3.exoplayer.mediacodec.f fVar, boolean z11, AudioSink audioSink, Handler handler, androidx.media3.exoplayer.audio.c cVar, ArrayList<w2> arrayList) {
        int i12;
        int i13;
        int i14;
        arrayList.add(new androidx.media3.exoplayer.audio.h(context, k(), fVar, z11, handler, cVar, audioSink));
        if (i11 == 0) {
            return;
        }
        int size = arrayList.size();
        if (i11 == 2) {
            size--;
        }
        try {
            try {
                i12 = size + 1;
                try {
                    arrayList.add(size, (w2) Class.forName("androidx.media3.decoder.midi.MidiRenderer").getConstructor(Context.class).newInstance(context));
                    z3.o.f("DefaultRenderersFactory", "Loaded MidiRenderer.");
                } catch (ClassNotFoundException unused) {
                    size = i12;
                    i12 = size;
                }
            } catch (ClassNotFoundException unused2) {
            }
            try {
                try {
                    i13 = i12 + 1;
                    try {
                        arrayList.add(i12, (w2) Class.forName("androidx.media3.decoder.opus.LibopusAudioRenderer").getConstructor(Handler.class, androidx.media3.exoplayer.audio.c.class, AudioSink.class).newInstance(handler, cVar, audioSink));
                        z3.o.f("DefaultRenderersFactory", "Loaded LibopusAudioRenderer.");
                    } catch (ClassNotFoundException unused3) {
                        i12 = i13;
                        i13 = i12;
                    }
                } catch (ClassNotFoundException unused4) {
                }
                try {
                    try {
                        i14 = i13 + 1;
                        try {
                            arrayList.add(i13, (w2) Class.forName("androidx.media3.decoder.flac.LibflacAudioRenderer").getConstructor(Handler.class, androidx.media3.exoplayer.audio.c.class, AudioSink.class).newInstance(handler, cVar, audioSink));
                            z3.o.f("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
                        } catch (ClassNotFoundException unused5) {
                            i13 = i14;
                            i14 = i13;
                        }
                    } catch (ClassNotFoundException unused6) {
                    }
                    try {
                        arrayList.add(i14, (w2) Class.forName("androidx.media3.decoder.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, androidx.media3.exoplayer.audio.c.class, AudioSink.class).newInstance(handler, cVar, audioSink));
                        z3.o.f("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
                    } catch (ClassNotFoundException unused7) {
                    } catch (Exception e11) {
                        throw new RuntimeException("Error instantiating FFmpeg extension", e11);
                    }
                } catch (Exception e12) {
                    throw new RuntimeException("Error instantiating FLAC extension", e12);
                }
            } catch (Exception e13) {
                throw new RuntimeException("Error instantiating Opus extension", e13);
            }
        } catch (Exception e14) {
            throw new RuntimeException("Error instantiating MIDI extension", e14);
        }
    }

    @Nullable
    public AudioSink c(Context context, boolean z11, boolean z12) {
        return new DefaultAudioSink.f(context).m(z11).l(z12).i();
    }

    public void d(Context context, int i11, ArrayList<w2> arrayList) {
        arrayList.add(new t4.b());
    }

    public void e(ArrayList<w2> arrayList) {
        arrayList.add(new l4.f(l4.c.a.f69780a, null));
    }

    public void f(Context context, n4.b bVar, Looper looper, int i11, ArrayList<w2> arrayList) {
        arrayList.add(new n4.c(bVar, looper));
    }

    public void g(Context context, Handler handler, int i11, ArrayList<w2> arrayList) {
    }

    public void h(Context context, r4.h hVar, Looper looper, int i11, ArrayList<w2> arrayList) {
        arrayList.add(new r4.i(hVar, looper));
    }

    public void i(Context context, int i11, androidx.media3.exoplayer.mediacodec.f fVar, boolean z11, Handler handler, androidx.media3.exoplayer.video.f0 f0Var, long j11, ArrayList<w2> arrayList) {
        int i12;
        int i13;
        arrayList.add(new androidx.media3.exoplayer.video.j(context, k(), fVar, j11, z11, handler, f0Var, 50));
        if (i11 == 0) {
            return;
        }
        int size = arrayList.size();
        if (i11 == 2) {
            size--;
        }
        try {
            try {
                i12 = size + 1;
                try {
                    arrayList.add(size, (w2) Class.forName("androidx.media3.decoder.vp9.LibvpxVideoRenderer").getConstructor(Long.TYPE, Handler.class, androidx.media3.exoplayer.video.f0.class, Integer.TYPE).newInstance(Long.valueOf(j11), handler, f0Var, 50));
                    z3.o.f("DefaultRenderersFactory", "Loaded LibvpxVideoRenderer.");
                } catch (ClassNotFoundException unused) {
                    size = i12;
                    i12 = size;
                }
            } catch (ClassNotFoundException unused2) {
            }
            try {
                try {
                    int i14 = d4.c.f62929d0;
                    i13 = i12 + 1;
                    try {
                        arrayList.add(i12, (w2) d4.c.class.getConstructor(Long.TYPE, Handler.class, androidx.media3.exoplayer.video.f0.class, Integer.TYPE).newInstance(Long.valueOf(j11), handler, f0Var, 50));
                        z3.o.f("DefaultRenderersFactory", "Loaded Libgav1VideoRenderer.");
                    } catch (ClassNotFoundException unused3) {
                        i12 = i13;
                        i13 = i12;
                    }
                } catch (ClassNotFoundException unused4) {
                }
                try {
                    arrayList.add(i13, (w2) Class.forName("androidx.media3.decoder.ffmpeg.ExperimentalFfmpegVideoRenderer").getConstructor(Long.TYPE, Handler.class, androidx.media3.exoplayer.video.f0.class, Integer.TYPE).newInstance(Long.valueOf(j11), handler, f0Var, 50));
                    z3.o.f("DefaultRenderersFactory", "Loaded FfmpegVideoRenderer.");
                } catch (ClassNotFoundException unused5) {
                } catch (Exception e11) {
                    throw new RuntimeException("Error instantiating FFmpeg extension", e11);
                }
            } catch (Exception e12) {
                throw new RuntimeException("Error instantiating AV1 extension", e12);
            }
        } catch (Exception e13) {
            throw new RuntimeException("Error instantiating VP9 extension", e13);
        }
    }

    public final s j() {
        this.f11002b.b();
        return this;
    }

    public androidx.media3.exoplayer.mediacodec.c.b k() {
        return this.f11002b;
    }

    public final s l(boolean z11) {
        this.f11005e = z11;
        return this;
    }

    public final s m(int i11) {
        this.f11003c = i11;
        return this;
    }
}
