package ry;

import com.transsion.transfer.impl.entity.FileData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
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
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f75768a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<FileData> f75769b = new ArrayList();

    public final void a(List<FileData> data) {
        Object next;
        Intrinsics.g(data, "data");
        for (FileData fileData : data) {
            Iterator<T> it = f75769b.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.b(((FileData) next).getFileRemotePath(), fileData.getFileRemotePath()));
            if (next == null) {
                f75769b.add(fileData);
            }
        }
    }

    public final void b() {
        f75769b.clear();
    }

    public final List<FileData> c(int i11) {
        List<FileData> list = f75769b;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((FileData) obj).getState() == i11) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt___CollectionsKt.M0(arrayList);
    }

    public final List<FileData> d() {
        return f75769b;
    }

    public final List<FileData> e() {
        return CollectionsKt___CollectionsKt.M0(c(4));
    }

    public final List<FileData> f() {
        return CollectionsKt___CollectionsKt.M0(CollectionsKt___CollectionsKt.x0(c(3), c(5)));
    }

    public final List<FileData> g() {
        return CollectionsKt___CollectionsKt.M0(c(2));
    }

    public final List<FileData> h() {
        return CollectionsKt___CollectionsKt.M0(c(0));
    }

    public final boolean i() {
        return f75769b.isEmpty();
    }

    public final void j(List<FileData> data) {
        Intrinsics.g(data, "data");
        List<FileData> list = f75769b;
        list.clear();
        list.addAll(data);
    }
}
