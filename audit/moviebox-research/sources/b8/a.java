package b8;

import a8.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@SourceDebugExtension
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<String, List<a8.b>> f14061a = new LinkedHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f14062b = new LinkedHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Function2<String, d, Unit>> f14063c = new ArrayList();

    public final void a(String subtitleMd5) {
        Intrinsics.g(subtitleMd5, "subtitleMd5");
        this.f14062b.put(subtitleMd5, "");
    }

    public final void b(Function2<? super String, ? super d, Unit> callback) {
        Intrinsics.g(callback, "callback");
        if (this.f14063c.contains(callback)) {
            return;
        }
        this.f14063c.add(callback);
    }

    public final void c() {
        this.f14061a.clear();
    }

    public final List<a8.b> d(String subtitleMd5) {
        Intrinsics.g(subtitleMd5, "subtitleMd5");
        return this.f14061a.get(subtitleMd5);
    }

    public final boolean e(String subtitleMd5) {
        Intrinsics.g(subtitleMd5, "subtitleMd5");
        return this.f14061a.containsKey(subtitleMd5);
    }

    public final void f(String subtitleMd5, List<? extends a8.b> subtitles) {
        Intrinsics.g(subtitleMd5, "subtitleMd5");
        Intrinsics.g(subtitles, "subtitles");
        if (this.f14061a.size() > 10) {
            try {
                Result.Companion companion = Result.Companion;
                Set<String> setKeySet = this.f14061a.keySet();
                Intrinsics.f(setKeySet, "subtitlesMap.keys");
                Object objD0 = CollectionsKt___CollectionsKt.d0(setKeySet);
                Intrinsics.f(objD0, "subtitlesMap.keys.first()");
                Result.m163constructorimpl(this.f14061a.remove((String) objD0));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m163constructorimpl(ResultKt.a(th2));
            }
        }
        this.f14061a.put(subtitleMd5, subtitles);
    }

    public final boolean g() {
        return this.f14061a.isEmpty();
    }

    public final boolean h(String subtitleMd5) {
        Intrinsics.g(subtitleMd5, "subtitleMd5");
        return this.f14062b.containsKey(subtitleMd5);
    }

    public final void i(String subtitleMd5) {
        Intrinsics.g(subtitleMd5, "subtitleMd5");
        this.f14062b.remove(subtitleMd5);
    }

    public final void j(String subtitleMd5) {
        Intrinsics.g(subtitleMd5, "subtitleMd5");
        this.f14061a.remove(subtitleMd5);
    }

    public final void k(String subtitleMd5, d dVar) {
        Intrinsics.g(subtitleMd5, "subtitleMd5");
        Iterator<T> it = this.f14063c.iterator();
        while (it.hasNext()) {
            ((Function2) it.next()).invoke(subtitleMd5, dVar);
        }
        this.f14063c.clear();
    }
}
