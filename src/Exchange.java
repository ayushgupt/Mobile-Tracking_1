public class Exchange //that will form the nodes of the routing map structure
{
	public int identity;
	public Exchange next;
	public Exchange par;
	public ExchangeList Children;
	public MobilePhoneSet Resident;
	
	Exchange(int number) //constructor to create an exchange Unique identifier for an exchange is an integer
	{
		identity=number;
		next=null;
		par=null;
	}
	
	public Exchange parent()
	{
		return par;
	}
	public int numChildren()// (for number of children)
	{
		return Children.N;
	}
	public Exchange child(int i) //(returns the ith child)
	{
		Children.curr=Children.head;
		for(int j=0;j<i-1;j++)
		{
			Children.curr=Children.curr.next;
		}
		return Children.curr;
	}
	public Boolean isRoot()
	{
		if(identity==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public RoutingMapTree subtree(int i) // (returns the ith subtree)
	{
		RoutingMapTree sub=new RoutingMapTree();
		sub.root=child(i);
		return sub;
	}
	public MobilePhoneSet residentSet() //This returns the resident set of mobile phones of the exchange.
	{
		return Resident;
	}
}
