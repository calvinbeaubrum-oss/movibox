package fu;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.transsion.lib.diffupdate.c;
import com.transsion.lib.diffupdate.d;
import com.transsion.lib.diffupdate.e;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.io.TextStreamsKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f65287a = new a();

    /* JADX WARN: Code duplicated, block: B:39:0x00ca  */
    public final c a(String basePkgMd5) throws Throwable {
        HttpURLConnection httpURLConnection;
        Map<String, String> mapB;
        Intrinsics.g(basePkgMd5, "basePkgMd5");
        HttpURLConnection httpURLConnection2 = null;
        try {
            StringBuilder sb2 = new StringBuilder();
            e eVar = e.f53052a;
            com.transsion.lib.diffupdate.a aVarB = eVar.b();
            sb2.append(aVarB != null ? aVarB.a() : null);
            sb2.append("?basePkgMd5=");
            sb2.append(basePkgMd5);
            URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(new URL(sb2.toString()).openConnection());
            Intrinsics.e(uRLConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) uRLConnection;
            try {
                httpURLConnection3.setRequestMethod("GET");
                com.transsion.lib.diffupdate.a aVarB2 = eVar.b();
                if (aVarB2 != null && (mapB = aVarB2.b()) != null) {
                    for (Map.Entry<String, String> entry : mapB.entrySet()) {
                        httpURLConnection3.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection3.connect();
                int responseCode = httpURLConnection3.getResponseCode();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection3.getInputStream()));
                String strE = TextStreamsKt.e(bufferedReader);
                bufferedReader.close();
                if (responseCode == 200) {
                    c cVarA = d.a(strE);
                    httpURLConnection3.disconnect();
                    return cVarA;
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("sendGetRequest and response: ");
                sb3.append(strE);
                httpURLConnection3.disconnect();
                return null;
            } catch (Exception e11) {
                httpURLConnection = httpURLConnection3;
                e = e11;
                try {
                    e.printStackTrace();
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection2 = httpURLConnection;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                httpURLConnection2 = httpURLConnection3;
                th = th3;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        } catch (Exception e12) {
            e = e12;
            httpURLConnection = null;
        } catch (Throwable th4) {
            th = th4;
        }
    }
}
