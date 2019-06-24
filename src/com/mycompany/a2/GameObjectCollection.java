package com.mycompany.a2;

import java.util.Collection;
import java.util.Vector;

public class GameObjectCollection implements ICollection {
	private Vector<GameObject> theCollection;
	
	public GameObjectCollection() {
		this.theCollection = new Vector<GameObject>();
	}
	
	@Override
	public void add(Object newObject) {
		this.theCollection.addElement((GameObject) newObject);	
	}
	
	@Override
	public void remove(Object toRemove) {
		theCollection.remove((GameObject) toRemove);
	}
	
	@Override
	public IIterator getIterator() {
		return new GameObjectVectorIterator( );
	}
	
	public boolean isEmpty() {
		return theCollection.isEmpty();
	}
	
	public void removeAll(GameObjectCollection removeItems) {
		theCollection.removeAll((Collection<?>) removeItems);
	}
	
	//------------------------------------------------------------------//
	private class GameObjectVectorIterator implements IIterator {
		private int currElementIndex;
		
		public GameObjectVectorIterator() {
			this.currElementIndex = -1;
		}
		
		@Override
		public boolean hasNext() {
			if (theCollection.size( ) <= 0) 
				return false;
			if (currElementIndex == theCollection.size()-1 )
				return false;
			
			return true;
		}

		@Override
		public Object next() {
			++currElementIndex; 
			return theCollection.elementAt(currElementIndex);
		}
	}
}