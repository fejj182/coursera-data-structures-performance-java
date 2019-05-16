package textgen;

import org.reactfx.util.LL;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	private int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null, head);
		size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		new LLNode<E>(element, tail.prev, tail);
		size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		if (size == 0 || index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException();
		}

		LLNode<E> current = head;

		for (int i=0; i < index + 1; i++) {
			current = current.next;
		}
		return current.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		LLNode<E> current = head;

		for (int i=0; i < index + 1; i++) {
			current = (i == 0) ? current : current.next;
		}
		new LLNode<E>(element, current, current.next);
		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index)
	{
		if (size == 0 || index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException();
		}

		LLNode<E> current = head;

		for (int i=0; i < index + 1; i++) {
			current = current.next;
		}

		current.prev.next = current.next;
		current.next.prev = current.prev;
		size--;

		return current.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element)
	{
		if (size == 0 || index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException();
		}

		LLNode<E> current = head;

		for (int i=0; i < index + 1; i++) {
			current = current.next;
		}

		E oldValue = current.data;
		current.data = element;

		return oldValue;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

	public LLNode(E e, LLNode<E> prev)
	{
		this(e);
		prev.next = this;
		this.prev = prev;
	}

	public LLNode(E e, LLNode<E> prev, LLNode<E> next)
	{
		this(e, prev);
		this.next = next;
		next.prev = this;
	}

}
