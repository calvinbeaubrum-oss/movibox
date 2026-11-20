package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.a2;

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
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f69489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f69490b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public static final a2 f69491c;

    static {
        s sVar = new s();
        f69489a = sVar;
        d0.f("kotlinx.coroutines.fast.service.loader", true);
        f69491c = sVar.a();
    }

    public final a2 a() {
        Object next;
        a2 a2VarE;
        try {
            List<r> listC = f69490b ? j.f69470a.c() : SequencesKt___SequencesKt.v(SequencesKt__SequencesKt.c(ServiceLoader.load(r.class, r.class.getClassLoader()).iterator()));
            Iterator<T> it = listC.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int iC = ((r) next).c();
                    do {
                        Object next2 = it.next();
                        int iC2 = ((r) next2).c();
                        if (iC < iC2) {
                            next = next2;
                            iC = iC2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            r rVar = (r) next;
            return (rVar == null || (a2VarE = t.e(rVar, listC)) == null) ? t.b(null, null, 3, null) : a2VarE;
        } catch (Throwable th2) {
            return t.b(th2, null, 2, null);
        }
    }
}
