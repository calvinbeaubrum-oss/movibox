package com.transsion.moviedetail.preload;

import androidx.lifecycle.c0;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.moviedetailapi.bean.Subject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import lu.b;
import zo.d;

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
public final class MovieDetailDataLoader extends b<Pair<? extends String, ? extends Subject>> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f53717f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f53718g;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends zo.a<Subject> {
        public a() {
        }

        @Override // zo.a
        public void a(String str, String str2) {
            MovieDetailDataLoader.this.c(new Pair(str, null));
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(Subject subject) {
            MovieDetailDataLoader.this.d(new Pair("0", subject));
        }

        @Override // zo.a, io.reactivex.rxjava3.core.o
        public void onSubscribe(h10.b d11) {
            Intrinsics.g(d11, "d");
            super.onSubscribe(d11);
            MovieDetailDataLoader.this.i(d11);
        }
    }

    public MovieDetailDataLoader(String subjectId) {
        Intrinsics.g(subjectId, "subjectId");
        this.f53717f = subjectId;
        this.f53718g = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.NONE, new Function0<vu.a>() { // from class: com.transsion.moviedetail.preload.MovieDetailDataLoader$service$2
            @Override // kotlin.jvm.functions.Function0
            public final vu.a invoke() {
                return (vu.a) NetServiceGenerator.f49399d.a().i(vu.a.class);
            }
        });
    }

    @Override // lu.b
    public void h(c0<Pair<? extends String, ? extends Subject>> c0Var) {
        k().a(cp.a.f62775a.a(), this.f53717f).e(d.f82109a.c()).subscribe(new a());
    }

    public final vu.a k() {
        return (vu.a) this.f53718g.getValue();
    }

    public final void l(String str) {
        Intrinsics.g(str, "<set-?>");
        this.f53717f = str;
    }
}
