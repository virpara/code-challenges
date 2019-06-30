package com.misc;

import java.util.Arrays;

public class SimpleHashTable {
	
	static class Pair {
		Object key;
		Object value;
		Pair next;

		Pair(Object key, Object value, Pair next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}

		public String toString() {
			return key + "=" + value;
		}

	}

	Pair[] table = new Pair[10];

	public Object put(Object key, Object val) {
		int hash = key.hashCode();
		int idx = (hash & 0x7FFFFFFF) % table.length;

		Pair pair = table[idx];
		Object old = null;

		// bucket does't exist
		if (pair == null) {
			table[idx] = new Pair(key, val, null);
			return null;
		}

		for (; pair != null; pair = pair.next) {
			if (pair.key.equals(key)) {
				old = pair.value;
				pair.value = val;
				return old;
			}

			if (pair.next == null) {
				pair.next = new Pair(key, val, null);
				return old;
			}
		}

		// shouldn't reach here;
		return old;
	}

	public Object remove(Object key) {
		int hash = key.hashCode();
		int idx = (hash & 0x7FFFFFFF) % table.length;

		Pair pair = table[idx];
		Pair prevPair = null;
		Object old = null;
		for (; pair != null; pair = pair.next) {
			if (pair.key.equals(key)) {
				old = pair.value;

				if (prevPair != null) {
					prevPair.next = pair.next;
				} else {
					table[idx] = pair.next;
				}
			}

			prevPair = pair;
		}

		return old;
	}

	public String toString() {
		return Arrays.asList(table).toString();
	}

	public static void main(String[] args) {

		SimpleHashTable t = new SimpleHashTable();
		t.put("abc", "123");
		t.put("dba", "456");
		t.put("xyz", "789");
		t.put("abc", "12334");
		t.put("dbaas", "456");
		t.put("xyzsdf", "789");
		System.out.println(t);
	}
}