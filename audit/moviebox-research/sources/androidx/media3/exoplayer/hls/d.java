package androidx.media3.exoplayer.hls;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.media3.common.Metadata;
import androidx.media3.common.f0;
import androidx.media3.common.y;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import e4.x3;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import u4.t;
import x5.h0;
import z3.i0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f10376f = {8, 13, 11, 2, 0, 1, 7};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public o5.s.a f10378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10379d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f10380e;

    public d() {
        this(0, true);
    }

    public d(int i11, boolean z11) {
        this.f10377b = i11;
        this.f10380e = z11;
        this.f10378c = new o5.h();
    }

    public static void e(int i11, List<Integer> list) {
        if (Ints.h(f10376f, i11) == -1 || list.contains(Integer.valueOf(i11))) {
            return;
        }
        list.add(Integer.valueOf(i11));
    }

    public static l5.g h(o5.s.a aVar, boolean z11, i0 i0Var, y yVar, @Nullable List<y> list) {
        int i11 = k(yVar) ? 4 : 0;
        if (!z11) {
            aVar = o5.s.a.f72352a;
            i11 |= 32;
        }
        o5.s.a aVar2 = aVar;
        int i12 = i11;
        if (list == null) {
            list = ImmutableList.of();
        }
        return new l5.g(aVar2, i12, i0Var, null, list, null);
    }

    public static h0 i(int i11, boolean z11, y yVar, @Nullable List<y> list, i0 i0Var, o5.s.a aVar, boolean z12) {
        o5.s.a aVar2;
        int i12;
        int i13 = i11 | 16;
        if (list != null) {
            i13 = i11 | 48;
        } else {
            list = z11 ? Collections.singletonList(new y.b().k0(MimeTypes.APPLICATION_CEA608).I()) : Collections.emptyList();
        }
        String str = yVar.f9498j;
        if (!TextUtils.isEmpty(str)) {
            if (!f0.b(str, MimeTypes.AUDIO_AAC)) {
                i13 |= 2;
            }
            if (!f0.b(str, MimeTypes.VIDEO_H264)) {
                i13 |= 4;
            }
        }
        if (z12) {
            aVar2 = aVar;
            i12 = 0;
        } else {
            aVar2 = o5.s.a.f72352a;
            i12 = 1;
        }
        return new h0(2, i12, aVar2, i0Var, new x5.j(i13, list), 112800);
    }

    public static boolean k(y yVar) {
        Metadata metadata = yVar.f9499k;
        if (metadata == null) {
            return false;
        }
        for (int i11 = 0; i11 < metadata.length(); i11++) {
            Metadata.Entry entry = metadata.get(i11);
            if (entry instanceof HlsTrackMetadataEntry) {
                return !((HlsTrackMetadataEntry) entry).variantInfos.isEmpty();
            }
        }
        return false;
    }

    public static boolean m(u4.s sVar, t tVar) throws IOException {
        try {
            return sVar.b(tVar);
        } catch (EOFException unused) {
            return false;
        } finally {
            tVar.resetPeekPosition();
        }
    }

    @Override // androidx.media3.exoplayer.hls.g
    public y c(y yVar) {
        String str;
        if (!this.f10379d || !this.f10378c.a(yVar)) {
            return yVar;
        }
        y.b bVarQ = yVar.b().k0("application/x-media3-cues").Q(this.f10378c.b(yVar));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(yVar.f9501m);
        if (yVar.f9498j != null) {
            str = " " + yVar.f9498j;
        } else {
            str = "";
        }
        sb2.append(str);
        return bVarQ.M(sb2.toString()).o0(Long.MAX_VALUE).I();
    }

    @Override // androidx.media3.exoplayer.hls.g
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public b d(Uri uri, y yVar, @Nullable List<y> list, i0 i0Var, Map<String, List<String>> map, t tVar, x3 x3Var) throws IOException {
        int iA = androidx.media3.common.r.a(yVar.f9501m);
        int iB = androidx.media3.common.r.b(map);
        int iC = androidx.media3.common.r.c(uri);
        int[] iArr = f10376f;
        ArrayList arrayList = new ArrayList(iArr.length);
        e(iA, arrayList);
        e(iB, arrayList);
        e(iC, arrayList);
        for (int i11 : iArr) {
            e(i11, arrayList);
        }
        tVar.resetPeekPosition();
        u4.s sVar = null;
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            int iIntValue = ((Integer) arrayList.get(i12)).intValue();
            u4.s sVar2 = (u4.s) z3.a.e(g(iIntValue, yVar, list, i0Var));
            if (m(sVar2, tVar)) {
                return new b(sVar2, yVar, i0Var, this.f10378c, this.f10379d);
            }
            if (sVar == null && (iIntValue == iA || iIntValue == iB || iIntValue == iC || iIntValue == 11)) {
                sVar = sVar2;
            }
        }
        return new b((u4.s) z3.a.e(sVar), yVar, i0Var, this.f10378c, this.f10379d);
    }

    @Nullable
    @SuppressLint({"SwitchIntDef"})
    public final u4.s g(int i11, y yVar, @Nullable List<y> list, i0 i0Var) {
        if (i11 == 0) {
            return new x5.b();
        }
        if (i11 == 1) {
            return new x5.e();
        }
        if (i11 == 2) {
            return new x5.h();
        }
        if (i11 == 7) {
            return new k5.f(0, 0L);
        }
        if (i11 == 8) {
            return h(this.f10378c, this.f10379d, i0Var, yVar, list);
        }
        if (i11 == 11) {
            return i(this.f10377b, this.f10380e, yVar, list, i0Var, this.f10378c, this.f10379d);
        }
        if (i11 != 13) {
            return null;
        }
        return new s(yVar.f9492d, i0Var, this.f10378c, this.f10379d);
    }

    @Override // androidx.media3.exoplayer.hls.g
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public d b(boolean z11) {
        this.f10379d = z11;
        return this;
    }

    @Override // androidx.media3.exoplayer.hls.g
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public d a(o5.s.a aVar) {
        this.f10378c = aVar;
        return this;
    }
}
