package he;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f66433a = new c();

    public static final void f() {
        je.c.a();
    }

    public static final void g(List dataCaches) {
        Intrinsics.g(dataCaches, "$dataCaches");
        Iterator it = dataCaches.iterator();
        while (it.hasNext()) {
            je.a aVar = (je.a) it.next();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("report -> cache, post, athenaAppId = ");
            sb2.append(aVar.a());
            sb2.append(", tag = ");
            sb2.append(aVar.c());
            f66433a.c(aVar.c(), aVar.a(), aVar.b());
        }
    }

    public final void c(String str, int i11, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        new dr.a(str, i11).c(bundle, null).b();
    }

    public final void d(String str, int i11, Bundle bundle) {
        try {
            boolean z11 = je.c.f68000c.get() == -1 || (!(je.c.f67998a.get() && je.c.f67999b.get()) && je.c.f68000c.get() == 1);
            if (z11) {
                if (Intrinsics.b(Looper.myLooper(), Looper.getMainLooper())) {
                    je.c.f68001d.execute(new Runnable() { // from class: he.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            c.f();
                        }
                    });
                } else {
                    je.c.a();
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("report -> isNeedGetAthenaStatus:");
            sb2.append(z11);
            if (z11) {
                je.b.f67996a.d(new je.a(i11, str, bundle));
                return;
            }
            je.b bVar = je.b.f67996a;
            final List<je.a> listC = bVar.c();
            bVar.b();
            if (!(!listC.isEmpty())) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("report -> no cache, post only current, athenaAppId = ");
                sb3.append(i11);
                sb3.append(", tag = ");
                sb3.append(str);
                c(str, i11, bundle);
                return;
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append("report -> exist cache, post all size = ");
            sb4.append(listC.size());
            listC.add(new je.a(i11, str, bundle));
            if (Intrinsics.b(Looper.myLooper(), Looper.getMainLooper())) {
                new Thread(new Runnable() { // from class: he.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.g(listC);
                    }
                }).start();
                return;
            }
            for (je.a aVar : listC) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("report -> cache, post, athenaAppId = ");
                sb5.append(aVar.a());
                sb5.append(", tag = ");
                sb5.append(aVar.c());
                f66433a.c(aVar.c(), aVar.a(), aVar.b());
            }
        } catch (Throwable unused) {
        }
    }

    public final void e(String str, Bundle bundle) {
        if (str != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(CampaignEx.JSON_KEY_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            f66433a.d(str, 3755, bundle2);
        }
    }
}
