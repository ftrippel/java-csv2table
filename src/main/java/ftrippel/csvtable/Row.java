package ftrippel.csvtable;

import java.util.List;

/**
 * 
 * @author https://github.com/ftrippel
 * 
 */
public class Row extends Data {

	List<String> names;

	public Object get(String name) {
		return super.get(names.indexOf(name));
	}

	@SuppressWarnings("cast")
	public <T> T get(String name, Class<T> clazz) {
		return (T) super.get(names.indexOf(name), clazz);
	}

	public void set(String name, Object o) {
		super.set(names.indexOf(name), o);
	}

	@Override
	public String toString() {
		return "Row " + super.toString();
	}

}
