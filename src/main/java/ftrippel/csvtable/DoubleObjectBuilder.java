package ftrippel.csvtable;

import org.apache.commons.lang.StringUtils;

public class DoubleObjectBuilder implements ObjectBuilder {

	public Double build(String value) {
		value = StringUtils.trimToNull(StringUtils.removeStart(StringUtils.removeEnd(value, "\""), "\""));
		if (value == null)
			return null;
		return new Double(value);
	}

}
