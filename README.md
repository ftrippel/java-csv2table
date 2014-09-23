csv2table
=========

A simple Java framework to bind csv files as tables with indexing functionality

# Example Usage

```java
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
```
