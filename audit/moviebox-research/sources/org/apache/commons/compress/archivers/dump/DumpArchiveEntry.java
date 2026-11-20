package org.apache.commons.compress.archivers.dump;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class DumpArchiveEntry implements l20.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f72519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TYPE f72520b = TYPE.UNKNOWN;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set<PERMISSION> f72521c = Collections.emptySet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f72522d = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f72523f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f72524g;

    /* JADX INFO: compiled from: source.java */
    public enum PERMISSION {
        SETUID(2048),
        SETGUI(1024),
        STICKY(512),
        USER_READ(256),
        USER_WRITE(128),
        USER_EXEC(64),
        GROUP_READ(32),
        GROUP_WRITE(16),
        GROUP_EXEC(8),
        WORLD_READ(4),
        WORLD_WRITE(2),
        WORLD_EXEC(1);

        private int code;

        PERMISSION(int i11) {
            this.code = i11;
        }

        public static Set<PERMISSION> find(int i11) {
            HashSet hashSet = new HashSet();
            for (PERMISSION permission : values()) {
                int i12 = permission.code;
                if ((i11 & i12) == i12) {
                    hashSet.add(permission);
                }
            }
            return hashSet.isEmpty() ? Collections.emptySet() : EnumSet.copyOf((Collection) hashSet);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum TYPE {
        WHITEOUT(14),
        SOCKET(12),
        LINK(10),
        FILE(8),
        BLKDEV(6),
        DIRECTORY(4),
        CHRDEV(2),
        FIFO(1),
        UNKNOWN(15);

        private int code;

        TYPE(int i11) {
            this.code = i11;
        }

        public static TYPE find(int i11) {
            TYPE type = UNKNOWN;
            for (TYPE type2 : values()) {
                if (i11 == type2.code) {
                    type = type2;
                }
            }
            return type;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f72525a = new byte[512];
    }

    public String a() {
        return this.f72519a;
    }

    public String b() {
        return this.f72523f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        DumpArchiveEntry dumpArchiveEntry = (DumpArchiveEntry) obj;
        return dumpArchiveEntry.f72522d != null && this.f72524g == dumpArchiveEntry.f72524g;
    }

    public int hashCode() {
        return this.f72524g;
    }

    public String toString() {
        return a();
    }
}
