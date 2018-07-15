package com.YP;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Optional;

public class MyHashMap<K, V> {
	private final static int TABLE_SIZE = 128;
	private Bucket<K, V>[] table;

	public MyHashMap() {
		table = (Bucket<K, V>[])new Bucket[TABLE_SIZE];
	}

	private int hashCode(K key) {
		int result = 1;
		result = result * 31 + key.hashCode();
		return result;
	}

	public Entry<K, V> get(K key) {
		int hashCode = hashCode(key);
		if (table[hashCode] != null) {
			Optional<Entry<K, V>> entry = table[hashCode].getList().stream().filter(e -> e.getKey().equals(key))
					.findFirst();
			return entry.orElse(null);
		} else {
			return null;
		}                  
	}

	public void put(K key, V value) {
		Entry<K, V> newEntry = new Entry<K, V>(key, value);
		int hashCode = hashCode(key);
		if (table[hashCode] != null) {
			Entry<K, V> entry = table[hashCode].getList().stream().filter(e -> e.getKey().equals(key)).findFirst().orElse(null);
			if(entry != null)
				entry.setVal(value);
			else
				table[hashCode].getList().add(newEntry);
		} else {
			LinkedList<Entry<K, V>> list = new LinkedList<Entry<K, V>>();
			list.add(newEntry);
			table[hashCode] = new Bucket(hashCode, list);
		}
	}

	public static void main(String[] args) {
		MyHashMap<String, String> map = new MyHashMap<>();
		map.put("1", "Brian");
		map.put("1", "zhuwei");
		
		Entry<String, String> entry = new Entry<String, String>("1", "haha");
		
		LinkedList<Entry<String, String>> list = new LinkedList();
		list.add(entry);
		list.add(entry);
		System.out.println(list.size());
		
		HashMap<Entry, String> hashMap = new HashMap<Entry, String>();
		hashMap.put(entry, "1111");
		hashMap.put(entry, "2222");
		System.out.println(hashMap.size());

		System.out.println(map.get("1").getKey() + "   " + map.get("1").getVal());
	}
}

class Bucket<K, V> {

	private int index;
	private LinkedList<Entry<K, V>> list;

	public Bucket(int index, LinkedList<Entry<K, V>> list) {
		this.index = index;
		this.list = list;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public LinkedList<Entry<K, V>> getList() {
		return list;
	}

	public void setList(LinkedList<Entry<K, V>> list) {
		this.list = list;
	}
}

class Entry<K, V> {
	private K key;
	private V val;

	public Entry(K key, V val) {
		this.key = key;
		this.val = val;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getVal() {
		return val;
	}

	public void setVal(V val) {
		this.val = val;
	}

}