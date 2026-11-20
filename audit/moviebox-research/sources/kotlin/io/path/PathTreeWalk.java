package kotlin.io.path;

import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequenceBuilderKt;

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
@ExperimentalPathApi
public final class PathTreeWalk implements Sequence<Path> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f68879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PathWalkOption[] f68880b;

    public final Iterator<Path> f() {
        return SequencesKt__SequenceBuilderKt.a(new PathTreeWalk$bfsIterator$1(this, null));
    }

    public final Iterator<Path> g() {
        return SequencesKt__SequenceBuilderKt.a(new PathTreeWalk$dfsIterator$1(this, null));
    }

    public final boolean h() {
        return kotlin.collections.d.I(this.f68880b, PathWalkOption.FOLLOW_LINKS);
    }

    public final boolean i() {
        return kotlin.collections.d.I(this.f68880b, PathWalkOption.INCLUDE_DIRECTORIES);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<Path> iterator() {
        return k() ? f() : g();
    }

    public final LinkOption[] j() {
        return LinkFollowing.f68874a.a(h());
    }

    public final boolean k() {
        return kotlin.collections.d.I(this.f68880b, PathWalkOption.BREADTH_FIRST);
    }
}
