package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.offline.StreamKey;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import sh.e;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class d extends e {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final d f34203n = new d("", Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, Collections.emptyList(), false, Collections.emptyMap(), Collections.emptyList());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Uri> f34204d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<b> f34205e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<a> f34206f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<a> f34207g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<a> f34208h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<a> f34209i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public final m1 f34210j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final List<m1> f34211k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<String, String> f34212l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<DrmInitData> f34213m;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final Uri f34214a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final m1 f34215b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f34216c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f34217d;

        public a(@Nullable Uri uri, m1 m1Var, String str, String str2) {
            this.f34214a = uri;
            this.f34215b = m1Var;
            this.f34216c = str;
            this.f34217d = str2;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f34218a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final m1 f34219b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final String f34220c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final String f34221d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public final String f34222e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public final String f34223f;

        public b(Uri uri, m1 m1Var, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
            this.f34218a = uri;
            this.f34219b = m1Var;
            this.f34220c = str;
            this.f34221d = str2;
            this.f34222e = str3;
            this.f34223f = str4;
        }

        public static b b(Uri uri) {
            return new b(uri, new m1.b().S("0").K(MimeTypes.APPLICATION_M3U8).E(), null, null, null, null);
        }

        public b a(m1 m1Var) {
            return new b(this.f34218a, m1Var, this.f34220c, this.f34221d, this.f34222e, this.f34223f);
        }
    }

    public d(String str, List<String> list, List<b> list2, List<a> list3, List<a> list4, List<a> list5, List<a> list6, @Nullable m1 m1Var, @Nullable List<m1> list7, boolean z11, Map<String, String> map, List<DrmInitData> list8) {
        super(str, list, z11);
        this.f34204d = Collections.unmodifiableList(e(list2, list3, list4, list5, list6));
        this.f34205e = Collections.unmodifiableList(list2);
        this.f34206f = Collections.unmodifiableList(list3);
        this.f34207g = Collections.unmodifiableList(list4);
        this.f34208h = Collections.unmodifiableList(list5);
        this.f34209i = Collections.unmodifiableList(list6);
        this.f34210j = m1Var;
        this.f34211k = list7 != null ? Collections.unmodifiableList(list7) : null;
        this.f34212l = Collections.unmodifiableMap(map);
        this.f34213m = Collections.unmodifiableList(list8);
    }

    public static void a(List<a> list, List<Uri> list2) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            Uri uri = list.get(i11).f34214a;
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

    public static d d(String str) {
        return new d("", Collections.emptyList(), Collections.singletonList(b.b(Uri.parse(str))), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, null, false, Collections.emptyMap(), Collections.emptyList());
    }

    public static List<Uri> e(List<b> list, List<a> list2, List<a> list3, List<a> list4, List<a> list5) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            Uri uri = list.get(i11).f34218a;
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

    @Override // com.google.android.exoplayer2.offline.c
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public d copy(List<StreamKey> list) {
        return new d(this.f76359a, this.f76360b, c(this.f34205e, 0, list), Collections.emptyList(), c(this.f34207g, 1, list), c(this.f34208h, 2, list), Collections.emptyList(), this.f34210j, this.f34211k, this.f76361c, this.f34212l, this.f34213m);
    }
}
