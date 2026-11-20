package kotlinx.coroutines.internal;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.transsion.gslb.Utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;

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
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f69470a = new j();

    public final <S> S a(String str, ClassLoader classLoader, Class<S> cls) throws ClassNotFoundException {
        Class<?> cls2 = Class.forName(str, false, classLoader);
        if (cls.isAssignableFrom(cls2)) {
            return cls.cast(cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        throw new IllegalArgumentException(("Expected service of class " + cls + ", but found " + cls2).toString());
    }

    public final <S> List<S> b(Class<S> cls, ClassLoader classLoader) {
        try {
            return d(cls, classLoader);
        } catch (Throwable unused) {
            return CollectionsKt___CollectionsKt.J0(ServiceLoader.load(cls, classLoader));
        }
    }

    public final List<r> c() {
        r rVar;
        if (!k.a()) {
            return b(r.class, r.class.getClassLoader());
        }
        try {
            ArrayList arrayList = new ArrayList(2);
            r rVar2 = null;
            try {
                rVar = (r) r.class.cast(Class.forName("kotlinx.coroutines.android.a", true, r.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused) {
                rVar = null;
            }
            if (rVar != null) {
                arrayList.add(rVar);
            }
            try {
                rVar2 = (r) r.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, r.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused2) {
            }
            if (rVar2 == null) {
                return arrayList;
            }
            arrayList.add(rVar2);
            return arrayList;
        } catch (Throwable unused3) {
            return b(r.class, r.class.getClassLoader());
        }
    }

    public final <S> List<S> d(Class<S> cls, ClassLoader classLoader) {
        ArrayList list = Collections.list(classLoader.getResources("META-INF/services/" + cls.getName()));
        Intrinsics.f(list, "list(...)");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            kotlin.collections.k.A(arrayList, f69470a.e((URL) it.next()));
        }
        Set setO0 = CollectionsKt___CollectionsKt.O0(arrayList);
        if (!(!setO0.isEmpty())) {
            throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
        }
        Set set = setO0;
        ArrayList arrayList2 = new ArrayList(kotlin.collections.h.v(set, 10));
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            arrayList2.add(f69470a.a((String) it2.next(), classLoader, cls));
        }
        return arrayList2;
    }

    public final List<String> e(URL url) throws IOException {
        String string = url.toString();
        if (!kotlin.text.l.L(string, "jar", false, 2, null)) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(FirebasePerfUrlConnection.openStream(url)));
            try {
                List<String> listF = f69470a.f(bufferedReader);
                CloseableKt.a(bufferedReader, null);
                return listF;
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    CloseableKt.a(bufferedReader, th2);
                    throw th3;
                }
            }
        }
        String strU0 = StringsKt__StringsKt.U0(StringsKt__StringsKt.N0(string, "jar:file:", null, 2, null), '!', null, 2, null);
        String strN0 = StringsKt__StringsKt.N0(string, "!/", null, 2, null);
        JarFile jarFile = new JarFile(strU0, false);
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(jarFile.getInputStream(new ZipEntry(strN0)), "UTF-8"));
            try {
                List<String> listF2 = f69470a.f(bufferedReader2);
                CloseableKt.a(bufferedReader2, null);
                jarFile.close();
                return listF2;
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    CloseableKt.a(bufferedReader2, th4);
                    throw th5;
                }
            }
        } catch (Throwable th6) {
            try {
                throw th6;
            } catch (Throwable th7) {
                try {
                    jarFile.close();
                    throw th7;
                } catch (Throwable th8) {
                    v10.b.a(th6, th8);
                    throw th6;
                }
            }
        }
    }

    public final List<String> f(BufferedReader bufferedReader) throws IOException {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return CollectionsKt___CollectionsKt.J0(linkedHashSet);
            }
            String string = StringsKt__StringsKt.Z0(StringsKt__StringsKt.V0(line, Utils.SEPARATOR, null, 2, null)).toString();
            for (int i11 = 0; i11 < string.length(); i11++) {
                char cCharAt = string.charAt(i11);
                if (cCharAt != '.' && !Character.isJavaIdentifierPart(cCharAt)) {
                    throw new IllegalArgumentException(("Illegal service provider class name: " + string).toString());
                }
            }
            if (string.length() > 0) {
                linkedHashSet.add(string);
            }
        }
    }
}
