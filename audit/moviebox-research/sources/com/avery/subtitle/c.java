package com.avery.subtitle;

import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    @Nullable
    public static a8.b a(long j11, List<a8.b> list) {
        if (list != null && !list.isEmpty()) {
            int size = list.size() - 1;
            int i11 = 0;
            while (i11 <= size) {
                int i12 = (i11 + size) / 2;
                a8.b bVar = list.get(i12);
                int i13 = bVar.f451b.f454a;
                if (j11 >= i13) {
                    int i14 = bVar.f452c.f454a;
                    if (j11 > i14) {
                        if (j11 < i13) {
                            return bVar;
                        }
                        i11 = i12 + 1;
                    } else if (j11 >= i13 && j11 <= i14) {
                        return bVar;
                    }
                } else {
                    if (j11 > bVar.f452c.f454a) {
                        return bVar;
                    }
                    size = i12 - 1;
                }
            }
        }
        return null;
    }
}
