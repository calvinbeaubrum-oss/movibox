package androidx.media3.exoplayer.hls.playlist;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.StreamKey;
import androidx.media3.common.y;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import k4.e;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends e {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final c f10566n = new c("", Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, Collections.emptyList(), false, Collections.emptyMap(), Collections.emptyList());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Uri> f10567d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<b> f10568e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<a> f10569f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<a> f10570g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<a> f10571h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<a> f10572i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public final y f10573j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final List<y> f10574k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<String, String> f10575l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<DrmInitData> f10576m;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final Uri f10577a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final y f10578b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f10579c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f10580d;

        public a(@Nullable Uri uri, y yVar, String str, String str2) {
            this.f10577a = uri;
            this.f10578b = yVar;
            this.f10579c = str;
            this.f10580d = str2;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f10581a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final y f10582b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final String f10583c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final String f10584d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public final String f10585e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public final String f10586f;

        public b(Uri uri, y yVar, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
            this.f10581a = uri;
            this.f10582b = yVar;
            this.f10583c = str;
            this.f10584d = str2;
            this.f10585e = str3;
            this.f10586f = str4;
        }

        public static b b(Uri uri) {
            return new b(uri, new y.b().X("0").O(MimeTypes.APPLICATION_M3U8).I(), null, null, null, null);
        }

        public b a(y yVar) {
            return new b(this.f10581a, yVar, this.f10583c, this.f10584d, this.f10585e, this.f10586f);
        }
    }

    public c(String str, List<String> list, List<b> list2, List<a> list3, List<a> list4, List<a> list5, List<a> list6, @Nullable y yVar, @Nullable List<y> list7, boolean z11, Map<String, String> map, List<DrmInitData> list8) {
        super(str, list, z11);
        this.f10567d = Collections.unmodifiableList(e(list2, list3, list4, list5, list6));
        this.f10568e = Collections.unmodifiableList(list2);
        this.f10569f = Collections.unmodifiableList(list3);
        this.f10570g = Collections.unmodifiableList(list4);
        this.f10571h = Collections.unmodifiableList(list5);
        this.f10572i = Collections.unmodifiableList(list6);
        this.f10573j = yVar;
        this.f10574k = list7 != null ? Collections.unmodifiableList(list7) : null;
        this.f10575l = Collections.unmodifiableMap(map);
        this.f10576m = Collections.unmodifiableList(list8);
    }

    public static void a(List<a> list, List<Uri> list2) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            Uri uri = list.get(i11).f10577a;
            if (uri != null && !list2.contains(uri)) {
                list2.add(uri);
            }
        }
    }

    public static <T> List<T> c(List<T> list, int i11, List<StreamKey> list2) {
        ArrayList arrayList = new ArrayList(list2.size());
        for (int i12 = 0; i12 < list.size(); i12++) {
            T t11 = list.get(i12);
            for (int i13 = 0; i13 < list2.size(); i13++) {
                StreamKey streamKey = list2.get(i13);
                if (streamKey.groupIndex == i11 && streamKey.streamIndex == i12) {
                    arrayList.add(t11);
                    break;
                }
            }
        }
        return arrayList;
    }

    public static c d(String str) {
        return new c("", Collections.emptyList(), Collections.singletonList(b.b(Uri.parse(str))), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, null, false, Collections.emptyMap(), Collections.emptyList());
    }

    public static List<Uri> e(List<b> list, List<a> list2, List<a> list3, List<a> list4, List<a> list5) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            Uri uri = list.get(i11).f10581a;
            if (!arrayList.contains(uri)) {
                arrayList.add(uri);
            }
        }
        a(list2, arrayList);
        a(list3, arrayList);
        a(list4, arrayList);
        a(list5, arrayList);
        return arrayList;
    }

    @Override // androidx.media3.exoplayer.offline.q
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public c copy(List<StreamKey> list) {
        return new c(this.f68239a, this.f68240b, c(this.f10568e, 0, list), Collections.emptyList(), c(this.f10570g, 1, list), c(this.f10571h, 2, list), Collections.emptyList(), this.f10573j, this.f10574k, this.f68241c, this.f10575l, this.f10576m);
    }
}
