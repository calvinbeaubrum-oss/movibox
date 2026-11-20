package bk;

import java.util.Date;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public interface a {
    String getDomain();

    String getName();

    String getPath();

    boolean isExpired(Date date);
}
