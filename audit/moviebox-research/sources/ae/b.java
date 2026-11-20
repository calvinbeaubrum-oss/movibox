package ae;

import com.cloud.tmc.miniutils.util.j;
import com.cloud.tmc.offline.download.resource.IOfflineResourceManagerProxy;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.l;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class b implements be.a {
    @Override // be.a
    public be.a.c a(be.a.InterfaceC0143a chain) {
        String str;
        Intrinsics.g(chain, "chain");
        be.a.b bVarA = chain.a();
        String strA = bVarA.a();
        String strB = bVarA.b();
        if (strA == null || strA.length() == 0 || strB == null || strB.length() == 0) {
            return new be.a.c(null, 1, null);
        }
        IOfflineResourceManagerProxy iOfflineResourceManagerProxy = (IOfflineResourceManagerProxy) tc.a.a(IOfflineResourceManagerProxy.class);
        String vhost = iOfflineResourceManagerProxy.getVhost(strA);
        if (!l.L(strB, vhost, false, 2, null)) {
            if (l.L(strB, "/", false, 2, null)) {
                str = vhost + strB;
            } else {
                str = vhost + '/' + strB;
            }
            strB = str;
        }
        if (l.u(strB, "/", false, 2, null)) {
            strB = strB.substring(0, strB.length() - 1);
            Intrinsics.f(strB, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        File fileR = j.r(iOfflineResourceManagerProxy.getFilePath(strB));
        if (!j.z(fileR)) {
            return chain.b(bVarA);
        }
        be.a.c cVar = new be.a.c(null, 1, null);
        cVar.b(fileR);
        return cVar;
    }
}
