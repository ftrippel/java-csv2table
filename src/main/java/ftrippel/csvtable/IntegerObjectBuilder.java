package ftrippel.csvtable;

import org.apache.commons.lang.StringUtils;

public class IntegerObjectBuilder implements ObjectBuilder {

	public Integer build(String value) {
		value = StringUtils.trimToNull(StringUtils.removeStart(StringUtils.removeEnd(value, "\""), "\""));
		if (value == null)
			return null;
		return new Integer(value);
	}

}
