package com.transsion.postdetail.comment.ui;

import android.app.Application;
import androidx.lifecycle.b;
import androidx.lifecycle.c0;
import androidx.lifecycle.u0;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.postdetail.bean.CommentBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;

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
public final class CommentListViewModel extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f54975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0<List<CommentBean>> f54976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<CommentBean> f54977d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f54978f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f54979g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f54980h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentListViewModel(Application application) {
        super(application);
        Intrinsics.g(application, "application");
        this.f54975b = LazyKt__LazyJVMKt.b(new Function0<xv.a>() { // from class: com.transsion.postdetail.comment.ui.CommentListViewModel$commentNetApi$2
            @Override // kotlin.jvm.functions.Function0
            public final xv.a invoke() {
                return (xv.a) NetServiceGenerator.f49399d.a().i(xv.a.class);
            }
        });
        this.f54976c = new c0<>();
        this.f54977d = new ArrayList();
        this.f54978f = "1";
        this.f54979g = 20;
        this.f54980h = true;
    }

    public final void i(boolean z11) {
        if (z11) {
            this.f54978f = "1";
            this.f54977d.clear();
            this.f54980h = true;
        }
        j.d(u0.a(this), null, null, new CommentListViewModel$getCommentList$1(this, null), 3, null);
    }

    public final xv.a j() {
        return (xv.a) this.f54975b.getValue();
    }

    public final c0<List<CommentBean>> k() {
        return this.f54976c;
    }

    public final boolean l() {
        return this.f54980h;
    }
}
