package ae;

import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniutils.util.j;
import com.cloud.tmc.offline.download.OfflineManager;
import com.cloud.tmc.offline.download.resource.IOfflineResourceManagerProxy;
import java.io.File;
import kotlin.Metadata;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class a implements be.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0022a f482a = new C0022a(null);

    /* JADX INFO: renamed from: ae.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0022a {
        public C0022a() {
        }

        public /* synthetic */ C0022a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

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
        if (l.t(strB, ".so", true) && OfflineManager.W()) {
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
                try {
                    return b(chain, iOfflineResourceManagerProxy);
                } catch (Throwable unused) {
                    return chain.b(chain.a());
                }
            }
            be.a.c cVar = new be.a.c(null, 1, null);
            cVar.b(fileR);
            return cVar;
        }
        return chain.b(bVarA);
    }

    public final be.a.c b(be.a.InterfaceC0143a interfaceC0143a, IOfflineResourceManagerProxy iOfflineResourceManagerProxy) {
        TmcLogger.c("AhaSoFileFormatConvertR", "Searching for file at url: " + interfaceC0143a.a().b());
        String strB = interfaceC0143a.a().b();
        if (strB == null) {
            return interfaceC0143a.b(interfaceC0143a.a());
        }
        File zipFileByPath = j.r(iOfflineResourceManagerProxy != null ? iOfflineResourceManagerProxy.getFilePath(l.D(strB, ".so", "@===.zip", true)) : null);
        if (!j.z(zipFileByPath)) {
            return interfaceC0143a.b(interfaceC0143a.a());
        }
        String absolutePath = zipFileByPath.getAbsolutePath();
        Intrinsics.f(absolutePath, "zipFileByPath.absolutePath");
        String strD = l.D(absolutePath, "@===.zip", ".so", true);
        if (j.A(strD)) {
            return new be.a.c(j.r(strD));
        }
        Intrinsics.f(zipFileByPath, "zipFileByPath");
        File fileR = FilesKt__UtilsKt.r(zipFileByPath, new File(strD), true, 0, 4, null);
        be.a.c cVar = new be.a.c(null, 1, null);
        cVar.b(fileR);
        return cVar;
    }
}
