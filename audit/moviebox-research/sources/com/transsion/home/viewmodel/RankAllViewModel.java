package com.transsion.home.viewmodel;

import androidx.lifecycle.c0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.home.bean.RankAllData;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
import kotlinx.coroutines.w0;
import rt.c;

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
@SourceDebugExtension
public final class RankAllViewModel extends t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0<RankAllData> f52747a = new c0<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0<RankAllData> f52748b = new c0<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f52749c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f52750d = (c) NetServiceGenerator.f49399d.a().i(c.class);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f52751f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f52752g;

    public final c0<RankAllData> h() {
        return this.f52748b;
    }

    public final c0<RankAllData> i() {
        return this.f52747a;
    }

    public final void j(String str, int i11) {
        this.f52751f = str;
        this.f52752g = i11;
        this.f52749c = 1;
        m(false);
    }

    public final void k() {
        m(true);
    }

    public final void l(RankAllData rankAllData) {
        List<Subject> subjects;
        String ops = rankAllData != null ? rankAllData.getOps() : null;
        if (ops == null || ops.length() == 0 || rankAllData == null || (subjects = rankAllData.getSubjects()) == null) {
            return;
        }
        for (Subject subject : subjects) {
            String ops2 = subject.getOps();
            if (ops2 == null || ops2.length() == 0) {
                subject.setOps(ops);
            }
        }
    }

    public final void m(boolean z11) {
        j.d(u0.a(this), w0.b(), null, new RankAllViewModel$startRequest$1(z11, this, null), 2, null);
    }
}
