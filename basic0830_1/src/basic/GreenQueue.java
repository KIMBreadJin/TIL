package basic;

import java.util.LinkedList;
import java.util.Queue;

public class GreenQueue {
	Queue q = new LinkedList<>(); // queue는 interface(부모) = linkedList(자식), 다형성(polymorphism)
	static final int MAX_SIZE =5;
	public Queue<String> getQ () {return this.q;}
	public void setQ(Queue<String> q) {this.q=q;}
	public void save(String input) {
		if(!"".equals(input)) q.offer(input);
		if(q.size()>GreenQueue.MAX_SIZE) q.remove();
	}
}
