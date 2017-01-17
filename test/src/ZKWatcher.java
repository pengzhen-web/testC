import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;

import sun.font.LayoutPathImpl.EndType;


public class ZKWatcher implements Watcher {

	@Override
	public void process(WatchedEvent event) {
		if(event.getType() == EventType.NodeDeleted){
			System.out.println("node delete");
		}
		if(event.getType() == EventType.NodeCreated){
			System.out.println("node create");
		}
		if(event.getType() == EventType.NodeChildrenChanged){
			System.out.println("node childrenChanged");
		}
		if(event.getType() == EventType.NodeDataChanged){
			System.out.println("node dataChanged");
		}
	}

}
