package ftrippel.csvtable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang.StringUtils;

/**
 * 
 * @author https://github.com/ftrippel
 * 
 */
public class Table {

	List<Row> rows = new ArrayList<Row>();

	List<String> colNames = new ArrayList<String>();

	List<ObjectBuilder> objectBuilders = new ArrayList<ObjectBuilder>();

	public void addColumn(String name, ObjectBuilder builder) {
		this.colNames.add(name);
		this.objectBuilders.add(builder);
	}

	public String getName(Integer i) {
		return this.colNames.get(i);
	}

	public Integer getIndex(String name) {
		int i = this.colNames.indexOf(name);
		if (i == -1)
			throw new RuntimeException("Unknown Column: " + name);
		return i;
	}

	public ObjectBuilder getBuilder(Integer i) {
		return this.objectBuilders.get(i);
	}

	public ObjectBuilder getBuilder(String name) {
		return this.objectBuilders.get(getIndex(name));
	}

	public Row getRow(Integer i) {
		return this.rows.get(i);
	}

	public List<Row> getRows(List<Integer> is) {
		List<Row> rows = new ArrayList<Row>();
		for (Integer i : is) {
			rows.add(this.rows.get(i));
		}
		return rows;
	}

	@SuppressWarnings("unchecked")
	public List<Row> getRows() {
		return ListUtils.unmodifiableList(this.rows);
	}

	public void loadFromFile(File file, String separator, boolean skipFirst) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			int irow = -1;
			Pattern pattern = Pattern.compile(separator, Pattern.LITERAL);
			while ((line = in.readLine()) != null) {
				++irow;
				if (irow == 0 && skipFirst)
					continue;
				if (StringUtils.trimToNull(line) == null)
					continue;
				String[] tokens = pattern.split(line, -1);
				int icol = -1;
				Row row = new Row();
				for (String token : tokens) {
					++icol;
					if (icol + 1 > this.colNames.size())
						break;
					row.data.add(this.objectBuilders.get(icol).build(token));
				}
				row.names = this.colNames;
				this.rows.add(row);
			}
			in.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
