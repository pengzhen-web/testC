import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;


public class ZookeeperTest {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 * @throws KeeperException 
	 */
	public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
		// TODO Auto-generated method stub
		ZooKeeper zook = new ZooKeeper("192.168.11.139:2181", 5000, null);
		Stat stat = zook.exists("/root", false);
		if(stat == null){
			System.out.println("节点不存在");
		}else{
			System.out.println("节点存在");
		}
		//zook.create("/root", "root data".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
	}

}
