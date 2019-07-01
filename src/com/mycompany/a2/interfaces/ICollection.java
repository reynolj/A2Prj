package com.mycompany.a2.interfaces;

public interface ICollection {
	public void add(Object newObject);
	public IIterator getIterator();
	void remove(Object toRemove);
}
