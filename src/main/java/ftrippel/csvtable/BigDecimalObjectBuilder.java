package ftrippel.csvtable;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

public class BigDecimalObjectBuilder implements ObjectBuilder {

	public BigDecimal build(String value) {
		value = StringUtils.trimToNull(StringUtils.removeStart(StringUtils.removeEnd(value, "\""), "\""));
		if (value == null)
			return null;
		return new BigDecimal(value.replace(",", "."));
	}

}
