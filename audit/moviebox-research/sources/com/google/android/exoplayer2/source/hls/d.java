package com.google.android.exoplayer2.source.hls;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.k0;
import com.google.android.exoplayer2.util.w;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import dh.h0;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import qg.u1;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d implements g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f33985d = {8, 13, 11, 2, 0, 1, 7};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f33986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f33987c;

    public d() {
        this(0, true);
    }

    public d(int i11, boolean z11) {
        this.f33986b = i11;
        this.f33987c = z11;
    }

    public static void b(int i11, List<Integer> list) {
        if (Ints.h(f33985d, i11) == -1 || list.contains(Integer.valueOf(i11))) {
            return;
        }
        list.add(Integer.valueOf(i11));
    }

    public static bh.g e(k0 k0Var, m1 m1Var, @Nullable List<m1> list) {
        int i11 = g(m1Var) ? 4 : 0;
        if (list == null) {
            list = Collections.emptyList();
        }
        return new bh.g(i11, k0Var, null, list);
    }

    public static h0 f(int i11, boolean z11, m1 m1Var, @Nullable List<m1> list, k0 k0Var) {
        int i12 = i11 | 16;
        if (list != null) {
            i12 = i11 | 48;
        } else {
            list = z11 ? Collections.singletonList(new m1.b().e0(MimeTypes.APPLICATION_CEA608).E()) : Collections.emptyList();
        }
        String str = m1Var.f33442j;
        if (!TextUtils.isEmpty(str)) {
            if (!w.b(str, MimeTypes.AUDIO_AAC)) {
                i12 |= 2;
            }
            if (!w.b(str, MimeTypes.VIDEO_H264)) {
                i12 |= 4;
            }
        }
        return new h0(2, k0Var, new dh.j(i12, list));
    }

    public static boolean g(m1 m1Var) {
        Metadata metadata = m1Var.f33443k;
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

    public static boolean h(tg.l lVar, tg.m mVar) throws IOException {
        try {
            return lVar.b(mVar);
        } catch (EOFException unused) {
            return false;
        } finally {
            mVar.resetPeekPosition();
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.g
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public b a(Uri uri, m1 m1Var, @Nullable List<m1> list, k0 k0Var, Map<String, List<String>> map, tg.m mVar, u1 u1Var) throws IOException {
        int iA = com.google.android.exoplayer2.util.l.a(m1Var.f33445m);
        int iB = com.google.android.exoplayer2.util.l.b(map);
        int iC = com.google.android.exoplayer2.util.l.c(uri);
        int[] iArr = f33985d;
        ArrayList arrayList = new ArrayList(iArr.length);
        b(iA, arrayList);
        b(iB, arrayList);
        b(iC, arrayList);
        for (int i11 : iArr) {
            b(i11, arrayList);
        }
        mVar.resetPeekPosition();
        tg.l lVar = null;
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            int iIntValue = ((Integer) arrayList.get(i12)).intValue();
            tg.l lVar2 = (tg.l) com.google.android.exoplayer2.util.a.e(d(iIntValue, m1Var, list, k0Var));
            if (h(lVar2, mVar)) {
                return new b(lVar2, m1Var, k0Var);
            }
            if (lVar == null && (iIntValue == iA || iIntValue == iB || iIntValue == iC || iIntValue == 11)) {
                lVar = lVar2;
            }
        }
        return new b((tg.l) com.google.android.exoplayer2.util.a.e(lVar), m1Var, k0Var);
    }

    @Nullable
    @SuppressLint({"SwitchIntDef"})
    public final tg.l d(int i11, m1 m1Var, @Nullable List<m1> list, k0 k0Var) {
        if (i11 == 0) {
            return new dh.b();
        }
        if (i11 == 1) {
            return new dh.e();
        }
        if (i11 == 2) {
            return new dh.h();
        }
        if (i11 == 7) {
            return new ah.f(0, 0L);
        }
        if (i11 == 8) {
            return e(k0Var, m1Var, list);
        }
        if (i11 == 11) {
            return f(this.f33986b, this.f33987c, m1Var, list, k0Var);
        }
        if (i11 != 13) {
            return null;
        }
        return new r(m1Var.f33436c, k0Var);
    }
}
