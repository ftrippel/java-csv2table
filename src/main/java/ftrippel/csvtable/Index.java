package ftrippel.csvtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author https://github.com/ftrippel
 * 
 */
public class Index {

	Map<Key, List<Integer>> index = new HashMap<Key, List<Integer>>();

	Table table;

	String[] names;

	public Index(Table t, String... names) {
		int irow = -1;
		for (Row row : t.rows) {
			++irow;
			Key key = new Key();
			for (String name : names) {
				try {
					key.add(row.get(name));
				} catch (Exception e) {
					System.out.println(row);
				}
			}
			if (this.index.containsKey(key)) {
				this.index.get(key).add(irow);
			} else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(irow);
				this.index.put(key, list);
			}
		}
		this.names = names;
		this.table = t;
	}

	public Set<Key> getKeys() {
		return this.index.keySet();
	}

	public boolean containsKey(Key key) {
		return this.index.containsKey(key);
	}

	protected Key buildKey(Object... vals) {
		Key key = new Key();
		if (this.names.length != vals.length)
			throw new IllegalArgumentException("Zu wenig Argumente");
		for (Object val : vals) {
			key.add(val);
		}
		return key;
	}

	protected Key buildKey(String... vals) {
		Key key = new Key();
		if (this.names.length != vals.length)
			throw new IllegalArgumentException("Zu wenig Argumente");
		for (int i = 0; i < vals.length; ++i) {
			key.add(this.table.getBuilder(this.names[i]).build(vals[i]));
		}
		return key;
	}

	public List<Integer> getIndex(Key key) {
		return this.index.get(key);
	}

	public List<Integer> getIndex(Object... vals) {
		return getIndex(buildKey(vals));
	}

	public List<Integer> getIndex(String... vals) {
		return getIndex(buildKey(vals));
	}

	public List<Row> getRows(Key key) {
		if (!this.index.containsKey(key))
			return null;
		return this.table.getRows(this.index.get(key));
	}

	public List<Row> getRows(Object... vals) {
		return getRows(buildKey(vals));
	}

	public List<Row> getRows(String... vals) {
		return getRows(buildKey(vals));
	}

	public Integer getFirstIndex(Key key) {
		if (!this.index.containsKey(key))
			return null;
		return index.get(key).get(0);
	}

	public Integer getFirstIndex(Object... vals) {
		return getFirstIndex(buildKey(vals));
	}

	public Integer getFirstIndex(String... vals) {
		return getFirstIndex(buildKey(vals));
	}

	public Row getFirstRow(Key key) {
		if (!this.index.containsKey(key))
			return null;
		return this.table.getRow(index.get(key).get(0));
	}

	public Row getFirstRow(Object... vals) {
		return getFirstRow(buildKey(vals));
	}

	public Row getFirstRow(String... vals) {
		return getFirstRow(buildKey(vals));
	}

}
