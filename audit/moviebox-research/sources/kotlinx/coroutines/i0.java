package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@IgnoreJRERequirement
@PublishedApi
public final class i0 extends AbstractCoroutineContextElement implements m2<String> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f69434b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f69435a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements CoroutineContext.Key<i0> {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i0) && this.f69435a == ((i0) obj).f69435a;
    }

    public int hashCode() {
        return l.p.a(this.f69435a);
    }

    public final long o() {
        return this.f69435a;
    }

    @Override // kotlinx.coroutines.m2
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public void h(CoroutineContext coroutineContext, String str) {
        Thread.currentThread().setName(str);
    }

    @Override // kotlinx.coroutines.m2
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public String r(CoroutineContext coroutineContext) {
        String strO;
        j0 j0Var = (j0) coroutineContext.get(j0.f69498b);
        if (j0Var == null || (strO = j0Var.o()) == null) {
            strO = "coroutine";
        }
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        int iJ0 = StringsKt__StringsKt.j0(name, " @", 0, false, 6, null);
        if (iJ0 < 0) {
            iJ0 = name.length();
        }
        StringBuilder sb2 = new StringBuilder(strO.length() + iJ0 + 10);
        String strSubstring = name.substring(0, iJ0);
        Intrinsics.f(strSubstring, "substring(...)");
        sb2.append(strSubstring);
        sb2.append(" @");
        sb2.append(strO);
        sb2.append('#');
        sb2.append(this.f69435a);
        String string = sb2.toString();
        Intrinsics.f(string, "toString(...)");
        threadCurrentThread.setName(string);
        return name;
    }

    public String toString() {
        return "CoroutineId(" + this.f69435a + ')';
    }
}
