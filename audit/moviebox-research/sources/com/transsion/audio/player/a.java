package com.transsion.audio.player;

import android.text.TextUtils;
import com.hisavana.common.tracking.TrackingKey;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.baselib.report.m;
import com.transsion.player.orplayer.PlayError;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AudioBean f50849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f50850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f50851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f50852d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f50853e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f50854f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f50855g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f50856h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f50857i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f50858j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f50859k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f50860l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f50861m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Integer f50862n;

    public a(AudioBean audioBean) {
        Intrinsics.g(audioBean, "audioBean");
        this.f50850b = a.class.getSimpleName();
        this.f50849a = audioBean;
        this.f50851c = System.currentTimeMillis();
        uo.b.a.f(uo.b.f78622a, "video_play", "initView", false, 4, null);
    }

    public final void a() {
        String postId;
        String subjectId;
        Long duration;
        String ops;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        AudioBean audioBean = this.f50849a;
        String str = "";
        if (audioBean == null || (postId = audioBean.getPostId()) == null) {
            postId = "";
        }
        linkedHashMap.put("post_id", postId);
        AudioBean audioBean2 = this.f50849a;
        if (audioBean2 == null || (subjectId = audioBean2.getSubjectId()) == null) {
            subjectId = "";
        }
        linkedHashMap.put("subject_id", subjectId);
        AudioBean audioBean3 = this.f50849a;
        if (!TextUtils.isEmpty(audioBean3 != null ? audioBean3.getOps() : null)) {
            AudioBean audioBean4 = this.f50849a;
            if (audioBean4 != null && (ops = audioBean4.getOps()) != null) {
                str = ops;
            }
            linkedHashMap.put("ops", str);
        }
        if (this.f50852d > 0) {
            linkedHashMap.put("is_start", "1");
            linkedHashMap.put("delay_v", String.valueOf(this.f50852d - this.f50851c));
            linkedHashMap.put("buffer_time", String.valueOf(this.f50853e));
            linkedHashMap.put("buffer_count", String.valueOf(this.f50855g));
            float f11 = this.f50856h;
            AudioBean audioBean5 = this.f50849a;
            linkedHashMap.put("play_complete", String.valueOf(((f11 / ((audioBean5 == null || (duration = audioBean5.getDuration()) == null) ? 1L : duration.longValue())) * 100.0f) + (this.f50859k * 100.0f)));
            linkedHashMap.put("play_duration", String.valueOf(this.f50858j));
            linkedHashMap.put("pause_duration", String.valueOf(this.f50861m));
        } else {
            linkedHashMap.put("is_start", "0");
            linkedHashMap.put("delay_v", String.valueOf(System.currentTimeMillis() - this.f50851c));
        }
        Integer num = this.f50862n;
        if (num != null) {
            linkedHashMap.put(TrackingKey.ERROR_CODE, String.valueOf(num));
        }
        m.f51277a.w("postdetail", "audio_play", this.f50858j, linkedHashMap);
    }

    public final void b() {
        a();
    }

    public final void c() {
        if (this.f50852d > 0) {
            this.f50854f = System.currentTimeMillis();
        }
    }

    public final void d() {
        if (this.f50854f > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f50854f;
            this.f50854f = jCurrentTimeMillis;
            this.f50853e += jCurrentTimeMillis;
            this.f50855g++;
        }
    }

    public final void e(PlayError errorInfo) {
        Intrinsics.g(errorInfo, "errorInfo");
        this.f50862n = errorInfo.getErrorCode();
    }

    public final void f(long j11) {
        long j12 = this.f50857i;
        long j13 = j11 - j12;
        if (1 <= j13 && j13 < 1000) {
            this.f50858j += j11 - j12;
        }
        this.f50857i = j11;
        if (j11 > this.f50856h) {
            this.f50856h = j11;
        }
    }

    public final void g() {
        uo.b.a.f(uo.b.f78622a, "video_play", "onRenderFirstFrame", false, 4, null);
        if (this.f50852d > 0) {
            return;
        }
        this.f50852d = System.currentTimeMillis();
    }

    public final void h() {
        this.f50860l = System.currentTimeMillis();
    }

    public final void i() {
        if (this.f50860l != 0) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f50860l;
            this.f50860l = jCurrentTimeMillis;
            this.f50861m += jCurrentTimeMillis;
        }
    }
}
