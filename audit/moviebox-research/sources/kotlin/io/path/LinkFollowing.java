package kotlin.io.path;

import java.nio.file.FileVisitOption;
import java.nio.file.LinkOption;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.v;
import kotlin.collections.w;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class LinkFollowing {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkFollowing f68874a = new LinkFollowing();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkOption[] f68875b = {LinkOption.NOFOLLOW_LINKS};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LinkOption[] f68876c = new LinkOption[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<FileVisitOption> f68877d = w.f();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set<FileVisitOption> f68878e = v.d(FileVisitOption.FOLLOW_LINKS);

    private LinkFollowing() {
    }

    public final LinkOption[] a(boolean z11) {
        return z11 ? f68876c : f68875b;
    }

    public final Set<FileVisitOption> b(boolean z11) {
        return z11 ? f68878e : f68877d;
    }
}
