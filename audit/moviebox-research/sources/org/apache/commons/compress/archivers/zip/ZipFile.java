package org.apache.commons.compress.archivers.zip;

import java.io.Closeable;
import java.util.Comparator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class ZipFile implements Closeable {

    /* JADX INFO: renamed from: org.apache.commons.compress.archivers.zip.ZipFile$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public class AnonymousClass2 implements Comparator<ZipArchiveEntry> {
        final /* synthetic */ ZipFile this$0;

        public AnonymousClass2(ZipFile zipFile) {
        }

        @Override // java.util.Comparator
        public int compare(ZipArchiveEntry zipArchiveEntry, ZipArchiveEntry zipArchiveEntry2) {
            if (zipArchiveEntry == zipArchiveEntry2) {
                return 0;
            }
            a aVar = zipArchiveEntry instanceof a ? (a) zipArchiveEntry : null;
            a aVar2 = zipArchiveEntry2 instanceof a ? (a) zipArchiveEntry2 : null;
            if (aVar == null) {
                return 1;
            }
            if (aVar2 == null) {
                return -1;
            }
            long jK = aVar.k() - aVar2.k();
            if (jK == 0) {
                return 0;
            }
            return jK < 0 ? -1 : 1;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class a extends ZipArchiveEntry {
        @Override // org.apache.commons.compress.archivers.zip.ZipArchiveEntry
        public boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            a aVar = (a) obj;
            return k() == aVar.k() && super.d() == aVar.d();
        }

        @Override // org.apache.commons.compress.archivers.zip.ZipArchiveEntry, java.util.zip.ZipEntry
        public int hashCode() {
            return (super.hashCode() * 3) + ((int) k()) + ((int) (k() >> 32));
        }
    }
}
