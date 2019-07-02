package com.mycompany.a2.interfaces;

public interface ICollection {
	public void add(Object newObject);
	public IIterator getIterator();
	public void remove(Object toRemove);
}
