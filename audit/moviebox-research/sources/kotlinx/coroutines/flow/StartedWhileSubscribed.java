package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

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
public final class StartedWhileSubscribed implements d1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f69370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f69371c;

    public StartedWhileSubscribed(long j11, long j12) {
        this.f69370b = j11;
        this.f69371c = j12;
        if (j11 < 0) {
            throw new IllegalArgumentException(("stopTimeout(" + j11 + " ms) cannot be negative").toString());
        }
        if (j12 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("replayExpiration(" + j12 + " ms) cannot be negative").toString());
    }

    @Override // kotlinx.coroutines.flow.d1
    public a<SharingCommand> a(f1<Integer> f1Var) {
        return c.i(c.j(c.z(f1Var, new StartedWhileSubscribed$command$1(this, null)), new StartedWhileSubscribed$command$2(null)));
    }

    public boolean equals(Object obj) {
        if (obj instanceof StartedWhileSubscribed) {
            StartedWhileSubscribed startedWhileSubscribed = (StartedWhileSubscribed) obj;
            if (this.f69370b == startedWhileSubscribed.f69370b && this.f69371c == startedWhileSubscribed.f69371c) {
                return true;
            }
        }
        return false;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        return (l.p.a(this.f69370b) * 31) + l.p.a(this.f69371c);
    }

    public String toString() {
        List listD = kotlin.collections.f.d(2);
        if (this.f69370b > 0) {
            listD.add("stopTimeout=" + this.f69370b + "ms");
        }
        if (this.f69371c < Long.MAX_VALUE) {
            listD.add("replayExpiration=" + this.f69371c + "ms");
        }
        return "SharingStarted.WhileSubscribed(" + CollectionsKt___CollectionsKt.o0(kotlin.collections.f.a(listD), null, null, null, 0, null, null, 63, null) + ')';
    }
}
