package org.apache.hadoop.fs.ceph;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.DelegateToFileSystem;
import org.apache.hadoop.fs.FileSystem;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Delegation of the original ceph filesystem as presented to hadoop 1.x
 * for the newer hadoop 2.x API's
 * @author Greg Bowyer
 */
public class CephHadoop2FileSystem extends DelegateToFileSystem {

  /**
   * This constructor has the signature needed by
   * {@link AbstractFileSystem#createFileSystem(URI, Configuration)}.
   *
   * @param theUri which must be that of localFs
   * @param conf
   * @throws IOException
   * @throws URISyntaxException
   */
  CephHadoop2FileSystem(final URI theUri, final Configuration conf) throws IOException,
    URISyntaxException {
    super(theUri, new CephFileSystem(), conf, "ceph", true);
  }

  @Override
  public int getUriDefaultPort() {
    return 6789;
  }
}
