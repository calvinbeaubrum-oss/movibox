package z7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@SourceDebugExtension
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f81886a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f81887b = Pattern.compile("\\{(\\d+)\\}\\{(\\d+)\\}(.*)");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f81888c = Pattern.compile("(\\d+):(\\d+):(\\d+)[:\\.](\\d+)");

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final int a(String str) {
        Matcher matcher = f81888c.matcher(str);
        if (!matcher.matches()) {
            return 0;
        }
        String strGroup = matcher.group(1);
        int i11 = strGroup != null ? Integer.parseInt(strGroup) : 0;
        String strGroup2 = matcher.group(2);
        int i12 = strGroup2 != null ? Integer.parseInt(strGroup2) : 0;
        String strGroup3 = matcher.group(3);
        int i13 = strGroup3 != null ? Integer.parseInt(strGroup3) : 0;
        String strGroup4 = matcher.group(4);
        return ((strGroup4 != null ? Integer.parseInt(strGroup4) : 0) * 10) + (i13 * 1000) + (i12 * 60000) + (i11 * 3600000);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0073  */
    /* JADX WARN: Code duplicated, block: B:40:0x0086 A[DONT_GENERATE] */
    public a8.d b(String str, String unicode, InputStream inputStream) throws IOException {
        String string;
        Intrinsics.g(unicode, "unicode");
        a8.d dVar = new a8.d();
        BufferedReader bufferedReader = new BufferedReader(unicode.length() > 0 ? new InputStreamReader(inputStream, unicode) : new InputStreamReader(inputStream));
        dVar.f459e = str;
        String line = bufferedReader.readLine();
        if (line != null) {
            int length = line.length() - 1;
            int i11 = 0;
            boolean z11 = false;
            while (i11 <= length) {
                boolean z12 = Intrinsics.i(line.charAt(!z11 ? i11 : length), 32) <= 0;
                if (z11) {
                    if (!z12) {
                        break;
                    }
                    length--;
                } else if (z12) {
                    i11++;
                } else {
                    z11 = true;
                }
            }
            string = line.subSequence(i11, length + 1).toString();
        } else {
            string = null;
        }
        if (string != null) {
            try {
                if (l.L(string, "{", false, 2, null)) {
                    c(bufferedReader, string, dVar);
                } else if (string != null && l.L(string, "[INFORMATION]", false, 2, null)) {
                    d(bufferedReader, string, dVar);
                }
                if (inputStream != null) {
                }
            } catch (Throwable th2) {
                try {
                    th2.printStackTrace();
                } finally {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            }
        } else {
            if (string != null) {
                d(bufferedReader, string, dVar);
            }
            if (inputStream != null) {
            }
        }
        return dVar;
    }

    public final void c(BufferedReader bufferedReader, String str, a8.d dVar) {
        a8.b bVar = new a8.b();
        while (str != null && str.length() != 0) {
            int length = str.length() - 1;
            int i11 = 0;
            boolean z11 = false;
            while (i11 <= length) {
                boolean z12 = Intrinsics.i(str.charAt(!z11 ? i11 : length), 32) <= 0;
                if (z11) {
                    if (!z12) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z12) {
                    i11++;
                } else {
                    z11 = true;
                }
            }
            Matcher matcher = f81887b.matcher(str.subSequence(i11, length + 1).toString());
            try {
                if (matcher.matches()) {
                    String strGroup = matcher.group(1);
                    String strGroup2 = matcher.group(2);
                    long j11 = 23976;
                    long j12 = (((long) (strGroup != null ? Integer.parseInt(strGroup) : 0)) * 1000000) / j11;
                    long j13 = (((long) (strGroup2 != null ? Integer.parseInt(strGroup2) : 0)) * 1000000) / j11;
                    a8.c cVar = new a8.c("", "");
                    cVar.f454a = (int) j12;
                    bVar.f451b = cVar;
                    a8.c cVar2 = new a8.c("", "");
                    cVar2.f454a = (int) j13;
                    bVar.f452c = cVar2;
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            try {
                if (matcher.matches()) {
                    bVar.f453d = matcher.group(3);
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
            int i12 = bVar.f451b.f454a;
            while (dVar.f463i.containsKey(Integer.valueOf(i12))) {
                i12++;
            }
            TreeMap<Integer, a8.b> treeMap = dVar.f463i;
            Intrinsics.f(treeMap, "tto.captions");
            treeMap.put(Integer.valueOf(i12), bVar);
            try {
                str = bufferedReader.readLine();
            } catch (Throwable unused) {
                str = "";
            }
            bVar = new a8.b();
        }
        dVar.f467m = true;
    }

    public final void d(BufferedReader bufferedReader, String str, a8.d dVar) throws IOException {
        a8.b bVar = new a8.b();
        while (str != null && !l.L(str, "[COLF]", false, 2, null)) {
            str = bufferedReader.readLine();
        }
        while (str != null && str.length() != 0) {
            String line = bufferedReader.readLine();
            if (line != null) {
                int length = line.length() - 1;
                int i11 = 0;
                boolean z11 = false;
                while (i11 <= length) {
                    boolean z12 = Intrinsics.i(line.charAt(!z11 ? i11 : length), 32) <= 0;
                    if (z11) {
                        if (!z12) {
                            break;
                        } else {
                            length--;
                        }
                    } else if (z12) {
                        i11++;
                    } else {
                        z11 = true;
                    }
                }
                str = line.subSequence(i11, length + 1).toString();
            } else {
                str = null;
            }
            if (str != null) {
                try {
                    List listE0 = StringsKt__StringsKt.E0(str, new String[]{","}, false, 0, 6, null);
                    if (listE0 != null) {
                        String str2 = (String) listE0.get(0);
                        String str3 = (String) listE0.get(1);
                        int iA = a(str2);
                        int iA2 = a(str3);
                        a8.c cVar = new a8.c("", "");
                        cVar.f454a = iA;
                        bVar.f451b = cVar;
                        a8.c cVar2 = new a8.c("", "");
                        cVar2.f454a = iA2;
                        bVar.f452c = cVar2;
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            try {
                String line2 = bufferedReader.readLine();
                if (line2 != null) {
                    int length2 = line2.length() - 1;
                    int i12 = 0;
                    boolean z13 = false;
                    while (i12 <= length2) {
                        boolean z14 = Intrinsics.i(line2.charAt(!z13 ? i12 : length2), 32) <= 0;
                        if (z13) {
                            if (!z14) {
                                break;
                            } else {
                                length2--;
                            }
                        } else if (z14) {
                            i12++;
                        } else {
                            z13 = true;
                        }
                    }
                    str = line2.subSequence(i12, length2 + 1).toString();
                } else {
                    str = null;
                }
                bVar.f453d = str;
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
            try {
                bufferedReader.readLine();
            } catch (Throwable unused) {
            }
            int i13 = bVar.f451b.f454a;
            while (dVar.f463i.containsKey(Integer.valueOf(i13))) {
                i13++;
            }
            TreeMap<Integer, a8.b> treeMap = dVar.f463i;
            Intrinsics.f(treeMap, "tto.captions");
            treeMap.put(Integer.valueOf(i13), bVar);
            bVar = new a8.b();
        }
        dVar.f467m = true;
    }
}
