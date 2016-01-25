public class Node 
{
	public Object element;
	public Node next;
	public Node()
	{
		this(null,null);
	}
	public Node(Object e, Node n)
	{
		element =e;
		next  = n;
	}
	public Object getElement()
	{
		return element;
	}
	public Node getNext()
	{
		return next;
	}
	public void  setElement(Object newElem)
	{
		element=newElem;
	}
	public void setNext(Node newNext)
	{
		next=newNext;
	}
}
