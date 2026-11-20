package com.applovin.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class k6 implements ti {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f20120a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f20123d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f20125f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f20126g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f20127h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f20128i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f20129j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f20130k;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f20121b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f20122c = 5000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private md f20124e = md.f20656a;

    public k6(Context context) {
        this.f20120a = context;
    }

    public r1 a(Context context, boolean z11, boolean z12, boolean z13) {
        return new s5(n1.a(context), new s5.d(new p1[0]), z11, z12, z13 ? 1 : 0);
    }

    public void a(Context context, int i11, md mdVar, boolean z11, Handler handler, wq wqVar, long j11, ArrayList arrayList) {
        int i12;
        int i13;
        pd pdVar = new pd(context, mdVar, j11, z11, handler, wqVar, 50);
        pdVar.a(this.f20125f);
        pdVar.b(this.f20126g);
        pdVar.c(this.f20127h);
        arrayList.add(pdVar);
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
                    arrayList.add(size, (qi) Class.forName("com.applovin.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(Long.TYPE, Handler.class, wq.class, Integer.TYPE).newInstance(Long.valueOf(j11), handler, wqVar, 50));
                    pc.c("DefaultRenderersFactory", "Loaded LibvpxVideoRenderer.");
                } catch (ClassNotFoundException unused) {
                    size = i12;
                    i12 = size;
                }
            } catch (Exception e11) {
                throw new RuntimeException("Error instantiating VP9 extension", e11);
            }
        } catch (ClassNotFoundException unused2) {
        }
        try {
            try {
                i13 = i12 + 1;
                try {
                    arrayList.add(i12, (qi) Class.forName("com.applovin.exoplayer2.ext.av1.Libgav1VideoRenderer").getConstructor(Long.TYPE, Handler.class, wq.class, Integer.TYPE).newInstance(Long.valueOf(j11), handler, wqVar, 50));
                    pc.c("DefaultRenderersFactory", "Loaded Libgav1VideoRenderer.");
                } catch (ClassNotFoundException unused3) {
                    i12 = i13;
                    i13 = i12;
                }
            } catch (ClassNotFoundException unused4) {
            }
            try {
                arrayList.add(i13, (qi) Class.forName("com.applovin.exoplayer2.ext.ffmpeg.FfmpegVideoRenderer").getConstructor(Long.TYPE, Handler.class, wq.class, Integer.TYPE).newInstance(Long.valueOf(j11), handler, wqVar, 50));
                pc.c("DefaultRenderersFactory", "Loaded FfmpegVideoRenderer.");
            } catch (ClassNotFoundException unused5) {
            } catch (Exception e12) {
                throw new RuntimeException("Error instantiating FFmpeg extension", e12);
            }
        } catch (Exception e13) {
            throw new RuntimeException("Error instantiating AV1 extension", e13);
        }
    }

    public void a(Context context, int i11, md mdVar, boolean z11, r1 r1Var, Handler handler, q1 q1Var, ArrayList arrayList) {
        int i12;
        int i13;
        id idVar = new id(context, mdVar, z11, handler, q1Var, r1Var);
        idVar.a(this.f20125f);
        idVar.b(this.f20126g);
        idVar.c(this.f20127h);
        arrayList.add(idVar);
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
                    arrayList.add(size, (qi) Class.forName("com.applovin.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(Handler.class, q1.class, r1.class).newInstance(handler, q1Var, r1Var));
                    pc.c("DefaultRenderersFactory", "Loaded LibopusAudioRenderer.");
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
                        arrayList.add(i12, (qi) Class.forName("com.applovin.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, q1.class, r1.class).newInstance(handler, q1Var, r1Var));
                        pc.c("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
                    } catch (ClassNotFoundException unused3) {
                        i12 = i13;
                        i13 = i12;
                    }
                } catch (ClassNotFoundException unused4) {
                }
                try {
                    arrayList.add(i13, (qi) Class.forName("com.applovin.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, q1.class, r1.class).newInstance(handler, q1Var, r1Var));
                    pc.c("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
                } catch (ClassNotFoundException unused5) {
                } catch (Exception e11) {
                    throw new RuntimeException("Error instantiating FFmpeg extension", e11);
                }
            } catch (Exception e12) {
                throw new RuntimeException("Error instantiating FLAC extension", e12);
            }
        } catch (Exception e13) {
            throw new RuntimeException("Error instantiating Opus extension", e13);
        }
    }

    public void a(Context context, int i11, ArrayList arrayList) {
        arrayList.add(new w2());
    }

    public void a(Context context, Handler handler, int i11, ArrayList arrayList) {
    }

    public void a(Context context, ao aoVar, Looper looper, int i11, ArrayList arrayList) {
        arrayList.add(new bo(aoVar, looper));
    }

    public void a(Context context, ff ffVar, Looper looper, int i11, ArrayList arrayList) {
        arrayList.add(new gf(ffVar, looper));
    }

    @Override // com.applovin.impl.ti
    public qi[] a(Handler handler, wq wqVar, q1 q1Var, ao aoVar, ff ffVar) {
        ArrayList arrayList = new ArrayList();
        a(this.f20120a, this.f20121b, this.f20124e, this.f20123d, handler, wqVar, this.f20122c, arrayList);
        r1 r1VarA = a(this.f20120a, this.f20128i, this.f20129j, this.f20130k);
        if (r1VarA != null) {
            a(this.f20120a, this.f20121b, this.f20124e, this.f20123d, r1VarA, handler, q1Var, arrayList);
        }
        a(this.f20120a, aoVar, handler.getLooper(), this.f20121b, arrayList);
        a(this.f20120a, ffVar, handler.getLooper(), this.f20121b, arrayList);
        a(this.f20120a, this.f20121b, arrayList);
        a(this.f20120a, handler, this.f20121b, arrayList);
        return (qi[]) arrayList.toArray(new qi[0]);
    }
}
