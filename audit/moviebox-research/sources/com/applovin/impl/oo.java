package com.applovin.impl;

import android.os.Bundle;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class oo implements o2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final o2.a f21583d = new o2.a() { // from class: com.applovin.impl.t00
        @Override // com.applovin.impl.o2.a
        public final o2 a(Bundle bundle) {
            return oo.a(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f9[] f21585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f21586c;

    public oo(f9... f9VarArr) {
        b1.a(f9VarArr.length > 0);
        this.f21585b = f9VarArr;
        this.f21584a = f9VarArr.length;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ oo a(Bundle bundle) {
        return new oo((f9[]) p2.a(f9.I, bundle.getParcelableArrayList(b(0)), eb.h()).toArray(new f9[0]));
    }

    private static String a(String str) {
        return (str == null || str.equals(C.LANGUAGE_UNDETERMINED)) ? "" : str;
    }

    private void a() {
        String strA = a(this.f21585b[0].f18891c);
        int iC = c(this.f21585b[0].f18893f);
        int i11 = 1;
        while (true) {
            f9[] f9VarArr = this.f21585b;
            if (i11 >= f9VarArr.length) {
                return;
            }
            if (!strA.equals(a(f9VarArr[i11].f18891c))) {
                f9[] f9VarArr2 = this.f21585b;
                a("languages", f9VarArr2[0].f18891c, f9VarArr2[i11].f18891c, i11);
                return;
            } else {
                if (iC != c(this.f21585b[i11].f18893f)) {
                    a("role flags", Integer.toBinaryString(this.f21585b[0].f18893f), Integer.toBinaryString(this.f21585b[i11].f18893f), i11);
                    return;
                }
                i11++;
            }
        }
    }

    private static void a(String str, String str2, String str3, int i11) {
        pc.a("TrackGroup", "", new IllegalStateException("Different " + str + " combined in one TrackGroup: '" + str2 + "' (track 0) and '" + str3 + "' (track " + i11 + ")"));
    }

    private static String b(int i11) {
        return Integer.toString(i11, 36);
    }

    private static int c(int i11) {
        return i11 | 16384;
    }

    public int a(f9 f9Var) {
        int i11 = 0;
        while (true) {
            f9[] f9VarArr = this.f21585b;
            if (i11 >= f9VarArr.length) {
                return -1;
            }
            if (f9Var == f9VarArr[i11]) {
                return i11;
            }
            i11++;
        }
    }

    public f9 a(int i11) {
        return this.f21585b[i11];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || oo.class != obj.getClass()) {
            return false;
        }
        oo ooVar = (oo) obj;
        return this.f21584a == ooVar.f21584a && Arrays.equals(this.f21585b, ooVar.f21585b);
    }

    public int hashCode() {
        if (this.f21586c == 0) {
            this.f21586c = Arrays.hashCode(this.f21585b) + 527;
        }
        return this.f21586c;
    }
}
