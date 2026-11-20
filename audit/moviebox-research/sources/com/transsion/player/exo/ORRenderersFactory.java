package com.transsion.player.exo;

import android.content.Context;
import android.os.Handler;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.audio.DefaultAudioSink;
import androidx.media3.exoplayer.s;
import androidx.media3.exoplayer.video.f0;
import androidx.media3.exoplayer.w2;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ORRenderersFactory extends s {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f54265k = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ORExoDecoderType f54266i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f54267j;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f54268a;

        static {
            int[] iArr = new int[ORExoDecoderType.values().length];
            try {
                iArr[ORExoDecoderType.AV1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f54268a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ORRenderersFactory(Context context, ORExoDecoderType videoRendererType) {
        super(context);
        Intrinsics.g(context, "context");
        Intrinsics.g(videoRendererType, "videoRendererType");
        this.f54266i = videoRendererType;
        this.f54267j = LazyKt__LazyJVMKt.b(new Function0<e>() { // from class: com.transsion.player.exo.ORRenderersFactory$volumeAudioProcessor$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final e invoke() {
                return new e();
            }
        });
    }

    @Override // androidx.media3.exoplayer.s
    public void b(Context context, int i11, androidx.media3.exoplayer.mediacodec.f mediaCodecSelector, boolean z11, AudioSink audioSink, Handler eventHandler, androidx.media3.exoplayer.audio.c eventListener, ArrayList<w2> out) {
        Intrinsics.g(context, "context");
        Intrinsics.g(mediaCodecSelector, "mediaCodecSelector");
        Intrinsics.g(audioSink, "audioSink");
        Intrinsics.g(eventHandler, "eventHandler");
        Intrinsics.g(eventListener, "eventListener");
        Intrinsics.g(out, "out");
        super.b(context, i11, mediaCodecSelector, z11, audioSink, eventHandler, eventListener, out);
        com.transsion.player.utils.b bVar = com.transsion.player.utils.b.f54866a;
        bVar.e("ORRenderersFactory", "buildAudioRenderers, mode:" + i11, true);
        if (i11 == 0) {
            return;
        }
        int size = out.size();
        if (i11 == 2) {
            size--;
        }
        try {
            out.add(size, new io.github.anilbeesetti.nextlib.media3ext.ffdecoder.b(eventHandler, eventListener, audioSink));
            bVar.e("ORRenderersFactory", "Loaded FfmpegAudioRenderer.", true);
        } catch (Exception e11) {
            e11.printStackTrace();
            com.transsion.player.utils.b.f54866a.c("ORRenderersFactory", "Error instantiating Ffmpeg extension :" + e11, true);
        }
    }

    @Override // androidx.media3.exoplayer.s
    public AudioSink c(Context context, boolean z11, boolean z12) {
        Intrinsics.g(context, "context");
        DefaultAudioSink defaultAudioSinkI = new DefaultAudioSink.f(context).m(z11).l(z12).k(new e[]{n()}).i();
        Intrinsics.f(defaultAudioSinkI, "Builder(context)\n       …or))\n            .build()");
        return defaultAudioSinkI;
    }

    @Override // androidx.media3.exoplayer.s
    public void i(Context context, int i11, androidx.media3.exoplayer.mediacodec.f mediaCodecSelector, boolean z11, Handler eventHandler, f0 eventListener, long j11, ArrayList<w2> out) {
        Intrinsics.g(context, "context");
        Intrinsics.g(mediaCodecSelector, "mediaCodecSelector");
        Intrinsics.g(eventHandler, "eventHandler");
        Intrinsics.g(eventListener, "eventListener");
        Intrinsics.g(out, "out");
        super.i(context, i11, mediaCodecSelector, z11, eventHandler, eventListener, j11, out);
        com.transsion.player.utils.b bVar = com.transsion.player.utils.b.f54866a;
        bVar.e("ORRenderersFactory", "buildVideoRenderers, mode:" + i11, true);
        if (i11 == 0) {
            return;
        }
        int size = out.size();
        if (i11 == 2) {
            size--;
        }
        try {
            out.add(size, b.f54268a[this.f54266i.ordinal()] == 1 ? new d4.c(j11, eventHandler, eventListener, 50) : new io.github.anilbeesetti.nextlib.media3ext.ffdecoder.d(j11, eventHandler, eventListener, 50));
            bVar.e("ORRenderersFactory", "Loaded FfmpegVideoRenderer.", true);
        } catch (Exception e11) {
            e11.printStackTrace();
            com.transsion.player.utils.b.f54866a.c("ORRenderersFactory", "Error instantiating Ffmpeg extension :" + e11, true);
        }
    }

    public final e n() {
        return (e) this.f54267j.getValue();
    }

    public void o(float f11) {
        if (f11 > 1.0f) {
            f11 = (2 * f11) - 1.0f;
        }
        n().b(f11);
    }
}
