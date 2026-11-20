package androidx.room;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class v implements g6.j, g6.i {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f12893j = new a(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @JvmField
    public static final TreeMap<Integer, v> f12894k = new TreeMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile String f12896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public final long[] f12897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @JvmField
    public final double[] f12898d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @JvmField
    public final String[] f12899f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @JvmField
    public final byte[][] f12900g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int[] f12901h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f12902i;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final v a(String query, int i11) {
            Intrinsics.g(query, "query");
            TreeMap<Integer, v> treeMap = v.f12894k;
            synchronized (treeMap) {
                Map.Entry<Integer, v> entryCeilingEntry = treeMap.ceilingEntry(Integer.valueOf(i11));
                if (entryCeilingEntry == null) {
                    Unit unit = Unit.f68710a;
                    v vVar = new v(i11, null);
                    vVar.e(query, i11);
                    return vVar;
                }
                treeMap.remove(entryCeilingEntry.getKey());
                v sqliteQuery = entryCeilingEntry.getValue();
                sqliteQuery.e(query, i11);
                Intrinsics.f(sqliteQuery, "sqliteQuery");
                return sqliteQuery;
            }
        }

        public final void b() {
            TreeMap<Integer, v> treeMap = v.f12894k;
            if (treeMap.size() <= 15) {
                return;
            }
            int size = treeMap.size() - 10;
            Iterator<Integer> it = treeMap.descendingKeySet().iterator();
            Intrinsics.f(it, "queryPool.descendingKeySet().iterator()");
            while (true) {
                int i11 = size - 1;
                if (size <= 0) {
                    return;
                }
                it.next();
                it.remove();
                size = i11;
            }
        }
    }

    public v(int i11) {
        this.f12895a = i11;
        int i12 = i11 + 1;
        this.f12901h = new int[i12];
        this.f12897c = new long[i12];
        this.f12898d = new double[i12];
        this.f12899f = new String[i12];
        this.f12900g = new byte[i12][];
    }

    public /* synthetic */ v(int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11);
    }

    @JvmStatic
    public static final v c(String str, int i11) {
        return f12893j.a(str, i11);
    }

    @Override // g6.i
    public void V(int i11, long j11) {
        this.f12901h[i11] = 2;
        this.f12897c[i11] = j11;
    }

    @Override // g6.j
    public String a() {
        String str = this.f12896b;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // g6.j
    public void b(g6.i statement) {
        Intrinsics.g(statement, "statement");
        int iD = d();
        if (1 > iD) {
            return;
        }
        int i11 = 1;
        while (true) {
            int i12 = this.f12901h[i11];
            if (i12 == 1) {
                statement.m0(i11);
            } else if (i12 == 2) {
                statement.V(i11, this.f12897c[i11]);
            } else if (i12 == 3) {
                statement.f(i11, this.f12898d[i11]);
            } else if (i12 == 4) {
                String str = this.f12899f[i11];
                if (str == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                statement.s(i11, str);
            } else if (i12 == 5) {
                byte[] bArr = this.f12900g[i11];
                if (bArr == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                statement.c0(i11, bArr);
            }
            if (i11 == iD) {
                return;
            } else {
                i11++;
            }
        }
    }

    @Override // g6.i
    public void c0(int i11, byte[] value) {
        Intrinsics.g(value, "value");
        this.f12901h[i11] = 5;
        this.f12900g[i11] = value;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public int d() {
        return this.f12902i;
    }

    public final void e(String query, int i11) {
        Intrinsics.g(query, "query");
        this.f12896b = query;
        this.f12902i = i11;
    }

    @Override // g6.i
    public void f(int i11, double d11) {
        this.f12901h[i11] = 3;
        this.f12898d[i11] = d11;
    }

    @Override // g6.i
    public void m0(int i11) {
        this.f12901h[i11] = 1;
    }

    public final void release() {
        TreeMap<Integer, v> treeMap = f12894k;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.f12895a), this);
            f12893j.b();
            Unit unit = Unit.f68710a;
        }
    }

    @Override // g6.i
    public void s(int i11, String value) {
        Intrinsics.g(value, "value");
        this.f12901h[i11] = 4;
        this.f12899f[i11] = value;
    }
}
