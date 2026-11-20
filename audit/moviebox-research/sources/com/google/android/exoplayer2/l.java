package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class l implements a3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f33422a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f33426e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f33428g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f33429h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f33430i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.mediacodec.b f33423b = new com.google.android.exoplayer2.mediacodec.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f33424c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f33425d = 5000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.google.android.exoplayer2.mediacodec.e f33427f = com.google.android.exoplayer2.mediacodec.e.f33564a;

    public l(Context context) {
        this.f33422a = context;
    }

    @Override // com.google.android.exoplayer2.a3
    public w2[] a(Handler handler, com.google.android.exoplayer2.video.w wVar, com.google.android.exoplayer2.audio.r rVar, vh.o oVar, gh.e eVar) {
        ArrayList<w2> arrayList = new ArrayList<>();
        h(this.f33422a, this.f33424c, this.f33427f, this.f33426e, handler, wVar, this.f33425d, arrayList);
        AudioSink audioSinkC = c(this.f33422a, this.f33428g, this.f33429h, this.f33430i);
        if (audioSinkC != null) {
            b(this.f33422a, this.f33424c, this.f33427f, this.f33426e, audioSinkC, handler, rVar, arrayList);
        }
        g(this.f33422a, oVar, handler.getLooper(), this.f33424c, arrayList);
        e(this.f33422a, eVar, handler.getLooper(), this.f33424c, arrayList);
        d(this.f33422a, this.f33424c, arrayList);
        f(this.f33422a, handler, this.f33424c, arrayList);
        return (w2[]) arrayList.toArray(new w2[0]);
    }

    public void b(Context context, int i11, com.google.android.exoplayer2.mediacodec.e eVar, boolean z11, AudioSink audioSink, Handler handler, com.google.android.exoplayer2.audio.r rVar, ArrayList<w2> arrayList) {
        int i12;
        int i13;
        int i14;
        arrayList.add(new com.google.android.exoplayer2.audio.a0(context, i(), eVar, z11, handler, rVar, audioSink));
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
                    arrayList.add(size, (w2) Class.forName("com.google.android.exoplayer2.decoder.midi.MidiRenderer").getConstructor(new Class[0]).newInstance(new Object[0]));
                    com.google.android.exoplayer2.util.s.f("DefaultRenderersFactory", "Loaded MidiRenderer.");
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
                        arrayList.add(i12, (w2) Class.forName("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(Handler.class, com.google.android.exoplayer2.audio.r.class, AudioSink.class).newInstance(handler, rVar, audioSink));
                        com.google.android.exoplayer2.util.s.f("DefaultRenderersFactory", "Loaded LibopusAudioRenderer.");
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
                            arrayList.add(i13, (w2) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, com.google.android.exoplayer2.audio.r.class, AudioSink.class).newInstance(handler, rVar, audioSink));
                            com.google.android.exoplayer2.util.s.f("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
                        } catch (ClassNotFoundException unused5) {
                            i13 = i14;
                            i14 = i13;
                        }
                    } catch (ClassNotFoundException unused6) {
                    }
                    try {
                        arrayList.add(i14, (w2) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, com.google.android.exoplayer2.audio.r.class, AudioSink.class).newInstance(handler, rVar, audioSink));
                        com.google.android.exoplayer2.util.s.f("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
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
    public AudioSink c(Context context, boolean z11, boolean z12, boolean z13) {
        return new DefaultAudioSink.d().g(com.google.android.exoplayer2.audio.f.c(context)).i(z11).h(z12).j(z13 ? 1 : 0).f();
    }

    public void d(Context context, int i11, ArrayList<w2> arrayList) {
        arrayList.add(new gi.b());
    }

    public void e(Context context, gh.e eVar, Looper looper, int i11, ArrayList<w2> arrayList) {
        arrayList.add(new com.google.android.exoplayer2.metadata.a(eVar, looper));
    }

    public void f(Context context, Handler handler, int i11, ArrayList<w2> arrayList) {
    }

    public void g(Context context, vh.o oVar, Looper looper, int i11, ArrayList<w2> arrayList) {
        arrayList.add(new vh.p(oVar, looper));
    }

    public void h(Context context, int i11, com.google.android.exoplayer2.mediacodec.e eVar, boolean z11, Handler handler, com.google.android.exoplayer2.video.w wVar, long j11, ArrayList<w2> arrayList) {
        int i12;
        arrayList.add(new com.google.android.exoplayer2.video.g(context, i(), eVar, j11, z11, handler, wVar, 50));
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
                    arrayList.add(size, (w2) Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(Long.TYPE, Handler.class, com.google.android.exoplayer2.video.w.class, Integer.TYPE).newInstance(Long.valueOf(j11), handler, wVar, 50));
                    com.google.android.exoplayer2.util.s.f("DefaultRenderersFactory", "Loaded LibvpxVideoRenderer.");
                } catch (ClassNotFoundException unused) {
                    size = i12;
                    i12 = size;
                }
            } catch (ClassNotFoundException unused2) {
            }
            try {
                arrayList.add(i12, (w2) Class.forName("com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer").getConstructor(Long.TYPE, Handler.class, com.google.android.exoplayer2.video.w.class, Integer.TYPE).newInstance(Long.valueOf(j11), handler, wVar, 50));
                com.google.android.exoplayer2.util.s.f("DefaultRenderersFactory", "Loaded Libgav1VideoRenderer.");
            } catch (ClassNotFoundException unused3) {
            } catch (Exception e11) {
                throw new RuntimeException("Error instantiating AV1 extension", e11);
            }
        } catch (Exception e12) {
            throw new RuntimeException("Error instantiating VP9 extension", e12);
        }
    }

    public com.google.android.exoplayer2.mediacodec.c.b i() {
        return this.f33423b;
    }

    public l j(boolean z11) {
        this.f33426e = z11;
        return this;
    }
}
