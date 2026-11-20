package kotlin.io.path;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class e extends SimpleFileVisitor<Path> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f68883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f68884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayDeque<h> f68885c = new ArrayDeque<>();

    public e(boolean z11) {
        this.f68883a = z11;
    }

    public FileVisitResult a(Path dir, BasicFileAttributes attrs) throws IOException {
        Intrinsics.g(dir, "dir");
        Intrinsics.g(attrs, "attrs");
        this.f68885c.add(new h(dir, attrs.fileKey(), this.f68884b));
        FileVisitResult fileVisitResultPreVisitDirectory = super.preVisitDirectory(dir, attrs);
        Intrinsics.f(fileVisitResultPreVisitDirectory, "preVisitDirectory(...)");
        return fileVisitResultPreVisitDirectory;
    }

    public final List<h> b(h directoryNode) throws IOException {
        Intrinsics.g(directoryNode, "directoryNode");
        this.f68884b = directoryNode;
        Files.walkFileTree(directoryNode.d(), LinkFollowing.f68874a.b(this.f68883a), 1, b.a(this));
        this.f68885c.removeFirst();
        ArrayDeque<h> arrayDeque = this.f68885c;
        this.f68885c = new ArrayDeque<>();
        return arrayDeque;
    }

    public FileVisitResult c(Path file, BasicFileAttributes attrs) throws IOException {
        Intrinsics.g(file, "file");
        Intrinsics.g(attrs, "attrs");
        this.f68885c.add(new h(file, null, this.f68884b));
        FileVisitResult fileVisitResultVisitFile = super.visitFile(file, attrs);
        Intrinsics.f(fileVisitResultVisitFile, "visitFile(...)");
        return fileVisitResultVisitFile;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* bridge */ /* synthetic */ FileVisitResult preVisitDirectory(Object obj, BasicFileAttributes basicFileAttributes) {
        return a(a.a(obj), basicFileAttributes);
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* bridge */ /* synthetic */ FileVisitResult visitFile(Object obj, BasicFileAttributes basicFileAttributes) {
        return c(a.a(obj), basicFileAttributes);
    }
}
