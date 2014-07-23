package ftrippel.csvtable;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author https://github.com/ftrippel
 * 
 */
public class Data {

	List<Object> data = new ArrayList<Object>();

	public Object get(Integer i) {
		return this.data.get(i);
	}

	public <T> T get(Integer i, Class<T> clazz) {
		return (T) this.data.get(i);
	}

	public void set(Integer i, Object o) {
		this.data.set(i, o);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Data {");
		for (Object val : this.data) {
			sb.append(val.toString()).append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("}");
		return sb.toString();
	}

}
