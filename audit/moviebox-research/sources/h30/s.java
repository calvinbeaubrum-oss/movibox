package h30;

import com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CacheDataSink;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class s extends y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int[] f66212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int[] f66213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f66214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f66215d;

    public s() {
        f66212a = new int[]{2, 0, 0, 4096, 196608, 64, 0, 0, CacheDataSink.DEFAULT_BUFFER_SIZE, 0, 0, 0, 0, 0, 0, 0, 572662306, 572662306, 572662306, 572662306, 572662306, 572662306, 572662306, 572662306, 572662306, 572662306, 572662306, 572662306, 572662306, 572662306, 572662306, 572662306};
        f66213b = new int[]{285212976, 572657937, 289476898, 286593297, 8465};
        f66215d = "ISO-2022-KR";
        f66214c = 6;
    }

    @Override // h30.y
    public int[] a() {
        return f66212a;
    }

    @Override // h30.y
    public String b() {
        return f66215d;
    }

    @Override // h30.y
    public boolean d() {
        return false;
    }

    @Override // h30.y
    public int e() {
        return f66214c;
    }

    @Override // h30.y
    public int[] f() {
        return f66213b;
    }
}
