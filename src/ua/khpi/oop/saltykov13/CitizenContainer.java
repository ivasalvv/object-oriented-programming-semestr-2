package ua.khpi.oop.saltykov13;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;

public class CitizenContainer implements Iterable<Citizen>, Serializable {
	private static final long serialVersionUID = 1L;
	private Citizen[] array = new Citizen[0];

	public void add(Citizen element) {
		array = Arrays.copyOf(array, array.length + 1);
		array[array.length - 1] = element;
	}

	public int size() {
		return array.length;
	}

	public void clear() {
		array = new Citizen[0];
	}

	public Citizen get(int index) {
		return array[index];
	}

	public Citizen set(int index, Citizen element) {
		Citizen old = array[index];
		array[index] = element;
		return old;
	}

	public Citizen[] toArray() {
		return array;
	}

	public Citizen remove(int index) {
		if (index < 0 || index >= array.length) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		Citizen[] newArray = new Citizen[array.length - 1];
		System.arraycopy(array, 0, newArray, 0, index);
		System.arraycopy(array, index + 1, newArray, index, newArray.length - index);
		Citizen removed = array[index];
		array = newArray;
		return removed;
	}

	public String toString() {
		String result = "";
		for (int i = 0; i < array.length; i++) {
			result = result.concat(this.toArray()[i].toString());
			result = result.concat("\n");
		}
		return result;
	}

	@Override
	public Iterator<Citizen> iterator() {
		return new CitizenArrayIterator();
	}

	private class CitizenArrayIterator implements Iterator<Citizen> {
		int cursor = 0;
		int lastRet = -1;

		@Override
		public boolean hasNext() {
			return cursor < array.length;
		}

		@Override
		public Citizen next() {
			return array[lastRet = cursor++];
		}

		public void remove() {
			CitizenContainer.this.remove(lastRet);
			cursor--;
			lastRet = -1;
		}
	}
}
