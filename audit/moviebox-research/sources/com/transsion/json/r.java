package com.transsion.json;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<String> f52986a = new LinkedList<>();

    public r a(String str) {
        this.f52986a.add(str);
        return this;
    }

    public List<String> b() {
        return this.f52986a;
    }

    public int c() {
        return this.f52986a.size();
    }

    public String d() {
        return this.f52986a.removeLast();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r.class != obj.getClass()) {
            return false;
        }
        return this.f52986a.equals(((r) obj).f52986a);
    }

    public int hashCode() {
        return this.f52986a.hashCode();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("[ ");
        boolean z11 = false;
        for (String str : this.f52986a) {
            if (z11) {
                sb2.append(InstructionFileId.DOT);
            }
            sb2.append(str);
            z11 = true;
        }
        sb2.append(" ]");
        return sb2.toString();
    }
}
