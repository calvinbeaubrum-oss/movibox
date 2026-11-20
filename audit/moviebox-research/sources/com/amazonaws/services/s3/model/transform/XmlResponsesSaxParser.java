package com.amazonaws.services.s3.model.transform;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.alibaba.sdk.android.oss.model.CreateBucketRequest;
import com.amazonaws.AmazonClientException;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.internal.DeleteObjectsResponse;
import com.amazonaws.services.s3.internal.ObjectExpirationResult;
import com.amazonaws.services.s3.internal.S3HttpUtils;
import com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import com.amazonaws.services.s3.internal.S3VersionResult;
import com.amazonaws.services.s3.internal.ServerSideEncryptionResult;
import com.amazonaws.services.s3.internal.ServiceUtils;
import com.amazonaws.services.s3.model.AbortIncompleteMultipartUpload;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.BucketAccelerateConfiguration;
import com.amazonaws.services.s3.model.BucketCrossOriginConfiguration;
import com.amazonaws.services.s3.model.BucketLifecycleConfiguration;
import com.amazonaws.services.s3.model.BucketLoggingConfiguration;
import com.amazonaws.services.s3.model.BucketReplicationConfiguration;
import com.amazonaws.services.s3.model.BucketTaggingConfiguration;
import com.amazonaws.services.s3.model.BucketVersioningConfiguration;
import com.amazonaws.services.s3.model.BucketWebsiteConfiguration;
import com.amazonaws.services.s3.model.CORSRule;
import com.amazonaws.services.s3.model.CanonicalGrantee;
import com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazonaws.services.s3.model.CopyObjectResult;
import com.amazonaws.services.s3.model.DeleteObjectsResult;
import com.amazonaws.services.s3.model.EmailAddressGrantee;
import com.amazonaws.services.s3.model.GetBucketInventoryConfigurationResult;
import com.amazonaws.services.s3.model.GetObjectTaggingResult;
import com.amazonaws.services.s3.model.Grantee;
import com.amazonaws.services.s3.model.GroupGrantee;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.ListBucketAnalyticsConfigurationsResult;
import com.amazonaws.services.s3.model.ListBucketInventoryConfigurationsResult;
import com.amazonaws.services.s3.model.ListBucketMetricsConfigurationsResult;
import com.amazonaws.services.s3.model.MultiObjectDeleteException;
import com.amazonaws.services.s3.model.MultipartUpload;
import com.amazonaws.services.s3.model.MultipartUploadListing;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.Owner;
import com.amazonaws.services.s3.model.PartListing;
import com.amazonaws.services.s3.model.PartSummary;
import com.amazonaws.services.s3.model.Permission;
import com.amazonaws.services.s3.model.RedirectRule;
import com.amazonaws.services.s3.model.ReplicationDestinationConfig;
import com.amazonaws.services.s3.model.ReplicationRule;
import com.amazonaws.services.s3.model.RoutingRule;
import com.amazonaws.services.s3.model.RoutingRuleCondition;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.services.s3.model.S3VersionSummary;
import com.amazonaws.services.s3.model.Tag;
import com.amazonaws.services.s3.model.TagSet;
import com.amazonaws.services.s3.model.analytics.AnalyticsAndOperator;
import com.amazonaws.services.s3.model.analytics.AnalyticsConfiguration;
import com.amazonaws.services.s3.model.analytics.AnalyticsExportDestination;
import com.amazonaws.services.s3.model.analytics.AnalyticsFilter;
import com.amazonaws.services.s3.model.analytics.AnalyticsFilterPredicate;
import com.amazonaws.services.s3.model.analytics.AnalyticsPrefixPredicate;
import com.amazonaws.services.s3.model.analytics.AnalyticsS3BucketDestination;
import com.amazonaws.services.s3.model.analytics.AnalyticsTagPredicate;
import com.amazonaws.services.s3.model.analytics.StorageClassAnalysis;
import com.amazonaws.services.s3.model.analytics.StorageClassAnalysisDataExport;
import com.amazonaws.services.s3.model.inventory.InventoryConfiguration;
import com.amazonaws.services.s3.model.inventory.InventoryDestination;
import com.amazonaws.services.s3.model.inventory.InventoryFilter;
import com.amazonaws.services.s3.model.inventory.InventoryPrefixPredicate;
import com.amazonaws.services.s3.model.inventory.InventoryS3BucketDestination;
import com.amazonaws.services.s3.model.inventory.InventorySchedule;
import com.amazonaws.services.s3.model.lifecycle.LifecycleAndOperator;
import com.amazonaws.services.s3.model.lifecycle.LifecycleFilter;
import com.amazonaws.services.s3.model.lifecycle.LifecycleFilterPredicate;
import com.amazonaws.services.s3.model.lifecycle.LifecyclePrefixPredicate;
import com.amazonaws.services.s3.model.lifecycle.LifecycleTagPredicate;
import com.amazonaws.services.s3.model.metrics.MetricsAndOperator;
import com.amazonaws.services.s3.model.metrics.MetricsConfiguration;
import com.amazonaws.services.s3.model.metrics.MetricsFilter;
import com.amazonaws.services.s3.model.metrics.MetricsFilterPredicate;
import com.amazonaws.services.s3.model.metrics.MetricsPrefixPredicate;
import com.amazonaws.services.s3.model.metrics.MetricsTagPredicate;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.StringUtils;
import com.transsion.search.bean.HotRankItem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class XmlResponsesSaxParser {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Log f16121c = LogFactory.b(XmlResponsesSaxParser.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public XMLReader f16122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f16123b = true;

    /* JADX INFO: compiled from: source.java */
    public static class AccessControlListHandler extends AbstractHandler {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AccessControlList f16124c = new AccessControlList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Grantee f16125d = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Permission f16126f = null;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void b(String str, String str2, String str3) {
            if (e("AccessControlPolicy", "Owner")) {
                if (str2.equals("ID")) {
                    this.f16124c.getOwner().setId(d());
                    return;
                } else {
                    if (str2.equals("DisplayName")) {
                        this.f16124c.getOwner().setDisplayName(d());
                        return;
                    }
                    return;
                }
            }
            if (e("AccessControlPolicy", "AccessControlList")) {
                if (str2.equals("Grant")) {
                    this.f16124c.grantPermission(this.f16125d, this.f16126f);
                    this.f16125d = null;
                    this.f16126f = null;
                    return;
                }
                return;
            }
            if (e("AccessControlPolicy", "AccessControlList", "Grant")) {
                if (str2.equals("Permission")) {
                    this.f16126f = Permission.parsePermission(d());
                }
            } else if (e("AccessControlPolicy", "AccessControlList", "Grant", "Grantee")) {
                if (str2.equals("ID")) {
                    this.f16125d.setIdentifier(d());
                    return;
                }
                if (str2.equals("EmailAddress")) {
                    this.f16125d.setIdentifier(d());
                } else if (str2.equals("URI")) {
                    this.f16125d = GroupGrantee.parseGroupGrantee(d());
                } else if (str2.equals("DisplayName")) {
                    ((CanonicalGrantee) this.f16125d).setDisplayName(d());
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void c(String str, String str2, String str3, Attributes attributes) {
            if (e("AccessControlPolicy")) {
                if (str2.equals("Owner")) {
                    this.f16124c.setOwner(new Owner());
                }
            } else if (e("AccessControlPolicy", "AccessControlList", "Grant") && str2.equals("Grantee")) {
                String strI = XmlResponsesSaxParser.i("xsi:type", attributes);
                if ("AmazonCustomerByEmail".equals(strI)) {
                    this.f16125d = new EmailAddressGrantee(null);
                } else if ("CanonicalUser".equals(strI)) {
                    this.f16125d = new CanonicalGrantee(null);
                } else {
                    HotRankItem.CATE_GROUP.equals(strI);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class BucketAccelerateConfigurationHandler extends AbstractHandler {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final BucketAccelerateConfiguration f16127c = new BucketAccelerateConfiguration(null);

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void b(String str, String str2, String str3) {
            if (e("AccelerateConfiguration") && str2.equals("Status")) {
                this.f16127c.a(d());
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void c(String str, String str2, String str3, Attributes attributes) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class BucketCrossOriginConfigurationHandler extends AbstractHandler {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public CORSRule f16129d;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final BucketCrossOriginConfiguration f16128c = new BucketCrossOriginConfiguration(new ArrayList());

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<CORSRule.AllowedMethods> f16130f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List<String> f16131g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public List<String> f16132h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public List<String> f16133i = null;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void b(String str, String str2, String str3) {
            if (e("CORSConfiguration")) {
                if (str2.equals("CORSRule")) {
                    this.f16129d.a(this.f16133i);
                    this.f16129d.b(this.f16130f);
                    this.f16129d.c(this.f16131g);
                    this.f16129d.d(this.f16132h);
                    this.f16133i = null;
                    this.f16130f = null;
                    this.f16131g = null;
                    this.f16132h = null;
                    this.f16128c.getRules().add(this.f16129d);
                    this.f16129d = null;
                    return;
                }
                return;
            }
            if (e("CORSConfiguration", "CORSRule")) {
                if (str2.equals("ID")) {
                    this.f16129d.e(d());
                    return;
                }
                if (str2.equals("AllowedOrigin")) {
                    this.f16131g.add(d());
                    return;
                }
                if (str2.equals("AllowedMethod")) {
                    this.f16130f.add(CORSRule.AllowedMethods.fromValue(d()));
                    return;
                }
                if (str2.equals("MaxAgeSeconds")) {
                    this.f16129d.f(Integer.parseInt(d()));
                } else if (str2.equals("ExposeHeader")) {
                    this.f16132h.add(d());
                } else if (str2.equals("AllowedHeader")) {
                    this.f16133i.add(d());
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void c(String str, String str2, String str3, Attributes attributes) {
            if (e("CORSConfiguration")) {
                if (str2.equals("CORSRule")) {
                    this.f16129d = new CORSRule();
                    return;
                }
                return;
            }
            if (e("CORSConfiguration", "CORSRule")) {
                if (str2.equals("AllowedOrigin")) {
                    if (this.f16131g == null) {
                        this.f16131g = new ArrayList();
                    }
                } else if (str2.equals("AllowedMethod")) {
                    if (this.f16130f == null) {
                        this.f16130f = new ArrayList();
                    }
                } else if (str2.equals("ExposeHeader")) {
                    if (this.f16132h == null) {
                        this.f16132h = new ArrayList();
                    }
                } else if (str2.equals("AllowedHeader") && this.f16133i == null) {
                    this.f16133i = new LinkedList();
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class BucketLifecycleConfigurationHandler extends AbstractHandler {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final BucketLifecycleConfiguration f16134c = new BucketLifecycleConfiguration(new ArrayList());

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public BucketLifecycleConfiguration.Rule f16135d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public BucketLifecycleConfiguration.Transition f16136f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public BucketLifecycleConfiguration.NoncurrentVersionTransition f16137g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public AbortIncompleteMultipartUpload f16138h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public LifecycleFilter f16139i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public List<LifecycleFilterPredicate> f16140j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f16141k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f16142l;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void b(String str, String str2, String str3) {
            if (e("LifecycleConfiguration")) {
                if (str2.equals("Rule")) {
                    this.f16134c.getRules().add(this.f16135d);
                    this.f16135d = null;
                    return;
                }
                return;
            }
            if (e("LifecycleConfiguration", "Rule")) {
                if (str2.equals("ID")) {
                    this.f16135d.setId(d());
                    return;
                }
                if (str2.equals("Prefix")) {
                    this.f16135d.setPrefix(d());
                    return;
                }
                if (str2.equals("Status")) {
                    this.f16135d.setStatus(d());
                    return;
                }
                if (str2.equals("Transition")) {
                    this.f16135d.addTransition(this.f16136f);
                    this.f16136f = null;
                    return;
                }
                if (str2.equals("NoncurrentVersionTransition")) {
                    this.f16135d.addNoncurrentVersionTransition(this.f16137g);
                    this.f16137g = null;
                    return;
                } else if (str2.equals("AbortIncompleteMultipartUpload")) {
                    this.f16135d.setAbortIncompleteMultipartUpload(this.f16138h);
                    this.f16138h = null;
                    return;
                } else {
                    if (str2.equals("Filter")) {
                        this.f16135d.setFilter(this.f16139i);
                        this.f16139i = null;
                        return;
                    }
                    return;
                }
            }
            if (e("LifecycleConfiguration", "Rule", "Expiration")) {
                if (str2.equals(HttpHeaders.DATE)) {
                    this.f16135d.setExpirationDate(ServiceUtils.d(d()));
                    return;
                }
                if (str2.equals("Days")) {
                    this.f16135d.setExpirationInDays(Integer.parseInt(d()));
                    return;
                } else {
                    if (str2.equals("ExpiredObjectDeleteMarker") && "true".equals(d())) {
                        this.f16135d.setExpiredObjectDeleteMarker(true);
                        return;
                    }
                    return;
                }
            }
            if (e("LifecycleConfiguration", "Rule", "Transition")) {
                if (str2.equals(CreateBucketRequest.TAB_STORAGECLASS)) {
                    this.f16136f.setStorageClass(d());
                    return;
                } else if (str2.equals(HttpHeaders.DATE)) {
                    this.f16136f.setDate(ServiceUtils.d(d()));
                    return;
                } else {
                    if (str2.equals("Days")) {
                        this.f16136f.setDays(Integer.parseInt(d()));
                        return;
                    }
                    return;
                }
            }
            if (e("LifecycleConfiguration", "Rule", "NoncurrentVersionExpiration")) {
                if (str2.equals("NoncurrentDays")) {
                    this.f16135d.setNoncurrentVersionExpirationInDays(Integer.parseInt(d()));
                    return;
                }
                return;
            }
            if (e("LifecycleConfiguration", "Rule", "NoncurrentVersionTransition")) {
                if (str2.equals(CreateBucketRequest.TAB_STORAGECLASS)) {
                    this.f16137g.setStorageClass(d());
                    return;
                } else {
                    if (str2.equals("NoncurrentDays")) {
                        this.f16137g.setDays(Integer.parseInt(d()));
                        return;
                    }
                    return;
                }
            }
            if (e("LifecycleConfiguration", "Rule", "AbortIncompleteMultipartUpload")) {
                if (str2.equals("DaysAfterInitiation")) {
                    this.f16138h.setDaysAfterInitiation(Integer.parseInt(d()));
                    return;
                }
                return;
            }
            if (e("LifecycleConfiguration", "Rule", "Filter")) {
                if (str2.equals("Prefix")) {
                    this.f16139i.setPredicate(new LifecyclePrefixPredicate(d()));
                    return;
                }
                if (str2.equals("Tag")) {
                    this.f16139i.setPredicate(new LifecycleTagPredicate(new Tag(this.f16141k, this.f16142l)));
                    this.f16141k = null;
                    this.f16142l = null;
                    return;
                } else {
                    if (str2.equals("And")) {
                        this.f16139i.setPredicate(new LifecycleAndOperator(this.f16140j));
                        this.f16140j = null;
                        return;
                    }
                    return;
                }
            }
            if (e("LifecycleConfiguration", "Rule", "Filter", "Tag")) {
                if (str2.equals("Key")) {
                    this.f16141k = d();
                    return;
                } else {
                    if (str2.equals("Value")) {
                        this.f16142l = d();
                        return;
                    }
                    return;
                }
            }
            if (e("LifecycleConfiguration", "Rule", "Filter", "And")) {
                if (str2.equals("Prefix")) {
                    this.f16140j.add(new LifecyclePrefixPredicate(d()));
                    return;
                } else {
                    if (str2.equals("Tag")) {
                        this.f16140j.add(new LifecycleTagPredicate(new Tag(this.f16141k, this.f16142l)));
                        this.f16141k = null;
                        this.f16142l = null;
                        return;
                    }
                    return;
                }
            }
            if (e("LifecycleConfiguration", "Rule", "Filter", "And", "Tag")) {
                if (str2.equals("Key")) {
                    this.f16141k = d();
                } else if (str2.equals("Value")) {
                    this.f16142l = d();
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void c(String str, String str2, String str3, Attributes attributes) {
            if (e("LifecycleConfiguration")) {
                if (str2.equals("Rule")) {
                    this.f16135d = new BucketLifecycleConfiguration.Rule();
                    return;
                }
                return;
            }
            if (!e("LifecycleConfiguration", "Rule")) {
                if (e("LifecycleConfiguration", "Rule", "Filter") && str2.equals("And")) {
                    this.f16140j = new ArrayList();
                    return;
                }
                return;
            }
            if (str2.equals("Transition")) {
                this.f16136f = new BucketLifecycleConfiguration.Transition();
                return;
            }
            if (str2.equals("NoncurrentVersionTransition")) {
                this.f16137g = new BucketLifecycleConfiguration.NoncurrentVersionTransition();
            } else if (str2.equals("AbortIncompleteMultipartUpload")) {
                this.f16138h = new AbortIncompleteMultipartUpload();
            } else if (str2.equals("Filter")) {
                this.f16139i = new LifecycleFilter();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class BucketLocationHandler extends AbstractHandler {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f16143c = null;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void b(String str, String str2, String str3) {
            if (a() && str2.equals(CreateBucketRequest.TAB_LOCATIONCONSTRAINT)) {
                String strD = d();
                if (strD.length() == 0) {
                    this.f16143c = null;
                } else {
                    this.f16143c = strD;
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void c(String str, String str2, String str3, Attributes attributes) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class BucketLoggingConfigurationHandler extends AbstractHandler {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final BucketLoggingConfiguration f16144c = new BucketLoggingConfiguration();

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void b(String str, String str2, String str3) {
            if (e("BucketLoggingStatus", "LoggingEnabled")) {
                if (str2.equals("TargetBucket")) {
                    this.f16144c.setDestinationBucketName(d());
                } else if (str2.equals("TargetPrefix")) {
                    this.f16144c.setLogFilePrefix(d());
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void c(String str, String str2, String str3, Attributes attributes) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class BucketReplicationConfigurationHandler extends AbstractHandler {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final BucketReplicationConfiguration f16145c = new BucketReplicationConfiguration();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f16146d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ReplicationRule f16147f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ReplicationDestinationConfig f16148g;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void b(String str, String str2, String str3) {
            if (e("ReplicationConfiguration")) {
                if (!str2.equals("Rule")) {
                    if (str2.equals("Role")) {
                        this.f16145c.setRoleARN(d());
                        return;
                    }
                    return;
                } else {
                    this.f16145c.addRule(this.f16146d, this.f16147f);
                    this.f16147f = null;
                    this.f16146d = null;
                    this.f16148g = null;
                    return;
                }
            }
            if (!e("ReplicationConfiguration", "Rule")) {
                if (e("ReplicationConfiguration", "Rule", "Destination")) {
                    if (str2.equals("Bucket")) {
                        this.f16148g.a(d());
                        return;
                    } else {
                        if (str2.equals(CreateBucketRequest.TAB_STORAGECLASS)) {
                            this.f16148g.b(d());
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (str2.equals("ID")) {
                this.f16146d = d();
                return;
            }
            if (str2.equals("Prefix")) {
                this.f16147f.b(d());
            } else if (str2.equals("Status")) {
                this.f16147f.c(d());
            } else if (str2.equals("Destination")) {
                this.f16147f.a(this.f16148g);
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void c(String str, String str2, String str3, Attributes attributes) {
            if (e("ReplicationConfiguration")) {
                if (str2.equals("Rule")) {
                    this.f16147f = new ReplicationRule();
                }
            } else if (e("ReplicationConfiguration", "Rule") && str2.equals("Destination")) {
                this.f16148g = new ReplicationDestinationConfig();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class BucketTaggingConfigurationHandler extends AbstractHandler {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final BucketTaggingConfiguration f16149c = new BucketTaggingConfiguration();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Map<String, String> f16150d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f16151f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f16152g;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void b(String str, String str2, String str3) {
            String str4;
            if (e("Tagging")) {
                if (str2.equals("TagSet")) {
                    this.f16149c.getAllTagSets().add(new TagSet(this.f16150d));
                    this.f16150d = null;
                    return;
                }
                return;
            }
            if (e("Tagging", "TagSet")) {
                if (str2.equals("Tag")) {
                    String str5 = this.f16151f;
                    if (str5 != null && (str4 = this.f16152g) != null) {
                        this.f16150d.put(str5, str4);
                    }
                    this.f16151f = null;
                    this.f16152g = null;
                    return;
                }
                return;
            }
            if (e("Tagging", "TagSet", "Tag")) {
                if (str2.equals("Key")) {
                    this.f16151f = d();
                } else if (str2.equals("Value")) {
                    this.f16152g = d();
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void c(String str, String str2, String str3, Attributes attributes) {
            if (e("Tagging") && str2.equals("TagSet")) {
                this.f16150d = new HashMap();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class BucketVersioningConfigurationHandler extends AbstractHandler {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final BucketVersioningConfiguration f16153c = new BucketVersioningConfiguration();

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void b(String str, String str2, String str3) {
            if (e("VersioningConfiguration")) {
                if (str2.equals("Status")) {
                    this.f16153c.setStatus(d());
                    return;
                }
                if (str2.equals("MfaDelete")) {
                    String strD = d();
                    if (strD.equals(BucketLifecycleConfiguration.DISABLED)) {
                        this.f16153c.setMfaDeleteEnabled(Boolean.FALSE);
                    } else if (strD.equals("Enabled")) {
                        this.f16153c.setMfaDeleteEnabled(Boolean.TRUE);
                    } else {
                        this.f16153c.setMfaDeleteEnabled(null);
                    }
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void c(String str, String str2, String str3, Attributes attributes) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class BucketWebsiteConfigurationHandler extends AbstractHandler {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final BucketWebsiteConfiguration f16154c = new BucketWebsiteConfiguration(null);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public RoutingRuleCondition f16155d = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public RedirectRule f16156f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public RoutingRule f16157g = null;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void b(String str, String str2, String str3) {
            if (e("WebsiteConfiguration")) {
                if (str2.equals("RedirectAllRequestsTo")) {
                    this.f16154c.setRedirectAllRequestsTo(this.f16156f);
                    this.f16156f = null;
                    return;
                }
                return;
            }
            if (e("WebsiteConfiguration", "IndexDocument")) {
                if (str2.equals("Suffix")) {
                    this.f16154c.setIndexDocumentSuffix(d());
                    return;
                }
                return;
            }
            if (e("WebsiteConfiguration", "ErrorDocument")) {
                if (str2.equals("Key")) {
                    this.f16154c.setErrorDocument(d());
                    return;
                }
                return;
            }
            if (e("WebsiteConfiguration", "RoutingRules")) {
                if (str2.equals("RoutingRule")) {
                    this.f16154c.getRoutingRules().add(this.f16157g);
                    this.f16157g = null;
                    return;
                }
                return;
            }
            if (e("WebsiteConfiguration", "RoutingRules", "RoutingRule")) {
                if (str2.equals("Condition")) {
                    this.f16157g.a(this.f16155d);
                    this.f16155d = null;
                    return;
                } else {
                    if (str2.equals("Redirect")) {
                        this.f16157g.b(this.f16156f);
                        this.f16156f = null;
                        return;
                    }
                    return;
                }
            }
            if (e("WebsiteConfiguration", "RoutingRules", "RoutingRule", "Condition")) {
                if (str2.equals("KeyPrefixEquals")) {
                    this.f16155d.b(d());
                    return;
                } else {
                    if (str2.equals("HttpErrorCodeReturnedEquals")) {
                        this.f16155d.a(d());
                        return;
                    }
                    return;
                }
            }
            if (e("WebsiteConfiguration", "RedirectAllRequestsTo") || e("WebsiteConfiguration", "RoutingRules", "RoutingRule", "Redirect")) {
                if (str2.equals("Protocol")) {
                    this.f16156f.c(d());
                    return;
                }
                if (str2.equals("HostName")) {
                    this.f16156f.a(d());
                    return;
                }
                if (str2.equals("ReplaceKeyPrefixWith")) {
                    this.f16156f.d(d());
                } else if (str2.equals("ReplaceKeyWith")) {
                    this.f16156f.e(d());
                } else if (str2.equals("HttpRedirectCode")) {
                    this.f16156f.b(d());
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void c(String str, String str2, String str3, Attributes attributes) {
            if (e("WebsiteConfiguration")) {
                if (str2.equals("RedirectAllRequestsTo")) {
                    this.f16156f = new RedirectRule();
                }
            } else if (e("WebsiteConfiguration", "RoutingRules")) {
                if (str2.equals("RoutingRule")) {
                    this.f16157g = new RoutingRule();
                }
            } else if (e("WebsiteConfiguration", "RoutingRules", "RoutingRule")) {
                if (str2.equals("Condition")) {
                    this.f16155d = new RoutingRuleCondition();
                } else if (str2.equals("Redirect")) {
                    this.f16156f = new RedirectRule();
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class CompleteMultipartUploadHandler extends AbstractSSEHandler implements ObjectExpirationResult, S3VersionResult, S3RequesterChargedResult {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CompleteMultipartUploadResult f16158c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public AmazonS3Exception f16159d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f16160f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f16161g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f16162h;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void b(String str, String str2, String str3) {
            AmazonS3Exception amazonS3Exception;
            if (a()) {
                if (!str2.equals("Error") || (amazonS3Exception = this.f16159d) == null) {
                    return;
                }
                amazonS3Exception.setErrorCode(this.f16162h);
                this.f16159d.setRequestId(this.f16161g);
                this.f16159d.setExtendedRequestId(this.f16160f);
                return;
            }
            if (e("CompleteMultipartUploadResult")) {
                if (str2.equals(HttpHeaders.LOCATION)) {
                    this.f16158c.setLocation(d());
                    return;
                }
                if (str2.equals("Bucket")) {
                    this.f16158c.setBucketName(d());
                    return;
                } else if (str2.equals("Key")) {
                    this.f16158c.setKey(d());
                    return;
                } else {
                    if (str2.equals("ETag")) {
                        this.f16158c.setETag(ServiceUtils.f(d()));
                        return;
                    }
                    return;
                }
            }
            if (e("Error")) {
                if (str2.equals("Code")) {
                    this.f16162h = d();
                    return;
                }
                if (str2.equals("Message")) {
                    this.f16159d = new AmazonS3Exception(d());
                } else if (str2.equals("RequestId")) {
                    this.f16161g = d();
                } else if (str2.equals("HostId")) {
                    this.f16160f = d();
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void c(String str, String str2, String str3, Attributes attributes) {
            if (a() && str2.equals("CompleteMultipartUploadResult")) {
                this.f16158c = new CompleteMultipartUploadResult();
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractSSEHandler
        public ServerSideEncryptionResult f() {
            return this.f16158c;
        }

        public AmazonS3Exception g() {
            return this.f16159d;
        }

        public CompleteMultipartUploadResult h() {
            return this.f16158c;
        }

        @Override // com.amazonaws.services.s3.internal.ObjectExpirationResult
        public void setExpirationTime(Date date) {
            CompleteMultipartUploadResult completeMultipartUploadResult = this.f16158c;
            if (completeMultipartUploadResult != null) {
                completeMultipartUploadResult.setExpirationTime(date);
            }
        }

        @Override // com.amazonaws.services.s3.internal.ObjectExpirationResult
        public void setExpirationTimeRuleId(String str) {
            CompleteMultipartUploadResult completeMultipartUploadResult = this.f16158c;
            if (completeMultipartUploadResult != null) {
                completeMultipartUploadResult.setExpirationTimeRuleId(str);
            }
        }

        @Override // com.amazonaws.services.s3.internal.S3RequesterChargedResult
        public void setRequesterCharged(boolean z11) {
            CompleteMultipartUploadResult completeMultipartUploadResult = this.f16158c;
            if (completeMultipartUploadResult != null) {
                completeMultipartUploadResult.setRequesterCharged(z11);
            }
        }

        @Override // com.amazonaws.services.s3.internal.S3VersionResult
        public void setVersionId(String str) {
            CompleteMultipartUploadResult completeMultipartUploadResult = this.f16158c;
            if (completeMultipartUploadResult != null) {
                completeMultipartUploadResult.setVersionId(str);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class CopyObjectResultHandler extends AbstractSSEHandler implements ObjectExpirationResult, S3RequesterChargedResult, S3VersionResult {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final CopyObjectResult f16163c = new CopyObjectResult();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f16164d = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f16165f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f16166g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f16167h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f16168i = false;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void b(String str, String str2, String str3) {
            if (e("CopyObjectResult") || e("CopyPartResult")) {
                if (str2.equals("LastModified")) {
                    this.f16163c.setLastModifiedDate(ServiceUtils.d(d()));
                    return;
                } else {
                    if (str2.equals("ETag")) {
                        this.f16163c.setETag(ServiceUtils.f(d()));
                        return;
                    }
                    return;
                }
            }
            if (e("Error")) {
                if (str2.equals("Code")) {
                    this.f16164d = d();
                    return;
                }
                if (str2.equals("Message")) {
                    this.f16165f = d();
                } else if (str2.equals("RequestId")) {
                    this.f16166g = d();
                } else if (str2.equals("HostId")) {
                    this.f16167h = d();
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void c(String str, String str2, String str3, Attributes attributes) {
            if (a()) {
                if (str2.equals("CopyObjectResult") || str2.equals("CopyPartResult")) {
                    this.f16168i = false;
                } else if (str2.equals("Error")) {
                    this.f16168i = true;
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractSSEHandler
        public ServerSideEncryptionResult f() {
            return this.f16163c;
        }

        @Override // com.amazonaws.services.s3.internal.ObjectExpirationResult
        public void setExpirationTime(Date date) {
            this.f16163c.setExpirationTime(date);
        }

        @Override // com.amazonaws.services.s3.internal.ObjectExpirationResult
        public void setExpirationTimeRuleId(String str) {
            this.f16163c.setExpirationTimeRuleId(str);
        }

        @Override // com.amazonaws.services.s3.internal.S3RequesterChargedResult
        public void setRequesterCharged(boolean z11) {
            this.f16163c.setRequesterCharged(z11);
        }

        @Override // com.amazonaws.services.s3.internal.S3VersionResult
        public void setVersionId(String str) {
            this.f16163c.setVersionId(str);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class DeleteObjectsHandler extends AbstractHandler {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final DeleteObjectsResponse f16169c = new DeleteObjectsResponse();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public DeleteObjectsResult.DeletedObject f16170d = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public MultiObjectDeleteException.DeleteError f16171f = null;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void b(String str, String str2, String str3) {
            if (e("DeleteResult")) {
                if (str2.equals("Deleted")) {
                    this.f16169c.a().add(this.f16170d);
                    this.f16170d = null;
                    return;
                } else {
                    if (str2.equals("Error")) {
                        this.f16169c.b().add(this.f16171f);
                        this.f16171f = null;
                        return;
                    }
                    return;
                }
            }
            if (e("DeleteResult", "Deleted")) {
                if (str2.equals("Key")) {
                    this.f16170d.setKey(d());
                    return;
                }
                if (str2.equals("VersionId")) {
                    this.f16170d.setVersionId(d());
                    return;
                } else if (str2.equals("DeleteMarker")) {
                    this.f16170d.setDeleteMarker(d().equals("true"));
                    return;
                } else {
                    if (str2.equals("DeleteMarkerVersionId")) {
                        this.f16170d.setDeleteMarkerVersionId(d());
                        return;
                    }
                    return;
                }
            }
            if (e("DeleteResult", "Error")) {
                if (str2.equals("Key")) {
                    this.f16171f.b(d());
                    return;
                }
                if (str2.equals("VersionId")) {
                    this.f16171f.d(d());
                } else if (str2.equals("Code")) {
                    this.f16171f.a(d());
                } else if (str2.equals("Message")) {
                    this.f16171f.c(d());
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void c(String str, String str2, String str3, Attributes attributes) {
            if (e("DeleteResult")) {
                if (str2.equals("Deleted")) {
                    this.f16170d = new DeleteObjectsResult.DeletedObject();
                } else if (str2.equals("Error")) {
                    this.f16171f = new MultiObjectDeleteException.DeleteError();
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class GetBucketAnalyticsConfigurationHandler extends AbstractHandler {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AnalyticsConfiguration f16172c = new AnalyticsConfiguration();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public AnalyticsFilter f16173d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<AnalyticsFilterPredicate> f16174f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public StorageClassAnalysis f16175g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public StorageClassAnalysisDataExport f16176h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public AnalyticsExportDestination f16177i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public AnalyticsS3BucketDestination f16178j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f16179k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f16180l;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void b(String str, String str2, String str3) {
            if (e("AnalyticsConfiguration")) {
                if (str2.equals("Id")) {
                    this.f16172c.setId(d());
                    return;
                } else if (str2.equals("Filter")) {
                    this.f16172c.setFilter(this.f16173d);
                    return;
                } else {
                    if (str2.equals("StorageClassAnalysis")) {
                        this.f16172c.setStorageClassAnalysis(this.f16175g);
                        return;
                    }
                    return;
                }
            }
            if (e("AnalyticsConfiguration", "Filter")) {
                if (str2.equals("Prefix")) {
                    this.f16173d.setPredicate(new AnalyticsPrefixPredicate(d()));
                    return;
                }
                if (str2.equals("Tag")) {
                    this.f16173d.setPredicate(new AnalyticsTagPredicate(new Tag(this.f16179k, this.f16180l)));
                    this.f16179k = null;
                    this.f16180l = null;
                    return;
                } else {
                    if (str2.equals("And")) {
                        this.f16173d.setPredicate(new AnalyticsAndOperator(this.f16174f));
                        this.f16174f = null;
                        return;
                    }
                    return;
                }
            }
            if (e("AnalyticsConfiguration", "Filter", "Tag")) {
                if (str2.equals("Key")) {
                    this.f16179k = d();
                    return;
                } else {
                    if (str2.equals("Value")) {
                        this.f16180l = d();
                        return;
                    }
                    return;
                }
            }
            if (e("AnalyticsConfiguration", "Filter", "And")) {
                if (str2.equals("Prefix")) {
                    this.f16174f.add(new AnalyticsPrefixPredicate(d()));
                    return;
                } else {
                    if (str2.equals("Tag")) {
                        this.f16174f.add(new AnalyticsTagPredicate(new Tag(this.f16179k, this.f16180l)));
                        this.f16179k = null;
                        this.f16180l = null;
                        return;
                    }
                    return;
                }
            }
            if (e("AnalyticsConfiguration", "Filter", "And", "Tag")) {
                if (str2.equals("Key")) {
                    this.f16179k = d();
                    return;
                } else {
                    if (str2.equals("Value")) {
                        this.f16180l = d();
                        return;
                    }
                    return;
                }
            }
            if (e("AnalyticsConfiguration", "StorageClassAnalysis")) {
                if (str2.equals("DataExport")) {
                    this.f16175g.setDataExport(this.f16176h);
                    return;
                }
                return;
            }
            if (e("AnalyticsConfiguration", "StorageClassAnalysis", "DataExport")) {
                if (str2.equals("OutputSchemaVersion")) {
                    this.f16176h.setOutputSchemaVersion(d());
                    return;
                } else {
                    if (str2.equals("Destination")) {
                        this.f16176h.setDestination(this.f16177i);
                        return;
                    }
                    return;
                }
            }
            if (e("AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination")) {
                if (str2.equals("S3BucketDestination")) {
                    this.f16177i.setS3BucketDestination(this.f16178j);
                }
            } else if (e("AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination", "S3BucketDestination")) {
                if (str2.equals("Format")) {
                    this.f16178j.setFormat(d());
                    return;
                }
                if (str2.equals("BucketAccountId")) {
                    this.f16178j.setBucketAccountId(d());
                } else if (str2.equals("Bucket")) {
                    this.f16178j.setBucketArn(d());
                } else if (str2.equals("Prefix")) {
                    this.f16178j.setPrefix(d());
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void c(String str, String str2, String str3, Attributes attributes) {
            if (e("AnalyticsConfiguration")) {
                if (str2.equals("Filter")) {
                    this.f16173d = new AnalyticsFilter();
                    return;
                } else {
                    if (str2.equals("StorageClassAnalysis")) {
                        this.f16175g = new StorageClassAnalysis();
                        return;
                    }
                    return;
                }
            }
            if (e("AnalyticsConfiguration", "Filter")) {
                if (str2.equals("And")) {
                    this.f16174f = new ArrayList();
                }
            } else if (e("AnalyticsConfiguration", "StorageClassAnalysis")) {
                if (str2.equals("DataExport")) {
                    this.f16176h = new StorageClassAnalysisDataExport();
                }
            } else if (e("AnalyticsConfiguration", "StorageClassAnalysis", "DataExport")) {
                if (str2.equals("Destination")) {
                    this.f16177i = new AnalyticsExportDestination();
                }
            } else if (e("AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination") && str2.equals("S3BucketDestination")) {
                this.f16178j = new AnalyticsS3BucketDestination();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class GetBucketInventoryConfigurationHandler extends AbstractHandler {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final GetBucketInventoryConfigurationResult f16181c = new GetBucketInventoryConfigurationResult();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final InventoryConfiguration f16182d = new InventoryConfiguration();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<String> f16183f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public InventoryDestination f16184g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public InventoryFilter f16185h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public InventoryS3BucketDestination f16186i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public InventorySchedule f16187j;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void b(String str, String str2, String str3) {
            if (e("InventoryConfiguration")) {
                if (str2.equals("Id")) {
                    this.f16182d.setId(d());
                    return;
                }
                if (str2.equals("Destination")) {
                    this.f16182d.setDestination(this.f16184g);
                    this.f16184g = null;
                    return;
                }
                if (str2.equals("IsEnabled")) {
                    this.f16182d.setEnabled(Boolean.valueOf("true".equals(d())));
                    return;
                }
                if (str2.equals("Filter")) {
                    this.f16182d.setInventoryFilter(this.f16185h);
                    this.f16185h = null;
                    return;
                }
                if (str2.equals("IncludedObjectVersions")) {
                    this.f16182d.setIncludedObjectVersions(d());
                    return;
                }
                if (str2.equals("Schedule")) {
                    this.f16182d.setSchedule(this.f16187j);
                    this.f16187j = null;
                    return;
                } else {
                    if (str2.equals("OptionalFields")) {
                        this.f16182d.setOptionalFields(this.f16183f);
                        this.f16183f = null;
                        return;
                    }
                    return;
                }
            }
            if (e("InventoryConfiguration", "Destination")) {
                if (str2.equals("S3BucketDestination")) {
                    this.f16184g.setS3BucketDestination(this.f16186i);
                    this.f16186i = null;
                    return;
                }
                return;
            }
            if (e("InventoryConfiguration", "Destination", "S3BucketDestination")) {
                if (str2.equals("AccountId")) {
                    this.f16186i.setAccountId(d());
                    return;
                }
                if (str2.equals("Bucket")) {
                    this.f16186i.setBucketArn(d());
                    return;
                } else if (str2.equals("Format")) {
                    this.f16186i.setFormat(d());
                    return;
                } else {
                    if (str2.equals("Prefix")) {
                        this.f16186i.setPrefix(d());
                        return;
                    }
                    return;
                }
            }
            if (e("InventoryConfiguration", "Filter")) {
                if (str2.equals("Prefix")) {
                    this.f16185h.setPredicate(new InventoryPrefixPredicate(d()));
                }
            } else if (e("InventoryConfiguration", "Schedule")) {
                if (str2.equals("Frequency")) {
                    this.f16187j.setFrequency(d());
                }
            } else if (e("InventoryConfiguration", "OptionalFields") && str2.equals("Field")) {
                this.f16183f.add(d());
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void c(String str, String str2, String str3, Attributes attributes) {
            if (!e("InventoryConfiguration")) {
                if (e("InventoryConfiguration", "Destination") && str2.equals("S3BucketDestination")) {
                    this.f16186i = new InventoryS3BucketDestination();
                    return;
                }
                return;
            }
            if (str2.equals("Destination")) {
                this.f16184g = new InventoryDestination();
                return;
            }
            if (str2.equals("Filter")) {
                this.f16185h = new InventoryFilter();
            } else if (str2.equals("Schedule")) {
                this.f16187j = new InventorySchedule();
            } else if (str2.equals("OptionalFields")) {
                this.f16183f = new ArrayList();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class GetBucketMetricsConfigurationHandler extends AbstractHandler {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final MetricsConfiguration f16188c = new MetricsConfiguration();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public MetricsFilter f16189d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<MetricsFilterPredicate> f16190f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f16191g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f16192h;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void b(String str, String str2, String str3) {
            if (e("MetricsConfiguration")) {
                if (str2.equals("Id")) {
                    this.f16188c.setId(d());
                    return;
                } else {
                    if (str2.equals("Filter")) {
                        this.f16188c.setFilter(this.f16189d);
                        this.f16189d = null;
                        return;
                    }
                    return;
                }
            }
            if (e("MetricsConfiguration", "Filter")) {
                if (str2.equals("Prefix")) {
                    this.f16189d.setPredicate(new MetricsPrefixPredicate(d()));
                    return;
                }
                if (str2.equals("Tag")) {
                    this.f16189d.setPredicate(new MetricsTagPredicate(new Tag(this.f16191g, this.f16192h)));
                    this.f16191g = null;
                    this.f16192h = null;
                    return;
                } else {
                    if (str2.equals("And")) {
                        this.f16189d.setPredicate(new MetricsAndOperator(this.f16190f));
                        this.f16190f = null;
                        return;
                    }
                    return;
                }
            }
            if (e("MetricsConfiguration", "Filter", "Tag")) {
                if (str2.equals("Key")) {
                    this.f16191g = d();
                    return;
                } else {
                    if (str2.equals("Value")) {
                        this.f16192h = d();
                        return;
                    }
                    return;
                }
            }
            if (e("MetricsConfiguration", "Filter", "And")) {
                if (str2.equals("Prefix")) {
                    this.f16190f.add(new MetricsPrefixPredicate(d()));
                    return;
                } else {
                    if (str2.equals("Tag")) {
                        this.f16190f.add(new MetricsTagPredicate(new Tag(this.f16191g, this.f16192h)));
                        this.f16191g = null;
                        this.f16192h = null;
                        return;
                    }
                    return;
                }
            }
            if (e("MetricsConfiguration", "Filter", "And", "Tag")) {
                if (str2.equals("Key")) {
                    this.f16191g = d();
                } else if (str2.equals("Value")) {
                    this.f16192h = d();
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void c(String str, String str2, String str3, Attributes attributes) {
            if (e("MetricsConfiguration")) {
                if (str2.equals("Filter")) {
                    this.f16189d = new MetricsFilter();
                }
            } else if (e("MetricsConfiguration", "Filter") && str2.equals("And")) {
                this.f16190f = new ArrayList();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class GetObjectTaggingHandler extends AbstractHandler {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public GetObjectTaggingResult f16193c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List<Tag> f16194d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f16195f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f16196g;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void b(String str, String str2, String str3) {
            if (e("Tagging") && str2.equals("TagSet")) {
                this.f16193c = new GetObjectTaggingResult(this.f16194d);
                this.f16194d = null;
            }
            if (e("Tagging", "TagSet")) {
                if (str2.equals("Tag")) {
                    this.f16194d.add(new Tag(this.f16196g, this.f16195f));
                    this.f16196g = null;
                    this.f16195f = null;
                    return;
                }
                return;
            }
            if (e("Tagging", "TagSet", "Tag")) {
                if (str2.equals("Key")) {
                    this.f16196g = d();
                } else if (str2.equals("Value")) {
                    this.f16195f = d();
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void c(String str, String str2, String str3, Attributes attributes) {
            if (e("Tagging") && str2.equals("TagSet")) {
                this.f16194d = new ArrayList();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class InitiateMultipartUploadHandler extends AbstractHandler {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final InitiateMultipartUploadResult f16197c = new InitiateMultipartUploadResult();

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void b(String str, String str2, String str3) {
            if (e("InitiateMultipartUploadResult")) {
                if (str2.equals("Bucket")) {
                    this.f16197c.setBucketName(d());
                } else if (str2.equals("Key")) {
                    this.f16197c.setKey(d());
                } else if (str2.equals("UploadId")) {
                    this.f16197c.b(d());
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void c(String str, String str2, String str3, Attributes attributes) {
        }

        public InitiateMultipartUploadResult f() {
            return this.f16197c;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class ListAllMyBucketsHandler extends AbstractHandler {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<Bucket> f16198c = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Owner f16199d = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Bucket f16200f = null;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void b(String str, String str2, String str3) {
            if (e("ListAllMyBucketsResult", "Owner")) {
                if (str2.equals("ID")) {
                    this.f16199d.setId(d());
                    return;
                } else {
                    if (str2.equals("DisplayName")) {
                        this.f16199d.setDisplayName(d());
                        return;
                    }
                    return;
                }
            }
            if (e("ListAllMyBucketsResult", "Buckets")) {
                if (str2.equals("Bucket")) {
                    this.f16198c.add(this.f16200f);
                    this.f16200f = null;
                    return;
                }
                return;
            }
            if (e("ListAllMyBucketsResult", "Buckets", "Bucket")) {
                if (str2.equals("Name")) {
                    this.f16200f.setName(d());
                } else if (str2.equals("CreationDate")) {
                    this.f16200f.setCreationDate(DateUtils.h(d()));
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void c(String str, String str2, String str3, Attributes attributes) {
            if (e("ListAllMyBucketsResult")) {
                if (str2.equals("Owner")) {
                    this.f16199d = new Owner();
                }
            } else if (e("ListAllMyBucketsResult", "Buckets") && str2.equals("Bucket")) {
                Bucket bucket = new Bucket();
                this.f16200f = bucket;
                bucket.setOwner(this.f16199d);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class ListBucketAnalyticsConfigurationHandler extends AbstractHandler {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ListBucketAnalyticsConfigurationsResult f16201c = new ListBucketAnalyticsConfigurationsResult();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public AnalyticsConfiguration f16202d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public AnalyticsFilter f16203f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List<AnalyticsFilterPredicate> f16204g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public StorageClassAnalysis f16205h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public StorageClassAnalysisDataExport f16206i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public AnalyticsExportDestination f16207j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public AnalyticsS3BucketDestination f16208k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f16209l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f16210m;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void b(String str, String str2, String str3) {
            if (e("ListBucketAnalyticsConfigurationsResult")) {
                if (str2.equals("AnalyticsConfiguration")) {
                    if (this.f16201c.getAnalyticsConfigurationList() == null) {
                        this.f16201c.setAnalyticsConfigurationList(new ArrayList());
                    }
                    this.f16201c.getAnalyticsConfigurationList().add(this.f16202d);
                    this.f16202d = null;
                    return;
                }
                if (str2.equals("IsTruncated")) {
                    this.f16201c.setTruncated("true".equals(d()));
                    return;
                } else if (str2.equals("ContinuationToken")) {
                    this.f16201c.setContinuationToken(d());
                    return;
                } else {
                    if (str2.equals("NextContinuationToken")) {
                        this.f16201c.setNextContinuationToken(d());
                        return;
                    }
                    return;
                }
            }
            if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration")) {
                if (str2.equals("Id")) {
                    this.f16202d.setId(d());
                    return;
                } else if (str2.equals("Filter")) {
                    this.f16202d.setFilter(this.f16203f);
                    return;
                } else {
                    if (str2.equals("StorageClassAnalysis")) {
                        this.f16202d.setStorageClassAnalysis(this.f16205h);
                        return;
                    }
                    return;
                }
            }
            if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "Filter")) {
                if (str2.equals("Prefix")) {
                    this.f16203f.setPredicate(new AnalyticsPrefixPredicate(d()));
                    return;
                }
                if (str2.equals("Tag")) {
                    this.f16203f.setPredicate(new AnalyticsTagPredicate(new Tag(this.f16209l, this.f16210m)));
                    this.f16209l = null;
                    this.f16210m = null;
                    return;
                } else {
                    if (str2.equals("And")) {
                        this.f16203f.setPredicate(new AnalyticsAndOperator(this.f16204g));
                        this.f16204g = null;
                        return;
                    }
                    return;
                }
            }
            if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "Filter", "Tag")) {
                if (str2.equals("Key")) {
                    this.f16209l = d();
                    return;
                } else {
                    if (str2.equals("Value")) {
                        this.f16210m = d();
                        return;
                    }
                    return;
                }
            }
            if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "Filter", "And")) {
                if (str2.equals("Prefix")) {
                    this.f16204g.add(new AnalyticsPrefixPredicate(d()));
                    return;
                } else {
                    if (str2.equals("Tag")) {
                        this.f16204g.add(new AnalyticsTagPredicate(new Tag(this.f16209l, this.f16210m)));
                        this.f16209l = null;
                        this.f16210m = null;
                        return;
                    }
                    return;
                }
            }
            if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "Filter", "And", "Tag")) {
                if (str2.equals("Key")) {
                    this.f16209l = d();
                    return;
                } else {
                    if (str2.equals("Value")) {
                        this.f16210m = d();
                        return;
                    }
                    return;
                }
            }
            if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis")) {
                if (str2.equals("DataExport")) {
                    this.f16205h.setDataExport(this.f16206i);
                    return;
                }
                return;
            }
            if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport")) {
                if (str2.equals("OutputSchemaVersion")) {
                    this.f16206i.setOutputSchemaVersion(d());
                    return;
                } else {
                    if (str2.equals("Destination")) {
                        this.f16206i.setDestination(this.f16207j);
                        return;
                    }
                    return;
                }
            }
            if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination")) {
                if (str2.equals("S3BucketDestination")) {
                    this.f16207j.setS3BucketDestination(this.f16208k);
                }
            } else if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination", "S3BucketDestination")) {
                if (str2.equals("Format")) {
                    this.f16208k.setFormat(d());
                    return;
                }
                if (str2.equals("BucketAccountId")) {
                    this.f16208k.setBucketAccountId(d());
                } else if (str2.equals("Bucket")) {
                    this.f16208k.setBucketArn(d());
                } else if (str2.equals("Prefix")) {
                    this.f16208k.setPrefix(d());
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void c(String str, String str2, String str3, Attributes attributes) {
            if (e("ListBucketAnalyticsConfigurationsResult")) {
                if (str2.equals("AnalyticsConfiguration")) {
                    this.f16202d = new AnalyticsConfiguration();
                    return;
                }
                return;
            }
            if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration")) {
                if (str2.equals("Filter")) {
                    this.f16203f = new AnalyticsFilter();
                    return;
                } else {
                    if (str2.equals("StorageClassAnalysis")) {
                        this.f16205h = new StorageClassAnalysis();
                        return;
                    }
                    return;
                }
            }
            if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "Filter")) {
                if (str2.equals("And")) {
                    this.f16204g = new ArrayList();
                }
            } else if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis")) {
                if (str2.equals("DataExport")) {
                    this.f16206i = new StorageClassAnalysisDataExport();
                }
            } else if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport")) {
                if (str2.equals("Destination")) {
                    this.f16207j = new AnalyticsExportDestination();
                }
            } else if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination") && str2.equals("S3BucketDestination")) {
                this.f16208k = new AnalyticsS3BucketDestination();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class ListBucketHandler extends AbstractHandler {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ObjectListing f16211c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f16212d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public S3ObjectSummary f16213f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Owner f16214g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f16215h;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void b(String str, String str2, String str3) {
            String strA = null;
            if (a()) {
                if (str2.equals("ListBucketResult") && this.f16211c.isTruncated() && this.f16211c.getNextMarker() == null) {
                    if (!this.f16211c.getObjectSummaries().isEmpty()) {
                        strA = this.f16211c.getObjectSummaries().get(this.f16211c.getObjectSummaries().size() - 1).a();
                    } else if (this.f16211c.getCommonPrefixes().isEmpty()) {
                        XmlResponsesSaxParser.f16121c.f("S3 response indicates truncated results, but contains no object summaries or common prefixes.");
                    } else {
                        strA = this.f16211c.getCommonPrefixes().get(this.f16211c.getCommonPrefixes().size() - 1);
                    }
                    this.f16211c.setNextMarker(strA);
                    return;
                }
                return;
            }
            if (!e("ListBucketResult")) {
                if (!e("ListBucketResult", "Contents")) {
                    if (!e("ListBucketResult", "Contents", "Owner")) {
                        if (e("ListBucketResult", "CommonPrefixes") && str2.equals("Prefix")) {
                            this.f16211c.getCommonPrefixes().add(XmlResponsesSaxParser.h(d(), this.f16212d));
                            return;
                        }
                        return;
                    }
                    if (str2.equals("ID")) {
                        this.f16214g.setId(d());
                        return;
                    } else {
                        if (str2.equals("DisplayName")) {
                            this.f16214g.setDisplayName(d());
                            return;
                        }
                        return;
                    }
                }
                if (str2.equals("Key")) {
                    String strD = d();
                    this.f16215h = strD;
                    this.f16213f.d(XmlResponsesSaxParser.h(strD, this.f16212d));
                    return;
                }
                if (str2.equals("LastModified")) {
                    this.f16213f.e(ServiceUtils.d(d()));
                    return;
                }
                if (str2.equals("ETag")) {
                    this.f16213f.c(ServiceUtils.f(d()));
                    return;
                }
                if (str2.equals("Size")) {
                    this.f16213f.g(XmlResponsesSaxParser.m(d()));
                    return;
                }
                if (str2.equals(CreateBucketRequest.TAB_STORAGECLASS)) {
                    this.f16213f.h(d());
                    return;
                } else {
                    if (str2.equals("Owner")) {
                        this.f16213f.f(this.f16214g);
                        this.f16214g = null;
                        return;
                    }
                    return;
                }
            }
            if (str2.equals("Name")) {
                this.f16211c.setBucketName(d());
                if (XmlResponsesSaxParser.f16121c.b()) {
                    XmlResponsesSaxParser.f16121c.a("Examining listing for bucket: " + this.f16211c.getBucketName());
                    return;
                }
                return;
            }
            if (str2.equals("Prefix")) {
                this.f16211c.setPrefix(XmlResponsesSaxParser.h(XmlResponsesSaxParser.g(d()), this.f16212d));
                return;
            }
            if (str2.equals("Marker")) {
                this.f16211c.setMarker(XmlResponsesSaxParser.h(XmlResponsesSaxParser.g(d()), this.f16212d));
                return;
            }
            if (str2.equals("NextMarker")) {
                this.f16211c.setNextMarker(XmlResponsesSaxParser.h(d(), this.f16212d));
                return;
            }
            if (str2.equals("MaxKeys")) {
                this.f16211c.setMaxKeys(XmlResponsesSaxParser.l(d()));
                return;
            }
            if (str2.equals("Delimiter")) {
                this.f16211c.setDelimiter(XmlResponsesSaxParser.h(XmlResponsesSaxParser.g(d()), this.f16212d));
                return;
            }
            if (str2.equals("EncodingType")) {
                this.f16211c.setEncodingType(XmlResponsesSaxParser.g(d()));
                return;
            }
            if (!str2.equals("IsTruncated")) {
                if (str2.equals("Contents")) {
                    this.f16211c.getObjectSummaries().add(this.f16213f);
                    this.f16213f = null;
                    return;
                }
                return;
            }
            String strB = StringUtils.b(d());
            if (strB.startsWith("false")) {
                this.f16211c.setTruncated(false);
            } else {
                if (strB.startsWith("true")) {
                    this.f16211c.setTruncated(true);
                    return;
                }
                throw new IllegalStateException("Invalid value for IsTruncated field: " + strB);
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void c(String str, String str2, String str3, Attributes attributes) {
            if (!e("ListBucketResult")) {
                if (e("ListBucketResult", "Contents") && str2.equals("Owner")) {
                    this.f16214g = new Owner();
                    return;
                }
                return;
            }
            if (str2.equals("Contents")) {
                S3ObjectSummary s3ObjectSummary = new S3ObjectSummary();
                this.f16213f = s3ObjectSummary;
                s3ObjectSummary.b(this.f16211c.getBucketName());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class ListBucketInventoryConfigurationsHandler extends AbstractHandler {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ListBucketInventoryConfigurationsResult f16216c = new ListBucketInventoryConfigurationsResult();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public InventoryConfiguration f16217d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<String> f16218f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public InventoryDestination f16219g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public InventoryFilter f16220h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public InventoryS3BucketDestination f16221i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public InventorySchedule f16222j;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void b(String str, String str2, String str3) {
            if (e("ListInventoryConfigurationsResult")) {
                if (str2.equals("InventoryConfiguration")) {
                    if (this.f16216c.getInventoryConfigurationList() == null) {
                        this.f16216c.setInventoryConfigurationList(new ArrayList());
                    }
                    this.f16216c.getInventoryConfigurationList().add(this.f16217d);
                    this.f16217d = null;
                    return;
                }
                if (str2.equals("IsTruncated")) {
                    this.f16216c.setTruncated("true".equals(d()));
                    return;
                } else if (str2.equals("ContinuationToken")) {
                    this.f16216c.setContinuationToken(d());
                    return;
                } else {
                    if (str2.equals("NextContinuationToken")) {
                        this.f16216c.setNextContinuationToken(d());
                        return;
                    }
                    return;
                }
            }
            if (e("ListInventoryConfigurationsResult", "InventoryConfiguration")) {
                if (str2.equals("Id")) {
                    this.f16217d.setId(d());
                    return;
                }
                if (str2.equals("Destination")) {
                    this.f16217d.setDestination(this.f16219g);
                    this.f16219g = null;
                    return;
                }
                if (str2.equals("IsEnabled")) {
                    this.f16217d.setEnabled(Boolean.valueOf("true".equals(d())));
                    return;
                }
                if (str2.equals("Filter")) {
                    this.f16217d.setInventoryFilter(this.f16220h);
                    this.f16220h = null;
                    return;
                }
                if (str2.equals("IncludedObjectVersions")) {
                    this.f16217d.setIncludedObjectVersions(d());
                    return;
                }
                if (str2.equals("Schedule")) {
                    this.f16217d.setSchedule(this.f16222j);
                    this.f16222j = null;
                    return;
                } else {
                    if (str2.equals("OptionalFields")) {
                        this.f16217d.setOptionalFields(this.f16218f);
                        this.f16218f = null;
                        return;
                    }
                    return;
                }
            }
            if (e("ListInventoryConfigurationsResult", "InventoryConfiguration", "Destination")) {
                if (str2.equals("S3BucketDestination")) {
                    this.f16219g.setS3BucketDestination(this.f16221i);
                    this.f16221i = null;
                    return;
                }
                return;
            }
            if (e("ListInventoryConfigurationsResult", "InventoryConfiguration", "Destination", "S3BucketDestination")) {
                if (str2.equals("AccountId")) {
                    this.f16221i.setAccountId(d());
                    return;
                }
                if (str2.equals("Bucket")) {
                    this.f16221i.setBucketArn(d());
                    return;
                } else if (str2.equals("Format")) {
                    this.f16221i.setFormat(d());
                    return;
                } else {
                    if (str2.equals("Prefix")) {
                        this.f16221i.setPrefix(d());
                        return;
                    }
                    return;
                }
            }
            if (e("ListInventoryConfigurationsResult", "InventoryConfiguration", "Filter")) {
                if (str2.equals("Prefix")) {
                    this.f16220h.setPredicate(new InventoryPrefixPredicate(d()));
                }
            } else if (e("ListInventoryConfigurationsResult", "InventoryConfiguration", "Schedule")) {
                if (str2.equals("Frequency")) {
                    this.f16222j.setFrequency(d());
                }
            } else if (e("ListInventoryConfigurationsResult", "InventoryConfiguration", "OptionalFields") && str2.equals("Field")) {
                this.f16218f.add(d());
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void c(String str, String str2, String str3, Attributes attributes) {
            if (e("ListInventoryConfigurationsResult")) {
                if (str2.equals("InventoryConfiguration")) {
                    this.f16217d = new InventoryConfiguration();
                    return;
                }
                return;
            }
            if (!e("ListInventoryConfigurationsResult", "InventoryConfiguration")) {
                if (e("ListInventoryConfigurationsResult", "InventoryConfiguration", "Destination") && str2.equals("S3BucketDestination")) {
                    this.f16221i = new InventoryS3BucketDestination();
                    return;
                }
                return;
            }
            if (str2.equals("Destination")) {
                this.f16219g = new InventoryDestination();
                return;
            }
            if (str2.equals("Filter")) {
                this.f16220h = new InventoryFilter();
            } else if (str2.equals("Schedule")) {
                this.f16222j = new InventorySchedule();
            } else if (str2.equals("OptionalFields")) {
                this.f16218f = new ArrayList();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class ListBucketMetricsConfigurationsHandler extends AbstractHandler {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ListBucketMetricsConfigurationsResult f16223c = new ListBucketMetricsConfigurationsResult();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public MetricsConfiguration f16224d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public MetricsFilter f16225f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List<MetricsFilterPredicate> f16226g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f16227h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f16228i;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void b(String str, String str2, String str3) {
            if (e("ListMetricsConfigurationsResult")) {
                if (str2.equals("MetricsConfiguration")) {
                    if (this.f16223c.getMetricsConfigurationList() == null) {
                        this.f16223c.setMetricsConfigurationList(new ArrayList());
                    }
                    this.f16223c.getMetricsConfigurationList().add(this.f16224d);
                    this.f16224d = null;
                    return;
                }
                if (str2.equals("IsTruncated")) {
                    this.f16223c.setTruncated("true".equals(d()));
                    return;
                } else if (str2.equals("ContinuationToken")) {
                    this.f16223c.setContinuationToken(d());
                    return;
                } else {
                    if (str2.equals("NextContinuationToken")) {
                        this.f16223c.setNextContinuationToken(d());
                        return;
                    }
                    return;
                }
            }
            if (e("ListMetricsConfigurationsResult", "MetricsConfiguration")) {
                if (str2.equals("Id")) {
                    this.f16224d.setId(d());
                    return;
                } else {
                    if (str2.equals("Filter")) {
                        this.f16224d.setFilter(this.f16225f);
                        this.f16225f = null;
                        return;
                    }
                    return;
                }
            }
            if (e("ListMetricsConfigurationsResult", "MetricsConfiguration", "Filter")) {
                if (str2.equals("Prefix")) {
                    this.f16225f.setPredicate(new MetricsPrefixPredicate(d()));
                    return;
                }
                if (str2.equals("Tag")) {
                    this.f16225f.setPredicate(new MetricsTagPredicate(new Tag(this.f16227h, this.f16228i)));
                    this.f16227h = null;
                    this.f16228i = null;
                    return;
                } else {
                    if (str2.equals("And")) {
                        this.f16225f.setPredicate(new MetricsAndOperator(this.f16226g));
                        this.f16226g = null;
                        return;
                    }
                    return;
                }
            }
            if (e("ListMetricsConfigurationsResult", "MetricsConfiguration", "Filter", "Tag")) {
                if (str2.equals("Key")) {
                    this.f16227h = d();
                    return;
                } else {
                    if (str2.equals("Value")) {
                        this.f16228i = d();
                        return;
                    }
                    return;
                }
            }
            if (e("ListMetricsConfigurationsResult", "MetricsConfiguration", "Filter", "And")) {
                if (str2.equals("Prefix")) {
                    this.f16226g.add(new MetricsPrefixPredicate(d()));
                    return;
                } else {
                    if (str2.equals("Tag")) {
                        this.f16226g.add(new MetricsTagPredicate(new Tag(this.f16227h, this.f16228i)));
                        this.f16227h = null;
                        this.f16228i = null;
                        return;
                    }
                    return;
                }
            }
            if (e("ListMetricsConfigurationsResult", "MetricsConfiguration", "Filter", "And", "Tag")) {
                if (str2.equals("Key")) {
                    this.f16227h = d();
                } else if (str2.equals("Value")) {
                    this.f16228i = d();
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void c(String str, String str2, String str3, Attributes attributes) {
            if (e("ListMetricsConfigurationsResult")) {
                if (str2.equals("MetricsConfiguration")) {
                    this.f16224d = new MetricsConfiguration();
                }
            } else if (e("ListMetricsConfigurationsResult", "MetricsConfiguration")) {
                if (str2.equals("Filter")) {
                    this.f16225f = new MetricsFilter();
                }
            } else if (e("ListMetricsConfigurationsResult", "MetricsConfiguration", "Filter") && str2.equals("And")) {
                this.f16226g = new ArrayList();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class ListMultipartUploadsHandler extends AbstractHandler {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final MultipartUploadListing f16229c = new MultipartUploadListing();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public MultipartUpload f16230d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Owner f16231f;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void b(String str, String str2, String str3) {
            if (e("ListMultipartUploadsResult")) {
                if (str2.equals("Bucket")) {
                    this.f16229c.c(d());
                    return;
                }
                if (str2.equals("KeyMarker")) {
                    this.f16229c.f(XmlResponsesSaxParser.g(d()));
                    return;
                }
                if (str2.equals("Delimiter")) {
                    this.f16229c.d(XmlResponsesSaxParser.g(d()));
                    return;
                }
                if (str2.equals("Prefix")) {
                    this.f16229c.j(XmlResponsesSaxParser.g(d()));
                    return;
                }
                if (str2.equals("UploadIdMarker")) {
                    this.f16229c.l(XmlResponsesSaxParser.g(d()));
                    return;
                }
                if (str2.equals("NextKeyMarker")) {
                    this.f16229c.h(XmlResponsesSaxParser.g(d()));
                    return;
                }
                if (str2.equals("NextUploadIdMarker")) {
                    this.f16229c.i(XmlResponsesSaxParser.g(d()));
                    return;
                }
                if (str2.equals("MaxUploads")) {
                    this.f16229c.g(Integer.parseInt(d()));
                    return;
                }
                if (str2.equals("EncodingType")) {
                    this.f16229c.e(XmlResponsesSaxParser.g(d()));
                    return;
                }
                if (str2.equals("IsTruncated")) {
                    this.f16229c.k(Boolean.parseBoolean(d()));
                    return;
                } else {
                    if (str2.equals("Upload")) {
                        this.f16229c.b().add(this.f16230d);
                        this.f16230d = null;
                        return;
                    }
                    return;
                }
            }
            if (e("ListMultipartUploadsResult", "CommonPrefixes")) {
                if (str2.equals("Prefix")) {
                    this.f16229c.a().add(d());
                    return;
                }
                return;
            }
            if (!e("ListMultipartUploadsResult", "Upload")) {
                if (e("ListMultipartUploadsResult", "Upload", "Owner") || e("ListMultipartUploadsResult", "Upload", "Initiator")) {
                    if (str2.equals("ID")) {
                        this.f16231f.setId(XmlResponsesSaxParser.g(d()));
                        return;
                    } else {
                        if (str2.equals("DisplayName")) {
                            this.f16231f.setDisplayName(XmlResponsesSaxParser.g(d()));
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (str2.equals("Key")) {
                this.f16230d.c(d());
                return;
            }
            if (str2.equals("UploadId")) {
                this.f16230d.f(d());
                return;
            }
            if (str2.equals("Owner")) {
                this.f16230d.d(this.f16231f);
                this.f16231f = null;
            } else if (str2.equals("Initiator")) {
                this.f16230d.b(this.f16231f);
                this.f16231f = null;
            } else if (str2.equals(CreateBucketRequest.TAB_STORAGECLASS)) {
                this.f16230d.e(d());
            } else if (str2.equals("Initiated")) {
                this.f16230d.a(ServiceUtils.d(d()));
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void c(String str, String str2, String str3, Attributes attributes) {
            if (e("ListMultipartUploadsResult")) {
                if (str2.equals("Upload")) {
                    this.f16230d = new MultipartUpload();
                }
            } else if (e("ListMultipartUploadsResult", "Upload")) {
                if (str2.equals("Owner") || str2.equals("Initiator")) {
                    this.f16231f = new Owner();
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class ListObjectsV2Handler extends AbstractHandler {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f16232c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public S3ObjectSummary f16233d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Owner f16234f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f16235g;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void b(String str, String str2, String str3) {
            if (a()) {
                if (str2.equals("ListBucketResult")) {
                    throw null;
                }
                return;
            }
            if (!e("ListBucketResult")) {
                if (!e("ListBucketResult", "Contents")) {
                    if (!e("ListBucketResult", "Contents", "Owner")) {
                        if (e("ListBucketResult", "CommonPrefixes") && str2.equals("Prefix")) {
                            throw null;
                        }
                        return;
                    } else if (str2.equals("ID")) {
                        this.f16234f.setId(d());
                        return;
                    } else {
                        if (str2.equals("DisplayName")) {
                            this.f16234f.setDisplayName(d());
                            return;
                        }
                        return;
                    }
                }
                if (str2.equals("Key")) {
                    String strD = d();
                    this.f16235g = strD;
                    this.f16233d.d(XmlResponsesSaxParser.h(strD, this.f16232c));
                    return;
                }
                if (str2.equals("LastModified")) {
                    this.f16233d.e(ServiceUtils.d(d()));
                    return;
                }
                if (str2.equals("ETag")) {
                    this.f16233d.c(ServiceUtils.f(d()));
                    return;
                }
                if (str2.equals("Size")) {
                    this.f16233d.g(XmlResponsesSaxParser.m(d()));
                    return;
                }
                if (str2.equals(CreateBucketRequest.TAB_STORAGECLASS)) {
                    this.f16233d.h(d());
                    return;
                } else {
                    if (str2.equals("Owner")) {
                        this.f16233d.f(this.f16234f);
                        this.f16234f = null;
                        return;
                    }
                    return;
                }
            }
            if (str2.equals("Name")) {
                d();
                throw null;
            }
            if (str2.equals("Prefix")) {
                XmlResponsesSaxParser.h(XmlResponsesSaxParser.g(d()), this.f16232c);
                throw null;
            }
            if (str2.equals("MaxKeys")) {
                XmlResponsesSaxParser.l(d());
                throw null;
            }
            if (str2.equals("NextContinuationToken")) {
                d();
                throw null;
            }
            if (str2.equals("ContinuationToken")) {
                d();
                throw null;
            }
            if (str2.equals("StartAfter")) {
                XmlResponsesSaxParser.h(d(), this.f16232c);
                throw null;
            }
            if (str2.equals("KeyCount")) {
                XmlResponsesSaxParser.l(d());
                throw null;
            }
            if (str2.equals("Delimiter")) {
                XmlResponsesSaxParser.h(XmlResponsesSaxParser.g(d()), this.f16232c);
                throw null;
            }
            if (str2.equals("EncodingType")) {
                XmlResponsesSaxParser.g(d());
                throw null;
            }
            if (!str2.equals("IsTruncated")) {
                if (str2.equals("Contents")) {
                    throw null;
                }
                return;
            }
            String strB = StringUtils.b(d());
            if (strB.startsWith("false") || strB.startsWith("true")) {
                throw null;
            }
            throw new IllegalStateException("Invalid value for IsTruncated field: " + strB);
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void c(String str, String str2, String str3, Attributes attributes) {
            if (e("ListBucketResult")) {
                if (str2.equals("Contents")) {
                    this.f16233d = new S3ObjectSummary();
                    throw null;
                }
            } else if (e("ListBucketResult", "Contents") && str2.equals("Owner")) {
                this.f16234f = new Owner();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class ListPartsHandler extends AbstractHandler {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final PartListing f16236c = new PartListing();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public PartSummary f16237d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Owner f16238f;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void b(String str, String str2, String str3) {
            if (!e("ListPartsResult")) {
                if (!e("ListPartsResult", "Part")) {
                    if (e("ListPartsResult", "Owner") || e("ListPartsResult", "Initiator")) {
                        if (str2.equals("ID")) {
                            this.f16238f.setId(XmlResponsesSaxParser.g(d()));
                            return;
                        } else {
                            if (str2.equals("DisplayName")) {
                                this.f16238f.setDisplayName(XmlResponsesSaxParser.g(d()));
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                if (str2.equals("PartNumber")) {
                    this.f16237d.c(Integer.parseInt(d()));
                    return;
                }
                if (str2.equals("LastModified")) {
                    this.f16237d.b(ServiceUtils.d(d()));
                    return;
                } else if (str2.equals("ETag")) {
                    this.f16237d.a(ServiceUtils.f(d()));
                    return;
                } else {
                    if (str2.equals("Size")) {
                        this.f16237d.d(Long.parseLong(d()));
                        return;
                    }
                    return;
                }
            }
            if (str2.equals("Bucket")) {
                this.f16236c.b(d());
                return;
            }
            if (str2.equals("Key")) {
                this.f16236c.e(d());
                return;
            }
            if (str2.equals("UploadId")) {
                this.f16236c.l(d());
                return;
            }
            if (str2.equals("Owner")) {
                this.f16236c.h(this.f16238f);
                this.f16238f = null;
                return;
            }
            if (str2.equals("Initiator")) {
                this.f16236c.d(this.f16238f);
                this.f16238f = null;
                return;
            }
            if (str2.equals(CreateBucketRequest.TAB_STORAGECLASS)) {
                this.f16236c.j(d());
                return;
            }
            if (str2.equals("PartNumberMarker")) {
                this.f16236c.i(f(d()).intValue());
                return;
            }
            if (str2.equals("NextPartNumberMarker")) {
                this.f16236c.g(f(d()).intValue());
                return;
            }
            if (str2.equals("MaxParts")) {
                this.f16236c.f(f(d()).intValue());
                return;
            }
            if (str2.equals("EncodingType")) {
                this.f16236c.c(XmlResponsesSaxParser.g(d()));
                return;
            }
            if (str2.equals("IsTruncated")) {
                this.f16236c.k(Boolean.parseBoolean(d()));
            } else if (str2.equals("Part")) {
                this.f16236c.a().add(this.f16237d);
                this.f16237d = null;
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void c(String str, String str2, String str3, Attributes attributes) {
            if (e("ListPartsResult")) {
                if (str2.equals("Part")) {
                    this.f16237d = new PartSummary();
                } else if (str2.equals("Owner") || str2.equals("Initiator")) {
                    this.f16238f = new Owner();
                }
            }
        }

        public final Integer f(String str) {
            String strG = XmlResponsesSaxParser.g(d());
            if (strG == null) {
                return null;
            }
            return Integer.valueOf(Integer.parseInt(strG));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class ListVersionsHandler extends AbstractHandler {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f16239c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public S3VersionSummary f16240d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Owner f16241f;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void b(String str, String str2, String str3) {
            if (e("ListVersionsResult")) {
                if (str2.equals("Name")) {
                    d();
                    throw null;
                }
                if (str2.equals("Prefix")) {
                    XmlResponsesSaxParser.h(XmlResponsesSaxParser.g(d()), this.f16239c);
                    throw null;
                }
                if (str2.equals("KeyMarker")) {
                    XmlResponsesSaxParser.h(XmlResponsesSaxParser.g(d()), this.f16239c);
                    throw null;
                }
                if (str2.equals("VersionIdMarker")) {
                    XmlResponsesSaxParser.g(d());
                    throw null;
                }
                if (str2.equals("MaxKeys")) {
                    Integer.parseInt(d());
                    throw null;
                }
                if (str2.equals("Delimiter")) {
                    XmlResponsesSaxParser.h(XmlResponsesSaxParser.g(d()), this.f16239c);
                    throw null;
                }
                if (str2.equals("EncodingType")) {
                    XmlResponsesSaxParser.g(d());
                    throw null;
                }
                if (str2.equals("NextKeyMarker")) {
                    XmlResponsesSaxParser.h(XmlResponsesSaxParser.g(d()), this.f16239c);
                    throw null;
                }
                if (str2.equals("NextVersionIdMarker")) {
                    d();
                    throw null;
                }
                if (str2.equals("IsTruncated")) {
                    "true".equals(d());
                    throw null;
                }
                if (str2.equals("Version") || str2.equals("DeleteMarker")) {
                    throw null;
                }
                return;
            }
            if (e("ListVersionsResult", "CommonPrefixes")) {
                if (str2.equals("Prefix")) {
                    XmlResponsesSaxParser.g(d());
                    throw null;
                }
                return;
            }
            if (!e("ListVersionsResult", "Version") && !e("ListVersionsResult", "DeleteMarker")) {
                if (e("ListVersionsResult", "Version", "Owner") || e("ListVersionsResult", "DeleteMarker", "Owner")) {
                    if (str2.equals("ID")) {
                        this.f16241f.setId(d());
                        return;
                    } else {
                        if (str2.equals("DisplayName")) {
                            this.f16241f.setDisplayName(d());
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (str2.equals("Key")) {
                this.f16240d.c(XmlResponsesSaxParser.h(d(), this.f16239c));
                return;
            }
            if (str2.equals("VersionId")) {
                this.f16240d.h(d());
                return;
            }
            if (str2.equals("IsLatest")) {
                this.f16240d.b("true".equals(d()));
                return;
            }
            if (str2.equals("LastModified")) {
                this.f16240d.d(ServiceUtils.d(d()));
                return;
            }
            if (str2.equals("ETag")) {
                this.f16240d.a(ServiceUtils.f(d()));
                return;
            }
            if (str2.equals("Size")) {
                this.f16240d.f(Long.parseLong(d()));
                return;
            }
            if (str2.equals("Owner")) {
                this.f16240d.e(this.f16241f);
                this.f16241f = null;
            } else if (str2.equals(CreateBucketRequest.TAB_STORAGECLASS)) {
                this.f16240d.g(d());
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void c(String str, String str2, String str3, Attributes attributes) {
            if (!e("ListVersionsResult")) {
                if ((e("ListVersionsResult", "Version") || e("ListVersionsResult", "DeleteMarker")) && str2.equals("Owner")) {
                    this.f16241f = new Owner();
                    return;
                }
                return;
            }
            if (str2.equals("Version")) {
                this.f16240d = new S3VersionSummary();
                throw null;
            }
            if (str2.equals("DeleteMarker")) {
                this.f16240d = new S3VersionSummary();
                throw null;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class RequestPaymentConfigurationHandler extends AbstractHandler {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f16242c = null;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void b(String str, String str2, String str3) {
            if (e("RequestPaymentConfiguration") && str2.equals("Payer")) {
                this.f16242c = d();
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void c(String str, String str2, String str3, Attributes attributes) {
        }
    }

    public XmlResponsesSaxParser() throws AmazonClientException {
        this.f16122a = null;
        try {
            this.f16122a = XMLReaderFactory.createXMLReader();
        } catch (SAXException e11) {
            System.setProperty("org.xml.sax.driver", "org.xmlpull.v1.sax2.Driver");
            try {
                this.f16122a = XMLReaderFactory.createXMLReader();
            } catch (SAXException unused) {
                throw new AmazonClientException("Couldn't initialize a sax driver for the XMLReader", e11);
            }
        }
    }

    public static String g(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return str;
    }

    public static String h(String str, boolean z11) {
        return z11 ? S3HttpUtils.a(str) : str;
    }

    public static String i(String str, Attributes attributes) {
        if (!StringUtils.a(str) && attributes != null) {
            for (int i11 = 0; i11 < attributes.getLength(); i11++) {
                if (attributes.getQName(i11).trim().equalsIgnoreCase(str.trim())) {
                    return attributes.getValue(i11);
                }
            }
        }
        return null;
    }

    public static int l(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e11) {
            f16121c.e("Unable to parse integer value '" + str + "'", e11);
            return -1;
        }
    }

    public static long m(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e11) {
            f16121c.e("Unable to parse long value '" + str + "'", e11);
            return -1L;
        }
    }

    public CompleteMultipartUploadHandler j(InputStream inputStream) throws IOException {
        CompleteMultipartUploadHandler completeMultipartUploadHandler = new CompleteMultipartUploadHandler();
        n(completeMultipartUploadHandler, inputStream);
        return completeMultipartUploadHandler;
    }

    public InitiateMultipartUploadHandler k(InputStream inputStream) throws IOException {
        InitiateMultipartUploadHandler initiateMultipartUploadHandler = new InitiateMultipartUploadHandler();
        n(initiateMultipartUploadHandler, inputStream);
        return initiateMultipartUploadHandler;
    }

    public void n(DefaultHandler defaultHandler, InputStream inputStream) throws IOException {
        try {
            Log log = f16121c;
            if (log.b()) {
                log.a("Parsing XML response document with handler: " + defaultHandler.getClass());
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            this.f16122a.setContentHandler(defaultHandler);
            this.f16122a.setErrorHandler(defaultHandler);
            this.f16122a.parse(new InputSource(bufferedReader));
        } catch (IOException e11) {
            throw e11;
        } catch (Throwable th2) {
            try {
                inputStream.close();
            } catch (IOException e12) {
                if (f16121c.h()) {
                    f16121c.e("Unable to close response InputStream up after XML parse failure", e12);
                }
            }
            throw new AmazonClientException("Failed to parse XML document with handler " + defaultHandler.getClass(), th2);
        }
    }
}
