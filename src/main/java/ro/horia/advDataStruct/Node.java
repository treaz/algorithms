package ro.horia.advDataStruct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node {

	List<String> keys = new ArrayList<>();
	Node[] children;
	boolean leaf = false;
	int size;
	@Override
	public String toString() {
		return "Node [keys=" + keys + ", children=" + Arrays.toString(children)
				+ ", leaf=" + leaf + ", size=" + size + "]";
	}
}
