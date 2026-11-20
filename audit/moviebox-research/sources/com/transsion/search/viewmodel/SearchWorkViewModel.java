package com.transsion.search.viewmodel;

import android.app.Application;
import androidx.lifecycle.c0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import kotlinx.coroutines.w0;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class SearchWorkViewModel extends t0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f57706f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f57702a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0<List<VideoDetailPlayBean>> f57703b = new c0<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<VideoDetailPlayBean> f57704c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f57705d = LazyKt__LazyJVMKt.b(new Function0<VideoDetailPlayDao>() { // from class: com.transsion.search.viewmodel.SearchWorkViewModel$videoDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final VideoDetailPlayDao invoke() {
            AppDatabase.v0 v0Var = AppDatabase.f51036p;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            return v0Var.b(applicationA).O0();
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f57707g = 50;

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoDetailPlayDao i() {
        return (VideoDetailPlayDao) this.f57705d.getValue();
    }

    public static /* synthetic */ void k(SearchWorkViewModel searchWorkViewModel, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        searchWorkViewModel.j(z11);
    }

    public final boolean f() {
        return this.f57702a;
    }

    public final c0<List<VideoDetailPlayBean>> g() {
        return this.f57703b;
    }

    public final int h() {
        return this.f57706f;
    }

    public final void j(boolean z11) {
        j.d(u0.a(this), w0.b(), null, new SearchWorkViewModel$getVideoHistoryList$1(z11, this, null), 2, null);
    }

    public final void l(int i11) {
        this.f57706f = i11;
    }
}
