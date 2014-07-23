package ftrippel.csvtable;

import org.apache.commons.lang.StringUtils;

public class StringObjectBuilder implements ObjectBuilder {

	public Object build(String value) {
		return StringUtils.trimToNull(StringUtils.removeStart(StringUtils.removeEnd(value, "\""), "\""));
	}

}
