package com.cloud.tmc.integration.audio.recording;

import android.media.MediaRecorder;
import android.os.Build;
import com.cloud.tmc.kernel.log.TmcLogger;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class c implements f, RecorderTimer.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f30427f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecorderTimer f30428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MediaRecorder f30429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public File f30430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicInteger f30431d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g f30432e;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public c() {
        RecorderTimer recorderTimer = new RecorderTimer();
        recorderTimer.h(this);
        this.f30428a = recorderTimer;
        this.f30431d = new AtomicInteger(0);
    }

    @Override // com.cloud.tmc.integration.audio.recording.f
    public boolean a() {
        return this.f30431d.get() == 0;
    }

    @Override // com.cloud.tmc.integration.audio.recording.f
    public boolean e() {
        return this.f30431d.get() == 2;
    }

    @Override // com.cloud.tmc.integration.audio.recording.f
    public void f() {
        TmcLogger.c("AudioRecorder", "stopRecording isStopped: " + a());
        if (a()) {
            TmcLogger.f("AudioRecorder", "Recording has already stopped or hasn't started");
            return;
        }
        try {
            MediaRecorder mediaRecorder = this.f30429b;
            if (mediaRecorder != null) {
                mediaRecorder.stop();
            }
            MediaRecorder mediaRecorder2 = this.f30429b;
            if (mediaRecorder2 != null) {
                mediaRecorder2.release();
            }
        } catch (Throwable th2) {
            TmcLogger.g("AudioRecorder", "stopRecording() problems", th2);
        }
        g gVar = this.f30432e;
        if (gVar != null) {
            gVar.b(this.f30430c, this.f30428a.b());
        }
        this.f30428a.d();
        this.f30430c = null;
        this.f30431d.set(0);
        this.f30429b = null;
    }

    @Override // com.cloud.tmc.integration.audio.recording.f
    public void g() {
        TmcLogger.c("AudioRecorder", "pauseRecording isRecording: " + j());
        if (Build.VERSION.SDK_INT < 24 || !j()) {
            return;
        }
        try {
            MediaRecorder mediaRecorder = this.f30429b;
            if (mediaRecorder != null) {
                mediaRecorder.pause();
            }
            this.f30428a.c();
            g gVar = this.f30432e;
            if (gVar != null) {
                gVar.d();
            }
            this.f30431d.set(2);
        } catch (Throwable th2) {
            TmcLogger.g("AudioRecorder", "pauseRecording() failed", th2);
            g gVar2 = this.f30432e;
            if (gVar2 != null) {
                gVar2.onError(3, "recorder init failed");
            }
        }
    }

    @Override // com.cloud.tmc.integration.audio.recording.f
    public void h(g gVar) {
        this.f30432e = gVar;
    }

    @Override // com.cloud.tmc.integration.audio.recording.f
    public void i(String outputFile, int i11, int i12, int i13, int i14) {
        File file;
        Intrinsics.g(outputFile, "outputFile");
        this.f30430c = new File(outputFile);
        TmcLogger.c("AudioRecorder", "startRecording file: " + outputFile);
        File file2 = this.f30430c;
        if (file2 == null || !file2.exists() || (file = this.f30430c) == null || !file.isFile()) {
            g gVar = this.f30432e;
            if (gVar != null) {
                gVar.onError(2, "invalid output file");
                return;
            }
            return;
        }
        MediaRecorder mediaRecorder = new MediaRecorder();
        this.f30429b = mediaRecorder;
        mediaRecorder.setAudioSource(i11);
        MediaRecorder mediaRecorder2 = this.f30429b;
        if (mediaRecorder2 != null) {
            mediaRecorder2.setOutputFormat(2);
        }
        MediaRecorder mediaRecorder3 = this.f30429b;
        if (mediaRecorder3 != null) {
            mediaRecorder3.setAudioEncoder(3);
        }
        MediaRecorder mediaRecorder4 = this.f30429b;
        if (mediaRecorder4 != null) {
            mediaRecorder4.setAudioChannels(i12);
        }
        MediaRecorder mediaRecorder5 = this.f30429b;
        if (mediaRecorder5 != null) {
            mediaRecorder5.setAudioSamplingRate(i13);
        }
        MediaRecorder mediaRecorder6 = this.f30429b;
        if (mediaRecorder6 != null) {
            mediaRecorder6.setAudioEncodingBitRate(i14);
        }
        MediaRecorder mediaRecorder7 = this.f30429b;
        if (mediaRecorder7 != null) {
            mediaRecorder7.setMaxDuration(-1);
        }
        MediaRecorder mediaRecorder8 = this.f30429b;
        if (mediaRecorder8 != null) {
            File file3 = this.f30430c;
            Intrinsics.d(file3);
            mediaRecorder8.setOutputFile(file3.getAbsolutePath());
        }
        try {
            MediaRecorder mediaRecorder9 = this.f30429b;
            if (mediaRecorder9 != null) {
                mediaRecorder9.prepare();
            }
            MediaRecorder mediaRecorder10 = this.f30429b;
            if (mediaRecorder10 != null) {
                mediaRecorder10.start();
            }
            this.f30428a.i();
            this.f30431d.set(1);
            g gVar2 = this.f30432e;
            if (gVar2 != null) {
                File file4 = this.f30430c;
                Intrinsics.d(file4);
                gVar2.a(file4);
            }
        } catch (Throwable th2) {
            TmcLogger.g("AudioRecorder", "prepare() failed", th2);
            g gVar3 = this.f30432e;
            if (gVar3 != null) {
                gVar3.onError(3, "recorder init failed");
            }
        }
    }

    @Override // com.cloud.tmc.integration.audio.recording.f
    public boolean j() {
        return this.f30431d.get() == 1;
    }

    @Override // com.cloud.tmc.integration.audio.recording.f
    public void k() {
        TmcLogger.c("AudioRecorder", "resumeRecording isPaused: " + e());
        if (Build.VERSION.SDK_INT < 24 || !e()) {
            return;
        }
        try {
            MediaRecorder mediaRecorder = this.f30429b;
            if (mediaRecorder != null) {
                mediaRecorder.resume();
            }
            this.f30428a.f();
            g gVar = this.f30432e;
            if (gVar != null) {
                gVar.c();
            }
            this.f30431d.set(1);
        } catch (Throwable th2) {
            TmcLogger.g("AudioRecorder", "unpauseRecording() failed", th2);
            g gVar2 = this.f30432e;
            if (gVar2 != null) {
                gVar2.onError(3, "recorder init failed");
            }
        }
    }

    @Override // com.cloud.tmc.integration.audio.recording.RecorderTimer.b
    public void onTick(long j11) {
        MediaRecorder mediaRecorder;
        try {
            g gVar = this.f30432e;
            if (gVar == null || (mediaRecorder = this.f30429b) == null || gVar == null) {
                return;
            }
            Intrinsics.d(mediaRecorder);
            gVar.e(j11, mediaRecorder.getMaxAmplitude());
        } catch (Throwable th2) {
            TmcLogger.h("AudioRecorder", th2);
        }
    }
}
