package ftrippel.csvtable;

import java.io.File;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author https://github.com/ftrippel
 * 
 */
public class AppTest {

	@Test
	public void test() {
		StringObjectBuilder stringBuilder = new StringObjectBuilder();
		IntegerObjectBuilder integerBuilder = new IntegerObjectBuilder();
		DoubleObjectBuilder doubleBuilder = new DoubleObjectBuilder();
		BigDecimalObjectBuilder decimalBuilder = new BigDecimalObjectBuilder();

		Table table = new Table();
		table.addColumn("C1", stringBuilder);
		table.addColumn("C2", integerBuilder);
		table.loadFromFile(new File("data/a.csv"), ",", false);
		Index idx = new Index(table, "C1");

		Set<Key> keys = idx.getKeys();
		Assert.assertTrue(keys.contains(idx.buildKey("a")));
		Assert.assertTrue(keys.contains(idx.buildKey("b")));

		List<Row> rows;
		rows = idx.getRows(idx.buildKey("a"));
		Assert.assertNotNull(rows);
		Assert.assertEquals(2, rows.size());

		rows = idx.getRows(idx.buildKey("b"));
		Assert.assertNotNull(rows);
		Assert.assertEquals(1, rows.size());

		rows = idx.getRows(idx.buildKey("c"));
		Assert.assertNull(rows);

	}
}
