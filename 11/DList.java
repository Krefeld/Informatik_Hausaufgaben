
public class DList {
	public class Knoten {
		Object wert;
		Knoten vorgaenger, next;

		public Knoten(Object wert, Knoten vorgaenger, Knoten next){
			this.wert = wert;
			this.vorgaenger = vorgaenger;
			this.next = next;
		}
	}

	Knoten act;
	Knoten first;
	Knoten last;
	public DList() {
		act = null;
		last = null;
		first = null;
	}

	//check
	private boolean isEmpty() {
		return (last == null);
	}

	//check
	private boolean hasAccess() {
		return (act != null);
	}

	//check
	public void next() {
		if(act == null)
			toFirst();
		if (!isEmpty() && hasAccess() && act != last) {
			act = act.next;
		} else {
			act = null;
		}
	}

	//check
	public void toFirst() {
		if (!isEmpty())
			act = first;
	}

	//check
	public void toLast() {
		if (!isEmpty())
			act = last;
	}

	//check
	public Object getContent() {
		if (hasAccess())
			return act.wert;
		else
			return null;
	}

	//check
	public void setContent(Object x) {
		if ((hasAccess()) && (x != null))
			act.wert = x;
	}

	public void append(Object x){
		if (x != null)
		{
			Knoten neu = new Knoten(x,last,null);

			if (isEmpty())
			{
				first = last = neu;
			}
			else
			{
				last.next = neu;
				last = neu;
			}
		}
	}

	public void insert(Object x){
		if (isEmpty())
		{
			first = new Knoten(x,null,null);
			last = first;
			act = null;
		}

		else if (hasAccess()) 
		{
			if (act == first)
			{
				Knoten neu = new Knoten(x,null,first);
				first.vorgaenger = neu;
				first = neu;
			}
			else
			{
				Knoten help = act.vorgaenger;
				help.next = new Knoten(x,help,act);
				act.vorgaenger = help.next;
			}
		}
	}

	public void concat(DList pList) {
		if(pList == null || pList.isEmpty()){
			return;
		}

		last.next = pList.first; 
		last = pList.last;
		pList.last = null;
	}

	public void remove(){
		// Fall 0: Liste ist leer oder es gibt kein aktuelles Element
		if ( (isEmpty()) || (!hasAccess())) return;

		// Fall 2: Liste besteht aus nur einem Element
		if (first == last)
		{
			first = last = act = null; 
			return;
		}

		// Fall 3a: es soll vorne gelöscht werden
		if (act == first)
		{
			act = act.next;
			first = act;
			first.vorgaenger = null;
			return;
		}

		// Fall 3b: es soll hinten gelöscht werden
		if (act == last)
		{
			act = act.vorgaenger;
			last = act;
			last.next = null;
			act = null;
			return;
		}

		// Fall 4: es soll in der Mitte gelöscht werden
		act.vorgaenger.next = act.next;
		act.next.vorgaenger = act.vorgaenger;
		act = act.next;
	}

	public int size() {
		int counter = 0;
		Knoten temp;
		for (temp = first; temp != last.next; temp = temp.next) {
			++counter;
		}
		return counter;
	}
	
	public void show() {
		Knoten temp;
		for(temp = first; temp != null; temp = temp.next) {
			System.out.println(temp.wert);
		}
	}
}

