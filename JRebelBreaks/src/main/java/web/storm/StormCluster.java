package web.storm;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import backtype.storm.Config;
import backtype.storm.ILocalCluster;
import backtype.storm.LocalCluster;
import backtype.storm.Testing;
import backtype.storm.generated.StormTopology;
import backtype.storm.testing.MkClusterParam;

@Component
public class StormCluster {
  private static final Logger _logger = LoggerFactory.getLogger(StormCluster.class);
  
  private LocalCluster _localCluster;
  private Config conf;
  
  public StormCluster() {
    _logger.info("Creating storm local cluster");
    
    conf = new Config();
    conf.setDebug(false);  
  }
  
  @PostConstruct
  private void start() {
    new Thread(new Runnable() {

      @Override
      public void run() {
//        MkClusterParam mkClusterParam = new MkClusterParam();
//        mkClusterParam.setSupervisors(6);
//        mkClusterParam.setPortsPerSupervisor(5);
//        Config daemonConf = new Config();
//        daemonConf.put(Config.SUPERVISOR_ENABLE, true);
//        daemonConf.put(Config.TOPOLOGY_ACKER_EXECUTORS, 1);
//        Testing.withLocalCluster(mkClusterParam, new backtype.storm.testing.TestJob() {
//          @Override
//          public void run(final ILocalCluster cluster) {
//            _localCluster = (LocalCluster) cluster;
//            Thread.currentThread().interrupt();
//          }
//        });


      }
    }).start();

//    while (_localCluster == null) {
//      try {
//        Thread.sleep(1000);
//      } catch (InterruptedException e) {
//        _logger.error(e.getMessage());
//      }
//    }
  }
  
  public void submitTopology(String name, StormTopology stormTopology) {
    _logger.info("name=" + name);
    _localCluster.submitTopology(name, conf, stormTopology);
  }
  
  public void killTopology(String name) {    
    _logger.info("name=" + name);
    _localCluster.killTopology(name);
  }
  
  @PreDestroy
 public void shutdown() {
    _logger.info("Shutting down");
   _localCluster.shutdown();
 }
  

}
