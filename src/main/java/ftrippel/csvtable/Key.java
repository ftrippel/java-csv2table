package ftrippel.csvtable;

/**
 * 
 * @author https://github.com/ftrippel
 * 
 */
public class Key extends Data {

	int hashCode = 0;

	public Key add(Object key) {
		this.data.add(key);
		if (key != null) {
			this.hashCode += key.hashCode();
		}
		return this;
	}

	@Override
	public int hashCode() {
		return this.hashCode;
	}

	@Override
	public boolean equals(Object _other) {
		if (_other == null)
			return false;
		if (!(_other instanceof Key))
			return false;
		Key other = (Key) _other;
		if (other.data.size() != this.data.size())
			return false;
		for (int i = 0; i < this.data.size(); ++i) {
			if (this.data.get(i) == null && other.data.get(i) != null)
				return false;
			if (this.data.get(i) != null && other.data.get(i) == null)
				return false;
			if (this.data.get(i) == null && other.data.get(i) == null)
				continue;
			if (!this.data.get(i).equals(other.data.get(i)))
				return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Key " + super.toString();
	}
}
