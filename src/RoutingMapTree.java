public class RoutingMapTree 
{
	public Exchange curr;
	public Exchange root;
	
	RoutingMapTree() //: constructor method. This should create a RoutingMapTree with one Exchange node, the root node which has an identifier of 0. Create other constructors that you deem necessary.
	{
		root.identity=0;
		curr=null;
	}
	public Boolean containsNode(int a)
	{
		if(root.identity==a)
		{
			return true;
		}
		else
		{
			if(root.numChildren()==0)
			{
				return false;
			}
			else
			{
				for(int i=1;i<=root.numChildren();i++)
				{
					if(root.subtree(i).containsNode(a))
					{
						return true;
					}
				}
				return false;
			}
				
		}
			
		
	}
	
	public Exchange returnNode(int a)
	{
		if(root.identity==a)
		{
			return root;
		}
		else
		{
			for(int i=1;i<=root.numChildren();i++)
			{	
				if(root.child(i).identity==a)
				{
					return root.child(i);
				}
			}
			for(int i=1;i<=root.numChildren();i++)
			{
				
				if(root.subtree(i).containsNode(a))
				{
					return root.subtree(i).returnNode(a);
				}
			}
		}	
	}
	
	
	
	public void addExchange(int a,int b)
	{
		Exchange add=new Exchange(b);//created new Exchange
		add.par=returnNode(a);
		returnNode(a).Children.Insert(add);
	}
	public void switchOn(int a,int b)// : This method only works on mobile phones that are currently switched off. It switches the phone a on and registers it with base station b. The entire routing map tree will be updated accordingly.
	{
		MobilePhone add=new MobilePhone(a);
		returnNode(b).Resident.Set.Insert(add);
	}
	
	public void switchOff(int a)// : This method only works on mobile phones that are currently switched on. It switches the phone a off. The entire routing map tree has to be updated accordingly.
	{
		//find mobilephone with identifier a and deregister it
		//traverse through the tree and find whose resident set has a and then
		(/*Exchange Object which has that mobilephone with identifier a */).Resident.Set.Delete(/*mobilephone object with identifier a*/)
	}
	
	public int queryNthchild(int a, int b)
	{
		System.out.println("queryNthChild "+a+" "+b+":"+" "+returnNode(a).child(b).identity);
		return 0;
	}
	public int queryMobileSet(int a)
	{
		Exchange imp=returnNode(a);
		imp.Resident.Set.ll.curr=imp.Resident.Set.ll.head;
		if(imp.Resident.Set.ll.N==0)
		{
			throw new RuntimeException("This Exchange is Empty...!!!");
		}
		System.out.print("queryMobilePhoneSet "+a+":");
		for( ;imp.Resident.Set.ll.curr.next!=null;imp.Resident.Set.ll.curr=imp.Resident.Set.ll.curr.next)
		{
			System.out.print(imp.Resident.Set.ll.curr.element.identity+",");
		}
		System.out.print(imp.Resident.Set.ll.curr.element.identity);
		System.out.println(" ");
		return 0;
	}
	
	
	
	
	
	
	
	public void performAction(String actionMessage)// : This the main stub method that you have to implement. It takes an action as a string. The list of actions, and their format will be described next.
	{
		String[] tokens = actionMessage.split(" ");
		String a1;
		a1=tokens[0];
		if(a1.equals("addExchange"))
		{
			addExchange(Integer.parseInt (tokens[1]) ,Integer.parseInt(tokens[2]) );
		}
		else if(a1.equals("queryNthChild"))
		{
			System.out.println(queryNthchild(Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2])));
		}
		else if(a1.equals("switchOnMobile"))
		{
			switchOn( Integer.parseInt (tokens[1]) ,Integer.parseInt(tokens[2]) );
		}
		else if(a1.equals("switchOffMobile"))
		{
			switchOff(Integer.parseInt (tokens[1]) );
		}
		else if(a1.equals("queryMobilePhoneSet"))
		{
			System.out.println(queryMobileSet( Integer.parseInt(tokens[1]) ) );
		}
		
	}
 
}
